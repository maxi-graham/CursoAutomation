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
	@FindBy(xpath="//*[@class='-eva-3-icon-md eva-3-icon-rentals -eva-3-mr-sm']")
	WebElement resultado_hotel;
	
	
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
		return this.resultado_hotel.isDisplayed();
	}
	
}
