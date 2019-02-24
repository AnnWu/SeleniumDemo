package com.testhome;

import com.testhome.page.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClickBanner {
    WebDriver driver=null;
    @BeforeMethod
    private void setUp(){
        driver=new ChromeDriver();
    }
    @Test
    public void Test() throws Exception {
        driver.get("https://testerhome.com/");
        HomePage homePage = new HomePage(driver);
        String handle1=driver.getWindowHandle();
        Reporter.log("原窗口是"+handle1,true);
        homePage.clickBanner();


        WebDriverWait wait =new WebDriverWait(driver,200);

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        for(String  handle:driver.getWindowHandles()){
            if(!handle.equalsIgnoreCase(handle1)){
                driver.switchTo().window(handle);
                Reporter.log("切换到窗口"+handle,true);
            }
        }
        String expectTitle="大会";
        wait.until(ExpectedConditions.titleContains(expectTitle));
        //Thread.sleep(5000);
    }
    @AfterMethod
    private void  tearDown(){
        driver.quit();
    }
}
