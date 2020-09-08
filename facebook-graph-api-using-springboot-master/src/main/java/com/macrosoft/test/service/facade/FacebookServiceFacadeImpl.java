package com.macrosoft.test.service.facade;

import com.macrosoft.test.data.Place;
import com.macrosoft.test.service.FacebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.List;


@Service
public class FacebookServiceFacadeImpl implements FacebookServiceFacade
{


    private final FacebookService facebookService;


    @Autowired
    public FacebookServiceFacadeImpl(FacebookService facebookService)
    {
        this.facebookService = facebookService;
    }


    /*
* This method work for to fetch records from Facebook using facebook graph api
* */
    @Override
    public List<Place> fetchFacebookData()
    {
        try {
            return this.facebookService.fetchFacebookData();
        } catch(IOException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();

    }

}
