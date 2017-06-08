package com.yourcompany.Pages.PageFactories;

import com.yourcompany.Pages.DesktopWeb.DesktopHomePage;
import com.yourcompany.Pages.DesktopWeb.DesktopLoginPage;
import com.yourcompany.Pages.LoginPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by neil on 5/27/17.
 */
public class DesktopWebPageFactory implements PageFactory {
    @Override
    public DesktopHomePage createSauceHomePage(WebDriver driver) {
        return new DesktopHomePage(driver);
    }

    @Override
    public LoginPage createSauceLoginPage(WebDriver driver) {
        return new DesktopLoginPage(driver);
    }
}
