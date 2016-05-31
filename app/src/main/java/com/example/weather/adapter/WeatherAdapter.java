package com.example.weather.adapter;


import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.weather.R;
import com.example.weather.bean.FutureWeather;
import com.example.weather.utils.ConfigWeatherIcon;

/**
 * Created by admin on 2016/3/13.
 */
public class WeatherAdapter extends BaseAdapter {
    private List<FutureWeather> futureWeathers;
    private Context context;



    public WeatherAdapter(List<FutureWeather> futureWeathers, Context context) {
        this.futureWeathers = futureWeathers;
        this.context = context;
    }
    @Override
    public int getCount() {
        return futureWeathers.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final FutureWeather futureWeather = futureWeathers.get(position);
        ViewHoder hoder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.futureweather_item, null);
            hoder = new ViewHoder();
            hoder.wind_icon= (ImageView) convertView.findViewById(R.id.wind_icon);
            hoder.weather = (TextView) convertView.findViewById(R.id.weather);
            hoder.date = (TextView) convertView.findViewById(R.id.date);
            hoder.tmp = (TextView) convertView.findViewById(R.id.tmp);
            hoder.wind = (TextView) convertView.findViewById(R.id.wind);
            convertView.setTag(hoder);
        } else {
            hoder = (ViewHoder) convertView.getTag();
        }
        hoder.wind_icon.setImageResource(ConfigWeatherIcon.weatherConfig(futureWeather.getTxt_d()));
        hoder.weather.setText(futureWeather.getTxt_d());
        hoder.date.setText(futureWeather.getDate());
        hoder.tmp.setText(futureWeather.getMin() + "~"+futureWeather.getMax()+"℃");
        hoder.wind.setText(futureWeather.getDaily_forecast_dir() + ","+futureWeather.getDaily_forecast_sc());
        return convertView;
    }

    class ViewHoder {
        private ImageView wind_icon;
        private TextView weather;
        private TextView date;
        private TextView tmp;
        private TextView wind;
    }
}
