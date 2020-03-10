
package com.devmohamedibrahim1997.ibnakeel.model.successResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CoursesToRegisterLevel3 {

    @SerializedName("Course")
    @Expose
    private Course course;
    @SerializedName("IsRegistered")
    @Expose
    private Boolean isRegistered;
    @SerializedName("Grade")
    @Expose
    private Object grade;
    @SerializedName("Tooltip")
    @Expose
    private Object tooltip;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Boolean getIsRegistered() {
        return isRegistered;
    }

    public void setIsRegistered(Boolean isRegistered) {
        this.isRegistered = isRegistered;
    }

    public Object getGrade() {
        return grade;
    }

    public void setGrade(Object grade) {
        this.grade = grade;
    }

    public Object getTooltip() {
        return tooltip;
    }

    public void setTooltip(Object tooltip) {
        this.tooltip = tooltip;
    }

}
