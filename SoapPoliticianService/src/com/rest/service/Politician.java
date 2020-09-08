package com.rest.service;

import javax.xml.bind.annotation.XmlRootElement;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

@WebService(targetNamespace = "http://service.rest.com/", portName = "PoliticianPort", serviceName = "PoliticianService")
@XmlRootElement(name = "Politicians") 
public class Politician {
	
	@XmlElement
	private String name;
	
	@XmlElement
	private String country;
	
	public Politician() {
		
	}

	public Politician(String name, String country) {
		this.name = name;
		this.country = country;
	}
}
