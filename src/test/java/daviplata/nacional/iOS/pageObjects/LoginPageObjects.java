package daviplata.nacional.iOS.pageObjects;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.github.javafaker.Faker;
import daviplata.nacional.iOS.utilidades.Credenciales;
import daviplata.nacional.iOS.steps.WebRedebanSteps;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import daviplata.nacional.iOS.definitions.Hooks;
import daviplata.nacional.iOS.utilidades.Utilidades;
import daviplata.nacional.iOS.utilidades.UtilidadesTCS;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.core.pages.PageObject;

public class LoginPageObjects extends PageObject{

	BaseUtil base;
	private AppiumDriver<MobileElement> driver = Hooks.getDriver();
	// private AppiumDriver<MobileElement> driver = Hooks.getDriver();
	private WebDriverWait wait = Hooks.getDriverWait();
	private int contador = 0;
	Utilidades utilidad;
	Utilidades Utilidades;
	negocioPageObjects negocioPO;
	UtilidadesTCS utilidadesTCS;

	private WebRedebanSteps stepsWebRedeban;
	private static WebLatiniaPageObject pageLatinia;
	private static NewLPageObjects pageNLatinia;
	// private NewLPageObjects pageNLatinia;
	private Faker objFaker;
	ArrayList<Float> saldos = new ArrayList<Float>();

	// Xpath nuevo login
	private String listaTipoId = "//XCUIElementTypePickerWheel";
	private String btnContinuar = "(//XCUIElementTypeButton[@name = 'Continuar'])[2]";
	private String btnContinuar2 = "(//XCUIElementTypeButton[@name = 'Continuar'])";
	private String DocumentoTi = "//*[@name = 'Selección Tarjeta de Identidad']";
	private String DocumentoCc = "//*[@name = 'Selección Cédula de Ciudadanía']";
	private String DocumentoCe = "//*[@name = 'Selección Cédula de Extranjería']";
	private String DocumentoPep = "(//XCUIElementTypeStaticText[@name = 'Cédula de Extranjería'])[2]";
	private String Documento = "Abrir listado tipo de documento";

	private String desplegarPassword = "//XCUIElementTypeApplication[@name='DaviPlata']/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeButton";
	private String desplegarPasswordNueva = "//XCUIElementTypeApplication[@name=\"DaviPlata\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeButton";
	private String desplegarPasswordDespuesCambio = "//XCUIElementTypeApplication[@name=\"DaviPlata\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[5]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther";
	private String pulsarTipoDocumento = "com.davivienda.daviplataapp.lab:id/btn_login_tipodoc";
	// private String pulsarTipoDocumento =
	// "com.davivienda.daviplataapp.lab:id/btn_login_tipodoc";
	private String tipoDocumento = "//XCUIElementTypeButton[@name=\"Lista Desplegable\"]";
	private String btnInicar = "//XCUIElementTypeButton[@name=\"Ingresar\"]";
	private String ingresarDocumento = "//XCUIElementTypeTextField[@name=\"Ingrese su número de documento\"]";
	//
	private String btnIngresarInitId = "enterBtn";
	private String edtLoginId = "//XCUIElementTypeTextField[@name='Ingrese su número de documento']";
	private String btnContinuarId = "Ingresar";
	private String btnContinuarlogin = "//XCUIElementTypeButton[@name='Continuar']";
	private String btnRegistrarse = "//XCUIElementTypeButton[@name='Crear DaviPlata' or @name='Registrarse']";
	private String btnCambiarNumeroZonaPublica = "Cambiar mi número";
	private String edtContrasenaId = "login_et_clave";
	private String btnIngresar = "Continuar";
	private String mensajeTopeCredito = "//XCUIElementTypeStaticText[contains(@name,'Está llegando al tope')]";
	private String txtMiDaviPlataXpath = "//XCUIElementTypeStaticText[@name='lbl-header-balance']";
	private String txtIngresoFallido = "com.davivienda.daviplataapp.lab:id/notif_text_rappi";
	private String btnCerrarVideoInicialCasitaRojaXpath = "com.davivienda.daviplataapp.lab:id/ib_close_introduction";

	private String txtSaldoDaviPlata = "//XCUIElementTypeOther[@name='lbl-mount']";
	// (//*[contains(@name,'pesos')])[2]
	private String txtSaldoEcard = "(//XCUIElementTypeStaticText[2])[4]";
	private String txtSaldoBolsillo = "(//XCUIElementTypeStaticText[2])[3]";
	private String txtSaldoTotal = "com.davivienda.daviplataapp.lab:id/balanceTotal";

	private String btnMenuHamburguesa = "//XCUIElementTypeOther[@name='Menú hamburguesa botón']";
	private String btnUsarPlata = "//XCUIElementTypeButton[@value='Usar Plata']";
	private String btnMeterPlata = "//*[@text='Meter plata']";
	private String btnMeterPlataMH = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout";
	private String btnMeterPlataXpath = "//XCUIElementTypeButton[@name='Opción para meter plata ']";
	private String btnPasarPlata = "//*[@text='Pasar plata']";
	private String btnPasarPlataMH = "//XCUIElementTypeStaticText[@name='Pasar plata']";
	private String txtUrlPSEconfirmacion = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View/android.widget.TextView[2]";
	private String btnMasServicios = "//XCUIElementTypeButton[@value = 'Más servicios']";
	private String btnNotificaciones = "icon circle menu gray";
	private String btnNotificacionesNew = "com.davivienda.daviplataapp.lab:id/nav_bar_btn_context_menu";
	private String listNotificaciones = "//XCUIElementTypeButton[@name='Transacciones']";
	private String btnCompras = "//*[@name='Compras en Tienda Virtual']";
	private String selectMensajeEliminar = "(//XCUIElementTypeButton[@name='Casilla de selección no marcada'])[1]";
	private String btnEliminar = "//XCUIElementTypeButton[@name='Eliminar']";
	private String txtEliminado = "//XCUIElementTypeStaticText[@name='Mensaje Eliminado']";
	private String btnEliminarMensaje = "//XCUIElementTypeButton[@name='Aceptar']";

	private String btnCloseAnuncio = "//*[@id='ib_close_introduction']";

	private BigDecimal saldoDaviPlata;
	private BigDecimal saldoEcard = new BigDecimal("0.00");
	private BigDecimal saldoBolsillo = new BigDecimal("0.00");
	private BigDecimal saldoTotal;

