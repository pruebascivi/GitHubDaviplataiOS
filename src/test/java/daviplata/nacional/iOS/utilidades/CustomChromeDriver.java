package daviplata.nacional.iOS.utilidades;

import org.openqa.selenium.chrome.ChromeDriver;

public class CustomChromeDriver {
	
	public static void iniciarChromeDriver() {
		System.setProperty("webdriver.chrome.driver", Credenciales.parametrosGenerales().getProperty("ubicacion.driverchrome"));
		BaseUtil.chromeDriver = new ChromeDriver();
		BaseUtil.chromeDriver.manage().window().maximize();
	}
	
	public void iniciarChromeDriverLatinia() {
		System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/Mac/chromedriver.exe");
		BaseUtil.chromeDriverLatinia = new ChromeDriver();
		BaseUtil.chromeDriverLatinia.manage().window().maximize();
	}
	public void iniciarChromeDriverNLatinia() {
		System.setProperty("webdriver.chrome.driver", Credenciales.parametrosGenerales().getProperty("ubicacion.driverchrome"));
		BaseUtil.chromeDriverNLatinia = new ChromeDriver();
		BaseUtil.chromeDriverNLatinia.manage().window().maximize();
	}
	
	public static void cerrarChromeDriver() {
		BaseUtil.chromeDriver.quit();
	}
	
	public void cerrarChromeDriverLatinia() {
		BaseUtil.chromeDriverLatinia.close();
		BaseUtil.chromeDriverLatinia.quit();
	}
	public void cerrarChromeDriverNLatinia() {
		BaseUtil.chromeDriverNLatinia.close();
		BaseUtil.chromeDriverNLatinia.quit();
	}

}
