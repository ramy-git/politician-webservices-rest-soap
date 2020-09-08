package com.macrosoft.test.service;

import com.macrosoft.test.data.Place;

import java.io.IOException;
import java.util.List;

public interface FacebookService
{
    /*
      * This method work for to fetch records from Facebook using facebook graph api
      * */
    List<Place> fetchFacebookData() throws IOException;
}
