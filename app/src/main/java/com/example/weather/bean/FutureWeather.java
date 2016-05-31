package com.example.weather.bean;

import java.io.Serializable;

public class FutureWeather implements Serializable{
	private String date;
	private String txt_d;
	private String max;
	private String min;
	private String daily_forecast_dir;
	private String daily_forecast_sc;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTxt_d() {
		return txt_d;
	}
	public void setTxt_d(String txt_d) {
		this.txt_d = txt_d;
	}
	public String getMax() {
		return max;
	}
	public void setMax(String max) {
		this.max = max;
	}
	public String getMin() {
		return min;
	}
	public void setMin(String min) {
		this.min = min;
	}
	public String getDaily_forecast_dir() {
		return daily_forecast_dir;
	}
	public void setDaily_forecast_dir(String daily_forecast_dir) {
		this.daily_forecast_dir = daily_forecast_dir;
	}
	public String getDaily_forecast_sc() {
		return daily_forecast_sc;
	}
	public void setDaily_forecast_sc(String daily_forecast_sc) {
		this.daily_forecast_sc = daily_forecast_sc;
	}
	@Override
	public String toString() {
		return "FutureWeather [date=" + date + ", txt_d=" + txt_d + ", max="
				+ max + ", min=" + min + ", daily_forecast_dir="
				+ daily_forecast_dir + ", daily_forecast_sc="
				+ daily_forecast_sc + "]";
	}
	
}
