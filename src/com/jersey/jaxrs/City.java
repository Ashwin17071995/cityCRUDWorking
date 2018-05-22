package com.jersey.jaxrs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name = "city")
@XmlAccessorType(XmlAccessType.FIELD)

public class City {
	
	public int id;
	public String name;
	public int population;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	
	public City(int id, String name,int population) {
		super();
		this.id = id;
		this.name = name;
		this.population = population;
	}
	
	public City() {
		super();
		
	}

}
