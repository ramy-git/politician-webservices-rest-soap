package com.rest.service.client;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

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
