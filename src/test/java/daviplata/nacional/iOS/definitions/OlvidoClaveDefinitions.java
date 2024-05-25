package daviplata.nacional.iOS.definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import daviplata.nacional.iOS.steps.LoginSteps;
import daviplata.nacional.iOS.steps.WebRedebanSteps;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import daviplata.nacional.iOS.steps.OlvidoClaveSteps;
import net.thucydides.core.annotations.Steps;

public class OlvidoClaveDefinitions {

	@Steps
	OlvidoClaveSteps stepsOlvidoClave;
	@Steps
	WebRedebanSteps stepsWebRedeban;
	@Steps
	LoginSteps stepsLogin;
	public String email = "";
	public String celular = "";
	BaseUtil base;
	Hooks hooks;
	
	@Given("^Habilite proceso de olvido clave temporal redeban \"([^\"]*)\"$")
	public void habilitarClaveTemporalRedeban(String usuario) {
		stepsOlvidoClave.habilitarClaveTemporalRedeban(usuario);
	}
	
	@Given("^Cerre redeban desde olvido clave$")
	public void cerrarRedebanOlvidoClave() {
		stepsOlvidoClave.cerrarRedebanOlvidoClave();
	}
	
	@Then("^Validar clave temporal erronea$")
	public void validarClaveTemporalErronea() {
		stepsOlvidoClave.validarClaveTemporal();
	}



	@When("^completar flujo olvido su clave \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void completarFlujoOlvidoSuClave(String tipoDocumento, String numeroDocumento, String claveNueva) throws Exception {
		stepsOlvidoClave.ingresarOlvidoSuClave();
		stepsOlvidoClave.ingresarDocumento(tipoDocumento, numeroDocumento);
		stepsOlvidoClave.pulsarContinuar();
		//OBTENER NUMERO DE CELULAR EN REDEBAN
		String numCelular = stepsWebRedeban.consultaNumeroCelular(numeroDocumento);
		System.out.println("Su numero celular es: " + numCelular);
		//CERRAR SESION EN REDEBAN
		stepsWebRedeban.logOut("//img[@src='/ASDebitMonWeb/images/pages/logout.gif']");
		//stepsOlvidoClave.consultarOtpLatinia(numCelular); 
		stepsOlvidoClave.ingresarNuevaClave(claveNueva);
	}
	
	@When("^flujo olvido su clave otp \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void flujoOlvidoClaveOTP(String tipoDocumento, String numeroDocumento, String claveNueva) throws Exception {
		stepsOlvidoClave.ingresarOlvidoSuClave();
		stepsOlvidoClave.ingresarDocumento(tipoDocumento, numeroDocumento);
		stepsOlvidoClave.pulsarContinuar();
		//OBTENER NUMERO DE CELULAR EN REDEBAN
		String numCelular = stepsWebRedeban.consultaNumeroCelular(numeroDocumento);
		System.out.println(numCelular);
		//CERRAR SESION EN REDEBAN
		stepsWebRedeban.logOut("//img[@src='/ASDebitMonWeb/images/pages/logout.gif']");
		//stepsOlvidoClave.ingresarEmail(email, numCelular);
		stepsOlvidoClave.validarMensajeIngresoClave();
	}
	
	@When("^completar flujo olvido su clave ingresando confirmación erronea \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void completarFlujoOlvidoSuClaveConfirmacionErronea(String tipoDocumento, String numeroDocumento, String claveNueva) throws Exception {
		stepsOlvidoClave.ingresarOlvidoSuClave();
		stepsOlvidoClave.ingresarDocumento(tipoDocumento, numeroDocumento);
		stepsOlvidoClave.pulsarContinuar();
		//OBTENER NUMERO DE CELULAR EN REDEBAN
		String numCelular = stepsWebRedeban.consultaNumeroCelular(numeroDocumento);
		System.out.println(numCelular);
		//CERRAR SESION EN REDEBAN
		stepsWebRedeban.logOut("//img[@src='/ASDebitMonWeb/images/pages/logout.gif']");
		//stepsOlvidoClave.ingresarEmail(email, numCelular); 
		stepsOlvidoClave.ingresarNuevaClaveConfirmacionErronea(claveNueva);
	}
	
	@When("^completar flujo olvido su clave ingresando clave nueva erronea \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void completarFlujoOlvidoSuClaveNuevaErronea(String tipoDocumento, String numeroDocumento, String claveNueva) throws Exception {
		stepsOlvidoClave.ingresarOlvidoSuClave();
		stepsOlvidoClave.ingresarDocumento(tipoDocumento, numeroDocumento);
		stepsOlvidoClave.pulsarContinuar();
		//OBTENER NUMERO DE CELULAR EN REDEBAN
		String numCelular = stepsWebRedeban.consultaNumeroCelular(numeroDocumento);
		System.out.println(numCelular);
		//CERRAR SESION EN REDEBAN
		stepsWebRedeban.logOut("//img[@src='/ASDebitMonWeb/images/pages/logout.gif']");
		//stepsOlvidoClave.ingresarEmail(email, numCelular); 
		stepsOlvidoClave.ingresarNuevaClaveNuevaErronea(claveNueva);
	}
	

	@Then("^Validar cambio de clave$")
	public void validarCambioDeClave() throws Exception {
		stepsOlvidoClave.validarCambioDeClave();
	}

	@Then("^validar notificacion misma clave\"([^\"]*)\" \"([^\"]*)\"$")
	public void validarNotificacionMismaClave(String arg1, String arg2) throws Exception {
		stepsOlvidoClave.validarCambioDeClaveIgual();
	}

