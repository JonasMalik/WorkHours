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

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.Where;
import com.jonasmalik94.workhours.DB.DatabaseHelper;
import com.jonasmalik94.workhours.DB.WorkDays;
import com.jonasmalik94.workhours.Model.CalendarEngine;
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
    private int year;
    private int date;
    private ArrayList<String> items;
    LayoutInflater inflater;
    CalendarEngine engine = new CalendarEngine();

    public CalendarAdapter(Context context, ArrayList<String> items, int month, int year) {
        this.context = context;
        this.items = items;
        this.month = month;
        this.year = year;
        inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        date = position +1;

        if (convertView == null) {convertView = inflater.inflate(R.layout.cell, null);}

        Button cell = (Button) convertView.findViewById(R.id.grid_item);
        cell.setText(items.get(position));
        engine.printCell(context, cell, date, month, year);

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


}
