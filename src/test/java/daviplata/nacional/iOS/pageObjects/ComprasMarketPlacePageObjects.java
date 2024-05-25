package daviplata.nacional.iOS.pageObjects;

import static org.junit.Assert.assertEquals;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import daviplata.nacional.iOS.definitions.Hooks;
import daviplata.nacional.iOS.utilidades.Utilidades;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import net.serenitybdd.core.pages.PageObject;

public class ComprasMarketPlacePageObjects extends PageObject {

	private AppiumDriver<MobileElement> driver = Hooks.getDriver();
	private WebDriverWait wait = Hooks.getDriverWait();
	
	Utilidades utilidad;
	Utilidades Utilidades;

	private String btnTiendaVirtual = "//XCUIElementTypeButton[@name=\"ico tienda virtual\"]";

	// -------Menu Principal Tienda---------//
	private String btnPagosServicios = "//XCUIElementTypeOther[@name=\"Pago de Servicios\"]";
	private String btnRecargas = "//XCUIElementTypeOther[@name='Recargas']";
	private String btnSeguros = "//XCUIElementTypeOther[@name='Seguros']";

	// -------------Pago de Servicios-----------------//
	private String btnLuz = "//XCUIElementTypeStaticText[@name='Luz']";
	private String btnGas = "//XCUIElementTypeStaticText[@name='Gas']";
	private String btnAgua = "//XCUIElementTypeStaticText[@name=\"Agua\"]";
	private String btnMinutos = "//XCUIElementTypeStaticText[@name=\"Minutos\"]";
	private String btnOtrosServicios = "//XCUIElementTypeStaticText[@name='Otros Servicios']";
	private String btnAcueducto = "//XCUIElementTypeStaticText[@name=\"ACUEDUCTO\"]";
	private String btnGasPrueba = "//XCUIElementTypeStaticText[@name=\"Pago de gas 2\"]";
	private String txtRefServicios = "//XCUIElementTypeTextField[@name=\"Escriba número de referencia\"]";
	private String btnPagarServicios = "//XCUIElementTypeButton[@name=\"Pagar\"]";
	private String lblNoPermitePago = "//XCUIElementTypeStaticText[@name=\"Error en el sistema, intente más tarde\"]";
	private String lblRefNoExiste = "//XCUIElementTypeStaticText[@name=\"Nro factura no existe\"]";
	private String btnOtroServicios = "//XCUIElementTypeStaticText[@name=\"Otros servicios\"]";

	// -------------Seguros-----------------//
	private String btnSeguroVida = "//XCUIElementTypeStaticText[@name='Vida']";
	private String btnSeguroMascotas = "//XCUIElementTypeStaticText[@name=\"Mascota\"]";
	private String btnSeguroMascotaOpcion1 = "(//XCUIElementTypeButton[@name=\"Seleccionar\"])[1]";
	private String btnSeguroMascotaOpcion2 = "(//XCUIElementTypeButton[@name=\"Seleccionar\"])[2]";
	private String btnSeguroBicicleta = "//XCUIElementTypeStaticText[@name=\"BIcicleta\"]";
	private String btnSeguroBicicletaOpcion1 = "(//XCUIElementTypeButton[@name=\"Seleccionar\"])[1]";
	private String btnSeguroBicicletaOpcion2 = "(//XCUIElementTypeStaticText[@name=\"Seleccionar\"])[2]";
	private String btnSeguroSoat = "//XCUIElementTypeStaticText[@name=\"SOAT\"]";
	private String btnOpcion1 = "(//XCUIElementTypeButton[@name=\"Seleccionar\"])[1]";
	private String btnOpcion2 = "(//XCUIElementTypeButton[@name=\"Seleccionar\"])[2]";
	private String txtYaTieneSeguro = "//XCUIElementTypeStaticText[@name=\"Usted ya cuenta con seguro vigente, para más información escribanos por la opción necesita ayuda\"]";
	private String lblFondosInsuficientes = "//XCUIElementTypeStaticText[@name=\"Fondos insuficientes\"]";

	// ----------------botones--------------//

