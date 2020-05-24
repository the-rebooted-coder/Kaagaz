package com.aaxena.kaagaz;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.Vibrator;
import android.provider.Settings;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Landing extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_landing);
        //Determining Manufacturer
        determineManufacture();

        //Checker Fun
        final Button checker = findViewById(R.id.checker);
        checker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String packageName = getPackageName();
                PowerManager pm = (PowerManager) getSystemService(POWER_SERVICE);
                if (!pm.isIgnoringBatteryOptimizations(packageName)){
                    Toast.makeText(Landing.this, R.string.err_not_opt,Toast.LENGTH_SHORT).show();
                }
                else {
                    Vibrator v8 = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    v8.vibrate(26);
                    Toast.makeText(Landing.this, R.string.sucsful,Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(Landing.this,SplashScreen.class);
                    startActivity(i);
                    finish();
                }
            }
        });

        Button starter = findViewById(R.id.starter);
        starter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrator v8 = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                v8.vibrate(25);
                try {
                    Intent intent = new Intent();
                    String manufacturer = android.os.Build.MANUFACTURER;
                    if ("xiaomi".equalsIgnoreCase(manufacturer)) {
                        intent.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity"));
                        startActivity(intent);
                        checker.setVisibility(View.VISIBLE);
                    } else if ("oppo".equalsIgnoreCase(manufacturer)) {
                        intent.setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.permission.startup.StartupAppListActivity"));
                        startActivity(intent);
                        checker.setVisibility(View.VISIBLE);
                    } else if ("vivo".equalsIgnoreCase(manufacturer)) {
                        intent.setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.BgStartUpManagerActivity"));
                        startActivity(intent);
                        checker.setVisibility(View.VISIBLE);
                    } else {
                        Intent i = new Intent(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
                        i.setData(Uri.parse("package:" + getPackageName()));
                        startActivity(i);
                        checker.setVisibility(View.VISIBLE);
                    }
                } catch (Exception e) {
                    Toast.makeText(Landing.this, R.string.err_msg, Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void determineManufacture() {
        Button extra = findViewById(R.id.extra_ins);
        TextView ro_device = findViewById(R.id.device_ro_details);
        String ro_build = android.os.Build.MANUFACTURER;
        if ("xiaomi".equalsIgnoreCase(ro_build)) {
            ro_device.setText(R.string.xiaomi);
            extra.setVisibility(View.VISIBLE);
            extra.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(Landing.this, "Go to Battery Saver", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    Vibrator v8 = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    v8.vibrate(25);
                    Uri uri = Uri.fromParts("package", getPackageName(), null);
                    intent.setData(uri);
                    startActivity(intent);
                }
            });
        } else if ("oppo".equalsIgnoreCase(ro_build)) {
            ro_device.setText(R.string.oppo);
            extra.setVisibility(View.VISIBLE);
            extra.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(Landing.this, "Find Battery Exclusions", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    Vibrator v8 = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    v8.vibrate(25);
                    Uri uri = Uri.fromParts("package", getPackageName(), null);
                    intent.setData(uri);
                    startActivity(intent);
                }
            });
        } else if ("vivo".equalsIgnoreCase(ro_build)) {
            ro_device.setText(R.string.vivo);
            extra.setVisibility(View.VISIBLE);
            extra.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(Landing.this, "Find Battery Exclusions", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    Vibrator v8 = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    v8.vibrate(25);
                    Uri uri = Uri.fromParts("package", getPackageName(), null);
                    intent.setData(uri);
                    startActivity(intent);
                }
            });
        }
    }
}
