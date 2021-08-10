package com.josthin.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MenuApp extends AppCompatActivity implements View.OnClickListener {
    MediaPlayer next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_app);
        ImageButton btnHistory = findViewById(R.id.history);
        ImageButton btnChatBot = findViewById(R.id.chatBot);
        Button btnHelp = findViewById(R.id.help);
        Button btnChats = findViewById(R.id.chats);
        next = MediaPlayer.create(this,R.raw.next);
        btnChatBot.setOnClickListener(this);
        btnChats.setOnClickListener(this);
        btnHelp.setOnClickListener(this);
        btnHistory.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.chatBot:
                Intent i = new Intent(MenuApp.this, ChatBot.class);
                Toast.makeText(this,"Welcome to ChatBot", Toast.LENGTH_LONG).show();
                next.start();
                startActivity(i);
                break;
            case R.id.chats:
                Intent i2 = new Intent(MenuApp.this, Chats.class);
                Toast.makeText(this,"Welcome to Chats", Toast.LENGTH_LONG).show();
                next.start();
                startActivity(i2);
                break;
            case R.id.history:
                Intent i3 = new Intent(MenuApp.this, History.class);
                Toast.makeText(this,"Welcome to Histories", Toast.LENGTH_LONG).show();
                next.start();
                startActivity(i3);
                break;
            case R.id.help:
                Intent i4 = new Intent(MenuApp.this, Help.class);
                Toast.makeText(this,"Welcome to Help", Toast.LENGTH_LONG).show();
                next.start();
                startActivity(i4);
                break;
        }
    }
}