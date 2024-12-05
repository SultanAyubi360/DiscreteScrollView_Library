package com.sultanayubi.discretescrollapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.snackbar.Snackbar;
import com.sultanayubi.discretescrollapp.gallery.GalleryActivity;
import com.sultanayubi.discretescrollapp.shop.ShopActivity;
import com.sultanayubi.discretescrollapp.weather.WeatherActivity;

import java.net.URL;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.preview_shop).setOnClickListener(this);
        findViewById(R.id.preview_weather).setOnClickListener(this);
        findViewById(R.id.preview_vertical).setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.preview_shop) {
            start(ShopActivity.class);
        } else if (v.getId() == R.id.preview_weather) {
            start(WeatherActivity.class);
        } else if (v.getId() == R.id.preview_vertical) {
            start(GalleryActivity.class);
        }
    }

    private void start(Class<? extends Activity> token) {
        Intent intent = new Intent(this, token);
        startActivity(intent);
    }
}
