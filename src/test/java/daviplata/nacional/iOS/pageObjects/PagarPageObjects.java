package daviplata.nacional.iOS.pageObjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.math.BigDecimal;
import java.util.List;
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
import static org.hamcrest.Matchers.*;

public class PagarPageObjects extends PageObject {

	private AppiumDriver<MobileElement> driver = Hooks.getDriver();
	private WebDriverWait wait = Hooks.getDriverWait();
	Utilidades utilidad;
	Utilidades Utilidades;
	BaseUtil base;

	private String btnEscribirDatosRecibo = "//XCUIElementTypeButton[@name='Seleccionar opción para escribir los datos del recibo']";
	private String inputBuscadorEmpresa = "//XCUIElementTypeOther[@name='Buscar convenio o servicio']";
	private String btnEmpresaBuscada = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.TextView";
//	private String btnEmpresaBuscadaPrimera = "//android.widget.TextView[contains(@text";
	private String btnEmpresaBuscadaPrimera = "//XCUIElementTypeTable/XCUIElementTypeCell[1]";
	private String btnEsmpresaSelect = "(//*[@id='pago_frecuente_convenio_name'][contains(text(),'#')])";
	private String inputUnaReferencia = "(//XCUIElementTypeTextField)[1]";
	private String inputUnaReferencia2 = "(//XCUIElementTypeTextField)[2]";
	private String btnContinuar = "//XCUIElementTypeButton[@name='Continuar']";
	private String ingresoMontoRecibo = "com.davivienda.daviplataapp.lab:id/hacer_pagos_manual_op4_value";
	private String inputValorAPagar = "//*[@name='Escriba el valor a pagar']//following-sibling::XCUIElementTypeTextField";
	private String btnPagar = "//XCUIElementTypeButton[@name=\"Pagar\"]";
	private String btnCerrar = "";
	private String txtConfEmpresa = "(//*[contains(@name,'#')])";
	private String txtConfReferencia = "(//*[contains(@name,'#')])";
	private String txtValorAPagar = "(//XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther)[9]";
	private String btnFinalizar = "//XCUIElementTypeButton[@name=\"Finalizar\"]";
	private String cerrarTeclado = "(//XCUIElementTypeButton[@name=\"Continuar\"])[2]";
	private String txtRefNoExiste = "//*[contains(@name,'no existe')]";// REFERENCIA
	private String txtInfoDatosServiciosPublicos = "//*[contains(@name, 'Ingrese los datos')]";
	private String txtValorAPagarServicio = "//*[contains(@value, 'pesos')]";
	public static final String BOTON_MAS = "//XCUIElementTypeOther[@name='btn-my-movements-3']";
	public static final String BOTON_PAGAR = "//XCUIElementTypeOther[@name='circle-button-5']";
	public static final String BOTON_TODOS_MARKETPLACE = "//XCUIElementTypeStaticText[@name='Todos']";																																							// PARA
																																								// PAGO
																																								// NO
	// EXISTE

	private String inputReferencia2 = "(//XCUIElementTypeTextField)[2]";
	private String labelCuentaNoExiste = "com.davivienda.daviplataapp.lab:id/notif_text_rappi";

	private String txtAutorizador = "(//XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther)[11]";
	private int contador = 0;

