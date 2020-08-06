package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SearchWikiPageHelper;

import java.net.MalformedURLException;

public class SearchWikiTest extends TestBase{
    SearchWikiPageHelper searchWikiPage;

    @BeforeMethod
    public void initTests() {
        searchWikiPage = PageFactory.initElements(driver,SearchWikiPageHelper.class);
    }

    @Test
    public void SearchSeleniumTestingInWikiTest() throws MalformedURLException {
        searchWikiPage.startWikiInCustomePhone7();
        String resultSearch = searchWikiPage.searchInWiki("Selenium Testing");
        Assert.assertEquals(resultSearch, "Selenium (software)", "The text of search result is not 'Selenium (software)'");
    }
}
