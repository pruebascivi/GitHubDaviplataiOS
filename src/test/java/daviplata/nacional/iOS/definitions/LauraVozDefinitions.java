package daviplata.nacional.iOS.definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import daviplata.nacional.iOS.steps.LauraVozSteps;
import daviplata.nacional.iOS.steps.LoginSteps;
import daviplata.nacional.iOS.utilidades.Evidencias;
import net.thucydides.core.annotations.Steps;

public class LauraVozDefinitions {
	@Steps
	LoginSteps loginSteps;
	@Steps
	Evidencias evidencia;
	@Steps
	LauraVozSteps lauraVozSteps;
	
    @When("^Valido que me redireccione al gestor de interacciones tradicional$")
    public void validoQueMeRedireccioneAlGestorDeInteraccionesTradicional() throws Exception {
        lauraVozSteps.validoMeRedireccioneAlGestorDeInteraccionesTradicional();
    }
    
    @Given("^Valido que me redireccione al usuario a la pantalla bienvenida$")
    public void validoMeRedireccioneAlUsuarioALaPantallaBienvenida() throws Exception {
        lauraVozSteps.validoMeRedireccioneAlUsuarioALaPantallaBienvenida();
    }
    
    @Then("^Validar la pantalla Bievenido al chat de servicio daviplata contenga el icono cerrar y me redirija al login del gestor$")
    public void validarLaPantallaBienvenidoAlChatDeServicioDaviplataContengaIconoCerrar() throws Exception {
        lauraVozSteps.validarLaPantallaBienvenidoAlChatDeServicioDaviplataContengaIconoCerrar();
    }
    
    @Then("^Valido que en la pantalla contenga el icono Minimizar y al dar tap sobre el icono redireccione a la App Daviplata$")
    public void validoLapantallaLauraVozContengaElIconoMinimizar() throws Exception {
        lauraVozSteps.validoLapantallaLauraVozContengaElIconoMinimizar();
    }
    
    @Then("^Validar despues del tap en el icono minimizar y volver a ingresar al boton necesito ayuda se direccione al Gestor Poc Laura en la misma pantalla que se minimizo$")
    public void validarElTapMinimizarPresentaLaMismaPantallaQueSeMinimizo() throws Exception {
        lauraVozSteps.validarElTapMinimizarPresentaLaMismaPantallaQueSeMinimizo();
    }
    
    @Then("^Realizo tap en el boton Empecemos y se dirija a la pantalla 'necesita Ayuda' donde se podrá visualizar el mensaje predeterminado$")
    public void realizoTapEnElBotonEmpecemosSeVisualiceElMensajePredeterminado() throws Exception {
        lauraVozSteps.realizoTapEnElBotonEmpecemosSeVisualiceElMensajePredeterminado();
    }
    
    @Then("^Validar que la pantalla contenga el texto 'Renovamos nuestro servicio de ayuda'$")
    public void validarQueLaPantallaContegaElTextoPredeterminado() throws Exception {
        lauraVozSteps.validarQueLaPantallaContegaElTextoPredeterminado();
    }
    
	@When("^Valido que la pantalla contenga el texto 'Renovamos nuestro servicio de ayuda'$")
    public void validoQueLaPantallaContegaElTextoPredeterminado() throws Exception {
        lauraVozSteps.validarQueLaPantallaContegaElTextoPredeterminado();
    }
    
    @When("^Hago clic en el boton reproducir$")
    public void hagoClicEnElBotonReproducir() throws Exception {
        lauraVozSteps.hacerClicBotonReproducir();
    }
    
    @Then("^Validar textos de la reproduccion de Laura voz$")
    public void validarTextosDeLaReproduccionDeLauraVoz() throws Exception {
        lauraVozSteps.validarTextosDeLaReproduccionLaura();
    }
}
