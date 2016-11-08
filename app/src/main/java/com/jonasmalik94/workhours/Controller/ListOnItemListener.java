package com.jonasmalik94.workhours.Controller;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.jonasmalik94.workhours.Elements.ListElements;
import com.jonasmalik94.workhours.R;
import com.jonasmalik94.workhours.View.UpdateActivity;

/**
 * Created by jonas on 2016-11-02.
 */

public class ListOnItemListener implements AdapterView.OnItemLongClickListener {

    private Activity activity;
    ListElements e = ListElements.getInstance();
    public ListOnItemListener(Activity activity) {
        this.activity = activity;
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

        TextView id = (TextView) view.findViewById(R.id.list_id);
        TextView year = (TextView) view.findViewById(R.id.list_year);
        TextView month = (TextView) view.findViewById(R.id.list_month);
        TextView date = (TextView) view.findViewById(R.id.list_day_of_month);
        TextView workedH = (TextView) view.findViewById(R.id.list_worked_hours);
        TextView workedM = (TextView) view.findViewById(R.id.list_worked_minutes);
        TextView lunchH = (TextView) view.findViewById(R.id.list_lunch_hours);
        TextView lunchM = (TextView) view.findViewById(R.id.list_lunch_minutes);

        Intent intent = new Intent(activity, UpdateActivity.class);
        intent.putExtra("id", Integer.parseInt(id.getText().toString().replaceAll("\\D+","")));
        intent.putExtra("year", Integer.parseInt(year.getText().toString().replaceAll("\\D+","")));
        intent.putExtra("month", Integer.parseInt(month.getText().toString().replaceAll("\\D+","")));
        intent.putExtra("date", Integer.parseInt(date.getText().toString().replaceAll("\\D+","")));
        intent.putExtra("workedH", Integer.parseInt(workedH.getText().toString().replaceAll("\\D+","")));
        intent.putExtra("workedM", Integer.parseInt(workedM.getText().toString().replaceAll("\\D+","")));
        intent.putExtra("lunchH", Integer.parseInt(lunchH.getText().toString().replaceAll("\\D+","")));
        intent.putExtra("lunchM", Integer.parseInt(lunchM.getText().toString().replaceAll("\\D+","")));

        activity.startActivity(intent);


        //activity.startActivity(intent);
    //    activity.overridePendingTransition( R.anim.right_to_left, R.anim.stable );

        return true;
    }
}
