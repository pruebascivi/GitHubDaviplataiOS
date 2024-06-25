package daviplata.nacional.iOS.pageObjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.math.BigDecimal;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import daviplata.nacional.iOS.definitions.Hooks;
import daviplata.nacional.iOS.utilidades.Utilidades;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.core.pages.PageObject;

public class HomePageObjects extends PageObject {

	private AppiumDriver<MobileElement> driver = Hooks.getDriver();
	private WebDriverWait wait = Hooks.getDriverWait();
	BaseUtil base;
	private boolean flag = true;
	private int count = 1;
	private int contador = 0;

	private String btnSacarPlata = "//XCUIElementTypeOther[@name='circle-button-3']";
	private String labelSaldo = "//XCUIElementTypeOther[@name='lbl-mount']";
	private String btnActualizarSaldo = "com.davivienda.daviplataapp.lab:id/text_balance";
	private String btnAyudaEnLinea = "//XCUIElementTypeOther[@name='btn-rigth-1']";
	private String btnNoMeInteresa = "//*[@id='btn_cmp_no_interes']";
	private String btnTartejaVirtual = "//XCUIElementTypeStaticText[contains(@value,'Mi Tarjeta virtual')] | //XCUIElementTypeOther[@name='card-product-1'] | //XCUIElementTypeStaticText[contains(@value,'Mi tarjeta virtual')]";
	private String txtSaldoEcard = "com.davivienda.daviplataapp.lab:id/saldo";
	private String txtSaldoEcardHome = "(//XCUIElementTypeStaticText)[15]";
	private String btnBack = "//*[@name='Botón atrás' or @name='Regresar a pantalla menú principal'] | //XCUIElementTypeButton[@name='icon back button']";
	private String btnIngresar = "//*[@id='enterBtn']";
	private String btnPermitirFotos = "//*[@id='permission_allow_button']";
	private String btnAceptarPermisos = "//*[@id='button1']";
    private String btnAtencionLinea = "//android.view.View[@content-desc='Ir a asesor virtual ¿Necesita ayuda?']";
	private String btnsegurodevida  = "//XCUIElementTypeStaticText[@name='Vida']";
	private String btnNotificaciones = "//XCUIElementTypeOther[@name='btn-rigth-0'] | //XCUIElementTypeOther[@label= 'Notificaciones botón'] | //XCUIElementTypeImage[@name='Notificaciones Botón']";
	private String btnTiendaVirtual = "//XCUIElementTypeButton[@name='iconTiendaVirtual']";
	private String btnAtrasBolsillos = "//XCUIElementTypeButton[@name='Regresar a pantalla Anterior']";
	private String btnAgua = "//XCUIElementTypeOther[@name=\"Agua boton\"]";
	private String inputEPM = "//XCUIElementTypeCell[1]";
	private String btnAceptar = "//XCUIElementTypeButton[@name='Aceptar']";
	private String btnMasServicios = "//XCUIElementTypeOther[@name='Otros Servicios']";
	private String btnMicroSeguros = "//XCUIElementTypeStaticText[@name='Microseguros']";
	private String btnAceptarLogout = "//XCUIElementTypeButton[@name='Aceptar']";	
	public static final String SACAR_PLATA_MODULO_BTN = "//XCUIElementTypeOther[@name='circle-button-3']";
	public static final String BOTON_TARJETA_VIRTUAL = "//XCUIElementTypeStaticText[@name='name-product-1']";
	public static final String BOTON_MAS_PRODUCTOS = "//XCUIElementTypeOther[@name='Más productos']";
	public static final String TEXTO_MIS_PRODUCTOS = "//XCUIElementTypeStaticText[@name='Mis productos'] | //XCUIElementTypeStaticText[contains(@name, 'solicite sus productos desde aquí')]";
	public static final String TEXTO_BOLSILLO_MODULO = "//XCUIElementTypeStaticText[@value='Bolsillo'] | //XCUIElementTypeStaticText[@name='Bolsillo'] | //XCUIElementTypeStaticText[@label='Bolsillo']";
	
