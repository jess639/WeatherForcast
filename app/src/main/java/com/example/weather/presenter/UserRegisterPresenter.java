package com.example.weather.presenter;


import com.example.weather.biz.IUserBiz;
import com.example.weather.biz.UserBiz;
import com.example.weather.biz.listener.OnRegisterListener;
import com.example.weather.view.IUserRegisterView;

import android.content.Context;
import android.text.TextUtils;


/**
 * Created by admin on 2016/3/7.
 */
public class UserRegisterPresenter {
    private IUserBiz userBiz;
    private IUserRegisterView userRegisterView;
    private Context context;

    public UserRegisterPresenter(IUserRegisterView userRegisterView, Context context) {
        this.userBiz = new UserBiz();
        this.userRegisterView = userRegisterView;
        this.context = context;
    }

    public void register() {
        if (TextUtils.isEmpty(userRegisterView.getPsd()) || TextUtils.isEmpty(userRegisterView.getUsername())|| TextUtils.isEmpty(userRegisterView.getConPsd())|| TextUtils.isEmpty(userRegisterView.getEmail())) {
            userRegisterView.ErrorOfUsnorPsdorEmail();
            return;
        };
        if (!userRegisterView.getConPsd().endsWith(userRegisterView.getPsd())){
            userRegisterView.ErrorOfConfingerPsd();
            return;
        }
        userRegisterView.showLoading();
        userBiz.register(userRegisterView.getUsername(), userRegisterView.getPsd(), userRegisterView.getEmail(), new OnRegisterListener() {
            @Override
            public void OnSuccess() {
                userRegisterView.hideLoading();
                userRegisterView.Success();
                userRegisterView.FinishAty();
            }

            @Override
            public void OnFailed() {
                userRegisterView.hideLoading();
                userRegisterView.Failed();
            }
        }, userRegisterView.getContext());
    }


}
