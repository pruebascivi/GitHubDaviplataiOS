package daviplata.nacional.iOS.steps;
import static org.junit.Assert.fail;

import daviplata.nacional.iOS.pageObjects.AcercaDePageObjects;
import daviplata.nacional.iOS.pageObjects.CambioDispositivoPageObjects;
import daviplata.nacional.iOS.pageObjects.WebLatiniaPageObject;
import daviplata.nacional.iOS.pageObjects.LoginPageObjects;
import daviplata.nacional.iOS.pageObjects.LoginRobustoPage;
import daviplata.nacional.iOS.utilidades.Credenciales;
import daviplata.nacional.iOS.utilidades.Utilidades;
import daviplata.nacional.iOS.utilidades.UtilidadesTCS;
import net.thucydides.core.annotations.Step;

public class CambioDispositivoSteps {
	
	Utilidades utilidad;
	UtilidadesTCS utilidadesTCS;
	AcercaDePageObjects pageAcercaDe;
	LoginSteps loginSteps;
	
	@Step
	public void ingresarUsuario(String tipoDocumento, String usuario) {
		System.out.println("Ingresando a la app");
		utilidadesTCS.esperarElementVisibility("xpath", LoginRobustoPage.BOTON_NOTIFICACIONES);
		loginSteps.validarVersionApp();// Version
		utilidadesTCS.seleccionarTipoDocumentoInputHomeDaviplata("xpath",tipoDocumento);
		utilidadesTCS.writeElement("xpath", LoginRobustoPage.CAMPO_INGRESO_USUARIO, usuario);
		Utilidades.esperaMiliseg(800);
		Utilidades.tomaEvidencia("Se diligencia tipo de documento y usuario");
		utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_INGRESAR);
	}
	
	@Step 
	public void realizarCambioDispositivo(String contrasena) {
		boolean estadoVisibilidadPopUP = utilidadesTCS.validateElementVisibility("xpath", LoginRobustoPage.POP_UP_CAMBIAR_DISPOSITIVO);
		if (estadoVisibilidadPopUP == true) {
			Utilidades.tomaEvidencia("Dar clic en el boton continuar del popUp");
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.CONTINUAR_POP_UP_CAMBIAR_DISPOSITIVO);
			Utilidades.esperaMiliseg(1000);
            boolean validarBiometria = utilidadesTCS.validateElementVisibilityCatch("xpath",LoginRobustoPage.TEXTO_TYT_BIOMETRIA);
            if (validarBiometria == true) {
                System.out.println("*********************************************");
                System.out.println("*                                           *");
                System.out.println("*          ¡ALERTA DE BIOMETRÍA!            *");
                System.out.println("*                                           *");
                System.out.println("*        BIOMETRÍA ACTIVA DETECTADA         *");
                System.out.println("*                                           *");
                System.out.println("*********************************************");
                Utilidades.tomaEvidencia("Error, biometria activa en cambio de dispositivo");
                fail("Se encuentra la biometria activa para el cambio de dispositivo");
            }else {
            	utilidadesTCS.esperarElementVisibility("xpath", LoginRobustoPage.POP_UP_REGLAMENTO_CAMBIO_DISPOSITIVO);
    			utilidadesTCS.clicElement("xpath", LoginRobustoPage.POP_UP_REGLAMENTO_CAMBIO_DISPOSITIVO);
    			Utilidades.esperaMiliseg(1000);
    			utilidadesTCS.writeElement("xpath", LoginRobustoPage.INPUT_CORREO_ELECTRONICO, "XXX@gmail.com");
    			utilidadesTCS.writeElement("xpath", LoginRobustoPage.INPUT_CLAVE_DAVIPLATA, contrasena);
    			Utilidades.tomaEvidencia("Diligenciar formulario de cambio de dispositivo");
    			utilidadesTCS.clicElement("xpath", LoginRobustoPage.CONTINUAR_POP_UP_CAMBIAR_DISPOSITIVO);
    			utilidadesTCS.clicElement("xpath", LoginRobustoPage.CONTINUAR_POP_UP_CAMBIAR_DISPOSITIVO);
    			Utilidades.esperaMiliseg(1000);
    			utilidadesTCS.esperarElementVisibility("xpath", LoginRobustoPage.POP_UP_OTP);
    			utilidadesTCS.clicElement("xpath", LoginRobustoPage.POP_UP_OTP);
    			Utilidades.esperaMiliseg(2000);
    			utilidadesTCS.clickCoordinates(221,435);
    			boolean visibilidadTeclado = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.BOTON_ACEPTAR_TECLADO_IOS);
    			if(visibilidadTeclado == true) {
    				utilidadesTCS.escribirPorTecladoIos("230116");
        			Utilidades.tomaEvidencia("Ingresar Otp de cambio de dispositivo");
    				utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_ACEPTAR_TECLADO_IOS);
    			}else {
    				utilidadesTCS.clickCoordinates(194,385);
    				utilidadesTCS.validateElementVisibility("xpath", LoginRobustoPage.BOTON_ACEPTAR_TECLADO_IOS);
    				utilidadesTCS.escribirPorTecladoIos("230116");
    				Utilidades.tomaEvidencia("Ingresar otp de cambio de dispositivo");
    				utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_ACEPTAR_TECLADO_IOS);
    			}
    			Utilidades.esperaMiliseg(2000);
    			utilidadesTCS.clickCoordinates(217,562);
    			boolean estadoVisiblePopUpAmigos = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.POP_UP_INVITE_AMIGOS);
    			boolean estadoVisibleSlideInformativo = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.SLIDE_INFORMATIVO_DAVIPLATA);
    			if(estadoVisiblePopUpAmigos == true || estadoVisibleSlideInformativo ==true) {
    				Utilidades.esperaMiliseg(1000);
        			boolean estadoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.POP_UP_INVITE_AMIGOS);
        			if(estadoVisible == true) {
        				Utilidades.tomaEvidencia("Cerrar pop up de amigos");
        				utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_CLOSE);
        			}
        			utilidadesTCS.esperarElementVisibility("xpath", LoginRobustoPage.SLIDE_INFORMATIVO_DAVIPLATA);
        			Utilidades.tomaEvidencia("Aceptar pop up de slide informativo");
        			utilidadesTCS.clicElement("xpath", LoginRobustoPage.CONTINUAR_POP_UP_CAMBIAR_DISPOSITIVO);
    			}else {
    				utilidadesTCS.clickCoordinates(198,490);
    				Utilidades.esperaMiliseg(1000);
        			boolean estadoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.POP_UP_INVITE_AMIGOS);
        			if(estadoVisible == true) {
        				Utilidades.tomaEvidencia("Cerrar pop up de amigos");
        				utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_CLOSE);
        			}
        			utilidadesTCS.esperarElementVisibility("xpath", LoginRobustoPage.SLIDE_INFORMATIVO_DAVIPLATA);
        			Utilidades.tomaEvidencia("Aceptar pop up de slide informativo");
        			utilidadesTCS.clicElement("xpath", LoginRobustoPage.CONTINUAR_POP_UP_CAMBIAR_DISPOSITIVO);
    			}
    			
            }
		}
	}
	
	@Step 
	public void realizarCambioDispositivoClaveIncorrecta(String contrasena, String otp) {
		boolean estadoVisibilidadPopUP = utilidadesTCS.validateElementVisibility("xpath", LoginRobustoPage.POP_UP_CAMBIAR_DISPOSITIVO);
		if (estadoVisibilidadPopUP == true) {
			Utilidades.tomaEvidencia("Dar clic en el boton continuar del popUp");
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.CONTINUAR_POP_UP_CAMBIAR_DISPOSITIVO);
			Utilidades.esperaMiliseg(1000);
            boolean validarBiometria = utilidadesTCS.validateElementVisibilityCatch("xpath",LoginRobustoPage.TEXTO_TYT_BIOMETRIA);
            if (validarBiometria == true) {
                System.out.println("*********************************************");
                System.out.println("*                                           *");
                System.out.println("*          ¡ALERTA DE BIOMETRÍA!            *");
                System.out.println("*                                           *");
                System.out.println("*        BIOMETRÍA ACTIVA DETECTADA         *");
                System.out.println("*                                           *");
                System.out.println("*********************************************");
                Utilidades.tomaEvidencia("Error, biometria activa en cambio de dispositivo");
                fail("Se encuentra la biometria activa para el cambio de dispositivo");
            }else {
            	utilidadesTCS.esperarElementVisibility("xpath", LoginRobustoPage.POP_UP_REGLAMENTO_CAMBIO_DISPOSITIVO);
    			utilidadesTCS.clicElement("xpath", LoginRobustoPage.POP_UP_REGLAMENTO_CAMBIO_DISPOSITIVO);
    			Utilidades.esperaMiliseg(1000);
    			utilidadesTCS.writeElement("xpath", LoginRobustoPage.INPUT_CORREO_ELECTRONICO, "XXX@gmail.com");
    			utilidadesTCS.writeElement("xpath", LoginRobustoPage.INPUT_CLAVE_DAVIPLATA, contrasena);
    			Utilidades.tomaEvidencia("Diligenciar formulario de cambio de dispositivo");
    			utilidadesTCS.clicElement("xpath", LoginRobustoPage.CONTINUAR_POP_UP_CAMBIAR_DISPOSITIVO);
    			utilidadesTCS.clicElement("xpath", LoginRobustoPage.CONTINUAR_POP_UP_CAMBIAR_DISPOSITIVO);
    			Utilidades.esperaMiliseg(1000);
    			utilidadesTCS.esperarElementVisibility("xpath", LoginRobustoPage.POP_UP_OTP);
    			utilidadesTCS.clicElement("xpath", LoginRobustoPage.POP_UP_OTP);
    			Utilidades.esperaMiliseg(2000);
    			utilidadesTCS.clickCoordinates(221,435);
    			boolean visibilidadTeclado = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.BOTON_ACEPTAR_TECLADO_IOS);
    			if(visibilidadTeclado == true) {
    				utilidadesTCS.escribirPorTecladoIos(otp);
        			Utilidades.tomaEvidencia("Ingresar Otp de cambio de dispositivo");
    				utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_ACEPTAR_TECLADO_IOS);
    			}else {
    				utilidadesTCS.clickCoordinates(194,385);
    				utilidadesTCS.validateElementVisibility("xpath", LoginRobustoPage.BOTON_ACEPTAR_TECLADO_IOS);
    				utilidadesTCS.escribirPorTecladoIos("230116");
    				Utilidades.tomaEvidencia("Ingresar otp de cambio de dispositivo");
    				utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_ACEPTAR_TECLADO_IOS);
    			}
    			Utilidades.esperaMiliseg(2000);
    			utilidadesTCS.clickCoordinates(217,562);
    			boolean estadoVisibleClaveIncorrecta = utilidadesTCS.validateElementVisibilityCatch("xpath", CambioDispositivoPageObjects.POPUP_OTP_Y_CLAVE_INCORRECTA);
    			if(estadoVisibleClaveIncorrecta == false) {
    				Utilidades.esperaMiliseg(1000);
    				utilidadesTCS.clickCoordinates(198,490);
    			}
    			
            }
		}
	}
	
	@Step
	public void validarMensajeClaveIncorrecta() {
		String texto = utilidadesTCS.obtenerTexto("xpath", CambioDispositivoPageObjects.POPUP_OTP_Y_CLAVE_INCORRECTA);
		utilidadesTCS.validateTextContainsStringIgnoreUppercaseLowercase(texto, "Clave daviplata incorrecta");
		Utilidades.tomaEvidencia("Validar mensaje de clave incorrecta de cambio de dispositivo");
		
	}
	
	@Step
	public void validarMensajeOtpIncorrecta() {
		String texto = utilidadesTCS.obtenerTexto("xpath", CambioDispositivoPageObjects.POPUP_OTP_Y_CLAVE_INCORRECTA);
		utilidadesTCS.validateTextContainsStringIgnoreUppercaseLowercase(texto, "Otp inválido");
		Utilidades.tomaEvidencia("Validar mensaje de otp incorrecta de cambio de dispositivo");
		
	}
}