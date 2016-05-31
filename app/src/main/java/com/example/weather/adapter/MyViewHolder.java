package com.example.weather.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weather.R;



/**
 * Created by admin on 2016/3/16.
 */
public class MyViewHolder extends RecyclerView.ViewHolder {
    public ImageView wind_icon;
    public TextView weather;
    public TextView date;
    public TextView tmp;
    public TextView wind;

    public MyViewHolder(View itemView) {
        super(itemView);
        wind_icon= (ImageView) itemView.findViewById(R.id.wind_icon);
        weather = (TextView) itemView.findViewById(R.id.weather);
        date = (TextView) itemView.findViewById(R.id.date);
        tmp = (TextView) itemView.findViewById(R.id.tmp);
        wind = (TextView) itemView.findViewById(R.id.wind);
    }
}
