package com.jonasmalik94.workhours.Elements;

import android.widget.Button;
import android.widget.TextView;

import com.jonasmalik94.workhours.R;


/**
 * Created by jonas on 2016-10-15.
 */

public class ListElements {

    private static ListElements instance = null;
    private ListElements() {}

    public static synchronized ListElements getInstance() {
        if (instance == null) instance = new ListElements();
        return instance;
    }
    TextView id;
    TextView year;
    TextView month;
    TextView dayOfMonth;
    TextView workedHours;
    TextView workedMinutes;
    TextView lunchHours;
    TextView lunchMinutes;
    TextView header;

    public TextView getId() {
        return id;
    }

    public void setId(TextView id) {
        this.id = id;
    }

    public TextView getYear() {
        return year;
    }

    public void setYear(TextView year) {
        this.year = year;
    }

    public TextView getMonth() {
        return month;
    }

    public void setMonth(TextView month) {
        this.month = month;
    }

    public TextView getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(TextView dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public TextView getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(TextView workedHours) {
        this.workedHours = workedHours;
    }

    public TextView getWorkedMinutes() {
        return workedMinutes;
    }

    public void setWorkedMinutes(TextView workedMinutes) {
        this.workedMinutes = workedMinutes;
    }

    public TextView getLunchHours() {
        return lunchHours;
    }

    public void setLunchHours(TextView lunchHours) {
        this.lunchHours = lunchHours;
    }

    public TextView getLunchMinutes() {
        return lunchMinutes;
    }

    public void setLunchMinutes(TextView lunchMinutes) {
        this.lunchMinutes = lunchMinutes;
    }

    public TextView getHeader() {
        return header;
    }

    public void setHeader(TextView header) {
        this.header = header;
    }
}
