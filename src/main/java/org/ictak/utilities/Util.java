package org.ictak.utilities;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.ictak.pages.Navigator;
import org.ictak.pages.LearnersForm;
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

	public static LearnersForm findLerner(WebDriver driver, String learnerId, boolean deletePresent) {
		LearnersForm objLerner = null;
		List<WebElement> pagination = driver.findElements(By.xpath("//li[@class='page-item']"));
		boolean found = false;
		for (WebElement index : pagination) {
			Util.sleepForMilliSec(2000);
			WebElement table = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']"));
			List<WebElement> rows = table.findElements(By.tagName("tr"));
			System.out.println("Row size = " + rows.size());

			List<WebElement> editButtons = null;
			List<WebElement> deleteButtons = null;

			if (deletePresent) {
				editButtons = table.findElements(By.xpath("//button[@class='btn btn-success']"));
				deleteButtons = table.findElements(By.xpath("//button[@class='btn btn-danger']"));
			} else {
				editButtons = table.findElements(By.xpath("//button[@class='btn btn-success btn btn-primary']"));
			}

			int i = 0;
			boolean header = true;
			for (WebElement row : rows) {
				if (header) {
					header = false;
					continue;
				}
				System.out.println("Row  = " + row.getText());
				LearnersForm learner = null;
				if (deletePresent) {
					learner = new LearnersForm(driver, row, editButtons.get(i), deleteButtons.get(i));
				} else {
					learner = new LearnersForm(driver, row, editButtons.get(i));
				}
				i++;
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

//	public static void waitForClickability(WebDriver driver, WebElement element) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.elementToBeClickable(element));
//	}

//	public static void waitUntilVisible(WebDriver driver, WebElement element) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOf(element));
//	}
	public static WebElement waitForClickability(WebDriver driver, By locatior) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		return wait.until(ExpectedConditions.elementToBeClickable(locatior));
	}

	public static WebElement waitUntilVisible(WebDriver driver, By locatior) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locatior));
	}
}
