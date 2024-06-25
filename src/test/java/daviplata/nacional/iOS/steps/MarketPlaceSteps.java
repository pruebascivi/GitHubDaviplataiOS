package daviplata.nacional.iOS.steps;

import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.List;

import org.apache.tools.ant.property.GetProperty;

import cucumber.api.Scenario;
import daviplata.nacional.iOS.definitions.Hooks;
import daviplata.nacional.iOS.pageObjects.ComprasMarketPlacePageObjects;
import daviplata.nacional.iOS.pageObjects.EcardPageObject;
import daviplata.nacional.iOS.pageObjects.MarketPlacePageObjects;
import daviplata.nacional.iOS.pageObjects.HomePageObjects;
import daviplata.nacional.iOS.pageObjects.LoginPageObjects;
import daviplata.nacional.iOS.pageObjects.LoginRobustoPage;
import daviplata.nacional.iOS.pageObjects.MenuHamburguesaPageObjects;
import daviplata.nacional.iOS.pageObjects.NanocreditoPageObjects;
import daviplata.nacional.iOS.pageObjects.NotificacionesPushPageObjects;
import daviplata.nacional.iOS.pageObjects.PagarPageObjects;
import daviplata.nacional.iOS.pageObjects.RecargaPageObjects;
import daviplata.nacional.iOS.pageObjects.RegistroMayoresPageObjects;
import daviplata.nacional.iOS.pageObjects.SacarPlataPageObjects;
import daviplata.nacional.iOS.utilidades.Utilidades;
import daviplata.nacional.iOS.utilidades.UtilidadesTCS;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

public class MarketPlaceSteps {
	
	BaseUtil base;
	HomePageObjects homePageObjects;
	ComprasMarketPlacePageObjects comprasMarketPlacePageObjects;
	MarketPlacePageObjects marketObj;
	SacarPlataPageObjects pageSacarPlata;
	HomePageObjects pageHome;
	RecargaPageObjects recargarPageObjects;
	LoginPageObjects loginPageObjects;
	EcardPageObject ecardPageObject;
	PagarPageObjects pagePagar;
	WebRedebanSteps webRedebanSteps;
	MenuHamburguesaPageObjects menuHamburguesaPageObjects;
	NanocreditoPageObjects nanocreditoPageObjects;
	private int contador = 0;
	Utilidades utilidad;
	UtilidadesTCS utilidadesTCS;
	BigDecimal valorHome = null;
	BigDecimal valorTransferencia = null;
	String monto;
	public static String horaTxSeguro;
	public static String valorPago;

	@Step("Ingresar a MarketPlace")
	public void btnMarketPlace() {
		Utilidades.esperaMiliseg(1500);
		utilidadesTCS.scrollBackground("xpath", MarketPlacePageObjects.BTN_CAJA, -200, 0);
		Utilidades.esperaMiliseg(1000);
		marketObj.btnMarketPlace();
		boolean estadoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", MarketPlacePageObjects.CERRAR_POPUP);
		if(estadoVisible == true) {
			marketObj.cerrarPopUpTiendaVirtual();
		}
		marketObj.esperarVisibilidadDeTiendaVirtual();
		Utilidades.tomaEvidencia("Ingreso a MarketPlace");
	}
	
	@Step("Validar btn inhabilitado")
	public void validarBtnInhabilitado() {
		marketObj.validarBtnInhabilitado();
	}
	
	@Step
	public void validarBtnMovilidad() {
		utilidadesTCS.esperarElementVisibility("xpath", MarketPlacePageObjects.MOVILIDAD_HOME_BTN);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath", MarketPlacePageObjects.MOVILIDAD_HOME_BTN);
		Utilidades.esperaMiliseg(5000);
		Utilidades.tomaEvidencia("Valido que el botón de movilidad del home, lleva a la tienda virtual");
	}

	@Step("Ingresar a Seguros")
	public void btnSeguros() {
		utilidad.tomaEvidencia("Ingreso a Seguros");
		marketObj.btnSeguros();
	}
	
	@Step("validar afectación de saldo debido a recarga")
	public void validarSaldosRecarga() {
		marketObj.cerrarPopup();
		marketObj.validarTransaccionExitosa();
		marketObj.guardarNumeroAutorizador();
		utilidad.tomaEvidencia("mensaje de transaccion exitosa");
		marketObj.clickbtnFinalizar();
		marketObj.btnVolver();
		utilidad.esperaMiliseg(7000);
		marketObj.capturarSaldoFinal();
	}
	
	@Step("validar mensaje de saldo insuficiente")
	public void validarMensajeSaldoInsuficiente() {
		marketObj.validarMensajeTransaccionFallida();
		marketObj.clickBtnAceptar();
		pageSacarPlata.botonAtras2();
		utilidad.esperaMiliseg(2000);
		utilidad.tomaEvidencia("capturo saldo final");
		pageHome.capturarSaldoFinal();
	}
	
	
	@Step("Diligencio datos de recarga minutos")
	public void diligenciarDatosRecargaMinutos(String monto, String numero) {
		utilidad.esperaMiliseg(7000);
		utilidad.tomaEvidencia("Ingreso a recarga minutos");
		marketObj.ingresarBtnRecargar();
		utilidad.tomaEvidencia("formulario de recarga de minutos");
		marketObj.seleccionarMonto(monto);
		marketObj.ingresarNumeroCelularARecargar(numero);
		utilidad.tomaEvidencia("diligencio formulario de recarga de minutos");
		marketObj.clickBtnContinuar();
		utilidad.tomaEvidencia("detalle de compra");
		marketObj.obtenerMontoAPagar();
		marketObj.clickBtnRecargar();
		utilidad.esperaMiliseg(2000);
		utilidad.tomaEvidencia("recarga exitosa");
		marketObj.clickBtnAceptar();
	}
	
	@Step("Diligencio datos de recarga minutos con monto superior")
	public void diligenciarDatosRecargaMinutosMontoSuperior(String monto, String numero) {
		utilidad.esperaMiliseg(7000);
		utilidad.tomaEvidencia("Ingreso a recarga minutos");
		marketObj.ingresarBtnRecargar();
		utilidad.tomaEvidencia("formulario de recarga de minutos");
		marketObj.seleccionarMonto(monto);
		utilidad.tomaEvidencia("validacion btn continuar desactivado");
	}
	
