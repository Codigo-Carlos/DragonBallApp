package com.gemu404.dragonballapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.gemu404.dragonballapp.adapter.AdapterHeroe;
import com.gemu404.dragonballapp.model.Heroe;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class HeroesActivity extends AppCompatActivity {
    //api url
    private static final String URL="https://dragon-ball-api.herokuapp.com/api/character";
    private static final String URLimage = "https://dragon-ball-api.herokuapp.com";



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroes);
        //lamada a proceso para recuperar datos
        processHTTP();
        Log.e ("WARNING", "si lees esto entonces compila bien");
    }

    private void processHTTP() {
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(URL, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String data = new String(responseBody);
                processCharacters(data);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    private void processCharacters(String data) {
        try {
            //recuperar datos de la api
            JSONArray root = new JSONArray(data);
            List<Heroe> lista = new ArrayList<>();
                for (int i = 0; i<root.length()-3;i++) {
                    JSONObject hero = root.getJSONObject(i);
                    String name = hero.getString("name");
                    String originPlanet = hero.getString("originPlanet");
                    String gender = hero.getString("gender");
                    String series = hero.getString("series");
                    String status = hero.getString("status");
                    String species = hero.getString("species");
                    String temp_image = hero.getString("image");
                    String image ;

                    //comprueba si la imagen es un enlaze
                    if(temp_image.substring(0,1).equalsIgnoreCase(".")){
                        //si no lo fuese, se concatena con el url y se borran 2 puntos
                        image = URLimage + temp_image.replace("..","");
                    } else {
                        //si lo fuese, se guarda tal cual
                        image = temp_image;
                    }
                    Heroe he = new Heroe(name,originPlanet,gender,series,status,species);
                    lista.add(he);
                }

            RecyclerView rc = findViewById(R.id.rc_heroes);
            AdapterHeroe ad = new AdapterHeroe(this,lista,R.layout.item_character);
            LinearLayoutManager lm = new LinearLayoutManager(this);
            lm.setOrientation(RecyclerView.VERTICAL);

            rc.setLayoutManager(lm);
            rc.setAdapter(ad);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}