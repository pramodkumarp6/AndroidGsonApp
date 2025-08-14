package com.example.androidgsonapp.data.remote;

import com.example.androidgsonapp.data.model.LoginResponse;
import com.example.androidgsonapp.data.model.RegisterResponse;
import com.example.androidgsonapp.data.model.UsersInfoDetails;

import io.reactivex.Observable;
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