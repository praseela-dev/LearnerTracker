package org.ictak.pages;

import java.util.List;

import org.ictak.utilities.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Users extends PageBase {

	public Users(WebDriver driver) {
		super(driver);
		// TODO Auto-generated construSuperctor stub
	}

	public AddUsers addUsers() {
		driver.findElement(By.xpath("//button[@class='mb-3 btn btn-success']")).click();
		return new AddUsers(driver);
	}

//	public AddUsers updateUser(String userName) {
//		AddUsers objAddUsers = null;
//		List<WebElement> pagination = driver.findElements(By.xpath("//li[@class='page-item']"));
//		boolean found = false;
//		for (WebElement index : pagination) {
//			WebElement table = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']"));
//			List<WebElement> rows = table.findElements(By.tagName("tr"));
//			System.out.println("Row size = " + rows.size());
//
//			for (WebElement row : rows) {
//				System.out.println("Row  = " + row.getText());
//				User user = new User(driver, row);
//				System.out.println(user);
//				if (userName.equals(user.getUserName())) {
//					objAddUsers = user.navigateToUpdate();
//					found = true;
//					break;
//				}
//			}
//			if (found)
//				break;
//			index.click();
//		}
//
//		return objAddUsers;
//	}

	public User findFistUser() {
		User objUser = null;

		Util.sleepForMilliSec(2000);

		WebElement table = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		System.out.println("Row size = " + rows.size());

		List<WebElement> updateBtns = table
				.findElements(By.xpath("//button[@class='btn btn-success btn btn-primary']"));
		List<WebElement> deleteBtns = table.findElements(By.xpath("//button[@class='btn btn-danger btn btn-primary']"));
		int i = 0;
		boolean header = true;

		for (WebElement row : rows) {
			if (header) {
				header = false;
				continue;
			}
			System.out.println("Row  = " + row.getText());
			User user = new User(driver, row, updateBtns.get(i), deleteBtns.get(i));
			i++;
			System.out.println(user);

			objUser = user;
			break;
		}

		return objUser;

	}

	public User findUser(String userName) {
		User objUser = null;
		List<WebElement> pagination = driver.findElements(By.xpath("//li[@class='page-item']"));
//		List<WebElement> pagination = driver.findElements(By.xpath("//a[@role='button']"));

		boolean found = false;
		Actions action = new Actions(driver);
		for (WebElement index : pagination) {

			System.out.println("page index:" + index.getText());
			if (!(index.isDisplayed() && index.isEnabled())) {// just to skip invisible indexes
				continue;
			}
			Util.sleepForMilliSec(2000);

			WebElement table = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']"));
			List<WebElement> rows = table.findElements(By.tagName("tr"));
			System.out.println("Row size = " + rows.size());

			List<WebElement> updateBtns = table
					.findElements(By.xpath("//button[@class='btn btn-success btn btn-primary']"));
			List<WebElement> deleteBtns = table
					.findElements(By.xpath("//button[@class='btn btn-danger btn btn-primary']"));
			int i = 0;
			boolean header = true;

			for (WebElement row : rows) {
				if (header) {
					header = false;
					continue;
				}
				System.out.println("Row  = " + row.getText());
				User user = new User(driver, row, updateBtns.get(i), deleteBtns.get(i));
				i++;
				System.out.println(user);
				if (userName.equals(user.getUserName())) {
					objUser = user;
					found = true;
					break;
				}
			}
			if (found)
				break;
//			JavascriptExecutor js = (JavascriptExecutor)driver;
//			js.executeScript("arguments[0].click();", index);
			index.click();
		}

		return objUser;
	}

	public void deleteUsers() {
		driver.findElement(By.xpath("//button[@class='btn btn-danger btn btn-primary']")).click();

	}

}
