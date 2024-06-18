package daviplata.nacional.iOS.definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import daviplata.nacional.iOS.steps.LauraChatSteps;
import daviplata.nacional.iOS.steps.LoginSteps;
import daviplata.nacional.iOS.utilidades.Evidencias;
import net.thucydides.core.annotations.Steps;

public class LauraChatDefinitions {
	@Steps
	LoginSteps loginSteps;
	@Steps
	Evidencias evidencia;
	@Steps
	LauraChatSteps lauraChatSteps;
	
	@When("^Ingreso a necesito ayuda desde zona privada$")    
    public void ingresarNecesitoAyuda() {
        lauraChatSteps.ingresarANecesitoAyudaDesdeElHomeDaviplata();
    }
    
    @When("^Valido pantalla de bienvenida \"([^\"]*)\"\"([^\"]*)\"$")    
    public void validoPantallaDeBienvenida(String tipoDocumento, String numDocumento) throws Exception {
        lauraChatSteps.validarPantallaBienvenida(tipoDocumento, numDocumento);
    }
    
    @When("^Hago clic en el boton cerrar$")    
    public void hagoClicEnElBotonCerrar() {
        lauraChatSteps.hacerClicEnLaEquis();
    }
    
    @When("^Valido que despues de dar clic en el boton de cerrar chat direccione al home Daviplata$")
    public void validoQueDespuesDeDarClicEnElBotonDeCerrarChatDireccioneAlHomeDaviplata() throws Exception {
        lauraChatSteps.validarHomeDaviplataAlDarEnLaEquis();
    }

    @When("^Hago clic en el boton minimizar$")
    public void hagoClicEnElBotonMinimizar() throws Exception {
        lauraChatSteps.hacerClicEnMinimizar();
    }

    @When("^Valido que despues de dar clic en el boton de minimizar chat direccione al home Daviplata$")
    public void validoQueDespuesDeDarClicEnElBotonDeMinimizarChatDireccioneAlHomeDaviplata() throws Exception {
        lauraChatSteps.validarHomeDaviplataAlDarEnMinimizar();
    }

    @When("^Doy clic en el boton empecemos$")
    public void doyClicEnElBotonEmpecemos() throws Exception {
        lauraChatSteps.hacerClicEnElBotonEmpecemos();
    }

    @Then("^Validar pantalla del canal del chat$")
    public void validarPantallaDelCanalDelChat() throws Exception {
        lauraChatSteps.validarCanalDelChat();
    }

}
