package org.dorum.automation.runners;

import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "org.dorum.automation.steps",
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class TestRunner extends TestBase {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}