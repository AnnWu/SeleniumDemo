package com.testhome;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

public class ClickImage {
    WebDriver driver=null;
    @BeforeMethod
    private void setUp(){
        driver=new ChromeDriver();
    }
    /*@Test
    public void clickTest(){
        driver.get("https://testerhome.com/");
        By imageBy= By.cssSelector("#main div a img");
        WebElement webElement = driver.findElement(imageBy);
        webElement.click();
        System.out.println("Click success!");
    }*/
    @Test
    public void searchTest() throws InterruptedException {
        driver.get("https://testerhome.com/");
        By searchBy = By.xpath("//div/input");
        WebElement elementSearch = driver.findElement(searchBy);
        Actions action=new Actions(driver);
        action.sendKeys(elementSearch,"selenium").perform();
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(10000);
        System.out.println("Click success!");
    }
    @AfterMethod
    private void  tearDown(){
        driver.quit();
    }
}
