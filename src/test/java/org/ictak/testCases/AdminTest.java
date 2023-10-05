package org.ictak.testCases;

import java.io.IOException;

import org.ictak.constants.Constant;
import org.ictak.pages.AddUsers;
import org.ictak.pages.Learners;
import org.ictak.pages.LearnersForm;
import org.ictak.pages.Login;
import org.ictak.pages.Navigator;
import org.ictak.pages.User;
import org.ictak.pages.Users;
import org.ictak.utilities.ExcelUtility;
import org.ictak.utilities.Util;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminTest extends TestBase {

	@Test(priority = 5)
	public void addAdminUserRole_TC_24() throws IOException {
		Navigator objLearDashBoard = new Navigator(driver);
		Login log = Util.setLoginFields(driver, 0);
		log.loginclick();

		objLearDashBoard.users();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		for (int i = 0; i < 5; i++) {
//			System.out.println(ExcelUtility.getTestData(1, "TC_24", i));
//		}

		Users objUser = new Users(driver);
		AddUsers addUsers = objUser.addUsers();
		System.out.println("Print AddUser...");
		addUsers.setName(ExcelUtility.getTestData(1, "TC_24", 1));
		addUsers.setEmail(ExcelUtility.getTestData(1, "TC_24", 2));
		addUsers.setUserName(ExcelUtility.getTestData(1, "TC_24", 3));
		addUsers.setPassword(ExcelUtility.getTestData(1, "TC_24", 4));
		addUsers.setRole(ExcelUtility.getTestData(1, "TC_24", 5));
		addUsers.clickSubmit();

		Assert.assertEquals(Util.getMessage(driver), Constant.SUCESS_MSG);

		Util.sleepForMilliSec(2000);
		Util.presOK(driver);

		Util.sleepForMilliSec(2000);
		objLearDashBoard.logout();

	}

	@Test(priority = 6)
	public void adminTask_backtoDashboard_TC_35() throws IOException {
		Navigator objLearDashBoard = new Navigator(driver);
		Login log = Util.setLoginFields(driver, 0);
		log.loginclick();

		objLearDashBoard.users();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Users objUser = new Users(driver);
		AddUsers addUsers = objUser.addUsers();
		System.out.println("Print AddUser...");
		addUsers.setName(ExcelUtility.getTestData(1, "TC_24", 1));
		addUsers.setEmail(ExcelUtility.getTestData(1, "TC_24", 2));
		addUsers.setUserName(ExcelUtility.getTestData(1, "TC_24", 3));
		addUsers.setPassword(ExcelUtility.getTestData(1, "TC_24", 4));
		addUsers.setRole(ExcelUtility.getTestData(1, "TC_24", 5));
		addUsers.clickBackDashb();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		objLearDashBoard.logout();

	}

	@Test(priority = 7)
	public void editUserAdmin_TC_25() throws IOException {

		Login log = Util.setLoginFields(driver, 0);
		log.loginclick();
		Navigator objLearDashBoard = new Navigator(driver);
		objLearDashBoard.users();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Users objUsers = new Users(driver);
//		User objUser = objUsers.findUser(ExcelUtility.getTestData(1, "TC_25", 3));
		User objUser = objUsers.findFistUser();

		AddUsers updateUser = objUser.navigateToUpdate();
		System.out.println("Print UPdate User...");
		updateUser.setRole(ExcelUtility.getTestData(1, "TC_25", 5));
		System.out.println("Read the excel file");
		updateUser.clickSubmit();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		objLearDashBoard.logout();

	}

	@Test(priority = 8)
	public void deleteAdmin_TC_26() throws IOException {

		Login log = Util.setLoginFields(driver, 0);
		log.loginclick();
		Util.sleepForMilliSec(2000);
		Navigator objLearDashBoard = new Navigator(driver);
		objLearDashBoard.users();
		Util.sleepForMilliSec(2000);

		Users objUsers = new Users(driver);
//		User objUser = objUsers.findUser(ExcelUtility.getTestData(1, "TC_26", 3));
		User objUser = objUsers.findFistUser();
		objUser.delete();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		objLearDashBoard.logout();

	}

	@Test(priority = 9)

	public void adminAddUserBlankProject_TC_14() throws IOException {

		Navigator objLearDashBoard = new Navigator(driver);
		Login log;
		log = Util.setLoginFields(driver, 0);
		log.loginclick();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String actualResult = objLearDashBoard.getUserTitle();
		System.out.println("This is Actual Result : " + actualResult);
		Assert.assertEquals(actualResult, Constant.USERS);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		objLearDashBoard.users();

		Users objUser = new Users(driver);
		AddUsers addUsers = objUser.addUsers();
		System.out.println("Print AddUser...");
		addUsers.setName(ExcelUtility.getTestData(1, "TC_14", 1));
		// addUsers.setEmail(ExcelUtility.getTestData(1, "TC_14", 2));
		addUsers.setUserName(ExcelUtility.getTestData(1, "TC_14", 3));
		addUsers.setPassword(ExcelUtility.getTestData(1, "TC_14", 4));
		addUsers.setRole(ExcelUtility.getTestData(1, "TC_14", 5));
		addUsers.clickSubmit();
		String errorMsg = addUsers.getBlankFieldErrMessage();
		Assert.assertEquals(errorMsg, Constant.USER_BLANK_ERROR);

		Util.sleepForMilliSec(2000);

		addUsers.clickBackDashb();

		Util.sleepForMilliSec(2000);

		objLearDashBoard.logout();

	}

	@Test(priority = 10)

	public void adminAddUserInvalidProject_TC_28() throws IOException {

		Navigator objLearDashBoard = new Navigator(driver);
		Login log;
		log = Util.setLoginFields(driver, 0);
		log.loginclick();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String actualResult = objLearDashBoard.getUserTitle();
		System.out.println("This is Actual Result : " + actualResult);
		Assert.assertEquals(actualResult, Constant.USERS);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		objLearDashBoard.users();

		Users objUser = new Users(driver);
		AddUsers addUsers = objUser.addUsers();
		System.out.println("Print AddUser...");
		addUsers.setName(ExcelUtility.getTestData(1, "TC_28", 1));
		addUsers.setEmail(ExcelUtility.getTestData(1, "TC_28", 2));
		addUsers.setUserName(ExcelUtility.getTestData(1, "TC_28", 3));
		addUsers.setPassword(ExcelUtility.getTestData(1, "TC_28", 4));
		addUsers.setRole(ExcelUtility.getTestData(1, "TC_28", 5));
		addUsers.clickSubmit();
		String errorMsg = addUsers.getBlankFieldErrMessage();
		Assert.assertEquals(errorMsg, Constant.USER_INVALID_USERNAME);

		Util.sleepForMilliSec(2000);
		addUsers.clickBackDashb();

		Util.sleepForMilliSec(2000);
		objLearDashBoard.logout();

	}

	@Test(priority = 11)
	public void addTrainingHeadUserRole_TC_51() throws IOException {
		Navigator objLearDashBoard = new Navigator(driver);
		Login log = Util.setLoginFields(driver, 0);
		log.loginclick();

		objLearDashBoard.users();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Users objUser = new Users(driver);
		AddUsers addUsers = objUser.addUsers();
		System.out.println("Print AddUser...");
		addUsers.setName(ExcelUtility.getTestData(1, "TC_51", 1));
		addUsers.setEmail(ExcelUtility.getTestData(1, "TC_51", 2));
		addUsers.setUserName(ExcelUtility.getTestData(1, "TC_51", 3));
		addUsers.setPassword(ExcelUtility.getTestData(1, "TC_51", 4));
		addUsers.setRole(ExcelUtility.getTestData(1, "TC_51", 5));
		addUsers.clickSubmit();

		Assert.assertEquals(Util.getMessage(driver), Constant.SUCESS_MSG);

		Util.sleepForMilliSec(2000);
		Util.presOK(driver);

		Util.sleepForMilliSec(2000);
		objLearDashBoard.logout();

	}

	@Test(priority = 12)
	public void adminViewUsers_TC_52() throws IOException {
		Navigator objLearDashBoard = new Navigator(driver);
		Login log = Util.setLoginFields(driver, 0);
		log.loginclick();

		objLearDashBoard.users();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		objLearDashBoard.clickLearner();
		Util.sleepForMilliSec(2000);
		objLearDashBoard.clickPlacement();
		Util.sleepForMilliSec(2000);
		objLearDashBoard.logout();

	}

}
