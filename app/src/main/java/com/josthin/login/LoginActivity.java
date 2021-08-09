package com.josthin.login;

import android.content.Intent;
import android.media.MediaPlayer;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    MediaPlayer login;
    private EditText e_mail, password;
    daoUsuario dao;
    //Expresiones Regulares para validar formularios
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +         //1 digito
                    "(?=.*[a-z])" +         //1 letra minúscula
                    "(?=.*[A-Z])" +         //1 letra mayúscula
                    "(?=.*[@#$%^&+=])" +    //1 caracter especial
                    "(?=\\S+$)" +           //No espacios
                    ".{6,}" +               //6 caracteres
                    "$");
    private static final Pattern EMAIL_ADDRESS =
            Pattern.compile(
                    "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                            "\\@" +
                            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                            "(" +
                                "\\." +
                                "[a-zA-Z0-9][a-zA-z0-9\\-]{0,25}" +
                            ")+"
            );
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = MediaPlayer.create(this, R.raw.message);
        Button buttonLogin = findViewById(R.id.button1);
        Button buttonSignUp = findViewById(R.id.button2);
        e_mail = findViewById(R.id.EmailAddress);
        password = findViewById(R.id.Password);
        buttonLogin.setOnClickListener(this);
        buttonSignUp.setOnClickListener(this);
        dao = new daoUsuario(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                String u = e_mail.getText().toString();
                String p = password.getText().toString();
                if (u.equals("") && p.equals("")){
                    Toast.makeText(this, "ERROR: Campos Vacíos", Toast.LENGTH_LONG).show();
                    e_mail.setError("Campo Vacío");
                    password.setError("Campo Vacío");
                } else if (!EMAIL_ADDRESS.matcher(u).matches()){
                    Toast.makeText(this, "ERROR: E-mail inválido", Toast.LENGTH_LONG).show();
                    e_mail.setError("No válido, ej: nombre@gmail.com");
                } else if (!PASSWORD_PATTERN.matcher(p).matches()){
                    Toast.makeText(this, "ERROR: Contraseña muy débil", Toast.LENGTH_LONG).show();
                    password.setError("Minimo: 1 minúscula, 1 mayúscula, 1 símbolo, 1 dígito y 6 caracteres");
                }else if (dao.login(u,p) == 1){
                    Usuario ux = dao.getUsuario(u,p);
                    Intent i2 = new Intent(LoginActivity.this, VoiceGirlIntroductionActivity.class);
                    e_mail.setError(null);
                    password.setError(null);
                    login.start();
                    Toast.makeText(this, "Welcome", Toast.LENGTH_LONG).show();
                    i2.putExtra("Id",ux.getId());
                    startActivity(i2);
                    finish();
                } else {
                    Toast.makeText(this, "Usuario y/o Password incorrectos", Toast.LENGTH_LONG).show();
                    e_mail.setError("No coincide con contraseña o no está registrado");
                    password.setError("No coincide con e-mail o no está registrado");
                }
                break;
            case R.id.button2:
                Intent i = new Intent(LoginActivity.this, SignUpActivity.class);
                login.start();
                startActivity(i);
                break;
        }
    }
}