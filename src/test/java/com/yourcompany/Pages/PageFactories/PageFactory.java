package com.yourcompany.Pages.PageFactories;
import com.yourcompany.Pages.HomePage;
import com.yourcompany.Pages.LoginPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by neil on 3/1/17.
 */
public interface PageFactory {
    HomePage createSauceHomePage(WebDriver driver);

    LoginPage createSauceLoginPage(WebDriver driver);
}