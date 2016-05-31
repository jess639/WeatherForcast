package com.example.weather.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.weather.R;


/**
 * Created by admin on 2016/3/16.
 */
public class MyViewHolder2 extends RecyclerView.ViewHolder {
    public TextView date;
    public TextView tmp;
    public TextView hum;
    public TextView wind;

    public MyViewHolder2(View itemView) {
        super(itemView);
        hum = (TextView) itemView.findViewById(R.id.hum);
        date = (TextView) itemView.findViewById(R.id.date);
        tmp = (TextView) itemView.findViewById(R.id.tmp);
        wind = (TextView) itemView.findViewById(R.id.wind);
    }
}
