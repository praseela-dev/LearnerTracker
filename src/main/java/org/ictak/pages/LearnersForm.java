package org.ictak.pages;

import java.util.List;

import org.ictak.utilities.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LearnersForm extends PageBase {

	private String learnerId;
	private String name;
	private String course;
	private String project;
	private String batch;
	private String courseStatus;
	private String placementStatus;

//	private WebElement submitButton;

	private WebElement updateButton;

	public LearnersForm(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public LearnersForm(WebDriver driver, WebElement row,WebElement button ) {
		super(driver);
		List<WebElement> children = row.findElements(By.tagName("td"));
		if (children.size() > 0) {
			int i = 0;
			learnerId = children.get(i++).getText();
			name = children.get(i++).getText();
			course = children.get(i++).getText();
			project = children.get(i++).getText();
			batch = children.get(i++).getText();
			courseStatus = children.get(i++).getText();
			placementStatus = children.get(i++).getText();

			updateButton = button;
//			updateButton = row.findElement(By.xpath("//button[@class='btn btn-success btn btn-primary']"));
//			deleteButton = row.findElement(By.xpath("//button[@class='btn btn-danger btn btn-primary']"));
		}
	}

	public String getLearnerId() {
		return learnerId;
	}

	public void setLearnerId(String learnerId) {
		WebElement elmnt = driver.findElement(By.xpath("//input[@id='learnerid']"));
		elmnt.sendKeys(learnerId);
		this.learnerId = learnerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		WebElement elmnt = driver.findElement(By.xpath("//input[@id='name']"));
		elmnt.sendKeys(name);
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		WebElement dropDown = driver.findElement(By.xpath("//select[@name='course']"));
		dropDown.click();
		WebElement subMenu = Util.findFirstMatchingListElement(driver, dropDown, course);
		subMenu.click();
		this.course = course;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		WebElement dropDown = driver.findElement(By.xpath("//select[@name='project']"));
		dropDown.click();

		WebElement subMenu = Util.findFirstMatchingListElement(driver, dropDown, project);
		subMenu.click();
		subMenu.click();
		this.project = project;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		WebElement dropDown = driver.findElement(By.xpath("//select[@name='batch']"));
		dropDown.click();
		WebElement subMenu = Util.findFirstMatchingListElement(driver, dropDown, batch);
		subMenu.click();
		this.batch = batch;
	}

	public String getCourseStatus() {
		return courseStatus;
	}

	public void setCourseStatus(String courseStatus) {
		WebElement dropDown = driver.findElement(By.xpath("//select[@name='cstatus']"));
		dropDown.click();
		WebElement subMenu = Util.findFirstMatchingListElement(driver, dropDown, courseStatus);
		subMenu.click();
		this.courseStatus = courseStatus;
	}

	public void setPlacementStatus(String placementStaus) {
		WebElement dropDown = driver.findElement(By.xpath("//select[@name='pstatus']"));
		dropDown.click();
		WebElement subMenu = Util.findFirstMatchingListElement(driver, dropDown, placementStaus);
		subMenu.click();
		this.placementStatus = placementStaus;
	}

	public String getPlacementStatus() {
		return placementStatus;
	}

	public void navigateToEdit() {
		updateButton.click();
	}

	public void clickSubmit() {
		WebElement elmnt = driver.findElement(By.xpath("//button[@class='btn btn-success']"));
		elmnt.click();
	}

	@Override
	public String toString() {
		return "LearnersForm [learnerId=" + learnerId + ", name=" + name + ", course=" + course + ", project=" + project
				+ ", batch=" + batch + ", courseStatus=" + courseStatus + ", placementStatus=" + placementStatus + "]";
	}

}
