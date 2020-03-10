
package com.devmohamedibrahim1997.ibnakeel.model.successResponse;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StudentAutomaticRegister {

    @SerializedName("StaffRegisterName")
    @Expose
    private String staffRegisterName;
    @SerializedName("DoctorRegisterName")
    @Expose
    private String doctorRegisterName;
    @SerializedName("OptionalCoursesPassedNo")
    @Expose
    private Integer optionalCoursesPassedNo;
    @SerializedName("CoursesToRegisterLevel1")
    @Expose
    private List<CoursesToRegisterLevel1> coursesToRegisterLevel1 = null;
    @SerializedName("CoursesToRegisterLevel2")
    @Expose
    private List<CoursesToRegisterLevel2> coursesToRegisterLevel2 = null;
    @SerializedName("CoursesToRegisterLevel3")
    @Expose
    private List<CoursesToRegisterLevel3> coursesToRegisterLevel3 = null;
    @SerializedName("CoursesToRegisterLevel4")
    @Expose
    private List<CoursesToRegisterLevel4> coursesToRegisterLevel4 = null;
    @SerializedName("CoursesToRegisterLevel5")
    @Expose
    private List<CoursesToRegisterLevel5> coursesToRegisterLevel5 = null;
    @SerializedName("CoursesToRegisterLevel6")
    @Expose
    private List<Object> coursesToRegisterLevel6 = null;

    public String getStaffRegisterName() {
        return staffRegisterName;
    }

    public void setStaffRegisterName(String staffRegisterName) {
        this.staffRegisterName = staffRegisterName;
    }

    public String getDoctorRegisterName() {
        return doctorRegisterName;
    }

    public void setDoctorRegisterName(String doctorRegisterName) {
        this.doctorRegisterName = doctorRegisterName;
    }

    public Integer getOptionalCoursesPassedNo() {
        return optionalCoursesPassedNo;
    }

    public void setOptionalCoursesPassedNo(Integer optionalCoursesPassedNo) {
        this.optionalCoursesPassedNo = optionalCoursesPassedNo;
    }

    public List<CoursesToRegisterLevel1> getCoursesToRegisterLevel1() {
        return coursesToRegisterLevel1;
    }

    public void setCoursesToRegisterLevel1(List<CoursesToRegisterLevel1> coursesToRegisterLevel1) {
        this.coursesToRegisterLevel1 = coursesToRegisterLevel1;
    }

    public List<CoursesToRegisterLevel2> getCoursesToRegisterLevel2() {
        return coursesToRegisterLevel2;
    }

    public void setCoursesToRegisterLevel2(List<CoursesToRegisterLevel2> coursesToRegisterLevel2) {
        this.coursesToRegisterLevel2 = coursesToRegisterLevel2;
    }

    public List<CoursesToRegisterLevel3> getCoursesToRegisterLevel3() {
        return coursesToRegisterLevel3;
    }

    public void setCoursesToRegisterLevel3(List<CoursesToRegisterLevel3> coursesToRegisterLevel3) {
        this.coursesToRegisterLevel3 = coursesToRegisterLevel3;
    }

    public List<CoursesToRegisterLevel4> getCoursesToRegisterLevel4() {
        return coursesToRegisterLevel4;
    }

    public void setCoursesToRegisterLevel4(List<CoursesToRegisterLevel4> coursesToRegisterLevel4) {
        this.coursesToRegisterLevel4 = coursesToRegisterLevel4;
    }

    public List<CoursesToRegisterLevel5> getCoursesToRegisterLevel5() {
        return coursesToRegisterLevel5;
    }

    public void setCoursesToRegisterLevel5(List<CoursesToRegisterLevel5> coursesToRegisterLevel5) {
        this.coursesToRegisterLevel5 = coursesToRegisterLevel5;
    }

    public List<Object> getCoursesToRegisterLevel6() {
        return coursesToRegisterLevel6;
    }

    public void setCoursesToRegisterLevel6(List<Object> coursesToRegisterLevel6) {
        this.coursesToRegisterLevel6 = coursesToRegisterLevel6;
    }

}
