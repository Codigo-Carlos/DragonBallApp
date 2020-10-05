package com.gemu404.dragonballapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String  NAME     = "get intent",
                IMAGE    = "https://dragon-ball-api.herokuapp.com/images/Goku.jpg",
                PLANET   = "get intent",
                SERIES   = "get intent",
                GENDER   = "get intent",
                STATUS   = "get intent",
                SPECIES  = "get intent";

        TextView    i_name      = findViewById(R.id.item_name),
                    i_planet    = findViewById(R.id.item_planet),
                    i_series    = findViewById(R.id.item_series),
                    i_gender    = findViewById(R.id.item_gender),
                    i_status    = findViewById(R.id.item_status),
                    i_species   = findViewById(R.id.item_species);
        ImageView   i_img       = findViewById(R.id.item_img);

        i_name.setText(NAME);
        i_planet.setText(PLANET);
        i_series.setText(SERIES);
        i_gender.setText(GENDER);
        i_status.setText(STATUS);
        i_species.setText(SPECIES);
        Glide.with(this).load(IMAGE).into(i_img);
    }
}