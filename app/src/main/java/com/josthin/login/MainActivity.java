package com.josthin.login;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    MediaPlayer hello;
    MediaPlayer message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Add Multimedia
        hello = MediaPlayer.create(this, R.raw.hello);
        message = MediaPlayer.create(this, R.raw.message);
        //Add Animations
        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba);

        ImageView logoImageView = findViewById(R.id.LogoImageView);
        logoImageView.setAnimation(animation1);
        new Handler().postDelayed(() -> hello.start(), 2000);

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            message.start();
            startActivity(intent);
            finish();
        }, 4000);
    }
}