	private String btnPopUp = "//*[contains(text(),'Autori')]";
	private String btnAceptarHuella = "com.davivienda.daviplataapp.lab:id/BtnPopupPositiveButton";
	private String labelActualizarCorreo = "//*[@text='Estimado cliente, antes de ingresar agradecemos actualizar su correo electrónico.']";
	private String btnContinuarActivar = "//android.widget.Button[contains(@text,'Aceptar')]";
//	private String btnContinuarActivar = "//android.widget.LinearLayout[2]/android.widget.Button[2]";
	private String btnContinuarActivarH = "com.davivienda.daviplataapp.lab:id/notif_btn_aceptar";
	private String btnAceptarSalirApp = "com.davivienda.daviplataapp.lab:id/notif_btn_aceptar";
	private String btnContinuarRegistro = "//*[@text='Continuar']";
	private String btnContinuarRegistro2 = "com.davivienda.daviplataapp.lab:id/btnNewRegisterContinue";
	private String labelNotificacion = "com.davivienda.daviplataapp.lab:id/notification_popup_layout";
	private String labelNotificacion2 = "com.davivienda.daviplataapp.lab:id/notif_text_rappi";
	private String inputCorreoElectronico = "com.davivienda.daviplataapp.lab:id/etNewRegisterEmail";
	private String inputClaveRegistro = "com.davivienda.daviplataapp.lab:id/etNewRegisterPin";
	private String labelNumTelefoo = "com.davivienda.daviplataapp.lab:id/tvNewOtpSimplePhoneNumber";
	private String labelNumTelefooo = "com.davivienda.daviplataapp.lab:id/tvNewOtpPhoneNumber";
	private String labelNumTelefonoOlvidoClave = "com.davivienda.daviplataapp.lab:id/olvido_clave_viewPhone_numero";
	private String inputOtp = "com.davivienda.daviplataapp.lab:id/etNewOtpSimpleCode";
	private String inputOtpRegistro = "//XCUIElementTypeTextField['1']";
	private String btnContinuarTeclado = "(//XCUIElementTypeButton[@name='Continuar'])[2]";
	private String btnCambiarNumero = "Cambiar número";
	private String btnContinuarRegistrar = "com.davivienda.daviplataapp.lab:id/btnNewRegisterContinue";
	private String btnContinuarOTP = "com.davivienda.daviplataapp.lab:id/btnNewOtpSimpleContinue";
	private String btnContinuarOTPRegistro = "//XCUIElementTypeButton[@name='Continuar']";
	private String labelNotificaciones = "com.davivienda.daviplataapp.lab:id/nav_bar_title";
	private String btnSalirApp = "//*[@id='nav_bar_btn_close']";
	private String btnRegresar = "//*[@id='nav_bar_btn_left']";
	private String cargando = "//*[@id='progress']";
	private String txtDaviplatainvalido = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView";
	private String enunciado = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView";
	private String txtMeterPlata = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.EditText";
	private String txtMeterPlataRepetir = "//XCUIElementTypeButton[@name='Meter Plata botón']";

	private String txtvalor = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View[2]/android.widget.EditText";
	private String txtBanco = "//*[@text='Seleccione el banco...']";
	private String btnBanco = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[10]";

	private String btnComprasTienda = "//*[@resource-id='com.davivienda.daviplataapp.lab:id/notification_content']";
	private String btnValidarLeerBono = "//*[contains(@text,'Bono')]";
	private String btnValidarLeerBono2 = "//android.widget.ListView/android.widget.LinearLayout[1]/android.widget.TextView[1]";

	private String popUpReinicio = "com.davivienda.daviplataapp.lab:id/ClDialogPopupContent";
	private String btn_aceptarReinicio = "com.davivienda.daviplataapp.lab:id/BtnPopupPositiveButton";
	private String btn_continuarRegistro = "//android.widget.Button[@content-desc=\"Continuar\"]";

	private String mensajeTopes = "//XCUIElementTypeStaticText[contains(@name,'Está llegando al tope mensual')]";
	private String labelCuantoTengoHomePerfilPersona = "(//XCUIElementTypeStaticText[2])[1]";
	public static final String MENSAJE_CARACTER_ESPECIAL = "(//XCUIElementTypeStaticText[contains(@name,'solo')])";
	private String labelMensajeSolicitudOTP = "";

	private String btnMenuHamburguesaNegocio = "(//*[@text = 'Menú hamburguesa botón'])[1]";
	private String btnIrAPerfilPersona = "//*[contains(@text,'Ir a perfil persona Botón')]";
	private String formularioMeterPlata = "//*[@text='Complete los datos para meter plata a DaviPlata']";

