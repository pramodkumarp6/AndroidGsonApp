package com.example.androidgsonapp.ui.auth;


import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.androidgsonapp.R;
import com.example.androidgsonapp.databinding.ActivityMainBinding;
import com.example.androidgsonapp.utils.Toaster;
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





        binding.buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Register();
            }
        });

        mainViewModel.getRegisterData().observe(this, new Observer<String>() {

            @Override
            public void onChanged(String s) {
                Toaster.simpleToaster(MainActivity.this,s);

            }
        });

        mainViewModel.RegisterValid().observe(this, new Observer<String>() {

            @Override
            public void onChanged(String s) {
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void Register() {
        String  email = binding.editTextEmail.getText().toString();
        String  password= binding.editTextPassword.getText().toString();
        String  name = binding.editName.getText().toString();
        String  school = binding.editTextSchool.getText().toString();

        mainViewModel.createRegister(email,password,name,school);

    }



}
