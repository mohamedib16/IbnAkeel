
package com.devmohamedibrahim1997.ibnakeel.model.failureResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FailureResponse {

    @SerializedName("statusCode")
    @Expose
    private Integer statusCode;
    @SerializedName("Data")
    @Expose
    private String data;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
