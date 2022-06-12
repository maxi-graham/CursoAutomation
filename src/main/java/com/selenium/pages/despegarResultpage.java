package com.selenium.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class despegarResultpage {

	@FindBy(xpath="//*[@class='tooltip-close eva-3-icon-close']")
	WebElement ventana_emergente;
	@FindBy(xpath="//*[@class='accommodation-name-wrapper']//*[@class='accommodation-name -eva-3-ellipsis'][text()='Savannah Cordoba Hotel']")
	WebElement hotel_encontrado;
	
	
	private WebDriver driver=null;
	WebDriverWait wait;
	//----------------------------------------------------------------
	public despegarResultpage (WebDriver Construcdriver) {
		this.driver = Construcdriver;
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	public void ventana_emergente() {
		this.ventana_emergente.click();
	}
	
	public boolean hotel_encontrado_visible() {
		return this.hotel_encontrado.isDisplayed();
	}
	
}
