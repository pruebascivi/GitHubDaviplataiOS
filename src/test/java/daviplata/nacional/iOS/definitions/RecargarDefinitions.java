package daviplata.nacional.iOS.definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import daviplata.nacional.iOS.steps.RecargaSteps;
import net.thucydides.core.annotations.Steps;

public class RecargarDefinitions {

	@Steps
	RecargaSteps stepsRecarga;

	@When("^seleccionar recarga prepago$")
	public void seleccionarRecargaPrepago() { 
		stepsRecarga.seleccionarRecargaVirual();
	}

	@When("^realizar recarga prepago tv \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void realizarRecargaPrepagoTv(String empresaOperador, String numReferencia,
			String montoSeleccionable) {
		stepsRecarga.selecccionarTipoRecarga();
		stepsRecarga.diligenciarDatosDeRecargaTv(empresaOperador, numReferencia, montoSeleccionable);
	}
	
	@When("^realizar recarga prepago cel \"([^\"]*)\" \"([^\"]*)\"$")
	public void realizarRecargaPrepagoCel( String numReferencia, String montoSeleccionable) {
		stepsRecarga.selecccionarTipoRecarga();
		//stepsRecarga.diligenciarDatosRecargaCelular(numReferencia,montoSeleccionable);
	}
	
	@Then("^validar recarga exitosa \"([^\"]*)\"$")
	public void validarRecargaExitosa(String numReferencia) {
		stepsRecarga.validarRecargaExitosa(numReferencia);
		stepsRecarga.verificoSaldoFinal();
	}
	
	@Then("^validar recarga rechazada$")
	public void validarRecargaRechazada() {
		stepsRecarga.validarRecargaFallida();
	}



}
