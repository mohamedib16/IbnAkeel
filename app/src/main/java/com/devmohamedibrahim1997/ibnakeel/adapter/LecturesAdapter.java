package com.devmohamedibrahim1997.ibnakeel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.devmohamedibrahim1997.ibnakeel.R;
import com.devmohamedibrahim1997.ibnakeel.model.successResponse.AbsenseLecture;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LecturesAdapter extends RecyclerView.Adapter<LecturesAdapter.LecturesViewHolder> {


    private static ClickInterface mClickInterface;
    private Context mContext;
    private List<AbsenseLecture> mAbsenseLectures;

    public LecturesAdapter(Context context, ClickInterface clickInterface){
        mContext = context;
        mClickInterface = clickInterface;
    }

    @NonNull
    @Override
    public LecturesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LecturesViewHolder(LayoutInflater.from(mContext).inflate(R.layout.lectures_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull LecturesViewHolder holder, int position) {
        AbsenseLecture lecture = mAbsenseLectures.get(position);
        holder.courseName.setText(lecture.getCourse().getName());
        holder.noOfRegisterAbsense.setText(String.valueOf(lecture.getNoOfRegisterAbsnese()));
        holder.noOfAttendence.setText(String.valueOf(lecture.getNoOfAttendence()));
        holder.noOfAbsense.setText(String.valueOf(lecture.getNoOfAbsense()));
    }

    @Override
    public int getItemCount() {
        return mAbsenseLectures!= null? mAbsenseLectures.size():0;
    }

    public void setLectures(List<AbsenseLecture> absenseLectures){
        mAbsenseLectures = absenseLectures;
        notifyDataSetChanged();
    }

    static class LecturesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView courseName, noOfRegisterAbsense, noOfAttendence, noOfAbsense;
        LecturesViewHolder(@NonNull View itemView) {
            super(itemView);
            courseName = itemView.findViewById(R.id.lectures_CourseName);
            noOfRegisterAbsense = itemView.findViewById(R.id.lectures_NoOfRegisterAbsense);
            noOfAttendence = itemView.findViewById(R.id.lectures_NoOfAttendence);
            noOfAbsense = itemView.findViewById(R.id.lectures_NoOfAbsense);
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
