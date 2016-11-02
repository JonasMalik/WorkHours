package com.jonasmalik94.workhours.View;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SearchView;

import com.jonasmalik94.workhours.Controller.ListOnClickListener;
import com.jonasmalik94.workhours.Controller.SearchListener;
import com.jonasmalik94.workhours.Elements.ListElements;
import com.jonasmalik94.workhours.Model.ListEngine;
import com.jonasmalik94.workhours.R;

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

        ListEngine engine = new ListEngine();
        ListOnClickListener listOnClickListener = new ListOnClickListener();
        SearchListener searchListener= new SearchListener(getContext());
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);
        ListElements e = ListElements.getInstance();

        ListView listView = (ListView) rootView.findViewById(R.id.listview);
        SearchView searchView = (SearchView) rootView.findViewById(R.id.searchView);

        searchView.setOnQueryTextListener(searchListener);
        searchView.setOnClickListener(listOnClickListener);

        e.setListView(listView);
        e.setSearchView(searchView);

        engine.refreshListView(getContext());

        return rootView;
    }
}