	@Step("Diligencio datos de recarga paquetes")
	public void diligenciarDatosRecargaPaquetes(String numero) {
		utilidad.esperaMiliseg(7000);
		utilidad.tomaEvidencia("Ingreso a recarga paquetes");
		marketObj.ingresarBtnPaquetes();
		utilidad.tomaEvidencia("lista de paquetes");
		marketObj.seleccionarTodoIncluido();
		marketObj.seleccionarPaqueteAComprar();
		marketObj.ingresarNumeroCelularARecargar(numero);
		utilidad.tomaEvidencia("diligencio formulario de recarga de paquete");
		marketObj.clickBtnContinuar();
		utilidad.tomaEvidencia("detalle de compra");
		marketObj.obtenerMontoAPagar();
		marketObj.clickBtnRecargar();
		utilidad.esperaMiliseg(2000);
		utilidad.tomaEvidencia("recarga exitosa");
		marketObj.clickBtnAceptar();
	}
	@Step("Diligencio datos de recarga paquetes con fondos insuficientes")
	public void diligenciarDatosRecargaPaquetesFondosInsuficientes(String numero) {
		utilidad.esperaMiliseg(7000);
		utilidad.tomaEvidencia("Ingreso a recarga paquetes");
		marketObj.ingresarBtnPaquetes();
		utilidad.tomaEvidencia("lista de paquetes");
		marketObj.seleccionarTodoIncluido();
		marketObj.seleccionarPaqueteAComprar();
		marketObj.ingresarNumeroCelularARecargar(numero);
		utilidad.tomaEvidencia("diligencio formulario de recarga de paquete");
		marketObj.clickBtnContinuar();
		utilidad.tomaEvidencia("detalle de compra");
		marketObj.obtenerMontoAPagar();
		marketObj.clickBtnRecargar();
		utilidad.esperaMiliseg(2000);
		utilidad.tomaEvidencia("recarga fallida");
	}
	
	@Step("Diligencio datos de recarga paquetes")
	public void completoFlujoDeRecargaPaquetes(String numero) {
		Utilidades.esperaMiliseg(8000);
		Utilidades.tomaEvidencia("ingreso a tienda virtual");
		// INGRESO A OPERADOR MOVISTAR
		marketObj.clickOperadorMovistar();
		Utilidades.esperaMiliseg(7000);
		Utilidades.tomaEvidencia("Ingreso a recarga paquetes");
		// INGRESO A BTN DE PAQUETES
		marketObj.ingresarBtnPaquetes();
		Utilidades.tomaEvidencia("lista de paquetes");
		// SELECCIONAR TAB 
		//marketObj.seleccionarTodoIncluido();
		// SELECCIONO PAQUETE A COMPRAR
		//marketObj.seleccionarPaqueteAComprar();
		marketObj.seleccionoPaqueteVoz();
		// INGRESO NUMERO DE CELULAR A RECARGAR
		marketObj.ingresarNumeroCelularARecargar(numero);
		Utilidades.tomaEvidencia("diligencio formulario de recarga de paquete");
		// CLICK A BTN CONTINUAR
		marketObj.clickBtnContinuar();
		Utilidades.tomaEvidencia("detalle de compra");
		// OBTENER MONTO A PAGAR
		marketObj.obtenerMontoAPagarArreglo();
		// CLICK A BTN DE RECARGAR
		marketObj.clickBtnRecargar();
		Utilidades.esperaMiliseg(2000);
		Utilidades.tomaEvidencia("recarga exitosa");
		// CLICK A BTN ACEPTAR
		marketObj.clickBtnAceptar();
		Utilidades.esperaMiliseg(4000);
		Utilidades.tomaEvidencia("mensaje de transaccion exitosa");
		// VALIDAR MENSAJE DE TRANSACCION EXITOSA
		marketObj.validarTransaccionExitosa();
		// GUARDA NUMERO DE AUTORIZACION EN UN ARREGLO
		marketObj.guardarNumeroAutorizadorArreglo();
		// CLICK A BTN FINALIZAR
		marketObj.clickbtnFinalizar();
	}
	
	
	@Step("Ingresar a operador elegido")
	public void ingresarOpcionSeleccionada(String operador) {
		utilidad.esperaMiliseg(10000);
		utilidad.tomaEvidencia("Ingreso a recargas");
		marketObj.btnRecargas();
		utilidad.scrollDownSwipe(1);
		marketObj.btnOperador(operador);
		
	}

	@Step("Ingresar a Seguros de vida")
	public void btnSegurosVida(String opcion, String genero) {
		utilidad.tomaEvidencia("Ingreso a Seguro de vida");	
		marketObj.btnSeguroVida();
		marketObj.cerrarPopup();
		utilidad.tomaEvidencia("Continuar");
		marketObj.btnContinuarmicroseguro();
		if (opcion.equalsIgnoreCase("1")) {
			utilidad.tomaEvidencia("Primera Cobertura");
			marketObj.btnSeleccionaroberturaPrimera();
		} else {
			utilidad.tomaEvidencia("Segunda Cobertura");
			marketObj.btnSeleccionarCoberturaSegunda();
		}
		marketObj.clicBtnDesplegableFechaNacimiento();
		//marketObj.abrirDiscosFechaNacimiento();
		marketObj.escogerFechaNacimiento();
		marketObj.clicBtnAceptarFechaNacimiento();
		utilidad.tomaEvidencia("Ingreso fecha de nacimiento");
		utilidad.esperaMiliseg(2000);
		marketObj.clicbtnGenero();
		marketObj.escogerGenero(genero);
		utilidad.tomaEvidencia("Ingreso genero");
		marketObj.btnCheckBox();
		marketObj.capturoDatosValorPagar();
		utilidad.tomaEvidencia("Comprar");
		marketObj.btnComprar();

	}

	@Step("Ingresar a Seguros Mascota")
	public void btnSeguroMascota(String opcion, String raza) {
		marketObj.btnSeguros();
		utilidad.tomaEvidencia("Seguro mascota");
		marketObj.btnMascota();
		marketObj.cerrarPopup();
		marketObj.btnContinuarMascota();
		if (opcion.equalsIgnoreCase("1")) {
			utilidad.tomaEvidencia("Primera Cobertura");
			marketObj.btnSeleccionarOpcion1();
		} else {
			utilidad.tomaEvidencia("Segunda Cobertura");
			marketObj.btnSeleccionarOpcion2();
		}
		marketObj.btnSeleccionarMascota();
		marketObj.seleccionarMascota(raza);
		
		marketObj.btnCheckBox();
		marketObj.capturoDatosValorPagarBicicleta();
		utilidad.tomaEvidencia("Comprar");
		marketObj.btnComprar();

	}
	
