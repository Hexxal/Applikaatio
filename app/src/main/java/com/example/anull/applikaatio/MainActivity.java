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
    }

    public void setup(View view){
        Intent intent = new Intent(MainActivity.this, Setup.class);
        startActivity(intent);
    }



}
