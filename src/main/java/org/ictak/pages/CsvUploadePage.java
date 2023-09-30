package org.ictak.pages;

import org.ictak.utilities.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CsvUploadePage extends PageBase {

	public CsvUploadePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void upload(String file) {
		WebElement fileUploadElement = driver.findElement(By.xpath("//input[@type='file']"));
		fileUploadElement.sendKeys(file);
		Util.sleepForMilliSec(2000);
		
		WebElement sumbitButton = driver.findElement(By.xpath("//button[@class='ui grey mini button']"));
		sumbitButton.click();
	}
	
	public String getMessage() {
		WebElement elmnt = driver.findElement(By.xpath("//h2[@id='swal2-title']"));
		return elmnt.getText();
	}

	public void presOK() {
		WebElement elmnt = driver.findElement(By.xpath("//button[@class='swal2-confirm swal2-styled']"));
		elmnt.click();
	}

}
