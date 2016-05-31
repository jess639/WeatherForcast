package com.example.weather.view;


import android.content.Context;

/**
 * Created by luzixun on 2016/5/27.
 */
public interface IUserRegisterView {
    //注册成功时候提示
    void Success();
    //注册失败
    void Failed();
    void showLoading();
    void hideLoading();
    //注册成功back这个Aty
    void FinishAty();
    String getUsername();
    String getPsd();
    String getConPsd();
    String getEmail();
    Context getContext();
    void ErrorOfUsnorPsdorEmail();
    void ErrorOfConfingerPsd();

}
