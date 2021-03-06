package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CurrentArticlePageHelper;
import pages.MyCurrentListHelper;
import pages.MyListsPageHelper;
import pages.SearchPageHelper;

public class CurrentArticleTests extends TestBase {
    SearchPageHelper searchPage;
    CurrentArticlePageHelper articleSearchSoftware;
    MyListsPageHelper myListsPage;
    MyCurrentListHelper myCurrentList;

    @BeforeMethod
    public void testsInit(){
        searchPage = PageFactory.initElements(driver,SearchPageHelper.class);
        articleSearchSoftware = new CurrentArticlePageHelper(driver,"Selenium (software)");
        myListsPage = PageFactory.initElements(driver, MyListsPageHelper.class);
        myCurrentList = PageFactory.initElements(driver, MyCurrentListHelper.class);
        searchPage.waitUntilPageIsLoaded();
    }

    @Test
    public void addToNewReadingList(){
        String search = "Selenium";
        String article = "Selenium (software)";
        searchPage.enterSearchText(search)
                .openArticle(article);
        articleSearchSoftware.waitUntilPageIsLoaded()
                .addToNewReadingList("List IT")
                .closeArticle();
        searchPage.waitUntilPageIsLoaded()
                .openMyListsPage();
        myListsPage.waitUntilPageIsLoaded()
                .openList("List IT");
        myCurrentList.waitUntilPageIsLoaded();
        Assert.assertTrue(myCurrentList.existsArticle(article));
    }

    @Test
    public void addToNewReadingListAndDelete()  {
        String search = "Selenium";
        String article = "Selenium (software)";
        searchPage.enterSearchText(search)
                .openArticle(article);
        articleSearchSoftware.waitUntilPageIsLoaded()
                .addToNewReadingList("List IT")
                .closeArticle();
        searchPage.waitUntilPageIsLoaded()
                .openMyListsPage();
        myListsPage.waitUntilPageIsLoaded()
                .openList("List IT");
        myCurrentList.waitUntilPageIsLoaded()
                .deleteArticle(article)
                .closeReadingList();
        myListsPage.waitUntilPageIsLoaded()
                .openList("List IT");
        myCurrentList.waitUntilPageIsLoaded();
        Assert.assertFalse(myCurrentList.existsArticle(article));

    }
}