	private String labelIngresoDaviplata = "//XCUIElementTypeStaticText[@name='Ingrese a su Daviplata']";
	private String labelIngresoContrasena = "//XCUIElementTypeStaticText[@name='Ingrese su clave']";
	private String homePerfilNegocio = "";
	private String logoDaviplata = "//*[@resource-id='com.davivienda.daviplataapp.lab:id/login_iv_logo' or @resource-id='com.davivienda.daviplataapp.lab:id/BtnPopupPositiveButton']";
	public static final String MENU_DAVIPLATA_BTN = "//XCUIElementTypeOther[@name='btn-left-0']";
	public static final String SOLICITUDES_SECCION_DESPLEGABLE = "//XCUIElementTypeOther[@name='Seccion Solicitudes Desplegar opciones boton']";
	public static final String SALIR_DAVIPLATA_BTN = "//XCUIElementTypeOther[@name='btn-sign-out']";
	public static final String CONFIRMAR_SALIR_DAVIPLATA = "//XCUIElementTypeStaticText[contains(@name,'Aceptar')]";
	public static final String REGRESAR_MENÚ_INICIAL_BTN = "//XCUIElementTypeButton[@name='Regresar']";
	public static final String REGISTRARME_BTN = "//XCUIElementTypeStaticText[@name='Registrarme']";
	public static final String PERFIL_PERSONA_BTN = "//XCUIElementTypeOther[@name='btn-left-0']";
	public static final String PERFIL_MI_DAVIPLATA_BTN = "//XCUIElementTypeOther[@name='btn-mi-daviplata']";
	public static final String HOME_PERFIL_NEGOCIO = "//XCUIElementTypeOther[@name='btn-mi-negocio']";
	public static final String SALDO_HOME_CEROS = "//XCUIElementTypeStaticText[contains(@value,'$')] | //XCUIElementTypeOther[@name='lbl-mount']";

	
	public void darClickBotonNotificaciones() {
		try {
			contador++;
			Utilidades.esperaMiliseg(2000);
			driver.findElement(By.name(this.btnNotificaciones)).click();
			System.out.println("Di click al btn notificaciones");
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				darClickBotonNotificaciones();
			} else {
				fail("No se pudo dar clic en botón Notificaciones " + this.btnNotificaciones + " debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void clickBtnIngresarInit() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnIngresarInitId)));
			driver.findElement(By.xpath(this.btnIngresarInitId)).click();
		} catch (Exception e) {
			System.out.println("No aparece menu de ingresar al inicial la app.");
		}
	}

	public void capturarSaldo() {
		try {
			contador++;
			Utilidades.esperaMiliseg(7000);
			String subSaldo;

			subSaldo = base.driver.findElement(By.xpath(this.txtSaldoDaviPlata)).getText();
			System.out.println("Saldo capturado: " +subSaldo);
			subSaldo = subSaldo.replaceAll("[^0-9]", "");
			int cantidad = subSaldo.length();
			int numero = cantidad - 2;
			subSaldo = subSaldo.substring(0, numero);

			if (base.saldo == null) {
				System.out.println("Saldo capturado: " + subSaldo);
				base.saldo = new BigDecimal(subSaldo);
				System.out.println("base saldo captura: " + base.saldo);
				String saldo1 = subSaldo;
				float saldoDavi1 = Float.parseFloat(saldo1);
				saldos.add(saldoDavi1);
			} else {
				System.out.println("Saldo final convertido: " + subSaldo);
				base.saldoFinal = new BigDecimal(subSaldo);
				String saldo2 = subSaldo;
				float saldoDavi2 = Float.parseFloat(saldo2);
				saldos.add(saldoDavi2);
			}
			// base.saldoSinDecimal = new BigDecimal(result[0]);
			// base.saldoIni = result[0];

		} catch (Exception e) {

			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(500);
				capturarSaldo();
			} else {
				System.out.println("No se pudo capturar saldo de cuenta daviplata debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validarDebitoSaldoDaviPlata() {
		try {
			contador++;
			System.out.println("El saldo inicial en Base es: " + base.saldo);
			System.out.println("El saldo final en Base es: " + base.saldoFinal);
			System.out.println("El monto transado es: " + base.montoTransado);
			assertThat(base.saldoFinal, equalTo(base.saldo.subtract(base.montoTransado)));
			System.out.println("Valide correctamente la afectacion del debito de saldo en el DaviPlata");

		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(500);
				validarDebitoSaldoDaviPlata();
			} else {
				fail("No pude validar los saldos correctamente: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void validarCreditoSaldoDaviPlata() {
		try {
			contador++;
			System.out.println("El saldo inicial en Base es: " + base.saldo);
			System.out.println("El saldo final en Base es: " + base.saldoFinal);
			System.out.println("El monto transado es: " + base.montoTransado);
			assertThat(base.saldoFinal, equalTo(base.saldo.add(base.montoTransado)));
			System.out.println("Valide correctamente la afectacion del credito del saldo en el DaviPlata");

		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(500);
				validarCreditoSaldoDaviPlata();
			} else {
				fail("No pude validar los saldos correctamente: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void validarIgualdadSaldoDaviPlata() {
		try {
			contador++;
			System.out.println("El saldo inicial en Base es: " + base.saldo);
			System.out.println("El saldo final en Base es: " + base.saldoFinal);
			System.out.println("El monto transado es: " + base.montoTransado);
			assertThat(base.saldoFinal, equalTo(base.saldo));
			System.out.println("Valide correctamente la igualdad del saldo en el DaviPlata");

		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(500);
				validarCreditoSaldoDaviPlata();
			} else {
				fail("No pude validar los saldos correctamente: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public String popUpDaviplata() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.labelNotificacion)));
			String popUp = base.driver.findElement(By.xpath(this.labelNotificacion)).getText();
			return popUp;
		} catch (Exception e) {
			System.out.println("no encontre popup");
		}
		return "";
	}

	// --------- PopUp reinicio ---------------//
	public void popUpReinicio() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btn_aceptarReinicio)));
			driver.findElement(By.xpath(this.btn_aceptarReinicio)).click();
			System.out.println("Aparecio popup Reiniciar");
		} catch (Exception e) {
			System.out.println("No aparece popUp reiniciar debido a: " + e.getMessage());
		}

	}
	// --------- Slider que aparece cuando un usuario es registrado
	// ---------------//

	public void sliderRegistroAcercaDaviplata() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btn_continuarRegistro)));
			driver.findElement(By.xpath(this.btn_continuarRegistro)).click();
			System.out.println("Aparecio slider acerca de daviplata");
		} catch (Exception e) {
			System.out.println("No aparece slider acerca de daviplata");
		}

	}

	public boolean activarDaviplata(String documento, String clave) {
		boolean flag = true;
		boolean registro = true;

		try {

			System.out.println(popUpDaviplata());
			registro = true;

		} catch (Exception e) {
			registro = false;
		}

		if (registro) {

			if (popUpDaviplata().contains("activo")) {
				try {
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarActivar)));
					base.driver.findElement(By.xpath(this.btnContinuarActivar)).click();
					utilidad.tomaEvidencia("Activar Daviplata en este celular");
				} catch (Exception e) {
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarActivarH)));
					base.driver.findElement(By.xpath(this.btnContinuarActivarH)).click();
					utilidad.tomaEvidencia("Activar Daviplata en este celular");
				}
				// utilidad.darUnTap(240, 640);
				// String numCelular = stepsWebRedeban.consultaNumeroCelular(documento);
				// String email = stepsWebRedeban.obtenerCorreo(numCelular);
				// stepsWebRedeban.logOut("//img[@src='/AutorizadorMonWeb/images/pages/logout.gif']");
				ingresarCorreoElectronico();
				ingresoClaveDaviplata(clave);

				utilidad.tomaEvidencia("Ingresando datos para activar DaviPlata");
				clickBtnContinuarRegistro();
				String numCelular = capturoNumTelefono();
				try {
					pageNLatinia.initDriverNLatinia();

					try {
						pageNLatinia.clicBtnContinuar();
					} catch (Exception e) {

					}
					pageNLatinia.ingresarEmpresa();
					pageNLatinia.ingresarUsuario();
					pageNLatinia.ingresarPassword();
					pageNLatinia.darClickAcceder();

					pageNLatinia.darClickBtnActualizar();
					String numeroOTP = pageNLatinia.traeOTP(numCelular);
					System.out.println(numeroOTP);
					ingresoOTP(numeroOTP);
					pulsarBtnContinuarOTP();
				} catch (Exception e) {
					System.out.println("Fallo latinia " + e.getLocalizedMessage());
//				pageNLatinia.darClickFinalizarSesion();
					pageNLatinia.cerrarLatinia();

				}

				Utilidades.esperaMiliseg(5000);
				try {
					String iOTP = popUpDaviplata();
					System.out.println(iOTP);
					System.out.println(iOTP.contains("inválido"));
					while (iOTP.contains("inválido")) {
						Utilidades.esperaMiliseg(5000);

						pageNLatinia.darClickBtnActualizar();
						String numeroOTP = pageNLatinia.traeOTP(numCelular);
						System.out.println(numeroOTP);
						ingresoOTP(numeroOTP);
						pulsarBtnContinuarOTP();
					}

				} catch (Exception e) {
					System.out.println("Fallo OTP " + e.getLocalizedMessage());
					pageNLatinia.cerrarLatinia();
				}

				flag = false;
			} else if (popUpDaviplata().contains("reglamento")) {
				System.out.println("Si encontró reglamento");
				ingresarCorreoElectronico();
				ingresoClaveDaviplata(clave);
				utilidad.tomaEvidencia("Ingresando datos para activar DaviPlata");
				clickBtnContinuarRegistro();

				String numCelular = capturoNumTelefono();
				try {
					pageNLatinia.initDriverNLatinia();
					pageNLatinia.clicBtnContinuar();
					pageNLatinia.ingresarEmpresa();
					pageNLatinia.ingresarUsuario();
					pageNLatinia.ingresarPassword();
					pageNLatinia.darClickAcceder();
					pageNLatinia.darClickBtnActualizar();
					String numeroOTP = pageNLatinia.traeOTP(numCelular);
					System.out.println(numeroOTP);
					pageNLatinia.cerrarLatinia();
					ingresoOTP(numeroOTP);
				} catch (Exception e) {
					System.out.println("Fallo latinia " + e.getLocalizedMessage());
//				pageNLatinia.darClickFinalizarSesion();
					pageNLatinia.cerrarLatinia();

				}

				try {
					pulsarBtnContinuarOTP();
				} catch (Exception e) {

					System.out.println(popUpDaviplata());
				}
				flag = false;
			}
		} else {

			System.out.println("El DaviPlata ya esta activo en este celular");

		}

		return flag;
	}

	public void ingresarLatiniaRegistro() {
		String numCelular = capturoNumTelefonoRegistro();
		pageLatinia.abrirWebLatinia();
		utilidad.esperaMiliseg(5000);
		utilidad.tomaEvidenciaPantalla("Ingreso a Latinia");
		// pageLatinia.clicBtnContinuar();
		pageLatinia.ingresarEmpresa();
		pageLatinia.ingresarUsuario();
		pageLatinia.ingresarPassword();
		utilidad.tomaEvidenciaPantalla("Ingreso credenciales y dar en botón Acceder");
		pageLatinia.darClickAcceder();
		// pageLatinia.darClickInicio();
		pageLatinia.darClickBtnActualizar();
		String numeroOTP = pageLatinia.traeOTP(numCelular);
		/*
		 * if(numeroOTP.contentEquals("No encontrada")) { numeroOTP =
		 * pageLatinia.traeOPTFiltro(numCelular); }
		 */
		System.out.println(numeroOTP);
		utilidad.tomaEvidenciaPantalla("Otp Encontrada");
		pageLatinia.cerrarWebLatinia();
		ingresoOTPRegistro(numeroOTP);
		btnContinuarOTPRegistro();
	}

	public void darClickEnOpcionCambiarNumeroZonaPublica() {
		try {
			contador++;
			darClickBotonNotificaciones();
			utilidad.tomaEvidencia("Selecciono opcion cambiar numero desde zona publica");
			utilidad.esperaMiliseg(500);
			wait.until(ExpectedConditions.elementToBeClickable(By.name(this.btnCambiarNumeroZonaPublica)));
			base.driver.findElement(By.name(this.btnCambiarNumeroZonaPublica)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(500);
				darClickEnOpcionCambiarNumeroZonaPublica();
			} else {
				fail("No se encontró boton 'Cambio de Numero' desde Zona Pública, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void ingresarOTPGenerica() {
		// clicMensajeParaOTP();
		ingresoOTPRegistro("230116");
		btnContinuarOTPRegistro();
	}

	public void clicMensajeParaOTP() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtIngresoFallido)));
			driver.findElement(By.xpath(this.txtIngresoFallido)).click();
		} catch (Exception e) {
			if (!(contador == 20)) {
				Utilidades.esperaMiliseg(2000);
				clicMensajeParaOTP();
			} else {
				fail("No se pudo dar clic en mensaje solicitando ingresode otp debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void pulsarBtnContinuarOTP() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarOTP)));
		MobileElement btnContinuarOTP = driver.findElement(By.xpath(this.btnContinuarOTP));
		// utilidad.darUnTap(202, 200);
		btnContinuarOTP.click();
		btnContinuarOTP.click();
	}

	public void btnContinuarOTPRegistro() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarOTPRegistro)));
		driver.findElement(By.xpath(this.btnContinuarOTPRegistro)).click();
	}

	public void pulsarBtnSalirApp() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSalirApp)));
		driver.findElement(By.xpath(this.btnSalirApp)).click();
	}

	public void pulsarBtnAceptarSalirApp() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptarSalirApp)));
			driver.findElement(By.xpath(this.btnAceptarSalirApp)).click();
		} catch (Exception e) {

			System.out.println("No salio mensaje Daviplata ya esta activo");
		}
	}

	public void pulsarbtnCerrarVideoInicialCasitaRojaXpath() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCerrarVideoInicialCasitaRojaXpath)));
			driver.findElement(By.xpath(this.btnCerrarVideoInicialCasitaRojaXpath)).click();
		} catch (Exception e) {
			System.out.println("No aparece video casita roja");
		}
	}

	public void cerrarMensajeTopes() {
		BaseUtil.driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		try {
			boolean mensajeTopes = driver.findElement(By.xpath(this.mensajeTopes)).isDisplayed();
			if (mensajeTopes) {
				TouchAction touchAction = new TouchAction(driver);
				touchAction.tap(new PointOption().withCoordinates(192, 163)).perform();
			}
			System.out.println("Se encontró y se cerró mensaje de topes");
		} catch (Exception e) {
			System.out.println("No se encontró mensaje de topes");

		}

	}

	public void validarPerfilPersona() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnMenuHamburguesaNegocio)));
			driver.findElement(By.xpath(this.btnMenuHamburguesaNegocio)).click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnIrAPerfilPersona)));
			driver.findElement(By.xpath(this.btnIrAPerfilPersona)).click();
			System.out.println("Estoy en perfil negocio");
			System.out.println("Di click al botón ir a perfil persona");
		} catch (Exception e) {
			if (!(contador == 3)) {
				Utilidades.esperaMiliseg(2000);
				validarPerfilPersona();
			} else {
				System.out.println("Estoy en perfil persona");
			}
		} finally {
			contador = 0;
		}
	}

	public void clickBtnPopUpHuella() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptarHuella)));
			driver.findElement(By.xpath(this.btnAceptarHuella)).click();
		} catch (Exception e) {
			System.out.println("No aparece PopUpHuella");
		}
	}

	public void clickBtnContinuarRegistro() {
		Utilidades.esperaMiliseg(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarRegistrar)));
		driver.findElement(By.xpath(this.btnContinuarRegistrar)).click();
	}

	public void ingresarUsuario(String usuario) {
		base.driver.findElement(By.xpath(this.edtLoginId)).sendKeys(usuario);
		BaseUtil.usuario = usuario;
	}

	public void darClicEnContinuar() {
		try {
			base.driver.findElement(By.name(this.btnContinuarId)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(500);
				darClicEnContinuar();
			} else {
				System.out.println("No se pudo dar clic en boton continuar del login debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void darBtnClicContinuar() {
		try {
			base.driver.findElement(By.xpath(this.btnContinuarlogin)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(1000);
				darClicEnContinuar();
			} else {
				System.out.println("No se pudo dar clic en boton continuar del login debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void darClicEnRegistrarse() {
		utilidad.esperaMiliseg(2000);
		driver.findElement(By.xpath(this.btnRegistrarse)).click();
	}

	public boolean verificoSiEstaRegistrado() {
		BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		boolean clienteRegistrado = true;
		try {
			MobileElement labelActualizarCorreo = base.driver.findElement(By.xpath(this.labelActualizarCorreo));
			clienteRegistrado = !labelActualizarCorreo.isEnabled();
			System.out.println("clienteRegistrado " + clienteRegistrado);
		} catch (Exception e) {
			System.out.println("Entró al catch verificoRegistro");
		}
		System.out.println("cliente registrado: " + clienteRegistrado);
		return clienteRegistrado;
	}

	public void ingresarContrasena(String contrasena) {
		utilidad.esperaMiliseg(4000);
		TouchAction touchAction = new TouchAction(base.driver);
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

	public void ingresarContrasenaDespuesCambio(String contrasena) {
		try {
			contador++;
			utilidad.esperaMiliseg(4000);
			System.out.println("ingresando la contraseña");
			TouchAction touchAction = new TouchAction(driver);
			touchAction.tap(new PointOption().withCoordinates(98, 368)).perform();
			System.out.println("ya di tap");
			// base.driver.findElement(By.xpath(this.desplegarPasswordDespuesCambio)).click();

			contador++;
			int j = 1;
			int k = 0;
			for (int i = 0; i < 4; i++) {
				utilidad.esperaMiliseg(2000);
				base.driver.findElement(By.name("otpTextField_" + j)).sendKeys((contrasena.substring(i, j)));
				j++;
			}
			System.out.println("Ingrese la contraseña correctamenete");

		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(500);
				ingresarContrasenaDespuesCambio(contrasena);
			} else {
				fail("No se pudo ingresar la clave del usuario daviplata debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void ingresarContrasenaNueva(String claveNueva) {
		System.out.println("ingresando la contraseña");
		try {
			contador++;
			base.driver.findElement(By.xpath(this.desplegarPasswordNueva)).click();
			utilidad.esperaMiliseg(500);
			contador++;
			int j = 1;
			int k = 0;
			for (int i = 0; i < 4; i++) {
				utilidad.esperaMiliseg(2000);
				base.driver.findElement(By.name("otpTextField_" + j)).sendKeys((claveNueva.substring(i, j)));
				j++;
			}
			System.out.println("Ingrese la contraseña correctamenete");

		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				ingresarContrasenaNueva(claveNueva);
			} else {
				fail("No se pudo ingresar la clave del usuario daviplata debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void darClicBotonIngresar() {
		try {
			base.driver.findElement(By.name(this.btnIngresar)).click();
		} catch (Exception e) {
			System.out.println("no di clikc a name ingresar");
		}
	}

	public void validarMensajeTopes() {
		try {

			String txtMensaje = driver.findElement(By.xpath(this.mensajeTopeCredito)).getText().toLowerCase();

			if (txtMensaje.contains("Está llegando al tope")) {
				TouchAction touchAction = new TouchAction(driver);
				touchAction.tap(new PointOption().withCoordinates(188, 117)).perform();
			}
		} catch (Exception e) {
			if (!(contador == 2)) {
				Utilidades.esperaMiliseg(2000);
				validarMensajeTopes();
			} else {
				System.out.println("no se encontro mensaje de topes credito");
			}
		} finally {
			contador = 0;
		}
		/*
		 * try { MobileElement btnIngresar = (MobileElement) wait
		 * .until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnIngresar)));
		 * btnIngresar.click(); } catch (Exception e) {
		 * System.out.println(popUpDaviplata() + " " + e.getLocalizedMessage()); }
		 */

	}

	public void verificarPerfilPersona() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.id(this.edtContrasenaId)));
			driver.findElement(By.id(this.edtContrasenaId)).sendKeys();
		} catch (Exception e) {
			if (!(contador == 20)) {
				Utilidades.esperaMiliseg(2000);
				verificarPerfilPersona();
			} else {
				fail("No se pudo ingresar la clave del usuario daviplata debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validarInicioSesion() {
		boolean lblIngresaPresente = validarLblIngresaPresente();
		if (lblIngresaPresente) {
			negocioPO.IraNegocio();
		} else {
			System.out.println("...Estoy en perfil Negocio...");
		}
	}

	public boolean validarLblIngresaPresente() {
		boolean aux = false;
		int cont = 0;
		while ((!aux) && (cont < 7)) {
			try {
				base.driver.findElement(By.xpath(this.labelCuantoTengoHomePerfilPersona));
				aux = true;
			} catch (Exception e) {
				aux = false;
			}
			utilidad.esperaMiliseg(2000);
			cont++;
		}
		return aux;
	}

	public void darClicBotonClose() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCloseAnuncio)));
			driver.findElement(By.xpath(this.btnCloseAnuncio)).click();
		} catch (Exception e) {
			System.out.println("No aparece PopUp");
		}

	}

	public String buscarMensajeDeIngresoALaAplicacion() {
		try {
			utilidad.esperaMiliseg(5000);
			String txtMiDaviPlataXpath = base.driver.findElement(By.xpath(this.txtMiDaviPlataXpath)).getText();
			return txtMiDaviPlataXpath;
		} catch (Exception e) {
			System.out.println("no obtuve mi daviplata");
		}
		return "";
	}

	public void validoIngresoALaAPP(String mensajeActual) {
		assertEquals("¿Cuánto tengo?", mensajeActual);
	}

	public String buscarMensajeDeIngresoFallido() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtIngresoFallido)));
		String txtIngresoFallido = driver.findElement(By.xpath(this.txtIngresoFallido)).getText();
		System.out.println("Mensaje obtenido: " + txtIngresoFallido);
		return txtIngresoFallido;
	}

	public void validoIngresoFallidoALaApp(String mensajeActual) {
		boolean validacion = false;
		if (mensajeActual.contains("La clave ingresada es incorrecta") || mensajeActual.contains("CLAVE INCORRECTA")
				|| mensajeActual.contains("LA CLAVE INGRESADA ES INCORRECTA")
				|| mensajeActual.contains("MAXIMO INTENTO DE CLAVE INVALIDA")) {
			validacion = true;
		}
		assertTrue(validacion);
	}

//***********************************************************ValidacionDeSaldos***********************************************************

	public void validoSaldoDaviPlata() {
		String subSaldo;
		boolean mayorCero = false;
		subSaldo = base.driver.findElement(By.xpath(this.txtSaldoDaviPlata)).getText().replace("$", "").replace(",", "")
				.replace(".", "").replace("pesos", "").replace(" ", "");

		System.out.println(subSaldo);

		Integer saldo = Integer.parseInt(subSaldo);
		System.out.println(saldo);

		if (saldo >= 0) {
			mayorCero = true;
		}

		assertTrue(mayorCero);

	}

	public void validoSaldoeCard() {

		String saldoEcard;
		boolean mayorCero = false;
		saldoEcard = base.driver.findElement(By.xpath(this.txtSaldoEcard)).getText().replace("$", "").replace(",", "")
				.replace(".", "").replace("pesos", "").replace(" ", "");

		System.out.println(saldoEcard);

		Integer saldo = Integer.parseInt(saldoEcard);
		System.out.println(saldo);

		if (saldo >= 0) {
			mayorCero = true;
		}

		assertTrue(mayorCero);
	}

	public void validoSaldoBolsillo() {
		try {
			String saldoBolsillo;
			boolean mayorCero = false;
			saldoBolsillo = base.driver.findElement(By.xpath(this.txtSaldoBolsillo)).getText().replace("$", "")
					.replace(",", "").replace(".", "").replace("pesos", "").replace(" ", "");

			System.out.println(saldoEcard);

			Integer saldo = Integer.parseInt(saldoBolsillo);
			System.out.println(saldo);

			if (saldo >= 0) {
				mayorCero = true;
			}

			assertTrue(mayorCero);
		} catch (Exception e) {
			System.out.println("No hay saldo en bolsillos");
		}

	}

	public void capturoSaldos() {
		Utilidades.esperaMiliseg(1500);
		String txtSaldoDaviplata = base.driver.findElement(By.xpath(this.txtSaldoDaviPlata)).getText().replace("$", "")
				.replace(",", "").replace(".", "").replace("pesos", "").replace(" ", "");
		try {
			String txtSaldoEcard = base.driver.findElement(By.xpath(this.txtSaldoEcard)).getText().replace("$", "")
					.replace(",", "").replace(".", "").replace("pesos", "").replace(" ", "");
			saldoEcard = new BigDecimal(txtSaldoEcard);

			System.out.println("Saldo de la tarjeta ecard: " + saldoEcard);
		} catch (Exception e) {
			System.out.println("No hay saldo ecard Disponible");
		}

		try {
			String txtSaldoBolsillo = base.driver.findElement(By.xpath(this.txtSaldoBolsillo)).getText()
					.replace("$", "").replace(",", "").replace(".", "").replace("pesos", "").replace(" ", "");
			saldoBolsillo = new BigDecimal(txtSaldoBolsillo);
			System.out.println("El saldo del bolsillo es: " + saldoBolsillo);
		} catch (Exception e) {
			System.out.println("No hay saldo bolsillo Disponible");
		}

		saldoDaviPlata = new BigDecimal(txtSaldoDaviplata);
		System.out.println("El saldo del daviplata es: " + saldoDaviPlata);

	}

	public void capturoSaldoTotal() {
		String subSaldo, bolsillo, ecard;
		subSaldo = base.driver.findElement(By.xpath(this.txtSaldoDaviPlata)).getText().replace("$", "").replace(",", "")
				.replace(".", "").replace("pesos", "").replace(" ", "");

		bolsillo = base.driver.findElement(By.xpath(this.txtSaldoEcard)).getText().replace("$", "").replace(",", "")
				.replace(".", "").replace("pesos", "").replace(" ", "");

		ecard = base.driver.findElement(By.xpath(this.txtSaldoBolsillo)).getText().replace("$", "").replace(",", "")
				.replace(".", "").replace("pesos", "").replace(" ", "");

		BigDecimal saldobig = new BigDecimal(subSaldo);
		BigDecimal bolsillobig = new BigDecimal(bolsillo);
		BigDecimal ecardbig = new BigDecimal(ecard);

		BigDecimal subtotal = bolsillobig.add(saldobig).add(ecardbig);
		saldoTotal = subtotal;

		System.out.println("El saldo Total es: " + saldoTotal);
	}

	public void validoSaldoTotal() {
		BigDecimal saldoCalculado = new BigDecimal("0.00");
		saldoCalculado = saldoCalculado.add(saldoDaviPlata).add(saldoEcard).add(saldoBolsillo);
		String saldoCalculadoSinDecimales = saldoCalculado.toString().replace(".00", "");
		System.out.println(saldoTotal.getClass());
		assertEquals(saldoTotal, new BigDecimal(saldoCalculadoSinDecimales));
	}

	public void darClickEnMenuHamburguesa() {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnMenuHamburguesa)));
			base.driver.findElement(By.xpath(this.btnMenuHamburguesa)).click();
		} catch (Exception e) {
			if (!(contador == 10)) {
				utilidad.esperaMiliseg(500);
				darClickEnMenuHamburguesa();
			} else {
				fail("No se encontró botón menu hamburguesa perfil persona debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void darClickEnUsarPlata() {
		try {
			contador++;
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.btnUsarPlata)));
			driver.findElement(By.xpath(this.btnUsarPlata)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(500);
				darClickEnUsarPlata();
			} else {
				fail("No se encontró boton de USAR PLATA debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void darClickEnMasServicios() {
		try {
			contador++;
			base.driver.findElement(By.xpath(this.btnMasServicios)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				darClickEnMasServicios();
			} else {
				fail("No se encontró boton de 'Más Servicios' debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void darClickEnMeterPlata() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnMeterPlata)));
		driver.findElement(By.xpath(this.btnMeterPlata)).click();
	}

	public void darClickEnMeterPlataMH() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnMeterPlataMH)));
		driver.findElement(By.xpath(this.btnMeterPlataMH)).click();
	}

	public void darClickEnPasarPlataMH() {
		driver.findElement(By.xpath(this.btnPasarPlataMH)).click();
	}

	public void darClickEnMeteerPlata() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnMeterPlataXpath)));
		driver.findElement(By.xpath(this.btnMeterPlataXpath)).click();
	}

	public void darClickEnPasarPlata() {
		MobileElement btnMeterPlata = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnPasarPlata)));
		btnMeterPlata.click();
	}

	public void validarIngresoAPSE() {
		Utilidades.esperaMiliseg(5000);
		try {
			MobileElement btnContinuarRegistro = base.driver.findElement(By.xpath(this.btnContinuarRegistro));
			btnContinuarRegistro.click();

			MobileElement btnContinuarActivar = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarActivar)));
			btnContinuarActivar.click();
		} catch (Exception e) {
			System.out.println("Permitió ingresar al portal transaccional");
		}
		Utilidades.esperaMiliseg(5000);
		MobileElement txtPSEconfirmacion = (MobileElement) wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.txtUrlPSEconfirmacion)));
		String txtPSE = txtPSEconfirmacion.getText();
		boolean validacion = false;
		if (txtPSE.contains("PSE")) {
			validacion = true;
		}

		assertTrue(validacion);
	}

