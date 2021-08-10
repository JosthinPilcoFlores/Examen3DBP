package com.josthin.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuApp extends AppCompatActivity implements View.OnClickListener {
    MediaPlayer next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_app);
        Button btnChatBot = findViewById(R.id.btnChatBot);
        next = MediaPlayer.create(this,R.raw.next);
        btnChatBot.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(MenuApp.this, ChatBot.class);
        Toast.makeText(this,"Welcome to ChatBot", Toast.LENGTH_LONG).show();
        next.start();
        startActivity(i);
        finish();
    }
}