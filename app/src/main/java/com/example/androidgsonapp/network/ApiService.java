package com.example.androidgsonapp.network;

import com.example.androidgsonapp.model.UsersERt;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface ApiService {
  /* @FormUrlEncoded
    @POST("userlogin")


   @FormUrlEncoded
   @POST("userlogin")

*/

    @GET("/posts")
    Call<List<UsersERt>> getData();



}