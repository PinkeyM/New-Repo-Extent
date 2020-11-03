package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBaseClass;

public class LoginPageClass extends TestBaseClass{
	
	
	@FindBy(xpath="//input[@class='_2zrpKA _1dBPDZ']")
	WebElement UserName;
	@FindBy(xpath="//input[@type='password']")
	WebElement Password;
	@FindBy(xpath="//button[@class='_2AkmmA _1LctnI _7UHT_c']")
	WebElement Login;
	
	public LoginPageClass() throws IOException {
		PageFactory.initElements(driver, this);
		
	}


public String getTitle() {
	return driver.getTitle();
	
}

public HomePage Login(String un, String pwd) throws IOException {
UserName.sendKeys(un);
Password.sendKeys(pwd);
Login.click();
return new HomePage();
}
}
