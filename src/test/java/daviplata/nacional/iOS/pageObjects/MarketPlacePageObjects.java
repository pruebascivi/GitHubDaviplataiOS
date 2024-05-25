package daviplata.nacional.iOS.pageObjects;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.hamcrest.CoreMatchers.is;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import daviplata.nacional.iOS.definitions.Hooks;
import daviplata.nacional.iOS.utilidades.Utilidades;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.core.pages.PageObject;

public class MarketPlacePageObjects extends PageObject {

	private AppiumDriver<MobileElement> driver = Hooks.getDriver();
	private WebDriverWait wait = Hooks.getDriverWait();
	Utilidades utilidad;
	Utilidades utilidades;
	BaseUtil base;
	

	// -------------Aliados-----------------//

	private int contador = 0;
	private String btnMarketPlace = "(//XCUIElementTypeOther[@name='Tienda Virtual'])[2]";
	private String btnPopMarket = "//XCUIElementTypeButton[@name='iconTiendaVirtual']";
	private String cerrarPopup = "//XCUIElementTypeButton[@name='Aceptar']";
	private String btnSeguros = "//XCUIElementTypeOther[@name='Seguros']";
	private String btnSeguroVida = "//XCUIElementTypeStaticText[@name=\"Vida\"]";
	private String btnLuz = "//*[@text='Luz']";
	private String btnAgua = "//*[@text='Agua']";
	private String btnGas = "//*[@text='Gas']";
	private String btnPagos = "//XCUIElementTypeButton[@name='iconPagos']";
	private String btnPagosServicios = "//XCUIElementTypeStaticText[@name=\"Pago de Servicios\"]";
	private String btnServicioAgua = "//XCUIElementTypeOther[@name='Agua boton']";

	private String btnContinuar = "//XCUIElementTypeButton[@name='Done']";
	private String btnContinuar3 = "//XCUIElementTypeButton[@name='Continuar']";
	private String btnContinuarTeclado = "(//XCUIElementTypeButton[@name='Continuar'])[2]";
	private String btnSeleccionaroberturaPrimera = "(//XCUIElementTypeButton[@name='Seleccionar'])[1]";
	private String btnSeleccionarCoberturaSegunda = "//XCUIElementTypeScrollView/XCUIElementTypeButton";
	private String txtNotifyRappi = "//*[contains(@name, 'Usted ya cuenta con seguro vigente')] | //*[contains(@name, 'rango de edad')] | //*[contains(@name, 'Fondos insuficientes')]";
	private String btnNecesitoAyuda = "//XCUIElementTypeOther[@name='Ir a asesor virtual boton']";
	private String btnNecesitoAyuda1 = "//android.view.View[@content-desc=\"Ir a asesor virtual ¿Necesita ayuda?\"]";
	private String btnHamburguesa = "com.davivienda.daviplataapp.lab:id/ivMenuHowMuch";
	private String btnOpcionesHome = "//XCUIElementTypeButton[@name='iconPagos']";
	private String btnCerrarPopup = "//XCUIElementTypeButton[@name='Close']";

	// Fecha de nacimiento
	private String btnFechaNacimiento = "(//XCUIElementTypeButton[@name='selector arrow down red'])[1]";
	private String btnAno = "//XCUIElementTypePickerWheel[3]";
	private String btnAnoEspecifico = "//*[@text='1997']";
	private String btnAceptar2 = "//XCUIElementTypeButton[@name='Done'] | //XCUIElementTypeButton[@name='Aceptar'] ";
	private String btnAceptar = "//XCUIElementTypeButton[@name='Aceptar']";

	// Genero

	private String btnGenero = "(//XCUIElementTypeButton[@name='selector arrow down red'])[2]";
	private String btnGeneroMasculino = "//*[@text='Masculino']";
	private String btnGeneroFemenino = "//*[@text='Femenino']";
	private String listaGenero = "//XCUIElementTypePickerWheel";

	// CheckBox y continuar
	private String btnCheckBox = "//XCUIElementTypeButton[@name='radio btn normal']";
	private String btnContinuarCheck = "//XCUIElementTypeButton[@name='Continuar']";

	// validar
	private String resultadosTransaccion = "//*[@class='android.widget.TextView']";
	private String btnFinalizar = "//*[contains(@name,'Finalizar')]";
	private String txtNumeroPoliza = "//XCUIElementTypeOther[2]/XCUIElementTypeOther[2]";
	private String txtValorPoliza = "(//XCUIElementTypeStaticText[contains(@name, '$')])[3]";
	private String txtValorPolizaBicicleta = "(//XCUIElementTypeStaticText[contains(@name, '$')])[2]";
	private String txtNumeroAutorizacion = "//XCUIElementTypeOther[2]/XCUIElementTypeOther[5]";
	private String txtFechaHora = "//XCUIElementTypeOther[2]/XCUIElementTypeOther[4]";
	private String txtAutorizador = "(//XCUIElementTypeStaticText)[10]";
	private String txtValorPago = "com.davivienda.daviplataapp.lab:id/hacer_pagos_complete_3";
	private String popUpTerminosCondiciones = "//*[contains(@name,'comprar productos')]";

	// Home
	private String btnActualizarSaldo = "com.davivienda.daviplataapp.lab:id/text_balance";
	private String labelSaldo = "//XCUIElementTypeOther[contains(@name, 'lbl-mount')]";

	// Gas
	private String btnOtroServicios = "//XCUIElementTypeOther[@name='Otros Servicios']";
	private String btnBuscarEmpresa = "com.davivienda.daviplataapp.lab:id/hacer_pagos_busqueda";
	private String btnClickBuscarEmpresa = "com.davivienda.daviplataapp.lab:id/pago_frecuente_convenio_name";
	private String txtReferencia = "com.davivienda.daviplataapp.lab:id/hacer_pagos_referencia_numero";
	private String btnContinuarRef = "com.davivienda.daviplataapp.lab:id/hacer_pagos_referencia_btn_continuar";
	private String btnPagarRef = "//*[contains(@text,'Pagar')]";

	// Mascotas
	private String btnMascota = "//*[@name='Mascota']";
	private String btnContinuarMascota = "//XCUIElementTypeButton[@name='Continuar']";
	private String btnSeleccionarOpcion1 = "(//XCUIElementTypeButton[@name='Seleccionar'])[1]";
	private String btnSeleccionarOpcion2 = "//XCUIElementTypeScrollView/XCUIElementTypeButton";
	private String btnSeleccionarMascota = "//XCUIElementTypeButton[@name='selector arrow down red']";
	private String btnSeleccionarGato = "//*[@text='Gato']";
	private String btnSeleccionarPerro = "//*[@text='Perro']";
	private String btnCheckBoxMascota = "com.davivienda.daviplataapp.lab:id/check_info_micro_seguros";
	private String btnContinuarMasco = "com.davivienda.daviplataapp.lab:id/hacer_pagos_monto_btn_continuar";

	// Bicicleta

	private String btnBicicleta = "//XCUIElementTypeStaticText[@name='BIcicleta']";
	private String btnFechaBicicleta = "//XCUIElementTypeButton[@name=\"selector arrow down red\"]";
	private String btnFecha = "//*[@text='2015']";
	private String listaFecha = "//XCUIElementTypePickerWheel";
	private String btnContinuar2 = "(//XCUIElementTypeButton[@name='Continuar'])[2]";

	// SOAT
	private String btnSoat = "//XCUIElementTypeStaticText[@name='SOAT']";
	private String btnContinuarSoat = "//div[@class='_highlighter-box_619e8 _inspected-element-box_619e8']";
	private String txtPlaca = "//*[@class='android.widget.EditText']";
	private String checkBoxSi = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View";
	private String btnCotizar = "//android.widget.Button[contains(@text,'Cotizar')]";
	private String btnCiudadSoat = "//*[@resource-id='ciudad']";
	private String btnEscogerCiudad = "//*[contains(@text,'LETI')]";
	private String btnLapiz = "(//android.view.View[@content-desc=\"Editar\"])[2]/android.widget.Image";
	private String btnSeleccione = "//*[contains(@text,'Seleccione')]";
	private String btnSelectId = "//android.widget.CheckedTextView[@text='Cédula de ciudadanía']";
	private String inputNumId = "(//android.widget.EditText)[2]";
	private String inputNombre = "(//android.widget.EditText)[3]";
	private String inputApellido = "(//android.widget.EditText)[4]";
	private String btnCalleSoat = "//*[(@text='Calle')]";
	private String btnPrimero = "//*[@resource-id='fieldOne']";
	private String btnSegundo = "//*[@resource-id='fieldTwo']";
	private String btnTercero = "//*[@resource-id='fieldThree']";
	private String btnCasa = "//*[@resource-id='aptoFloorOther']";
	private String btnCorreoSoat = "//*[@resource-id='correo']";
	private String checkBoxTerminos = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View/android.view.View[6]/android.view.View[1]";
	private String btnAceptarTermino = "//*[contains(@text,'Aceptar')]";
	private String btnComprarSoat = "//*[contains(@text,'Comprar')]";
	private String btnPlacaInvalida = "//*[contains(@text,'ingresar')]";

	// Otros servicios
	private String btnOtrosServicios = "//*[contains(@text,'Otros Servicios')]";
	private String btnEmpresaOtrosServicio = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView";
	private String txtvalor = "com.davivienda.daviplataapp.lab:id/hacer_pagos_manual_op4_value";
	private String txtRappi = "com.davivienda.daviplataapp.lab:id/notif_text_rappi";
	private String btnEmpresaBuscada = "//*[@text='BDI - 2011 DNR 01012913']";
	private String btnContinuarOtrosServicios = "com.davivienda.daviplataapp.lab:id/hacer_pagos_manual_btn_pagar";
	// Salir Daviplata
	private String btnSalir = "com.davivienda.daviplataapp.lab:id/nav_bar_btn_close";
	private String btnAceptarSalir = "//*[@text='Aceptar']";
	private String txtDaviplata = "com.davivienda.daviplataapp.lab:id/btn_login_tipodoc";

	// Bonos
	private String btnCorral = "//XCUIElementTypeStaticText[@name='Bonos de hamburguesas y malteadas']";
	private String btnCrepes = "//XCUIElementTypeStaticText[@name='Bonos de Mini waffles y helado']";
	private String btnBono20k = "//XCUIElementTypeLink[@name='Bono $20.000']";
	private String btnBono50k = "//XCUIElementTypeLink[@name='Seven Seven Bono $50.000']";
	private String btnMiniWafle = "//XCUIElementTypeLink[@name='Mini Waffle']";
	private String btnContinuarBogo = "//XCUIElementTypeButton[@name='Continuar']";
	private String txtEmail = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.view.View[12]/android.view.View[2]/android.widget.EditText";
	private String btnComprar = "//XCUIElementTypeButton[contains(@name,'Comprar')]";
	private String txtCorreoInput = "//XCUIElementTypeTextField[@value='correo@correo.com']";
	private String txtValidarCompra = "//XCUIElementTypeStaticText[@name='¡Gracias por su compra!']";
	private String txtValorBono = "com.davivienda.daviplataapp.lab:id/tvResponseAmmount";
	private String btnCampana = "com.davivienda.daviplataapp.lab:id/ivNotification";
	private String btnComprasTiendaVirtual = "com.davivienda.daviplataapp.lab:id/tab3_text";
	private String txtValidarCompraCampana = "//*[contains(@text, 'Quantum')]";
	private String btnDescargarBono = "//XCUIElementTypeStaticText[@name='Descargar']";
	private String txtBoleta = "//*[contains(@name,'Boleta')]";

	// Descuentos
	private String btnDescuentos = "com.davivienda.daviplataapp.lab:id/tvDiscount";
	private String btnValidarDescuentos = "//android.widget.ImageView";

	// Descuentos Dunkin Donuts
	private String btnDonuts = "//android.view.View[@content-desc='Dunkin Donuts Caja x 6']/android.widget.Image";
	private String btnDepartamento = "//*[contains(@text, 'departamento')]";
	private String btnBono = "//*[contains(@text, 'Bono')]";
	private String btnCundinamarca = "//*[contains(@text, 'Cundinamarca')]";
	private String btnCiudad = "//*[contains(@text, 'ciudad')]";
	private String btnChia = "//*[contains(@text, 'Chia')]";
	private String btnEstablecimiento = "//*[contains(@text, 'Seleccione')]";
	private String btnContinuarGeneral = "//XCUIElementTypeButton[@name='Continuar']";

