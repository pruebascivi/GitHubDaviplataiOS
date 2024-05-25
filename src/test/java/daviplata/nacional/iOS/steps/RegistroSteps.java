package daviplata.nacional.iOS.steps;

import daviplata.nacional.iOS.pageObjects.RegistroMayoresPageObjects;
import daviplata.nacional.iOS.pageObjects.RegistroPageObject;
import daviplata.nacional.iOS.utilidades.Utilidades;
import daviplata.nacional.iOS.utilidades.UtilidadesTCS;
import net.thucydides.core.annotations.Step;

public class RegistroSteps {
	
	private static RegistroPageObject registroObj;
	Utilidades utilidad;
	UtilidadesTCS utilidadesTCS;
	 
	
	@Step("Ingreso a mis datos")
	public void ingresarMisDatos(String nombre, String numDoc, String lugar, String cel,String correo) {
		registroObj.btnTomarFoto();
		registroObj.txtNombreApellido(nombre);
		registroObj.txtNumDoc(numDoc);
		//utilidad.esperaMilise(10000);
		registroObj.btnFecha(); 
		registroObj.btnHecho(); 
		registroObj.btnFechaExp();  
		registroObj.btnHecho();   
		registroObj.txtLugarExp(lugar);
		registroObj.txtNumCel(cel);
		registroObj.txtNumCelConf(cel);
		registroObj.txtCorreo(correo);
		utilidad.scrollDownSwipe();
		registroObj.txtCorreoConfirmar(correo);
		registroObj.btnContinuar();
		registroObj.checkBoxTerminosCondiciones();
		registroObj.btnAceptarTerminosCondiciones();
	}
	
	@Step("Acepto los terminos")
	public void aceptarTerminos() {
		registroObj.clickDaviplataInfo();
		registroObj.btnTerminos();
		utilidad.tomaEvidencia("Acepto los terminos");
		registroObj.btnContinuar();
		

	}
	
	@Step("Escribo la clave")
	public void ingresarClave(String clave) {
		registroObj.btnClave(clave);
	}
	
	@Step("Completo el flujo restante")
	public void completarFlujo() {
		registroObj.btnPersona();
		registroObj.continuarFlujo();
		

	}
	@Step("Escribo la clave")
	public void validoIngreso() {
		registroObj.validoIngreso();
		utilidad.tomaEvidencia("Valido el ingreso correcto");
		

	}
	
	@Step("Ingreso la otp invalida")
	public void ingresoOtpInvalida() {
		registroObj.ingresarOtpInvalida();
		

	}
	@Step("valido el mensaje otp invalida")
	public void validoOtpInvalida() {
		registroObj.otpInvalido();
		Utilidades.tomaEvidencia("Valido que se genere el mensaje de otp invalida");
	}
	
	@Step("Ingreso la clave incalida")
	public void ingresoClaveInvalida(String clave) {	
		registroObj.btnClaveInco(clave);

	}
	@Step("valido el mensaje otp invalida")
	public void validoClaveInvalida() {
		registroObj.validoClaveInco();
		utilidad.tomaEvidencia("Valido que se genere el mensaje de clave invalida");
	}
	
	@Step
	public void aceptoAutorizaciones() {
		boolean visibilidad = utilidadesTCS.validateElementVisibilityCatch("xpath", RegistroPageObject.CHECK_BOX_REGLAMENTO_USO);
		if(visibilidad == true) {
			Utilidades.esperaMiliseg(800);
			registroObj.aceptoReglamentoUso();
		}
		
		boolean visibilidad2 = utilidadesTCS.validateElementVisibilityCatch("xpath", RegistroPageObject.CHECK_BOX_DATOS_PERSONALES);
		if(visibilidad2 == true) {
			Utilidades.esperaMiliseg(800);
			registroObj.aceptoReglamentoDatosPersonales();
		}
		
		boolean visibilidad3 = utilidadesTCS.validateElementVisibilityCatch("xpath", RegistroPageObject.CHECK_BOX_REGLAMENTO_CONSULTA);
		if(visibilidad3 == true) {
			Utilidades.esperaMiliseg(800);
			registroObj.aceptoReglamentoConsultaInformacion();
		}
		Utilidades.tomaEvidencia("Acepto autorizaciones de registro");
		registroObj.clicBtnContinuar();		
	}
	
	@Step
	public void aceptarAutorizacion() {
		utilidad.esperaMiliseg(1500);
		registroObj.aceptoReglamentoUso();
		utilidad.esperaMiliseg(800);
		utilidad.tomaEvidencia("Acepto autorizaciones de registro");
		registroObj.clicBtnContinuar();	
		utilidad.esperaMiliseg(1500);
		utilidadesTCS.esperarElementVisibility("xpath", RegistroPageObject.CEDULA_TRADICIONAL);
		utilidad.esperaMiliseg(800);
		utilidadesTCS.clicElement("xpath", RegistroPageObject.CEDULA_TRADICIONAL);
		utilidad.esperaMiliseg(1500);
	}
	
	@Step
	public void validarRegistro() {
		utilidad.esperaMiliseg(2000);
		utilidad.tomaEvidencia("valide registro exitoso");
		//registroObj.validarRegistro();
		utilidad.esperaMiliseg(1000);
		utilidad.tomaEvidencia("actualización de terminos y condiciones");
		registroObj.aceptarAcualizacionTerminosYCondiciones();
		utilidad.esperaMiliseg(5000);
		utilidad.tomaEvidencia("registro completado");
	}
	
	@Step("Ingreso a mis datos")
	public void ingresarMisDatos(String nombre, String dia, String mes, String año, String diaExpedicion, String mesExpedicion, String anioExpedicion, String lugar, String cel, String correo) {
		
		boolean estadoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", RegistroMayoresPageObjects.TXT_VALIDACION_IDENTIDAD_BIO);
		if(estadoVisible == true) {
			utilidadesTCS.esperarElementVisibility("xpath", RegistroMayoresPageObjects.TXT_VALIDACION_IDENTIDAD);
			Utilidades.tomaEvidencia("Valido que me encuentro en la sección validación de identidad.");
			utilidadesTCS.clicElement("xpath", RegistroMayoresPageObjects.BX_CEDULA_TRADICIONAL);
			Utilidades.esperaMiliseg(1000);	
			
		}
		registroObj.txtNombreApellido(nombre);
		registroObj.ingresarDia(dia);
		registroObj.ingresarMes(mes);
		registroObj.ingresarAño(año);
		utilidad.esperaMiliseg(2000);
		utilidad.scrollDownSwipe();
		registroObj.ingresarDiaExpedicion(diaExpedicion); 
		registroObj.ingresarMesExpedicion(mesExpedicion); 
		registroObj.ingresarAnioExpedicion(anioExpedicion); 
		utilidad.scrollDownSwipe();
		registroObj.ingresarLugarExp(lugar);
		registroObj.txtNumCel(cel);
		registroObj.txtCorreo(correo);
		utilidadesTCS.clickCoordinates(409,383);		
		registroObj.txtCorreoConfirmar(correo);
		utilidad.esperaMiliseg(2000);
		utilidadesTCS.clickCoordinates(409,383);		
		utilidad.tomaEvidencia("Datos diligenciados");
		registroObj.btnContinuar();
	}
	
	@Step
	public void ingresoClaveInvalida(String clave, String claveErronea) {	
		registroObj.ingresarContrasena(clave);
		registroObj.ingresarContrasenaConfirmada(claveErronea);
	}
}
