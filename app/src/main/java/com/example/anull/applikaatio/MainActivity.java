package com.example.anull.applikaatio;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    //Kun ohjelman ensimmäinen View (MainActivity.java) avataan,
    //asetetaan OnClickListener seuraamaan nappia 'button'
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new handleButton());
    }

    //Kun nappia button klikataan, vaihdetaan View MainActivitystä Screen2:een
    class handleButton implements View.OnClickListener {
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, Screen2.class);
            startActivity(intent);
        }

    }
}