//***********************************************************ValidacionDeActualizacionDeDatos***********************************************************
//*************************************************Validacion Mensajes y notificaciones**************************************************	

	public void darClickEnMensajes() {
		MobileElement btnNotificaciones = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.btnNotificaciones)));
		btnNotificaciones.click();
	}

	public void btnCompras() {
		try {
			contador++;
			MobileElement btnNotificaciones = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCompras)));
			btnNotificaciones.click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(500);
				btnCompras();
			} else {
				fail("No se encontró botón 'Tienda virtual' de mensajes del cliente en la campana de notificaciones, debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void btnBonoLeer() {
		try {
			MobileElement btnNotificaciones = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnComprasTienda)));
			btnNotificaciones.click();

			MobileElement btnValidarLeerBono = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnValidarLeerBono)));

			utilidad.tomaEvidencia("Valido que se pueda leer la compra en tienda virtual");
		} catch (Exception e) {
			String compra = base.driver.findElement(By.xpath(this.btnValidarLeerBono2)).getText();
			System.out.println(compra);
			if (compra.contains("20")) {
				assertTrue(true);
				utilidad.tomaEvidencia("Valido que se pueda leer la compra en tienda virtual");
			} else {
				assertTrue(false);
			}
		}

		//// android.widget.ListView/android.widget.LinearLayout[1]/android.widget.TextView[1]
	}

	public void validarQueAparezcanMensajes() {
		MobileElement listNotificaciones = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.btnNotificaciones)));
		String validar = listNotificaciones.getText();
		System.out.println(validar);
		boolean validacion = false;
		if (validar.contains("Novedades")) {
			validacion = true;
		}
		assertTrue(validacion);

	}

	public void validarQueAparezcanCompras() {
		MobileElement listNotificaciones = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.btnCompras)));
		String validar = listNotificaciones.getText();
		System.out.println(validar);
		boolean validacion = false;
		if (validar.contains("Compras")) {
			validacion = true;
		}
		assertTrue(validacion);

	}

	public void validarQueAparezcanNotificaciones() {
		utilidad.esperaMiliseg(5000);
		MobileElement listNotificaciones = driver.findElement(By.xpath(this.listNotificaciones));
		listNotificaciones.click();
		String validar = listNotificaciones.getText();
		System.out.println(validar);
		boolean validacion = false;
		if (validar.contains("Transacciones")) {
			validacion = true;
		}
		assertTrue(validacion);

	}

	public void seleccionarMensajeAEliminar() {
		System.out.println("seleccione el mensaje a eliminar");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.selectMensajeEliminar)));
		driver.findElement(By.xpath(this.selectMensajeEliminar)).click();
	}

	public void darClickEnEliminar() {
		System.out.println("di click al btn de eliminar");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnEliminar)));
		driver.findElement(By.xpath(this.btnEliminar)).click();
	}

	public void validarQueSeEliminenLosMensajesONotificaciones() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtEliminado)));
		MobileElement txtEliminado = driver.findElement(By.xpath(this.txtEliminado));
		System.out.println("validando mensaje de eliminacion de notificaciones");
		String txtNotificacion = txtEliminado.getText();
		System.out.println(txtNotificacion);
		boolean validacion = false;
		if (txtNotificacion.contains("Eliminado")) {
			validacion = true;
		}
		assertTrue(validacion);

	}

	public void darBtnAceptarEliminarMensaje() {
		System.out.println("di click al btn aceptar eliminar mensaje");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnEliminarMensaje)));
		driver.findElement(By.xpath(this.btnEliminarMensaje)).click();
	}

	public void verificoPopUp() {

		MobileElement btnPopUp = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnPopUp)));
		utilidad.tomaEvidencia("Seleccion de opcion Autorizo");
		assertTrue(btnPopUp.isEnabled());
		btnPopUp.click();
	}

	// Registro Latinia

	public void darClickEnContinuarRegistro() {

		MobileElement btnContinuarRegistro = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarRegistro)));
		btnContinuarRegistro.click();
	}

	public void darClickEnContinuarOTP() {

		MobileElement btnContinuar = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.btnContinuarRegistro2)));
		btnContinuar.click();

		utilidad.esperaMiliseg(500);

		btnContinuar.click();
	}

	public void darClickEnNotificacion() {
		MobileElement labelNotificacion = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.labelNotificacion)));
		labelNotificacion.click();
	}

	public void ingresarCorreoElectronico() {
		MobileElement inputCorreoElectronico = (MobileElement) wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id(this.inputCorreoElectronico)));
		inputCorreoElectronico.sendKeys(Credenciales.propertiesRegistro().getProperty("correo.registro"));
	}

	public void ingresoClaveDaviplata(String clave) {
		MobileElement inputClaveRegistro = (MobileElement) wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id(this.inputClaveRegistro)));
		inputClaveRegistro.sendKeys(clave);
	}

	public String capturoNumTelefono() {

		MobileElement labelNumTelefoo = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.labelNumTelefoo)));
		System.out.println(labelNumTelefoo.getText());
		String ultimosCuatroDigitos = labelNumTelefoo.getText().split(" ")[2];
		System.out.println(ultimosCuatroDigitos);
		return ultimosCuatroDigitos;
	}

	public String capturoNumTelefonoRegistro() {

		MobileElement labelNumTelefoo = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.labelNumTelefooo)));
		System.out.println(labelNumTelefoo.getText());
		String ultimosCuatroDigitos = labelNumTelefoo.getText().split(" ")[2];
		System.out.println(ultimosCuatroDigitos);
		return ultimosCuatroDigitos;
	}

	public void ingresoOTP(String OTP) {
		// utilidad.darUnTap(202, 200);
		MobileElement inputOtp = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.inputOtp)));
		inputOtp.sendKeys(OTP);
	}

	public void ingresoOTPRegistro(String OTP) {
		try {
			contador++;
			driver.findElement(By.xpath(this.inputOtpRegistro)).sendKeys(OTP);

			// String[] otpDividida = OTP.split("");
			// for(int i = 1; i <= 6; i++) {
			// driver.findElement(By.xpath("//XCUIElementTypeTextField['"+ i
			// +"']")).sendKeys(otpDividida[i - 1]);
			// }

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarTeclado)));
			driver.findElement(By.xpath(this.btnContinuarTeclado)).click();

		} catch (Exception e) {
			if (!(contador == 20)) {
				Utilidades.esperaMiliseg(2000);
				ingresoOTPRegistro(OTP);
			} else {
				fail("No se pudo ingresar valor de otp debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void ingresoOTPInvalida() {
		try {
			contador++;
			driver.findElement(By.xpath(this.inputOtpRegistro)).sendKeys("123456");

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarTeclado)));
			driver.findElement(By.xpath(this.btnContinuarTeclado)).click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuar2)));
			driver.findElement(By.xpath(this.btnContinuar2)).click();

		} catch (Exception e) {
			if (!(contador == 20)) {
				Utilidades.esperaMiliseg(2000);
				ingresoOTPInvalida();
			} else {
				fail("No se pudo ingresar valor de otp debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void salirNotificacionesYMensajes() {
		try {
			MobileElement labelNotificaciones = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.id(this.labelNotificaciones)));
			if (labelNotificaciones.getText().contains("Notificaciones y mensajes"))
				pulsarBtnRegresar();
		} catch (Exception e) {
			System.out.println("No aparecieron 'Notificaciones y mensajes'");
		}
	}

	public void pulsarBtnRegresar() {
		MobileElement btnRegresar = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnRegresar)));
		btnRegresar.click();
	}

	// Cambio Numero
	public void pulsarBotonCambiarNumero() {
		base.driver.findElement(By.name(this.btnCambiarNumero)).click();
		utilidad.tomaEvidencia("Cambiar Numero");
	}

	public void pulsoTipoDeDocumento() {
		try {
			System.out.println("pulse el tipo de documento");
			contador++;
			MobileElement btnCambiarNumero = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.tipoDocumento)));
			utilidad.tomaEvidencia("Pagina principal de daviplata");
			btnCambiarNumero.click();
			utilidad.tomaEvidencia("Selecciono tipo de documento");
		} catch (Exception e) {
			if (!(contador == 20)) {
				Utilidades.esperaMiliseg(2000);
				pulsoTipoDeDocumento();
			} else {
				fail("No se pudo dar clic en select tipo de documento en login debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void seleccionarTipoDocumento(String tipoDocumento) {
		try {
			MobileElement listaDesplegable = (MobileElement) wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.listaTipoId)));

			JavascriptExecutor js = (JavascriptExecutor) base.driver;
			Map<String, Object> params = new HashMap<>();

			System.out.println("El tipo documento requerido es: " + tipoDocumento);

			contador++;

			switch (tipoDocumento) {
			case "CC":
				System.out.println("Entra a caso donde quiere seleccionar Cédula de Ciudadanía");
				break;
			case "Cédula de ciudadanía":
				System.out.println("entra al caso donde se quiera ir a Cada quince días");
				break;
			case "TI":

				params.put("order", "previous");
				params.put("offset", 0.15);
				params.put("element", ((RemoteWebElement) listaDesplegable).getId());
				js.executeScript("mobile: selectPickerWheelValue", params);
				System.out.println("Hola ya ejecute el scroll");
				break;

			case "CE":

				params.put("order", "next");
				params.put("offset", 0.15);
				params.put("element", ((RemoteWebElement) listaDesplegable).getId());
				js.executeScript("mobile: selectPickerWheelValue", params);
				System.out.println("Hola ya ejecute el scroll");
				break;

			case "PEP":

				params.put("order", "next");
				params.put("offset", 0.15);
				params.put("element", ((RemoteWebElement) listaDesplegable).getId());
				js.executeScript("mobile: selectPickerWheelValue", params);
				System.out.println("Hola ya ejecute el scroll");
				break;

			default:
				MobileElement btnContinuar = (MobileElement) wait
						.until(ExpectedConditions.elementToBeClickable(By.name(this.btnContinuar)));
				btnContinuar.click();

				System.out.println("No encontre el periodo");
				break;
			}

			MobileElement btnContinuar = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuar)));
			btnContinuar.click();

			System.out.println("Seleccione TIPO ID");

		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(500);
				seleccionarTipoDocumento(tipoDocumento);
			} else {
				fail("No se puedo ingresar el TIPO ID debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validacionDatos() {
		MobileElement objMobileElement = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.ingresarDocumento)));
		objMobileElement.sendKeys("Prueba123");
		MobileElement objMobileElement2 = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.btnInicar)));
		objMobileElement2.click();
		utilidad.tomaEvidencia("Documento incorrecto");
		objMobileElement.click();
		objMobileElement.click();
		objMobileElement.sendKeys("*+*_1254");
		utilidad.esperaMiliseg(2000);
		objMobileElement2.click();
		utilidad.tomaEvidencia("Documento incorrecto");
	}

	public void validoBtnUsarPlata() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnUsarPlata)));
		String txtUsarPlata = driver.findElement(By.xpath(this.btnUsarPlata)).getText();
		assertThat(txtUsarPlata, containsString("Usar Plata"));
	}

	public void validomensajedaviplatainvalido() {
		MobileElement txtTransaccionFail = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.enunciado)));

		boolean validacion = false;

		if (txtTransaccionFail.isDisplayed()) {

			validacion = true;
		} else {
			validacion = false;
		}
		assertEquals(true, validacion);

	}

	public void validarMensajeCaracteres() {
		BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		MobileElement mensajeCaracter = driver.findElement(By.xpath(MENSAJE_CARACTER_ESPECIAL));
		String texto = mensajeCaracter.getText();
		assertThat(texto, containsString("Su identificacion/celular debe tener"));
	}

	public void validarLongitudCaracteres(String usuario) {
		try {
			contador++;
			MobileElement carcateresLongitud = (MobileElement) wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.edtLoginId)));
			String cadenaEscrita = carcateresLongitud.getText();
			int longitudEscrita = cadenaEscrita.length();
			int longitudAlmacenada = usuario.length();
			assertThat(longitudEscrita, is(not(equalTo(longitudAlmacenada))));
			System.out.println("------------------------------ NOTA ------------------------------------ ");
			System.out.println(" La longitud escrita es: " + longitudEscrita
					+ ", la longitud enviada a escribir fue de: " + longitudAlmacenada);
			System.out.println(" debido a que la app no permite longitudes mayores a quince ");
			System.out.println("------------------------------------------------------------------------ ");
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				validarLongitudCaracteres(usuario);
			} else {
				fail("No se encontró input de escritura de usuario en logeo debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void validarTipoDeDocumento() {
		try {
			contador++;
			MobileElement btnTipoDocumental = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.tipoDocumento)));

			btnTipoDocumental.click();
			Utilidades.tomaEvidencia("tipo de documento abierto");
			assertThat(btnTipoDocumental.isDisplayed(), is(equalTo(true)));
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(500);
				pulsoTipoDeDocumento();
			} else {
				fail("No se pudo dar clic en select tipo de documento en login debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void validacionCaracterEspecial() {
		try {
			contador++;
			int j = 1;
			for (int i = 0; i < 4; i++) {
				MobileElement edtContrasena = (MobileElement) wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//XCUIElementTypeSecureTextField[" + j + "]")));
				System.out.println("valor de j: " + j);
				String valoresContrasena = edtContrasena.getText();
				if (valoresContrasena.matches("[0-9]*")) {
					System.out.println("Se encontró el numero: " + valoresContrasena);
				} else {
					System.out.println("Se encontró el siguiente caracter especial: " + valoresContrasena);
				}
				j++;
			}

		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(500);
				validacionCaracterEspecial();
			} else {
				System.out.println("No se encontró campo de contraseña debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validarLongitudCaracteresPEP(String usuario) {
		try {
			contador++;
			MobileElement carcateresLongitud = (MobileElement) wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.edtLoginId)));
			String cadenaEscrita = carcateresLongitud.getText();
			int longitudEscrita = cadenaEscrita.length();
			int longitudAlmacenada = usuario.length();
			assertThat(longitudEscrita, is((equalTo(longitudAlmacenada))));
			System.out.println("------------------------------ NOTA ------------------------------------ ");
			System.out.println(" La longitud escrita es: " + longitudEscrita
					+ ", la longitud enviada a escribir fue de: " + longitudAlmacenada);
			System.out.println("------------------------------------------------------------------------ ");
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				validarLongitudCaracteresPEP(usuario);
			} else {
				fail("No se encontró input de escritura de usuario en logeo debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void validacionIngresoDaviPlataLookAndFeel() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.labelIngresoDaviplata)));
			assertThat(element.getText(), containsString("Ingrese a su Daviplata"));
		} catch (Exception e) {
			if (!(contador == 20)) {
				Utilidades.esperaMiliseg(2000);
				validacionIngresoDaviPlataLookAndFeel();
			} else {
				fail("No se encontró label 'Ingrese a su DaviPlata' debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validacionIngresoContrasenaLookAndFeel() {
		try {
			System.out.println("entre a validar look and feel en clave");
			contador++;
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.labelIngresoContrasena)));
			String element = base.driver.findElement(By.xpath(this.labelIngresoContrasena)).getText();
			assertThat(element, containsString("Ingrese su clave"));
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(500);
				validacionIngresoContrasenaLookAndFeel();
			} else {
				fail("No se encontró label 'Ingrese su clave' debido a: " + e.getMessage());
			}

		} finally {
			contador = 0;
		}

	}

	public void ingresarLatinia() {
		System.out.println("estoy ingresando a latinia");
		pageLatinia.initDriverLatinia();
		System.out.println(Credenciales.propertiesWebs().getProperty("web.Nlatinia.url"));
		utilidad.esperaMiliseg(5000);
		utilidad.tomaEvidenciaPantalla("Ingreso a Latinia");
		pageLatinia.ingresarEmpresa();
		pageLatinia.ingresarUsuario();
		pageLatinia.ingresarPassword();
		utilidad.tomaEvidenciaPantalla("Ingreso credenciales y dar en botón Acceder");
		pageLatinia.darClickAcceder();

	}

	public void validarMensajes() {
		pageLatinia.vaidarMensajes();
	}

	public void validarInicioSesionPersona() {
		boolean elementoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginPageObjects.PERFIL_PERSONA_BTN);
		if(elementoVisible == true) {
			Utilidades.esperaMiliseg(1000);
			System.out.println("Me encuentro en el perfil 'Mi DaviPlata'");
		} else {
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.clicElement("xpath", LoginPageObjects.PERFIL_MI_DAVIPLATA_BTN);
		}
	}

	public boolean validarPerfilNegocioPresente() {
		boolean aux = false;
		int cont = 0;
		while ((!aux) && (cont < 7)) {
			try {
				base.driver.findElement(By.xpath(this.homePerfilNegocio));
				aux = true;
			} catch (Exception e) {
				aux = false;
			}
			utilidad.esperaMiliseg(500);
			cont++;
		}
		return aux;
	}

	public void esperarAparezcaHomeZonaPublica() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.logoDaviplata)));
		} catch (Exception e) {
			if (!(contador == 40)) {
				utilidad.esperaMiliseg(500);
				esperarAparezcaHomeZonaPublica();
			} else {
				fail("No se encontró logo de home daviplata en zona pública, debido a: " + e.getMessage());
			}

		} finally {
			contador = 0;
		}

	}

}
