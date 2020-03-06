package com.securepay.stepdefinition;

import static org.junit.Assert.*;

import com.securepay.TestSecurePayContactUsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SecurePayContactUsSteps {
    private static final String CONTACT_US = "Contact Us – SecurePay – Sales – Support – Accounts";
    private TestSecurePayContactUsPage theContactUsPage = new TestSecurePayContactUsPage();

    @Given("Open Google and navigate to SecurePay Contact Us page")
    public void openGoogleNavigateToSecurePay() {
        theContactUsPage.launchGoogleAndNavigateToSecurePayContactUsPage();
    }

    @When("Contact Us page has been loaded")
    public void contactUsPageHasBeenLoaded() {
        assertEquals(CONTACT_US, theContactUsPage.getPageTitle());
    }

    @Then("Fill in all the fields using random data generator")
    public void fillInAllTheFieldsUsingRandomDataGenerator() {
        theContactUsPage.populateContactUsPageWithRandomData();
    }
}
