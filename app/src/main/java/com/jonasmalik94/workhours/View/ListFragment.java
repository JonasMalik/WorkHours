package com.jonasmalik94.workhours.View;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;

import com.jonasmalik94.workhours.Controller.ListOnClickListener;
import com.jonasmalik94.workhours.Controller.ListOnItemListener;
import com.jonasmalik94.workhours.Controller.SearchListener;
import com.jonasmalik94.workhours.Controller.SpinnerListener;
import com.jonasmalik94.workhours.Elements.ListElements;
import com.jonasmalik94.workhours.Model.ListEngine;
import com.jonasmalik94.workhours.R;

import java.util.ArrayList;

public class ListFragment extends Fragment {

    public ListFragment() {}

    public static ListFragment newInstance() {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ArrayList<String> hours = new ArrayList<String>();
        ArrayList<String> minutes = new ArrayList<String>();


        SpinnerListener spinnerListener = new SpinnerListener();
        ListOnItemListener listOnItemListener = new ListOnItemListener(getActivity());
        ListOnClickListener listOnClickListener = new ListOnClickListener();
        SearchListener searchListener= new SearchListener(getContext());

        ListElements e = ListElements.getInstance();
        ListEngine engine = new ListEngine();

        View rootView = inflater.inflate(R.layout.fragment_list, container, false);

        ListView listView = (ListView) rootView.findViewById(R.id.listview);
        SearchView searchView = (SearchView) rootView.findViewById(R.id.searchView);
        TextView updateDate = (TextView) rootView.findViewById(R.id.update_date);
        Spinner updateLunchH = (Spinner) rootView.findViewById(R.id.update_lunch_h);
        Spinner updateLunchM = (Spinner) rootView.findViewById(R.id.update_lunch_m);
        Button updateButton = (Button) rootView.findViewById(R.id.update_button);


        listView.setOnItemLongClickListener(listOnItemListener);
        searchView.setOnQueryTextListener(searchListener);
        searchView.setOnClickListener(listOnClickListener);
        //updateLunchM.setOnItemSelectedListener(spinnerListener);
        //updateLunchH.setOnItemSelectedListener(spinnerListener);
        //updateButton.setOnClickListener(listener);
        //updateStart.setOnClickListener(listener);
        //updateEnd.setOnClickListener(listener);
        //updateDate.setOnClickListener(listener);


        // Spinner Drop down elements

        for (int i = 0; i<25; i++) {
            hours.add(i + " timmar");
        }
        for (int i = 0; i<60; i++) {
            minutes.add(i + " minuter");
        }

        // Creating adapter for spinner
        ArrayAdapter<String> hoursAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, hours);
        ArrayAdapter<String> minutesAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, minutes);

        // Drop down layout style - list view with radio button
        //hoursAdapter.setDropDownViewResource(R.layout.spinner_row);
        //minutesAdapter.setDropDownViewResource(R.layout.spinner_row);

        // attaching data adapter to spinner
        //updateLunchH.setAdapter(hoursAdapter);
        //updateLunchM.setAdapter(minutesAdapter);

        e.setUpdateDate(updateDate);
        e.setUpdateLunchH(updateLunchH);
        e.setUpdateLunchM(updateLunchM);
        e.setUpdateButton(updateButton);
        e.setListView(listView);
        e.setSearchView(searchView);

        engine.refreshListView(getContext());

        return rootView;
    }
}