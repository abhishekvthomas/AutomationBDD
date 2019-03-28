package runner;

import org.junit.runner.RunWith;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@Test
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src\\test\\resources\\featureFiles"
		,glue={"steps"}
		)

public class TestRunner {

}
