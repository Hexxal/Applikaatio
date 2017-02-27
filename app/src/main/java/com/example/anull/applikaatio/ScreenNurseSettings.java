package com.example.anull.applikaatio;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.id.message;
import static com.example.anull.applikaatio.R.id.editText;
import static com.example.anull.applikaatio.R.id.textView2;
import static com.example.anull.applikaatio.R.id.textView3;

public class ScreenNurseSettings extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nursesettings);

        //Testaa nappi
        Button five = (Button) findViewById(R.id.button6);
        five.setOnClickListener(this);
        //Ota käyttöön nappi
        Button six = (Button) findViewById(R.id.button7);
        six.setOnClickListener(this);
        }

    /*      Siirretty Actions.java Classiin.

        private void sendSMS(String phoneNumber, String message) {
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(phoneNumber, null, message, null, null);
        }
    */

    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button6:
                //Tähän määritellään button4-napin (TESTAA) toiminnot


                //Tarkistetaan sovelluksen oikeudet
                if (ActivityCompat.checkSelfPermission(ScreenNurseSettings.this,
                        Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {

                    //Ei oikeuksia -> Näytetään Toasti edellisellä ruudulla, ja palataan sinne
                    Toast.makeText(ScreenNurseSettings.this,
                            "Salli tekstiviestit sovellukselle asetuksista ennen testausta!", Toast.LENGTH_LONG).show();
                    return;

                }
                else {
                    EditText num = (EditText) findViewById(R.id.editText) ;
                    int val = Integer.parseInt( num.getText().toString() );
                    String value = Integer.toString(val);
                    Actions.sendSMS(value, "ping");
                }



                break;
            case R.id.button7:
                //Tähän button5-toiminnot (OTA KÄYTTÖÖN)
                Intent intent4 = new Intent(ScreenNurseSettings.this, ScreenNurseFinal.class);
                startActivity(intent4);
                break;
            default:
                break;
        }

    }

    public void BroadcastSMSIntent(View view){
        Intent in = new Intent("BroadcastSMS");

        EditText et = (EditText)findViewById(R.id.editText);

        in.putExtra("message", "Nurse Test");
        in.setAction("com.example.anull.applikaatio.BROADCAST_INTENT");
        sendBroadcast(in);
    }


    }

