package com.securepay;

import com.securepay.testhelper.RandomDataGenerator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.securepay.webdrivers.ChromeWebDriver;

import static org.junit.Assert.assertEquals;


public class TestSecurePayContactUsPage
{
    public static ChromeWebDriver theWebDriver = WebDriverProvider.getChromeDriverInstance();
    public RandomDataGenerator theDataGenerator = new RandomDataGenerator();
    private static final String VALUE = "value";
    private static final String MESSAGE = "message";
    private static final String URL = "website-url";
    private static final String SUPPORT = "Support";
    private static final String PHONE = "phone-number";
    private static final String GOOGLE_SEARCH_BAR = "q";
    private static final String EMAIL = "email-address";
    private static final String LAST_NAME = "last-name";
    private static final String SECURE_PAY = "SecurePay";
    private static final String CONTACT_US = "Contact Us";
    private static final String FIRST_NAME = "first-name";
    private static final String REASON = "reason-for-enquiry";
    private static final String COMPANY_NAME = "business-name";
    private static final String GOOGLE_URL = "http://www.google.com.au";
    private static final String SECURE_ONLINE_PAYMENT = "SecurePay online payment";


    public void populateContactUsPageWithRandomData()
    {
        populateFieldName(theWebDriver.findElementByName(FIRST_NAME), theDataGenerator.getFirstName());
        populateFieldName(theWebDriver.findElementByName(LAST_NAME), theDataGenerator.getLastName());
        populateFieldName(theWebDriver.findElementByName(EMAIL), theDataGenerator.getEmail());
        populateFieldName(theWebDriver.findElementByName(PHONE), theDataGenerator.getPhoneNumber());
        populateFieldName(theWebDriver.findElementByName(URL), theDataGenerator.getUrl());
        populateFieldName(theWebDriver.findElementByName(COMPANY_NAME), theDataGenerator.getCompanyName());
        new Select(theWebDriver.findElementByName(REASON)).selectByValue(SUPPORT);
        populateFieldName(theWebDriver.findElementByName(MESSAGE), theDataGenerator.getMessage());
    }

    public void launchGoogleAndNavigateToSecurePayContactUsPage()
    {
        launchGoogleAndSearchForSecurePay();
        clickOnSecurePayOnlinePaymentLinkToGoToWebPage();
        navigateToContactUsPage();
    }

    public String getPageTitle()
    {
        return theWebDriver.getPageTitle();
    }

    private void populateFieldName(WebElement aWebElement, String aValueToSet)
    {
        aWebElement.sendKeys(aValueToSet);
        assertEquals(aWebElement.getAttribute(VALUE), aValueToSet);
    }

    private static void launchGoogleAndSearchForSecurePay()
    {
        theWebDriver.launchWebPage(GOOGLE_URL);
        WebElement myGoogleSearchBox = theWebDriver.findElementByName(GOOGLE_SEARCH_BAR);
        myGoogleSearchBox.sendKeys(SECURE_PAY);
        myGoogleSearchBox.submit();
        theWebDriver.waitForWebPageToLoad();
    }

    private static void clickOnSecurePayOnlinePaymentLinkToGoToWebPage()
    {
        theWebDriver.findElementByPartialLinkText(SECURE_ONLINE_PAYMENT).click();
    }

    private static void navigateToContactUsPage()
    {
        theWebDriver.findByLinkText(CONTACT_US).click();
        theWebDriver.waitForWebPageToLoad();
    }
}
