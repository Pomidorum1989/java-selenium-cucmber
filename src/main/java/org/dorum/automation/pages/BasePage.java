package org.dorum.automation.pages;

import io.cucumber.java.Scenario;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.FileUtils;
import org.dorum.automation.utils.WebDriverContainer;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Log4j2
public class BasePage {

    public String getPageTitle() {
        return WebDriverContainer.getDriver().getTitle();
    }

    public static void takeScreenShot(Scenario scenario, String fileName) {
        File srcFile, destFile;
        String name = fileName.replaceAll("\\s", "");
        try {
            TakesScreenshot scrShot = ((TakesScreenshot) WebDriverContainer.getDriver());
            srcFile = scrShot.getScreenshotAs(OutputType.FILE);
            scenario.attach(Files.readAllBytes(srcFile.toPath()), "image/png", fileName);
            destFile = new File(String.format("target\\%s.png", name));
            FileUtils.copyFile(srcFile, destFile);
            String winHandle = WebDriverContainer.getDriver().getWindowHandle();
            log.info("Screenshot {} of window handle {} was created", name, winHandle);
        } catch (WebDriverException | IOException e) {
            log.error("Unable to create screenshot: {}", e.getMessage());
        }
    }

    public void waitForPageToLoad(int seconds) {
        boolean pageLoaded = false;
        int attempts = 0;
        while (!pageLoaded && attempts < seconds) {
            pageLoaded = ((JavascriptExecutor) WebDriverContainer.getDriver()).executeScript("return document.readyState").equals("complete");
            if (!pageLoaded) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    log.warn("Page still loading");
                }
            }
            attempts++;
        }
        if (pageLoaded) {
            log.info("Page is fully loaded in {} second(s)", attempts);
        } else {
            log.info("Page may not have fully loaded after {} second(s)", seconds);
        }
    }

}