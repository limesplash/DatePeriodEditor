package com.example.android.dateperiodeditor.view.adapter;

import android.content.Context;
import android.database.DataSetObserver;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.android.dateperiodeditor.R;

import java.util.Calendar;
import java.util.Locale;

/**
 * Created by sofiaserver on 7/6/17.
 *
 * Creates a list of months for a specific year
 *
 */

public class MonthAdapter extends RecyclerView.Adapter<MonthAdapter.MonthViewHolder> {

    public class MonthViewHolder extends RecyclerView.ViewHolder {

        public RecyclerView monthView;
        public TextView label;

        public MonthViewHolder(View view){
            super(view);
            monthView = (RecyclerView)view.findViewById(R.id.calendar_month_date_list);
            label = (TextView)view.findViewById(R.id.calendar_month_label);
        }
    }


    private Calendar mYear;


    public MonthAdapter(Calendar year) {
        this.mYear = year;
    }

    @Override
    public int getItemCount() {
        return mYear.getActualMaximum(Calendar.MONTH);
    }

    public void setYear(Calendar year) {
        mYear = year;
        notifyDataSetChanged();
    }

    @Override
    public MonthViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = (LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.calendar_month, parent, false);


        return new MonthViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MonthViewHolder holder, int position) {
        String monthStr = mYear.getDisplayName(Calendar.MONTH, position, Locale.getDefault());
        DateAdapter adapter = holder.monthView.getAdapter() == null ? new DateAdapter(mYear) : ((DateAdapter)holder.monthView.getAdapter());

        Calendar month = (Calendar)mYear.clone();
        month.set(Calendar.MONTH,position);
        adapter.setMonth(month);



    }


}
