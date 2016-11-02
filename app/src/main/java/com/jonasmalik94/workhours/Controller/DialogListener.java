package com.jonasmalik94.workhours.Controller;

import android.content.Context;
import android.content.DialogInterface;
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
 * Created by jonas on 2016-10-31.
 */

public class DialogListener implements DialogInterface.OnClickListener {

    Context context;
    int date;
    int month;
    int year;
    CalendarElements e = CalendarElements.getInstance();
    CalendarEngine engine = new CalendarEngine();

    public DialogListener(Context context,int date, int month, int year) {
        this.context = context;
        this.date = date;
        this.month = month;
        this.year = year;
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        engine.deleteCellInfo(context,date,month,year);
    }
}
