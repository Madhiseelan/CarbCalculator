package com.calframework.tests;

import com.calframework.pages.HomePage1;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest1 extends BaseTest{

    private HomePage1 homePage1;
    @BeforeTest(alwaysRun = true)
    public void setupTest() {
        this.homePage1 = new HomePage1(driver);
        homePage1.goTo("https://www.calculator.net/carbohydrate-calculator.html");
        driver.manage().window().maximize();
    }

    @Test
    public void testSignInLink(){
      homePage1.clickSignIn();
    }

    /*
     * This class can be extended to include more tests related to the Home Page as needed.
     */
}