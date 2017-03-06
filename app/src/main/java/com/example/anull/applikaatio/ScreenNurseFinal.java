package com.example.anull.applikaatio;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class ScreenNurseFinal extends Activity {

    int TAKE_PHOTO_CODE = 0;
    public static int count = 0;
    final String dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/picFolder/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_nurse_final);

        // Here, we are making a folder named picFolder to store
        // pics taken by the camera using this application.
        final String dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/picFolder/";
        File newdir = new File(dir);
        newdir.mkdirs();
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

        String file = dir+".jpg";
        File newfile = new File(file);
        try {
            newfile.createNewFile();
        }
        catch (IOException e)
        {
        }

        Uri outputFileUri = Uri.fromFile(newfile);

        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);

        startActivityForResult(cameraIntent, TAKE_PHOTO_CODE);
    }
}
