package com.example.anull.applikaatio;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.content.ContentValues;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.Contacts.People;

public class ScreenNurseSettings extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nursesettings);
    }

    /*
    *   Hoitajan testausnapin toiminnot
    * */
    public void testNurse(View view) {

        //Tarkistetaan sovelluksen oikeudet
        if (ActivityCompat.checkSelfPermission(ScreenNurseSettings.this,
                Manifest.permission.WRITE_CONTACTS) != PackageManager.PERMISSION_GRANTED) {

            //Ei oikeuksia -> Näytetään Toasti edellisellä ruudulla, ja palataan sinne
            Toast.makeText(ScreenNurseSettings.this,
                    "Salli tekstiviestit sovellukselle asetuksista ennen testausta!", Toast.LENGTH_LONG).show();
            return;

        } else {
            EditText num = (EditText) findViewById(R.id.editText);
            int val = Integer.parseInt(num.getText().toString());
            String value = Integer.toString(val);
            Actions.sendSMS(value, "ping");
        }
    }

    /*
     *      Asennuksen viimeistely
     */

        public void finishNSetup(View view){

            EditText num = (EditText) findViewById(R.id.editText);
            addContact("patient", num.getText().toString());

            Intent intent = new Intent(ScreenNurseSettings.this, ScreenNurseFinal.class);
            startActivity(intent);

        }

    /*
    *       TEKSTIVIESTIN KUUNTELU, KESKEN
    * */

    public void BroadcastSMSIntent(View view){
        Intent in = new Intent("BroadcastSMS");

        EditText et = (EditText)findViewById(R.id.editText);

        in.putExtra("nro", (CharSequence)et.getText().toString());
        in.setAction("com.example.anull.applikaatio.BROADCAST_INTENT");
        sendBroadcast(in);
    }

    /*
    *       Kontaktin lisääminen
    * */
    private void addContact(String name, String phone) {
        ContentValues values = new ContentValues();
        values.put(People.NUMBER, phone);
        values.put(People.TYPE, Phone.TYPE_CUSTOM);
        values.put(People.LABEL, name);
        values.put(People.NAME, name);
        Uri dataUri = getContentResolver().insert(People.CONTENT_URI, values);
        Uri updateUri = Uri.withAppendedPath(dataUri, People.Phones.CONTENT_DIRECTORY);
        values.clear();
        values.put(People.Phones.TYPE, People.TYPE_MOBILE);
        values.put(People.NUMBER, phone);
        updateUri = getContentResolver().insert(updateUri, values);
    }

    }

