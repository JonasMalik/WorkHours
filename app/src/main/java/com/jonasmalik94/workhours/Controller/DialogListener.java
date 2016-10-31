package com.jonasmalik94.workhours.Controller;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.Where;
import com.jonasmalik94.workhours.DB.DatabaseHelper;
import com.jonasmalik94.workhours.DB.WorkDays;
import com.jonasmalik94.workhours.Elements.CalendarElements;
import com.jonasmalik94.workhours.Model.CalendarEngine;
import com.jonasmalik94.workhours.R;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by jonas on 2016-10-31.
 */

public class DialogListener implements DialogInterface.OnClickListener {

    Context context;
    int date;
    int month;
    int year;
    CalendarElements e = CalendarElements.getInstance();
    CalendarEngine engine = new CalendarEngine();

    public DialogListener(Context context,int date, int month, int year) {
        this.context = context;
        this.date = date;
        this.month = month;
        this.year = year;
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        RuntimeExceptionDao<WorkDays,Integer> workDaysDao = null;
        try {
            DatabaseHelper helper = new DatabaseHelper(context);
            workDaysDao = helper.getWorkDaysRuntimeDao();
            Where where = workDaysDao.queryBuilder().where();

            List<WorkDays> workDays = where.and(where.eq("day_of_month", date),
                                                where.eq("month", month),
                                                where.eq("year", year))
                                                .query();
            workDaysDao.delete(workDays);
            if (workDays.size()>0){
                e.getCalendar().setAdapter(new CalendarAdapter(context,engine.getItems(year,month), month,year));
                Toast.makeText(context, R.string.toast_delete_success,Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(context, R.string.toast_delete_nothing_to_delete,Toast.LENGTH_SHORT).show();
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
            Toast.makeText(context,R.string.toast_delete_error,Toast.LENGTH_SHORT).show();
        }
    }
}
