package stepDefnitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;
import java.io.IOException;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

import static io.restassured.RestAssured.given;

public class TC_AddPlace extends Utils {

	@Given("Add Place Payload with {string}  {string} {string}")
	public void add_Place_Payload_with(String name, String language, String address) throws IOException {

		requestSpecification = given().spec(requestSpecification())
				.body(TestDataBuild.addPlacePayload(name, language, address));

	}

	@When("User calls {string} api with {string} http request")
	public void user_calls_api_with_http_request(String resource, String httpMethod) {

		// Create Obj for ebum class
		resourceAPI = APIResources.valueOf(resource);

		if (httpMethod.equalsIgnoreCase("POST")) {
			response = requestSpecification.when().post(resourceAPI.getResource());
		}

		else if (httpMethod.equalsIgnoreCase("GET")) {
			response = requestSpecification.when().get(resourceAPI.getResource());
		}

		else if (httpMethod.equalsIgnoreCase("DELETE")) {
			response = requestSpecification.when().delete(resourceAPI.getResource());
		}

	}

	// Validate status code
	@Then("api call got success with status code <{int}>")
	public void api_call_got_success_with_status_code(int code) {
		assertEquals(code, response.getStatusCode());
	}

	@Then("{string} in response is {string}")
	public void in_response_is(String key, String expectedValue) {

		// jsonPath = new JsonPath(response.asString());
		// assertEquals(jsonPath.getString(key), value);
		// Call getValueForKey() and send response and key for which u need value
		assertEquals(getValueForKey(response, key), expectedValue);

	}

	@Then("verify place_id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedName, String resource) throws IOException {

		placeID = getValueForKey(response, "place_id");
		System.out.println(placeID);

		// Form request
		requestSpecification = given().spec(requestSpecification()).queryParam("place_id", placeID);

		// Hit API using existing method
		user_calls_api_with_http_request(resource, "GET");

		// response has all response content of type Response
		System.out.println("Expected Name " + expectedName);
		System.out.println("Actual name " + getValueForKey(response, "name"));
		System.out.println("Longitude " + getValueForKey(response, "location.longitude"));
		System.out.println("Latitude " + getValueForKey(response, "location.latitude"));

		// Compare name
		assertEquals(getValueForKey(response, "name"), expectedName);

	}

}
