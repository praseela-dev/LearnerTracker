package org.ictak.pages;

import org.ictak.utilities.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddUsers extends PageBase {

	public AddUsers(WebDriver driver) {
		super(driver);
	}

	public void setName(String name) {
		WebElement elmnt = driver.findElement(By.id("name"));
		elmnt.sendKeys(name);
	}

	public void setEmail(String email) {
		WebElement elmnt = driver.findElement(By.id("email"));
		elmnt.sendKeys(email);
	}

	public void setUserName(String user) {
		WebElement elmnt = driver.findElement(By.id("username"));
		elmnt.sendKeys(user);
	}

	public void setPassword(String passw) {
		WebElement elmnt = driver.findElement(By.id("password"));
		elmnt.sendKeys(passw);
	}

	public void setRole(String userRole) {
		WebElement parent = driver.findElement(By.name("roleInputs"));
		parent.click();
		parent.click();
		WebElement role = Util.findFirstMatchingListElement(driver, parent, userRole);
		role.click();

	}

	public void clickSubmit() {
		WebElement elmnt = driver.findElement(By.xpath("//button[@class='btn btn-success']"));
		elmnt.click();
	}

	public void clickBackDashb() {
		WebElement elmnt = driver.findElement(By.xpath("//button[@class='btn btn-warning']"));
		elmnt.click();
	}
	
	

//	public String getMessage() {
//		WebElement elmnt = driver.findElement(By.xpath("//div[@id='swal2-html-container']"));
//		return elmnt.getText();
//	}
//
//	public void presOK() {
//		WebElement elmnt = driver.findElement(By.xpath("//button[@class='swal2-confirm swal2-styled']"));
//		elmnt.click();
//	}
//	
	
//	
//	public void updateUserName(String updname) {
//		driver.findElement(By.name("lastname")).sendKeys(updname);
//		
//	}
	
//	public void updateUserRole(String updtrole) {
//		driver.findElement(By.name("lastname")).sendKeys(updtrole);
//		
//	}
	
	
	
//	public void clickUpdate() {
//		WebElement elmnt = driver.findElement(By.xpath("//button[@class='btn btn-success']"));
//		elmnt.click();
//	}

	
}
