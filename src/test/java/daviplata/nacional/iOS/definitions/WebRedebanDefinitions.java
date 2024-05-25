package daviplata.nacional.iOS.definitions;

import java.math.BigDecimal;

import cucumber.api.Scenario;
import daviplata.nacional.iOS.pageObjects.HomePageObjects;
import daviplata.nacional.iOS.pageObjects.LoginPageObjects;
import daviplata.nacional.iOS.pageObjects.MenuHamburguesaPageObjects;
import daviplata.nacional.iOS.pageObjects.PasarPlataPageObjects;
import daviplata.nacional.iOS.pageObjects.RecargaPageObjects;
import daviplata.nacional.iOS.steps.AumentoDeTopesSteps;
import daviplata.nacional.iOS.steps.WebRedebanSteps;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import daviplata.nacional.iOS.utilidades.Utilidades;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import net.thucydides.core.annotations.Steps;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import daviplata.nacional.iOS.modelo.ConsultaCupoTarjeta;
import daviplata.nacional.iOS.steps.AumentoDeTopesSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import daviplata.nacional.iOS.steps.WebRedebanSteps;
import daviplata.nacional.iOS.utilidades.Utilidades;

public class WebRedebanDefinitions {
	
	Hooks Hooks;
	LoginPageObjects pageLogin;
	PasarPlataPageObjects pagePasarPlata;
	BaseUtil base;
	HomePageObjects pageHome;
	RecargaPageObjects pageRecarga;
	MenuHamburguesaPageObjects menuHamburguesaPageObjects;
	BigDecimal valorHome = null;
	BigDecimal valorTransferencia = null;
	private Scenario scenario = Hooks.scenario;
	private AppiumDriver<MobileElement> driver = Hooks.getDriver();
	Utilidades utilidad;
	Utilidades Utilidades;
	ArrayList<Float> saldos = new ArrayList<Float>();
	static String numCelular = "";
	
