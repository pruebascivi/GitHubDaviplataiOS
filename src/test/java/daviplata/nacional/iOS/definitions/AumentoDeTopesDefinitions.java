/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daviplata.nacional.iOS.definitions;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import daviplata.nacional.iOS.modelo.ConsultaCupoTarjeta;
import daviplata.nacional.iOS.modelo.ConsultaCupoTarjetaDestino;
import daviplata.nacional.iOS.steps.AumentoDeTopesSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import daviplata.nacional.iOS.steps.WebRedebanSteps;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import daviplata.nacional.iOS.utilidades.Utilidades;
/**
 *
 * @author Contr
 */
public class AumentoDeTopesDefinitions {
	ArrayList<Float> saldos = new ArrayList<Float>();
	String numCelular = "";
	String numCelularDestino = "";
	BaseUtil base;
	@Steps
	AumentoDeTopesSteps stepsAumentoDeTopes;
	@Steps
	WebRedebanSteps stepsWebRedeban;
	
	

	@Given("^obtener numero celular actual en redeban aumento de topes \"([^\"]*)\"$")
	public void obtenerNumeroCelularActualEnRedebanAumentoDeTopes(String usuario) throws Exception {
		numCelular = stepsWebRedeban.consultaNumeroCelular(usuario);
		assertNotNull(numCelular);
	}
	
	@Given("^Validé tope actual en debitos destino \"([^\"]*)\"$")
    public void valideTopeActualEnDebitosDestino(String topeDebitos) throws Exception {
        stepsWebRedeban.validarTopeDebitosDestino(topeDebitos);
    }
	
	@Given("^Validé tope actual en debitos \"([^\"]*)\"$")
	public void valideTopeActualEnDebitos(String topeDebitos) throws Exception {
		stepsWebRedeban.validarTopeDebitos(topeDebitos);
	}

	@Then("^logout redeban al finalizar consulta$")
	public void logoutRedeban() throws Exception {
		Utilidades.esperaMiliseg(1000);
		System.out.println("Estoy en Aumento de topes");
		stepsWebRedeban.logOut("//img[@src='/AutorizadorMonWeb/images/pages/logout.gif']");
	}
	
	@Given("^ingresar a opcion topes$")
	public void ingresarAOpcionTopes() throws Exception {
		stepsAumentoDeTopes.ingresoALaOpcionTopes();
	}
	
	@Given("^ingresar a opcion topes debito$")
	public void ingresarAOpcionTopesDebito() throws Exception {
		stepsAumentoDeTopes.ingresoALaOpcionTopesDebito();
	}
	
	@Given("^obtener topes de credito$")
	public void ObtenerTopesDeCreditoIncial() throws Exception {
		stepsAumentoDeTopes.ObtenerTopesDeCreditoIncial();
	}
	
	@Given("^obtener topes de debito$")
	public void ObtenerTopesDeDebitoIncial() throws Exception {
		stepsAumentoDeTopes.ObtenerTopesDeDebitoIncial();
	}
	
	@Given("^logout app$")
	public void logoutApp() throws Exception {
		stepsAumentoDeTopes.logoutApp();
	}
	
	@Given("^ingresar app$")
	public void ingresarApp() throws Exception {
		stepsAumentoDeTopes.ingresarApp();
	}
	
	@Given("^Obtener numero celular actual en redeban aumento de topes Destino \"([^\"]*)\"$")
	public void obtenerNumeroCelularActualEnRedebanAumentoDeTopesDestino(String usuarioDestino) throws Exception {
		numCelularDestino = stepsWebRedeban.consultaNumeroCelularDestino(usuarioDestino);
		assertNotNull(numCelularDestino);
	}
	
	@Given("^Consulté saldo tarjeta en redeban aumento de topes destino$")
	public void consultarSaldoTarjetaEnRedebanAumentoDeTopesDestino() throws Exception {
		String numTarjetaDestino = stepsWebRedeban.returnNumeroTarjetaDestino();
		ConsultaCupoTarjetaDestino cupoTarjetaDestino = stepsWebRedeban.consultaCuposTarjetaDestino(numTarjetaDestino);
		
		BigDecimal realDisponibleParaCompararDestino = new BigDecimal(cupoTarjetaDestino.getRealDisponibleDestino().replace(".", "").replace(",", ".").replace(".00", ""));
		Serenity.setSessionVariable("saldoRealDestino").to(realDisponibleParaCompararDestino);
		
		float disponibleDestino = Float.parseFloat(cupoTarjetaDestino.getRealDisponibleDestino().replace(".", "").replace(",", "."));
		
		//float bolsillos = Float.parseFloat(cupoTarjeta.getSaldoBolsillos().replace(".", "").replace(",", "."));
		float acumuladoMensualCreditoDestino = Float.parseFloat(cupoTarjetaDestino.getAcumuladoMensualCreditoDestino().replace(".", "").replace(",", "."));
		float acumuladoMensualDebitoDestino = Float.parseFloat(cupoTarjetaDestino.getAcumuladoMensualDebitoDestino().replace(".", "").replace(",", "."));
		saldos.add(disponibleDestino);
		//saldos.add(bolsillos);
		saldos.add(acumuladoMensualCreditoDestino);
	    saldos.add(acumuladoMensualDebitoDestino);
		
		System.out.println("Real Disponible tarjeta destino " + numTarjetaDestino + ": " + cupoTarjetaDestino.getRealDisponibleDestino());
		
		System.out.println("Bolsillos tarjeta destino " + numTarjetaDestino + ": " + cupoTarjetaDestino.getSaldoBolsillosDestino());
		String acumuladoMensualDebitoRedebanDestino = cupoTarjetaDestino.getAcumuladoMensualDebitoDestino(); 
		String acumuladoMensualCreditoRedebanDestino = cupoTarjetaDestino.getAcumuladoMensualCreditoDestino(); 
		System.out.println("Acumulado mensual credito destino " + numTarjetaDestino + ": " + cupoTarjetaDestino.getAcumuladoMensualCreditoDestino()); 
		Serenity.setSessionVariable("acumuladoMensualDebitoRedebanDestino").to(acumuladoMensualDebitoRedebanDestino);
		System.out.println("Acumulado mensual debito destino " + numTarjetaDestino + ": " + cupoTarjetaDestino.getAcumuladoMensualDebitoDestino());  
		Serenity.setSessionVariable("acumuladoMensualCreditoRedeban").to(acumuladoMensualCreditoRedebanDestino);
	}

