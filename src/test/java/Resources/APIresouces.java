package Resources;

public enum APIresouces {
	
	AddPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	DeletePlaceAPI("/maps/api/place/delete/json");
	
	private String resource;
	
	APIresouces(String resource){
		this.resource = resource;
	}
	public String getResource() {
		
		return resource;
	}

}
