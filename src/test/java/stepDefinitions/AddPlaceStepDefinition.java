package stepDefinitions;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.AddResources;
import resources.TestData;
import resources.Utils;


public class AddPlaceStepDefinition extends Utils{
	RequestSpecification r;
	Response s;
	String validate;
	JsonPath j;
	static String placeID;
	TestData data=new TestData();
@Given("user should have a addPlaceAPI details {string} {string} {string} {string} {double} {double} and key for authentication")
public void user_should_have_a_add_place_api_details_and_key_for_authentication(String string, String string2, String string3, String string4,Double double1, Double double2) throws IOException {
		r=given().spec(requestSpecification()).body(data.requestBody(string,string2,string3,string4,double1,double2));
	}
@When("the {string} request is sent through {string} method")
public void the_request_is_sent_through_method(String string, String string2) throws IOException {
	AddResources resource=AddResources.valueOf(string);
	System.out.println(resource.getResource());
	if(string2.equalsIgnoreCase("POST"))
	 s=r.when().post(resource.getResource()).then().spec(responseSpecification()).extract().response();
	else if(string2.equalsIgnoreCase("GET"))
	{   r=given().spec(requestSpecification()).queryParam("place_id",placeID);
		s=r.when().get(resource.getResource()).then().spec(responseSpecification()).extract().response();
	}
	else if(string2.equalsIgnoreCase("PUT"))
	{
		
	}
	else if(string2.equalsIgnoreCase("DELETE"))
	{
		s=r.when().delete(resource.getResource()).then().spec(responseSpecification()).extract().response();
		
	}
}
@Then("the response should give {int} response")
public void the_response_should_give_response(Integer int1) 
{
	int p=s.getStatusCode();
	int q=int1;
	assertEquals(p,q);
}
@Then("read the placeid value")
public void read_the_placeid_value() {
validate=s.asString();
j=new JsonPath(validate);
placeID=j.get("place_id");

}
@Then("Verify the {string} through {string} method")
public void verify_the_through_method(String string, String string2) throws IOException {
	the_request_is_sent_through_method("getPlaceAPI",string2);
	the_response_should_give_response(200);
	validate=s.asString();
	j=new JsonPath(validate);
	String name=j.get("name");
	assertEquals(string,name);
	System.out.println(name);
	
}

@Given("user should have deleteplaceAPI request")
public void user_should_have_deleteplaceAPI_request() throws IOException {
	r=given().spec(requestSpecification()).body(data.deleterequestbody(placeID));
	}

}
