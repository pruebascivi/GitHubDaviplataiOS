package daviplata.nacional.iOS.pageObjects;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.hamcrest.Matchers.anyOf;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import daviplata.nacional.iOS.definitions.Hooks;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import daviplata.nacional.iOS.utilidades.Utilidades;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import net.serenitybdd.core.pages.PageObject;

public class EcardPageObject extends PageObject {

	
	private AppiumDriver<MobileElement> driver = Hooks.getDriver();
	private WebDriverWait wait = Hooks.getDriverWait();
	Utilidades utilidad;
	Utilidades Utilidades;
	BaseUtil base;
	
	private int contador = 0;
	private String txtClienteSinTarjeta = "//XCUIElementTypeStaticText[@name='¿No tiene tarjeta para hacer compras por internet? ']";
	private String btnContinuar = "(//*[contains(@name, 'Continuar')])[1]";
	private String checkTyC = "com.davivienda.daviplataapp.lab:id/checkBox";
	private String btnCrear = "//XCUIElementTypeButton[@name='Crear botón habilitado']";
	private String txtTarjetaCreada = "//*[contains(@text,'No le alcanza la plata')]";
	private String txtTarjetaCreada2 = "//XCUIElementTypeStaticText[@name='Su Tarjeta virtual DaviPlata se ha creado.']";
	private String btnCerrar = "//XCUIElementTypeButton[@name='Ir a la Tarjeta virtual']";
	private String popupCerrar = "//XCUIElementTypeButton[@name='Close']";
//	private String btnRecargar = "//*[contains(text(),'RecargarTarjeta')]";
	private String btnRecargar = "com.davivienda.daviplataapp.lab:id/ds_action_button";
	//private String btnRecargarEcardHome = "com.davivienda.daviplataapp.lab:id/buttonRecarga";
	private String btnRecargarEcardHome = "//XCUIElementTypeButton[@name='Recargar tarjeta para comprar por internet']";
	private String cerrarAlert = "com.davivienda.daviplataapp.lab:id/notif_ico";
	private String selectMonto = "//*[@class='android.widget.CheckBox'][#]";
	private String inputMonto = "com.davivienda.daviplataapp.lab:id/editTextValue";
	private String btnAceptar = "(//XCUIElementTypeStaticText[@name='Aceptar'])[2]";
	private String resultadosTransaccion = "//*[@class='android.widget.TextView']";
	private String txtValorTransado = "(//*[contains(@name, 'Cuanta plata recargo')])";
	private String txtCostoComision = "(//*[contains(@name, 'Cobro comisión de la recarga')])";
	private String btnVolverHome = "//XCUIElementTypeButton[@name='Regresar a pantalla inicio sesión botón']";
	private String txtRecargaNegada = "//*[@id='notif_text_rappi']";
	private String btnImagenTarjeta = "(//XCUIElementTypeOther[1]/XCUIElementTypeButton)[1]";
	private String txtNumeroTarjeta = "(//*[contains(@name, 'Numero de su tarjeta')])";
	private String txtNombreTarjeta = "(//*[contains(@name, 'Nombre')])[2]";
	private String txtFechaExpiraTarjeta = "(//*[contains(@name, 'Fecha de vencimiento tarjeta')])";
	private String btnVerDatosTarjeta = "//XCUIElementTypeButton[@name='Ir a ver datos Tarjeta virtual']";
	private String lblAceptar = "com.davivienda.daviplataapp.lab:id/ds_action_button";
	private String btnMovimientos = "//XCUIElementTypeButton[@name='Ir a movimiento']";
	private String listDateMovimientos = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[";
	private String btnBloquearTarjeta = "//XCUIElementTypeButton[@name='Ir a Bloquear tarjeta']";
	private String btnAceptarPopUp = "//XCUIElementTypeButton[@name='Bloquear']";
	private String btnFinalizar = "//XCUIElementTypeButton[@name='Finalizar']";
	private String btnCheckBoxValorRecarga = "com.davivienda.daviplataapp.lab:id/check1";
	private String txtValorRecarga = "com.davivienda.daviplataapp.lab:id/editTextValue";
	private String txtRecargaExitosa = "//XCUIElementTypeStaticText[@name='Recarga exitosa']";
	private String txtSeleccionarRecarga = "com.davivienda.daviplataapp.lab:id/check1";
	private String txtMensajeBloqueo = "com.davivienda.daviplataapp.lab:id/TvPopupMessage";
	private String btnClose = "com.davivienda.daviplataapp.lab:id/IvPopupClose";
	public static final String txtRestringida = "//XCUIElementTypeImage[@name='notif_bkg']//following-sibling::XCUIElementTypeStaticText";
	private String txtValorRestringido = "(//XCUIElementTypeStaticText)[8]";
	private String btnTarjetaVirtualMh = "(//XCUIElementTypeButton[@name='Button'])[1]";
	private String btnTerminosYCondiciones = "com.davivienda.daviplataapp.lab:id/text2";
	private String txtCondiciones = "//*[@text='CONDICIONES DE USO TARJETA VIRTUAL ECARD DAVIPLATA']";
	private String btnTerminos = "//XCUIElementTypeButton[@name='No marcado casilla verificacion Aceptación Términos y Condiciones']";
	private String btnBloquear = "//*[@text='Bloquear']";
	private String txtAutorizacion = "com.davivienda.daviplataapp.lab:id/num_aut";
	private String txtFechaHora = "(//*[contains(@name, 'Fecha y hora')])";
	private String inputMontoEcard = "com.davivienda.daviplataapp.lab:id/editTextValue";
	private String btnAbrirProductos = "com.davivienda.daviplataapp.lab:id/llOpenProducts";
	private String btnUsarPlata = "(//*[@value='Usar Plata'])[1]";
	private String btnTarjetaVirtual = "//XCUIElementTypeStaticText[@name='Tarjeta virtual']";
	private String checkBoxRecargaEcard = "//XCUIElementTypeButton[@name='No marcado 50 mil pesos casilla de verificación']";
	private String mensajeSaldoInsuficienteEcard = "//XCUIElementTypeStaticText[@name='No le alcanza la plata para hacer la recarga.']";
	private String mensajeCupoSuperadoEcard = "(//XCUIElementTypeStaticText)[8]";
	private String saldoEcard = "(//*[contains(@name, 'tengo en mi Tarjeta')])";
	
	/*private String checkboxCincuentaMil = "com.davivienda.daviplataapp.lab:id/check1";
	private String checkboxDiezMil = "com.davivienda.daviplataapp.lab:id/check2";
	private String checkboxTrecientosMil = "com.davivienda.daviplataapp.lab:id/check3";
	private String checkboxQuinientosMil = "com.davivienda.daviplataapp.lab:id/check4";
	private String montoDiferente = "com.davivienda.daviplataapp.lab:id/editTextValue";*/
	
	private String checkboxCincuentaMil = "//XCUIElementTypeButton[@name='No marcado 50 mil pesos casilla de verificación']";
	private String checkboxDiezMil = "//XCUIElementTypeButton[@name='No marcado 100 mil pesos casilla de verificación']";
	private String checkboxTrecientosMil = "//XCUIElementTypeButton[@name='No marcado 300 mil pesos casilla de verificación']";
	private String checkboxQuinientosMil = "//XCUIElementTypeButton[@name='No marcado 500 mil pesos casilla de verificación']";
	private String montoDiferente = "//XCUIElementTypeTextField[@name='Editar casilla ingrese otro valor']";

	private String btnAceptarPopUpEcard = "//*[@name='Aceptar']";
	private String btnRegresarEcard = "//*[contains(@name, 'Regresar')]";
	public static final String MENSAJE_TOPES_TARJETA_VIRTUAL = "//XCUIElementTypeStaticText[contains(@name,'Valor invalido')]";
	public static final String TEXTO_TARJETA_VIRTUAL_MODULO = "//XCUIElementTypeStaticText[@name='Tarjeta virtual']";	
	public static final String BOTON_TARJETA_VIRTUAL = "//XCUIElementTypeOther[@name='Mi tarjeta virtual 0,00']";
	public static final String BOTON_TIENDA_VIRTUAL = "(//XCUIElementTypeOther[@name='Tienda Virtual'])[1]";
	public static final String TEXTO_TIENDA_VIRTUAL_MODULO = "//XCUIElementTypeStaticText[@name='Tienda virtual'] | //XCUIElementTypeStaticText[@name='Tienda Virtual']";

	public void verificoVisualizacionTextoElClienteNoTieneEcard() {
		try {
		    contador++;
			driver.findElement(By.xpath(this.txtClienteSinTarjeta));
		    System.out.println("verficandp que el cliente no tiene tarjeta");
		}catch(Exception e) {
		    if(!(contador==5)) {
		    	utilidad.esperaMiliseg(500);
			    verificoQueElClienteNoTengaEcard();
		    }else {
		    	fail("No se encontró texto '¿No tiene tarjeta para hacer compras por internet?' en creación de tarjeta crédito, debido a: " + e.getMessage());
		    }
		}finally {contador=0;}
		
	}
	
	public void verificoQueElClienteNoTengaEcard() {
		try {
		    contador++;
			String txtClienteSinTarjeta = driver.findElement(By.xpath(this.txtClienteSinTarjeta)).getText();
		    System.out.println("verifique que el cliente no tiene tarjetas");
			assertThat(txtClienteSinTarjeta, containsString("¿No tiene tarjeta"));		
		}catch(Exception e) {
		    if(!(contador==5)) {
		    	utilidad.esperaMiliseg(500);
			    verificoQueElClienteNoTengaEcard();
		    }else {
		    	fail("No se encontró texto '¿No tiene tarjeta para hacer compras por internet?' en creación de tarjeta crédito, debido a: " + e.getMessage());
		    }
		}finally {contador=0;}
		
	}

	public void doyClickEnContinuar() {
		try {
			contador ++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuar)));
			driver.findElement(By.xpath(this.btnContinuar)).click();
			System.out.println("di click en btn continuar");
		}catch (Exception e) {
			if(!(contador==3)) {Utilidades.esperaMiliseg(500); doyClickEnContinuar();
			}else {fail("No se pudo dar clic en boton Continuar pantalla Recargar debido a: " + e.getMessage());}
		}finally {contador = 0;}
	}


	public void btnBloquear() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnBloquear)));
		driver.findElement(By.xpath(this.btnBloquear)).click();
	}

	public void aceptoTerminosYCondiciones() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnTerminosYCondiciones)));
		driver.findElement(By.xpath(this.btnTerminosYCondiciones)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnTerminosYCondiciones)));
		String txtCondiciones = driver.findElement(By.xpath(this.btnTerminosYCondiciones)).getText();
		
		assertTrue(txtCondiciones.contains("CONDICIONES DE USO TARJETA VIRTUAL ECARD DAVIPLATA"));
	}

	public void aceptoTerminos() {
		BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(this.btnTerminos)).click();
	}


	public void doyClickEnCrear() {
		try {
		    contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCrear)));
			driver.findElement(By.xpath(this.btnCrear)).click();
			System.out.println("di click en btn crear");
		}catch(Exception e) {
		    if(!(contador==5)) {
		    	utilidad.esperaMiliseg(2000);
		    	doyClickEnCrear();
		    }else {
		    	fail("No se encontró botón 'Continuar' en recarga de tarjeta crédito, debido a: " + e.getMessage());
		    }
		}finally {contador=0;}
		
	}
	
	public void validoAparicionMensajeTarjetaCreada() {
		try {
		    contador++;
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.txtTarjetaCreada2)));
			driver.findElement(By.xpath(this.txtTarjetaCreada2));
		}catch(Exception e) {
		    if(!(contador==3)) {
		    	utilidad.esperaMiliseg(500);
		    	validoAparicionMensajeTarjetaCreada();
		    }else {
		    	fail("No se encontró mensaje de validación en creación de la tarjeta de crédito, debido a: " + e.getMessage());
		    }
		}finally {contador=0;}
		
	}



	public void validoCreacion() {
		try {
		    contador++;
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtTarjetaCreada2)));
			String txtTarjetaCreada = driver.findElement(By.xpath(this.txtTarjetaCreada2)).getText();
		    assertThat(txtTarjetaCreada, containsString("Su Tarjeta virtual DaviPlata"));
		}catch(Exception e) {
		    if(!(contador==5)) {
		    	utilidad.esperaMiliseg(500);
		    	validoCreacion();
		    }else {
		    	fail("No se encontró mensaje de validación en creación de la tarjeta de crédito, debido a: " + e.getMessage());
		    }
		}finally {contador=0;}
		
	}

	
	public void clicTarjetaVirtual() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnTarjetaVirtualMh)));
		driver.findElement(By.xpath(this.btnTarjetaVirtualMh)).click();
	}
	
	
	public void clickUsarPlata() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnUsarPlata)));
			driver.findElement(By.xpath(this.btnUsarPlata)).click();
			System.out.println("di click al btn de usar plata");
		}catch(Exception e) {
			if(!(contador==5)) {
				utilidad.esperaMiliseg(2000);
				clickUsarPlata();
			}else {
				fail("No se pudo dar click a btn usar plata debido debido a: " + e.getMessage());
			}
		}finally {contador=0;}
		
	}

		
	public void validoRecargaRestringida() {
		BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.txtRestringida)));
			String txtRestringida = driver.findElement(By.xpath(this.txtRestringida)).getText();
			assertThat(txtRestringida, anyOf(containsString("tarjeta con aviso de extravio"), containsString("transaccion con problemas")));
		}catch(Exception e) {
			fail("No se encontró mensaje de recarga restringida");
		}
		
	}
	
	public void validoRecargaTopeRestringido() {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.txtValorRestringido)));
			String txtRestringidaTope = driver.findElement(By.xpath(this.txtValorRestringido)).getText();
			assertThat(txtRestringidaTope,containsString("Valor invalido"));
		}catch(Exception e) {
			if(!(contador==5)) {
				utilidad.esperaMiliseg(2000);
				validoRecargaTopeRestringido();
			}else {
				fail("No se pudo encontrar mensaje de tope en recarga de tarjeta virtual debido a: " + e.getMessage());
			}
		}finally {contador=0;}
		
	}

	public void validoMensajeBloqueoSegundaVez() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id(this.txtMensajeBloqueo)));
		String txtMensajeBloqueo = driver.findElement(By.id(this.txtMensajeBloqueo)).getText();
		
		boolean validacion = txtMensajeBloqueo.contains("Recuerde que solo puede");
		assertTrue(validacion);
	}

	public void btnClose() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id(this.btnClose)));
		driver.findElement(By.id(this.btnClose)).click();
	}

	public void doyClickEnCerrar() {
		try {
		    contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCerrar)));
			driver.findElement(By.xpath(this.btnCerrar)).click();
		}catch(Exception e) {
		    if(!(contador==5)) {
		    	utilidad.esperaMiliseg(500);
		    	doyClickEnCerrar();
		    }else {
			fail("No se encontro botón 'Cerrar' popUp tarjeta creada, debido a: " + e.getMessage());
		    }
		}finally {contador=0;}
		
	}


	public void doyClickEnRecargar() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnRecargar)));
			driver.findElement(By.xpath(this.btnRecargar)).click();
		}catch(Exception e) {
			if(!(contador==5)) {
				utilidad.esperaMiliseg(2000);
				doyClickEnRecargar();
			}else {
				fail("No se encontró boton aceptar popUp de recarga en tarjeta virtual debido a: " + e.getMessage());
			}
		}finally {contador=0;}
	}

	public void doyClickMSGTarjetaBloqueada() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id(this.txtRestringida)));
		MobileElement txtRestringida = driver.findElement(By.id(this.txtRestringida));
		assertTrue(txtRestringida.getText().contains("Tarjeta crédito bloqueada"));
		txtRestringida.click();
	}
	
	public void doyClickEnRecargarEcardHome() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnRecargarEcardHome)));
			driver.findElement(By.xpath(this.btnRecargarEcardHome)).click();	
			System.out.println("di click a recargar tarjeta");
		}catch(Exception e) {
			if(!(contador==5)) {
				utilidad.esperaMiliseg(2000);
				doyClickEnRecargarEcardHome();
			}else {
				fail("No se encontró botón recargar tarjeta debido a: " + e.getMessage());
			}
		}finally {contador=0;}
	}
	
	public void cerrarPopup() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.popupCerrar)));
			driver.findElement(By.xpath(this.popupCerrar)).click();	
			System.out.println("di click a btn cerrar popup");
		}catch(Exception e) {
			if(!(contador==2)) {
				utilidad.esperaMiliseg(1000);
				cerrarPopup();
			}else {
				System.out.println("No se encontró botón de cerrar popup: " + e.getMessage());
			}
		}finally {contador=0;}
	}
	
	public void cerrarAlertEcard() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id(this.cerrarAlert)));
		driver.findElement(By.id(this.cerrarAlert)).click();	
	}

	public void ingresarOSeleccionarValor(String montoSeleccionable) {
		wait.until(ExpectedConditions.elementToBeClickable(By.id(this.btnCheckBoxValorRecarga)));
		MobileElement btnCheckBoxValorRecarga = driver.findElement(By.id(this.btnCheckBoxValorRecarga));
		btnCheckBoxValorRecarga.click();
		base.montoTransado = new BigDecimal(btnCheckBoxValorRecarga.getText().replace("$", "").replace(".", "").trim());

	}

	public void ingresarValorRecarga(String montoSeleccionable) {

		if (montoSeleccionable.contains("si")) {
			wait.until(ExpectedConditions.elementToBeClickable(By.id(this.txtSeleccionarRecarga)));
			driver.findElement(By.id(this.txtSeleccionarRecarga)).click();	
			base.montoTransado = new BigDecimal(50000);
			base.monto = "50000";
			
			
		} else {
			wait.until(ExpectedConditions.elementToBeClickable(By.id(this.txtValorRecarga)));
			driver.findElement(By.id(this.txtValorRecarga)).sendKeys("5000");	
			base.montoTransado = new BigDecimal(5000);
			base.monto = "5000";
		}

	}
	
	public void montoDiferenteEcard(String monto) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(this.inputMontoEcard)));
		driver.findElement(By.id(this.inputMontoEcard)).sendKeys(monto);	
		base.montoTransado = new BigDecimal(5000);
			
	}

	public void seleccionarMonto() {
		this.selectMonto = this.selectMonto.replace("#", utilidad.numAleatorio(4, 1));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.selectMonto)));
		MobileElement selectMonto = driver.findElement(By.xpath(this.selectMonto));
		
		System.out.println(selectMonto.getText());
		base.montoTransado = new BigDecimal(selectMonto.getText().replace("$", "").replace(".", "").trim());
		selectMonto.click();
		utilidad.tomaEvidencia("Monto seleccionado");
		utilidad.esperaMiliseg(500);
	}

	public void ingresarMonto() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputMonto)));
		MobileElement inputMonto = driver.findElement(By.xpath(this.inputMonto));
		
		String valorAConsignar = Utilidades.generarMontoTransaccional();
		base.montoTransado = new BigDecimal(valorAConsignar);
		inputMonto.sendKeys(valorAConsignar);
		utilidad.tomaEvidencia("Monto a recargar");
		utilidad.esperaMiliseg(500);
	}

	public void ingresarMonto(String monto) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputMonto)));
		driver.findElement(By.xpath(this.inputMonto)).sendKeys(monto);
		
		utilidad.tomaEvidencia("Monto a recargar");
		utilidad.esperaMiliseg(500);
	}

	public void doyClickEnAceptar() {
		BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("di click en btn aceptar");
		driver.findElement(By.xpath(this.btnAceptar)).click();
	}

	public List<MobileElement> capturaResultadoTransaccion() {
		utilidad.esperaMiliseg(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuar)));
		driver.findElement(By.xpath(this.btnContinuar)).click();
		try {
			//pulsarAceptar();
		}catch(Exception e) {
			System.out.println("No salio mensaje de costo de recarga");
		}
		List<MobileElement> listaElementos = base.driver.findElements(By.xpath(resultadosTransaccion));
		return listaElementos;
	}

	public void verificoResultadoTransaccion(List<MobileElement> listaElementos) {
		String textoValidacion = "";
		for (MobileElement mobileElement : listaElementos) {
			if (mobileElement.getText().contains("Recarga Exitosa")) {
				textoValidacion = "Recarga Exitosa";
				break;
			} else
				textoValidacion = "No se encuentra 'Recarga Exitosa'";
		}
		assertEquals("Recarga Exitosa", textoValidacion);
	}
	
	public void verificoTransaccionExitosa() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtRecargaExitosa)));
		boolean isDisplayed = driver.findElement(By.xpath(this.txtRecargaExitosa)).isDisplayed();
		
		assertTrue(isDisplayed);
	}

	public void verificoValoresDeLaTransaccion() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtValorTransado)));
		String txtValorTransado = driver.findElement(By.xpath(this.txtValorTransado)).getText();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtCostoComision)));
		String txtCostoComision = driver.findElement(By.xpath(this.txtCostoComision)).getText();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtFechaHora)));
		String txtFechaHoraApp = driver.findElement(By.xpath(this.txtFechaHora)).getText();
		
		String fechaHora = txtFechaHoraApp.substring(30, 49).replace(" ", "");
		System.out.println("Fecha y hora: "+ fechaHora);
		base.fechaHora = fechaHora;
		
		String valorTransado = txtValorTransado
											.replace("$","")
											.replace(",","")
											.replace("¿","")
											.replace("?","")
											.replace(".","")
											.replace("Cuánta plata recargó", "")
											.replace("Cuanta plata recargo", "")
											.replace("pesos", "")
											.replace(" ","")
											.replaceAll("\\s+","");
		
		BigDecimal valorTransadoActual = new BigDecimal(valorTransado.substring(1));
	
		System.out.println("El valor transado es:" + valorTransadoActual);
		
		base.monto = valorTransadoActual.toString();
		String costoComision = txtCostoComision.replace("$", "")
														.replace("Cobro comisión de la recarga", "")
														.replace("pesos","")
														.replace(" ", "").trim();
		
		
		BigDecimal costoComisionActual = new BigDecimal(costoComision.substring(1));
		System.out.println("El valor de comision es:" + costoComisionActual);
		System.out.println(base.montoTransado + " base Monto Translado");
		
		System.out.println(base.montoTransado.getClass().getSimpleName());
		System.out.println(valorTransadoActual.getClass().getSimpleName());
		
		System.out.println(base.montoTransado);
		System.out.println(valorTransadoActual);
		
		assertEquals(base.montoTransado, valorTransadoActual); 
		base.comision = costoComisionActual;

	}
	
	public void txtAutorizadorBolsillo() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id(this.txtAutorizacion)));
		String auto = driver.findElement(By.id(this.txtAutorizacion)).getText();
		
		System.out.println("Autorizador " + auto);
		if (auto.length() == 6) {
			base.Autorizador = auto;
			base.idTransaccion = auto;
		} else {
			quitarCerosIzquierda(auto);
		}

	}
	
	public void quitarCerosIzquierda(String numero) {
		long p = Long.parseLong(numero);
		base.Autorizador = Long.toString(p);
		base.idTransaccion = Long.toString(p);
	}

	public void doyClickEnVolver() {
		try {
		    contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnVolverHome)));
			driver.findElement(By.xpath(this.btnVolverHome)).click();
		}catch(Exception e) {
		    if(!(contador==5)) {
		    	utilidad.esperaMiliseg(500);
		    	doyClickEnVolver();
		    }else {
		    	fail("No se encontró botón 'Volver' en la tarjeta creada, debido a: " + e.getMessage());
		    }
		}finally {contador=0;}
		
	}


	public void validoSaldoNuevoSaldoDeRecarga(BigDecimal saldoInicialTarjeta, BigDecimal saldoFinalTarjeta) {
		BigDecimal subSaldo;
		System.out.println("Inicial" + base.saldoInicialTarjeta);
		System.out.println("Final" + saldoFinalTarjeta);
		subSaldo = base.montoTransado;
		System.out.println(subSaldo);
//		subSaldo = saldoFinalTarjeta.subtract(saldoInicialTarjeta);
		// String montoTransado = String.valueOf(base.montoTransado);
		// String subSaldoString = String.valueOf(subSaldo).split("\\.")[0];
	//	assertEquals(subSaldo+".00", saldoFinalTarjeta);
	}
	
	public void validacionDeSaldos() {
		
		System.out.println("Entre a validar saldos");
		System.out.println(base.saldo);
		System.out.println(base.montoTransado);
		System.out.println(base.comision);
		System.out.println(base.saldoFinal);

		BigDecimal subSaldo = base.saldo.subtract(base.montoTransado);
		subSaldo = subSaldo.subtract(base.comision);
		String saldoFinal = String.valueOf(base.saldoFinal).split("\\.")[0];
		String subSaldoString = String.valueOf(subSaldo).split("\\.")[0];
		
		System.out.println(saldoFinal);
		System.out.println(subSaldoString);
		
		assertEquals(saldoFinal, subSaldoString);

	}

	public void validoRecargaNegada() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtRecargaNegada)));
		String txtRecargaNegada = driver.findElement(By.xpath(this.txtRecargaNegada)).getText();
		
		System.out.println("Texto informativo: " + txtRecargaNegada);
		boolean banderaValidadora = false;
		if (txtRecargaNegada.contains("VALOR INVALIDO")) {
			banderaValidadora = true;
		}

		assertTrue(banderaValidadora);
	}

	public void validoLblNoAlcanzaPlata() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtTarjetaCreada)));
		String lblExcedeCupo = driver.findElement(By.xpath(this.txtTarjetaCreada)).getText();
		
		assertEquals("No le alcanza la plata para hacer la recarga", lblExcedeCupo);
		utilidad.tomaEvidencia("Valido mensaje de no alcanza la plata");
		base.montoTransado = new BigDecimal(0);
		pulsarAceptar();
	}

	public void pulsarAceptar() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.lblAceptar)));
		driver.findElement(By.xpath(this.lblAceptar)).click();
	}

	public void pulsarBtnImagenTarjeta() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnImagenTarjeta)));
		driver.findElement(By.xpath(this.btnImagenTarjeta)).click();
	}

	public void pulsarBtnVerDatosTarjeta() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnVerDatosTarjeta)));
		driver.findElement(By.xpath(this.btnVerDatosTarjeta)).click();
	}

	public void pulsarBtnMovimientos() {
		BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(this.btnMovimientos)).click();
	}

	public void pulsarBtnBloquearTarjeta() {
		System.out.println("dando click  a btn bloqeuar tarjeta");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnBloquearTarjeta)));
		driver.findElement(By.xpath(this.btnBloquearTarjeta)).click();
	}

	public void pulsarAceptarPopUpBloquear() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptarPopUp)));
			driver.findElement(By.xpath(this.btnAceptarPopUp)).click();
		}catch(Exception e) {
			if(!(contador==3)) {
				Utilidades.esperaMiliseg(500);
				pulsarAceptarPopUpBloquear();
			}else {
				fail("No se encontró popUp de bloqueo en ecard, debido a: " + e.getMessage());
			}
		}finally {contador=0;}
		
	}
	

	public void pulsarFinalizarBloqueo() {
		BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		try {
			driver.findElement(By.xpath(this.btnFinalizar)).click();
		}catch(Exception e) {
			System.out.println("No se encontró botón 'Finalizar' bloqueo en ecard, debido a: " +e.getMessage());
			
		}
		
	}
	
	public String obtenerTxtNumeroTarjeta() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtNumeroTarjeta)));
		String txtNumeroTarjeta = driver.findElement(By.xpath(this.txtNumeroTarjeta)).getText();
		String numeroTarjeta = txtNumeroTarjeta.replace("Numero de su tarjeta","");
		return numeroTarjeta;
	}

	public String obtenerTxtNombreTarjeta() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtNumeroTarjeta)));
		String txtNombreTarjeta = driver.findElement(By.xpath(this.txtNumeroTarjeta)).getText();
		
		String nombreTarjeta = txtNombreTarjeta.replace("Nombre","");
		return nombreTarjeta;
	}

	public String obtenerTxtFechaExpiraTarjeta() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtFechaExpiraTarjeta)));
		String txtFechaExpiraTarjeta = driver.findElement(By.xpath(this.txtFechaExpiraTarjeta)).getText();
		
		String fechaExpiraTarjeta = txtFechaExpiraTarjeta.replace("Fecha de vencimiento tarjeta", "");
		return fechaExpiraTarjeta;
	}

	public void obtenerMovimientosTarjeta() {
		BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		int cont = 0;
		String txtFechaMovimiento = "";
		do {
			try {
				cont++;
				String xpathFecha = "(//*[contains(@name, '/')])[" + cont + "]";
				txtFechaMovimiento = driver.findElement(By.xpath(xpathFecha)).getText();
			} catch (Exception e) {
				System.out.println("No encontre algún o mas movimientos");
				txtFechaMovimiento = "";
				cont--;
			}
		} while (txtFechaMovimiento.length() > 0);
		System.out.println("Total de movimientos: " + cont);
	}
		
    public void irOpcionTarjetaVirtual() {
    	try {
    		contador++;
        	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnTarjetaVirtual)));
    		driver.findElement(By.xpath(this.btnTarjetaVirtual)).click();
    	}catch(Exception e){
    		if(!(contador==5)) {
    			utilidad.esperaMiliseg(2000);
    			irOpcionTarjetaVirtual();
    		}else {
    			fail("No se encontró boton tarjeta virtual debido a: " +e.getMessage());
    		}
    	}finally {contador=0;}	
	}
    
    public void validarLinkTarjetaVirtual() {
    	try {
    		contador++;
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnTarjetaVirtual)));
    		String textoLinkTarjeta = driver.findElement(By.xpath(this.btnTarjetaVirtual)).getText();
    		
    		assertThat(textoLinkTarjeta, containsString("Tarjeta virtual"));
        	
        
    	}catch(Exception e){
    		if(!(contador==5)) {
    			utilidad.esperaMiliseg(2000);
    			validarLinkTarjetaVirtual();
    		}else {
    			fail("No se encontró link tarjeta virtual debido a: " +e.getMessage());
    		}
    	}finally {contador=0;}	
	}
    
    public void irOpcionAbrirProductos() {
    	try {
    		contador++;
        	wait.until(ExpectedConditions.elementToBeClickable(By.id(this.btnAbrirProductos)));
    		driver.findElement(By.id(this.btnAbrirProductos)).click();
    	}catch(Exception e){
    		if(!(contador==5)) {
    			utilidad.esperaMiliseg(2000);
    			irOpcionAbrirProductos();
    		}else {
    			fail("No se encontró boton abrir productos debido a: " +e.getMessage());
    		}
    	}finally {contador=0;}	
    	
	}
    
    public void irOpcionUsarPlata() {
    	try {
    		contador++;
        	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnUsarPlata)));
    		driver.findElement(By.xpath(this.btnUsarPlata)).click();
    	}catch(Exception e){
    		if(!(contador==5)) {
    			utilidad.esperaMiliseg(2000);
    			irOpcionUsarPlata();
    		}else {
    			fail("No se encontró boton usar plata debido a: " +e.getMessage());
    		}
    	}finally {contador=0;}	    				
	}
	
    public void recargarEcard() {
    	try {
    		contador++;
    		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.checkBoxRecargaEcard)));
    		driver.findElement(By.xpath(this.checkBoxRecargaEcard)).click();
    	}catch(Exception e){
    		if(!(contador==5)) {
    			utilidad.esperaMiliseg(2000);
    			recargarEcard();
    		}else {
    			fail("No se encontró check box de recarga tarjeta virtual debido a: " + e.getMessage());
    		}
    	}finally {contador=0;}	    				
	}
    
    public void validarMensajeSaldoInsuficiente() {
    	try {
    		contador++;
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.mensajeSaldoInsuficienteEcard)));
    		String mensaje = driver.findElement(By.xpath(this.mensajeSaldoInsuficienteEcard)).getText();
    		assertThat(mensaje, containsString("No le alcanza la plata para hacer la recarga")); 		
    	}catch(Exception e){
    		if(!(contador==5)) {
    			utilidad.esperaMiliseg(2000);
    			validarMensajeSaldoInsuficiente();
    		}else {
    			fail("No se encontró mensaje de saldo insuficiente, en recarga de tarjeta virtual debido a: " + e.getMessage());
    		}
    	}finally {contador=0;}	    				
	}
    
    public void validarMensajeSuperoCupo() {
    	try {
    		contador++;
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.mensajeCupoSuperadoEcard)));
    		String mensaje = driver.findElement(By.xpath(this.mensajeCupoSuperadoEcard)).getText();
    		assertThat(mensaje, containsString("VALOR INVALIDO")); 		
    	}catch(Exception e){
    		if(!(contador==5)) {
    			utilidad.esperaMiliseg(2000);
    			validarMensajeSuperoCupo();
    		}else {
    			fail("No se encontró mensaje de cupo superado, en recarga de tarjeta virtual debido a: " + e.getMessage());
    		}
    	}finally {contador=0;}	    				
	}
    
    public void validarSaldoRecargadoEnEcard() {
    	try {
    		contador++;
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.saldoEcard)));
    		String saldoEcard = driver.findElement(By.xpath(this.saldoEcard)).getText();
    		
    		System.out.println("Este es el saldo actual en la ecard: " + saldoEcard);
    	}catch(Exception e){
    		if(!(contador==5)) {
    			utilidad.esperaMiliseg(2000);
    			validarSaldoRecargadoEnEcard();
    		}else {
    			fail("No se encontró saldo recarga de tarjeta virtual debido a: " + e.getMessage());
    		}
    	}finally {contador=0;}	    				
	}
    
    public void montoTarjetaParaRecargar(String monto) {
    	BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	try {
    		
    		base.montoTransado = new BigDecimal(monto);
    		contador++;
    		switch (monto) { 
    	    case "50000":
        		driver.findElement(By.xpath(this.checkboxCincuentaMil)).click();
    	     break;
    	    case "100000":
        		driver.findElement(By.xpath(this.checkboxDiezMil)).click();
    	     break;    	
    	    case "300000" :
        		driver.findElement(By.xpath(this.checkboxTrecientosMil)).click();
    	     break;
    	    case "500000" :
        		driver.findElement(By.xpath(this.checkboxQuinientosMil)).click();
    	     break;
    	     
    	    default: {
    	    	
        		driver.findElement(By.xpath(this.montoDiferente)).sendKeys(monto);
    	    	
    	    }

    	    
    	    }   
    	}catch (Exception e) {
    		if(!(contador==3)) {
    			utilidad.esperaMiliseg(500);
    			montoTarjetaParaRecargar(monto);
    		}else {fail("No se pudo encontrar checkbox de recarga ni input para ingresar monto en tarjeta crédito, debido a: "+e.getMessage());}
    	}finally {contador=0;}    				
	}
    
    public void cerrarPopUpFondosInsuficientesEcard() {
    	try {
    		contador++;
    		MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptarPopUpEcard)));
    		Actions actions = new Actions(driver);
    	    actions.click(element).perform();
    	}catch(Exception e){
    		if(!(contador==5)) {
    			utilidad.esperaMiliseg(500);
    			cerrarPopUpFondosInsuficientesEcard();
    		}else {
    			fail("No se encontró botón 'Aceptar' de popUp fondos insuficientes de la ecard, debido a: " + e.getMessage());
    		}
    	}finally {contador=0;}	    				
	}
    
    public void clicBotonAtrasEcard() {
    	try {
    		contador++;
    		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnRegresarEcard)));
    		driver.findElement(By.xpath(this.btnRegresarEcard)).click();
    	}catch(Exception e){
    		if(!(contador==5)) {
    			utilidad.esperaMiliseg(500);
    			clicBotonAtrasEcard();
    		}else {
    			fail("No se encontró botón 'Atras' de la ecard, debido a: " + e.getMessage());
    		}
    	}finally {contador=0;}	    				
	}
    

    
    
}
