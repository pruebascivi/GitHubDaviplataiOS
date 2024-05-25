/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daviplata.nacional.iOS.steps;

import java.util.Random;

import cucumber.api.Scenario;
import daviplata.nacional.iOS.definitions.Hooks;
import daviplata.nacional.iOS.pageObjects.AcercaDeDaviplataPage;
import daviplata.nacional.iOS.pageObjects.AcercaDePageObjects;
import daviplata.nacional.iOS.pageObjects.LoginRobustoPage;
import daviplata.nacional.iOS.utilidades.Utilidades;
import daviplata.nacional.iOS.utilidades.UtilidadesTCS;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import net.thucydides.core.annotations.Step;

public class AcercaDeSteps {
	
	AcercaDePageObjects pageAcercaDe;
	Utilidades utilidad;
	private AppiumDriver<MobileElement> driver = Hooks.getDriver();
	private Scenario scenario = Hooks.scenario;
	Random rand = new Random();
	//LoginSteps loginSteps;
	UtilidadesTCS utilidadesTCS;
	
	@Step
	public void seleccionarModuloAcercaDe() {
		try {
			
			utilidadesTCS.clicElement("name", LoginRobustoPage.MENU_TRES_PUNTOS);
			Utilidades.tomaEvidencia("Menu tres puntos");
		} catch(Exception e) {
			
			System.out.println("No se pudo interactuar con el elemento debido a: " + e.getMessage().toString());
			assert utilidadesTCS.validateElementVisibilityCatch("name", LoginRobustoPage.MENU_TRES_PUNTOS) : "No se pudo interactuar con el elemento." + LoginRobustoPage.MENU_TRES_PUNTOS;
		}
		try {
			Utilidades.esperaMiliseg(2000);
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.ACERCA_DE_DAVIPLATA);
			Utilidades.esperaMiliseg(1500);
			
		} catch(Exception e) {
			System.out.println("No se pudo interactuar con el elemento debido a: " + e.getMessage().toString());
			assert utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.ACERCA_DE_DAVIPLATA) : "No se pudo interactuar con el elemento." + LoginRobustoPage.ACERCA_DE_DAVIPLATA;
		}	
	}
	
	
	@Step
	public void ingresoAOpcionParaQueSirve() {
		pageAcercaDe.darClickQueEsDaviPlata();
	}
	
	@Step
	public void validarOpcionParaQueSirve() {
		pageAcercaDe.validarOpcionParaQueSirve();
		utilidad.tomaEvidencia("Ingreso correcto Opcion Para Que sirve");
	}
	
	@Step
	public void ingresoAOpcionDondeUsar() {
		pageAcercaDe.darClickDondeUsarDaviPlata();
		pageAcercaDe.pulsarBtnPermitirSoloUsoConApp();
		pageAcercaDe.pulsarBtnPermisoLeerUbicacion();
	}
	
	@Step
	public void validarOpcionDondeUsar() {
		pageAcercaDe.esperarVisibilidadDondeUsarDaviplata();
		pageAcercaDe.validarOpcionDondeUsarDP();
		Utilidades.tomaEvidencia("Validar la opción donde usar Daviplata");
		
		
	}
	
	@Step
	public void ingresoAOpcionTwitter() {
		pageAcercaDe.darClickTwitter();
	}
	
	@Step
	public void validoOpcionTwitter() {
		pageAcercaDe.validarOpcionTwitter();
		utilidad.esperaMiliseg(5000);
		utilidad.tomaEvidencia("Ingreso a Twitter DaviPlata");
	}
	
	@Step
	public void ingresoAOpcionYoutube() {
		pageAcercaDe.darClickYoutube();
	}
	
	@Step
	public void validoOpcionYoutube() {
		pageAcercaDe.validarOpcionYoutube();
		utilidad.esperaMiliseg(5000);
		utilidad.tomaEvidencia("Ingreso a Youtube DaviPlata");
	}
	
	@Step
	public void ingresoAOpcionReglamento() {
		pageAcercaDe.darClickReglamento();
	}
	
	@Step
	public void validoOpcionReglamento() {
		pageAcercaDe.validarReglamento();
		utilidad.esperaMiliseg(7000); 
		utilidad.tomaEvidencia("Descarga de Reglamento");
	}
	
	@Step
	public void ingresoAOpcionCondiciones() {
		pageAcercaDe.darClickCondiciones();
	}
	
	@Step
	public void validoOpcionCondiciones() {
	//	pageAcercaDe.validarOpcionCondiciones();
		pageAcercaDe.validarCondiciones();
		utilidad.esperaMiliseg(5000);
		utilidad.tomaEvidencia("Descarga de Condiciones");
	}
	
	@Step
	public void ingresoALaOpcionAyudaEnLinea() {
		utilidad.esperaMiliseg(5000);
		//loginSteps.validarVersionApp();// Version
		utilidad.esperaMiliseg(10000);
		utilidad.tomaEvidencia("Ingreso a la Aplicacion");
		pageAcercaDe.darClickEnOpcionAyudaEnLinea();

	}
	
	@Step
	public void ingresoALaOpcionAyudaEnLinea1() {
		pageAcercaDe.esperarVisibilidadElemento();
		utilidad.tomaEvidencia("Ingreso a la Aplicacion");
		pageAcercaDe.darClickEnOpcionAyudaEnLinea();
	}

	@Step
	public void validarOpvionAyudaEnLinea() {
		pageAcercaDe.esperarVisibilidadFormularioDeAyudaEnLinea();
		pageAcercaDe.validarFormularioDeAyudaEnLinea(); 
		utilidad.tomaEvidencia("Funcionalidad de Ayuda en linea");
	}
	
	@Step
	public void ingresarBotonNotificaciones() {
		pageAcercaDe.pulsarBtnRegresar();
		Utilidades.esperaMiliseg(4000);
		utilidadesTCS.clicElement("xpath", pageAcercaDe.BOTON_NOTIFICACIONES);
		utilidad.tomaEvidencia("Ingresar a la opción donde usar su Daviplata");
		
	}
	
	
}
