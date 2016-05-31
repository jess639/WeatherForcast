package com.example.weather.presenter;

import android.content.Context;

import com.example.weather.biz.IUserBiz;
import com.example.weather.biz.UserBiz;
import com.example.weather.biz.listener.OnWeatherListener;
import com.example.weather.view.IHomeView;

public class HomePresenter {
	 private IHomeView homeView;
	 private Context context;
	 private IUserBiz userBiz;
	 public HomePresenter(IHomeView homeView, Context context) {
	        this.homeView = homeView;
	        this.context = context;
	        this.userBiz=new UserBiz();
	    }
	 
	 public void getWeatherInfo(final String city) {
			homeView.showLoading();
	        userBiz.getWeatherInfo(city,new OnWeatherListener() {
				
				@Override
				public void OnSuccess(String response) {
					homeView.hideLoading();
					homeView.QueryWeatherSuccess(response,city);
				}
				
				@Override
				public void OnFailed(int status, String responseString, Exception e) {
					homeView.hideLoading();
					homeView.QueryWeatherFail(status,responseString,e);
				}
			} , context);
	    }
}
