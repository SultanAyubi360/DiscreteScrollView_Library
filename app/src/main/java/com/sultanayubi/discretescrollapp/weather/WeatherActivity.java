package com.sultanayubi.discretescrollapp.weather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.sultanayubi.discretescrollviewlibrary.DiscreteScrollViewOptions;
import com.sultanayubi.discretescrollapp.MainActivity;
import com.sultanayubi.discretescrollapp.R;
import com.sultanayubi.discretescrollviewlibrary.DiscreteScrollView;
import com.sultanayubi.discretescrollviewlibrary.transform.ScaleTransformer;

import java.util.List;


public class WeatherActivity extends AppCompatActivity implements
        DiscreteScrollView.ScrollStateChangeListener<ForecastAdapter.ViewHolder>,
        DiscreteScrollView.OnItemChangedListener<ForecastAdapter.ViewHolder>,
        View.OnClickListener {

    private List<Forecast> forecasts;

    private ForecastView forecastView;
    private DiscreteScrollView cityPicker;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        forecastView = findViewById(R.id.forecast_view);

        forecasts = WeatherStation.get().getForecasts();

        cityPicker = findViewById(R.id.forecast_city_picker);
        cityPicker.setSlideOnFling(true);
        cityPicker.setAdapter(new ForecastAdapter(forecasts));
        cityPicker.addOnItemChangedListener(this);
        cityPicker.addScrollStateChangeListener(this);
        cityPicker.scrollToPosition(2);
        cityPicker.setItemTransitionTimeMillis(DiscreteScrollViewOptions.getTransitionTime());
        cityPicker.setItemTransformer(new ScaleTransformer.Builder()
                .setMinScale(0.8f)
                .build());

        forecastView.setForecast(forecasts.get(0));

        findViewById(R.id.homeweather).setOnClickListener(this);

    }

    @Override
    public void onCurrentItemChanged(@Nullable ForecastAdapter.ViewHolder holder, int position) {
        //viewHolder will never be null, because we never remove items from adapter's list
        if (holder != null) {
            forecastView.setForecast(forecasts.get(position));
            holder.showText();
        }
    }

    @Override
    public void onScrollStart(@NonNull ForecastAdapter.ViewHolder holder, int position) {
        holder.hideText();
    }

    @Override
    public void onScroll(
            float position,
            int currentIndex, int newIndex,
            @Nullable ForecastAdapter.ViewHolder currentHolder,
            @Nullable ForecastAdapter.ViewHolder newHolder) {
        Forecast current = forecasts.get(currentIndex);
        RecyclerView.Adapter<?> adapter = cityPicker.getAdapter();
        int itemCount = adapter != null ? adapter.getItemCount() : 0;
        if (newIndex >= 0 && newIndex < itemCount) {
            Forecast next = forecasts.get(newIndex);
            forecastView.onScroll(1f - Math.abs(position), current, next);
        }
    }



    @Override
    public void onScrollEnd(@NonNull ForecastAdapter.ViewHolder holder, int position) {

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.homeweather) {
            start(MainActivity.class);
            finish();
        }
    }

    private void start(Class<? extends Activity> token) {
        Intent intent = new Intent(this, token);
        startActivity(intent);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}
