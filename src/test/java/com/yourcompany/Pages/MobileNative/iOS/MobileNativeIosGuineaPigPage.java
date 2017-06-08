package com.yourcompany.Pages.MobileNative.iOS;

import com.yourcompany.Pages.BasePage;
import com.yourcompany.Pages.GuineaPigPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by neil on 6/3/17.
 */
public class MobileNativeIosGuineaPigPage extends BasePage implements GuineaPigPage {

    By h1Text = By.id("h1Text");
    By yourComments = By.id("submittedComments");
    By commentsTextInput = By.id("comments");
    By submitBtn = By.id("submit");

    public MobileNativeIosGuineaPigPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void submitComment(String comment) throws Exception {
        click(commentsTextInput);
        sendKeys(commentsTextInput, comment);
        click(h1Text);
        click(yourComments);

        click(submitBtn);
    }

    @Override
    public String getSubmittedCommentText() {
        return getText(yourComments);
    }
}
