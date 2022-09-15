package com.example.androidgsonapp.network;

import com.example.androidgsonapp.model.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

public interface ApiService {
   /* @FormUrlEncoded
    @POST("userlogin")

*/


    @GET("/posts")
    Call<List<Users>> getData();



}