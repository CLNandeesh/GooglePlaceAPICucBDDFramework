package stepDefnitions;

import java.io.IOException;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import resources.Utils;

public class Hooks {

	/*
	 * @Before("@DeletePlace") public void beforeScenario(Scenario scenario) throws
	 * IOException {
	 * 
	 * System.out.println(scenario.getName() + " started execution");
	 * 
	 * TC_AddPlace ap = new TC_AddPlace();
	 * 
	 * if (Utils.placeID == null) { ap.add_Place_Payload_with("raghu", "Kannada",
	 * "Mysore"); ap.user_calls_api_with_http_request("AddPlaceAPI", "POST");
	 * ap.verify_place_id_created_maps_to_using("raghu", "GetPlaceAPI"); }
	 * 
	 * }
	 */

	@Before()
	public void beforeScenario(Scenario scenario) throws IOException {

		System.out.println(scenario.getName() + " started execution");

	}

	@After()
	public void afterScenario(Scenario scenario) throws IOException {

		System.out.println(scenario.getName() + " finished execution");

	}

}
