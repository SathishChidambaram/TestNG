package org.testngTask;

import org.base.classes.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testngPojo.Question_1_Pojo;

public class Question_1 extends BaseClass {

	@Test()
	public void tc1() {

		browserLaunch();
		maxWindow();
	}

	@Test
	public void tc2() {

		launchURL("https://www.facebook.com/");
	}

	@Test()
	public void tc3() {

		driver.close();
		System.out.println("Facebook Launched Successfully");
	}

	@Test
	public void tc4() {

		browserLaunch();
		maxWindow();
		launchURL("https://www.flipkart.com/");

	}

	@Test(enabled=false)
	public void tc5() {

		driver.close();
		System.out.println("Flipkart Launched Successfully");
	}

	@Test(dataProvider = "veni", dataProviderClass = Facebook.class)
	public void tc8(String userName, String passWord) {
		browserLaunch();
		maxWindow();
		launchURL("https://www.facebook.com/");
		Question_1_Pojo q1 = new Question_1_Pojo();
		sendText(q1.getUserName(), userName);
		sendText(q1.getPassWord(), passWord);
		click(q1.getLogIn());
		driver.close();

	}

}
