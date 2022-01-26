package com.example.weatherapp;

import org.json.JSONException;
import org.json.JSONObject;

public class wData {

    private String temp,icon,city,WeatherType;
    private int condition;

    public static wData fromJson(JSONObject jsonObject)
    {

        try
        {
            wData weatherD=new wData();
            weatherD.city=jsonObject.getString("name");
            weatherD.condition=jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id");
            weatherD.WeatherType=jsonObject.getJSONArray("weather").getJSONObject(0).getString("main");
            weatherD.icon=updateWeatherIcon(weatherD.condition);
            double tempResult=jsonObject.getJSONObject("main").getDouble("temp")-273.15;
            int roundedValue=(int)Math.rint(tempResult);
            weatherD.temp=Integer.toString(roundedValue);
            return weatherD;
        }

        catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }

    private static String updateWeatherIcon(int condition)
    {
        if(condition>=0 && condition<=300)
        {
            return "thunderstorm1";
        }
        else if(condition>=300 && condition<=500)
        {
            return "lightrain";
        }
        else if(condition>=500 && condition<=600)
        {
            return "shower";
        }
        else  if(condition>=600 && condition<=700)
        {
            return "snow2";
        }
        else if(condition>=701 && condition<=771)
        {
            return "fog";
        }

        else if(condition>=772 && condition<=800)
        {
            return "overcast";
        }
        else if(condition==800)
        {
            return "sunny";
        }
        else if(condition>=801 && condition<=804)
        {
            return "cloudy";
        }
        else  if(condition>=900 && condition<=902)
        {
            return "thunderstorm1";
        }
        if(condition==903)
        {
            return "snow1";
        }
        if(condition==904)
        {
            return "sunny";
        }
        if(condition>=905 && condition<=1000)
        {
            return "thunderstorm2";
        }

        return "searching";

    }

    public String getTemp() {
        return temp+"°C";
    }

    public String getIcon() {
        return icon;
    }

    public String getCity() {
        return city;
    }

    public String getWeatherType() {
        return WeatherType;
    }


}
