package com.gemu404.dragonballapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

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
            //falta implementar el modelo
            //falta implementar una lista con objetos del modelo
            JSONArray root = new JSONArray(data);

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


                    Log.e("msg", species+" | "+ name +" | " +originPlanet+" | "+ gender+" | "+series+" | "+status+" | "+image);


                    //falta crear objeto con los parametros de arriba
                    //falta agregar el objeto a una lista
                }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}