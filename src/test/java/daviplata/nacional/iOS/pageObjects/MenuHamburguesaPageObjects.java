package daviplata.nacional.iOS.pageObjects;

import static org.junit.Assert.fail;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import daviplata.nacional.iOS.definitions.Hooks;
import daviplata.nacional.iOS.utilidades.Utilidades;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import net.serenitybdd.core.pages.PageObject;

public class MenuHamburguesaPageObjects extends PageObject {
	
	private AppiumDriver<MobileElement> driver = Hooks.getDriver();
	private WebDriverWait wait = Hooks.getDriverWait();
	Utilidades utilidad;

	private int contador = 0;
	private String btnMenuHamburguesa = "//XCUIElementTypeNavigationBar[@name='Menu']/XCUIElementTypeButton";
	private String btnAbrirProductos = "com.davivienda.daviplataapp.lab:id/ivOpenProducts";
	private String btnUsarPlata = "com.davivienda.daviplataapp.lab:id/ivUseCash";
	private String btnMasServicios = "//*[@value='Más servicios']";
	private String btnNoMeInteresa = "com.davivienda.daviplataapp.lab:id/btn_cmp_no_interes";
	
	// Funciones mas servicios
	private String btnCambiarClaveCorreo ="(//XCUIElementTypeButton[@name='Button'])[3]";
	private String btnActivarCasita = "//*[@text='Activar la Casita Roja']";
	private String btnVerMovimientos = "(//XCUIElementTypeButton[@name='Button'])[2] | //XCUIElementTypeStaticText[@name='lbl-value-0']";
	
	private String btnNanoCredito = "//*[@text='Nanocrédito']";
	private String btnTarjetaVirtual="//*[@text='Tarjeta virtual']";
	private String btnQRDaviplata="//*[@text='QR DaviPlata']";
	public static final String BOTON_FINALIZAR_MOVIMIENTOS = "//XCUIElementTypeStaticText[@name='Finalizar']";
	
	
	public void darClickMenuHamburguesa() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnMenuHamburguesa)));
			driver.findElement(By.xpath(this.btnMenuHamburguesa)).click();
		
		}catch(Exception e) {
			if(!(contador==10)) {
				Utilidades.esperaMiliseg(500);
				darClickMenuHamburguesa();
			}else {
				fail("No se encontro botón menu hamburguesa del perfil persona, debido a: " +e.getMessage());
			}
		}finally {contador=0;}
		
	}
	
	public void clicBtnNoMeInteresa() {
		try {
			driver.findElement(By.xpath(this.btnNoMeInteresa)).click();
		} catch (Exception e) {
			System.out.println("No se encontró 'No me interesa' en cambio de clave, debido a: " + e.getMessage());	
		}
	}

	// Sub Botones Principales
	public void darClickAbrirProductos() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAbrirProductos)));
		driver.findElement(By.xpath(this.btnAbrirProductos)).click();
	}

	public void darClickUsarPlata() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnUsarPlata)));
		driver.findElement(By.xpath(this.btnUsarPlata)).click();
	}

	// Funciones boton "Mas Servicios"
	

	public void darClickActivarCasitaRoja() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnActivarCasita)));
		driver.findElement(By.xpath(this.btnActivarCasita)).click();
	}
	
	public void darClickVerMovimientos() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnVerMovimientos)));
			driver.findElement(By.xpath(this.btnVerMovimientos)).click();
		}catch(Exception e) {
			if(!(contador==0)) {
				utilidad.esperaMiliseg(2000);
				darClickVerMovimientos();
			}else {
				fail("No se encontró opcion 'Ver Movimientos' debido a: " + e.getMessage());
			}
		}finally {contador=0;}
		
	}
	
	//Funciones boton Abrir productos
	
	public void darClickBtnNanoCredito() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnNanoCredito)));
		driver.findElement(By.xpath(this.btnNanoCredito)).click();
	}
	
	// Funciones para Usar Plata
	
	public void pulsarBtnQRDaviplata() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnQRDaviplata)));
		driver.findElement(By.xpath(this.btnQRDaviplata)).click();
		utilidad.tomaEvidencia("Selecciono opción QR");
	}
}
