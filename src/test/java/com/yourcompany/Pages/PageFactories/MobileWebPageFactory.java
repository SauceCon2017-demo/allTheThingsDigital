package com.yourcompany.Pages.PageFactories;

import com.yourcompany.Pages.MobileWeb.MobileWebHomePage;
import com.yourcompany.Pages.MobileWeb.MobileWebLoginPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by neil on 5/27/17.
 */
public class MobileWebPageFactory implements PageFactory {
    @Override
    public MobileWebHomePage createSauceHomePage(WebDriver driver) {
        return new MobileWebHomePage(driver);
    }

    @Override
    public MobileWebLoginPage createSauceLoginPage(WebDriver driver) {
        return new MobileWebLoginPage(driver);
    }
}
