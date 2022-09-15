package com.example.androidgsonapp.network;

import android.util.Base64;

public class Constants {
    public  static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    private static final String AUTH = "Basic " + Base64.encodeToString(("user:123456").getBytes(), Base64.NO_WRAP);

}
