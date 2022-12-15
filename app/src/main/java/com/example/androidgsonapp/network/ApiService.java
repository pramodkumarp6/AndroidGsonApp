package com.example.androidgsonapp.network;

import com.example.androidgsonapp.model.LoginResponse;
import com.example.androidgsonapp.model.RegisterResponse;
import com.example.androidgsonapp.model.UsersInfoDetails;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface ApiService {
    @FormUrlEncoded
    @POST("userlogin")
    Observable<LoginResponse> userLogin(@Field("email") String email,
                                        @Field("password") String password);


    @FormUrlEncoded
    @POST("createuser")
    Observable<RegisterResponse> createUser(@Field("email") String email,
                                            @Field("password") String password,
                                            @Field("name") String name,
                                            @Field("school") String school


    );

    @GET("allusers")
    Observable<UsersInfoDetails>getData();


}