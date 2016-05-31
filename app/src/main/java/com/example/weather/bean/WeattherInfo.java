package com.example.weather.bean;

import java.io.Serializable;
import java.util.List;

public class WeattherInfo implements Serializable {
    private String status;
    private String txt;
    private String fl;
    private String tmp;
    private String dir;
    private String sc;
    private String city_api;
    private String pres;
    private String city_co;
    private String city_no2;
    private String city_qlty;
    private List<FutureWeather> futureWeathers;
    private List<HourlyForecast> hourlyForecasts;
    private String comf_txt;
    private String drsg_txt;

    public List<HourlyForecast> getHourlyForecasts() {
        return hourlyForecasts;
    }

    public void setHourlyForecasts(List<HourlyForecast> hourlyForecasts) {
        this.hourlyForecasts = hourlyForecasts;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getFl() {
        return fl;
    }

    public void setFl(String fl) {
        this.fl = fl;
    }

    public String getTmp() {
        return tmp;
    }

    public void setTmp(String tmp) {
        this.tmp = tmp;
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

    public String getCity_api() {
        return city_api;
    }

    public void setCity_api(String city_api) {
        this.city_api = city_api;
    }

    public String getCity_co() {
        return city_co;
    }

    public void setCity_co(String city_co) {
        this.city_co = city_co;
    }

    public String getCity_no2() {
        return city_no2;
    }

    public void setCity_no2(String city_no2) {
        this.city_no2 = city_no2;
    }

    public String getCity_qlty() {
        return city_qlty;
    }

    public void setCity_qlty(String city_qlty) {
        this.city_qlty = city_qlty;
    }


    public String getComf_txt() {
        return comf_txt;
    }

    public void setComf_txt(String comf_txt) {
        this.comf_txt = comf_txt;
    }

    public String getDrsg_txt() {
        return drsg_txt;
    }

    public void setDrsg_txt(String drsg_txt) {
        this.drsg_txt = drsg_txt;
    }

    public List<FutureWeather> getFutureWeathers() {
        return futureWeathers;
    }

    public void setFutureWeathers(List<FutureWeather> futureWeathers) {
        this.futureWeathers = futureWeathers;
    }

    public String getPres() {
        return pres;
    }

    public void setPres(String pres) {
        this.pres = pres;
    }

    @Override
    public String toString() {
        return "WeattherInfo{" +
                "status='" + status + '\'' +
                ", txt='" + txt + '\'' +
                ", fl='" + fl + '\'' +
                ", tmp='" + tmp + '\'' +
                ", dir='" + dir + '\'' +
                ", sc='" + sc + '\'' +
                ", city_api='" + city_api + '\'' +
                ", pres='" + pres + '\'' +
                ", city_co='" + city_co + '\'' +
                ", city_no2='" + city_no2 + '\'' +
                ", city_qlty='" + city_qlty + '\'' +
                ", futureWeathers=" + futureWeathers +
                ", hourlyForecasts=" + hourlyForecasts +
                ", comf_txt='" + comf_txt + '\'' +
                ", drsg_txt='" + drsg_txt + '\'' +
                '}';
    }
}
