package com.gemu404.covidapi.model;

public class Country {
    public String Name;
    public String Code;
    public String NewConfirmed;
    public String TotalConfirmed;
    public String NewDeaths;
    public String TotalDeaths;
    public String NewRecovered;
    public String TotalRecovered;

    public Country (){

    }

    public Country(String name, String code, String newConfirmed, String totalConfirmed, String newDeaths, String totalDeaths, String newRecovered, String totalRecovered) {
        Name = name;
        Code = code;
        NewConfirmed = newConfirmed;
        TotalConfirmed = totalConfirmed;
        NewDeaths = newDeaths;
        TotalDeaths = totalDeaths;
        NewRecovered = newRecovered;
        TotalRecovered = totalRecovered;
    }
}
