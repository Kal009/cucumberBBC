package test;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumebr.json","pretty:target/cucumber-pretty.txt"},
        features = ".")
public class RunnerTest {
}
