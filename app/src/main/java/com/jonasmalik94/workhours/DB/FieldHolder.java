package com.jonasmalik94.workhours.DB;

import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * Created by jonas on 2016-10-15.
 */

public class FieldHolder {

    private static FieldHolder instance = null;
    private FieldHolder() {}

    public static synchronized FieldHolder getInstance() {
        if (instance == null) instance = new FieldHolder();
        return instance;
    }

    private int id;
    private int year;
    private int month;
    private int day_of_month;
    private int worked_hours;
    private int worked_minutes;
    private String start_time;
    private String end_time;
    private int lunch_hours;
    private int lunch_minutes;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public int getDay_of_month() {
        return day_of_month;
    }
    public void setDay_of_month(int day_of_month) {
        this.day_of_month = day_of_month;
    }
    public int getWorked_hours() throws ParseException {
        long hours;
        String time1 = "07:30";
        String time2 = "16:30";

        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Date date1 = format.parse(time1);
        Date date2 = format.parse(time2);
        long difference = date2.getTime() - date1.getTime();
        difference = difference / 1000; // To seconds
        difference = difference / 60; // To minutes
        hours = (difference/60)%60;

        return (int) hours;
    }
    public void setWorked_hours(int worked_hours) {
        this.worked_hours = worked_hours;
    }
    public int getWorked_minutes() throws ParseException {
        long minutes;
        long hours;
        String time1 = "07:30";
        String time2 = "16:30";

        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Date date1 = format.parse(time1);
        Date date2 = format.parse(time2);
        long difference = date2.getTime() - date1.getTime();
        difference = difference / 1000; // To seconds
        difference = difference / 60; // To minutes

        hours = (difference/60)%60;
        minutes = difference-(hours*60);
        return (int) minutes;
    }
    public void setWorked_minutes(int worked_minutes) {
        this.worked_minutes = worked_minutes;
    }
    public int getLunch_hours() {
        return lunch_hours;
    }
    public void setLunch_hours(int lunch_hours) {
        this.lunch_hours = lunch_hours;
    }
    public int getLunch_minutes() {
        return lunch_minutes;
    }
    public void setLunch_minutes(int lunch_minutes) {
        this.lunch_minutes = lunch_minutes;
    }
    public String getStart_time() {
        return start_time;
    }
    public void setStart_time(String start_hours) {
        this.start_time = start_time;
    }
    public String getEnd_time() {
        return end_time;
    }
    public void setEnd_time(String end_hours) {
        this.end_time = end_time;
    }

}
