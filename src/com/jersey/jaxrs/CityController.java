package com.jersey.jaxrs;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;




@Path("/cities")
public class CityController {
	
	CityService cs = new CityService();
	
	@GET
	@Path("/getall")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<City> getAllFriends(){
		System.out.println("Cities");
		List<City> cities = cs.getAllCities();
		
		for(City c:cities){
			System.out.println(c.id + " " + c.name);
		}
		
		return cities;
	}
	
	
	@GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public City getCityById(@PathParam("id") int id)
	{	
		System.out.println("Cities");
		  return cs.getCity(id);
	}
	
	
	 @POST
	 @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	 public List<City> addCity(City city)
	 {  
		 System.out.println("Cities");
	  List<City> cities = cs.addCity(city);
		for(City c:cities)
		{
			System.out.println(c.id + " " + c.name);
		}
		return cities;
	 }
	 
	 @PUT
	    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	 public List<City> updateCity(City city)
	 {		System.out.println("Cities");
		 List<City> cities = cs.updateCity(city);
			for(City c:cities)
			{
				System.out.println(c.id + " " + c.name);
			}
			return cities;
	 }
	 
	    @DELETE
	    @Path("/{id}")
	    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	 public List<City> deleteCountry(@PathParam("id") int id)
	 {System.out.println("Cities");
	    	List<City> cities = cs.deleteCity(id);
	    	for(City c:cities)
			{
				System.out.println(c.id + " " + c.name);
			}

	    	return cities;
	  
	 }
}
