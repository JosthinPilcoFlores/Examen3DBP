package com.josthin.login;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Teo extends AppCompatActivity implements View.OnClickListener{
    MediaPlayer teo,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teo);
        teo = MediaPlayer.create(this,R.raw.teo);
        back = MediaPlayer.create(this, R.raw.back);
        FloatingActionButton back = findViewById(R.id.back5);
        back.setOnClickListener(this);
        teo.start();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.back5) {
            teo.pause();
            Intent intent = new Intent(Teo.this, History.class);
            Toast.makeText(this, "Check our options", Toast.LENGTH_LONG).show();
            back.start();
            startActivity(intent);
            finish();
        }
    }
}