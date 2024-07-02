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
    
    @Then("^Ingreso a certificaciones$")
    public void ingresoACertificaciones() throws Exception {
    	generacionExtractosSteps.validarOpcionCertificaciones();
    }
    
    @Then("^Ingreso tipo de Certificación$")
    public void ingresoTipoDeCertificacion() throws Exception {
    	generacionExtractosSteps.seleccionarTipoCertificacion();
    }
    
    @Then("^Ingreso a certificacion nanocredito$")
    public void ingresoACertificacionNanocredito() throws Exception {
    	generacionExtractosSteps.seleccionarCertificacionNano();
    }
    
    @Then("^Valido opcion cuánto debo$")
    public void validoOpcioCuantoDebo() throws Exception {
    	generacionExtractosSteps.validarModuloCuantoDebo();
    }
    
    @Then("^Ingreso a consultar certificacion tributaria$")
    public void ingresoAConsultarCertificacionTributaria() throws Exception {
    	generacionExtractosSteps.seleccionarCertificacionTributaria();
    }
    
    @Then("^Validar mensaje de certificacion tributaria$")
    public void validarMensajeDeCertificacionTributaria() throws Exception {
    	generacionExtractosSteps.validarInformeGeneral();
    }
    
    @Then("^Genero certificación por año$")
    public void generoCertificacionPorAnio() throws Exception {
    	generacionExtractosSteps.validarInformeGeneralPorAnio();
    }
    
    @Then("^Valido generacion de certificacion tributaria$")
    public void validoGeneracionDeCertificacionTributaria() throws Exception {
    	generacionExtractosSteps.validarGeneracionDeInforme();
    }
    
    @Then("^Ingreso a consultar certificacion costos$")
    public void ingresoAConsultarCertificacionCostos() throws Exception {
    	generacionExtractosSteps.validarOpcionCertificarCostos();
    }
    
    @Then("^Valido mensaje de certificacion de costos$")
    public void validoMensajeDeCertificacionDeCostos() throws Exception {
    	generacionExtractosSteps.validarMensajeCertificacionCostos();
    }
}

