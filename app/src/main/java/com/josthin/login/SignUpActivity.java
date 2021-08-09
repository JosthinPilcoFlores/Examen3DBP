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

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    MediaPlayer login;
    private EditText email, password;
    daoUsuario dao;
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
        setContentView(R.layout.activity_sign_up);
        Button buttonRegister = findViewById(R.id.button4);
        login = MediaPlayer.create(this, R.raw.message);
        email = findViewById(R.id.EmailRegister);
        password = findViewById(R.id.PasswordRegister);
        buttonRegister.setOnClickListener(this);
        dao = new daoUsuario(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button4:
                Usuario u = new Usuario();
                u.setEmail(email.getText().toString());
                u.setPassword(password.getText().toString());
                if (!u.isNull()){
                    Toast.makeText(this, "ERROR: Campos vacíos", Toast.LENGTH_LONG).show();
                    email.setError("Campo Vacío");
                    password.setError("Campo vacío");
                } else if (!EMAIL_ADDRESS.matcher(u.getEmail()).matches()){
                    Toast.makeText(this, "ERROR: E-mail no válido", Toast.LENGTH_LONG).show();
                    email.setError("Email inválido, ej: persona@gmail.com");
                } else if (!PASSWORD_PATTERN.matcher(u.getPassword()).matches()){
                    Toast.makeText(this, "ERROR: Contraseña muy débil", Toast.LENGTH_LONG).show();
                    password.setError("Minimo: 1 minúscula, 1 mayúscula, 1 símbolo, 1 dígito y 6 caracteres");
                }else if (dao.insertUsuario(u)){
                    Intent i2 = new Intent(SignUpActivity.this, LoginActivity.class);
                    email.setError(null);
                    password.setError(null);
                    Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_LONG).show();
                    login.start();
                    startActivity(i2);
                    finish();
                } else {
                    Toast.makeText(this, "Usuario ya registrado", Toast.LENGTH_LONG).show();
                    email.setError("Usuario ya registrado");
                    password.setError("Usuario ya registrado");
                }
        }
    }
}