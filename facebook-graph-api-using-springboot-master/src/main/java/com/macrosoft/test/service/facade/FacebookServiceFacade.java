package com.macrosoft.test.service.facade;

import com.macrosoft.test.data.Place;

import java.util.List;

public interface FacebookServiceFacade
{
    /*
    * This method work for to fetch records from Facebook using facebook graph api
    * */
    List<Place> fetchFacebookData();
}
