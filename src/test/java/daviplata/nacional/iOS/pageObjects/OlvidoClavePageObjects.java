package daviplata.nacional.iOS.pageObjects;

import static org.junit.Assert.fail;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import daviplata.nacional.iOS.utilidades.Credenciales;
import daviplata.nacional.iOS.definitions.Hooks;
import daviplata.nacional.iOS.utilidades.Utilidades;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.core.pages.PageObject;

public class OlvidoClavePageObjects extends PageObject {
    
	private AppiumDriver<MobileElement> driver= Hooks.getDriver();
	private WebDriverWait wait =Hooks.getDriverWait();
	Utilidades utilidades;
	private int contador = 0;
	String numCelular = "";
	BaseUtil base;

	WebLatiniaPageObject pageLatinia;
	
	private String btnOlvidoClave = "//XCUIElementTypeStaticText[@name='¿Olvidó su clave?']";
	private String btnTipoDocumento = "//XCUIElementTypeButton[@name='Lista desplegable - Tipo de documento']";
	private String listaDocumento = "//XCUIElementTypeOther[@name='DaviPlata']/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]";
	private String DocumentoTI = "//*[@name='Tarjeta de Identidad']";
	private String DocumentoCC = "(//*[@name='Cédula de Ciudadanía'])[2]";
	private String DocumentoCE = "//*[@name='Cédula de Extranjería']";
	private String btnContinuarTeclado = "(//XCUIElementTypeButton[@name='Continuar'])[2]";
	private String txtNumDocumento = "//*[@name='Editar Numero de documento - campo habilitado']";
	private String btnContinuar = "//XCUIElementTypeButton[contains(@name, 'Continuar')] | //XCUIElementTypeButton[contains(@label, 'Continuar')]";
	private String txtEmail = "//XCUIElementTypeTextField";
	private String btnAceptarTeclado = "//XCUIElementTypeButton[@name='Done']";
	private String btnContinuarEmail = "//XCUIElementTypeButton[@name='Continuar']";
	private String txtClaveTemporal = "com.davivienda.daviplataapp.lab:id/olvido_clave_view02_clave";
	private String btnContinuarClaveTemporal = "com.davivienda.daviplataapp.lab:id/olvido_clave_view02_btn";
	private String txtNuevaClave = "//XCUIElementTypeSecureTextField[1]";
	private String btnAceptarConfirmarClave = "(//XCUIElementTypeButton[@name='Aceptar'])[2]";
	private String btnSiguiente = "//XCUIElementTypeButton[@name='Siguiente']";
	private String txtConfirmarNuevaClave = "//XCUIElementTypeSecureTextField[2]";
	private String btnAceptar = "//XCUIElementTypeButton[@name=\"Aceptar\"]";
	private String labelNotificacion = "(//*[contains(@name, 'Cambio de clave exitoso')])";
	private String btnContinuarOTP = "//XCUIElementTypeButton[@name='Continuar']";
	private String inputOtp = "(//XCUIElementTypeTextField)[1]";
	private String labelNumTelefoo = "(//XCUIElementTypeStaticText)[5]";
	private String mensajeClaveErronea = "//XCUIElementTypeStaticText[@name='LA CLAVE INGRESADA ES INCORRECTA']";
	private String confirmacionClaveErronea = "//XCUIElementTypeStaticText[@name=\"La clave asignada y la confirmación no coinciden. Por favor verifique e intente nuevamente.\"]";
	private String txtCambiarClaveTitulo = "//XCUIElementTypeStaticText[@name=\"Por favor cambie su clave de acceso.\"]";
	private String inputClaveNuevaOlvidoClave = "(//XCUIElementTypeSecureTextField[@name='Digite su nueva clave'])[1]";
	private String btnCrearClave = "//XCUIElementTypeButton[@name='Crear clave']";
	private String btnFinalizarOlvidoClave = "//XCUIElementTypeButton[@name='Finalizar']";
	private String btnContinuarTecladoIos = "//XCUIElementTypeButton[@name='Continuar']";
	public static final String POP_UP_REGISTRO_USUARIO_NUEVO = "//XCUIElementTypeTextView[contains(@value, 'Chat DaviPlata')]";
	public static final String BTN_CERRAR_POPUP = "//XCUIElementTypeButton[contains(@name, 'Cerrar botón')] | //XCUIElementTypeButton[contains(@label, 'Cerrar botón')]";
	public static final String TXT_INGRESE_DATOS = "//XCUIElementTypeStaticText[@name='Ingrese sus datos']";
	
