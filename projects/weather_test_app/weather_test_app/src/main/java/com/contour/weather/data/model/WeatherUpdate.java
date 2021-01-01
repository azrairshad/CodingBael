package com.contour.weather.data.model;

import com.contour.weather.util.WeatherCondition;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Weather update
 */
@Entity
@Table(name = "weather_info")
public class WeatherUpdate implements java.io.Serializable {

    @Column(name = "weather_time")
    public Long getWeatherTime() {
        return weatherTime;
    }

    public void setWeatherTime(Long weatherTime) {
        this.weatherTime = weatherTime;
    }

    @Column(name = "temperature")
    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Column(name = "weather_condition")
    @Enumerated(EnumType.STRING)
    public WeatherCondition getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(WeatherCondition weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "weather_info_id")
    public int getWeatherInfoId() {
        return weatherInfoId;
    }

    public void setWeatherInfoId(int weatherInfoId) {
        this.weatherInfoId = weatherInfoId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public String toString() {
        return city+", "+
                weatherTime+", "+temperature+", "+weatherCondition;
    }

    private String city;
    private int weatherInfoId;
    private Long weatherTime;
    private double temperature;
    private WeatherCondition weatherCondition;

}
