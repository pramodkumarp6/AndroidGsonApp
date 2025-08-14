package com.example.androidgsonapp.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.androidgsonapp.data.remote.ApiService;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class LoginViewModel extends ViewModel {

    private final ApiService apiService;


    @Inject
    public LoginViewModel(ApiService apiService) {
        this.apiService = apiService;
    }
}
