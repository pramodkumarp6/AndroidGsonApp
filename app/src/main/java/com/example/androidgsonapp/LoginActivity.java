package com.example.androidgsonapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.androidgsonapp.databinding.ActivityLoginBinding;
import com.example.androidgsonapp.model.LoginResponse;
import com.example.androidgsonapp.navhost.DashBoardActivity;
import com.example.androidgsonapp.preference.SharedPrefManager;
import com.example.androidgsonapp.viewmodel.MainViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class LoginActivity extends AppCompatActivity {
    private MainViewModel mainViewModel;
    private ActivityLoginBinding binding ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        if (SharedPrefManager.getInstance(LoginActivity.this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, DashBoardActivity.class));
        }


        binding.buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login();
            }
        });


        binding.textViewSignUp.setOnClickListener(view -> {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
        });



    mainViewModel.loginData().observe(this, new Observer<LoginResponse>() {
        @Override
        public void onChanged(LoginResponse loginResponse) {

            if(!loginResponse.isError()){
                SharedPrefManager.getInstance(LoginActivity.this).saveUser(loginResponse.getUser());

                Intent intent = new Intent(new Intent(LoginActivity.this, DashBoardActivity.class));

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }else {

            }

            Toast.makeText(LoginActivity.this, loginResponse.getMessage(), Toast.LENGTH_SHORT).show();



        }
    });

    }

    public void Login(){
      String email=  binding.textemail.getText().toString();
      String password =   binding.textpassword.getText().toString();

        mainViewModel.createLogin(email,password);







    }



    }
