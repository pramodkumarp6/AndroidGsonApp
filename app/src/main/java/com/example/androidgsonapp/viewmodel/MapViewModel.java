package com.example.androidgsonapp.viewmodel;


import androidx.lifecycle.ViewModel;

import com.example.androidgsonapp.repository.MapRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MapViewModel extends ViewModel {

    private MapRepository mapRepository;


    @Inject
    public MapViewModel(MapRepository mapRepository) {
        this.mapRepository = mapRepository;
    }
}
