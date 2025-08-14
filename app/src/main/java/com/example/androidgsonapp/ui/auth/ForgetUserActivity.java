package com.example.androidgsonapp.ui.auth;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidgsonapp.R;

import dagger.hilt.android.AndroidEntryPoint;


@AndroidEntryPoint
public class ForgetUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_user);

    }
}