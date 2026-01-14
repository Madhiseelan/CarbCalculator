package com.calframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SigninPage2 extends AbstractPage {

    @FindBy(css = "input[name='email']")
    private WebElement emailInput;
    @FindBy(css = "input[name='password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//input[@name='submit']")
    private WebElement signInButton;
    @FindBy(xpath = "//h1[normalize-space()='My Account']")
    private WebElement myAccountHeader;
    @FindBy(xpath = "//a[normalize-space()='Fitness & Health']")
    private WebElement fitnessAndHealthLink;
    private By fitnessAndHealthLinkBy = By.xpath("//a[normalize-space()='Fitness & Health']");

    public SigninPage2(WebDriver driver) {
        super(driver);
    }
    public void login(String username, String password){
        this.emailInput.sendKeys(username);
        this.passwordInput.sendKeys(password);
        this.signInButton.click();
    }

    public void fitnessAndHealthLink(){
    /*
        this.wait.until((ExpectedConditions.visibilityOf(this.fitnessAndHealthLink)));
        this.fitnessAndHealthLink.click(); */
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(fitnessAndHealthLinkBy)).click();
    }
    @Override
    public boolean isAt() {
        this.wait.until((ExpectedConditions.visibilityOf(this.myAccountHeader)));
        return this.myAccountHeader.isDisplayed();
    }
}
