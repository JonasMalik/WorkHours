package com.jonasmalik94.workhours.View;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.jonasmalik94.workhours.Controller.CalculatorOnClickListener;
import com.jonasmalik94.workhours.R;
import com.jonasmalik94.workhours.Elements.CalculatorElements;

public class CalculatorFragment extends Fragment {

    public CalculatorFragment() {}

    public static CalculatorFragment newInstance() {
        CalculatorFragment fragment = new CalculatorFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        CalculatorOnClickListener  clicklistener = new CalculatorOnClickListener();
        CalculatorElements e = CalculatorElements.getInstance();
        int i = 0;

        View rootView = inflater.inflate(R.layout.fragment_calculator, container, false);
        TextView display = (TextView) rootView.findViewById(R.id.display);

        Button b0 = (Button) rootView.findViewById(R.id.b0);
        Button b1 = (Button) rootView.findViewById(R.id.b1);
        Button b2 = (Button) rootView.findViewById(R.id.b2);
        Button b3 = (Button) rootView.findViewById(R.id.b3);
        Button b4 = (Button) rootView.findViewById(R.id.b4);
        Button b5 = (Button) rootView.findViewById(R.id.b5);
        Button b6 = (Button) rootView.findViewById(R.id.b6);
        Button b7 = (Button) rootView.findViewById(R.id.b7);
        Button b8 = (Button) rootView.findViewById(R.id.b8);
        Button b9 = (Button) rootView.findViewById(R.id.b9);
        Button bDot = (Button) rootView.findViewById(R.id.bDot);


        Button bPlus = (Button) rootView.findViewById(R.id.bPlus);
        Button bDel = (Button) rootView.findViewById(R.id.bDel);
        Button bDiv = (Button) rootView.findViewById(R.id.bDiv);
        Button bMulti = (Button) rootView.findViewById(R.id.bMulti);
        Button bSub = (Button) rootView.findViewById(R.id.bSub);
        Button bEqual = (Button) rootView.findViewById(R.id.bEqual);

        Button[] numberButtons = {b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bDot,bPlus,bDel,bDiv,bMulti,bSub,bEqual};
        while ( i<numberButtons.length){
            numberButtons[i].setOnClickListener(clicklistener);
            i++;
        }

        e.setB0(b0);
        e.setB1(b1);
        e.setB2(b2);
        e.setB3(b3);
        e.setB4(b4);
        e.setB5(b5);
        e.setB6(b6);
        e.setB7(b7);
        e.setB8(b8);
        e.setB9(b9);
        e.setbDot(bDot);

        e.setbPlus(bPlus);
        e.setbDel(bDel);
        e.setbDiv(bDiv);
        e.setbMulti(bMulti);
        e.setbSub(bSub);
        e.setbEqual(bEqual);

        e.setDisplay(display);

        return rootView;
    }
}