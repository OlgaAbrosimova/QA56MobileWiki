package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.SearchPageHelper;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {
    public AppiumDriver driver;
    SearchPageHelper searchPage;
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","CustomePhone7");
        capabilities.setCapability("platformVersion","7.0");
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity",".main.MainActivity");
        capabilities.setCapability("app","D:/Olga/QA/AutoQA/IntelliG IDEA/OscarShopProjectQA56/QA56MobileWiki/apk/wikipedia.apk");
        capabilities.setCapability("automationName","Uiautomator1");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        searchPage = PageFactory
                .initElements(driver,SearchPageHelper.class);
        searchPage.waitUntilPageIsLoaded();
        searchPage.rotateScreenPORTRAIT();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
