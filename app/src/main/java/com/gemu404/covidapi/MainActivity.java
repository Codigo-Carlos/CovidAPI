package com.gemu404.covidapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.gemu404.covidapi.adapter.AdapterCountry;
import com.gemu404.covidapi.model.Country;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    private static final String URL="https://api.covid19api.com/summary";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        procesoHTTP();
    }

    private void procesoHTTP() {
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(URL, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String data = new String(responseBody);
                procesarCiudades(data);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    private void procesarCiudades(String data) {
        try {
            JSONObject root = new JSONObject(data);

            JSONObject global = root.getJSONObject("Global");
                String Nconfirmed = global.getString("NewConfirmed");
                String Tconfirmed = global.getString("TotalConfirmed");
                String Ndeaths = global.getString("NewDeaths");
                String Tdeaths = global.getString("TotalDeaths");
                String Nrecovered = global.getString("NewRecovered");
                String Trecovered = global.getString("TotalRecovered");

            JSONArray country = root.getJSONArray("Countries");

            List<Country> list = new ArrayList<>();

                for (int i = 0; i<country.length();i++) {
                    JSONObject Pais = country.getJSONObject(i);
                    String Nombre = Pais.getString("Country");
                    String Codigo = Pais.getString("CountryCode");
                    String P_Nconfirmed = Pais.getString("NewConfirmed");
                    String P_Tconfirmed = Pais.getString("TotalConfirmed");
                    String P_Ndeaths = Pais.getString("NewDeaths");
                    String P_Tdeaths = Pais.getString("TotalDeaths");
                    String P_Nrecovered = Pais.getString("NewRecovered");
                    String P_Trecovered = Pais.getString("TotalRecovered");
                    Country Co = new Country(Nombre, Codigo, P_Nconfirmed, P_Tconfirmed, P_Ndeaths, P_Tdeaths, P_Nrecovered, P_Trecovered);
                    list.add(Co);
                }
            RecyclerView rc = findViewById(R.id.rc_country);
            AdapterCountry ad = new AdapterCountry(this,list,R.layout.item_country);
            LinearLayoutManager lm = new LinearLayoutManager(this);
            lm.setOrientation(RecyclerView.VERTICAL);

            rc.setLayoutManager(lm);
            rc.setAdapter(ad);


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}