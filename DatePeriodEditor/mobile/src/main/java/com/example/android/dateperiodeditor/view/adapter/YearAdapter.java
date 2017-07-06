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

public class YearAdapter extends RecyclerView.Adapter<YearAdapter.YearViewHolder> {

    public class YearViewHolder extends RecyclerView.ViewHolder {

        public TextView yearLabel;
        public RecyclerView monthsList;

        public YearViewHolder(View view) {
            super(view);
            yearLabel = (TextView)view.findViewById(R.id.calendar_year_label);
            monthsList = (RecyclerView)view.findViewById(R.id.calendar_year_months_list);
        }
    }


    private int mFirstYear;
    private int mLastYear;


    public YearAdapter(int firstYear, int lastYear){
        super();
        this.mFirstYear = firstYear;
        this.mLastYear = lastYear;
    }

    @Override
    public YearViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = (LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.calendar_year, parent, false);

        return new YearViewHolder(view);
    }

    @Override
    public void onBindViewHolder(YearViewHolder holder, int position) {

        holder.yearLabel.setText(String.valueOf(mFirstYear + position));

        MonthAdapter monthAdapter = holder.monthsList.getAdapter() == null ? null : (MonthAdapter)holder.monthsList.getAdapter();

        Calendar year = Calendar.getInstance();

        year.set(Calendar.YEAR,mFirstYear+position);

        if(monthAdapter == null) {
            monthAdapter = new MonthAdapter(year);
            holder.monthsList.setAdapter(monthAdapter);
        }else {
            monthAdapter.setYear(year);
        }

    }

    @Override
    public int getItemCount() {
        return mLastYear - mFirstYear + 1;
    }
}
