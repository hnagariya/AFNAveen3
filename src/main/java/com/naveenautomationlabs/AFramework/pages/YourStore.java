package com.naveenautomationlabs.AFramework.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.naveenautomationlabs.AFramework.base.TestBase;
import com.naveenautomationlabs.AFramework.utils.Utils;


public class YourStore extends TestBase{
	public YourStore() {
		PageFactory.initElements(wd.get(), this);
	}

	@FindBy(css = "ul.list-inline>li:nth-of-type(2) a")
	private WebElement myAccountBtn;

	@FindBy(css = "ul.dropdown-menu li:nth-of-type(2) a")
	private WebElement loginBtn;

	@FindBy(css = "ul.nav.navbar-nav>li:nth-of-type(2)")
	private WebElement laptopNotebookLink;

	@FindBy(css = "ul.nav.navbar-nav>li:nth-of-type(2) div.dropdown-menu>a")
	private WebElement showAllLaptopsNotebookLink;

	@FindBy(css = "div.caption a")
	private List<WebElement> listOfDisplayItemOnMainPage;

	@FindBy(css = "div#carousel0>div:nth-of-type(1) >div")
	private List<WebElement> displayMovingOnFooter;

	@FindBy(css = "div#slideshow0 div div")
	private WebElement displayMacBookOnMain;

	@FindBy(css = "a#wishlist-total span")
	private WebElement wishListBtn;

	@FindBy(xpath = "( //i[@class='fa fa-heart'])[2]")
	private WebElement wishBtn;

	public YourStore clickMyAccountBtn() {
		myAccountBtn.click();
		return new YourStore();
	}

	public AccountLogin clickLoginBtn() {
		loginBtn.click();
		return new AccountLogin();
	}

	public LaptopsNotebook mouseHoverLaptopsNotebookLink() {
		Actions action = new Actions(wd.get());
		action.moveToElement(laptopNotebookLink).perform();
		action.moveToElement(showAllLaptopsNotebookLink).perform();
		action.click().perform();
		return new LaptopsNotebook();
	}

	public boolean ClickOnDisplayItemOnMainPage() {
		List<Boolean> listOfClick = new ArrayList();
		boolean isClickTakeToRtPage = true;
		for (WebElement element : listOfDisplayItemOnMainPage) {
			String itemName = element.getText();
			if (itemName.equals("Apple Cinema 30\"")) {
				itemName = "Apple Cinema 30";
			}
			if (itemName.equals("Canon EOS 5D")) {
				itemName = "sdf";
			}
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			listOfClick.add(wd.get().getTitle().equals(itemName));
			wd.get().navigate().back();
		}
		for (boolean b : listOfClick) {
			if (!b) {
				isClickTakeToRtPage = false;
			}
		}
		return isClickTakeToRtPage;
	}

	public boolean checkFooterDisplayImagesMoving() {
		ArrayList<String> list1 = new ArrayList();
		ArrayList<String> list2 = new ArrayList();
		for (WebElement element : displayMovingOnFooter) {
			list1.add(element.getAttribute("class"));
		}
		Utils.sleep();
		for (WebElement element : displayMovingOnFooter) {
			list2.add(element.getAttribute("class"));
		}
		boolean isDisplayItemMoving = list1.equals(list2);
		return isDisplayItemMoving;
	}

	public boolean checkDisplayImagesMoving() {

		int point1x = displayMacBookOnMain.getLocation().getX();
		int point1y = displayMacBookOnMain.getLocation().getY();
		Utils.sleep();
		int point2x = displayMacBookOnMain.getLocation().getX();
		int point2y = displayMacBookOnMain.getLocation().getY();
		if ((point1x == point2x) && (point1y == point2y)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkWishListUpdated() {
		int currentWishList = Utils.returnDigitsFromString(wishListBtn.getText());
		wait.until(ExpectedConditions.visibilityOf(wishBtn));
		wishBtn.click();
		boolean isWishListUpdated = false;
		Utils.sleep();
		int updatedWishList = Utils.returnDigitsFromString(wishListBtn.getText());
		if (updatedWishList>currentWishList) {
			isWishListUpdated = true;
		}
		return isWishListUpdated;
	}

}
