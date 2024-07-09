package daviplata.nacional.iOS.definitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import daviplata.nacional.iOS.steps.ClaveCorreoSteps;
import daviplata.nacional.iOS.steps.WebRedebanSteps;
import net.thucydides.core.annotations.Steps;

public class ClaveCorreoDefinitions {

	@Steps
	ClaveCorreoSteps stepsClaveCorreo;
	@Steps
	WebRedebanSteps stepsWebRedeban;

	@When("^Ingreso al header home$")
	public void seleccionoAlHeaderHome() {
		stepsClaveCorreo.ingresarAlHeaderHome();
	}
	
	@When("^selecciono cambiar clave y correo$")
	public void seleccionoCambiarClaveYCorreo() {
		stepsClaveCorreo.seleccionoCambiarClaveYCorreo();
	}

	@When("^cambiar clave \"([^\"]*)\" \"([^\"]*)\"$")
	public void cambiarClave(String claveAntigua, String claveNueva) {
		stepsClaveCorreo.cambiarClave(claveAntigua, claveNueva);
	}
	
	@When("^cambiar clave \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void cambiarClave(String claveAntigua, String claveNueva, String claveNuevaErrada) {
		stepsClaveCorreo.cambiarClave(claveAntigua, claveNueva, claveNuevaErrada);
	}

	@Then("^validar cambio de clave exitoso$")
	public void validarCambioDeClaveExitoso() {
		stepsClaveCorreo.validarCambioDeClaveExitoso();
	}
	
	@Then("^validar cambio de clave fallido$")
	public void validarCambioDeClaveFallido() {
		stepsClaveCorreo.validarCambioDeClaveFallido();
	}
	
	@When("^cambiar correo  \"([^\"]*)\"$")
	public void cambiarCorreo(String correoNuevo) {
		stepsClaveCorreo.cambiarCorreo(correoNuevo);
	}
	
	@When("^cambiar correo cuando no coincide  \"([^\"]*)\" \"([^\"]*)\"$")
	public void cambiarCorreoCuandoNoCoincide(String correoNuevo, String correoNuevoDos) {
		stepsClaveCorreo.cambiarCorreoNoCoincide(correoNuevo,correoNuevoDos);
	}
	
	@Then("^validar cambio de correo exitoso$")
	public void validarCambioDeCorreoExitoso() {
		stepsClaveCorreo.validarCambioDeCorreoExitoso();
	}
	
	@Then("^validar cambio de correo fallido$")
	public void validarCambioDeCorreoFallido() {
		stepsClaveCorreo.validarCambioDeCorreoFallido();
	}
	
	
	@Given("^obtener correo actual en redeban \"([^\"]*)\"$")
	public void obtenerCorreoActualEnRedeban(String usuario) {
		stepsWebRedeban.correoActual(usuario);
		stepsWebRedeban.logOut("//img[@src='/ASPrivateCardMonWeb/images/pages/logout.gif']");
	}
	
	@Then("^validar cambio correo en redeban \"([^\"]*)\" \"([^\"]*)\"$")
	public void validarCambioCorreoEnRedeban(String usuario, String correoNuevo) {
		String correoActual = stepsWebRedeban.correoActual(usuario);
		stepsWebRedeban.logOut("//img[@src='/ASPrivateCardMonWeb/images/pages/logout.gif']");
		assertEquals(correoNuevo, correoActual);
	}
	
	@Then("^validar No cambio correo en redeban \"([^\"]*)\" \"([^\"]*)\"$")
	public void validarNoCambioCorreoEnRedeban(String usuario, String correoNuevo) {
		String correoActual = stepsWebRedeban.correoActual(usuario);
		stepsWebRedeban.logOut("//img[@src='/ASPrivateCardMonWeb/images/pages/logout.gif']");
		assertNotEquals(correoNuevo, correoActual);
	}
	
// CASO DE CASITA ROJA
	
	@When("^activar teclado$")
	public void activarTeclado() {
		stepsClaveCorreo.activarTeclado();
		
	}

	@Then("^validar indicaciones de activacion$")
	public void validarIndicacionesDeActivacion() {
		stepsClaveCorreo.validarIndicacionesDeActivacion();
	}

//CASOS VER MOVIMIENTOS 
	
	@When("^selecciono ver movimientos$")
	public void seleccionoVerMovimientos() {
		stepsClaveCorreo.seleccionoVerMovimientos();
	}

	@Then("^validar que se muestren los movimientos$")
	public void validarQueSeMuestrenLosMovimientos() {
		stepsClaveCorreo.validarQueSeMuestrenLosMovimientos();
	}
	
	@When("^filtro movimientos$")
	public void filtroMovimientos() {
		stepsClaveCorreo.filtroMovimientos();
		
	}

	@Then("^validar que se muestren los movimientos filtrados$")
	public void validarQueSeMuestrenLosMovimientosFiltrados() {
		stepsClaveCorreo.validarQueSeMuestrenLosMovimientosFiltrados();
	}
	
	@Then("^validar envio de movimientos a correo$")
	public void validarEnvioDeMovimientosACorreo() {
		stepsClaveCorreo.validarEnvioDeMovimientosACorreo();
	}
	
	@Then("^Aceptar terminos y condiciones de los datos$")
	public void aceptarTerminosYCondicionesDeLosDatos() {
		stepsClaveCorreo.clicAceptarTerminosCondiciones();
	}
}
