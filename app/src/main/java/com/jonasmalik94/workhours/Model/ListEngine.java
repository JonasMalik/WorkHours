package com.jonasmalik94.workhours.Model;

import android.content.Context;

import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.Where;
import com.jonasmalik94.workhours.DB.DatabaseHelper;
import com.jonasmalik94.workhours.DB.WorkDays;
import com.jonasmalik94.workhours.Elements.ListElements;
import com.jonasmalik94.workhours.Controller.MainListAdapter;
import com.jonasmalik94.workhours.Elements.MainListRow;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 2016-10-16.
 */

public class ListEngine {
    ListElements e = ListElements.getInstance();

    //In progress
    public void refreshListView(Context context){

        MainListAdapter adapter;
        ArrayList<MainListRow> arrayOfRows = new ArrayList<>();

        RuntimeExceptionDao<WorkDays,Integer> workDaysDao = null;
        try {
            DatabaseHelper helper = new DatabaseHelper(context);
            workDaysDao = helper.getWorkDaysRuntimeDao();
            List<WorkDays> workDays = workDaysDao.queryForAll();

            for (int i = 0; i<workDays.size() ; i++){
                int id = workDays.get(i).getId();
                int year = workDays.get(i).getYear();
                int month = workDays.get(i).getMonth();
                int dayOfMonth = workDays.get(i).getDay_of_month();
                int workedHours = workDays.get(i).getWorked_hours();
                int workedMinutes = workDays.get(i).getWorked_minutes();
                int lunchHours = workDays.get(i).getLunch_hours();
                int lunchMinutes = workDays.get(i).getLunch_minutes();

                MainListRow newRow = new MainListRow(id, year, month, dayOfMonth, workedHours, workedMinutes, lunchHours,lunchMinutes);
                arrayOfRows.add(newRow);
            }

            adapter = new MainListAdapter(context, arrayOfRows);
            e.getListView().setAdapter(adapter);


            helper.close();

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public void search(Context context, String search){
        e.getListView().setAdapter(null);
        MainListAdapter adapter;
        ArrayList<MainListRow> arrayOfRows = new ArrayList<>();



        RuntimeExceptionDao<WorkDays,Integer> workDaysDao = null;
        try {
            DatabaseHelper helper = new DatabaseHelper(context);
            workDaysDao = helper.getWorkDaysRuntimeDao();
            Where where = workDaysDao.queryBuilder().where();
            List<WorkDays> workDays = where.like("monthName","%"+search+"%").query();
            for (int i = 0; i<workDays.size(); i++) {
                MainListRow newRow = new MainListRow(workDays.get(i).getId(),
                        workDays.get(i).getYear(),
                        workDays.get(i).getMonth(),
                        workDays.get(i).getDay_of_month(),
                        workDays.get(i).getWorked_hours(),
                        workDays.get(i).getWorked_minutes(),
                        workDays.get(i).getLunch_hours(),
                        workDays.get(i).getLunch_minutes());

                arrayOfRows.add(newRow);
            }

            adapter = new MainListAdapter(context, arrayOfRows);
            e.getListView().setAdapter(adapter);
            helper.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}
