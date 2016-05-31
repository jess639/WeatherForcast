package com.example.weather.biz;


import android.content.Context;

import com.example.weather.biz.listener.OnLoginListener;
import com.example.weather.biz.listener.OnRegisterListener;
import com.example.weather.biz.listener.OnWeatherListener;

/**
 * Created by admin on 2016/3/7.
 */
public interface IUserBiz {
    //登录
    void login(String username, String password, OnLoginListener loginListener, Context context);
    //注册
    void register(String username, String password, String email, OnRegisterListener registerListener, Context context);
    //获取天气
    void getWeatherInfo(String city,OnWeatherListener weatherListener,Context context);
}
