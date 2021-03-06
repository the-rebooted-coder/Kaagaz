package com.aaxena.kaagaz;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.analytics.FirebaseAnalytics;

public class SplashScreen extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Initiating Flash Screen
        fireSplashScreen();
        //G Analytics
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
    }

    private void fireSplashScreen() {
        String packageName = getPackageName();
        PowerManager pm = (PowerManager) getSystemService(POWER_SERVICE);
        int splash_screen_time_out = 2100;
        new Handler().postDelayed(() -> {
            if (pm.isIgnoringBatteryOptimizations(packageName)) {
                Intent i = new Intent(SplashScreen.this, DeployedChooser.class);
                startActivity(i);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
            } 
            else {
                Intent i = new Intent(SplashScreen.this, WelcomeActivity.class);
                startActivity(i);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
            }
        }, splash_screen_time_out);
    }
}
