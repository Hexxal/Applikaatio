package com.example.anull.applikaatio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Antti on 27.2.2017.
 */

public class AppBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub

        // Extract data included in the Intent
        CharSequence intentData = intent.getCharSequenceExtra("message");
        //Toast.makeText(context, "message: "+intentData, Toast.LENGTH_LONG).show();

        Actions.sendSMS("0451298258", intentData.toString());
    }
}
