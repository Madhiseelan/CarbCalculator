package com.calframework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage1 extends AbstractPage{
    @FindBy(xpath = "//a[normalize-space()='sign in']")
    private WebElement signInLink;

    public HomePage1(WebDriver driver) {
        super(driver);
    }

    public void clickSignIn(){
        this.signInLink.click();
    }

    public void goTo(String url) {
        this.driver.get(url);
    }

    @Override
    public boolean isAt() {
        return false;
    }
}