	@When("^completar flujo olvido su clave con confirmacion mal \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void completarFlujoOlvidoSuClaveConConfirmacionMal(String tipoDocumento, String numeroDocumento,
			String claveNueva) throws Exception {
		
		stepsOlvidoClave.ingresarDocumento(tipoDocumento, numeroDocumento);
		stepsOlvidoClave.pulsarContinuar();
		stepsOlvidoClave.ingresarOlvidoSuClave();
		stepsOlvidoClave.ingresarDocumento(tipoDocumento, numeroDocumento);
		stepsOlvidoClave.pulsarContinuar();
		//stepsOlvidoClave.ingresarEmail(email, numeroDocumento); 
		stepsOlvidoClave.ingresarNuevaClaveConConfirmacionMal(claveNueva);
		
	}
	
	@Then("^validar notificacion confirmacion mal$")
	public void validarNotificacionConfirmacionMal() throws Exception {
		stepsOlvidoClave.validarMensajeNoCoincide();
	}
	
	@When("^completar flujo olvido su clave con otp mal \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void completarFlujoOlvidoSuClaveConOtpMal(String tipoDocumento, String numeroDocumento,
			String claveNueva) throws Exception {
		
		stepsOlvidoClave.ingresarOlvidoSuClave();
		stepsOlvidoClave.ingresarDocumento(tipoDocumento, numeroDocumento);
		stepsOlvidoClave.pulsarContinuar();
		//OBTENER NUMERO DE CELULAR EN REDEBAN
		String numCelular = stepsWebRedeban.consultaNumeroCelular(numeroDocumento);
		System.out.println(numCelular);
		//CERRAR SESION EN REDEBAN
		stepsWebRedeban.logOut("//img[@src='/ASDebitMonWeb/images/pages/logout.gif']");
		stepsOlvidoClave.ingresarEmailOtpInvalida(email, numCelular);
	}
	
	@Then("^validar notificacion otp mal$")
	public void validarNotificacionOtpMal() throws Exception {
		stepsOlvidoClave.validarMensajeOtpErronea();
	}
	
	@Then("^validar cambio de clave erroneo$")
	public void validarCambioDeClaveErroneo() throws Exception {
		stepsOlvidoClave.validarMensajeClaveErronea();
	}
	
	@When("^Ingresé al modulo olvido clave$")
	public void ingreseAlModuloOlvidoClave() throws Exception {
		stepsOlvidoClave.ingresarOlvidoSuClave();
	}
	
	@When("^Ingreso datos de olvido clave \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoDatosDeOlvidoClave(String tipoDocumento, String numeroDocumento) throws Exception {
		stepsOlvidoClave.ingresarDocumento(tipoDocumento, numeroDocumento);
		stepsOlvidoClave.pulsarContinuar();
	}
	
	@When("^Consulto numero celular en redeban \"([^\"]*)\"$")
	public void consultoNumeroCelularEnRedeban(String numeroDocumento) throws Exception {
		BaseUtil.numeroCelularOtp = stepsWebRedeban.consultaNumeroCelular(numeroDocumento);
		System.out.println("Su numero celular es: " + celular);
		stepsWebRedeban.logOut("//img[@src='/ASDebitMonWeb/images/pages/logout.gif']");
	}
	
	@When("^Consulto en latinia la otp$")
	public void consultoEnLatiniaLaOtp() throws Exception {
		stepsOlvidoClave.consultarOtpLatinia(BaseUtil.numeroCelularOtp);
	}
	
	@When("^Ingreso otp en cambio de clave$")
	public void ingresoOtpEnCambioDeClave() throws Exception {
		stepsOlvidoClave.ingresarOtpDeLatinia();
	}
	
	@When("^Consulto en latinia la otp de olvido clave$")
	public void consultoEnLatiniaLaOtpOlvidoClave() throws Exception {
		stepsOlvidoClave.consultarOtpLatiniaOlvidoClave(BaseUtil.numeroCelularOtp);
	}
	
	@When("^Ingreso clave nueva en olvido clave \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoClaveNuevaEnOlvidoClave(String claveNueva, String confirmacionClaveNueva) throws Exception {
		stepsOlvidoClave.ingresarClaveNueva(claveNueva,confirmacionClaveNueva);
	}
	
	@Then("^Ingresar a la app para validar el ingreso con nueva clave \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void validarCambioDeClave(String tipoDocumento, String usuario, String clave) throws Exception {
		stepsLogin.ingresarAAppNuevaContraseniaDespuesCambio(tipoDocumento,usuario, clave);
	}
	
	@When("^Diligencio formulario olvido clave \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void diligencioFormularioOlvidoClave(String tipoDocumento, String numeroDocumento, String claveNueva) throws Exception {        
        stepsOlvidoClave.ingresarOlvidoSuClave();
        stepsOlvidoClave.ingresarDocumento(tipoDocumento, numeroDocumento);
        stepsOlvidoClave.pulsarContinuar();
    }
	
	@Then("^Valido pop up chat con asesor$")
    public void validoPopUpChatConAsesor() {
        stepsOlvidoClave.validarPopUpChatConAsesor();
    }
	
	@Then("^Validar que al dar tap en la equis direccione a la pantalla anterior$")
    public void validarQueAlDarTapEnLaEquisDireccioneALaPantallaAnterior() {
        stepsOlvidoClave.validarPantallaAnteriorAlHacerClicEnLaEquisPopUp();
    }
}
