package org.dorum.automation.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.extern.log4j.Log4j2;
import org.dorum.automation.pages.BasePage;
import org.dorum.automation.utils.WebDriverFactory;

@Log4j2
public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        log.info("Starting scenario {}", scenario.getName());
        WebDriverFactory.createDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        log.info("Finishing scenario {}", scenario.getName());
        if (scenario.isFailed()) {
            BasePage.takeScreenShot(scenario, scenario.getName() + "-" + Thread.currentThread().getId());
        }
        WebDriverFactory.quitDriver();
    }
}
