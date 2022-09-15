package com.example.androidgsonapp;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.Json;
import com.squareup.moshi.ToJson;

public class UserAdapter {
    @ToJson
    public void fullname(){
        String title;
        int userId;

    }
    @FromJson
    public void getTitle(){
         String  name;
         int userid;
    }
}



