package daviplata.nacional.iOS.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import daviplata.nacional.iOS.definitions.Hooks;
import daviplata.nacional.iOS.utilidades.Utilidades;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import net.serenitybdd.core.pages.PageObject;

public class PagosMarketPlacePageObjects extends PageObject {
    
	private AppiumDriver<MobileElement> driver = Hooks.getDriver();
	private WebDriverWait wait = Hooks.getDriverWait();
	Utilidades utilidad;
	Utilidades Utilidades;

	private String btnGaleria = "//XCUIElementTypeButton[@name=\"ic qr gallery\"]";
	private String btnMomentosGaleria = "//XCUIElementTypeCell[@name=\"Momentos\"]";
	private String fotoQrDaviplataSinValor = "//XCUIElementTypeCell[@name=\"Captura de pantalla, Vertical, 17 de julio, 5:35 p. m.\"]";
	private String fotoQrCtaAhorrosSinValor = "";
	private String fotoQrCtaCorrienteSinValor = "";
	private String fotoQrDaviplataConValor = "";
	private String fotoQrCtaAhorrosConValor = "";
	private String fotoQrCtaCorrienteConValor = "";
	private String btnUsarFoto = "//XCUIElementTypeButton[@name=\"Usar\"]";
	private String btnCancelarFoto = "//XCUIElementTypeButton[@name=\"Cancelar\"]";
	private String inpValorQr = "//XCUIElementTypeApplication[@name=\"DaviPlata\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeTextField";
	private String lblTransSinCosto = "//XCUIElementTypeStaticText[@name=\"Esta transacción no tiene costo\"]";
	private String lblIngreseDatosTrans = "//XCUIElementTypeStaticText[@name=\"Ingrese los datos para completar su compra\"]";
	private String lblCualEsValor = "//XCUIElementTypeStaticText[@name=\"¿Cuál es el valor de la compra?\"]";
	private String btnAceptar = "//XCUIElementTypeButton[@name=\"Aceptar\"]";
	private String btnContinuar = "//XCUIElementTypeButton[@name=\"Continuar\"]";
	private String inpClaveDaviplata = "//XCUIElementTypeApplication[@name=\"DaviPlata\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeSecureTextField";
	private String btnPagar = "//XCUIElementTypeButton[@name=\"Pagar\"]";
	private String lblExcedeCupo = "//XCUIElementTypeStaticText[@name=\"EXCEDE CUPO\"]";
	private String btnLeerQrPagar = "(//XCUIElementTypeButton[@name=\"arrow red\"])[1]";
	private String btnCrearCodigo = "(//XCUIElementTypeButton[@name=\"arrow red\"])[2]";
	private String lblExitosa = "//XCUIElementTypeApplication[@name=\"DaviPlata\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]";
	private String lblCuantoPaga = "//XCUIElementTypeApplication[@name=\"DaviPlata\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]";
	private String lblFechaTransaccion = "//XCUIElementTypeApplication[@name=\"DaviPlata\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]";
	private String lblValorTrans = "//XCUIElementTypeApplication[@name=\"DaviPlata\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[5]";
	private String lblNumeroAutorizacion = "//XCUIElementTypeApplication[@name=\"DaviPlata\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[4]/XCUIElementTypeStaticText[2]";
	private String btnFinalizar = "//XCUIElementTypeButton[@name=\"Finalizar\"]";
	private String lblWheelDondeQuierePlata = "//XCUIElementTypeStaticText[@name=\"DaviPlata\"]";
	private String wheelDondeQuierePlata = "//XCUIElementTypeApplication[@name=\"DaviPlata\"]/XCUIElementTypeWindow[4]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypePicker/XCUIElementTypePickerWheel";
	private String btnDone = "//XCUIElementTypeButton[@name=\"Done\"]";
	private String inpNumeroProd = "//XCUIElementTypeApplication[@name=\"DaviPlata\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField";
	private String chkConValor = "//XCUIElementTypeApplication[@name=\"DaviPlata\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeButton";
	private String chkSinValor = "//XCUIElementTypeApplication[@name=\"DaviPlata\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeButton";
	private String lblCodigoGeneradoExitoso = "//XCUIElementTypeStaticText[@name=\"Código generado de forma exitosa\"]";
	private String btnDescargar = "//XCUIElementTypeButton[@name=\"Descargar\"]";
	private String lblNumDaviPlata = "//XCUIElementTypeStaticText[@name=\"DaviPlata - 3355555544\"]";
	private String lblCuantaPlata = "";
	private String lblFechaCreacion = "";
	private String inpNombrePDF = "//XCUIElementTypeApplication[@name=\"DaviPlata\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField";
	private String btnPrivateComprar = "(//XCUIElementTypeButton[@name=\"arrow red\"])[1]";
	private String btnPrivateVender = "(//XCUIElementTypeButton[@name=\"arrow red\"])[1]";

