package org.ictak.testCases;

import java.io.IOException;

import org.ictak.constants.Constant;
import org.ictak.pages.AddUsers;
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
	public void addAdminUser_TC_24() throws IOException {
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
		User objUser = objUsers.findUser(ExcelUtility.getTestData(1, "TC_25", 3));
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

//		Assert.assertEquals(updateUser.getMessage(), Constant.SUCESS_MSG);
		// Thread.sleep(4000);
		// addUser.presOK();

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
		User objUser = objUsers.findUser(ExcelUtility.getTestData(1, "TC_26", 3));
		objUser.delete();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		objLearDashBoard.logout();

	}

}
