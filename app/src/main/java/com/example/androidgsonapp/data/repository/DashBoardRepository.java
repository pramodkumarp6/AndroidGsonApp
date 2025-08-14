package com.example.androidgsonapp.data.repository;

import com.example.androidgsonapp.data.remote.ApiService;

import javax.inject.Inject;

public class DashBoardRepository {
    private ApiService apiService;

    @Inject
    public DashBoardRepository(ApiService apiService) {
        this.apiService = apiService;
    }

}
