package com.josthin.login;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class VoiceGirlIntroductionActivity extends AppCompatActivity implements View.OnClickListener {
    MediaPlayer introduction, next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_girl_introduction);
        Button btnSkip = findViewById(R.id.skip);
        next = MediaPlayer.create(this, R.raw.message);
        introduction = MediaPlayer.create(this, R.raw.introduccion);
        introduction.start();
        btnSkip.setOnClickListener(this);
        new Handler().postDelayed(() -> {
            Intent i = new Intent(VoiceGirlIntroductionActivity.this, MenuApp.class);
            Toast.makeText(this, "Check our options", Toast.LENGTH_LONG).show();
            next.start();
            startActivity(i);
            finish();
        }, 89000);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.skip) {
            introduction.pause();
            Intent intent = new Intent(VoiceGirlIntroductionActivity.this, MenuApp.class);
            Toast.makeText(this, "Check our options", Toast.LENGTH_LONG).show();
            next.start();
            startActivity(intent);
            finish();
        }
    }
}