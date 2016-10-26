package com.jonasmalik94.workhours.Controller;

import android.app.DatePickerDialog;
import android.widget.DatePicker;

import com.jonasmalik94.workhours.DB.FieldHolder;
import com.jonasmalik94.workhours.Elements.NewDayElements;

/**
 * Created by jonas on 2016-10-23.
 */

public class DatePickerListener implements DatePickerDialog.OnDateSetListener {

    NewDayElements e = NewDayElements.getInstance();
    FieldHolder f = FieldHolder.getInstance();

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayInMonth) {
        month = month+1;
        e.getDate().setText(year+"-"+month+"-"+dayInMonth);
        f.setYear(year);
        f.setMonth(month);
        f.setDay_of_month(dayInMonth);
    }
}
