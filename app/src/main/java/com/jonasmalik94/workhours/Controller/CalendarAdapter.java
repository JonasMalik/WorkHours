package com.jonasmalik94.workhours.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.Where;
import com.jonasmalik94.workhours.DB.DatabaseHelper;
import com.jonasmalik94.workhours.DB.WorkDays;
import com.jonasmalik94.workhours.R;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 2016-10-11.
 */

public class CalendarAdapter extends BaseAdapter {

    private Context context;
    private int month;
    private ArrayList<String> items;
    LayoutInflater inflater;

    public CalendarAdapter(Context context, ArrayList<String> items, int month) {
        this.context = context;
        this.items = items;
        this.month = month;
        inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.cell, null);
        }
        Button cell = (Button) convertView.findViewById(R.id.grid_item);
        cell.setText(items.get(position));
        checkIfExist(cell,position, month);

        return convertView;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void checkIfExist(Button cell, int position, int month){
        RuntimeExceptionDao<WorkDays,Integer> workDaysDao = null;
        try {
            DatabaseHelper helper = new DatabaseHelper(context);
            workDaysDao = helper.getWorkDaysRuntimeDao();
            Where where = workDaysDao.queryBuilder().where();
            List<WorkDays> workDays = where.and(where.eq("day_of_month", position+1), where.eq("month", month)).query();

            if (workDays.size() > 0){
                cell.setBackgroundColor(cell.getResources().getColor(R.color.light_red));
                workDays.clear();
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}
