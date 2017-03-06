package com.example.anull.applikaatio;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.Contacts.People;




public class ScreenPatientSettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patientsettings);
    }

    /*
        Potilaan testaus painikkeen metodi
     */
    public void testPatient(View view){
        //Tähän määritellään button4-napin (TESTAA) toiminnot
        Intent callIntent = new Intent(Intent.ACTION_CALL);

        EditText num = (EditText) findViewById(R.id.editText2);

        callIntent.setData(Uri.parse("tel:" + num.getText().toString()));

        //Tarkistetaan sovelluksen oikeudet
        if (ActivityCompat.checkSelfPermission(ScreenPatientSettings.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

            //Ei oikeuksia -> Näytetään Toasti edellisellä ruudulla, ja palataan sinne
            Toast.makeText(ScreenPatientSettings.this,
                    "Salli puhelut sovellukselle asetuksista ennen testausta!", Toast.LENGTH_LONG).show();
            return;

        }
        else {
            startActivity(callIntent);
        }

    }



    public void finishPSetup(View view) {

        //Tarkistetaan sovelluksen oikeudet
        if (ActivityCompat.checkSelfPermission(ScreenPatientSettings.this,
                Manifest.permission.WRITE_CONTACTS) != PackageManager.PERMISSION_GRANTED) {

            //Ei oikeuksia -> Näytetään Toasti edellisellä ruudulla, ja palataan sinne
            Toast.makeText(ScreenPatientSettings.this,
                    "Salli kontaktit sovellukselle asetuksista ennen testausta!", Toast.LENGTH_LONG).show();
            return;

        }
        else {
            EditText num = (EditText) findViewById(R.id.editText2) ;

            addContact("nurse", (String)num.getText().toString());

            // siirrytään seuraavaan activityyn
            Intent intent = new Intent(ScreenPatientSettings.this, ScreenPatientFinal.class);
            startActivity(intent);
        }

    }

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



