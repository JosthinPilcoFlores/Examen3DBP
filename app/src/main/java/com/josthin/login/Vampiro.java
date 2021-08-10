package com.josthin.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Vampiro extends AppCompatActivity implements View.OnClickListener{
    MediaPlayer vampiro, back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vampiro);
        vampiro = MediaPlayer.create(this,R.raw.guapovampiro);
        back = MediaPlayer.create(this,R.raw.back);
        FloatingActionButton back = findViewById(R.id.back4);
        back.setOnClickListener(this);
        vampiro.start();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.back4) {
            vampiro.pause();
            Intent intent = new Intent(Vampiro.this, History.class);
            Toast.makeText(this, "Check our options", Toast.LENGTH_LONG).show();
            back.start();
            startActivity(intent);
            finish();
        }
    }
}