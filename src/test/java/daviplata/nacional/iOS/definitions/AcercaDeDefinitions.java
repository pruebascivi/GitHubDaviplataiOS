/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daviplata.nacional.iOS.definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import daviplata.nacional.iOS.steps.AcercaDeSteps;
import daviplata.nacional.iOS.steps.LoginSteps;
import net.thucydides.core.annotations.Steps;
/**
 *
 * @author Contr
 */
public class AcercaDeDefinitions {
	@Steps
	AcercaDeSteps stepsAcercaDe;
	@Steps
	LoginSteps loginSteps;
	

	@Given("^ingreso al modulo acerca de$")
	public void ingresoAlModuloAcercaDe() {
		loginSteps.verificarVersion();
		stepsAcercaDe.seleccionarModuloAcercaDe();
	}
	@When("^ingresar a opcion para que sirve$")
	public void ingresarAOpcionParaQueSirve() {
		stepsAcercaDe.ingresoAOpcionParaQueSirve();
	}
	
	@Then("^validar opcion para que sirve$")
	public void validarOpcionParaQueSirve() {
		stepsAcercaDe.validarOpcionParaQueSirve();
	}
	
	@When("^ingresar a opcion donde usar$")
	public void ingresarAOpcionDondeUsar() {
		stepsAcercaDe.ingresoAOpcionDondeUsar();
	}

	@Then("^validar opcion donde usar$")
	public void validarOpcionDondeUsar() {
		stepsAcercaDe.validarOpcionDondeUsar();
	}
	
	@When("^ingresar a opcion twitter$")
	public void ingresarAOpcionTwitter() {
		stepsAcercaDe.ingresoAOpcionTwitter();
	}

	@Then("^validar opcion twitter$")
	public void validarOpcionTwitter() {
		stepsAcercaDe.validoOpcionTwitter();
	}
	
	@When("^ingresar a opcion youtube$")
	public void ingresarAOpcionYoutube() {
		stepsAcercaDe.ingresoAOpcionYoutube();
	}

	@Then("^validar opcion youtube$")
	public void validarOpcionYoutube() {
		stepsAcercaDe.validoOpcionYoutube();
	}
	
	@When("^ingresar a opcion reglamento$")
	public void ingresarAOpcionReglamento() {
		stepsAcercaDe.ingresoAOpcionReglamento();
	}
	

	@Then("^validar opcion reglamento$")
	public void validarOpcionReglamento() {
		stepsAcercaDe.validoOpcionReglamento();
	}
	
	@When("^ingresar a opcion condiciones$")
	public void ingresarAOpcionCondiciones() {
		stepsAcercaDe.ingresoAOpcionCondiciones();
	}

	@Then("^validar opcion condiciones$")
	public void validarOpcionCondiciones() {
		stepsAcercaDe.validoOpcionCondiciones();
	}
	
	@Given("^ingreso a la opcion ayuda en linea$")
	public void ingresoALaOpcionAyudaEnLinea() {
		stepsAcercaDe.ingresoALaOpcionAyudaEnLinea(); 
	}

	@Then("^validar opcion ayuda en linea$")
	public void validarOpcionAyudaEnLinea() {
		stepsAcercaDe.validarOpvionAyudaEnLinea();
	}
	
	/*
	@Given("^Crear Excel$")
	public void crearExcel() throws Exception {
		stepsAcercaDe.crearExcel();
	}*/
	
	@Given("^Ingresé al boton de notificaciones home daviplata$")
	public void ingreséAlBotonDeNotificacionesHomeDaviplata() {
		stepsAcercaDe.ingresarBotonNotificaciones();
	}

}
