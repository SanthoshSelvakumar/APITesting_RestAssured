package resources;

import java.util.ArrayList;
import java.util.List;

import RestAPIAutomation.BDDFramework.AddPlaceLocation;
import RestAPIAutomation.BDDFramework.Location;

public class TestData {
	public AddPlaceLocation requestBody(String name,String language,String type,String shop,double lat,double lng)
	{
		AddPlaceLocation a=new AddPlaceLocation();
		Location l=new Location();
		l.setLat(lat);
		l.setLng(lng);
		a.setLocation(l);
		a.setAccuracy(50);
		a.setName(name);
		a.setPhone_number("+91 9876432160");
		a.setAddress("45,Chennai,India");
		List<String> t=new ArrayList<String>();
		t.add(type);
		t.add(shop);
		a.setTypes(t);
		a.setWebsite("http://google.com");
		a.setLanguage(language);
		return a;
	}
	public String deleterequestbody(String placeId)
	{
		return "{\r\n"
				+ "    \"place_id\":\""+placeId+"\"\r\n"
				+ "}";
		
	}

}
