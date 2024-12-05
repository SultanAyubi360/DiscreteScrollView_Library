package com.sultanayubi.discretescrollapp.weather;

import com.sultanayubi.discretescrollapp.R;

import java.util.Arrays;
import java.util.List;


public class WeatherStation {


    public static WeatherStation get() {
        return new WeatherStation();
    }

    private WeatherStation() {
    }

    public List<Forecast> getForecasts() {
        return Arrays.asList(
                new Forecast("Islamabad", R.drawable.pisa, "16", Weather.PARTLY_CLOUDY),
                new Forecast("Karachi", R.drawable.paris, "14", Weather.CLEAR),
                new Forecast("Lahore", R.drawable.new_york, "9", Weather.MOSTLY_CLOUDY),
                new Forecast("Multan", R.drawable.rome, "18", Weather.PARTLY_CLOUDY),
                new Forecast("Rawalpindi", R.drawable.london, "6", Weather.PERIODIC_CLOUDS),
                new Forecast("Peshawar", R.drawable.washington, "20", Weather.CLEAR));
    }
}
