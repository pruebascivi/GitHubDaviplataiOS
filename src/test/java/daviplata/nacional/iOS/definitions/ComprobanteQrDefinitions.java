package daviplata.nacional.iOS.definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import daviplata.nacional.iOS.steps.ComprobanteQrSteps;
import daviplata.nacional.iOS.steps.LoginSteps;
import daviplata.nacional.iOS.utilidades.Evidencias;
import net.thucydides.core.annotations.Steps;

public class ComprobanteQrDefinitions {

	@Steps
	ComprobanteQrSteps comprobanteQrSteps;
	@Steps
	LoginSteps loginSteps;
	@Steps
	Evidencias evidencia;

	@Given("^Ingresé a la app Daviplata$")
	public void ingreséALaAppDaviplata() {
		comprobanteQrSteps.ingresarALaApp();
	}

	@When("^Valido botón QR desde el login inicial$")
	public void validoBotónQRDesdeElLoginInicial() {
		comprobanteQrSteps.validarVisibilidadBotonQr();
	}

	@When("^Ingreso a la sección datos recordados \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoALaSecciónDatosRecordados(String tipoDocumento, String usuario, String contrasena) {
		comprobanteQrSteps.ingresarADatosRecordados(tipoDocumento, usuario, contrasena);
		comprobanteQrSteps.salirDeLaApp();
	}

	@Then("^Validar botón QR desde la sección datos recordados$")
	public void validarBotónQRDesdeLaSecciónDatosRecordados() {
		comprobanteQrSteps.validarVisibilidadBotonQr();
	}

	@Then("^Validar opciones del boton QR$")
	public void validarOpcionesDelBotonQR() {
		comprobanteQrSteps.validarOpcionesBotonQr();
	}
	
	@Then("^Ingreso al modulo de lectura de QR desde el home$")
    public void ingresoAlModuloDeLecturaDeQrDesdeElHome() throws Exception {
        comprobanteQrSteps.ingresarAlBotonLeerCodigoQr();
    }

	@Then("^Valido modulo de lectura de QR$")
    public void validoModuloDeLecturaDeQr() throws Exception {
        comprobanteQrSteps.validarFuncionalidadDeLeerQr();
    }
}
