package com.example.androidgsonapp.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.androidgsonapp.data.remote.ApiService;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;


@HiltViewModel
public class SplashViewmodel extends ViewModel {
    private final ApiService apiService;

    @Inject
    public SplashViewmodel(ApiService apiService) {
        this.apiService = apiService;
    }
}