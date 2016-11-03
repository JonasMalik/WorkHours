package com.jonasmalik94.workhours.Controller;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.jonasmalik94.workhours.Elements.CalculatorElements;
import com.jonasmalik94.workhours.Elements.ListElements;
import com.jonasmalik94.workhours.Model.CalculatorOperators;
import com.jonasmalik94.workhours.R;

import java.util.HashSet;


/**
 * Created by jonas on 2016-10-11.
 */

public class ListOnClickListener extends Activity implements View.OnClickListener {


    @Override
    public void onClick(View view) {

        ListElements e = ListElements.getInstance();
        e.getSearchView().onActionViewExpanded();
    }

}

