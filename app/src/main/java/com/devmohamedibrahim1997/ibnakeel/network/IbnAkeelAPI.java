package com.devmohamedibrahim1997.ibnakeel.network;

import com.devmohamedibrahim1997.ibnakeel.model.User;
import com.devmohamedibrahim1997.ibnakeel.model.successResponse.SuccessResponse;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IbnAkeelAPI {
    @POST("api/UserSecurity/LoginForm")
    Single<SuccessResponse> login(@Body User user);
}
