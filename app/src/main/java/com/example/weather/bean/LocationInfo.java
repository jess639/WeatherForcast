package com.example.weather.bean;
/**
 * Created by admin on 2016/4/2.
 */
public class LocationInfo {
    /**
     * 经度
     */
    private double latitude;
    /**
     * 纬度
     */
    private double longtitude;
    private String address;
    private String city;
    private String erro;


    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    @Override
    public String toString() {
        return "LocationInfo{" +
                "latitude=" + latitude +
                ", longtitude=" + longtitude +
                ", address='" + address + '\'' +
                '}';
    }
}
