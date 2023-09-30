package org.ictak.pages;

import org.ictak.constants.Constant;
import org.ictak.utilities.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;

public class Navigator extends PageBase {

	public Navigator(WebDriver driver) {
		super(driver);
	}

	public String getUserTitle() {
		return driver.findElement(By.className("item-content")).getText();

	}

	public Users users() {
		driver.findElement(By.xpath("//span[@class='item-content']")).click();
		return new Users(driver);
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

		WebElement dropDown = driver.findElement(By.id("basic-nav-dropdown"));
		dropDown.click();
		WebElement parent = driver.findElement(By.xpath("//div[@class='me-5 pe-5 nav-item show dropdown']"));
		WebElement logoutButton = Util.findFirstMatchingListElement(driver, parent, "//a[@class='dropdown-item' ]",
				Constant.LOGOUT);
		logoutButton.click();
		return new Login(driver);
	}

}