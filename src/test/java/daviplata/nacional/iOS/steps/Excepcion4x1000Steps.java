package daviplata.nacional.iOS.steps;


import daviplata.nacional.iOS.pageObjects.Excepcion4x1000PageObjects;
import daviplata.nacional.iOS.pageObjects.LoginPageObjects;
import daviplata.nacional.iOS.pageObjects.WebLatiniaPageObject;
import daviplata.nacional.iOS.utilidades.Utilidades;
import daviplata.nacional.iOS.utilidades.UtilidadesTCS;
import net.thucydides.core.annotations.Step;

public class Excepcion4x1000Steps {

	static Utilidades utilidad;
	Excepcion4x1000PageObjects pageExcepcion4x1000;
	static LoginPageObjects pageLogin;
	static WebLatiniaPageObject pageLatinia;
	int contador = 0;
	UtilidadesTCS utilidadesTCS;

	@Step	
	public void seleccionarOpcionExencion4x1000() {
		pageExcepcion4x1000.seleccionarOpcionExencion4x1000();
		Utilidades.tomaEvidencia("Ingreso a opcion Exención 4x1000");
		pageExcepcion4x1000.pulsarBtnAceptarPopUp();
		Utilidades.tomaEvidencia("Presione Aceptar en el Pop Up");
	}
	
	public void validarOpcionExencion4x1000() {
		pageExcepcion4x1000.validarOpcionExencion4x1000();
	}
	
	
	
	public void validarExencionExitosa() {
		pageExcepcion4x1000.validarExencionExitosa();
		utilidad.tomaEvidencia("Valido Exencion exitosa");	
	}
	
	
	public void validarCamposMenuHamburguesa() {
		pageExcepcion4x1000.validarCamposMenuHamburguesa();
		utilidad.tomaEvidencia("Valido campos exitosamente");
	}
	
	
	public void validarExencionNoExitosa() {
		utilidad.esperaMiliseg(1500);
		pageExcepcion4x1000.validarExencionNoExitosa();
		utilidad.tomaEvidencia("Valido Exencion no exitosa");
		
	}
	
	public void pulsarBtnFinalizar() {
		pageExcepcion4x1000.pulsarBtnFinalizar();
		utilidad.tomaEvidencia("Click al boton finalizar");
		
	}
	
	public void hacerClicBotonSolicitudes() {
		Utilidades.esperaMiliseg(2500);
		utilidadesTCS.clicElement("xpath", Excepcion4x1000PageObjects.BOTON_SOLICITUDES);
		utilidad.tomaEvidencia("Doy clic en boton de solicitudes");
		
	}
	
}
