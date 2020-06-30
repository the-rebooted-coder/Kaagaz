package com.aaxena.kaagaz;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import static android.graphics.Color.BLUE;

public class ReminderBroadcast  extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "Reminder")
                .setSmallIcon(R.drawable.ic_half_moon)
                .setContentTitle(context.getString(R.string.half_moon))
                .setContentText("Half Moon is just around the corner")
                .setAutoCancel(true)
                .setColor(BLUE)
                .setColorized(true)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Half Moon is just around the corner, gaze the night sky!"))
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify(200, builder.build());

    }
}