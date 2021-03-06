package resources;

public enum APIResources {

	AddPlaceAPI("/maps/api/place/add/json"),
	DeletePlaceAPI("/maps/api/place/delete/json"),
	GetPlaceAPI("/maps/api/place/get/json"),
	UpdatePlaceAPI("/maps/api/place/update/json");

	private String resource;

	//Constructor to set resource value
	APIResources(String resource) {
		this.resource = resource;
	}

	public String getResource() {
		return resource;
	}

}
