package com.yourcompany.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.Collections;

/**
 * Created by neil on 5/27/17.
 */
public class TOUtils {
    static String webAccesskey = System.getenv("TO_WEB_ACCESS_KEY");
    static String iosAccessKey = System.getenv("TO_IOS_ACCESS_KEY");
    static String androidAccessKey = System.getenv("TO_ANDROID_ACCESS_KEY");

    public static boolean isTO(WebDriver driver) {
        return ((RemoteWebDriver) driver).getCapabilities().getCapability("testobject_device") != null;
    }

    public static boolean isTO(String browser) {
        return browser.contains("TestObject");
    }

    public static DesiredCapabilities CreateCapabilities(String browser, String version, String os, String pageobject, String methodName) {
        String key = "";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("testobject_device", os);
        if (pageobject.contains("MobileNative")) {
            key = pageobject.contains("Android") ? androidAccessKey : iosAccessKey;
        } else {
            key = webAccesskey;
        }
        caps.setCapability("testobject_api_key", key);
        caps.setCapability("testobject_test_name", methodName);

        caps.setCapability("testobject_appium_version", "1.6.4");
        caps.setCapability("deviceOrientation", "portrait");

        caps.setCapability("testobject_cache_device", "true");
        return caps;
    }

    public static String getURL() {
        return "https://us1.appium.testobject.com/wd/hub";
    }

    public static void updateResults(String sessionid, Boolean status) {
        Client client = ClientBuilder.newClient();
        WebTarget resource = client.target("https://app.testobject.com/api/rest/appium/v1/");
        resource.path("session")
                .path(sessionid)
                .path("test")
                .request(new MediaType[]{MediaType.APPLICATION_JSON_TYPE}).
                put(Entity.json(Collections.singletonMap("passed", status)));
    }
}
