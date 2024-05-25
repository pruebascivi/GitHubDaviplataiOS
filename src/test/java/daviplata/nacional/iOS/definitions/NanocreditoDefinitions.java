package daviplata.nacional.iOS.definitions;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import daviplata.nacional.iOS.steps.LoginSteps;
import daviplata.nacional.iOS.steps.NanocreditoSteps;
import daviplata.nacional.iOS.utilidades.Utilidades;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import net.thucydides.core.annotations.Steps;

public class NanocreditoDefinitions {
	
	@Steps
	NanocreditoSteps stepsNanoCredito;
	LoginSteps loginSteps;
	

	@When("^ingreso a opcion nanocredito$")
	public void ingresoAOpcionNanocredito() {
		stepsNanoCredito.ingresoAOpcionNanocredito();
	}
	
	@When("^autorizo utilizacion de datos$")
	public void autorizoUtilizacionDeDatos() {
		stepsNanoCredito.autorizoUtilizacionDeDatos();
		
	}
	
	@When("^solicitud del credito por monto no permitido$")
	public void solicitudDelCreditoPorMontoNoPermitido() {
		stepsNanoCredito.adquirirCreditoMontoNoPermitido();
	}

	@When("^solicitud del credito por monto permitido$")
	public void solicitudDelCreditoPorMontoPermitido() {
		stepsNanoCredito.adquirirCreditoMontoPermitido();
	}
	
	@When("^solicitud del credito por monto permitido no cumplo politicas$")
	public void solicitudDelCreditoPorMontoPermitidoNoCumploPoliticas() {
		stepsNanoCredito.solicitudDelCreditoPorMontoPermitidoNoCumploPoliticas();
	}
	
	@Then("^valido negacion del credito$")
	public void validoNegacionDelCredito() {
		stepsNanoCredito.validoNegacionDelCredito();
	}
	
	@Then("^valido que el DaviPlata no concuerde$")
	public void validoQueElDaviPlataNoConcuerde() {
		stepsNanoCredito.validoQueElDaviPlataNoConcuerde();
	}
	
	@Then("^valido negacion del credito OTP no valida$")
	public void validoNegacionDelCreditoOTPNoValida() {
		stepsNanoCredito.validoNegacionDelCreditoOTPNoValida();
	}
	
	@Then("^valido negacion del credito no cumplo politicas$")
	public void validoNegacionDelCreditoNoCumploPoliticas() throws Exception {
		stepsNanoCredito.validoNegacionDelCreditoNoCumploPoliticas();
	}
	
	@Then("^Ingreso usuario y contrasena en nanocredito \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void ingresoUsuarioYContrasenaEnNanocredito(String tipoDocumento, String usuario, String contrasena) throws Exception {
		stepsNanoCredito.ingresarALaAppEnNanocredito(tipoDocumento, usuario, contrasena);
    }
	
	@Then("^Validar PopUp nanocredito al ingresar al home daviplata$")
    public void validarPopUpNanocreditoAlIngresarAlHomeDaviplata() throws Exception {
        stepsNanoCredito.validarPopUpNanocredito();
    }
	
	@Then("^Seleccionar opcion no me interesa$")
    public void seleccionarOpcionNoMeInteresa() throws Exception {
        stepsNanoCredito.validarOpcionNoMeInteresa();
    }
	
	@Then("^Validar cajon nanocredito de la barra productos$")
    public void validarCajonNanocreditoBarraProductos() throws Exception {
        stepsNanoCredito.validaCajonNanocreditoBarraProductos();
    }
}
