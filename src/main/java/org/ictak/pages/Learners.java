package org.ictak.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Learners extends PageBase {

	public Learners(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public LearnersForm addLearner() {
		driver.findElement(By.xpath("//ion-icon[@name='person-add-outline']")).click();
		return new LearnersForm(driver); 
	}
	public CsvUploadePage navigateToCsvUploadPage() {
		driver.findElement(By.xpath("//ion-icon[@name='cloud-upload']")).click();
		return new CsvUploadePage(driver); 
	}
}
