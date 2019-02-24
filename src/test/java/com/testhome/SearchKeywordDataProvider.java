package com.testhome;

import com.testhome.page.HomePage;
import com.testhome.page.SearcheResultPage;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SearchKeywordDataProvider {
    WebDriver driver=null;


    @BeforeMethod
    private void setUp(){
        ChromeOptions options=new ChromeOptions();
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();

    }/*
    @DataProvider
    public Object[][] getData(){
        Object[][] o={{"selenium"},{"testng"}};
        return o;
    }*/

    @DataProvider
    public Iterator<Object[]> getData() throws Exception {
        String filePath= SearchKeywordDataProvider.class.getResource("/searchWords.csv").getPath();

        return readCscFile("D:\\JavaWork\\testhome\\SeleniumDemo\\searchKeyword.csv");
    }

    @Test(dataProvider ="getData")
    private void Test(String value) throws Exception {
        driver.get("https://testerhome.com/");
        HomePage homePage = new HomePage(driver);
        SearcheResultPage searchResultPage= homePage.gotoSearchResult(value);
        Thread.sleep(3000);
    }

    public Iterator<Object[]>readCscFile(String filePath) throws Exception {
        List<Object[]> dataArray=new ArrayList<Object[]>();
        Reader in = new FileReader(filePath);
        Iterable<CSVRecord>records = CSVFormat.EXCEL.parse(in);
        for(CSVRecord record:records){
            List<Object> rowList = new ArrayList();
            Iterator i =record.iterator();
            while (i.hasNext()){
                rowList.add( i.next());
            }
            Object[] rowlist = rowList.toArray();
            dataArray.add(rowlist);

        }
        return dataArray.iterator();

    }

    @AfterMethod
    private void  tearDown(){
        driver.quit();
    }
}
