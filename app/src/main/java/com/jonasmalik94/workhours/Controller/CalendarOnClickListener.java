package com.jonasmalik94.workhours.Controller;

import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

import com.jonasmalik94.workhours.Elements.CalculatorElements;
import com.jonasmalik94.workhours.Elements.CalendarElements;
import com.jonasmalik94.workhours.Model.CalculatorOperators;
import com.jonasmalik94.workhours.Model.CalendarEngine;

import java.util.ArrayList;
import java.util.HashSet;


/**
 * Created by jonas on 2016-10-11.
 */

public class CalendarOnClickListener implements View.OnClickListener {

    CalendarEngine engine = new CalendarEngine();
    CalendarElements e = CalendarElements.getInstance();
    int click = 0;
    int tempCounter = 0;
    int year = engine.getYear();
    @Override
    public void onClick(View view) {


        ArrayList<String> items = new ArrayList();
        TextView month = e.getMonth();
        GridView calendar = e.getCalendar();
        Button left = e.getLeft();
        Button right = e.getRight();

        if (view.getId() == left.getId()){
            int counter = 0;
            click--;

            tempCounter = click + engine.getMonthNumber();
            if (tempCounter == 0){
                tempCounter = tempCounter+12;
                click = click+12;
                year--;
            }
            while (counter<engine.getCountOfDays(year,tempCounter)){
                items.add(Integer.toString(counter+1));
                counter++;
            }

            month.setText(engine.getMonthName(tempCounter)+" "+year);
            calendar.setAdapter(new CalendarAdapter(view.getContext(),items, tempCounter));

        }
        else if (view.getId() == right.getId()){
            int counter = 0;
            click++;

            tempCounter = click + engine.getMonthNumber();
            if (tempCounter == 13){
                tempCounter = tempCounter-12;
                click = click-12;
                year++;
            }
            while (counter<engine.getCountOfDays(year,tempCounter)){
                items.add(Integer.toString(counter+1));
                counter++;
            }

            month.setText(engine.getMonthName(tempCounter)+" "+year);
            calendar.setAdapter(new CalendarAdapter(view.getContext(),items, tempCounter));
        }
    }
}
