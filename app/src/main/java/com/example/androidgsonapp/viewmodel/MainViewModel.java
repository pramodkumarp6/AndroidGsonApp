package com.example.androidgsonapp.viewmodel;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainViewModel extends ViewModel {
     @Inject

    public MainViewModel() {
    }
}
