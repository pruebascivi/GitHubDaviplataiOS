package daviplata.nacional.iOS.steps;

import daviplata.nacional.iOS.pageObjects.CambioNumeroPageObjects;
import daviplata.nacional.iOS.pageObjects.HomePageObjects;
import daviplata.nacional.iOS.pageObjects.LoginPageObjects;
import daviplata.nacional.iOS.pageObjects.MenuHamburguesaPageObjects;
import daviplata.nacional.iOS.pageObjects.WebLatiniaPageObject;
import daviplata.nacional.iOS.utilidades.Credenciales;
import daviplata.nacional.iOS.utilidades.Utilidades;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class CambioNumeroSteps {

	Utilidades utilidad;
	@Steps
	CambioNumeroPageObjects pageCambioNumero;
	@Steps
	LoginPageObjects pageLogin;
	@Steps
	WebLatiniaPageObject pageLatinia;

	
	@Step
	public void ingresarDocumento(String tipoId, String usuario) {
		utilidad.tomaEvidencia("click tipo documento");
		pageCambioNumero.pulsarBtnTipoDocumento();
		pageLogin.seleccionarTipoDocumento(tipoId);
		pageCambioNumero.ingresarNumeroDocumento(usuario);
		pageCambioNumero.clicBotonContinuarTecladoIos();
		utilidad.tomaEvidencia("Ingresar número documento");
	}
	
	@Step
	public void pulsarBotonContinuar() {
		pageCambioNumero.pulsarBotonContinuar();
	}

	@Step
	public void pulsarAceptar() {
		pageCambioNumero.pulsarAceptarPopUp();
	}

	@Step
	public void ingresarNumeroCelular(String numeroCelular) {
		pageCambioNumero.pulsarAceptarPopUp();
		utilidad.tomaEvidencia("Seleccion de opcion 'Aceptar'");
		pageCambioNumero.ingresarNuevoNumeroCelular(numeroCelular);
		utilidad.tomaEvidencia("Ingreso Numero de celular nuevo");
		pageCambioNumero.ingresarConfirmarNuevoNumeroCelular(numeroCelular);
		utilidad.tomaEvidencia("Ingreso nuevamente Numero de celular nuevo");
		pageCambioNumero.pulsarContinuarCambioNumero();
		utilidad.tomaEvidencia("Click boton Continuar");
		//pageLogin.validarEsperaPage();
		utilidad.tomaEvidencia("Validar espera");
	}
	
	@Step
	public void validarPopUpAtencion() {
		pageCambioNumero.validarPopUpAtencion();
	}

	@Step
	public void ingresarOTP(String numeroCelular , String clave) {
		pageLatinia.initDriverLatinia();
//		pageLatinia.clicBtnContinuar();
		utilidad.tomaEvidencia("Ingreso a Latinia");
		pageLatinia.ingresarEmpresa();
		pageLatinia.ingresarUsuario();
		pageLatinia.ingresarPassword();
		utilidad.tomaEvidencia("Ingreso de credenciales");
		pageLatinia.darClickAcceder();
		utilidad.esperar(500);
		utilidad.tomaEvidencia("Click boton Acceder");
		pageLatinia.darClickBtnActualizar();
		String numeroOTP = pageLatinia.traeOTP(numeroCelular);
		utilidad.tomaEvidencia("Consulta OTP");
		System.out.println(numeroOTP);
		pageLatinia.cerrarLatinia();
		pageCambioNumero.ingresarOTP(numeroOTP);
		utilidad.tomaEvidencia("Ingreso OTP");
		pageCambioNumero.pulsarContinuarIngresoOTP();
		utilidad.tomaEvidencia("Click boton Continuar");
		pageCambioNumero.ingresarClaveConfirmacionOTP(clave);
		pageCambioNumero.pulsarContinuarLogin();
		utilidad.tomaEvidencia("Ingreso de credenciales para finalizar");
	}
	
	@Step
	public void ingresarSegundaOTP(String numeroCelular , String clave) {
		utilidad.esperaMiliseg(10000);
		pageLatinia.initDriverLatinia();
//		pageLatinia.clicBtnContinuar();
		utilidad.tomaEvidencia("Ingreso a Latinia");
		pageLatinia.ingresarEmpresa();
		pageLatinia.ingresarUsuario();
		pageLatinia.ingresarPassword();
		utilidad.tomaEvidencia("Ingreso de credenciales");
		pageLatinia.darClickAcceder();
		utilidad.esperar(500);
		utilidad.tomaEvidencia("Click boton Acceder");
		pageLatinia.darClickBtnActualizar();
		String numeroOTP = pageLatinia.traeOPTFiltro(numeroCelular);
		utilidad.tomaEvidencia("Consulta OTP");
		System.out.println(numeroOTP);
		pageLatinia.cerrarLatinia();
		pageCambioNumero.ingresarOTP(numeroOTP);
		utilidad.tomaEvidencia("Ingreso OTP");
		pageCambioNumero.pulsarContinuarIngresoOTP();
		utilidad.tomaEvidencia("Click boton Continuar");
		pageCambioNumero.ingresarClaveConfirmacionOTP(clave);
		pageCambioNumero.pulsarContinuarLogin();
		utilidad.tomaEvidencia("Ingreso de credenciales para finalizar");
	}
	
	@Step
	public void ingresarNumeroCelularDiferenteConfirmacion(String numeroCelular, String numeroCelular2) {
		pageCambioNumero.ingresarNuevoNumeroCelular(numeroCelular);
		pageCambioNumero.ingresarConfirmarNuevoNumeroCelular(numeroCelular2);
		pageCambioNumero.pulsarContinuarCambioNumero();
	}
	@Step
	public void validarPopUpConfirmacionDiferente() {
		pageCambioNumero.validarPopUPNumerosDiferentes();
	}
	@Step
	public void validarPopUpNumeroNoIniciaEnTres() {
		pageCambioNumero.validarPopUpNumeroNoIniciaEnTres();
	}
	@Step
	public void validarPopUpAdvertenciaNumeroDebeSerDiferente() {
		pageCambioNumero.validarPopUpAdvertenciaNumeroDebeSerDiferente();
	}
	@Step
	public void validarPopUpCambioNumero() {
		pageCambioNumero.validarPopUpCambioNumero();
	}
	@Step
	public void validarPopUpAsesoriaEnLinea() {
		pageCambioNumero.validarPopUpAsesoriaEnLinea();
	}
	@Step
	public void validarYDarTapEnBotonCancelar() {
		pageCambioNumero.validarYDarTapEnBotonCancelar();
	}
	@Step
	public void validarYDarTapEnBotonAceptar() {
		pageCambioNumero.validarYDarTapEnBotonAceptar();
	}
	@Step
	public void validarMensajeOtpInvalido() {
		pageCambioNumero.validarMensajeOtpInvalido();
	}
	
	@Step
	public void pulsarVolverAEnviarOTP() {
		pageCambioNumero.pulsarVolverAEnviarOTP();
	}
	
	@Step
	public void ingresarOTPInvalido() {
		String random = "876726";
		pageCambioNumero.ingresarOTP(random);
		pageCambioNumero.pulsarContinuarIngresoOTP();
	}
	
	@Step
	public void ingresarOTPErradaTresVeces() {
		String random = pageCambioNumero.numAleatorioSeisDigitos();
		pageCambioNumero.ingresarOTP(random);
		pageCambioNumero.pulsarContinuarIngresoOTP();
		pageCambioNumero.pulsarContinuarIngresoOTP();
		pageCambioNumero.pulsarContinuarIngresoOTP();
	}
	
	@Step
	public void validarAdvertenciaAlSuperarIntentos() {
		pageCambioNumero.validarAdvertenciaSuperarIntentos();
	}
	
	@Step
	public void IngresarCambioNumeroPrivado() {
		pageCambioNumero.pulsarBtnNoMeInteresaOfertaCredito();
		//Implementar funciones para el ingreso desde el home header
		pageCambioNumero.pulsarBtnCambioNumeroPrivado();
		pageCambioNumero.pulsarAceptarPopUp();
	}
	
	
	@Step
	public void pulsarOlvidoSuClave() {
		pageCambioNumero.pulsarBtnOlvidoClave();
	}
	
	
	@Step
	public void ingresarUsuarioOlvidoClave(String tipoDocumento, String numeroDocumento) {
		pageCambioNumero.pulsarBtnTipoDocumento();
		pageCambioNumero.seleccionarTipoDocumento(tipoDocumento);
		pageCambioNumero.ingresarNumDocumentoOlvidoClave(numeroDocumento);
		pageCambioNumero.pulsarBtnContinuarOlvidoClave();
	}
	
	
	@Step
	public void ingresarEmailOlvidoClave(String email) {
		pageCambioNumero.ingresarEmailOlvidoClave(email);
		pageCambioNumero.pulsarBtnContinuarOlvidoClaveDos();
	}
	
	
	@Step
	public void ingresarClaveTemporal(String numCelular) {
		pageLatinia.ingresarEmpresa();
		pageLatinia.ingresarUsuario();
		pageLatinia.ingresarPassword();
		pageLatinia.darClickAcceder();
		pageLatinia.darClickBtnActualizar();
		String claveTemporal = pageLatinia.traeOTP(numCelular);
		pageLatinia.cerrarLatinia();
		pageCambioNumero.ingresarClaveTemporal(claveTemporal);
		pageCambioNumero.pulsarbtnContinuarClaveTemporal();
	}
	
	
	@Step
	public void ingresarNuevaClave(String clave) {
		pageCambioNumero.ingresarNuevaClave(clave);
		pageCambioNumero.ingresarNuevaClaveVerificar(clave);
		pageCambioNumero.pulsarbtnAceptarNuevaClave();
	}
	
}
