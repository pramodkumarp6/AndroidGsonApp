package com.example.androidgsonapp.repository;

import com.example.androidgsonapp.api.ApiService;

import javax.inject.Inject;

public class DashBoardRepository {
    private ApiService apiService;

    @Inject
    public DashBoardRepository(ApiService apiService) {
        this.apiService = apiService;
    }

}
