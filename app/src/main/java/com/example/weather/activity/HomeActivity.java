package com.example.weather.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.example.weather.R;
import com.example.weather.adapter.MyParallaxRecyclerAdapter;
import com.example.weather.bean.LocationInfo;
import com.example.weather.bean.Weather;
import com.example.weather.bean.WeattherInfo;
import com.example.weather.presenter.HomePresenter;
import com.example.weather.utils.ConfigWeatherIcon;
import com.example.weather.utils.T;
import com.example.weather.utils.Utils;
import com.example.weather.view.IHomeView;

import org.json.JSONException;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeActivity extends Activity implements IHomeView, OnClickListener, AMapLocationListener {
    private static final int RESULT_CODE = 1;
    ImageView weather_icon;
    TextView weather_condition;
    TextView weatherTmp;
    TextView pres;
    TextView wind;
    TextView fl;
    TextView airCondition;
    Button details;

    @Bind(R.id.back)
    Button back;
    @Bind(R.id.add)
    Button add;

    @Bind(R.id.progress)
    ProgressBar progressBar;

    @Bind(R.id.city_name)
    TextView cityName;
    @Bind(R.id.mListView)
    RecyclerView mListView;

    private MyParallaxRecyclerAdapter adapter;
    private View hearview;


    private AMapLocationClient locationClient = null;
    private AMapLocationClientOption locationOption = null;
    private HomePresenter homePresenter = new HomePresenter(this, HomeActivity.this);

    private WeattherInfo weattherInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initId();
        InitLocation();
        InitAdpter();
        add.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    private void InitAdpter() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mListView.setLayoutManager(manager);
        mListView.setHasFixedSize(true);



    }

    private void initId() {
        locationClient = new AMapLocationClient(this.getApplicationContext());
        locationOption = new AMapLocationClientOption();
        // 设置定位模式为低功耗模式
        locationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Battery_Saving);
        // 设置定位监听
        locationClient.setLocationListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.details:
                Intent intent = new Intent(HomeActivity.this, DetailsActivity.class);
                intent.putExtra("weattherInfo", weattherInfo);
                startActivity(intent);
                break;
            case R.id.weather_icon:
                Intent intent2 = new Intent(HomeActivity.this, DetailsActivity.class);
                intent2.putExtra("weattherInfo", weattherInfo);
                startActivity(intent2);
            case R.id.add:
                startActivityForResult(new Intent(HomeActivity.this, PickCityActivity.class), RESULT_CODE);
                break;
            case R.id.back:
                this.finish();
                break;
            default:
                break;
        }
    }


    private void InitLocation() {
        // 设置是否需要显示地址信息
        locationOption.setNeedAddress(true);
        /**
         *  设置发送定位请求的时间间隔,最小值为1000，如果小于1000，按照1000算
         *  只有持续定位设置定位间隔才有效，单次定位无效
         */
        locationOption.setInterval(Long.valueOf(1000));
        //单次定位
        locationOption.setOnceLocation(true);
        locationClient.setLocationOption(locationOption);
        // 启动定位
        locationClient.startLocation();
        mHandler.sendEmptyMessage(Utils.MSG_LOCATION_START);
    }

    public void onLocationChanged(AMapLocation loc) {
        if (null != loc) {
            Message msg = mHandler.obtainMessage();
            msg.obj = loc;
            msg.what = Utils.MSG_LOCATION_FINISH;
            mHandler.sendMessage(msg);
        }
    }

    Handler mHandler = new Handler() {
        public void dispatchMessage(Message msg) {
            switch (msg.what) {
                case Utils.MSG_LOCATION_START:
                    break;
                //定位完成
                case Utils.MSG_LOCATION_FINISH:
                    AMapLocation loc = (AMapLocation) msg.obj;
                    LocationInfo locationInfo = Utils.getLocationInfo(loc);
                    if (TextUtils.isEmpty(locationInfo.getAddress()) && locationInfo.getLatitude() == 0 && locationInfo.getLongtitude() == 0) {
                        homePresenter.getWeatherInfo("合肥");
                    } else {
                        //定位成功
                        homePresenter.getWeatherInfo(locationInfo.getCity().replaceAll("市", ""));
                    }
                    break;
                case Utils.MSG_LOCATION_STOP:
                    break;
                default:
                    break;
            }
        }

        ;
    };

    protected void onDestroy() {
        super.onDestroy();
        homePresenter = null;
        if (null != locationClient) {
            /**
             * 如果AMapLocationClient是在当前Activity实例化的，
             * 在Activity的onDestroy中一定要执行AMapLocationClient的onDestroy
             */
            locationClient.onDestroy();
            locationClient = null;
            locationOption = null;
        }
    }


    @Override
    public void QueryWeatherSuccess(String weather, String city) {
        Weather weather2 = new Weather();
        try {
            weattherInfo = weather2.JsonWeatherInfo(weather);
            Log.e(TAG, "QueryWeatherSuccess: " + weattherInfo.getHourlyForecasts().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        hearview= LayoutInflater.from(this).inflate(R.layout.listview_header, mListView, false);
        weather_icon= (ImageView) hearview.findViewById(R.id.weather_icon);
        weather_condition= (TextView) hearview.findViewById(R.id.weather_condition);
        weatherTmp= (TextView) hearview.findViewById(R.id.weather_tmp);
        pres= (TextView) hearview.findViewById(R.id.pres);
        wind= (TextView) hearview.findViewById(R.id.wind);
        fl= (TextView) hearview.findViewById(R.id.fl);
        airCondition= (TextView) hearview.findViewById(R.id.air_condition);
        details= (Button) hearview.findViewById(R.id.details);
        details.setOnClickListener(this);

        adapter = new MyParallaxRecyclerAdapter(null, weattherInfo.getFutureWeathers(), HomeActivity.this);
        adapter.setParallaxHeader(hearview, mListView);
        mListView.setAdapter(adapter);

        weather_icon.setImageResource(ConfigWeatherIcon.weatherConfig(weattherInfo.getTxt()));
        weather_condition.setText(weattherInfo.getTxt());
        cityName.setText(city);
        weatherTmp.setText("当前：" + weattherInfo.getTmp() + "℃");
        fl.setText("体感温度：" + weattherInfo.getFl() + "℃");
        pres.setText("气压：" + weattherInfo.getPres() + "hPa");
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
        airCondition.setText("空气质量：" + weattherInfo.getCity_api() + "|" + weattherInfo.getCity_qlty());
    }

    @Override
    public void QueryWeatherFail(int status, String responseString, Exception e) {
        T.showShort(getApplicationContext(), "获取天气失败！");
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    ;
    private static final String TAG = "HomeActivity";

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RESULT_CODE && resultCode == RESULT_OK && data != null) {
            String city = data.getExtras().getString("city").replaceAll("市", "");//得到新Activity 关闭后返回的数据
            Log.e(TAG, "city:" + city);
            homePresenter.getWeatherInfo(city);
        }
    }
}
