package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;


public class TestBase {
    public AppiumDriver driver;

    @BeforeMethod
    public void initDriver() {

    }

//    @AfterMethod
//    public void tearDownForTest(){
//        driver.quit();
//    }
}
