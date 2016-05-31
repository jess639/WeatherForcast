package com.example.weather.presenter;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;

import com.example.weather.biz.IUserBiz;
import com.example.weather.biz.LoginUser;
import com.example.weather.biz.UserBiz;
import com.example.weather.biz.listener.OnLoginListener;
import com.example.weather.view.ILoginView;

import org.litepal.crud.DataSupport;

public class LoginPresenter {
	private Context context;
	private ILoginView loginView;
    private IUserBiz userBiz;
    
    
    public LoginPresenter(ILoginView loginView,Context context) {
        this.userBiz = new UserBiz();
        this.loginView = loginView;
        this.context= context;
    }
	
	
	
	public void login() {
		loginView.showLoading();
		if (TextUtils.isEmpty(loginView.getUserName())||TextUtils.isEmpty(loginView.getPassword())) {
			loginView.ErrorOfUsnAndPsd();
			return;
		}
		userBiz.login(loginView.getUserName(), loginView.getPassword(), new OnLoginListener() {
            @Override
            public void OnSuccess() {
            	loginView.hideLoading();
            	loginView.loginSuccess();
            }

            @Override
            public void OnFailed() {
            	loginView.hideLoading();
            	loginView.loginFailed();
            }
        },loginView.getContext());
	}
	
	
	public void rememberUsdAndPsd() {
		int countNum=DataSupport.count(LoginUser.class);
		if (countNum==0) {
			LoginUser loginUser=new LoginUser();
			loginUser.setUsername(loginView.getUserName());
			loginUser.setPassword(loginView.getPassword());
			loginUser.setIsremember(true);
			loginUser.save();
		}else {
			ContentValues values=new ContentValues();
			values.put("username", loginView.getUserName());
			values.put("password", loginView.getPassword());
			values.put("isremember", true);
			DataSupport.updateAll(LoginUser.class,values);
		}
	}

}
