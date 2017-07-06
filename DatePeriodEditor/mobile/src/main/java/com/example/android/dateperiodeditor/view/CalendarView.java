package com.example.android.dateperiodeditor.view;


import java.util.Calendar;

/**
 * Created by sofiaserver on 7/6/17.
 */

public interface CalendarView {
    public void setMinDate(Calendar date);
    public void setMaxDate(Calendar date);
    public void setSelectionStart(Calendar date);
    public void setSelectionEnd(Calendar date);
    //TODO getters for selection and listener handling for selection change
}
