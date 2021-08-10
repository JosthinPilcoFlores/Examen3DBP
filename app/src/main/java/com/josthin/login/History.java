package com.josthin.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class History extends AppCompatActivity implements View.OnClickListener{
    MediaPlayer next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        next = MediaPlayer.create(this,R.raw.next);
        Button btnMalvado = findViewById(R.id.malvado);
        Button btnAcampar = findViewById(R.id.acampar);
        Button btnVampiro = findViewById(R.id.vampiro);
        Button btnTeo = findViewById(R.id.teo);
        btnAcampar.setOnClickListener(this);
        btnMalvado.setOnClickListener(this);
        btnVampiro.setOnClickListener(this);
        btnTeo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.acampar:
                Intent i = new Intent(History.this, Acampar.class);
                Toast.makeText(this,"Welcome to ChatBot", Toast.LENGTH_LONG).show();
                next.start();
                startActivity(i);
                break;
            case R.id.malvado:
                Intent i2 = new Intent(History.this, Malvado.class);
                Toast.makeText(this,"Welcome to ChatBot", Toast.LENGTH_LONG).show();
                next.start();
                startActivity(i2);
                break;
            case R.id.vampiro:
                Intent i3 = new Intent(History.this, Vampiro.class);
                Toast.makeText(this,"Welcome to ChatBot", Toast.LENGTH_LONG).show();
                next.start();
                startActivity(i3);
                break;
            case R.id.teo:
                Intent i4 = new Intent(History.this, Teo.class);
                Toast.makeText(this,"Welcome to ChatBot", Toast.LENGTH_LONG).show();
                next.start();
                startActivity(i4);
                break;
        }
    }
}