package daviplata.nacional.iOS.pageObjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.hamcrest.CoreMatchers.containsString;
import java.math.BigDecimal;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import daviplata.nacional.iOS.utilidades.Utilidades;
import daviplata.nacional.iOS.utilidades.UtilidadesTCS;
import daviplata.nacional.iOS.definitions.Hooks;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.core.pages.PageObject;

public class SacarPlataPageObjects extends PageObject {

	private AppiumDriver<MobileElement> driver = Hooks.getDriver();
	private WebDriverWait wait = Hooks.getDriverWait();
	Utilidades Utilidades;
	Utilidades utilidad;
	UtilidadesTCS utilidadesTCS;
	BaseUtil base;

	private String selectMonto = "com.davivienda.daviplataapp.lab:id/check_sacarplata_paso00_amount#";
	private String inputOtroMonto = "//XCUIElementTypeTextField";
	private String btnAceptarTeclado = "(//XCUIElementTypeButton[@name='Aceptar'])[2]";
	private String btnAceptar = "//XCUIElementTypeButton[@name='Aceptar']";
	private String btnContinuar = "//XCUIElementTypeButton[@name='Continuar']";
	private String btnfinalizar = "//XCUIElementTypeButton[@name='Finalizar']";
	private String txtMontoConfirmacion = "com.davivienda.daviplataapp.lab:id/tv_sacarplata_paso01_amount";
	private String txtCupoExcedido = "//XCUIElementTypeStaticText[@name='Excede cupo']";
	private String txtMensajeNotificacion = "//XCUIElementTypeStaticText[@name='El monto debe ser múltiplo de 10.000 y menor a 720.000.' or @name='Excede cupo']";
	private String txtMensajeNotificacionSacarPlata = "//XCUIElementTypeStaticText[@name='Su código para sacar plata es:']";
	private String labelCuentaNoExiste = "com.davivienda.daviplataapp.lab:id/notif_text_rappi";
	private String checkboxVeinteMil = "//XCUIElementTypeButton[@name='veinte mil pesos']";
	private String checkboxCincuentaMil = "//XCUIElementTypeButton[@name='cincuenta mil pesos']";
	private String checkboxCienMil = "//XCUIElementTypeButton[@name='cien mil pesos']";
	private String checkboxDocientosMil = "//XCUIElementTypeButton[@name='doscientos mil pesos']";
	private String montoDiferente = "com.davivienda.daviplataapp.lab:id/sacarplata_paso00_otromonto";
	private String popUpRetiro = "com.davivienda.daviplataapp.lab:id/com_braze_inappmessage_modal_close_button";
	private String btnX = "//XCUIElementTypeButton[@name='Button']";
	private String btnAtras = "//XCUIElementTypeButton[@name='Regresar a pantalla Anterior']";
	private String btnAtras2 = "//XCUIElementTypeButton[@name='Botón atrás']";
	public static final String CODIGO_OTP = "//XCUIElementTypeStaticText[@name='Su código para sacar plata es:']/following-sibling::XCUIElementTypeStaticText[1]";

	private int contador = 0;

