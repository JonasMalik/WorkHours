package com.jonasmalik94.workhours.notSorted;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.jonasmalik94.workhours.Elements.CalendarElements;
import com.jonasmalik94.workhours.Model.CalendarEngine;
import com.jonasmalik94.workhours.R;

import java.util.ArrayList;

/**
 * Created by jonas on 2016-06-22.
 */
public class MainListAdapter extends ArrayAdapter<MainListRow> {

    CalendarElements e = CalendarElements.getInstance();
    CalendarEngine engine = new CalendarEngine();

    public MainListAdapter(Context context, ArrayList<MainListRow> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the data item for this position
        MainListRow row = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_main, parent, false);
        }

        // Lookup view for data population
        TextView id = (TextView) convertView.findViewById(R.id.list_id);
        TextView year = (TextView) convertView.findViewById(R.id.list_year);
        TextView month = (TextView) convertView.findViewById(R.id.list_month);
        TextView dayOfMonth = (TextView) convertView.findViewById(R.id.list_day_of_month);
        TextView workedHours = (TextView) convertView.findViewById(R.id.list_worked_hours);
        TextView workedMinutes = (TextView) convertView.findViewById(R.id.list_worked_minutes);
        TextView lunchHours = (TextView) convertView.findViewById(R.id.list_lunch_hours);
        TextView lunchMinutes = (TextView) convertView.findViewById(R.id.list_lunch_minutes);
        TextView header = (TextView) convertView.findViewById(R.id.list_header);

        String monthName = engine.getMonthName(row.getMonth());
        header.setText(row.getYear()+" "+monthName+" "+row.getDayOfMonth());



        // Populate the data into the template view using the data object
        id.setText("ID: "+Integer.toString(row.getId()));
        year.setText("Datum: "+Integer.toString(row.getYear()));
        month.setText("- "+Integer.toString(row.getMonth()));
        dayOfMonth.setText("- "+Integer.toString(row.getDayOfMonth()));
        workedHours.setText("Arbetad tid: "+Integer.toString(row.getWorkedHours())+"h");
        workedMinutes.setText(Integer.toString(row.getWorkedMinutes())+"m");
        lunchHours.setText("Rast: "+Integer.toString(row.getLunchHours())+"h");
        lunchMinutes.setText(Integer.toString(row.getLunchMinutes())+"m");


        // Return the completed view to render on screen
        return convertView;
    }
}