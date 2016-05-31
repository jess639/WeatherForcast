package com.example.weather.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.weather.R;
import com.example.weather.adapter.MyParallaxRecyclerAdapter2;
import com.example.weather.bean.WeattherInfo;
import com.example.weather.utils.ConfigWeatherIcon;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DetailsActivity extends Activity implements OnClickListener {
    private static final int RESULT_CODE = 1;
    ImageView weather_icon;
    TextView weather_condition;
    TextView weatherTmp;
    TextView wind;
    TextView fl;
    TextView co;
    TextView co2;
    TextView airCondition;

    @Bind(R.id.back)
    Button back;
    @Bind(R.id.about_us)
    Button aboutUs;
    @Bind(R.id.progress)
    ProgressBar progress;
    @Bind(R.id.mListView)
    RecyclerView mListView;



    private MyParallaxRecyclerAdapter2 adapter;
    private View hearview;

    private WeattherInfo weattherInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        InitAdpter();
        if (getIntent() != null) {
            weattherInfo = (WeattherInfo) getIntent().getSerializableExtra("weattherInfo");
            if (weattherInfo != null) {
                UpdateTodayWeatherInfo(weattherInfo);
            }
        }
        aboutUs.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    private void InitAdpter() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mListView.setLayoutManager(manager);
        mListView.setHasFixedSize(true);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.about_us:
                Uri uri = Uri.parse("http://www.ahau.edu.cn/");
                Intent it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it);
                break;
            case R.id.back:
                this.finish();
                break;
            default:
                break;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public void UpdateTodayWeatherInfo(WeattherInfo weattherInfo) {
        hearview = LayoutInflater.from(this).inflate(R.layout.listview_header_details, mListView, false);
        weather_icon = (ImageView) hearview.findViewById(R.id.weather_icon);
        weather_condition = (TextView) hearview.findViewById(R.id.weather_condition);
        weatherTmp = (TextView) hearview.findViewById(R.id.weather_tmp);
        wind = (TextView) hearview.findViewById(R.id.wind);
        fl = (TextView) hearview.findViewById(R.id.fl);
        co = (TextView) hearview.findViewById(R.id.co);
        co2 = (TextView) hearview.findViewById(R.id.co2);
        airCondition = (TextView) hearview.findViewById(R.id.air_condition);

        adapter = new MyParallaxRecyclerAdapter2(null, weattherInfo.getHourlyForecasts(), DetailsActivity.this);
        adapter.setParallaxHeader(hearview, mListView);
        mListView.setAdapter(adapter);

        weather_icon.setImageResource(ConfigWeatherIcon.weatherConfig(weattherInfo.getTxt()));
        weather_condition.setText(weattherInfo.getTxt());
        weatherTmp.setText("当前：" + weattherInfo.getTmp() + "℃");
        fl.setText("体感温度：" + weattherInfo.getFl() + "℃");
        if (
                weattherInfo.getSc().contains("1") ||
                        weattherInfo.getSc().contains("2") ||
                        weattherInfo.getSc().contains("3") ||
                        weattherInfo.getSc().contains("4") ||
                        weattherInfo.getSc().contains("5") ||
                        weattherInfo.getSc().contains("6") ||
                        weattherInfo.getSc().contains("7") ||
                        weattherInfo.getSc().contains("8") ||
                        weattherInfo.getSc().contains("9") ||
                        weattherInfo.getSc().contains("0")
                ) {
            wind.setText(weattherInfo.getDir() + "|" + weattherInfo.getSc() + "级");
        } else {
            wind.setText(weattherInfo.getDir() + "|" + weattherInfo.getSc());
        }
        co.setText("Co含量："+weattherInfo.getCity_co()+"ug/m³");
        co2.setText("Co2含量："+weattherInfo.getCity_no2()+"ug/m³");
        airCondition.setText("空气质量：" + weattherInfo.getCity_api() + "|" + weattherInfo.getCity_qlty());
    }

    private static final String TAG = "DetailsActivity";
}
