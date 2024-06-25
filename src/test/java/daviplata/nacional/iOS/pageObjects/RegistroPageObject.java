package daviplata.nacional.iOS.pageObjects;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.hamcrest.Matchers.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import daviplata.nacional.iOS.utilidades.Utilidades;
import daviplata.nacional.iOS.utilidades.UtilidadesTCS;
import daviplata.nacional.iOS.definitions.Hooks;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import net.serenitybdd.core.pages.PageObject;

public class RegistroPageObject extends PageObject {
    
	private AppiumDriver<MobileElement> driver = Hooks.getDriver();
	private WebDriverWait wait = Hooks.getDriverWait();
	Utilidades utilidad;
	private int contador=0;
	UtilidadesTCS utilidadesTCS;
	
	
	//tomar foto
	private String btnTomarFoto = "com.davivienda.daviplataapp.lab:id/btnTakeIdPhoto";
	
	// txt Nombre
	private String txtNombreApellido ="//XCUIElementTypeOther[4]/XCUIElementTypeTextField";
	
	//txt numero de documento
	private String txtNumDoc = "com.davivienda.daviplataapp.lab:id/tvIdNumber";
	
	//btn Fecha 
	private String btnFecha = "com.davivienda.daviplataapp.lab:id/tvIdBirthDate";
	
	//txt para comenzar el scroll
	private String btnFechaIn = "//*[contains(@text, '2021')]";
	
	private String btnFechaFi = "//*[contains(@text, '2022')]"; 
	
	//txt fecha de nacimiento
	private String btnFechaNaci = "//*[contains(@text, '1997')]";
	
	//btnHecho fecha
	private String btnHecho = "//*[contains(@text, 'Hecho')]";
	
	//btn Fecha Expidicion
	private String btnFechaExp = "com.davivienda.daviplataapp.lab:id/tvIdExpeditionDate";
	
	//txt fecha de nacimiento
	private String btnFechaExpe = "//*[contains(@text, '2010')]";
	
	//txt Lugar expedicion
	private String txtLugarExp = "//XCUIElementTypeOther[1]/XCUIElementTypeOther[13]/XCUIElementTypeTextField";
	
	//txt numero de cel
	private String txtNumCel = "//XCUIElementTypeStaticText[@name=\"Número de celular\"]";
	
	//txt numero de cel confirmacion 
	private String txtNumCelConf = "com.davivienda.daviplataapp.lab:id/etIdPhoneNumberConfirmR";
	
	//txt correo electronico
	private String txtCorreo = "//XCUIElementTypeStaticText[@name='Correo electrónico']";
	private String txtCorreoConfirmar = "//XCUIElementTypeStaticText[@name='Confirme su correo electrónico']";
	private String btnAceptar = "//XCUIElementTypeButton[@name='Done' or @name='Aceptar']";
	//btnContinuar
	private String btnContinuar = "//XCUIElementTypeButton[@name='Continuar']";
	
	private String btnContinuarTeclado2 = "(//XCUIElementTypeButton[@name='Continuar'])[2]";
	
	private String checkBoxTerminosCondiciones = "com.davivienda.daviplataapp.lab:id/checkOtp";
	private String btnAceptarTerminosCondiciones = "com.davivienda.daviplataapp.lab:id/BtnPopupPositiveButton";
	
	//btnTerminos
	private String btnTermino = "com.davivienda.daviplataapp.lab:id/cbTermsRules";
	//btnTerminos reglas
	private String btnReglas = "com.davivienda.daviplataapp.lab:id/cbTermsAuthorizeData";
	//btn autorizacion
	private String btnAuto = "com.davivienda.daviplataapp.lab:id/cbTermsAuthorizeAllies";
	
	
	//Clave nuevo
	private String txtclave = "//XCUIElementTypeOther[2]/XCUIElementTypeSecureTextField[1]";
	
	//Confirmacion clave
	private String txtConfiClave = "//XCUIElementTypeOther[3]/XCUIElementTypeSecureTextField[1]";
	
	//Continuar clave 
	private String btnContinuarClave = "//XCUIElementTypeButton[@name='Crear DaviPlata']";
	
	private String desplegarPassword = "";
	private String inputOtpRegistro = "//XCUIElementTypeTextField['1']";
	//Cambiar a persona
	private String btnPersona = "com.davivienda.daviplataapp.lab:id/txt_btn_persons";
	
