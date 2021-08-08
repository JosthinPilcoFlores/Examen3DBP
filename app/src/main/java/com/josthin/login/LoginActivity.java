package com.josthin.login;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    MediaPlayer login;
    private EditText e_mail, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = MediaPlayer.create(this, R.raw.message);
        Button buttonLogin = findViewById(R.id.button1);
        buttonLogin.setOnClickListener((View v) -> goToChatsActivity());
        Button buttonSignUp = findViewById(R.id.button2);
        buttonSignUp.setOnClickListener((View v) -> goToSignUpActivity());
        e_mail = (EditText) findViewById(R.id.EmailAddress);
        password = (EditText) findViewById(R.id.Password);
    }
    private void goToChatsActivity(){
        String mail = e_mail.getText().toString();
        String pass = password.getText().toString();
        Intent intent = new Intent(this, ChatsActivity.class);
        if (mail.length() == 0){
            Toast.makeText(this, "Debes ingresar un e_mail", Toast.LENGTH_LONG).show();
        }
        if (pass.length() == 0){
            Toast.makeText(this, "Debes ingresar una constraseña", Toast.LENGTH_LONG).show();
        }
        if (mail.length() != 0 && pass.length() != 0){
            Toast.makeText(this, "Registro en proceso...", Toast.LENGTH_LONG).show();
            login.start();
            startActivity(intent);
        }
    }
    private void goToSignUpActivity(){
        Intent intent = new Intent(this, SignUpActivity.class);
        login.start();
        startActivity(intent);
    }
}