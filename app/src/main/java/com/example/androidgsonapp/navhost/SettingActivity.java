package com.example.androidgsonapp.navhost;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.androidgsonapp.R;

import dagger.hilt.android.AndroidEntryPoint;


@AndroidEntryPoint
public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }
}