package com.example.androidgsonapp.data.repository;


import com.example.androidgsonapp.data.remote.ApiService;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SpashRepository {
    private final ApiService apiService;

    @Inject
    public SpashRepository(ApiService apiService) {
        this.apiService = apiService;
    }



}
