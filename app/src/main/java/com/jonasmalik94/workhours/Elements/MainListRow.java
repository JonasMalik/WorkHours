package com.jonasmalik94.workhours.Elements;

/**
 * Created by jonas on 2016-06-22.
 */
public class MainListRow {
    private int id;
    private int year;
    private int month;
    private int dayOfMonth;
    private int workedHours;
    private int workedMinutes;
    private int lunchHours;
    private int lunchMinutes;




    private String is_a_movie;

    public MainListRow(int id,
                       int year,
                       int month,
                       int dayOfMonth,
                       int workedHours,
                       int workedMinutes,
                       int lunchHours,
                       int lunchMinutes) {

        this.id = id;
        this.year = year;
        this.month = month;
        this.dayOfMonth = dayOfMonth;
        this.workedHours = workedHours;
        this.workedMinutes = workedMinutes;
        this.lunchHours = lunchHours;
        this.lunchMinutes = lunchMinutes;
    }

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

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public int getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(int workedHours) {
        this.workedHours = workedHours;
    }

    public int getWorkedMinutes() {
        return workedMinutes;
    }

    public void setWorkedMinutes(int workedMinutes) {
        this.workedMinutes = workedMinutes;
    }

    public int getLunchHours() {
        return lunchHours;
    }

    public void setLunchHours(int lunchHours) {
        this.lunchHours = lunchHours;
    }

    public int getLunchMinutes() {
        return lunchMinutes;
    }

    public void setLunchMinutes(int lunchMinutes) {
        this.lunchMinutes = lunchMinutes;
    }

    public String getIs_a_movie() {
        return is_a_movie;
    }

    public void setIs_a_movie(String is_a_movie) {
        this.is_a_movie = is_a_movie;
    }
}
