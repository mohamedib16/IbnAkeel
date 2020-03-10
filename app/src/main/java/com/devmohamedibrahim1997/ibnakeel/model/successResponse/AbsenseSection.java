
package com.devmohamedibrahim1997.ibnakeel.model.successResponse;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AbsenseSection {

    @SerializedName("Course")
    @Expose
    private Course course;
    @SerializedName("Weeks")
    @Expose
    private List<Week> weeks = null;
    @SerializedName("NoOfRegisterAbsnese")
    @Expose
    private Integer noOfRegisterAbsnese;
    @SerializedName("NoOfAttendence")
    @Expose
    private Integer noOfAttendence;
    @SerializedName("NoOfAbsense")
    @Expose
    private Integer noOfAbsense;
    @SerializedName("Hint")
    @Expose
    private Object hint;
    @SerializedName("SectionNo")
    @Expose
    private Integer sectionNo;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Week> getWeeks() {
        return weeks;
    }

    public void setWeeks(List<Week> weeks) {
        this.weeks = weeks;
    }

    public Integer getNoOfRegisterAbsnese() {
        return noOfRegisterAbsnese;
    }

    public void setNoOfRegisterAbsnese(Integer noOfRegisterAbsnese) {
        this.noOfRegisterAbsnese = noOfRegisterAbsnese;
    }

    public Integer getNoOfAttendence() {
        return noOfAttendence;
    }

    public void setNoOfAttendence(Integer noOfAttendence) {
        this.noOfAttendence = noOfAttendence;
    }

    public Integer getNoOfAbsense() {
        return noOfAbsense;
    }

    public void setNoOfAbsense(Integer noOfAbsense) {
        this.noOfAbsense = noOfAbsense;
    }

    public Object getHint() {
        return hint;
    }

    public void setHint(Object hint) {
        this.hint = hint;
    }

    public Integer getSectionNo() {
        return sectionNo;
    }

    public void setSectionNo(Integer sectionNo) {
        this.sectionNo = sectionNo;
    }

}
