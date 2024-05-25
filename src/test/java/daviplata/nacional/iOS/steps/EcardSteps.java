package daviplata.nacional.iOS.steps;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Assert;

import daviplata.nacional.iOS.utilidades.BaseUtil;
import daviplata.nacional.iOS.utilidades.Credenciales;
import daviplata.nacional.iOS.definitions.Hooks;
import daviplata.nacional.iOS.pageObjects.EcardPageObject;
import daviplata.nacional.iOS.pageObjects.HomePageObjects;
import daviplata.nacional.iOS.pageObjects.LoginPageObjects;
import daviplata.nacional.iOS.pageObjects.LoginRobustoPage;
import daviplata.nacional.iOS.pageObjects.MarketPlacePageObjects;
import daviplata.nacional.iOS.pageObjects.MenuHamburguesaPageObjects;
import daviplata.nacional.iOS.pageObjects.NanocreditoPageObjects;
import daviplata.nacional.iOS.pageObjects.PasarPlataPageObjects;
import daviplata.nacional.iOS.pageObjects.RecargaPageObjects;
import daviplata.nacional.iOS.pageObjects.WebLatiniaPageObject;
import daviplata.nacional.iOS.utilidades.Utilidades;
import daviplata.nacional.iOS.utilidades.UtilidadesTCS;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import net.bytebuddy.asm.Advice.This;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

public class EcardSteps {
    
	HomePageObjects pageHome;
	EcardPageObject pageEcard;
	static Utilidades utilidad;
	static Utilidades Utilidades;
	static NanocreditoPageObjects nanoCreditoPageObjects;
	LoginPageObjects pageLogin;
	WebLatiniaPageObject pageLatinia;
	BigDecimal saldoInicialTarjeta;
	BigDecimal saldoFinalTarjeta;
	BigDecimal saldoInicial;


	BigDecimal saldoFinal;
	BigDecimal valorAConsignar;
	BigDecimal valorExtra;
	BigDecimal valorHome = null;
	BigDecimal valorTotal = null;
	BigDecimal valorBolsillo = null;
	BigDecimal valorTransferencia = null;

	private AppiumDriver<MobileElement> driver = Hooks.getDriver();
	private String numAutorizador;
	public static String horaTxEcard;
	PasarPlataPageObjects pagePasarPlata;
	BaseUtil base;
	UtilidadesTCS utilidadesTCS;
	MarketPlacePageObjects marketPlacePageObjects;

	public void ingresoATarjetaDeCredito(boolean verificador) {
		// pageHome.darClickEnTarjetaVirtual();
		saldoInicialTarjeta = pageHome.capturarSaldoInicial();
		if (verificador) {
			utilidad.tomaEvidencia("Saldo Inicial");
		}
		// pageHome.capturarSaldoInicial();
		pageHome.darClickEnTarjetaVirtual();
	}

	public void clickEcard() {
		utilidad.tomaEvidencia("Saldo Inicial");
		pageHome.darClickEnTarjetaVirtual();
	}

	public void creoTarjetaVirtual() {
		pageEcard.verificoVisualizacionTextoElClienteNoTieneEcard();
		pageEcard.verificoQueElClienteNoTengaEcard();
		utilidad.tomaEvidencia("Cliente Sin Tarjeta Virtual.");
		utilidad.esperaMiliseg(1000);
		pageEcard.doyClickEnContinuar();
		pageEcard.aceptoTerminos();
		utilidad.tomaEvidencia("Aceptando terminos y condiciones.");
		utilidad.esperaMiliseg(1000);
		pageEcard.doyClickEnCrear();

	}
	public void validarTerminosYCondiciones() {
		pageEcard.verificoQueElClienteNoTengaEcard();
		utilidad.tomaEvidencia("Cliente Sin Tarjeta Virtual.");
		utilidad.esperaMiliseg(1000);
		pageEcard.doyClickEnContinuar();
		pageEcard.aceptoTerminosYCondiciones(); 
		utilidad.esperaMiliseg(5);
		utilidad.tomaEvidencia("Valido terminos y condiciones");
		
	}
	
	public void ingresoMenuHamburguesa(){
		pageLogin.darClickEnMenuHamburguesa();
		utilidad.esperaMiliseg(2000);
		utilidad.tomaEvidencia("Ingresar y seleccionar tarjeta virtual desde menu hamburguesa");
		pageEcard.clicTarjetaVirtual();
		
	}

	public void validoCreacionSinRecarga() {
		utilidad.esperaMiliseg(10000);
		pageEcard.validoAparicionMensajeTarjetaCreada();
		pageEcard.validoCreacion();
		utilidad.tomaEvidencia("Tarjeta Virtual Creada.");
		pageEcard.doyClickEnCerrar();
		utilidad.esperaMiliseg(4000);
		pageEcard.doyClickEnVolver();
		utilidad.esperaMiliseg(3000);
		utilidad.tomaEvidencia("Tarjeta virtual habilitada.");
	}

