package Resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	public static RequestSpecification reqSpecBuilder;
	
	public static String getGlobalProperties(String baseUri) throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("//Users//C-VAA//Documents//Selenium//APIFramework//src//test//java//Resources//Global.properties");
		prop.load(fis);
		return prop.getProperty(baseUri);
		
	}
	
	public RequestSpecification requestSpecification() throws IOException{
		
		if(reqSpecBuilder==null) {
		
		PrintStream log = new PrintStream(new FileOutputStream("RR_Pairs.txt"));
		reqSpecBuilder = new RequestSpecBuilder().setBaseUri(getGlobalProperties("baseUri"))
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.addQueryParam("key", "qaclick123")
				.setContentType(ContentType.JSON)
				.build();
		return reqSpecBuilder;
	}
		return reqSpecBuilder;
	}
	
	public String getJsonPath(Response response, String Key) {
		
		 String strResponse = response.asString();
	     JsonPath js = new JsonPath(strResponse);
		String value = js.get(Key);
		
		return value;
		
	}

}
