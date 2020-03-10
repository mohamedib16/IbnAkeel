
package com.devmohamedibrahim1997.ibnakeel.model.successResponse;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListAbsenseReport{

    @SerializedName("AbsenseLectures")
    @Expose
    private List<AbsenseLecture> absenseLectures = null;
    @SerializedName("AbsenseSections")
    @Expose
    private List<AbsenseSection> absenseSections = null;

    public List<AbsenseLecture> getAbsenseLectures() {
        return absenseLectures;
    }

    public void setAbsenseLectures(List<AbsenseLecture> absenseLectures) {
        this.absenseLectures = absenseLectures;
    }

    public List<AbsenseSection> getAbsenseSections() {
        return absenseSections;
    }

    public void setAbsenseSections(List<AbsenseSection> absenseSections) {
        this.absenseSections = absenseSections;
    }
}
