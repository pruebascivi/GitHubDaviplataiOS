package daviplata.nacional.iOS.steps;

import cucumber.api.Scenario;
import daviplata.nacional.iOS.definitions.Hooks;
import daviplata.nacional.iOS.pageObjects.AcercaDeDaviplataPage;
import daviplata.nacional.iOS.pageObjects.AcercaDePageObjects;
import daviplata.nacional.iOS.pageObjects.AumentoDeTopesPageObjects;
import daviplata.nacional.iOS.pageObjects.ClaveCorreoPageObject;
import daviplata.nacional.iOS.pageObjects.ComprobanteQrPageObjects;
import daviplata.nacional.iOS.pageObjects.LoginPageObjects;
import daviplata.nacional.iOS.pageObjects.LoginRobustoPage;
import daviplata.nacional.iOS.utilidades.Evidencias;
import daviplata.nacional.iOS.utilidades.Utilidades;
import daviplata.nacional.iOS.utilidades.UtilidadesTCS;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import net.thucydides.core.annotations.Step;

public class ComprobanteQrSteps {
	
	AcercaDePageObjects pageAcercaDe;
	Utilidades utilidad;
	ComprobanteQrPageObjects comprobanteQrPageObjects;
	LoginPageObjects pageLogin;
	AumentoDeTopesPageObjects aumentoDeTopesPageObjects;
	UtilidadesTCS utilidadesTCS;
	private AppiumDriver<MobileElement> driver = Hooks.getDriver();
	private Scenario scenario = Hooks.scenario;
	LoginSteps loginSteps;
	ClaveCorreoPageObject claveCorreoPageObject;
	
	@Step
	public void ingresarALaApp() {
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
		System.out.println("Ingresando a la app");
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.esperarElementVisibility("xpath", LoginRobustoPage.BOTON_NOTIFICACIONES);
		Utilidades.esperaMiliseg(1000);
	}
	
	@Step
	public void validarVisibilidadBotonQr() {
		utilidadesTCS.esperarElementVisibility("xpath", LoginRobustoPage.BOTON_NOTIFICACIONES);
		comprobanteQrPageObjects.validarBotonQr();
		Utilidades.tomaEvidencia("Validar botón del home de logeo Daviplata");
	}
	
	@Step
	public void salirDeLaApp() {
		utilidadesTCS.esperarElementVisibility("xpath", ClaveCorreoPageObject.BOTON_HEADER_HOME);
		Utilidades.esperaMiliseg(800);
		utilidadesTCS.clicElement("xpath", ClaveCorreoPageObject.BOTON_HEADER_HOME);
		utilidadesTCS.esperarElementVisibility("xpath", ClaveCorreoPageObject.BTN_SALIR_DAVIPLATA);
		Utilidades.esperaMiliseg(800);
		utilidadesTCS.clicElement("xpath", ClaveCorreoPageObject.BTN_SALIR_DAVIPLATA);
		Utilidades.tomaEvidencia("Doy a salir de la app");
		//aumentoDeTopesPageObjects.logoutApp();
		utilidadesTCS.clicElement("xpath", ClaveCorreoPageObject.BOTON_ACEPTAR_SALIR_APP);
		Utilidades.esperaMiliseg(1000);
		Utilidades.tomaEvidencia("Valido opcion de cambio de usuario para ingreso a la app");
		comprobanteQrPageObjects.clicBotonCambiarLogeo();
	}
	
	@Step
	public void ingresarADatosRecordados(String tipoDocumento, String usuario, String contrasena ) {
		utilidadesTCS.seleccionarTipoDocumentoInputHomeDaviplata("xpath",tipoDocumento);
		utilidadesTCS.writeElement("xpath", LoginRobustoPage.CAMPO_INGRESO_USUARIO, usuario);
		Utilidades.esperaMiliseg(800);
		Utilidades.tomaEvidencia("Se diligencia tipo de documento y usuario");
		comprobanteQrPageObjects.clicCheckDatosRecordados();
		utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_INGRESAR);
		Utilidades.tomaEvidencia("Ingreso a Daviplata");
		pageLogin.ingresarContrasena(contrasena);
		Utilidades.tomaEvidencia("Diligencio usuario " + usuario + " contraseña " + contrasena);
		pageLogin.darClicBotonIngresar();
		Utilidades.esperaMiliseg(500);
		pageLogin.darClicBotonIngresar();
		Utilidades.esperaMiliseg(500);
		pageLogin.cerrarMensajeTopes();
		Utilidades.esperaMiliseg(800);
		boolean estadoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.POP_UP_INVITE_AMIGOS);
		if(estadoVisible == true) {
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_CLOSE);
		}
	}
	
	@Step
	public void validarOpcionesBotonQr() {
		Utilidades.tomaEvidencia("Entrar a las opciones del botón QR");
		comprobanteQrPageObjects.clicBotonQr();
		comprobanteQrPageObjects.validarOpcionComprar();
		comprobanteQrPageObjects.validarOpcionVender();
		comprobanteQrPageObjects.validarOpcionConfirmarComprobante();
		Utilidades.tomaEvidencia("Validar opciones del boton QR");
	}
	
	@Step
	public void ingresarAlBotonLeerCodigoQr() {
        Utilidades.esperaMiliseg(2000);
        Utilidades.tomaEvidencia("Ingreso a la funcionalidad de leer codigo QR");   
		utilidadesTCS.esperarElementVisibility("xpath", ComprobanteQrPageObjects.BOTON_QR_PUBLIC_HOME);
        utilidadesTCS.clicElement("xpath", ComprobanteQrPageObjects.BOTON_QR_PUBLIC_HOME);   
    }

	@Step
	public void validarFuncionalidadDeLeerQr() {
		Utilidades.esperaMiliseg(2000);
		utilidadesTCS.esperarElementVisibility("xpath", ComprobanteQrPageObjects.TEXTO_CUANTO_DEBO);
        boolean estado = utilidadesTCS.validateElementVisibility("xpath", ComprobanteQrPageObjects.TEXTO_CUANTO_DEBO);
        utilidadesTCS.validateStatusElement(estado);
        Utilidades.tomaEvidencia("Validar modulo de compra en lectura de QR");
    }
}
