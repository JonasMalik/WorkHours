package com.jonasmalik94.workhours.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import com.jonasmalik94.workhours.R;

import java.util.ArrayList;

/**
 * Created by jonas on 2016-10-11.
 */

public class CalendarAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> items;
    LayoutInflater inflater;

    public CalendarAdapter(Context context, ArrayList<String> items) {
        this.context = context;
        this.items = items;
        inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.cell, null);
        }
        if (position == 0){
            Button button = (Button) convertView.findViewById(R.id.grid_item);

        }
        Button button = (Button) convertView.findViewById(R.id.grid_item);
        button.setText(items.get(position));

        return convertView;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
