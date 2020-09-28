package com.gemu404.covidapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MoreInfoActivity extends AppCompatActivity {

    String CODE,flagres;
    TextView Ncases,Acases,Nrecover,Arecover,Ndeath,Adeath;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);
        CODE = getIntent().getStringExtra("CODE");
        Toast.makeText(this,"CODE" + CODE,Toast.LENGTH_LONG).show();
        flagres = CODE;
        Acases = findViewById(R.id.item_Tcases);
        Adeath = findViewById(R.id.item_Tdeaths);
        Arecover = findViewById(R.id.item_Trecovered);
        Ncases = findViewById(R.id.item_Ncases);
        Ndeath = findViewById(R.id.item_Ndeaths);
        Nrecover = findViewById(R.id.item_Nrecovered);
        img = findViewById(R.id.img_flag);
        Glide.with(this).load("https://flagcdn.com/w1280/"+CODE.toLowerCase()+".jpg").into(img);

    }
}