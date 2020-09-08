package com.macrosoft.test;


import com.macrosoft.test.data.Place;
import com.macrosoft.test.service.facade.FacebookServiceFacade;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;
import com.restfb.json.JsonArray;
import com.restfb.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@org.springframework.web.bind.annotation.RestController
public class RestController
{




    @Value("${access.token:test}")
    private String MY_ACCESS_TOKEN;


    private static List<Place> places;



    private final FacebookServiceFacade facebookServiceFacade;


    @Autowired
    public RestController(FacebookServiceFacade facebookServiceFacade)
    {
        this.facebookServiceFacade = facebookServiceFacade;
    }


    @RequestMapping("/facebookData")
    public List<Place> getPlaces() throws IOException
    {
        return places = this.facebookServiceFacade.fetchFacebookData();
    }


    @RequestMapping("/searchByName")
    public List<Place> getitem(@RequestParam("name") String name) throws IOException
    {
        return places.stream().filter(place -> place.getName() != null && place.getName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
    }

    @RequestMapping("/searchByCountry")
    public List<Place> getPlacesByCountry(@RequestParam("countryName") String countryName) throws IOException
    {
        return places.stream().filter(place -> place.getCountry() != null && place.getCountry().toLowerCase().contains(countryName.toLowerCase())).collect(Collectors.toList());
    }


    @RequestMapping("/searchByCity")
    public List<Place> getPlacesByCity(@RequestParam("cityName") String cityName) throws IOException
    {
        return places.stream().filter(place -> place.getCity() != null && place.getCity().toLowerCase().contains(cityName.toLowerCase())).collect(Collectors.toList());
    }

}
