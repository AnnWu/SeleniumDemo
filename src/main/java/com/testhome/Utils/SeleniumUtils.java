package com.testhome.Utils;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class SeleniumUtils {
    /**
     * 跳转到某个窗口的方法
     * @param title 窗口标题
     * @param driver
     */
    public static void  switchToWindow(String title, WebDriver driver){
        for(String  handle:driver.getWindowHandles()){
            driver.switchTo().window(handle);
            if(driver.getTitle().contains(title))
            {
                break;
            }
        }
    }
}
