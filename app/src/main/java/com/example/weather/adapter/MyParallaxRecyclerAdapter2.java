package com.example.weather.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.weather.R;
import com.example.weather.bean.HourlyForecast;
import com.poliveira.parallaxrecyclerview.ParallaxRecyclerAdapter;

import java.util.List;

/**
 * Created by admin on 2016/3/16.
 */
public class MyParallaxRecyclerAdapter2 extends ParallaxRecyclerAdapter {
    private List<HourlyForecast> hourlyForecasts;
    private Context context;

    public MyParallaxRecyclerAdapter2(List data, List<HourlyForecast> hourlyForecasts, Context context) {
        super(data);
        this.hourlyForecasts = hourlyForecasts;
        this.context = context;
    }

    @Override
    public void onBindViewHolderImpl(RecyclerView.ViewHolder viewHolder, ParallaxRecyclerAdapter parallaxRecyclerAdapter,final int i) {
        final HourlyForecast hourlyForecast = hourlyForecasts.get(i);
        ((MyViewHolder2) viewHolder).date.setText(hourlyForecast.getDate());
        ((MyViewHolder2) viewHolder).tmp.setText("温度："+hourlyForecast.getTmp() + "℃");
        ((MyViewHolder2) viewHolder).hum.setText("相对湿度："+hourlyForecast.getHum());
        ((MyViewHolder2) viewHolder).wind.setText(hourlyForecast.getDir() + ","+hourlyForecast.getSc());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolderImpl(ViewGroup viewGroup, ParallaxRecyclerAdapter parallaxRecyclerAdapter, int i) {
        return new MyViewHolder2(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hourdailyweather_item, viewGroup, false));
    }

    @Override
    public int getItemCountImpl(ParallaxRecyclerAdapter parallaxRecyclerAdapter) {
        return hourlyForecasts.size();
    }
}
