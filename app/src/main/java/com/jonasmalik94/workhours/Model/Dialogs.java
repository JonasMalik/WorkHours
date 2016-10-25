package com.jonasmalik94.workhours.Model;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.jonasmalik94.workhours.Controller.DatePickerListener;
import com.jonasmalik94.workhours.Controller.TimePickerListener;
import com.jonasmalik94.workhours.DB.DatabaseHelper;
import com.jonasmalik94.workhours.DB.WorkDays;

import java.sql.SQLException;
import java.util.List;


/**
 * Created by jonas on 2016-10-23.
 */

@RequiresApi(api = Build.VERSION_CODES.N)
public class Dialogs extends OrmLiteBaseActivity<DatabaseHelper>{

    Calendar c = Calendar.getInstance();
    DatePickerListener datePickerListener = new DatePickerListener();

    public void openDatePickerDialog(Context context) throws SQLException {
        new DatePickerDialog(context,datePickerListener,c.get(c.YEAR),c.get(c.MONTH),c.get(c.DAY_OF_MONTH)).show();
    }

    public void openTimePickerDialog(Context context, int id){
        TimePickerListener timePickerListener = new TimePickerListener(id);
        new TimePickerDialog(context,timePickerListener,c.get(c.HOUR),c.get(c.MINUTE), true).show();
    }

}
