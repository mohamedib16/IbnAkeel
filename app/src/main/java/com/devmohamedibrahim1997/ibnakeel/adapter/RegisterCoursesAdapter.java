package com.devmohamedibrahim1997.ibnakeel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.devmohamedibrahim1997.ibnakeel.R;
import com.devmohamedibrahim1997.ibnakeel.model.successResponse.CoursesToRegisterLevel1;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RegisterCoursesAdapter extends RecyclerView.Adapter<RegisterCoursesAdapter.RegisteredCoursesViewHolder> {

    private Context mContext;
    private List<CoursesToRegisterLevel1> registeredCoursesList;

    public RegisterCoursesAdapter(Context context){
        mContext = context;
    }
    @NonNull
    @Override
    public RegisteredCoursesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RegisteredCoursesViewHolder(LayoutInflater.from(mContext).inflate(R.layout.registered_courses_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RegisteredCoursesViewHolder holder, int position) {
        CoursesToRegisterLevel1 registeredCourse = registeredCoursesList.get(position);
        holder.reg_name.setText(registeredCourse.getCourse().getName());
        holder.reg_code.setText(String.valueOf(registeredCourse.getCourse().getCode()));
        holder.reg_hours.setText(String.valueOf(registeredCourse.getCourse().getHours()));
        holder.reg_grade.setText(registeredCourse.getGrade());
    }

    @Override
    public int getItemCount() {
        return registeredCoursesList!=null? registeredCoursesList.size():0;
    }

    public void setRegisteredCourses(List<CoursesToRegisterLevel1> registeredCourses){
        registeredCoursesList = registeredCourses;
        notifyDataSetChanged();
    }

    static class RegisteredCoursesViewHolder extends RecyclerView.ViewHolder{
        TextView reg_name, reg_code, reg_hours, reg_grade;
        RegisteredCoursesViewHolder(@NonNull View itemView) {
            super(itemView);
            reg_name = itemView.findViewById(R.id.registered_course_name);
            reg_code = itemView.findViewById(R.id.registered_course_code);
            reg_hours = itemView.findViewById(R.id.registered_course_total_hours);
            reg_grade = itemView.findViewById(R.id.registered_course_grade);
        }
    }
}
