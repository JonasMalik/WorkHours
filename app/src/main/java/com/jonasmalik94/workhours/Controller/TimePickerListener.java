package com.jonasmalik94.workhours.Controller;

import android.app.TimePickerDialog;
import android.widget.TimePicker;

import com.jonasmalik94.workhours.DB.FieldHolder;
import com.jonasmalik94.workhours.Elements.NewDayElements;

/**
 * Created by jonas on 2016-10-23.
 */

public class TimePickerListener implements TimePickerDialog.OnTimeSetListener {
    NewDayElements e = NewDayElements.getInstance();
    FieldHolder f = FieldHolder.getInstance();
    int id;

    public TimePickerListener(int id) {
        this.id = id;
    }


    @Override
    public void onTimeSet(TimePicker timePicker, int hours, int minutes) {
        String sHours = Integer.toString(hours);
        String sMinutes = Integer.toString(minutes);

        if (sHours.length() == 1) sHours = "0"+sHours;
        if (sMinutes.length() == 1) sMinutes = "0"+sMinutes;

        if (e.getStart().getId() == id){
            e.getStart().setText(sHours+":"+sMinutes);
            f.setStart_time(sHours+":"+sMinutes);
        }
        else {
            e.getEnd().setText(sHours+":"+sMinutes);
            f.setEnd_time(sHours+":"+sMinutes);
        }
    }
}
