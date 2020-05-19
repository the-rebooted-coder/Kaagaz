package com.aaxena.kaagaz;

import android.app.Service;
import android.app.WallpaperManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.widget.Toast;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AlarmService extends Service {
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";
    private String hello;
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        loadPerfs();
        if (hello.contains("mojave")) {
            //Setting Wallpaper for Mojave Desert
            setWallpaperMojave();
        }
        else{
            //Setting Wallpaper for Beach Side
            setWallpaperBeach();
        }
        return START_STICKY;
    }

    private void loadPerfs() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        hello = sharedPreferences.getString(TEXT,"mojave");
    }

    private void setWallpaperBeach() {

        Calendar c = Calendar.getInstance();
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

        if (timeOfDay >= 0 && timeOfDay < 01) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.seventeen_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 01 && timeOfDay < 02) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.seventeen_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 02 && timeOfDay < 03) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.seventeen_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 03 && timeOfDay < 04) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.fifteen_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 04 && timeOfDay < 05) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.fifteen_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 05 && timeOfDay < 06) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.sixteen_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 06 && timeOfDay < 07) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.one_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 07 && timeOfDay < 8) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.one_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 8 && timeOfDay < 9) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.two_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 9 && timeOfDay < 10) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.three_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 10 && timeOfDay < 11) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.four_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 11 && timeOfDay < 12) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.five_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 12 && timeOfDay < 13) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.six_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 13 && timeOfDay < 14) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.seven_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 14 && timeOfDay < 15) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.eight_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 15 && timeOfDay < 16) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.nine_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 16 && timeOfDay < 17) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ten_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 17 && timeOfDay < 18) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.eleven_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 18 && timeOfDay < 19) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.twelve_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 19 && timeOfDay < 20) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.thirteen_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 20 && timeOfDay < 21) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.fifteen_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 21 && timeOfDay < 22) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.fourteen_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 22 && timeOfDay < 23) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.seventeen_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 23 && timeOfDay < 24) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.seventeen_two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void setWallpaperMojave() {

        Calendar c = Calendar.getInstance();
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

        if (timeOfDay >= 0 && timeOfDay < 01) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.one);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 01 && timeOfDay < 02) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 02 && timeOfDay < 03) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.three);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 03 && timeOfDay < 04) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.four);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 04 && timeOfDay < 05) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.five);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 05 && timeOfDay < 06) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.six);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 06 && timeOfDay < 07) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.seven);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 07 && timeOfDay < 8) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.seven);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 8 && timeOfDay < 9) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.eight);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 9 && timeOfDay < 10) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.nine);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 10 && timeOfDay < 11) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ten);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 11 && timeOfDay < 12) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ten);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 12 && timeOfDay < 13) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.eleven);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 13 && timeOfDay < 14) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.twelve);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 14 && timeOfDay < 15) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.thirteen);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 15 && timeOfDay < 16) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.thirteen);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 16 && timeOfDay < 17) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.fourteen);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 17 && timeOfDay < 18) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.fifteen);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 18 && timeOfDay < 19) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.sixteen);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 19 && timeOfDay < 20) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.four);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 20 && timeOfDay < 21) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.three);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 21 && timeOfDay < 22) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.two);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 22 && timeOfDay < 23) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.one);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } else if (timeOfDay >= 23 && timeOfDay < 24) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.one);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        }
    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
