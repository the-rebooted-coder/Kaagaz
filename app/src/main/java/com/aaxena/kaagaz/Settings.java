package com.aaxena.kaagaz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Button devButton = findViewById(R.id.devButton);
        devButton.setOnClickListener(v -> Toast.makeText(getApplicationContext(),"App Developed by One Silicon Diode",Toast.LENGTH_LONG).show());
    }
}