	@Step("Ingresar a Seguros Mascota con volver atras")
	public void btnSeguroMascotaVolver(String opcion, String raza) {
		marketObj.btnSeguros();
		utilidad.tomaEvidencia("Seguro mascota");
		marketObj.btnMascota();
		utilidad.tomaEvidencia("Ingreso a seguros mascota");
		marketObj.btnVolver2();
		utilidad.esperaMiliseg(3000);
		utilidad.tomaEvidencia("Valido volver a la pantalla anterior");
		marketObj.btnMascota();
		utilidad.tomaEvidencia("Ingreso a seguros mascota");
		marketObj.btnContinuarMascota();
		utilidad.tomaEvidencia("Escoje cual seguro");
		marketObj.btnVolver2();
		utilidad.esperaMiliseg(3000);
		utilidad.tomaEvidencia("Valido volver a la pantalla anterior");
		marketObj.btnContinuarMascota();
		if (opcion.equalsIgnoreCase("1")) {
			utilidad.tomaEvidencia("Primera Cobertura");
			marketObj.btnSeleccionarOpcion1();
			utilidad.tomaEvidencia("Completo datos");
		} else {
			utilidad.tomaEvidencia("Segunda Cobertura");
			marketObj.btnSeleccionarOpcion2();
			utilidad.tomaEvidencia("Completo datos");
		}
		marketObj.btnVolver2();
		utilidad.esperaMiliseg(3000);
		utilidad.tomaEvidencia("Valido volver a la pantalla anterior");
		if (opcion.equalsIgnoreCase("1")) {
			utilidad.tomaEvidencia("Primera Cobertura");
			marketObj.btnSeleccionarOpcion1();
			utilidad.tomaEvidencia("Completo datos");
		} else {
			utilidad.tomaEvidencia("Segunda Cobertura");
			marketObj.btnSeleccionarOpcion2();
			utilidad.tomaEvidencia("Completo datos");
		}
		marketObj.btnSeleccionarMascota();
		if (raza.equalsIgnoreCase("Gato")) {
			utilidad.tomaEvidencia("Selecciono gato");
			marketObj.btnSeleccionarGato();
		} else {
			utilidad.tomaEvidencia("Selecciono perro");
			marketObj.btnSeleccionarPerro();
		}
		marketObj.btnCheckBoxMascota();
		utilidad.tomaEvidencia("Completo el flujo");
		

	}

	@Step("Ingresar a Seguros Bicicleta")
	public void btnSeguroBicicleta(String opcion) {
		marketObj.btnBicicleta();
		//marketObj.cerrarPopup();
		utilidad.tomaEvidencia("Continuar");
		marketObj.btnContinuarMascota();
		if (opcion.equalsIgnoreCase("1")) {
			utilidad.tomaEvidencia("Primera Cobertura");
			marketObj.btnSeleccionarOpcion1();
		} else {
			utilidad.tomaEvidencia("Segunda Cobertura");
			marketObj.btnSeleccionarOpcion2();
		}
		marketObj.btnFechaBicicleta();
		marketObj.btnFecha();
		marketObj.btnContinuarTeclado();
		utilidad.tomaEvidencia("Fecha de compra bicicleta");
		marketObj.btnCheckBox();
		marketObj.capturoDatosValorPagarBicicleta();
		utilidad.tomaEvidencia("Comprar");
		marketObj.btnComprar();

	}
	@Step("Ingresar a Seguros Soat")
	public void btnSeguroSoat(String placa) {
		//marketObj.btnSeguros();
		//marketObj.btnSoat();
		marketObj.btnContinuarSoat();
		marketObj.txtPlaca(placa);
		marketObj.checkBoxSi();
		marketObj.btnCotizar();
		marketObj.btnContinuarSoat();
		marketObj.btnCiudadSoat();
		marketObj.btnDireccionSoat();
		marketObj.ingresarDatos("xxx@gmail.com");
		marketObj.IngresoTerminos();
		marketObj.btnContinuarSoat();
		marketObj.ComprarSoat();
	}
	@Step("Ingresar a Seguros Soat")
	public void btnSeguroSoatPlacaInvalida(String usuario, String placa) {
		marketObj.btnSeguros();
		marketObj.btnSoat();
		marketObj.btnContinuarSoat();
		marketObj.txtPlaca(placa);
		marketObj.checkBoxSi();
		marketObj.btnSeleccionId();
		marketObj.inputNumId(usuario);
		marketObj.inputNombreTitular("Byron");
		marketObj.inputApellidoTitular("Peña");
		utilidad.moverPantallaCorto();
		utilidad.tomaEvidencia("Ingreso la placa");
		marketObj.btnCotizar();
	}

	@Step("Valido transaccion")
	public void btnValidar() {
		utilidad.esperaMiliseg(15000);
		utilidad.tomaEvidencia("Transaccion Exitosa");
		marketObj.darClickBtnFinalizarCompra();
		marketObj.cerrarPopup();
		utilidad.esperaMiliseg(15000);
		marketObj.capturarSaldoFinal();
		utilidad.tomaEvidencia("Saldo final " + base.saldoFinal);
		
	}
	
	@Step("flujo volver a captura saldo final")
	public void flujoVolvercapturarSaldo() {
//		marketObj.cerrarMensaje();
		marketObj.volver();
		utilidad.esperaMiliseg(15000);
		//marketObj.darClickEnActualizarSaldo();
		marketObj.capturarSaldoFinal();
		utilidad.tomaEvidencia("Saldo final " + base.saldoFinal);
		
	}
	
	
	

	@Step("Valido transaccion Gas")
	public void btnValidarGas() {
		List<MobileElement> listaElementos = marketObj.capturaResultadoTransaccion();
		marketObj.verificoResultadoTransaccion(listaElementos);
		utilidad.tomaEvidencia("Transaccion Exitosa");
		marketObj.capturoDatosPagos();
		marketObj.darClickEnActualizarSaldo();
		marketObj.capturarSaldoFinal();
		utilidad.tomaEvidencia("Saldo final " + base.saldoFinal);
		marketObj.validarSaldosPagos();
	}

	@Step("Ingresar a Seguros de vida con fecha menor")
	public void btnSegurosVidaFechaMenor(String opcion, String genero) {
		marketObj.btnSeguroVida();
		marketObj.cerrarPopup();
		utilidad.tomaEvidencia("Continuar");
		marketObj.btnContinuarmicroseguro();
		if (opcion.equalsIgnoreCase("1")) {
			utilidad.tomaEvidencia("Primera Cobertura");
			marketObj.btnSeleccionaroberturaPrimera();
		} else {
			utilidad.tomaEvidencia("Segunda Cobertura");
			marketObj.btnSeleccionarCoberturaSegunda();
		}
		utilidad.tomaEvidencia("carga de informacion");
		marketObj.clicBtnDesplegableFechaNacimiento();
		marketObj.btnFechaNacimientoIncorrecto();
		marketObj.clicBtnAceptarFechaNacimiento();
		utilidad.tomaEvidencia("mensaje de cliente menor");

	}

	@Step("Valido mensaje ")
	public void validarMensaje() {
		marketObj.validarMensaje();
		utilidad.tomaEvidencia("Valido mensaje de rango de edad");
	}

	@Step("Ingreso a Gas")
	public void ingresarGas() {
		utilidad.tomaEvidencia("Ingreso a Gas");
		marketObj.btnGas();
	}
	
