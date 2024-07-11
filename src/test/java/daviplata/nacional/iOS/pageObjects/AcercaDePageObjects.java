package daviplata.nacional.iOS.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import daviplata.nacional.iOS.definitions.Hooks;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import daviplata.nacional.iOS.utilidades.Utilidades;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import net.serenitybdd.core.pages.PageObject;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class AcercaDePageObjects extends PageObject {

	private AppiumDriver<MobileElement> driver = Hooks.getDriver();
	Utilidades Utilidades;
	BaseUtil base;
	private WebDriverWait wait = new WebDriverWait(BaseUtil.driver, 5);
	
	
	private String txtCondiciones = "I CONDICIONES DE USO DAVIPLATA";
	private String txtReglamento = "TabBarItemTitle";
	public static final String BOTON_ACERCA_DE = "//XCUIElementTypeStaticText[contains(@name,'Acerca de DaviPlata')] | //XCUIElementTypeStaticText[contains(@name,'Acerca de Daviplata')] | //XCUIElementTypeStaticText[contains(@name,'Acerca de')]";
	public static final String BOTON_NOTIFICACIONES = "//*[@name='Menu de conocimiento']";
	public static final String BOTON_CONTINUAR = "//XCUIElementTypeButton[@name='Continuar']";
	private String btnQueEsDP = "¿Qué es DaviPlata y para qué sirve?";
	private String btnDondeUsarDP = "¿Dónde usar su DaviPlata?";
	private String btnTwitter = "Twitter";
	private String btnTwitterSamsung = "com.sec.android.app.sbrowser:id/location_bar_edit_text";
	private String btnYoutube = "Youtube";
	private String txtEncabezado = "com.davivienda.daviplataapp.lab:id/nav_bar_title";
	private String imgQueHacer = "(//*[@type='XCUIElementTypeImage'])[#]";
	private String txtEncabezadoQueHacerConDP = "Qué hacer con DaviPlata";
	private String txtEncabezadoDondeUsarDP = "//*[@name='Dónde usar DaviPlata']";
	
	private String btnCajeros = "Meter Plata";
	private String txtContenCajeros = "Corresponsales";
	private String btnOficinas = "Sacar Plata";
	private String txtContenOficinas = "Cajeros";
	private String btnPuntosDP = "Comprar";
	private String txtContentPuntos = "//*[contains(@text,'Gasolina')]";
	private String btnMasComprar = "(//*[@type='XCUIElementTypeWebView'])[3]";

	private String txtContenidoTwitter = "TabBarItemTitle";
	private String btnCerrarContinuarConGoogle = "(//*[@class = 'android.view.View'])[82]";
	private String txtContenidoTwitterH = "//android.view.View[@content-desc=\"Twitter\"]/android.view.View";
	private String txtContenidoYoutube = "//*[contains(@value,'youtube')]";

	private String btnReglamento = "Reglamento";
	private String btnCondiciones = "Condiciones de uso";
	private String btnDescargar = "com.android.chrome:id/button_primary";
	private String btnDescargar2 = "android:id/button2";
	private String btnMenuChrome = "//android.widget.ImageView[@content-desc=\"Más opciones\"]";
	private String btnMenuChromeH = "com.android.chrome:id/menu_button";
	private String btnMenuChromeDescargar = "//*[contains(@text,'Descargar')]";
	private String btnMenuCromeDescargarHuawei = "//android.widget.TextView[@content-desc=\"Descargas\"]";
//	private String btnMenuChromeDescargarHuawei = "com.huawei.browser:id/menu_chrome";
	private String btnReglamentoPdf = "com.sec.android.app.sbrowser:id/button_primary";
	private String btnReglamentoPdfH = "com.android.chrome:id/title";
	/// hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.TextView[1]
	private String txtContenidoReglamento = "//android.widget.ImageView[@content-desc=\"Más opciones\"]";
	private String txtContenidoTyC = "com.google.android.apps.pdfviewer:id/action_find";

	private String btnAyudaEnLinea = "Ir a asesor virtual boton";

	private String txtContenidoAyudaEnLinea = "//XCUIElementTypeStaticText[@name='¿Necesita Ayuda?']";
	private String txtContenidoAyudaEnLineaH = "//android.view.View[2]/android.widget.Button";

	private String btnPermitir = "com.android.packageinstaller:id/permission_allow_button";
	private String btnPermitirSamsung = "com.android.permissioncontroller:id/permission_allow_button";
	private String btnPermitirSoloUsoConApp = "com.android.permissioncontroller:id/permission_allow_one_time_button";
	private String btnPermitirSoloUsoConAppSamsung = "com.android.permissioncontroller:id/permission_allow_foreground_only_button";
	private String btnIngresar = "com.davivienda.daviplataapp.lab:id/enterBtn";
	private String btnPermisoLeerUbicacion = "android:id/button1";
	public static final String LABEL_VERSION = "(//*[contains(@name, 'Versión')])[2]";
//	private String btnRegresar = "com.davivienda.daviplataapp.lab:id/nav_bar_btn_left";
	public static final String BOTON_REGRESAR = "Regresar";
	private String btnNecesitasAyuda = "Ir a asesor virtual boton";
    private String txtSaldoo = "com.davivienda.daviplataapp.lab:id/tv_saldo_value";
	private String btnAbrirCon = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.TextView[1]";

	private String btnContinuarintroduccionApp = "com.davivienda.daviplataapp.lab:id/enterBtn";
	
	int contador = 0;
	
	public void darClickQueEsDaviPlata() {
		wait.until(ExpectedConditions.elementToBeClickable(By.name(this.btnQueEsDP)));
		driver.findElement(By.name(this.btnQueEsDP)).click();
	}

	public void darClickDondeUsarDaviPlata() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.name(this.btnDondeUsarDP)));
			driver.findElement(By.name(this.btnDondeUsarDP)).click();
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(500);
				darClickDondeUsarDaviPlata();
				
			}else {
				fail("No se pudo encontrar opción 'Donde usar Daviplata', debido a: " + e.getMessage());
			}
		}finally{contador=0;}
		
	}

	public void darClickTwitter() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.name(this.btnTwitter)));
			driver.findElement(By.name(this.btnTwitter)).click();
		} catch (Exception e) {
			System.out.println("No aparecio barra de navegacion");
		}
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.id(this.btnTwitterSamsung)));
			driver.findElement(By.name(this.btnTwitterSamsung)).click();
		} catch (Exception e) {
			System.out.println("No aparecio barra de navegacion Samsung");
		}
	}

	public void darClickYoutube() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.name(this.btnYoutube)));
			driver.findElement(By.name(this.btnYoutube)).click();
		} catch(Exception e) {
			fail("no pude dar click a btn youtube");
		}
	}

	public void darClickReglamento() {
		wait.until(ExpectedConditions.elementToBeClickable(By.name(this.btnReglamento)));
		driver.findElement(By.name(this.btnReglamento)).click();
	}

	public void darClickCondiciones() {
		wait.until(ExpectedConditions.elementToBeClickable(By.name(this.btnCondiciones)));
		driver.findElement(By.name(this.btnCondiciones)).click();
	}

	public void pulsarBtnPermitirSoloUsoConApp() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.id(this.btnPermitirSoloUsoConApp)));
			driver.findElement(By.id(this.btnPermitirSoloUsoConApp)).click();
		} catch (Exception e) {
			System.out.println("No aparecio botón 'permitir solo con la app en uso'");
		}
	}

	public void pulsarBtnPermisoLeerUbicacion() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.id(this.btnPermisoLeerUbicacion)));
			driver.findElement(By.id(this.btnPermisoLeerUbicacion)).click();
		} catch (Exception e) {
			System.out.println("No aparecio botón 'Daviplata necesita permiso para leer la ubicación'");
		}
	}

	public void pulsarBtnPermisoAccederArchivos() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.id(this.btnPermisoLeerUbicacion)));
			driver.findElement(By.id(this.btnPermisoLeerUbicacion)).click();
		} catch (Exception e) {
			System.out.println("No aparecio botón 'DaviPlata necesita permiso para acceder a los archivos'");
		}
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.id(this.btnPermitirSamsung)));
			driver.findElement(By.id(this.btnPermitirSamsung)).click();
		} catch (Exception e) {
			System.out.println("No aparecio botón 'Daviplata necesita permiso para acceder a los archivos en Samsung'");
		}
	}

	public void validarOpcionParaQueSirve() {
		pulsarBtnPermitir();
		wait.until(ExpectedConditions.elementToBeClickable(By.name(this.txtEncabezadoQueHacerConDP)));
		MobileElement txtQueHacerConDP = driver.findElement(By.name(this.txtEncabezadoQueHacerConDP));
		System.out.println("txtQueHacer: " + txtQueHacerConDP.getAttribute("name"));
		String txtQueHacer = txtQueHacerConDP.getAttribute("name");
		assertEquals("Qué hacer con DaviPlata", txtQueHacer);
		for (int i = 1; i <= 3; i++) { // Aqui se valida que aparezcan las tres imagenes
			String direccionImagenes = this.imgQueHacer.replace("#", Integer.toString(i));
			System.out.println(direccionImagenes);
			MobileElement imgQueHacer = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(direccionImagenes)));
			assertTrue(imgQueHacer.isEnabled());
		}
	}

	public String obtenerTituloDeEncabezado() {
		wait.until(ExpectedConditions.elementToBeClickable(By.name(this.txtEncabezadoQueHacerConDP)));
		String txtQueHacerConDP = driver.findElement(By.name(this.txtEncabezadoQueHacerConDP)).getText();
		return txtQueHacerConDP;
	}

	public void validarOpcionDondeUsarDP() {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.txtEncabezadoDondeUsarDP)));
			MobileElement txt = driver.findElement(By.xpath(this.txtEncabezadoDondeUsarDP));
			assertEquals("Dónde usar DaviPlata", txt.getAttribute("name"));
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(500);
				validarOpcionDondeUsarDP();
				
			}else {
				fail("No se encontró texto 'Dónde usar Daviplata', debido a: " + e.getMessage());
			}
		}finally {contador=0;}
		
	}

	public void validarOpcionMeterPlata() {
		wait.until(ExpectedConditions.elementToBeClickable(By.name(this.btnCajeros)));
		driver.findElement(By.name(this.btnCajeros)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.name(this.txtContenCajeros)));
		boolean isEnabled = driver.findElement(By.name(this.txtContenCajeros)).isEnabled();
		assertTrue(isEnabled);
	}

	public void validarOpcionSacarPlata() {
		wait.until(ExpectedConditions.elementToBeClickable(By.name(this.btnOficinas)));
		driver.findElement(By.name(this.btnOficinas)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.name(this.txtContenOficinas)));
		boolean isEnabled = driver.findElement(By.name(this.txtContenOficinas)).isEnabled();
		assertTrue(isEnabled);
	}

	public void validarOpcionComprar() {
		wait.until(ExpectedConditions.elementToBeClickable(By.name(this.btnPuntosDP)));
		driver.findElement(By.name(this.btnPuntosDP)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnMasComprar)));
		boolean isEnabled = driver.findElement(By.xpath(this.btnMasComprar)).isEnabled();
		assertTrue(isEnabled);
	}

	
	
	
	public void validarOpcionTwitter() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.name(this.txtContenidoTwitter)));
			boolean isEnabled = driver.findElement(By.name(this.txtContenidoTwitter)).isEnabled();
			assertTrue(isEnabled);
			
		} catch (Exception e) {
			wait.until(ExpectedConditions.elementToBeClickable(By.name(this.txtContenidoTwitter)));
			boolean isEnabled = driver.findElement(By.name(this.txtContenidoTwitter)).isEnabled();
			assertTrue(isEnabled);
		}
	}

	public void validarOpcionYoutube() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtContenidoYoutube)));
		boolean isEnabled = driver.findElement(By.xpath(this.txtContenidoYoutube)).isEnabled();
		assertTrue(isEnabled);
	}
	
	public void validarReglamento() {
		wait.until(ExpectedConditions.elementToBeClickable(By.name(this.txtReglamento)));
		boolean isEnabled = driver.findElement(By.name(this.txtReglamento)).isEnabled();
		assertTrue(isEnabled);
	}
	
	public void validarCondiciones() {
		wait.until(ExpectedConditions.elementToBeClickable(By.name(this.txtReglamento)));
		boolean isEnabled = driver.findElement(By.name(this.txtReglamento)).isEnabled();
		assertTrue(isEnabled);
	}

	public void darClickEnDescargar() {
		try {

			try {
				wait.until(ExpectedConditions.elementToBeClickable(By.id(this.btnDescargar)));
				driver.findElement(By.id(this.btnDescargar)).click();
			} catch (Exception e) {
				wait.until(ExpectedConditions.elementToBeClickable(By.id(this.btnDescargar2)));
				driver.findElement(By.id(this.btnDescargar2)).click();
			}
		} catch (Exception e) {
			System.out.println("No salio boton descargar");
		}
	}

	public void darClickEnMenuChrome() {
		try {
			Utilidades.esperaMiliseg(2000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnMenuChrome)));
			driver.findElement(By.xpath(this.btnMenuChrome)).click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.elementToBeClickable(By.id(this.btnMenuChromeH)));
			driver.findElement(By.id(this.btnMenuChromeH)).click();

		}
	}

	public void darClickEnMenuChromeDescargar() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnMenuChromeDescargar)));
			driver.findElement(By.xpath(this.btnMenuChromeDescargar)).click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnMenuCromeDescargarHuawei)));
			driver.findElement(By.xpath(this.btnMenuCromeDescargarHuawei)).click();
		}
	}

	public void darClickEnReglamentoPdf() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.id(this.btnReglamentoPdf)));
			driver.findElement(By.id(this.btnReglamentoPdf)).click();
			Utilidades.esperaMiliseg(5000);
		} catch (Exception e) {
			wait.until(ExpectedConditions.elementToBeClickable(By.id(this.btnReglamentoPdfH)));
			driver.findElement(By.id(this.btnReglamentoPdfH)).click();
			Utilidades.esperaMiliseg(5000);
		}
	}

	public void darClickAbrirCon() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAbrirCon)));
			driver.findElement(By.xpath(this.btnAbrirCon)).click();
		} catch (Exception e) {
			System.out.println("No aparecio abrir con");
		}

	}

	public void darClickEnTyCPdf() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.id(this.btnReglamentoPdf)));
			driver.findElement(By.id(this.btnReglamentoPdf)).click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.elementToBeClickable(By.id(this.btnReglamentoPdfH)));
			driver.findElement(By.id(this.btnReglamentoPdfH)).click();
		}
	}

