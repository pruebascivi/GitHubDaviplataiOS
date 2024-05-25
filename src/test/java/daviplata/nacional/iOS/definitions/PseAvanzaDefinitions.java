package daviplata.nacional.iOS.definitions;

import cucumber.api.java.en.Given;
import daviplata.nacional.iOS.steps.MeterPlataSteps;
import daviplata.nacional.iOS.steps.PagarSteps;
import daviplata.nacional.iOS.steps.WebRedebanSteps;
import net.thucydides.core.annotations.Steps;

public class PseAvanzaDefinitions {

	@Steps
	PagarSteps stepsPagar;
	@Steps
	WebRedebanSteps stepsWebRedeban;
	@Steps
	MeterPlataSteps meterPlataSteps;

	@Given("^Validé estado nor del usuario origen \"([^\"]*)\"$")
    public void validarEstadoNorDelUsuarioOrigen(String usuario) throws Exception {
        stepsWebRedeban.validarEstadoNorDelUsusarioOrigen(usuario);
    }
}
