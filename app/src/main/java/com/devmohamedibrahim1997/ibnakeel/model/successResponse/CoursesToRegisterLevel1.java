
package com.devmohamedibrahim1997.ibnakeel.model.successResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CoursesToRegisterLevel1 {

    @SerializedName("Course")
    @Expose
    private Course course;
    @SerializedName("IsRegistered")
    @Expose
    private Boolean isRegistered;
    @SerializedName("Grade")
    @Expose
    private String grade;
    @SerializedName("Tooltip")
    @Expose
    private String tooltip;

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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getTooltip() {
        return tooltip;
    }

    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }

}
