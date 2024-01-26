package com.naveenautomationlabs.AFramework.pages;

import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.naveenautomationlabs.AFramework.base.TestBase;

public class MyWishList extends TestBase{
	public WebElement getCellElementFromTable(MyWishListTable column, String ModelName) {
		int indexOfColumn = returnIndexOfColumn(column);
		if (indexOfColumn < 0) {
			throw new NoSuchElementException();
		}
		List<WebElement> rowsWebElement = wd.findElements(By.cssSelector("div.table-responsive tbody tr"));
		for (int i = 0; i < rowsWebElement.size(); i++) {
			List<WebElement> cells = rowsWebElement.get(i).findElements(By.cssSelector("td"));
			if (cells.get(2).getText().equals(ModelName)) {
				return cells.get(indexOfColumn);
			}
		}
		return null;
	}

	// Find the index of column that we r interested in
	public int returnIndexOfColumn(MyWishListTable columnName) {
		List<WebElement> headers = wd.findElements(By.cssSelector("div.table-responsive thead tr td"));
		for (WebElement headerElement : headers) {
			if (headerElement.getText().equals(columnName.value)) {
				return headers.indexOf(headerElement);
			}
		}
		return -1;
	}
	//created structure of webTable
	public enum MyWishListTable {
		IMAGE("Image"),
		PRODUCT_NAME("Product Name"),
		MODEL("Model"),
		STOCK("Stock"),
		UNIT_PRICE("Unit Price"),
		ACTION("Action");
		
		String value;

		private MyWishListTable(String value) {
			this.value = value;
		}

	}

}
