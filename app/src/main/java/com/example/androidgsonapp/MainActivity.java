package com.example.androidgsonapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.androidgsonapp.databinding.ActivityMainBinding;
import com.example.androidgsonapp.viewmodel.MainViewModel;

import dagger.hilt.android.AndroidEntryPoint;


@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        Register();
    }

    private void Register() {
        binding.editTextEmail.getText().toString();
        binding.editTextPassword.getText().toString();
        binding.editName.getText().toString();
        binding.editTextSchool.getText().toString();

    }

}