	public void pulsarBtnOlvidoClave() {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnOlvidoClave)));
			driver.findElement(By.xpath(this.btnOlvidoClave)).click();
		}catch (Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(500);
				pulsarBtnOlvidoClave();
			}else {fail("No se encontró botón '¿Olvidó su clave?' desde zona publica, debido a: " + e.getMessage());}
		}finally {contador=0;}
	}

	public void pulsarBtnTipoDocumento() {
		try {
			contador++;
			System.out.println("pulse el btn tipo de documento");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnTipoDocumento)));
			driver.findElement(By.xpath(this.btnTipoDocumento)).click();
			Utilidades.esperaMiliseg(900);
			Utilidades.tomaEvidencia("click tipo documento");
		}catch (Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(2000);
				pulsarBtnTipoDocumento();
			}else {fail("No de pudo dar clic en el boton tipo documento OlvidoClave "+btnTipoDocumento+" debido a:"+e.getMessage());}
		}finally {contador=0;}
		
	}

	public void seleccionarTipoDocumento(String tipoDocumento) {
		if (tipoDocumento.contains("identidad")){
			MobileElement listaDesplegable = (MobileElement) wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.listaDocumento)));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			Map<String, Object> params = new HashMap<>();
			params.put("order", "previous");
			params.put("offset", 0.15);
			params.put("element", ((RemoteWebElement) listaDesplegable).getId());
			js.executeScript("mobile: selectPickerWheelValue", params);
		}
		else if (tipoDocumento.contains("ciudadanía")){
			System.out.println("seleccione el mismo");
		}
		else if (tipoDocumento.contains("extranjeria")) {
			System.out.println("seleccionando tipo de documento");
			MobileElement listaDesplegable = (MobileElement) wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.listaDocumento)));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			Map<String, Object> params = new HashMap<>();
			params.put("order", "next");
			params.put("offset", 0.15);
			params.put("element", ((RemoteWebElement) listaDesplegable).getId());
			js.executeScript("mobile: selectPickerWheelValue", params);
		}
		
	}

	public void ingresarNumDocumento(String numDocumento) {
		try {
		    contador++;
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtNumDocumento)));
			driver.findElement(By.xpath(this.txtNumDocumento)).sendKeys(numDocumento);
		}catch(Exception e) {
		    if(!(contador==5)) {
		    	Utilidades.esperaMiliseg(500);
		    	ingresarNumDocumento(numDocumento);
		    }else {
		    	fail("No se encontró input 'Número de documento' en olvido clave, debido a: " + e.getMessage());
		    }
		}finally {contador=0;}
		
	}

	public void pulsarBotonContinuar() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuar)));
			driver.findElement(By.xpath(this.btnContinuar)).click();
		}catch(Exception e) {
		    if(!(contador==5)) {
		    	Utilidades.esperaMiliseg(500);
		    	pulsarBotonContinuar();
		    }else {
		    	fail("No se encontró botón 'Continuar' en olvido clave al ingresar credenciales, debido a: " + e.getMessage());
		    }
		}finally {contador=0;}
		
	}
	
	public void diligenciarEmailSinLatinia() {
			ingresarCorreoElectronico();
			Utilidades.tomaEvidencia("Ingresar email");
			pulsarBtnContinuarEmail();
	}
	
	public void validarMensajePantallaIngresarClave() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.txtCambiarClaveTitulo)));
		String tituloPantallaClaveNueva = driver.findElement(By.xpath(this.txtCambiarClaveTitulo)).getText();
		Utilidades.tomaEvidencia("valido que la otp ingresada es correcta");
		assertThat(tituloPantallaClaveNueva, containsString("clave de acceso"));
	}

	public void consultarOtpEnLatinia(String numCelular) {
		WebLatiniaPageObject.initDriverLatinia();
		pageLatinia.clicBtnContinuar();
		WebLatiniaPageObject.ingresarEmpresa();
		WebLatiniaPageObject.ingresarUsuario();
		WebLatiniaPageObject.ingresarPassword();
		Utilidades.tomaEvidenciaPantalla("Ingresando credenciales en Latinia");
		pageLatinia.darClickAcceder();
		Utilidades.tomaEvidenciaPantalla("Inicio de sesion en Latinia");
		pageLatinia.darClickBtnFiltroAvanzado();
		Utilidades.tomaEvidenciaPantalla("Entrando a filtro avanzado");
		
		//DAR CLICK A TAB DE MENSAJES
		pageLatinia.darClickTabMensajes();
		Utilidades.tomaEvidenciaPantalla("Entrando a mensajes");
		
		// DAR CLICK A CHECBOX DE DIRECCION DESTINO
		pageLatinia.darClickCheckBoxDireccion();
		
		//ESCRIBIR NUMERO ENCONTRADO EN REDEBAN
		pageLatinia.escribirNumeroCelular(numCelular);
		Utilidades.tomaEvidenciaPantalla("Escribiendo numero de celular encontrado en redeban");
		
		//DAR CLICK A BOTON DE BUSCAR
		pageLatinia.darClickBtnBuscar();
		
		Utilidades.esperaMiliseg(3000);
		
		Utilidades.tomaEvidenciaPantalla("Se aplico el filtro avanzado");
		System.out.println("ya hize el filtro avanzado");
		
		BaseUtil.numeroOTP = pageLatinia.traeOTP(numCelular);
		
		System.out.println("la otp que voy a digitar : " + BaseUtil.numeroOTP);
		
		Utilidades.esperaMiliseg(3000);
		
		//DAR CLICK A BTN DE OPCIONES
		pageLatinia.darClickBtnOpciones();
		
		//CERRAR SESION Y CERRAR CHROME DRIVER
		WebLatiniaPageObject.darClickFinalizarSesion();

	}
	
	public void consultarOtpEnLatiniaDeOlvidoClave(String numCelular) {
		WebLatiniaPageObject.initDriverLatinia();
		//pageLatinia.clicBtnContinuar();
		WebLatiniaPageObject.ingresarEmpresa();
		WebLatiniaPageObject.ingresarUsuario();
		WebLatiniaPageObject.ingresarPassword();
		Utilidades.tomaEvidenciaPantalla("Ingresando credenciales en Latinia");
		pageLatinia.darClickAcceder();
		Utilidades.tomaEvidenciaPantalla("Inicio de sesion en Latinia");
		pageLatinia.darClickBtnFiltroAvanzado();
		Utilidades.tomaEvidenciaPantalla("Entrando a filtro avanzado");
		
		//DAR CLICK A TAB DE MENSAJES
		pageLatinia.darClickTabMensajes();
		Utilidades.tomaEvidenciaPantalla("Entrando a mensajes");
		
		// DAR CLICK A CHECBOX DE DIRECCION DESTINO
		pageLatinia.darClickCheckBoxDireccion();
		
		//ESCRIBIR NUMERO ENCONTRADO EN REDEBAN
		pageLatinia.escribirNumeroCelular(numCelular);
		Utilidades.tomaEvidenciaPantalla("Escribiendo numero de celular encontrado en redeban");
		
		//DAR CLICK A BOTON DE BUSCAR
		pageLatinia.darClickBtnBuscar();
		
		Utilidades.esperaMiliseg(3000);
		
		Utilidades.tomaEvidenciaPantalla("Se aplico el filtro avanzado");
		System.out.println("ya hize el filtro avanzado");
		
		BaseUtil.numeroOTP = pageLatinia.traeOtpOlvidoClave(numCelular);
		
		System.out.println("la otp que voy a digitar : " + BaseUtil.numeroOTP);
		
		Utilidades.esperaMiliseg(3000);
		
		//DAR CLICK A BTN DE OPCIONES
		pageLatinia.darClickBtnOpciones();
		
		//CERRAR SESION Y CERRAR CHROME DRIVER
		WebLatiniaPageObject.darClickFinalizarSesion();

	}
	
	public void ingresarOtpDeLatinia() {
		ingresoOTP(BaseUtil.numeroOTP);
		clicBotonContinuar();
		Utilidades.tomaEvidencia("Se ingresa Otp de latinia");
		pulsarBtnContinuarOTP();
	}
	
	public void diligenciarEmailOtpErronea(String email, String numCelular) {
		ingresarCorreoElectronico();
		Utilidades.tomaEvidencia("Ingresar email");
		pulsarBtnContinuarEmail();
		Utilidades.tomaEvidencia("Ingresando datos para activar DaviPlata");
		cerrarMensaje();
		String numCelularOlvido = capturoNumTelefonoOlvidoClave();
		
		WebLatiniaPageObject.initDriverLatinia();
		pageLatinia.clicBtnContinuar();
		WebLatiniaPageObject.ingresarEmpresa();
		WebLatiniaPageObject.ingresarUsuario();
		WebLatiniaPageObject.ingresarPassword();
		Utilidades.tomaEvidenciaPantalla("Ingresando credenciales en Latinia");
		pageLatinia.darClickAcceder();
		Utilidades.tomaEvidenciaPantalla("Inicio de sesion en Latinia");
		
		//DAR CLICK A BTN FILTRO AVANZADO
		pageLatinia.darClickBtnFiltroAvanzado();
		Utilidades.tomaEvidenciaPantalla("Entrando a filtro avanzado");
		
		//DAR CLICK A TAB DE MENSAJES
		pageLatinia.darClickTabMensajes();
		Utilidades.tomaEvidenciaPantalla("Entrando a mensajes");
		// DAR CLICK A CHECBOX DE DIRECCION DESTINO
		pageLatinia.darClickCheckBoxDireccion();
		//ESCRIBIR NUMERO ENCONTRADO EN REDEBAN
		pageLatinia.escribirNumeroCelular(numCelular);
		Utilidades.tomaEvidenciaPantalla("Escribiendo numero de celular encontrado en redeban");
		//DAR CLICK A BOTON DE BUSCAR
		pageLatinia.darClickBtnBuscar();
		
		Utilidades.esperaMiliseg(3000);
		
		Utilidades.tomaEvidenciaPantalla("Se aplico el filtro avanzado");
		System.out.println("ya hize el filtro avanzado");
		
		String numeroOTP = pageLatinia.traeOTP(numCelularOlvido);
		
		System.out.println("la otp que voy a digitar : " + numeroOTP);
		
		Utilidades.tomaEvidenciaPantalla("la otp encontrada es: " + numeroOTP);
		
		Utilidades.esperaMiliseg(3000);
		//DAR CLICK A BTN DE OPCIONES
		pageLatinia.darClickBtnOpciones();
		
		//CERRAR SESION Y CERRAR CHROME DRIVER
		WebLatiniaPageObject.darClickFinalizarSesion();
		
		ingresoOTP("1234");
		Utilidades.tomaEvidencia("Ingreso otp invalida");
		pulsarBtnContinuarOTP();

	}
	
	public void cerrarMensaje() {
		Utilidades.esperaMiliseg(3000);
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(201, 201)).perform();
		System.out.println("cerre mensaje");
	}
	

	public String capturoNumTelefonoOlvidoClave() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.labelNumTelefoo)));
		String labelNumTelefooo = driver.findElement(By.xpath(this.labelNumTelefoo)).getText();
		
		String labelNumTelefoo = labelNumTelefooo;
		char [] ultimosCuatroDigitos = labelNumTelefoo.toCharArray();
		StringBuilder sb = new StringBuilder();
		sb.append(ultimosCuatroDigitos[6]);
		sb.append(ultimosCuatroDigitos[7]);
		sb.append(ultimosCuatroDigitos[8]);
		sb.append(ultimosCuatroDigitos[9]);
		String str = sb.toString();
		System.out.println(str);
		return str;
	}
	
	public void pulsarBtnContinuarOTP() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarOTP)));
			driver.findElement(By.xpath(this.btnContinuarOTP)).click();
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(500);
				pulsarBtnContinuarOTP();
			}else {
				fail("No se encontró botón 'Continuar' en clave temporal de olvido clave, debido a: " + e.getMessage());
			}
		}finally {contador=0;}
		
	
	}
	
	public void ingresoOTP(String OTP) {
		try {
			contador++;
			int j = 1;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.inputOtp)));
			for (int i = 0; i < 4; i++) {
				driver.findElement(By.xpath("//XCUIElementTypeTextField[" + j + "]")).sendKeys((OTP.substring(i, j)));
				j++;
			}
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(500);
				ingresoOTP(OTP);
			}else {
				fail("No se encontró input de ingreso otp en olvido clave, debido a: "+e.getMessage());
			}
		}finally {contador=0;}
	}
	
	public void ingresarCorreoElectronico() {
		System.out.println("ingresando el correo electronico");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtEmail)));
		driver.findElement(By.xpath(this.txtEmail)).sendKeys(Credenciales.propertiesWebs().getProperty("correo.registro"));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptarTeclado)));
		driver.findElement(By.xpath(this.btnAceptarTeclado)).click();
	}
	
	public void pulsarBtnContinuarEmail() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarEmail)));
		driver.findElement(By.xpath(this.btnContinuarEmail)).click();
	}

	public void ingresarClaveTemporal(String clave) {
		utilidades.darUnTap(202, 347);
		MobileElement txtClaveTemporal = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.txtClaveTemporal)));
		txtClaveTemporal.sendKeys(clave);
		Utilidades.esperaMiliseg(800);
		Utilidades.tomaEvidencia("Ingresar clave temporal");
	}

	public void pulsarbtnContinuarClaveTemporal() {
		utilidades.darUnTap(200, 200);
		utilidades.darUnTap(200, 200);
		Utilidades.esperaMiliseg(2000);
		MobileElement btnContinuarClaveTemporal = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.btnContinuarClaveTemporal)));
		Utilidades.tomaEvidencia("Continuar");
		btnContinuarClaveTemporal.click();
		btnContinuarClaveTemporal.click();
	}

	public void ingresarNuevaClave(String claveNueva) {
		Utilidades.esperaMiliseg(4000);
		System.out.println("ingresando con la clave: " + claveNueva);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtNuevaClave)));
		driver.findElement(By.xpath(this.txtNuevaClave)).sendKeys(claveNueva);
		
		Utilidades.esperaMiliseg(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSiguiente)));
		driver.findElement(By.xpath(this.btnSiguiente)).click();
		Utilidades.tomaEvidencia("Ingresar nueva clave " + claveNueva);
	}
	
	public void ingresarNuevaClaveErronea(String claveNueva) {
		Utilidades.esperaMiliseg(4000);
		
		System.out.println("la Clave correcta es: " + claveNueva);
		
		StringBuilder claveInvertida = new StringBuilder();
		  
        // agrego la clave nueva a la clave invertida
		claveInvertida.append(claveNueva);
  
        // invoco el metodo reverse que invierte un string
		claveInvertida.reverse();
		
		System.out.println("ingresando con la clave: " + claveInvertida);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtNuevaClave)));
		driver.findElement(By.xpath(this.txtNuevaClave)).sendKeys(claveInvertida);
		
		Utilidades.esperaMiliseg(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSiguiente)));
		driver.findElement(By.xpath(this.btnSiguiente)).click();
		Utilidades.tomaEvidencia("Ingresar nueva clave " + claveNueva);
	}

	public void ingresarConfirmarNuevaClave(String claveNueva) {
		Utilidades.esperaMiliseg(2000);
		
		System.out.println("ingresando confirmacion con la clave: " + claveNueva);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtConfirmarNuevaClave)));
		driver.findElement(By.xpath(this.txtConfirmarNuevaClave)).sendKeys(claveNueva);
		
		Utilidades.esperaMiliseg(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptarConfirmarClave)));
		driver.findElement(By.xpath(this.btnAceptarConfirmarClave)).click();
		Utilidades.tomaEvidencia("Confirmar nueva clave " + claveNueva);
	}

	public void ingresarConfirmarNuevaClaveErronea(String claveNueva) {
		Utilidades.esperaMiliseg(2000);
		
		System.out.println("la Clave correcta es: " + claveNueva);
		
		StringBuilder claveInvertida = new StringBuilder();
		  
        // agrego la clave nueva a la clave invertida
		claveInvertida.append(claveNueva);
  
        // invoco el metodo reverse que invierte un string
		claveInvertida.reverse();
  
		
		System.out.println("ingresando confirmacion con la clave: " + claveInvertida);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtConfirmarNuevaClave)));
		driver.findElement(By.xpath(this.txtConfirmarNuevaClave)).sendKeys(claveInvertida);
		
		Utilidades.esperaMiliseg(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptarConfirmarClave)));
		driver.findElement(By.xpath(this.btnAceptarConfirmarClave)).click();
		Utilidades.tomaEvidencia("Confirmar nueva clave " + claveInvertida);
	}
	
	public void pulsarBtnAceptar() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptar)));
		driver.findElement(By.xpath(this.btnAceptar)).click();
	}
	
	public void validarMensajeClaveErronea() {
		System.out.println("validando mensaje de notificacion erronea");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.confirmacionClaveErronea)));
		String txtMensaje = driver.findElement(By.xpath(this.confirmacionClaveErronea)).getText();
		assertThat(txtMensaje, containsString("confirmación no coinciden"));
		Utilidades.tomaEvidencia("mensaje de confirmacion erronea");
	}
	
	public void validarMensajeCambioClave() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.labelNotificacion)));
			String mensajeValidacion = driver.findElement(By.xpath(this.labelNotificacion)).getText();
			assertThat(mensajeValidacion, containsString("Cambio de clave exitoso"));
		} catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(500);
				validarMensajeCambioClave();
			} else {
				fail("No se encontró mensaje de validación de cambio de clave exitoso en olvido clave, debido a: " + e.getMessage());
			}
		} finally {contador=0;}
		
	}
	
	public String obtenerMensajePopUp() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.labelNotificacion)));
		String msj = driver.findElement(By.xpath(this.labelNotificacion)).getText();
		Utilidades.tomaEvidencia("mensaje pop up");
		return msj;
	}
	public void darClickDaviplata() {
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(201, 201)).perform();
		System.out.println("cerre mensaje");
	}
	
	public void validarClaveTemporalErronea() {
		try {
		    contador++;
		    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.mensajeClaveErronea)));
			String msj = driver.findElement(By.xpath(this.mensajeClaveErronea)).getText();
		    assertThat(msj, containsString("LA CLAVE INGRESADA ES INCORRECTA"));	
		} catch(Exception e) {
		    if(!(contador==5)) {
		    	Utilidades.esperaMiliseg(2000);
		    	validarClaveTemporalErronea();
		    } else {
		    	fail("No se encontró mensaje de validación de clave temporal erronea, debido a: " + e.getMessage());
		    }
		} finally {contador=0;}
		
	}
	
	public void clicBotonContinuar() {
		try {
		    contador++;
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarTeclado)));
			driver.findElement(By.xpath(this.btnContinuarTeclado)).click();
		} catch(Exception e) {
		    if(!(contador==5)) {
		    	Utilidades.esperaMiliseg(500);
		    	clicBotonContinuar();
		    } else {
		    	fail("No se encontró botón 'Continuar' del teclado iOS, debido a: " + e.getMessage());
		    }
		} finally {contador=0;}
		
	}
	
	public void seleccionarTipoDocumentoOlvidoClave(String tipoDocumento) {
		switch (tipoDocumento.toUpperCase()) {
	    case "CC":
	    	MobileElement Ciudadania = (MobileElement) wait
			.until(ExpectedConditions.elementToBeClickable(By.xpath(this.DocumentoCC)));
	    	Ciudadania.click();
	        break;
	    case "TI":
	    	MobileElement Identidad = (MobileElement) wait
			.until(ExpectedConditions.elementToBeClickable(By.xpath(this.DocumentoTI)));
	    	Identidad.click();
	        break;
	    case "CE":
	    	MobileElement Extranjeria = (MobileElement) wait
			.until(ExpectedConditions.elementToBeClickable(By.xpath(this.DocumentoCE)));
	    	Extranjeria.click();
	        break;
	        default:
	        	fail("No se encontró coincidencia con algun tipo de documento");
		}
	}
	
	public void ingresarClaveNuevaDeOlvidolave() {
		ingresoOTP(BaseUtil.numeroOTP);
		clicBotonContinuar();
		pulsarBtnContinuarOTP();
	}
	
	public void ingresarClaveNuevaDeOlvidoClave(String claveNueva) {
		try {
			contador++;
			int j = 1;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.inputClaveNuevaOlvidoClave)));
			for (int i = 0; i < 4; i++) {
				driver.findElement(By.xpath("(//XCUIElementTypeSecureTextField[@name='Digite su nueva clave'])[" + j + "]")).sendKeys((claveNueva.substring(i, j)));
				j++;
			}
			System.out.println("Ingresé la nueva clave correctamente");
		} catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(500);
				ingresarClaveNuevaDeOlvidoClave(claveNueva);
			} else {
				fail("No se encontró input de ingreso nueva clave en olvido clave, debido a: "+e.getMessage());
			}
		} finally {contador=0;}
	}
	
	public void ingresarConfirmacionClaveNuevaOlvidoClave(String confirmacionClaveNueva) {
		try {
			contador++;
			int j = 5;
			int k = 1;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.inputClaveNuevaOlvidoClave)));
			for (int i = 0; i < 4; i++) {
				driver.findElement(By.xpath("(//XCUIElementTypeSecureTextField[@name='Digite su nueva clave'])[" + j + "]")).sendKeys((confirmacionClaveNueva.substring(i, k)));
				j++;
				k++;
			}
			System.out.println("Ingresé la confirmación de nueva clave correctamente");
		} catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(500);
				ingresarConfirmacionClaveNuevaOlvidoClave(confirmacionClaveNueva);
			} else {
				fail("No se encontró input de confirmación clave nueva en olvido clave, debido a: "+e.getMessage());
			}
		} finally {contador=0;}
	}
	
	public void clicBotonCrearClave() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCrearClave)));
			driver.findElement(By.xpath(this.btnCrearClave)).click();
		} catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(500);
				clicBotonCrearClave();
			} else {
				fail("No se encontró botón ´Crear Clave' en cree su nueva clave de olvido clave, debido a: " + e.getMessage());
			}
		} finally {contador=0;}
		
	
	}
	
	public void clicBotonFinalizarCambioClave() {
		try {
		    contador++;
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnFinalizarOlvidoClave)));
			driver.findElement(By.xpath(this.btnFinalizarOlvidoClave)).click();
		} catch(Exception e) {
		    if(!(contador==5)) {
		    	Utilidades.esperaMiliseg(500);
		    	clicBotonFinalizarCambioClave();
		    } else {
		    	fail("No se encontró botón 'Finalizar' en validación de cambio de clave exitoso para olvido clave, debido a: " + e.getMessage());
		    }
		} finally {contador=0;}
		
	}
	
	public void clicBotonContinuarTecladoiOSIngresoDocumento() {
		try {
		    contador++;
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarTecladoIos)));
			driver.findElement(By.xpath(this.btnContinuarTecladoIos)).click();
		} catch(Exception e) {
		    if(!(contador==5)) {
		    	Utilidades.esperaMiliseg(500);
		    	clicBotonContinuarTecladoiOSIngresoDocumento();
		    } else {
		    	fail("No se encontró botón 'Continuar' del teclado iOS, debido a: " + e.getMessage());
		    }
		} finally {contador=0;}
	}
}
