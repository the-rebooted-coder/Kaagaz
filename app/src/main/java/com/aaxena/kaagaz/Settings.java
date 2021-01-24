package com.aaxena.kaagaz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
    }
}