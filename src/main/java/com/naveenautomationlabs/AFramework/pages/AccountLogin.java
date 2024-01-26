package com.naveenautomationlabs.AFramework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.naveenautomationlabs.AFramework.base.TestBase;

public class AccountLogin extends TestBase {
	public AccountLogin() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(id = "input-email")
	private WebElement emailInputField;

	@FindBy(id = "input-password")
	private WebElement passwordInputField;

	@FindBy(css = "input[value='Login']")
	private WebElement loginBtn;

	@FindBy(css = "div.form-group a")
	private WebElement forgotPasswordLink;

	@FindBy(css = "div.alert")
	private WebElement passwordResetLinkText;

	private void enterEmail(String userName) {
		emailInputField.sendKeys(userName);
	}

	private void enterPassword(String password) {
		passwordInputField.sendKeys(password);
	}

	private MyAccount clickLoginBtn() {
		loginBtn.click();
		return new MyAccount();
	}

	public MyAccount loginToPortal(String userName,String password) {
		enterEmail(userName);
		enterPassword(password);
		return clickLoginBtn();
	}

	public ForgotYourPassword clickForgotPassword() {
		forgotPasswordLink.click();
		return new ForgotYourPassword();
	}

	public String getPasswordResetLinkSuccessMessageText() {
		return passwordResetLinkText.getText();
	}


}
