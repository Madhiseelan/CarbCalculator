package com.calframework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FitnessandHealthPage3 extends AbstractPage {

    @FindBy(css = "a[href='/carbohydrate-calculator.html']")
    private WebElement carbohydrateCalculatorLink;

    @FindBy(xpath = "//h1[normalize-space()='Carbohydrate Calculator']")
    private WebElement carbohydrateCalculatorHeader;

    public FitnessandHealthPage3(WebDriver driver) {
        super(driver);
    }

    public void clickCarbohydrateCalculator(){
        carbohydrateCalculatorLink.click();
    }
    @Override
    public boolean isAt() {
        this.wait.until((ExpectedConditions.visibilityOf(this.carbohydrateCalculatorHeader)));
        return this.carbohydrateCalculatorHeader.isDisplayed();
    }
}
