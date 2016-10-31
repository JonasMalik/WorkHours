package com.jonasmalik94.workhours.DB;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by jonas on 2016-10-24.
 */

public class WorkDays {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private int year;

    @DatabaseField
    private int month;

    @DatabaseField
    private int day_of_month;

    @DatabaseField
    private int worked_hours;

    @DatabaseField
    private int worked_minutes;

    @DatabaseField
    private int lunch_hours;

    @DatabaseField
    private int lunch_minutes;

    public WorkDays(){

    }

    public WorkDays(int year, int month, int day_of_month, int worked_hours, int worked_minutes, int lunch_hours, int lunch_minutes) {
        this.year = year;
        this.month = month;
        this.day_of_month = day_of_month;
        this.worked_hours = worked_hours;
        this.worked_minutes = worked_minutes;
        this.lunch_hours = lunch_hours;
        this.lunch_minutes = lunch_minutes;
    }

    @Override
    public String toString() {
        return "WorkDays{" +
                "id=" + id +
                ", year=" + year +
                ", month=" + month +
                ", day_of_month=" + day_of_month +
                ", worked_hours=" + worked_hours +
                ", worked_minutes=" + worked_minutes +
                ", lunch_hours=" + lunch_hours +
                ", lunch_minutes=" + lunch_minutes +
                '}';
    }

    public int getLunch_minutes() {
        return lunch_minutes;
    }
    public int getLunch_hours() {
        return lunch_hours;
    }
    public int getId() {
        return id;
    }
    public int getYear() {
        return year;
    }
    public int getMonth() {
        return month;
    }
    public int getDay_of_month() {
        return day_of_month;
    }
    public int getWorked_hours() {
        return worked_hours;
    }
    public int getWorked_minutes() {
        return worked_minutes;
    }
}
