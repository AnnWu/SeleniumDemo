package com.testhome.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClubPage {
    WebDriver driver;

    @FindBy(css = "a[data-name='霍格沃兹测试学院']")
    WebElement teamName;

    public ClubPage(WebDriver driver) {
        this.driver=driver;
    }

    public TeamPage gotoTeamPage(By team){
        //teamName.click();
        driver.findElement(team).click();
        return new TeamPage(driver);
    }
}
