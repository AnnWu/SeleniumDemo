package com.testhome;

import com.testhome.page.ClubPage;
import com.testhome.page.HomePage;
import com.testhome.page.SignInPage;
import com.testhome.page.TeamPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TeamTopic {
    private WebDriver driver=null;
    @BeforeMethod
    public void setUp(){
        ChromeOptions options=new ChromeOptions();
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
    @Test
    private void test() throws InterruptedException {
        String alerMsg="访问被拒绝，你可能没有权限或未登录。";

        driver.get("https://testerhome.com/");

        HomePage homePage = new HomePage(driver);
        ClubPage clubPage = homePage.gotoClubPage();//去到社团页面

        WebDriverWait wait=new WebDriverWait(driver,200);

        By teamPageBy=By.xpath("//div/div/a[@data-name='霍格沃兹测试学院']"); //By.cssSelector("a[data-name='霍格沃兹测试学院']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(teamPageBy));

        TeamPage teamPage = clubPage.gotoTeamPage(teamPageBy);//进入某个社团页面

        By teamTopicBy = By.xpath("//div[1]/div[2]/div[1]/a/span[contains(text(),'霍格沃兹测试学院')]");
        wait.until(ExpectedConditions.elementToBeClickable(teamTopicBy));//不用也可以
        SignInPage signInPage = teamPage.gotoTopicPage(teamTopicBy);

        Assert.assertEquals(alerMsg,signInPage.getAlertMsg());

    }
    @AfterMethod
    private void tearDown(){
        driver.quit();
    }
}
