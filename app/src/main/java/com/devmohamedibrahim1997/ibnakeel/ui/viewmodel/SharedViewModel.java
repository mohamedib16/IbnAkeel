package com.devmohamedibrahim1997.ibnakeel.ui.viewmodel;

import com.devmohamedibrahim1997.ibnakeel.model.User;
import com.devmohamedibrahim1997.ibnakeel.model.failureResponse.FailureResponse;
import com.devmohamedibrahim1997.ibnakeel.model.successResponse.Data;
import com.devmohamedibrahim1997.ibnakeel.model.successResponse.SuccessResponse;
import com.devmohamedibrahim1997.ibnakeel.model.successResponse.Week;
import com.devmohamedibrahim1997.ibnakeel.network.APIClient;
import com.devmohamedibrahim1997.ibnakeel.network.IbnAkeelAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.Objects;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SharedViewModel extends ViewModel {
    private MutableLiveData<Data> successResponseLiveData = new MutableLiveData<>();
    private MutableLiveData<String> failureMessageLiveData = new MutableLiveData<>();
    private MutableLiveData<List<Week>> weeksLiveData = new MutableLiveData<>();
    private MutableLiveData<String> actionBarTitleLiveData = new MutableLiveData<>();

    public MutableLiveData<String> login(String userId, String userPassword) {
        APIClient.getInstance()
                .create(IbnAkeelAPI.class)
                .login(new User(userId, userPassword))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<SuccessResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onSuccess(SuccessResponse response) {
                        if (response != null) {
                            Gson gson = new GsonBuilder().create();
                            if (response.getStatusCode() == 200) {
                                Data data = gson.fromJson(gson.toJson(response.getData()), Data.class);
                                successResponseLiveData.postValue(data);
                                failureMessageLiveData.setValue("success");

                            } else if (response.getStatusCode() == 204) {
                                FailureResponse failureResponse = gson.fromJson(gson.toJson(response), FailureResponse.class);
                                String data = failureResponse.getData();
                                failureMessageLiveData.setValue(data);
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (e != null && Objects.requireNonNull(e.getMessage()).contains("Failed to connect to")) {
                            failureMessageLiveData.setValue("تأكد من الاتصال بالانترنت وأعد المحاولة!");
                        }else{
                            failureMessageLiveData.setValue(e != null ? e.getMessage() : null);
                        }
                    }
                });

        return failureMessageLiveData;
    }

    public LiveData<Data> getSuccessResponseLiveData() {
        return successResponseLiveData;
    }

    public MutableLiveData<List<Week>> getWeeksLiveData() {
        return weeksLiveData;
    }

    public void setWeeks(List<Week> weeks) {
        weeksLiveData.setValue(weeks);
    }

    public MutableLiveData<String> getActionBarTitleLiveData() {
        return actionBarTitleLiveData;
    }

    public void setActionBarTitle(String courseName) {
        actionBarTitleLiveData.setValue(courseName);
    }
}
