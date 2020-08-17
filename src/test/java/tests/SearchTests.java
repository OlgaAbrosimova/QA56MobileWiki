package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CurrentArticlePageHelper;
import pages.MyListsPageHelper;
import pages.SearchPageHelper;
import util.DataProviders;


public class SearchTests extends TestBase {
    SearchPageHelper searchPage;
    CurrentArticlePageHelper articleSeleniumSoftware;

    @BeforeMethod
    public void initTests(){
        searchPage = PageFactory.initElements(driver,SearchPageHelper
                .class);
        articleSeleniumSoftware =
                new CurrentArticlePageHelper(driver,"Selenium (software)");
        searchPage.waitUntilPageIsLoaded();
    }

    @Test
    public void wikiTest()  {
        Assert.assertEquals("Search Wikipedia", searchPage
                .getSearchFieldText());
    }

    @Test
    public void searchArticle(){
        searchPage.enterSearchText("Selenium");
        Assert.assertTrue(searchPage
                .existArticleInSearchResult("Selenium (software)"));
    }

    @Test(dataProviderClass = DataProviders
            .class,dataProvider = "searchArticlesFromFile")
    public void searchArticleAndOpen(String search, String article){
        searchPage.enterSearchText(search)
                .openArticle(article);
        System.out.println("open ok");
        articleSeleniumSoftware.waitUntilPageIsLoaded();
        Assert.assertTrue(articleSeleniumSoftware
                .isOpenedCorrectly());
    }
    @Test(dataProviderClass = DataProviders
            .class,dataProvider = "searchArticle")
    public void searchArticleAndOpen2(String search, String article){
        searchPage.enterSearchText(search)
                .openArticle(article);
        articleSeleniumSoftware.waitUntilPageIsLoaded();
        Assert.assertTrue(articleSeleniumSoftware
                .isOpenedCorrectly());
    }

    @Test
    public void searchArticleOpenAndRotate(){
        String search = "Selenium";
        String article = "Selenium (software)";
        searchPage.enterSearchText(search)
                .openArticle(article);
        articleSeleniumSoftware.waitUntilPageIsLoaded()
                .rotateScreenLandscape();
        articleSeleniumSoftware.waitUntilPageIsLoaded();
        searchPage.rotateScreenPORTRAIT();
        articleSeleniumSoftware.waitUntilPageIsLoaded();
        Assert.assertTrue(articleSeleniumSoftware.isOpenedCorrectly());
    }
    @Test
    public void searchArticleOpenAndBackground(){
        String search = "Selenium";
        String article = "Selenium (software)";
        searchPage.enterSearchText(search)
                .openArticle(article);
        articleSeleniumSoftware.waitUntilPageIsLoaded()
                .runBackGround(2);
        articleSeleniumSoftware.waitUntilPageIsLoaded();
        Assert.assertTrue(articleSeleniumSoftware.isOpenedCorrectly());
    }
    @Test
    public void searchArticleOpenRotateAndBackground(){
        String search = "Selenium";
        String article = "Selenium (software)";
        searchPage.enterSearchText(search)
                .openArticle(article);
        articleSeleniumSoftware.waitUntilPageIsLoaded()
                .rotateScreenLandscape();
        articleSeleniumSoftware.waitUntilPageIsLoaded()
                .runBackGround(2);
        articleSeleniumSoftware.waitUntilPageIsLoaded();
        searchPage.rotateScreenPORTRAIT();
        articleSeleniumSoftware.waitUntilPageIsLoaded()
                .runBackGround(2);
        articleSeleniumSoftware.waitUntilPageIsLoaded();
        Assert.assertTrue(articleSeleniumSoftware.isOpenedCorrectly());
    }
    @Test
    public void searchArticleOpenAndSwipe(){
        String search = "Selenium";
        String article = "Selenium (software)";
        searchPage.enterSearchText(search)
            .openArticle(article);
        articleSeleniumSoftware.waitUntilPageIsLoaded()
                .swipeUp();
        articleSeleniumSoftware.swipeUp();
        articleSeleniumSoftware.swipeUp();
    }

    @Test
    public void searchArticleOpenAndSwipeToFooter(){
        String search = "Selenium";
        String article = "Selenium (software)";
        searchPage.enterSearchText(search)
            .openArticle(article);
        articleSeleniumSoftware.waitUntilPageIsLoaded()
                .swipeToFooter();
        Assert.assertTrue(articleSeleniumSoftware.isEndOfArticle());
    }

    @Test
    public void searchArticleAndOpenMenuArticle(){
        String search = "Selenium";
        String article = "Selenium (software)";
        searchPage.enterSearchText(search)
            .openArticleMenu(article);
        searchPage.closeArticleMenu();
    }

}
