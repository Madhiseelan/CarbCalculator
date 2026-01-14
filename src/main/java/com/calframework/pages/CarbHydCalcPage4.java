package com.calframework.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.xml.xpath.XPath;
import java.time.Duration;

public class CarbHydCalcPage4 extends AbstractPage {

    @FindBy(css = "#cage")
    private WebElement ageInput;
    @FindBy(xpath = "//label[normalize-space()='female']")
    private WebElement genderOption;
    @FindBy(css = "#cheightmeter")
    private WebElement heightInput;

    @FindBy(css = "#cheightfeet")
    private WebElement usUnitsHeightFeetInput;

    @FindBy(css = "#cheightinch")
    private WebElement usUnitsHeightInchesInput;

    @FindBy(xpath = "//input[@id='ckg']")
    private WebElement metricUnitWeightInput;

    @FindBy(xpath = "//input[@id='cpound']")
    private WebElement usUnitsWeightInput;
    @FindBy(xpath = "//select[@id='cactivity']")
    private WebElement activityDropdown;

    @FindBy(css = "input[value='Calculate']")
    private WebElement calculateButton;

    @FindBy(xpath = "//h2[normalize-space()='Result']")
    private WebElement resultHeader;

    @FindBy(xpath = "//a[normalize-space()='US Units']")
    private WebElement usUnitsHeader;

    @FindBy(xpath = "//input[@value='Clear']")
    private WebElement clearButton;

    public CarbHydCalcPage4(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//p[@class='bigtext']")
    private WebElement recommendedResultText;

    @FindBy(css = "table.cinfoT")
    private WebElement recommendedResultTable;

    String expectedRecommendedResultText = "It is recommended that carbohydrates comprise 40-75% of daily caloric intake.";

    @FindBy(xpath = "//font[normalize-space()='Please provide an age between 18 and 80.']")
    private WebElement ageErrorText;
    @FindBy(xpath = "//font[normalize-space()='Please provide positive height value.']")
    private WebElement heightErrorText;
    @FindBy(xpath = "//font[normalize-space()='Please provide positive weight value.']")
    private WebElement weightErrorText;

    String expectedAgeErrorMsg = "Please provide an age between 18 and 80.";
    String expectedHeightErrorMsg = "Please provide positive height value.";
    String expectedWeightErrorMsg = "Please provide positive weight value.";

    @FindBy(xpath = "//a[normalize-space()='sign out']")
    private WebElement signOutLink;

    @FindBy(xpath = "//h1[normalize-space()='Free Online Calculators']")
    private WebElement freeOnlineCalculatorsHeader;

    @FindBy(css = "img[title='Save this calculation']")
    private WebElement saveCalculationIcon;

    public void signOutClick(){
        signOutLink.click();
    }

    public void assertInvalidFieldError() {
        String actualAge = getText(ageErrorText);
        Assert.assertEquals(actualAge, expectedAgeErrorMsg, "❌ Age Error message mismatch!");

        String actualHeight = getText(heightErrorText);
        Assert.assertEquals(actualHeight, expectedHeightErrorMsg, "❌ Height Error message mismatch!");

        String actualWeight = getText(weightErrorText);
        Assert.assertEquals(actualWeight, expectedWeightErrorMsg, "❌ Weight Error message mismatch!");
    }

    public void resultHeaderCheck() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(resultHeader));
        Assert.assertTrue(resultHeader.isDisplayed(), "Result header should be displayed");
    }

    public boolean isResultTableDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(recommendedResultTable));
        return recommendedResultTable.isDisplayed();
    }

    public boolean isSaveButtonDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(saveCalculationIcon));
        return saveCalculationIcon.isDisplayed();
    }

    public boolean isFreeOnlineCalculatorsHeaderDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(freeOnlineCalculatorsHeader));
            return freeOnlineCalculatorsHeader.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    // Generic helper method to assert error messages

    private String getText(WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(element))
                .getText()
                .trim();
    }

    public void assertResultsPageTest() {
        String actualRecommendedResultText = getText(recommendedResultText);
        Assert.assertEquals(actualRecommendedResultText, expectedRecommendedResultText, "❌ Recommended Result Text Error message mismatch!");
    }

    /*
    private String getText(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator))
                    .getText().trim();
        } catch (StaleElementReferenceException e) {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator))
                    .getText().trim();
        }
    }*/

    public void goTo(String url) {
        this.driver.get(url);
    }

    public void setAge(String age) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(ageInput));

        ageInput.clear();
        ageInput.sendKeys(age);
    }

    public void setGender() {
        this.genderOption.click();
    }

    public void setHeight(String height) {
        this.heightInput.clear();
        this.heightInput.sendKeys(height);
    }

    public void setMetricUnitsWeight(String weight) {
        this.metricUnitWeightInput.clear();
        this.metricUnitWeightInput.sendKeys(weight);
    }

    public void setUsUnitsWeight(String weight) {
        this.usUnitsWeightInput.clear();
        this.usUnitsWeightInput.sendKeys(weight);
    }

    public void setActivity(String visibleText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement dropdown_element = wait.until(ExpectedConditions.elementToBeClickable(activityDropdown));
        Select select = new Select(dropdown_element);

        // List all dropdown values
        for (WebElement options : select.getOptions()) {
            System.out.println("value is: " + options.getAttribute("value") + " | Text: " + options.getText());
        }

        // Select by visible text
        select.selectByVisibleText(visibleText);
    }

    public void buttonClick() {
        calculateButton.click();
    }

    public void clearButtonClick() {
        clearButton.click();
    }

    public void usUnitsHeaderClick() {
        usUnitsHeader.click();
    }

    public void setUSHeights(String feet, String inches) {
        usUnitsHeightFeetInput.sendKeys(feet);
        usUnitsHeightInchesInput.sendKeys(inches);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.ageInput));
        return this.ageInput.isDisplayed();
    }

}
