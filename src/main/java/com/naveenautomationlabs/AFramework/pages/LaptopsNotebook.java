package com.naveenautomationlabs.AFramework.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.naveenautomationlabs.AFramework.base.TestBase;

public class LaptopsNotebook extends TestBase {
	public LaptopsNotebook() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "div.product-thumb div.caption a")
	private List<WebElement> listOfLaptopsNotebook;

	public void checkClickOnProductOfLaptopsNotebookGoRespectivePage(String nameOfProduct) {
		for (WebElement element : listOfLaptopsNotebook) {
			if ((element.getText()).equals(nameOfProduct)) {
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
				break;
			}
		}
	}

}
