package org.dorum.automation.pages;

import lombok.extern.log4j.Log4j2;
import org.dorum.automation.utils.WebDriverContainer;
import org.dorum.automation.utils.WebDriverWaitUtils;
import org.openqa.selenium.By;

@Log4j2
public class HomePage extends BasePage {

    private final By adobeImg = By.xpath("//span[@class='feds-brand-label' and text()='Adobe']");

    public void openPage(String url) {
        WebDriverContainer.getDriver().get(url);
        WebDriverWaitUtils.waitForUrlToContain(url);
        log.info("{} was opened", url);
    }

    public void isAdobePageLoaded() {
        WebDriverWaitUtils.waitForElementToBeVisible(adobeImg);
    }
}
