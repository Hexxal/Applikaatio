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

public class ScreenNurseFinal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_nurse_final);
    }

    // SOITTAA POTILAALLE
    public void makeCall(View view) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);

        EditText num = (EditText) findViewById(R.id.editText2);

        callIntent.setData(Uri.parse("tel:" + num.getText().toString()));

        //Tarkistetaan sovelluksen oikeudet
        if (ActivityCompat.checkSelfPermission(ScreenNurseFinal.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

            //Ei oikeuksia -> Näytetään Toasti edellisellä ruudulla, ja palataan sinne
            Toast.makeText(ScreenNurseFinal.this,
                    "Salli puhelut sovellukselle asetuksista ennen testausta!", Toast.LENGTH_LONG).show();
            return;

        } else {
            startActivity(callIntent);
        }
    }

    // OTTAA KUVAN
    public void takePhoto(View view){

    }
}
