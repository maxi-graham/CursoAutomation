package com.selenium.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class despegarAlojamientopage {
	
	@FindBy(xpath="//*[@class='sbox5-3-input sbox5-3-validation -top-right -lg -icon-left']//*[@placeholder='Ingresá una ciudad, alojamiento o punto de interés']")
	WebElement text_Ciudad;
	@FindBy(xpath="//*[@class='ac-group-title eva-3-overline-2'][text()='Ciudades']")
	WebElement cuadro_ciudades;
	//@FindBy(xpath="//*[@class='shifu-icon-product shifu-3-icon-hotels']")
	@FindBy(css="i.shifu-icon-product shifu-3-icon-hotels")
	WebElement btn_Alojamiento;
	@FindBy(xpath="//*[@class='input-container']//*[@placeholder='Entrada']")
	WebElement calendario;
	@FindBy(xpath="//*[@class='lgpd-banner--button eva-3-btn -white -md']")
	//@FindBy(css="a.lgpd-banner--button eva-3-btn -white -md")
	WebElement btn_EntendiCookie;
	@FindBy(xpath="//*[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//*[@class='sbox5-monthgrid-dates sbox5-monthgrid-dates-31']//*[@class='sbox5-monthgrid-datenumber-number'][text()='18']")
	WebElement fecha_inicio;
	//@FindBy(xpath="//*[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//*[@class='sbox5-monthgrid sbox5-compact-view']//*[@class='sbox5-monthgrid-dates sbox5-monthgrid-dates-30']//*[@class='sbox5-monthgrid-datenumber-number'][text()='29']")
	@FindBy(xpath="//*[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//*[@class='sbox5-monthgrid-dates sbox5-monthgrid-dates-31']//*[@class='sbox5-monthgrid-datenumber-number'][text()='29']")
	WebElement fecha_fin;
	@FindBy(xpath="//*[@class='sbox5-3-btn -primary -md']")
	//@FindBy(css="button.sbox5-3-btn -primary -md")
	WebElement btn_aplicar;
	//@FindBy(xpath="//*[@class='sbox5-3-double-input']")
	@FindBy(css="div.sbox5-3-double-input")
	WebElement habitaciones;
	@FindBy(xpath="//*[@class='stepper__distribution_container']//*[@class='steppers-icon-right stepper__icon']")
	List <WebElement> lista_sumar_adulto;
	@FindBy(xpath="//*[@class='stepper__distribution_container']//*[@class='steppers-icon-right stepper__icon']")
	List <WebElement> lista_sumar_menor;
	@FindBy(xpath="//*[@class='stepper__distribution_container']//*[@class='select-container']//*[@class='select-option'][text()='3 años']")
	WebElement selecciona_edad_menor;
	@FindBy(xpath="//*[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//*[@class='stepper__room__footer ']//*[@class='sbox5-3-btn -md -primary']//*[@class='btn-text']")
	WebElement btn_aplicar_huesped;
	@FindBy(xpath="//*[@class='sbox5-box-button-ovr sbox5-3-btn -secondary -icon -lg']")
	//@FindBy(css="button.sbox5-box-button-ovr sbox5-3-btn -secondary -icon -lg")
	WebElement btn_buscar;
	//@FindBy(xpath="//*[@class='tooltip-close eva-3-icon-close']")
	@FindBy(css="i.tooltip-close eva-3-icon-close")
	WebElement ventana_emergente;
	@FindBy(xpath="//*[@class='login-incentive shifu-3-card -shifu-3-shadow-static -show']//*[@class='login-incentive--header']//*[@class='login-incentive--close shifu-3-icon-close -eva-3-mr-md']")
	WebElement btn_facebook;
	
	private WebDriver driver=null;
	WebDriverWait wait;
	//----------------------------------------------------------------
	public despegarAlojamientopage (WebDriver Construcdriver) {
		this.driver = Construcdriver;
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
	}
	
	public void text_Ciudadclick() {
		this.text_Ciudad.click();
	}
	
	public void text_Ciudad (String text) throws InterruptedException {
		this.text_Ciudad.sendKeys(text);
		Thread.sleep(1000);
		this.text_Ciudad.sendKeys(Keys.CONTROL);
		wait.until(ExpectedConditions.visibilityOf(this.cuadro_ciudades));
		this.text_Ciudad.sendKeys(Keys.ENTER);
	}
	
	public void calendarioClick() {
		this.calendario.click();
	}
	
	public boolean btn_EntendiCookieVisible() {
		return this.btn_EntendiCookie.isDisplayed();
	}
	
	public void btn_EntendiCookiesClick() {
		this.btn_EntendiCookie.click();
	}
	
	public void fecha_inicioClick() throws InterruptedException {
		//wait.until(ExpectedConditions.invisibilityOf(this.cuadro_ciudades));
		wait.until(ExpectedConditions.elementToBeClickable(this.fecha_inicio));
		this.fecha_inicio.click();
	}
	
	public void fecha_finClick() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(this.calendario));
		wait.until(ExpectedConditions.elementToBeClickable(this.fecha_fin));
		this.fecha_fin.click();
	}
	
	public void btn_aplicarClick() {
		this.btn_aplicar.click();
	}
	
	public void cierraVentafacebook() {
		this.btn_facebook.click();
	}
	
	public void habitacionesClick() {
		cierraVentafacebook();
		wait.until(ExpectedConditions.elementToBeClickable(this.habitaciones));
		this.habitaciones.click();
	}
	
	public void sumar_adulto() {
		wait.until(ExpectedConditions.visibilityOf(this.lista_sumar_adulto.get(2)));
		this.lista_sumar_adulto.get(2).click();
	}
	
	public void sumar_menor() {
		this.lista_sumar_menor.get(3).click();
	}
	
	public void seleccionedadMenor() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(this.selecciona_edad_menor));
		this.selecciona_edad_menor.click();
	}
	
	public void btn_aplicar_huesped() {
		this.btn_aplicar_huesped.click();
	}
	
	public despegarResultpage btn_buscar_hotel() {
		this.btn_buscar.click();
		return new despegarResultpage (this.driver);
	}
}
