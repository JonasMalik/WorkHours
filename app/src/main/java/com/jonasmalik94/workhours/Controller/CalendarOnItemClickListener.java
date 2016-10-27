package com.jonasmalik94.workhours.Controller;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.jonasmalik94.workhours.Elements.CalendarElements;
import com.jonasmalik94.workhours.Model.CalendarEngine;

/**
 * Created by jonas on 2016-10-27.
 */

public class CalendarOnItemClickListener implements AdapterView.OnItemClickListener {
    Context context;
    int date;
    String month;
    CalendarEngine engine = new CalendarEngine();
    CalendarElements e = CalendarElements.getInstance();

    public CalendarOnItemClickListener(Context context) {
        this.context = context;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Getting the clicked list item by position
        // final View view1 = calendar.getAdapter().getView(position, null, calendar);
        //TextView myID = (TextView) view1.findViewById(R.id.myID);
        date = position +1;
        month = e.getMonth().getText().toString().substring(0,e.getMonth().length()-5);
        e.getInfoHeader().setText(month+" "+date);
        Toast.makeText(context,Integer.toString(position),Toast.LENGTH_SHORT).show();
    }
}
