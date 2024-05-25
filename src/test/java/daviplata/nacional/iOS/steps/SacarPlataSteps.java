package daviplata.nacional.iOS.steps;

import java.math.BigDecimal;

import cucumber.api.Scenario;
import daviplata.nacional.iOS.definitions.Hooks;
import daviplata.nacional.iOS.pageObjects.HomePageObjects;
import daviplata.nacional.iOS.pageObjects.LoginPageObjects;
import daviplata.nacional.iOS.pageObjects.LoginRobustoPage;
import daviplata.nacional.iOS.pageObjects.MovimientoFuncionalPageObjects;
import daviplata.nacional.iOS.pageObjects.SacarPlataPageObjects;
import daviplata.nacional.iOS.utilidades.Utilidades;
import daviplata.nacional.iOS.utilidades.UtilidadesTCS;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import net.thucydides.core.annotations.Step;

public class SacarPlataSteps {
	HomePageObjects pageHome;
	SacarPlataPageObjects pageSacarPlata;
	private static LoginPageObjects pageLogin;
	BigDecimal valorHome = null;
	BigDecimal valorTransferencia = null;
	private Scenario scenario = Hooks.scenario;
	private AppiumDriver<MobileElement> driver = Hooks.getDriver();
	Utilidades utilidad;
	UtilidadesTCS utilidadesTCS;

	public void seleccionarModuloSacarPlata() {
		pageHome.capturarSaldoInicial();
		pageHome.darClickEnBotonMas();
		utilidad.tomaEvidencia("Ingreso a modulo Sacar Plata");
		utilidadesTCS.clicElement("xpath", HomePageObjects.SACAR_PLATA_MODULO_BTN );
//		pageHome.darClickEnSacarPlata();
	}

	public void diligenciarSacarPlataSeleccionable() {
		pageSacarPlata.seleccionoMonto();
		utilidad.tomaEvidencia("Monto seleccionado");
		pageSacarPlata.capturoMonto();
		pageSacarPlata.darClickEnAceptar();
	}

	public void confirmoDatosDiligenciados() {
		pageSacarPlata.capturoMontoConfirmacion();
		utilidad.tomaEvidencia("Confirmacion de Datos");
		pageSacarPlata.darClickEnContinuar();
	}

	public void validoGeneracionDeOTP() {
		pageSacarPlata.validoQueSeGenereLaOTP();
		utilidad.tomaEvidencia("Generacion de OTP Exitosa");
		pageSacarPlata.darClickFinalizar();
		boolean estadoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.POP_UP_INVITE_AMIGOS);
		if(estadoVisible == true) {
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_CLOSE);
		}
		Utilidades.esperaMiliseg(1000);
        utilidadesTCS.esperarElementVisibility("xpath", MovimientoFuncionalPageObjects.BOTON_ATRAS_MOVIMIENTOS);
        utilidadesTCS.clicElement("xpath", MovimientoFuncionalPageObjects.BOTON_ATRAS_MOVIMIENTOS);     
	}
	
	public void validoFondosInsuficientes() {
		pageSacarPlata.validoQueSeGenereSaldoInsuficiente();
		utilidad.tomaEvidencia("Excede cupo");
	}

	public void verificoSaldos() {
		//pageHome.darClickEnActualizarSaldo();
		//pageHome.capturarSaldoFinal();
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("Saldo Final");
		//pageHome.validacionDeSaldos();
	}

	public void diligenciarSacarPlataMontoDiferente(String montoATransar) {
		pageSacarPlata.ingresarMonto(montoATransar);
	//	utilidad.ocultarTeclado();
		pageSacarPlata.darClickBtnTecladoAceptar();
		utilidad.tomaEvidencia("Monto a diferente a Transar");
		utilidad.esperaMiliseg(500);
		pageSacarPlata.darClickEnAceptar();
	}
	
	public void pulsarContinuar() {
		pageSacarPlata.darClickEnContinuar();
	}
	
	public void mensajeExcedeCupo() {
		pageSacarPlata.mensajeExcedeCupo();
	}

	public void validoValorErrado() {
		pageSacarPlata.validoValorErrado();
		utilidad.tomaEvidencia("Monto errado");
	}
	
	public void volverCapturarSaldofinal() {
		pageSacarPlata.cerrarAlerta();
		pageSacarPlata.botonAtras();
		pageSacarPlata.botonAtras();
		pageSacarPlata.clickBotonX();
		utilidad.esperaMiliseg(2000);
		utilidad.tomaEvidencia("capturo saldo final");
		pageHome.capturarSaldoFinal();
	}
	
	public void validoExcedeCupo() {
		pageSacarPlata.validoLblExcedeCupo();
		pageHome.clickBotonAtras(2);
		//pageHome.darClickEnActualizarSaldo();
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("Valido no haya descuento del home");
		utilidad.validacionDeSaldos();
		utilidad.esperaMiliseg(2000);

	}
	
	public void diligenciarSacarPlataSeleccionable(String monto) {
		pageSacarPlata.seleccionoMonto(monto);
		utilidad.tomaEvidencia("Monto seleccionado");
		pageSacarPlata.darClickEnAceptar();
		utilidad.esperaMiliseg(2000);
		utilidad.tomaEvidencia("Confirmación de datos");
		pulsarContinuar();
		pageSacarPlata.cerrarPopUpProgramacionRetiro();
	}
	
	public void ingresarMontoDiferente(String montoATransar) {
		pageSacarPlata.ingresarMonto(montoATransar);
		utilidad.tomaEvidencia("Monto ingresado");
		pageSacarPlata.darClickEnAceptar();
		pageSacarPlata.darClickEnAceptar();
	}
	
	public void ingresarMontoDiferenteFondosInsuficientes(String montoATransar) {
		pageSacarPlata.ingresarMonto(montoATransar);
		utilidad.tomaEvidencia("Monto ingresado");
		pageSacarPlata.darClickEnAceptar();
		pageSacarPlata.darClickEnAceptar();
		utilidad.esperaMiliseg(2000);
		utilidad.tomaEvidencia("Confirmación de datos");
		pulsarContinuar();
	}


	
}
