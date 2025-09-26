//package com.ninza.crm.tests.campaign;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.annotations.Test;
//import java.net.URL;
//import java.util.HashMap;
//import java.util.Map;
//
//public class BrowserStackDemo {
//    @Test
//    public void testBrowserStack() throws Exception {
//        String USERNAME = "sunilsamal_GUgefR";
//        String ACCESS_KEY = "LZvx7V6T2JpSAZT8kDzp";
//
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("browserName", "Chrome");
//        caps.setCapability("browserVersion", "114.0");
//
//        Map<String, Object> bstackOptions = new HashMap<>();
//        bstackOptions.put("os", "Windows");
//        bstackOptions.put("osVersion", "11");
//        bstackOptions.put("sessionName", "BrowserStack Demo Test");
//        caps.setCapability("bstack:options", bstackOptions);
//
//        WebDriver driver = new RemoteWebDriver(
//            new URL("https://" + "sunilsamal_GUgefR" + ":" + "LZvx7V6T2JpSAZT8kDzp" + "@hub.browserstack.com/wd/hub"),
//            caps
//        );
//
//        driver.get("http://49.249.28.218:8098/");
//        System.out.println("Page Title: " + driver.getTitle());
//        driver.quit();
//    }
//}
