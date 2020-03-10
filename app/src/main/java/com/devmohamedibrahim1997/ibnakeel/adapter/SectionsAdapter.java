package com.devmohamedibrahim1997.ibnakeel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.devmohamedibrahim1997.ibnakeel.R;
import com.devmohamedibrahim1997.ibnakeel.model.successResponse.AbsenseSection;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SectionsAdapter extends RecyclerView.Adapter<SectionsAdapter.SectionsHolder> {

    private static ClickInterface mClickInterface;
    private Context mContext;
    private List<AbsenseSection> absenseSectionsList;

    public SectionsAdapter(Context context, ClickInterface clickInterface){
        mContext = context;
        mClickInterface = clickInterface;
    }

    @NonNull
    @Override
    public SectionsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SectionsHolder(LayoutInflater.from(mContext).inflate(R.layout.sections_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SectionsHolder holder, int position) {
        AbsenseSection absenseSection = absenseSectionsList.get(position);
        holder.courseName.setText(absenseSection.getCourse().getName());
        holder.noOfRegisterAbsense.setText(String.valueOf(absenseSection.getNoOfRegisterAbsnese()));
        holder.noOfAttendence.setText(String.valueOf(absenseSection.getNoOfAttendence()));
        holder.noOfAbsense.setText(String.valueOf(absenseSection.getNoOfAbsense()));
    }

    @Override
    public int getItemCount() {
        return absenseSectionsList!=null? absenseSectionsList.size():0;
    }

    public void setSections(List<AbsenseSection> absenseSections){
        absenseSectionsList = absenseSections;
        notifyDataSetChanged();
    }


    static class SectionsHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView courseName, noOfRegisterAbsense, noOfAttendence, noOfAbsense;
        SectionsHolder(@NonNull View itemView) {
            super(itemView);
            courseName = itemView.findViewById(R.id.section_CourseName);
            noOfRegisterAbsense = itemView.findViewById(R.id.section_NoOfRegisterAbsense);
            noOfAttendence = itemView.findViewById(R.id.section_NoOfAttendence);
            noOfAbsense = itemView.findViewById(R.id.section_NoOfAbsense);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mClickInterface.onItemClicked(getAdapterPosition());
        }
    }

    public interface ClickInterface {
        void onItemClicked(int position);
    }
}
