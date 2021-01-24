package com.aaxena.kaagaz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.pedromassango.doubleclick.DoubleClick;
import com.pedromassango.doubleclick.DoubleClickListener;

import java.util.Set;

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
            finish();
        });
        
        Button yes = findViewById(R.id.yes);
        yes.setOnClickListener(new DoubleClick(new DoubleClickListener() {
            @Override
            public void onSingleClick(View view) {
                Toast.makeText(getApplicationContext(),"Tap Again to Stop Service",Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onDoubleClick(View view) {
                stopService(new Intent(Settings.this, AlarmService.class));
                finish();
            }
        }));
    }
}