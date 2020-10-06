package com.gemu404.dragonballapp.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.gemu404.dragonballapp.DetailActivity;
import com.gemu404.dragonballapp.R;
import com.gemu404.dragonballapp.model.Heroe;

import java.util.ArrayList;
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
        View view =LayoutInflater.from(parent.getContext()).inflate(item_hereo,parent,false);

        return new HeroeHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull HeroeHolder holder, int position) {
        Heroe hero = list.get(position);
        holder.item_name.setText(hero.getName());
        holder.item_raze.setText(hero.getSpecies());
        Glide.with(activity).load(hero.getImage()).into(holder.item_img);
        holder.urlImage=hero.getImage();

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HeroeHolder extends RecyclerView.ViewHolder{
        ImageView item_img;
        TextView item_name,item_raze;
        String urlImage;
        RelativeLayout item_cardChara;


        public HeroeHolder( View itemView) {
            super(itemView);
            item_img = itemView.findViewById(R.id.item_img);
            item_name= itemView.findViewById(R.id.item_name);
            item_raze= itemView.findViewById(R.id.item_raze);
            item_cardChara=itemView.findViewById(R.id.item_cardChara);

            item_cardChara.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(activity, DetailActivity.class);
                    //obtiene la psicion del adapter
                    int Pos = getAdapterPosition();
                    //recupera el objeto en la posicion marcada
                    Heroe he = list.get(Pos);
                    intent.putExtra("NAME",he.getName());
                    intent.putExtra("IMAGE",he.getImage());
                    intent.putExtra("PLANET",he.getOriginPlanet());
                    intent.putExtra("SERIES",he.getSeries());
                    intent.putExtra("GENDER",he.getGender());
                    intent.putExtra("STATUS",he.getStatus());
                    intent.putExtra("SPECIES",he.getSpecies());
                    activity.startActivity(intent);


               /* Toast.makeText(activity,"Hello"+item_name.getText().toString(),
                       Toast.LENGTH_LONG).show();*/




                }
            });
        }
    }




}
