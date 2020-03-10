
package com.devmohamedibrahim1997.ibnakeel.model.successResponse;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Week implements Parcelable {

    @SerializedName("WeekNo")
    @Expose
    private Integer weekNo;
    @SerializedName("WeekFlag")
    @Expose
    private Object weekFlag;

    protected Week(Parcel in) {
        if (in.readByte() == 0) {
            weekNo = null;
        } else {
            weekNo = in.readInt();
        }
    }

    public static final Creator<Week> CREATOR = new Creator<Week>() {
        @Override
        public Week createFromParcel(Parcel in) {
            return new Week(in);
        }

        @Override
        public Week[] newArray(int size) {
            return new Week[size];
        }
    };

    public Integer getWeekNo() {
        return weekNo;
    }

    public void setWeekNo(Integer weekNo) {
        this.weekNo = weekNo;
    }

    public Object getWeekFlag() {
        return weekFlag;
    }

    public void setWeekFlag(Object weekFlag) {
        this.weekFlag = weekFlag;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        if (weekNo == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(weekNo);
        }
    }
}
