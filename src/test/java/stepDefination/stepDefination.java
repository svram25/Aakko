package stepDefination;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.IOException;

import Resources.APIresouces;
import Resources.TestDataBuild;
import Resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class stepDefination extends Utils{
	
	RequestSpecification request;
	Response response;
	ResponseSpecification rspSpecBuilder;
	JsonPath js;
	String strResponse;
	static String placeId;
	
	TestDataBuild data = new TestDataBuild();
	
	
	@Given("Add Place Payload with {string} {string} {string}")
	public void add_Place_Payload_with(String name, String language, String address) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
				
			
			 
			request = given().spec(requestSpecification()).body(data.addPlacePayload(name,language,address));
	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
	    // Write code here that turns the phrase above into concrete actions
		
		APIresouces uri =  APIresouces.valueOf(resource);
		System.out.println(method+" "+uri.getResource());
		
		if (method.equals("POST"))
		response = request.when().post(uri.getResource());
		else if (method.equals("GET"))
		response = request.when().get(uri.getResource());
		else if (method.equals("PUT"))
		response = request.when().put(uri.getResource());
		else if (method.equals("DELETE"))
		response = request.when().delete(uri.getResource());
		
	}

	@Then("the API call is success with status code {int}")
	public void the_API_call_is_success_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(response.getStatusCode(),200);
		
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	     
	    assertEquals(getJsonPath(response, string),string2);
	    
	    
	}
	
	@Then("verify place_ID created maps to {string} using {string}")
	public void verify_place_ID_created_maps_to_using(String string, String string2) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		
		 placeId = getJsonPath(response, "place_id");
		request = given().spec(requestSpecification()).queryParam("place_id", placeId);
		user_calls_with_http_request(string2, "GET");
		String name = getJsonPath(response, "name");
		
		assertEquals(string, name);
		
	}
	
	@Given("DeletePlace Payload")
	public void deleteplace_Payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	  request = given().spec(requestSpecification()).body(data.deletePayload(placeId));
	}
}
