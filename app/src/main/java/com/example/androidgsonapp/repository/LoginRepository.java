package com.example.androidgsonapp.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.androidgsonapp.model.LoginResponse;
import com.example.androidgsonapp.model.RegisterResponse;
import com.example.androidgsonapp.network.ApiService;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginRepository {
    private ApiService apiService;

    @Inject
    public LoginRepository(ApiService apiService) {
        this.apiService = apiService;
    }


    private MutableLiveData<LoginResponse>  data = new MutableLiveData<>();
    private MutableLiveData<String>  registerData = new MutableLiveData<>();


         public void login(String email,String password){

             Log.e("login: ",email );
             Log.e("loginPassword: ",password );

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
                             Log.e("onNext: ",response.toString() );
                             data.postValue(loginResponse);


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

    public void registerUser(String email, String password, String name, String school) {
        apiService.createUser(email,password,name,school)
                .subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegisterResponse>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegisterResponse registerResponse) {

                        if(registerResponse ==null){
                            registerData.postValue(registerResponse.getMessage());
                        }else {
                            registerData.postValue(registerResponse.getMessage());

                        }

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public MutableLiveData<String>getRegisterData(){
             return registerData;
    }

}





