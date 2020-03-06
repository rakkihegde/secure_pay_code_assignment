package com.securepay.webdrivers;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeWebDriver extends BaseWebDriver {
    private static final String CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String CHROME_DRIVER_PATH = "src/test/resources/chromedriver.exe";

    public ChromeWebDriver() {
        System.setProperty(CHROME_DRIVER, CHROME_DRIVER_PATH);
        setWebDriver(new ChromeDriver());
    }
}
