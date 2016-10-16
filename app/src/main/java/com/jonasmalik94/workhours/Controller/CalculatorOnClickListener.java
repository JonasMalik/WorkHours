package com.jonasmalik94.workhours.Controller;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jonasmalik94.workhours.Model.CalculatorOperators;
import com.jonasmalik94.workhours.View.Elements;
import com.jonasmalik94.workhours.R;


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


        Button[] numberButtons = {b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bDot};
        /*while (j<numberButtons.length){
            if (view.getId() == numberButtons[j].getId()){
                display.append(numberButtons[j].getText());
                j = 0;
                i = 0;
                break;
            }
            j++;
        }*/

        if (numberButtons.Cview.getId()){
            display.append("1");

        }

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
