package com.example.weather.view;

public interface IHomeView {
  void QueryWeatherFail(int status, String responseString, Exception e);
  void QueryWeatherSuccess(String weather,String city);
  void showLoading();
  void hideLoading();

}
