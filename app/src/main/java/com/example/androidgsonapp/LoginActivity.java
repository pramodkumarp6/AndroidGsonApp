package com.example.androidgsonapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import com.example.androidgsonapp.databinding.ActivityLoginBinding;
import com.example.androidgsonapp.databinding.ActivityMainBinding;
import com.example.androidgsonapp.viewmodel.MainViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class LoginActivity extends AppCompatActivity {
    private MainViewModel mainViewModel;
    private ActivityLoginBinding binding ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        Login();

        binding.textViewSignUp.setOnClickListener(view->{
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
        });


    }
    public void Login(){
        binding.editTextEmail.getText().toString();
        binding.editTextPassword.getText().toString();
    }
}