package com.jonasmalik94.workhours.Controller;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;


import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;
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
    int monthNumber;
    int year;
    CalendarEngine engine = new CalendarEngine();
    CalendarElements e = CalendarElements.getInstance();

    public CalendarOnItemClickListener(Context context) {
        this.context = context;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        date = position +1;
        engine.showDateInfo(context, date);
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
