package daviplata.nacional.iOS.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import daviplata.nacional.iOS.definitions.Hooks;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import daviplata.nacional.iOS.utilidades.Utilidades;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.core.pages.PageObject;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;
import static org.hamcrest.CoreMatchers.*;

public class ComprobanteQrPageObjects extends PageObject {
	
	Utilidades utilidad;
	private AppiumDriver<MobileElement> driver = Hooks.getDriver();
	BaseUtil base;
	private WebDriverWait wait = new WebDriverWait(BaseUtil.driver, 5);
	public int contador = 0;
	
	private String botonQr = "//XCUIElementTypeButton[@name='Codigo QR'] | //XCUIElementTypeButton[contains(@label, 'QR')]";
	private String checkRecordarDatos = "//*[@name='Recordar datos']";
	private String botonCambiar = "Cambiar";
	private String btnComprar = "//*[@name='Comprar']";
	private String btnVender = "//*[@name='Vender']";
	private String btnConfirmarComprobante = "//*[@name='Confirmar Comprobante']";
	public static final String BOTON_QR_PUBLIC_HOME = "//XCUIElementTypeButton[@name='Codigo QR'] | //XCUIElementTypeButton[contains(@label, 'QR')] | //XCUIElementTypeOther[@name='btn-custom-1'] | //XCUIElementTypeOther[@label= 'Leer código QR botón'] | //XCUIElementTypeOther[@label= 'Código qr botón']";
	public static final String TEXTO_CUANTO_DEBO = "//XCUIElementTypeStaticText[contains(@name, 'Para comprar, ubique el código QR')]";
			
	public void validarBotonQr() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.botonQr)));
			assertThat(element.isDisplayed(), is(true));
		}catch(Exception e) {
			if(!(contador==5)) {
				utilidad.esperaMiliseg(500);
				validarBotonQr();
			}else {
				fail("No se encontró botón QR del home de logeo Daviplata, debido a: " + e.getMessage());
			}
		}finally {contador=0;}
	}
	
	public void clicCheckDatosRecordados() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.checkRecordarDatos)));
			element.click();
		}catch(Exception e) {
			if(!(contador==5)) {
				utilidad.esperaMiliseg(500);
				clicCheckDatosRecordados();
			}else {
				fail("No se encontró botón 'Recordar datos' en logeo Daviplata, debido a: " + e.getMessage());
			}
		}finally {contador=0;}
	}
	
	public void clicBotonCambiarLogeo() {
		try {
			contador++;
			utilidad.esperaMiliseg(4000);
			TouchAction touchAction=new TouchAction(driver);
			touchAction.tap(new PointOption().withCoordinates(324, 269)).perform();
		}catch(Exception e) {
			if(!(contador==5)) {
				utilidad.esperaMiliseg(500);
				clicBotonCambiarLogeo();
			}else {
				fail("No se encontró botón 'Cambiar' en logeo de datos Daviplata, debido a: " + e.getMessage());
			}
		}finally {contador=0;}
	}
	
	public void validarOpcionComprar() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnComprar)));
			assertThat(element.isDisplayed(), is(true));
		}catch(Exception e) {
			if(!(contador==5)) {
				utilidad.esperaMiliseg(500);
				validarOpcionComprar();
			}else {
				fail("No se encontró botón 'Comprar' en las opciones QR, debido a: " + e.getMessage());
			}
		}finally {contador=0;}
	}
	
	public void validarOpcionVender() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnVender)));
			assertThat(element.isDisplayed(), is(true));
		}catch(Exception e) {
			if(!(contador==5)) {
				utilidad.esperaMiliseg(500);
				validarOpcionVender();
			}else {
				fail("No se encontró botón 'Vender' en las opciones QR, debido a: " + e.getMessage());
			}
		}finally {contador=0;}
	}
	
	public void validarOpcionConfirmarComprobante() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnConfirmarComprobante)));
			assertThat(element.isDisplayed(), is(true));
		}catch(Exception e) {
			if(!(contador==5)) {
				utilidad.esperaMiliseg(500);
				validarOpcionConfirmarComprobante();
			}else {
				fail("No se encontró botón 'Confirmar Comprobante' en las opciones QR, debido a: " + e.getMessage());
			}
		}finally {contador=0;}
	}
	
	public void clicBotonQr() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.botonQr)));
			element.click();
		}catch(Exception e) {
			if(!(contador==5)) {
				utilidad.esperaMiliseg(500);
				clicBotonQr();
			}else {
				fail("No se encontró botón 'QR' del home de logeo Daviplata, debido a: " + e.getMessage());
			}
		}finally {contador=0;}
	}
}
