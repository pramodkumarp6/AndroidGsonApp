package com.example.androidgsonapp.viewmodel;
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




    @Inject
    public MainViewModel(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }







    public void createLogin(String email, String password) {

        mainRepository.login(email,password);
    }

    public LiveData<LoginResponse>loginData(){

        return mainRepository.getData();


    }
}