	public void validoCreacionConRecarga() {
		utilidad.esperaMiliseg(10000);
		pageEcard.validoCreacion();
		utilidad.tomaEvidencia("Tarjeta Virtual Creada.");
		utilidad.esperaMiliseg(1000);
		pageEcard.doyClickEnRecargar();
//		4155600
//		pagos@progreser.com
	}
	
	public void validoRecargaRestringida() {
		pageEcard.validoRecargaRestringida();
		utilidad.tomaEvidencia("Pop recarga restringida");
	}
	
	public void validoMensajeTope() {
		pageEcard.validoRecargaTopeRestringido();
		utilidad.tomaEvidencia("Valido mensaje de tope en recarga de tarjeta virtual");
	}

	public void recargoTarjeta(String montoSeleccionable) {
		pageEcard.ingresarValorRecarga(montoSeleccionable);
		utilidad.tomaEvidencia("Doy en continuar");
		pageEcard.doyClickEnContinuar();
		utilidad.tomaEvidencia("PopUp informativo de recarga");
		utilidad.esperaMiliseg(1000);
		pageEcard.doyClickEnAceptar();
	}
	public void recargoTarjetaMontoDiferente(String monto) {
		pageEcard.doyClickEnRecargarEcardHome();
		pageEcard.montoTarjetaParaRecargar(monto);
		utilidad.tomaEvidencia("Ingresar monto");
		pageEcard.doyClickEnContinuar();
		utilidad.tomaEvidencia("PopUp informativo de recarga");
		utilidad.esperaMiliseg(1000);
		pageEcard.doyClickEnAceptar();
	}

	public void verificoMensajeBloqueoSegundaVez() {
		utilidad.tomaEvidencia("Valido el mensaje de bloqueo por segunda vez");
		pageEcard.validoMensajeBloqueoSegundaVez();
		pageEcard.btnBloquear();
		//pageEcard.btnClose();
	}

	public void recargoTarjetaFondoInsuficiente(String montoSeleccionable) {
		pageEcard.ingresarMonto(montoSeleccionable);
		pageEcard.doyClickEnContinuar();
	}