	public void txtAutorizador() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtAutorizador)));
		String auto = driver.findElement(By.xpath(this.txtAutorizador)).getText();
		auto = auto.replaceAll("[^0-9]", "");
		if (auto.length() == 6) {
			base.Autorizador = auto;
			base.idTransaccion = base.Autorizador;
			System.out.println("Autorizador " + base.Autorizador);
		} else {
			agregarCeros(auto);
		}

	}

	public void quitarCerosIzquierda(String numero) {
		long p = Long.parseLong(numero);
		base.Autorizador = Long.toString(p);
		base.idTransaccion = base.Autorizador;
		System.out.println("Autorizador " + base.Autorizador);
	}

	public void agregarCeros(String numero) {
		String f = "0" + numero;
		base.Autorizador = f;
	}

	public void darClickEnEscribirDatosDelRecibo() {
		Utilidades.esperaMiliseg(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnEscribirDatosRecibo)));
		driver.findElement(By.xpath(this.btnEscribirDatosRecibo)).click();
	}

	public void ingresoDatosDeEmpresa(String empresaServicio) {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputBuscadorEmpresa)));
			driver.findElement(By.xpath(this.inputBuscadorEmpresa)).sendKeys(empresaServicio);
			System.out.println("ingresa datos de empresa");
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(500);
				ingresoDatosDeEmpresa(empresaServicio);
			}else {
				fail("No se encontró input para ingresar empresa y pagar el servicio, debido a: "+e.getMessage());
			}
		}finally {contador=0;}
		
	}

	public void darClickEnEmpresaEncontrada(String empresaServicio) {
		try {
			contador++;
			Utilidades.esperaMiliseg(2500);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnEmpresaBuscadaPrimera)));
			driver.findElement(By.xpath(this.btnEmpresaBuscadaPrimera)).click();
		} catch (Exception e) {
			if(!(contador==5)) {
				utilidad.esperaMiliseg(500);
				darClickEnEmpresaEncontrada(empresaServicio);
			}else {
				fail("No se encontró disco de empresa buscada, debido a: "+e.getMessage());
			}
		}finally {contador=0;}

	}

	public void darClickEnEmpresaEncontradaa(String empresaServicio) {
		// String empresaASeleccionar = buscarPosiblesEmpresas(empresaServicio);
		// this.btnEmpresaBuscada = this.btnEmpresaBuscada.replace("#",
		// empresaServicio);

		MobileElement btnEmpresaBuscada = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnEmpresaBuscada)));
		btnEmpresaBuscada.click();
	}

	private String buscarPosiblesEmpresas(String empresaServicio) {
		btnEsmpresaSelect = btnEsmpresaSelect.replace("#", empresaServicio);
		List<MobileElement> listaElementos = driver.findElements(By.xpath(btnEsmpresaSelect));
		String posicionRetorno = "";
		int posicion = 0;
		for (MobileElement mobileElement : listaElementos) {
			posicion++;
			if (mobileElement.getText().contentEquals(empresaServicio)) {
				posicionRetorno = String.valueOf(posicion);
				break;
			} else
				posicionRetorno = "1";
		}
		return posicionRetorno;
	}

	public void ingresarReferenciaUno(String referencia) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputUnaReferencia)));
			driver.findElement(By.xpath(this.inputUnaReferencia)).sendKeys(referencia);
			base.cuentaONumero = referencia;

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.cerrarTeclado)));
			driver.findElement(By.xpath(this.cerrarTeclado)).click();
		} catch (Exception e) {
			if (!(contador == 20)) {
				Utilidades.esperaMiliseg(2000);
				ingresarReferenciaUno(referencia);
			} else {
				fail("No se puedo ingresar referencia para en modulo pagar debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void ingresarReferenciaDos(String referencia2) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputReferencia2)));
			driver.findElement(By.xpath(this.inputReferencia2)).sendKeys(referencia2);
			base.cuentaONumero2 = referencia2;

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.cerrarTeclado)));
			driver.findElement(By.xpath(this.cerrarTeclado)).click();
		} catch (Exception e) {
			if (!(contador == 20)) {
				Utilidades.esperaMiliseg(2000);
				ingresarReferenciaDos(referencia2);
			} else {
				fail("No se puedo ingresar referencia dos para en modulo pagar debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void darClickEnContinuar() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuar)));
			driver.findElement(By.xpath(this.btnContinuar)).click();
		} catch (Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(500);
				darClickEnContinuar();
			}else {
				fail("No se se encontró botón 'Continuar' en pago de servicios publicos, debido a: " +e.getMessage());
			}
		} finally {contador=0;}
		
	}

	public void valorAPagar(String valorTransaccion) {
		MobileElement ingresoMonto = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.ingresoMontoRecibo)));
		ingresoMonto.sendKeys(valorTransaccion);
		;
	}

	public void ingresarValorAPagar(String valorTransaccion) {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputValorAPagar)));
			MobileElement inputPagar = driver.findElement(By.xpath(this.inputValorAPagar));
			inputPagar.clear();
			inputPagar.sendKeys(valorTransaccion);
			base.montoTransado = new BigDecimal(valorTransaccion);
		} catch (Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(500);
				ingresarValorAPagar(valorTransaccion);
			}else {
				fail("No se se encontró input para ingresar valor de pago de servicios publicos, debido a: " +e.getMessage());
			}
		} finally {contador=0;}
	}
	
	public void clicBotonContinuarTeclado() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.cerrarTeclado)));
			driver.findElement(By.xpath(this.cerrarTeclado)).click();
		} catch (Exception e) {
			System.out.println("no pude modificar el pago de servicio");
		} finally {
			
		}
	}

	public void darClickEnPagar() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnPagar)));
		driver.findElement(By.xpath(this.btnPagar)).click();
	}

	public void cerrarPopup() {
		utilidad.esperaMiliseg(8000);
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(351, 407)).perform();
	}

	public void validarEmpresa(String empresaServicio) {
		this.txtConfEmpresa = this.txtConfEmpresa.replace("#", empresaServicio);
		System.out.println(this.txtConfEmpresa);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtConfEmpresa)));
		boolean isEnabled = driver.findElement(By.xpath(this.txtConfEmpresa)).isEnabled();
		assertTrue(isEnabled);
	}

	public void validarReferenciaUno(String referencia) {
		this.txtConfReferencia = this.txtConfReferencia.replace("#", referencia);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtConfReferencia)));
		boolean isEnabled = driver.findElement(By.xpath(this.txtConfReferencia)).isEnabled();
		assertTrue(isEnabled);
	}

	public void validarReferenciaDos(String referencia, String referencia2) {
		String referenciaFinal = referencia.concat(" - ").concat(referencia2);
		this.txtConfReferencia = this.txtConfReferencia.replace("#", referenciaFinal);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtConfReferencia)));
		boolean isEnabled = driver.findElement(By.xpath(this.txtConfReferencia)).isEnabled();
		assertTrue(isEnabled);
	}

	public void validarValorAPagar() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtValorAPagar)));
		String txtValorAPagar = driver.findElement(By.xpath(this.txtValorAPagar)).getText();

		String valor = txtValorAPagar.replaceAll("[^0-9]", "");
		;
		System.out.println("valor a pagar" + valor);
		base.monto = valor;
		base.montoTransado = new BigDecimal(2105);

	}

	public void darClickEnFinalizar() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnFinalizar)));
		driver.findElement(By.xpath(this.btnFinalizar)).click();
	}

	public void validarNumDeReferenciaNoExiste() {
		try {
			contador++;
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.txtRefNoExiste)));
			String valor = driver.findElement(By.xpath(this.txtRefNoExiste)).getText();
			assertThat(valor, containsString("Nro factura no existe"));
		}catch(Exception e) {
			if(!(contador==5)) {
				utilidad.esperaMiliseg(500);
				validarNumDeReferenciaNoExiste();
				
			}else {
				fail("No se encontró texto de validación de numero de factura errada, debido a: " + e.getMessage());
				
			}
			
		}finally {contador=0;}
		
	}

	public void validoLblFondosInsuficientes07() {
		MobileElement lblExcedeCupo = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.labelCuentaNoExiste)));
		utilidad.esperaMiliseg(3000);
		assertEquals("RECHAZADA POR FONDOS INSUFICIENTES    07", lblExcedeCupo.getText());
		utilidad.tomaEvidencia("Valido mensaje de fondos insuficientes");
		utilidad.esperaMiliseg(2000);
		base.montoTransado = new BigDecimal(0);
		lblExcedeCupo.click();
	}

	public void validoLblExcedeTopeSaldo() {
		MobileElement lblExcedeCupo = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.labelCuentaNoExiste)));
		utilidad.esperaMiliseg(3000);
		assertEquals("RECHAZADA POR FONDOS INSUFICIENTES    07", lblExcedeCupo.getText());
		utilidad.tomaEvidencia("Valido mensaje de fondos insuficientes");
		utilidad.esperaMiliseg(2000);
		base.montoTransado = new BigDecimal(0);
		lblExcedeCupo.click();
	}
	
	public void esperarAparezcaInfoHacerPagosServicios() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
			    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.txtInfoDatosServiciosPublicos)));
		}catch(Exception e) {
			if(!(contador==20)) {
				utilidad.esperaMiliseg(500);
				esperarAparezcaInfoHacerPagosServicios();
				
			}else {
				fail("No se encontró información para hacer pago de servicios, debido a: " + e.getMessage());
				
			}
			
		}finally {contador=0;}
		
	}
	
	public void valorAPagarServicio(String valorServicio) {
		base.montoTransado =  new BigDecimal(valorServicio);
	}
			

}
