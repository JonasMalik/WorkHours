package com.jonasmalik94.workhours.Elements;

import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;


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
    private ListView listView;
    private SearchView searchView;
    private Spinner updateWorkedH;
    private Spinner updateWorkedM;
    private TextView updateDate;
    private Spinner updateLunchH;
    private Spinner updateLunchM;
    private Button updateButton;

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

    public Spinner getUpdateWorkedH() {
        return updateWorkedH;
    }

    public void setUpdateWorkedH(Spinner updatdeWorkedH) {
        this.updateWorkedH = updatdeWorkedH;
    }

    public Spinner getUpdateWorkedM() {
        return updateWorkedM;
    }

    public void setUpdateWorkedM(Spinner updateWorkedM) {
        this.updateWorkedM = updateWorkedM;
    }

    public TextView getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(TextView updateDate) {
        this.updateDate = updateDate;
    }

    public Spinner getUpdateLunchH() {
        return updateLunchH;
    }

    public void setUpdateLunchH(Spinner updateLunchH) {
        this.updateLunchH = updateLunchH;
    }

    public Spinner getUpdateLunchM() {
        return updateLunchM;
    }

    public void setUpdateLunchM(Spinner updateLunchM) {
        this.updateLunchM = updateLunchM;
    }

    public Button getUpdateButton() {
        return updateButton;
    }

    public void setUpdateButton(Button updateButton) {
        this.updateButton = updateButton;
    }
}
