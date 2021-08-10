package com.josthin.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Acampar extends AppCompatActivity implements View.OnClickListener{
    MediaPlayer acampar, next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acampar);
        next = MediaPlayer.create(this,R.raw.next);
        FloatingActionButton back = findViewById(R.id.back2);
        acampar = MediaPlayer.create(this,R.raw.acampar);
        acampar.start();
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.back2) {
            acampar.pause();
            Intent intent = new Intent(Acampar.this, History.class);
            Toast.makeText(this, "Check our options", Toast.LENGTH_LONG).show();
            next.start();
            startActivity(intent);
            finish();
        }
    }
}