package com.example.weather.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.weather.R;
import com.example.weather.bean.FutureWeather;
import com.example.weather.utils.ConfigWeatherIcon;
import com.poliveira.parallaxrecyclerview.ParallaxRecyclerAdapter;

import java.util.List;

/**
 * Created by admin on 2016/3/16.
 */
public class MyParallaxRecyclerAdapter extends ParallaxRecyclerAdapter {
    private List<FutureWeather> futureWeathers;
    private Context context;

    public MyParallaxRecyclerAdapter(List data, List<FutureWeather> futureWeathers, Context context) {
        super(data);
        this.futureWeathers = futureWeathers;
        this.context = context;
    }

    @Override
    public void onBindViewHolderImpl(RecyclerView.ViewHolder viewHolder, ParallaxRecyclerAdapter parallaxRecyclerAdapter,final int i) {
        final FutureWeather futureWeather = futureWeathers.get(i);
        ((MyViewHolder) viewHolder).wind_icon.setImageResource(ConfigWeatherIcon.weatherConfig(futureWeather.getTxt_d()));
        ((MyViewHolder) viewHolder).weather.setText(futureWeather.getTxt_d());
        ((MyViewHolder) viewHolder).date.setText(futureWeather.getDate());
        ((MyViewHolder) viewHolder).tmp.setText(futureWeather.getMin() + "~"+futureWeather.getMax()+"℃");
        ((MyViewHolder) viewHolder).wind.setText(futureWeather.getDaily_forecast_dir() + ","+futureWeather.getDaily_forecast_sc());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolderImpl(ViewGroup viewGroup, ParallaxRecyclerAdapter parallaxRecyclerAdapter, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.futureweather_item, viewGroup, false));
    }

    @Override
    public int getItemCountImpl(ParallaxRecyclerAdapter parallaxRecyclerAdapter) {
        return futureWeathers.size();
    }
}
