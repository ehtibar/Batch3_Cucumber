package utilityLibrary;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiLibrary {

	RequestSpecification request;
	
	Response response;
	
	JSONObject JsonBody = new JSONObject();

	public ApiLibrary() {
		RestAssured.baseURI = "http://ec2-3-86-91-230.compute-1.amazonaws.com:5000/";
		request = RestAssured.given();
	}


	/**********************
	 * Header & Body
	 **********************/
	
	//Method overloading
	public void setUpHeader() {
		request.headers("Content-type", "Application/json");
	}
	public void setUpHeader(String key, String value) {
		request.headers(key, value);
	}
	
	
	public void setUpBody(String key, String value) {
		JsonBody.put(key, value);
	}
	
	public void attachBody() {
		request.body(JsonBody.toJSONString());
	}
	
	
	
	/**********************
	 * API CALL
	 **********************/
	
	public void postApiCall(String appendUrl) {
		response = request.post(appendUrl);
	}
	
	public void getApiCall(String appendUrl) {
		response = request.get(appendUrl);
	}
	
	
	
	
	
	
	
	
	
	
	/**********************
	 * Response
	 **********************/
	
	public Response getResponse() {
		return response;
	}
	
	public int getStatusCode() {
		return response.getStatusCode();
	}
	
	public String getBodyAsString() {
		return response.getBody().asString();
	}
	
	public String getValueFromBody(String path) {
		return response.getBody().jsonPath().getString(path);
	}
	

}
