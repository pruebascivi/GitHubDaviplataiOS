package daviplata.nacional.iOS.steps;

import static org.junit.Assert.assertEquals;
import daviplata.nacional.iOS.pageObjects.AcercaDePageObjects;
import daviplata.nacional.iOS.pageObjects.LoginPageObjects;
import daviplata.nacional.iOS.pageObjects.LoginRobustoPage;
import daviplata.nacional.iOS.pageObjects.OlvidoClavePageObjects;
import daviplata.nacional.iOS.pageObjects.WebRedebanPageObjects;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import daviplata.nacional.iOS.utilidades.Utilidades;
import daviplata.nacional.iOS.utilidades.UtilidadesTCS;
import net.thucydides.core.annotations.Step;

public class OlvidoClaveSteps {

	OlvidoClavePageObjects pageObjectOlvidoClave;
	LoginPageObjects loginPageObjects;
	AcercaDePageObjects acercaDePageObjects;
	Utilidades utilidad;
	AcercaDePageObjects pageAcercaDe;
	UtilidadesTCS utilidadesTCS;
	LoginSteps loginSteps;


	@Step
	public void ingresarOlvidoSuClave() {
		System.out.println("Ingresando a la app");
		loginSteps.verificarVersion();// Version
    	Utilidades.esperaMiliseg(800);
		pageObjectOlvidoClave.pulsarBtnOlvidoClave();
		Utilidades.tomaEvidencia("se ingreso a 'Olvidó su clave'");
	}
	
	@Step
	public void validarVersionApp() {
    	Utilidades.esperaMiliseg(800);
		utilidadesTCS.esperarElementVisibility("xpath", AcercaDePageObjects.BOTON_NOTIFICACIONES);
		utilidadesTCS.clicElement("xpath", AcercaDePageObjects.BOTON_NOTIFICACIONES);
    	Utilidades.esperaMiliseg(1500);
		utilidadesTCS.clicElement("xpath", AcercaDePageObjects.BOTON_ACERCA_DE);
		Utilidades.esperaMiliseg(2000);
		String versionAppDaviplata = utilidadesTCS.obtenerTexto("xpath", AcercaDePageObjects.LABEL_VERSION);
		BaseUtil.versionApp = versionAppDaviplata;
		System.out.println("Esta es la version de la app: " + versionAppDaviplata);
		Utilidades.tomaEvidencia("Esta es la versión de la app" + versionAppDaviplata);
		utilidadesTCS.clicElement("name", AcercaDePageObjects.BOTON_REGRESAR);
	}
	
	public void ingresarDocumento(String tipoDocumento, String numeroDocumento) {
		pageObjectOlvidoClave.pulsarBtnTipoDocumento();
    	Utilidades.esperaMiliseg(1000);
		pageObjectOlvidoClave.seleccionarTipoDocumentoOlvidoClave(tipoDocumento);
		Utilidades.tomaEvidencia("Selección tipo de documento");
		pageObjectOlvidoClave.ingresarNumDocumento(numeroDocumento);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath", AcercaDePageObjects.BOTON_CONTINUAR);
		Utilidades.esperaMiliseg(800);
		Utilidades.tomaEvidencia("Ingresar numero y tipo de documento");
	}
	
	public void pulsarContinuar() {
		Utilidades.esperaMiliseg(800);
		pageObjectOlvidoClave.pulsarBotonContinuar();
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
	}

	public void consultarOtpLatinia(String numCelular) {
		pageObjectOlvidoClave.consultarOtpEnLatinia(numCelular); 
	}
	
	public void consultarOtpLatiniaOlvidoClave(String numCelular) {
		pageObjectOlvidoClave.consultarOtpEnLatiniaDeOlvidoClave(numCelular); 
	}
	
	public void ingresarEmailOtpInvalida(String email, String numCelular) {
		pageObjectOlvidoClave.diligenciarEmailOtpErronea(email, numCelular); 
	}
	
	public void validarMensajeIngresoClave() {
		pageObjectOlvidoClave.validarMensajePantallaIngresarClave();
	}
	
	public void ingresarEmailSinLatinia() {
		pageObjectOlvidoClave.diligenciarEmailSinLatinia();
	}
	
		
	public void ingresarClaveTemporalErronea() {
		int claveRandom = (int) (Math.random() * (9999 - 1111)) + 1111;
		pageObjectOlvidoClave.ingresarClaveTemporal(String.valueOf(claveRandom));
		pageObjectOlvidoClave.pulsarbtnContinuarClaveTemporal();
	}
	
	public void ingresarNuevaClave(String claveNueva) {
		pageObjectOlvidoClave.ingresarNuevaClave(claveNueva);
		pageObjectOlvidoClave.ingresarConfirmarNuevaClave(claveNueva);
		pageObjectOlvidoClave.pulsarBtnAceptar();
	}
	
	public void ingresarNuevaClaveConfirmacionErronea(String claveNueva) {
		pageObjectOlvidoClave.ingresarNuevaClave(claveNueva);
		pageObjectOlvidoClave.ingresarConfirmarNuevaClaveErronea(claveNueva);
		pageObjectOlvidoClave.pulsarBtnAceptar();
	}
	
	public void ingresarNuevaClaveNuevaErronea(String claveNueva) {
		pageObjectOlvidoClave.ingresarNuevaClaveErronea(claveNueva);
		pageObjectOlvidoClave.ingresarConfirmarNuevaClave(claveNueva);
		pageObjectOlvidoClave.pulsarBtnAceptar();
	}
	
