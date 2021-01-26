package com.aaxena.kaagaz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.pedromassango.doubleclick.DoubleClick;
import com.pedromassango.doubleclick.DoubleClickListener;

import java.util.Set;

import static com.aaxena.kaagaz.AlarmService.SHARED_PREFS;
import static com.aaxena.kaagaz.AlarmService.TEXT;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Button devButton = findViewById(R.id.devButton);
        devButton.setOnClickListener(v -> {
            Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE) ;
            vibe.vibrate(20);
            Toast.makeText(getApplicationContext(),"App Developed by One Silicon Diode ;)",Toast.LENGTH_SHORT).show();
        });
        
        Button nope = findViewById(R.id.nope);
        nope.setOnClickListener(v -> {
            Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE) ;
            vibe.vibrate(20);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            finish();
        });

        Button aboutDeveloper = findViewById(R.id.developerName);
        aboutDeveloper.setOnClickListener(v -> {
            Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE) ;
            vibe.vibrate(25);
            String url = "https://spandansaxena.codes/";
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
            builder.setToolbarColor(Color.parseColor("#1B1557"));
            CustomTabsIntent customTabsIntent = builder.build();
            builder.setShowTitle(true);
            customTabsIntent.launchUrl(Settings.this, Uri.parse(url));
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });
        
        Button yes = findViewById(R.id.yes);
        yes.setOnClickListener(new DoubleClick(new DoubleClickListener() {
            @Override
            public void onSingleClick(View view) {
                Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE) ;
                vibe.vibrate(15);
                Toast.makeText(getApplicationContext(),"Tap Twice to Stop",Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onDoubleClick(View view) {
                Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE) ;
                vibe.vibrate(20);
                Toast.makeText(getApplicationContext(),"Wallpaper Service Stopped",Toast.LENGTH_SHORT).show();
                SharedPreferences preferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(TEXT, "null");
                editor.commit();
                stopService(new Intent(Settings.this, AlarmService.class));
                finish();
            }
        }));
    }
}