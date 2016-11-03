package com.jonasmalik94.workhours.Model;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.jonasmalik94.workhours.Controller.DatePickerListener;
import com.jonasmalik94.workhours.Controller.TimePickerListener;


/**
 * Created by jonas on 2016-10-23.
 */

@RequiresApi(api = Build.VERSION_CODES.N)
public class Dialogs{

    Calendar c = Calendar.getInstance();

    public void openDatePickerDialog(Context context, int id) {
        DatePickerListener datePickerListener = new DatePickerListener(id);
        new DatePickerDialog(context,datePickerListener,c.get(c.YEAR),c.get(c.MONTH),c.get(c.DAY_OF_MONTH)).show();
    }

    public void openTimePickerDialog(Context context, int id){
        TimePickerListener timePickerListener = new TimePickerListener(id);
        new TimePickerDialog(context,timePickerListener,c.get(c.HOUR),c.get(c.MINUTE), true).show();
    }

}
