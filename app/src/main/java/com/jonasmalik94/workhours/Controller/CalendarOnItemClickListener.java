package com.jonasmalik94.workhours.Controller;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.Where;
import com.jonasmalik94.workhours.DB.DatabaseHelper;
import com.jonasmalik94.workhours.DB.WorkDays;
import com.jonasmalik94.workhours.Elements.CalendarElements;
import com.jonasmalik94.workhours.Model.CalendarEngine;
import com.jonasmalik94.workhours.R;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by jonas on 2016-10-27.
 */

public class CalendarOnItemClickListener implements AdapterView.OnItemLongClickListener, AdapterView.OnItemClickListener {
    Context context;
    int date;
    String month;
    int monthNumber;
    int year;
    CalendarEngine engine = new CalendarEngine();
    CalendarElements e = CalendarElements.getInstance();

    public CalendarOnItemClickListener(Context context) {
        this.context = context;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Getting the clicked list item by position
        // final View view1 = calendar.getAdapter().getView(position, null, calendar);
        //TextView myID = (TextView) view1.findViewById(R.id.myID);
        date = position +1;
        month = e.getMonth().getText().toString().substring(0,e.getMonth().length()-5);
        monthNumber = engine.getMonthNumber(e.getMonth().getText().toString().substring(0,e.getMonth().length()-5));
        year = Integer.parseInt(e.getMonth().getText().toString().substring(e.getMonth().length()-4));
        e.getInfoHeader().setText(month+" "+date);






//============================================================================================================================
        RuntimeExceptionDao<WorkDays,Integer> workDaysDao = null;
        try {
            DatabaseHelper helper = new DatabaseHelper(context);
            workDaysDao = helper.getWorkDaysRuntimeDao();
            Where where = workDaysDao.queryBuilder().where();
            List<WorkDays> workDays = where.and(where.eq("month", monthNumber), where.eq("year", year)).query();
            int workedHours = workDays.get(0).getWorked_hours();
            int workedMinutes = workDays.get(0).getWorked_minutes();
            e.getInfoHoursWorked().setText(workedHours+":"+workedMinutes);
            workDays.clear();

        } catch (SQLException e1) {
            e1.printStackTrace();
        }

//================================================================================================================================


        Toast.makeText(context,Integer.toString(position),Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

        date = position +1;
        monthNumber = engine.getMonthNumber(e.getMonth().getText().toString().substring(0,e.getMonth().length()-5));
        year = Integer.parseInt(e.getMonth().getText().toString().substring(e.getMonth().length()-4));

        DialogListener dialogListener = new DialogListener(context,date,monthNumber,year);

        AlertDialog.Builder dialogAlert = new AlertDialog.Builder(context);
        dialogAlert.setTitle(R.string.delete_title);
        dialogAlert.setIcon(android.R.drawable.ic_menu_delete);
        dialogAlert.setMessage(R.string.delete_message);
        dialogAlert.setPositiveButton(R.string.delete_positive_button, dialogListener);
        dialogAlert.setNegativeButton(R.string.delete_negative_button, null);

        dialogAlert.show();
        return true;
    }
}
