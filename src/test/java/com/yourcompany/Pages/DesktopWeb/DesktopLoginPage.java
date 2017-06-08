package com.yourcompany.Pages.DesktopWeb;

import com.yourcompany.Pages.BasePage;
import com.yourcompany.Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DesktopLoginPage extends BasePage implements LoginPage {

    By usernameLocator = By.cssSelector("[name='username']");
    By passwordLocator = By.cssSelector("[name='password']");
    By signInButton = By.cssSelector("#submit");

    By invalidMessage = By.xpath("//*[contains(text(), 'Invalid username or password')]");

    public DesktopLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void invalidLogin() throws Exception {
        sendKeys(usernameLocator, "invalid_username");
        sendKeys(passwordLocator, "invalid_password");
        click(signInButton);
    }

    @Override
    public boolean isInvalidMessage() {
        try {
            waitForElement(invalidMessage);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
