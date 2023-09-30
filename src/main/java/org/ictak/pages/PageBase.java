package org.ictak.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

	WebDriver driver;

	public PageBase(WebDriver driver) {
		this.driver = driver;
	}

	public String getTitle() {
		String titile = null;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement titleHeader = driver.findElement(By.xpath("//div[@class='px-5 py-2']"));// ALL Post Title
		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(titleHeader)); // wait until an alert is present
		} catch (TimeoutException eTO) {
			System.out.println("TimeOutException: " + eTO.getMessage());
		}

		List<WebElement> childElements = titleHeader.findElements(By.xpath("./child::*"));
		if (childElements.size() > 0) // checks if the childElements list has any elements
		{
			titile = childElements.get(0).getText().trim(); // get the text of the first child element
		}
		System.out.println("Page Title = " + titile);
		return titile;
	}
}
