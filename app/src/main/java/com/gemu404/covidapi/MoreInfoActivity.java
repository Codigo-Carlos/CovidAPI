package com.gemu404.covidapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.gemu404.covidapi.model.Country;
import com.gemu404.covidapi.model.Country;

import org.json.JSONObject;

public class MoreInfoActivity extends AppCompatActivity {

    String CODE,NAME,NCON,TCON,NREC,TREC,NDEA,TDEA;
    TextView Ncases,Acases,Nrecover,Arecover,Ndeath,Adeath,Title;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);
        CODE = getIntent().getStringExtra("CODE");
        NAME = getIntent().getStringExtra("NAME");
        NCON = getIntent().getStringExtra("NCON");
        TCON = getIntent().getStringExtra("TCON");
        NREC = getIntent().getStringExtra("NREC");
        TREC = getIntent().getStringExtra("TREC");
        NDEA = getIntent().getStringExtra("NDEA");
        TDEA = getIntent().getStringExtra("TDEA");

        Title = findViewById(R.id.item_title);
        Acases = findViewById(R.id.item_Tcases);
        Adeath = findViewById(R.id.item_Tdeaths);
        Arecover = findViewById(R.id.item_Trecovered);
        Ncases = findViewById(R.id.item_Ncases);
        Ndeath = findViewById(R.id.item_Ndeaths);
        Nrecover = findViewById(R.id.item_Nrecovered);
        img = findViewById(R.id.img_flag);

        Glide.with(this).load("https://flagcdn.com/w1280/"+CODE.toLowerCase()+".jpg").into(img);
        Title.setText(NAME);
        Acases.setText(TCON);
        Adeath.setText(TDEA);
        Arecover.setText(TREC);
        Ncases.setText(NCON);
        Ndeath.setText(NDEA);
        Nrecover.setText(NREC);
    }
}