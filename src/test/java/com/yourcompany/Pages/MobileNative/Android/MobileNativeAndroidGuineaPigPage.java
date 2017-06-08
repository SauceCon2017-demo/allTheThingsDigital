package com.yourcompany.Pages.MobileNative.Android;

import com.yourcompany.Pages.BasePage;
import com.yourcompany.Pages.GuineaPigPage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by neil on 6/3/17.
 */
public class MobileNativeAndroidGuineaPigPage extends BasePage implements GuineaPigPage {
    By h1Text = By.id("Heading1_1");
    By yourComments = By.id("your_comments");
    By commentsTextInput = By.id("comments");
    By submitBtn = By.id("submit");

    public MobileNativeAndroidGuineaPigPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void submitComment(String comment) throws Exception {
        click(commentsTextInput);
        sendKeys(commentsTextInput, comment);
        ((AndroidDriver)driver).hideKeyboard();
        click(h1Text);
        click(submitBtn);
    }

    @Override
    public String getSubmittedCommentText() {
        return getText(yourComments);
    }
}
