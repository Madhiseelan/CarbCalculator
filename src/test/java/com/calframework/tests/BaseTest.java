package com.calframework.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void setDriver(){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();

    }

    @AfterTest(alwaysRun = true)
    public void quitDriver(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.driver.quit();
    }

}
