package daviplata.nacional.iOS.pageObjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import java.math.BigDecimal;
import java.util.Calendar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import daviplata.nacional.iOS.definitions.Hooks;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import daviplata.nacional.iOS.utilidades.Credenciales;
import daviplata.nacional.iOS.utilidades.CustomChromeDriver;
import daviplata.nacional.iOS.utilidades.Utilidades;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.core.pages.PageObject;

public class NanocreditoPageObjects extends PageObject {
	
	
	private AppiumDriver<MobileElement> driver = Hooks.getDriver();
	private WebDriverWait wait = Hooks.getDriverWait();
	Utilidades utilidad;
	private static CustomChromeDriver confiChromeDriver;
	public static String horaSistema = "";
	private int contador = 0;
	BaseUtil base;
	private String pantallaAurtorizoNano = "//*[@class='android.view.View'][contains(text(),'AUTORIZA')]";
	private String btnAutorizo = "//*[@text='Autorizo']";
	private String btnNoDeseo = "//*[@text='No deseo']";
	private String btnContinuar = "//*[@text='Continuar']";
	private String labelMontoMaximo = "//*[@class='android.view.View'][contains(text(),'Usted puede pedir')]";
	private String inputMonto = "//*[@id='totalIngresos']";
	private String labelDPNoConincide = "//*[@class='android.view.View'][contains(text(),'Su número')]";
	private String btnAceptar = "//*[@text='Aceptar']";
	BigDecimal monto;
	BigDecimal montoSuperior;
	// xpaths fusionadas del proyecto de Diego
	private String selectorDiasPagarCuota = "//*[@class='android.widget.Spinner']";
	private String ciudadResidencia = "//*[@id='ciudad']";
	private String checkAceptarCondiciones = "((//*[@id='app']/*[@class='android.view.View'])[4]/*/*[@class='android.view.View' and ./parent::*[@class='android.view.View']])[2]";
	private String checkAutorizoDebitoAutomatico = "((//*[@id='app']/*[@class='android.view.View'])[5]/*/*[@class='android.view.View' and ./parent::*[@class='android.view.View']])[2]";
	private String iconoEstudioCredito50 = "//*[@text='50% Completo']";
	private String btnAcepto = "//*[@text='Acepto']";
	private String labelCreditoPreaprobado = "//*[@text='¡Felicitaciones! su crédito ha sido preaprobado.']";

	private String checkAceptarFirmarPagare = "(((//*[@class='android.view.View']/*[@class='android.view.View'])[9]/*[@class='android.view.View'])[2]/*/*[@class='android.view.View' and ./parent::*[@class='android.view.View']])[2]";
	private String checkContratoCreditoDaviplata = "(((//*[@class='android.view.View']/*[@class='android.view.View'])[9]/*[@class='android.view.View'])[3]/*/*[@class='android.view.View' and ./parent::*[@class='android.view.View']])[2]";
	private String checkSeguroVida = "(((//*[@class='android.view.View']/*[@class='android.view.View'])[9]/*[@class='android.view.View'])[4]/*/*[@class='android.view.View' and ./parent::*[@class='android.view.View']])[2]";
	private String checkAutorizacionDaviplata = "//*[@class='android.view.View' and ./parent::*[@class='android.view.View' and (./preceding-sibling::* | ./following-sibling::*)[@text='Autorizo a Davivienda a meter la plata del crédito en mi DaviPlata.'] and ./parent::*[@class='android.view.View']]]";
	private String btnfinalizarFirmaAutenticacion = "//*[@text='Continuar']";
	private String txtOTP = "//*[@id='codigoOTP']";
	private String btnEnviarOTP = "//*[@text='Enviar']";
	private String txtOTPNoValida = "//*[contains(text(),'OTP incorrecto')]";
	private String txtNocumplePoliticas = "//*[contains(text(),'no cumple con las pol')]";
	private String btnFinalizar = "//*[@text='Finalizar']";
	private String btnIngresar = "Continuar";
	private String inputNumeroCelular = "/html/body/form/fieldset/div[1]/input";
	private String inputHora = "//*[@id='appt-time']";
	private String btnSubmitNanoCredito = "/html/body/form/fieldset/input";
	private String hola = "(//*[contains(text(), '3124851065')]/following-sibling::td[1])[1]";
	
