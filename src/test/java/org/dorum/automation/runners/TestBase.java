package org.dorum.automation.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

@Log4j2
public class TestBase extends AbstractTestNGCucumberTests {

    @BeforeMethod
    public void beforeMethod() {
        log.info("Before method");
    }

    @AfterMethod
    public void afterMethod() {
        log.info("After method");
    }
}
