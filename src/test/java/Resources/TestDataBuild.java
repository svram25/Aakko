package Resources;

import java.util.ArrayList;
import java.util.List;

import pojo.Deletelocation;
import pojo.SerialPojo;
import pojo.location;

public class TestDataBuild {
	
	public static SerialPojo addPlacePayload(String name, String language, String address) {
		
		SerialPojo obj = new SerialPojo();
		obj.setAccuracy(50);
		obj.setAddress(address);
		obj.setLanguage(language);
		obj.setName(name);
		obj.setPhone_number("(+91) 983 893 3937");
		obj.setWebsite("http://google.com");
		
		List<String> listobj = new ArrayList<String>();
		listobj.add("shoe park");
		listobj.add("shop");
		obj.setTypes(listobj);
		
		location objlocation = new location();
		objlocation.setLat(-38.383494);
		objlocation.setLng(33.427362);
		obj.setLocation(objlocation);
		
		return obj;
	
	}
	
	public static Deletelocation deletePayload(String place_id) {
	
	Deletelocation delobj = new Deletelocation();
	delobj.setPlace_id(place_id);
	return delobj;
	}
	

}
