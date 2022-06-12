package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pageHome {
	
	@FindBy(id="searchInput")
	WebElement searchinput;
	
	private WebDriver driver=null;
	//----------------------------------------------------------------
	public pageHome (WebDriver Construcdriver) {
		this.driver = Construcdriver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean searchInputEsVisible() {
		return this.searchinput.isDisplayed();
	}
	
	public pageResult searchtext (String text) {
		this.searchinput.sendKeys(text);
		this.searchinput.submit();
		return new pageResult(this.driver);
	}	

}
