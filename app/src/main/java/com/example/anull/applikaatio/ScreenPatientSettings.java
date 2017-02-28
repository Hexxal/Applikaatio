package com.example.anull.applikaatio;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ScreenPatientSettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patientscreen);

    }

    /*
        Potilaan testaus painikkeen metodi
     */
    public void testPatient(View view){
        //Tähän määritellään button4-napin (TESTAA) toiminnot
        Intent callIntent = new Intent(Intent.ACTION_CALL);

        EditText num = (EditText) findViewById(R.id.editText2) ;

        callIntent.setData(Uri.parse("tel:" + num));

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



    public void finishSetup(View view) {
        //Tähän button5-toiminnot (OTA KÄYTTÖÖN)
        SharedPreferences sp = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        EditText num = (EditText) findViewById(R.id.editText2) ;

        editor.putString("saved_number", (String)num.getText().toString());
        editor.commit();

        // siirrytään seuraavaan activityyn
        Intent intent = new Intent(ScreenPatientSettings.this, ScreenPatientFinal.class);
        startActivity(intent);
    }



    }



