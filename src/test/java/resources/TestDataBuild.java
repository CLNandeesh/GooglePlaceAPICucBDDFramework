package resources;

import java.util.ArrayList;

import java.util.List;

import pojo.*;

public class TestDataBuild {

	public static AddPlacePayload addPlacePayload(String name,String language,String address) {

		AddPlacePayload a = new AddPlacePayload();
		a.setAccuracy(50);
		a.setName(name);
		a.setPhone_number("(+91) 983 893 3937");
		a.setAddress(address);
		a.setWebsite("http://google.com");
		a.setLanguage(language);

		// To add list of types
		List<String> l = new ArrayList<String>();
		l.add("shoe park");
		l.add("shop");
		a.setTypes(l);

		//
		Location loc = new Location();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		a.setLocation(loc);

		return a;
	}
	
	public static String deletePlacePayload(String placeID)
	{
		return "{\r\n" + 
				"    \"place_id\":\""+placeID+"\"   	 	\r\n" + 
				"}\r\n" + 
				"";
	}

}
