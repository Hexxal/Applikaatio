package com.example.anull.applikaatio;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ScreenPatientSettings extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patientscreen);
        //Testaa nappi
        Button three = (Button) findViewById(R.id.button4);
        three.setOnClickListener(this);
        //Ota käyttöön nappi
        Button four = (Button) findViewById(R.id.button5);
        four.setOnClickListener(this);

    }

    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button4:
                //Tähän määritellään button4-napin (TESTAA) toiminnot
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:0400896942"));

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



                break;
            case R.id.button5:
                //Tähän button5-toiminnot (OTA KÄYTTÖÖN)
                break;
            default:
                break;
        }

    }


}
