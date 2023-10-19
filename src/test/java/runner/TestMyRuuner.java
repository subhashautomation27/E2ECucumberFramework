package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		    features="E:\\complete_Drive\\complete Cucumber Practies\\EndToEndCucumberFramwork\\EndToEndTutorialsProj\\src\\test\\resources\\features" ,
		    glue= {"stepdefinitions","hooks"} ,
		    publish=true,
		    plugin= {"pretty","html:target/E2EFramework/cucumberReport.html"}
		
		)
public class TestMyRuuner {

}
