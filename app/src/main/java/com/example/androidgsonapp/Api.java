package com.example.androidgsonapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("/posts")
    Call<List<Users>> getData();



}