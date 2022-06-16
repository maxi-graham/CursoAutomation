package test;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.driver.DriverFactory;
import com.selenium.pages.despegarHomepage;

public class testLista extends DriverFactory {
	
	WebDriver driver = null;
	  despegarHomepage objHomepage= null;
	  
	  @BeforeMethod (alwaysRun = true)
	  public void abrir(ITestContext context) {
		  String url = "https://www.despegar.com.ar/";
		  String navegadorTestSuite = context.getCurrentXmlTest().getParameter("Navegador");
		  String navegador = navegadorTestSuite != null ? navegadorTestSuite : "CHROME";
		  //driver =  LevantarBrowser("CHROME", "https://www.despegar.com.ar/");
		  driver = LevantarBrowser (navegador,url);
		  
	  }
	  
	  @Test(description = "Validar_Lista_Despegar")
	  public void validarListaHome() {
		  despegarHomepage objhome = new despegarHomepage (driver);
		  objhome.validarListaMenu();
	  }
	  
	  @AfterMethod(alwaysRun = true)
	  public void cerrar() {
		  DriverFactory.cerrarBrowser(driver);
	  }

}
