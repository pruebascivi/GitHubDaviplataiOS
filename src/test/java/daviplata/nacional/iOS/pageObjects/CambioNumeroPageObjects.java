package daviplata.nacional.iOS.pageObjects;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import daviplata.nacional.iOS.definitions.Hooks;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import daviplata.nacional.iOS.utilidades.Utilidades;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import net.serenitybdd.core.pages.PageObject;


public class CambioNumeroPageObjects extends PageObject {

	Hooks Hooks;
	private AppiumDriver<MobileElement> driver = Hooks.getDriver();
	private WebDriverWait wait = Hooks.getDriverWait();
	BaseUtil base;
	Utilidades utilidad;
	Utilidades Utilidades;

	private int contador = 0;
	private String btnTipoDocumento = "//XCUIElementTypeButton[@name = 'Lista desplegable - Tipo de documento']";
	private String listTipoDocumento = "(//*[@id='select_dialog_listview']/*[@text])[";
	private String inputNumeroDocumento = "Editar Numero de documento - campo habilitado";
	private String btnContinuarZonaPublica = "//XCUIElementTypeButton[@name = 'Continuar']";
	private String btnContinuar = "//*[@id='btnContinue']";
	private String btnContinuarTeclado = "(//XCUIElementTypeButton[@name = 'Continuar'])[2]";
	private String btnCancelarPopUp = "//android.widget.Button[1]";
	private String btnAceptarPopUp = "//android.widget.Button[2]";
	private String inputNuevoNumeroCelular = "com.davivienda.daviplataapp.lab:id/et_cambiar_numero_actual";
	private String inputConfirmarNuevoNumeroCelular = "com.davivienda.daviplataapp.lab:id/et_cambiar_numero_nuevo";
	private String btnContinuarCambioNumero = "com.davivienda.daviplataapp.lab:id/cambiar_numero_btn_continuar";
	private String popUpAtencion = "com.davivienda.daviplataapp.lab:id/custom_card_view";
	
	private String txtAtencion = "Para hacer el cambio de número lo comunicaremos con asesoria en linea.";
	

	private String btnAceptarAsesoriaEnLinea = "com.davivienda.daviplataapp.lab:id/BtnPopupPositiveButton";
	private String btnCancelarAsesoriaEnLinea = "com.davivienda.daviplataapp.lab:id/BtnPopupNegativeButton";
	private String btnCerrarAsesoriaEnLinea = "ico close modal";
	private String inputIngresarOTP = "com.davivienda.daviplataapp.lab:id/etNewOtpSimpleCode";
	private String btnContinuarIngresoOTP = "com.davivienda.daviplataapp.lab:id/btnNewOtpSimpleContinue";
	private String txtClaveConfirmacionOTP = "com.davivienda.daviplataapp.lab:id/login_et_clave";
	private String btnContinuarLogin = "com.davivienda.daviplataapp.lab:id/login_btn_ingresar";
	private String popUpCambioNumero = "//android.widget.TextView[1]";
	private String btnVolverEnviarOTP = "com.davivienda.daviplataapp.lab:id/btnNewOtpSimpleResend"; 
	private String txtAdvertencia = "//*[@text='Excedió la cantidad de intentos para ingresar el código']";
	private String txtSuperoIntentos = "com.davivienda.daviplataapp.lab:id/notif_text_rappi";
	private String btnMenuHamburguesa = "com.davivienda.daviplataapp.lab:id/ivMenuHowMuch";
	private String btnMasServicios = "com.davivienda.daviplataapp.lab:id/ivMoreServices";
	private String btnCambioNumeroPrivado = "//android.widget.TextView[contains(@text,'Cambiar número')]";
	private String btnOlvidoClave = "//*[@id='btnForgotPasswordRem']";
	private String txtNumDocumentoOlvidoClave = "//*[@id='et_login_documento']";
	private String btnContinuarCredenciales = "//*[@id='login_btn_continuar']";
	private String txtEmailOlvidoClave = "//*[@id='olvido_clave_view01_email']";
	private String btnContinuarOlvidoClave = "//*[@id='olvido_clave_view01_btnContinuar']";
	private String txtClaveTemporal = "//*[@id='olvido_clave_view02_clave']";
	private String btnContinuarClaveTemporal = "//*[@id='olvido_clave_view02_btn']";
	private String txtNuevaClave = "//*[@id='olvido_clave_view03_clave']";
	private String txtVerifiqueClave = "//*[@id='olvido_clave_view03_reclave']";
	private String btnAceptarNuevaClave = "//*[@id='olvido_clave_view03_btn']";
	private String btnNoMeInteresaOfertaCredito = "//*[@id='btn_cmp_no_interes']";
	private String imgEsperaPage = "android:id/progress";

