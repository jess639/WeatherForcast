package com.example.weather.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.example.weather.R;
import com.example.weather.biz.LoginUser;
import com.example.weather.presenter.LoginPresenter;
import com.example.weather.utils.SHA1;
import com.example.weather.utils.T;
import com.example.weather.view.ILoginView;

import org.litepal.crud.DataSupport;

import cn.bmob.v3.Bmob;


public class LoginActivity extends Activity implements ILoginView,OnClickListener{
    private static final String TAG = "LoginActivity";

    private ProgressBar loginProgress;
    private EditText userName;
    private EditText userPsd;
    private Button login;
    private CheckBox remembre_psd;
    private LinearLayout register;
    private LoginPresenter presenter=new LoginPresenter(LoginActivity.this, this);
    

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_page);
		initId();
		InitData();
		login.setOnClickListener(this);
		register.setOnClickListener(this);
		Log.e(TAG, "SHA: "+ SHA1.sHA1(LoginActivity.this));
	}


	private void InitData() {
		LoginUser user=DataSupport.findLast(LoginUser.class);
		if (user!=null) {
			setUserName(user.getUsername());
			setPassword(user.getPassword());
			remembre_psd.setChecked(true);
		}
	}


	private void initId() {
		login=(Button) findViewById(R.id.Login);
		userName=(EditText) findViewById(R.id.User_Name);
		userPsd=(EditText) findViewById(R.id.User_Psd);
		loginProgress=(ProgressBar) findViewById(R.id.login_progress);
		register=(LinearLayout) findViewById(R.id.register);
		remembre_psd=(CheckBox) findViewById(R.id.remeber_psd);
        Bmob.initialize(this, "edc3ed4ae81cbdde9d0bc6d2ddd697a0");
	}
	
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		presenter=null;
	}


	@Override
	public String getUserName() {
		return userName.getText().toString();
	}


	@Override
	public String getPassword() {
		return userPsd.getText().toString();
	}


	@Override
	public void showLoading() {
		// TODO Auto-generated method stub
		loginProgress.setVisibility(View.VISIBLE);
		
	}


	@Override
	public void hideLoading() {
		// TODO Auto-generated method stub
		loginProgress.setVisibility(View.INVISIBLE);
	}


	@Override
	public void loginFailed() {
		T.showShort(getApplicationContext(), "登录失败!");
	}


	@Override
	public Context getContext() {
		return LoginActivity.this;
	}


	@Override
	public void ErrorOfUsnAndPsd() {
		T.showShort(getApplicationContext(), "用户名或者密码不能为空!");
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.register:
			//注册
	        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
			break;
		case R.id.Login:
			//判断是否需要保存账号密码；
			if (remembre_psd.isChecked()) {
				presenter.rememberUsdAndPsd();
			}else {
				DataSupport.deleteAll(LoginUser.class);
			}
			presenter.login();
			break;

		default:
			break;
		}
		
	}


	@Override
	public void loginSuccess() {
		startActivity(new Intent(LoginActivity.this,HomeActivity.class));
	}


	@Override
	public void setUserName(String username) {
		// TODO Auto-generated method stub
		userName.setText(username);
	}


	@Override
	public void setPassword(String password) {
		// TODO Auto-generated method stub
	     userPsd.setText(password);
	}


}
