package org.ictak.pages;

import org.ictak.pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login extends PageBase {

	private WebElement username;
	private WebElement passw;
	private WebElement login;

	public Login(WebDriver driver) {
		super(driver);
	}

	public void setUser(String user) {
		username = driver.findElement(By.id("username"));
		username.sendKeys(user);
	}

	public void setPassword(String setpassw) {
		passw = driver.findElement(By.id("password"));
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

	public PageBase clickError() {

		WebElement elmnt = driver.findElement(By.xpath("//button[@class='btn-close']"));
		elmnt.click();
		username.clear();
		passw.clear();
		return new PageBase(driver);

	}
}
