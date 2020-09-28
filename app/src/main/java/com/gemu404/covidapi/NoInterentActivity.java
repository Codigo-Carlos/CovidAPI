package com.gemu404.covidapi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gemu404.covidapi.model.Country;

public class NoInterentActivity extends AppCompatActivity {
    private Button boton;
    public Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_interent);
        boton = findViewById(R.id.item_tryinternet);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (internetcheck()) {
                    Intent in = new Intent(activity, MainActivity.class);
                    activity.startActivity(in);
                } else {
                    Intent in = new Intent(activity, NoInterentActivity.class);
                    activity.startActivity(in);
                }
            }
        });
    }

    public boolean internetcheck(){
        ConnectivityManager conect;
        conect = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);

        Network[] networks = conect.getAllNetworks();
        boolean conected = false;
        for (Network network : networks){
            NetworkInfo info = conect.getNetworkInfo(network);
            if (info.isConnected()) {
                conected = true;
            }
        }
        return conected;
    }
}