	public void pulsarBtnTipoDocumento() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnTipoDocumento)));
			driver.findElement(By.xpath(this.btnTipoDocumento)).click();
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(500);
				pulsarBtnTipoDocumento();
			}else {
				fail("No se encontró lista de tipo de documento en cambio de numero, debido a: " + e.getMessage());
			}
		}finally {contador=0;}
		
	}

	public void seleccionarTipoDocumento(String tipoDocumento) {
		if (tipoDocumento.contains("identidad"))
			listTipoDocumento = listTipoDocumento + "1]";
		else if (tipoDocumento.contains("ciudadanía"))
			listTipoDocumento = listTipoDocumento + "2]";
		else if (tipoDocumento.contains("extranjería"))
			listTipoDocumento = listTipoDocumento + "3]";
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.listTipoDocumento)));
		driver.findElement(By.xpath(this.listTipoDocumento)).click();
		utilidad.esperaMiliseg(900);
		utilidad.tomaEvidencia("seleccionar tipo documento");
	}

	public void ingresarNumeroDocumento(String usuario) {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(this.inputNumeroDocumento)));
			driver.findElement(By.name(this.inputNumeroDocumento)).sendKeys(usuario);
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(500);
				ingresarNumeroDocumento(usuario);
			}else {
				fail("No se encontró input para ingresar numero de documento en Cambio de numero, debido a: " + e.getMessage());
			}
		}finally {contador=0;}
	
		
	}

	public void pulsarBotonContinuar() {
		utilidad.esperaMiliseg(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarZonaPublica)));
		driver.findElement(By.xpath(this.btnContinuarZonaPublica)).click();
	}
	
	

	public void pulsarAceptarPopUp() {
		WebDriverWait espera = new WebDriverWait(base.driver, 10);
		try {
			System.out.println("Ingrese al PopUp Cambio de Numero");
			utilidad.tomaEvidencia("Pop up Cambio número celular");
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptarPopUp)));
			driver.findElement(By.xpath(this.btnAceptarPopUp)).click();
			
		} catch (Exception e) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptarPopUp)));
				driver.findElement(By.xpath(this.btnAceptarPopUp)).click();
			} catch (Exception e2) {
				System.out.println("No encontre pop up");
			}
		}
	}
	
	public void validarPopUpAtencion() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id(this.txtAtencion)));
		String txtAdvertencia = driver.findElement(By.id(this.txtAtencion)).getText();
		assertEquals(txtAdvertencia, "Para poder continuar vamos a eliminar los bolsillos y el saldo lo pasaremos a su saldo disponible");
		utilidad.tomaEvidencia("Se presento el Pop Up de Atencion");
		System.out.println("Valide el Pop Up de Atencion Correctamente");
	}
	
	public void pulsarBotonCerrarAsesoriaEnLinea() {
		wait.until(ExpectedConditions.elementToBeClickable(By.name(this.btnCerrarAsesoriaEnLinea)));
		driver.findElement(By.name(this.btnCerrarAsesoriaEnLinea)).click();
	}

	public void ingresarNuevoNumeroCelular(String numeroCelular) {
		wait.until(ExpectedConditions.elementToBeClickable(By.id(this.inputNuevoNumeroCelular)));
		driver.findElement(By.id(this.inputNuevoNumeroCelular)).sendKeys(numeroCelular);
		utilidad.esperaMiliseg(1000);
		utilidad.tomaEvidencia("Ingresar número celular");
		System.out.println("Ingrese al modulo Cambio de numero");
	}

	public void ingresarConfirmarNuevoNumeroCelular(String numeroCelular) {
		wait.until(ExpectedConditions.elementToBeClickable(By.id(this.inputConfirmarNuevoNumeroCelular)));
		driver.findElement(By.id(this.inputConfirmarNuevoNumeroCelular)).sendKeys(numeroCelular);
		
		utilidad.esperaMiliseg(1000);
		utilidad.tomaEvidencia("Ingresar número celular de nuevo");
	}

	public void pulsarContinuarCambioNumero() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id(this.btnContinuarCambioNumero)));
		driver.findElement(By.id(this.btnContinuarCambioNumero)).click();
		utilidad.tomaEvidencia("Click boton Continuar");
	}

	public void validarPopUPNumerosDiferentes() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id(this.txtAtencion)));
		String txtPopup = driver.findElement(By.id(this.txtAtencion)).getText();
		assertEquals("El número ingresado y la confirmación no coinciden. Por favor verifique e intente nuevamente.",
				txtPopup);
		utilidad.esperaMiliseg(1500);
		utilidad.tomaEvidencia("Pop up numeros ingresados no coinciden");
	}

	public void validarPopUpNumeroNoIniciaEnTres() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id(this.txtAtencion)));
		String txtPopup = driver.findElement(By.id(this.txtAtencion)).getText();
		assertEquals("El número de celular ingresado debe iniciar por 3", txtPopup);
		utilidad.esperaMiliseg(1500);
		utilidad.tomaEvidencia("Pop up numero no inicia en tres");
	}

	public void validarPopUpAdvertenciaNumeroDebeSerDiferente() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id(this.txtAtencion)));
		String txtPopup = driver.findElement(By.id(this.txtAtencion)).getText();
		
		assertEquals("El nuevo número ingresado debe ser diferente al actual.", txtPopup);
		utilidad.esperaMiliseg(1500);
		utilidad.tomaEvidencia("Pop up numero debe ser diferente");
	}

	public void ingresarOTP(String OTP) {
		try {
			contador++;
		wait.until(ExpectedConditions.elementToBeClickable(By.id(this.inputIngresarOTP)));
		MobileElement txtIngresarOTP = driver.findElement(By.id(this.inputIngresarOTP));
		
		txtIngresarOTP.click();
		txtIngresarOTP.sendKeys(OTP);
		
		utilidad.esperaMiliseg(1000);
		utilidad.tomaEvidencia("ingreso OTP");
		}catch(Exception e) {
		    if(!(contador==3)) {
		        utilidad.esperaMiliseg(500);
		        ingresarOTP(OTP);
		        }else {
		        fail("No se encontró , debido a: " + e.getMessage());
		        }
		    }finally {contador=0;}
	}

	public void pulsarContinuarIngresoOTP() {
		utilidad.esperaMiliseg(2000);
		utilidad.darUnTap(202, 347);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(this.btnContinuarIngresoOTP)));
		driver.findElement(By.id(this.btnContinuarIngresoOTP)).click();
		
		utilidad.tomaEvidencia("click boton continuar al ingresar OTP");
	}

	public void ingresarClaveConfirmacionOTP(String clave) {
		if (base.scenario.getName().contains("publico") || base.scenario.getName().contains("publica")) {
			
			wait.until(ExpectedConditions.elementToBeClickable(By.id(this.txtClaveConfirmacionOTP)));
			driver.findElement(By.id(this.txtClaveConfirmacionOTP)).sendKeys(clave);
			utilidad.tomaEvidencia("Ingresar clave");
		}
	}

	public void pulsarContinuarLogin() {
		if (base.scenario.getName().contains("publico") || base.scenario.getName().contains("publica")) {
			wait.until(ExpectedConditions.elementToBeClickable(By.id(this.btnContinuarLogin)));
			driver.findElement(By.id(this.btnContinuarLogin)).click();
		}
	}

	public void validarPopUpCambioNumero() {
		Utilidades.esperaMiliseg(12000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.popUpCambioNumero)));
		String popUp = driver.findElement(By.xpath(this.popUpCambioNumero)).getText();
			
		assertEquals("Cambio de número exitoso", popUp);
		Utilidades.esperaMiliseg(800);
		utilidad.tomaEvidencia("Cambio de numero exitoso");
		pulsarAceptarPopUp();
	}
	
	public void validarPopUpAsesoriaEnLinea() { 
		Utilidades.esperaMiliseg(12000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(this.txtAtencion)));
		String popUpAsesoriaEnLinea = driver.findElement(By.name(this.txtAtencion)).getText();
		assertThat(popUpAsesoriaEnLinea.replace("\n", ""), containsString("Para hacer el cambio de número lo comunicaremos con asesoria en linea."));
		Utilidades.esperaMiliseg(800);
		utilidad.tomaEvidencia("Pop Up Atención");
		pulsarBotonCerrarAsesoriaEnLinea();
	}
	
	
	public void validarMensajeOtpInvalido() {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(this.txtSuperoIntentos)));
			String mensajeOtpInvalido = driver.findElement(By.id(this.txtSuperoIntentos)).getText();
			assertThat(mensajeOtpInvalido, containsString("El código ingresado no es correcto, por favor revise e intente nuevamente"));
				Utilidades.esperaMiliseg(800);
				utilidad.tomaEvidencia("Cambio de número no exitoso OTP invalido");
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(2000);
				validarMensajeOtpInvalido();
			}else {fail("No se pudo validar mensaje OTP invalido, debido a: "+e.getMessage());}
		}finally {contador=0;}
		}
		
		
		
	
	
	public void validarYDarTapEnBotonCancelar() {
		Utilidades.esperaMiliseg(12000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(this.btnCancelarAsesoriaEnLinea)));
		MobileElement btnCancelar = driver.findElement(By.id(this.btnCancelarAsesoriaEnLinea));
			//assertEquals("Para hacer el cambio de número lo comunicaremos con asesoria en linea.", popUpAsesoriaEnLinea.getText());
		assertThat(btnCancelar.getText().replace("\n", ""), containsString("Cancelar"));
			Utilidades.esperaMiliseg(800);
			utilidad.tomaEvidencia("Encontré el boton Cancelar");
			System.out.print("Encontré el boton Cancelar y estoy haciendo click en el");
			btnCancelar.click();
	}
	
	public void validarYDarTapEnBotonAceptar() {
		Utilidades.esperaMiliseg(12000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(this.btnAceptarAsesoriaEnLinea)));
		MobileElement btnAceptar = driver.findElement(By.id(this.btnAceptarAsesoriaEnLinea));
		assertThat(btnAceptar.getText().replace("\n", ""), containsString("Aceptar"));
			Utilidades.esperaMiliseg(800);
			utilidad.tomaEvidencia("Encontré el boton Aceptar");
			System.out.print("Encontré el boton Aceptar y estoy haciendo click en el");
			btnAceptar.click();
	}
	

	public void pulsarVolverAEnviarOTP() {
		utilidad.esperaMiliseg(58000);
		utilidad.darUnTap(202, 347);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(this.btnVolverEnviarOTP)));
		MobileElement btnVolverEnviarOtp = driver.findElement(By.id(this.btnVolverEnviarOTP));
		utilidad.tomaEvidencia("click boton continuar al ingresar OTP");
		 btnVolverEnviarOtp.click();
		 utilidad.esperaMiliseg(10000);
		 //pageLogin.validarEsperaPage();
		 utilidad.tomaEvidencia("Validar cargando");
	}

	public String numAleatorioSeisDigitos() {
		String random = utilidad.numAleatorio(999999, 100000);
		return random;
	}

	public void validarAdvertenciaSuperarIntentos() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(this.txtSuperoIntentos)));
		String txtAdvertencia = driver.findElement(By.id(this.txtSuperoIntentos)).getText();
		assertEquals("Excedió la cantidad de intentos para ingresar el código", txtAdvertencia);
		utilidad.tomaEvidencia("Excedio la cantidad de intentos");
	}

	public void pulsarBtnMenuHamburguesa() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id(this.btnMenuHamburguesa)));
		driver.findElement(By.id(this.btnMenuHamburguesa)).click();
		Utilidades.esperaMiliseg(800);
		utilidad.tomaEvidencia("click botón menú");
	}

	

	public void pulsarBtnCambioNumeroPrivado() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCambioNumeroPrivado)));
		driver.findElement(By.xpath(this.btnCambioNumeroPrivado)).click();
		utilidad.esperaMiliseg(800);
		utilidad.tomaEvidencia("se ingreso a cambiar el numero");
	}

	public void pulsarBtnOlvidoClave() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnOlvidoClave)));
		driver.findElement(By.xpath(this.btnOlvidoClave)).click();
		utilidad.esperaMiliseg(800);
		utilidad.tomaEvidencia("se ingreso a '¿Olvidó su clave?'");
	}

	public void ingresarNumDocumentoOlvidoClave(String numDocumento) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtNumDocumentoOlvidoClave)));
		driver.findElement(By.xpath(this.txtNumDocumentoOlvidoClave)).sendKeys(numDocumento);
		utilidad.esperaMiliseg(800);
		utilidad.tomaEvidencia("Ingresar numero documento");
	}

	public void pulsarBtnContinuarOlvidoClave() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarCredenciales)));
		driver.findElement(By.xpath(this.btnContinuarCredenciales)).click();
	}

	public void ingresarEmailOlvidoClave(String email) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtEmailOlvidoClave)));
		driver.findElement(By.xpath(this.txtEmailOlvidoClave)).sendKeys(email);
		utilidad.esperaMiliseg(800);
		utilidad.tomaEvidencia("Ingresar email");
	}

	public void pulsarBtnContinuarOlvidoClaveDos() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarOlvidoClave)));
		driver.findElement(By.xpath(this.btnContinuarOlvidoClave)).click();
	}

	public void ingresarClaveTemporal(String clave) {
		utilidad.darUnTap(202, 347);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtClaveTemporal)));
		driver.findElement(By.xpath(this.txtClaveTemporal)).sendKeys(clave);
		utilidad.esperaMiliseg(800);
		utilidad.tomaEvidencia("Ingresar clave temporal");
	}

	public void pulsarbtnContinuarClaveTemporal() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarClaveTemporal)));
		driver.findElement(By.xpath(this.btnContinuarClaveTemporal)).click();
	}

	public void ingresarNuevaClave(String clave) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtNuevaClave)));
		driver.findElement(By.xpath(this.txtNuevaClave)).sendKeys(clave);
		utilidad.esperaMiliseg(800);
		utilidad.tomaEvidencia("Ingresar nueva clave");
	}

	public void ingresarNuevaClaveVerificar(String clave) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtVerifiqueClave)));
		driver.findElement(By.xpath(this.txtVerifiqueClave)).sendKeys(clave);
		utilidad.esperaMiliseg(800);
		utilidad.tomaEvidencia("Ingresar nueva clave para verificar");
	}

	public void pulsarbtnAceptarNuevaClave() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptarNuevaClave)));
		driver.findElement(By.xpath(this.btnAceptarNuevaClave)).click();
	}

	public void esperar() {
		utilidad.esperaMiliseg(10000);
	}

	public void pulsarBtnNoMeInteresaOfertaCredito() {
		WebDriverWait espera = new WebDriverWait(base.driver, 10);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnNoMeInteresaOfertaCredito)));
			driver.findElement(By.xpath(this.btnNoMeInteresaOfertaCredito)).click();
		} catch (Exception e) {
			System.out.println("No encontre oferta credito");
		}
	}
	
	public void clicBotonContinuarTecladoIos() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarTeclado)));
			driver.findElement(By.xpath(this.btnContinuarTeclado)).click();
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(500);
				clicBotonContinuarTecladoIos();
			}else {
				fail("No se encontró botón 'Continuar' del teclado iOS, debido a: " + e.getMessage());
			}
		}finally {contador=0;}
		
	}
	

}
