
package com.devmohamedibrahim1997.ibnakeel.model.successResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Course {

    @SerializedName("Code")
    @Expose
    private String code;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("LevelId")
    @Expose
    private Integer levelId;
    @SerializedName("Hours")
    @Expose
    private Integer hours;
    @SerializedName("IsOpenThisTerm")
    @Expose
    private Boolean isOpenThisTerm;
    @SerializedName("Preq1")
    @Expose
    private String preq1;
    @SerializedName("Preq2")
    @Expose
    private String preq2;
    @SerializedName("Preq3")
    @Expose
    private String preq3;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Boolean getIsOpenThisTerm() {
        return isOpenThisTerm;
    }

    public void setIsOpenThisTerm(Boolean isOpenThisTerm) {
        this.isOpenThisTerm = isOpenThisTerm;
    }

    public String getPreq1() {
        return preq1;
    }

    public void setPreq1(String preq1) {
        this.preq1 = preq1;
    }

    public String getPreq2() {
        return preq2;
    }

    public void setPreq2(String preq2) {
        this.preq2 = preq2;
    }

    public String getPreq3() {
        return preq3;
    }

    public void setPreq3(String preq3) {
        this.preq3 = preq3;
    }

}
