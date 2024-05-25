package daviplata.nacional.iOS.pageObjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.github.javafaker.Faker;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import daviplata.nacional.iOS.definitions.Hooks;
import daviplata.nacional.iOS.utilidades.Utilidades;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.core.pages.PageObject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BolsilloPageObjects extends PageObject {

	private BaseUtil base;
	// private AppiumDriver<MobileElement> driver = Hooks.getDriver();
	private WebDriverWait wait = new WebDriverWait(BaseUtil.driver, 5);
	private int contador = 0;
	private AppiumDriver<MobileElement> driver = Hooks.getDriver();
	Utilidades utilidad;
	Utilidades Utilidades;

	private Faker objFaker = new Faker();
	private String btnActualizarSaldoBolsillos = "com.davivienda.daviplataapp.lab:id/refresh_pocket";
	private String btnBolsillo = "Bolsillo";
	private String btnBolsillos = "//XCUIElementTypeStaticText[@value='Mis bolsillos']";
	private String btnContinuar = "Continuar";
	// ---------------xpaths para crear bolsillos---------------------------------//
	private String btnAbrirBolsillo = "//XCUIElementTypeButton[@name='Abrir Bolsillo']";
	private String listaPeriodo = "//XCUIElementTypePickerWheel";
	private String checkTerminosCondiciones = "//XCUIElementTypeButton[@name='Casilla condiciones de uso Bolsillo. casilla no marcada']";
	private String btnContinuarCreacionBolsillo = "//XCUIElementTypeButton[@name='Finalizar' or @name='Continuar']";
	private String btnConfirmarCreacionBolsillo = "//XCUIElementTypeButton[@name=\"Finalizar\"]";
	private String btnFinalizarCreacionBolsillo = "//XCUIElementTypeButton[@name=\"Finalizar\"]";
	
	private String btnCerrar = "//XCUIElementTypeButton[@name=\"Close\"]";
	private String txtNoMasBolsillos = "//XCUIElementTypeStaticText[@name='Maximo cantidad de bolsillos creados']";
	// ---------------xpaths para leer bolsillos---------------------------------//
	private String txtContenidoUsuarioBolsillo = "";
	private String lblMontoTotal = "(//XCUIElementTypeOther)[12]";
	private String btnMeterPlata = "//XCUIElementTypeButton[@label='Meter plata bolsillo']";
	private String xpathListaElementos = "(//XCUIElementTypeOther[contains(@name,'pesos')])[1]";
	private List<MobileElement> listaElementos;
	private String bolsilloACargar = "//XCUIElementTypeCell";
	private String txtIngresarMontoBolsillo = "//XCUIElementTypeTextField";
	private String btnContinuarBolsillo = "//XCUIElementTypeButton[@label='Continuar']";
	private String saldoBolsillo = "//*[contains(@name, 'Saldo total bolsillo')]";

	// ---------------xpaths para sacar plata de
	// bolsillos---------------------------------//
	private String btnSacarPlata = "Sacar plata bolsillo";
	private String saldoBolsilloSacarPlata = "(//*[@resource-id = 'com.davivienda.daviplataapp.lab:id/bolsillo_item_value'])[1]";
	private String btnSelBolsillo1 = "(//*[@type = 'XCUIElementTypeCell'])[1]";
	private String txtSacarPlata = "//*[@type = 'XCUIElementTypeTextField']";
	private String txtBolsillo1 = "(//*[contains(@name,'Bolsillo')])[3]";
	private String btnContinuarSacarPlata = "Continuar";
	private String txtAutorizacion = "//XCUIElementTypeStaticText[@name='Número de autorización']//following-sibling:: XCUIElementTypeStaticText";
	private String txtExcedeMonto = "//XCUIElementTypeStaticText[@name=\"Bolsillo no tiene saldo disponible\"]";
	private String btnFinalizarSacar = "Finalizar";
	private String btnVolver = "Regresar a pantalla Anterior";
	// ---------------xpaths para modificar
	private String txtModificacionrealizada = "//XCUIElementTypeStaticText[@name='Modificación realizada']";
	private String btnModificar = "//XCUIElementTypeButton[@name='Modificar']";
	// bolsillos---------------------------------//
	private String btnEliminarBolsillo = "//XCUIElementTypeButton[@name='Eliminar']";
	private String btnAceptarEliminarBolsillo = "//XCUIElementTypeButton[@name='Aceptar']";
	private String btnContinuarEliminacion = "//XCUIElementTypeButton[@name='Continuar']";
	private String btnContinuarModificacion = "//XCUIElementTypeStaticText[@name='Continuar']";
	private boolean crearBolsillo = false;
	private boolean mensajeNoMasBolsillos = false;

	// Validar creacion

	private String txtTransaccion = "//XCUIElementTypeStaticText[@name='Transacción exitosa' or @name='Transacción Exitosa']";
	private String btnFinalizar = "//XCUIElementTypeButton[@name='Finalizar']";
	private String txtBolsilloCreado = "//XCUIElementTypeOther[contains(@name, '#')]";

	// popups

	private String btnCerrarPopup = "//XCUIElementTypeButton[@name='Close']";
	private String popUpAperturaBolsillo = "(//XCUIElementTypeOther)[5]";
	private String inputNombreBolsillo = "(//XCUIElementTypeOther[contains(@name,'nombre del bolsillo')] | //XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1])[last()]";
    public static final String LISTA_DESPLEGABLE_PERIODO_MODIFICADO = "//XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]";
    public static final String LISTA_DESPLEGABLE_PERIODO = "//XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[5]";
    public static final String BOTON_SACAR_PLATA = "//XCUIElementTypeButton[@name='Sacar plata bolsillo']";
    public static final String BOTON_BOLSILLOS_HOME = "//XCUIElementTypeStaticText[@name='name-product-0']  | //XCUIElementTypeStaticText[contains(@value, 'Mis bolsillos')]";
    
    
	public void verificoResultadoTransaccion() {
		String textoValidacion = "";
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.txtTransaccion)));
		textoValidacion = driver.findElement(By.xpath(this.txtTransaccion)).getText();

		if (textoValidacion.contains("Transacción exitosa") || textoValidacion.contains("Exitosa")) {
			textoValidacion = "Transaccion exitosa";
		} else
			textoValidacion = "No se encuentra 'Transaccion exitosa'";

		assertEquals("Transaccion exitosa", textoValidacion);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnFinalizar)));
		driver.findElement(By.xpath(this.btnFinalizar)).click();
	}

	public void verificoResultadoTransaccionExcedeMonto() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtExcedeMonto)));
			MobileElement txtExcedeMonto = driver.findElement(By.xpath(this.txtExcedeMonto));
			utilidad.tomaEvidencia("Valido mensaje Excede monto");
			assertThat(txtExcedeMonto.getText(), equalTo("Bolsillo no tiene saldo disponible"));
			txtExcedeMonto.click();
			System.out.println("Validé el mensaje excede monto correctamente");
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				verificoResultadoTransaccionExcedeMonto();
			} else {
				fail("No se pudo validar txt excede monto debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void txtAutorizadorBolsillo() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtAutorizacion)));
		String auto = driver.findElement(By.xpath(this.txtAutorizacion)).getText();
		System.out.println("Autorizador " + auto);
		if (auto.length() == 6) {
			try {
				base.Autorizador = auto;
				base.idTransaccion = auto;
			} catch (Exception e) {
				System.out.println("no pude ingresar el autorizador a base.autorizador ");
			}
		} else {
			quitarCerosIzquierda(auto);
		}

	}

	public void btnFinalizarSacar() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.name(this.btnFinalizarSacar)));
			driver.findElement(By.name(this.btnFinalizarSacar)).click();
		} catch (Exception e) {
			System.out.println("no pude dar click a btn finalizar");
		} finally {
			contador = 0;
		}

	}

	public void btnVolver() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.name(this.btnVolver)));
			driver.findElement(By.name(this.btnVolver)).click();
			utilidad.tomaEvidencia("Volver atras");
		} catch (Exception e) {
			System.out.println("no pude dar click a btn atras");
		}
	}
	
	public void cerrarPopupSacarBolsillo() {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.btnCerrar)));
			driver.findElement(By.xpath(this.btnCerrar)).click();
			utilidad.tomaEvidencia("Volver atras");
		} catch (Exception e) {
			System.out.println("no di click a btn cerrar");
		} 
	}
	

	public void quitarCerosIzquierda(String numero) {
		long p = Long.parseLong(numero);
		base.Autorizador = Long.toString(p);
		base.idTransaccion = Long.toString(p);
	}

	public void pulsarBtnActualizarSaldoBolsillos() {
		try {
			contador++;
			MobileElement objMobileElement = base.driver.findElement(By.id(this.btnActualizarSaldoBolsillos));
			utilidad.tomaEvidencia("Actualizo saldo total de bolsillos");
			objMobileElement.click();
			crearBolsillo = false;
		} catch (Exception objException) {

			if (!(contador == 2)) {
				Utilidades.esperaMiliseg(2000);
				pulsarBtnActualizarSaldoBolsillos();
			} else {
				System.out.println("No hubo necesidad de actualizar bolsillos");
			}
		} finally {
			contador = 0;
		}
	}

	public void pulsarSaldoTotalBolsillos(boolean verificador) {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnBolsillos)));
			try {
				if (verificador) {
					utilidad.tomaEvidencia("Ingreso a la opcion bolsillos");
				}
				System.out.println("di click en bolsillos");
				base.driver.findElement(By.xpath(this.btnBolsillos)).click();
				crearBolsillo = false;
			} catch (Exception objException) {
				crearBolsillo = true;
				System.out.println("Al parecer no existen bolsillos");
			}

		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				pulsarSaldoTotalBolsillos(verificador);
			} else {
				fail("No se encontró bolsillos para escoger, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void pulsarBtnCrearBolsillos() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnBolsillos)));
			driver.findElement(By.xpath(this.btnBolsillos)).click();
			System.out.println("di click a btn bolsillos");
			utilidad.tomaEvidencia("Ingreso a Bolsillos desde el Home");
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				pulsarBtnCrearBolsillos();
			} else {
				System.out.println("No se pudo dar click a crear bolsillo debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void pulsarAbrirBolsillo() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAbrirBolsillo)));
			driver.findElement(By.xpath(this.btnAbrirBolsillo)).click();
			utilidad.tomaEvidencia("Pulso en abrir bolsillo");

		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(500);
				pulsarAbrirBolsillo();
			} else {
				System.out.println("No se pudo dar click a abrir bolsillo debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void ingresarNombreBolsillo() {
		BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String nombre = this.objFaker.name().firstName();
		BaseUtil.driver.findElement(By.xpath(this.inputNombreBolsillo)).sendKeys(nombre);
		System.out.println("Ingrese el nuevo nombre del bolsillo correctamente");
	}

	

	public void ingresarMontoInicialBolsillo(String monto) {
		try {
			contador++;
			// MobileElement objMobileElement = (MobileElement) wait
			// .until(ExpectedConditions.elementToBeClickable(By.name(this.txtMontoInicialBolsillo)));
			// objMobileElement.sendKeys(monto);
			// base.monto = monto;
			System.out.println(monto);

			base.montoTransado = new BigDecimal(monto);
			
			TouchAction touchAction=new TouchAction(driver);
            touchAction.tap(new PointOption().withCoordinates(94, 300)).perform();
			
			for(int i = 0; i<monto.length(); i++) {
				String numero = String.valueOf(monto.charAt(i));
				String teclas = "//XCUIElementTypeKey[@name='" + numero + "']";
				driver.findElement(By.xpath(teclas)).click();
	            
			}
			
			wait.until(ExpectedConditions.elementToBeClickable(By.name(this.btnContinuar)));
			driver.findElement(By.name(this.btnContinuar)).click();

			utilidad.tomaEvidencia("Ingresar monto inicial");

		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				ingresarMontoInicialBolsillo(monto);
			} else {
				fail("No se pudo ingresar el monto inicial al bolsillo debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void ingresarMontoInicialBolsilloFondosInsuficientes(String monto) {
		try {
			contador++;
			utilidad.esperaMiliseg(2000);
			TouchAction touchAction=new TouchAction(driver);
            touchAction.tap(new PointOption().withCoordinates(98, 306)).perform();
			
			for(int i = 0; i<monto.length(); i++) {
				String numero = String.valueOf(monto.charAt(i));
				String teclas = "//XCUIElementTypeKey[@name='" + numero + "']";
				driver.findElement(By.xpath(teclas)).click();
	            
			}
			System.out.println("Ingrese el monto del bolsillo correctamente");

		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				ingresarMontoInicialBolsilloFondosInsuficientes(monto);
			} else {
				fail("No se pudo ingresar el monto inicial fondos insuficientes al bolsillo debido a: "+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void ingresarMontoTotalBolsillo(String monto) {

		try {
			contador++;
			utilidad.esperaMiliseg(2000);
			TouchAction touchAction=new TouchAction(driver);
            touchAction.tap(new PointOption().withCoordinates(103, 377)).perform();
			
			for(int i = 0; i<monto.length(); i++) {
				String numero = String.valueOf(monto.charAt(i));
				String teclas = "//XCUIElementTypeKey[@name='" + numero + "']";
				driver.findElement(By.xpath(teclas)).click();
	            
			}
			System.out.println("Ingrese el monto del bolsillo correctamente");

		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				ingresarMontoTotalBolsillo(monto);
			} else {
				fail("No se pudo ingresar el monto totoal al bolsillo debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void ingresarMontoTotalBolsillohamburguesa(String monto) {
		try {
			contador++;
			// MobileElement objMobileElement = (MobileElement) wait
			// .until(ExpectedConditions.elementToBeClickable(By.name(this.txtMontoTotalBolsillo)));
			// objMobileElement.sendKeys(monto);

			TouchAction touchAction=new TouchAction(driver);
            touchAction.tap(new PointOption().withCoordinates(94, 370)).perform();
			
			for(int i = 0; i<monto.length(); i++) {
				String numero = String.valueOf(monto.charAt(i));
				String teclas = "//XCUIElementTypeKey[@name='" + numero + "']";
				driver.findElement(By.xpath(teclas)).click();
	            
			}
			System.out.println("Ingrese el monto del bolsillo correctamente");

			wait.until(ExpectedConditions.elementToBeClickable(By.name(this.btnContinuar)));
			driver.findElement(By.name(this.btnContinuar)).click();

			utilidad.tomaEvidencia("Ingresar monto final");

		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				ingresarMontoTotalBolsillohamburguesa(monto);
			} else {
				fail("No se pudo ingresar el monto total al bolsillo debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void pulsarAceptarTyC() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.checkTerminosCondiciones)));
			driver.findElement(By.xpath(this.checkTerminosCondiciones)).click();
			utilidad.tomaEvidencia("Aceptar termin y condiciones");

		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				pulsarAceptarTyC();
			} else {
				fail("No se pudo pulsar el btn aceptar TyC, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void pulsarContinuarCreacionBolsillo() {
		try {
			contador++;
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.btnContinuarCreacionBolsillo)));
				driver.findElement(By.xpath(this.btnContinuarCreacionBolsillo)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				pulsarContinuarCreacionBolsillo();
			} else {
				fail("No se pudo pulsar el btn continuar creacion bolsillo,  debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}
	
	public void pulsarContinuarCreacion(int variacion) {
		try {
			contador++;
			for(int i = 0; i<variacion; i++) {
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarCreacionBolsillo)));
				driver.findElement(By.xpath(this.btnContinuarCreacionBolsillo)).click();
			}
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				pulsarContinuarCreacion(variacion);
			} else {
				fail("No se pudo pulsar el botón continuar creacion bolsillo  debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void pulsarConfirmarCreacionBolsillo() {
		try {
			contador++;
			utilidad.tomaEvidencia("Confirmar creación de bolsillo");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnConfirmarCreacionBolsillo)));
			driver.findElement(By.xpath(this.btnConfirmarCreacionBolsillo)).click();
			

		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				pulsarConfirmarCreacionBolsillo();
			} else {
				fail("No se pudo pulsar el btn confirmar creacion bolsillo  debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validoTransaccionExitosa() {
		try {
			contador++;
			boolean validacion = false;
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.txtTransaccion)));
			String txtTransaccion = driver.findElement(By.xpath(this.txtTransaccion)).getText();
			
			if (txtTransaccion.equalsIgnoreCase("exitosa") 
					||
					txtTransaccion.equalsIgnoreCase("Transacción exitosa"))
				validacion = true;
			assertTrue(validacion);
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				validoTransaccionExitosa();
			} else {
				fail("No se puedo validar el resultado de la transacción debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void pulsarFinalizarCreacionBolsillo() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnFinalizarCreacionBolsillo)));
			driver.findElement(By.xpath(this.btnFinalizarCreacionBolsillo)).click();
			utilidad.tomaEvidencia("Mensaje de creacion de bolsillo");

		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				pulsarFinalizarCreacionBolsillo();
			} else {
				fail("No se pudo pulsar el btn finalizar creacion bolsillo  debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void cerrarPopup() {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnCerrarPopup)));
			driver.findElement(By.xpath(this.btnCerrarPopup)).click();
			utilidad.tomaEvidencia("Cerrar Popup");;
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				cerrarPopup();
			} else {
				fail("No se pudo pulsar el btn cerrar popup debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public int seleccionarBolsilloAleatorio() {
		int bolsilloSeleccionado = 0;
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.xpathListaElementos)));
			int cantidadBolsillos = obtenerCantidadBolsillos();
			bolsilloSeleccionado = (int) (Math.random() * cantidadBolsillos + 1);
			base.driver.findElement(By.xpath(this.xpathListaElementos)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				seleccionarBolsilloAleatorio();
			} else {
				fail("No se pudo seleccionar bolsillo aleatorio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
		return bolsilloSeleccionado;

	}

	public int obtenerCantidadBolsillos() {
		listaElementos = base.driver.findElements(By.xpath(xpathListaElementos));
		return listaElementos.size();
	}

	public void seleccionarBolsillo() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.xpathListaElementos)));
			MobileElement objMobileElement = driver.findElement(By.xpath(this.xpathListaElementos));
			utilidad.tomaEvidencia("Selecciono el bolsillo");

			this.txtContenidoUsuarioBolsillo = objMobileElement.getText();

			System.out.println("seleccione el bolsillo con el contenido : " + this.txtContenidoUsuarioBolsillo);

			objMobileElement.click();

		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(500);
				seleccionarBolsillo();
			} else {
				fail("No se pudo seleccionar bolsillo  debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void pulsarModificarBolsillo() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnModificar)));
			driver.findElement(By.xpath(this.btnModificar)).click();
			utilidad.tomaEvidencia("Pulso boton modificar");

		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				pulsarModificarBolsillo();
			} else {
				fail("No se pudo pulsar el btn modificar bolsillo  debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public int obtenerMontoTotal() {
		int saldo = 0;
		try {
			contador++;
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.lblMontoTotal)));
			String lblMontoTotal = driver.findElement(By.xpath(this.lblMontoTotal)).getText();

			String saldoTotal = lblMontoTotal.replace(" ", "").replace("$", "").replace(".", "")
					.replace(",", "").replace("pesos", "").replace("Saldototalbolsillo", "");
			System.out.println(saldoTotal);
			saldo = Integer.parseInt(saldoTotal);
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				obtenerMontoTotal();
			} else {
				fail("No se pudo obtener monto total del bolsillo, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
		return saldo;

	}

	public void verBolsillos() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnMeterPlata)));
			driver.findElement(By.xpath(this.btnMeterPlata));
			utilidad.tomaEvidencia("Ver bolsillos");
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				verBolsillos();
			} else {
				fail("No se puedo validar bolsillos debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void pulsarMeterPlata() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnMeterPlata)));
			driver.findElement(By.xpath(this.btnMeterPlata)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				pulsarMeterPlata();
			} else {
				fail("No se puedo presionar botón meter plata debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void pulsarBolsilloSeleccionado(int numeroBolsillo) {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.bolsilloACargar)));
			driver.findElement(By.xpath(this.bolsilloACargar)).click();
			utilidad.tomaEvidencia("selecciono bolsillo");
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				pulsarBolsilloSeleccionado(numeroBolsillo);
			} else {
				fail("No se puedo presionar bolsillo seleccionado con numero de bolsillo, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void ingresarMonto(String monto) {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtIngresarMontoBolsillo)));
			driver.findElement(By.xpath(this.txtIngresarMontoBolsillo)).sendKeys(monto);
			utilidad.tomaEvidencia("ingreso monto");
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				ingresarMonto(monto);
			} else {
				fail("No se puedo ingresar monto debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void pulsarContinuarBolsillo() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarBolsillo)));
			driver.findElement(By.xpath(this.btnContinuarBolsillo)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				pulsarContinuarBolsillo();
			} else {
				fail("No se puedo pulsar btn continuar bolsillo debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void pulsarEliminarBolsillo() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnEliminarBolsillo)));
			driver.findElement(By.xpath(this.btnEliminarBolsillo)).click();
			utilidad.tomaEvidencia("Selecciono eliminar bolsillo");
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				pulsarEliminarBolsillo();
			} else {
				fail("No se puedo pulsar btn eliminar bolsillo debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void setSaldoBolsillo() {
		try {
			contador++;
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.saldoBolsillo)));
			String saldoBolsillo = driver.findElement(By.xpath(this.saldoBolsillo)).getText();

			// Expresión regular mejorada para extraer el saldo completo con separadores de miles y decimales
	        Pattern pattern = Pattern.compile("\\d{1,3}(,\\d{3})*(\\.\\d+)?");
	        Matcher matcher = pattern.matcher(saldoBolsillo);
	        if (matcher.find()) {
	            String saldoBolsilloTotal = matcher.group(); // Obtiene la primera coincidencia de números

	            System.out.println("saldo del bolsillo seleccionado : " + saldoBolsilloTotal);
	            // Elimina las comas de los separadores de miles antes de convertir a BigDecimal
	            saldoBolsilloTotal = saldoBolsilloTotal.replaceAll(",", "");
	            BigDecimal monto = new BigDecimal(saldoBolsilloTotal);

	            base.montoTransado = monto;
	        } else {
	            throw new NumberFormatException("No se encontraron números en la cadena");
	        }
	        
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				setSaldoBolsillo();
			} else {
				fail("No se pudo obtener el saldo del bolsillo debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void pulsarAceptarEliminarBolsillo() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptarEliminarBolsillo)));
			driver.findElement(By.xpath(this.btnAceptarEliminarBolsillo)).click();
			utilidad.tomaEvidencia("aceptar");
			System.out.println("Di click en Boton 'aceptar' de modificacion realizada");
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				pulsarAceptarEliminarBolsillo();
			} else {
				fail("No se puedo pulsar btn 'aceptar' confirmacion de eliminacion debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void btnContinuarEliminacion() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarModificacion)));
			driver.findElement(By.xpath(this.btnContinuarModificacion)).click();
			utilidad.tomaEvidencia("di click en btn Continuar Confimar modificacion");
			System.out.println("di click en btn Continuar Confirmar validacion");
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				btnContinuarEliminacion();
			} else {
				fail("No se puedo dar click al btn continuar debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void pulsarSacarPlata() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.name(this.btnSacarPlata)));
			driver.findElement(By.name(this.btnSacarPlata)).click();
			System.out.println("di click en btn Sacar plata");
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				pulsarSacarPlata();
			} else {
				fail("No se puedo dar click al btn sacar plata debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void obtenerSaldoBolsilloSacarPlata() {
		System.out.println("entre a obtener saldo del bolsillo sacar plata");
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtBolsillo1)));
			String saldo = driver.findElement(By.xpath(this.txtBolsillo1)).getText();

			String saldoBolsillo = saldo.replace("Bolsillo", "").replace("Saldo total por", "")
					.replace(",", "").replace(".", "").replace("pesos", "").replace("Habilitado para seleccionar", "");

			String[] resultado = saldoBolsillo.split(" ", 0);

			base.saldoBolsillo = new BigDecimal(resultado[3]);

			System.out.println("saldo bolsillo: " + resultado[3]);
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				obtenerSaldoBolsilloSacarPlata();
			} else {
				fail("No se puedo obtener el saldo del bolsillo en sacar plata debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void seleccionarBolsilloPasar() {
		System.out.println("seleccionar bolsillo a pasar");
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSelBolsillo1)));
			driver.findElement(By.xpath(this.btnSelBolsillo1)).click();
			System.out.println("seleccione el bolsillo");
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(500);
				seleccionarBolsilloPasar();
			} else {
				fail("No se puedo seleccionar el bolsillo a pasar plata debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void ingresarMontoSacarPlataBolsillo(String monto) {
		try {
			contador++;
			base.montoTransado = new BigDecimal(monto);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtSacarPlata)));
			driver.findElement(By.xpath(this.txtSacarPlata)).sendKeys(monto);
			// base.monto = monto;
			utilidad.esperaMiliseg(500);
			wait.until(ExpectedConditions.elementToBeClickable(By.name(this.btnContinuarSacarPlata)));
			driver.findElement(By.name(this.btnContinuarSacarPlata)).click();
			utilidad.esperaMiliseg(500);
			utilidad.tomaEvidencia("ingreso monto a retirar de bolsillo");
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				ingresarMontoSacarPlataBolsillo(monto);
			} else {
				fail("No se puedo ingresar monto sacar plata debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void pulsarContinuarSacarPlataBolsillos() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.name(this.btnContinuarSacarPlata)));
			driver.findElement(By.name(this.btnContinuarSacarPlata)).click();
			System.out.println("di click en el btn continuar sacar plata");
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				pulsarContinuarSacarPlataBolsillos();
			} else {
				fail("No se puedo dar click al btn continuar sacar plata debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public boolean isCrearBolsillo() {
		return crearBolsillo;
	}

	public void setCrearBolsillo(boolean crearBolsillo) {
		this.crearBolsillo = crearBolsillo;
	}

	public void validarBolsilloCreado() {
		try {
			contador++;
			this.txtBolsilloCreado = this.txtBolsilloCreado.replace("#", base.nombreBolsillo);
			
			System.out.println(this.txtBolsilloCreado);
			Utilidades.esperaMiliseg(10000);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.txtBolsilloCreado)));
			String txtTransaccion = driver.findElement(By.xpath(this.txtBolsilloCreado)).getText();
			
			System.out.println(txtTransaccion);
			assertThat(txtTransaccion, containsString(base.nombreBolsillo));
			utilidad.tomaEvidencia("Valido que se creo el bolsillo");

			

		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(500);
				validarBolsilloCreado();
			} else {
				fail("No se puedo validar bolsillo creado debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void ingresarBolsillo() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.name(this.btnBolsillo)));
			driver.findElement(By.name(this.btnBolsillo)).click();
			System.out.println("Di click al btn bolsillo correctamente");

		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				ingresarBolsillo();
			} else {
				fail("No se puedo ingresar al bolsillo debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	

	public void seleccionoPeriodo(String periodo) {

//		MobileElement objMobileElement =(MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSemana)));
		try {
		
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.listaPeriodo)));
			String listaPeriodo = driver.findElement(By.xpath(this.listaPeriodo)).getText();

			String valorActual = listaPeriodo;
			System.out.println("El periodo actual es: " + valorActual);
			System.out.println("El periodo requerido es: " + periodo);

			contador++;

			switch (periodo) {
			case "Cada Semana":
				System.out.println("Entra a caso donde quiere ir a Cada Semana");
				if (periodo != valorActual) {
					System.out.println("Entra a validacion donde el requerimiento no sea igual al actual");
					if (valorActual.equals("Cada mes")) {
						for (int i = 0; i < 2; i++) {
							wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.listaPeriodo)));
							MobileElement listaDesplegable = driver.findElement(By.xpath(this.listaPeriodo));
							JavascriptExecutor js = (JavascriptExecutor) base.driver;
							Map<String, Object> params = new HashMap<>();
							params.put("order", "previous");
							params.put("offset", 0.15);
							params.put("element", ((RemoteWebElement) listaDesplegable).getId());
							js.executeScript("mobile: selectPickerWheelValue", params);
						}

					} else if (valorActual.equals("Cada quince días")) {
						System.out.println("Entra a scroll donde me quiero mover de Cada quince días a Cada Semana");
						wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.listaPeriodo)));
						MobileElement listaDesplegable = driver.findElement(By.xpath(this.listaPeriodo));
						JavascriptExecutor js = (JavascriptExecutor) base.driver;
						Map<String, Object> params = new HashMap<>();
						params.put("order", "previous");
						params.put("offset", 0.15);
						params.put("element", ((RemoteWebElement) listaDesplegable).getId());
						js.executeScript("mobile: selectPickerWheelValue", params);
					}
				} else {
					System.out.println("Ya estoy en cada semana");
				}

				break;
			case "Cada quince días":
				System.out.println("entra al caso donde se quiera ir a Cada quince días");
				if (periodo != valorActual) {
					if (valorActual.equals("Cada mes")) {
						wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.listaPeriodo)));
						MobileElement listaDesplegable = driver.findElement(By.xpath(this.listaPeriodo));

						JavascriptExecutor js = (JavascriptExecutor) base.driver;
						Map<String, Object> params = new HashMap<>();

						params.put("order", "previous");
						params.put("offset", 0.15);
						params.put("element", ((RemoteWebElement) listaDesplegable).getId());
						js.executeScript("mobile: selectPickerWheelValue", params);
					} else if (valorActual.equals("Cada Semana")) {
						wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.listaPeriodo)));
						MobileElement listaDesplegable = driver.findElement(By.xpath(this.listaPeriodo));

						JavascriptExecutor js = (JavascriptExecutor) base.driver;
						Map<String, Object> params = new HashMap<>();

						params.put("order", "next");
						params.put("offset", 0.15);
						params.put("element", ((RemoteWebElement) listaDesplegable).getId());
						js.executeScript("mobile: selectPickerWheelValue", params);
					}

				} else {
					System.out.println("Ya estoy en cada quince días");
				}
				// MobileElement objMobileElement2 = (MobileElement) wait
				// .until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnQuincenal)));
				// objMobileElement2.click();
				break;
			case "Cada mes":
				System.out.println("entra al caso donde se quiera ir a Cada mes");
				if (periodo != valorActual) {
					System.out.println("entra a la validacion no coinicide el requerido con actual");
					if (valorActual.equals("Cada Semana")) {
						for (int i = 0; i < 2; i++) {
							wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.listaPeriodo)));
							MobileElement listaDesplegable = driver.findElement(By.xpath(this.listaPeriodo));

							JavascriptExecutor js = (JavascriptExecutor) base.driver;
							Map<String, Object> params = new HashMap<>();

							params.put("order", "next");
							params.put("offset", 0.15);
							params.put("element", ((RemoteWebElement) listaDesplegable).getId());
							js.executeScript("mobile: selectPickerWheelValue", params);
							System.out.println("Hola ya ejecute el scroll");
						}
					} else if (valorActual.equals("Cada quince días")) {
						System.out.println("entra a scrollear de cada quince dias a cada mes");
						wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.listaPeriodo)));
						MobileElement listaDesplegable = driver.findElement(By.xpath(this.listaPeriodo));

						JavascriptExecutor js = (JavascriptExecutor) base.driver;
						Map<String, Object> params = new HashMap<>();
						params.put("order", "next");
						params.put("offset", 0.15);
						params.put("element", ((RemoteWebElement) listaDesplegable).getId());
						js.executeScript("mobile: selectPickerWheelValue", params);
					}

				} else {
					System.out.println("Ya estoy en cada quince días");
				}
				break;
			default:
				wait.until(ExpectedConditions.elementToBeClickable(By.name(this.btnContinuar)));
				driver.findElement(By.name(this.btnContinuar)).click();

				System.out.println("No encontre el periodo");
				break;
			}

			wait.until(ExpectedConditions.elementToBeClickable(By.name(this.btnContinuar)));
			driver.findElement(By.name(this.btnContinuar)).click();

			System.out.println("Seleccione mi periodo de ahorro");

		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				seleccionoPeriodo(periodo);
			} else {
				fail("No se puedo ingresar el periodo debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public boolean mensajeNoMasBolsillos() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.txtNoMasBolsillos)));
			String txtMensajeNoMasbolsillos = driver.findElement(By.xpath(this.txtNoMasBolsillos)).getText();
			
			System.out.println(txtMensajeNoMasbolsillos);
			utilidad.tomaEvidencia("Maximo cantidad de bolsillos creados");
			if (txtMensajeNoMasbolsillos.equalsIgnoreCase("Maximo cantidad de bolsillos creados")) {
				mensajeNoMasBolsillos = true;
				return true;
			} else {
				return mensajeNoMasBolsillos;
			}
		} catch (Exception objException) {
			return mensajeNoMasBolsillos;
		}
	}

	public void validarMensajeMaximoBolsillos() {
		try {
			contador++;
			boolean validacion = false;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.txtNoMasBolsillos)));
			String txtMensajeNoMasbolsillos = driver.findElement(By.xpath(this.txtNoMasBolsillos)).getText();
			if (txtMensajeNoMasbolsillos.equalsIgnoreCase("Maximo cantidad de bolsillos creados"))
				utilidad.tomaEvidencia("Maximo cantidad de bolsillos creados");
			validacion = true;
			assertTrue(validacion);
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				validarMensajeMaximoBolsillos();
			} else {
				fail("No se pudo validar mensaje maximo de bolsillos debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validarModificacionRealizada() {
		try {
			contador++;
			utilidad.esperaMiliseg(4000);
			boolean validacion = false;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.txtModificacionrealizada)));
			String txtAlertaModificacion = driver.findElement(By.xpath(this.txtModificacionrealizada)).getText();
			utilidad.esperaMiliseg(2000);
			utilidad.tomaEvidencia("mensaje: Modificacion realizada");
			utilidad.esperaMiliseg(2000);

			System.out.println(txtAlertaModificacion);
			System.out.println("Validando si se modifico correctamente");
			if (txtAlertaModificacion.equalsIgnoreCase("modificación realizada")) {
				System.out.println("Se mostro la alerta de modificacion correctamente");
				validacion = true;
				assertTrue(validacion);
			}
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				validarModificacionRealizada();
			} else {
				fail("No se puedo validar el resultado de la modificación realizada debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void validarActualizacionNombreBolsillo() {
		try {
			contador++;
			utilidad.esperaMiliseg(500);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.xpathListaElementos)));
			String txtContenidoBolsilloModificado = driver.findElement(By.xpath(this.xpathListaElementos)).getText();

			System.out.println("el contenido del bolsillo actual es: " + this.txtContenidoUsuarioBolsillo);
			System.out.println("el contenido del bolsillo modificado es: " + txtContenidoBolsilloModificado);

			assertThat(this.txtContenidoUsuarioBolsillo, is(not(equalTo(txtContenidoBolsilloModificado))));
			utilidad.tomaEvidencia("mensaje: Modificacion realizada");
			System.out.println("valide el cambio del nombre y fue exitoso");

		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				validarModificacionRealizada();
			} else {
				fail("No se puedo validar el resultado de la modificación realizada debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}
	
	public void cerrarPopUPBolsillo() {
		try {
			Utilidades.esperaMiliseg(4000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.popUpAperturaBolsillo)));
			driver.findElement(By.xpath(this.popUpAperturaBolsillo)).click();
		} catch (Exception e) {
			System.out.println("No se encontró popUP bolsillos, debido a: " + e.getMessage());
		}
	}

}
