 package org.testngTask;

import org.base.classes.BaseClass;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testngPojo.Question_1_Pojo;

public class Facebook extends BaseClass {
	@Parameters({ "userName", "passWord" })
	@Test
	public void tc1(String userName, String passWord) {
		edgeBrowserLaunch();
		maxWindow();
		launchURL("https://www.facebook.com/");
		Question_1_Pojo q1 = new Question_1_Pojo();
		sendText(q1.getUserName(), userName);
		sendText(q1.getPassWord(), passWord);
		click(q1.getLogIn());
		driver.close();

	}

	@Parameters({ "userName1", "passWord1" })
	//@Test(retryAnalyzer=ReRunTheFacebook.class)
	@Test
	public void tc2(String userName, String passWord) {
		//browserLaunch();
		edgeBrowserLaunch();
		maxWindow();
		launchURL("https://www.facebook.com/");
		Question_1_Pojo q1 = new Question_1_Pojo();
		//Assert.assertTrue(false);
		sendText(q1.getUserName(), userName);
		sendText(q1.getPassWord(), passWord);
		click(q1.getLogIn());
		driver.close();

	}

	@Test(dataProvider = "veni")
	public void tc3(String userName, String passWord) {
		//browserLaunch();
		edgeBrowserLaunch();
		maxWindow();
		launchURL("https://www.facebook.com/");
		Question_1_Pojo q1 = new Question_1_Pojo();
		sendText(q1.getUserName(), userName);
		sendText(q1.getPassWord(), passWord);
		click(q1.getLogIn());
		driver.close();

	}

	@DataProvider(name = "veni")
	public Object[][] sampleData() {

		return new Object[][] {

				{ "veni@gmail.com", "veni@123" }, { "muthu@gmail.com", "muthu@123" }

		};

	}
}