	//Crear persona
	private String btnCrearPersona = "com.davivienda.daviplataapp.lab:id/btnNewPinContinue";
	
	//Continuar despues de clave
	private String btnContinuarr = "com.davivienda.daviplataapp.lab:id/notification_btn_continue";
	
	//x en Activar teclado
	private String btnCerrarTeclado = "com.davivienda.daviplataapp.lab:id/ib_close_introduction";
	
	// validar daviplata
	private String txtDaviplata = "//*[contains(@text, 'DaviPlata')]";
	
	//otp invalido
	private String otpInvalido = "//XCUIElementTypeStaticText[@name='Código de verificación inválido']";
	private String mensajeInvalidoClave = "//XCUIElementTypeStaticText[@name='Claves no coinciden']";
	//txt para ingresar otp
	private String txtOtp = "com.davivienda.daviplataapp.lab:id/etNewOtpCode";
	
	//btn continuar otp
	private String btnContinuarOtp = "com.davivienda.daviplataapp.lab:id/btnNewOtpContinue";
	
	private String checkBoxReglamentoUso = "(//XCUIElementTypeOther[2]/XCUIElementTypeButton)[1] | //XCUIElementTypeButton[@name='ic ui checkbox empty 2@2x']";
	private String checkBoxReglamentoDatosPersonales = "(//XCUIElementTypeOther[4]/XCUIElementTypeButton)[1]";
	private String checkBoxReglamentoConsultaInformacion = "(//XCUIElementTypeOther[6]/XCUIElementTypeButton)[1]";
	private String btnContinuarAutorizaciones = "//XCUIElementTypeButton[@name='Continuar']";
	private String btnDia = "(//XCUIElementTypeImage[@name='icon_arrow_down_white'])[1]";
	private String btnMes = "(//XCUIElementTypeImage[@name='icon_arrow_down_white'])[1]";
	private String btnAño = "(//XCUIElementTypeImage[@name='icon_arrow_down_white'])[1]";
	private String btnDiaExpedicion = "(//XCUIElementTypeImage[@name='icon_arrow_down_white'])[1]";
	private String btnMesExpedicion = "(//XCUIElementTypeImage[@name='icon_arrow_down_white'])[1]";
	private String btnAnioExpedicion = "(//XCUIElementTypeImage[@name='icon_arrow_down_white'])[1]";
	private String txtCreado = "//XCUIElementTypeStaticText[contains(@name, 'ha sido creado')]";
	private String btnMiDaviplata = "//XCUIElementTypeButton[@name='Usar Mi DaviPlata']";
	private String btnTerminoActualizado1 = "(//XCUIElementTypeButton[@name='ic ui checkbox empty 2@2x'])[1]";
	private String btnTerminoActualizado2 = "//XCUIElementTypeButton[@name='ic ui checkbox empty 2@2x']";
	private String inputOtp = "(//android.widget.EditText)[";
	private String inputContrasena = "(//android.widget.EditText)[";
	private String inputContrasenaConfirmada1 = "com.davivienda.daviplataapp.lab:id/i";
	private String inputContrasenaConfirmada2 = "(//android.widget.EditText)[6]";
	private String inputContrasenaConfirmada3 = "(//android.widget.EditText)[7]";
	private String inputContrasenaConfirmada4 = "(//android.widget.EditText)[8]";
	private String btnCrearDaviplata = "com.davivienda.daviplataapp.lab:id/btnCrearDavi";
	private String mensajeContrasenaErronea = "com.davivienda.daviplataapp.lab:id/tvError";
	private String ciudadEncontrada = "//XCUIElementTypeCell/XCUIElementTypeOther[1]/XCUIElementTypeOther";

