package com.aaxena.kaagaz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.Vibrator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Checker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        String packageName = getPackageName();
        PowerManager pm = (PowerManager) getSystemService(POWER_SERVICE);
        if (!pm.isIgnoringBatteryOptimizations(packageName)){
            Intent i=new Intent(Checker.this,Landing.class);
            startActivity(i);
            finish();
        }
        else {
            Vibrator v8 = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            v8.vibrate(26);
            Intent i=new Intent(Checker.this,MainActivity.class);
            startActivity(i);
            finish();
        }
    }
}
