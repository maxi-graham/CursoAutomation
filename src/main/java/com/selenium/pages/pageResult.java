package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pageResult {
	
	@FindBy(id="firstHeading")
	WebElement titulo;
	
	private WebDriver driver=null;
	
	public pageResult (WebDriver Construcdriver) {
		this.driver = Construcdriver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean tituloEsVisible() {
		return this.titulo.isDisplayed();
	}

}
