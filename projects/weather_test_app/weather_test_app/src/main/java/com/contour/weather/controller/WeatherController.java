package com.contour.weather.controller;

import com.contour.weather.data.model.WeatherUpdate;
import com.contour.weather.service.WeatherService;
import com.contour.weather.util.WeatherCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Weather controller
 */
@RestController
public class WeatherController {


    public static final String DEFAULT_COUNTRY = "USA";
    public static final String STATE = "CA";
    public static final String DEFAULT_CITY = "San Francisco";
    private Logger logger = LoggerFactory.getLogger(WeatherController.class);
    private WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @RequestMapping(value = "/weather", method = RequestMethod.GET)
    public WeatherUpdate getWeatherUpdateByLocation(@RequestParam("country")  String country
            , @RequestParam("state")  String state
            , @RequestParam("city") String city) {
        logger.info("Fetch current weather...");
        WeatherUpdate weatherUpdate = getCurrentWeatherUpdate(country, state, city);
        logger.info("Current weather fetched...");
        return weatherUpdate;
//        ModelAndView model = new ModelAndView();
//        model.addObject("weatherUpdate", weatherUpdate);
//        model.setViewName("WeatherInfo");
//        return model;
    }

    private WeatherUpdate getCurrentWeatherUpdate(@RequestParam("country") String country
            , @RequestParam("state") String state, @RequestParam("city") String city) {
        WeatherUpdate weatherUpdate =
                weatherService.getCurrentWeatherUpdateByLocation(country, state, city);
        return weatherUpdate;
    }

    @RequestMapping(value = "/weather", method = RequestMethod.POST)
    public String saveWeather(@RequestBody WeatherUpdate weatherUpdate) {
        logger.info("Saving weather...");
        weatherService.saveWeather(weatherUpdate);
        logger.info("Saved weather...");
        return "Saved Successfully!";
    }

    @RequestMapping(value = "/weather/history", method = RequestMethod.POST)
    public List<WeatherUpdate> getWeatherHistory() {
        //get history for default values
       // ModelAndView model = new ModelAndView();
       // List<WeatherUpdate> weatherUpdates =
              return  weatherService.getWeatherUpdateByLocation(DEFAULT_COUNTRY
                      , STATE, DEFAULT_CITY);
//        model.addObject("weatherUpdates", weatherUpdates);
//        model.setViewName("WeatherInfo");
//        return model;

    }

    @RequestMapping(value = { "/"}, method = RequestMethod.GET)
    public ModelAndView welcomePage() {
        ModelAndView model = new ModelAndView();
        List<WeatherUpdate> weatherUpdates =
                weatherService.getWeatherUpdateByLocation(DEFAULT_COUNTRY, STATE, DEFAULT_CITY);
        model.addObject("weatherUpdates", weatherUpdates);
        WeatherUpdate weatherUpdate = getCurrentWeatherUpdate(DEFAULT_COUNTRY,STATE,DEFAULT_CITY);
        model.addObject("weatherUpdate", weatherUpdate);
        model.setViewName("WeatherInfo");
        return model;
    }
}