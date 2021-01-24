package com.aaxena.kaagaz;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootCompletedIntentReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
            Intent pushIntent = new Intent(context, AlarmService.class);
            context.startService(pushIntent);
        }
}
