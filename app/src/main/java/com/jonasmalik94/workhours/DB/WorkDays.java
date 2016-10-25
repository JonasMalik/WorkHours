package com.jonasmalik94.workhours.DB;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by jonas on 2016-10-24.
 */

public class WorkDays {

    @DatabaseField(generatedId = true)
    int id;

    @DatabaseField
    int year;

    @DatabaseField
    int month;

    @DatabaseField
    int day_of_month;

    @DatabaseField
    int worked_hours;

    @DatabaseField
    int worked_minutes;

    @DatabaseField
    int lunch_hours;

    @DatabaseField
    int lunch_minutes;

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
}
