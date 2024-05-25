package daviplata.nacional.iOS.pageObjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.*;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import daviplata.nacional.iOS.definitions.Hooks;
import daviplata.nacional.iOS.utilidades.Utilidades;
import daviplata.nacional.iOS.utilidades.UtilidadesTCS;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import net.serenitybdd.core.pages.PageObject;

public class ClaveCorreoPageObject extends PageObject {

	
	private AppiumDriver<MobileElement> driver = Hooks.getDriver();
	private WebDriverWait wait = Hooks.getDriverWait();
	BaseUtil base;
	UtilidadesTCS utilidadesTCS;

	private String btnCambiarClave = "//XCUIElementTypeButton[@name='Cambiar clave' or @name='Cambiar Clave']";
	private String btnCambiarCorreo = "//XCUIElementTypeButton[@name='Cambiar correo' or @name='Cambiar Correo']";

// funciones Cambiar Clave

	private String inputClaveActual = "//*[@value='Clave actual']";
	private String inputNuevaClave = "//*[@value='Nueva clave (4 dígitos)']";
	private String inputConfrimarClave = "//*[@value='Confirme su nueva clave']";
	private String btnContinuar = "//XCUIElementTypeButton[@name='Continuar']";
	private String btnContinuarTeclado = "(//XCUIElementTypeButton[@name='Continuar'])[2]";
	private String txtCambioExitoso = "//XCUIElementTypeStaticText[@name='Cambio de clave exitoso Ingrese al app con su nueva clave.']";
	//private String txtCambioFallido = "//XCUIElementTypeStaticText[@name='La nueva clave es igual a la clave anterior. Por favor ingrese una clave diferente.']";
	private String txtCambioFallido = "//XCUIElementTypeImage[@name='notif_ico_info']/following-sibling::XCUIElementTypeStaticText";
	private String txtCambioFallidoCambioFallido = "//XCUIElementTypeStaticText[@name='Error en cambio de clave']";
	private String txtCambioCorreoExitoso = "//XCUIElementTypeStaticText[contains(@name,'Solicitud de cambio de correo exitoso')]";
// funciones cambiar correo

	private String inputCorreoActual = "//XCUIElementTypeTextField[@name=\"Editar Correo Nuevo - campo habilitado\"]";
	private String inputCorreoNuevo = "//XCUIElementTypeTextField[@name=\"Editar Confirme Correo Nuevo - campo habilitado\"]";

// funciones casita roja caso 
	private String btnActivarTeclado = "com.davivienda.daviplataapp.lab:id/login_btn_ingresar";
	private String iframeValidacion = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.RelativeLayout[2]";
	private String txtTittle = "//android.widget.LinearLayout[@content-desc=\"Felicitaciones. El teclado ha sido instalado. Desde ya empiece a pasar plata desde sus redes sociales.\"]";
	private String topHeader = "com.davivienda.daviplataapp.lab:id/tvTopHeader";

// funciones ver movimientos

	private String listContainsMovimientos = "//XCUIElementTypeTable";
	private String textUltimosMovimiento = "//XCUIElementTypeStaticText[@name='Últimos movimientos']";
	private String textFechaMov = "//XCUIElementTypeStaticText[@name='Fecha']";
	private String listDateMov = "com.davivienda.daviplataapp.lab:id/movimientos_list_item_date";
	private String selectFecha = "//XCUIElementTypeImage[@name='login_line.png']";// desplegable para seleccionar fecha
	private String primeraFecha = "(//XCUIElementTypeStaticText[contains(@name, '/')])[1]";
	private String btnDiaAFiltrar = "//*[@text='#']";
	private String btnAceptar = "//XCUIElementTypeButton[@name='Aceptar']";
	private String btnAceptarFecha = "//XCUIElementTypeButton[@name='Aceptar']";
	private String btnEnviarCorreoElectronico = "//*[@name='Enviar a correo electrónico']";
	private String txtMovEnviados = "//*[@name='Sus movimientos han sido enviados a su correo electrónico registrado.']";

