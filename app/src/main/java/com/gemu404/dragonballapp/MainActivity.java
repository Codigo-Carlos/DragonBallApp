package com.gemu404.dragonballapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.gemu404.dragonballapp.adapter.AdapterHeroe;
import com.gemu404.dragonballapp.model.Heroe;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity implements Serializable {

    private static final String URL="https://dragon-ball-api.herokuapp.com/api/character";
    private static final String URLimage = "https://dragon-ball-api.herokuapp.com";
    Handler
            mHandler = new Handler();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);


    }

    public void gologin(View view) {

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