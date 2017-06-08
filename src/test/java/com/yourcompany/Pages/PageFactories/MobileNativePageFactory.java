package com.yourcompany.Pages.PageFactories;
import com.yourcompany.Pages.GuineaPigPage;
import com.yourcompany.Pages.HomePage;
import com.yourcompany.Pages.LoginPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by neil on 3/1/17.
 */
public interface MobileNativePageFactory {
    GuineaPigPage createGuineaPigPage(WebDriver driver);
}