package com.testhome.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class SignInPage extends NavBarPage {
    //@FindBy(xpath = "//div[@class=alert-danger]")
    @FindBy(css = "#main div.alert")
    WebElement alert;

    public SignInPage(WebDriver driver){
        super(driver);
    }
    public String getAlertMsg(){
        Reporter.log(alert.getText());
        return alert.getText();
    }
}
