package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class SearchWikiPageHelper extends PageBase{
    @FindBy(xpath = "//*[contains(@text,'Search Wikipedia')]")
    WebElement searchWikiField;

    @FindBy(xpath = "//*[contains(@text,'Search…')]")
    WebElement searchField;

    @FindBy(xpath = "//*[@class='android.widget.LinearLayout']")
    List<WebElement> listResult;


    public SearchWikiPageHelper startWikiInCustomePhone7() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "CustomePhone7");
        capabilities.setCapability("platformVersion", "7.0");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "D:/Olga/QA/AutoQA/IntelliG IDEA/OscarShopProjectQA56/QA56MobileWiki/apk/wikipedia.apk");
        capabilities.setCapability("automationName", "Uiautomator1");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        return this;
    }

    public String searchInWiki(String searchName){
        WebElement searchWikiField = driver.findElement(By.xpath("//*[contains(@text,'Search Wikipedia')]"));
        searchWikiField.click();

        WebElement searchField = driver.findElement(By.xpath("//*[contains(@text,'Search…')]"));
        searchField.sendKeys(searchName);

        waitUntilElementIsVisible(driver.findElement(By.xpath("//*[@class='android.widget.LinearLayout']")),5);

        WebElement searchQueryResult = driver.findElement(By.xpath(searchQueryLocator()));
        System.out.println("text of element:" + searchQueryResult.getText());

        return searchQueryResult.getText();
    }

    private String searchQueryLocator(){
        return "//*[contains(@text,'" + searchResultName + "')]";
    }
}
