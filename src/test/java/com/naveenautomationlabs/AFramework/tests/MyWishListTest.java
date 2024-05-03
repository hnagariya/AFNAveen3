package com.naveenautomationlabs.AFramework.tests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.naveenautomationlabs.AFramework.base.TestBase;
import com.naveenautomationlabs.AFramework.pages.AccountLogin;
import com.naveenautomationlabs.AFramework.pages.MyAccount;
import com.naveenautomationlabs.AFramework.pages.MyWishList;
import com.naveenautomationlabs.AFramework.pages.MyWishList.MyWishListTable;
import com.naveenautomationlabs.AFramework.pages.YourStore;


public class MyWishListTest extends TestBase {
	private YourStore yourStore;
	private AccountLogin accountLogin;
	private MyAccount myAccount;
	private MyWishList myWishList;

	@BeforeMethod
	public void setUp() {
		initialisation();
		yourStore = new YourStore();
	}
	@Test(priority=1)
	public void validateLogin() {
		yourStore.clickMyAccountBtn();
		accountLogin = yourStore.clickLoginBtn();
		myAccount = accountLogin.loginToPortal("tony@gmail.com","Password2");
		myWishList=myAccount.clickWishListBtn();
	}
	@Test
	public void validateGettingCellElementFromTable() {
		yourStore.clickMyAccountBtn();
		accountLogin = yourStore.clickLoginBtn();
		myAccount = accountLogin.loginToPortal("riti@gmail.com","password1");
		myWishList=myAccount.clickWishListBtn();
		String s= myWishList.getCellElementFromTable(MyWishListTable.PRODUCT_NAME,"Product 15").getText();
		System.out.println(s);
	}

}
