package daviplata.nacional.iOS.definitions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import daviplata.nacional.iOS.steps.LoginSteps;
import daviplata.nacional.iOS.steps.PasarPlataSteps;
import daviplata.nacional.iOS.steps.MeterPlataSteps;
import daviplata.nacional.iOS.modelo.ConsultaCupoTarjeta;
import daviplata.nacional.iOS.steps.WebRedebanSteps;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import daviplata.nacional.iOS.utilidades.Utilidades;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class BolsilloDefinitions {
	
	
	@Steps
	PasarPlataSteps stepsPasar;
	@Steps
	LoginSteps stepsLogin;
	@Steps
	MeterPlataSteps stepsMeter;
	@Steps
	private WebRedebanSteps stepsWebRedeban;
	ArrayList<Float> saldos = new ArrayList<Float>();
	String numCelular = "";
	
	@When("^ingreso a la opcion bolsillo desde home$")
	public void ingresoABolsillosHome() throws Exception {
		stepsLogin.ingresoABolsillosHome();
	}
	
	@When("^ingreso a perfil persona$")
	public void ingresarAPerfilPersona() throws Exception {
		stepsLogin.ingresoAPerfilPersona();
	}
	
	@When("^ingreso a menu hamburguesa$")
	public void ingresarAMenuHamburguesa() throws Exception {
		stepsLogin.ingresoAMenuHamburguesa();
	}
	
	@When("^selecciono bolsillos \"([^\"]*)\"$")
	public void seleccionoBolsillos(boolean verificador) throws Exception {
		stepsPasar.ingresarABolsillos(verificador);
	}
	@When("^Flujo de crear bolsillo \"([^\"]*)\"$")
	public void flujoDeCrearBolsillo(String valorDisponible) throws Exception {
		stepsPasar.crearBolsillo(valorDisponible);
	}
	@When("^Flujo de crear bolsillo desde header home \"([^\"]*)\"$")
	public void flujoDeCrearBolsilloHamburguesa(String monto) throws Exception {
		stepsPasar.crearBolsilloHamburguesa(monto);
	}
	@When("^flujo de crear maximos bolsillos \"([^\"]*)\"$")
	public void flujoDeCrearMaximosBolsillos(String monto) throws Exception {
		stepsPasar.crearMaximosBolsillos(monto);
		}
	@When("^flujo de crear bolsillo por periodo \"([^\"]*)\" \"([^\"]*)\"$")
	public void flujoDeCrearBolsilloPorPeriodo(String monto, String periodo) throws Exception {
		stepsPasar.crearBolsilloPeriodo(monto, periodo);
	}

	@Then("^valido creacion de bolsillo$")
	public void validoCreacionDeBolsillo() throws Exception {
		stepsPasar.validoBolsilloCreado();
	}

	@When("^flujo de eliminar bolsillos$")
	public void flujoDeEliminarBolsillos() throws Exception {
		stepsPasar.eliminarBolsillo();
	}
	@When("^flujo de modificar bolsillos \"([^\"]*)\"$")
	public void flujoDeModificarBolsillos(String periodo) throws Exception {
		stepsPasar.modificarBolsillo(periodo);
	}
	@When("^flujo de bolsillos modificar hamburguesa \"([^\"]*)\"$")
	public void flujoDeModificarBolsillosHamburguesa(String periodo) throws Exception {
		stepsPasar.modificarBolsilloHamburguesa(periodo);
	}
	@Then("^valido eliminacion de bolsillo$")
	public void validoEliminacionDeBolsillo() throws Exception {
		stepsPasar.validarEliminacion();
	}
	@Then("^valido modificacion de bolsillo$")
	public void validoModificacionBolsillo() {
		stepsPasar.validoModificacionBolsillo();
	}
	@Then("^validar modificacion bolsillo$")
	public void validarModificacionBolsillo() {
	}
	@Then("^valido mesaje de maximos bolsillos creados$")
	public void validoMensajeNoMasBolsillos() {
		stepsPasar.ValidarMensajeMaximoBolsillos();
	}
	@When("^flujo sacar plata bolsillos \"([^\"]*)\"$")
	public void flujoSacarPlataBolsillos(String monto) throws Exception {
	    stepsPasar.sacarPlataBolsillo(monto);
	    
	}

	@When("^flujo sacar plata bolsillos mayor a lo que tiene el bolsillo$")
	public void flujoSacarPlataBolsillosMayorSaldoBolsillo() throws Exception {
	    stepsPasar.sacarPlataBolsilloMayorSaldoBolsillo();
	    
	}

	@Then("^valido el pasar plata bolsillos a daviplata$")
	public void validoElPasarPlataBolsillos() throws Exception {
		stepsPasar.validarPasarPlataBolsillosADaviplata();
	}
	
	@Then("^valido el pasar plata daviplata a bolsillos$")
	public void validoElPasarPlataDaviPlataABolsillos() throws Exception {
		stepsPasar.validarSaldoFinalBolsillos();
		
	}
	
	@Then("^valido el mensaje excede monto$")
	public void validoMensajeExcedeMonto() throws Exception {
		stepsPasar.cerrarPopup();
	    stepsPasar.validarMensajeExcedeMonto();
	    stepsPasar.verificarIgualdadSaldoDaviPlata();
	}
	
	
	
	@Given("^obtener numero celular actual en redeban bolsillos \"([^\"]*)\"$")
	public void obtenerNumeroCelularActualEnRedeban(String usuario) throws Exception {
		numCelular = stepsWebRedeban.consultaNumeroCelular(usuario);
		BaseUtil.numeroCelularRedeban = numCelular;
		assertNotNull(numCelular);
	}
	
	@Given("^consultar saldo tarjeta en redeban bolsillos$")
	public void consultarSaldoTarjetaEnRedebanBolsillos() throws Exception {
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
		System.out.println("Voy a entrar al metodo de cerrar sesión");
		Utilidades.esperaMiliseg(1000);
		stepsWebRedeban.logOut("//img[@src='/AutorizadorMonWeb/images/pages/logout.gif']");
	}
	
	
	@Then("^validar igualdad saldos tarjetas bolsillos$")
	public void validarIgualdadSaldosTarjetasCasita() throws Exception {
		int cantidadSaldos = saldos.size();
		
		try {
			
			assertThat(cantidadSaldos, is(equalTo(4)));
			double sumaPrimeraTarjeta = saldos.get(0) + saldos.get(1);
			double sumaSegundaTarjeta = saldos.get(2) + saldos.get(3);
			
			assertThat(sumaPrimeraTarjeta, is(equalTo(sumaSegundaTarjeta)));
			System.out.println("La transacción no afectó redeban");
				
		}catch(Exception e) {
			fail("No se pudo validar igualdad de saldos debido a: " + e.getMessage());
		}
}

	
	@Then("^validar afectacion saldos tarjetas bolsillos \"([^\"]*)\"$")
	public void validarIgualdadSaldosTarjetasCasita(String monto) throws Exception {
		double montoInt = Double.parseDouble(monto);
		int cantidadSaldos = saldos.size();
		try {
			
			assertThat(cantidadSaldos, is(equalTo(4)));
			double sumaPrimeraTarjeta = saldos.get(0);
			double sumaSegundaTarjeta = saldos.get(2); 
			
			assertThat(sumaSegundaTarjeta, is(equalTo(sumaPrimeraTarjeta - montoInt)));
			System.out.println("La transacción afectó la cuenta del cliente en redeban");
				
		}catch(Exception e) {
			fail("No se pudo validar la afectacion de saldos en redeban debido a: " + e.getMessage());
		}
	}
}
	
	
	
	
	