	@Step("Ingreso a Minutos")
	public void ingresarMinutos() {
		utilidad.tomaEvidencia("Ingreso a Gas");
		marketObj.btnMinutos();
	}

	@Step("Completo flujo gas")
	public void ingresarGasFlujo(String referencia,String nombreEmpresa) {
		utilidad.tomaEvidencia("Otros servicios");
		marketObj.btnOtroServicios();
		marketObj.txtBuscarEmpresa(nombreEmpresa);
		utilidad.tomaEvidencia("Busco la empresa");
		marketObj.btnEmpresa();
		marketObj.txtReferencia(referencia);
		utilidad.tomaEvidencia("Ingreso referencia");
		marketObj.btnContinuarGeneral();
		utilidad.tomaEvidencia("Pagar referencia");
		marketObj.capturoValor();
		marketObj.btnContinuarGeneral();
		marketObj.btnPagarRef();
	}
	
	@Step("Completo flujo referencia incorrecta")
	public void ingresarGasFlujoReferencia(String referencia,String nombreEmpresa) {
		utilidad.tomaEvidencia("Otros servicios");
		marketObj.btnOtroServicios();
		pagePagar.ingresoDatosDeEmpresa(nombreEmpresa);
		utilidad.tomaEvidencia("Empresa buscada " + nombreEmpresa);
		pagePagar.darClickEnEmpresaEncontrada(nombreEmpresa);
		StringBuilder referenciaErronea = new StringBuilder();
		referenciaErronea.append(referencia);
		referenciaErronea.reverse();
		pagePagar.ingresarReferenciaUno(referenciaErronea.toString());
		utilidad.tomaEvidencia("Ingreso referencia");
		pagePagar.darClickEnContinuar();
	}
	@Step("Validar transaccion rechazada referencia")
	public void ingresarFlujoReferenciaRechazada() {
		marketObj.validarTransaccionRechazada();
		utilidad.tomaEvidencia("Validar referencia errada");
	}

	@Step("Completo otros servicios")
	public void ingresarOtrosServicios(String referencia, String opcion) {
		utilidad.tomaEvidencia("Otros servicios");
		marketObj.btnOtrosServicios();
		marketObj.txtBuscarEmpresa(opcion);
		utilidad.tomaEvidencia("Busco la empresa");
		marketObj.btnEmpresaOtrosServicio();
		marketObj.txtReferencia(referencia);
		utilidad.tomaEvidencia("Ingreso referencia");
		marketObj.btnContinuarRef();
		marketObj.txtvalor();
		utilidad.tomaEvidencia("Continuar referencia");
		marketObj.btnContinuarSeguros();
		utilidad.tomaEvidencia("Pagar referencia");
		marketObj.btnPagarRef();
	}

	@Step("Completo otros servicios con referencia errada")
	public void ingresarOtrosServiciosReferenciaErrada(String referencia, String opcion) {
		utilidad.tomaEvidencia("Otros servicios");
		marketObj.btnOtrosServicios();
		marketObj.txtBuscarEmpresa(opcion);
		utilidad.tomaEvidencia("Busco la empresa");
		marketObj.btnEmpresaBuscada();
		marketObj.txtReferencia(referencia);
		utilidad.tomaEvidencia("Ingreso referencia");
		marketObj.btnContinuarRef();
		marketObj.btnPagarRef();

	}

	@Step("valido referencia errada")
	public void validarReferenciaErrada() {
		marketObj.validarMensajeReferenciaErrada();
		utilidad.tomaEvidencia("Valido referencia errada");

	}

	@Step("Validar salida de daviplata")
	public void validarSalidaDaviplata() {
		utilidad.esperaMiliseg(4000);
		utilidad.tomaEvidencia("Valido el ingreso a Marketplace");
		marketObj.btnGas();
		marketObj.btnSalir();
		utilidad.tomaEvidencia("Salir de Daviplata");
		marketObj.btnAceptarSalir();
		marketObj.txtDaviplata();
		utilidad.tomaEvidencia("Valido la salida exitosa de Daviplata");

	}

	@Step("Realizo compra de bono para compartir y descargar la compra")
	public void flujoCompraBono() {
		utilidad.esperaMiliseg(4000);
		utilidad.tomaEvidencia("Ingreso a crepes");
		marketObj.btnTodos();
		utilidad.esperaMiliseg(2000);
		utilidad.scrollDownSwipe(3);
		utilidad.tomaEvidencia("Ingreso al corral");
		marketObj.btnCorral();
		marketObj.esperarVisibilidadBtnBono20k();
		utilidad.tomaEvidencia("Bono");
		marketObj.btnBono20k();
		marketObj.esperarVisibilidadBonoCompraCorral();
		utilidad.tomaEvidencia("Continuar");
		marketObj.btnContinuarBono();
		marketObj.esperarVisibilidadDetalleCompraBono();
		marketObj.ingresarCorreoCompraBonoCorral();
		utilidad.tomaEvidencia("Ingresar correo electrónico y dar clic en comprar bono");
		marketObj.btnComprarBono();
		marketObj.esperarVisibilidadCompraExitosaBono();
	}

	@Step("Flujo de compra de bono")
	public void ingresarBonoYValidarNecesitoAyuda() {
		utilidad.esperaMiliseg(4000);
		marketObj.btnNecesitoAyuda();
		System.out.println("di scroll");
		utilidad.scrollDownSwipe(3);
		utilidad.esperaMiliseg(4000);
		System.out.println("buscando crepes");
		utilidad.scrollDownSwipe(4);
		utilidad.tomaEvidencia("Ingreso a crepes");
		marketObj.btnCrepes();
		utilidad.esperaMiliseg(1000);
		utilidad.tomaEvidencia("Bono");
		marketObj.btnMiniWafle();
		utilidad.scrollDownSwipe(1);
		utilidad.tomaEvidencia("Continuar");
		marketObj.btnContinuarBono();
		marketObj.btnComprarBono();	
		marketObj.txtValidarCompra();
		utilidad.tomaEvidencia("Valido compra de bono");
		marketObj.btnNecesitoAyuda();
		marketObj.btnFinalizar();
		marketObj.btnNecesitoAyuda();

	}
	
	@Step("Flujo de pago de servicios")
	public void ingresarPagarYValidarNecesitoAyuda() {
		utilidad.esperaMiliseg(4000);
		pagePagar.ingresoDatosDeEmpresa("DNR UNA REF ATH dos");
		utilidad.tomaEvidencia("Empresa buscada " + "DNR UNA REF ATH dos");
		pagePagar.darClickEnEmpresaEncontrada("DNR UNA REF ATH dos");
		utilidad.esperaMiliseg(2000);
		marketObj.btnNecesitoAyuda();
		pagePagar.ingresarReferenciaUno("52411946");
		utilidad.tomaEvidencia("Referencia de pago ingresada "+ "52411946");
		pagePagar.darClickEnContinuar();
		pagePagar.ingresarValorAPagar("2500");
		utilidad.tomaEvidencia("Valor a pagar "+ "2500");
		pagePagar.darClickEnContinuar();
		marketObj.btnNecesitoAyuda();
		utilidad.esperaMiliseg(4000);
		marketObj.btnNecesitoAyuda();	
	}

