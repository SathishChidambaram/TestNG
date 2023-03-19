package org.testngTask;

import org.base.classes.BaseClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testngPojo.Question_3_Pojo;

public class Question_3_Task extends BaseClass {
	Question_3_Pojo q3;

	@Test
	public void tc1() {
		browserLaunch();
		maxWindow();

	}

	@Test
	public void tc3() throws InterruptedException {
		launchURL("https://www.toolsqa.com/selenium-training/#enroll-form");
		Thread.sleep(5000);
		//q3 = new Question_3_Pojo();
		sendText(q3.getFirstName(), "Sathish");
		sendText(q3.getLastName(), "Chidambaram");
		sendText(q3.getEmail(), "sathish@123.com");
		sendText(q3.getMobileNumber(), "9894586508");
		click(q3.getCountryIndia());
		sendText(q3.getCityName(), "Cheanni");
		sendText(q3.getEnterMessage(), "Hi this is Sathish Chidambaram");
		click(q3.getSend());
		System.out.println("All Test Cases are Runned Successfully");
		// driver.close();

	}

}
