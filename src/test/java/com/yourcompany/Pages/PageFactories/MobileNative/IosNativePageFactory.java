package com.yourcompany.Pages.PageFactories.MobileNative;

import com.yourcompany.Pages.GuineaPigPage;
import com.yourcompany.Pages.HomePage;
import com.yourcompany.Pages.LoginPage;
import com.yourcompany.Pages.MobileNative.Android.MobileNativeAndroidGuineaPigPage;
import com.yourcompany.Pages.MobileNative.iOS.MobileNativeIosGuineaPigPage;
import com.yourcompany.Pages.PageFactories.MobileNativePageFactory;
import org.openqa.selenium.WebDriver;

/**
 * Created by neil on 6/3/17.
 */
public class IosNativePageFactory implements MobileNativePageFactory {

    @Override
    public GuineaPigPage createGuineaPigPage(WebDriver driver) {
        return new MobileNativeIosGuineaPigPage(driver);
    }
}
