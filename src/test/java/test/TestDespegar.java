package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.driver.DriverFactory;
import com.selenium.pages.despegarAlojamientopage;
import com.selenium.pages.despegarHomepage;
import com.selenium.pages.despegarResultpage;

public class TestDespegar extends DriverFactory {
  
  WebDriver driver = null;
  despegarHomepage objHomepage= null;
  
  @BeforeMethod (alwaysRun = true)
  public void abrir(ITestContext context) {
	  String url = "https://www.despegar.com.ar/";
	  String navegadorTestSuite = context.getCurrentXmlTest().getParameter("Navegador");
	  //toma por defecto CHROME, si la variable es = a null
	  String navegador = navegadorTestSuite != null ? navegadorTestSuite : "CHROME";
	  //driver =  LevantarBrowser("CHROME", "https://www.despegar.com.ar/");
	  driver = LevantarBrowser (navegador,url);
	  
  }
  
  @DataProvider(name="ciudades")
  public Object[][] providerCiudades(){
	  return new Object[][] {{"Salta"}};
  }//, {"Rio Negro"}, {"Bariloche"}
  
  @Test(groups= {"grupo1"},dataProvider= "ciudades", description = "Validar_Despegar")
  public void PruebaDespegar(String searchText) throws Exception {	  
	  
	  despegarHomepage objHomepage = new despegarHomepage(driver);
	  Assert.assertTrue(objHomepage.log_desktopVisible(), "El logo no esta disponible");
	  despegarAlojamientopage objAlojamiento= new despegarAlojamientopage(driver);
	  objAlojamiento = objHomepage.btn_AlojamientoClick();
	  Assert.assertTrue(objHomepage.btn_AlojamientoVisible(),"NO HAY BOTON ALOJAMIENTO");
	  objAlojamiento.text_Ciudadclick();
	  objAlojamiento.text_Ciudad(searchText);
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
	  Assert.assertTrue(objResult.hotel_encontrado_visible(), "NO HAY RESULTADOS DISPONIBLES");
	  System.out.println("---------- Test De Despegar Completado-------------------");
	  System.out.println();
  }
  
  
  @AfterMethod(alwaysRun = true)
  public void cerrar() {
 	  DriverFactory.cerrarBrowser(driver);
  }
}
