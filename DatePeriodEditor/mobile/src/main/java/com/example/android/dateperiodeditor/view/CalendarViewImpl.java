package com.example.android.dateperiodeditor.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.example.android.dateperiodeditor.view.CalendarView;
import com.example.android.dateperiodeditor.view.adapter.YearAdapter;

import java.util.Calendar;

/**
 * Created by sofiaserver on 7/6/17.
 */

public class CalendarViewImpl extends RecyclerView implements CalendarView {

    public CalendarViewImpl(Context contect) {
        super(contect);
    }

    public CalendarViewImpl(Context context, AttributeSet attr, int defStyle) {
        super(context, attr, defStyle);
    }

    private Calendar mMinDate;
    private Calendar mMaxDate;

    private Calendar mSelectionStart;
    private Calendar mSelectionEnd;



    private void datesChanged() {
        if(mMinDate != null && mMaxDate != null) {
            YearAdapter yearAdapter = new YearAdapter(mMinDate.get(Calendar.YEAR), mMaxDate.get(Calendar.YEAR));
            setAdapter(yearAdapter);
        }
    }

    @Override
    public void setMinDate(Calendar date) {
        //TODO check if mMinDate equals date ...
        mMinDate = date;
        datesChanged();
    }

    @Override
    public void setMaxDate(Calendar date) {
        mMaxDate = date;
        datesChanged();
    }

    @Override
    public void setSelectionStart(Calendar date) {
        mSelectionStart = date;
        datesChanged();
    }

    @Override
    public void setSelectionEnd(Calendar date) {
        mSelectionEnd = date;
        datesChanged();
    }
}
