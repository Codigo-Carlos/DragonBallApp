package com.gemu404.dragonballapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class NointernetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nointernet);



    }
    public void tryinternet(View view) {

        if (internetcheck()) {
            Intent intent= new Intent(this,LoginActivity.class);
            startActivity(intent);
        } else {
            Intent intent= new Intent(this,NointernetActivity.class);
            Toast.makeText(this, "No conectado a internet, intente mas tarde", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }



    }

    public boolean internetcheck(){
        ConnectivityManager conect;
        conect = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);

        Network[] networks = conect.getAllNetworks();
        boolean conected = false;
        for (Network network : networks){
            NetworkInfo info = conect.getNetworkInfo(network);
            if (info.isConnected()) {
                conected = true;
            }
        }
        return conected;
    }
}