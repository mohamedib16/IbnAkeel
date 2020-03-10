package com.devmohamedibrahim1997.ibnakeel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.devmohamedibrahim1997.ibnakeel.R;
import com.devmohamedibrahim1997.ibnakeel.model.successResponse.Week;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.DetailsViewHolder> {


    private Context mContext;
    private List<Week> mWeeks;

    public DetailsAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public DetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DetailsViewHolder(LayoutInflater.from(mContext).inflate(R.layout.week_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsViewHolder holder, int position) {
        Week week = mWeeks.get(position);
        holder.week_no.setText(String.valueOf(week.getWeekNo()));

        String flag;
        if(week.getWeekFlag() != null && week.getWeekFlag().equals("true")){
            flag = "حضور";
        }else if(week.getWeekFlag() != null && week.getWeekFlag().equals("false")){
            flag = "غياب";
        }else {
            flag = "لم يتم الرصد";
        }

        holder.week_flag.setText(flag);
    }

    @Override
    public int getItemCount() {
        return mWeeks != null ? mWeeks.size() : 0;
    }

    public void setWeeks(List<Week> Weeks) {
        mWeeks = Weeks;
        notifyDataSetChanged();
    }

    static class DetailsViewHolder extends RecyclerView.ViewHolder {
        TextView week_no, week_flag;
        DetailsViewHolder(@NonNull View itemView) {
            super(itemView);
            week_no = itemView.findViewById(R.id.week_num);
            week_flag = itemView.findViewById(R.id.week_flag);
        }
    }
}