package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBaseClass;

public class HomePage extends TestBaseClass{
	
	
	@FindBy(xpath="//input[@type='text']")
	WebElement searchbox;
	@FindBy(xpath="//button[@class='vh79eN']")
	WebElement box;
public HomePage() throws IOException {
		
		PageFactory.initElements(driver, this);
	}



public String Title() {
	return driver.getTitle();
}

public void search(String val) {
	 searchbox.sendKeys(val);
	 box.click();
	
}


}