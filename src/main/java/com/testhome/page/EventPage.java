package com.testhome.page;

import org.openqa.selenium.WebDriver;

public class EventPage {
    WebDriver driver;
    public EventPage(WebDriver driver){
        this.driver=driver;
    }
    public String getPageTitle(){
        return driver.getTitle();
    }

}
