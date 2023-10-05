package org.ictak.pages;

import java.time.Duration;

import org.ictak.constants.Constant;
import org.ictak.utilities.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class Navigator extends PageBase {

	public Navigator(WebDriver driver) {
		super(driver);
	}

	public String getUserTitle() {
		
		WebElement element = Util.waitUntilVisible(driver, By.className("item-content"));
		return element.getText();

	}

	public Users users() {
		driver.findElement(By.xpath("//span[@class='item-content']")).click();
		return new Users(driver);
	}

	public void clickLearner() {
		WebElement elmnt = Util.findFirstMatchingListElement(driver, "//span[@class='item-content']",
				Constant.LEARNERS);
		elmnt.click();
	}

	public void clickPlacement() {
		WebElement elmnt = Util.findFirstMatchingListElement(driver, "//span[@class='item-content']",
				Constant.PLACEMENT );
		elmnt.click();
	}
	
	
	public Learners learners() {
		driver.findElement(By.xpath("//span[@class='item-content']")).click();
		return new Learners(driver);
	}

	public Placement placement() {
		driver.findElement(By.xpath("//span[@class='item-content']")).click();
		return new Placement(driver);
	}

	@AfterMethod
	public Login logout() {

		WebElement dropDown = Util.waitUntilVisible(driver, By.id("basic-nav-dropdown"));
		dropDown.click();

		WebElement parent = Util.waitUntilVisible(driver, By.xpath("//div[@class='me-5 pe-5 nav-item show dropdown']"));
		WebElement logoutButton = Util.findFirstMatchingListElement(driver, parent, "//a[@class='dropdown-item' ]",
				Constant.LOGOUT);
		logoutButton.click();
		return new Login(driver);
	}

}