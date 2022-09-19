package com.example.androidgsonapp.repository;


import com.example.androidgsonapp.network.ApiServiceImpl;

import javax.inject.Inject;

public class MainRepository {
    private ApiServiceImpl apiService;

    @Inject
    public MainRepository(ApiServiceImpl apiService) {
        this.apiService = apiService;
    }
}





