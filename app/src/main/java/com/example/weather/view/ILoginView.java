package com.example.weather.view;

import android.content.Context;

public interface ILoginView {
	String getUserName();

	void setUserName(String username);

	String getPassword();

	void setPassword(String password);

	void showLoading();

	void hideLoading();

	void loginFailed();

	Context getContext();

	void ErrorOfUsnAndPsd();

	void loginSuccess();

}
