package com.example.weather.biz.listener;

public interface OnWeatherListener {
    void OnSuccess(String response);

    void OnFailed(int status, String responseString, Exception e);
}
