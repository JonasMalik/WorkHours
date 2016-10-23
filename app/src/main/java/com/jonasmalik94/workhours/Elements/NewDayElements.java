package com.jonasmalik94.workhours.Elements;

import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


/**
 * Created by jonas on 2016-10-15.
 */

public class NewDayElements {

    private static NewDayElements instance = null;
    private NewDayElements() {}

    public static synchronized NewDayElements getInstance() {
        if (instance == null) instance = new NewDayElements();
        return instance;
    }

    private TextView startLabel;
    private TextView start;
    private TextView endLabel;
    private TextView end;
    private TextView lunchLabel;
    private TextView dateLabel;
    private TextView date;
    private Spinner lunchH;
    private Spinner lunchM;
    private Button submitButton;


    public TextView getStartLabel() {
        return startLabel;
    }
    public void setStartLabel(TextView startLabel) {
        this.startLabel = startLabel;
    }
    public TextView getStart() {
        return start;
    }
    public void setStart(TextView start) {
        this.start = start;
    }
    public TextView getEndLabel() {
        return endLabel;
    }
    public void setEndLabel(TextView endLabel) {
        this.endLabel = endLabel;
    }
    public TextView getEnd() {
        return end;
    }
    public void setEnd(TextView end) {
        this.end = end;
    }
    public TextView getLunchLabel() {
        return lunchLabel;
    }
    public void setLunchLabel(TextView lunchLabel) {
        this.lunchLabel = lunchLabel;
    }
    public Spinner getLunchH() {
        return lunchH;
    }
    public void setLunchH(Spinner lunchH) {
        this.lunchH = lunchH;
    }
    public Button getSubmitButton() {
        return submitButton;
    }
    public void setSubmitButton(Button submitButton) {
        this.submitButton = submitButton;
    }
    public TextView getDateLabel() {
        return dateLabel;
    }
    public void setDateLabel(TextView dateLabel) {
        this.dateLabel = dateLabel;
    }
    public TextView getDate() {
        return date;
    }
    public void setDate(TextView date) {
        this.date = date;
    }
    public Spinner getLunchM() {
        return lunchM;
    }
    public void setLunchM(Spinner lunchM) {
        this.lunchM = lunchM;
    }

}
