package com.securepay.webdrivers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseWebDriver {
    private static final String READY_STATE = "return document.readyState";
    private static final String COMPLETE = "complete";
    private static org.openqa.selenium.WebDriver theWebDriver;
    private static final int TIMEOUT = 30;

    public static void setWebDriver(WebDriver aWebDriver)
    {
        theWebDriver = aWebDriver;
    }

    public void waitForWebPageToLoad() {
        ExpectedCondition<Boolean> pageLoadCondition = webDriver -> {
            assert webDriver != null;
            return ((JavascriptExecutor) webDriver).executeScript(READY_STATE).equals(COMPLETE);
        };
        WebDriverWait wait = new WebDriverWait(theWebDriver, TIMEOUT);
        wait.until(pageLoadCondition);
    }

    public WebElement findElementByName(String aName)
    {
        return theWebDriver.findElement(By.name(aName));
    }

    public WebElement findElementByPartialLinkText(String aPartialLinkText)
    {
        return theWebDriver.findElement(By.partialLinkText(aPartialLinkText));
    }

    public WebElement findByLinkText(String aLinkText)
    {
        return theWebDriver.findElement(By.linkText(aLinkText));
    }

    public String getPageTitle()
    {
        return theWebDriver.getTitle();
    }

    public void launchWebPage(String aURL)
    {
        theWebDriver.get(aURL);
    }
}
