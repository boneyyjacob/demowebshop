package com.demowebshop.testscript;


import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.demowebshop.automationcore.Base;
import com.demowebshop.constants.ErrorMessages;
import com.demowebshop.listeners.TestListener;
import com.demowebshop.pages.HomePage;
import com.demowebshop.utilities.ExcelUtility;

public class HomeTest extends Base
{
HomePage home;
ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
@Test
public void TC_001_verifySubscribeEmailMessage()
{
	List<ArrayList<String>> data=ExcelUtility.excelDataReader("HomePage");
	String expSubMessage=data.get(1).get(0);
	home=new HomePage(driver);
	home.enterSubscribeEmailID();
	home.clickOnSubscribeButton();
	
	String actSubMessage=home.getSubscribeMessage();
	Assert.assertEquals(actSubMessage, expSubMessage, ErrorMessages.SUBSCRIBE_FAILURE_MESSAGE);
	}
}
