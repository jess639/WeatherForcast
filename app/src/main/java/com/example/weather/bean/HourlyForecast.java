package com.example.weather.bean;

import java.io.Serializable;

/**
 * Created by admin on 2016/5/30.
 */
public class HourlyForecast implements Serializable{
    private String date;//时间
    private String hum;//相对湿度（%）
    private String tmp;//温度
    private String dir;//风向
    private String sc; //风力


    public String getTmp() {
        return tmp;
    }

    public void setTmp(String tmp) {
        this.tmp = tmp;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHum() {
        return hum;
    }

    public void setHum(String hum) {
        this.hum = hum;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getSc() {
        return sc;
    }

    public void setSc(String sc) {
        this.sc = sc;
    }

    @Override
    public String toString() {
        return "HourlyForecast{" +
                "date='" + date + '\'' +
                ", hum='" + hum + '\'' +
                ", tmp='" + tmp + '\'' +
                ", dir='" + dir + '\'' +
                ", sc='" + sc + '\'' +
                '}';
    }
}
