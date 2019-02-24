package com.testhome.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class SearcheResultPage extends NavBarPage {

    @FindBy(css=".topic a")
    public List<WebElement> topics;

    public SearcheResultPage(WebDriver driver){
        super(driver);
    }

    public void  assertTopics(String value){
        String actualMsg="";
        for(WebElement topic :topics){
            actualMsg=topic.getText().trim();
            Assert.assertTrue(actualMsg.toLowerCase().contains(value.toLowerCase()));
        }
    }

    public List<String> getTopics() {
        ArrayList<String> arrayList = new ArrayList<>();
        for(WebElement topic:returnTopics()){
            String actualMsg = topic.getText().trim();
            arrayList.add(actualMsg);
        }
        return  arrayList;
    }
    public List<WebElement> returnTopics() {
        return topics;
    }
}
