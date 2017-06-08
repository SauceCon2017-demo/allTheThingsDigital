package com.yourcompany.Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by neil on 5/27/17.
 */
public class SauceUtils {
    static String username = System.getenv("SAUCE_USERNAME");
    static String accesskey = System.getenv("SAUCE_ACCESS_KEY");

    static String androidApp = "https://github.com/saucelabs-sample-test-frameworks/GuineaPig-Sample-App/blob/master/android/GuineaPigApp-debug.apk?raw=true";
    static String iosApp = "https://github.com/saucelabs-sample-test-frameworks/Java-Junit-Appium-iOS/blob/master/resources/SauceGuineaPig-sim-debug.app.zip?raw=true";

    public static boolean isSauce(String os, String pageobject) {
        return os.contains("Simulator") || os.contains("Emulator") || pageobject.equals("DesktopWeb");
    }

    public static DesiredCapabilities CreateCapabilities(String browser, String version, String os, String pageobject, String methodName) {
        DesiredCapabilities caps = new DesiredCapabilities();
        Boolean isEmulator = os.contains("Emulator");
        Boolean isSimulator = os.contains("Simulator");

        if (isEmulator || isSimulator) {
            caps.setCapability("platformName", isEmulator ? "Android" : "iOS"); // TO DO
            caps.setCapability("platformVersion", version);
            caps.setCapability("deviceName", os);

            caps.setCapability("browserName", browser);

            caps.setCapability("appiumVersion", "1.6.4");

            if (pageobject.contains("MobileNative")) {
                caps.setCapability("app", isEmulator ? androidApp : iosApp);
            }

        } else {
            caps.setCapability("browserName", browser);
            caps.setCapability("version", version);
            caps.setCapability("platform", os);

        }
        caps.setCapability("name", methodName);




        return caps;
    }

    public static String getURL() {
        return "https://" + username + ":" + accesskey + "@ondemand.saucelabs.com:443/wd/hub";
    }

    public static void updateResults(WebDriver driver, Boolean status) {
        ((JavascriptExecutor) driver).executeScript("sauce:job-result=" +
                (status ? "passed" : "failed"));
    }
}