	// Aliados

	private String btnTodos = "//XCUIElementTypeStaticText[@name='Todos']";
	private String btnRecargas = "//*[contains(@name, 'Recargas')]";
	private String btnRecargasNativas = "//android.widget.LinearLayout[@content-desc='Recargas Nativas']";
	private String btnRestaurante = "//*[contains(@name, 'Restaurantes')]";
	private String btnVestuario = "//*[contains(@name, 'Vestuario')]";
	private String btnSalud = "//XCUIElementTypeStaticText[@name='Salud']";
	private String btnServiciosHogar = "//*[contains(@name, 'Servicios hogar')]";
	private String btnCines = "//*[contains(@name, 'Cines')]";
	private String btnOtros = "//*[contains(@text, 'Otros')]";
	private String btnMercado = "//*[contains(@name, 'Mercado')]";
	private String btnSegurosAliados = "//*[contains(@name, 'Seguros')]";
	private String btnEntretenimiento = "//*[contains(@name, 'Entretenimiento')]";
	private String btnContenidoDigital = "//*[contains(@name, 'Contenido')]";
	private String btnJuegos = "//*[contains(@name, 'Juegos')]";
	private String btnTransporte = "//*[contains(@name, 'Transporte')]";
	private String btnDomicilios = "//*[contains(@name, 'Domicilios')]";

	private String btnGrandesAlmacenes = "//*[contains(@text, 'Almacenes')]";
	// private String btnServiciosSalud = "//*[contains(@text, 'Servicios hogar')]";
	private String btnvalidarAliados = "com.davivienda.daviplataapp.lab:id/vpAlliesOptional";
	private String btnvalidarAliadosMain = "(//XCUIElementTypeCollectionView)[4]";
	private String listAliados = "(//android.widget.LinearLayout)";
	private String btnAvanzar = "(//android.widget.ImageView)[3]";

	// Donas
	private String btnDonas = "//*[contains(@text, \"donas\")]";

	// Volver

	private String btnVolver = "//XCUIElementTypeButton[@name='Botón atrás']";

	// Crear Negocio

	private String btnIrNegocio = "//XCUIElementTypeButton[@name='Ir a su negocio']";
	private String checkBoxNegocio = "com.davivienda.daviplataapp.lab:id/tvTermsAndConditionsBenefits";
	private String linkTerminosYCondicionesNegocio = "(//XCUIElementTypeOther[1]/XCUIElementTypeButton)[1]";
	private String btnCrearNegocio = "//XCUIElementTypeButton[@name='Crear Mi Negocio']";
	private String txtNombreNegocio = "//XCUIElementTypeTextField[@name='¿Cuál es el nombre de su negocio?']";
	private String txtVendeNegocio = "//XCUIElementTypeOther[@name='main']/XCUIElementTypeOther[3]/XCUIElementTypeTextField";
	private String txtCiudadNegocio = "//XCUIElementTypeOther[@name='main']/XCUIElementTypeOther[5]/XCUIElementTypeTextField";

