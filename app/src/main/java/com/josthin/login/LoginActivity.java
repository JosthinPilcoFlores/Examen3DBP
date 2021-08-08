package com.josthin.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button buttonLogin = findViewById(R.id.button1);
        buttonLogin.setOnClickListener((View v) -> goToChatsActivity());
        Button buttonSignUp = findViewById(R.id.button2);
        buttonSignUp.setOnClickListener((View v) -> goToSignUpActivity());
    }
    private void goToChatsActivity(){
        Intent intent = new Intent(this, ChatsActivity.class);
        startActivity(intent);
    }
    private void goToSignUpActivity(){
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }
}