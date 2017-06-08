package com.yourcompany.Pages.MobileWeb;

import com.yourcompany.Pages.BasePage;
import com.yourcompany.Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by neil on 5/27/17.
 */
public class MobileWebHomePage extends BasePage implements HomePage {

    public MobileWebHomePage(WebDriver driver) {
        super(driver);
    }
    private By menuBtn = By.cssSelector(".N54G");
    private By signInButton = By.cssSelector("#site-header a[data-reactid='69']");

    public static String url = "https://www.saucelabs.com";

    public void visitPage() {
        this.driver.get(url);
    }

    public void goToLogin() throws Exception {
        click(menuBtn);
        click(signInButton);
    }
}
