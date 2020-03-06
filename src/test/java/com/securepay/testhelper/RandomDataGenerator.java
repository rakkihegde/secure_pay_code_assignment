package com.securepay.testhelper;

import com.github.javafaker.Company;
import com.github.javafaker.Faker;

public class RandomDataGenerator {
    private Faker theDataGenerator;
    private Company theCompany;
    private String theFirstName;
    private String theLastName;

    public RandomDataGenerator() {
        theDataGenerator = new Faker();
    }

    public String getEmail() {
        return theDataGenerator.bothify(getFirstName() + "." + getLastName() + "@gmail.com");
    }

    public String getFirstName() {
        theFirstName = theDataGenerator.name().firstName();
        return theFirstName;
    }

    public String getLastName() {
        theLastName = theDataGenerator.name().lastName();
        return theLastName;
    }

    public String getPhoneNumber() {
        return theDataGenerator.phoneNumber().phoneNumber();
    }

    public String getUrl() {
        theCompany = theDataGenerator.company();
        return theCompany.url();
    }

    public String getCompanyName() {
        return theCompany.name();
    }

    public String getMessage() {
        return "I, " + theFirstName + " " + theLastName + ", from company " + getCompanyName()
                + " need assistance with setting up my account.";
    }
}