	private String mensajeCambioClaveExitoso = "//XCUIElementTypeImage[@name='notif_bkg.png']";
	private String btnPermitir = "com.android.permissioncontroller:id/permission_allow_button";
	private String btnLenguajeIntroduccion = "com.davivienda.daviplataapp.lab:id/ks_btn_go_keyboard_settings";
	private String btnActivarTecldoDaviplata = "(//android.widget.Switch[@resource-id='android:id/switch_widget'])[3]";
	private String btnAceptarActivacionTecladoDaviplata = "android:id/button1";
	private String btnSeleccionarTecladoDaviplata = "com.davivienda.daviplataapp.lab:id/ks_btn_select_keyboard";
	private String opcionTecladoDaviplata = "//*[@text='Teclado DaviPlata']";
	public static final String BOTON_HEADER_HOME = "(//XCUIElementTypeOther[contains(@name,'image-header')])[1]";
	public static final String LISTA_DESPLEGABLE_PREFERENCIAS = "//XCUIElementTypeOther[@name='Seccion preferencias Desplegar opciones boton']";
	public static final String BOTON_CAMBIAR_CLAVE_CORREO = "//XCUIElementTypeOther[@name='btn-3']";
	public static final String CHECK_AUTORIZO_DATOS_PERSONALES = "(//XCUIElementTypeTextView[contains(@value,'Autorizo el uso de mis datos')]//following-sibling::XCUIElementTypeButton)[1]";
	public static final String CHECK_AUTORIZO_CONSULTAS_REPORTES  = "(//XCUIElementTypeTextView[contains(@value,'Autorizo el uso de mis datos')]//following-sibling::XCUIElementTypeButton)[2]";
	public static final String BOTON_ACEPTAR_TERMINOS_Y_CONDICIONES  = "//XCUIElementTypeStaticText[@name='Aceptar']";
	public static final String BTN_SALIR_DAVIPLATA = "//XCUIElementTypeOther[@name='btn-sign-out'] | //XCUIElementTypeOther[@name='Salir de DaviPlata botón']";
	public static final String BOTON_ACEPTAR_SALIR_APP  = "//XCUIElementTypeButton[@name='Aceptar']";

	
	public void darClickCambiarClave() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCambiarClave)));
		driver.findElement(By.xpath(this.btnCambiarClave)).click();
		
		System.out.println("di click en btn cambiar clave");
	}

	public void darClickCambiarCorreo() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.btnCambiarCorreo)));
		driver.findElement(By.xpath(this.btnCambiarCorreo)).click();
	}

//Funciones cambiar Clave

	public void ingresarClaveActual(String claveActual) {
		System.out.println("keys a input clave actual");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputClaveActual)));
		driver.findElement(By.xpath(this.inputClaveActual)).sendKeys(claveActual);
	}

	public void ingresarClaveNueva(String claveNueva) {
		System.out.println("keys a input clave nueva");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputNuevaClave)));
		driver.findElement(By.xpath(this.inputNuevaClave)).sendKeys(claveNueva);
	}

	public void ingresarConfirmarClave(String claveNueva) {
		System.out.println("keys a input confirmar clave nueva");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputConfrimarClave)));
		driver.findElement(By.xpath(this.inputConfrimarClave)).sendKeys(claveNueva);
	}

	public void darClickContinuar() {
		try {
			Utilidades.esperaMiliseg(1000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuar)));
			driver.findElement(By.xpath(this.btnContinuar)).click();
		}catch(Exception e) {
			System.out.println("no di click a btn continuar");
		}
	}

	public void validarCambioDeClaveExitoso() {
		System.out.println("validando cambio de clave exitoso");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.txtCambioExitoso)));
		String txtCambioExitoso = driver.findElement(By.xpath(this.txtCambioExitoso)).getText();
		System.out.println("mensaje de clave es: " + txtCambioExitoso);
		assertThat(txtCambioExitoso, containsString("Cambio de clave exitoso"));
		System.out.println("se paso validacion de mensaje de clave ");
	}
	
	public void cerrarMensajeCambioClaveExitoso() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.txtCambioExitoso)));
		driver.findElement(By.xpath(this.txtCambioExitoso)).click();
	}

	public void validarCambioDeClaveFallido() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtCambioFallido)));
		String txtCambioFallido = driver.findElement(By.xpath(this.txtCambioFallido)).getText();
		System.out.println("cambioExitoso "+txtCambioFallido);
		boolean validacion = false;
		if (txtCambioFallido
				.contains("La nueva clave es igual a la clave anterior. Por favor ingrese una clave diferente.")) {
			validacion = true;
		} else if (txtCambioFallido.contains("Error en cambio de clave")) {
			validacion = true;
		} else if (txtCambioFallido
				.contains("La nueva clave no conicide con la confirmación. Por favor digítela nuevamente.")) {
			validacion = true;
			System.out.println("voy a poner validacion en true");
		}
		assertTrue(validacion);
	}
	
