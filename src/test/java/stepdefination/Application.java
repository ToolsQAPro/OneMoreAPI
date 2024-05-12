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
public class Application {
	RequestSpecification resp;
	Response  response;
	@Given("Body taking from json") 
	public void body_taking_from_json() throws FileNotFoundException {
		FileInputStream file=new FileInputStream("./src/test/resources/jsoninput/application.json");
	    resp = RestAssured.given().body(file).log().all().contentType(ContentType.JSON);
	}
	@When("I do post request with url")
	public void i_do_post_request_with_url() throws IOException {
		FileInputStream file=new FileInputStream("./src/test/resources/property/application.properties");
		Properties prop=new Properties();
		prop.load(file);
		String url=prop.getProperty("URL");
		response = resp.when().post(url);
	}
	@Then("Get the response and verify details")
	public void get_the_response_and_verify_details() {
	response.then().statusCode(201).log().all();	
	}
}