	private String btnVender = "//android.view.View/android.view.View[2]/android.widget.Spinner";
	private String btn_Discos_Vender = "//*[contains(@text, 'CONTRATISTAS')]";
	private String txtMonto = "//XCUIElementTypeTextField[@name='¿Cuál es el monto de sus ventas mensuales?']";
	private String btnCiudadNegocio = "//XCUIElementTypeOther[5]/XCUIElementTypeTextField";
	private String btnElegirCiudad = "//XCUIElementTypeOther[@name='main']/XCUIElementTypeOther[5]/XCUIElementTypeOther[4]";
	private String btnDireccion1 = "//XCUIElementTypeOther[@name='main']/XCUIElementTypeOther[7]";
	private String btnCalle = "(//XCUIElementTypeStaticText[@name='Calle'])[2]";
	private String txtDireccion2 = "//XCUIElementTypeOther[@name='main']/XCUIElementTypeOther[11]";
	private String txtDireccion3 = "//XCUIElementTypeOther[@name='main']/XCUIElementTypeOther[13]";
	private String txtDireccion4 = "//XCUIElementTypeOther[@name='main']/XCUIElementTypeOther[15]";
	private String txtCasa = "//XCUIElementTypeOther[@name='main']/XCUIElementTypeOther[16]";
	private String txtCorreo = "//XCUIElementTypeTextField[@name='Ingrese el correo electrónico de su negocio']";
	private String btncontinuanmicroseguro = "//XCUIElementTypeButton[@name='Continuar']";
	private String yaTiene = "com.davivienda.daviplataapp.lab:id/notif_text_rappi";
	private String logoCargaPagina = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]";

	// Validar negocio
	private String txtRegistro = "(//XCUIElementTypeStaticText[@name='Registro exitoso'])[2] | (//XCUIElementTypeStaticText[@name='Registro exitoso'])[2] | //XCUIElementTypeStaticText[contains(@value, 'exitoso')]";
	private String txtDaviplataNegocio = "//*[contains(@text, 'Mi DaviPlata')]";
	private String txtfondosinsuficientesmicroseguros = "//XCUIElementTypeStaticText[@name='Fondos insuficientes']";

	// Validar saldo perfil negocio
	private String txtSaldoNegocioDaviplata = "//android.widget.TextView[2]";

	// Minutos
	private String btnMinutos = "//*[contains(@text, 'Gas')]";
	private String btnRappi = "com.davivienda.daviplataapp.lab:id/notif_text_rappi";
	private String pantalla;
	private String btnCrearNego = "//XCUIElementTypeButton[@name='Crear negocio']";

	// Validar Scroll
	private String btnScrollCategorias = "//XCUIElementTypeButton[@name='ic arrow right']";
	private String btnPruebasTecnologia = "//XCUIElementTypeStaticText[@name='Adquiera los mejores productos']";
	private String btnScroll = "//XCUIElementTypeButton[@name='ic arrow right']";
	private String txtTodos = "//XCUIElementTypeStaticText[@name='Todos']";
	private String btnTiendaNumero4 = "(//XCUIElementTypeStaticText[@name='Bonos genéricos'])[4]";
	private String btnCinemark = "//XCUIElementTypeStaticText[@name='Bonos de boletería y confitería']";
	private String btnEntrada2d = "//XCUIElementTypeLink[@name='Entrada 2D']";
	private String bono = "//*[contains(@text, 'Bono')]";
	private String valorBono = "//android.view.View[6]";
	private String btnDescargar = "(//*[contains(@text, 'Descargar')])[2]";
	private String btnCompartir = "(//*[contains(@text, 'Compartir')])";
	private String btnRecargasTiendaVirtual = "//XCUIElementTypeButton[@name=\"Opción para recargar\"]";
	private String btnRecargasTienda = "//XCUIElementTypeStaticText[@name='Recargas']";
	private String popUpTerminosCondicionesNoAparece = "//XCUIElementTypeStaticText[@name='Pago de Servicios']";
	private String btnRestaurantes = "//XCUIElementTypeStaticText[@value= 'Restaurantes']";
	private String btnBonoHamburguesas = "//XCUIElementTypeStaticText[@name='Bonos de hamburguesas y malteadas']";
	private String btnTerminosCondicionesTiendaVirtual = "//XCUIElementTypeButton[@name='Aceptar']";
	private String btnCerrar = "com.davivienda.daviplataapp.lab:id/ivClose";
	private String listaNotificaciones = "com.davivienda.daviplataapp.lab:id/notificaciones_list_item_text";
	private String bonoCompra = "com.davivienda.daviplataapp.lab:id/main_detail_container";
	private String btnEditarBono = "//*[@resource-id='editarCorreo-btn']";
	private String inputCorreoBono = "//*[@resource-id='email']";
	private String franjaAliados = "//XCUIElementTypeStaticText[@name='Nuestros aliados']";
	private String contenedorAliados = "(//XCUIElementTypeOther[1]/XCUIElementTypeButton)";
	private String franjaCategorias = "com.davivienda.daviplataapp.lab:id/tabsAllies";
	private String checkboxTyC = "com.davivienda.daviplataapp.lab:id/check_info_micro_seguros";
	private String btnEmpresaBuscadaPrimera = "//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]";

	// RECARGAS
	private String btnMovistar = "(//XCUIElementTypeCollectionView/XCUIElementTypeCell[2]/XCUIElementTypeOther)[4]";
	private String btnRecargar = "//XCUIElementTypeLink[@name=\"Recarga Recargar minutos\"]";
	private String btnPaquetes = "//XCUIElementTypeLink[@name=\"Paquete Paquetes\"]";
	private String btnTodoIncluido = "//XCUIElementTypeStaticText[@name=\"Todo incluido\"]";
	private String btnPrimerPaquete = "(//XCUIElementTypeButton)[3]";
	private String checkCincoMil = "//XCUIElementTypeOther[@name=\"$5.000\"]";
	private String checkSieteMil = "//XCUIElementTypeOther[@name=\"$7.000\"]";
	private String checkDiezMil = "//XCUIElementTypeOther[@name=\"$10.000\"]";
	private String checkVeinteMil = "//XCUIElementTypeOther[@name=\"$20.000\"]";
	private String montoDiferente = "//XCUIElementTypeOther[@name=\"main\"]/XCUIElementTypeTextField";
	private String inputNumero = "//XCUIElementTypeTextField";
	private String txtValorAPagar = "(//XCUIElementTypeStaticText[contains(@name,'$')])[2]";
	private String btnRecargarConfirmarCompra = "//XCUIElementTypeButton[@name='Recargar']";
	private String txtTransaccionExitosa = "//XCUIElementTypeStaticText[@name='Transacción Exitosa']";
	private String btnContinuarInhabilitado = "//XCUIElementTypeButton[@name='Continuar']";
	private String txtSaldoInsuficiente = "//XCUIElementTypeStaticText[@name='Rechazada por fondos insuficientes 07']";
	private String btnVerMasHomeDaviplata = "//XCUIElementTypeOther[@name='btn-my-movements-3'] | (//XCUIElementTypeOther[contains(@label, 'Más botón')])[13]";
	private String btnTodosTiendaVirtual = "//XCUIElementTypeStaticText[@name='Todos']";
	private String txtCorral = "//*[@name='El Corral']";
	private String txtDetalleCompraCorral = "//*[@name='Detalles de compra']";
	private String txtCompraBono = "//*[@name='¡Gracias por su compra!']";
	private String btnFinalizarCompraBono = "//*[@name='Finalizar']";
	private String btnNotificacionBono = "//*[contains(@name,'El Corral')]";
	private String inputCorreoCorral = "//*[@name='Quantum - DaviPlata: Catalogs']//following-sibling::XCUIElementTypeOther/XCUIElementTypeTextField";
	private String btnCompartirBono = "//*[@name='Compartir']";
	private String btnCerrarCompartirBono = "//*[@name='Close']";
	private String btnAnio = "(//XCUIElementTypePickerWheel)[3]";
	private String btnVolver2 = "//XCUIElementTypeButton[@name='Botón atrás' or @name='ic arrow left' or @name='Regresar a pantalla Anterior'] | //XCUIElementTypeButton[contains(@name, 'icon back button')]";
	public static final String MOVILIDAD_HOME_BTN = "//XCUIElementTypeOther[@name='Movilidad botón']";
	public static final String TIENDA_VIRTUAL = "//XCUIElementTypeOther[@label= 'Recargas botón']";
	public static final String BTN_HAMBURGUESA = "//XCUIElementTypeStaticText[@name='Bonos de hamburguesas y malteadas']";
	public static final String BTN_OPCION_BONO_BURGUER = "(//XCUIElementTypeOther)[12]/following-sibling::XCUIElementTypeLink";
	public static final String BTN_CONTINUAR_BONO = "//XCUIElementTypeButton[@name='Continuar']";
	public static final String BTN_COMPRAR = "//XCUIElementTypeButton[@name='Comprar']";
	public static final String BTN_FINALIZAR = "//XCUIElementTypeButton[@name='Finalizar']";


	// TECLADO
	private String btnDone = "//XCUIElementTypeButton[@name='Done']";

	// LISTA DE ARREGLOS PARA GUARDAR DATOS

	List<Integer> listaMontos = new ArrayList<>();
	public static List<String> listaAutorizadores = new ArrayList<>();

	public void validomensajedaviplatainvalido() {

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtfondosinsuficientesmicroseguros)));
		String txtinvalido = driver.findElement(By.xpath(this.txtfondosinsuficientesmicroseguros)).getText();

		boolean validacion = false;
		if (txtinvalido.contains("Fondos insuficientes")) {
			utilidad.tomaEvidencia("Valido mensaje fondos insuficientes");
			validacion = true;
		}
		assertEquals(true, validacion);

	}

	public void btnContinuarmicroseguro() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btncontinuanmicroseguro)));
		driver.findElement(By.xpath(this.btncontinuanmicroseguro)).click();
	}

	public void btnMarketPlace() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnMarketPlace)));
			driver.findElement(By.xpath(this.btnMarketPlace)).click();
		} catch (Exception e) {
			if (!(contador == 10)) {
				utilidades.esperaMiliseg(500);
				btnMarketPlace();
			} else {
				fail("No se pudo encontrar botón 'Tienda Virtual' en sección 'Ver más' de perfil persona, debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void clickBtnMas() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnVerMasHomeDaviplata)));
			driver.findElement(By.xpath(this.btnVerMasHomeDaviplata)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clickBtnMas();
			} else {
				fail("No se pudo encontrar botón más debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void validarBtnInhabilitado() {
		boolean botonHabilitado = driver.findElement(By.xpath(this.btnContinuarInhabilitado)).isEnabled();

		assertFalse(botonHabilitado);
	}

	public void btnNecesitoAyuda() {
		BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(this.btnNecesitoAyuda)).isDisplayed();
		utilidades.tomaEvidencia("Valido que se encuentra el boton Necesito ayuda");

	}
	
	public void volverAtras() {
		base.driver.findElement(By.xpath(this.btnVolver2)).click();
	}

	public void btnVolver() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnVolver)));
			driver.findElement(By.xpath(this.btnVolver)).click();
		} catch (Exception e) {
			if (!(contador == 10)) {
				utilidades.esperaMiliseg(500);
				btnVolver();
			} else {
				fail("No se pudo encontrar botón volver debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void txtValidarVolver(String xpath) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		driver.findElement(By.xpath(xpath));
		utilidades.esperaMiliseg(4000);
		utilidades.tomaEvidencia("Valido pantalla anterior");
	}

	public void btnNecesitoAyuda1() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnNecesitoAyuda1)));
		MobileElement btnNecesitoAyuda = driver.findElement(By.xpath(this.btnNecesitoAyuda1));

		assertTrue(btnNecesitoAyuda.isDisplayed());
		utilidades.tomaEvidencia("Valido que se encuentra el boton Necesito ayuda");

	}

	public void btnVolver2() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnVolver)));
		driver.findElement(By.xpath(this.btnVolver)).click();

	}

	public void btnMinutos() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnMinutos)));
		driver.findElement(By.xpath(this.btnMinutos)).click();

	}

	public void cerrarPopup() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCerrarPopup)));
			driver.findElement(By.xpath(this.btnCerrarPopup)).click();
		} catch (Exception e) {
			System.out.println("no aparecio popup");
		}
	}

	public void volver() {
		for (int i = 0; i < 5; i++) {
			utilidad.esperaMiliseg(2000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnVolver)));
			driver.findElement(By.xpath(this.btnVolver)).click();
		}
	}

	public void validarTransaccionRechazada() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnRappi)));
		String valor = driver.findElement(By.xpath(this.btnRappi)).getText();
		System.out.println(valor);
		boolean validacion = false;
		if (valor.contains("NO EXISTE")) {
			validacion = true;
		} else if (valor.contains("FACTURA")) {
			validacion = true;
		}
		assertTrue(validacion);
	}
	// Flujo Crear negocio

	public void validarNegocio() {

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtRegistro)));
		String valor = driver.findElement(By.xpath(this.txtRegistro)).getText();
		System.out.println(valor);
		boolean validacion = false;
		if (valor.contains("Registro")) {
			validacion = true;
		} else if (valor.contains("Exitoso")) {
			validacion = true;
		}
		assertTrue(validacion);
		utilidades.tomaEvidencia("Valido el registro exitoso");

		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(184, 146)).perform();
		utilidades.esperaMiliseg(10000);

		// MobileElement txtDaviplataNegocio = (MobileElement) wait
		// .until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtDaviplataNegocio)));

		utilidades.tomaEvidencia("Valido la creacion del negocio");

	}

	public void cerrarMensaje() {
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(322, 72)).perform();
	}

	public void ingresarMenuHamburguesa() {
		try {
			contador++;
			driver.findElement(By.xpath(this.btnHamburguesa)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				ingresarMenuHamburguesa();
			} else {
				fail("No se encontró menu hamburguesa debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void ingresarCrearNegocio() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnIrNegocio)));
			driver.findElement(By.xpath(this.btnIrNegocio)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				ingresarCrearNegocio();
			} else {
				fail("No se encontró boton ir a negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void ingresarTerminosCondiciones() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.linkTerminosYCondicionesNegocio)));
			driver.findElement(By.xpath(this.linkTerminosYCondicionesNegocio)).click();
			System.out.println("di click a terminos y condiciones checkbox");
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				ingresarTerminosCondiciones();
			} else {
				fail("No se encontró enlace terminos y condiciones de perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void hacerClicBtnAceptarTerminosCondiciones() {
		try {
			contador++;
			driver.findElement(MobileBy.IosUIAutomation(
					"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Aceptar\").instance(0))"))
					.click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				hacerClicBtnAceptarTerminosCondiciones();
			} else {
				fail("No se encontró botón aceptar terminos y condiciones de perfil negocio debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void hacerClicBtnCrearNegocio() {
		try {
			contador++;
			MobileElement btnCrearNegocio = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCrearNegocio)));
			btnCrearNegocio.click();
			System.out.println("di click a btn crear negocio");
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				hacerClicBtnCrearNegocio();
			} else {
				fail("No se encontró botón crear negocio de perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	// --------------- Llenado del formulario -------------------//
	public void cerrarTeclado() {
		try {
			MobileElement btnContinuar = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuar)));
			btnContinuar.click();
		} catch (Exception e) {
			System.out.println("No se pudo dar click al btn done debido a: " + e.getMessage());
		}
	}

	public void ingresarNombrePerfilNegocio(String nombre) {
		try {
			contador++;
			MobileElement txtNombreNegocio = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtNombreNegocio)));
			txtNombreNegocio.clear();
			txtNombreNegocio.sendKeys(nombre);
			System.out.println("ingrese nombre de negocio");

		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				ingresarNombrePerfilNegocio(nombre);
			} else {
				fail("No se encontró input ingresar nombre de perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void ingresarQueVendeNegocio(String queVende) {
		try {
			contador++;
			MobileElement txtNombreNegocio = driver.findElement(By.xpath(this.txtVendeNegocio));
			txtNombreNegocio.clear();
			txtNombreNegocio.sendKeys(queVende);
			System.out.println("ingrese que vende negocio");
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				ingresarQueVendeNegocio(queVende);
			} else {
				fail("No se encontró input ingresar nombre de perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void clicBtnVenderPerfilNegocio(String queVende) {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnVender)));
			driver.findElement(By.xpath(this.btnVender)).click();
		} catch (Exception e) {
			if (!(contador == 20)) {
				utilidades.esperaMiliseg(2000);
				clicBtnVenderPerfilNegocio(queVende);
			} else {
				fail("No se encontró botón vender de perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void clicDiscoVenderPerfilNegocio(String queVende) {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btn_Discos_Vender)));
			driver.findElement(By.xpath(this.btn_Discos_Vender)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicDiscoVenderPerfilNegocio(queVende);
			} else {
				fail("No se encontró disco vender de perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void ingresarMontoPerfilNegocio(String monto) {
		try {
			System.out.println(monto);
			MobileElement txtMonto = driver.findElement(By.xpath(this.txtMonto));
			txtMonto.clear();
			txtMonto.sendKeys(monto);
		} catch (Exception e) {
			fail("No se encontró input monto de perfil negocio debido a: " + e.getMessage());
		}
	}

	public void ingresarCiudadNegocio(String ciudad) {
		try {
			contador++;
			MobileElement txtCiudad = driver.findElement(By.xpath(this.btnCiudadNegocio));
			txtCiudad.clear();
			txtCiudad.sendKeys(ciudad);
			// txtMonto.click();
			// utilidades.ocultarTeclado();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				ingresarCiudadNegocio(ciudad);
			} else {
				fail("No se encontró input monto de perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void clicBtnCiudadPerfilNegocio() {
		try {
			contador++;
			driver.findElement(By.xpath(this.btnCiudadNegocio)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicBtnCiudadPerfilNegocio();
			} else {
				fail("No se encontró boton ciudad de perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void elegirBtnCiudadPerfilNegocio() {
		utilidades.esperaMiliseg(4000);
		try {
			contador++;
			driver.findElement(By.xpath(this.btnElegirCiudad)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				elegirBtnCiudadPerfilNegocio();
			} else {
				fail("No se encontró disco ciudad de perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void clicTipoViaPerfilNegocio() {
		try {
			contador++;
			driver.findElement(By.xpath(this.btnDireccion1)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicTipoViaPerfilNegocio();
			} else {
				fail("No se encontró botón tipo via de perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void elegirTipoViaPerfilNegocio() {
		try {
			contador++;
			driver.findElement(By.xpath(this.btnCalle)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				elegirTipoViaPerfilNegocio();
			} else {
				fail("No se encontró disco tipo via de perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void ingresarNumeroViaPerfilNegocio() {
		try {
			contador++;
			driver.findElement(By.xpath(this.txtDireccion2)).sendKeys("2");
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				ingresarNumeroViaPerfilNegocio();
			} else {
				fail("No se encontró input de numero via de perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void ingresarPrimerNumeroPlacaPerfilNegocio() {
		try {
			contador++;
			driver.findElement(By.xpath(this.txtDireccion3)).sendKeys("5");
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				ingresarPrimerNumeroPlacaPerfilNegocio();
			} else {
				fail("No se encontró input de primer numero placa de perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void ingresarSegundoNumeroPlacaPerfilNegocio() {
		try {
			contador++;
			driver.findElement(By.xpath(this.txtDireccion4)).sendKeys("2");
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				ingresarSegundoNumeroPlacaPerfilNegocio();
			} else {
				fail("No se encontró input de segundo numero placa de perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void ingresarTipoViviendaPerfilNegocio(String casa) {
		try {
			contador++;
			MobileElement txtCasa = driver.findElement(By.xpath(this.txtCasa));
			txtCasa.clear();
			txtCasa.sendKeys(casa);
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				ingresarTipoViviendaPerfilNegocio(casa);
			} else {
				fail("No se encontró input para ingresar tipo vivienda de perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void ingresarCorreoPerfilNegocio(String correo) {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtCorreo)));
			MobileElement txtCorreo = driver.findElement(By.xpath(this.txtCorreo));
			txtCorreo.clear();
			txtCorreo.sendKeys(correo);
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				ingresarCorreoPerfilNegocio(correo);
			} else {
				fail("No se encontró input para ingresar correo de perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void clicBtnCrearPerfilNegocio() {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnCrearNego)));
			driver.findElement(By.xpath(this.btnCrearNego)).click();
		} catch (Exception e) {
			if (!(contador == 20)) {
				utilidades.esperaMiliseg(2000);
				clicBtnCrearPerfilNegocio();
			} else {
				fail("No se encontró botón crear de perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	// Fin flujo crear negocio

	// ---------------- Inicio flujo, perfil negocio ----------------//
	public void ingresoPerfilNegocio() {
		utilidades.tomaEvidencia("Menu Hamburguesa");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnHamburguesa)));
		driver.findElement(By.xpath(this.btnHamburguesa)).click();
		utilidades.tomaEvidencia("Ir a negocio");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnIrNegocio)));
		driver.findElement(By.xpath(this.btnIrNegocio)).click();
	}

	// ---------- Validar saldo disponible perfil negocio ---------//
	public void validoSaldoPerfilNegocio() {
		utilidades.esperaMiliseg(10000);
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.txtSaldoNegocioDaviplata)));
			MobileElement txtSaldoDisponiblePerfilNegocio = driver.findElement(By.xpath(this.txtSaldoNegocioDaviplata));

			assertTrue(txtSaldoDisponiblePerfilNegocio.isEnabled());
			System.out.println(
					"...Saldo del perfil negocio: " + String.valueOf(txtSaldoDisponiblePerfilNegocio.getText()));
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				validoSaldoPerfilNegocio();
			} else {
				fail("No se encontró label saldo perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	// Flujo donas

	public void btnDonas() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnDonas)));
		driver.findElement(By.xpath(this.btnDonas)).click();
	}

	public void btnRestaurante() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnRestaurante)));
		driver.findElement(By.xpath(this.btnRestaurante)).click();
	}

	// Fin flujo de donas

	// Flujo validar aliados

	public void validarAliados() {

		validarAliadosMetodo(btnRestaurante, "Valido restaurantes");
		validarAliadosMetodo(btnRecargas, "Valido recargas");
		utilidades.hacerScrollHorizontal("(//XCUIElementTypeCollectionView)[3]");
		validarAliadosMetodo(btnVestuario, "Valido vestuario");
		validarAliadosMetodo(btnSalud, "Validar Salud");
		validarAliadosMetodo(btnServiciosHogar, "Validar Servicios Hogar");
		utilidades.hacerScrollHorizontal("(//XCUIElementTypeCollectionView)[3]");
		validarAliadosMetodo(btnCines, "Validar Cines");
		validarAliadosMetodo(btnMercado, "Valido mercado");
		utilidades.hacerScrollHorizontal("(//XCUIElementTypeCollectionView)[3]");
		validarAliadosMetodo(btnSegurosAliados, "Valido Seguros Aliados");
		validarAliadosMetodo(btnEntretenimiento, "Valido Entretenimiento");
		utilidades.hacerScrollHorizontal("(//XCUIElementTypeCollectionView)[3]");
		validarAliadosMetodo(btnContenidoDigital, "Validar contenido digital");
		validarAliadosMetodo(btnJuegos, "Validar Juegos");
		validarAliadosMetodo(btnTransporte, "Validar transporte");
		utilidades.hacerScrollHorizontal("(//XCUIElementTypeCollectionView)[3]");
		validarAliadosMetodo(btnDomicilios, "Validar Domicilios");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnDomicilios)));
		boolean isDisplayed = driver.findElement(By.xpath(this.btnDomicilios)).isDisplayed();
		assertTrue(isDisplayed);

	}

	public void validarAliadosMetodo(String xpath, String Evidencia) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		driver.findElement(By.xpath(xpath)).click();

		utilidades.esperaMiliseg(6000);

		utilidades.tomaEvidencia(Evidencia);
	}

	// Fin Flujo validar aliados

	// Flujo Descuentos

	public void btnDescuentos() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnDescuentos)));
		driver.findElement(By.xpath(this.btnDescuentos)).click();
	}

	public void btnValidarDescuentos() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnValidarDescuentos)));
		boolean isEnabled = driver.findElement(By.xpath(this.btnValidarDescuentos)).isEnabled();
		assertTrue(isEnabled);
	}

	public void btnClickDunki() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnValidarDescuentos)));
		driver.findElement(By.xpath(this.btnValidarDescuentos)).click();
	}

	public void btnDonuts() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnDonuts)));
		driver.findElement(By.xpath(this.btnDonuts)).click();
	}

	public void btnBono() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnBono)));
		driver.findElement(By.xpath(this.btnBono)).click();

	}

	public void ingresarDatoaDonuts() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnDepartamento)));
		driver.findElement(By.xpath(this.btnDepartamento)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCundinamarca)));
		driver.findElement(By.xpath(this.btnCundinamarca)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCiudad)));
		driver.findElement(By.xpath(this.btnCiudad)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnChia)));
		driver.findElement(By.xpath(this.btnChia)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnEstablecimiento)));
		driver.findElement(By.xpath(this.btnEstablecimiento)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnChia)));
		driver.findElement(By.xpath(this.btnChia)).click();

		utilidades.esperaMiliseg(4000);
		utilidades.tomaEvidencia("Ingreso los datos solicitados");

		utilidades.moverPantallaXY(driver, 532, 2057, 496, 1028);

	}

	public void btnContinuarGeneral() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarGeneral)));
			driver.findElement(By.xpath(this.btnContinuarGeneral)).click();
			System.out.println("Di click al boton Continuar");
		} catch (Exception e) {
			if (!(contador == 40)) {
				utilidad.esperaMiliseg(2000);
				btnContinuarGeneral();
			} else {
				fail("No se pudo dar click al boton continuar debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	// Fin Flujo Descuentos

	// Flujo Bono

	public void btnTodos() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnTodos)));
		driver.findElement(By.xpath(this.btnTodos)).click();
	}

	public void btnCorral() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCorral)));
		driver.findElement(By.xpath(this.btnCorral)).click();
	}

	public void btnCrepes() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCrepes)));
		driver.findElement(By.xpath(this.btnCrepes)).click();
	}

	public void btnBono20k() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnBono20k)));
			driver.findElement(By.xpath(this.btnBono20k)).click();
		} catch (Exception e) {
			if (!(contador == 10)) {
				Utilidades.esperar(500);
				btnBono20k();
			} else {
				fail("No se encontró botón de bono en el corral, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clickBtn50K() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnBono50k)));
		driver.findElement(By.xpath(this.btnBono50k)).click();

	}

	public void btnMiniWafle() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnMiniWafle)));
		driver.findElement(By.xpath(this.btnMiniWafle)).click();

	}

	public void btnContinuarBono() {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnContinuarBogo)));
			driver.findElement(By.xpath(this.btnContinuarBogo)).click();
		} catch (Exception e) {
			if (!(contador == 10)) {
				utilidad.esperaMiliseg(500);
				btnContinuarBono();
			} else {
				fail("No se encontró botón 'Continuar' en compra de bono, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void txtEmail() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtEmail)));
			driver.findElement(By.xpath(this.txtEmail)).sendKeys("xxx@gmail.com");
		} catch (Exception e) {
			System.out.println("no se valido el txtEmail");
		}

	}

	public void txtCorreo() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtCorreoInput)));
			driver.findElement(By.xpath(this.txtCorreoInput)).sendKeys("xxx@gmail.com");
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(500);
				btnComprarBono();
			} else {
				fail("No se pudo llenar el correo debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void btnComprarBono() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnComprar)));
			driver.findElement(By.xpath(this.btnComprar)).click();
		} catch (Exception e) {
			if (!(contador == 10)) {
				utilidad.esperaMiliseg(500);
				btnComprarBono();
			} else {
				fail("No se pudo dar click al boton comprar debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void txtValidarCompra() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtValidarCompra)));
			String valor = driver.findElement(By.xpath(this.txtValidarCompra)).getText();
			System.out.println(valor);
			boolean validacion = false;
			if (valor.contains("Gracias por su compra") || valor.contains("Gracias")) {
				validacion = true;
			}
			assertTrue(validacion);
			System.out.println("Valide correctamente la compra");
		} catch (Exception e) {
			if (!(contador == 40)) {
				utilidad.esperaMiliseg(2000);
				txtValidarCompra();
			} else {
				fail("No se pudo validar correctamente la compra debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicBotonDescargaBono() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnDescargarBono)));
			driver.findElement(By.xpath(this.btnDescargarBono)).click();
		} catch (Exception e) {
			if (!(contador == 10)) {
				utilidad.esperaMiliseg(500);
				clicBotonDescargaBono();
			} else {
				fail("No se encontró botón de 'Descarga' en compra de bono, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void btnFinalizar() {

		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnFinalizar)));
			driver.findElement(By.xpath(this.btnFinalizar)).click();
			System.out.println("Finalicé correctamente la compra");
		} catch (Exception e) {
			if (!(contador == 10)) {
				utilidad.esperaMiliseg(500);
				btnFinalizar();
			} else {
				fail("No se pudo finalizar correctamente la compra debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void txtValorBono() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtValorBono)));
		String txValorBono = driver.findElement(By.xpath(this.txtValorBono)).getText();
		String subSaldo = txtValorBono.replaceAll("[^0-9]", "");
		base.ValorPago = new BigDecimal(subSaldo);

	}

	public void btnCampana() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCampana)));
		driver.findElement(By.xpath(this.btnCampana)).click();
	}

	public void btnComprasTiendaVirtual() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnComprasTiendaVirtual)));
		driver.findElement(By.xpath(this.btnComprasTiendaVirtual)).click();
	}

	public void txtValidarCompraCampanaCorral() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtValidarCompraCampana)));
		String valor = driver.findElement(By.xpath(this.txtValidarCompraCampana)).getText();
		System.out.println(valor);
		boolean validacion = false;
		if (valor.contains("El corral") || valor.contains("Compra Quantum")) {
			validacion = true;
			assertTrue(validacion);
		}
	}

	// Fin Flujo Bono
	public void btnSeguros() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSeguros)));
		driver.findElement(By.xpath(this.btnSeguros)).click();
	}

	public void btnSalir() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSalir)));
		driver.findElement(By.xpath(this.btnSalir)).click();

	}

	public void btnAceptarSalir() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptarSalir)));
		driver.findElement(By.xpath(this.btnAceptarSalir)).click();
	}

	public void txtDaviplata() {
		MobileElement txtDaviplata = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.txtDaviplata)));
		String valor = txtDaviplata.getText();
		boolean validacion = false;
		if (valor.contains("Cédula de ciudadanía")) {
			validacion = true;
		} else if (valor.contains("Cedula")) {
			validacion = true;
		}
		assertTrue(validacion);

	}
	// FLujo Mascotas

	public void btnMascota() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnMascota)));
			driver.findElement(By.xpath(this.btnMascota)).click();
		}catch(Exception e) {
			if(!(contador==5)){
				Utilidades.esperaMiliseg(500);
				btnMascota();
			}else {
				fail("No se encontró botón seguro de 'Mascota' en tienda virtual, debido a: "+e.getMessage());
				
			}
		}finally {contador=0;}
		

	}

	public void btnContinuarMascota() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarMascota)));
		driver.findElement(By.xpath(this.btnContinuarMascota)).click();

	}

	public void btnSeleccionarOpcion1() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSeleccionarOpcion1)));
		driver.findElement(By.xpath(this.btnSeleccionarOpcion1)).click();

	}

	public void btnSeleccionarOpcion2() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSeleccionarOpcion2)));
		driver.findElement(By.xpath(this.btnSeleccionarOpcion2)).click();
	}

	public void btnSeleccionarMascota() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSeleccionarMascota)));
		driver.findElement(By.xpath(this.btnSeleccionarMascota)).click();

	}

	public void seleccionarMascota(String raza) {

		if (raza.toLowerCase().equals("perro")) {
			System.out.println("seleccione la opcion de perro");
		} else {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.listaFecha)));
			MobileElement listaDesplegable = driver.findElement(By.xpath(this.listaFecha));

			JavascriptExecutor js = (JavascriptExecutor) base.driver;
			Map<String, Object> params = new HashMap<>();

			params.put("order", "next");
			params.put("offset", 0.15);
			params.put("element", ((RemoteWebElement) listaDesplegable).getId());
			js.executeScript("mobile: selectPickerWheelValue", params);
		}

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarTeclado)));
		driver.findElement(By.xpath(this.btnContinuarTeclado)).click();

	}

	public void btnSeleccionarGato() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSeleccionarGato)));
		driver.findElement(By.xpath(this.btnSeleccionarGato)).click();
	}

	public void btnSeleccionarPerro() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSeleccionarPerro)));
		driver.findElement(By.xpath(this.btnSeleccionarPerro)).click();
	}

	public void btnCheckBoxMascota() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCheckBoxMascota)));
		driver.findElement(By.xpath(this.btnCheckBoxMascota)).click();
	}

	public void btnContinuarMasco() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarMasco)));
		driver.findElement(By.xpath(this.btnContinuarMasco)).click();

	}
	// Fin Flujo Mascotas

	// Flujo Bicicleta

	public void btnBicicleta() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnBicicleta)));
			driver.findElement(By.xpath(this.btnBicicleta)).click();
		}catch(Exception e) {
			if(!(contador==5)) {
				utilidades.esperaMiliseg(500);
				btnBicicleta();
			}else {
				fail("No se encontró boton 'Bicicleta' en el modulo de seguros, debido a: " + e.getMessage());
			}
		}finally {contador=0;}
		
	}

	public void btnFechaBicicleta() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnFechaBicicleta)));
		driver.findElement(By.xpath(this.btnFechaBicicleta)).click();
	}

	public void btnContinuarTeclado() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuar2)));
		driver.findElement(By.xpath(this.btnContinuar2)).click();
	}

	public void btnFecha() {
		for (int i = 0; i < 8; i++) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.listaFecha)));
			MobileElement listaDesplegable = driver.findElement(By.xpath(this.listaFecha));

			JavascriptExecutor js = (JavascriptExecutor) base.driver;
			Map<String, Object> params = new HashMap<>();

			params.put("order", "next");
			params.put("offset", 0.15);
			params.put("element", ((RemoteWebElement) listaDesplegable).getId());
			js.executeScript("mobile: selectPickerWheelValue", params);
		}

	}

	// Fin Flujo Bicicleta

	// Flujo Soat

	public void btnSoat() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSoat)));
		driver.findElement(By.xpath(this.btnSoat)).click();

	}

	public void btnContinuarSoat() {
		/*
		 * MobileElement element = (MobileElement) wait
		 * .until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarSoat
		 * ))); element.click();
		 */
		utilidades.esperar(5);
		utilidades.darUnTap(569, 2060);

	}

	public void btnContinuarSeguros() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarOtrosServicios)));
		driver.findElement(By.xpath(this.btnContinuarOtrosServicios)).click();
	}

	public void txtPlaca(String placa) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtPlaca)));
		driver.findElement(By.xpath(this.txtPlaca)).sendKeys(placa);

	}

	public void checkBoxSi() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.checkBoxSi)));
		driver.findElement(By.xpath(this.checkBoxSi)).click();

	}

	public void btnCotizar() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCotizar)));
		driver.findElement(By.xpath(this.btnCotizar)).click();

	}

	public void btnCiudadSoat() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCiudadSoat)));
		driver.findElement(By.xpath(this.btnCiudadSoat)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnEscogerCiudad)));
		driver.findElement(By.xpath(this.btnEscogerCiudad)).click();

	}

	public void btnSeleccionId() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSeleccione)));
		driver.findElement(By.xpath(this.btnSeleccione)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSelectId)));
		driver.findElement(By.xpath(this.btnSelectId)).click();

	}

	public void inputNombreTitular(String nombre) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputNombre)));
		driver.findElement(By.xpath(this.inputNombre)).sendKeys(nombre);
	}

	public void inputNumId(String numId) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputNumId)));
		driver.findElement(By.xpath(this.inputNumId)).sendKeys(numId);

	}

	public void inputApellidoTitular(String apellido) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputApellido)));
		driver.findElement(By.xpath(this.inputApellido)).sendKeys(apellido);
	}

	public void btnDireccionSoat() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnLapiz)));
		driver.findElement(By.xpath(this.btnLapiz)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSeleccione)));
		driver.findElement(By.xpath(this.btnSeleccione)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCalleSoat)));
		driver.findElement(By.xpath(this.btnCalleSoat)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnPrimero)));
		driver.findElement(By.xpath(this.btnPrimero)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSegundo)));
		driver.findElement(By.xpath(this.btnSegundo)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnTercero)));
		driver.findElement(By.xpath(this.btnTercero)).sendKeys("34");

	}

	public void ingresarDatos(String correo) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCasa)));
		driver.findElement(By.xpath(this.btnCasa)).sendKeys("Casa");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCorreoSoat)));
		driver.findElement(By.xpath(this.btnCorreoSoat)).sendKeys(correo);
	}

	public void IngresoTerminos() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.checkBoxTerminos)));
		driver.findElement(By.xpath(this.checkBoxTerminos)).click();

		utilidades.moverPantallaXY(driver, 558, 2051, 527, 853);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptarTermino)));
		driver.findElement(By.xpath(this.btnAceptarTermino)).click();

	}

	public void ComprarSoat() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnComprarSoat)));
		driver.findElement(By.xpath(this.btnComprarSoat)).click();
	}

	// Fin Flujo Soat

	// FLujo Otros servicios

	public void btnOtrosServicios() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnOtrosServicios)));
		driver.findElement(By.xpath(this.btnOtrosServicios)).click();

	}

	public void btnEmpresaOtrosServicio() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnEmpresaOtrosServicio)));
		driver.findElement(By.xpath(this.btnEmpresaOtrosServicio)).click();

	}

	public void btnEmpresaBuscada() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnEmpresaBuscada)));
		driver.findElement(By.xpath(this.btnEmpresaBuscada)).click();

	}

	public void txtvalor() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtvalor)));
		driver.findElement(By.xpath(this.txtvalor)).sendKeys("2500");
		base.ValorPago = new BigDecimal(2500);

	}

	// Fin Flujo Otros Servicios

	public void btnLuz() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnLuz)));
		driver.findElement(By.xpath(this.btnLuz)).click();

	}

	public void btnAgua() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAgua)));
		driver.findElement(By.xpath(this.btnAgua)).click();
	}

	// Flujo gas
	public void btnGas() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnGas)));
		driver.findElement(By.xpath(this.btnGas)).click();

	}

	public void btnOtroServicios() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnOtroServicios)));
		driver.findElement(By.xpath(this.btnOtroServicios)).click();

	}

	public void btnRecargas() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.btnRecargas)));
		driver.findElement(By.xpath(this.btnRecargas)).click();
	}

	public void btnOperador(String operador) {
		operador = operador.toLowerCase();
		try {
			contador++;
			String path = "(//XCUIElementTypeOther[2]/XCUIElementTypeCollectionView/XCUIElementTypeCell[#])[2]";

			if (operador.equals("movistar")) {
				path = path.replace("#", "2");
				System.out.println("entre a path movistar");
			} else if (operador.equals("virgin")) {
				path = path.replace("#", "1");
			} else if (operador.equals("claro")) {
				path = path.replace("#", "3");
			}

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
			driver.findElement(By.xpath(path)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				btnOperador(operador);
			} else {
				fail("No se pudo encontrar operador debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void txtBuscarEmpresa(String empresa) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnBuscarEmpresa)));
		driver.findElement(By.xpath(this.btnBuscarEmpresa)).sendKeys(empresa);

	}

	public void btnEmpresa() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnClickBuscarEmpresa)));
		driver.findElement(By.xpath(this.btnClickBuscarEmpresa)).click();
	}

	public void txtReferencia(String referencia) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtReferencia)));
		driver.findElement(By.xpath(this.txtReferencia)).sendKeys(referencia);

	}

	public void btnContinuarRef() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarRef)));
		driver.findElement(By.xpath(this.btnContinuarRef)).click();

	}

	public void btnPagarRef() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnPagarRef)));
			driver.findElement(By.xpath(this.btnPagarRef)).click();
		} catch (Exception e) {
			fail("no se pudo dar click a btn pagar ref: " + e.getMessage());
		}

	}

	public void capturoValor() {
		base.ValorPago = new BigDecimal(136740);

	}

	// Fin Flujo gas

	public void btnSeguroVida() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSeguroVida)));
		driver.findElement(By.xpath(this.btnSeguroVida)).click();
	}

	public void btnContinuar() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuar)));
		driver.findElement(By.xpath(this.btnContinuar)).click();

	}

	public void btnSeleccionaroberturaPrimera() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSeleccionaroberturaPrimera)));
		driver.findElement(By.xpath(this.btnSeleccionaroberturaPrimera)).click();
	}

	public void btnSeleccionarCoberturaSegunda() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSeleccionarCoberturaSegunda)));
		driver.findElement(By.xpath(this.btnSeleccionarCoberturaSegunda)).click();

	}

	public void btnFechaNacimiento() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnFechaNacimiento)));
		driver.findElement(By.xpath(this.btnFechaNacimiento)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAno)));
		driver.findElement(By.xpath(this.btnAno)).click();
		utilidades.esperaMiliseg(1000);
		utilidades.moverPantallaXY(driver, 527, 863, 537, 1555);
		utilidades.moverPantallaXY(driver, 527, 863, 537, 1555);
		utilidades.moverPantallaXY(driver, 527, 863, 537, 1555);
		utilidades.moverPantallaXY(driver, 527, 863, 537, 1555);
		utilidades.moverPantallaXY(driver, 527, 863, 537, 1555);
		utilidades.moverPantallaXY(driver, 527, 863, 537, 1555);
		utilidades.esperaMiliseg(1000);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAnoEspecifico)));
		driver.findElement(By.xpath(this.btnAnoEspecifico)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptar)));
		driver.findElement(By.xpath(this.btnAceptar)).click();
	}

	public void btnFechaNacimientoIncorrecto() {
		for (int i = 0; i < 2; i++) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypePickerWheel[3]")));
			MobileElement listaDesplegable = driver.findElement(By.xpath("//XCUIElementTypePickerWheel[3]"));
			JavascriptExecutor js = (JavascriptExecutor) base.driver;
			Map<String, Object> params = new HashMap<>();
			params.put("order", "previous");
			params.put("offset", 0.15);
			params.put("element", ((RemoteWebElement) listaDesplegable).getId());
			js.executeScript("mobile: selectPickerWheelValue", params);
		}
	}

	public void btnGenero(String genero) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnGenero)));
		driver.findElement(By.xpath(this.btnGenero)).click();
		if (genero.equalsIgnoreCase("M")) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnGeneroMasculino)));
			driver.findElement(By.xpath(this.btnGeneroMasculino)).click();
		} else {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnGeneroFemenino)));
			driver.findElement(By.xpath(this.btnGeneroFemenino)).click();
		}

	}

	public void btnCheckBox() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCheckBox)));
		driver.findElement(By.xpath(this.btnCheckBox)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarCheck)));
		driver.findElement(By.xpath(this.btnContinuarCheck)).click();

		utilidades.esperaMiliseg(10000);
	}

	public void btnComprar() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnComprar)));
		driver.findElement(By.xpath(this.btnComprar)).click();

	}

	// Validaciones
	public List<MobileElement> capturaResultadoTransaccion() {
		utilidades.esperaMiliseg(6000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.resultadosTransaccion)));
		driver.findElement(By.xpath(this.resultadosTransaccion));
		List<MobileElement> listaElementos = base.driver.findElements(By.xpath(resultadosTransaccion));
		return listaElementos;

	}

	public void darBtnFinalizar() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnFinalizar)));
		driver.findElement(By.xpath(this.btnFinalizar)).click();
	}

	public void verificoResultadoTransaccion(List<MobileElement> listaElementos) {
		String textoValidacion = "";
		for (MobileElement mobileElement : listaElementos) {
			if (mobileElement.getText().contains("Transacción exitosa")) {
				textoValidacion = "Transaccion exitosa";
				break;
			} else
				textoValidacion = "No se encuentra 'Transaccion exitosa'";
		}
		assertEquals("Transaccion exitosa", textoValidacion);

	}

	public void capturoDatos() {

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtNumeroPoliza)));
		String txtNumeroPoliza = driver.findElement(By.xpath(this.txtNumeroPoliza)).getText().replaceAll("[^0-9]", "");
		base.numeroPoliza = txtNumeroPoliza;
		base.cuentaONumero = txtNumeroPoliza;

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtValorPoliza)));
		String txtValorPoliza = driver.findElement(By.xpath(this.txtValorPoliza)).getText();
		System.out.println("valor poliza: " + txtValorPoliza);

		System.out.println("valor poliza numeros: " + txtValorPoliza.replaceAll("[^0-9]", ""));
		base.ValorPoliza = txtValorPoliza.replaceAll("[^0-9]", "");
