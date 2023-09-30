package org.ictak.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class User extends PageBase {
	private String name;
	private String email;
	private String userName;
	private String password;
	private String role;
	private WebElement updateButton;
	private WebElement deleteButton;

	public User(WebDriver driver, WebElement row, WebElement updateButton, WebElement deleteButton) {
		super(driver);
		List<WebElement> children = row.findElements(By.tagName("td"));
		if (children.size() > 0) {
			int i = 0;
			name = children.get(i++).getText();
			email = children.get(i++).getText();
			userName = children.get(i++).getText();
			password = children.get(i++).getText();
			role = children.get(i++).getText();
			this.updateButton = updateButton;
			this.deleteButton = deleteButton;
			
//			updateButton = row.findElement(By.xpath("//button[@class='btn btn-success btn btn-primary']"));
//			deleteButton = row.findElement(By.xpath("//button[@class='btn btn-danger btn btn-primary']"));
		}

	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", userName=" + userName + ", password=" + password
				+ ", role=" + role + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public AddUsers navigateToUpdate() {
		updateButton.click();
		return new AddUsers(driver);
	}

	public void delete() {
		deleteButton.click();
	}
}
