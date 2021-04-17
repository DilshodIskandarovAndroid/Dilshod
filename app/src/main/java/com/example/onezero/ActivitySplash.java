package com.example.onezero;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;
import maes.tech.intentanim.CustomIntent;

public class ActivitySplash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    protected void onStart() {
        super.onStart();
        EasySplashScreen config = new EasySplashScreen(ActivitySplash.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(100)
                .withBackgroundResource(android.R.color.white)
                .withBeforeLogoText("PenCod");

        config.getBeforeLogoTextView().setTextColor(Color.RED);
        config.getBeforeLogoTextView().setTextSize(40);


        View easySplashScreenView = config.create();
        setContentView(easySplashScreenView);
        CustomIntent.customType(ActivitySplash.this, "right-to-left");
    }
}