//	public void validarOpcionCondiciones() {
//		MobileElement txtContenidoTyC = (MobileElement) wait
//				.until(ExpectedConditions.elementToBeClickable(By.id(this.txtContenidoTyC)));
//		assertTrue(txtContenidoTyC.isEnabled());
//	}

	public void darClickEnOpcionAyudaEnLinea() {
		wait.until(ExpectedConditions.elementToBeClickable(By.name(this.btnAyudaEnLinea)));
		driver.findElement(By.name(this.btnAyudaEnLinea)).click();
	}

	public void validarFormularioDeAyudaEnLinea() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtContenidoAyudaEnLinea)));
			boolean isEnabled = driver.findElement(By.xpath(this.txtContenidoAyudaEnLinea)).isEnabled();
			assertTrue(isEnabled);
		} catch (Exception e) {
			if(!(contador==10)) {
				Utilidades.esperaMiliseg(500);
				validarFormularioDeAyudaEnLinea();
			}else {
				fail("No se pudo validar el formulario, debido a : " + e.getMessage());
			}
			
		}finally {contador=0;}
	}

	public void pulsarBtnPermitir() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.id(this.btnPermitir)));
			driver.findElement(By.id(this.btnPermitir)).click();
		} catch (Exception e) {
			System.out.println("No aparecio botón permitir");
		}
	}

	public void pulsarBtnIngresar() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.id(this.btnIngresar)));
			driver.findElement(By.id(this.btnIngresar)).click();
		} catch (Exception e) {
			System.out.println("No aparecio botón ingresar");
		}
	}

	public void btn_ContinuarintroduccionApp() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.id(this.btnContinuarintroduccionApp)));
			driver.findElement(By.id(this.btnContinuarintroduccionApp)).click();
		} catch (Exception e) {

		}

	}

	public String traerSaldo() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id(this.txtSaldoo)));
		String saldo = driver.findElement(By.id(this.txtSaldoo)).getText();
		return saldo;
	}

	public void pulsarBtnRegresar() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.name(this.BOTON_REGRESAR)));
			base.driver.findElement(By.name(this.BOTON_REGRESAR)).click();
		}catch (Exception e) {
			if(!(contador==5)) {Utilidades.esperaMiliseg(500);pulsarBtnRegresar();}
			else {fail("No puse puedo dar clic en boton regresar "+this.BOTON_REGRESAR+" debido a: "+e.getMessage());}
		}finally {contador=0;}
	}

	
	public void esperarVisibilidadDondeUsarDaviplata() {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.txtEncabezadoDondeUsarDP)));
		}catch(Exception e) {
			if(!(contador==20)) {
				Utilidades.esperaMiliseg(500);
				esperarVisibilidadDondeUsarDaviplata();
			}else {
				fail("No se encontró texto 'Donde usar DaviPlata' debido a: " + e.getMessage());
			}
			
		}finally {contador=0;}
		
	}
	
	public void esperarVisibilidadFormularioDeAyudaEnLinea() {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.txtContenidoAyudaEnLinea)));
		} catch (Exception e) {
			if(!(contador==10)) {
				Utilidades.esperaMiliseg(500);
				esperarVisibilidadFormularioDeAyudaEnLinea();
			}else {
				fail("No se pudo visualizar el formulario, debido a : " + e.getMessage());
			}
			
		}finally {contador=0;}
	}
	
	public void esperarVisibilidadElemento() {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(this.btnNecesitasAyuda)));
		} catch (Exception e) {
			if(!(contador==30)) {
				Utilidades.esperaMiliseg(500);
				esperarVisibilidadElemento();
			}else {
				fail("No se pudo visualizar el formulario, debido a : " + e.getMessage());
			}
		}finally {contador=0;}
	}
}
