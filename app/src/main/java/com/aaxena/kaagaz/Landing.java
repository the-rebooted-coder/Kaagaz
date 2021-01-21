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

        Button starter = findViewById(R.id.starter);
        starter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    String manufacturer = android.os.Build.MANUFACTURER;
                    if ("xiaomi".equalsIgnoreCase(manufacturer)) {
                        intent.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity"));
                        startActivity(intent);
                    } else if ("oppo".equalsIgnoreCase(manufacturer)) {
                        intent.setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.permission.startup.StartupAppListActivity"));
                        startActivity(intent);
                    } else if ("vivo".equalsIgnoreCase(manufacturer)) {
                        intent.setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.BgStartUpManagerActivity"));
                        startActivity(intent);
                    } else {
                        Toast.makeText(Landing.this,"Restart Kaagaz Now",Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(Landing.this, R.string.err_msg, Toast.LENGTH_LONG).show();
                }
            }
        });

        //Checker Fun
        final Button checker = findViewById(R.id.checker);
        checker.setOnClickListener(v -> {
            String packageName = getPackageName();
            PowerManager pm = (PowerManager) getSystemService(POWER_SERVICE);
            if (!pm.isIgnoringBatteryOptimizations(packageName)){
                Toast.makeText(Landing.this, R.string.err_not_opt,Toast.LENGTH_SHORT).show();
            }
            else {
                Vibrator v8 = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                v8.vibrate(26);
                Toast.makeText(Landing.this, R.string.sucsful,Toast.LENGTH_SHORT).show();
                Intent i=new Intent(Landing.this,DeployedChooser.class);
                startActivity(i);
                finish();
            }
        });
    }
    private void determineManufacture() {
        Button extra = findViewById(R.id.extra_ins);
        TextView ro_device = findViewById(R.id.mobile_make);
        String ro_build = android.os.Build.MANUFACTURER;
        if ("xiaomi".equalsIgnoreCase(ro_build)) {
            ro_device.setText(R.string.xiaomi);
            extra.setVisibility(View.VISIBLE);
            extra.setOnClickListener(v -> {
                Toast.makeText(Landing.this, "Go to Battery Saver then tap 'No Restrictions'", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Vibrator v8 = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                v8.vibrate(25);
                Uri uri = Uri.fromParts("package", getPackageName(), null);
                intent.setData(uri);
                startActivity(intent);
            });
        } else if ("oppo".equalsIgnoreCase(ro_build)) {
            ro_device.setText(R.string.oppo);
            extra.setVisibility(View.VISIBLE);
            extra.setOnClickListener(v -> {
                Toast.makeText(Landing.this, "Find Battery Exclusions and turn them off", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Vibrator v8 = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                v8.vibrate(25);
                Uri uri = Uri.fromParts("package", getPackageName(), null);
                intent.setData(uri);
                startActivity(intent);
            });
        } else if ("vivo".equalsIgnoreCase(ro_build)) {
            ro_device.setText(R.string.vivo);
            extra.setVisibility(View.VISIBLE);
            extra.setOnClickListener(v -> {
                Toast.makeText(Landing.this, "Open iManager and Grant Battery Exclusion", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Vibrator v8 = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                v8.vibrate(25);
                Uri uri = Uri.fromParts("package", getPackageName(), null);
                intent.setData(uri);
                startActivity(intent);
            });
        }
        else {
            Toast.makeText(this,"Cannot configure Kaagaz on your device, please contact developer at connectwithspandan@gmail.com",Toast.LENGTH_LONG).show();
        }
    }
}
