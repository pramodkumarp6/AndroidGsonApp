package com.example.androidgsonapp.viewmodel;

import android.text.TextUtils;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androidgsonapp.model.LoginResponse;
import com.example.androidgsonapp.repository.MainRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class RegisterViewModel extends ViewModel {
    private final MainRepository mainRepository;
    public LiveData<LoginResponse>loginData;
    private final MutableLiveData<String>  valid = new MutableLiveData<>();
    private MutableLiveData<String>  Registervalid = new MutableLiveData<>();







    @Inject
    public RegisterViewModel(MainRepository mainRepository) {
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

    public MutableLiveData<String> getRegistervalid() {
        return Registervalid;
    }

    public void setRegistervalid(MutableLiveData<String> registervalid) {
        Registervalid = registervalid;
    }
}
