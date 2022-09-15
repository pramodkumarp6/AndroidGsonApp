package com.example.androidgsonapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.database.DatabaseUtils;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.androidgsonapp.databinding.ActivityMainBinding;
import com.example.androidgsonapp.network.RetrofitClient;
import com.example.androidgsonapp.viewmodel.MainViewModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;
    private  ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mainViewModel = new  ViewModelProvider(this).get(MainViewModel.class);




        Call<List<Users>> call = RetrofitClient.getInstance().getApi().getData();

        call.enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>>  call, Response<List<Users>> response) {
                    List<Users> d=   response.body();
                   // String  tata = d.get(0).getTitle();

                     //Log.d(d.toString(),"response");
                      /*  GsonBuilder gsonBuilder = new GsonBuilder();
                         Gson gson = gsonBuilder.create();
                         Users[] users = gson.fromJson(tata, Users[].class);
*/
                Gson t =  new  GsonBuilder().setPrettyPrinting().create();
                Log.e("onResponse: ",t.toJson(d) );



            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {

                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });




    }
}