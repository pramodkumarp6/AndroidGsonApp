package com.example.androidgsonapp.viewmodel;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androidgsonapp.model.LoginResponse;
import com.example.androidgsonapp.repository.MainRepository;

import java.io.Closeable;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainViewModel extends ViewModel {
    private MainRepository mainRepository;
    public LiveData<LoginResponse>loginData;
    private MutableLiveData<String>  valid = new MutableLiveData<>();
    private MutableLiveData<String>  Registervalid = new MutableLiveData<>();







    @Inject
    public MainViewModel(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }



    public LiveData<String> getValid() {
        return valid;
    }



    public void createLogin(String email, String password) {


        if (TextUtils.isEmpty(email)){
            valid.setValue("Email Is required");
            return;
        }
        if (TextUtils.isEmpty(password)) {
            valid.setValue("password  Is required");
            return;
        }

        mainRepository.login(email,password);
    }

    public LiveData<LoginResponse>loginData(){

        return mainRepository.getData();


    }

    public void createRegister(String email, String password, String name, String school) {
        mainRepository.registerUser(email,password,name,school);

        if (TextUtils.isEmpty(email)){
            valid.setValue("Email Is required");
            return;
        }
        if (TextUtils.isEmpty(password)) {
            valid.setValue("password  Is required");
            return;
        }
        if (TextUtils.isEmpty(name)){
            valid.setValue("Name Is required");
            return;
        }
        if (TextUtils.isEmpty(school)) {
            valid.setValue("School  Is required");
            return;
        }
    }



    public MutableLiveData<String>getRegisterData(){
        return mainRepository.getRegisterData();
    }
    public LiveData<String> RegisterValid() {
        return valid;
    }
}
