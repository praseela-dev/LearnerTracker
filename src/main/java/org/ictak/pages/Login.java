package org.ictak.pages;

import java.time.Duration;

import org.ictak.pages.PageBase;
import org.ictak.utilities.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login extends PageBase {

	private WebElement username;
	private WebElement passw;
	private WebElement login;

	public Login(WebDriver driver) {
		super(driver);
	}

	public void setUser(String user) {
		username = Util.waitUntilVisible(driver, By.id("username"));
		username.sendKeys(user);
	}

	public void setPassword(String setpassw) {
		passw = Util.waitUntilVisible(driver, By.id("password"));
		passw.sendKeys(setpassw);
	}

	public PageBase loginclick() {

		login = driver.findElement(By.xpath("//button[@class='btn btn-success w-100']"));
		login.click();
		return new PageBase(driver);
	}

	public String getError() {

		return driver.findElement(By.xpath("//div[@class='fade alert alert-danger alert-dismissible show']")).getText();
	}

	public void closeError() {

		WebElement elmnt = driver.findElement(By.xpath("//button[@class='btn-close']"));
		elmnt.click();
	}

	public void clearUserName() {
		username.clear();
	}

	public void clearPassword() {
		passw.clear();
	}

	public String getEmptyTextBoxError() {
		return driver.findElement(By.xpath("//small[@class='text-danger']")).getText();

	}

}
