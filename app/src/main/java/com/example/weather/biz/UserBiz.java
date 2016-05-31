package com.example.weather.biz;

import android.content.Context;
import android.util.Log;

import com.baidu.apistore.sdk.ApiCallBack;
import com.baidu.apistore.sdk.ApiStoreSDK;
import com.baidu.apistore.sdk.network.Parameters;
import com.example.weather.bean.User;
import com.example.weather.biz.listener.OnLoginListener;
import com.example.weather.biz.listener.OnRegisterListener;
import com.example.weather.biz.listener.OnWeatherListener;

import cn.bmob.v3.listener.SaveListener;

public class UserBiz implements IUserBiz{

	//登录
    @Override
    public void login(String username, String password, final OnLoginListener loginListener, Context context) {
        final User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.login(context, new SaveListener() {
            @Override
            public void onSuccess() {
                loginListener.OnSuccess();
            }

            @Override
            public void onFailure(int i, String s) {
                loginListener.OnFailed();
            }
        });

    }

	@Override
	public void register(String username, String password, String email,
			final OnRegisterListener registerListener, Context context) {
		 User user = new User();
	        user.setUsername(username);
	        user.setPassword(password);
	        user.setEmail(email);
	        user.signUp(context, new SaveListener() {
	            @Override
	            public void onSuccess() {
	                registerListener.OnSuccess();
	            }

	            @Override
	            public void onFailure(int i, String s) {
	                registerListener.OnFailed();
	            }
	        });
	}


	@Override
	public void getWeatherInfo(String city,
			final OnWeatherListener weatherListener, Context context) {
		Parameters para = new Parameters();
		para.put("city", city);
		ApiStoreSDK.execute("http://apis.baidu.com/heweather/weather/free", 
			ApiStoreSDK.GET,
			para, 
			new ApiCallBack() {
		        @Override
		        public void onSuccess(int status, String responseString) {
		            Log.i("sdkdemo", "onSuccess");
		            weatherListener.OnSuccess(responseString);
		        }
		    
		        @Override
		        public void onComplete() {
		             Log.i("sdkdemo", "onComplete");
		        }
		    
		        @Override
		        public void onError(int status, String responseString, Exception e) {
		            Log.i("sdkdemo", "onError, status: " + status);
		            Log.i("sdkdemo", "errMsg: " + (e == null ? "" : e.getMessage()));
		            weatherListener.OnFailed( status,  responseString,  e);
		        }  

		});
		
	}

}
