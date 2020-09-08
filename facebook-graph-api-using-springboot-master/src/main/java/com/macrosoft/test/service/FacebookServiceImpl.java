package com.macrosoft.test.service;

import com.macrosoft.test.data.Place;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;
import com.restfb.json.JsonArray;
import com.restfb.json.JsonObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class FacebookServiceImpl implements FacebookService
{


    public static final String FQL_ME_TAGGED_PLACES = "/me/tagged_places";
    public static final String NAME = "name";
    public static final String COUNTRY = "country";
    public static final String CITY = "city";
    public static final String EMPTY_STRING = "";



    @Value("${access.token:test}")
    private String MY_ACCESS_TOKEN;





    /*
  * This method work for to fetch records from Facebook using facebook graph api
  * */
    @Override
    public List<Place> fetchFacebookData() throws IOException
    {

        FacebookClient fbClient = new DefaultFacebookClient(MY_ACCESS_TOKEN, Version.LATEST);


        JsonObject placeObjects = fbClient.fetchObject(FQL_ME_TAGGED_PLACES, JsonObject.class);
        JsonArray array = placeObjects.getJsonArray("data");


        return setData(array);
    }



    /*
  * This method help  to collect records from JSONObject and put it into Data Structure.
  * Right now currently we using simple ArrayList data structure.
  * */
    private List<Place> setData(JsonArray array)
    {

        List<Place> places = new ArrayList<>();

        for(int i = 0; i < array.length(); i++) {


            Place place = new Place();

            JsonObject rootJsonObject = (JsonObject) array.get(i);
            JsonObject placeJsonObject = (JsonObject) rootJsonObject.get("place");
            JsonObject locationJsonObject = (JsonObject) placeJsonObject.get("location");


            place.setName(placeJsonObject.has(NAME) ? placeJsonObject.get(NAME).toString() : EMPTY_STRING);
            place.setCity(locationJsonObject.has(CITY) ? locationJsonObject.get(CITY).toString() : EMPTY_STRING);
            place.setCountry(locationJsonObject.has(COUNTRY) ? locationJsonObject.get(COUNTRY).toString() : EMPTY_STRING);


            places.add(place);


            System.out.println(array.get(i).toString());
        }

        return places;
    }
}
