package com.jonasmalik94.workhours.View;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import com.jonasmalik94.workhours.Controller.NewDayOnClickListener;
import com.jonasmalik94.workhours.R;


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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_new_day, container, false);

        TextView textView = (TextView) rootView.findViewById(R.id.time_header);
        TimePicker time = (TimePicker) rootView.findViewById(R.id.time);
        Button submitButton = (Button) rootView.findViewById(R.id.submit_button);

        time.setIs24HourView(true);
        submitButton.setOnClickListener(new NewDayOnClickListener(rootView));
        return rootView;
    }
}