	@Step("Flujo de compra de bono")
	public void ingresarBonoSinCorreo() {
		utilidad.esperaMiliseg(4000);
		for(int i = 0; i<=3; i++) {
			utilidad.scrollDownSwipe(1);
		}
		utilidad.tomaEvidencia("Ingreso al corral");
		marketObj.btnCorral();
		utilidad.esperaMiliseg(2000);
		utilidad.tomaEvidencia("Bono");
		marketObj.btnBono20k();
		utilidad.tomaEvidencia("Continuar");
		marketObj.btnContinuarBono();
		utilidad.tomaEvidencia("No Ingreso el email");
		marketObj.btnComprarBono();
		utilidad.esperaMiliseg(1000);
		utilidad.tomaEvidencia("Valido que pide el correo obligatoriamente");

	}

	@Step("valido compra correcta bono")
	public void validarCompraBono() {
		utilidad.tomaEvidencia("Ingreso a notificaciones");
		marketObj.btnCampana();
		utilidad.tomaEvidencia("Compras tienda virtual");
		marketObj.btnComprasTiendaVirtual();
		marketObj.txtValidarCompraCampanaCorral();
		utilidad.tomaEvidencia("Valido la compra");

	}

	@Step("Ingreso a descuentos")
	public void ingresarDescuentos() {
		utilidad.esperaMiliseg(3000);
		utilidad.tomaEvidencia("Ingreso a Descuentos");
		marketObj.btnDescuentos();

	}

	@Step("Ingreso a descuentos Dunki ")
	public void ingresarDescuentosDunki() {
		utilidad.tomaEvidencia("Ingreso a bono donas");
		marketObj.btnClickDunki();
		utilidad.tomaEvidencia("Promo Donas");
		marketObj.btnDonuts();
		marketObj.ingresarDatoaDonuts();
		marketObj.btnContinuarGeneral();
		utilidad.tomaEvidencia("Comprar Bono");
		marketObj.btnComprarBono();
		marketObj.txtValidarCompra();
		utilidad.tomaEvidencia("Valido compra de bono");
		marketObj.btnFinalizar();
		marketObj.txtValorBono();
		utilidad.tomaEvidencia("Valido el valor del bono");
		marketObj.btnFinalizar();
		utilidad.darUnTap(150, 176);
		marketObj.darClickEnActualizarSaldo();
		marketObj.capturarSaldoFinal();
		utilidad.tomaEvidencia("Saldo final " + base.saldoFinal);
		marketObj.validarSaldosPagos();

	}
	@Step("Ingreso a descuentos McDonals ")
	public void ingresarDescuentosMc() {
		utilidad.tomaEvidencia("Ingreso a bono Mc Donalds");
		marketObj.btnClickDunki();
		utilidad.tomaEvidencia("Bono de 10k");
		marketObj.btnBono();
		marketObj.btnContinuarBono();
		utilidad.tomaEvidencia("Comprar Bono");
		marketObj.txtEmail();
		utilidad.tomaEvidencia("Ingreso el email");
		marketObj.btnComprarBono();	
		marketObj.txtValidarCompra();
		utilidad.tomaEvidencia("Valido compra de bono");
		marketObj.btnFinalizar();
		marketObj.txtValorBono();
		utilidad.tomaEvidencia("Valido el valor del bono");
		marketObj.btnFinalizar();
		utilidad.darUnTap(150, 176);
		marketObj.darClickEnActualizarSaldo();
		marketObj.capturarSaldoFinal();
		utilidad.tomaEvidencia("Saldo final " + base.saldoFinal);
		marketObj.validarSaldosPagos();

	}

	@Step("Ingresar Donas")
	public void ingresarDonas() {
		marketObj.btnRestaurante();
		utilidad.esperaMiliseg(6000);
		utilidad.scrollDownSwipe(1);
		utilidad.scrollDownSwipe(1);
		utilidad.moverPantalla(543, 1530, 537, 605);

	}

	@Step("Completo flujo donas")
	public void CompletarflujoDonas() {
		utilidad.esperaMiliseg(3000);
		utilidad.tomaEvidencia("Ingreso a bono donas");
		marketObj.btnDonas();
		utilidad.tomaEvidencia("Promo Donas");
		marketObj.btnDonuts();
		marketObj.ingresarDatoaDonuts();
		marketObj.btnContinuarGeneral();
		utilidad.tomaEvidencia("Comprar Bono");
		marketObj.btnComprarBono();
		marketObj.txtValidarCompra();
		utilidad.tomaEvidencia("Valido compra de bono");
		marketObj.btnFinalizar();
		marketObj.txtValorBono();
		utilidad.tomaEvidencia("Valido el valor del bono");
		marketObj.btnFinalizar();
		marketObj.btnVolver();
		//utilidad.darUnTap(150, 176);
		marketObj.darClickEnActualizarSaldo();
		marketObj.capturarSaldoFinal();
		utilidad.tomaEvidencia("Saldo final " + base.saldoFinal);
		marketObj.validarSaldosPagos();

	}
	@Step("Validar el boton de volver")
	public void ValidarFlujoAtras() {
		utilidad.esperaMiliseg(4000);
		utilidad.tomaEvidencia("Ingreso a crepes");
		marketObj.btnTodos();
		utilidad.esperaMiliseg(2000);
		utilidad.scrollDownSwipe(3);
		utilidad.tomaEvidencia("Ingreso al corral");
		marketObj.btnCorral();
		marketObj.esperarVisibilidadBtnBono20k();
		utilidad.tomaEvidencia("Ingreso al bono");
		marketObj.btnVolver();
		marketObj.esperarAparezcaBtnCorral();
		marketObj.txtValidarVolver("//*[contains(@name, 'hamburguesas')]");
		marketObj.btnCorral();
		marketObj.esperarVisibilidadBtnBono20k();
		utilidad.tomaEvidencia("Ingreso al bono");
		marketObj.btnBono20k();
		marketObj.esperarVisibilidadBonoCompraCorral();
		utilidad.tomaEvidencia("Ingreso a información de la compra del bono");
		marketObj.btnVolver();
		marketObj.esperarVisibilidadBtnBono20k();
		marketObj.txtValidarVolver("//*[contains(@name, 'Bono')]");
		marketObj.btnBono20k();
		marketObj.esperarVisibilidadBonoCompraCorral();
		utilidad.tomaEvidencia("Ingreso a información de la compra del bono");
		utilidad.tomaEvidencia("Doy clic en 'Continuar'");
		marketObj.btnContinuarBono();
		marketObj.esperarVisibilidadDetalleCompraBono();
		marketObj.ingresarCorreoCompraBonoCorral();
		utilidad.tomaEvidencia("Ingresar correo electrónico y dar clic en comprar bono");
		marketObj.btnComprarBono();
		marketObj.esperarVisibilidadCompraExitosaBono();
		utilidad.tomaEvidencia("Dar clic en 'Finalizar' compra");
		marketObj.clicFinalizarCompraBono();
		utilidad.tomaEvidencia("Validé la compra");
		marketObj.validarTransaccionExitosa();
		utilidad.tomaEvidencia("Valido transaccón exitosa");
	}

