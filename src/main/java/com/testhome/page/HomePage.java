package com.testhome.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class HomePage extends NavBarPage {
    @FindBy(css = "#main div a img")
    WebElement imgWebElement;

    public HomePage(WebDriver driver){
        super(driver);

    }

    public void clickBanner() {
        imgWebElement.click();
        Reporter.log("点击图片",true);
    }

}
