package stepDefination;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException
	{
		
		stepDefination m = new stepDefination();
		if(stepDefination.placeId==null) {
		m.add_Place_Payload_with("Hello", "World", "Ciao");
		m.user_calls_with_http_request("AddPlaceAPI", "POST");
		m.verify_place_ID_created_maps_to_using("Hello", "getPlaceAPI");
	}
	
	}
}