	public void validarMensajeClaveErronea() {
		pageObjectOlvidoClave.validarMensajeClaveErronea();
	}
	
	
	public void validarCambioDeClave() {
		pageObjectOlvidoClave.validarMensajeCambioClave();
		Utilidades.tomaEvidencia("Se valida el cambio de clave exitoso en olvido clave");
		pageObjectOlvidoClave.clicBotonFinalizarCambioClave();
		
	}
	
	public void validarCambioDeClaveIgual() {
		pageObjectOlvidoClave.validarMensajeCambioClave();
		
	}
	
	public void validarMensajeNoCoincide(){
		String msj = pageObjectOlvidoClave.obtenerMensajePopUp();
		System.out.println("msj: "+msj);
		assertEquals("La clave asignada y la confirmación no coinciden. Por favor verifique e intente nuevamente.", msj);
	}
	
	public void validarMensajeOtpErronea(){
		String msj = pageObjectOlvidoClave.obtenerMensajePopUp();
		System.out.println("msj: "+msj);
		assertEquals("CLAVE INVALIDA", msj);
	}
	
	public void ingresarNuevaClaveConConfirmacionMal(String claveNueva) {
	
		pageObjectOlvidoClave.ingresarNuevaClave(claveNueva);
		int claveRandom = (int) (Math.random() * (999999 - 111111)) + 111111;
		pageObjectOlvidoClave.ingresarConfirmarNuevaClave(String.valueOf(claveRandom));
		pageObjectOlvidoClave.pulsarBtnAceptar();
	}
	
	public void habilitarClaveTemporalRedeban(String usuario) {		
		WebRedebanPageObjects.abrirWebRedeban();
		WebRedebanPageObjects.sendKeysInputUsuario();
		WebRedebanPageObjects.sendKeysInputPass();
		Utilidades.tomaEvidenciaPantalla("Ingresar credenciales redeban");
		WebRedebanPageObjects.clicBtnEnvia();
		Utilidades.esperaMiliseg(4000);
		Utilidades.cambiarFocoNuevaVentanaAbierta();
		Utilidades.tomaEvidenciaPantalla("Ingresar a monedero redeban");
		WebRedebanPageObjects.clicMonederos();
		WebRedebanPageObjects.clicOlvidoClave();
		WebRedebanPageObjects.ingresarDocumento(usuario);
		Utilidades.tomaEvidenciaPantalla("Ingresar documento " + usuario);
		WebRedebanPageObjects.clicEnviarOlvidoClave();
		Utilidades.esperaMiliseg(4000);
		Utilidades.scrollDownSwipe(1);
		WebRedebanPageObjects.clicAceptarOlvidoClave();
		WebRedebanPageObjects.clicAceptarAlerta();
		Utilidades.esperaMiliseg(4000);
		Utilidades.scrollHaciaArriba();
		WebRedebanPageObjects.validarActivacionClaveTemporal();
		Utilidades.tomaEvidenciaPantalla("Validar activacion de clave temporal");
	}
	
	public void cerrarRedebanOlvidoClave() {
		WebRedebanPageObjects.logoutRedebanOlvidoClave();
		WebRedebanPageObjects.cerrarWebRedeban();
		
	}
	
	public void validarClaveTemporal() {
		pageObjectOlvidoClave.validarClaveTemporalErronea();
		Utilidades.tomaEvidencia("Validar mensaje de clave temporal erronea");
	}
	
	public void ingresarOtpDeLatinia() {
		pageObjectOlvidoClave.ingresarOtpDeLatinia();
	}
	
	public void ingresarClaveNueva(String claveNueva, String confirmacionClaveNueva) {
		pageObjectOlvidoClave.ingresarClaveNuevaDeOlvidoClave(claveNueva);
		pageObjectOlvidoClave.ingresarConfirmacionClaveNuevaOlvidoClave(confirmacionClaveNueva);
		Utilidades.tomaEvidencia("Se crea la clave nueva");
		pageObjectOlvidoClave.clicBotonContinuarTecladoiOSIngresoDocumento();
		pageObjectOlvidoClave.clicBotonCrearClave();
	}

	@Step
	public void validarPopUpChatConAsesor() {
        utilidadesTCS.esperarElementVisibility("xpath", OlvidoClavePageObjects.POP_UP_REGISTRO_USUARIO_NUEVO);
        String texto = utilidadesTCS.obtenerTexto("xpath", OlvidoClavePageObjects.POP_UP_REGISTRO_USUARIO_NUEVO);
        utilidadesTCS.validateTextContainsString(texto, "Chat DaviPlata");
        Utilidades.tomaEvidencia("Validoque el pop up contiene el texto 'Para recuperar su clave, por favor ingrese al Chat DaviPlata'");
    }

	public void validarPantallaAnteriorAlHacerClicEnLaEquisPopUp() {
		Utilidades.esperaMiliseg(1000);
        boolean elementoUno = utilidadesTCS.validateElementVisibility("xpath", OlvidoClavePageObjects.BTN_CERRAR_POPUP);
        utilidadesTCS.validateStatusElement(elementoUno);
        Utilidades.tomaEvidencia("Validar que en el pop up se visualice una 'X' en la parte superior");
        utilidadesTCS.clicElement("xpath", OlvidoClavePageObjects.BTN_CERRAR_POPUP);
		Utilidades.esperaMiliseg(1000);
        Utilidades.tomaEvidencia("Validar que al dar tap en la 'X' me regrese a la pantalla anterior");
    }
	
}
