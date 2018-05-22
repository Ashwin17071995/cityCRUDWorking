package com.jersey.jaxrs;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class MongoDB {
	
	public static void main(String[] args) {
	    connectDB();
	  }

	
	public static void connectDB()	
	{
	MongoClient mongoClient = null;
	try
	{	
		mongoClient = new MongoClient();	
		DB db = mongoClient.getDB("fromnode");
		DBCollection collection = db.getCollection("friends");
		
		System.out.println("collection : "+collection);
		
		final BasicDBObject basic1 = new BasicDBObject();
	      
	      basic1.put("id", 6);
	      basic1.put("name", "Amaury");
	      basic1.put("location", "Valdes");    
	      collection.insert(basic1);
	      System.out.println("Employee 1: " + basic1.toJson());
	      
	      final BasicDBObject basic2 = new BasicDBObject();
	      basic2.put("id", 6);
	      basic2.put("name", "Aasd");
	      basic2.put("location", "Vssdsds");     
	      collection.insert(basic2);
	      System.out.println("Employee 2: " + basic2.toJson());
	      
	      showAllDocs(collection);
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally{
		  mongoClient.close();
		}
	
	}
	
	
	
	public static void showAllDocs(final DBCollection collection) {
	    DBCursor cursor = (DBCursor) collection.find().iterator();
	    try {
	        while (cursor.hasNext()) {
	            System.out.println(cursor.next().toString());
	        }
	    } finally {
	        cursor.close();
	    }
	}
	
}