	@Step("Validar descuentos")
	public void validarDescuentos() {
		marketObj.btnValidarDescuentos();
		utilidad.tomaEvidencia("Valido descuentos");

	}

	@Step("Validar aliados")
	public void validarAliados() {
		marketObj.esperarVisibilidadDeTiendaVirtual();
		marketObj.validarAliados();

	}
	
	@Step("Flujo crear negocio")
	public void crearNegocio(String nombre, String queVende, String monto, String ciudadNegocio, String casa,String correo) {
		//marketObj.ingresarMenuHamburguesa();
		menuHamburguesaPageObjects.darClickMenuHamburguesa();
		utilidad.tomaEvidencia("Ingreso Menu hamburguesa");
		utilidad.tomaEvidencia("Ingresar crear negocio");
		marketObj.ingresarCrearNegocio();
		marketObj.ingresarTerminosCondiciones();
		utilidad.tomaEvidencia("Acepte terminos y condiciones");
		utilidad.esperaMiliseg(1000);
		utilidad.tomaEvidencia("Crear negocio");
		marketObj.hacerClicBtnCrearNegocio();
		System.out.println("esperando que cargue el formulario");
		utilidad.esperaMiliseg(20000);
		System.out.println("termine de esperar que cargue el formulario");
		marketObj.ingresarNombrePerfilNegocio(nombre);
		marketObj.cerrarTeclado();
		marketObj.ingresarQueVendeNegocio(queVende);
		marketObj.cerrarTeclado();
		System.out.println("esperando que se ingrese el monto");
		marketObj.ingresarMontoPerfilNegocio(monto);
		System.out.println("termino de ingresar monto");
		marketObj.ingresarMontoPerfilNegocio(monto);
		marketObj.ingresarCiudadNegocio(ciudadNegocio);
		marketObj.cerrarTeclado();
		marketObj.elegirBtnCiudadPerfilNegocio();
		marketObj.clicTipoViaPerfilNegocio();
		marketObj.elegirTipoViaPerfilNegocio();
		utilidad.esperaMiliseg(500);
		marketObj.ingresarNumeroViaPerfilNegocio();
		utilidad.esperaMiliseg(500);
		marketObj.ingresarPrimerNumeroPlacaPerfilNegocio();
		utilidad.esperaMiliseg(500);
		marketObj.ingresarSegundoNumeroPlacaPerfilNegocio();
		utilidad.esperaMiliseg(500);
		marketObj.ingresarTipoViviendaPerfilNegocio(casa);
		marketObj.cerrarTeclado();
		marketObj.ingresarCorreoPerfilNegocio(correo);
		utilidad.tomaEvidencia("Completo el formulario requerido");
		marketObj.clicBtnCrearPerfilNegocio();
	} 
	
	@Step("Flujo ingresar perfil negocio")
	public void ingresarPerfilNegocio() {
		marketObj.ingresoPerfilNegocio();
	}
	
	@Step("Validar saldo disponible perfil negocio")
	public void validarSaldoPerfilNegocio() {
		marketObj.validoSaldoPerfilNegocio();
		utilidad.tomaEvidencia("Saldo del perfil negocio.");
	}
	
	@Step("Flujo crear negocio")
	public void validarCrearNegocio() {
		utilidad.esperaMiliseg(10000);
		marketObj.validarNegocio();
		utilidad.esperaMiliseg(800);
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
		utilidad.esperaMiliseg(2500);
        Utilidades.tomaEvidencia("Valido mi negocion en el home de la App");
	}
	
	@Step("Valido mensaje de placa invalida")
	public void validarMensajePlacaValida() {
		marketObj.validarMensajePlacaValida();
		utilidad.tomaEvidencia("Valido mensaje de placa invalida");

	}
	
	@Step("validar boton pasar plata")
	public void validarBotonPasarPlataPerfilNegocio(){
	}
	
	//**********************************************************************************************************************************************************
	
	
	public void validoScrollHorizontalCategorias() {
		marketObj.validarPrimerElementoCategorias();
		utilidad.esperaMiliseg(2000);
		marketObj.darClickBtnScrollCategorias();
		utilidad.tomaEvidencia("Di click al boton del scroll hasta el final");
		utilidad.esperaMiliseg(2000);
		marketObj.validarUltimoElementoCategorias();
		utilidad.tomaEvidencia("Valide el ultimo elemento de la barra de navegacion");
		utilidad.tomaEvidencia("Valido correctamente el scroll tanto a la derecha como a la izquierda");
	}
	
	public void completoFlujoComprarVestuario() {
		marketObj.irAVestuario();
		marketObj.clickBtnVestuario();
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Localicé la tienda Seven Seven");
		marketObj.darClickBtnSevenSeven();
		utilidad.esperaMiliseg(5000);
		utilidad.tomaEvidencia("Ingrese a Seven Seven");
		marketObj.clickBtn50K();
		marketObj.btnContinuarGeneral();
		marketObj.txtCorreo();
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Di click al boton Continuar");
		marketObj.btnComprarBono();
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Di click al boton Comprar");
		marketObj.txtValidarCompra();
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Validé la compra");
		marketObj.btnFinalizar();
		marketObj.btnFinalizar();
		utilidad.esperaMiliseg(2000);
		marketObj.btnVolver();
		utilidad.esperaMiliseg(2000);
		marketObj.capturarSaldoFinal();
	}
	
	public void completoFlujoComprarCine() {
		utilidad.esperaMiliseg(15000);
		marketObj.irACines();
		marketObj.clickBtnCines();
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Localicé el cine Cinemark");
		marketObj.darClickBtnCineCinemark();
		utilidad.esperaMiliseg(8000);
		utilidad.tomaEvidencia("Ingrese a CineMark");
		marketObj.darClickEntrada2D();
		utilidad.tomaEvidencia("Di click al bono de entrada para cine");
		marketObj.btnContinuarGeneral();
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("lleno correo");
		marketObj.txtCorreo();
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Di click al boton Continuar");
		marketObj.btnComprarBono();
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Di click al boton Comprar");
		marketObj.txtValidarCompra();
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Validé la compra");
		marketObj.btnFinalizar();
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Finalicé la compra");
		marketObj.btnFinalizar();
		utilidad.esperaMiliseg(2000);
		marketObj.btnVolver();
		utilidad.esperaMiliseg(5000);
		utilidad.tomaEvidencia("Capturo saldo final");
		marketObj.capturarSaldoFinal();
	}
	
