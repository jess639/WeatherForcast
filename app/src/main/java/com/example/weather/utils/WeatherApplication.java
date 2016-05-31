package com.example.weather.utils;

import com.baidu.apistore.sdk.ApiStoreSDK;


public class WeatherApplication extends MyApplication{
	 @Override
	    public void onCreate() {
	    	// TODO 您的其他初始化流程
	    	ApiStoreSDK.init(this, "1b72e395b7ebd13af9af698e3262d032");
	    	super.onCreate();
	    }
}
