package daviplata.nacional.iOS.pageObjects;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import daviplata.nacional.iOS.definitions.Hooks;
import daviplata.nacional.iOS.utilidades.Utilidades;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import net.serenitybdd.core.pages.PageObject;

public class NotificacionesPageObjects extends PageObject {
	
	private AppiumDriver<MobileElement> driver= Hooks.getDriver();
	private WebDriverWait wait =Hooks.getDriverWait();
	Utilidades utilidad;
	Utilidades Utilidades;
	
	private String btnNotificaciones="///XCUIElementTypeButton[@name=\"Novedades\"]";
	private String btnMensajes="//XCUIElementTypeButton[@name=\"Transacciones\"]";
	private String btnComprasTienda = "//XCUIElementTypeButton[@name=\"Compras en Tienda Virtual\"]";
	private String chkNum1="(//XCUIElementTypeButton[@name=\"Casilla de selección no marcada\"])[1]";
	private String btnEliminar="//XCUIElementTypeButton[@name=\"Eliminar\"]";
	private String lblMensajeEliminado="//*[contains(@name,'Mensaje Eliminado')]";
	private String btnAceptar = "//*[contains(@name,'Aceptar')]"; 
	private String validarLeerBono = "//XCUIElementTypeTable/XCUIElementTypeCell[1]";
	private String validarLeerBono2 = "//XCUIElementTypeTextView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther";
	
	public void clicBtnNotificaciones() {
		MobileElement btnNotificaciones = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnNotificaciones)));
		Utilidades.tomaEvidencia("Clic en notificaciones");
		btnNotificaciones.click();
	}
	
	
	public void clicBtnMensajes() {
		MobileElement btnMensajes = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnMensajes)));
		Utilidades.tomaEvidencia("Clic en mensajes");
		btnMensajes.click();
	}
	
	public void clicBtnComprasTienda() {
		MobileElement btnMensajes = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnComprasTienda)));
		Utilidades.tomaEvidencia("Clic en el boton Compras en tienda virtual");
		btnMensajes.click();
	}
	
	public void clicChkNum1() {
		MobileElement chkNum1 = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.chkNum1)));
		Utilidades.tomaEvidencia("Clic en primer check");
		chkNum1.click();
	}
	
	public void clicBtnEliminar() {
		MobileElement btnEliminar = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnEliminar)));
		Utilidades.tomaEvidencia("Clic en eliminar mensaje");
		btnEliminar.click();
	}
	
	public void clicBtnAceptar() {
		MobileElement btnEliminar = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptar)));
		Utilidades.tomaEvidencia("Clic en Aceptar");
		btnEliminar.click();
	}
	
	public void validoBtnNotificaciones() {
		Utilidades.esperaMiliseg(5000);
		Utilidades.tomaEvidencia("Valido las notificaciones");
	}
	
	public void validoBtnMensajes() {
		Utilidades.esperaMiliseg(5000);
		Utilidades.tomaEvidencia("Valido los mensajes");
	}
	
	public void validoBtnCompraTienda() {
		
		try {
			Utilidades.esperaMiliseg(5000);
			Utilidades.tomaEvidencia("Valido los mensajes de compras en tienda virtual");
			MobileElement btnLeerBono = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.validarLeerBono)));
			btnLeerBono.click();
			MobileElement btnLeerBono1 = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.validarLeerBono2)));
			System.out.println(btnLeerBono1.getText());
			Utilidades.esperaMiliseg(5000);
			Utilidades.tomaEvidencia("Valido el bono");
		} catch (Exception e) {
			String compra = driver.findElement(By.xpath(this.validarLeerBono)).getText();
			if(compra.contains("Novedades")) {
				assertTrue(true);
				Utilidades.tomaEvidencia("Valido los mensajes de compras en tienda virtual");
			}else {
				assertTrue(false);
			}
		}
		//Utilidades.tomaEvidencia("Valido los mensajes de compras en tienda virtual");
	}
	
	public void validoMensajeEliminado() {
		MobileElement lblMensajeEliminado = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.lblMensajeEliminado)));
		Utilidades.tomaEvidencia("Valido label de mensaje eliminado");
		assertTrue(lblMensajeEliminado.isEnabled());
	}
}