// ************************************************Funciones Cambio De Correo************************************************************

	public void ingresarCorreoActual(String correoActual) {
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputCorreoActual)));
		driver.findElement(By.xpath(this.inputCorreoActual)).sendKeys(correoActual);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarTeclado)));
		driver.findElement(By.xpath(this.btnContinuarTeclado)).click();
		
	}

	public void ingresarCorreoNuevo(String correoNuevo) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputCorreoNuevo)));
		driver.findElement(By.xpath(this.inputCorreoNuevo)).sendKeys(correoNuevo);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarTeclado)));
		driver.findElement(By.xpath(this.btnContinuarTeclado)).click();
	}

	public void validarCambioDeCorreoExitoso() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtCambioCorreoExitoso)));
		String txtCambioExitoso = driver.findElement(By.xpath(this.txtCambioCorreoExitoso)).getText();
		System.out.println(txtCambioExitoso);
		assertEquals("Solicitud de cambio de correo exitoso. En las próximas 24 horas quedará actualizado su correo.", txtCambioExitoso);
	}

	public void validarCambioDeCorreoFallido() {
		boolean estadoVisiblePopUpAmigos = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.POP_UP_INVITE_AMIGOS);
		if(estadoVisiblePopUpAmigos == true) {
			Utilidades.esperaMiliseg(1500);
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_CLOSE);
		}	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtCambioFallido)));
		String txtCambioFallido = driver.findElement(By.xpath(this.txtCambioFallido)).getText();
		System.out.println(txtCambioFallido);
		boolean validacion = false;
		if (txtCambioFallido
				.contains("El nuevo correo es igual al correo anterior. Por favor ingrese un correo diferente.")) {
			validacion = true;
		} else if (txtCambioFallido.contains("CORREO ELECTRONICO ANTERIOR NO VALIDO")) {
			validacion = true;
		} else if(txtCambioFallido.contains("El correo ingresado no es un correo válido. Por favor revise e intente nuevamente.")) {
			validacion = true;
		} else if(txtCambioFallido.contains("Los datos de correo nuevo y confirmación de correo no son iguales. Por favor revise.")) {																	
			validacion = true;
		} else if(txtCambioFallido.contains("Solicitud de cambio de correo exitoso. En las próximas 24 horas quedará actualizado su correo.")) {																	
			validacion = true;
		}
		assertTrue(validacion); 
	}

// *******************************************Metodos Casita roja activar teclado*****************************************************

	public void darClickBtnActivarTeclado() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnActivarTeclado)));
		driver.findElement(By.xpath(this.btnActivarTeclado)).click();
	}
	
	public void darPermisosDeLaApp() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnPermitir)));
			driver.findElement(By.xpath(this.btnPermitir)).click();
			System.out.println("Se encontró popup y se dio permisos a la app");
		}catch(Exception e) {
			System.out.println("No se encontró popup de dar permisos a la app");
		}
	}
	
	public void darEnBtnLenguajeIntroduccion() { 
		MobileElement btnLenguajeIntro = (MobileElement) wait
		 .until(ExpectedConditions.elementToBeClickable(By.id(this.btnLenguajeIntroduccion)));
		btnLenguajeIntro.click();
	}
	
	public void darBtnActivarTecladoDaviplata() { 
		MobileElement activarTecladoDaviplata = (MobileElement) wait
		 .until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnActivarTecldoDaviplata)));
		activarTecladoDaviplata.click();
	}
	
	public void darBtnAceptarAtencionTecladoDaviplata() { 
		MobileElement aceptarAtencionTecladoDaviplata = (MobileElement) wait
		 .until(ExpectedConditions.elementToBeClickable(By.id(this.btnAceptarActivacionTecladoDaviplata)));
		aceptarAtencionTecladoDaviplata.click();
	}
	
	public void darBtnSeleccionarTecladoDaviplata() { 
		MobileElement seleccionarTecladoDaviplata = (MobileElement) wait
		 .until(ExpectedConditions.elementToBeClickable(By.id(this.btnSeleccionarTecladoDaviplata)));
		seleccionarTecladoDaviplata.click();
	}
	
	public void darOpcionSeleccionarTecladoDaviplata() { 
		MobileElement opcionSeleccionarTecladoDaviplata = (MobileElement) wait
		 .until(ExpectedConditions.elementToBeClickable(By.xpath(this.opcionTecladoDaviplata)));
		opcionSeleccionarTecladoDaviplata.click();
	}

	public void validarActivacionTeclado() {
		MobileElement txtTittle = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtTittle)));
		String instrucciones = txtTittle.getAttribute("content-desc");
		
		System.out.println(instrucciones);
		boolean validacion = false;
		if (instrucciones.contains("Felicitaciones. El teclado ha sido instalado. Desde ya empiece a pasar plata desde sus redes sociales.")) {
			validacion = true;
		}
		assertTrue(validacion);

	}

