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

public class CalendarOnClickListener extends CalculatorOperators implements View.OnClickListener {

    int click = 0;
    @Override
    public void onClick(View view) {

        CalendarEngine engine = new CalendarEngine();
        CalendarElements e = CalendarElements.getInstance();
        ArrayList<String> items = new ArrayList();
        TextView month = e.getMonth();
        GridView calendar = e.getCalendar();
        Button left = e.getLeft();
        Button right = e.getRight();

        if (view.getId() == left.getId()){

        }
        else if (view.getId() == right.getId()){
            int counter = 0;
            int tempCounter = 0;
            click++;

            tempCounter = click + engine.getMonthNumber();
            if (tempCounter == 13){
                tempCounter = tempCounter-12;
                click = click-12;
            }
            while (counter<engine.getCountOfDays(2016,tempCounter)){
                items.add(Integer.toString(counter+1));
                counter++;
            }

            month.setText(engine.getMonthName(tempCounter));
            calendar.setAdapter(new CalendarAdapter(view.getContext(),items));
        }
    }
}
