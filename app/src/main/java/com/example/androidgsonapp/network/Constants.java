package com.example.androidgsonapp.network;

import android.util.Base64;

public class Constants {
    public  static final String BASE_URL = "https://big-name-interviewe.000webhostapp.com/simple/public/";
    private static final String AUTH = "Basic " + Base64.encodeToString(("user:123456").getBytes(), Base64.NO_WRAP);



}
