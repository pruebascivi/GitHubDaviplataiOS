package daviplata.nacional.iOS.definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import daviplata.nacional.iOS.steps.RecargaSteps;
import daviplata.nacional.iOS.steps.SacarPlataSteps;
import daviplata.nacional.iOS.utilidades.Utilidades;
import net.thucydides.core.annotations.Steps;

public class SacarPlataDefinitions {

	@Steps
	SacarPlataSteps stepsSacarPlata;


	@When("^ingreso a modulo sacar plata$")
	public void ingresoAModuloSacarPlata() {
		stepsSacarPlata.seleccionarModuloSacarPlata();
	}

	@When("^diligenciar sacar plata monto seleccionable$")
	public void diligenciarSacarPlataMontoSeleccionable() {
		stepsSacarPlata.diligenciarSacarPlataSeleccionable();
		stepsSacarPlata.pulsarContinuar();
	}

	@Then("^valido generacion de OTP$")
	public void validoGeneracionDeOTP() {
//		stepsSacarPlata.confirmoDatosDiligenciados();
		stepsSacarPlata.validoGeneracionDeOTP();
		stepsSacarPlata.verificoSaldos();
	}

	@When("^diligenciar sacar plata monto diferente \"([^\"]*)\"$")
	public void diligenciarSacarPlataMontoDiferente(String montoATransar) {
		stepsSacarPlata.diligenciarSacarPlataMontoDiferente(montoATransar);
		stepsSacarPlata.pulsarContinuar();
	}

	@Then("^valido valor errado$")
	public void validoValorErrado() {
		stepsSacarPlata.validoValorErrado();

	}

	@Then("^valido fondos insuficientes$")
	public void validoFondosInsuficientes() {
	//	stepsSacarPlata.confirmoDatosDiligenciados();
		stepsSacarPlata.validoFondosInsuficientes();
	}
	
	@When("^diligenciar sacar plata monto seleccionable \"([^\"]*)\"$")
	public void diligenciarSacarPlataMontoSeleccionable(String monto) {
		stepsSacarPlata.diligenciarSacarPlataSeleccionable(monto);
	}
	
	@When("^Diligencio monto diferente \"([^\"]*)\"$")
	public void diligenciarMontoDiferente(String montoATransar) {
		stepsSacarPlata.ingresarMontoDiferente(montoATransar);
	}
	
	@When("^Diligencio monto diferente para fondos insuficientes \"([^\"]*)\"$")
	public void diligenciarMontoDiferenteFondosInsuficientes(String montoATransar) {
		stepsSacarPlata.ingresarMontoDiferenteFondosInsuficientes(montoATransar);
	}

	@Then("^Validar valor errado$")
	public void validarValorErrado() {
		stepsSacarPlata.validoValorErrado();

	}
	
	@Then("^volver a capturar saldo$")
	public void volverCapturarSaldo() {
		stepsSacarPlata.volverCapturarSaldofinal();

	}
	
	

	
}
