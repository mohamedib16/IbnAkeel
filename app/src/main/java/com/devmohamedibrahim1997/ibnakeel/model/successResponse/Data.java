package com.devmohamedibrahim1997.ibnakeel.model.successResponse;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data implements Parcelable {

    @SerializedName("SitNo")
    @Expose
    private Integer sitNo;
    @SerializedName("Year")
    @Expose
    private Integer year;
    @SerializedName("StName")
    @Expose
    private String stName;
    @SerializedName("Grade")
    @Expose
    private String grade;
    @SerializedName("Gpa")
    @Expose
    private Double gpa;
    @SerializedName("Hours")
    @Expose
    private Integer hours;
    @SerializedName("Token")
    @Expose
    private String token;
    @SerializedName("Department")
    @Expose
    private Department department;
    @SerializedName("Level")
    @Expose
    private Level level;
    @SerializedName("Status")
    @Expose
    private Status status;
    @SerializedName("ListRegisterCourses")
    @Expose
    private Object listRegisterCourses;
    @SerializedName("StudentAutomaticRegister")
    @Expose
    private StudentAutomaticRegister studentAutomaticRegister;
    @SerializedName("ListAbsenseReport")
    @Expose
    private ListAbsenseReport listAbsenseReport;

    private Data(Parcel in) {
        if (in.readByte() == 0) {
            sitNo = null;
        } else {
            sitNo = in.readInt();
        }
        if (in.readByte() == 0) {
            year = null;
        } else {
            year = in.readInt();
        }
        stName = in.readString();
        grade = in.readString();
        if (in.readByte() == 0) {
            gpa = null;
        } else {
            gpa = in.readDouble();
        }
        if (in.readByte() == 0) {
            hours = null;
        } else {
            hours = in.readInt();
        }
        token = in.readString();
    }

    public static final Creator<Data> CREATOR = new Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };

    public Integer getSitNo() {
        return sitNo;
    }

    public void setSitNo(Integer sitNo) {
        this.sitNo = sitNo;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Object getListRegisterCourses() {
        return listRegisterCourses;
    }

    public void setListRegisterCourses(Object listRegisterCourses) {
        this.listRegisterCourses = listRegisterCourses;
    }

    public StudentAutomaticRegister getStudentAutomaticRegister() {
        return studentAutomaticRegister;
    }

    public void setStudentAutomaticRegister(StudentAutomaticRegister studentAutomaticRegister) {
        this.studentAutomaticRegister = studentAutomaticRegister;
    }

    public ListAbsenseReport getListAbsenseReport() {
        return listAbsenseReport;
    }

    public void setListAbsenseReport(ListAbsenseReport listAbsenseReport) {
        this.listAbsenseReport = listAbsenseReport;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        if (sitNo == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(sitNo);
        }
        if (year == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(year);
        }
        parcel.writeString(stName);
        parcel.writeString(grade);
        if (gpa == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(gpa);
        }
        if (hours == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(hours);
        }
        parcel.writeString(token);
    }
}
