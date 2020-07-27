package runners;

import cucumber.api.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"src/test/java/features"},
plugin="json:target/jsonReports/cucumber-report.json",
                 glue= {"stepDefnitions"}
)
public class TestRunner {

}
