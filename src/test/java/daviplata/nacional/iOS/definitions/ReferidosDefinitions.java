package daviplata.nacional.iOS.definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import daviplata.nacional.iOS.steps.LoginSteps;
import daviplata.nacional.iOS.steps.ReferidosSteps;
import daviplata.nacional.iOS.steps.RegistroMayoresSteps;
import net.thucydides.core.annotations.Steps;

public class ReferidosDefinitions {
	
	@Steps
	RegistroMayoresSteps registroMayoresSteps;
	@Steps
	LoginSteps loginSteps;
	@Steps
	ReferidosSteps referidosSteps;

	@When("^Ingresé al pop up de referidos \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void ingreseAlAplicativoSinCerrarPopUpDeReferidos(String tipoDocumento, String usuario, String contrasena) {
        referidosSteps.ingresarAlPopUpReferidos(tipoDocumento, usuario, contrasena);
    }

	@When("^Valido la funcionalidad de la equis en el header$")
    public void validoLaFuncionalidadDeLaEquisEnElHeader() {
        referidosSteps.validoLaEquisEnElHeaderReferidos();
    }
    
    @When("^Salgo del header de referidos$")
    public void salgoDelHeaderDeReferidos() {
        referidosSteps.salirDelHeaderDeReferidos();
    }
    
    @When("^Valido el logo daviplata en referidos$")
    public void validoElLogoDaviplataEnReferidos() {
        referidosSteps.validarLogoDaviplataEnElHeader();
    }
    
    @When("^Ingreso al menu hamburguesa de referidos$")
    public void ingresoAlMenuHamburguesaDeReferidos() {
        referidosSteps.hacerClicEnElBotonMenuHamburguesa();
    }
    
    @When("^Valido opcion para invitar referidos$")
    public void validoOpcionParaInvitarReferidos() {
        referidosSteps.validarLasOpcionesParaInvitar();
    }
    
    @When("^Valido opcion mis ganancias$")
    public void validoOpcionMisGanancias() {
        referidosSteps.validarLaOpcionMisGanancias();
    }
    
    @When("^Valido la opcion registrarse en daviPlata$")
    public void validoLaOpcionRegistrarseEnDaviPlata() {
        referidosSteps.validarLaOpcionRegistrarseEnDaviplata();
    }
    
    @When("^Valido el cuadro de texto con el link e icono de copiar$")
    public void validoElCuadroDeTextoConElLinkEIconoDeCopiar() {
        referidosSteps.validarCuadroDeTextoDelLinkJuntoConElCuadroDeCopiar();
    }
    
    @When("^Valido los diferentes canales de compartir$")
    public void validoLosDiferentesCanalesDeCompartir() {
        referidosSteps.validarLosDiferentesCanalesParaCompartir();
    }
    
    @When("^Valido opciones para ganar dinero por invitar amigos$")
    public void validoOpcionesParaGanarDineroPorInvitarAmigos() {
        referidosSteps.validarOpcionesParaGanarPorInvitarAmigos();
    }

    @Then("^Validar las opciones de compartir en cada medio de red social$")
    public void validarLasOpcionesDeCompartirEnCadaMedioDeRedSocial() {
        referidosSteps.validarMediosParaCompartirReferidos();
    }
    
    @When("^Valido el recuadro que refleja el dinero adquirido$")
    public void validoElRecuadroQueReflejaElDineroAdquirido() {
        referidosSteps.validoRecuadroDineroGanado();
    }
    
    @When("^Valido contadores de enlaces$")
    public void validoContadoresDeEnlaces() {
        referidosSteps.validarContadoresDeReferidos();
    }
    
    @When("^Valido texto de referidos dentro de mis ganancias$")
    public void validoTextoDeReferidosDentroDeMisGanancias() {
        referidosSteps.validarTextoReferidosMisGanancias();
    }
    
    @When("^Valido campos de busqueda por nombre y fecha de referidos$")
    public void validoCamposDeBusquedaPorNombreYFechaDeReferidos() {
        referidosSteps.validarCamposPrediccionBusquedaPorNombreYFecha();
    }
    
    @When("^Valido lista de referidos$")
    public void validoListaDeReferidos() {
        referidosSteps.validarListaDeReferidos();
    }
    
    @When("^Valido dos textos de la primera pantalla$")
    public void validoDosTextosDeLaPrimeraPantalla() {
        referidosSteps.validarTextosDeLasPantallasDeReferidos();
    }
    
    @When("^Valido barra ilustrativa de avance entre pantallas$")
    public void validoBarraIlustrativaDeAvanceEntrePantallas() {
        referidosSteps.validarLaBarraDeAvance();
    }
    
    @When("^Valido que este presente un check obligatorio desmarcado$")
    public void validoQueEstePresenteUnCheckObligatorioDesmarcado() {
        referidosSteps.validarCheckDesmarcado();
    }
    
    @When("^Valido que el check al marcarlo se encuentre activo en las dos pantallas$")
    public void validoQueElCheckAlMarcarloSeEncuentreActivoEnLasDosPantallas() {
        referidosSteps.validarElCheckTyCEnLasDosPantallas();
    }
    
    @When("^Doy a continuar en el modulo invita a sus amigos$")
    public void doyAContinuarEnElModuloInvitaASusAmigos() {
    	referidosSteps.darClicAlBtnContinuar();
    }
    
    @When("^Regreso al home$")
    public void regresoAlHome() {
        referidosSteps.regresarAlHome();
    }
    
    @When("^Valido modulo 'Gane plata invitando a sus amigos'$")
    public void validoModuloGanePlataInvitandoASusAmigos() {
        referidosSteps.validarModuloGanePlataInvitando();
    }
    

}
