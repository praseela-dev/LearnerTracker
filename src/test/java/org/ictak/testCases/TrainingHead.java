package org.ictak.testCases;

import org.ictak.constants.Constant;
import org.ictak.pages.CsvUploadePage;
import org.ictak.pages.Learners;
import org.ictak.pages.LearnersForm;
import org.ictak.pages.Login;
import org.ictak.pages.Navigator;
import org.ictak.pages.Placement;
import org.ictak.utilities.ExcelUtility;
import org.ictak.utilities.Util;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TrainingHead extends TestBase {

	@Test(priority = 10)

	public void trainingHeadAddLearner_TC_34() {

		Navigator objLearDashBoard = new Navigator(driver);
		Login log;
		try {
			log = Util.setLoginFields(driver, 1);

			log.loginclick();
			String actualResult = objLearDashBoard.getUserTitle();
			System.out.println("This is Actual Result : " + actualResult);
			Assert.assertEquals(actualResult, Constant.LEARNERS);

			Thread.sleep(2000);
			Learners objLerners = objLearDashBoard.learners();
			LearnersForm objFoarm = objLerners.addLearner();

			objFoarm.setLearnerId(ExcelUtility.getTestData(1, "TC_34", 1));
			objFoarm.setName(ExcelUtility.getTestData(1, "TC_34", 2));
			objFoarm.setCourse(ExcelUtility.getTestData(1, "TC_34", 3));
			objFoarm.setProject(ExcelUtility.getTestData(1, "TC_34", 4));
			objFoarm.setBatch(ExcelUtility.getTestData(1, "TC_34", 5));
			objFoarm.setCourseStatus(ExcelUtility.getTestData(1, "TC_34", 6));

			objFoarm.clickSubmit();

			Assert.assertEquals(Util.getMessage(driver), Constant.SUCESS_MSG);

			Util.sleepForMilliSec(2000);
			Util.presOK(driver);
			Util.sleepForMilliSec(2000);

			objLearDashBoard.logout();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(priority = 11)

	public void trainingHeadBulkUpdate_TC_42() {

		Navigator objLearDashBoard = new Navigator(driver);
		Login log;
		try {
			log = Util.setLoginFields(driver, 1);

			log.loginclick();
			String actualResult = objLearDashBoard.getUserTitle();
			System.out.println("This is Actual Result : " + actualResult);
			Assert.assertEquals(actualResult, Constant.LEARNERS);

			Thread.sleep(2000);
			Learners objLerners = objLearDashBoard.learners();
			CsvUploadePage objCsvUploader = objLerners.navigateToCsvUploadPage();
			String csvFile = System.getProperty("user.dir") + "\\src\\main\\resources\\LearnersCSV.csv";
			objCsvUploader.upload(csvFile);
			Assert.assertEquals(objCsvUploader.getMessage(), Constant.SUCESS_MSG_CSV);
			objCsvUploader.presOK();

			Assert.assertEquals(objCsvUploader.getMessage(), Constant.SAVED);
			objCsvUploader.presOK();

			objLearDashBoard.logout();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(priority = 12)

	public void trainingHeadAddLearnerBlankProject_TC_41() {

		Navigator objLearDashBoard = new Navigator(driver);
		Login log;
		try {
			log = Util.setLoginFields(driver, 1);

			log.loginclick();
			String actualResult = objLearDashBoard.getUserTitle();
			System.out.println("This is Actual Result : " + actualResult);
			Assert.assertEquals(actualResult, Constant.LEARNERS);

			Thread.sleep(2000);
			Learners objLerners = objLearDashBoard.learners();
			LearnersForm objFoarm = objLerners.addLearner();

			objFoarm.setLearnerId(ExcelUtility.getTestData(1, "TC_41", 1));
			objFoarm.setName(ExcelUtility.getTestData(1, "TC_41", 2));
			objFoarm.setCourse(ExcelUtility.getTestData(1, "TC_41", 3));
//			objFoarm.setProject(ExcelUtility.getTestData(1, "TC_41", 4));
			objFoarm.setBatch(ExcelUtility.getTestData(1, "TC_41", 5));
			objFoarm.setCourseStatus(ExcelUtility.getTestData(1, "TC_41", 6));

			objFoarm.clickSubmit();

			Assert.assertEquals(objFoarm.getEmptyFieldError(), Constant.EMPTY_PROJECT_ERROR);

			Util.sleepForMilliSec(2000);
			objFoarm.clickBackDashb();
			Util.sleepForMilliSec(2000);
			objLearDashBoard.logout();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 13)

	public void trainingHeadAddLearnerInvalidName_TC_38() {

		Navigator objLearDashBoard = new Navigator(driver);
		Login log;
		try {
			log = Util.setLoginFields(driver, 1);

			log.loginclick();
			String actualResult = objLearDashBoard.getUserTitle();
			System.out.println("This is Actual Result : " + actualResult);
			Assert.assertEquals(actualResult, Constant.LEARNERS);

			Thread.sleep(2000);
			Learners objLerners = objLearDashBoard.learners();
			LearnersForm objFoarm = objLerners.addLearner();

			objFoarm.setLearnerId(ExcelUtility.getTestData(1, "TC_38", 1));
			objFoarm.setName(ExcelUtility.getTestData(1, "TC_38", 2));
			objFoarm.setCourse(ExcelUtility.getTestData(1, "TC_38", 3));
			objFoarm.setProject(ExcelUtility.getTestData(1, "TC_38", 4));
			objFoarm.setBatch(ExcelUtility.getTestData(1, "TC_38", 5));
			objFoarm.setCourseStatus(ExcelUtility.getTestData(1, "TC_38", 6));

			objFoarm.clickSubmit();

			Assert.assertEquals(objFoarm.getEmptyFieldError(), Constant.LERANS_INVALID_NAME_ERROR);

			Util.sleepForMilliSec(2000);
			objFoarm.clickBackDashb();
			Util.sleepForMilliSec(2000);
			objLearDashBoard.logout();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 14)
	public void updateLearner_TC_49() {

		Navigator objDashBoard = new Navigator(driver);
		Login log;
		try {
			log = Util.setLoginFields(driver, 1);
			Util.sleepForMilliSec(2000);
			log.loginclick();
			Util.sleepForMilliSec(2000);
			String actualResult = objDashBoard.getUserTitle();
			System.out.println("This is Actual Result : " + actualResult);
			Assert.assertEquals(actualResult, Constant.LEARNERS);

			Thread.sleep(2000);
//			Learners objLearner = objDashBoard.learners();
//			LearnersForm objFoarm = Util.findLerner(driver, ExcelUtility.getTestData(1, "TC_49", 1), true); 
			LearnersForm objFoarm = Util.findFirstLerner(driver, true); 
			objFoarm.navigateToEdit();
			objFoarm.setCourse(ExcelUtility.getTestData(1, "TC_49", 3));
			objFoarm.setProject(ExcelUtility.getTestData(1, "TC_49", 4));
			objFoarm.setCourseStatus(ExcelUtility.getTestData(1, "TC_49", 6));

			objFoarm.clickSubmit();

//			Assert.assertEquals(Util.getMessage(driver), Constant.SUCESS_MSG);
//
//			Util.sleepForMilliSec(2000);
//			Util.presOK(driver);
			Util.sleepForMilliSec(2000);

			objDashBoard.logout();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 15)
	public void deleteLearner_TC_50() {

		Util.sleepForMilliSec(2000);
		
		Navigator objDashBoard = new Navigator(driver);
		Login log;
		try {
			log = Util.setLoginFields(driver, 1);

			log.loginclick();
			Util.sleepForMilliSec(2000);
			String actualResult = objDashBoard.getUserTitle();
			System.out.println("This is Actual Result : " + actualResult);
			Assert.assertEquals(actualResult, Constant.LEARNERS);

			Thread.sleep(2000);
//			LearnersForm objFoarm = Util.findLerner(driver, ExcelUtility.getTestData(1, "TC_49", 1), true); 
			LearnersForm objFoarm = Util.findFirstLerner(driver, true); 
			objFoarm.delete();

//			Assert.assertEquals(Util.getMessage(driver), Constant.SUCESS_MSG);
//
//			Util.sleepForMilliSec(2000);
//			Util.presOK(driver);
//			Util.sleepForMilliSec(2000);

			objDashBoard.logout();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}}

