package com.example.androidgsonapp.repository;


import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.androidgsonapp.model.LoginResponse;
import com.example.androidgsonapp.model.User;
import com.example.androidgsonapp.network.ApiService;
import com.example.androidgsonapp.preference.SharedPrefManager;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainRepository {
    private ApiService apiService;

    @Inject
    public MainRepository(ApiService apiService) {
        this.apiService = apiService;
    }


    private MutableLiveData<LoginResponse>  data = new MutableLiveData<>();


         public void login(String email,String password){
             Log.e("login: ",email );
             Log.e("login: ",password );

             apiService.userLogin(email,password)
                 .subscribeOn(Schedulers.io())
                 .subscribeOn(AndroidSchedulers.mainThread())
                     .subscribe(new Observer<LoginResponse>() {
                         @Override
                         public void onSubscribe(Disposable d) {

                         }

                         @Override
                         public void onNext(LoginResponse response) {
                             LoginResponse loginResponse = response;

                             data.postValue(loginResponse);


                          /*   if(!loginResponse.isError()){
                                 SharedPrefManager.getInstance().saveUser(response.getUser());

                                 data.postValue(loginResponse.getUser().toString());

                             }else {
                                 data.postValue(loginResponse.getMessage());

                             }*/




                         }

                         @Override
                         public void onError(Throwable e) {

                         }

                         @Override
                         public void onComplete() {

                         }
                     });

         }

    public MutableLiveData<LoginResponse> getData() {
        return data;
    }
}





