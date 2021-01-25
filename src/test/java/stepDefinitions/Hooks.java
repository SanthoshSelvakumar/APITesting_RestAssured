package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks
{
	@Before("@deleteplaceAPI")
	public void stub() throws IOException {
	if(AddPlaceStepDefinition.placeID==null)
	{
	AddPlaceStepDefinition a=new AddPlaceStepDefinition();
	a.user_should_have_a_add_place_api_details_and_key_for_authentication("RBNM","Japanse","Service Provider","Showroom",45.23566,67.34341);
	a.the_request_is_sent_through_method("addPlaceAPI", "POST");
	a.read_the_placeid_value();
	}
	}

}
