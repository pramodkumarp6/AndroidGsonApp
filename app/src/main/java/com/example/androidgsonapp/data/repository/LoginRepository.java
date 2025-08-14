package com.example.androidgsonapp.data.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.androidgsonapp.data.local.AppDatabase;
import com.example.androidgsonapp.data.model.LoginResponse;
import com.example.androidgsonapp.data.model.RegisterResponse;
import com.example.androidgsonapp.data.remote.ApiService;
import com.example.androidgsonapp.data.local.SharedPrefManager;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
@Singleton
public class LoginRepository {
    private final ApiService apiService;
    private  SharedPrefManager sharedPrefManager;
    private  AppDatabase appDatabase;
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final MutableLiveData<LoginResponse>  data = new MutableLiveData<>();
    private final MutableLiveData<String>  registerData = new MutableLiveData<>();
    private final MutableLiveData<String> errorData = new MutableLiveData<>();


    @Inject
    public LoginRepository(ApiService apiService) {
        this.apiService = apiService;
    }




         public void login(String email,String password){

             Log.e("login: ",email );
             Log.e("loginPassword: ",password );

             apiService.userLogin(email,password)

                 .subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                     .subscribe(new Observer<LoginResponse>() {
                         @Override
                         public void onSubscribe(Disposable d) {
                             disposables.add(d);
                         }

                         @Override
                         public void onNext(LoginResponse response) {
                             Log.e("onNext: ",response.toString() );
                             data.postValue(response);


                         }

                         @Override
                         public void onError(Throwable e) {
                             Log.e("Login Error", e.getMessage(), e);
                             errorData.postValue(e.getMessage());
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





