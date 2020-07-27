package stepDefnitions;

import io.cucumber.java.en.Given;
import resources.TestDataBuild;
import resources.Utils;
import static io.restassured.RestAssured.given;

import java.io.IOException;

public class TC_DeletePlace extends Utils{
	
	@Given("Delte Place payload")
	public void delte_Place_payload() throws IOException {
		requestSpecification=given().spec(requestSpecification()).body(TestDataBuild.deletePlacePayload(placeID));
	}


}
