package org.testngPojo;

import org.base.classes.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Question_3_Pojo extends BaseClass {

	public Question_3_Pojo() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "first-name")
	private WebElement firstName;

	@FindBy(id = "last-name")
	private WebElement lastName;

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getMobileNumber() {
		return mobileNumber;
	}

	public WebElement getCountryIndia() {
		return countryIndia;
	}

	public WebElement getCityName() {
		return cityName;
	}

	public WebElement getEnterMessage() {
		return enterMessage;
	}

	public WebElement getSend() {
		return send;
	}

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(id = "mobile")
	private WebElement mobileNumber;

	@FindBy(xpath = "//option[text()='India']")
	private WebElement countryIndia;

	@FindBy(id = "city")
	private WebElement cityName;

	@FindBy(id = "message")
	private WebElement enterMessage;

	@FindBy(xpath = "//button[text()='Send']")
	private WebElement send;

}