	public static final String POP_UP_NANOCREDITO = "//XCUIElementTypeStaticText[contains(@value, 'Conozca el Nanocrédito')] | //XCUIElementTypeStaticText[contains(@name, 'Conozca el Nanocrédito')]";
	public static final String BNT_NO_ME_INTERESA = "//XCUIElementTypeStaticText[@name='No me interesa']";
	public static final String BTN_CAJA_NANOCREDITO = "//XCUIElementTypeStaticText[contains(@value, 'Nanocrédito')]";
	
	
	
	public void esperoAQueAparezcaAutorizoNanoCredito() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.pantallaAurtorizoNano)));
			driver.findElement(By.xpath(this.pantallaAurtorizoNano));
			System.out.println("Apareció el autorizo");			
		}catch(Exception e){
			System.out.println("No apareció el autorizo");			
		}
		
	}

	public void darClickAutorizo() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAutorizo)));
		driver.findElement(By.xpath(this.btnAutorizo));

	}

	public void darClickNoDeseo() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnNoDeseo)));
			driver.findElement(By.xpath(this.btnNoDeseo));
			utilidad.esperaMiliseg(500);
			utilidad.tomaEvidencia("Tomar nueva solicitud de credito");
			
		}catch(Exception e) {
			System.out.println("No apareció botón 'No Deseo' ");
			
		}
		
	}

	public void darClickContinuar() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuar)));
		driver.findElement(By.xpath(this.btnContinuar)).click();
	}

	public void obtenerMontoMaximo() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.labelMontoMaximo)));
		String labelMontoMaximo = driver.findElement(By.xpath(this.labelMontoMaximo)).getText();
		System.out.println(labelMontoMaximo);
		String montoMaximo = labelMontoMaximo.split("\\$")[1].replace(".", "");
		System.out.println(montoMaximo);
		monto = new BigDecimal(montoMaximo);

	}

	public String calcularMontoSuperior() {
		this.montoSuperior = monto.add(new BigDecimal("50000"));
		String montoSuperior = String.valueOf(this.montoSuperior);
		return montoSuperior;
	}

	public void ingresarMonto(String monto) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputMonto)));
		MobileElement inputMonto = driver.findElement(By.xpath(this.inputMonto));
		inputMonto.clear();
		System.out.println("Limpie campo");
		inputMonto.sendKeys(monto);
	}

	public void ingresarMontoAleatorio() {
		int montoAleatorio = (int) ((Math.random() * (monto.intValue() - 50000)) + 50000);
		System.out.println("Monto aleatorio: " + montoAleatorio);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputMonto)));
		MobileElement inputMonto = driver.findElement(By.xpath(this.inputMonto));
		inputMonto.clear();
		System.out.println("Limpie campo");
		inputMonto.sendKeys(String.valueOf(montoAleatorio));
	}

	public void escogerFechaInicialPago() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.selectorDiasPagarCuota)));
		driver.findElement(By.xpath(this.selectorDiasPagarCuota)).click();
	}

	public void seleccionarDiaDePago() {
		String fechaInicio = "//*[@class='android.widget.CheckedTextView'][";
		int dia = (int) ((Math.random() * 7) + 1);
		System.out.println("El dia escogido al azar es: " + dia);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(fechaInicio + dia + "]")));
		driver.findElement(By.xpath(fechaInicio + dia + "]")).click();

	}

	public void ingresarCiudadResidencia() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.ciudadResidencia)));
		MobileElement inputCiudad = driver.findElement(By.xpath(this.ciudadResidencia));
		
		String[] ciudades = { "Bogota", "Cali", "Medellin", "Cartagena" };
		int eleccion = (int) ((Math.random() * ciudades.length));
		inputCiudad.sendKeys(ciudades[eleccion]);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ngb-typeahead-0-0']")));
		driver.findElement(By.xpath("//*[@id='ngb-typeahead-0-0']")).click();
	}

	public void darClickAceptarCondiciones() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.checkAceptarCondiciones)));
		driver.findElement(By.xpath(this.checkAceptarCondiciones));
	}

	public void darClickAutorizoDebitoAutomatico() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.checkAutorizoDebitoAutomatico)));
		driver.findElement(By.xpath(this.checkAutorizoDebitoAutomatico));
	}

	public void darClickAceptoInformacion() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAcepto)));
		driver.findElement(By.xpath(this.btnAcepto));
	}

	public void esperarIconoEstudioCredito50() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.iconoEstudioCredito50)));
		driver.findElement(By.xpath(this.iconoEstudioCredito50));
	}

	public void darClickContinuarEstudioCredito() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuar)));
		driver.findElement(By.xpath(this.btnContinuar));
	}

	public void esperarConfirmacionPreaprobacionNanoCredito() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.labelCreditoPreaprobado)));
		driver.findElement(By.xpath(this.labelCreditoPreaprobado)).getText();
		utilidad.esperaMiliseg(3000);
	}

	public void darClickAceptarFirmarPagare() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.checkAceptarFirmarPagare)));
		driver.findElement(By.xpath(this.checkAceptarFirmarPagare)).click();
	}

	public void darClickContratoCreditoDaviplata() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.checkContratoCreditoDaviplata)));
		driver.findElement(By.xpath(this.checkContratoCreditoDaviplata)).click();
	}

	public void darClickSeguroVida() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.checkSeguroVida)));
		driver.findElement(By.xpath(this.checkSeguroVida)).click();
	}

	public void darClickAutorizacionDaviplata() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.checkAutorizacionDaviplata)));
		driver.findElement(By.xpath(this.checkAutorizacionDaviplata)).click();
	}

	public void darClickFinalizarFirmaAutenticacion() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnfinalizarFirmaAutenticacion)));
		driver.findElement(By.xpath(this.btnfinalizarFirmaAutenticacion)).click();
	}

	public void ingresarOTPNoValida() {
		String eleccion = "";
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtOTP)));
		MobileElement btnOTPInvalida = driver.findElement(By.xpath(this.txtOTP));
		for (int contador = 0; contador < 6; contador++)
			eleccion += String.valueOf((int) ((Math.random() * 9)));
		btnOTPInvalida.sendKeys(eleccion);
	}

	public void darClickAceptarOTP() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnEnviarOTP)));
		driver.findElement(By.xpath(this.btnEnviarOTP)).click();
	}

	public void darClickNotificacionOTPInvalida() {
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(360, 682)).perform();
		System.out.println("Di el click");
	}

	public void darClickFinalizar() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnFinalizar)));
		driver.findElement(By.xpath(this.btnFinalizar)).click();
	}

	public void validoNegacionDelCreditoOTPInvalida() {
		boolean validacion = false;
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtOTPNoValida)));
		String texto = driver.findElement(By.xpath(this.txtOTPNoValida)).getText();
		utilidad.tomaEvidencia("Se valida mensaje de negacion de nanocredito por OTP incorrecto");
		this.darClickFinalizar();
		if (texto.contains("OTP incorrecto"))
			validacion = true;
		assertTrue(validacion);
	}

	public void validoNegacionDelCredito() {
		boolean validacion = false;
		if (monto.equals(montoSuperior)) {
			validacion = false;
		} else {
			validacion = true;
		}
		assertTrue(validacion);
	}

	public void validoNegacionDelCreditoNoCumploPoliticas() {
		boolean validacion = false;
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtNocumplePoliticas)));
		String texto = driver.findElement(By.xpath(this.txtNocumplePoliticas)).getText();
		utilidad.tomaEvidencia("Se valida mensaje de negacion de nanocredito por no cumplir politicas");
		this.darClickFinalizar();
		if (texto.contains("no cumple con las políticas"))
			validacion = true;
		assertTrue(validacion);

	}

	public void validoDaviplataNoConcuerde() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.labelDPNoConincide)));
		String textoDeNoConcuerda = driver.findElement(By.xpath(this.labelDPNoConincide)).getText();
		assertEquals(
				"Su número de Daviplata no coincide con el de la campaña, lo invitamos a actualizar a sus datos a través de nuestros canales de atención.",
				textoDeNoConcuerda);
	}

	public void darClickEnAceptar() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptar)));
		driver.findElement(By.xpath(this.btnAceptar)).click();
	}
	
	public void abrirConsultaNotificaciones() {
		confiChromeDriver.iniciarChromeDriver();
		System.out.println("paso");
		BaseUtil.chromeDriver.get(Credenciales.propertiesWebs().getProperty("web.notificaciones.url"));
		wait = new WebDriverWait(BaseUtil.chromeDriver, 20);
	}
	
	public void sendKeysInputNumeroCelular(String numeroCelularDaviplata) {		
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputNumeroCelular)));
		element.sendKeys(numeroCelularDaviplata);
	}
	
	public void sendKeysInputHora() {		
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputHora)));
		element.clear();
		element.sendKeys(horaSistema);
	}
	
	public void clicBtnSubmitNotificacionesNano() {		
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSubmitNanoCredito)));
		element.click();
	}
	
	public void capturarOtpCVVNotificaciones() {
		String horaSistemaSubstring = "";
		try {
			contador++;
			utilidad.cambiarFocoNuevaVentanaAbierta();
			Calendar calendar = Calendar.getInstance();
			int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
			if(hourOfDay>= 0 && hourOfDay<10){
				horaSistemaSubstring = horaSistema.substring(1,5);
			}else {
				horaSistemaSubstring = horaSistema.substring(0,5);
			}			
			String xpathOtp = "(//*[contains(text(), '"+horaSistemaSubstring+"')]/following-sibling::td[2])[1]";
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathOtp)));
			assertThat(element.getText(), containsString("El codigo de seguridad"));
			String codigoCVV = element.getText().substring(46);
			System.out.println("El código CVV es: " + codigoCVV);			
		}catch(Exception e) {
			if(!(contador == 10)) {
				utilidad.esperaMiliseg(2000);
				capturarOtpCVVNotificaciones();
			}else {
				fail("No se encontró Otp CVV de la ecard, debido a: " + e.getMessage());
			}
		}finally {contador=0;}

	}
	
	public void cerrarWebNotificacionesNanoCredito() {
		try {
			confiChromeDriver.cerrarChromeDriver();
		} catch (Exception e) {
			System.out.println("No cerró ChromeDriver debido a: " + e.getMessage());
		}

	}

	public void cerrarWebNotificaciones() {
		try {
			confiChromeDriver.cerrarChromeDriver();
		} catch (Exception e) {
			System.out.println("No cerró ChromeDriver debido a: " + e.getMessage());
		}

	}
	
	public void ingresarContrasena(String contrasena) {
		utilidad.esperaMiliseg(4000);
		TouchAction touchAction = new TouchAction(BaseUtil.driver);
		touchAction.tap(new PointOption().withCoordinates(100, 368)).perform();
		utilidad.esperaMiliseg(1000);
		int j = 1;
		int k = 0;
		for (int i = 0; i < 4; i++) {
			utilidad.esperaMiliseg(1000);
			base.driver.findElement(By.xpath("//XCUIElementTypeSecureTextField[" + j + "]"))
					.sendKeys((contrasena.substring(i, j)));
			j++;
		}
		System.out.println("Ingrese la contraseña correctamente");
	}
	
	public void darClicBotonIngresar() {
		try {
			base.driver.findElement(By.name(this.btnIngresar)).click();
		} catch (Exception e) {
			System.out.println("no di clikc a name ingresar");
		}
	}
	
	//// *[@text='Su número de Daviplata no coincide con el de la campaña, lo
	//// invitamos a actualizar a sus datos a través de nuestros canales de
	//// atención.']
}
