package com.gemu404.dragonballapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.gemu404.dragonballapp.model.User;

public class LoginActivity extends AppCompatActivity {
    //usuario de prueba
    public User usr = new User("admin","admin");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }

    public void loginapp(View view) {
        TextView form_user = findViewById(R.id.input_user);
        TextView form_pass = findViewById(R.id.input_pass);
        String user = form_user.getText().toString();
        String pass = form_pass.getText().toString();

        if (finduser(user,pass)){
            form_user.setText("");
            form_pass.setText("");
            Intent intent = new Intent(this, HeroesActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();
            form_pass.setText("");
        }

    }

    //metodo que busca si un usuario y contraseña existe
    public boolean finduser(String user, String pass){
        if (user.equalsIgnoreCase(usr.getUser())) {
            if (pass.equals(usr.getPassword())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}