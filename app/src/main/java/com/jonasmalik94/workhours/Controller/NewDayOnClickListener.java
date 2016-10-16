package com.jonasmalik94.workhours.Controller;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.jonasmalik94.workhours.R;


/**
 * Created by jonas on 2016-10-11.
 */

public class NewDayOnClickListener extends Activity implements View.OnClickListener {

    int i = 0;
    int j = 0;
    View rootView;

    public NewDayOnClickListener(View rootView) {
        this.rootView = rootView;
    }

    @Override
    public void onClick(View view) {

        TextView textView = (TextView) rootView.findViewById(R.id.time_header);
        TimePicker time = (TimePicker) rootView.findViewById(R.id.time);
        Button submitButton = (Button) rootView.findViewById(R.id.submit_button);

        if (view.getId() == submitButton.getId()) {
            switch (view.getId()) {

                case R.id.submit_button:
                    if (i == 0) {
                        textView.setText(R.string.end_work);
                        submitButton.setText(R.string.next);
                        i++;
                    } else if (i == 1) {
                        textView.setText(R.string.start_lunch);
                        submitButton.setText(R.string.next);
                        i++;
                    } else if (i == 2) {
                        textView.setText(R.string.end_lunch);
                        submitButton.setText(R.string.next);
                        i++;
                    } else if (i == 3) {
                        textView.setText(R.string.summary);
                        submitButton.setText(R.string.save);
                        i++;
                    }
                    break;

                default:
                    break;
            }
        }
    }
}