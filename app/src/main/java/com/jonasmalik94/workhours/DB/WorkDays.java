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
    String month;

    @DatabaseField
    int day_of_month;

    @DatabaseField
    int hours;

    @DatabaseField
    int lunch;

    public WorkDays(){

    }

    public WorkDays(int year, String month, int day_of_month, int hours, int lunch) {
        this.year = year;
        this.month = month;
        this.day_of_month = day_of_month;
        this.hours = hours;
        this.lunch = lunch;
    }

    @Override
    public String toString() {
        return "WorkDays{" +
                "id=" + id +
                ", year=" + year +
                ", month='" + month + '\'' +
                ", day_of_month=" + day_of_month +
                ", hours=" + hours +
                ", lunch=" + lunch +
                '}';
    }
}
