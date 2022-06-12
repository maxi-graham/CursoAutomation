package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.driver.DriverFactory;
import com.selenium.pages.despegarAlojamientopage;
import com.selenium.pages.despegarHomepage;
import com.selenium.pages.despegarResultpage;

public class TestDespegar extends DriverFactory {
  @Test(description = "Validar Despegar")
  public void PruebaDespegar() throws Exception {
	  	  
	  WebDriver driver = null;
	 
	  driver =  LevantarBrowser("CHROME", "https://www.despegar.com.ar/");
	  despegarHomepage objHomepage = new despegarHomepage(driver);
	  Assert.assertTrue(objHomepage.log_desktopVisible(), "El logo no esta disponible");
	  despegarAlojamientopage objAlojamiento= new despegarAlojamientopage(driver);
	  objAlojamiento = objHomepage.btn_AlojamientoClick();
	  Assert.assertTrue(objHomepage.btn_AlojamientoVisible(),"NO HAY BOTON ALOJAMIENTO");
	  objAlojamiento.text_Ciudadclick();
	  objAlojamiento.text_Ciudad("Cordoba,");
	  Assert.assertTrue(objAlojamiento.btn_EntendiCookieVisible(), "El Boton de Entendi cookies nos esta visible");
	  objAlojamiento.btn_EntendiCookiesClick();
	  objAlojamiento.calendarioClick();
	  objAlojamiento.fecha_inicioClick();
	  objAlojamiento.fecha_finClick();
	  objAlojamiento.btn_aplicarClick();
	  objAlojamiento.habitacionesClick();
	  objAlojamiento.sumar_adulto();
	  objAlojamiento.sumar_menor();
	  objAlojamiento.seleccionedadMenor();
	  objAlojamiento.btn_aplicar_huesped();
	  despegarResultpage objResult = new despegarResultpage(driver);
	  objResult = objAlojamiento.btn_buscar_hotel();
	  objResult.ventana_emergente();
	  Assert.assertTrue(objResult.hotel_encontrado_visible(), "EL HOTEL NO SE ENCUENTRA DISPONIBLE");
	  
	  DriverFactory.cerrarBrowser(driver);
	  
  }
}
