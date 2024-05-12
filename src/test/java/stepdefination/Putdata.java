package stepdefination;

import java.io.FileInputStream; 
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Putdata {
	RequestSpecification resp;
	Response  response;
	@Given("Body take from json")
	public void Body_take_from_json() throws FileNotFoundException {
		FileInputStream file=new FileInputStream("./src/test/resources/jsoninput/putdata.json");
	    resp = RestAssured.given().body(file).log().all().contentType(ContentType.JSON);
	}
	@When("I do put request with url")
	public void i_do_put_request_with_url() throws IOException {
		FileInputStream file=new FileInputStream("./src/test/resources/property/putdata.properties");
		Properties prop=new Properties();
		prop.load(file);
		String url=prop.getProperty("URL");
		String endpoint=prop.getProperty("endpoint");
        System.out.println("Actual endpoint:"+url.concat(endpoint));
		response = resp.when().put(url.concat(endpoint));
	}
	@Then("Get the response and verify details put")
	public void get_the_response_and_verify_details_put() {
		response.then().statusCode(200).log().all();	
	}

}
