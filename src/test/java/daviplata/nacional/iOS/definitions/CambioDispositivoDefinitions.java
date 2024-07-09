package daviplata.nacional.iOS.definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import daviplata.nacional.iOS.steps.CambioDispositivoSteps;
import net.thucydides.core.annotations.Steps;

public class CambioDispositivoDefinitions {
	
	@Steps
	CambioDispositivoSteps stepsCambioDispositivo;
	
	@Given("^Ingresé usuario \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingreséUsuarioYContraseña(String tipoDocumento, String usuario) {
		stepsCambioDispositivo.ingresarUsuario(tipoDocumento,usuario);
	}
	
	@When("^Realizo cambio de dispositivo \"([^\"]*)\"$")
	public void relizoCambioDeDispositivo(String contrasena) {
		stepsCambioDispositivo.realizarCambioDispositivo(contrasena);
	}
	
	@When("^Realizo cambio de dispositivo con clave incorrecta \"([^\"]*)\" \"([^\"]*)\"$")
	public void relizoCambioDeDispositivoConClaveIncorrecta(String contrasena,String otp) {
		stepsCambioDispositivo.realizarCambioDispositivoClaveIncorrecta(contrasena,otp);
	}
	
	@Then("^Validar mensaje de clave incorrecta$")
	public void validarMensajeDeClaveIncorrecta() {
		stepsCambioDispositivo.validarMensajeClaveIncorrecta();
	}
	
	@Then("^Validar mensaje de otp incorrecta$")
	public void validarMensajeDeOtpIncorrecta() {
		stepsCambioDispositivo.validarMensajeOtpIncorrecta();
	}
}

