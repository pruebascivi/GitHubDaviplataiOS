package daviplata.nacional.iOS.definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import daviplata.nacional.iOS.steps.WebRedebanSteps;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import daviplata.nacional.iOS.steps.EcardSteps;
import daviplata.nacional.iOS.steps.PagarSteps;
import net.thucydides.core.annotations.Steps;

public class EcardDefinitions {


	@Steps
	EcardSteps stepsEcard;
	@Steps
	WebRedebanSteps stepsRedeban;

	@When("^ingreso a tarjeta de credito$")
	public void ingresoATarjetaDeCredito() {
		stepsEcard.clickEcard();
	}
	
	@When("^ingreso a tarjeta de credito MH$")
	public void ingresoATarjetaDeCreditoMH() {
		stepsEcard.ingresoMenuHamburguesa();
	}
	
	@Then("^valido terminos$")
	public void validoTerminos() throws Exception {
	    stepsEcard.validarTerminosYCondiciones();
	}
	
	@When("^crear tarjeta de credito$")
	public void crearTarjetaDeCredito() {
		stepsEcard.creoTarjetaVirtual();
	}
	
	@When("^click boton Ver datos Tarjeta$")
	public void clickBotonVerDatosTarjeta() {
		stepsEcard.clickBotonVerDatosTarjeta();
	}
	
	@When("^click imagen tarjeta$")
	public void clickImagenTarjeta() {
		stepsEcard.clickImagenTarjeta();
	}
	
	@Then("^valido en latinia \"([^\"]*)\"$")
	public void validoEnLatinia(String numero) {
		stepsEcard.validarCvv(numero);
	}
	
	@Then("^valido creacion sin recarga$")
	public void validoCreacionSinRecarga() {
		stepsEcard.validoCreacionSinRecarga();
	}
	
	@When("^recargo tarjeta \"([^\"]*)\"$")
	public void recargoTarjeta(String montoSeleccionable) {
		stepsEcard.recargoTarjeta(montoSeleccionable);
	}
	
	/*@When("^recargo tarjeta \"([^\"]*)\"$")
	public void recargoTarjetaMontoDiferente(String monto) throws Exception {
	    stepsEcard.recargoTarjetaMontoDiferente(monto);
	}*/
	
	@When("^selecciono Movimientos Tarjeta$")
	public void seleccionoMovimientosTarjeta() {
		stepsEcard.seleccionoMovimientosTarjeta();
	}
	
	@And("^valido recarga exitosa$")
	public void validoRecargaExitosa() {
		stepsEcard.validoRecargaExitosa();
	}
	
	@Then("^valido datos tarjeta$")
	public void validoDatosTarjeta() {
		stepsEcard.validoDatosTarjeta();
	}
	
	@When("^selecciono recargar tarjeta$")
	public void seleccionoRecargarTarjeta() {
		stepsEcard.seleccionoRecargar();
	}
	
	@When("^selecciono recargar tarjeta credito$")
	public void seleccionoRecargarTarjetaCredito() {
		stepsEcard.seleccionoRecargarTarjeta();
	}
	
	@When("^selecciono Bloquear Tarjeta$")
	public void seleccionoBloquearTarjeta() {
		stepsEcard.seleccionoBloquearTarjeta();
	}
	
	@When("^selecciono Bloquear TarjetaHM$")
	public void seleccionoBloquearTarjetaHM() {
		stepsEcard.seleccionoBloquearTarjeta();
	}
	
	@When("^selecciono Bloquear Tarjeta segunda vez$")
	public void seleccionoBloquearTarjetaSegundaVez() throws Exception {
		String montoSeleccionable = "5000";
		stepsEcard.seleccionoBloquearTarjetaSegundaVez();
		stepsEcard.verificoMensajeBloqueoSegundaVez();
		stepsEcard.seleccionoRecargar();
		stepsEcard.recargoTarjeta(montoSeleccionable);
	}
	
	@Then("^valido creacion con recarga$")
	public void validoCreacionConRecarga() {
		stepsEcard.validoCreacionConRecarga();
	}
	
	@Then("^valido recarga negada$")
	public void validoRecargaNegada() throws Exception {
	    stepsEcard.validoRecargaRestringida();
	}
	
	@Then("^valido mensaje tope tarjeta virtual$")
	public void validoMensajeTopeTarjetaVirtual() throws Exception {
	    stepsEcard.validoMensajeTope();
	}
	
	
	@Then("^valido recarga negada \"([^\"]*)\"$")
	public void validoRecargaNegada(String montoSeleccionable) {
		stepsEcard.recargoTarjeta(montoSeleccionable);
		stepsEcard.validoRecargaNegada();
	}
	
	@Then("^valido visualizacion movimientos$")
	public void validoVisualizacionMovimientos() throws Exception {
		stepsEcard.visualizacionMovimientos();
	}
	
	@Then("^valido Bloqueo Tarjeta$")
	public void validoBloqueoTarjeta() throws Exception {
		stepsEcard.validoBloqueoTarjeta();
	}
	
	@And("^Validar en redeban ecard \"([^\"]*)\"$")
	public void validarEnRedebanEcard(String cuenta) throws Exception {
		//base.montoTrasadoRedeban = stepsRedeban.consultaDiaria2(cuenta, base.monto);
	}
	
	@And("^ir a tarjeta virtual$")
	public void irATarjetaVirtual() throws Exception {
		stepsEcard.ingresarOpcionTarjetaVirtual();
	}
	
	@And("^recargar tarjeta$")
	public void recargarTarjeta() throws Exception {
		stepsEcard.recargarTarjetaVirtual();
	}
	
	@And("^validar mensaje de supero cupo$")
	public void validarMensajeDeSuperoCupo() throws Exception {
		stepsEcard.validarMensajeCupo();
	}
	
	@And("^recargar tarjeta sin disponible$")
	public void recargarTarjetaSinDisponible () throws Exception {
		stepsEcard.recargarTarjetaVirtualSinDisponible();
	}
	
	@And("^validar mensaje de saldo insuficiente$")
	public void validarMensajeDeSaldoInsuficiente () throws Exception {
		stepsEcard.validarMensajeSaldoInsuficiente();
	}
	
	@And("^validar recarga exitosa$")
	public void validarRecargaExitosa() throws Exception {
		stepsEcard.validarRecarga();
	}
	
	@And("^validar link de tarjeta virtual en el menu hamburguesa$")
	public void validarLinkDeTarjetaVirtualEnElMenuHamburguesa() throws Exception {
		stepsEcard.tarjetaVirtualEnElMenuHamburguesa();
	}
	
	@When("^verificar saldo de ecard$")
	public void verificarSaldoDeEcard() throws Exception {
		stepsEcard.validarSaldoEcard();
	}
	
	@When("^recargo tarjeta credito \"([^\"]*)\"$")
	public void recargoTarjetaMontoDiferente(String monto) throws Exception {
	    stepsEcard.recargoTarjetaMontoDiferente(monto);
	}
	
	@Then("^Valido en web consultas \"([^\"]*)\"$")
	public void ValidoEnWebConsultas(String numeroCelularDaviplata) throws Exception {
		stepsEcard.validarCVVEcard(numeroCelularDaviplata);
	}
	
	@Then("^Validar mensaje de topes en tarjeta virtual$")
	public void validarMensajeDeTopesEnTarjetaVirtual() throws Exception {
		stepsEcard.validarMensajeDeTopes();
	}

	
	
}