package com.jonasmalik94.workhours.Controller;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.jonasmalik94.workhours.Elements.NewDayElements;
import com.jonasmalik94.workhours.Model.Dialogs;


/**
 * Created by jonas on 2016-10-11.
 */

@RequiresApi(api = Build.VERSION_CODES.N)
public class NewDayOnClickListener extends Dialogs implements View.OnClickListener {

    int i = 0;
    int j = 0;
    View rootView;
    Context context;
    NewDayElements e = NewDayElements.getInstance();


    public NewDayOnClickListener(View rootView, Context context) {
        this.rootView = rootView;
        this.context = context;
    }

    @Override
    public void onClick(View view) {

        TextView start = e.getStart();
        TextView end = e.getEnd();
        Spinner lunch = e.getLunchH();
        TextView date = e.getDate();
        Button submitButton = e.getSubmitButton();

        if (view.getId() == date.getId()) {
            openDatePickerDialog(context);
        }
        else if (view.getId() == start.getId()) {
            openTimePickerDialog(context, start.getId());
        }
        else if (view.getId() == end.getId()) {
            openTimePickerDialog(context, end.getId());
        }
        else if (view.getId() == lunch.getId()) {
            openDatePickerDialog(context);
        }
        else if (view.getId() == submitButton.getId()){
            
        }
    }
}