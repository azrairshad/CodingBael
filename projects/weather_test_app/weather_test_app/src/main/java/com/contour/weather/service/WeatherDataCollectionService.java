package com.contour.weather.service;

import com.contour.weather.data.model.WeatherUpdate;;
import com.contour.weather.util.WeatherCondition;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Weather collection simulator service
 */
@Service
public class WeatherDataCollectionService {
    public static final String CITY = "San Francisco";
    public static final String STATE = "CA";
    public static final String COUNTRY = "USA";
    public static List<String> cities = Arrays.asList("San Francisco", "San Jose", "Fremont", "Milpitas");
    public static List<Double> temperatures = Arrays.asList(33.4, 34.2, 35.6, 32.5);
    public static List<WeatherCondition> condition = Arrays.asList(WeatherCondition.CLEAR, WeatherCondition.MOSTLY_CLOUDY);

    /**
     * This method is supposed to fetch data using Rest template from some external weather web service
     * but to save time the data is being mocked here.
     * @return
     */
    public List<WeatherUpdate> fetchLiveData() {
        //todo: rest template can be used to fetch live data from external service
        //mocking data
        Collections.shuffle(condition);
        Collections.shuffle(cities);
        Collections.shuffle(temperatures);
        List<WeatherUpdate> weatherUpdates = new ArrayList<>();
        WeatherUpdate weatherUpdate = new WeatherUpdate();
        weatherUpdate.setCity(cities.get(0));
        weatherUpdate.setTemperature(temperatures.get(0));
        weatherUpdate.setWeatherCondition(condition.get(0));
        weatherUpdate.setWeatherTime(System.currentTimeMillis());
        weatherUpdates.add(weatherUpdate);
        return weatherUpdates;
    }
}
