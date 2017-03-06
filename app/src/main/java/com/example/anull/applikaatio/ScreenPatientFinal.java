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

public class ScreenPatientFinal extends AppCompatActivity {

    private static final int CAMERA_REQUEST = 1888;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_patient_final);
    }

    public void makeAlarm(){
        //Tekstiviesti
        Actions.sendSMS(getResources().getString(R.string.saved_number), "Hälytys");

        //kuva
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);
        //Soitto
        Intent callIntent = new Intent(Intent.ACTION_CALL);

        EditText num = (EditText) findViewById(R.id.editText2) ;

        callIntent.setData(Uri.parse("tel:" + num));

        //Tarkistetaan sovelluksen oikeudet
        if (ActivityCompat.checkSelfPermission(ScreenPatientFinal.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

            //Ei oikeuksia -> Näytetään Toasti edellisellä ruudulla, ja palataan sinne
            Toast.makeText(ScreenPatientFinal.this,
                    "Salli puhelut sovellukselle asetuksista ennen testausta!", Toast.LENGTH_LONG).show();


        }
        else {
            startActivity(callIntent);
        }
    }

    public void newSetup(View view){
        Intent intent = new Intent(ScreenPatientFinal.this, MainActivity.class);
        startActivity(intent);
    }
}
