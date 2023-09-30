package org.ictak.utilities;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.ictak.pages.Navigator;
import org.ictak.pages.Login;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util {

	public static Login setLoginFields(WebDriver driver, int row) throws IOException {

		Login log = new Login(driver);
		System.out.println("*****Its launched*******");
		String UserName = ExcelUtility.getData(row, 0);
		String Password = ExcelUtility.getData(row, 1);
		log.setUser(UserName);
		log.setPassword(Password);
		System.out.println("*****Hello, ready for Testing*******");

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// e.printStackTrace();
		}
		return log;
	}

	public static String manageAlert(WebDriver driver, int timeSec) {
		String alertMessage = null;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeSec));
		try {
			wait.until(ExpectedConditions.alertIsPresent()); // wait until an alert is present
			Alert alert = driver.switchTo().alert(); // switch the focus of the WebDriver to alert window
			alertMessage = alert.getText();
			System.out.println("Alert message:" + alertMessage);
			alert.accept();
		} catch (TimeoutException eTO) {
			System.out.println("TimeOutException: " + eTO.getMessage());
		}
		return alertMessage;
	}

	public static void sleepForMilliSec(int sleep) {
		try {
			Thread.sleep(sleep);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static WebElement findFirstMatchingListElement(WebDriver driver, String xpath, String title) {
		WebElement matchingElement = null;
		List<WebElement> elements = driver.findElements(By.xpath(xpath));

		for (WebElement element : elements) {
			if (element.getText().equals(title)) {
				System.out.println("findFirstMatchingElement: element.getText().equals(title) for:" + title);
				matchingElement = element;
				break;
			}
		}
		return matchingElement;
	}

	public static WebElement findFirstMatchingListElement(WebDriver driver, WebElement parent, String xpath,
			String title) {
		WebElement matchingElement = null;
		List<WebElement> elements = parent.findElements(By.xpath(xpath));

		for (WebElement element : elements) {
			if (element.getText().equals(title)) {
				System.out.println("findFirstMatchingElement: element.getText().equals(title) for:" + title);
				matchingElement = element;
				break;
			}
		}
		return matchingElement;
	}

	public static WebElement findFirstMatchingListElement(WebDriver driver, WebElement parent, String title) {
		WebElement matchingElement = null;
		List<WebElement> elements = parent.findElements(By.xpath("//*"));

		for (WebElement element : elements) {
			if (element.getText().equals(title)) {
				System.out.println("findFirstMatchingElement: element.getText().equals(title) for:" + title);
				matchingElement = element;
				break;
			}
		}
		return matchingElement;
	}

	public static String getMessage(WebDriver driver) {
		WebElement elmnt = driver.findElement(By.xpath("//div[@id='swal2-html-container']"));
		return elmnt.getText();
	}

	public static void presOK(WebDriver driver) {
		WebElement elmnt = driver.findElement(By.xpath("//button[@class='swal2-confirm swal2-styled']"));
		elmnt.click();
	}

}
