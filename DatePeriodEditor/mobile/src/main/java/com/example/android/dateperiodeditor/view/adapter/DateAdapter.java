package com.example.android.dateperiodeditor.view.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import com.example.android.dateperiodeditor.R;

import java.util.Calendar;

/**
 * Created by sofiaserver on 7/6/17.
 */

public class DateAdapter extends RecyclerView.Adapter<DateAdapter.DateViewHolder> {

    public class DateViewHolder extends RecyclerView.ViewHolder {

        public TextView dateLabel;

        public DateViewHolder(View view) {
            super(view);
            dateLabel = (TextView)view;
        }
    }

    private Calendar mMonth;


    public DateAdapter(Calendar month){
        this.mMonth = month;
    }

    @Override
    public DateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.calendar_date,parent);

        return new DateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DateViewHolder holder, int position) {
        holder.dateLabel.setText(String.valueOf(position + 1));
    }

    @Override
    public int getItemCount() {
        return mMonth.getMaximum(Calendar.DATE);
    }

    public void setMonth(Calendar month){
        mMonth = month;
        //TODO dispatch dataset changed
    }
}
