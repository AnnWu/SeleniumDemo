package com.testhome;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.testhome.page.HomePage;
import com.testhome.page.SearcheResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchKeyword {
    WebDriver driver=null;
    private HomePage homePage;

    @BeforeMethod
    private void setUp(){
        ChromeOptions options=new ChromeOptions();
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();

    }
    /*
    @Test
    private void searchTest() throws Exception {
        driver.get("https://testerhome.com/");
        HomePage homePage = new HomePage(driver);
        String keyword="selenium";
        SearcheResultPage searchResultPage= homePage.gotoSearchResult(keyword);
        Thread.sleep(10000);
        //System.out.println("Click success!");
        String actualMsg = "";
        for(WebElement topic : searchResultPage.returnTopics()) {
            actualMsg = topic.getText().trim();
            Assert.assertTrue(actualMsg.toLowerCase().contains(keyword), "期待的标题不包含" + keyword + "实际的标题是" + actualMsg);
        }
    }*/
    @DataProvider
    public Object[][] getData(){
        Object[][] o={{"selenium"},{"testng"}};
        return o;
    }

    @Test(dataProvider ="getData")
    private void Test(String value) throws Exception {
        driver.get("https://testerhome.com/");
        HomePage homePage = new HomePage(driver);
        SearcheResultPage searchResultPage= homePage.gotoSearchResult(value);
        String actualMsg ="";
        for(WebElement topic:searchResultPage.returnTopics()) {
            actualMsg = topic.getText().trim();
            Assert.assertTrue(actualMsg.toLowerCase().contains(value), "期望的标题不包含" + value + "实际的标题是" + actualMsg);
        }
    }

    @AfterMethod
    private void tearDown(){
            driver.quit();
        }
}