package com.calframework.tests;

import com.calframework.pages.CarbHydCalcPage4;
import com.calframework.pages.FitnessandHealthPage3;
import com.calframework.pages.HomePage1;
import com.calframework.pages.SigninPage2;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CarbHydCalcPageTest4 extends BaseTest {
    private HomePage1 homePage1;
    private SigninPage2 signinPage2;
    private FitnessandHealthPage3 fitnessandHealthPage3;
    private CarbHydCalcPage4 carbHydCalcPage4;

    /*
     * Setup method to initialize page objects and navigate to the Carbohydrate Calculator page
     */
    @BeforeTest(alwaysRun = true)
    public void setupTest() {
        this.homePage1 = new HomePage1(driver);
        homePage1.goTo("https://www.calculator.net/carbohydrate-calculator.html");
        driver.manage().window().maximize();
        this.signinPage2 = new SigninPage2(driver);
        this.fitnessandHealthPage3 = new FitnessandHealthPage3(driver);
        this.carbHydCalcPage4 = new CarbHydCalcPage4(driver);
        homePage1.clickSignIn();
        signinPage2.login("madhigainfully@gmail.com", "Terminal@123");
        signinPage2.fitnessAndHealthLink();
        fitnessandHealthPage3.clickCarbohydrateCalculator();
        Assert.assertTrue(fitnessandHealthPage3.isAt());
        System.out.println("Landed Carbohydrate Calculator Page Successfully");
    }

    /**
     * Carbohydrate Calculator using Metric Units
     */
    @Test(alwaysRun = true)
    public void test1_metricUnitsTest() {

        carbHydCalcPage4.setAge("35");
        carbHydCalcPage4.setGender();
        carbHydCalcPage4.setHeight("175");
        carbHydCalcPage4.setMetricUnitsWeight("75");
        carbHydCalcPage4.setActivity("Moderate: exercise 4-5 times/week");
        carbHydCalcPage4.buttonClick();
        // Assert that the results header is displayed
        carbHydCalcPage4.resultHeaderCheck();

        //Assert Recommended Results text is displayed
        carbHydCalcPage4.assertResultsPageTest();

        //Assert that the Results table is displayed
        Assert.assertTrue(carbHydCalcPage4.isResultTableDisplayed(), "Result table is not displayed");

        //Assert that the Save Button is displayed
        Assert.assertTrue(carbHydCalcPage4.isSaveButtonDisplayed(), "Save button is not displayed");
    }

    /**
     * Carbohydrate Calculator using US units
     */
    @Test(alwaysRun = true)
    public void test2_USUnitsTest() {
        carbHydCalcPage4.usUnitsHeaderClick();
        carbHydCalcPage4.setAge("45");
        carbHydCalcPage4.setGender();
        carbHydCalcPage4.setUSHeights("6", "2");
        carbHydCalcPage4.setUsUnitsWeight("68");
        carbHydCalcPage4.setActivity("Moderate: exercise 4-5 times/week");
        carbHydCalcPage4.buttonClick();

        // Assert that the results header is displayed
        carbHydCalcPage4.resultHeaderCheck();

        //Assert Recommended Results text is displayed
        carbHydCalcPage4.assertResultsPageTest();

        //Assert that the Results table is displayed
        Assert.assertTrue(carbHydCalcPage4.isResultTableDisplayed(), "Result table is not displayed");

        //Assert that the Save Button is displayed
        Assert.assertTrue(carbHydCalcPage4.isSaveButtonDisplayed(), "Save button is not displayed");
    }

    @Test(alwaysRun = true)
    public void test3_metricUnitErrorMessageTest() {
        carbHydCalcPage4.clearButtonClick();
        carbHydCalcPage4.buttonClick();
        carbHydCalcPage4.assertInvalidFieldError();
        //Sign out after test
        carbHydCalcPage4.signOutClick();
        //Assert if sign out is successfully done
        Assert.assertTrue(
                carbHydCalcPage4.isFreeOnlineCalculatorsHeaderDisplayed(),
                "Free Online Calculators header is not displayed after sign out"
        );
    }
}