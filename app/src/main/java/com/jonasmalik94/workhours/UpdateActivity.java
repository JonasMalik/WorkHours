package com.jonasmalik94.workhours;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.jonasmalik94.workhours.Controller.UpdateOnClickListener;
import com.jonasmalik94.workhours.DB.FieldHolder;
import com.jonasmalik94.workhours.Elements.ListElements;
import com.jonasmalik94.workhours.Model.ListEngine;

import java.util.ArrayList;

/**
 * Created by jonas on 2016-09-14.
 */
public class UpdateActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        int id      = getIntent().getExtras().getInt("id");
        int year    = getIntent().getExtras().getInt("year");
        int month   = getIntent().getExtras().getInt("month");
        int date    = getIntent().getExtras().getInt("date");
        int workedH = getIntent().getExtras().getInt("workedH");
        int workedM = getIntent().getExtras().getInt("workedM");
        int lunchH  = getIntent().getExtras().getInt("lunchH");
        int lunchM  = getIntent().getExtras().getInt("lunchM");

        ArrayList<String> hours = new ArrayList<String>();
        ArrayList<String> minutes = new ArrayList<String>();

        ListElements e = ListElements.getInstance();
        FieldHolder f = FieldHolder.getInstance();

        UpdateOnClickListener listener = new UpdateOnClickListener();

        TextView updateDate = (TextView) findViewById(R.id.update_date);
        Spinner updateWorkedH = (Spinner) findViewById(R.id.update_worked_h);
        Spinner updateWorkedM = (Spinner) findViewById(R.id.update_worked_m);
        Spinner updateLunchH = (Spinner) findViewById(R.id.update_lunch_h);
        Spinner updateLunchM = (Spinner) findViewById(R.id.update_lunch_m);
        Button updateButton = (Button) findViewById(R.id.update_button);

        //updateLunchM.setOnItemSelectedListener(spinnerListener);
        //updateLunchH.setOnItemSelectedListener(spinnerListener);
        updateButton.setOnClickListener(listener);
        updateDate.setOnClickListener(listener);

        // Spinner Drop down elements

        for (int i = 0; i<25; i++) {
            hours.add(i + " timmar");
        }
        for (int i = 0; i<60; i++) {
            minutes.add(i + " minuter");
        }

        ArrayAdapter<String> hoursAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, hours);
        ArrayAdapter<String> minutesAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, minutes);

        hoursAdapter.setDropDownViewResource(R.layout.spinner_row);
        minutesAdapter.setDropDownViewResource(R.layout.spinner_row);

        updateLunchH.setAdapter(hoursAdapter);
        updateLunchM.setAdapter(minutesAdapter);
        updateWorkedH.setAdapter(hoursAdapter);
        updateWorkedM.setAdapter(minutesAdapter);

        updateDate.setText(year+"-"+month+"-"+date);
        updateWorkedH.setSelection(workedH);
        updateWorkedM.setSelection(workedM);
        updateLunchH.setSelection(lunchH);
        updateLunchM.setSelection(lunchM);
        f.setId(id);

        e.setUpdateWorkedH(updateWorkedH);
        e.setUpdateWorkedM(updateWorkedM);
        e.setUpdateDate(updateDate);
        e.setUpdateLunchH(updateLunchH);
        e.setUpdateLunchM(updateLunchM);
        e.setUpdateButton(updateButton);
    }
}
