package com.gemu404.dragonballapp.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gemu404.dragonballapp.R;
import com.gemu404.dragonballapp.model.Heroe;

import java.util.List;

public class AdapterHeroe extends RecyclerView.Adapter<AdapterHeroe.HeroeHolder> {
   public Activity          activity;
    public List<Heroe>      list;
    public int              item_hereo;

    public AdapterHeroe(Activity activity, List<Heroe> list, int item_hereo) {
        this.activity = activity;
        this.list = list;
        this.item_hereo = item_hereo;
    }

    @NonNull
    @Override
    public HeroeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }
    @Override
    public void onBindViewHolder(@NonNull HeroeHolder holder, int position) {
        Heroe hero = list.get(position);
        holder.item_name.setText(hero.getName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HeroeHolder extends RecyclerView.ViewHolder{
        ImageView item_img;
        TextView item_name;

        public HeroeHolder( View itemView) {
            super(itemView);
            item_img = itemView.findViewById(R.id.item_img);
            item_name= itemView.findViewById(R.id.item_name);
        }
    }



}
