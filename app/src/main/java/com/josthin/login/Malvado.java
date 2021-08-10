package com.josthin.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Malvado extends AppCompatActivity implements View.OnClickListener{
    MediaPlayer malvado, back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_malvado);
        malvado = MediaPlayer.create(this,R.raw.malvado);
        back = MediaPlayer.create(this,R.raw.back);
        FloatingActionButton back = findViewById(R.id.back3);
        back.setOnClickListener(this);
        malvado.start();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.back3) {
            malvado.pause();
            Intent intent = new Intent(Malvado.this, History.class);
            Toast.makeText(this, "Check our options", Toast.LENGTH_LONG).show();
            back.start();
            startActivity(intent);
            finish();
        }
    }
}