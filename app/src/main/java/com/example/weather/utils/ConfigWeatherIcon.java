package com.example.weather.utils;

import com.example.weather.R;

public class ConfigWeatherIcon {
	public static int weatherConfig(String condition){
		if (condition.contains("晴")) {
			return R.drawable.weather_icon_0;
		}
        
        if (condition.contains("多云")) {
        	return R.drawable.weather_icon_1;
		}
        
        if(condition.contains("阴")){
        	return R.drawable.weather_icon_2;
        }
        
        if(condition.contains("雨")){
        	return R.drawable.weather_icon_9;
        }
        
        if(condition.contains("雪")){
        	return R.drawable.weather_icon_14;
        }
        
        if(condition.contains("雷")){
        	return R.drawable.weather_icon_4;
        }
		return R.drawable.weather_icon_1;
	}
	

}
