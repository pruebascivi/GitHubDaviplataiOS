package daviplata.nacional.iOS.definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import daviplata.nacional.iOS.steps.PagarSteps;
import net.thucydides.core.annotations.Steps;

public class PagarDefinitions {

	@Steps
	PagarSteps stepsPagar;

	@When("^ingreso a modulo pagar$")
	public void ingresoAModuloPagar() {
		stepsPagar.ingresoAModuloPagar();
	}
	
	@When("^ingresar a marketplace servicio agua$")
	public void ingresoAModuloPagarMarketplaceServicioAgua() {
		stepsPagar.ingresoAModuloPagarMarketPlaceServicioAgua();
	}
	
	@When("^ingresar a pagar home desde marketplace$")
	public void ingresoAModuloPagarDesdeMarketPlace() {
		stepsPagar.ingresoAModuloPagarMarketPlace();
	}
	@When("^ingresar datos de referencia \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresarDatosDeUnaReferencia(String empresaServicio, String referencia, String valorTransaccion) {
		stepsPagar.ingresarReferencia(referencia);
		stepsPagar.ingresarValorYPagar(valorTransaccion);
	}
	@When("^Diligencio datos de una referencia en empresa \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void diligencioDatosDeUnaReferencia(String empresaServicio, String referencia, String valorServicio) {
		stepsPagar.diligencioDatosDeUnaReferencia(empresaServicio, referencia);
		stepsPagar.ingresarValorPagarServicio(valorServicio);
	}
	
	@When("^Diligencio datos de una referencia servico \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void diligencioDatosDeUnaReferenciaServico(String empresaServicio, String referencia, String valorTransaccion) throws Exception {
		stepsPagar.diligencioDatosDeUnaReferencia(empresaServicio, referencia);
		stepsPagar.ingresarValorYPagar(valorTransaccion);
	}

	@Then("^verifico transaccion exitosa una ref \"([^\"]*)\" \"([^\"]*)\"$")
	public void verificoTransaccionExitosaUnaRef(String empresaServicio, String referencia) {
		stepsPagar.verificoTransaccionExitosaUnaRef(empresaServicio, referencia);
		stepsPagar.verificoSaldoFinal();
	}
	
	@Then("^verifico transaccion exitosa \"([^\"]*)\"$")
	public void verificoTransaccionExitosa(String referencia) {
		stepsPagar.verificoTransaccionExitosa(referencia);
		stepsPagar.verificoSaldoFinal();
	}
	
	@When("^diligencio datos de una referencia errada \"([^\"]*)\" \"([^\"]*)\"$")
	public void diligencioDatosDeUnaReferenciaErrada(String empresaServicio, String referencia) {
		stepsPagar.diligencioDatosDeUnaReferenciaErrada(empresaServicio, referencia);
	}

	@Then("^verifico transaccion negada$")
	public void verificoTransaccionNegada() {
		stepsPagar.verificoTransaccionNegada();
	}
	
	@When("^diligencio datos de dos referencias \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void diligencioDatosDeDosReferencias(String empresaServicio, String referencia, String referencia2, String valorTransaccion) {
		stepsPagar.diligencioDatosDeDosReferencias(empresaServicio, referencia, referencia2);
		stepsPagar.ingresarValorYPagar(valorTransaccion);
	}
	
	@Then("^verifico transaccion exitosa dos ref \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void verificoTransaccionExitosaDosRef(String empresaServicio, String referencia, String referencia2) {
		stepsPagar.verificoTransaccionExitosaDosRef(empresaServicio, referencia, referencia2);
		stepsPagar.verificoSaldoFinal();
	}
	
	@When("^diligencio datos de dos referencias errada \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void diligencioDatosDeDosReferenciasErrada(String empresaServicio, String referencia, String referencia2) {
		stepsPagar.diligencioDatosDeDosReferencias(empresaServicio, referencia, referencia2);
	}
}
