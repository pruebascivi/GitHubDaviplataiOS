package daviplata.nacional.iOS.definitions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import java.math.BigDecimal;
import java.util.ArrayList;
import static org.hamcrest.Matchers.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import daviplata.nacional.iOS.steps.WebRedebanSteps;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import daviplata.nacional.iOS.utilidades.Utilidades;
import daviplata.nacional.iOS.utilidades.UtilidadesTCS;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import daviplata.nacional.iOS.modelo.ConsultaCupoTarjeta;
import daviplata.nacional.iOS.pageObjects.MarketPlacePageObjects;
import daviplata.nacional.iOS.steps.PasarPlataSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class PasarPlataDefinitions {

	@Steps
	WebRedebanSteps stepsWebRedeban;
	@Steps
	Utilidades utilidad;
	UtilidadesTCS utilidadesTCS;
	String tipoCuenta = "";
	@Steps
	BaseUtil base;
	private AppiumDriver<MobileElement> driver = Hooks.getDriver();

	ArrayList<Float> saldos = new ArrayList<Float>();
	String numCelular = "";
	private int contador = 0;
	
	@Steps
	PasarPlataSteps stepsPasarPlata;
	@Steps
	MarketPlacePageObjects marketObj;

	@Given("^consulta saldo inicial redeban \"([^\"]*)\"$")
	public void consultaSaldoInicialRedeban(String documento) throws Exception {
		stepsPasarPlata.consultaSaldoInicialRedeban(documento);
	}

	@When("^pasar plata a otro Daviplata \"([^\"]*)\"$")
	public void pasarPlataAOtroDaviplata(String numero) throws Exception {
		stepsPasarPlata.pasarPlataAOtroDaviplata(numero);
	}
	
	@When("^pasar plata a otro Daviplata valor 1 \"([^\"]*)\"$")
	public void pasarPlataAOtroDaviplataValor1(String numero) throws Exception {
		stepsPasarPlata.pasarPlataAOtroDaviplataValor1(numero);
	}
	
	@When("^validacion de numero diferente de tres \"([^\"]*)\"$")
	public void validarNumeroErrado(String numero) throws Exception {
		stepsPasarPlata.validarNumeroErrado(numero);
	}

	@Then("^pasar plata a otro Daviplata volver atras \"([^\"]*)\"$")
	public void pasarPlataAOtroDaviplataVolverAtras(String numero) throws Exception {
		stepsPasarPlata.pasarPlataAOtroDaviplataVolverAtras(numero);
	}

	@When("^pasar plata a otro Daviplata escribir \"([^\"]*)\"\"([^\"]*)\"$")
	public void pasarPlataAOtroDaviplataEscribir(String numero,String monto) throws Exception {
		stepsPasarPlata.pasarPlataAOtroDaviplataValor(numero,monto);
	}
	
	@When("^pasar plata a otro Daviplata en cero \"([^\"]*)\"\"([^\"]*)\"$")
	public void pasarPlataAOtroDaviplataMontoCero(String numero,String monto) throws Exception {
		stepsPasarPlata.pasarPlataAOtroDaviplataValorCero(numero, monto);
	}

	@Then("^Validar en redeban \"([^\"]*)\"$")
	public void validarEnRedeban2(String cuenta) throws Exception {
		System.out.println("base: " + BaseUtil.Autorizador);
		BaseUtil.idTransaccion = BaseUtil.Autorizador;
		BaseUtil.montoTrasadoRedeban = stepsWebRedeban.consultaDiaria3(cuenta, BaseUtil.Autorizador);
	}
	
	@Then("^Validar transaccion exitosa pasar plata cuenta$")
	public void validarTransaccionExitosaPasarPlataCuenta() {
		stepsPasarPlata.verificarTransaccionExitosaPasarPlataCuenta();
	}
	
	@Then("^validar en redeban autorizaciones \"([^\"]*)\"$")
	public void validarEnRedebanAutorizaciones(String cuenta) throws Exception {
		stepsWebRedeban.consultaDiariaAutorizadores(cuenta);
	}

	@When("^pasar plata a otro Daviplata mayor al saldo \"([^\"]*)\"$")
	public void pasarPlataAOtroDaviplataMayorAlSaldo(String numero) throws Exception {
		stepsPasarPlata.pasarPlataAOtroDaviplataMayorAlSaldo(numero);
	}

	@When("^pasar plata a cuenta de ahorros mayor al saldo daviplata \"([^\"]*)\"$")
	public void pasarPlataACuentaDeAhorrosMayorAlSaldoDaviplata(String numero) throws Exception {
		stepsPasarPlata.seleccionarCuentaCorrienteMayorSaldoDaviplata(numero);
	}

	@When("^seleccionar pasar plata Home$")
	public void seleccionarPasarPlataHome() {
		stepsPasarPlata.seleccionarPasarPlata(true);
	}
	
	//Lineas nuevas modulo pasar plata
	@When("^Escoger opcion a cuentas Davivienda$")
	public void escogerOpcionACuentasDavivienda() throws Exception {
		stepsPasarPlata.escogerOpcionCuentasDavivienda();
	}
	
	@When("^Pasar plata a cuentas davivienda añadiendo cuenta a favoritos \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void pasarPlataACuentasDaviviendaAnadiendoCuentaAFavoritos(String tipoCuenta, String numCuenta, String agregarCuentaAFavoritos, String monto) throws Exception {
        stepsPasarPlata.escogerOpcionCuentasDavivienda();
        stepsPasarPlata.escogerOpcionTipoCuentaDavivienda(tipoCuenta);
        stepsPasarPlata.ingresarNumeroCuentaDavivienda(numCuenta);
        stepsPasarPlata.agregarCuentaAFavoritos(agregarCuentaAFavoritos);
        stepsPasarPlata.ingresarMontoCuentaDavivienda(monto);
	}
	
	@When("^pasar plata monto seleccionable \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void pasarPlataMontoSeleccionable(String tipoCuenta, String numCuenta, String monto) throws Exception {
		stepsPasarPlata.escogerOpcionCuentasDavivienda();
	    stepsPasarPlata.escogerOpcionTipoCuentaDavivienda(tipoCuenta);
	    stepsPasarPlata.ingresarNumeroCuentaDavivienda(numCuenta);
	    stepsPasarPlata.ingresarMontoCuentaDavivienda(monto);
	    TouchAction touchAction=new TouchAction(driver);
        touchAction.tap(new PointOption().withCoordinates(20, 352)).perform();
	    stepsPasarPlata.clicPasarPlataCuenta();
	    //marketObj.cerrarPopup();
	    stepsPasarPlata.clicPasarPlataCuenta();

	}

	@When("^Digitar numero de cuenta \"([^\"]*)\"$")
	public void digitarNumeroDeCuenta(String numCuenta) throws Exception {
	    stepsPasarPlata.ingresarNumeroCuentaDavivienda(numCuenta);
	}

	@When("^Digitar monto a pasar \"([^\"]*)\"$")
	public void digitarMontoAPasar(String monto) throws Exception {
		stepsPasarPlata.ingresarMontoCuentaDavivienda(monto);
	}
	
	@When("^Escoger opcion a otros bancos$")
	public void escogerOpcionAOtrosBancos() throws Exception {
	    stepsPasarPlata.escogerOpcionAOtrosBancos();
	}

	@When("Llenar formulario de datos \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void llenarFormularioDeDatos(String numeroCuenta, String tipoId, String numId, String valorAPasar, String banco) throws Exception {
		stepsPasarPlata.llenarFormularioPasarPlata(numeroCuenta, tipoId, numId, valorAPasar, banco );
	}
	
	@When("^Llenar formulario de datos y favorito \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void llenarFormularioDeDatosYFavorito(String numeroCuenta, String tipoId, String numId, String valorAPasar, String banco) throws Exception {
		stepsPasarPlata.llenarFormularioPasarPlataYFavorito(numeroCuenta, tipoId, numId, valorAPasar, banco );
	}
	 
	
	@When("^Llenar el formulario de datos fondos insuficientes \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void llenarElFormularioDeDatosFondosInsuficientes(String numeroCuenta, String tipoId, String numId, String banco) {
		stepsPasarPlata.llenarFormularioPasarPlataFondosInsuficientes(numeroCuenta, tipoId, numId, banco );	
	}
	
	@When("^Llenar formulario menor diez mil (.*) \"([^\"]*)\" (.*) (.*) \"([^\"]*)\"$")
	public void llenarFormularioDeDatosMenorDiezMil(String numeroCuenta, String tipoId, String numId, String valorAPasar, String banco) throws Exception {
		stepsPasarPlata.llenarFormularioPasarPlataMenorDiezMil(numeroCuenta, tipoId, numId, valorAPasar, banco );
	}
	
	
	@When("^Llenar monto de cuenta inscrita(.*)$")
	public void llenarMontoDeCuentaInscrita(String valorAPasar) throws Exception {
		stepsPasarPlata.llenarMonto(valorAPasar);
	}
	
	
	@When("^Llenar formulario ACH (.*) \"([^\"]*)\" (.*) (.*) \"([^\"]*)\"$")
	public void llenarFormularioDeDatosAch(String numeroCuenta, String tipoId, String numId, String valorAPasar, String banco) throws Exception {
		stepsPasarPlata.llenarFormularioPasarPlataAch(numeroCuenta, tipoId, numId, valorAPasar, banco );
	}
	
	//--------------------------------------------------------------------------

	/*@When("^pasar plata monto seleccionable \"([^\"]*)\" \"([^\"]*)\"$")
	public void pasarPlataMontoSeleccionable(String tipoCuenta, String cuentaNum) {
		stepsPasarPlata.seleccionarTipoCuentaDestino(tipoCuenta, cuentaNum);
		stepsPasarPlata.seleccionarMonto();
	}

	@When("^pasar plata con valor \"([^\"]*)\"\"([^\"]*)\"$")
	public void pasarPlataConValor(String cuentaNum,String monto) throws Exception {
		stepsPasarPlata.seleccionarTipoCuentaDestino(tipoCuenta, cuentaNum);
		stepsPasarPlata.escribirValor(monto);
	}*/

	// Pasar plata cuenta ahorros escribir valor
	
	
	@Then("^pasar plata otro valor \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
	public void pasarPlataOtroValor(String tipoCuenta, String cuentaNum, String monto) {
		// stepsPasarPlata.seleccionarTipoCuentaDestino(tipoCuenta, cuentaNum);
		stepsPasarPlata.seleccionarTipoCuentaDestino(tipoCuenta, cuentaNum);
		stepsPasarPlata.escribirValor(monto);
	}

	// Pasar plata cuenta corriente escoger valor
	/*@When("^pasar plata cuenta corriente \"([^\"]*)\"$")
	public void pasarPlataCuentaCorriente(String cuentaNum) throws Exception {
		stepsPasarPlata.seleccionarCuentaCorriente(tipoCuenta, cuentaNum);
		stepsPasarPlata.seleccionarMonto();
	}*/

	// Pasar plata cuenta corriente escribir valor
	@When("^pasar plata cuenta corriente valor \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
	public void pasarPlataCuentaCorrienteValor(String tipoCuenta, String cuentaNum, String monto) throws Exception {
		stepsPasarPlata.seleccionarCuentaCorriente(tipoCuenta, cuentaNum);
		stepsPasarPlata.escribirValor(monto);
	}

	@Then("^logout redeban$")
	public void logoutRedeban() throws Exception {
		stepsWebRedeban.logOut("//img[@src='/AutorizadorMonWeb/images/pages/logout.gif']");
	}
	
	@Then("^logout redeban vista detallada$")
	public void logoutRedebanVistaDetallada() throws Exception {
		stepsWebRedeban.logOut("//*[@id=\"AS_RespSpander\"]/table/tbody/tr/td/table/tbody/tr[2]/td/img");
	}

	@When("^pasar plata otro banco monto menor al permitido \"([^\"]*)\"$")
	public void pasarPlataOtroBancoMontoMenorAlPermitido(String cuentaNum) throws Exception {
		stepsPasarPlata.seleccionarCuentaCorriente(tipoCuenta, cuentaNum);
		stepsPasarPlata.escribirValorMenor();
	}
	
	@Then("^valido transaccion exitosa$")
	public void validaoTransaccionExitosa() {
		stepsPasarPlata.verificarSaldosDebitoDaviPlata();
	}

	@Then("^validar transaccion exitosa$")
	public void validarTransaccionExitosa() {
		stepsPasarPlata.verificarTransaccionExitosa();
		stepsPasarPlata.verificarSaldosDebitoDaviPlata();
	}
	
	@Then("^validar transaccion fallida$")
	public void validarTransaccionFallida() {
		stepsPasarPlata.verificarTransaccionFallida();
	}
	

	@Then("^validar transaccion exitosa otros bancos$")
	public void validarTransaccionExitosaOtrosBancos() {
		stepsPasarPlata.verificarTransaccionExitosaOtrosBancos();
		stepsPasarPlata.verificarSaldosDebitoDaviPlata();
	} 
	
	@Then("^validar transaccion exitosa dav$")
	public void validarTransaccionExitosaDav() {
		stepsPasarPlata.verificarTransaccionExitosa();
		stepsPasarPlata.verificarSaldosDebitoDaviPlata();
	} 

	@Then("^validar transaccion exitosa bolsillos$")
	public void validarTransaccionExitosaBolsillos() {
		stepsPasarPlata.volver();
		stepsPasarPlata.verificarSaldos();
	}

	@Then("^validar transaccion exitosa volver$")
	public void validarTransaccionExitosaVolver() {
		stepsPasarPlata.verificarTransaccionExitosaa();
		stepsPasarPlata.volver();
	}

	@When("^pasar plata a bolsillos \"([^\"]*)\"$")
	public void pasarPlataABolsillos(String valor) throws Exception {
		stepsPasarPlata.pasarPlataBolsillos(valor);
	}
	@When("^pasar plata a bolsillos desde menu hamburguresa \"([^\"]*)\"$")
	public void pasarPlataABolsilloshamburguesa(String valor) throws Exception {
		stepsPasarPlata.pasarPlataBolsillosHamburguesa(valor);
	}

	@Then("^validar monto$")
	public void validarMonto() {
		stepsPasarPlata.validarMonto();
	}

	@When("^pasar plata otro banco sin cuenta inscrita \"([^\"]*)\"$")
	public void pasarPlataOtroBancoSinCuentaInscrita(String tipoCuenta) {
//		stepsPasarPlata.seleccionarCuantaOtroBancoNoInscrita(tipoCuenta);
		stepsPasarPlata.diligenciarFormularioCuentasNoInscritas(tipoCuenta);
		stepsPasarPlata.procesarTransaccionOtrosBancos(tipoCuenta);
	}

	@When("^pasar plata otro banco cuenta inscrita$")
	public void pasarPlataOtroBancoCuentaInscrita() {
		stepsPasarPlata.seleccionarCuantaOtroBancoInscrita();
		stepsPasarPlata.diligenciarFormularioCuentasInscritas();
		stepsPasarPlata.procesarTransaccionOtrosBancosCtaInscrita();
	}
	
	@When("^pasar plata otro banco \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
	public void pasarPlataOtroBancoMonto(String numeroCuenta, String tipoId, String numId, String monto, String banco) {
		stepsPasarPlata.seleccionarCuentaOtroBanco(numeroCuenta, tipoId, numId, monto, banco);
	}

	@When("^pasar plata otro banco monto menor \"([^\"]*)\"$")
	public void pasarPlataOtroBancoMontoMenor(String tipoCuenta) {
//		stepsPasarPlata.seleccionarCuantaOtroBancoNoInscrita(tipoCuenta);
//		stepsPasarPlata.btnAOtroBanco();
//		stepsPasarPlata.btnCuentasNoInscritas();
		stepsPasarPlata.diligenciarFormularioCuentasNoInscritas(tipoCuenta);
	}

//	@When("^pasar plata otro banco monto menor ")
//	public void pasarPlataOtroBancoMontoMenor() {
//		stepsPasarPlata.seleccionarCuantaOtroBancoNoInscrita(tipoCuenta);
//		stepsPasarPlata.btnAOtroBanco();
//		stepsPasarPlata.btnCuentasNoInscritas();
//		stepsPasarPlata.diligenciarFormularioCuentasNoInscritas(tipoCuenta);
//	}

	@When("^pasar plata otro banco monto inferior")
	public void pasarPlataOtroBancoMontoInferior() {
		//stepsPasarPlata.seleccionarCuantaOtroBancoNoInscrita(tipoCuenta);
		stepsPasarPlata.btnAOtroBanco();
		stepsPasarPlata.btnCuentasNoInscritas();
		stepsPasarPlata.diligenciarFormularioCuentasNoInscritasSaldoMenor(tipoCuenta);
	}

	@Then("^validar transaccion negada$")
	public void validarTransaccionNegada() {
		stepsPasarPlata.validarTransaccionNegada();
	}
	
	@Then("^validar resultado transaccion$")
	public void validarResultadoTransaccion() {
		stepsPasarPlata.validarResultadoTransaccion();
	}
	
	@Then("^validar transaccion negada monto$")
	public void validarTransaccionNegadaMonto() {
		stepsPasarPlata.validarTransaccionNegadaMonto();
	}
	
	@When("^pasar plata valor mayor saldo \"([^\"]*)\"\"([^\"]*)\"$")
	public void pasarPlataValorMayorSaldo(String tipoCuenta, String cuentaNum) {
		stepsPasarPlata.seleccionarTipoCuentaDestino(tipoCuenta, cuentaNum);
		stepsPasarPlata.transaccionConvalorMayorAlSaldo();
	}

	@Then("^consultar saldo final redeban \"([^\"]*)\"$")
	public void consultarSaldoFinalRedeban(String documento) throws Exception {
		stepsPasarPlata.consultaSaldoInicialRedeban(documento);
	}

	@Then("^validar diferencia saldos redeban$")
	public void validarDiferenciaSaldosRedeban() throws Exception {
		stepsPasarPlata.validarDiferenciaSaldosRedeban();
	}

	@Then("^validar igualdad saldos redeban$")
	public void validarIgualdadSaldosRedeban() throws Exception {
		stepsPasarPlata.validarIgualdadSaldosRedeban();
	}
	
	@Then("^Validar Monto Cero$")
	public void validarMontoCero() throws Exception {
		stepsPasarPlata.validarMontoCero();
	}
	
	//****************************VALIDACION REDEBAN*******************************************************************************
	
	
	@Given("^obtener numero celular actual en redeban pasar plata \"([^\"]*)\"$")
	public void obtenerNumeroCelularActualEnRedeban(String usuario) throws Exception {
		numCelular = stepsWebRedeban.consultaNumeroCelular(usuario);
		assertNotNull(numCelular);
	}
	
	@Given("^consultar saldo tarjeta en redeban pasar plata$")
	public void consultarSaldoTarjetaEnRedebanPasarPlata() throws Exception {
		String numTarjeta = stepsWebRedeban.returnNumeroTarjeta();
		ConsultaCupoTarjeta cupoTarjeta = stepsWebRedeban.consultaCuposTarjeta(numTarjeta);
		float realDisponible = Float.parseFloat(cupoTarjeta.getRealDisponible().replace(".", "").replace(",", "."));
		float bolsillos = Float.parseFloat(cupoTarjeta.getSaldoBolsillos().replace(".", "").replace(",", "."));
		saldos.add(realDisponible);
		saldos.add(bolsillos);
		System.out.println("Real Disponible tarjeta " + numTarjeta + ": " + cupoTarjeta.getRealDisponible());
		System.out.println("Bolsillos tarjeta " + numTarjeta + ": " + cupoTarjeta.getSaldoBolsillos());
		String saldoTarjeta = cupoTarjeta.getRealDisponible();
		Serenity.setSessionVariable("saldoTarjeta").to(saldoTarjeta);
	}
	
	@Then("^validar igualdad saldos tarjetas pasar plata \"([^\"]*)\"$")
	public void validarIgualdadSaldosTarjetasPasarPlata(String valorAPasar) throws Exception {
		boolean flag = false;
		int valorTransaccion = Integer.parseInt(valorAPasar);
		int cantidadSaldos = saldos.size();
		if (cantidadSaldos == 4) {
			double sumaPrimeraTarjeta = saldos.get(0) + saldos.get(1);
			double sumaSegundaTarjeta = saldos.get(2) + saldos.get(3);
			
			if(sumaPrimeraTarjeta == sumaSegundaTarjeta) {
				System.out.println("La transaccion no afectó redeban");
			}	else if((sumaSegundaTarjeta) == (sumaPrimeraTarjeta - valorTransaccion)) {
				System.out.println("La transaccion  afectó redeban correctamente");
			}	else {
				System.out.println("Hubo un error");
			}
		}	else {
			System.out.println("No pude validar saldos");
		}
	}
	
	@Given("^obtener numero celular actual en redeban pasar plata cuenta \"([^\"]*)\"$")
	public void obtenerNumeroCelularActualEnRedebanAumentoDeTopes(String usuario) throws Exception {
		numCelular = stepsWebRedeban.consultaNumeroCelular(usuario);
		assertNotNull(numCelular);
	}
	
	@Given("^consultar saldo tarjeta en redeban pasar plata cuenta$")
	public void consultarSaldoTarjetaEnRedebanPasarPlataCuenta() throws Exception {
		String numTarjeta = stepsWebRedeban.returnNumeroTarjeta();
		ConsultaCupoTarjeta cupoTarjeta = stepsWebRedeban.consultaCuposTarjeta(numTarjeta);
		float realDisponible = Float.parseFloat(cupoTarjeta.getRealDisponible().replace(".", "").replace(",", "."));
		float bolsillos = Float.parseFloat(cupoTarjeta.getSaldoBolsillos().replace(".", "").replace(",", "."));
		float acumuladoMensualCredito = Float.parseFloat(cupoTarjeta.getAcumuladoMensualCredito().replace(".", "").replace(",", "."));
		float acumuladoMensualDebito = Float.parseFloat(cupoTarjeta.getAcumuladoMensualDebito().replace(".", "").replace(",", "."));
		saldos.add(realDisponible);
		saldos.add(bolsillos);
		saldos.add(acumuladoMensualCredito); 
		saldos.add(acumuladoMensualDebito);
		System.out.println("Real Disponible tarjeta " + numTarjeta + ": " + cupoTarjeta.getRealDisponible());
		System.out.println("Bolsillos tarjeta " + numTarjeta + ": " + cupoTarjeta.getSaldoBolsillos());
		System.out.println("Acumulado mensual credito " + numTarjeta + ": " + cupoTarjeta.getAcumuladoMensualCredito());
		System.out.println("Acumulado mensual debito " + numTarjeta + ": " + cupoTarjeta.getAcumuladoMensualDebito());
		String acumuladoMensualDebitoRedeban = cupoTarjeta.getAcumuladoMensualDebito(); 
		String acumuladoMensualCreditoRedeban = cupoTarjeta.getAcumuladoMensualCredito(); 
	}
	
	//***********************************TRANSFIYA*********************************************************************
	
	@Given("^ir a la opcion TransfiYA$")
	public void irALaOpcionTransfiYA() throws Exception {
		stepsPasarPlata.irATransfiYa();
	}
	
	@Given("^ir a la opcion 'Recibir y Pedir Plata'$")
	public void irALaOpcionRecibirYPedirPlata() throws Exception {
		stepsPasarPlata.irARecibirYPedir();
	}
	
	@Given("^Ir a la opcion 'Recibir y Pedir Plata' validando solicitud$")
	public void irALaOpcionRecibirYPedirPlataValidandoSolicitud() throws Exception {
		stepsPasarPlata.irARecibirYPedirValidandoSolicitud();
	}
	
	@Given("^Valido solicitudes de plata pendientes$")
	public void validoSolicitudesDePlataPendientes() throws Exception {
		stepsPasarPlata.validarSolicitudes();
	}
	
	@Given("^aceptar y validar transferencia denegada$")
	public void aceptarValidarTransferenciaDenegada() throws Exception {
		stepsPasarPlata.aceptarYValidarTransferenciaDenegada();
	}
	
	@Given("^selecciono opcion TransfiYa$")
	public void seleccionoOpcionTransfiYa() throws Exception {
		stepsPasarPlata.darClickOpcionTransfiYa();
	}
	
	@Given("^selecciono opcion Abonos Frecuentes$")
	public void seleccionoOpcionAbonosFrecuentes() throws Exception {
		stepsPasarPlata.darClickOpcionAbonosFrecuentes();
	}
	
	@Given("^realizo flujo pedir plata en linea \"([^\"]*)\" \"([^\"]*)\"$")
	public void realizoFlujoPasarPlataEnLinea(String numCelular, String monto) throws Exception {
		stepsPasarPlata.realizarFlujoPedirPlata(numCelular, monto);
	}
	
	@Given("^Realizo flujo pasar plata transfiya \"([^\"]*)\" \"([^\"]*)\"$")
	public void realizoFlujoPasarPlataTransfiya(String numCelular, String monto) throws Exception {
		stepsPasarPlata.realizarFlujoPasarPlataTransfiya(numCelular, monto);
	}
	
	@Given("^Realizo el flujo de 'Pedir Plata en Linea' \"([^\"]*)\" \"([^\"]*)\"$")
	public void realizoElFlujoDePedirPlataEnLinea(String numCelular, String monto) throws Exception {
		stepsPasarPlata.realizarFlujoPedirPlataEnLinea(numCelular, monto);
	}
	
	@Given("^valido resultado transaccion exitosa$")
	public void validoResultadoTransaccionExitosa() throws Exception {
		stepsPasarPlata.validoResultadoTransaccionExitosa();
	}
	
	@Given("^valido resultado solicitud exitosa$")
	public void validoResultadoSolicitudExitosa() throws Exception {
		stepsPasarPlata.validoResultadoSolicitudExitosa();
	}
	
	@Given("^valido resultado solicitud rechazada$")
	public void validoResultadoSolcitudRechazada() throws Exception {
		stepsPasarPlata.validarResultadoSolicitudRechazada();
	}
	
	@Given("^valido resultado transaccion rechazada$")
	public void validoResultadoTransaccionRechazada() throws Exception {
		stepsPasarPlata.validarResultadoTransaccionRechazada();
	}
	
	@Given("^validar saldo final$")
	public void validarSaldoFinal() throws Exception {
		stepsPasarPlata.validarSaldoFinalSinAceptacion();
	}
	
	@Given("^Regreso al home desde trasnsaccion$")
	public void regresoAlHomeDesdeTransaccion() throws Exception {
		stepsPasarPlata.regresarAlHome();
	}
	
	@When("^valido afectacion debito cuenta en redeban \"([^\"]*)\"$")
	public void validoAfectacionDebitoCuentaEnRedeban(String monto) throws Exception {
		try {
			contador++;
			double sumaPrimeraTarjeta = 0;
			double sumaSegundaTarjeta = 0;
			double montoTx = Integer.parseInt(monto);
			boolean flag = false;
			int cantidadSaldos = saldos.size();
			if (cantidadSaldos == 8) {
				 sumaPrimeraTarjeta = saldos.get(0) + saldos.get(1);
				 sumaSegundaTarjeta = saldos.get(4) + saldos.get(5);
			}
				assertThat(sumaSegundaTarjeta, equalTo(sumaPrimeraTarjeta -montoTx));
				System.out.println("La transacción afecto correctamente el saldo en redeban");
		}catch(Exception e) {
			if(!(contador==10)) {
				Utilidades.esperaMiliseg(2000);
				validoAfectacionDebitoCuentaEnRedeban(monto);
			}else {
				fail("No se pudo validar saldos debido a: " + e.getMessage());
			}
		}finally {contador=0;}}
	
	
	@When("^valido afectacion credito cuenta en redeban \"([^\"]*)\"$")
	public void validoAfectacionCreditoCuentaEnRedeban(String monto) throws Exception {
		try {
			contador++;
			double sumaPrimeraTarjeta = 0;
			double sumaSegundaTarjeta = 0;
			double montoTx = Integer.parseInt(monto);
			boolean flag = false;
			int cantidadSaldos = saldos.size();
			if (cantidadSaldos == 8) {
				 sumaPrimeraTarjeta = saldos.get(0) + saldos.get(1);
				 sumaSegundaTarjeta = saldos.get(4) + saldos.get(5);
			}
				assertThat(sumaSegundaTarjeta, equalTo(sumaPrimeraTarjeta + montoTx));
				System.out.println("La transacción afecto correctamente el saldo en redeban");
		}catch(Exception e) {
			if(!(contador==10)) {
				Utilidades.esperaMiliseg(2000);
				validoAfectacionCreditoCuentaEnRedeban(monto);
			}else {
				fail("No se pudo validar saldos debido a: " + e.getMessage());
			}
		}finally {contador=0;}}
	
	@When("^valido afectacion cuenta en redeban GMF \"([^\"]*)\"$")
	public void validoAfectacionCuentaEnRedebanGMF(String monto) throws Exception {
		try {
			contador++;
			double sumaPrimeraTarjeta = 0;
			double sumaSegundaTarjeta = 0;
			double montoTx = Integer.parseInt(monto);
			montoTx = montoTx + (montoTx * 0.004);
			boolean flag = false;
			int cantidadSaldos = saldos.size();
			if (cantidadSaldos == 8) {
				 sumaPrimeraTarjeta = saldos.get(0) + saldos.get(1);
				 sumaSegundaTarjeta = saldos.get(4) + saldos.get(5);
			}
				assertThat(sumaSegundaTarjeta, equalTo(sumaPrimeraTarjeta -montoTx));
				System.out.println("La transacción afecto correctamente el saldo en redeban");
		}catch(Exception e) {
			if(!(contador==10)) {
				Utilidades.esperaMiliseg(2000);
				validoAfectacionCuentaEnRedebanGMF(monto);
			}else {
				fail("No se pudo validar saldos debido a: " + e.getMessage());
			}
		}finally {contador=0;}}
	
	
	@When("^valido igualdad saldos en redeban$")
	public void validoIgualdadSaldosEnRedeban() throws Exception {
		try {
			contador++;
			double sumaPrimeraTarjeta = 0;
			double sumaSegundaTarjeta = 0;
			boolean flag = false;
			int cantidadSaldos = saldos.size();
			if (cantidadSaldos == 8) {
				 sumaPrimeraTarjeta = saldos.get(0) + saldos.get(1);
				 sumaSegundaTarjeta = saldos.get(4) + saldos.get(5);
			}
				assertThat(sumaSegundaTarjeta, equalTo(sumaPrimeraTarjeta));
				System.out.println("La transacción no afectó redeban, los saldos son iguales");
		}catch(Exception e) {
			if(!(contador==10)) {
				Utilidades.esperaMiliseg(2000);
				validoIgualdadSaldosEnRedeban();
			}else {
				fail("No se pudo validar saldos debido a: " + e.getMessage());
			}
		}finally {contador=0;}
	}
		
	@Given("aceptar solicitud pendiente \"([^\"]*)\"$")
	public void aceptarSolicitudPendiente(String monto) throws Exception {
		stepsPasarPlata.aceptarSolicitudPendiente(monto);
	}
	
	@Given("rechazar solicitud pendiente \"([^\"]*)\"$")
	public void rechazarSolicitudPendiente(String monto) throws Exception {
		stepsPasarPlata.rechazarSolicitudPendiente(monto);
	}
	
	@Given("^valido cliente GMF en redeban \"([^\"]*)\"$")
	public void validarEstadoActualExcenta4x1000(String usuario) throws Exception {
		String estadoExenta = stepsWebRedeban.consultaEstadoExcepcion(usuario);
		stepsPasarPlata.validarClienteGMF(estadoExenta);
	}

	@Given("^valido descripcion pop up TransfiYa$")
	public void validoDescripcionPopUpTransfiYa() throws Exception {
		stepsPasarPlata.validarDescripcionPopUpTransfiYa();
	}
	
	@Given("^valido lista contactos abonos frecuentes$")
	public void validoListaContactosAbonosFrecuentes() throws Exception {
		stepsPasarPlata.validarListaContactosAbonosFrecuentes();
	}
	
	@Given("^valido monto es mayor a tope credito \"([^\"]*)\"$")
	public void validoMontoEsMayorATopeCredito(String monto) throws Exception {
		stepsPasarPlata.validarMontoEsMayorATopeCredito(monto);
	}
	
	@Given("^valido monto es mayor a tope debito \"([^\"]*)\"$")
	public void validoMontoEsMayorATopeDebito(String monto) throws Exception {
		stepsPasarPlata.validarMontoEsMayorATopeDebito(monto);
	}
	
	@Given("^logout redeban subtipo$")
	public void logoutRedebanSubtipo() throws Exception {
		stepsWebRedeban.logOut("//*[@id='AS_RespSpander']/table/tbody/tr/td/table/tbody/tr[2]/td/img");
	}
	
	@Given("^Validar en redeban subtipo topes \"([^\"]*)\" \"([^\"]*)\"$")
	public void validarEnRedebanSubtipo(String cuenta, String subtipo) throws Exception {
		BaseUtil.montoTrasadoRedeban = stepsWebRedeban.consultasubtipoTopes(cuenta, subtipo);
	}

	@Given("^Consulté saldo disponible en redeban$")
	public void consultarSaldoTarjetaEnRedebanBolsillos() throws Exception {
		String numTarjeta = stepsWebRedeban.returnNumeroTarjeta();
		ConsultaCupoTarjeta cupoTarjeta = stepsWebRedeban.consultaSaldoRealDaviplata(numTarjeta);
		
		BigDecimal realDisponibleParaComparar = new BigDecimal(cupoTarjeta.getRealDisponible().replace(".", "").replace(",", "."));
		String realString = String.valueOf(realDisponibleParaComparar);
        int longitud = realString.length();
        int numero = longitud - 2;
        realString = realString.substring(0, numero); 
		BigDecimal numSaldoRealDisponible = new BigDecimal(realString);
		Serenity.setSessionVariable("saldoReal").to(numSaldoRealDisponible);

		float disponible = realDisponibleParaComparar.floatValue();
		saldos.add(disponible);
		System.out.println("Real disponible tarjeta " + numTarjeta + ": " + cupoTarjeta.getRealDisponible());
	}
	
	
	
	@Then("^Validar afectacion de saldos en redeban y daviplata$")
	public void validarIgualdadSaldosTarjetas() throws Exception {
		try {
			System.out.println("base.saldo: " + BaseUtil.saldo);
			System.out.println("base.saldoFin: " + BaseUtil.saldoFinal);
			
			String saldo = String.valueOf(BaseUtil.saldo);
			int cantidad = saldo.length();
			int numero = cantidad - 2;
			saldo = saldo.substring(0, numero);
			
			BigDecimal saldoInicial = new BigDecimal(saldo); 
			
			double saldoDaviplata1 = BaseUtil.saldo.doubleValue();
			double saldoDaviplata2 = BaseUtil.saldoFinal.doubleValue();
			
			System.out.println("Saldo 1: " + saldoInicial);
			System.out.println("Saldo 2: " + saldoDaviplata2);
			
			assertThat(BaseUtil.saldo, not(equalTo(BaseUtil.saldoFinal)));
			System.out.println("La transacción si afecto el saldo inicial del daviplata");
			double saldoRedeban1 = saldos.get(0);
			double saldoRedeban2 = saldos.get(1);

			assertThat(saldoRedeban1, not(equalTo(saldoRedeban2)));
			System.out.println("La transacción si afectó saldo inicial en redeban");

		} catch (Exception e) {
			fail("No se pudo validar saldos del Daviplata, debido a: " + e.getMessage());
		}
	}

	@Then("^Validar igualdad saldos$")
	public void validarIgualdadSaldos() throws Exception {
		try {
			System.out.println("Saldo inicial: " + BaseUtil.saldo);
			System.out.println("Saldo final: " + BaseUtil.saldoFinal);
			
			String saldo = String.valueOf(BaseUtil.saldo);
			int cantidad = saldo.length();
			int numero = cantidad - 2;
			if(cantidad > 2) {
				saldo = saldo.substring(0, numero);	
			}
			
			BigDecimal saldoInicial = new BigDecimal(saldo); 
			
			double saldoDaviplata1 = BaseUtil.saldo.doubleValue();
			double saldoDaviplata2 = BaseUtil.saldoFinal.doubleValue();
			
			System.out.println("Saldo 1: " + saldoInicial);
			System.out.println("Saldo 2: " + saldoDaviplata2);
			
			assertThat(BaseUtil.saldo, is(equalTo(BaseUtil.saldoFinal)));
			System.out.println("***La transacción no afecto el saldo inicial del daviplata***");

			double saldoRedeban1 = saldos.get(0);
			double saldoRedeban2 = saldos.get(1);

			assertThat(saldoRedeban1, is(equalTo(saldoRedeban2)));
			System.out.println("***La transacción no afectó saldo inicial en redeban***");

		} catch (Exception e) {
			fail("No se pudo validar saldos del Daviplata, debido a: " + e.getMessage());
		}
	}


	@Given("^Consulté saldo disponible en redeban GMF$")
	public void consultarSaldoTarjetaEnRedebanGmf() throws Exception {
		String numTarjeta = stepsWebRedeban.returnNumeroTarjeta();
		ConsultaCupoTarjeta cupoTarjeta = stepsWebRedeban.consultaSaldoGmfDaviplata(numTarjeta);
		BigDecimal realDisponibleGmf = new BigDecimal(cupoTarjeta.getSaldoDisponible4x1000().replace(".", "").replace(",", "."));
		BigDecimal acumuladoGmf = new BigDecimal(cupoTarjeta.getAcumulado4x1000().replace(".", "").replace(",", "."));
		String realStringGmf = String.valueOf(realDisponibleGmf);
		String realAcumuladoStringGmf = String.valueOf(acumuladoGmf);
        int longitud = realStringGmf.length();
        int longitud2 = realAcumuladoStringGmf.length();
        int numero = longitud - 2;
        int numero2 = longitud2 - 2;
        realStringGmf = realStringGmf.substring(0, numero); 
        realAcumuladoStringGmf = realAcumuladoStringGmf.substring(0, numero2); 
		BigDecimal numSaldoDisponibleGmf = new BigDecimal(realStringGmf);
		BigDecimal numSaldoAcumuladoGmf = new BigDecimal(realAcumuladoStringGmf);
		Serenity.setSessionVariable("saldoRealGmf").to(numSaldoDisponibleGmf);
		Serenity.setSessionVariable("saldoAcumuladoGmf").to(numSaldoAcumuladoGmf);

		float disponibleGmf = realDisponibleGmf.floatValue();
		float acumuladosGmf = acumuladoGmf.floatValue();
		saldos.add(disponibleGmf);
		saldos.add(acumuladosGmf);
		System.out.println("Real disponible tarjeta " + numTarjeta + ": " + cupoTarjeta.getSaldoDisponible4x1000());
	}
	
	@Given("^Validé saldos iniciales del daviplata GMF$")
	public void validarSaldosInicialesGmf() {
		stepsPasarPlata.verificarSaldoInicialDaviplataGmf();
	}

	@Then("^Extraer cobro GMF$")
	public void ExtraerCobroGmf() throws Exception {
		try {
			double acumuladoGmf1 = saldos.get(1);
			double acumuladoGmf2 = saldos.get(3);

			assertThat(acumuladoGmf1, not(equalTo(acumuladoGmf2)));
			double extraerAcumuladoGmf = acumuladoGmf2 - acumuladoGmf1;
			Utilidades.tomaEvidenciaPantalla("El cobro GMF fue de " + extraerAcumuladoGmf);

		} catch (AssertionError e) {
			fail("No se pudo validar acumulado GMF del Daviplata, debido a: " + e.getMessage());
		}
	}
	
	@Then("^Validar afectacion de saldos en redeban y daviplata GMF$")
	public void validarIgualdadSaldosTarjetasGmf() throws Exception {
		try {
			double saldoDaviplata1 = BaseUtil.saldoInicial.doubleValue();
			double saldoDaviplata2 = BaseUtil.saldoFinal.doubleValue();

			assertThat(saldoDaviplata1, not(equalTo(saldoDaviplata2)));
			System.out.println("La transacción si afecto el saldo inicial del daviplata");
			System.out.println(saldos);
			double saldoRedeban1 = saldos.get(0);
			double saldoRedeban2 = saldos.get(2);

			assertThat(saldoRedeban1, not(equalTo(saldoRedeban2)));
			System.out.println("La transacción si afectó saldo inicial en redeban");

		} catch (Exception e) {
			fail("No se pudo validar saldos del Daviplata, debido a: " + e.getMessage());
		}
	}
	
	@Then("^Validar en redeban la transansaccion\"([^\"]*)\"$")
	public void validarEnRedeban(String cuenta) throws Exception {
		System.out.println("base: " + BaseUtil.Autorizador);
		BaseUtil.idTransaccion = BaseUtil.Autorizador;
		BaseUtil.montoTrasadoRedeban = stepsWebRedeban.consultaDiaria3(cuenta, BaseUtil.Autorizador);
	}

	@Given("^Validé saldos iniciales del daviplata$")
	public void validarSaldosIniciales() {
		stepsPasarPlata.verificarSaldoInicialDaviplata();
	}
	
	@Given("^Valido saldo inicial usuario recien registrado$")
	public void validoSaldoInicialUsuarioRecienRegistrado() {
		stepsPasarPlata.validarSaldoInicialNuevoUsuario();
	}
	
	@Given("^validar transaccion destino$")
	public void validarTransaccionDestino() {
		stepsPasarPlata.validarTransaccionDestino();
	}
	
	@Then("^validar transaccion exitosa Pasar Plata$")
	public void validarTransaccionExitosaPasarPlata() {
		stepsPasarPlata.verificarTransaccionExitosaPasarPlata();
		stepsPasarPlata.verificarSaldos();
	}
	
	@When("^Pasar plata a otro Daviplata tope debitos \"([^\"]*)\"$")
	public void pasarPlataAOtroDaviplataTopeDebitos(String numero) throws Exception {
		stepsPasarPlata.pasarPlataAOtroDaviplataTopeDebitos(numero);
	}

	@When("^Paso plata a otro Daviplata \"([^\"]*)\" \"([^\"]*)\"$")
	public void pasoPlataAOtroDaviplata(String numero, String monto) throws Exception {
		stepsPasarPlata.pasarPlataAOtroDaviplataMonto(numero, monto);
	}

	@Then("^Validar en redeban la transaccion de switch \"([^\"]*)\"$")
	public void validarEnRedebanSwitch(String cuenta) throws Exception {
		System.out.println("base: " + BaseUtil.Autorizador);
		BaseUtil.idTransaccion = BaseUtil.Autorizador;
		BaseUtil.montoTrasadoRedeban = stepsWebRedeban.consultaDiariaSwitch(cuenta, BaseUtil.Autorizador);
	}

	@When("^pasar plata monto seleccionable cero \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void pasarPlataMontoSeleccionableCero(String tipoCuenta, String numCuenta, String monto) throws Exception {
		stepsPasarPlata.escogerOpcionCuentasDavivienda();
		stepsPasarPlata.escogerOpcionTipoCuentaDavivienda(tipoCuenta);
		stepsPasarPlata.ingresarNumeroCuentaDavivienda(numCuenta);
		stepsPasarPlata.ingresarMontoCuentaDaviviendaCero(monto);
	}
	
	@When("^Pasar plata monto seleccionable tope debitos \"([^\"]*)\" \"([^\"]*)\"$")
	public void pasarPlataMontoSeleccionable(String tipoCuenta, String numCuenta) throws Exception {
		stepsPasarPlata.escogerOpcionCuentasDavivienda();
		stepsPasarPlata.escogerOpcionTipoCuentaDavivienda(tipoCuenta);
		stepsPasarPlata.ingresarNumeroCuentaDavivienda(numCuenta);
		stepsPasarPlata.ingresarMontoCuentaDaviviendaTopeDebitos();
	}
	

	@When("Ingreso a la opcion pasar plata en el home daviplata$")
	public void ingresoALaOpcionPasarPlataHome() throws Exception {
		stepsPasarPlata.ingesoALaOpcionPasarPlataHome();
	}
	@When("^Pasar plata monto \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void pasarPlataMonto(String tipoCuenta, String numCuenta, String monto) throws Exception {
		stepsPasarPlata.escogerOpcionCuentasDavivienda();
		stepsPasarPlata.escogerOpcionTipoCuentaDavivienda(tipoCuenta);
		stepsPasarPlata.ingresarNumeroCuentaDavivienda(numCuenta);
		stepsPasarPlata.ingresarMontoCuentaDaviviendaPasarPlata(monto);
	}
	@Then("^Validar boton inhabilitado home$")
	public void ValidarBotonPasarPlataInhabilitadoHome() throws Exception {
		stepsPasarPlata.validarBotonInhabilitado();
	}
	@When("^Pasar plata cuentas inscritas \"([^\"]*)\"$")
	public void pasarPlataCuentaInscritas(String monto) throws Exception {
		stepsPasarPlata.escogerOpcionCuentasDaviviendaInscritas();
		stepsPasarPlata.ingresarMontoCuentaInscritas(monto);

	}
	
	@When("^Pasar plata monto seleccionable a cuentas con valor cero \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void pasarPlataMontoSeleccionableMontoCero(String tipoCuenta, String numCuenta, String monto) throws Exception {
		stepsPasarPlata.escogerOpcionCuentasDavivienda();
		stepsPasarPlata.escogerOpcionTipoCuentaDavivienda(tipoCuenta);
		stepsPasarPlata.ingresarNumeroCuentaDavivienda(numCuenta);
		stepsPasarPlata.ingresarMontoCeroCuentaDavivienda(monto);
		 TouchAction touchAction=new TouchAction(driver);
	        touchAction.tap(new PointOption().withCoordinates(20, 352)).perform();
	}
	
	@Then("^Validar Monto Cero cuentas Davivienda$")
	public void validarMontoCeroCuentas() throws Exception {
		stepsPasarPlata.validarMontoCeroCuentas();
	}

	@When("^Pasar plata valor mayor saldo diponible \"([^\"]*)\"\"([^\"]*)\"$")
	public void pasarPlataValorMayorSaldoDisponible(String tipoCuenta, String cuentaNum) {
		stepsPasarPlata.seleccionarTipoCuentaDestino(tipoCuenta, cuentaNum);
		stepsPasarPlata.ingresarMayorSaldoDisponible();
	}
	
	@Then("^Validar transacción negada por valor superior al saldo disponible$")
	public void validarTransaccionNegadaSaldoSuperior() {
		stepsPasarPlata.validarMensajeMontoSuperiorAlSaldoDisponible();
	}
	
	@Then("^Validar mensaje fondos insuficientes$")
	public void validarMensajeFondosInsuficientes() {
		stepsPasarPlata.validarMensajeFondosInsuficientes();
	}
	
	@When("^Pasar plata otro banco monto inferior otros bancos (.*) \"([^\"]*)\" (.*) (.*) \"([^\"]*)\"$")
	public void llenarFormularioSaldoInferiorOtrosBancos(String numeroCuenta, String tipoId, String numId, String valorAPasar, String banco) throws Exception {
		stepsPasarPlata.llenarFormularioMontoInferiorOtrosBancos(numeroCuenta, tipoId, numId, valorAPasar, banco );
	}
	
	@Then("^Validar mensaje valor inferior$")
	public void validarMensajeValorInferior() {
		stepsPasarPlata.validarMensajeValorInferior();
	}
	
	@Then("^Validar igualdad de saldos en redeban y daviplata GMF$")
	public void validarIgualdadDeSaldosEnRedebanYDaviplataGmf() throws Exception {
		try {
			double saldoDaviplata1 = BaseUtil.saldo.doubleValue();
			double saldoDaviplata2 = BaseUtil.saldoFinal.doubleValue();

			assertThat(saldoDaviplata1, is(equalTo(saldoDaviplata2)));
			System.out.println("La transacción si afecto el saldo inicial del daviplata");
			System.out.println(saldos);
			double saldoRedeban1 = saldos.get(0);
			double saldoRedeban2 = saldos.get(2);

			assertThat(saldoRedeban1, is(equalTo(saldoRedeban2)));
			System.out.println("La transacción si afectó saldo inicial en redeban");

		} catch (Exception e) {
			fail("No se pudo validar saldos del Daviplata, debido a: " + e.getMessage());
		}
	}
		
	@When("^Pasar plata a otro Daviplata añadiendo cuenta a favoritos \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void pasarPlataAOtroDaviplataAñadiendoCuentaAFavoritos(String numero,String monto,String nombreContactoFavorito) throws Exception {
        stepsPasarPlata.pasarPlataAOtroDaviplataAñadiendoCuentaAFavoritos(numero,monto,nombreContactoFavorito);
    }
	
	@Given("^Valido enmascaramiento del numero de transaccion$")
	public void validoEnmascaramientoDelNumeroDeTransaccion() {
		stepsPasarPlata.validarEnmascaramiento();
	}


	@Then("^Valido transaccion fecha actual y anterior$")
	public void validoTransaccionFechaActualYAnterior() {
		stepsPasarPlata.validarTransaccionFechas();
	}
	
	@Then("^Validar aun no tiene movimientos home$")
	public void validarAunNoTieneMovimientosHome() {
		stepsPasarPlata.validarNoMovimientos();
	}
}
			

