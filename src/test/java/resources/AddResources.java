package resources;

public enum AddResources {
	
	addPlaceAPI("maps/api/place/add/json"),deletePlaceAPI("maps/api/place/delete/json"),
	getPlaceAPI("maps/api/place/get/json"),putPlaceAPI("maps/api/place/update/json");
	String resource;

	AddResources(String resource ) {
		this.resource=resource;
	}

	public String getResource()
	{
		return resource;
	}
}
