package com.jonasmalik94.workhours.Elements;

import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.jonasmalik94.workhours.R;


/**
 * Created by jonas on 2016-10-15.
 */

public class ListElements {

    private static ListElements instance = null;
    private ListElements() {}

    public static synchronized ListElements getInstance() {
        if (instance == null) instance = new ListElements();
        return instance;
    }
    ListView listView;
    SearchView searchView;

    public ListView getListView() {
        return listView;
    }

    public void setListView(ListView listView) {
        this.listView = listView;
    }

    public SearchView getSearchView() {
        return searchView;
    }

    public void setSearchView(SearchView searchView) {
        this.searchView = searchView;
    }
}
