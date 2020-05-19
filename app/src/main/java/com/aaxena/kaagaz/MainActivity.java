package com.aaxena.kaagaz;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent launchIntent = new Intent(this, AlarmService.class);
        PendingIntent alarmIntent = PendingIntent.getService(this, 0, launchIntent, 0);


        AlarmManager manager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
                Toast.makeText(this, "Welcome to Kaagaz, Wallpaper Service Started, Wallpaper Will be Delivered in moments", Toast.LENGTH_LONG).show();
                Calendar c = Calendar.getInstance();
                c.set(Calendar.HOUR_OF_DAY, 12);
                c.add(Calendar.SECOND,10);
                manager.setRepeating(AlarmManager.RTC, c.getTimeInMillis(), AlarmManager.INTERVAL_HOUR, alarmIntent);
        finish();
    }
}
