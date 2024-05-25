package daviplata.nacional.iOS.definitions;

import cucumber.api.java.en.Then;
import daviplata.nacional.iOS.steps.PasarPlataSteps;
import daviplata.nacional.iOS.steps.WebCheckOutSteps;
import daviplata.nacional.iOS.steps.negocioSteps;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import net.thucydides.core.annotations.Steps;

public class WebCheckOutDefinitions {
	
	@Steps
    negocioSteps negocioStep;
	@Steps
	WebCheckOutSteps webcheckoutSteps;
    BaseUtil base;
	@Steps
    PasarPlataSteps stepsPasarPlata;
   
   @Then("^Selecciono botón de pago en perfil mi negocio$")
   public void seleccionoElBotonDePago() throws Exception {
	   webcheckoutSteps.seleccionoElBotonDePago();
   }
   
   @Then("^Validar que se presente un video y permita reproducirse varias veces$")
   public void ValidoElVideoPresenteBotonPago() throws Exception {
       webcheckoutSteps.ValidoElVideoPresenteBotonPago();
   }
   
   @Then("^Validar que se presente el texto definido$")
   public void ValidarTextosDefinidos() throws Exception {
       webcheckoutSteps.ValidarTextosDefinidos();
   }
   
   @Then("^Dar clic Atrás en el módulo botón de pago$")
   public void DarClicAtrasBotonDePago() throws Exception {
       webcheckoutSteps.DarClicAtrasBotonDePago();
   }
   
   @Then("^Hago clic en la equis y valido devolverme al home$")
   public void ClicEnLaEquisValidoDevolvermeAlHome() throws Exception {
       webcheckoutSteps.ClicEnLaEquisValidoDevolvermeAlHome();
   }
   
   @Then("^Ingreso y genero el botón de pago$")
   public void DarClicEnGenerarBotonDePago() throws Exception {
       webcheckoutSteps.DarClicEnGenerarBotonDePago();
   }
   
   @Then("^Valido la url del botón de pago$")
   public void ValidarUrlBotonDePago() throws Exception {
       webcheckoutSteps.ValidarUrlBotonDePago();
       webcheckoutSteps.seleccionoElBotonDePago();
   }
   
   @Then("^Valido el botón finalizar$")
   public void ValidarBotonFinalizar() throws Exception {
       webcheckoutSteps.ValidarBotonFinalizar();
   }
   
   @Then("Validar que despues de generar el primer botón de pago se omita la pantalla de Enlaces de pago$")
   public void ValidarPantallaNoPresente() throws Exception {
       webcheckoutSteps.ValidarPantallaNoPresente();
   }
   
   @Then("^Selecciono el botón enlace de pago$")
   public void seleccionoElBotonEnlaceDePago() throws Exception {
       webcheckoutSteps.seleccionoElBotonEnlaceDePago();
   }
   
   @Then("^Realizo la creación del producto \"([^\"]*)\" \"([^\"]*)\"$")
   public void realizoLaCreacionDelProducto(String nombreProducto, String valorProducto) throws Exception {
       webcheckoutSteps.realizoLaCreacionDelProducto(nombreProducto, valorProducto);
   }
   
   @Then("^Ingreso a la web con la url de enlace de pago \"([^\"]*)\"$")
   public void ingresoAWebEnlaceDePago(String numeroDocumento) throws Exception {
       webcheckoutSteps.ingresoAWebEnlaceDePago(numeroDocumento);
   }
}
