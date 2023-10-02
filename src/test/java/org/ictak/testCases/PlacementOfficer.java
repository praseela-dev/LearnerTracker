package org.ictak.testCases;

import org.ictak.constants.Constant;
import org.ictak.pages.Learners;
import org.ictak.pages.LearnersForm;
import org.ictak.pages.Login;
import org.ictak.pages.Navigator;
import org.ictak.pages.Placement;
import org.ictak.utilities.ExcelUtility;
import org.ictak.utilities.Util;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlacementOfficer extends TestBase{
	
	@Test(priority = 9)
	public void updatePlacementStatus_TC_46() {

		Navigator objDashBoard = new Navigator(driver);
		Login log;
		try {
			log = Util.setLoginFields(driver, 2);

			log.loginclick();
			String actualResult = objDashBoard.getUserTitle();
			System.out.println("This is Actual Result : " + actualResult);
			Assert.assertEquals(actualResult, Constant.PLACEMENT_OFFICER);

			Thread.sleep(2000);
			Placement objPlacement = objDashBoard.placement();
			LearnersForm objFoarm = Util.findLerner(driver, ExcelUtility.getTestData(1, "TC_46", 1), false); 
			objFoarm.navigateToEdit();
			objFoarm.setPlacementStatus(ExcelUtility.getTestData(1, "TC_46", 2));

			objFoarm.clickSubmit();

			objDashBoard.logout();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
