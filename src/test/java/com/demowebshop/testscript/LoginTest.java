package com.demowebshop.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.demowebshop.automationcore.Base;
import com.demowebshop.constants.ErrorMessages;
import com.demowebshop.dataprovider.DataProviders;
import com.demowebshop.listeners.TestListener;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.LoginPage;
import com.demowebshop.utilities.ExcelUtility;

public class LoginTest extends Base
{
	LoginPage login;
	HomePage home;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	
	@Test(priority=1,enabled=true,description="TC_002_verify Invalid Login Error Message", groups={"Smoke"},dataProvider="InvalidUserCredentials",dataProviderClass=DataProviders.class)
	public void TC_002_verifyInvalidLoginErrorMessage(String useremail,String userpassword)
	{
		extentTest.get().assignCategory("Smoke");
		List<ArrayList<String>> data =ExcelUtility.excelDataReader("LoginPage");
		String expErrMessage=data.get(1).get(2);
		home=new HomePage(driver);
		login=home.clickonLoginMenu();
		login.enterUserCredentials(useremail, userpassword);
		login.clickOnLoginButton();
		String actErrMessage=login.getLoginErrorMessage();
		Assert.assertEquals(actErrMessage, expErrMessage,ErrorMessages.INVALID_ERROR_MESSAGE);
	}
}
