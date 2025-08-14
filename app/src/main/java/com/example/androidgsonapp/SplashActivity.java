package com.example.androidgsonapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

import dagger.hilt.android.AndroidEntryPoint;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;


@AndroidEntryPoint
public class SplashActivity extends AppCompatActivity {
    private Disposable splashDisposable;
    private static final int SPLASH_DELAY = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        splashDisposable = Completable.timer(SPLASH_DELAY, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    finish();
                });
    }

    @Override
    protected void onDestroy() {
        if (splashDisposable != null && !splashDisposable.isDisposed()) {
            splashDisposable.dispose();
        }
        super.onDestroy();
    }






    }