	// xpath de QR EMVCO

	private String lblNombreVendedor = "//XCUIElementTypeStaticText[@name=\"Por favor revise los datos antes de completar la transacción.\"]/following::XCUIElementTypeStaticText[1]";
	private String lblValor = "//XCUIElementTypeStaticText[@name=\"Valor\"]/following::XCUIElementTypeTextField[1]";
	private String lblConfirValor = "//XCUIElementTypeStaticText[@name=\"Valor de la compra\"]/following::XCUIElementTypeStaticText[1]";
	private String lblConfirIVA = "//XCUIElementTypeStaticText[@name=\"IVA\"]/following::XCUIElementTypeStaticText[2]";
	private String lblConfirINC = "//XCUIElementTypeStaticText[@name=\"INC\"]/following::XCUIElementTypeStaticText[2]";
	private String lblConfirPropina = "//XCUIElementTypeStaticText[@name=\"Propina\"]/following::XCUIElementTypeStaticText[2]";
	private String lblValorTotal = "//XCUIElementTypeStaticText[@name=\"TOTAL A PAGAR\"]/following::XCUIElementTypeStaticText[1]";
	private String lblPassDaviplata = "(//XCUIElementTypeImage[@name=\"ico_clave\"]/ancestor-or-self::XCUIElementTypeOther[1]/following::XCUIElementTypeSecureTextField)";
	private String lblTransaccionExitosa = "//XCUIElementTypeStaticText[@name=\"Transacción exitosa\"]";
	private String lblNombreVendedorTx = "//XCUIElementTypeStaticText[@name=\\\"Transacción exitosa\\\"]/following::XCUIElementTypeStaticText[1]";
	private String lblNumComprobacion = "//XCUIElementTypeStaticText[@name=\"Redeban\"]/following::XCUIElementTypeStaticText[1]";
	private String lblValorTotalTx = "//XCUIElementTypeStaticText[@name=\"TOTAL\"]/following::XCUIElementTypeStaticText[1]";

