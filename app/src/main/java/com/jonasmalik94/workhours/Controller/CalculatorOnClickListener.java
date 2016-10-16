package com.jonasmalik94.workhours.Controller;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.jonasmalik94.workhours.Model.CalculatorOperators;
import com.jonasmalik94.workhours.View.Elements;
import com.jonasmalik94.workhours.R;

import java.util.HashSet;


/**
 * Created by jonas on 2016-10-11.
 */

public class CalculatorOnClickListener extends CalculatorOperators implements View.OnClickListener {

    private String firstValue;
    private String secondValue;
    private String operator;
    private int i = 0;
    private int j = 0;

    @Override
    public void onClick(View view) {

        Elements e = Elements.getInstance();

        TextView display = e.getDisplay();

        Button b0 = e.getB0();
        Button b1 = e.getB1();
        Button b2 = e.getB2();
        Button b3 = e.getB3();
        Button b4 = e.getB4();
        Button b5 = e.getB5();
        Button b6 = e.getB6();
        Button b7 = e.getB7();
        Button b8 = e.getB8();
        Button b9 = e.getB9();
        Button bDot = e.getbDot();

        Button bPlus = e.getbPlus();
        Button bDel = e.getbDel();
        Button bDiv = e.getbDiv();
        Button bMulti = e.getbMulti();
        Button bSub = e.getbSub();
        Button bEqual = e.getbEqual();


        HashSet numberButtons = new HashSet();
        numberButtons.add(b0);
        numberButtons.add(b1);
        numberButtons.add(b2);
        numberButtons.add(b3);
        numberButtons.add(b4);
        numberButtons.add(b5);
        numberButtons.add(b6);
        numberButtons.add(b7);
        numberButtons.add(b8);
        numberButtons.add(b9);
        numberButtons.add(bDot);

        if (view.getId() == b0.getId()) display.append("0");
        else if (view.getId() == b1.getId()) display.append("1");
        else if (view.getId() == b2.getId()) display.append("2");
        else if (view.getId() == b3.getId()) display.append("3");
        else if (view.getId() == b4.getId()) display.append("4");
        else if (view.getId() == b5.getId()) display.append("5");
        else if (view.getId() == b6.getId()) display.append("6");
        else if (view.getId() == b7.getId()) display.append("7");
        else if (view.getId() == b8.getId()) display.append("8");
        else if (view.getId() == b9.getId()) display.append("9");
        else if (view.getId() == bDot.getId()) display.append(".");

        else if (view.getId() == bPlus.getId()){
            operator = "+";
            firstValue = display.getText().toString();
            display.setText("+ ");

        }
        else if (view.getId() == bSub.getId()){
            operator = "-";
            firstValue = display.getText().toString();
            display.setText("- ");
        }
        else if (view.getId() == bDiv.getId()){
            operator = "/";
            firstValue = display.getText().toString();
            display.setText("/ ");
        }
        else if (view.getId() == bMulti.getId()){
            operator = "*";
            firstValue = display.getText().toString();
            display.setText("* ");
        }
        else if (view.getId() == bDel.getId()){

        }
        else if (view.getId() == bEqual.getId()){
            secondValue = display.getText().toString().substring(2);
            firstValue = operation(firstValue,secondValue,operator);
            display.setText(firstValue);
        }
    }
}
