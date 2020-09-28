package com.gemu404.covidapi.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gemu404.covidapi.MoreInfoActivity;
import com.gemu404.covidapi.R;
import com.gemu404.covidapi.model.Country;

import java.util.List;

public class AdapterCountry extends RecyclerView.Adapter<AdapterCountry.CountryHolder>{

    public Activity activity;
    public List<Country> list;
    public int item_country;

    public AdapterCountry(Activity activity, List<Country> list, int item_country) {
        this.activity = activity;
        this.list = list;
        this.item_country = item_country;
    }

    @NonNull
    @Override
    public CountryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(item_country,parent,false);
        return new CountryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryHolder holder, int position) {
        Country country = list.get(position);
        holder.item_country.setText(country.Name);
        holder.item_alldeaths.setText(country.TotalDeaths);
        holder.item_allcases.setText(country.TotalConfirmed);
        holder.item_allrecovered.setText(country.TotalRecovered);
        holder.item_code.setText(country.Code);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CountryHolder extends RecyclerView.ViewHolder {
        TextView    item_allcases,
                    item_alldeaths,
                    item_allrecovered,
                    item_country,
                    item_code;
        RelativeLayout item_card;

        public CountryHolder(@NonNull View itemView) {
            super(itemView);
            item_country = itemView.findViewById(R.id.item_country);
            item_allcases = itemView.findViewById(R.id.item_allcases);
            item_alldeaths = itemView.findViewById(R.id.item_alldeaths);
            item_allrecovered= itemView.findViewById(R.id.item_allrecovred);
            item_code = itemView.findViewById(R.id.item_code);
            item_card = itemView.findViewById(R.id.item_card);


            item_card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(activity, MoreInfoActivity.class);
                    int Pos = getAdapterPosition();
                    Country country = list.get(Pos);
                    in.putExtra("CODE",country.Code);
                    in.putExtra("NAME",country.Name);
                    in.putExtra("NCON",country.NewConfirmed);
                    in.putExtra("TCON",country.TotalConfirmed);
                    in.putExtra("NREC",country.NewRecovered);
                    in.putExtra("TREC",country.TotalRecovered);
                    in.putExtra("NDEA",country.NewDeaths);
                    in.putExtra("TDEA",country.TotalDeaths);
                    activity.startActivity(in);
                }
            });
        }
    }
}
