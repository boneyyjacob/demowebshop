package com.demowebshop.testscript;


import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.demowebshop.automationcore.Base;
import com.demowebshop.constants.ErrorMessages;
import com.demowebshop.constants.ExtentLog;
import com.demowebshop.listeners.TestListener;
import com.demowebshop.pages.HomePage;
import com.demowebshop.utilities.ExcelUtility;

public class HomeTest extends Base
{
HomePage home;
ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

@Test(priority=1,enabled=true,description="TC_001_verify Subscribe Email Message", groups={"Regression"})
public void TC_001_verifySubscribeEmailMessage()
{
	extentTest.get().assignCategory("Regression");
	List<ArrayList<String>> data=ExcelUtility.excelDataReader("HomePage");
	String expSubMessage=data.get(1).get(0);
	home=new HomePage(driver);
	home.enterSubscribeEmailID();
	extentTest.get().log(Status.PASS, ExtentLog.EMAIL_ENTERED_MESSAGE);
	home.clickOnSubscribeButton();
	extentTest.get().log(Status.PASS, ExtentLog.SUB_BUTTON_CLICKED_MESSAGE);
	String actSubMessage=home.getSubscribeMessage();
	Assert.assertEquals(actSubMessage, expSubMessage, ErrorMessages.SUBSCRIBE_FAILURE_MESSAGE);
	extentTest.get().log(Status.PASS, ExtentLog.VERIFIED_SUB_EMAIL_MESSAGE);
	}
}