	private String btnContinuar = "(//XCUIElementTypeButton[@name='Continuar'])[1]";
	private String btnContinuarSex = "(//XCUIElementTypeButton[@name='Continuar'])[2]";
	private String btnAceptar = "//XCUIElementTypeButton[@name=\"Aceptar\"]";
	private String btnAtras = "//XCUIElementTypeButton[@name=\"Botón atrás\"]";
	private String btnDone = "//XCUIElementTypeButton[@name=\"Done\"]";
	private String btnSelectorFecha = "(//XCUIElementTypeButton[@name=\"selector arrow down red\"])[1]";
	private String btnSelectorSexo = "(//XCUIElementTypeButton[@name=\"selector arrow down red\"])[2]";
	private String btnSelectorTipoMascota = "//XCUIElementTypeButton[@name=\"selector arrow down red\"]";
	private String btnSelectorAño = "//XCUIElementTypeButton[@name=\"selector arrow down red\"]";
	private String selectTipoMascota = "//XCUIElementTypePickerWheel[1]";
	private String selectMes = "//XCUIElementTypePickerWheel[1]";
	private String selectSexo = "//XCUIElementTypePickerWheel[1]";
	private String selectDia = "//XCUIElementTypePickerWheel[2]";
	private String selectAño = "//XCUIElementTypePickerWheel[3]";
	private String selectAñoBici = "//XCUIElementTypePickerWheel[1]";
	private String AceptarTermiCondiciones = "//XCUIElementTypeButton[@name=\"radio btn normal\"]";
	private String lblDaviplata = "//XCUIElementTypeButton[@name=\"Cambiar clave por olvido\"]";
	private String txtIngresoPlaca = "//XCUIElementTypeOther[@name=\"main\"]/XCUIElementTypeTextField";
	private String btnSeguroSiPropio = "//XCUIElementTypeStaticText[@name=\"Si\"]";
	private String btnSeguroNoPropio = "//XCUIElementTypeOther[@name=\"main\"]/XCUIElementTypeOther[8]";
	private String lblPlacaInvalida = "//XCUIElementTypeStaticText[@name=\"Debe ingresar una placa válida\"]";
	private String btnCotizarSoat = "//XCUIElementTypeButton[@name=\"Cotizar\"]";
	private String btnComprarSeguro = "//XCUIElementTypeOther/XCUIElementTypeButton";
	private String btnFinalizar = "//XCUIElementTypeButton[@name=\"Finalizar\"]";
	private String btnFinalizar1 = "//XCUIElementTypeButton[@name=\"Comprar\"]";
	private String lblCompraExitosa = "//XCUIElementTypeStaticText[@name=\"Transacción exitosa\"]";
	private String lblNoPermiteCompraSeguroVida = "//XCUIElementTypeStaticText[@name=\"Cliente no esta dentro del rango de edad, para más información escribanos por la opción necesita ayuda.\"]";
	private String btnCerrar = "//XCUIElementTypeButton[@name=\"Cerrar sesión\"]";
	private String btnCiudadSoat = "//XCUIElementTypeOther[@name=\"main\"]/XCUIElementTypeTextField[2]";
	private String btnSelectCalle = "//XCUIElementTypeOther[@name=\"main\"]/XCUIElementTypeOther[6]";
	private String selectCalle = "//XCUIElementTypePickerWheel[1]";
	private String txtDirección1 = "//XCUIElementTypeOther[@name=\"main\"]/XCUIElementTypeTextField[3]";
	private String txtDirección2 = "//XCUIElementTypeOther[@name=\"main\"]/XCUIElementTypeTextField[4]";
	private String txtDirección3 = "//XCUIElementTypeOther[@name=\"main\"]/XCUIElementTypeTextField[5]";
	private String txtTorreApto = "//XCUIElementTypeOther[@name=\"main\"]/XCUIElementTypeTextField[6]";
	private String txtCorreo = "//XCUIElementTypeOther[@name=\"main\"]/XCUIElementTypeTextField[7]";
	private String txtDatoOpcional = "//XCUIElementTypeOther[@name=\"main\"]/XCUIElementTypeTextField[8]";
	private String btnTerminosCondiciones = "//XCUIElementTypeOther[@name=\"main\"]/XCUIElementTypeSwitch";

