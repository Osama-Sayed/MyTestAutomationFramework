package runner;

import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features = "src/test/java/features", glue = ("setupDefinition"), plugin = {"pretty","html:target/cucumber-html-report.html"})
public class TestRunner  {


}
