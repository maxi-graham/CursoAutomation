package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class despegarHomepage {
	
	@FindBy(id="logo-desktop")
	WebElement logo_desktop;
	
	@FindBy(xpath="//*[@class='shifu-icon-product shifu-3-icon-hotels']")
	WebElement btn_Alojamiento;
	
	private WebDriver driver=null;
	//----------------------------------------------------------------
	public despegarHomepage (WebDriver Construcdriver) {
		this.driver = Construcdriver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean log_desktopVisible() {
		return this.logo_desktop.isDisplayed();
	}
	
	public boolean btn_AlojamientoVisible() {
		return this.btn_Alojamiento.isDisplayed();
	}
	
	public despegarAlojamientopage btn_AlojamientoClick() {
		this.btn_Alojamiento.click();
		return new despegarAlojamientopage (this.driver);
	}
	
}
