package com.aaxena.kaagaz;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import static android.graphics.Color.BLUE;
import static android.graphics.Color.RED;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Initiating Flash Screen
        fireSplashScreen();
        //FireOnGoingNotifcation
        fireNotification();
    }

    private void fireNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "Kaagaz Wallpaper Service")
                .setSmallIcon(R.drawable.ic_half_moon)
                .setContentTitle("Kaagaz Wallpaper Service Running")
                .setOngoing(true)
                .setColor(BLUE)
                .setColorized(true)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(100, builder.build());
    }

    private void fireSplashScreen() {
        String packageName = getPackageName();
        PowerManager pm = (PowerManager) getSystemService(POWER_SERVICE);
        int splash_screen_time_out = 1980;
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
