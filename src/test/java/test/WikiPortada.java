package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.selenium.driver.DriverFactory;
import com.selenium.pages.pageHome;
import com.selenium.pages.pageResult;

//import org.openqa.selenium.Keys;

@Test(groups= {"grupo1wiki"},description = "ValidarPortadaWikipedia")
public class WikiPortada extends DriverFactory {
	WebDriver driver = null;
	
  public void ValidarBusquedaWikipediaPortada() throws Exception {
	  
	  driver = DriverFactory.LevantarBrowser("CHROME", "https://es.wikipedia.org/wiki/Wikipedia:Portada");
	  pageHome objPageHome = new pageHome(driver);
	  Assert.assertTrue(objPageHome.searchInputEsVisible(), "El input no esta visible");
	  
	  pageResult objPageResult = objPageHome.searchtext("Selenium");
	  Assert.assertTrue(objPageResult.tituloEsVisible(), "El titulo no es visible");
	  
	  System.out.println("---------- Test de Wiki Completado-------------------");
	  System.out.println();
	  Thread.sleep(1000);
	  //driver.close(); 
  }
  
  @AfterMethod(alwaysRun = true)
  public void cerrar() {
 	  driver.close();
  }
}