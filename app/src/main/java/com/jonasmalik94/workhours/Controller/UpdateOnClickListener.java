package com.jonasmalik94.workhours.Controller;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;

import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.jonasmalik94.workhours.DB.DatabaseHelper;
import com.jonasmalik94.workhours.DB.FieldHolder;
import com.jonasmalik94.workhours.DB.WorkDays;
import com.jonasmalik94.workhours.Elements.ListElements;
import com.jonasmalik94.workhours.Model.CalendarEngine;
import com.jonasmalik94.workhours.Model.Dialogs;
import com.jonasmalik94.workhours.Model.ListEngine;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;


/**
 * Created by jonas on 2016-10-11.
 */

public class UpdateOnClickListener extends Dialogs implements View.OnClickListener {

    ListEngine listEngine = new ListEngine();
    CalendarEngine engine = new CalendarEngine();
    ListElements e = ListElements.getInstance();
    FieldHolder f = FieldHolder.getInstance();

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View view) {

        if (view.getId() == e.getUpdateButton().getId()) {
            f.setConverted_worked_hours(Integer.parseInt(e.getUpdateWorkedH().getSelectedItem().toString().replaceAll("\\D+", "")));
            f.setConverted_worked_minutes(Integer.parseInt(e.getUpdateWorkedM().getSelectedItem().toString().replaceAll("\\D+", "")));
            f.setLunch_hours(Integer.parseInt(e.getUpdateLunchH().getSelectedItem().toString().replaceAll("\\D+", "")));
            f.setLunch_minutes(Integer.parseInt(e.getUpdateLunchM().getSelectedItem().toString().replaceAll("\\D+", "")));

            RuntimeExceptionDao<WorkDays, Integer> workDaysDao = null;
            try {
                DatabaseHelper helper = new DatabaseHelper(view.getContext());
                workDaysDao = helper.getWorkDaysRuntimeDao();

                UpdateBuilder<WorkDays, Integer> updateBuilder = workDaysDao.updateBuilder();

                updateBuilder.updateColumnValue("year", f.getYear());
                updateBuilder.updateColumnValue("month", f.getMonth());
                updateBuilder.updateColumnValue("monthName", engine.getMonthName(f.getMonth()));
                updateBuilder.updateColumnValue("day_of_month", f.getDay_of_month());
                updateBuilder.updateColumnValue("worked_hours", f.getConverted_worked_hours());
                updateBuilder.updateColumnValue("worked_minutes", f.getConverted_worked_minutes());
                updateBuilder.updateColumnValue("lunch_hours", f.getLunch_hours());
                updateBuilder.updateColumnValue("lunch_minutes", f.getLunch_minutes());

                updateBuilder.where().eq("id", f.getId());
                updateBuilder.update();

                helper.close();

                engine.refreshCalendarItems(view.getContext(), engine.getMonthNumber(), engine.getYear());
                engine.refreshCalendarTotal(view.getContext(), engine.getMonthNumber(), engine.getYear());
                listEngine.refreshListView(view.getContext());
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        }
        else if (view.getId() == e.getUpdateDate().getId()){
            openDatePickerDialog(view.getContext(), e.getUpdateDate().getId());
        }

    }
}
