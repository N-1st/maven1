package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


	

@CucumberOptions(
    features = "src/test/resources/features",
    glue = "stepDefinations",
    tags="@CartTest",
    // plugin = {"pretty", "html:target/cucumber-reports"}
	plugin = {"pretty", "json:target/cucumber-reports-json/Cucumber.json"}
)

public class CartRunner extends AbstractTestNGCucumberTests{
	
}
