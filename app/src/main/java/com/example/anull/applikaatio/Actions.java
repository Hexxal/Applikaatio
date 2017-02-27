package com.example.anull.applikaatio;

import android.telephony.SmsManager;

/**
 * Created by Antti on 27.2.2017.
 */

public class Actions {

    public static void sendSMS(String phoneNumber, String message) {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, null, null);
    }

}


