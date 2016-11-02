package com.jonasmalik94.workhours.Controller;

import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.jonasmalik94.workhours.Elements.CalendarElements;
import com.jonasmalik94.workhours.Model.CalendarEngine;

import java.util.ArrayList;


/**
 * Created by jonas on 2016-10-11.
 */

public class CalendarOnClickListener implements View.OnClickListener {

    CalendarEngine engine = new CalendarEngine();
    CalendarElements e = CalendarElements.getInstance();
    int counter = 0;
    int monthNumber = 0;
    int year = engine.getYear();

    @Override
    public void onClick(View view) {
        ArrayList<Integer> returnedValues;

        if (view.getId() == e.getLeft().getId()){
            returnedValues = engine.prevMonth(view.getContext(),counter,monthNumber,year);
            counter = returnedValues.get(0);
            monthNumber = returnedValues.get(1);
            year = returnedValues.get(2);
        }
        else if (view.getId() == e.getRight().getId()){
            returnedValues = engine.nextMonth(view.getContext(),counter,monthNumber,year);
            counter = returnedValues.get(0);
            monthNumber = returnedValues.get(1);
            year = returnedValues.get(2);
        }
    }
}
