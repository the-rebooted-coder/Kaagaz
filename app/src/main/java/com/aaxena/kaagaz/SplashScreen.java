package com.aaxena.kaagaz;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import static android.graphics.Color.BLUE;
import static android.graphics.Color.GRAY;
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
        createOngoingChannel();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "ongoing")
                .setSmallIcon(R.drawable.ic_half_moon)
                .setContentTitle("Wallpaper Service Running")
                .setOngoing(true)
                .setColor(GRAY)
                .setColorized(true)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(150, builder.build());
    }

    private void createOngoingChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Persistent Wallpaper Service";
            String description = "Channel to prevent app from killing";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("ongoing", name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
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
