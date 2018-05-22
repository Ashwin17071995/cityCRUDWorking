package com.jersey.jaxrs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class CityService {
	
	
	static HashMap<Integer, City> cityMap = getCityMap();
	
	public CityService() {
		super();
		
		City c1 = new City(1, "CSK", 10000);
		City c2 = new City(2, "KKR", 20000);
		City c3 = new City(3, "SRH", 30000);
		City c4 = new City(4, "RR", 40000);
		
		cityMap = new HashMap<Integer,City>();
		
		cityMap.put(1, c1);
		cityMap.put(2, c2);
		cityMap.put(3, c3);
		cityMap.put(4, c4);
		
	}

	private static HashMap<Integer, City> getCityMap() {
		// TODO Auto-generated method stub
		return cityMap;
	}
	
	public List<City> getAllCities()
	 {
	  List<City> cities = new ArrayList(cityMap.values());
	  return cities;
	 }

	public City getCity(int id)
	 {
	  City city= cityMap.get(id);
	  return city;
	 }
	
	public List<City> addCity(City city)
	 {
	  cityMap.put(city.getId(), city);
	  List<City> cities = new ArrayList(cityMap.values());
	  connectDB(city);
	  return cities;
	 }
	 public List<City> updateCity(City city)
	 {
	  if(city.getId()<=0)
	   return null;
	  cityMap.put(city.getId(), city);
	  List<City> cities = new ArrayList(cityMap.values());
	  return cities;

	 
	 }
	 public List<City> deleteCity(int id)
	 {
		 cityMap.remove(id);
		 List<City> cities = new ArrayList(cityMap.values());
		  return cities;
	 }
	 
	 
	 public static void connectDB(City city)	
		{
		MongoClient mongoClient = null;
		try
		{	
			mongoClient = new MongoClient();	
			DB db = mongoClient.getDB("city");
			DBCollection collection = db.getCollection("cities");
			
			System.out.println("collection : "+collection);
			
			final BasicDBObject basic1 = new BasicDBObject();
		      
					basic1.put("id", city.getId());
					basic1.put("name", city.getName());
					basic1.put("population", city.getPopulation());    
					collection.insert(basic1);
					System.out.println("Employee 1: " + basic1.toJson());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			  mongoClient.close();
			}
		
		}
	 
}
