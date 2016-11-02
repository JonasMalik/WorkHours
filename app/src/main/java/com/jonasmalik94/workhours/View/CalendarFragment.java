package com.jonasmalik94.workhours.View;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.jonasmalik94.workhours.Controller.CalendarOnClickListener;
import com.jonasmalik94.workhours.Controller.CalendarOnItemClickListener;
import com.jonasmalik94.workhours.Elements.CalendarElements;
import com.jonasmalik94.workhours.Model.CalendarEngine;
import com.jonasmalik94.workhours.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class CalendarFragment extends Fragment {

    public CalendarFragment() {}

    public static CalendarFragment newInstance() {
        CalendarFragment fragment = new CalendarFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        CalendarEngine engine = new CalendarEngine();
        CalendarElements e = CalendarElements.getInstance();
        CalendarOnClickListener clickListener = new CalendarOnClickListener();
        View rootView = inflater.inflate(R.layout.fragment_calender, container, false);
        CalendarOnItemClickListener itemListener = new CalendarOnItemClickListener(getContext());

        final GridView calendar  = (GridView) rootView.findViewById(R.id.calender);
        Button left              = (Button)   rootView.findViewById(R.id.left);
        Button right             = (Button)   rootView.findViewById(R.id.right);
        Button cell              = (Button)   rootView.findViewById(R.id.grid_item);
        TextView infoHeader      = (TextView) rootView.findViewById(R.id.info_header);
        TextView infoHoursWorked = (TextView) rootView.findViewById(R.id.info_hours_worked);
        TextView daysTotal       = (TextView) rootView.findViewById(R.id.days_total);
        TextView hoursTotal      = (TextView) rootView.findViewById(R.id.hours_total);
        TextView month           = (TextView) rootView.findViewById(R.id.month);

        left.setOnClickListener(clickListener);
        right.setOnClickListener(clickListener);
        month.setText(engine.getMonthName(engine.getMonthNumber())+" "+engine.getYear());
        calendar.setOnItemClickListener(itemListener);
        calendar.setOnItemLongClickListener(itemListener);

        e.setInfoHoursWorked(infoHoursWorked);
        e.setInfoHeader(infoHeader);
        e.setCalendar(calendar);
        e.setMonth(month);
        e.setLeft(left);
        e.setRight(right);
        e.setHoursTotal(hoursTotal);
        e.setDaysTotal(daysTotal);
        e.setCell(cell);

        engine.refreshCalendarItems(getContext(),engine.getMonthNumber(),engine.getYear());
        engine.refreshCalendarTotal(getContext(),engine.getMonthNumber(),engine.getYear());

        return rootView;
    }
}