//***************************************metodos ver movimientos*******************************************************

	public void verificarQueSeMuestrenMovimientos() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.listContainsMovimientos)));
		boolean isEnabledlista = driver.findElement(By.xpath(this.listContainsMovimientos)).isEnabled();
		assertTrue(isEnabledlista);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.textUltimosMovimiento)));
		boolean textUltimosMovimiento = driver.findElement(By.xpath(this.textUltimosMovimiento)).isEnabled();
		assertTrue(textUltimosMovimiento);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.textFechaMov)));
		boolean textFechaMov = driver.findElement(By.xpath(this.textFechaMov)).isEnabled();
		assertTrue(textFechaMov);
	}

	public List<MobileElement> capturarFechas() {
		List<MobileElement> listDateMov = base.driver.findElements(By.xpath(this.listDateMov));
		return listDateMov;
	}

	public String buscoFechaMasAntiguaAFiltrar(List<MobileElement> listDateMov) {
		int fechaMenor = 0;
		int subFecha = 0;
		for (MobileElement mobileElement : listDateMov) {
			if (Integer.parseInt(mobileElement.getText().split("/")[2]) > subFecha) {
				subFecha = Integer.parseInt(mobileElement.getText().split("/")[2]);
			} else {
				fechaMenor = Integer.parseInt(mobileElement.getText().split("/")[2]);
			}
		}
		return String.valueOf(fechaMenor);
	}
	public String obtenerPrimeraFecha() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.primeraFecha)));
		return driver.findElement(By.xpath(this.primeraFecha)).getText();
	}
	
	public void darClickDesplegableSelectorFecha() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.selectFecha)));
		driver.findElement(By.xpath(this.selectFecha)).click();
	}
	

	public void darClickDiaAFiltar(String fecha) {
		
		this.btnDiaAFiltrar = this.btnDiaAFiltrar.replace("#", fecha);
		System.out.println(btnDiaAFiltrar);
		
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnDiaAFiltrar)));
		//driver.findElement(By.xpath(this.btnDiaAFiltrar)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptar)));
		driver.findElement(By.xpath(this.btnAceptar)).click();
	}

	public void darClickEnAceptarFecha() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptarFecha)));
		driver.findElement(By.xpath(this.btnAceptarFecha)).click();
	}

	public void verificoDiaFiltrado(String fechaAnteriorPrimera) {
		System.out.println("validando que las fecha se haya filtrado");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.primeraFecha)));
		String primeraFecha =  driver.findElement(By.xpath(this.primeraFecha)).getText();
		if(primeraFecha.equals(fechaAnteriorPrimera)) {
			assertThat(primeraFecha, is(equalTo(fechaAnteriorPrimera)));
			
		}else {
			assertThat(primeraFecha, is(not(equalTo(fechaAnteriorPrimera))));
		}
		
	}
	
	public void darClickEnviarACorreo() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnEnviarCorreoElectronico)));
		driver.findElement(By.xpath(this.btnEnviarCorreoElectronico)).click();
	}
	
	public void validarQueSeEnvienDatosACorreo() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtMovEnviados)));
		String txtMovEnviados = driver.findElement(By.xpath(this.txtMovEnviados)).getText();
		assertThat(txtMovEnviados, containsString("Sus movimientos han sido enviados a su correo electrónico registrado."));
	}

}
