package com.aaxena.kaagaz;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
    public static final String BATTERY_PREF = "sharedPrefs";
    public static final String STAT = "text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_landing);
        //Determining Manufacturer

        determineManufacture();

        Button starter = findViewById(R.id.starter);
        starter.setOnClickListener(v -> {
            try {
                Intent intent = new Intent();
                String manufacturer = android.os.Build.MANUFACTURER;
                if ("xiaomi".equalsIgnoreCase(manufacturer)) {
                    Vibrator v8 = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    v8.vibrate(26);
                    Toast.makeText(this,"Turn on Kaagaz",Toast.LENGTH_SHORT).show();
                    intent.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity"));
                    startActivity(intent);
                }
                else if ("Letv".equalsIgnoreCase(manufacturer)) {
                intent.setComponent(new ComponentName("com.letv.android.letvsafe",
                        "com.letv.android.letvsafe.AutobootManageActivity"));
                startActivity(intent);
                }
                else if ("oppo".equalsIgnoreCase(manufacturer)) {
                    Vibrator v8 = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    v8.vibrate(26);
                    try {
                        intent.setClassName("com.coloros.safecenter",
                                "com.coloros.safecenter.permission.startup.StartupAppListActivity");
                        startActivity(intent);
                    } catch (Exception e) {
                        try {
                            intent.setClassName("com.oppo.safe",
                                    "com.oppo.safe.permission.startup.StartupAppListActivity");
                            startActivity(intent);
                        } catch (Exception ex) {
                            try {
                                intent.setClassName("com.coloros.safecenter",
                                        "com.coloros.safecenter.startupapp.StartupAppListActivity");
                                startActivity(intent);
                            } catch (Exception exx) {
                                exx.printStackTrace();
                            }
                        }
                    }
                } else if ("vivo".equalsIgnoreCase(manufacturer)) {
                    Vibrator v8 = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    v8.vibrate(26);
                    try {
                        intent.setComponent(new ComponentName("com.iqoo.secure",
                                "com.iqoo.secure.ui.phoneoptimize.AddWhiteListActivity"));
                        startActivity(intent);
                    } catch (Exception e) {
                        try {
                            intent.setComponent(new ComponentName("com.vivo.permissionmanager",
                                    "com.vivo.permissionmanager.activity.BgStartUpManagerActivity"));
                            startActivity(intent);
                        } catch (Exception ex) {
                            try {
                                intent.setClassName("com.iqoo.secure",
                                        "com.iqoo.secure.ui.phoneoptimize.BgStartUpManager");
                                startActivity(intent);
                            } catch (Exception exx) {
                                ex.printStackTrace();
                            }
                        }
                    }
                } else {
                    Toast.makeText(Landing.this,"Restart Kaagaz Now",Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                Toast.makeText(Landing.this, R.string.err_msg, Toast.LENGTH_LONG).show();
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
                SharedPreferences preferences = getSharedPreferences(BATTERY_PREF,MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(STAT,"true");
                editor.commit();
                Toast.makeText(Landing.this, R.string.sucsful,Toast.LENGTH_SHORT).show();
                Intent i=new Intent(Landing.this,DeployedChooser.class);
                startActivity(i);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
            }
        });
    }
    private void determineManufacture() {
        Vibrator v8 = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v8.vibrate(26);
        Button extra = findViewById(R.id.extra_ins);
        TextView ro_device = findViewById(R.id.mobile_make);
        String ro_build = android.os.Build.MANUFACTURER;
        if ("xiaomi".equalsIgnoreCase(ro_build)) {
            ro_device.setText(R.string.xiaomi);
            extra.setVisibility(View.VISIBLE);
            extra.setOnClickListener(v -> {
                Toast.makeText(Landing.this, "Go to Battery Saver then tap 'No Restrictions'", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Vibrator v9 = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                v9.vibrate(25);
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
                Vibrator v10 = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                v10.vibrate(25);
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
                Vibrator v11 = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                v11.vibrate(25);
                Uri uri = Uri.fromParts("package", getPackageName(), null);
                intent.setData(uri);
                startActivity(intent);
            });
        }
        else if("Letv".equalsIgnoreCase(ro_build)){
            ro_device.setText(R.string.letv);
            extra.setVisibility(View.VISIBLE);
            extra.setOnClickListener(v -> {
                Toast.makeText(Landing.this, "Find Battery Saver, if not available proceed to next step", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Vibrator v11 = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                v11.vibrate(25);
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
