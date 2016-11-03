package com.jonasmalik94.workhours.Controller;

import android.app.DatePickerDialog;
import android.widget.DatePicker;

import com.jonasmalik94.workhours.DB.FieldHolder;
import com.jonasmalik94.workhours.Elements.ListElements;
import com.jonasmalik94.workhours.Elements.NewDayElements;

/**
 * Created by jonas on 2016-10-23.
 */

public class DatePickerListener implements DatePickerDialog.OnDateSetListener {

    NewDayElements e = NewDayElements.getInstance();
    ListElements listElements = ListElements.getInstance();
    FieldHolder f = FieldHolder.getInstance();
    private int id;

    public DatePickerListener(int id) {
        this.id = id;
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayInMonth) {
        month = month+1;
        if (id == e.getDate().getId()) {
            e.getDate().setText(year + "-" + month + "-" + dayInMonth);
        }else {
            listElements.getUpdateDate().setText(year + "-" + month + "-" + dayInMonth);
        }
        f.setYear(year);
        f.setMonth(month);
        f.setDay_of_month(dayInMonth);

    }
}
