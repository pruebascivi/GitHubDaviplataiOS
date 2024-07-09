package daviplata.nacional.iOS.definitions;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import java.util.ArrayList;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import daviplata.nacional.iOS.steps.Excepcion4x1000Steps;
import daviplata.nacional.iOS.steps.LoginSteps;
import daviplata.nacional.iOS.steps.WebRedebanSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class Excepcion4x1000Definitions {
	@Steps
	static Excepcion4x1000Steps stepsExcepcion4x1000;
	@Steps
	WebRedebanSteps stepsWebRedeban;
	@Steps
	LoginSteps stepsLogin;
	ArrayList<Float> saldos = new ArrayList<Float>();
	ArrayList<String> estados = new ArrayList<String>();
	String estadoExenta4x1000 = "";
	
	@Given("^consulto el estado actual excenta 4x1000 en redeban \"([^\"]*)\"$")
	public void validarEstadoActualExcenta4x1000(String usuario) throws Exception {
		String estadoExcenta = stepsWebRedeban.consultaEstadoExcepcion(usuario); Serenity.setSessionVariable("estadoExcenta").to(estadoExcenta);
		estados.add(estadoExcenta);
		System.out.println("Estado Excenta actual del cliente " + usuario + " es: " + estadoExcenta);
	}
	
	@Given("^validar estado de exencion \"([^\"]*)\"$")
	public void validarEstadoNoExcento(String estadoEsperado) throws Exception {
		String estado = Serenity.sessionVariableCalled("estadoExcenta");
		assertThat(estado, equalTo(estadoEsperado));
	}
	
	@Then("^logout redeban al finalizar consulta estado excenta$")
	public void logoutRedeban() throws Exception {
		stepsWebRedeban.logOut("//img[@src='/ASDebitMonWeb/images/pages/logout.gif']");
	}
	
	@Then("^selecciono opcion exencion 4x1000$")
	public void seleccionarOpcionExencion4x1000() throws Exception {
		stepsExcepcion4x1000.seleccionarOpcionExencion4x1000();
	}
	
	@Then("^valido exencion exitosa$")
	public void validarExencionExitosa() throws Exception {
		stepsExcepcion4x1000.validarExencionExitosa();
	}
	
	@Then("^valido exencion no exitosa$")
	public void validarExencionNoExitosa() throws Exception {
		stepsExcepcion4x1000.validarExencionNoExitosa();
	}
	
	@Then("^valido opcion exencion 4x1000$")
	public void validarOpcionExencion4x1000() throws Exception {
		stepsExcepcion4x1000.validarOpcionExencion4x1000();
	}
	
	@Then("^pulso boton finalizar$")
	public void pulsarBtnFinalizar() throws Exception {
		stepsExcepcion4x1000.pulsarBtnFinalizar();
	}
	
	@When("^Ingreso al desplegable solicitudes$")
    public void ingresoAlDesplegableSolicitudes() {
		stepsExcepcion4x1000.hacerClicBotonSolicitudes();
    }
}
