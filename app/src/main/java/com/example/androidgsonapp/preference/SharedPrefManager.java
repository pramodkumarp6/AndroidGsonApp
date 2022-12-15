package com.example.androidgsonapp.preference;

import static com.example.androidgsonapp.utils.Constants.SHARED_PREF_NAME;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.androidgsonapp.LoginActivity;
import com.example.androidgsonapp.model.User;

import javax.inject.Inject;

import dagger.hilt.android.qualifiers.ApplicationContext;

public class SharedPrefManager{

private static SharedPrefManager mInstance;
private  Context mCtx;




@Inject
public SharedPrefManager(@ApplicationContext Context mCtx) {
        this.mCtx = mCtx;
        }



public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
        mInstance = new SharedPrefManager(context);
        }
        return mInstance;
        }


public void saveUser(User user) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt("id", user.getId());
        int i = user.getId();
        Log.e(String.valueOf(i),"Shared");
        editor.putString("email", user.getEmail());
        editor.putString("name", user.getName());


        Log.e(user.getEmail(),"Sharedemail");
        editor.putString("school", user.getSchool());
        Log.e(user.getSchool(),"SharedSchool");

        editor.apply();
        editor.commit();
        }




public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt("id", -1) != -1;
        }


public User getUser() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new User(
        sharedPreferences.getInt("id", -1),
        sharedPreferences.getString("email", null),
        sharedPreferences.getString("name", null),
        sharedPreferences.getString("school", null)

        );
        }


public void logout() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        mCtx.startActivity(new Intent(mCtx, LoginActivity.class));
        }


        }
