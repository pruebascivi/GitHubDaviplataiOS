package daviplata.nacional.iOS.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import daviplata.nacional.iOS.definitions.Hooks;
import daviplata.nacional.iOS.utilidades.Utilidades;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.core.pages.PageObject;
import static org.junit.Assert.fail;

public class AumentoDeTopesPageObjects extends PageObject {

	Hooks Hooks;
	private AppiumDriver<MobileElement> driver = Hooks.getDriver();
	private WebDriverWait wait = Hooks.getDriverWait();
	public static String versionApp = "";
	Utilidades utilidad;
	Utilidades Utilidades;
	
	int contador = 0;

	private String btnTopes = "com.davivienda.daviplataapp.lab:id/imgAbrirtopes";
	//private String topeMensualDebito = "//*[@content-desc='Usar']";
	private String topeMensualDebito = "com.davivienda.daviplataapp.lab:id/txt_TopeMensualsec";
	private String topeMensualCredito = "com.davivienda.daviplataapp.lab:id/txt_saldoInicial";
	private String topeDisponibleCredito = "com.davivienda.daviplataapp.lab:id/txt_puedeRecibir";
	private String topeDisponibleDebito = "com.davivienda.daviplataapp.lab:id/txt_puedeUsar";
	private String acumuladoMensualDebito = "com.davivienda.daviplataapp.lab:id/txt_loQueHeUsado";
	private String acumuladoMensualCredito = "com.davivienda.daviplataapp.lab:id/txt_aunPuedeRecibir";
	private String btnCerrarApp = "com.davivienda.daviplataapp.lab:id/nav_bar_btn_close";
	private String btnAceptarCerrarApp = "//XCUIElementTypeButton[@name='Aceptar']";
	private String btnLogout = "//XCUIElementTypeButton[@name='Cerrar sesión']";
	private String appDaviplata = "//android.widget.TextView[@content-desc='Davi-lab']";
	private String btnUsar = "//*[contains(@text, 'Usar')]";
	private String btnRecibir = "//*[contains(@text, 'Recibir')]";
	private String btnVolver =   "//android.widget.ImageButton[@content-desc='Regresar']";
	private String msjPopUpTopes = "com.davivienda.daviplataapp.lab:id/TvPopupMessage";
	private String btnAceptar = "//[@name='aceptar']";
	String saldoDisponible = "";

