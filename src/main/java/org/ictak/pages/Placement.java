package org.ictak.pages;

import java.util.List;

import org.ictak.utilities.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Placement extends PageBase {

	public Placement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	

	public LearnersForm findLerner(String learnerId) {
		LearnersForm objLerner = null;
		List<WebElement> pagination = driver.findElements(By.xpath("//li[@class='page-item']"));
		boolean found = false;
		for (WebElement index : pagination) {
			Util.sleepForMilliSec(2000);
			WebElement table = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']"));
			List<WebElement> rows = table.findElements(By.tagName("tr"));
			System.out.println("Row size = " + rows.size());
			
			List<WebElement> buttons = table.findElements(By.xpath("//button[@class='btn btn-success btn btn-primary']"));
			int i = 0; 
			boolean header = true; 
			for (WebElement row : rows) {
				if(header) {
					header = false;
					continue;
				}
				System.out.println("Row  = " + row.getText());
				LearnersForm learner = new LearnersForm(driver, row, buttons.get(i++) ); 
				System.out.println(learner);
				if (learnerId.equals(learner.getLearnerId())) {
					objLerner = learner;
					found = true;
					break;
				}
			}
			if (found)
				break;
			index.click();
		}

		return objLerner;
	}

}