	private String btnContinuarTeclado = "//XCUIElementTypeButton[@name='continuar']";
	private String btnContinuarTeclado3 = "(//XCUIElementTypeButton[@name='Continuar'])[2]";
	public static String CEDULA_TRADICIONAL = "//XCUIElementTypeOther[@name='Cédula tradicional']";
	public static String CHECK_BOX_REGLAMENTO_USO = "(//XCUIElementTypeOther[2]/XCUIElementTypeButton)[1] | //XCUIElementTypeButton[@name='ic ui checkbox empty 2@2x']";
	public static String CHECK_BOX_DATOS_PERSONALES = "(//XCUIElementTypeOther[4]/XCUIElementTypeButton)[1]";
	public static String CHECK_BOX_REGLAMENTO_CONSULTA = "(//XCUIElementTypeOther[6]/XCUIElementTypeButton)[1]";
	public static String BTN_ACEPTAR = "//XCUIElementTypeButton[@name='Done' or @name='Aceptar'] | //XCUIElementTypeStaticText[@name='Continuar'] | //XCUIElementTypeButton[@name='Continuar']";

	
	public void btnTomarFoto() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.btnTomarFoto)));
		element.click();
	}
	
	public void txtNombreApellido(String nombre) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtNombreApellido)));
		driver.findElement(By.xpath(this.txtNombreApellido)).sendKeys(nombre);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarTeclado)));
		driver.findElement(By.xpath(this.btnContinuarTeclado)).click();
	}
	
	public void txtNumDoc(String numDoc) {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.txtNumDoc)));
		element.clear();
		element.sendKeys(numDoc);
	}
	
	public void btnFecha() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id(this.btnFecha)));
		element.click();
		
		AndroidElement element1 = (AndroidElement) wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnFechaIn)));
		
		AndroidElement element2 = (AndroidElement) wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnFechaFi)));
		//MobileElement element1 = (MobileElement) wait
		//		.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnFechaIn)));
		//utilidad.moverPantalla(734, 1597, 723, 1927);
		//utilidad.moverPantalla(734, 1597, 723, 1927);
		//utilidad.moverPantalla(734, 1597, 723, 1927);
		//utilidad.moverPantalla(734, 1597, 723, 1927);
		//utilidad.moverPantalla(734, 1597, 723, 1927);
		for(int i = 0 ; i<=5; i++) {
			Utilidades.scrollDownSwipe(1);
		}
	}
	
	public void btnHecho() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnHecho)));
		element.click();
	}
	
	public void btnFechaExp() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.btnFechaExp)));
		element.click();
		AndroidElement element1 = (AndroidElement) wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnFechaIn)));
		
		AndroidElement element2 = (AndroidElement) wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnFechaFi)));
		for(int i = 0 ; i<=2; i++) {
			Utilidades.scrollDownSwipe(1);
		}
		
		//MobileElement element1 = (MobileElement) wait
		//		.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnFechaIn)));
		//utilidad.moverPantalla(734, 1597, 723, 1927);
		//utilidad.moverPantalla(734, 1597, 723, 1927);
		//utilidad.moverPantalla(734, 1597, 723, 1927);
	}
	
	public void txtLugarExp(String lugar) {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.txtLugarExp)));
		element.sendKeys(lugar);
	}
	
	public void txtNumCel(String cel) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtNumCel)));
		driver.findElement(By.xpath(this.txtNumCel)).sendKeys(cel);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarTeclado2)));
		driver.findElement(By.xpath(this.btnContinuarTeclado2)).click();
	}
	
	public void txtNumCelConf(String cel) {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.txtNumCelConf)));
		element.sendKeys(cel);
	}
	
	public void txtCorreo(String correo) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtCorreo)));
		driver.findElement(By.xpath(this.txtCorreo)).sendKeys(correo);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarTeclado)));
		driver.findElement(By.xpath(this.btnContinuarTeclado)).click();
		
		Utilidades.tomaEvidencia("Ingreso los ultimos datos");
	}
	
	public void txtCorreoConfirmar(String correo) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtCorreoConfirmar)));
		driver.findElement(By.xpath(this.txtCorreoConfirmar)).sendKeys(correo);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptar)));
		driver.findElement(By.xpath(this.btnAceptar)).click();
	}
	
	public void btnContinuar() {
		Utilidades.tomaEvidencia("Continuar");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuar)));
		driver.findElement(By.xpath(this.btnContinuar)).click();
	}
	
	public void checkBoxTerminosCondiciones() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.checkBoxTerminosCondiciones)));
		element.click();
	}
	
	public void btnAceptarTerminosCondiciones() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.btnAceptarTerminosCondiciones)));
		element.click();
	}
	
	public void btnTerminos() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.btnTermino)));
		element.click();
		
		MobileElement element2 = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.btnReglas)));
		element2.click();
		
		MobileElement element3 = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.btnAuto)));
		element3.click();
	}
	
	public void btnClave(String clave) {
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtclave)));
		driver.findElement(By.xpath(this.txtclave)).sendKeys(clave);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtConfiClave)));
		driver.findElement(By.xpath(this.txtConfiClave)).sendKeys(clave);
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypeButton[@name='Continuar']")));
		driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Continuar']")).click();
		
		Utilidades.tomaEvidencia("Ingreso la clave y continuar");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarClave)));
		driver.findElement(By.xpath(this.btnContinuarClave)).click();
		
	}
	
	public void ingresarContrasena(String clave) {
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtclave)));
		driver.findElement(By.xpath(this.txtclave)).sendKeys(clave);
		
	}
	
	public void ingresarContrasenaConfirmada(String clave) {
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtConfiClave)));
		driver.findElement(By.xpath(this.txtConfiClave)).sendKeys(clave);
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypeButton[@name='Continuar']")));
		driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Continuar']")).click();
		
	}

	public void btnPersona() {
		/*MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.btnPersona)));
		element.click();
		utilidad.tomaEvidencia("Persona");*/
		
		MobileElement element2 = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.btnCrearPersona)));
		Utilidades.tomaEvidencia("Crear persona");
		element2.click();
	
	}
	
	public void continuarFlujo() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.btnContinuarr)));
		element.click();
		
		MobileElement element2 = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.btnCerrarTeclado)));
		element2.click();
		try {
			MobileElement element3 = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.id(this.btnCerrarTeclado)));
			element3.click();
		}catch(Exception e) {
			
		}
	
	}
	public void validoIngreso() {
		boolean validacion = false;
		MobileElement element1 = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtDaviplata)));
		String mensajeActual = element1.getText();
		if (mensajeActual.contains("Mi DaviPlata") || mensajeActual.contains("DaviPlata")) {
			validacion = true;
		}
		assertTrue(validacion);
	}
	
	public void otpInvalido() {
		boolean validacion = false;
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.otpInvalido)));
		String mensajeActual = driver.findElement(By.xpath(this.otpInvalido)).getText();
		
		if (mensajeActual.contains("Código de verificación inválido") || mensajeActual.contains("inválido")) {
			validacion = true;
		}
		assertTrue(validacion);
	}
	
	public void validoClaveInco() {
		boolean validacion = false;
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.mensajeInvalidoClave)));
		String mensajeActual = driver.findElement(By.xpath(this.mensajeInvalidoClave)).getText();
		
		if (mensajeActual.contains("claves no coinciden") || mensajeActual.contains("coinciden")) {
			validacion = true;
		}
		assertTrue(validacion);
	}
	public void btnClaveInco(String clave) {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.txtclave)));
		element.sendKeys(clave);
		
		MobileElement element2 = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.txtConfiClave)));
		element2.sendKeys("4321");
		
		MobileElement element3 = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.btnContinuarClave)));
		Utilidades.tomaEvidencia("Ingreso la clave y continuar");
		element3.click();
		
	}
	
	
	
	public void ingresarOtpInvalida() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputOtpRegistro)));
		driver.findElement(By.xpath(this.inputOtpRegistro)).sendKeys("1234567");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.btnContinuarTeclado3)));
		driver.findElement(By.xpath(this.btnContinuarTeclado3)).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.btnContinuar)));
		driver.findElement(By.xpath(this.btnContinuar)).click();
		
		Utilidades.tomaEvidencia("Ingreso la otp invalida");
	
	}

	public void clickDaviplataInfo() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.otpInvalido )));
		element.click();
	}
	
	public void aceptoReglamentoUso() {
		try {
		    contador++;
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.checkBoxReglamentoUso)));
			driver.findElement(By.xpath(this.checkBoxReglamentoUso)).click();
		}catch(Exception e) {
		    if(!(contador==5)) {
		    	Utilidades.esperaMiliseg(2000);
		    	aceptoReglamentoUso();
		    }else {
		    	fail("No se encontró checkBox de reglamento de uso en registro de usuarios, debido a: " + e.getMessage());
		    }
		}finally {contador=0;}
		
	}
	
	public void aceptoReglamentoDatosPersonales() {
		try {
		    contador++;	
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.checkBoxReglamentoDatosPersonales)));
			driver.findElement(By.xpath(this.checkBoxReglamentoDatosPersonales)).click();
		}catch(Exception e) {
		    if(!(contador==5)) {
		    	Utilidades.esperaMiliseg(2000);
		    	aceptoReglamentoDatosPersonales();
		    }else {
		    	fail("No se encontró checkBox de reglamento de datos personales en registro de usuarios, debido a: " + e.getMessage());
		    }
		}finally {contador=0;}
		
	}
	
	public void aceptoReglamentoConsultaInformacion() {
		try {
		    contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.checkBoxReglamentoConsultaInformacion)));
			driver.findElement(By.xpath(this.checkBoxReglamentoConsultaInformacion)).click();
		}catch(Exception e) {
		    if(!(contador==5)) {
		    	Utilidades.esperaMiliseg(2000);
		    	aceptoReglamentoConsultaInformacion();
		    }else {
		    	fail("No se encontró checkBox de reglamento de consulta de informacion personal en registro de usuarios, debido a: " + e.getMessage());
		    }
		}finally {contador=0;}
		
	}
	
	public void clicBtnContinuar() {
		try {
		    contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarAutorizaciones)));
			driver.findElement(By.xpath(this.btnContinuarAutorizaciones)).click();
		}catch(Exception e) {
		    if(!(contador==5)) {
		    	Utilidades.esperaMiliseg(2000);
		    	clicBtnContinuar();
		    }else {
		    	fail("No se encontró botón 'Continuar' en registro de usuarios, debido a: " + e.getMessage());
		    }
		}finally {contador=0;}
		
	}
	
	public void validarRegistro() {
		try {
		    contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtCreado)));
			String txtCreacion = driver.findElement(By.xpath(this.txtCreado)).getText();
			
			assertThat(txtCreacion, containsString("ha sido creado"));
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnMiDaviplata)));
			driver.findElement(By.xpath(this.btnMiDaviplata)).click();
		}catch(Exception e) {
		    if(!(contador==5)) {
		    	Utilidades.esperaMiliseg(2000);
		    	validarRegistro();
		    }else {
		    	fail("No se encontró botón 'Continuar' en registro de usuarios, debido a: " + e.getMessage());
		    }
		}finally {contador=0;}
		
	}
	
	public void aceptarAcualizacionTerminosYCondiciones() {
		try {
		    contador++;
//			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnTerminoActualizado1)));
//			driver.findElement(By.xpath(this.btnTerminoActualizado1)).click();
//			
//			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnTerminoActualizado1)));
//			driver.findElement(By.xpath(this.btnTerminoActualizado1)).click();
//			
		    
			boolean visibilidad2 = utilidadesTCS.validateElementVisibilityCatch("xpath", RegistroPageObject.CHECK_BOX_DATOS_PERSONALES);
			if(visibilidad2 == true) {
				Utilidades.esperaMiliseg(800);
				aceptoReglamentoDatosPersonales();
			}
			
			boolean visibilidad3 = utilidadesTCS.validateElementVisibilityCatch("xpath", RegistroPageObject.CHECK_BOX_REGLAMENTO_CONSULTA);
			if(visibilidad3 == true) {
				Utilidades.esperaMiliseg(800);
				aceptoReglamentoConsultaInformacion();
			}
			
			boolean visibilidad4 = utilidadesTCS.validateElementVisibilityCatch("xpath", RegistroPageObject.BTN_ACEPTAR);
			if(visibilidad4 == true) {
				Utilidades.esperaMiliseg(800);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptar)));
				driver.findElement(By.xpath(this.btnAceptar)).click();			
			}
			
			Utilidades.tomaEvidencia("Acepto autorizaciones de registro");
			
		}catch(Exception e) {
		    if(!(contador==5)) {
		    	Utilidades.esperaMiliseg(2000);
		    	aceptarAcualizacionTerminosYCondiciones();
		    }else {
		    	fail("No se encontró botón 'Continuar' en registro de usuarios, debido a: " + e.getMessage());
		    }
		}finally {contador=0;}
		
	}
	
	public void ingresarDia(String dia) {
		try {
		    contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnDia)));
			driver.findElement(By.xpath(this.btnDia)).click();
			Utilidades.esperaMiliseg(1000);
			driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='"+ dia +"']")).click();
		}catch(Exception e) {
		    if(!(contador==5)) {
		    	Utilidades.esperaMiliseg(2000);
		    	ingresarDia(dia);
		    }else {
		    	fail("No se encontró btn 'Día' en registro, debido a: " + e.getMessage());
		    }
		}finally {contador=0;}
		
	}
	public void ingresarMes(String mes) {
		try {
		    contador++;
			driver.findElement(By.xpath(this.btnMes)).click();
			Utilidades.esperaMiliseg(1000);
			driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='"+ mes +"']")).click();
		}catch(Exception e) {
		    if(!(contador==5)) {
		    	Utilidades.esperaMiliseg(2000);
		    	ingresarMes(mes);
		    }else {
		    	fail("No se encontró btn 'Mes' en registro, debido a: " + e.getMessage());
		    }
		}finally {contador=0;}
		
	}
	
	public void ingresarAño(String año) {
		System.out.println("ingresando año");
		try {
			Utilidades.esperaMiliseg(4000);
		    contador++;
			driver.findElement(By.xpath(this.btnAño)).click();
			
			Utilidades.esperaMiliseg(1000);
			driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='"+ año +"']")).click();
		}catch(Exception e) {
		    if(!(contador==5)) {
		    	Utilidades.esperaMiliseg(2000);
		    	ingresarAño(año);
		    }else {
		    	fail("No se encontró btn 'Año' en registro, debido a: " + e.getMessage());
		    }
		}finally {contador=0;}
		
	}
	
	public void ingresarDiaExpedicion(String diaExpedicion) {
		try {
		    contador++;
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnDiaExpedicion)));
			driver.findElement(By.xpath(this.btnAño)).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypeButton[@name='Aceptar']")));
			driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Aceptar']")).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnDiaExpedicion)));
			driver.findElement(By.xpath(this.btnAño)).click();
			
			Utilidades.esperaMiliseg(1000);
			driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='"+ diaExpedicion +"']")).click();
		}catch(Exception e) {
		    if(!(contador==5)) {
		    	Utilidades.esperaMiliseg(2000);
		    	ingresarDiaExpedicion(diaExpedicion);
		    }else {
		    	fail("No se encontró botón 'Dia' de expedición del documento en registro, debido a: " + e.getMessage());
		    }
		}finally {contador=0;}
		
	}
	
	public void ingresarMesExpedicion(String mesExpedicion) {
		try {
		    contador++;
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnMesExpedicion)));
			driver.findElement(By.xpath(this.btnMesExpedicion)).click();
			
			Utilidades.esperaMiliseg(1000);
			driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='"+ mesExpedicion +"']")).click();
		}catch(Exception e) {
		    if(!(contador==5)) {
		    	Utilidades.esperaMiliseg(2000);
		    	ingresarMesExpedicion(mesExpedicion);
		    }else {
		    	fail("No se encontró botón 'Mes' de expedición del documento en registro, debido a: " + e.getMessage());
		    }
		}finally {contador=0;}
	}
	
	public void ingresarAnioExpedicion(String anioExpedicion) {
		try {
		    contador++;	
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAnioExpedicion)));
			driver.findElement(By.xpath(this.btnAnioExpedicion)).click();
			
			Utilidades.esperaMiliseg(1000);
			driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='"+ anioExpedicion +"']")).click();
		}catch(Exception e) {
		    if(!(contador==5)) {
		    	Utilidades.esperaMiliseg(2000);
		    	ingresarAnioExpedicion(anioExpedicion);
		    }else {
		    	fail("No se encontró botón 'Año' de expedición del documento en registro, debido a: " + e.getMessage());
		    }
		}finally {contador=0;}
	}
	
	
	public void ingresarLugarExp(String lugar) {
		try {
		    contador++;
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtLugarExp)));
			driver.findElement(By.xpath(this.txtLugarExp)).sendKeys(lugar);
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.ciudadEncontrada)));
			driver.findElement(By.xpath(this.ciudadEncontrada)).click();
		}catch(Exception e) {
		    if(!(contador==5)) {
		    	Utilidades.esperaMiliseg(2000);
		    	ingresarLugarExp(lugar);
		    }else {
		    	fail("No se encontró botón desplegable de 'Ciudad de expedicion del documento', debido a: " + e.getMessage());
		    }
		}finally {contador=0;}
	}
}
