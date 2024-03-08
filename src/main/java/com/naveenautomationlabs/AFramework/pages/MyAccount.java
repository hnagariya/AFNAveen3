package com.naveenautomationlabs.AFramework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.naveenautomationlabs.AFramework.base.TestBase;

public class MyAccount extends TestBase{
	public MyAccount() {
		PageFactory.initElements(wd.get(), this);
	}
	@FindBy (css="a#wishlist-total span")
	WebElement wishListBtn;

	@FindBy(css = "#content>h2:first-of-type")
	private WebElement myAccountText;

	public String getMyAccountText() {
		return myAccountText.getText();
	}
	public MyWishList clickWishListBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(wishListBtn));
		wishListBtn.click();
		return new MyWishList();
	}


}
