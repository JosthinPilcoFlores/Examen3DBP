package com.josthin.login;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity {
    MediaPlayer login;
    private EditText email, password;
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
        buttonRegister.setOnClickListener((View v) -> goToLoginActivity());
        login = MediaPlayer.create(this, R.raw.message);
        email = findViewById(R.id.EmailRegister);
        password = findViewById(R.id.PasswordRegister);
    }
    private void goToLoginActivity(){
        Intent intent = new Intent(this, LoginActivity.class);
        if (!validateEmail()){
            confirmInput();
        }
        if (!validatePassword()){
            confirmInput();
        }
        if (validateEmail() && validatePassword()){
            Toast.makeText(this, "Inicie sesión con su e-mail", Toast.LENGTH_SHORT).show();
            login.start();
            startActivity(intent);
        }
    }
    private boolean validatePassword(){
        String passwordInput = password.getText().toString().trim();
        if (passwordInput.isEmpty()){
            password.setError("Campo Vacío");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()){
            password.setError("Contraseña invalida");
            return false;
        }else {
            password.setError(null);
            return true;
        }
    }
    private boolean validateEmail(){
        String emailImput = email.getText().toString().trim();
        if (emailImput.isEmpty()){
            email.setError("Campo Vacío");
            return false;
        } else if (!EMAIL_ADDRESS.matcher(emailImput).matches()){
            email.setError("Ingrese un e-mail válido");
            return false;
        } else {
            email.setError(null);
            return true;
        }
    }
    private void confirmInput(){
        if (!validateEmail() | !validatePassword()){
            return;
        }
        String input = "Email: " + email.getText().toString();
        input += "\n";
        input += "Password: " + password.getText().toString();
        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
    }
}