package com.calframework.tests;

import com.calframework.pages.HomePage1;
import com.calframework.pages.SigninPage2;
import com.calframework.pages.FitnessandHealthPage3;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FitnessandHealthPageTest3 extends BaseTest {
    private HomePage1 homePage1;
    private SigninPage2 signinPage2;
    private FitnessandHealthPage3 fitnessandHealthPage3;

    @BeforeTest(alwaysRun = true)
    public void setupTest() {
        this.homePage1 = new HomePage1(driver);
        homePage1.goTo("https://www.calculator.net/carbohydrate-calculator.html");
        driver.manage().window().maximize();
        this.signinPage2 = new SigninPage2(driver);
        this.fitnessandHealthPage3 = new FitnessandHealthPage3(driver);
    }

    @Test
    public void CarboHydCalculatorClick(){
        homePage1.clickSignIn();
        signinPage2.login("madhigainfully@gmail.com", "Terminal@123");
        signinPage2.fitnessAndHealthLink();
        fitnessandHealthPage3.clickCarbohydrateCalculator();
        Assert.assertTrue(fitnessandHealthPage3.isAt());
        System.out.println("Landed Carbohydrate Calculator Page Successfully");
    }

    /*
     * This class can be extended to include more tests related to the Fitness and Health Page as needed.
     */
}