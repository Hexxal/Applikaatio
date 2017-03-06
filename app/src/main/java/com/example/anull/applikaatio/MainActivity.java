package com.example.anull.applikaatio;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.widget.AdapterView;

public class MainActivity extends AppCompatActivity{


    //Seurataan button2 ja button3 painikkeita
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        /*
        String num = "asd";

        Log.d("NUM: ", "string");
        if(num.equals("0")){
            setContentView(R.layout.activity_main);
        }
        else{
            setContentView(R.layout.activity_screen_patient_final);
        }
        */
    }

    public void settingsPatient(View view){
        Intent intent = new Intent(MainActivity.this, ScreenPatientSettings.class);
        startActivity(intent);
    }

    public void settingsNurse(View view){
        Intent intent2 = new Intent(MainActivity.this, ScreenNurseSettings.class);
        startActivity(intent2);
    }


}