	// -----------Bonos------------//
	private String btnAliado1Descuentos = "//XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]";
	private String btnAliado2Descuentos = "//XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeCollectionView/XCUIElementTypeCell[2]";
	private String btnAlidos3Descuentos = "//XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeCollectionView/XCUIElementTypeCell[3]";
	private String btnBonoDunkin = "//XCUIElementTypeStaticText[@name=\"Bonos de donas y café\"]";
	private String btnMcDonalds = "//XCUIElementTypeImage[@name='Bono $10.000']";
	private String btnBonoElCorral = "//XCUIElementTypeStaticText[@name=\"Bonos de hamburguesas y malteadas\"]";
	private String btnBono20mil = "//XCUIElementTypeImage[@name=\"Bono $20.000\"]";
	private String btnBono11700 = "//XCUIElementTypeImage[@name=\"Dunkin Donuts Caja x 6\"]";
	private String btnEditImage = "//XCUIElementTypeOther/XCUIElementTypeOther[13]/XCUIElementTypeImage";
	private String txtCorreoBono = "//XCUIElementTypeTextField";
	private String lapizCorreo = "//XCUIElementTypeOther[@name=\"Quantum - DaviPlata: Catalogs\"]/XCUIElementTypeOther[13]";
	private String btnCompra = "//XCUIElementTypeButton[@name=\"Comprar\"]";
	private String btnDescargarBono = "//XCUIElementTypeStaticText[@name=\"Descargar\"]";
	private String lblDescargaBono = "//XCUIElementTypeStaticText[@name=\"Boleta.pdf\"]";
	private String lblTransacionExitosa = "//XCUIElementTypeStaticText[@name=\"Transacción Exitosa\"]";
	private String btnDesplegableDepartamento = "//XCUIElementTypeOther[@name=\"Quantum - DaviPlata: Catalogs\"]/XCUIElementTypeOther[8]/XCUIElementTypeOther";
	private String selectUbicacionDepartamento = "//XCUIElementTypePickerWheel[1]";
	private String btnDesplegableCiudad = "//XCUIElementTypeOther[@name=\"Quantum - DaviPlata: Catalogs\"]/XCUIElementTypeOther[9]/XCUIElementTypeOther";
	private String selectUbicacionCiudad = "//XCUIElementTypePickerWheel[1]";
	private String btnEstablecimiento = "//XCUIElementTypeOther[@name=\"Quantum - DaviPlata: Catalogs\"]/XCUIElementTypeOther[10]/XCUIElementTypeOther";
	private String selectEstablecimiento = "//XCUIElementTypePickerWheel[1]";
	private String txtFechaHora = "//XCUIElementTypeOther[2]/XCUIElementTypeOther[4]";
    private String popupNew = "//XCUIElementTypeImage[@name=\"notif_bkg.png\"]";
    private String popupNewTV = "//XCUIElementTypeButton[@name=\"Aceptar\"]";
    
    
	public void clicBtnTiendaVirtual() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.popupNew)));
			driver.findElement(By.xpath(this.popupNew)).click();
		} catch (Exception e) {
			// TODO: handle exception
		} 

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnTiendaVirtual)));
		driver.findElement(By.xpath(this.btnTiendaVirtual)).click();
		Utilidades.tomaEvidencia("Click en botòn Tienda virtual.");
	}

	public void clicBtnTiendaVirtualFlujoVolver() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnTiendaVirtual)));
		driver.findElement(By.xpath(this.btnTiendaVirtual));
		Utilidades.tomaEvidencia("Verifico ventana anterior");
		Utilidades.tomaEvidencia("Verifico ventana home");
	}

	public void clicBtnAtras() {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnFinalizar)));
			driver.findElement(By.xpath(this.btnFinalizar)).click();
			Utilidades.tomaEvidencia("Click en botòn finalizar.");
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAtras)));
			driver.findElement(By.xpath(this.btnAtras)).click();
			Utilidades.tomaEvidencia("Click en botòn Atras.");
			
		} catch (Exception e) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAtras)));
			driver.findElement(By.xpath(this.btnAtras)).click();
			Utilidades.tomaEvidencia("Click en botòn Atras.");
		}
	}

	// ------------Pago Servicios----------//
	public void clicBtnPagoServicios() {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnPagosServicios)));
		driver.findElement(By.xpath(this.btnPagosServicios)).click();
		Utilidades.tomaEvidencia("Click en botòn Pago de Servicios.");
	}

	public void clicBtnOtrosServicios() {
		Utilidades.moverPantallaUpiOS(driver);
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnOtroServicios)));
		driver.findElement(By.xpath(this.btnOtroServicios)).click();
		Utilidades.tomaEvidencia("Click en botòn Otros Servicios.");
	}

	public void clicBtnPagoServiciosLuz() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnLuz)));
		driver.findElement(By.xpath(this.btnLuz)).click();
		Utilidades.tomaEvidencia("Click en botòn Pago de Servicios de luz");
	}

	public void clicBtnPagoServiciosGas() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnGas)));
		driver.findElement(By.xpath(this.btnGas)).click();
		Utilidades.tomaEvidencia("Click en botòn Pago de Servicios de Gas");
	}

	public void clicBtnPagoServiciosGasPrueba2() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnGasPrueba)));
		driver.findElement(By.xpath(this.btnGasPrueba)).click();
		Utilidades.tomaEvidencia("Click en botòn Gas 2");
	}

	public void clicBtnPagoServiciosAgua() { 
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAgua)));
		driver.findElement(By.xpath(this.btnAgua)).click();
		Utilidades.tomaEvidencia("Click en botòn Pago de Servicios de Agua");
	}

	public void clicBtnPagoServiciosAguaAcueducto() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAcueducto)));
		driver.findElement(By.xpath(this.btnAcueducto)).click();
		Utilidades.tomaEvidencia("Click en botòn Acueducto");
	}

	public void clicBtnPagoServiciosMinutos() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnMinutos)));
		driver.findElement(By.xpath(this.btnMinutos)).click();
		Utilidades.tomaEvidencia("Click en botòn Pago de Servicios de Minutos");
	}

	public void clicBtnPagoOtrosServicios() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnOtrosServicios)));
		driver.findElement(By.xpath(this.btnOtrosServicios)).click();
		Utilidades.tomaEvidencia("Click en botòn Pago de otro servicios.");
	}

	public void clicBtnRecargas() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnRecargas)));
		driver.findElement(By.xpath(this.btnRecargas)).click();
		Utilidades.tomaEvidencia("Click en botón Recargas.");
	}

	public void clicBtnContinuarPagoServicios() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuar)));
		driver.findElement(By.xpath(this.btnContinuar)).click();
		Utilidades.tomaEvidencia("Clic en continuar pagar el servicio");
	}

	public void clicBtnPagarServicios() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnPagarServicios)));
		driver.findElement(By.xpath(this.btnPagarServicios)).click();
		Utilidades.tomaEvidencia("Clici en pagar el servicio");

	}

	public void clicTxtRefServicios(String referencia) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtRefServicios)));
		driver.findElement(By.xpath(this.txtRefServicios)).sendKeys(referencia);
		Utilidades.tomaEvidencia("Ingreso la referencia pagar el servicio");
	}

	public void ValidoLblReferenciaErradapPagoServicios() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.lblNoPermitePago)));
		String lblMensaje = driver.findElement(By.xpath(this.lblNoPermitePago)).getText();
		assertEquals("Error en el sistema, intente más tarde", lblMensaje);
		Utilidades.tomaEvidencia("Verifico que no permite pagar el servicio");
	}

	public void validoLblReferenciaNoExistePagoServicios() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.lblRefNoExiste)));
		String lblMensaje = driver.findElement(By.xpath(this.lblRefNoExiste)).getText();
		assertEquals("Nro factura no existe", lblMensaje);
		Utilidades.tomaEvidencia("Verifico que no permite pagar el servicio");
	}

	public void validoLblDescargBono() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.lblDescargaBono)));
		String lblMensaje = driver.findElement(By.xpath(this.lblDescargaBono)).getText();
		assertEquals("Boleta.pdf", lblMensaje);
		Utilidades.tomaEvidencia("Verifico que se descargo el bono");
	}

	// -----------------Seguros-------------//

	public void clicBtnSeguros() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		try {
			Utilidades.tomaEvidencia("Aceptar popUp primera vez tienda virtual");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.popupNewTV)));
			driver.findElement(By.xpath(this.popupNewTV)).click();
		} catch (Exception e) {
			
		}

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSeguros)));
		driver.findElement(By.xpath(this.btnSeguros)).click();
		Utilidades.tomaEvidencia("Click en botón Seguros.");
	}

	public void clicBtnSegurosFlujoVolver() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSeguros)));
		driver.findElement(By.xpath(this.btnSeguros)).isEnabled();
		Utilidades.tomaEvidencia("Verifico ventana anterior");
	}

	public void clicBtnSeguroVida() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSeguroVida)));
		driver.findElement(By.xpath(this.btnSeguroVida)).click();
		Utilidades.tomaEvidencia("Click en botòn Tienda virtual.");
		Utilidades.moverPantallaUpiOS(driver);
	}

	public void clicBtnSeguroVidaOpciones(String opcion) {
		WebDriverWait wait = new WebDriverWait(driver, 30);		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnOpcion1)));
		MobileElement btnSeguroVidaOp1 = driver.findElement(By.xpath(this.btnOpcion1));
		System.out.println(opcion);

		switch (opcion) {

		case "1":
		
			btnSeguroVidaOp1.click();
			Utilidades.tomaEvidencia("Click en botón Seguro Opción 1.");
			break;
		case "2":
			try {
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnOpcion2)));
				driver.findElement(By.xpath(this.btnOpcion2)).click();
			} catch (Exception e) {
				Utilidades.darTapiOS(driver, 240, 730);
			}
			
			Utilidades.tomaEvidencia("Click en botón Seguro Opción 2.");
			break;

		default:
			Utilidades.tomaEvidencia("Click en botón Seguro Opción 1.");
			btnSeguroVidaOp1.click();
			break;
		}

	}

	public void clicBtnSeguroBicicleta() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSeguroBicicleta)));
		driver.findElement(By.xpath(this.btnSeguroBicicleta)).click();
		Utilidades.tomaEvidencia("Click en botón seguro Bicicleta.");
		Utilidades.moverPantallaUpiOS(driver);
	}

	public void clicBtnSeguroBiciletaOpcion1() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSeguroBicicletaOpcion1)));
		driver.findElement(By.xpath(this.btnSeguroBicicletaOpcion1)).click();
		Utilidades.tomaEvidencia("Click en botón Seguro Opción 1.");
	}
	
	public void clicBtnSeguroBiciletaOpciones(String opcion) {
		
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSeguroBicicletaOpcion1)));
		MobileElement btnSeguroVidaBi1 = driver.findElement(By.xpath(this.btnSeguroBicicletaOpcion1));
		Utilidades.tomaEvidencia("Click en botón Seguro Opción 1.");
		System.out.println(opcion);
	//	
		switch (opcion) {

		case "1":
			Utilidades.tomaEvidencia("Click en botón Seguro Opción 1.");
			btnSeguroVidaBi1.click();
			
			break;
		case "2":
			try {
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSeguroBicicletaOpcion2)));
				MobileElement btnSeguroVidaBi2 = driver.findElement(By.xpath(this.btnSeguroBicicletaOpcion2));
				Utilidades.tomaEvidencia("Click en botón Seguro Opción 2.");
				btnSeguroVidaBi2.click();
			} catch (Exception e) {
				Utilidades.tomaEvidencia("Click en botón Seguro Opción 2.");
				Utilidades.darTapiOS(driver, 240, 730);
			}
			
			
			break;

		default:
			Utilidades.tomaEvidencia("Click en botón Seguro Opción 1.");
			btnSeguroVidaBi1.click();
			break;
		}
		
		
	}

	public void clicSelectorAñoBici() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSelectorAño)));
		driver.findElement(By.xpath(this.btnSelectorAño)).click();
	}

	public void selectAñoBici(String año) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSelectorAño)));
		MobileElement selectAñoBici = driver.findElement(By.xpath(this.btnSelectorAño));
		Utilidades.pickerWheelSelect(selectAñoBici, año);
	}

	public void clicBtnContinuarBici() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarSex)));
			driver.findElement(By.xpath(this.btnContinuarSex)).click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuar)));
			driver.findElement(By.xpath(this.btnContinuar)).click();
		}
	}

	public void clicBtnSeguroMascotas() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSeguroMascotas)));
		driver.findElement(By.xpath(this.btnSeguroMascotas)).click();
		Utilidades.tomaEvidencia("Click en botòn seguro Mascotas");
		Utilidades.moverPantallaUpiOS(driver);
	}

	public void clicBtnSeguroMascotaOpciones(String opcion) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSeguroMascotaOpcion1)));
		MobileElement btnSeguroVidaMa1 = driver.findElement(By.xpath(this.btnSeguroMascotaOpcion1));
		System.out.println(opcion);
		
		switch (opcion) {

		case "1":
			Utilidades.tomaEvidencia("Click en botón Seguro Opción 1.");
			btnSeguroVidaMa1.click();
			
			break;
		case "2":
			try {
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSeguroMascotaOpcion2)));
				MobileElement btnSeguroVidaMa2 = driver.findElement(By.xpath(this.btnSeguroMascotaOpcion2));
				Utilidades.tomaEvidencia("Click en botón Seguro Opción 2.");
				btnSeguroVidaMa2.click();
			} catch (Exception e) {
				Utilidades.tomaEvidencia("Click en botón Seguro Opción 2.");
				Utilidades.darTapiOS(driver, 240, 730);
			}
			
			
			break;

		default:
			Utilidades.tomaEvidencia("Click en botón Seguro Opción 1.");
			btnSeguroVidaMa1.click();
			break;
		}
	}

	public void clicBtnSeguroMascotaOpcion1FlujoVolver() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSeguroMascotaOpcion1)));
		driver.findElement(By.xpath(this.btnSeguroMascotaOpcion1)).isEnabled();
		Utilidades.tomaEvidencia("Verifico ventana anterior");
	}

	public void clicSelectorTipoMascota() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSelectorTipoMascota)));
		driver.findElement(By.xpath(this.btnSelectorTipoMascota)).click();
	}

	public void selectTipoMascota(String tipoMascota) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnSelectorTipoMascota)));
		MobileElement selectTipoMascota = driver.findElement(By.xpath(this.btnSelectorTipoMascota));
		Utilidades.pickerWheelSelect(selectTipoMascota, tipoMascota);
		Utilidades.tomaEvidencia("Selecciono el tipo de mascota");
	}

	public void selectTipoMascotaFlujoVolver() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.selectTipoMascota)));
		driver.findElement(By.xpath(this.selectTipoMascota)).isEnabled();
		Utilidades.tomaEvidencia("Valido ventana anterior");
	}

	public void clicBtnContinuarMascota() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarSex)));
		driver.findElement(By.xpath(this.btnContinuarSex)).click();
	}

	public void clicBtnContinuar() {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuar)));
		driver.findElement(By.xpath(this.btnContinuar)).click();
		Utilidades.tomaEvidencia("Click en botón Continuar.");
	}

	public void clicBtnContinuarFlujoVolver() {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuar)));
		driver.findElement(By.xpath(this.btnContinuar)).isEnabled();
		Utilidades.tomaEvidencia("Verifo ventana anterior");
	}

	public void clicBtnContinuarSoat() {

		Utilidades.moverPantallaDowniOS(driver);
		Utilidades.moverPantallaUpiOS(driver);
		Utilidades.moverPantallaUpiOS(driver);
		Utilidades.moverPantallaUpiOS(driver);
		Utilidades.esperaMiliseg(5000);
		Utilidades.darTapiOS(driver, 185, 625);
		Utilidades.darTapiOS(driver, 180, 640);
		Utilidades.tomaEvidencia("Click en botón Continuar.");
	}

	public void clicSelectorFecha() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSelectorFecha)));
		driver.findElement(By.xpath(this.btnSelectorFecha)).isEnabled();
	}

	public void selectMes(String mes) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.selectMes)));
		MobileElement selectMes = driver.findElement(By.xpath(this.selectMes));
		Utilidades.pickerWheelSelect(selectMes, mes);
	}

	public void selectDia(String dia) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.selectDia)));
		MobileElement selectDia = driver.findElement(By.xpath(this.selectDia));
		Utilidades.pickerWheelSelect(selectDia, dia);
	}

	public void selectAño(String año) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.selectAño)));
		MobileElement selectAno = driver.findElement(By.xpath(this.selectAño));
		Utilidades.pickerWheelSelect(selectAno, año);
	}

	public void clicBtnDone() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnDone)));
		driver.findElement(By.xpath(this.btnDone)).click();
	}

	public void clicSelectorSexo() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSelectorSexo)));
			driver.findElement(By.xpath(this.btnSelectorSexo)).click();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public void selectSexo(String sexo) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.selectSexo)));
			MobileElement selectSexo = driver.findElement(By.xpath(this.selectSexo));
			Utilidades.pickerWheelSelect(selectSexo, sexo);
			Utilidades.tomaEvidencia("Selecciono el sexo");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public void clicBtnContinuarSexo() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarSex)));
			driver.findElement(By.xpath(this.btnContinuarSex)).click();
		} catch (Exception e) {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuar)));
			driver.findElement(By.xpath(this.btnContinuar)).click();
		}
	}

	public void clicBtnSeguroSoat() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSeguroSoat)));
		driver.findElement(By.xpath(this.btnSeguroSoat)).click();
		Utilidades.tomaEvidencia("Clic el boton seguro SOAT");
	}

	public void clicTxtIngresoPlaca(String placa) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtIngresoPlaca)));
		driver.findElement(By.xpath(this.txtIngresoPlaca)).sendKeys(placa);
		Utilidades.tomaEvidencia("Ingreso Placa");
	}

	public void clicBtnSiPropio() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSeguroSiPropio)));
		driver.findElement(By.xpath(this.btnSeguroSiPropio)).click();
		Utilidades.tomaEvidencia("Clic el boton Si se encuentra a mi nombre");
	}

	public void clicBtnCiudadSoat() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCiudadSoat)));
		driver.findElement(By.xpath(this.btnCiudadSoat)).sendKeys("BOGOTA, D.C. - BOGOTA, D.C.");
		Utilidades.tomaEvidencia("Ingreso ciudad del Soat");
	}

	public void clicBtnLapizDirecciónSoat() {
		Utilidades.darTapiOS(driver, 329, 355);
	}

	public void clicBtnCotizar() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCotizarSoat)));
		driver.findElement(By.xpath(this.btnCotizarSoat)).click();
		Utilidades.tomaEvidencia("Clic en el botón Cotizar");
	}

	public void clicBtnCalleSoat() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSelectCalle)));
		driver.findElement(By.xpath(this.btnSelectCalle)).click();
	}

	public void selectCalleSoat() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.selectCalle)));
		MobileElement selectUbicación = driver.findElement(By.xpath(this.selectCalle));
		Utilidades.pickerWheelSelect(selectUbicación, "Calle");
	}

	public void clicTxtDirección1Soat() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtDirección1)));
		driver.findElement(By.xpath(this.txtDirección1)).sendKeys("22");
	}

	public void clicTxtDirección2Soat() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtDirección2)));
		driver.findElement(By.xpath(this.txtDirección2)).sendKeys("23");
	}

	public void clicTxtDirección3Soat() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtDirección3)));
		driver.findElement(By.xpath(this.txtDirección3)).sendKeys("24");
	}

	public void clicTxtTorreAptoSoat() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtTorreApto)));
		driver.findElement(By.xpath(this.txtTorreApto)).sendKeys("Bloque Pruebas");
		Utilidades.tomaEvidencia("Termino de ingresar direccióm");
	}

	public void clicTxtCorreoSoat() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtCorreo)));
		driver.findElement(By.xpath(this.txtCorreo)).sendKeys("xxx@gmail.com");
		Utilidades.moverPantallaUpiOS(driver);
		Utilidades.tomaEvidencia("Ingreso el correo");
	}

	public void clicTxtDatoOpcional() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtDatoOpcional)));
		driver.findElement(By.xpath(this.txtDatoOpcional)).sendKeys("12366778");
		Utilidades.moverPantallaUpiOS(driver);
		Utilidades.tomaEvidencia("Ingreso el dato opcional");
	}

	public void clicBtnAceptarTerminosCondicionesSoat() {
		Utilidades.moverPantallaDowniOS(driver);
		Utilidades.moverPantallaDowniOS(driver);
		Utilidades.moverPantallaUpiOS(driver);
		Utilidades.moverPantallaUpiOS(driver);
		Utilidades.moverPantallaUpiOS(driver);
		Utilidades.moverPantallaUpiOS(driver);
		Utilidades.moverPantallaUpiOS(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnTerminosCondiciones)));
		driver.findElement(By.xpath(this.btnTerminosCondiciones)).click();
		Utilidades.moverPantallaUpiOS(driver);
		Utilidades.moverPantallaUpiOS(driver);
	}

	public void clicBtnAceptarSoat() {
		Utilidades.moverPantallaDowniOS(driver);
		Utilidades.moverPantallaUpiOS(driver);
		Utilidades.moverPantallaUpiOS(driver);
		Utilidades.moverPantallaUpiOS(driver);
		Utilidades.moverPantallaUpiOS(driver);
		Utilidades.moverPantallaUpiOS(driver);
		Utilidades.moverPantallaUpiOS(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptar)));
		driver.findElement(By.xpath(this.btnAceptar)).click();
		Utilidades.tomaEvidencia("Click en botòn Aceptar");
		Utilidades.moverPantallaUpiOS(driver);
		Utilidades.moverPantallaUpiOS(driver);
		Utilidades.moverPantallaUpiOS(driver);
		Utilidades.moverPantallaUpiOS(driver);
	}

	public void clicBtnAceptarPagoServicios() {
		Utilidades.moverPantallaUpiOS(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptar)));
		driver.findElement(By.xpath(this.btnAceptar)).click();
		Utilidades.tomaEvidencia("Click en botòn Aceptar");
	}

	public void lblPlacaInvalida() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.lblPlacaInvalida)));
		String lblPlacaInvalida = driver.findElement(By.xpath(this.lblPlacaInvalida)).getText();
		Utilidades.tomaEvidencia("Valido mensaje Placa Invalida");
		assertEquals("Debe ingresar una placa válida", lblPlacaInvalida);
	}

	public void clicBtnAceptTermCondiciones() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.AceptarTermiCondiciones)));
		driver.findElement(By.xpath(this.AceptarTermiCondiciones)).click();
		Utilidades.tomaEvidencia("Clic en aceptar terminos y condiciones");
	}

	public void clicBtnAceptTermCondicionesFlujoVolver() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.AceptarTermiCondiciones)));
		driver.findElement(By.xpath(this.AceptarTermiCondiciones)).isEnabled();
		Utilidades.tomaEvidencia("Verifico ventana anterior");
	}

	public void clicBtnComprarSeguro() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnComprarSeguro)));
		driver.findElement(By.xpath(this.btnComprarSeguro)).click();
		Utilidades.tomaEvidencia("Valido Compra seguro");
	}

	public void validarLblCompraSeguro() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.lblCompraExitosa)));
		String LblCompraSeguro = driver.findElement(By.xpath(this.lblCompraExitosa)).getText();
		Utilidades.tomaEvidencia("Valido la compra del seguro");
		assertEquals("Transacción exitosa", LblCompraSeguro);
	}

	public void validarLblNoPermiteCompraSeguro() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.lblNoPermiteCompraSeguroVida)));
		String LblCompraSeguro = driver.findElement(By.xpath(this.lblNoPermiteCompraSeguroVida)).getText();
		Utilidades.tomaEvidencia("Valido que no permita la compra del seguro por ingresar fecha menor a 18 años");
		assertEquals(
				"Cliente no esta dentro del rango de edad, para más información escribanos por la opción necesita ayuda.",
				LblCompraSeguro);
	}
	
	public void validoMensajeYaTieneSeguro(String mensaje) {
		Utilidades.tomaEvidencia("Valido Mensaje Ya tiene Seguro");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtYaTieneSeguro)));
		String txtYaTieneSeguro = driver.findElement(By.xpath(this.txtYaTieneSeguro)).getText();
		assertEquals(txtYaTieneSeguro.toString(), (mensaje));
		
	}

	public void clicBtnFinalizar() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		try {
			Utilidades.darTapiOS(driver, 185, 565);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnFinalizar)));
			driver.findElement(By.xpath(this.btnFinalizar)).click();
			Utilidades.tomaEvidencia("Valido la compra");
		} catch (Exception e) {
			Utilidades.darTapiOS(driver, 185, 565);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnFinalizar1)));
			driver.findElement(By.xpath(this.btnFinalizar1)).click();
			Utilidades.tomaEvidencia("Valido la compra");
		}
	}

	// ------Valido Botón cerrar en Tienda Virtual------//

	public void clicBtnCerrar() {
		Utilidades.tomaEvidencia("Click en Botón cerrar con tienda virtual abierta");
		MobileElement btnCerrar = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCerrar)));
		btnCerrar.click();
	}

	public void clicBtnAceptar() {
		Utilidades.tomaEvidencia("Click en Botón aceptar para salir de la aplicación");
//		Utilidades.darTapiOS(driver, 258, 180);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptar)));
		driver.findElement(By.xpath(this.btnAceptar)).click();
	}

	public void validarLblLogoDaviplata() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.lblDaviplata)));
		String LblLogoDaviplata = driver.findElement(By.xpath(this.lblDaviplata)).getText();
		Utilidades.tomaEvidencia("Valido que cierre la sesión en daviplata");
		assertEquals("Cambiar clave por olvido", LblLogoDaviplata);
	}

	// -------------Bonos Desplegable---------------//

	public void btnBono1Desplegable() {
		Utilidades.tomaEvidencia("Click en Botón Bono MacDonals del desplegable descuentos");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAliado1Descuentos)));
		driver.findElement(By.xpath(this.btnAliado1Descuentos)).click();
	}

	public void btnBono2Desplegable() {
		Utilidades.tomaEvidencia("Click en Botón Bono MacDonalds del desplegable descuentos");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAliado2Descuentos)));
		driver.findElement(By.xpath(this.btnAliado2Descuentos)).click();
	}

	// --------------Bono Todos------------//
	public void btnBonoElCorral() {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		Utilidades.tomaEvidencia("Click en Botón Bono ElCorral");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnBonoElCorral)));
		driver.findElement(By.xpath(this.btnBonoElCorral)).click();
	}

	public void btnBonoDunkin() {
		Utilidades.moverPantallaUpiOS(driver);
		Utilidades.moverPantallaUpiOS(driver);
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnBonoDunkin)));
		driver.findElement(By.xpath(this.btnBonoDunkin)).click();
		Utilidades.tomaEvidencia("Click en Botón Bono Dunkin");
	}

	public void btnBonoMcDonalds() {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnMcDonalds)));
		driver.findElement(By.xpath(this.btnMcDonalds)).click();
		Utilidades.tomaEvidencia("Click en Botón Bono MacDonlads");
	}

	public void btnBonoElCorral20mil() {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnBono20mil)));
		driver.findElement(By.xpath(this.btnBono20mil)).click();
		Utilidades.tomaEvidencia("Click en Botón Bono 20 mil");
	}

	public void btnBonoDunkin11700() {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnBono11700)));
		driver.findElement(By.xpath(this.btnBono11700)).click();
		Utilidades.tomaEvidencia("Click en Botón Bono de 11.700");
	}

	public void btnDepartamento() {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnDesplegableDepartamento)));
		driver.findElement(By.xpath(this.btnDesplegableDepartamento)).click();
		Utilidades.tomaEvidencia("Click en Botón Departamento");
	}

	public void btnCiudad() {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnDesplegableCiudad)));
		driver.findElement(By.xpath(this.btnDesplegableCiudad)).click();
		Utilidades.tomaEvidencia("Click en Botón Ciudad");
	}

	public void btnEstablecimiento() {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnEstablecimiento)));
		driver.findElement(By.xpath(this.btnEstablecimiento)).click();
		Utilidades.tomaEvidencia("Click en Botón Establecimiento");
	}

	public void clicBtnContinuarBonoCorral() {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		Utilidades.moverPantallaUpiOS(driver);
		Utilidades.moverPantallaUpiOS(driver);
		Utilidades.moverPantallaUpiOS(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuar)));
		driver.findElement(By.xpath(this.btnContinuar)).click();
	}

	public void btnBonoComprar() {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCompra)));
		driver.findElement(By.xpath(this.btnCompra)).click();
		Utilidades.tomaEvidencia("Click en Botón Comprar Bono");
	}

	public void btnBonoComprarValidoSincorreo() {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		MobileElement imgQueEsDaviPlata = driver.findElement(By.xpath(this.btnCompra));
		Utilidades.tomaEvidencia("Botón comprar inhabilitado");
		// assertTrue(imgQueEsDaviPlata.isEnabled());
		assertEquals(false, imgQueEsDaviPlata.isEnabled());
	}

	public void btnBonoIngresoCorreo() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtCorreoBono)));
		driver.findElement(By.xpath(this.txtCorreoBono)).sendKeys("xxx@gmail.com");
		Utilidades.tomaEvidencia("Ingreso correo para envio del bono");
	}

	public void btnBonoIngresoSinCorreo() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtCorreoBono)));
			driver.findElement(By.xpath(this.txtCorreoBono)).clear();
			Utilidades.tomaEvidencia("Limpio casilla Correo");
		} catch (Exception e) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnEditImage)));
			driver.findElement(By.xpath(this.btnEditImage)).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtCorreoBono)));
			driver.findElement(By.xpath(this.txtCorreoBono)).clear();
			Utilidades.tomaEvidencia("Limpio casilla Correo");
		}
	}

	public void btnBonoLapizCorreo() {
		Utilidades.esperaMiliseg(5000);
		Utilidades.darTapiOS(driver, 308, 508);
	}

	public void btnBonoDescargar() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnDescargarBono)));
		driver.findElement(By.xpath(this.btnDescargarBono)).click();
		Utilidades.tomaEvidencia("Click en Botón Descargar Bono");
	}

	public void selectDepartamento() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.selectUbicacionDepartamento)));
		MobileElement selectUbicación = driver.findElement(By.xpath(this.selectUbicacionDepartamento));
		Utilidades.pickerWheelSelect(selectUbicación, "Bogotá D.C.");
		Utilidades.tomaEvidencia("Selecciono el departamento");
	}

	public void selectCiudad() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.selectUbicacionCiudad)));
		MobileElement selectUbicación = driver.findElement(By.xpath(this.selectUbicacionCiudad));
		Utilidades.pickerWheelSelect(selectUbicación, "Bogota");
		Utilidades.tomaEvidencia("Selecciono la ciudad");
	}

	public void selectEstablecimimiento() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.selectUbicacionCiudad)));
		MobileElement selectUbicación = driver.findElement(By.xpath(this.selectUbicacionCiudad));
		Utilidades.pickerWheelSelect(selectUbicación, "Dunkin Donuts Santafe");
		Utilidades.tomaEvidencia("Selecciono el establecimiento");
	}

//	public String valorTransacciónSeguros() {
//		MobileElement txtValorPoliza = (MobileElement) wait
//				.until(ExpectedConditions.elementToBeClickable(By.id(this.txtValorPoliza)));
//		String valorSeguro = txtValorPoliza.getText().replace(" ", "").replace("$", "").replace(".", "").replace(",",
//				".");
//		return(valorSeguro);
//	}
//	
	public String horaTransaccionSeguros() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.txtFechaHora)));
		String txtFechaHoraApp = driver.findElement(By.xpath(this.txtFechaHora)).getText();
		System.out.println("Esta es la hora de la tx: " + txtFechaHoraApp);
		String hora = txtFechaHoraApp.trim();
		System.out.println(hora);
		System.out.println("Hora app:" + hora);
		return hora;
	}
	
	public void validoLblFondosInsuficientes() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.lblFondosInsuficientes)));
		MobileElement element = driver.findElement(By.xpath(this.lblFondosInsuficientes));
		Assert.assertEquals("Fondos insuficientes", element.getText());
		Utilidades.tomaEvidencia("Valido fondos insuficientes");
		element.click();
	}

}
