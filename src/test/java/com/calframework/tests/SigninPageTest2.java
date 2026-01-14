package com.calframework.tests;

import com.calframework.pages.HomePage1;
import com.calframework.pages.SigninPage2;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SigninPageTest2 extends BaseTest{

    private HomePage1 homePage1;
    private SigninPage2 signinPage2;

    @BeforeTest(alwaysRun = true)
    public void setupTest() {
        this.homePage1 = new HomePage1(driver);
        homePage1.goTo("https://www.calculator.net/carbohydrate-calculator.html");
        driver.manage().window().maximize();
        this.signinPage2 = new SigninPage2(driver);
    }

    @Test
    public void testSignInLink(){
        homePage1.clickSignIn();
        signinPage2.login("madhigainfully@gmail.com", "Terminal@123");
        Assert.assertTrue(signinPage2.isAt());
        System.out.println("Login Successful");
    }

    /*
     * This class can be extended to include more tests related to the Sign-In Page as needed.
     */
}