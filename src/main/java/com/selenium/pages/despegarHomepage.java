package com.selenium.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class despegarHomepage {
	
	@FindBy(id="logo-desktop")
	WebElement logo_desktop;
	
	@FindBy(xpath="//*[@class='shifu-icon-product shifu-3-icon-hotels']")
	WebElement btn_Alojamiento;
	
	@FindBy(css="ul.header-list-products > li")
	List <WebElement> listamenu;
			
	private WebDriver driver=null;
	WebDriverWait wait;
	//----------------------------------------------------------------
	public despegarHomepage (WebDriver Construcdriver) {
		this.driver = Construcdriver;
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
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
	
	public void validarListaMenu () {
		
		for (int i=0; i < listamenu.size(); i ++) {
			WebElement labelMenu = listamenu.get(i).findElement(By.cssSelector(" label"));
			wait.until(ExpectedConditions.elementToBeClickable(this.listamenu.get(i)));
			//labelMenu.click();
			Assert.assertTrue(labelMenu.isDisplayed(), "El elemento no es visible");
		}
	}
}
