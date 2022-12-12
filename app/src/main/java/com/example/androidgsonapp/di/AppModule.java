package com.example.androidgsonapp.di;

import com.example.androidgsonapp.network.ApiService;
import com.example.androidgsonapp.network.Constants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {



    @Singleton
    @Provides
    public ApiService getRetrofitInstance(Retrofit retrofit) {
        return retrofit.create(ApiService.class);

    }
    @Singleton
    @Provides
    public Retrofit getinstance() {
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();


    }

}