package testrunner;

import org.junit.runner.RunWith;    

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)

@CucumberOptions(features= {
		"./src/test/resources/feature/application.feature",
		"./src/test/resources/feature/getuser.feature",
		"./src/test/resources/feature/putdata.feature"
		
},
glue="stepdefination",
dryRun=false
		

		)
public class Testrunner {
}
