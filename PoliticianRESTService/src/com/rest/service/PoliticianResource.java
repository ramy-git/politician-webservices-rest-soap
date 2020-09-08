package com.rest.service;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/rest/")
public class PoliticianResource {

	private List<Politician> politicians=new ArrayList<Politician>();
	
	@GET
    @Path("politicians")
    @Produces(MediaType.APPLICATION_XML )
    public List<Politician> getPoliticians() {
        politicians.add(new Politician("Trump","US"));
        politicians.add(new Politician("Xi Jinping","China"));
        politicians.add(new Politician("Macron","France"));
        return politicians;
    }
	
	@POST
    @Path("addPolitician")
    @Consumes(MediaType.APPLICATION_XML )
	@Produces(MediaType.APPLICATION_XML )
    public List<Politician> addPolitician(Politician politician) {
		politicians.add(politician);
        return politicians; 
    }
}
