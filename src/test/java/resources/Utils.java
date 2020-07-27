package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {

	public ResponseSpecification responseSpecification;
	public static RequestSpecification requestSpecification;
	public Response response;
	public JsonPath jsonPath;
	public PrintStream log;
	public APIResources resourceAPI;
	public static String placeID;

	public RequestSpecification requestSpecification() throws IOException {
		
		if(responseSpecification==null)
		{
			log = new PrintStream(new FileOutputStream("Logging.txt",true));
			requestSpecification = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseURI"))
					.setContentType(ContentType.JSON).addQueryParam("key", "qaclick123")
					.addFilter(RequestLoggingFilter.logRequestTo(log)).addFilter(ResponseLoggingFilter.logResponseTo(log))
					.build();

			return requestSpecification;
		}
		
		return requestSpecification;
		
	}

	public ResponseSpecification responseSpecification() {
		responseSpecification = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
		return responseSpecification;
	}

	public String getGlobalValue(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("./src\\test\\java\\resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);

	}
	
	//Returns value in form of string
	public String getValueForKey(Response response,String key)
	{
		jsonPath=new JsonPath(response.asString());
		return jsonPath.get(key).toString();
		
	}
}
