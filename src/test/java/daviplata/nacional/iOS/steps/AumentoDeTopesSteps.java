/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daviplata.nacional.iOS.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.Random;

import cucumber.api.Scenario;
import daviplata.nacional.iOS.definitions.Hooks;
import daviplata.nacional.iOS.pageObjects.AumentoDeTopesPageObjects;
import daviplata.nacional.iOS.utilidades.Utilidades;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

/**
 *
 * @author Contr
 */

public class AumentoDeTopesSteps {
	
	AumentoDeTopesPageObjects pageAumentoDeTopes;
	Utilidades utilidad;
	private AppiumDriver<MobileElement> driver = Hooks.getDriver();
	private Scenario scenario = Hooks.scenario;
	Random rand = new Random();
	

	public void ingresoALaOpcionTopes() {
		pageAumentoDeTopes.pulsarBotonTopes();
		utilidad.esperaMiliseg(1000);
		pageAumentoDeTopes.validarPopUpTopes();
		utilidad.esperaMiliseg(1000);
	}
	
	public void ingresoALaOpcionTopesDebito() {
		pageAumentoDeTopes.pulsarBotonUsar();
		utilidad.esperaMiliseg(1000);
		pageAumentoDeTopes.validarPopUpTopes();
		utilidad.esperaMiliseg(1000);
	}
	
	/*
	public void ObtenerTopesDeCreditoIncial() {
		String saldoDisponible = pageAumentoDeTopes.ObtenerTopeCreditoInicial(); 
		Serenity.setSessionVariable("saldoDisponibleTopeCredito").to(saldoDisponible);
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Ingreso a Topes de Credito");
		pageAumentoDeTopes.pulsarBotonVolverHome();
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Regreso al home");
	}*/
	
	public void ObtenerTopesDeDebitoIncial() {
		utilidad.esperaMiliseg(1000);
		String acumuladoMensualDebitoApp = pageAumentoDeTopes.ObtenerAcumuladoMensualDebito();
		String acumuladoMensualDebitoRedeban = Serenity.sessionVariableCalled("acumuladoMensualDebitoRedeban");
		//Reemplazar puntos y comas
		acumuladoMensualDebitoApp = acumuladoMensualDebitoApp.replace(",", "").replace(".", "").replace("$", "");
		acumuladoMensualDebitoRedeban = acumuladoMensualDebitoRedeban.replace(",", "").replace(".", "").replace("$", "");
		//Quitar decimales
		acumuladoMensualDebitoRedeban = acumuladoMensualDebitoRedeban.substring(0,acumuladoMensualDebitoRedeban.length()-2);
		assertThat(acumuladoMensualDebitoRedeban, is(equalTo(acumuladoMensualDebitoApp)));
		String topeMensualDebito = pageAumentoDeTopes.ObtenerTopeMensualDebito();
		String saldoDisponibleDebitos = pageAumentoDeTopes.ObtenerTopeDebitoInicial();
		Serenity.setSessionVariable("saldoDisponibleTopeDebito").to(saldoDisponibleDebitos);
		//Reemplazar puntos y comas
		topeMensualDebito = topeMensualDebito.replace(",", "").replace(" ", "").replace("$", "");
		saldoDisponibleDebitos = saldoDisponibleDebitos.replace(",", "").replace(" ", "").replace("$", "");
		int topeDebitoMensual = Integer.parseInt(topeMensualDebito);
		int acumuladoDebitosRedeban = Integer.parseInt(acumuladoMensualDebitoRedeban);
		int saldoRealizarDebitos = Integer.parseInt(saldoDisponibleDebitos);
		assertThat((topeDebitoMensual - acumuladoDebitosRedeban), is(equalTo(saldoRealizarDebitos)));
		System.out.println("Valide correctamente los saldos y los topes de debito en redeban y en Daviplata");
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Ingreso a Topes de Debito");
		pageAumentoDeTopes.pulsarBotonVolverHome();
	}
	
	public void ObtenerTopesDeCreditoIncial() {
		utilidad.esperaMiliseg(1000);
		String acumuladoMensualCreditoApp = pageAumentoDeTopes.ObtenerAcumuladoMensualCredito();
		String acumuladoMensualCreditoRedeban = Serenity.sessionVariableCalled("acumuladoMensualCreditoRedeban");
		//Reemplazar puntos y comas
		acumuladoMensualCreditoApp = acumuladoMensualCreditoApp.replace(",", "").replace(".", "").replace("$", "");
		acumuladoMensualCreditoRedeban = acumuladoMensualCreditoRedeban.replace(",", "").replace(".", "").replace("$", "");
		//Quitar decimales
		acumuladoMensualCreditoRedeban = acumuladoMensualCreditoRedeban.substring(0,acumuladoMensualCreditoRedeban.length()-2);
		assertThat(acumuladoMensualCreditoRedeban, is(equalTo(acumuladoMensualCreditoApp)));
		String topeMensualCreditos = pageAumentoDeTopes.ObtenerTopeMensualCredito();
		String saldoDisponibleCreditos = pageAumentoDeTopes.ObtenerTopeCreditoInicial();
		Serenity.setSessionVariable("saldoDisponibleTopeCredito").to(saldoDisponibleCreditos);
		//Reemplazar puntos y comas
		topeMensualCreditos = topeMensualCreditos.replace(",", "").replace(" ", "").replace("$", "");
		saldoDisponibleCreditos = saldoDisponibleCreditos.replace(",", "").replace(" ", "").replace("$", "");
		int topeCreditoMensual = Integer.parseInt(topeMensualCreditos);
		int acumuladoCreditosRedeban = Integer.parseInt(acumuladoMensualCreditoRedeban);
		int saldoRealizarCreditos = Integer.parseInt(saldoDisponibleCreditos);
		assertThat((topeCreditoMensual - acumuladoCreditosRedeban), is(equalTo(saldoRealizarCreditos)));
		System.out.println("Valide correctamente los saldos y los topes de credito en redeban y en Daviplata");
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Ingreso a Topes de Credito");
		pageAumentoDeTopes.pulsarBotonVolverHome();
	}
	
	public void logoutApp() {
		utilidad.esperaMiliseg(4000);
		pageAumentoDeTopes.logoutApp();
		utilidad.tomaEvidencia("saliendo de la App");
	}
	
	public void ingresarApp() {
		pageAumentoDeTopes.ingresarApp();
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Ingresando a la App");
	}
	




}
