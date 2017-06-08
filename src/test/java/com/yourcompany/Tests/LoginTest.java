package com.yourcompany.Tests;

import com.yourcompany.Pages.HomePage;
import com.yourcompany.Pages.LoginPage;
import junit.framework.Assert;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Method;


/**
 * Created by neil
 */

public class LoginTest extends TestBase {

    /**
     * Runs a simple test verifying if the comment input is functional.
     * @throws InvalidElementStateException
     */
    @org.testng.annotations.Test(dataProvider = "hardCodedBrowsers")
    public void invalidLoginTest(String browser, String version, String os, String pageobject, Method method)
            throws Exception {
        this.createDriver(browser, version, os, pageobject,method.getName());
        WebDriver driver = getWebDriver();

        HomePage homePage = pageFactory.createSauceHomePage(driver);
        homePage.visitPage();
        homePage.goToLogin();

        LoginPage loginPage = pageFactory.createSauceLoginPage(driver);
        loginPage.invalidLogin();

        Assert.assertTrue("Invalid Login Message not present",
                loginPage.isInvalidMessage());
    }

}