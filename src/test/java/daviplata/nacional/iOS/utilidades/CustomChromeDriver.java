package daviplata.nacional.iOS.utilidades;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomChromeDriver {
	
	private BaseUtil base;
	


	public static void iniciarChromeDriver() {
		System.setProperty("webdriver.chrome.driver", Credenciales.parametrosGenerales().getProperty("ubicacion.driverchrome"));
		BaseUtil.chromeDriver = new ChromeDriver();
//		base.chromeDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		BaseUtil.chromeDriver.manage().window().maximize();

		
//		chromeDriver.get(url);
	}
	
	public void iniciarChromeDriverLatinia() {
		System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/Mac/chromedriver.exe");
		base.chromeDriverLatinia = new ChromeDriver();
		//base.chromeDriver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
		base.chromeDriverLatinia.manage().window().maximize();
	}
	public void iniciarChromeDriverNLatinia() {
		System.setProperty("webdriver.chrome.driver", Credenciales.parametrosGenerales().getProperty("ubicacion.driverchrome"));
		base.chromeDriverNLatinia = new ChromeDriver();
		//base.chromeDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		base.chromeDriverNLatinia.manage().window().maximize();
	}
	
	
	public static void cerrarChromeDriver() {
		//base.chromeDriver.close();
		//base.chromeDriver.quit();
		BaseUtil.chromeDriver.quit();
	}
	
	public void cerrarChromeDriverLatinia() {
		base.chromeDriverLatinia.close();
		base.chromeDriverLatinia.quit();
	}
	public void cerrarChromeDriverNLatinia() {
		base.chromeDriverNLatinia.close();
		base.chromeDriverNLatinia.quit();
	}

}
