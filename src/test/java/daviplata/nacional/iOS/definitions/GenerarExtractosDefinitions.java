package daviplata.nacional.iOS.definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import daviplata.nacional.iOS.steps.GeneracionExtractosSteps;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import net.thucydides.core.annotations.Steps;

public class GenerarExtractosDefinitions {
	
	@Steps
	GeneracionExtractosSteps generacionExtractosSteps;
	BaseUtil base;
	
	@When("^Ingreso a extractos$")
    public void ingresoAExtractos() throws Exception {
		generacionExtractosSteps.ingresarAExtractos();
    }

    @Then("^Cerre popup nanocredito$")
    public void cerrePopupNanocredito() throws Exception {
    	generacionExtractosSteps.cerrePopupNanocredito();
    }

    @When("^Genero extractos$")
    public void generoExtractos() throws Exception {
    	generacionExtractosSteps.generarExtractos();
    }

    @Then("^Validar generación de extracto$")
    public void validarGeneraciónDeExtracto() throws Exception {
    	generacionExtractosSteps.validarGeneracionExtracto();
    }
}

