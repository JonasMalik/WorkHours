package com.jonasmalik94.workhours.View;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.Where;
import com.jonasmalik94.workhours.DB.DatabaseHelper;
import com.jonasmalik94.workhours.DB.WorkDays;
import com.jonasmalik94.workhours.Elements.ListElements;
import com.jonasmalik94.workhours.R;
import com.jonasmalik94.workhours.notSorted.MainListAdapter;
import com.jonasmalik94.workhours.notSorted.MainListRow;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

        View rootView = inflater.inflate(R.layout.fragment_list, container, false);

        MainListAdapter adapter;
        ArrayList<MainListRow> arrayOfRows = new ArrayList<>();
        ListView listView = (ListView) rootView.findViewById(R.id.listview);

        RuntimeExceptionDao<WorkDays,Integer> workDaysDao = null;
        try {
            DatabaseHelper helper = new DatabaseHelper(getContext());
            workDaysDao = helper.getWorkDaysRuntimeDao();
            List<WorkDays> workDays = workDaysDao.queryForAll();

            for (int i = 0; i<workDays.size() ; i++){
                int id = workDays.get(i).getId();
                int year = workDays.get(i).getYear();
                int month = workDays.get(i).getMonth();
                int dayOfMonth = workDays.get(i).getDay_of_month();
                int workedHours = workDays.get(i).getWorked_hours();
                int workedMinutes = workDays.get(i).getWorked_minutes();
                int lunchHours = workDays.get(i).getLunch_hours();
                int lunchMinutes = workDays.get(i).getLunch_minutes();

                MainListRow newRow = new MainListRow(id, year, month, dayOfMonth, workedHours, workedMinutes, lunchHours,lunchMinutes);
                arrayOfRows.add(newRow);
            }

            adapter = new MainListAdapter(getContext(), arrayOfRows);
            listView.setAdapter(adapter);


            helper.close();

        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        return rootView;
    }
}