	@Given("^Validé tope actual en creditos \"([^\"]*)\"$")
	public void valideTopeActualEnCreditos(String topeCredito) throws Exception {
		stepsWebRedeban.validarTopeCredito(topeCredito);
	}
	
	@Given("^consulté saldo tarjeta en redeban aumento de topes$")
    public void consultarSaldoTarjetaEnRedebanAumentoDeTopes() throws Exception {
		String numTarjeta = stepsWebRedeban.returnNumeroTarjeta();
        ConsultaCupoTarjeta cupoTarjeta = stepsWebRedeban.consultaCuposTarjeta(numTarjeta);
        
        BigDecimal realDisponibleParaComparar = new BigDecimal(cupoTarjeta.getRealDisponible().replace(".", "").replace(",", "."));
        String realString = String.valueOf(realDisponibleParaComparar);
        int longitud = realString.length();
        int numero = longitud - 2;
        realString = realString.substring(0, numero); 
        BigDecimal numSaldoRealDisponible = new BigDecimal(realString);
        Serenity.setSessionVariable("saldoReal").to(numSaldoRealDisponible);
        
        
        float disponible = realDisponibleParaComparar.floatValue();
        
        //float bolsillos = Float.parseFloat(cupoTarjeta.getSaldoBolsillos().replace(".", "").replace(",", "."));
        float acumuladoMensualCredito = Float.parseFloat(cupoTarjeta.getAcumuladoMensualCredito().replace(".", "").replace(",", "."));
        float acumuladoMensualDebito = Float.parseFloat(cupoTarjeta.getAcumuladoMensualDebito().replace(".", "").replace(",", "."));
        saldos.add(disponible);
        //saldos.add(bolsillos);
        saldos.add(acumuladoMensualCredito);
        saldos.add(acumuladoMensualDebito);
        
        System.out.println("Real Disponible tarjeta " + numTarjeta + ": " + cupoTarjeta.getRealDisponible());
        
        System.out.println("Bolsillos tarjeta " + numTarjeta + ": " + cupoTarjeta.getSaldoBolsillos());
        String acumuladoMensualDebitoRedeban = cupoTarjeta.getAcumuladoMensualDebito(); 
        String acumuladoMensualCreditoRedeban = cupoTarjeta.getAcumuladoMensualCredito(); 
        System.out.println("Acumulado mensual credito " + numTarjeta + ": " + cupoTarjeta.getAcumuladoMensualCredito()); 
        Serenity.setSessionVariable("acumuladoMensualDebitoRedeban").to(acumuladoMensualDebitoRedeban);
        System.out.println("Acumulado mensual debito " + numTarjeta + ": " + cupoTarjeta.getAcumuladoMensualDebito());  
        Serenity.setSessionVariable("acumuladoMensualCreditoRedeban").to(acumuladoMensualCreditoRedeban);


    }
	
	@Then("^Validar igualdad saldos topes$")
    public void validarIgualdadSaldosTopes() throws Exception {
        try {
            String saldo = String.valueOf(base.saldo);
            int cantidad = saldo.length();
            int numero = cantidad - 2;
            if(cantidad > 2) {
                saldo = saldo.substring(0, numero);    
            }
            
            BigDecimal saldoInicial = new BigDecimal(saldo); 
            
            double saldoDaviplata1 = base.saldo.doubleValue();
            double saldoDaviplata2 = base.saldoFinal.doubleValue();
            
            
            assertThat(BaseUtil.saldo, is(equalTo(BaseUtil.saldoFinal)));
            System.out.println("***La transacción no afecto el saldo inicial del daviplata***");
            
            double saldoRedeban1 = saldos.get(0);
            double saldoRedeban2 = saldos.get(3);
            
            assertThat(saldoRedeban1, is(equalTo(saldoRedeban2)));
            System.out.println("***La transacción no afectó saldo inicial en redeban***");
        } catch (Exception e) {
            fail("No se pudo validar saldos del Daviplata, debido a: " + e.getMessage());
        }
    }
	@Then("^Validar afectacion de saldos en redeban y daviplata topes$")
    public void validarIgualdadSaldosTarjetasTopes() throws Exception {
        try {
            double saldoDaviplata1 = base.saldoInicial.doubleValue();
            double saldoDaviplata2 = base.saldoFinal.doubleValue();
            
            assertThat(base.saldo, not(equalTo(base.saldoFinal)));
            System.out.println("La transacción si afecto el saldo inicial del daviplata");
            System.out.println(saldos);
            double saldoRedeban1 = saldos.get(0);
            double saldoRedeban2 = saldos.get(3);
            
            assertThat(saldoRedeban1, not(equalTo(saldoRedeban2)));
            System.out.println("La transacción si afectó saldo inicial en redeban");
        } catch (Exception e) {
            fail("No se pudo validar saldos del Daviplata, debido a: " + e.getMessage());;
        }
    }




}