	public void seleccionoMonto() {
		this.selectMonto = this.selectMonto.replace("#", "1");
		MobileElement selectMonto = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.selectMonto)));
		selectMonto.click();
	}

	public void capturoMonto() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.selectMonto)));
		String monto = driver.findElement(By.xpath(this.selectMonto)).getText();
		base.montoTransado = new BigDecimal(monto.replaceAll("[^0-9]", ""));
	}

	public void ingresarMonto(String monto) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputOtroMonto)));
		driver.findElement(By.xpath(this.inputOtroMonto)).sendKeys(monto);
		base.montoTransado = new BigDecimal(monto);
	}

	public void darClickEnAceptar() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptar)));
		driver.findElement(By.xpath(this.btnAceptar)).click();

		System.out.println("di click en btn aceptar");
	}

	public void darClickBtnTecladoAceptar() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptarTeclado)));
		driver.findElement(By.xpath(this.btnAceptarTeclado)).click();
	}

	public void darClickFinalizar() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnfinalizar)));
		driver.findElement(By.xpath(this.btnfinalizar)).click();
	}

	public void darClickEnContinuar() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuar)));
			driver.findElement(By.xpath(this.btnContinuar)).click();
		} catch (Exception e) {
			fail("no se pudo dar click en btn continuar debido a: " + e.getMessage());
		}

	}

	public void mensajeExcedeCupo() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtCupoExcedido)));
			String txtMensaje = driver.findElement(By.xpath(this.txtCupoExcedido)).getText();

			assertThat(txtMensaje, containsString("Excede cupo"));
		} catch (Exception e) {
			fail("no se pudo dar click en btn continuar debido a: " + e.getMessage());
		}

	}

	public void capturoMontoConfirmacion() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.txtMontoConfirmacion)));
		String textoOTP = driver.findElement(By.xpath(this.txtMontoConfirmacion)).getText();
		String monto = textoOTP.replaceAll("[^0-9]", "");
		String monto2 = String.valueOf(base.montoTransado);
		boolean validacion = false;
		if (monto.contains(monto2)) {
			validacion = true;
		}

		assertTrue(validacion);
	}

	public void validoQueSeGenereLaOTP() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.txtMensajeNotificacionSacarPlata)));
		String textoOTP = driver.findElement(By.xpath(this.txtMensajeNotificacionSacarPlata)).getText();
		boolean validacion = false;
		if (textoOTP.contains("Su código para sacar plata es:")) {
			validacion = true;
			String codigoOTP = utilidadesTCS.obtenerTexto("xpath", SacarPlataPageObjects.CODIGO_OTP);
			System.out.println("El código OTP es: " + codigoOTP);
		}
		assertTrue(validacion);
	}

	public void validoQueSeGenereSaldoInsuficiente() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtMensajeNotificacion)));
		String textoOTP = driver.findElement(By.xpath(this.txtMensajeNotificacion)).getText();
		System.out.println("Este es el mensaje: " + textoOTP);
		boolean validacion = false;
		if (textoOTP.contains("EXCEDE CUPO") || textoOTP.equalsIgnoreCase("Excede cupo")) {
			validacion = true;
		}
		assertTrue(validacion);
	}

	public void validoValorErrado() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.txtMensajeNotificacion)));
		String textoOTP = driver.findElement(By.xpath(this.txtMensajeNotificacion)).getText();
		boolean validacion = false;
		if (textoOTP.contains("El monto debe ser múltiplo de 10.000 y menor a 720.000")) {
			validacion = true;
		}
		assertTrue(validacion);
	}

	public void cerrarAlerta() {
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(197, 120)).perform();
	}

	public void clickBotonX() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnX)));
			driver.findElement(By.xpath(this.btnX)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				clickBotonX();
			} else {
				fail("No se encontró boton X debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void botonAtras() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAtras)));
			driver.findElement(By.xpath(this.btnAtras)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				botonAtras();
			} else {
				fail("No se encontró boton ATRAS debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void botonAtras2() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAtras2)));
			driver.findElement(By.xpath(this.btnAtras2)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				botonAtras2();
			} else {
				fail("No se encontró boton ATRAS debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void validoLblExcedeCupo() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.labelCuentaNoExiste)));
			MobileElement lblCupo = driver.findElement(By.xpath(this.labelCuentaNoExiste));
			assertEquals("EXCEDE CUPO", lblCupo.getText());
			utilidad.tomaEvidencia("Valido mensaje excede cupo");
			base.montoTransado = new BigDecimal(0);
			lblCupo.click();
		} catch (Exception e) {
			if (!(contador == 20)) {
				Utilidades.esperaMiliseg(2000);
				validoLblExcedeCupo();
			} else {
				fail("No se pudo validar el mensaje de Excede Cupo debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void seleccionoMonto(String monto) {
		BigDecimal bigDecimal = new BigDecimal(monto);
		base.montoTransado = bigDecimal;
		try {
			contador++;
			switch (monto) {
			case "20000":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.checkboxVeinteMil)));
				driver.findElement(By.xpath(this.checkboxVeinteMil)).click();
				break;
			case "50000":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.checkboxCincuentaMil)));
				driver.findElement(By.xpath(this.checkboxCincuentaMil)).click();
				break;
			case "100000":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.checkboxCienMil)));
				driver.findElement(By.xpath(this.checkboxCienMil)).click();
				break;
			case "200000":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.checkboxDocientosMil)));
				driver.findElement(By.xpath(this.checkboxDocientosMil)).click();
				break;

			default: {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.montoDiferente)));
				driver.findElement(By.xpath(this.montoDiferente)).sendKeys(monto);
			}

			}
		} catch (Exception e) {
			if (!(contador == 10)) {
				utilidad.esperaMiliseg(2000);
				seleccionoMonto(monto);
			} else {
				fail("No se pudo encontrar checkbox de sacar plata, ni input para ingresar monto en sacar plata, debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void cerrarPopUpProgramacionRetiro() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.popUpRetiro)));
			driver.findElement(By.xpath(this.popUpRetiro)).click();
		} catch (Exception e) {
			System.out.println("No se encontró botón de cierre del PopUp de programación de retiro, debido a: " + e.getMessage());

		}
	}

}
