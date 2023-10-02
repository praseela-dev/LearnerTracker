package org.ictak.testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeSuite;

public class TestBase {

	public static WebDriver driver;
	public static Properties properties;

	public TestBase() {
		properties = new Properties();
		File file = new File(System.getProperty("user.dir") + "/src/main/resources/config.properties");
		try {
			FileInputStream inputStream = new FileInputStream(file);
			properties.load(new InputStreamReader(inputStream, Charset.forName("UTF-8")));

		} catch (FileNotFoundException fie) {
			fie.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@BeforeSuite
	public void init() {

		String browser = properties.getProperty("browser");

		browser = browser.toLowerCase();

		if (browser.equals("edge")) {
			driver = new EdgeDriver();
		}

		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		}

		driver.get(properties.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
}