	public void pulsarBotonTopes() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id(this.btnTopes)));
		driver.findElement(By.id(this.btnTopes)).click();
		Utilidades.esperaMiliseg(1000);
		System.out.println("Di click al boton de Topes");
	}
	
	public void pulsarBotonUsar() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnUsar)));
		driver.findElement(By.xpath(this.btnUsar)).click();
		Utilidades.esperaMiliseg(1000);
		System.out.println("Di click al boton Usar");
	}
	
	public void pulsarBotonRecibir() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnRecibir)));
		driver.findElement(By.xpath(this.btnRecibir)).click();
		Utilidades.esperaMiliseg(1000);
		System.out.println("Di click al boton Recibir");
	}
	
	public void pulsarBotonVolverHome() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnVolver)));
		driver.findElement(By.xpath(this.btnVolver)).click();
		Utilidades.esperaMiliseg(1000);
		System.out.println("Di click al boton Volver al Home");
	}
	
	public void validarPopUpTopes() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.msjPopUpTopes)));
			String mensajeTope = driver.findElement(By.xpath(this.msjPopUpTopes)).getText();
			System.out.println("Encontré popUp de topes");
			Utilidades.tomaEvidencia("Pop Up Advertencia de Topes");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptar)));
			driver.findElement(By.xpath(this.btnAceptar)).click();
			System.out.println("Cerré Pop Up de topes");
		}catch(Exception e) {
			if(!(contador==5)) {Utilidades.esperaMiliseg(2000);validarPopUpTopes();
			}else {System.out.println("No encontré popUp de topes debido a: " + e.getMessage());}
		}finally {contador = 0;}
		}
		
		
	
	
	public String ObtenerTopeCreditoInicial() {
		System.out.println("Ingreso al modulo Topes de credito");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.topeDisponibleCredito)));
		String topeDisponibleCredito = driver.findElement(By.xpath(this.topeDisponibleCredito)).getText();
		saldoDisponible = topeDisponibleCredito.replace("$", "").replace(".", "").replace(",", "");
		Utilidades.esperaMiliseg(1000);
		System.out.println("Tope disponible credito: " + saldoDisponible);
		return saldoDisponible;
	}
	
	public String ObtenerTopeDebitoInicial() {
		System.out.println("Ingreso al modulo Topes de debito");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.topeDisponibleDebito)));
		saldoDisponible = driver.findElement(By.xpath(this.topeDisponibleDebito)).getText();
		Utilidades.esperaMiliseg(1000);
		System.out.println("Tope disponible debito: " + saldoDisponible);
		return saldoDisponible;
	}
	
	public String ObtenerAcumuladoMensualDebito() {
		System.out.println("Ingreso al modulo Topes de debito");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.acumuladoMensualDebito)));
		saldoDisponible = driver.findElement(By.xpath(this.acumuladoMensualDebito)).getText();
		Utilidades.esperaMiliseg(1000);
		System.out.println("Acumulado mensual App Daviplata Debitos: " + saldoDisponible);
		return saldoDisponible;
	}
	
	public String ObtenerAcumuladoMensualCredito() {
		System.out.println("Ingreso al modulo Topes de debito");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.acumuladoMensualCredito)));
		saldoDisponible = driver.findElement(By.xpath(this.acumuladoMensualCredito)).getText();
		Utilidades.esperaMiliseg(1000);
		System.out.println("Acumulado mensual App Daviplata Debitos: " + saldoDisponible);
		return saldoDisponible;
	}
	
	public String ObtenerTopeMensualDebito() {
		System.out.println("Ingreso al modulo Topes de debito");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.topeMensualDebito)));
		saldoDisponible = driver.findElement(By.xpath(this.topeMensualDebito)).getText();
		Utilidades.esperaMiliseg(1000);
		System.out.println("El tope mensual para realizar debitos: " + saldoDisponible);
		return saldoDisponible;
	}
	
	public String ObtenerTopeMensualCredito() {
		System.out.println("Ingreso al modulo Topes de credito");
		pulsarBotonUsar();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.topeMensualDebito)));
		saldoDisponible = driver.findElement(By.xpath(this.topeMensualDebito)).getText();
		
		pulsarBotonRecibir();
		
		Utilidades.esperaMiliseg(1000);
		System.out.println("El tope mensual para realizar creditos: " + saldoDisponible);
		return saldoDisponible;
	}
	
	
	
	public void logoutApp() {
		try {
			contador++;
			utilidad.esperaMiliseg(3000);
			TouchAction touchAction=new TouchAction(driver);
			touchAction.tap(new PointOption().withCoordinates(380, 70)).perform();
			
			/*wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnLogout)));
			driver.findElement(By.xpath(this.btnLogout)).click();*/
			
			System.out.println("di click en btn logout");
			
			Utilidades.esperaMiliseg(1000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptarCerrarApp)));
			driver.findElement(By.xpath(this.btnAceptarCerrarApp)).click();
			Utilidades.esperaMiliseg(1000);
			System.out.println("Estoy saliendo de la App");
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(500);
				logoutApp();
			}else {
				fail("No se encontró botón cerrar sesion, ni boton aceptar cerrar sesion debido a: " + e.getMessage());
			}
		}finally {contador=0;}
		
	}
	
	
	public void ingresarApp() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.appDaviplata)));
		driver.findElement(By.xpath(this.appDaviplata)).click();
		Utilidades.esperaMiliseg(1000);
		System.out.println("Estoy ingresando a la App");
	}
	
}
