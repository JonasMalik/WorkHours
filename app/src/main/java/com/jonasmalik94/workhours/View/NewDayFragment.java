package com.jonasmalik94.workhours.View;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.jonasmalik94.workhours.Controller.NewDayOnClickListener;
import com.jonasmalik94.workhours.Controller.SpinnerListener;
import com.jonasmalik94.workhours.Elements.NewDayElements;
import com.jonasmalik94.workhours.ExportActivity;
import com.jonasmalik94.workhours.MainActivity;
import com.jonasmalik94.workhours.R;

import java.util.ArrayList;


/**
 * A placeholder fragment containing a simple view.
 */
public class NewDayFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    public NewDayFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static NewDayFragment newInstance(int sectionNumber) {
        NewDayFragment fragment = new NewDayFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ArrayList<String> hours = new ArrayList<String>();
        ArrayList<String> minutes = new ArrayList<String>();
        NewDayElements e = NewDayElements.getInstance();
        View rootView = inflater.inflate(R.layout.fragment_new_day, container, false);
        NewDayOnClickListener listener= new  NewDayOnClickListener(rootView, getContext());
        SpinnerListener spinnerListener = new SpinnerListener();

        TextView startLabel = (TextView) rootView.findViewById(R.id.start_label);
        TextView endLabel = (TextView) rootView.findViewById(R.id.end_label);
        TextView lunchLabel = (TextView) rootView.findViewById(R.id.lunch_label);
        TextView start = (TextView) rootView.findViewById(R.id.start);
        TextView end = (TextView) rootView.findViewById(R.id.end);
        Spinner lunchH = (Spinner) rootView.findViewById(R.id.lunch_h);
        Spinner lunchM = (Spinner) rootView.findViewById(R.id.lunch_m);
        TextView dateLabel = (TextView) rootView.findViewById(R.id.date_label);
        TextView date = (TextView) rootView.findViewById(R.id.date);
        Button submitButton = (Button) rootView.findViewById(R.id.submit_button);

        lunchM.setOnItemSelectedListener(spinnerListener);
        lunchH.setOnItemSelectedListener(spinnerListener);
        dateLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ExportActivity.class);
                startActivity(intent);
            }
        });
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
        hoursAdapter.setDropDownViewResource(R.layout.spinner_row);
        minutesAdapter.setDropDownViewResource(R.layout.spinner_row);


        // attaching data adapter to spinner
        lunchH.setAdapter(hoursAdapter);
        lunchM.setAdapter(minutesAdapter);





        submitButton.setOnClickListener(listener);
        start.setOnClickListener(listener);
        end.setOnClickListener(listener);
        date.setOnClickListener(listener);

        e.setStartLabel(startLabel);
        e.setEndLabel(endLabel);
        e.setLunchLabel(lunchLabel);
        e.setStart(start);
        e.setEnd(end);
        e.setLunchH(lunchH);
        e.setLunchM(lunchM);
        e.setDateLabel(dateLabel);
        e.setDate(date);
        e.setSubmitButton(submitButton);
        return rootView;
    }
}