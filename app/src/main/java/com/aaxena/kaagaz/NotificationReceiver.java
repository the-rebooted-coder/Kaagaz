package com.aaxena.kaagaz;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class NotificationReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (AlarmService.AppConstant.STOP_ACTION.equals(action)) {
            Intent it = new Intent(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
            context.sendBroadcast(it);
            Toast.makeText(context, "STOP CALLED", Toast.LENGTH_SHORT).show();
        }
    }
}