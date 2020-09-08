package com.rest.service.client;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import java.util.List;

public class JerseyClient {
	public static List<Politician> testResponseMsgList(){
		Client client = Client.create();
		WebResource webresource = client.resource("http://localhost:8085/PoliticianRESTService/rest/politicians");
		java.util.List<Politician> shares = webresource.get(new GenericType<java.util.List<Customer>>(){});
		return shares;
	}
        
}