	public void clicBtnGaleria() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnGaleria)));
		Utilidades.tomaEvidencia("Clic boton entrar a Galeria");
		element.click();
	}

	public void clicBtnMomentosGaleria() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnMomentosGaleria)));
		Utilidades.tomaEvidencia("Clic boton Momentos Galeria");
		element.click();
	}

	public void clicFotoQrDaviplataSinValor() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.fotoQrDaviplataSinValor)));
		Utilidades.tomaEvidencia("Clic boton Foto QR Daviplata Sin Valor");
		element.click();
	}

	public void clicFotoQrCtaAhorrosSinValor() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.fotoQrCtaAhorrosSinValor)));
		Utilidades.tomaEvidencia("Clic boton Foto QR Cta Ahorros Sin Valor");
		element.click();
	}

	public void clicFotoQrCtaCorrienteSinValor() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.fotoQrCtaCorrienteSinValor)));
		Utilidades.tomaEvidencia("Clic boton Foto QR Cta Corriente Sin Valor");
		element.click();
	}

	public void clicFotoQrDaviplataConValor() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.fotoQrDaviplataConValor)));
		Utilidades.tomaEvidencia("Clic boton Foto QR Daviplata Con Valor");
		element.click();
	}

	public void clicFotoQrCtaCorrienteConValor() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.fotoQrCtaCorrienteConValor)));
		Utilidades.tomaEvidencia("Clic boton Foto QR Cta Corriente Con Valor");
		element.click();
	}

	public void clicFotoQrCtaAhorrosConValor() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.fotoQrCtaAhorrosConValor)));
		Utilidades.tomaEvidencia("Clic boton Foto QR Cta Ahorros Con Valor");
		element.click();
	}

	public void clicBtnUsarFoto() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnUsarFoto)));
		Utilidades.tomaEvidencia("Clic boton Usar Foto");
		element.click();
	}

	public void clicBtnCancelarFoto() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCancelarFoto)));
		Utilidades.tomaEvidencia("Clic boton Cancelar Foto");
		element.click();
	}

	public void sendKeysValorQr(String text) {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inpValorQr)));
		element.sendKeys(text);
		Utilidades.tomaEvidencia("Ingreso valor:" + text);
	}

	public void validoLblTransSinCosto() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.lblTransSinCosto)));
		Assert.assertTrue(element.isEnabled());
	}

	public void validoLblIngreseDatosTrans() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.lblIngreseDatosTrans)));
		Assert.assertTrue(element.isEnabled());
	}

	public void validoLblCualEsValor() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.lblCualEsValor)));
		Assert.assertTrue(element.isEnabled());
	}

	public void clicBtnAceptar() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptar)));
		Utilidades.tomaEvidencia("Clic boton Aceptar");
		element.click();
	}

	public void clicBtnContinuar() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuar)));
		Utilidades.tomaEvidencia("Clic boton Aceptar");
		element.click();
	}

	public void sendKeysClaveDaviplata(String text) {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inpClaveDaviplata)));
		element.sendKeys(text);
		Utilidades.tomaEvidencia("Ingreso valor:" + text);
	}

	public void clicBtnPagar() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnPagar)));
		Utilidades.tomaEvidencia("Clic boton Pagar");
		element.click();
	}

	public void validoLblExcedeCupo() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.lblExcedeCupo)));
		Assert.assertTrue(element.isEnabled());
	}

	public void clicBtnLeerQrPagar() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnLeerQrPagar)));
		Utilidades.tomaEvidencia("Clic boton Leer QR Pagar");
		element.click();
	}

	public void clicBtnCrearCodigo() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCrearCodigo)));
		Utilidades.tomaEvidencia("Clic boton Crear Codigo QR");
		element.click();
	}

	public void validoLblExitosa() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.lblExitosa)));
		Assert.assertTrue(element.isEnabled());
	}

	public String vuelveValorPagado() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.lblCuantoPaga)));
		return element.getText();
	}

	public String vuelveLblFechaTransaccion() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.lblFechaTransaccion)));
		return element.getText();
	}

	public String vuelveLblValorTrans() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.lblValorTrans)));
		return element.getText();
	}

	public String vuelveLblNumeroAutorizacion() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.lblNumeroAutorizacion)));
		return element.getText();
	}

	public void clicBtnFinalizar() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnFinalizar)));
		Utilidades.tomaEvidencia("Clic boton Leer QR Pagar");
		element.click();
	}

	public void clicLblWheelDondeQuierePlata() {
		Utilidades.esperaMiliseg(1000);
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable((By.xpath(this.lblWheelDondeQuierePlata))));
		Utilidades.tomaEvidencia("Clic wheel Donde quiere recivir la plata");
		element.click();
	}

	public void selectWheelDondeQuierePlata(String value) {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.wheelDondeQuierePlata)));
		Utilidades.pickerWheelSelect(element, value);
		Utilidades.tomaEvidencia("Selecciona " + value);
		clicBtnDone();
	}

	public void clicBtnDone() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnDone)));
		Utilidades.tomaEvidencia("Clic en Done");
		element.click();
	}

	public void sendKeysInpNumeroProd(String text) {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inpNumeroProd)));
		element.sendKeys(text);
		Utilidades.tomaEvidencia("Ingreso valor:" + text);
	}

	public void clicChkConValor() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.chkConValor)));
		Utilidades.tomaEvidencia("Clic check con valor");
		element.click();
	}

	public void clicChkSinValor() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.chkSinValor)));
		Utilidades.tomaEvidencia("Clic check con valor");
		element.click();
	}

	public void validoLblCodigoGeneradoExitoso() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.lblCodigoGeneradoExitoso)));
		Assert.assertTrue(element.isEnabled());
		Utilidades.tomaEvidencia("Valido label de Generado Exitoso");
	}

	public void clicBtnDescargar() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnDescargar)));
		Utilidades.tomaEvidencia("Clic en Descargar");
		element.click();
	}

	public void validoImgQRPDF() {
		Utilidades.esperaMiliseg(4000);
		MobileElement element = (MobileElement) driver.findElement((By.xpath(
				"//XCUIElementTypeOther[@name=\"QLPreviewControllerView\"]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther")));
		Assert.assertTrue(element.isEnabled());
		Utilidades.tomaEvidencia("Valido PDF con QR");
	}

	public void sendKeysInpNombrePDF(String text) {
		Utilidades.esperaMiliseg(500);
		MobileElement element = (MobileElement) driver.findElement(By.xpath(this.inpNombrePDF));
		element.sendKeys(text);
		Utilidades.tomaEvidencia("Ingreso valor:" + text);
	}

	public void validoNumeroRecibir(String tipo, String value) {
		MobileElement element = (MobileElement) driver
				.findElement((By.xpath("//XCUIElementTypeStaticText[@name=\"" + tipo + " - " + value + "\"]")));
		Assert.assertTrue(element.isEnabled());
	}

	public void validoCuantaPlata(String value) {
		MobileElement element = (MobileElement) driver
				.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"" + value + "\"]"));
		Assert.assertTrue(element.isEnabled());
	}

	public void clicBtnPrivateComprarQR() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnPrivateComprar)));
		Utilidades.tomaEvidencia("Clic boton pagar QR");
		element.click();
	}

	public void clicBtnPrivateVentaQR() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnPrivateVender)));
		Utilidades.tomaEvidencia("Clic en Descargar");
		element.click();
	}

	public String returnLblNombreVendedor() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.lblNombreVendedor)));
		return element.getText();
	}
	
	public String returnLblValor() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.lblValor)));
		Utilidades.tomaEvidencia("Valores de QR");
		return element.getText();
	}
	
	public String returnLblConfirValor() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.lblConfirValor)));

		return element.getText();
	}

}
