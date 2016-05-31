package com.example.weather.bean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Weather {
  public WeattherInfo JsonWeatherInfo(String weatherString) throws JSONException {
	  if(weatherString==null){
		  return null;
	    } ;
	  JSONObject object=new JSONObject(weatherString);
	  JSONArray services=object.getJSONArray("HeWeather data service 3.0");
      WeattherInfo weattherInfo=new WeattherInfo();
	  for (int i = 0; i < services.length(); i++) {
		JSONObject serviceObject=services.getJSONObject(i);
        String status=serviceObject.getString("status");
        JSONObject now=serviceObject.getJSONObject("now");
        JSONObject cond= now.getJSONObject("cond");
        String txt=cond.getString("txt");//天气状况描述
        String fl=now.getString("fl");//体感温度
        String tmp=now.getString("tmp");//温度
        String pres=now.getString("pres");//气压
        JSONObject wind= now.getJSONObject("wind");
        String dir=wind.getString("dir");//风向
        String sc=wind.getString("sc");//风力
        
        JSONObject aqi=serviceObject.getJSONObject("aqi");
        JSONObject city=aqi.getJSONObject("city");
        String city_api=city.getString("aqi"); //空气质量指数
        String city_co=city.getString("co");//一氧化碳1小时平均值(ug/m³)
        String city_no2=city.getString("no2");//二氧化氮1小时平均值(ug/m³)
        String city_qlty=city.getString("qlty");//空气质量类别
        
        JSONObject suggestion=serviceObject.getJSONObject("suggestion");
        JSONObject comf=suggestion.getJSONObject("comf"); //舒适度指数
        String comf_txt=comf.getString("txt");//详细描述
        
        
        JSONObject drsg=suggestion.getJSONObject("drsg"); //穿衣指数
        String drsg_txt=drsg.getString("txt");//详细描述
        
  	    JSONArray daily_forecasts=serviceObject.getJSONArray("daily_forecast");
  	    List<FutureWeather> futureWeathers=new ArrayList<>();
        for (int j = 0; j < daily_forecasts.length(); j++) {
    		JSONObject daily_forecastObject=daily_forecasts.getJSONObject(j);
    		String date=daily_forecastObject.getString("date");
            JSONObject daily_forecastObject_cond=daily_forecastObject.getJSONObject("cond");//天气状况
            String txt_d=daily_forecastObject_cond.getString("txt_d");
            
            JSONObject daily_forecastObject_tmp=daily_forecastObject.getJSONObject("tmp");//天气状况
            String max=daily_forecastObject_tmp.getString("max");
            String min=daily_forecastObject_tmp.getString("min");

            JSONObject daily_forecastObject_wind=daily_forecastObject.getJSONObject("wind");//天气状况
            String daily_forecast_dir=daily_forecastObject_wind.getString("dir");
            String daily_forecast_sc=daily_forecastObject_wind.getString("sc");
            
            FutureWeather futureWeather=new FutureWeather();
            futureWeather.setDate(date);
            futureWeather.setTxt_d(txt_d);
            futureWeather.setMax(max);
            futureWeather.setMin(min);
            futureWeather.setDaily_forecast_dir(daily_forecast_dir);
            futureWeather.setDaily_forecast_sc(daily_forecast_sc);
            futureWeathers.add(futureWeather);
		}



          JSONArray hourly_forecasts=serviceObject.getJSONArray("hourly_forecast");
          List<HourlyForecast> hourlyForecasts=new ArrayList<>();
          for (int j = 0; j < hourly_forecasts.length(); j++) {
              JSONObject hourly_forecastObject=hourly_forecasts.getJSONObject(j);
              String hourly_date=hourly_forecastObject.getString("date");
              String hourly_hum=hourly_forecastObject.getString("hum");
              String hourly_tmp=hourly_forecastObject.getString("tmp");

              JSONObject hourly_forecastObject_wind=hourly_forecastObject.getJSONObject("wind");//天气状况
              String hourly_forecast_dir=hourly_forecastObject_wind.getString("dir");
              String hourly_forecast_sc=hourly_forecastObject_wind.getString("sc");
              HourlyForecast hourlyForecast=new HourlyForecast();
              hourlyForecast.setDate(hourly_date);
              hourlyForecast.setHum(hourly_hum);
              hourlyForecast.setTmp(hourly_tmp);
              hourlyForecast.setDir(hourly_forecast_dir);
              hourlyForecast.setSc(hourly_forecast_sc);
              hourlyForecasts.add(hourlyForecast);
          }
        weattherInfo.setStatus(status);
        weattherInfo.setTxt(txt);
        weattherInfo.setFl(fl);
        weattherInfo.setTmp(tmp);
        weattherInfo.setDir(dir);
        weattherInfo.setSc(sc);
        weattherInfo.setPres(pres);
        weattherInfo.setCity_api(city_api);
        weattherInfo.setCity_co(city_co);
        weattherInfo.setCity_no2(city_no2);
        weattherInfo.setCity_qlty(city_qlty);
        weattherInfo.setFutureWeathers(futureWeathers);
        weattherInfo.setHourlyForecasts(hourlyForecasts);
        weattherInfo.setDrsg_txt(drsg_txt);
        weattherInfo.setComf_txt(comf_txt);
	  }
	  return weattherInfo;
  }
}
