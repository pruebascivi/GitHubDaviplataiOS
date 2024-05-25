package daviplata.nacional.iOS.steps;

import java.util.List;

import cucumber.api.Scenario;
import daviplata.nacional.iOS.pageObjects.ClaveCorreoPageObject;
import daviplata.nacional.iOS.pageObjects.MenuHamburguesaPageObjects;
import daviplata.nacional.iOS.pageObjects.WebCheckOutPageObjects;
import daviplata.nacional.iOS.definitions.Hooks;
import daviplata.nacional.iOS.modelo.ConsultaClientes;
import daviplata.nacional.iOS.pageObjects.HomePageObjects;
import daviplata.nacional.iOS.pageObjects.MenuHamburguesaPageObjects;
import daviplata.nacional.iOS.utilidades.Utilidades;
import daviplata.nacional.iOS.utilidades.UtilidadesTCS;
import io.appium.java_client.MobileElement;
import net.thucydides.core.annotations.Step;

public class ClaveCorreoSteps {
	
	private ClaveCorreoPageObject pageClaveCorreo;
	private MenuHamburguesaPageObjects pageMenuHamburguesa;
	private Utilidades utilidad;
	UtilidadesTCS utilidadesTCS;

	private Scenario scenario = Hooks.scenario;

	private String fecha = "";
	private String fechaFinal = "";

	@Step
	public void ingresarAlHeaderHome() {
		utilidadesTCS.clicElement("xpath", ClaveCorreoPageObject.BOTON_HEADER_HOME);
		utilidad.tomaEvidencia("Ingreso al header home");
	}

	@Step
	public void seleccionoCambiarClaveYCorreo() {
		utilidadesTCS.clicElement("xpath", ClaveCorreoPageObject.LISTA_DESPLEGABLE_PREFERENCIAS);
		Utilidades.esperaMiliseg(3000);
		Utilidades.tomaEvidencia("Ingreso a modulo Cambio de clave y correo");
		utilidadesTCS.clicElement("xpath", ClaveCorreoPageObject.BOTON_CAMBIAR_CLAVE_CORREO);
		
	}

	@Step
	public void cambiarClave(String claveActual, String claveNueva) {
		pageClaveCorreo.darClickCambiarClave();
		pageClaveCorreo.ingresarClaveActual(claveActual);
		pageClaveCorreo.ingresarClaveNueva(claveNueva);
		pageClaveCorreo.ingresarConfirmarClave(claveNueva);
		utilidad.tomaEvidencia("Claves diligenciadas_Clave actual " + claveActual + "_Clave nueva " + claveNueva
				+ "_Confirmación " + claveNueva);
		pageClaveCorreo.darClickContinuar();
		pageClaveCorreo.darClickContinuar();
	}
	
	@Step
	public void cambiarClave(String claveAntigua, String claveNueva, String claveNuevaErrada) {
		pageClaveCorreo.darClickCambiarClave();
		pageClaveCorreo.ingresarClaveActual(claveAntigua);
		pageClaveCorreo.ingresarClaveNueva(claveNueva);
		pageClaveCorreo.ingresarConfirmarClave(claveNuevaErrada);
		utilidad.tomaEvidencia("Claves diligenciadas_Clave actual " + claveAntigua + "_Clave nueva " + claveNueva
				+ "_Confirmación " + claveNuevaErrada);
		pageClaveCorreo.darClickContinuar();
		pageClaveCorreo.darClickContinuar();
	}

	@Step
	public void validarCambioDeClaveExitoso() {
		pageClaveCorreo.validarCambioDeClaveExitoso();
		utilidad.tomaEvidencia("Cambio de Clave exitoso");
		pageClaveCorreo.cerrarMensajeCambioClaveExitoso();		
	}

	@Step
	public void validarCambioDeClaveFallido() {
		pageClaveCorreo.validarCambioDeClaveFallido();
		utilidad.tomaEvidencia("Cambio de Clave Fallido");
	}

	

//************************************************Funciones Cambio De Correo************************************************************

	@Step
	public void cambiarCorreo(String correoNuevo) {
		utilidad.esperaMiliseg(2000);
		pageClaveCorreo.darClickCambiarCorreo();
		pageClaveCorreo.ingresarCorreoActual(correoNuevo);
		pageClaveCorreo.ingresarCorreoNuevo(correoNuevo);
		utilidad.tomaEvidencia("Cambio de correo electronico");
		pageClaveCorreo.darClickContinuar();
		//pageClaveCorreo.darClickContinuar();
	}
	@Step
	public void cambiarCorreoNoCoincide(String correoNuevo, String correoNuevoDos) {
		pageClaveCorreo.darClickCambiarCorreo();
		pageClaveCorreo.ingresarCorreoActual(correoNuevo);
		pageClaveCorreo.ingresarCorreoNuevo(correoNuevoDos);
		utilidad.tomaEvidencia("Cambio de correo electronico");
		pageClaveCorreo.darClickContinuar();
		//pageClaveCorreo.darClickContinuar();
	}

