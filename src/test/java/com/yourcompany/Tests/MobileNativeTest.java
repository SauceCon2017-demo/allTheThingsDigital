package com.yourcompany.Tests;

import com.yourcompany.Pages.GuineaPigPage;
import junit.framework.Assert;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Method;
import java.util.UUID;


/**
 * Created by neil
 */

public class MobileNativeTest extends TestBase {

    /**
     * Runs a simple test verifying if the comment input is functional.
     * @throws InvalidElementStateException
     */
    @org.testng.annotations.Test(dataProvider = "hardCodedDevices")
    public void mobileNativeTestTest(String browser, String version, String os, String pageobject, Method method)
            throws Exception {
        this.createDriver(browser, version, os, pageobject, method.getName());
        WebDriver driver = getWebDriver();

        String commentInputText = UUID.randomUUID().toString();

        GuineaPigPage page = mobileNativePageFactory.createGuineaPigPage(driver);

        page.submitComment(commentInputText);

        String submittedComment = page.getSubmittedCommentText();

        Assert.assertTrue(page.getSubmittedCommentText().contains(commentInputText));
    }

}