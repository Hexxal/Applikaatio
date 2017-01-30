package com.example.anull.applikaatio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Screen2 extends AppCompatActivity implements View.OnClickListener {

    //Seurataan button2 ja button3 painikkeita
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondscreen);

        Button one = (Button) findViewById(R.id.button2);
        one.setOnClickListener(this);
        Button two = (Button) findViewById(R.id.button3);
        two.setOnClickListener(this);
        //findViewById(R.id.button2).setOnClickListener(new Screen2.handleButton());
        //findViewById(R.id.button3).setOnClickListener(new Screen2.handleButton());
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button2:
                Intent intent = new Intent(Screen2.this, ScreenPatientSettings.class);
                startActivity(intent);
                break;
            case R.id.button3:
                Intent intent2 = new Intent(Screen2.this, ScreenNurseSettings.class);
                startActivity(intent2);
                break;
            default:
                break;
        }

    }

    //Kun button2 tai button3 painetaan, vaihdetaan näkymää (KESKEN)
    class handleButton implements View.OnClickListener {
        public void onClick(View v) {
            //Intent intent = new Intent(Screen2.this, ScreenNurseSettings.class);
            //startActivity(intent);
        }

    }
}
