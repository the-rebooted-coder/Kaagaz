package com.aaxena.kaagaz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Initiating Flash Screen
        fireSplashScreen();
    }

    private void fireSplashScreen() {
        int splash_screen_time_out = 2000;
        new Handler().postDelayed(() -> {
            Intent i=new Intent(SplashScreen.this,WelcomeActivity.class);
            startActivity(i);
            finish();
        }, splash_screen_time_out);
    }
}