	@Steps
	WebRedebanSteps stepsWebRedeban;
	
	
	@Given("^consultar saldo tarjeta en redeban \"([^\"]*)\"$")
    public void consultarSaldoTarjetaEnRedeban(String usuario) throws Exception {
        stepsWebRedeban.ingresoNumeroClienteRedeban(usuario);
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
	
	@Then("^logout redeban iOS$")
    public void logoutRedeban() throws Exception {
        stepsWebRedeban.logOut("//img[@src='/AutorizadorMonWeb/images/pages/logout.gif']");
    }
	
	@Then("^validar afectacion saldos tarjetas de daviplata a bolsillos$")
	public void validarIgualdadSaldosTarjetasDaviplataBolsillos() throws Exception {
		double montoInt = base.montoTransado.doubleValue();
		int cantidadSaldos = saldos.size();
		try {
			
			assertThat(cantidadSaldos, is(equalTo(4)));
			double sumaPrimeraTarjeta = saldos.get(1);
			double sumaSegundaTarjeta = saldos.get(3);
			
			assertThat(sumaSegundaTarjeta, is(equalTo(sumaPrimeraTarjeta + montoInt)));
			System.out.println("La transacción afectó la cuenta del cliente en redeban");
				
		}catch(Exception e) {
			fail("No se pudo validar la afectacion de saldos en redeban debido a: " + e.getMessage());
		}
	}
	
	@Then("^validar afectacion saldos tarjetas de bolsillos a daviplata$")
	public void validarIgualdadSaldosTarjetasBolsillosDaviplataEliminacion() throws Exception {
		
		double montoInt = base.montoTransado.doubleValue();
		int cantidadSaldos = saldos.size();
		try {
			
			assertThat(cantidadSaldos, is(equalTo(4)));
			double sumaPrimeraTarjeta = saldos.get(0);
			double sumaSegundaTarjeta = saldos.get(2); 
			
			assertThat(sumaSegundaTarjeta, is(equalTo(sumaPrimeraTarjeta + montoInt)));
			System.out.println("La transacción afectó correctamente la cuenta del cliente en redeban");
				
		}catch(Exception e) {
			fail("No se pudo validar la afectacion de saldos en redeban debido a: " + e.getMessage());
		}
    }
	
	@Given("^consultar saldos tarjetas en redeban origen y destino \"([^\"]*)\"\"([^\"]*)\"$")
	public void consultarSaldoTarjetaEnRedeban(String usuario, String usuario2) throws Exception {
		stepsWebRedeban.ingresoNumeroClienteRedeban(usuario);
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

		stepsWebRedeban.consultaSaldosUsuario2(usuario2);
		
		String numTarjeta2 = stepsWebRedeban.returnNumeroTarjeta();
		ConsultaCupoTarjeta cupoTarjeta2 = stepsWebRedeban.consultaCuposTarjeta(numTarjeta);
		float realDisponible2 = Float.parseFloat(cupoTarjeta.getRealDisponible().replace(".", "").replace(",", "."));
		float bolsillos2 = Float.parseFloat(cupoTarjeta.getSaldoBolsillos().replace(".", "").replace(",", "."));
		saldos.add(realDisponible2);
		saldos.add(bolsillos2);
		System.out.println("Real Disponible tarjeta " + numTarjeta2 + ": " + cupoTarjeta2.getRealDisponible());
		System.out.println("Bolsillos tarjeta " + numTarjeta2 + ": " + cupoTarjeta2.getSaldoBolsillos());
		String saldoTarjeta2 = cupoTarjeta2.getRealDisponible(); 
		Serenity.setSessionVariable("saldoTarjeta2").to(saldoTarjeta2);
		System.out.println("Ya realicé las consultas respectivas");
	}
	
	@Then("^valido igualdad saldos cuenta origen y destino$")
    public void validarIgualdadSaldosUsuarios() throws Exception {
        boolean flag = false;
        int cantidadSaldos = saldos.size();
        if (cantidadSaldos == 8) {
            double sumaPrimeraTarjetaCliente1 = saldos.get(0) + saldos.get(1);
            double sumaPrimeraTarjetaCliente2 = saldos.get(2) + saldos.get(3);
            double sumaSegundaTarjetaCliente1 = saldos.get(4) + saldos.get(5);
            double sumaSegundaTarjetaCliente2 = saldos.get(6) + saldos.get(7);
            assertThat(sumaPrimeraTarjetaCliente1, is(equalTo(sumaSegundaTarjetaCliente1)));
            assertThat(sumaPrimeraTarjetaCliente2, is(equalTo(sumaSegundaTarjetaCliente2)));
            System.out.println("Validé los saldos en redeban correctamente");
        }else {
            System.out.println("No pude validar saldos");
        }
}
	
	@Then("^valido igualdad saldos cuenta origen$")
	public void validoIgualdadSaldosCuentaOrigen() {
        boolean flag = false;
		
		int cantidadSaldos = saldos.size();
		if (cantidadSaldos == 4) {
			double sumaPrimeraTarjeta = saldos.get(0) + saldos.get(1);
			double sumaSegundaTarjeta = saldos.get(2) + saldos.get(3);
			
			if(sumaPrimeraTarjeta == sumaSegundaTarjeta) {
				System.out.println("La transaccion no afectó redeban");
			}else if((sumaSegundaTarjeta) == (sumaPrimeraTarjeta - 10000)) {
				System.out.println("La transaccion  afectó redeban correctamente");
			}else {
				System.out.println("Hubo un error");
			}
		}else {
			System.out.println("No pude validar saldos");
		}
	}
	
	@Given("^validar en redeban subtipo \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void validarEnRedebanSubtipo(String cuenta, String subtipo, String celular) throws Exception {
		base.montoTrasadoRedeban = stepsWebRedeban.consultasubtipo(cuenta, subtipo, celular);
	}

	@Given("^obtener numero celular actual en redeban bolsillos con sesion redeban abierta \"([^\"]*)\"$")
	public void obtenerNumeroCelularActualEnRedebanBolsillosConSesionRedebanAbierta(String usuario) throws Exception {
	    numCelular = stepsWebRedeban.consultaNumeroCelularConSesionAbierta(usuario);
		assertNotNull(numCelular);
	}
	
	@Given("^consultar saldos tarjetas en redeban origen y destino con sesion redeban abierta \"([^\"]*)\"\"([^\"]*)\"$")
	public void consultarSaldosTarjetasEnRedebanOrigenYDestinoConSesionRedebanAbierta(String usuario, String usuario2) throws Exception {
		stepsWebRedeban.ingresoNumeroClienteRedebanSesionAbierta(usuario);
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

		stepsWebRedeban.consultaSaldosUsuario2(usuario2);
		
		String numTarjeta2 = stepsWebRedeban.returnNumeroTarjeta();
		ConsultaCupoTarjeta cupoTarjeta2 = stepsWebRedeban.consultaCuposTarjeta(numTarjeta);
		float realDisponible2 = Float.parseFloat(cupoTarjeta.getRealDisponible().replace(".", "").replace(",", "."));
		float bolsillos2 = Float.parseFloat(cupoTarjeta.getSaldoBolsillos().replace(".", "").replace(",", "."));
		saldos.add(realDisponible2);
		saldos.add(bolsillos2);
		System.out.println("Real Disponible tarjeta " + numTarjeta2 + ": " + cupoTarjeta2.getRealDisponible());
		System.out.println("Bolsillos tarjeta " + numTarjeta2 + ": " + cupoTarjeta2.getSaldoBolsillos());
		String saldoTarjeta2 = cupoTarjeta2.getRealDisponible(); 
		Serenity.setSessionVariable("saldoTarjeta2").to(saldoTarjeta2);
		System.out.println("Ya realicé las consultas respectivas");
	}
	
	@Given("^Obtuve el numero celular del usuario destino validando el estado \"([^\"]*)\"\"([^\"]*)\"$")
    public void obtenerNumeroCelularActualEnRedeban(String usuario, String estado) throws Exception {
        BaseUtil.numCelularUsuarioDestino = stepsWebRedeban.consultarNumeroCelularUsuarioDestinoValidandoEstado(usuario,estado);
        System.out.println(BaseUtil.numCelularUsuarioDestino);
        assertNotNull(BaseUtil.numCelularUsuarioDestino);
    }
	
}
