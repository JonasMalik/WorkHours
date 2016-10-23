package com.jonasmalik94.workhours.Controller;

import android.app.TimePickerDialog;
import android.widget.TimePicker;

import com.jonasmalik94.workhours.Elements.NewDayElements;

/**
 * Created by jonas on 2016-10-23.
 */

public class TimePickerListener implements TimePickerDialog.OnTimeSetListener {
    NewDayElements e = NewDayElements.getInstance();
    int id;

    public TimePickerListener(int id) {
        this.id = id;
    }


    @Override
    public void onTimeSet(TimePicker timePicker, int hours, int minutes) {
        if (e.getStart().getId() == id){
            e.getStart().setText(hours+":"+minutes);
        }
        else {
            e.getEnd().setText(hours+":"+minutes);
        }
    }
}