	public void btnAtencionLinea() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id(this.btnAtencionLinea)));
		driver.findElement(By.id(this.btnAtencionLinea)).click();
	}
	
	public void clickBtnLogout() {
		TouchAction touchAction=new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(355, 68)).perform();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptarLogout)));
		driver.findElement(By.xpath(this.btnAceptarLogout)).click();
	}
	
	public void darClickTiendaVirtualMH() {
		
		for (int i = 1 ; i<=4 ; i++) {
		btnTiendaVirtual = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout["+i+"]/android.widget.RelativeLayout/android.widget.TextView";
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnTiendaVirtual)));
		MobileElement btnmicroseguromh = driver.findElement(By.xpath(this.btnTiendaVirtual));
		
		String texto = btnmicroseguromh.getText();
		System.out.println(texto);
		
		if(texto.contains("Microseguros") == true) {btnmicroseguromh.click(); i = 4;}
		
		
		}
	}
	public void darClicksegurodevida() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnsegurodevida)));
		driver.findElement(By.xpath(this.btnsegurodevida)).click();
	}
	
	public void darClickEnBotonMas() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PagarPageObjects.BOTON_MAS)));
			driver.findElement(By.xpath(PagarPageObjects.BOTON_MAS)).click();
		} catch (Exception objException) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(500);
				darClickEnBotonMas();
			} else {
				System.out.println("No pude dar click en boton mas debido a: ");
			}
		} finally {
			contador = 0;
		}
	}
	
	public void darClickEnSacarPlata() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSacarPlata)));
			driver.findElement(By.xpath(this.btnSacarPlata)).click();
		} catch (Exception objException) {
			if (!(contador == 10)) {
				Utilidades.esperaMiliseg(2000);
				darClickEnSacarPlata();
			} else {
				System.out.println("No pude dar click en boton sacar plata debido a: ");
			}
		} finally {
			contador = 0;
		}
	}

	public BigDecimal capturarSaldoInicial() {
		String subSaldo;
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.labelSaldo)));
		String labelSaldo = driver.findElement(By.xpath(this.labelSaldo )).getText();
		System.out.println(labelSaldo);
		subSaldo = labelSaldo.replaceAll("[^0-9]","");
		int cantidad = subSaldo.length();
		int numero = cantidad - 2;
		subSaldo = subSaldo.substring(0, numero);
		BaseUtil.saldo = new BigDecimal(subSaldo);
		
		
		//base.saldoFinal = new BigDecimal(subSaldo);
		return BaseUtil.saldo;
	}

	public void capturarSaldoIniciall() {
		try {
			String subSaldo;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtSaldoEcardHome )));
			String labelSaldo = driver.findElement(By.xpath(this.txtSaldoEcardHome )).getText();
			System.out.println(labelSaldo);
			subSaldo = labelSaldo.replace(" ", "").replace("$", "").replace(".", "").replace(",", ".");
			BaseUtil.saldoInicialTarjeta = new BigDecimal(subSaldo);

		} catch (Exception e) {
			System.out.println("No hay saldo en ecard inicial");
		}

	}

	public void capturarSaldoFinal() {
		try {
			contador++;
			
			Utilidades.esperaMiliseg(4000);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.labelSaldo)));
			String subSaldo = driver.findElement(By.xpath(this.labelSaldo)).getText();
			
			subSaldo = subSaldo.replaceAll("[^0-9]", "");
			int cantidad = subSaldo.length();
			int numero = cantidad - 2;
			subSaldo = subSaldo.substring(0, numero);
			
			
			BaseUtil.saldoFinal = new BigDecimal(subSaldo);
			System.out.println("capturarSaldoFinal: " +BaseUtil.saldoFinal);
			
		}catch (Exception e) {
			if(!(contador==8)) {Utilidades.esperaMiliseg(500); capturarSaldoFinal();
			}else {fail("No se pudo captuador saldo final despues de transferencia debido a: " + e.getMessage());}
		}finally {contador = 0;}
	}
	
	
	
	public void validacionDeSaldos() {
		String saldoMenosMonto =  BaseUtil.saldo.toString().replace(".","").replace(",","");
		int cantidad = saldoMenosMonto.length();
		int numero = cantidad - 2;
		saldoMenosMonto = saldoMenosMonto.substring(0, numero);
		
		BigDecimal saldoFinal = new BigDecimal(saldoMenosMonto);
				
		System.out.println("saldo base: " + BaseUtil.saldo);
		System.out.println("monto transado: " + BaseUtil.montoTransado);
		System.out.println("saldo final: " + BaseUtil.saldoFinal);
		System.out.println("saldo final sin decimales: " + saldoFinal);
		
		
		System.out.println("saldo menos monto: " + saldoMenosMonto);
		
		assertEquals(saldoFinal.subtract(BaseUtil.montoTransado), BaseUtil.saldoFinal);

	}

	public BigDecimal capturarSaldoTarjetaVirtual() {
		String subSaldo = "0.0";
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtSaldoEcard )));
			String txtSaldoEcard = driver.findElement(By.xpath(this.txtSaldoEcard )).getText();
			
			System.out.println(txtSaldoEcard);
			subSaldo = txtSaldoEcard.replace(" ", "").replace("$", "").replace(".", "").replace(",", ".");
		} catch (Exception e) {
			System.out.println("No esta disponible el saldo en la tarjeta.");
		}
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtSaldoEcardHome )));
			String txtSaldoEcardHome = driver.findElement(By.xpath(this.txtSaldoEcardHome )).getText();
			System.out.println(txtSaldoEcardHome);
			subSaldo = txtSaldoEcardHome.replace(" ", "").replace("$", "").replace(".", "").replace(",", ".");
		} catch (Exception e) {
			System.out.println("No esta disponible el saldo en la tarjeta en home.");
		}

		return new BigDecimal(subSaldo);
	}

	public void darClickEnActualizarSaldo() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnActualizarSaldo )));
			driver.findElement(By.xpath(this.btnActualizarSaldo )).click();
		} catch (Exception objException) {
			try {
				clickBotonAtras(2);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnActualizarSaldo )));
				driver.findElement(By.xpath(this.btnActualizarSaldo )).click();
			} catch (Exception e) {
				System.out.println("Mm no fue necesario actualizar el botón de saldo del los bolsillos.");
			}

		}
	}

	public void darClickAyudaEnLineaHome() {
		Utilidades.esperaMiliseg(1500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAyudaEnLinea)));
		driver.findElement(By.xpath(this.btnAyudaEnLinea)).click();
	}

	public void darClickCampanaNotificaciones() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnNotificaciones)));
			driver.findElement(By.xpath(this.btnNotificaciones)).click();
		}catch(Exception e) {
			if(!(contador ==5)) {
				Utilidades.esperaMiliseg(500);
				darClickCampanaNotificaciones();
			}else {
				fail("No se encontró campana de notificaciones en home perfil persona, debido a: " + e.getMessage());
			}
		}finally {contador=0;}
	}
	
	public void darClickBtnMas() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PagarPageObjects.BOTON_MAS)));
			driver.findElement(By.xpath(PagarPageObjects.BOTON_MAS)).click();
		}catch(Exception e){
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(500);
				darClickBtnMas();
			}else {
				fail("No se encontró botón 'Más opciones' del home Daviplata, debido a: "+e.getMessage());
			}
				
		}finally {contador=0;}
		
	}
	
	public void darClickMasServicios() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnMasServicios)));
			driver.findElement(By.xpath(this.btnMasServicios)).click();
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(500);
				darClickMasServicios();
			}else {
				fail("No se encontró botón 'Otros Servicios' desde tienda virtual, debido a: "+e.getMessage());
			}
		}finally {contador=0;}
		
		
	}
	
	public void darClickBotonMarketPlace() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnTiendaVirtual)));
			driver.findElement(By.xpath(this.btnTiendaVirtual)).click();
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(500);
				darClickBotonMarketPlace();
			}else {
				fail("No se encontró botón 'tienda virtual' desde el boton mas opciones en el perfil persona, debido a: "+e.getMessage());
			}
		}finally {contador=0;}
		
	}
	
	public void cerrarPopup() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptar)));
			driver.findElement(By.xpath(this.btnAceptar)).click();	
		}catch(Exception e) {
			System.out.println("no se encontro el boton de aceptar tienda virtual");
		}
		
	}
	
	
	public void darClickBtnAgua() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAgua)));
		driver.findElement(By.xpath(this.btnAgua)).click();
	}

	public void seleccionarEPM() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputEPM)));
		driver.findElement(By.xpath(this.inputEPM)).click();
	}
	
	public void clickBtnAceptar() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptar)));
		driver.findElement(By.xpath(this.btnAceptar)).click();
	}
	
	public void darClickEnNoMeInteresa() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnNoMeInteresa)));
			driver.findElement(By.xpath(this.btnNoMeInteresa)).click();
		} catch (Exception e) {
			System.out.println("No aparece PopUp NanoCredito");
		}
	}

	public void darClickEnTarjetaVirtual() {		
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnTartejaVirtual)));
			driver.findElement(By.xpath(this.btnTartejaVirtual)).click();
		}catch (Exception e) {
			if(!(contador==5)) {Utilidades.esperaMiliseg(500); darClickEnTarjetaVirtual();
			}else {fail("No se pudo encontrar botón de ecard debido a: " + e.getMessage());}
		}finally {contador = 0;}
	}


	

	public void clickBotonAtras(int repeticiones) {
		try {
			contador++;
			for (int i = 0; i < repeticiones; i++) {
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnBack)));
				driver.findElement(By.xpath(this.btnBack)).click();
			}
		}catch (Exception e) {
			if(!(contador==5)) {Utilidades.esperaMiliseg(500); clickBotonAtras(repeticiones);
			}else {fail("No se encontró boton ATRAS debido a: " + e.getMessage());}
		}finally {contador = 0;}
	}
	
	public void clickBotonAtrasBolsillos(int repeticiones) {
		try {
			contador++;
			for (int i = 0; i < repeticiones; i++) {
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAtrasBolsillos)));
				driver.findElement(By.xpath(this.btnAtrasBolsillos)).click();
			}
		}catch (Exception e) {
			if(!(contador==5)) {Utilidades.esperaMiliseg(2000); clickBotonAtrasBolsillos(repeticiones);
			}else {fail("No se encontró boton ATRAS debido a: " + e.getMessage());}
		}finally {contador = 0;}
	}

	public BigDecimal capturarSaldoInicialTotal() {
		String subSaldo;
		// utilidad.moverPantalla();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.labelSaldo)));
		String labelSaldo = driver.findElement(By.xpath(this.labelSaldo)).getText();
		System.out.println(labelSaldo);
		subSaldo = labelSaldo.replace(" ", "").replace("$", "").replace(".", "").replace(",", ".");
		BaseUtil.saldoTotalInicial = new BigDecimal(subSaldo);
		return BaseUtil.saldoTotalInicial;
	}

	public void pulsarBtnIngresar() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnIngresar)));
			driver.findElement(By.xpath(this.btnIngresar)).click();
		} catch (Exception e) {
			System.out.println("No aparece botón 'Ingresar'");
		}
	}

	public void pulsarBtnPermitirFotos() {
		pulsarBtnAceptarPermisos();
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnPermitirFotos)));
			driver.findElement(By.xpath(this.btnPermitirFotos)).click();
		} catch (Exception e) {
			System.out.println("No aparece botón '¿Permitir que DaviPlata tome fotos y grabe videos?'");
		}
	}

	public void pulsarBtnAceptarPermisos() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptarPermisos)));
			driver.findElement(By.xpath(this.btnAceptarPermisos)).click();
		} catch (Exception e) {
			System.out.println(
					"No aparece opción 'Para escanear el código QR DaviPlata requiere que le des permisos sobre la camara'");
		}
	}
	
	public void darClickMicroseguros() {
		try {
			contador++;
			Utilidades.esperaMiliseg(5000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnMicroSeguros)));
			driver.findElement(By.xpath(this.btnMicroSeguros)).click();
			System.out.println("di click en el btn de hamburguesa");
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				darClickMicroseguros();
			} else {
				fail("No se encontró botón menu hamburguesa perfil persona debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}
}
