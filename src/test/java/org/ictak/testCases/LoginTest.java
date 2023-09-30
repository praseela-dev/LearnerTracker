package org.ictak.testCases;

import java.io.IOException;

import org.ictak.constants.Constant;
import org.ictak.pages.Navigator;
import org.ictak.pages.Login;
import org.ictak.pages.PageBase;
import org.ictak.utilities.ExcelUtility;
import org.ictak.utilities.Util;
import org.openqa.selenium.UsernameAndPassword;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

	@Test(priority = 0)

	public void validAdminLogin_TC_2() {

		Navigator objLearDashBoard = new Navigator(driver);
		Login log;
		try {
			log = Util.setLoginFields(driver, 0);

			log.loginclick();
			Util.sleepForMilliSec(2000);
			String actualResult = objLearDashBoard.getUserTitle();
			System.out.println("This is Actual Result : " + actualResult);
			Assert.assertEquals(actualResult, Constant.USERS);

			Thread.sleep(4000);
			objLearDashBoard.users();
			System.out.println("Entered Dashboard");

			// Thread.sleep(4000);
			objLearDashBoard.logout();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(priority = 1)
	public void verifyValidAdminAndInvalidPasswd_TC_3() {

		try {
			Login log = Util.setLoginFields(driver, 3);
			log.loginclick();
			String actualResult = log.getError();
			System.out.println("This is Actual Result : " + actualResult);
			Assert.assertEquals(actualResult, Constant.LOGINFAILED);

			Thread.sleep(4000);
			log.clickError();

			System.out.println("Returned back to Login");

		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(priority = 2)

	public void validTrainingHeadLogin_TC_10() {

		Navigator objLearDashBoard = new Navigator(driver);
		Login log;
		try {
			log = Util.setLoginFields(driver, 1);

			log.loginclick();
			String actualResult = objLearDashBoard.getUserTitle();
			System.out.println("This is Actual Result : " + actualResult);
			Assert.assertEquals(actualResult, Constant.LEARNERS);

			Thread.sleep(4000);
			objLearDashBoard.users();
			System.out.println("Entered Dashboard");

			// Thread.sleep(4000);
			objLearDashBoard.logout();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	@Test(priority = 3)

	public void validPlacementOfficerLogin_TC_17() {

		Navigator objLearDashBoard = new Navigator(driver);
		Login log;
		try {
			log = Util.setLoginFields(driver, 2);

			log.loginclick();
			String actualResult = objLearDashBoard.getUserTitle();
			System.out.println("This is Actual Result : " + actualResult);
			Assert.assertEquals(actualResult, Constant.PLACEMENT_OFFICER);

			Thread.sleep(4000);
			objLearDashBoard.users();
			System.out.println("Entered Dashboard");

			// Thread.sleep(4000);
			objLearDashBoard.logout();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
