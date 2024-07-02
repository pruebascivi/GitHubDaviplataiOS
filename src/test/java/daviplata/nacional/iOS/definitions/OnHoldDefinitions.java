package daviplata.nacional.iOS.definitions;

import static org.junit.Assert.assertNotNull;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import daviplata.nacional.iOS.steps.OnHoldSteps;
import daviplata.nacional.iOS.steps.WebRedebanSteps;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import net.thucydides.core.annotations.Steps;

public class OnHoldDefinitions {
	
	@Steps
    OnHoldSteps holdSteps;
	BaseUtil base;
	WebRedebanSteps stepsWebRedeban = new WebRedebanSteps();
    
    @When("^Pasar plata a otro Daviplata on Hold \"([^\"]*)\" \"([^\"]*)\"$")
    public void pasarPlataAOtroDaviplataOnHold(String numero, String monto) throws Exception {
    	holdSteps.pasarPlataAOtroDaviplataOnHold(numero, monto);
    }
    
    @Given("^obtener numero celular actual en redeban con estado diferente \"([^\"]*)\" \"([^\"]*)\"$")
    public void obtenerNumeroCelularActualEnRedebanEstadoDiferente(String usuario, String estadoRedeban) throws Exception {
        BaseUtil.numCelularRedeban = stepsWebRedeban.consultaNumeroCelularConEstadoDiferente(usuario, estadoRedeban);
        BaseUtil.numCelularRedeban = base.numCelular;
        assertNotNull(base.numCelular);
    }
}

