package com.securepay;

import com.securepay.webdrivers.ChromeWebDriver;

public class WebDriverProvider
{
    public static ChromeWebDriver getChromeDriverInstance()
    {
        if (theChromeWebDriver == null)
        {
            ChromeDriverProvider();
        }
        return theChromeWebDriver;
    }

    private static ChromeWebDriver theChromeWebDriver = null;

    private static void ChromeDriverProvider()
    {
        theChromeWebDriver = new ChromeWebDriver();
    }

    private static void FireFoxDriverProvider()
    {
        // Instantiate FireFox driver
    }

    private static void internetExplorerDriverProvider()
    {
        // Instantiate IE driver
    }
}