	public void validoRecargaExitosa() {
		pageEcard.verificoTransaccionExitosa();
		pageEcard.verificoValoresDeLaTransaccion();
		utilidad.tomaEvidencia("Resultado Transacción");
		pageEcard.doyClickEnContinuar();
		pageEcard.doyClickEnVolver(); 
		boolean estadoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.POP_UP_INVITE_AMIGOS);
		if(estadoVisible == true) {
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_CLOSE);
		}
		pageHome.capturarSaldoFinal();

	}

	public void seleccionoRecargar() {
		//pageEcard.cerrarAlertEcard();
		utilidad.tomaEvidencia("Selecciono en recargar");
		pageEcard.doyClickEnRecargarEcardHome();
		//pageEcard.doyClickMSGTarjetaBloqueada();
		
		
	}
	
	public void seleccionoRecargarTarjeta() {
		utilidad.tomaEvidencia("Selecciono en recargar");
		pageEcard.doyClickEnRecargarEcardHome();
		
	}
	
	public void seleccionoRecargarHome() {
		utilidad.tomaEvidencia("Selecciono en recargar");
		pageEcard.doyClickEnRecargarEcardHome();
		
	}

	public void validoRecargaNegada() {
		pageEcard.validoRecargaNegada();
		utilidad.tomaEvidencia("Recarga negada.");
		utilidad.esperaMiliseg(1000);
	}

	public void validoNoAlcanzaPlata(int repeticiones) {
		pageEcard.validoLblNoAlcanzaPlata();
		pageHome.clickBotonAtras(repeticiones);
		pageHome.darClickEnActualizarSaldo();
		utilidad.tomaEvidencia("Valido no haya descuento del home");
		pageHome.capturarSaldoFinal();
		utilidad.validacionDeSaldos();
	}

	public void clickImagenTarjeta() {
		Utilidades.esperaMiliseg(2000);
		utilidad.tomaEvidencia("Selecciono Tarjeta eCard");
		pageEcard.pulsarBtnImagenTarjeta();
		Utilidades.esperaMiliseg(4000);
		utilidad.tomaEvidencia("Datos tarjeta eCard");
	}
	
	public void validarCvv(String numCel) {
		try {
			

		pageLatinia.initDriverLatinia();
		pageLatinia.clicBtnContinuar(); 
		pageLatinia.ingresarEmpresa();
		pageLatinia.ingresarUsuario();
		pageLatinia.ingresarPassword();
		utilidad.tomaEvidenciaPantalla("web-Ingreso a Latinia");
		pageLatinia.darClickAcceder();
		pageLatinia.darClickBtnActualizar();
		String numero=pageLatinia.traeCvv(numCel);
		utilidad.tomaEvidenciaPantalla("web-Encuentro el cvv con el numero de celular "+ numCel+ " y el otp es "+ numero);
		System.out.println(numero);
		} catch (Exception e) {
			//pageLatinia.cerrarLatinia();
		}
	}

	public void clickBotonVerDatosTarjeta() {
		Utilidades.esperaMiliseg(2000);
		utilidad.tomaEvidencia("Visualizacion boton 'Ver Datos Tarjeta'");
		pageEcard.pulsarBtnVerDatosTarjeta();
		Utilidades.esperaMiliseg(4000);
		utilidad.tomaEvidencia("Datos Tarjeta");
	}

	public void validoDatosTarjeta() {
		Utilidades.esperaMiliseg(1500);
		boolean valida = false;
		String txtNumero = pageEcard.obtenerTxtNumeroTarjeta();
		String txtNombre = pageEcard.obtenerTxtNombreTarjeta();
		String txtFechaExp = pageEcard.obtenerTxtFechaExpiraTarjeta();
		System.out.println("txtNumero: " + txtNumero);
		System.out.println("txtNombre: " + txtNombre);
		System.out.println("txtFechaExp: " + txtFechaExp);
		if (txtNumero.length() != 0 && txtNombre.length() != 0 && txtFechaExp.length() != 0)
			valida = true;
		assertTrue(valida);
		utilidad.tomaEvidencia("Datos tarjeta");
	}

	public void seleccionoMovimientosTarjeta() {
		Utilidades.esperaMiliseg(2000);
		utilidad.tomaEvidencia("Visualizacion boton 'Movimientos Tarjeta'");
		pageEcard.pulsarBtnMovimientos();
	}

	public void visualizacionMovimientos() {
		Utilidades.esperaMiliseg(2000);
		pageEcard.obtenerMovimientosTarjeta();
		utilidad.tomaEvidencia("Visualizacion Movimientos Tarjeta");
	}

	public void seleccionoBloquearTarjeta() {
		Utilidades.esperaMiliseg(500);
		pageEcard.pulsarBtnBloquearTarjeta();
		utilidad.tomaEvidencia("Aceptar bloqueo tarjeta");
		pageEcard.pulsarAceptarPopUpBloquear();
		pageEcard.pulsarFinalizarBloqueo();
		utilidad.tomaEvidencia("Tarjeta bloqueada");
	}
	
	public void seleccionoBloquearTarjetaHM() {
		Utilidades.esperaMiliseg(2000);
		pageEcard.pulsarBtnBloquearTarjeta();
		utilidad.tomaEvidencia("Aceptar bloqueo tarjeta");
		pageEcard.pulsarAceptarPopUpBloquear();
		pageEcard.pulsarFinalizarBloqueo();
		utilidad.esperaMiliseg(50000);
		utilidad.tomaEvidencia("Tarjeta bloqueada");
	}
	public void seleccionoBloquearTarjetaSegundaVez() {
		Utilidades.esperaMiliseg(2000);
		utilidad.tomaEvidencia("Pulsar en bloquear tarjeta");
		pageEcard.pulsarBtnBloquearTarjeta();
		
	}
	
	public void validoBloqueoTarjeta() {
		String textoBloqueoTarjeta = utilidadesTCS.obtenerTexto("xpath", EcardPageObject.txtRestringida);
		utilidadesTCS.validateTextContainsString(textoBloqueoTarjeta, "Tarjeta crédito bloqueada");
		
	}
	
    public void ingresarOpcionTarjetaVirtual() {
    	utilidad.tomaEvidencia("Dar clic en botón usar plata");
    	pageEcard.irOpcionUsarPlata();
    	utilidad.tomaEvidencia("Dar clic en botón tarjeta virtual");
    	pageEcard.irOpcionTarjetaVirtual();
	}
    
    public void recargarTarjetaVirtual() {
    	utilidad.esperaMiliseg(4000);
    	utilidad.tomaEvidencia("Click En Recargar Tarjeta");
    	pageEcard.doyClickEnRecargarEcardHome();
    	pageEcard.recargarEcard();
    	utilidad.tomaEvidencia("Click En check box de monto en Tarjeta");
    	pageEcard.doyClickEnCrear();
    	utilidad.tomaEvidencia("Aceptar PopUp de recarga");
    	pageEcard.doyClickEnRecargar();
	}
    
    public void validarMensajeCupo() {
    	pageEcard.validarMensajeSuperoCupo();
    	utilidad.tomaEvidencia("Validación mensaje de supero cupo en recarga Ecard");
	}
    
    public void recargarTarjetaVirtualSinDisponible() {
    	utilidad.tomaEvidencia("Click En Recargar Tarjeta");
    	pageEcard.doyClickEnRecargarEcardHome();
    	BigDecimal saldoTotal = Serenity.sessionVariableCalled("saldoReal");
    	String convertirString = String.valueOf(saldoTotal);
    	convertirString = convertirString.replace(",", "").replace(".", "").replace("'", "");
		BigDecimal valorTotal = new BigDecimal(convertirString);
		String valorSuperior = valorTotal.add(new BigDecimal(2)).toBigInteger().toString();
    	pageEcard.montoTarjetaParaRecargar(valorSuperior);
    	utilidad.tomaEvidencia("Recargar Tarjeta fondo insuficiente");
    	pageEcard.doyClickEnContinuar();
    }
    
    public void validarMensajeSaldoInsuficiente() {
    	pageEcard.validarMensajeSaldoInsuficiente();
    	utilidad.tomaEvidencia("Validar mensaje de saldo insuficiente");
    	pageEcard.cerrarPopUpFondosInsuficientesEcard();
    	pageEcard.clicBotonAtrasEcard();
    	pageEcard.clicBotonAtrasEcard();
    	utilidad.esperaMiliseg(4000);
    	boolean estadoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.POP_UP_INVITE_AMIGOS);
		if(estadoVisible == true) {
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_CLOSE);
		}
		pagePasarPlata.capturarSaldoFinal();
		utilidad.tomaEvidencia("Saldo Final " + base.saldoFinal);


    }
    
    public void validarRecarga() {
    	pageEcard.verificoTransaccionExitosa();
    	utilidad.tomaEvidencia("Validación de recarga exitosa");
	}
    
    public void tarjetaVirtualEnElMenuHamburguesa() {
    	utilidad.tomaEvidencia("Dar clic en el menu hamburguesa");
    	pageLogin.darClickEnMenuHamburguesa();
    	utilidad.tomaEvidencia("Dar clic en botón usar plata");
    	pageEcard.irOpcionUsarPlata();
    	pageEcard.validarLinkTarjetaVirtual();
    	utilidad.tomaEvidencia("Validar link de tarjeta virtual");
	}
    
    public void validarSaldoEcard() {
    	pageEcard.validarSaldoRecargadoEnEcard();
    	utilidad.tomaEvidencia("Validacion de saldo en la tarjeta virtual");
    }
    
    public void validarCVVEcard(String numeroCelularDaviplata) {
		nanoCreditoPageObjects.abrirConsultaNotificaciones();
		nanoCreditoPageObjects.sendKeysInputNumeroCelular(numeroCelularDaviplata);	
		nanoCreditoPageObjects.sendKeysInputHora();
		utilidad.tomaEvidenciaPantalla("Diligenciar número del daviplata y hora");
		nanoCreditoPageObjects.clicBtnSubmitNotificacionesNano();
		nanoCreditoPageObjects.capturarOtpCVVNotificaciones();
		utilidad.tomaEvidenciaPantalla("Validar CVV de tarjeta virtual generado");
		nanoCreditoPageObjects.cerrarWebNotificaciones();
	}
    
    
    
    @Step
    public void validarMensajeDeTopes() {
    	String mensajeTopes = utilidadesTCS.obtenerTexto("xpath", EcardPageObject.MENSAJE_TOPES_TARJETA_VIRTUAL);
    	utilidadesTCS.validateTextContainsString(mensajeTopes, "Valor invalido");
    	utilidad.tomaEvidencia("Validar mensaje de topes en tarjeta virtual");
    }
    
    @Step
    public void ingresarAEcard() {
    	utilidadesTCS.clicElement("xpath", EcardPageObject.BOTON_TARJETA_VIRTUAL);
        //pageHome.darClickEnTarjetaVirtual();
    	utilidad.esperaMiliseg(2000);
        utilidadesTCS.esperarElementVisibility("xpath", EcardPageObject.TEXTO_TARJETA_VIRTUAL_MODULO);
        utilidad.tomaEvidencia("Ingreso al modulo de tarjeta virtual");        
    }
    
    @Step
    public void ingresarATiendaVirtual() {
        utilidad.tomaEvidencia("Hacer clic en cajon de tienda virtual");
        utilidadesTCS.clicElement("xpath", EcardPageObject.BOTON_TIENDA_VIRTUAL);
        utilidadesTCS.esperarElementVisibility("xpath", EcardPageObject.TEXTO_TIENDA_VIRTUAL_MODULO);
        utilidad.tomaEvidencia("Ingreso al modulo de tienda virtual");
    }
}
