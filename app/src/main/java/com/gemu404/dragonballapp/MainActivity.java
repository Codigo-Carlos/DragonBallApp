package com.gemu404.dragonballapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

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




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        //cargar activity heroes
        Intent intent= new Intent(this,HeroesActivity.class);
        startActivity(intent);
//no funciono este intent
        Intent it  = new Intent(this,AdapterHeroe.class);
        startActivity(it);

        processHTTP();


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

            JSONObject root = new JSONObject(data);
            JSONArray results = root.getJSONArray("results");
            List<Heroe> lista = new ArrayList<>();
            for (int i = 0; i<results.length()-3;i++) {
                JSONObject hero = results.getJSONObject(i);

                String name = hero.getString("name");
                String originPlanet = hero.getString("originPlanet");
                String gender = hero.getString("gender");
                String series = hero.getString("series");
                String status = hero.getString("status");
                String species = hero.getString("species");
                String temp_image = hero.getString("image");
                String image ;

                if(temp_image.substring(0,1).equalsIgnoreCase(".")){
                    image = URLimage + temp_image.replace("..","");
                } else {
                    image = temp_image;
                }
                Heroe he = new Heroe(name,originPlanet,gender,series,status,species,image);
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