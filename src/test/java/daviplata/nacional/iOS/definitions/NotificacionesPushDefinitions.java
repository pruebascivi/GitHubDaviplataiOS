package daviplata.nacional.iOS.definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import daviplata.nacional.iOS.steps.LoginSteps;
import daviplata.nacional.iOS.steps.NotificacionesPushSteps;
import daviplata.nacional.iOS.steps.OnHoldSteps;
import daviplata.nacional.iOS.steps.WebRedebanSteps;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import net.thucydides.core.annotations.Steps;

public class NotificacionesPushDefinitions {
	
	@Steps
	NotificacionesPushSteps notificacionesPushSteps;
    
    @Given("^Abrir web de davivienda \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void abrirWebDeDavivienda(String tipoDocumentoWebDavivienda, String usuarioDavivienda, String contrasenaDavivienda, String numeroCelularUsuarioDavivienda) throws Exception {
        notificacionesPushSteps.ingresoAWebDavivienda(tipoDocumentoWebDavivienda,usuarioDavivienda,contrasenaDavivienda,numeroCelularUsuarioDavivienda);
    }
    
    @Then("^Cerrar sesion de davivienda$")
    public void cerrarSesionDeDavivienda() throws Exception {
        notificacionesPushSteps.cerrarSesionDavivienda();
    }
    
    @Then("^Realizo transaccion de davivienda a daviplata \"([^\"]*)\"\"([^\"]*)\"$")
    public void realizoTransaccionDeDaviviendaADaviplata(String monto, String numeroCelular) throws Exception {
        notificacionesPushSteps.realizarTransaccionDaviviendaDaviplata(monto, numeroCelular);
    }
    
    @Then("^Valido movimiento realizado$")
    public void validoMovimientoRealizado() throws Exception {
        notificacionesPushSteps.validarMovimientoHome();
    }
    
    @Then("^Valido mensaje de recarga daviplata desde davivienda$")
    public void validoMensajeDeRecargaDaviplataDesdeDavivienda() throws Exception {
        notificacionesPushSteps.validarMensajeRecargaDesdeDaviplata();
    }
    
    @Then("^Valido mensaje de transferencia desde daviplata a davivienda$")
    public void validoMensajeDeTransferenciaDesdeDaviplataADavivienda() throws Exception {
        notificacionesPushSteps.validarMensajeTransferenciaDesdeDaviplata();
    }
    
    @Then("^Valido mensaje de compra en tienda virtual desde daviplata$")
    public void validoMensajeDeCompraEnTiendaVirtualDesdeDaviplata() throws Exception {
        notificacionesPushSteps.validarMensajeCompraTiendaVirtualDesdeDaviplata();
    }
    
    @Then("^Valido mensaje de compra por pse$")
    public void validoMensajeDeCompraPorPse() throws Exception {
        notificacionesPushSteps.validarMensajeCompraPseDaviplata();
    }
    
    @When("^Abro web de latinia$")
    public void abroWebDeLatinia() throws Exception {
        notificacionesPushSteps.ingresoAWebLatinia();
    }
    
    @When("^Filtro numero celular \"([^\"]*)\"$")
    public void filtroNumeroCelular(String numeroCelular) throws Exception {
        notificacionesPushSteps.filtrarPorNumeroCelular(numeroCelular);
    }
    
    @Then("^Validar notificacion recarga daviplata en latinia \"([^\"]*)\"$")
    public void validarNotificacionRecargaDaviplataEnLatinia(String monto) throws Exception {
        notificacionesPushSteps.validarMensajeRecargaDesdeDaviviendaEnLatinia(monto);
    }
    
    @Then("^Validar notificacion transferencia desde daviplata a davivienda en latinia \"([^\"]*)\"$")
    public void validarNotificacionTransferenciaDesdeDaviplataADaviviendaEnLatinia(String monto) throws Exception {
        notificacionesPushSteps.validarMensajeTransferenciaACuentaDaviviendaDesdeDaviplata(monto);
    }
    
    @Then("^Validar notificacion pasar plata en linea desde latinia \"([^\"]*)\"$")
    public void validarNotificacionPasarPlataEnLineaDesdeLatinia(String monto) throws Exception {
        notificacionesPushSteps.validarMensajePasarPlataEnLineaDesdeDaviplata(monto);
    }
    
    @When("^Ingreso a notificaciones de tienda virtual$")
    public void ingresoANotificacionesDeTiendaVirtual() throws Exception {
        notificacionesPushSteps.hacerClicComprasEnTiendaVirtual();
    }
    
    @Then("^Validar mensaje de compra en tienda virtual desde latinia$")
    public void validarMensajeDeCompraEnTiendaVirtualDesdeLatinia() throws Exception {
        notificacionesPushSteps.validarMensajeCompraEnTiendaVirtual();
    }
    
    @Then("^Validar mensaje de compra en pse desde latinia$")
    public void validarMensajeDeCompraEnPseDesdeLatinia() throws Exception {
        notificacionesPushSteps.validarMensajeCompraEnPse();
    }
    
    @Then("^Valido la transacción en la campana de notificaciones$")
    public void validoLaTansaccionEnCampanaNotificaciones() throws Exception {
    	notificacionesPushSteps.validoLaTansaccionEnCampanaNotificaciones();
    }
    
    @Then("^Valido resultado transaccion exitosa pasar plata linea$")
    public void validoResultadoTransaccionExitosaPasarPlataLinea() throws Exception {
    	notificacionesPushSteps.validoResultadoTransaccionExitosaPasarPlataLinea();
    }
    
    @When("^Diligencio otp en el enlace de pago$")
    public void diligencioOtpEnElEnlaceDePago() throws Exception {
    	notificacionesPushSteps.diligenciarOtpDePago();
    }
    
    @When("^Hago clic en el boton de pagar en la otp de enlace de pago$")
    public void hagoClicEnElBotonDePagarEnLaOtpDeEnlaceDePago() throws Exception {
    	notificacionesPushSteps.clicBotonPagarEnlacePago();
    }
    
    @Then("Validar datos de transaccion exitosa$")
    public void validarDatosDeTransaccionExitosa() throws Exception {
    	notificacionesPushSteps.validarPantallaDeDatosCompraExitosa();
    }
}