//		base.monto = txtValorPoliza.getText().replace(" ", "").replace("$", "").replace(".", "").replace(",", ".");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtNumeroAutorizacion)));
		String txtNumeroAutorizacion = driver.findElement(By.xpath(this.txtNumeroAutorizacion)).getText()
				.replaceAll("[^0-9]", "");
		base.Autorizador = txtNumeroAutorizacion;
		base.idTransaccion = txtNumeroAutorizacion;

		String txtFechaHoraApp = driver.findElement(By.xpath(this.txtFechaHora)).getText();
		base.fechaHora = txtFechaHoraApp;
		System.out.println("Hora app:" + base.fechaHora);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnFinalizar)));
		driver.findElement(By.xpath(this.btnFinalizar)).click();
	}

	public void capturoDatosValorPagar() {

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtValorPoliza)));
		String txtValorPoliza = driver.findElement(By.xpath(this.txtValorPoliza)).getText();
		System.out.println("valor poliza: " + txtValorPoliza);

		System.out.println("valor poliza numeros: " + txtValorPoliza.replaceAll("[^0-9]", ""));
		base.ValorPoliza = txtValorPoliza.replaceAll("[^0-9]", "");

		Utilidades.tomaEvidencia("valor a pagar: " + txtValorPoliza.replaceAll("[^0-9]", ""));

	}

	public void capturoDatosValorPagarBicicleta() {

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtValorPolizaBicicleta)));
		String txtValorPoliza = driver.findElement(By.xpath(this.txtValorPolizaBicicleta)).getText();
		System.out.println("valor poliza: " + txtValorPoliza);

		System.out.println("valor poliza numeros: " + txtValorPoliza.replaceAll("[^0-9]", ""));
		base.ValorPoliza = txtValorPoliza.replaceAll("[^0-9]", "");

		Utilidades.tomaEvidencia("valor a pagar: " + txtValorPoliza.replaceAll("[^0-9]", ""));

	}

	public void darClickBtnFinalizarCompra() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnFinalizar)));
			driver.findElement(By.xpath(this.btnFinalizar)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				darClickBtnFinalizarCompra();
			} else {
				fail("No se pudo dar click a btn finalizar compra, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void capturoDatosPagos() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnFinalizar)));
		driver.findElement(By.xpath(this.btnFinalizar)).click();
	}

	public void txtAutorizador() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtAutorizador)));
			String auto = driver.findElement(By.xpath(this.txtAutorizador)).getText();
			if (auto.length() == 6) {
				base.Autorizador = auto;
			} else {
				quitarCerosIzquierda(auto);
			}

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnFinalizar)));
			driver.findElement(By.xpath(this.btnFinalizar)).click();

		} catch (Exception e) {

		}

	}

	public void quitarCerosIzquierda(String numero) {
		long p = Long.parseLong(numero);
		base.Autorizador = Long.toString(p);
	}

	public void darClickEnActualizarSaldo() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnActualizarSaldo)));
			driver.findElement(By.xpath(this.btnActualizarSaldo)).click();
		} catch (Exception e) {
			System.out.println("No encontre la opcion 'Actualizar Cuánto tengo'");
		}
	}

	public void capturarSaldoFinal() {
		String subSaldo;
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.labelSaldo)));
		String labelSaldo = driver.findElement(By.xpath(this.labelSaldo)).getText().replaceAll("[^0-9]", "");

		subSaldo = String.valueOf(labelSaldo);
		int longitud = subSaldo.length();
		int numero = longitud - 2;
		subSaldo = subSaldo.substring(0, numero);
		base.saldoFinal = new BigDecimal(subSaldo);
		System.out.println("saldo Final: " + base.saldoFinal);
		base.saldoFin = subSaldo;
	}

	public void validarSaldos() {
		System.out.println("Saldo inicial " + base.saldo);
		System.out.println("Valor transaccion" + base.ValorPoliza);
		System.out.println("Saldo final" + base.saldoFinal);
		BigDecimal Poliza = new BigDecimal(base.ValorPoliza);
		BigDecimal resultado = base.saldo.subtract(Poliza);
		assertThat(base.saldoFinal, equalTo(resultado));
	}

	public void validarSaldosRecarga() {
		System.out.println("Saldo inicial " + base.saldo);
		System.out.println("Valor transaccion" + base.montoTransado);
		System.out.println("Saldo final" + base.saldoFinal);
		BigDecimal monto = base.montoTransado;
		BigDecimal resultado = base.saldoFinal.add(monto);
		assertEquals(base.saldo, resultado);
	}

	public void validarSaldosPagos() {
		System.out.println("Saldo inicial " + base.saldoSinDecimal);
		System.out.println("Valor transaccion" + base.ValorPago);
		System.out.println("Saldo final" + base.saldoFinal);
		BigDecimal resultado = base.saldoFinal.add(base.ValorPago);
		// assertEquals(base.saldoSinDecimal, resultado);
	}

	public void validarSaldosTransacciones() {
		System.out.println("Saldos recolectados: " + this.listaMontos);
		System.out.println("autorizadores recolectados: " + this.listaAutorizadores);
		System.out.println("Saldo inicial: " + base.saldoSinDecimal);
		System.out.println("Saldo final: " + base.saldoFinal);

		Integer montoAcumuladoTransacciones = 0;

		for (Integer monto : this.listaMontos) {
			montoAcumuladoTransacciones += monto;
		}

		System.out.println("monto acumulado: " + montoAcumuladoTransacciones);

		BigDecimal resultado = base.saldoFinal.add(new BigDecimal(montoAcumuladoTransacciones));
		assertEquals(base.saldoSinDecimal, resultado);
	}

	public void llenarAutorizadoresTest() {
		this.listaAutorizadores.add("142330");
		this.listaAutorizadores.add("954453");
	}

	public void validarMensaje() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.txtNotifyRappi)));
		String valor = driver.findElement(By.xpath(this.txtNotifyRappi)).getText();
		boolean validacion = false;
		if (valor.contains("rango de edad")) {
			validacion = true;
		} else if (valor.contains("RECHAZADA POR FONDOS INSUFICIENTES")) {
			validacion = true;
		}
		assertTrue(validacion);

	}

	public void validarMensajeReferenciaErrada() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtRappi)));
		String valor = driver.findElement(By.xpath(this.txtRappi)).getText();
		System.out.println(valor);
		boolean validacion = false;
		if (valor.contains("REFERENCIA PARA PAGO NO EXISTE")) {
			validacion = true;
		} else if (valor.contains("NO EXISTE")) {
			validacion = true;
		}
		assertTrue(validacion);

	}

	public void validarMensajePlacaValida() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnPlacaInvalida)));
		String valor = driver.findElement(By.xpath(this.btnPlacaInvalida)).getText();
		System.out.println(valor);
		boolean validacion = false;
		if (valor.contains("placa válida")) {
			validacion = true;
		} else if (valor.contains("Debe ingresar una")) {
			validacion = true;
		}
		assertTrue(validacion);

	}

	public void esperarDesaparezcalogoCarga() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.logoCargaPagina)));
			driver.findElement(By.xpath(this.logoCargaPagina));
			esperarDesaparezcalogoCarga();
		} catch (Exception e) {
			System.out.println("Se desaparecio log de carga");
		}
	}

	public void darClickBtnScrollCategorias() {
		try {
			contador++;
			utilidad.esperaMiliseg(1000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnScroll)));
			driver.findElement(By.xpath(this.btnScroll)).click();
			System.out.println("Di click al boton Scroll Categorias");
		} catch (Exception e) {
			if (!(contador == 40)) {
				utilidad.esperaMiliseg(2000);
				darClickBtnScrollCategorias();
			} else {
				fail("No se pudo dar click al boton Scroll Categorias debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void validarUltimoElementoCategorias() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnPruebasTecnologia)));
			String txtPruebas = driver.findElement(By.xpath(this.btnPruebasTecnologia)).getText();

			assertThat(txtPruebas, containsString("Adquiera los mejores productos"));
			utilidad.esperaMiliseg(1000);
			System.out.println("Valide correctamente el ultimo elemento de la barra de navegacion de Categorias");
		} catch (Exception e) {
			if (!(contador == 20)) {
				utilidad.esperaMiliseg(2000);
				validarUltimoElementoCategorias();
			} else {
				fail("No pude Validar correctamente el ultimo elemento de la barra de navegacion de Categorias debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void validarPrimerElementoCategorias() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtTodos)));
			String txtTodos = driver.findElement(By.xpath(this.txtTodos)).getText();

			assertThat(txtTodos, containsString("Todos"));
			utilidad.esperaMiliseg(1000);
			System.out.println("Valide correctamente el primer elemento de la barra de navegacion de Categorias");
		} catch (Exception e) {
			if (!(contador == 20)) {
				utilidad.esperaMiliseg(2000);
				validarPrimerElementoCategorias();
			} else {
				fail("No pude Validar correctamente el primer elemento de la barra de navegacion de Categorias debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void deslizarMenu() {
		for (int i = 0; i < 3; i++) {
			System.out.println("Deslize el menu");
			(new TouchAction(driver)).longPress(PointOption.point(17, 596)).moveTo(PointOption.point(315, 596))
					.release().perform();
		}
	}

	public void darClickBtn(String categoria) {
		try {
			contador++;
			String xpath = "//*[contains(@text,'" + categoria + "')]";
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
			driver.findElement(By.xpath(xpath)).click();
			System.out.println("Di click al btn " + categoria + " correctamente");
		} catch (Exception e) {
			if (!(contador == 20)) {
				utilidad.esperaMiliseg(2000);
				darClickBtn(categoria);
			} else {
				fail("No pude ingresar a " + categoria + " debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void darClickBtnSevenSeven() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnTiendaNumero4)));
			driver.findElement(By.xpath(this.btnTiendaNumero4)).click();
			utilidad.esperaMiliseg(1000);
			System.out.println("Di click al boton Seven seven");
		} catch (Exception e) {
			if (!(contador == 40)) {
				utilidad.esperaMiliseg(2000);
				darClickBtnSevenSeven();
			} else {
				fail("No se pudo dar click al boton Seven Seven debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void irAVestuario() {
		try {
			contador++;
			(new TouchAction(driver)).longPress(PointOption.point(267, 530)).moveTo(PointOption.point(77, 530))
					.release().perform();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				irAVestuario();
			} else {
				fail("No se pudo dar click al boton Seven Seven debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void irACines() {
		try {
			contador++;
			for (int i = 0; i < 2; i++) {
				(new TouchAction(driver)).longPress(PointOption.point(267, 530)).moveTo(PointOption.point(77, 530))
						.release().perform();
			}
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				irAVestuario();
			} else {
				fail("No se pudo dar click al boton Seven Seven debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void darClickBtnCineColombia() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnTiendaNumero4)));
			driver.findElement(By.xpath(this.btnTiendaNumero4)).click();
			utilidad.esperaMiliseg(1000);
			System.out.println("Di click al boton Cine Colombia");
		} catch (Exception e) {
			if (!(contador == 40)) {
				utilidad.esperaMiliseg(2000);
				darClickBtnCineColombia();
			} else {
				fail("No se pudo dar click al boton CineColombia debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void darClickBtnCineCinemark() {
		try {
			contador++;
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.btnCinemark)));
			driver.findElement(By.xpath(this.btnCinemark)).click();
			System.out.println("Di click al boton Cine Cinemark");
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				darClickBtnCineCinemark();
			} else {
				fail("No se pudo dar click al boton cinemark debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void darClickEntrada2D() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnEntrada2d)));
			driver.findElement(By.xpath(this.btnEntrada2d)).click();
			System.out.println("Di click al boton 2d");
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				darClickEntrada2D();
			} else {
				fail("No se pudo dar click al boton 2d debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void clickBtnVestuario() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnVestuario)));
			driver.findElement(By.xpath(this.btnVestuario)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				clickBtnVestuario();
			} else {
				fail("No se pudo dar click al boton CineColombia debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void clickBtnCines() {
		try {
			contador++;
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.btnCines)));
			driver.findElement(By.xpath(this.btnCines)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				clickBtnCines();
			} else {
				fail("No se pudo dar click al boton cines debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void darClickBtnBono50() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.bono)));
			driver.findElement(By.xpath(this.bono)).click();
			utilidad.esperaMiliseg(1000);
			System.out.println("Di click al bono de 50.000");
		} catch (Exception e) {
			if (!(contador == 40)) {
				utilidad.esperaMiliseg(2000);
				darClickBtnBono50();
			} else {
				fail("No se pudo dar click al bono de 50.000 debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void validarPrimerElemento() {
		try {
			contador++;
			String xpath1 = "(//*[contains(@text, 'Bono')])[1]";
			String xpath2 = "(//*[contains(@text, 'Bono')])[2]";

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath1)));
			String bono1 = driver.findElement(By.xpath(xpath1)).getText();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath2)));
			String bono2 = driver.findElement(By.xpath(xpath2)).getText();

			if (bono.contains("Bono")) {
				System.out.println("Encontré el bono");
			} else if (bono2.contains("Bono")) {
				System.out.println("Encontré el bono");
			}
			utilidad.esperaMiliseg(1000);

		} catch (Exception e) {
			if (!(contador == 40)) {
				utilidad.esperaMiliseg(2000);
				validarPrimerElemento();
			} else {
				fail("No se pudo dar click al bono de 50.000 debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public int returnValorBono() {
		int valorBonoFinal = 0;
		try {
			contador++;
			MobileElement valorBono = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.valorBono)));
			String valorTotalBono = valorBono.getText().replace(" ", "").replace("$", "").replace(".", "").replace(",",
					"");
			int tamañoValor = (valorTotalBono.length() - 2);
			valorTotalBono = valorTotalBono.substring(0, tamañoValor);
			valorBonoFinal = Integer.parseInt(valorTotalBono);
			System.out.println(valorBonoFinal);

			utilidad.esperaMiliseg(1000);
		} catch (Exception e) {
			if (!(contador == 40)) {
				utilidad.esperaMiliseg(2000);
				darClickBtnBono50();
			} else {
				fail("No se pudo dar click al bono de 50.000 debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

		return valorBonoFinal;
	}

	public void validarBtnDescarga() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnDescargar)));
			MobileElement btnDescargar = driver.findElement(By.xpath(this.btnDescargar));

			assertThat(btnDescargar.getText(), containsString("Descargar"));
			System.out.println("Encontré el boton Descargar");
			btnDescargar.click();
			utilidad.esperaMiliseg(1000);

		} catch (Exception e) {
			if (!(contador == 40)) {
				utilidad.esperaMiliseg(2000);
				validarBtnDescarga();
			} else {
				fail("No se pudo dar click al boton Descargar debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void validarBtnCompartir() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCompartir)));
			MobileElement btnCompartir = driver.findElement(By.xpath(this.btnCompartir));

			assertThat(btnCompartir.getText(), containsString("Compartir"));
			System.out.println("Encontré el boton Compartir");
			btnCompartir.click();
			utilidad.esperaMiliseg(1000);

		} catch (Exception e) {
			if (!(contador == 40)) {
				utilidad.esperaMiliseg(2000);
				validarBtnCompartir();
			} else {
				fail("No se pudo dar click al boton Compartir debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void validarPopUpTerminosCondicionesMarketplace() {
		try {
			contador++;
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.popUpTerminosCondiciones)));
			String txtTerminos = driver.findElement(By.xpath(this.popUpTerminosCondiciones)).getText();

			assertThat(txtTerminos, containsString("Aquí podrá comprar productos"));
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				validarPopUpTerminosCondicionesMarketplace();
			} else {
				fail("No se encontró popUp términos y condiciones de tienda virtual, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void ingresarAlBotonOpcionesHome() {
		try {
			contador++;
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.btnOpcionesHome)));
			driver.findElement(By.xpath(this.btnOpcionesHome)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				ingresarAlBotonOpcionesHome();
			} else {
				fail("No se encontró boton 'Más' del home perfil persona , debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void ingresarOpcionPagarTiendaVirtual() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnPagos)));
			driver.findElement(By.xpath(this.btnPagos)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				ingresarOpcionPagarTiendaVirtual();
			} else {
				fail("No se encontró botón 'Pagos' de tienda virtual, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validarPestañaPagosServicios() {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnPagosServicios)));
			boolean pagoServiciosHabilitado = driver.findElement(By.xpath(this.btnPagosServicios)).isDisplayed();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnServicioAgua)));
			boolean pagoAguaHabilitado = driver.findElement(By.xpath(this.btnServicioAgua)).isDisplayed();

			assertThat(pagoServiciosHabilitado, is(true));
			assertThat(pagoAguaHabilitado, is(true));
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				validarPestañaPagosServicios();
			} else {
				fail("No se encontró botón 'Pagos' de tienda virtual, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void ingresarOpcionRecargasTiendaVirtual() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnRecargasTiendaVirtual)));
			driver.findElement(By.xpath(this.btnRecargasTiendaVirtual)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				ingresarOpcionRecargasTiendaVirtual();
			} else {
				fail("No se encontró botón 'Recargas' de tienda virtual, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validarPestañaRecargas() {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnRecargasTienda)));
			boolean btnRecargas = driver.findElement(By.xpath(this.btnRecargasTienda)).isDisplayed();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnMovistar)));
			boolean btnMovistar = driver.findElement(By.xpath(this.btnMovistar)).isDisplayed();

			assertThat(btnRecargas, is(true));
			assertThat(btnMovistar, is(true));
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				validarPestañaRecargas();
			} else {
				fail("No se encontró botón 'Recargas' o 'Recarga de minutos movistar' de tienda virtual, debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void ingresarARestaurantes() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnRestaurantes)));
			driver.findElement(By.xpath(this.btnRestaurantes)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				ingresarARestaurantes();
			} else {
				fail("No se encontró botón 'Restaurantes' de tienda virtual, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void ingresarBonoHamburguesas() {
		try {
			contador++;
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.btnBonoHamburguesas)));
			driver.findElement(By.xpath(this.btnBonoHamburguesas)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				ingresarBonoHamburguesas();
			} else {
				fail("No se encontró botón 'Bono de hamburguesas' de tienda virtual, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void aceptarTerminosCondicionesTiendaVirtual() {
		try {
			contador++;
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.btnTerminosCondicionesTiendaVirtual)));
			driver.findElement(By.xpath(this.btnTerminosCondicionesTiendaVirtual)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				aceptarTerminosCondicionesTiendaVirtual();
			} else {
				fail("No se encontró botón 'Aceptar' de terminos y condiciones en tienda virtual, debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void cerrarVentanaQueQuiereHacerConSuPlata() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCerrar)));
			driver.findElement(By.xpath(this.btnCerrar)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				cerrarVentanaQueQuiereHacerConSuPlata();
			} else {
				fail("No se pudo encontrar botón cerrar de '¿Qué quiere hacer con su plata?' en home daviplata, debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void abrirNotificacionTiendaVirtual() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.listaNotificaciones)));
			driver.findElement(By.xpath(this.listaNotificaciones)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				abrirNotificacionTiendaVirtual();
			} else {
				fail("No se pudo encontrar notificaciones de tienda virtual en campana de notificaciones, debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validarBono() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.bonoCompra)));
			boolean isDisplayed = driver.findElement(By.xpath(this.bonoCompra)).isDisplayed();
			assertThat(isDisplayed, is(true));
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				validarBono();
			} else {
				fail("No se pudo encontrar bono de compras de tienda virtual en campana de notificaciones, debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicBtnEditarCorreoBono() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnEditarBono)));
			driver.findElement(By.xpath(this.btnEditarBono)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicBtnEditarCorreoBono();
			} else {
				fail("No se pudo encontrar botón de editar correo en los bonos de tienda virtual, debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicInputCorreoBono() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputCorreoBono)));
			MobileElement element = driver.findElement(By.xpath(this.inputCorreoBono));
			element.click();
			element.clear();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicInputCorreoBono();
			} else {
				fail("No se pudo encontrar input correo en los bonos de tienda virtual, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void txtValidarCompraCampanaMcDonals() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtValidarCompraCampana)));
			String valor = driver.findElement(By.xpath(this.txtValidarCompraCampana)).getText();
			System.out.println(valor);
			boolean validacion = false;
			if (valor.contains("McDonald's") || valor.contains("Compra Quantum")) {
				validacion = true;
				assertTrue(validacion);
			}
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				txtValidarCompraCampanaMcDonals();
			} else {
				fail("No se encontró texto del nombre de bono en campana de notificaciones, debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validarFranjaAliadosPosicionEnLaMitad() {
		try {
			contador++;
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.franjaAliados)));
			Point ubicacion = driver.findElement(By.xpath(this.franjaAliados)).getLocation();
			System.out.println(
					"La franja de aliados se encuentra en la mitad de la pantalla, con la posicion: " + ubicacion);
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				validarFranjaAliadosPosicionEnLaMitad();
			} else {
				fail("No se pudo encontrar franja 'Nuestros aliados' de tienda virtual, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void tapFranjaNuestroAliados() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.contenedorAliados)));
			driver.findElement(By.xpath(this.contenedorAliados)).click();
		} catch (Exception e) {
			if (!(contador == 10)) {
				utilidades.esperaMiliseg(2000);
				tapFranjaNuestroAliados();
			} else {
				fail("No se pudo encontrar franja 'Nuestros aliados' de tienda virtual, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validarPantallaCategorias() {
		try {
			contador++;
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.contenedorAliados)));
			boolean isDisplayed = driver.findElement(By.xpath(this.contenedorAliados)).isDisplayed();

			assertThat(isDisplayed, is(true));
		} catch (Exception e) {
			if (!(contador == 10)) {
				utilidades.esperaMiliseg(2000);
				validarPantallaCategorias();
			} else {
				fail("No se pudo encontrar franja 'Categorias' de nuestros aliados en tienda virtual, debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validarMensajeCuentaConSeguroVida() {
		try {
			contador++;
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.txtNotifyRappi)));
			String txtMensaje = driver.findElement(By.xpath(this.txtNotifyRappi)).getText();
			assertThat(txtMensaje, containsString("ya cuenta con seguro vigente"));
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				validarMensajeCuentaConSeguroVida();
			} else {
				fail("No se encontró mensaje de que ya cuenta con seguro de vida en microseguro, debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validarTyCMicroseguros() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCheckBox)));
			MobileElement check = driver.findElement(By.xpath(this.btnCheckBox));
			check.click();
			assertThat(check.isEnabled(), is(true));
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				validarTyCMicroseguros();
			} else {
				fail("No se encontró terminos y condiciones en microseguro, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validarPopUpTerminosCondicionesTiendaVirtual() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnPopMarket)));
			driver.findElement(By.xpath(this.btnPopMarket)).click();
		} catch (Exception e) {
			System.out.println(
					"No se encontró popUp términos y condiciones de tienda virtual, debido a: " + e.getMessage());
		}

	}

	public void validarNoAparezcaPopUpTerminosCondicionesMarketplace() {
		try {
			contador++;
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.popUpTerminosCondicionesNoAparece)));
			String popumMarketplace = driver.findElement(By.xpath(this.popUpTerminosCondicionesNoAparece)).getText();
			assertThat(popumMarketplace, containsString("Pago de Servicios"));
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				validarNoAparezcaPopUpTerminosCondicionesMarketplace();
			} else {
				fail("No aparece popUp términos y condiciones de tienda virtual, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicBtnDesplegableFechaNacimiento() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnFechaNacimiento)));
			driver.findElement(By.xpath(this.btnFechaNacimiento)).click();

		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicBtnDesplegableFechaNacimiento();
			} else {
				fail("No se encontró boton desplegable de 'Fecha de nacimiento' en microseguro, debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void abrirDiscosFechaNacimiento() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAno)));
			driver.findElement(By.xpath(this.btnAno)).click();
			utilidades.esperaMiliseg(1000);
			utilidades.moverPantalla(527, 863, 537, 1555);
			utilidades.moverPantalla(527, 863, 537, 1555);
			utilidades.moverPantalla(527, 863, 537, 1555);
//			utilidades.moverPantalla(527, 863, 537, 1555);
//			utilidades.moverPantalla(527, 863, 537, 1555);
//			utilidades.moverPantalla(527, 863, 537, 1555);
			utilidades.esperaMiliseg(1000);
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				abrirDiscosFechaNacimiento();
			} else {
				fail("No se encontró boton de año en microseguro, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void escogerFechaNacimiento() {
		try {
			contador++;
			for (int i = 0; i < 20; i++) {
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypePickerWheel[3]")));
				MobileElement listaDesplegable = driver.findElement(By.xpath("//XCUIElementTypePickerWheel[3]"));
				JavascriptExecutor js = (JavascriptExecutor) base.driver;
				Map<String, Object> params = new HashMap<>();
				params.put("order", "previous");
				params.put("offset", 0.15);
				params.put("element", ((RemoteWebElement) listaDesplegable).getId());
				js.executeScript("mobile: selectPickerWheelValue", params);
			}
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				escogerFechaNacimiento();
			} else {
				fail("No se encontró fecha de nacimiento del desplegable en micro seguros, debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}
	
	public void ingresarAño() {
		String anio = "1994";
		System.out.println("ingresando año");
		try {
			utilidad.esperaMiliseg(4000);
		    contador++;
			driver.findElement(By.xpath(this.btnAnio)).click();
			
			utilidad.esperaMiliseg(1000);
			driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='"+ anio +"']")).click();
		}catch(Exception e) {
		    if(!(contador==5)) {
		    	utilidad.esperaMiliseg(2000);
		    	ingresarAño();
		    }else {
		    	fail("No se encontró btn 'Año' en registro, debido a: " + e.getMessage());
		    }
		}finally {contador=0;}
		
	}

	public void clicBtnAceptarFechaNacimiento() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptar2)));
			driver.findElement(By.xpath(this.btnAceptar2)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicBtnAceptarFechaNacimiento();
			} else {
				fail("No se encontró botón 'Aceptar' fecha de nacimiento en microseguros , debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicbtnGenero() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnGenero)));
			driver.findElement(By.xpath(this.btnGenero)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicbtnGenero();
			} else {
				fail("No se encontró botón de genero en microseguros , debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void escogerGenero(String genero) {
		try {
			contador++;
			if (genero.equalsIgnoreCase("M")) {
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.listaGenero)));
				MobileElement listaDesplegable = driver.findElement(By.xpath(this.listaGenero));

				JavascriptExecutor js = (JavascriptExecutor) base.driver;
				Map<String, Object> params = new HashMap<>();

				params.put("order", "next");
				params.put("offset", 0.15);
				params.put("element", ((RemoteWebElement) listaDesplegable).getId());
				js.executeScript("mobile: selectPickerWheelValue", params);
			} else {
				System.out.println("escogi genero femenino");
			}
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarTeclado)));
			driver.findElement(By.xpath(this.btnContinuarTeclado)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				escogerGenero(genero);
			} else {
				fail("No se encontró lista desplegable de genero en microseguro, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void ingresarBtnRecargar() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnRecargar)));
			driver.findElement(By.xpath(this.btnRecargar)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				ingresarBtnRecargar();
			} else {
				fail("No se pudo dar click al boton recargar debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void validarMensajeTransaccionFallida() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtSaldoInsuficiente)));
			String txtMensaje = driver.findElement(By.xpath(this.txtSaldoInsuficiente)).getText();

			assertThat(txtMensaje.toLowerCase(), containsString("rechazada por fondos insuficientes"));
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				validarMensajeTransaccionFallida();
			} else {
				fail("No se pudo dar click al boton recargar debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void ingresarBtnPaquetes() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnPaquetes)));
			driver.findElement(By.xpath(this.btnPaquetes)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				ingresarBtnPaquetes();
			} else {
				fail("No se pudo dar click al boton recargar debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void clickOperadorMovistar() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnMovistar)));
			driver.findElement(By.xpath(this.btnMovistar)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				clickOperadorMovistar();
			} else {
				fail("No se pudo dar click al boton recargar debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void seleccionarTodoIncluido() {
		try {
			contador++;
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.btnTodoIncluido)));
			driver.findElement(By.xpath(this.btnTodoIncluido)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				seleccionarTodoIncluido();
			} else {
				fail("No se pudo dar click al boton todo incluido debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void seleccionarPaqueteAComprar() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnPrimerPaquete)));
			driver.findElement(By.xpath(this.btnPrimerPaquete)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				seleccionarPaqueteAComprar();
			} else {
				fail("No se pudo dar click al boton todo incluido debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void seleccionoPaqueteVoz() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnPrimerPaquete)));
			driver.findElement(By.xpath(this.btnPrimerPaquete)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				seleccionoPaqueteVoz();
			} else {
				fail("No se pudo dar click al boton todo incluido debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void clickBtnContinuar() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuar3)));
			driver.findElement(By.xpath(this.btnContinuar3)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				clickBtnContinuar();
			} else {
				fail("No se pudo dar click al boton continuar debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void clickBtnRecargar() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnRecargarConfirmarCompra)));
			driver.findElement(By.xpath(this.btnRecargarConfirmarCompra)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				clickBtnRecargar();
			} else {
				fail("No se pudo dar click al boton recargar debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void clickbtnFinalizar() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnFinalizar)));
			driver.findElement(By.xpath(this.btnFinalizar)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				clickbtnFinalizar();
			} else {
				fail("No se pudo dar click al boton finalizar debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void clickBtnAceptar() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptar)));
			driver.findElement(By.xpath(this.btnAceptar)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				clickBtnAceptar();
			} else {
				fail("No se pudo dar click al boton aceptar debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void validarTransaccionExitosa() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtTransaccionExitosa)));
			String txtTransaccion = driver.findElement(By.xpath(this.txtTransaccionExitosa)).getText();

			assertThat(txtTransaccion, containsString("Exitosa"));
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				validarTransaccionExitosa();
			} else {
				fail("No se pudo obtener la transaccion exitosa debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void guardarNumeroAutorizador() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtAutorizador)));
			String auto = driver.findElement(By.xpath(this.txtAutorizador)).getText();
			auto = auto.replaceAll("[^0-9]", "");
			if (auto.length() >= 6) {
				base.Autorizador = auto;
				base.idTransaccion = base.Autorizador;
				System.out.println("Autorizador " + base.Autorizador);
			} else {
				agregarCeros(auto);
			}
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				guardarNumeroAutorizador();
			} else {
				fail("No se pudo obtener la transaccion exitosa debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void agregarCeros(String numero) {
		String f = "0" + numero;
		base.Autorizador = f;
	}

	public void guardarNumeroAutorizadorArreglo() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtAutorizador)));
			String auto = driver.findElement(By.xpath(this.txtAutorizador)).getText();
			auto = auto.replaceAll("[^0-9]", "");
			if (auto.length() == 6) {
				this.listaAutorizadores.add(auto);
				System.out.println("Autorizador " + auto);
			} else {
				agregarCerosArreglo(auto);
			}
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				guardarNumeroAutorizador();
			} else {
				fail("No se pudo obtener la transaccion exitosa debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void agregarCerosArreglo(String numero) {
		String f = "0" + "numero";
		this.listaAutorizadores.add(f);
	}

	public void obtenerMontoAPagar() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtValorAPagar)));
			String txtvalor = driver.findElement(By.xpath(this.txtValorAPagar)).getText().replaceAll("[^0-9]", "");

			System.out.println("el valor a pagar es: " + txtvalor);

			base.montoTransado = new BigDecimal(txtvalor);
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				obtenerMontoAPagar();
			} else {
				fail("No se pudo obtener el valro del pago debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void obtenerMontoAPagarArreglo() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtValorAPagar)));
			String txtvalor = driver.findElement(By.xpath(this.txtValorAPagar)).getText().replaceAll("[^0-9]", "");

			System.out.println("el valor a pagar es: " + txtvalor);

			// agrego al arreglo el monto a pagar
			this.listaMontos.add(Integer.parseInt(txtvalor));

		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				obtenerMontoAPagarArreglo();
			} else {
				fail("No se pudo obtener el valor del pago debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void ingresarNumeroCelularARecargar(String numero) {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputNumero)));
			driver.findElement(By.xpath(this.inputNumero)).sendKeys(numero);

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnDone)));
			driver.findElement(By.xpath(this.btnDone)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				ingresarNumeroCelularARecargar(numero);
			} else {
				fail("No se pudo ingresar numero de celular debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void seleccionarMonto(String monto) {
		try {
			contador++;
			switch (monto) {
			case "5000":
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.checkCincoMil)));
				driver.findElement(By.xpath(this.checkCincoMil)).click();
				break;
			case "7000":
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.checkSieteMil)));
				driver.findElement(By.xpath(this.checkSieteMil)).click();
				break;
			case "10000":
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.checkDiezMil)));
				driver.findElement(By.xpath(this.checkDiezMil)).click();
				break;
			case "20000":
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.checkVeinteMil)));
				driver.findElement(By.xpath(this.checkVeinteMil)).click();
				break;
			default:
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.montoDiferente)));
				driver.findElement(By.xpath(this.montoDiferente)).sendKeys(monto);

				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnDone)));
				driver.findElement(By.xpath(this.btnDone)).click();
			}

			System.out.println("di click a btn done");
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				ingresarBtnRecargar();
			} else {
				fail("No se pudo ingresar el monto debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void cerrarPopUpTiendaVirtual() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.cerrarPopup)));
			driver.findElement(By.xpath(this.cerrarPopup)).click();
		} catch (Exception e) {
			System.out.println(
					"No se encontró popUp al hacer clic en botón 'Tienda Virtual', debido a: " + e.getMessage());
		}
	}

	public void esperarVisibilidadDeTiendaVirtual() {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnTodosTiendaVirtual)));
		} catch (Exception e) {
			if (!(contador == 30)) {
				utilidad.esperaMiliseg(500);
				esperarVisibilidadDeTiendaVirtual();
			} else {
				fail("No se encontró botón 'Todos' de tienda virtual, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void esperarVisibilidadBtnBono20k() {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnBono20k)));
		} catch (Exception e) {
			if (!(contador == 30)) {
				Utilidades.esperar(500);
				esperarVisibilidadBtnBono20k();
			} else {
				fail("No se encontró botón de bono en el corral, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void esperarVisibilidadBonoCompraCorral() {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.txtCorral)));
		} catch (Exception e) {
			if (!(contador == 30)) {
				Utilidades.esperar(500);
				esperarVisibilidadBonoCompraCorral();
			} else {
				fail("No se encontró titulo del bono en el corral, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void esperarVisibilidadDetalleCompraBono() {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.txtDetalleCompraCorral)));
		} catch (Exception e) {
			if (!(contador == 30)) {
				Utilidades.esperar(500);
				esperarVisibilidadDetalleCompraBono();
			} else {
				fail("No se encontró titulo del detalle bono en el corral, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void esperarVisibilidadCompraExitosaBono() {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.txtCompraBono)));
		} catch (Exception e) {
			if (!(contador == 30)) {
				Utilidades.esperar(500);
				esperarVisibilidadCompraExitosaBono();
			} else {
				fail("No se encontró titulo de la compra bono exitosa en el corral, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicFinalizarCompraBono() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnFinalizarCompraBono)));
			driver.findElement(By.xpath(this.btnFinalizarCompraBono)).click();
		} catch (Exception e) {
			if (!(contador == 10)) {
				Utilidades.esperar(500);
				clicFinalizarCompraBono();
			} else {
				fail("No se encontró botón 'Finalizar' del bono en el corral, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validarTransaccionExitosaCompraBono() {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnFinalizarCompraBono)));
			driver.findElement(By.xpath(this.btnFinalizarCompraBono)).click();
		} catch (Exception e) {
			if (!(contador == 10)) {
				Utilidades.esperar(500);
				clicFinalizarCompraBono();
			} else {
				fail("No se encontró botón 'Finalizar' del bono en el corral, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validarBonoCorral() {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnNotificacionBono)));
			boolean isDisplayed = driver.findElement(By.xpath(this.btnNotificacionBono)).isDisplayed();
			assertThat(isDisplayed, is(true));
			driver.findElement(By.xpath(this.btnNotificacionBono)).click();
		} catch (Exception e) {
			if (!(contador == 10)) {
				utilidades.esperaMiliseg(500);
				validarBonoCorral();
			} else {
				fail("No se pudo encontrar bono de compras de corral en campana de notificaciones, debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void ingresarCorreoCompraBonoCorral() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputCorreoCorral)));
			driver.findElement(By.xpath(this.inputCorreoCorral)).sendKeys("xxx@gmail.com");
		} catch (Exception e) {
			if (!(contador == 10)) {
				utilidades.esperaMiliseg(500);
				ingresarCorreoCompraBonoCorral();
			} else {
				fail("No se pudo encontrar input de correo electronico en compra de bono corral, debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicBotonCompartirBono() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCompartirBono)));
			driver.findElement(By.xpath(this.btnCompartirBono)).click();
		} catch (Exception e) {
			if (!(contador == 10)) {
				utilidades.esperaMiliseg(500);
				clicBotonCompartirBono();
			} else {
				fail("No se pudo encontrar botón 'Compartir' de compra en bonos, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicBotonCerrarVentanaCompartirBono() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCerrarCompartirBono)));
			driver.findElement(By.xpath(this.btnCerrarCompartirBono)).click();
		} catch (Exception e) {
			if (!(contador == 10)) {
				utilidades.esperaMiliseg(500);
				clicBotonCerrarVentanaCompartirBono();
			} else {
				fail("No se pudo encontrar botón para cerrar ventana de compartir compra en bonos, debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validarDescargaBono() {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.txtBoleta)));
			boolean isDisplayed = driver.findElement(By.xpath(this.txtBoleta)).isDisplayed();
			assertTrue(isDisplayed);
		} catch (Exception e) {
			if (!(contador == 20)) {
				utilidad.esperaMiliseg(500);
				validarDescargaBono();
			} else {
				fail("No se encontró pdf de la descarga del bono, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void esperarAparezcaBtnCorral() {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnCorral)));
		} catch (Exception e) {
			if (!(contador == 30)) {
				utilidad.esperaMiliseg(500);
				esperarAparezcaBtnCorral();
			} else {
				fail("No se encontró botón 'Bonos de hamburguesas y malteadas' del corral en tienda virtual, debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	

}
