package com.example.androidgsonapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.androidgsonapp.databinding.ActivityLoginBinding;
import com.example.androidgsonapp.model.LoginResponse;
import com.example.androidgsonapp.navhost.DashBoardActivity;
import com.example.androidgsonapp.preference.SharedPrefManager;
import com.example.androidgsonapp.utils.Toaster;
import com.example.androidgsonapp.viewmodel.MainViewModel;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class LoginActivity extends AppCompatActivity {
    private MainViewModel mainViewModel;
    private ActivityLoginBinding binding;
    @Inject
    public SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        if (sharedPrefManager.getInstance(LoginActivity.this).isLoggedIn()) {
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

                if (!loginResponse.isError()) {
                    sharedPrefManager.getInstance(LoginActivity.this).saveUser(loginResponse.getUser());

                    Intent intent = new Intent(new Intent(LoginActivity.this, DashBoardActivity.class));

                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                } else {
                    Toaster.simpleToaster(LoginActivity.this, loginResponse.getMessage());
                }
            }
        });


        mainViewModel.getValid().observe(this, new Observer<String>() {

            @Override
            public void onChanged(String s) {
                Toast.makeText(LoginActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void Login() {
        String email = binding.textemail.getText().toString();
        String password = binding.textpassword.getText().toString();
        Log.e( "Login: ",email );
        mainViewModel.createLogin(email, password);


    }


}
