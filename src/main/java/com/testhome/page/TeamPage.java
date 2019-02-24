package com.testhome.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TeamPage {
    WebDriver driver;
    @FindBy(css = ".topic .title")
    List<WebElement> teamTopics;

    public TeamPage(WebDriver driver){
        this.driver=driver;
    }

    public SignInPage gotoTopicPage(By teamTopic){
        driver.findElement(teamTopic).click();
        return  new SignInPage(driver);
    }
}
