package com.rest.service;


import java.util.ArrayList;
import java.util.List;


public class PoliticianResource {

	private List<Politician> politicians=new ArrayList<Politician>();
    public List<Politician> getXml() {
        politicians.add(new Politician("Trump","US"));
        politicians.add(new Politician("Xi Jinping","China"));
        politicians.add(new Politician("Macron","France"));
        return politicians;
    }

}
