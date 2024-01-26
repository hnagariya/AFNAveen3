package com.naveenautomationlabs.AFramework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.naveenautomationlabs.AFramework.base.TestBase;


public class ForgotYourPassword extends TestBase {
	public ForgotYourPassword() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(id = "input-email")
	private WebElement emailInputField;

	@FindBy(css = "input[value='Continue']")
	private WebElement continueBtn;

	public void enterEmail() {
		emailInputField.sendKeys("tony@gmail.com");
	}

	public AccountLogin clickContinueBtn() {
		continueBtn.click();
		return new AccountLogin();
	}



}
