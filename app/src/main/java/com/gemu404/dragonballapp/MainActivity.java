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
        Intent intent= new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
}