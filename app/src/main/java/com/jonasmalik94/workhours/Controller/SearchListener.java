package com.jonasmalik94.workhours.Controller;

import android.content.Context;
import android.widget.SearchView;

import com.jonasmalik94.workhours.Elements.ListElements;
import com.jonasmalik94.workhours.Model.ListEngine;

/**
 * Created by jonas on 2016-11-02.
 */

public class SearchListener implements SearchView.OnQueryTextListener {

    private Context context;
    ListElements e = ListElements.getInstance();
    ListEngine engine = new ListEngine();

    public SearchListener(Context context) {
        this.context = context;
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {

        engine.search(context, s);
        return true;
    }
}
