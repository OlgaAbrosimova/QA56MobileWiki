package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CurrentArticlePageHelper;
import pages.MyListsPageHelper;
import pages.SearchPageHelper;


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
    @Test
    public void searchArticleAndOpen(){
        String search = "Selenium";
        String article = "Selenium (software)";
        searchPage.enterSearchText(search);
        searchPage.openArticle(article);
        articleSeleniumSoftware.waitUntilPageIsLoaded();
        Assert.assertTrue(articleSeleniumSoftware
                .isOpenedCorrectly());

    }
    @Test
    public void searchArticleOpenAndSwipe(){
        String search = "Selenium";
        String article = "Selenium (software)";
        searchPage.enterSearchText(search);
        searchPage.openArticle(article);
        articleSeleniumSoftware.waitUntilPageIsLoaded();
        articleSeleniumSoftware.swipeUp();
        articleSeleniumSoftware.swipeUp();
        articleSeleniumSoftware.swipeUp();
    }

    @Test
    public void searchArticleOpenAndSwipeToFooter(){
        String search = "Selenium";
        String article = "Selenium (software)";
        searchPage.enterSearchText(search);
        searchPage.openArticle(article);
        articleSeleniumSoftware.waitUntilPageIsLoaded();
        articleSeleniumSoftware.swipeToFooter();
        Assert.assertTrue(articleSeleniumSoftware.isEndOfArticle());
    }

    @Test
    public void searchArticleAndOpenMenuArticle(){
        String search = "Selenium";
        String article = "Selenium (software)";
        searchPage.enterSearchText(search);
        searchPage.openArticleMenu(article);
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        searchPage.closeArticleMenu();
    }

}
