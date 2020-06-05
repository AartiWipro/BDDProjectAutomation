package automation.stepDefinitions;

/*import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@cucumber.options(format = {"pretty", "html:target/cucumber-htmlreport","json-pretty:target/cucumber-report.json"})
public class RunCukes {

}*/

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"D:/workplace/BDDAutomation/src/test/resources/automation/testcases"},
        glue= {"StepDef", "D:/workplace/BDDAutomation/src/test/java/automation/stepDefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports"},
        monochrome = true)
public class RunCukes
{

}
