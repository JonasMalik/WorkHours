package com.jonasmalik94.workhours.Controller;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.table.TableUtils;
import com.jonasmalik94.workhours.DB.DatabaseHelper;
import com.jonasmalik94.workhours.DB.FieldHolder;
import com.jonasmalik94.workhours.DB.WorkDays;
import com.jonasmalik94.workhours.Elements.NewDayElements;
import com.jonasmalik94.workhours.Model.Dialogs;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;


/**
 * Created by jonas on 2016-10-11.
 */

@RequiresApi(api = Build.VERSION_CODES.N)
public class NewDayOnClickListener extends Dialogs implements View.OnClickListener {

    int i = 0;
    int j = 0;
    View rootView;
    Context context;
    NewDayElements e = NewDayElements.getInstance();
    FieldHolder f = FieldHolder.getInstance();


    public NewDayOnClickListener(View rootView, Context context) {
        this.rootView = rootView;
        this.context = context;
    }

    @Override
    public void onClick(View view) {

        TextView start = e.getStart();
        TextView end = e.getEnd();
        Spinner lunchH = e.getLunchH();
        Spinner lunchM = e.getLunchM();
        TextView date = e.getDate();
        Button submitButton = e.getSubmitButton();

        if (view.getId() == date.getId()) {
            openDatePickerDialog(context);
        }
        else if (view.getId() == start.getId()) {
            openTimePickerDialog(context, start.getId());
        }
        else if (view.getId() == end.getId()) {
            openTimePickerDialog(context, end.getId());
        }
        else if (view.getId() == lunchH.getId()) {

        }
        else if (view.getId() == submitButton.getId()){
            f.setLunch_hours(Integer.parseInt(lunchH.getSelectedItem().toString().replaceAll("\\D+","")));
            f.setLunch_minutes(Integer.parseInt(lunchM.getSelectedItem().toString().replaceAll("\\D+","")));

            RuntimeExceptionDao<WorkDays,Integer> workDaysDao = null;
            try {
                DatabaseHelper helper = new DatabaseHelper(context);
                workDaysDao = helper.getWorkDaysRuntimeDao();
                TableUtils.dropTable(workDaysDao,false);
                helper.createMyTable();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            //Create
            try {
                workDaysDao.create(new WorkDays(f.getYear(),
                                                f.getMonth(),
                                                f.getDay_of_month(),
                                                f.getWorked_hours(),
                                                f.getWorked_minutes(),
                                                f.getLunch_hours(),
                                                f.getLunch_minutes()));
            } catch (ParseException e1) {
                e1.printStackTrace();
            }


            //Add to db
            List<WorkDays> workDays = workDaysDao.queryForAll();

            //Output
            Log.d("demo",workDays.toString());
        }
    }
}