package com.example.anull.applikaatio;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity{


    //Seurataan button2 ja button3 painikkeita
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        SharedPreferences sp = this.getPreferences(Context.MODE_PRIVATE);
        String defaultvalue = getResources().getString(R.string.default_value);
        String num = sp.getString("saved_number", defaultvalue);

        Log.d("NUM: ",  num);
        if(num.equals("0")){
            setContentView(R.layout.activity_main);
        }
        else{
            setContentView(R.layout.activity_screen_patient_final);
        }
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
