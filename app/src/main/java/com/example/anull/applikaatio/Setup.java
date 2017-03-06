package com.example.anull.applikaatio;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Setup extends AppCompatActivity{


    //Seurataan button2 ja button3 painikkeita
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_setup);
    }



    public void settingsPatient(View view){
        Intent intent = new Intent(Setup.this, ScreenPatientSettings.class);
        startActivity(intent);
    }

    public void settingsNurse(View view){
        Intent intent2 = new Intent(Setup.this, ScreenNurseSettings.class);
        startActivity(intent2);
    }


}
