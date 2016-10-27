package com.jonasmalik94.workhours.Elements;

import android.widget.Button;
import android.widget.TextView;


/**
 * Created by jonas on 2016-10-15.
 */

public class CalculatorElements {

    private static CalculatorElements instance = null;
    private CalculatorElements() {}

    public static synchronized CalculatorElements getInstance() {
        if (instance == null) instance = new CalculatorElements();
        return instance;
    }

    private Button b0;
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    private Button b8;
    private Button b9;
    private Button bDot;

    private Button bPlus;
    private Button bDel;
    private Button bDiv;
    private Button bMulti;
    private Button bSub;
    private Button bEqual;

    private TextView display;

    public Button getB0() {
        return b0;
    }
    public void setB0(Button b0) {
        this.b0 = b0;
    }
    public Button getB1() {
        return b1;
    }
    public void setB1(Button b1) {
        this.b1 = b1;
    }
    public Button getB2() {
        return b2;
    }
    public void setB2(Button b2) {
        this.b2 = b2;
    }
    public Button getB3() {
        return b3;
    }
    public void setB3(Button b3) {
        this.b3 = b3;
    }
    public Button getB4() {
        return b4;
    }
    public void setB4(Button b4) {
        this.b4 = b4;
    }
    public Button getB5() {
        return b5;
    }
    public void setB5(Button b5) {
        this.b5 = b5;
    }
    public Button getB6() {
        return b6;
    }
    public void setB6(Button b6) {
        this.b6 = b6;
    }
    public Button getB7() {
        return b7;
    }
    public void setB7(Button b7) {
        this.b7 = b7;
    }
    public Button getB8() {
        return b8;
    }
    public void setB8(Button b8) {
        this.b8 = b8;
    }
    public Button getB9() {
        return b9;
    }
    public void setB9(Button b9) {
        this.b9 = b9;
    }
    public Button getbDot() {
        return bDot;
    }
    public void setbDot(Button bDot) {
        this.bDot = bDot;
    }

    public Button getbPlus() {
        return bPlus;
    }
    public void setbPlus(Button bPlus) {
        this.bPlus = bPlus;
    }
    public Button getbDel() {
        return bDel;
    }
    public void setbDel(Button bDel) {
        this.bDel = bDel;
    }
    public Button getbDiv() {
        return bDiv;
    }
    public void setbDiv(Button bDiv) {
        this.bDiv = bDiv;
    }
    public Button getbMulti() {
        return bMulti;
    }
    public void setbMulti(Button bMulti) {
        this.bMulti = bMulti;
    }
    public Button getbSub() {
        return bSub;
    }
    public void setbSub(Button bSub) {
        this.bSub = bSub;
    }
    public Button getbEqual() {
        return bEqual;
    }
    public void setbEqual(Button bEqual) {
        this.bEqual = bEqual;
    }

    public TextView getDisplay() {
        return display;
    }
    public void setDisplay(TextView display) {
        this.display = display;
    }
}
