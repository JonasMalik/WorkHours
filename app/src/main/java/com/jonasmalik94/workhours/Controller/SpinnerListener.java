package com.jonasmalik94.workhours.Controller;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.jonasmalik94.workhours.R;

/**
 * Created by jonas on 2016-10-23.
 */

public class SpinnerListener extends Activity implements AdapterView.OnItemSelectedListener {
    // Spinner text color
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        TextView selectedText = (TextView) adapterView.getChildAt(0);
        if (selectedText != null) {
            selectedText.setTextColor(Color.GRAY);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
