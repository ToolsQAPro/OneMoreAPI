package stepdefination;
import java.io.FileInputStream;  
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.util.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
public class Getuser {
    private Response response;
    @Given("I have the API endpoint")
    public void iHaveTheAPIEndpoint() throws IOException {
    	FileInputStream file=new FileInputStream("./src/test/resources/property/getuser.properties");
		Properties prop=new Properties();
		prop.load(file);
		String url=prop.getProperty("URL");
		String query=prop.getProperty("query");
        RestAssured.baseURI = url.concat(query);
        System.out.println("Actual endpoint:"+url.concat(query));
    }
    @When("I send a GET request")
    public void iSendAGETRequest() {
        // Send the GET request
        response = RestAssured.given().get();
    }
    @Then("the response status code should be")
    public void theResponseStatusCodeShouldBe() {
    	int expectedStatusCode=200;
        response.then().statusCode(expectedStatusCode).log().all(); 
//        int data = response.statusCode();
//        System.out.println("Atul--> "+data);
         
    }
}