	@Step
	public void validarCambioDeCorreoExitoso() {
		pageClaveCorreo.validarCambioDeCorreoExitoso();
		utilidad.tomaEvidencia("Cambio de correo exitoso");
	}

	@Step
	public void validarCambioDeCorreoFallido() {		
		pageClaveCorreo.validarCambioDeCorreoFallido();
		utilidad.tomaEvidencia("Valido PopUp referente al cambio de correo"); 
	}

//*****************************************************CASO CASITA ROJA*****************************************************

	@Step
	public void activarTeclado() {
		utilidad.tomaEvidencia("Ingreso a opción Mas Servicios");
		pageMenuHamburguesa.darClickActivarCasitaRoja();
		utilidad.tomaEvidencia("Ingreso a activar Casita Roja");
		
	}
	@Step
	public void validarIndicacionesDeActivacion() {
		pageClaveCorreo.darClickBtnActivarTeclado();
		utilidad.esperaMiliseg(2000);
		utilidad.tomaEvidencia("Dar permisos a la app");
		pageClaveCorreo.darPermisosDeLaApp();
		utilidad.tomaEvidencia("Dar en botón lenguaje e introducción");
		pageClaveCorreo.darEnBtnLenguajeIntroduccion();
		utilidad.tomaEvidencia("Dar en botón activar teclado Daviplata");
		pageClaveCorreo.darBtnActivarTecladoDaviplata();
		utilidad.tomaEvidencia("Dar en botón aceptar atencion teclado Daviplata");
		pageClaveCorreo.darBtnAceptarAtencionTecladoDaviplata();
		utilidad.tomaEvidencia("Dar en botón aceptar reinicio de dispositivo de teclado Daviplata");
		pageClaveCorreo.darBtnAceptarAtencionTecladoDaviplata();
		utilidad.tomaEvidencia("Dar en botón seleccionar teclado Daviplata");
		pageClaveCorreo.darBtnSeleccionarTecladoDaviplata();
		utilidad.tomaEvidencia("Dar en opción seleccionar teclado Daviplata");
		pageClaveCorreo.darOpcionSeleccionarTecladoDaviplata();
		utilidad.esperaMiliseg(3000);
		utilidad.tomaEvidencia("Validar Mensaje de teclado Daviplata activo");
		pageClaveCorreo.validarActivacionTeclado();
	}

	//*****************************************************CASOS VER MOVIMIENTOS *****************************************************
	
	@Step
	public void seleccionoVerMovimientos() {
		pageMenuHamburguesa.darClickVerMovimientos();
		utilidad.tomaEvidencia("Ingreso a ver movimientos");
	}

	@Step
	public void validarQueSeMuestrenLosMovimientos() {
		pageClaveCorreo.verificarQueSeMuestrenMovimientos();
		utilidad.tomaEvidencia("Movimientos del DaviPlata");
		
	}
	@Step
	public void filtroMovimientos() {
		fecha = pageClaveCorreo.obtenerPrimeraFecha();
		System.out.println("segui con desplegar fecha");
		pageClaveCorreo.darClickDesplegableSelectorFecha();
		utilidad.tomaEvidencia("Dia a Filtrar");
		pageClaveCorreo.darClickEnAceptarFecha();
	}
	@Step
	public void validarQueSeMuestrenLosMovimientosFiltrados() {
		pageClaveCorreo.verificoDiaFiltrado(fecha);
		utilidad.tomaEvidencia("Se muestran datos del dia Filtrado");		
	}
	
	@Step
	public void validarEnvioDeMovimientosACorreo() {
		pageClaveCorreo.darClickEnviarACorreo();
		pageClaveCorreo.validarQueSeEnvienDatosACorreo();
		utilidad.tomaEvidencia("Movimientos enviados al correo");
	}
	
	@Step
	public void clicAceptarTerminosCondiciones() {
        boolean visibilidadMensaje = utilidadesTCS.validateElementVisibilityCatch("xpath", ClaveCorreoPageObject.CHECK_AUTORIZO_DATOS_PERSONALES);
    	
        /** Bloque IF: dado sea visible el texto!**/
        if(visibilidadMensaje == true) {		
        	utilidadesTCS.clicElement("xpath", ClaveCorreoPageObject.CHECK_AUTORIZO_DATOS_PERSONALES);
    		utilidadesTCS.clicElement("xpath", ClaveCorreoPageObject.CHECK_AUTORIZO_CONSULTAS_REPORTES);
    		utilidad.tomaEvidencia("Autorizo terminos y condiciones");
    		utilidadesTCS.clicElement("xpath", ClaveCorreoPageObject.BOTON_ACEPTAR_TERMINOS_Y_CONDICIONES);
        }
	}
}