	public void darClickBtn(String categoria) {
		marketObj.darClickBtn(categoria);
		utilidad.tomaEvidencia("Ingrese a " + categoria);
		}
	
	public void realizarScroll(String categoria) {
		utilidad.esperaMiliseg(10000);
		try {
			contador++;
			if(categoria.contains("Restaurantes") || categoria.contains("Recargas") || categoria.contains("Vestuario") || categoria.contains("Salud") || categoria.contains("Servicios hogar")) {
				utilidad.moverPantalla(822, 1907, 84, 1907);
				System.out.println("Realicé scroll correctamente para localizar: " + categoria);
			}else if(categoria.contains("Cines") || categoria.contains("Otros") || categoria.contains("Mercado") || categoria.contains("Seguros") ) {
				utilidad.moverPantalla(822, 1907, 84, 1907);
				utilidad.moverPantalla(822, 1907, 84, 1907);
				System.out.println("Realicé scroll correctamente para localizar: " + categoria);
			}else {
				System.out.println("No entré");
				System.out.println(categoria);
			}
		
		}catch (Exception e) {
			if(!(contador==20)) {utilidad.esperaMiliseg(2000);realizarScroll(categoria);
			}else {fail("No pude realizar scroll a " + categoria + " debido a: "+e.getMessage());}
		}finally {contador=0;}
	
	}
	
	public void flujoValidarBtnDescarga() {
		utilidad.scrollHastaElemento("Bonos genéricos");
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Localicé la tienda Seven Seven");
		marketObj.darClickBtnSevenSeven();
		utilidad.esperaMiliseg(5000);
		utilidad.tomaEvidencia("Ingrese a Seven Seven");
		utilidad.darUnTap(269, 859);
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Di click al bono de 50.000");
		int valorBono = marketObj.returnValorBono();
		Serenity.setSessionVariable("valorBono").to(valorBono);
		utilidad.esperaMiliseg(500);
		System.out.println("El valor del bono es: " + valorBono);
		marketObj.btnContinuarGeneral();
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Di click al boton Continuar");
		marketObj.btnComprarBono();
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Di click al boton Comprar");
		marketObj.txtValidarCompra();
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Validé la compra");
		marketObj.validarBtnDescarga();
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Ingrese a realizar la descarga");
		utilidad.esperaMiliseg(20000);
		utilidad.tomaEvidencia("Documento descargado");
	}
	
	
	public void flujoValidarBtnCompartir() {
		utilidad.scrollHastaElemento("Bonos genéricos");
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Localicé la tienda Seven Seven");
		marketObj.darClickBtnSevenSeven();
		utilidad.esperaMiliseg(5000);
		utilidad.tomaEvidencia("Ingrese a Seven Seven");
		utilidad.darUnTap(269, 859);
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Di click al bono de 50.000");
		int valorBono = marketObj.returnValorBono();
		Serenity.setSessionVariable("valorBono").to(valorBono);
		utilidad.esperaMiliseg(500);
		System.out.println("El valor del bono es: " + valorBono);
		marketObj.btnContinuarGeneral();
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Di click al boton Continuar");
		marketObj.btnComprarBono();
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Di click al boton Comprar");
		marketObj.txtValidarCompra();
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Validé la compra");
		marketObj.validarBtnCompartir();
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Ingrese al btn compartir");
		utilidad.esperaMiliseg(20000);
		utilidad.tomaEvidencia("Ingrese al menú para compartir");
	}
	
	
	public void validacionSaldoTransacciones() {
		marketObj.btnVolver();
		utilidad.esperaMiliseg(8000);
		marketObj.capturarSaldoFinal();
		marketObj.validarSaldosTransacciones();
	}
	public void llenarAutorizadoresTest() {
		marketObj.llenarAutorizadoresTest();
	}
	
	public void validarTerminosCondicionesTiendaVirtual() {
		//marketObj.validarPopUpTerminosCondicionesMarketplace();
		//utilidad.tomaEvidencia("Validar popUp términos y condiciones de tienda virtual");
		utilidad.esperaMiliseg(1500);
		utilidadesTCS.clicElement("xpath", MarketPlacePageObjects.BTN_OPCION_BONO_BURGUER);
		utilidad.esperaMiliseg(1500);
		utilidad.tomaEvidencia("Valido características del bono");
		utilidad.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath", MarketPlacePageObjects.BTN_CONTINUAR_BONO);
		utilidad.esperaMiliseg(1500);
		utilidad.tomaEvidencia("Verifico detalles de compra");
		utilidadesTCS.clicElement("xpath", MarketPlacePageObjects.BTN_COMPRAR);
		utilidad.esperaMiliseg(1500);
		utilidad.tomaEvidencia("Valido compra realizada");
		utilidadesTCS.clicElement("xpath", MarketPlacePageObjects.BTN_FINALIZAR);
		utilidad.esperaMiliseg(1500);
		utilidad.tomaEvidencia("Verifico la transacción exitosa");
		utilidadesTCS.clicElement("xpath", MarketPlacePageObjects.BTN_FINALIZAR);
	}
	
	public void clicOpcionPagar() {
		marketObj.clickBtnMas();
		//marketObj.ingresarAlBotonOpcionesHome();
		utilidad.tomaEvidencia("Clic botón pagos");
		utilidadesTCS.clicElement("xpath", MarketPlacePageObjects.TIENDA_VIRTUAL);
		//marketObj.ingresarOpcionPagarTiendaVirtual();
	}

	public void validarPestañaPagos() {
		System.out.println("esperando que carguen los servicios");
		utilidad.esperaMiliseg(25000);
		System.out.println("cargaron los servicios");
		marketObj.validarPestañaPagosServicios();
		utilidad.tomaEvidencia("Validar pestaña pago de servicios");		
	}
	
	public void ingresarOpcionRecargas() {
		//marketObj.clickBtnMas();
		//marketObj.ingresarAlBotonOpcionesHome();
		utilidad.tomaEvidencia("Clic botón recargas de tienda virtual");
		marketObj.ingresarOpcionRecargasTiendaVirtual();
		
		
	}
	
	public void validarPestañaRecargasTiendaVirtual() {
		System.out.println("esperando que carguen los servicios");
		utilidad.esperaMiliseg(35000);
		System.out.println("cargaron los servicios");
		marketObj.validarPestañaRecargas();
		utilidad.tomaEvidencia("Validar pestaña recargas");
		
		
	}
	
