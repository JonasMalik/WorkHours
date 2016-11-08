package com.jonasmalik94.workhours.Model;

import android.content.Context;
import android.widget.Button;
import android.widget.Toast;

import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.Where;
import com.jonasmalik94.workhours.Controller.CalendarAdapter;
import com.jonasmalik94.workhours.DB.DatabaseHelper;
import com.jonasmalik94.workhours.DB.WorkDays;
import com.jonasmalik94.workhours.Elements.CalendarElements;
import com.jonasmalik94.workhours.R;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by jonas on 2016-10-16.
 */

public class CalendarEngine {
    CalendarElements e = CalendarElements.getInstance();


    public int getCountOfDays(int year, int month) {
        Calendar c = Calendar.getInstance();
        int numDays;

        month = month - 1;
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);

        numDays = c.getActualMaximum(Calendar.DATE);

        return numDays;
    }

    public int getMonthNumber() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat month_date = new SimpleDateFormat("M");
        int month_number = Integer.parseInt(month_date.format(cal.getTime()));

        return month_number;
    }

    public int getMonthNumber(String monthName) {
        int monthNumber = 0;
        String[] month = {"Januari", "Februari", "Mars", "April",
                "Maj", "Juni", "Juli", "Augusti", "September",
                "Oktober", "November", "December"};

        for (int i = 0; i < month.length; i++) {
            if (month[i].equals(monthName)) {
                monthNumber = i + 1;
            }
        }
        return monthNumber;
    }

    public String getMonthName(int monthNumber) {
        String month_name;
        String[] month = {"Januari", "Februari", "Mars", "April",
                "Maj", "Juni", "Juli", "Augusti", "September",
                "Oktober", "November", "December"};
        monthNumber = monthNumber - 1;
        month_name = month[monthNumber];
        return month_name;
    }

    public int getYear() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);

        return year;
    }

    public ArrayList<String> getItems(int year, int month) {
        int counter = 0;
        ArrayList<String> items = new ArrayList<>();

        while (counter < getCountOfDays(year, month)) {
            items.add(Integer.toString(counter + 1));
            counter++;
        }

        return items;
    }

    public void refreshCalendarTotal(Context context, int monnthNumber, int year) {

        RuntimeExceptionDao<WorkDays, Integer> workDaysDao = null;
        try {
            DatabaseHelper helper = new DatabaseHelper(context);
            workDaysDao = helper.getWorkDaysRuntimeDao();
            Where where = workDaysDao.queryBuilder().where();
            List<WorkDays> workDays = where.and(where.eq("month", monnthNumber), where.eq("year", year)).query();
            if (workDays.size() > 0) {
                int workedHours = 0;
                int workedMinutes = 0;
                int minutesLeft;

                for (int i = 0; i < workDays.size(); i++) {
                    workedHours = workedHours + workDays.get(i).getWorked_hours();
                    workedMinutes = workedMinutes + workDays.get(i).getWorked_minutes();
                }

                minutesLeft = workedMinutes % 60; // Calculates rest (minutes) when all min is converted to hours
                workedMinutes = (workedMinutes - minutesLeft) / 60; // Calculates how many hours in all minutes
                workedHours = workedHours + workedMinutes; // Adds hours made from all minutes to existing hours

                e.getHoursTotal().setText(R.string.hours_total);
                e.getHoursTotal().append(" " + workedHours + "h " + minutesLeft + "m");
                e.getDaysTotal().setText(R.string.days_total);
                e.getDaysTotal().append(" " + workDays.size());
                workDays.clear();
                helper.close();
            } else {
                e.getHoursTotal().setText(R.string.hours_total);
                e.getHoursTotal().append(" 0");
                e.getDaysTotal().setText(R.string.days_total);
                e.getDaysTotal().append(" 0");
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }

    public void refreshCalendarItems(Context context, int monthNumber, int year) {
        e.getCalendar()
                .setAdapter(new CalendarAdapter(context, getItems(year, monthNumber), monthNumber, year));
    }

    public void printCell(Context context, Button cell, int date, int month, int year) {

        RuntimeExceptionDao<WorkDays, Integer> workDaysDao = null;
        try {
            DatabaseHelper helper = new DatabaseHelper(context);
            workDaysDao = helper.getWorkDaysRuntimeDao();
            Where where = workDaysDao.queryBuilder().where();
            List<WorkDays> workDays = where.and(where.eq("day_of_month", date), where.eq("month", month), where.eq("year", year)).query();

            if (workDays.size() > 0) {
                cell.setBackgroundColor(cell.getResources().getColor(R.color.light_red));
                workDays.clear();
            }
            helper.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }

    public ArrayList<Integer> prevMonth(Context context, int counter, int monthNumber, int year) {
        ArrayList<Integer> returnValues = new ArrayList<>();
        counter--;
        monthNumber = counter + getMonthNumber();

        if (monthNumber == 0) {
            monthNumber = monthNumber + 12;
            counter = counter + 12;
            year--;
        }

        e.getMonth().setText(getMonthName(monthNumber) + " " + year);
        refreshCalendarItems(context, monthNumber, year);
        refreshCalendarTotal(context, monthNumber, year);

        returnValues.add(counter);
        returnValues.add(monthNumber);
        returnValues.add(year);

        return returnValues;
    }

    public ArrayList<Integer> nextMonth(Context context, int counter, int monthNumber, int year) {
        ArrayList<Integer> returnValues = new ArrayList<>();
        counter++;
        monthNumber = counter + getMonthNumber();

        if (monthNumber == 13) {
            monthNumber = monthNumber - 12;
            counter = counter - 12;
            year++;
        }

        e.getMonth().setText(getMonthName(monthNumber) + " " + year);
        refreshCalendarItems(context, monthNumber, year);
        refreshCalendarTotal(context, monthNumber, year);

        returnValues.add(counter);
        returnValues.add(monthNumber);
        returnValues.add(year);

        return returnValues;
    }

    public void showDateInfo(Context context, int date) {

        String month = e.getMonth().getText().toString().substring(0, e.getMonth().length() - 5);
        int monthNumber = getMonthNumber(e.getMonth().getText().toString().substring(0, e.getMonth().length() - 5));
        int year = Integer.parseInt(e.getMonth().getText().toString().substring(e.getMonth().length() - 4));
        e.getInfoHeader().setText(month + " " + date);


        RuntimeExceptionDao<WorkDays, Integer> workDaysDao = null;
        try {
            DatabaseHelper helper = new DatabaseHelper(context);
            workDaysDao = helper.getWorkDaysRuntimeDao();
            Where where = workDaysDao.queryBuilder().where();
            List<WorkDays> workDays = where.and(where.eq("day_of_month", date), where.eq("month", monthNumber), where.eq("year", year)).query();
            if (workDays.size() > 0) {
                int workedHours = workDays.get(0).getWorked_hours();
                int workedMinutes = workDays.get(0).getWorked_minutes();
                String sWorkedHours = Integer.toString(workedHours);
                String sWorkedMinutes = Integer.toString(workedMinutes);

                if (sWorkedHours.length() == 1) {
                    sWorkedHours = "0" + sWorkedHours;
                }
                if (sWorkedMinutes.length() == 1) {
                    sWorkedMinutes = "0" + sWorkedMinutes;
                }

                e.getInfoHoursWorked().setText(sWorkedHours + ":" + sWorkedMinutes);
                workDays.clear();
                helper.close();

            } else {
                e.getInfoHoursWorked().setText("00:00");
                Toast.makeText(context, "Inget arbetspass för detta datum!", Toast.LENGTH_SHORT).show();
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public void deleteCellInfo(Context context, int date, int month, int year) {
        RuntimeExceptionDao<WorkDays, Integer> workDaysDao = null;
        try {
            DatabaseHelper helper = new DatabaseHelper(context);
            workDaysDao = helper.getWorkDaysRuntimeDao();
            Where where = workDaysDao.queryBuilder().where();

            List<WorkDays> workDays = where.and(where.eq("day_of_month", date),
                    where.eq("month", month),
                    where.eq("year", year))
                    .query();
            workDaysDao.delete(workDays);
            if (workDays.size() > 0) {
                refreshCalendarItems(context, month, year);
                Toast.makeText(context, R.string.toast_delete_success, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, R.string.toast_delete_nothing_to_delete, Toast.LENGTH_SHORT).show();
            }
            helper.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
            Toast.makeText(context, R.string.toast_delete_error, Toast.LENGTH_SHORT).show();
        }
    }

    public boolean checkIfPostExist(Context context, int date, int month, int year) {
        boolean isPostExisting = false;

        RuntimeExceptionDao<WorkDays, Integer> workDaysDao = null;
        try {
            DatabaseHelper helper = new DatabaseHelper(context);
            workDaysDao = helper.getWorkDaysRuntimeDao();
            Where where = workDaysDao.queryBuilder().where();
            List<WorkDays> workDays = where.and(where.eq("day_of_month", date), where.eq("month", month), where.eq("year", year)).query();

            if (workDays.size() > 0) {
                isPostExisting = true;
            } else {
                isPostExisting = false;
            }
            workDays.clear();
            helper.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return isPostExisting;
    }
}
