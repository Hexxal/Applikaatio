package com.example.anull.applikaatio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Screen2 extends AppCompatActivity {

    //Seurataan button2 ja button3 painikkeita
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondscreen);
        findViewById(R.id.button2).setOnClickListener(new Screen2.handleButton());
        findViewById(R.id.button3).setOnClickListener(new Screen2.handleButton());
    }

    //Kun button2 tai button3 painetaan, vaihdetaan näkymää (KESKEN)
    class handleButton implements View.OnClickListener {
        public void onClick(View v) {
            Intent intent = new Intent(Screen2.this, ScreenNurseSettings.class);
            startActivity(intent);
        }

    }
}
