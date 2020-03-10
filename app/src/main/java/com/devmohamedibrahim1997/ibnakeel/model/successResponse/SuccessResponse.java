
package com.devmohamedibrahim1997.ibnakeel.model.successResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SuccessResponse {

    @SerializedName("statusCode")
    @Expose
    private Integer statusCode;
    @SerializedName("Data")
    @Expose
    private Object data;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
