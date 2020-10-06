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

        String  NAME     = getIntent().getStringExtra("NAME"),
                IMAGE    = getIntent().getStringExtra("IMAGE"),
                PLANET   = getIntent().getStringExtra("PLANET"),
                SERIES   = getIntent().getStringExtra("SERIES"),
                GENDER   = getIntent().getStringExtra("GENDER"),
                STATUS   = getIntent().getStringExtra("STATUS"),
                SPECIES  = getIntent().getStringExtra("SPECIES");

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