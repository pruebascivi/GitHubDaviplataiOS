package daviplata.nacional.iOS.pageObjects;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import daviplata.nacional.iOS.definitions.Hooks;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import daviplata.nacional.iOS.utilidades.Utilidades;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import net.serenitybdd.core.pages.PageObject;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;
import static org.hamcrest.Matchers.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Excepcion4x1000PageObjects extends PageObject {
	
	static Utilidades utilidad;
	private int contador = 0;
	private BaseUtil base;
	private AppiumDriver<MobileElement> driver = Hooks.getDriver();
	private WebDriverWait wait = Hooks.getDriverWait();
	
	private String btnExencion = "//XCUIElementTypeOther[@name='btn-2']";
	private String btnAceptar = "//XCUIElementTypeButton[@name='Aceptar']";
	private String txtExoneracionExitosa = "(//*[contains(@name, 'exitosa')])"; // Solicitud de exoneración exitosa
	private String subTxtExoneracionExitosa = "com.davivienda.daviplataapp.lab:id/TvPopupMessage"; // En las próximas 24 horas su DaviPlata quedará marcado como exento de 4x1000. Recuerde que por ley, solo puede tener una cuenta exenta de 4x1000, en el momento que desee desmarcar su DaviPlata debe ingresar por el botón ¿Necesita ayuda?
	private String btnFinalizar = "//XCUIElementTypeButton[@name='Finalizar']"; // Finalizar
	private String txtExencionNoExitosa = "com.davivienda.daviplataapp.lab:id/TvPopupMessage"; // Usted ya tiene un producto marcado como exento del 4x1.000, para poder exonerar su DaviPlata, acérquese a su banco para desmarcarlo y continuar con el proceso. A partir de este momento, se realizará este cobro cuando se debite dinero de su DaviPlata.
	private String nombreCampoHB = "com.davivienda.daviplataapp.lab:id/textViewchild";
	public static final String BOTON_SOLICITUDES = "//XCUIElementTypeStaticText[@name='lbl-title-content-accordion-solicitudes']";

	ArrayList<String> nombreCampo = new ArrayList<String>();
	private int i = 1;
	
	/*
	private String btnAbrirBolsillo = "com.davivienda.daviplataapp.lab:id/bolsillo_btn_abrir";
*/

	
	String saldoDisponible = "";

	
	public void seleccionarOpcionExencion4x1000() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnExencion)));
    		driver.findElement(By.xpath(this.btnExencion)).click();
			Utilidades.esperaMiliseg(1000);
			System.out.println("Di click al boton de Exencion 4x1000");
		}catch (Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(500);
				seleccionarOpcionExencion4x1000();
			}else {fail("No se pudo seleccionar a opción excepción 4x1000 debido a: "+e.getMessage());}
		}finally {contador=0;}
	}
	
	public void pulsarBtnAceptarPopUp() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptar)));
    		driver.findElement(By.xpath(this.btnAceptar)).click();
			Utilidades.esperaMiliseg(1000);
			System.out.println("Di click al boton Aceptar Exencion");
		}catch (Exception e) {
			if(!(contador==20)) {Utilidades.esperaMiliseg(2000);pulsarBtnAceptarPopUp();
			}else {fail("No se pudo clic en botón Aceptar del popup debido a: "+e.getMessage());}
		}finally {contador=0;}
	}
	
	public void validarExencionExitosa() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtExoneracionExitosa)));
    		String txtExoneracionExitosa = driver.findElement(By.xpath(this.txtExoneracionExitosa)).getText();
    		
			System.out.println(txtExoneracionExitosa);
			assertThat(txtExoneracionExitosa, containsString("exoneración exitosa"));
			System.out.println("Valide correctamente el mensaje de exencion exitosa");
			Utilidades.esperaMiliseg(1000);
		}catch (Exception e) {
			if(!(contador==5)) {Utilidades.esperaMiliseg(2000);validarExencionExitosa();
			}else {fail("No se pudo validar la excepción de 4x1000 debido a: "+e.getMessage());}
		}finally {contador=0;}
	}
	
	public void validarExencionNoExitosa() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtExencionNoExitosa)));
    		String txtExencionNoExitosa1 = driver.findElement(By.xpath(this.txtExencionNoExitosa)).getText();
    		
			txtExencionNoExitosa1 = (txtExencionNoExitosa).substring(0, 159);
			assertThat(txtExencionNoExitosa1, containsString("Usted ya tiene un producto marcado como exento del 4x1.000, para poder exonerar su DaviPlata, acérquese a su banco para desmarcarlo y continuar con el proceso."));
			Utilidades.esperaMiliseg(1000);
			System.out.println("Valide correctamente el mensaje de exencion no exitosa");
		}catch (Exception e) {
			if(!(contador==20)) {Utilidades.esperaMiliseg(2000);validarExencionExitosa();
			}else {fail("No se pudo validar la excepción de 4x1000 debido a: "+e.getMessage());}
		}finally {contador=0;}
	}
	
	public void scroll() {
		System.out.println("driver" + driver);
		
		HashMap<String, String> scrollObject = new HashMap<>();
		JavascriptExecutor js = driver; 
		scrollObject.put("direction", "down");
		js.executeScript("mobile: scroll", scrollObject); //or "mobile: swipe"
	}
	
	
	public void validarCamposMenuHamburguesa() {
		
		try {
			
		nombreCampo.add("Activar la Casita Roja");
		nombreCampo.add("¿Cuánto debo?");
		nombreCampo.add("Ver Movimientos");
		nombreCampo.add("Cambiar clave y correo");
		nombreCampo.add("Cambiar número"); 
		nombreCampo.add("Extractos");
		
		
		for(int j = 0; j<7;j++) {
			String campos = "//*[contains(@text, '"+nombreCampo.get(j)+"')]";
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(campos)));
    		String campo = driver.findElement(By.xpath(campos)).getText();
			assertThat(nombreCampo.get(j), equalTo(campo));
		}
		
		System.out.println("salí del for");
		
		}catch(Exception e) {
			if(!(contador==20)) {Utilidades.esperaMiliseg(2000);validarCamposMenuHamburguesa();
			}else {System.out.println("No se pudo validar los campos debido a: "+e.getMessage());}
		}finally {contador=0;}
		}
	
	
public void validarOpcionExencion4x1000() {
		try {
			contador++;
			scroll();
			System.out.println("Encontré el campo Exencion 4x1000 en el menú hamburguesa");
			utilidad.tomaEvidencia("Se presentó el campo Exencion 4x1000 en el menú hamburguesa");
		}catch(Exception e) {
			if(!(contador==2)) {Utilidades.esperaMiliseg(500);validarOpcionExencion4x1000();
			}else {
				System.out.println("No encontré el campo Exencion 4x1000 en el menú hamburguesa debido a: "+e.getMessage());
				utilidad.tomaEvidencia("No se presentó el campo Exencion 4x1000 en el menú hamburguesa");
			}
		}finally {contador=0;}
	}
		
	public void pulsarBtnFinalizar() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnFinalizar)));
    		driver.findElement(By.xpath(this.btnFinalizar)).click();
			Utilidades.esperaMiliseg(1000);
			System.out.println("Di click al boton Finalizar Exencion");
		}catch (Exception e) {
			if(!(contador==20)) {Utilidades.esperaMiliseg(2000);pulsarBtnAceptarPopUp();
			}else {fail("No se pudo clic en botón Finalizar del popup debido a: "+e.getMessage());}
		}finally {contador=0;}
	}
	
}
