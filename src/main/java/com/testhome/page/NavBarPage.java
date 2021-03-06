package com.testhome.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NavBarPage {
    WebDriver driver;


    @FindBy(tagName = "input")
    WebElement searchWebElement;

    @FindBy(css = ".nav a[href='/teams']")
    WebElement teamsWebElement;


    public NavBarPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void searchKeyWord(String value){
        searchWebElement.clear();
        searchWebElement.sendKeys(value);

        Reporter.log("输入搜索关键字"+value,true);
    }

    public SearcheResultPage gotoSearchResult(String value){
        searchKeyWord(value);
        Actions action=new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        return new SearcheResultPage(driver);
    }

    public ClubPage gotoClubPage(){
        teamsWebElement.click();
        return  new ClubPage(driver);
    }

}