	public void validarNoAparezcaTyCMarketPlace() {
		marketObj.validarNoAparezcaPopUpTerminosCondicionesMarketplace();
		utilidad.tomaEvidencia("Validar no aparezca popUp terminos y condiciones de marketplace");
	}
	
	public void comprarProductoDeLosAliados() {
		utilidad.esperaMiliseg(5000);
		marketObj.ingresarARestaurantes();
		utilidad.esperaMiliseg(4000);
		utilidadesTCS.scrollBackground("xpath", MarketPlacePageObjects.BTN_HAMBURGUESA, 0, -360);
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Ingreso a comprar productos en nuestros aliados");
		utilidadesTCS.clicElement("xpath", MarketPlacePageObjects.BTN_HAMBURGUESA);
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Opción cupón hamburguesa");
		//marketObj.ingresarBonoHamburguesas();
	}
	
	public void aceptarTerminosCondicionesTiendaVirtual() {
		utilidad.tomaEvidencia("Aceptar terminos y condiciones de tienda virtual");
		marketObj.aceptarTerminosCondicionesTiendaVirtual();
		utilidad.esperaMiliseg(20000);
		marketObj.btnVolver();
		utilidad.tomaEvidencia("Ingresar nuevamente a tienda virtual");
		marketObj.btnMarketPlace();
		
	}
	
	public void validarBonoEnCampanaNotificaciones() {
		utilidad.esperaMiliseg(8000);
		utilidad.tomaEvidencia("Ingresar a campana de notificaciones");
		homePageObjects.darClickCampanaNotificaciones();
		loginPageObjects.btnCompras();
		utilidad.tomaEvidencia("Seleccionar notificacion de bono");
		marketObj.validarBonoCorral();
		utilidad.esperaMiliseg(5000);
		utilidad.tomaEvidencia("Validar bono en campana de notificaciones del cliente");
		
	}
	
	@Step
	public void validarCompraBonoMcDonals() {
		utilidad.tomaEvidencia("Ingreso a notificaciones");
		marketObj.btnCampana();
		utilidad.tomaEvidencia("Compras tienda virtual");
		marketObj.btnComprasTiendaVirtual();
		marketObj.txtValidarCompraCampanaCorral();
		utilidad.tomaEvidencia("Valido la compra");

	}
	
	@Step
	public void validarFranjaAliadosEnLaMitad() {
		utilidad.esperaMiliseg(15000);
		marketObj.validarFranjaAliadosPosicionEnLaMitad();
		utilidad.tomaEvidencia("La franja de aliados se encuentra en la mitad de la pantalla");

	}
	
	@Step
	public void validarCategoriasAliadosAlHacerTap() {
		marketObj.tapFranjaNuestroAliados();
		marketObj.validarPantallaCategorias();
		utilidad.tomaEvidencia("Validar franja con sus categorías");

	}
	
	public void comprarBono() {
		utilidad.esperaMiliseg(2000);
		utilidad.scrollDownSwipe(1);
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Localicé la tienda Seven Seven");
		marketObj.darClickBtnSevenSeven();
		utilidad.esperaMiliseg(5000);
		utilidad.tomaEvidencia("Ingrese a Seven Seven");
		utilidad.darUnTap(269, 859);
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Di click al bono de 50.000");
		int valorBono = marketObj.returnValorBono();
		Serenity.setSessionVariable("valorBono").to(valorBono);
		utilidad.esperaMiliseg(500);
		System.out.println("El valor del bono es: " + valorBono);
		marketObj.btnContinuarGeneral();
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Di click al boton Continuar");
		marketObj.btnComprarBono();
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Di click al boton Comprar");
		marketObj.txtValidarCompra();
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Validé la compra");
		marketObj.btnFinalizar();
		marketObj.btnFinalizar();
	}
	
	@Step("Flujo de compra de bono")
	public void ingresarBono() {
		utilidad.esperaMiliseg(4000);
		utilidad.tomaEvidencia("Ingreso a categoria 'Todos'");
		System.out.println("Ingreso a categoria 'Todos'");
		marketObj.btnTodos();
		utilidad.esperaMiliseg(1000);
		utilidad.scrollDownSwipe(3);
		utilidad.tomaEvidencia("Ingreso al corral");
		marketObj.btnCorral();
		utilidad.esperaMiliseg(1000);
		marketObj.esperarVisibilidadBtnBono20k();
		utilidad.tomaEvidencia("Bono");
		marketObj.btnBono20k();
		utilidadesTCS.scrollBackground("xpath", MarketPlacePageObjects.TXT_EL_CORRAL, 0, -250);
//		marketObj.esperarVisibilidadBonoCompraCorral();
		utilidad.esperaMiliseg(1000);
		marketObj.btnContinuarBono();
		marketObj.esperarVisibilidadDetalleCompraBono();
//		marketObj.ingresarCorreoCompraBonoCorral();
		utilidad.tomaEvidencia("Ingresar correo electrónico y dar clic en comprar bono");
		marketObj.btnComprarBono();
		utilidad.esperaMiliseg(10000);
        boolean visibleCampoOtp = utilidadesTCS.validateElementVisibilityCatch("xpath", MarketPlacePageObjects.POPUP_SU_COMPRA_NO_PUDO_SER_PROCESADA);
        if(visibleCampoOtp) {
    		utilidad.tomaEvidencia("Su compra no pudo ser procesada");
        	utilidadesTCS.clicElement("xpath", MarketPlacePageObjects.BTN_CONTINUAR_BONO);;
        } else {
        	marketObj.esperarVisibilidadCompraExitosaBono();
    		utilidad.tomaEvidencia("Dar clic en 'Finalizar' compra");
    		marketObj.clicFinalizarCompraBono();
    		utilidad.tomaEvidencia("Validé la compra");
    		marketObj.validarTransaccionExitosa();
    		utilidad.tomaEvidencia("Valido transaccón exitosa");
    		marketObj.btnFinalizar();
        }
		marketObj.btnVolver();
		boolean estadoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.POP_UP_INVITE_AMIGOS);
		if(estadoVisible == true) {
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_CLOSE);
		}
		utilidad.esperaMiliseg(2000);
		marketObj.capturarSaldoFinal();
	}
	
	@Step
	public void validarOpcionesCompartirDescargarBono() {
		marketObj.clicBotonCompartirBono();
		utilidad.esperaMiliseg(6000);
		utilidad.tomaEvidencia("Valido opción compartir de compra de bono");
		marketObj.clicBotonCerrarVentanaCompartirBono();
		marketObj.clicBotonDescargaBono();
		marketObj.validarDescargaBono();
		utilidad.tomaEvidencia("Valido opción compartir de compra de bono");
	}


	

}