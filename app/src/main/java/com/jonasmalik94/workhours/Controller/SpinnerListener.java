package com.jonasmalik94.workhours.Controller;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.jonasmalik94.workhours.R;

/**
 * Created by jonas on 2016-10-23.
 */

public class SpinnerListener extends Activity implements AdapterView.OnItemSelectedListener {
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        ((TextView) adapterView.getChildAt(0)).setTextColor(view.getResources().getColor(R.color.white));

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
