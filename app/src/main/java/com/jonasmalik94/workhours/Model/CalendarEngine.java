package com.jonasmalik94.workhours.Model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by jonas on 2016-10-16.
 */

public class CalendarEngine {

    public int getCountOfDays(int year, int month) {
        Calendar c = Calendar.getInstance();
        int numDays;

        month = month-1;
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);

        numDays = c.getActualMaximum(Calendar.DATE);

        return numDays;
    }

    public int getMonthNumber() {
        Calendar cal=Calendar.getInstance();
        SimpleDateFormat month_date = new SimpleDateFormat("M");
        int month_number = Integer.parseInt(month_date.format(cal.getTime()));

        return month_number;
    }

    public int getMonthNumber(String monthName) {
        int monthNumber = 0;
        String[] month = {"Januari", "Februari", "Mars", "April",
                "Maj", "Juni", "Juli", "Augusti", "September",
                "Oktober", "November", "December"};

        for (int i =0; i<month.length; i++){
            if (month[i].equals(monthName)){
                monthNumber = i+1;
            }
        }
        return monthNumber;
    }

    public String getMonthName(int monthNumber) {
        String month_name;
        String[] month = {"Januari", "Februari", "Mars", "April",
                          "Maj", "Juni", "Juli", "Augusti", "September",
                          "Oktober", "November", "December"};
        monthNumber = monthNumber-1;
        month_name = month[monthNumber];
        return month_name;
    }

    public int getYear() {
        Calendar cal=Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);

        return year;
    }

    public ArrayList<String> getItems(int year, int month){
        int counter = 0;
        ArrayList<String> items = new ArrayList<>();

        while (counter<getCountOfDays(year,month)){
            items.add(Integer.toString(counter+1));
            counter++;
        }

        return items;
    }

}
