package com.demowebshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.utilities.TestHelperUtility;
import com.demowebshop.utilities.WaitUtility;

public class HomePage extends TestHelperUtility {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private final String _subscribeEmailField = "newsletter-email";
	@FindBy(id = _subscribeEmailField)
	private WebElement subscribeEmailField;
	private final String _subscribeButton = "newsletter-subscribe-button";
	@FindBy(id = _subscribeButton)
	private WebElement subscribeButton;
	private final String _subscribeMessage="newsletter-result-block";
	@FindBy(id=_subscribeMessage)
	private WebElement subscribeMessage;
	private final String _loginLink="//a[@class='ico-login']";
	@FindBy(xpath=_loginLink)
	private WebElement loginLink;
	
	public void enterSubscribeEmailID() {
		String emailId = random.getRandomEmail();
		page.enterText(subscribeEmailField, emailId);
	}

	public void clickOnSubscribeButton() {
		subscribeButton.click();
	}
	public String getSubscribeMessage()
	{
		//wait.waitForElementToBeVisible(driver,_subscribeMessage, WaitUtility.LocatorType.Id);
		wait.setHardWait();
		String message=subscribeMessage.getText();
		return message;
	}
	public LoginPage clickonLoginMenu()
	{
		page.clickOnElement(loginLink);
		return new LoginPage(driver);
	}
	
}
