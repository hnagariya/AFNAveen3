package com.naveenautomationlabs.AFramework.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.naveenautomationlabs.AFramework.base.TestBase;
import com.naveenautomationlabs.AFramework.pages.AccountLogin;
import com.naveenautomationlabs.AFramework.pages.MyAccount;
import com.naveenautomationlabs.AFramework.pages.YourStore;
import com.naveenautomationlabs.AFramework.utils.ExcelUtils;

public class YourStoreTest extends TestBase {
	private YourStore yourStore;
	private AccountLogin accountLogin;
	private MyAccount myAccount;

	@BeforeMethod
	public void setUp() {
		initialisation();
		yourStore = new YourStore();
	}

	@Test(dataProvider = "loginDataProvider")
	public void validateLoginUsingValidCredentials(String userName, String password) {
		yourStore.clickMyAccountBtn();
		accountLogin = yourStore.clickLoginBtn();
		myAccount = accountLogin.loginToPortal(userName, password);
		Assert.assertEquals(myAccount.getMyAccountText(), "My Account");
	}

	@DataProvider(name = "loginDataProvider")
	public String[][] getDataFromExcelFile() throws Exception {
		logger.info("data provider get executed");
		String file = "C:\\Users\\Neelam Nagariya\\Desktop\\Testing\\Data.xlsx";
		int rowCount = ExcelUtils.getRowCount(file, "sheet1");
		int columnCount = ExcelUtils.getColumnCount(file, "sheet1", rowCount);
		String[][] virtualSheet = new String[rowCount][columnCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				virtualSheet[i - 1][j] = ExcelUtils.getCellData(file, "sheet1", i, j);
			}
		}
		return virtualSheet;
	}

	@Test
	public void jdbcConnection() {
		String url = "jdbc:sqlserver://Neelam;databaseName=HR;integratedSecurity=true;encrypt=false";
		String userName = "sa";
		String Password = "madhu";
		try {
			Connection conn = DriverManager.getConnection(url);
			// to insert data single row
//		String sqlCommand = "INSERT INTO tablenmae" + "VALUES (String name, int n)";
//		Statement st = conn.createStatement();
//		int row = st.executeUpdate(sqlCommand);
//		// to insert multiple rows
//		PreparedStatement st1 = conn.prepareStatement(sqlCommand);
//		st1.setString(1, "Ravi");
//		st1.setInt(2, 54);
			// to get data
			String sql = "SELECT * FROM employees;";
			Statement st2 = conn.createStatement();
			ResultSet rs = st2.executeQuery(sql);
			int count = 0;
			while (rs.next()) {
				count++;
				String name = rs.getString("email");
				int i = rs.getInt("employee_id");
				System.out.println("Employee id: " + i + " email is : " + name);

			}
			System.out.println("Connection established");

		} catch (SQLException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}

	}

	@Test
	public void validateClickingDisplayItemOnMainPageTakesToItemPage() {
		Assert.assertTrue(yourStore.ClickOnDisplayItemOnMainPage());
	}

	@Test
	public void validateFooterDisplayImagesMoving() {
		Assert.assertFalse(yourStore.checkFooterDisplayImagesMoving(), "Footer Display images are not moving");
	}

	

	@Test
	public void validateDisplayImageIsMovingOnMainPage() {
		Assert.assertFalse(yourStore.checkDisplayImagesMoving(), "Display image not moving");
	}

	@Test
	public void validateWishListIsUpdated() {
		Assert.assertTrue(yourStore.checkWishListUpdated(), "Wish list not updated");
	}

	@AfterMethod
	public void quit() {
		tearDown();
	}

}
