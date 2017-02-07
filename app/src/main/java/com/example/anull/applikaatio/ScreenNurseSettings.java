package com.example.anull.applikaatio;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ScreenNurseSettings extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nursesettings);

        //Testaa nappi
        Button five = (Button) findViewById(R.id.button4);
        five.setOnClickListener(this);
        //Ota käyttöön nappi
        Button six = (Button) findViewById(R.id.button5);
        six.setOnClickListener(this);
        }


    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button4:
                //Tähän määritellään button4-napin (TESTAA) toiminnot
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:0400896942"));

                //Tarkistetaan sovelluksen oikeudet
                if (ActivityCompat.checkSelfPermission(ScreenNurseSettings.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                    //Ei oikeuksia -> Näytetään Toasti edellisellä ruudulla, ja palataan sinne
                    Toast.makeText(ScreenNurseSettings.this,
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

