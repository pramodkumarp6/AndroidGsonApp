package com.example.androidgsonapp.utils;

import android.util.Base64;

public class Constants {
    public  static final String BASE_URL = "https://big-name-interviewe.000webhostapp.com/simple/public/";
    private static final String AUTH = "Basic " + Base64.encodeToString(("user:123456").getBytes(), Base64.NO_WRAP);
    public static final String SHARED_PREF_NAME = "mysharedpref12";



}
