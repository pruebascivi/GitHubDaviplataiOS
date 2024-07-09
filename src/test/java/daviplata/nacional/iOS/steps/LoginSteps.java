package daviplata.nacional.iOS.steps;

import static org.junit.Assert.fail;
import java.util.Random;
import daviplata.nacional.iOS.utilidades.stratus.StratusDev;
import daviplata.nacional.iOS.pageObjects.AcercaDeDaviplataPage;
import daviplata.nacional.iOS.pageObjects.AcercaDePageObjects;
import daviplata.nacional.iOS.pageObjects.ComprasMarketPlacePageObjects;
import daviplata.nacional.iOS.pageObjects.HomePageObjects;
import daviplata.nacional.iOS.pageObjects.LoginPageObjects;
import daviplata.nacional.iOS.pageObjects.LoginRobustoPage;
import daviplata.nacional.iOS.pageObjects.NanocreditoPageObjects;
import daviplata.nacional.iOS.pageObjects.OlvidoClavePageObjects;
import daviplata.nacional.iOS.pageObjects.WebLatiniaPageObject;
import daviplata.nacional.iOS.pageObjects.NewLPageObjects;
import daviplata.nacional.iOS.pageObjects.BolsilloPageObjects;
import daviplata.nacional.iOS.pageObjects.PasarPlataPageObjects;
import daviplata.nacional.iOS.pageObjects.RegistroMayoresPageObjects;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import daviplata.nacional.iOS.utilidades.Utilidades;
import daviplata.nacional.iOS.utilidades.UtilidadesTCS;
import net.thucydides.core.annotations.Step;

public class LoginSteps {
	
	NewLPageObjects NewpageLatinia;
	private static LoginPageObjects pageLogin;
	PasarPlataPageObjects pagePasarPlata;
	HomePageObjects pageHome;
	NanocreditoPageObjects nanocreditoPageObjects;
	ComprasMarketPlacePageObjects comprasMarketPlacePageObjects;
	AcercaDePageObjects pageAcercaDe;
	OlvidoClavePageObjects olvidoClaveageObjects;
	BolsilloPageObjects pageBolsillos;
	WebLatiniaPageObject pageLatinia;
	StratusDev stratusdev;
	UtilidadesTCS utilidadesTCS;
	LoginRobustoSteps loginRobustoSteps;
	Utilidades utilidades;
	//private AppiumDriver<MobileElement> driver = Hooks.getDriver();
	//private Scenario scenario = Hooks.scenario;
	Random rand = new Random();
	
	@Step
	public void validarVersionApp() {
    	Utilidades.esperaMiliseg(1500);
		utilidadesTCS.clicElement("xpath", AcercaDePageObjects.BOTON_NOTIFICACIONES);
    	Utilidades.esperaMiliseg(2000);
    	utilidadesTCS.esperarElementVisibility("xpath", AcercaDePageObjects.BOTON_ACERCA_DE);
		utilidadesTCS.clicElement("xpath", AcercaDePageObjects.BOTON_ACERCA_DE);
		Utilidades.esperaMiliseg(2000);
		String versionAppDaviplata = utilidadesTCS.obtenerTexto("xpath", AcercaDePageObjects.LABEL_VERSION);
		BaseUtil.versionApp = versionAppDaviplata;
		System.out.println("Esta es la version de la app: " + versionAppDaviplata);
		Utilidades.tomaEvidencia("Esta es la versión de la app" + versionAppDaviplata);
		utilidadesTCS.clicElement("xpath", AcercaDePageObjects.BOTON_REGRESAR);
	}

	@Step
	public void ingresarAApp(String tipoDocumento, String usuario, String contrasena) {
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
		System.out.println("Ingresando a la app");
		Utilidades.esperaMiliseg(5000);
		utilidadesTCS.validateElementVisibility("xpath", LoginRobustoPage.BOTON_NOTIFICACIONES);
		verificarVersion();
		utilidadesTCS.seleccionarTipoDocumentoInputHomeDaviplata("xpath",tipoDocumento);
		utilidadesTCS.writeElement("xpath", LoginRobustoPage.CAMPO_INGRESO_USUARIO, usuario);
		Utilidades.esperaMiliseg(800);
		Utilidades.tomaEvidencia("Selecciono tipo de usurio: " + tipoDocumento + " e ingreso usuario: " + usuario);
		utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_INGRESAR);
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 120);
		boolean estadoVisibilidadPopUP = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.POP_UP_CAMBIAR_DISPOSITIVO);
		if (estadoVisibilidadPopUP == true) {
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
    				utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_ACEPTAR_TECLADO_IOS);
    			}else {
    				utilidadesTCS.clickCoordinates(194,385);
    				utilidadesTCS.escribirPorTecladoIos("230116");
    				utilidadesTCS.validateElementVisibility("xpath", LoginRobustoPage.BOTON_ACEPTAR_TECLADO_IOS);
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
        				utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_CLOSE);
        			}
        			utilidadesTCS.esperarElementVisibility("xpath", LoginRobustoPage.SLIDE_INFORMATIVO_DAVIPLATA);
        			utilidadesTCS.clicElement("xpath", LoginRobustoPage.CONTINUAR_POP_UP_CAMBIAR_DISPOSITIVO);
    			} else {
    				utilidadesTCS.clickCoordinates(198,490);
    				Utilidades.esperaMiliseg(1000);
        			boolean estadoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.POP_UP_INVITE_AMIGOS);
        			if(estadoVisible == true) {
        				utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_CLOSE);
        			}
        			utilidadesTCS.esperarElementVisibility("xpath", LoginRobustoPage.SLIDE_INFORMATIVO_DAVIPLATA);
        			utilidadesTCS.clicElement("xpath", LoginRobustoPage.CONTINUAR_POP_UP_CAMBIAR_DISPOSITIVO);
    			}
            }
			
		}else {
			Utilidades.esperaMiliseg(1000);
			pageLogin.ingresarContrasena(contrasena);
			Utilidades.tomaEvidencia("Diligencio contraseña " + contrasena);
			pageLogin.darClicBotonIngresar();
			Utilidades.esperaMiliseg(500);
			pageLogin.darClicBotonIngresar();
			utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 120);
		}

		boolean estadoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.POP_UP_INVITE_AMIGOS);
		if(estadoVisible == true) {
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_CLOSE);
		}
		
        boolean condicionesUso = utilidadesTCS.validateElementVisibilityCatch("xpath", RegistroMayoresPageObjects.TEXTO_ACTUALIZAMOS_CONDICIONES);
        if(condicionesUso) {
            Utilidades.esperaMiliseg(500);
            utilidadesTCS.clicElement("xpath", RegistroMayoresPageObjects.CHECK_BOX_ACTUALIZACION_1);
            utilidadesTCS.clicElement("xpath", RegistroMayoresPageObjects.CHECK_BOX_ACTUALIZACION_2);
            Utilidades.esperaMiliseg(500);
            Utilidades.tomaEvidencia("Validar actualizacion de las condiciones de uso de los datos");
            utilidadesTCS.clicElement("xpath", RegistroMayoresPageObjects.ACEPTAR_ACTUALZIACION_CONDICIONES);
        }
        
		boolean aprovechaBeneficios = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.POPUP_APROVECHA_BENEFICIOS);
		if(aprovechaBeneficios == true) {
            Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.BTN_LO_VERÉ_LUEGO_POPUP);
		}
        
		Utilidades.esperaMiliseg(3000);
		utilidadesTCS.esperarElementVisibility("xpath", LoginRobustoPage.BOTON_BOLSILLOS);
		Utilidades.tomaEvidencia("Ingreso a Daviplata");
		pageLogin.capturarSaldo();
		Utilidades.esperaMiliseg(500);
		pageLogin.cerrarMensajeTopes();
	}
	
	@Step
	public void cerrarPopUpInvitaAmigos () {
		
		boolean estadoVisiblePopUpAmigos = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.POP_UP_INVITE_AMIGOS);
		if(estadoVisiblePopUpAmigos == true) {
			
			Utilidades.esperaMiliseg(1500);
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_CLOSE);
		}
	}
	
	@Step
	public void ingresarAAppSinCapturaSaldo(String tipoDocumento, String usuario, String contrasena) {
		System.out.println("Ingresando a la app");
		Utilidades.esperaMiliseg(500);
		verificarVersion();
		utilidadesTCS.seleccionarTipoDocumentoInputHomeDaviplata("xpath",tipoDocumento);
		utilidadesTCS.writeElement("xpath", LoginRobustoPage.CAMPO_INGRESO_USUARIO, usuario);
		Utilidades.esperaMiliseg(800);
		Utilidades.tomaEvidencia("Se diligencia tipo de documento y usuario");
		utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_INGRESAR);
		Utilidades.tomaEvidencia("Ingreso a Daviplata");
        pageLogin.ingresarContrasena(contrasena);
        Utilidades.tomaEvidencia("Diligencio usuario " + usuario + " contraseña " + contrasena);
        pageLogin.darClicBotonIngresar();
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
        Utilidades.esperaMiliseg(1500);
        pageLogin.darClicBotonIngresar();
        Utilidades.esperaMiliseg(5000);
		boolean estadoVisiblePopUpAmigos = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.POP_UP_INVITE_AMIGOS);
		if(estadoVisiblePopUpAmigos == true) {
			
			Utilidades.esperaMiliseg(1500);
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_CLOSE);
		}
		boolean estadoVisiblePopUpSolicitud = utilidadesTCS.validateElementVisibilityCatch("xpath", PasarPlataPageObjects.POPUP_SOLICITUD_PENDIENTE);
		if(estadoVisiblePopUpSolicitud == true) {
			Utilidades.esperaMiliseg(1500);
			Utilidades.tomaEvidencia("Valido presencia de una solicitud de dinero");
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_CLOSE);
		}
		Utilidades.esperaMiliseg(5000);
		pageLogin.capturarSaldo();
		//pageLogin.cerrarMensajeTopes();
	}
	
	
	@Step
	public void loginAds(String tipoDocumento, String usuario, String contrasena) {
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
		System.out.println("Ingresando a la app");
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.esperarElementVisibility("xpath", LoginRobustoPage.BOTON_NOTIFICACIONES);
		Utilidades.esperaMiliseg(800);
		verificarVersion();
		utilidadesTCS.seleccionarTipoDocumentoInputHomeDaviplata("xpath",tipoDocumento);
		utilidadesTCS.writeElement("xpath", LoginRobustoPage.CAMPO_INGRESO_USUARIO, usuario);
		Utilidades.esperaMiliseg(800);
		Utilidades.tomaEvidencia("Selecciono tipo de usurio: " + tipoDocumento + " e ingreso usuario: " + usuario);
		utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_INGRESAR);
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 120);
		boolean estadoVisibilidadPopUP = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.POP_UP_CAMBIAR_DISPOSITIVO);
		if (estadoVisibilidadPopUP == true) {
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
    				utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_ACEPTAR_TECLADO_IOS);
    			}else {
    				utilidadesTCS.clickCoordinates(194,385);
    				utilidadesTCS.escribirPorTecladoIos("230116");
    				utilidadesTCS.validateElementVisibility("xpath", LoginRobustoPage.BOTON_ACEPTAR_TECLADO_IOS);
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
        				utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_CLOSE);
        			}
        			utilidadesTCS.esperarElementVisibility("xpath", LoginRobustoPage.SLIDE_INFORMATIVO_DAVIPLATA);
        			utilidadesTCS.clicElement("xpath", LoginRobustoPage.CONTINUAR_POP_UP_CAMBIAR_DISPOSITIVO);
    			}else {
    				utilidadesTCS.clickCoordinates(198,490);
    				Utilidades.esperaMiliseg(1000);
        			boolean estadoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.POP_UP_INVITE_AMIGOS);
        			if(estadoVisible == true) {
        				utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_CLOSE);
        			}
        			utilidadesTCS.esperarElementVisibility("xpath", LoginRobustoPage.SLIDE_INFORMATIVO_DAVIPLATA);
        			utilidadesTCS.clicElement("xpath", LoginRobustoPage.CONTINUAR_POP_UP_CAMBIAR_DISPOSITIVO);
    			}
            }
			
		}else {
			Utilidades.esperaMiliseg(1000);
			pageLogin.ingresarContrasena(contrasena);
			Utilidades.tomaEvidencia("Diligencio contraseña " + contrasena);
			pageLogin.darClicBotonIngresar();
			Utilidades.esperaMiliseg(500);
			pageLogin.darClicBotonIngresar();
			utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 120);
		}

		boolean estadoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.POP_UP_INVITE_AMIGOS);
		if(estadoVisible == true) {
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_CLOSE);
		}
		
        boolean condicionesUso = utilidadesTCS.validateElementVisibilityCatch("xpath", RegistroMayoresPageObjects.TEXTO_ACTUALIZAMOS_CONDICIONES);
        if(condicionesUso) {
            Utilidades.esperaMiliseg(500);
            utilidadesTCS.clicElement("xpath", RegistroMayoresPageObjects.CHECK_BOX_ACTUALIZACION_1);
            utilidadesTCS.clicElement("xpath", RegistroMayoresPageObjects.CHECK_BOX_ACTUALIZACION_2);
            Utilidades.esperaMiliseg(500);
            Utilidades.tomaEvidencia("Validar actualizacion de las condiciones de uso de los datos");
            utilidadesTCS.clicElement("xpath", RegistroMayoresPageObjects.ACEPTAR_ACTUALZIACION_CONDICIONES);
        }
        
		boolean aprovechaBeneficios = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.POPUP_APROVECHA_BENEFICIOS);
		if(aprovechaBeneficios == true) {
            Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.BTN_LO_VERÉ_LUEGO_POPUP);
		}
	}
	
	@Step
	public void ingresarAAppNuevaContrasenia(String tipoDocumento, String usuario, String claveNueva) {
		System.out.println("Ingresando a la app");
		utilidadesTCS.seleccionarTipoDocumentoInputHomeDaviplata("xpath",tipoDocumento);
		utilidadesTCS.writeElement("xpath", LoginRobustoPage.CAMPO_INGRESO_USUARIO, usuario);
		Utilidades.esperaMiliseg(800);
		Utilidades.tomaEvidencia("Se diligencia tipo de documento y usuario");
		utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_INGRESAR);
		
		Utilidades.esperaMiliseg(1000);
		Utilidades.tomaEvidencia("Ingreso a Daviplata");
		pageLogin.ingresarContrasena(claveNueva);
		Utilidades.tomaEvidencia("Diligencio usuario " + usuario + " contraseña " + claveNueva);
		pageLogin.darClicBotonIngresar();
		Utilidades.esperaMiliseg(500);
		pageLogin.darClicBotonIngresar();
	}
	
	public void ingresarAAppNuevaContraseniaDespuesCambio(String tipoDocumento, String usuario, String claveNueva) {
		System.out.println("Ingresando a la app");
		Utilidades.esperaMiliseg(500);
		verificarVersion();
		utilidadesTCS.seleccionarTipoDocumentoInputHomeDaviplata("xpath",tipoDocumento);
		utilidadesTCS.writeElement("xpath", LoginRobustoPage.CAMPO_INGRESO_USUARIO, usuario);
		Utilidades.esperaMiliseg(800);
		Utilidades.tomaEvidencia("Se diligencia tipo de documento y usuario");
		utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_INGRESAR);
		Utilidades.tomaEvidencia("Ingreso a Daviplata");
		pageLogin.ingresarContrasenaDespuesCambio(claveNueva);
		Utilidades.tomaEvidencia("Diligencio usuario " + usuario + " contraseña " + claveNueva);
		pageLogin.darClicBotonIngresar();
		Utilidades.esperaMiliseg(500);
		pageLogin.darClicBotonIngresar();
		Utilidades.esperaMiliseg(4000);
		boolean estadoVisiblePopUpAmigos = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.POP_UP_INVITE_AMIGOS);
		if(estadoVisiblePopUpAmigos == true) {
			
			Utilidades.esperaMiliseg(1500);
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_CLOSE);
		}
		Utilidades.tomaEvidencia("Ingreso a la app correctamente");
	}
	
	@Step
	public void ingresarCaracteresEspeciales(String tipoDocumento, String usuario) {
		System.out.println("Ingresando a la app");
		Utilidades.esperaMiliseg(2000);
		pageLogin.popUpReinicio();
		verificarVersion();// Version
		pageAcercaDe.btn_ContinuarintroduccionApp();		
		pageLogin.sliderRegistroAcercaDaviplata();
		utilidadesTCS.seleccionarTipoDocumentoInputHomeDaviplata("xpath",tipoDocumento);
		utilidadesTCS.writeElement("xpath", LoginRobustoPage.CAMPO_INGRESO_USUARIO, usuario);
		Utilidades.esperaMiliseg(800);
		Utilidades.tomaEvidencia("Se diligencia tipo de documento y usuario");
		utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_INGRESAR);
		
	}
	
	@Step
	public void ingresarLongitudSuperiorQuince(String tipoDocumento, String usuario) {
		System.out.println("Ingresando a la app");
		Utilidades.esperaMiliseg(2000);
		verificarVersion();// Version
		utilidadesTCS.seleccionarTipoDocumentoInputHomeDaviplata("xpath",tipoDocumento);
		utilidadesTCS.writeElement("xpath", LoginRobustoPage.CAMPO_INGRESO_USUARIO, usuario);
		Utilidades.esperaMiliseg(800);
		Utilidades.tomaEvidencia("Se diligencia tipo de documento y usuario");
		
	}
	
	@Step
	public void validarMensajeDeCaracteres() {
		utilidadesTCS.esperarElementVisibility("xpath", LoginPageObjects.MENSAJE_CARACTER_ESPECIAL);
		pageLogin.validarMensajeCaracteres();
		Utilidades.tomaEvidencia("Mensaje de validacion al ingresar caracteres en numero documental");
	}
	
	@Step
	public void validarLongitudDeCaracteres(String usuario) {	
		pageLogin.validarLongitudCaracteres(usuario);
		Utilidades.tomaEvidencia("Validación de longitud de caracteres");
	}
		


	@Step
	public void ingresarAAppContraInco(String usuario, String contrasena) {
		System.out.println("Ingresando a la app");
		verificarVersion();// Version
		pageLogin.clickBtnPopUpHuella();
		pageLogin.ingresarUsuario(usuario);
		Utilidades.tomaEvidencia("Ingreso a Daviplata");
		utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_INGRESAR);
		boolean flag = pageLogin.activarDaviplata(usuario, contrasena);
		if (flag) {
			boolean clienteRegistrado = pageLogin.verificoSiEstaRegistrado();
			if (!clienteRegistrado) {
				System.out.println("Cliente no registrado en el dispositivo!!");
				registroOTP(contrasena);
			} else {
				pageLogin.ingresarContrasena(contrasena);
				Utilidades.tomaEvidencia("Diligencio usuario " + usuario + " contraseña " + contrasena);
				pageLogin.darClicBotonIngresar();
			}
		}
	}

	@Step
	public void ingresarAAppSinClave(String usuario) {
		System.out.println("Ingresando a la app");
		verificarVersion();// Version
		pageLogin.ingresarUsuario(usuario);
		Utilidades.tomaEvidencia("Ingreso a Daviplata");
		utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_INGRESAR);
		pageLogin.darClicEnRegistrarse();
	}
	
	@Step
	public void ingresarAAppSinCredenciales() {
		System.out.println("Ingresando a la app");
		verificarVersion();// Version
		Utilidades.tomaEvidencia("Ingreso a Daviplata");
	}
	
	@Step
	public void ingresarAAppCambioDispositivo(String tipoDocumento, String usuario, String contrasena) {
		System.out.println("Ingresando a la app");
		verificarVersion();// Version
		Utilidades.tomaEvidencia("Ingreso a Daviplata");
		utilidadesTCS.seleccionarTipoDocumentoInputHomeDaviplata("xpath",tipoDocumento);
		utilidadesTCS.writeElement("xpath", LoginRobustoPage.CAMPO_INGRESO_USUARIO, usuario);
		Utilidades.esperaMiliseg(800);
		Utilidades.tomaEvidencia("Se diligencia tipo de documento y usuario");
		utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_INGRESAR);
	}

	
	@Step
	public void ingresarLatiniaRegistro() {
		pageLogin.ingresarLatiniaRegistro();
	}
	
	
	@Step
	public void ingresoOtp() {
		pageLogin.ingresarOTPGenerica();
	}
	
	@Step
	public void ingresoOtpInvalida() {
		pageLogin.ingresoOTPInvalida();
	}
	
	@Step
	public void validoPerfilPersona() {
		pageLogin.validarPerfilPersona();
	}
	
	@Step
	public void logoutApp() {
		
		/**
		 * REALIZO PASOS PARA CERRAR SESIÓN
		 */
		try {
		
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.esperarElementVisibility("xpath", LoginPageObjects.MENU_DAVIPLATA_BTN);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath", LoginPageObjects.MENU_DAVIPLATA_BTN);
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.esperarElementVisibility("xpath", LoginPageObjects.SALIR_DAVIPLATA_BTN);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath", LoginPageObjects.SALIR_DAVIPLATA_BTN);
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.esperarElementVisibility("xpath", LoginPageObjects.CONFIRMAR_SALIR_DAVIPLATA);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath", LoginPageObjects.CONFIRMAR_SALIR_DAVIPLATA);
			System.out.println("Estoy saliendo de la App");
			
		} catch(Exception e) {
			
			fail("No se encontró botón cerrar sesion, ni boton aceptar cerrar sesion debido a: " + e.getMessage());
		}
	}
	
	@Step
	public void registrarUsuario(String tipoId, String usuario) {
		/**
		 * SELECCIONO LA OPCIÓN REGISTRARME
		 */
		try {
	
			System.out.println("Ingresando a la app");
			verificarVersion();
			utilidadesTCS.esperarElementVisibility("xpath", LoginPageObjects.REGRESAR_MENÚ_INICIAL_BTN);
			Utilidades.esperaMiliseg(800);
			utilidadesTCS.clicElement("xpath", LoginPageObjects.REGRESAR_MENÚ_INICIAL_BTN);
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.esperarElementVisibility("xpath", LoginPageObjects.REGISTRARME_BTN);
			Utilidades.esperaMiliseg(800);
			utilidadesTCS.clicElement("xpath", LoginPageObjects.REGISTRARME_BTN);
			Utilidades.esperaMiliseg(1500);
			utilidadesTCS.seleccionarTipoDocumentoInputHomeDaviplata("xpath",tipoId);
			Utilidades.esperaMiliseg(1500);
            utilidadesTCS.writeElement("xpath", LoginRobustoPage.CAMPO_INGRESO_USUARIO, usuario);
			Utilidades.esperaMiliseg(1500);
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_CONTINUAR);
			Utilidades.esperaMiliseg(1000);
			Utilidades.tomaEvidencia("Ingreso a Daviplata");
			
		} catch(Exception e) {
			
			assert utilidadesTCS.validateElementVisibilityCatch("xpath", LoginPageObjects.REGRESAR_MENÚ_INICIAL_BTN) : "No se pudo interactuar con el elemento.";
			assert utilidadesTCS.validateElementVisibilityCatch("xpath", LoginPageObjects.REGISTRARME_BTN) : "No se pudo interactuar con el elemento.";
			fail("No se encontró botón registrarme debido a: " + e.getMessage());
		}
	}
	
	@Step
	public void validoMensajeIngreso() {
		String mensaje = pageLogin.buscarMensajeDeIngresoALaAplicacion();
		Utilidades.tomaEvidencia("Valido ingreso");
		pageLogin.validoIngresoALaAPP(mensaje);
	}

	@Step
	public void validoMensajeDeIngresoFalido() {
		String mensaje = pageLogin.buscarMensajeDeIngresoFallido();
		Utilidades.tomaEvidencia("Valido ingreso Fallido");
		pageLogin.validoIngresoFallidoALaApp(mensaje);
	}

	@Step
	public void cerrarSesionDaviplata() {
		pageLogin.pulsarBtnSalirApp();
		Utilidades.tomaEvidencia("Saliendo de la App");
		pageLogin.pulsarBtnAceptarSalirApp();
	}
//***********************************************************ValidacionDeSaldos***********************************************************

	
	@Step
	public void validoSaldoDaviPlata() {
		Utilidades.esperaMiliseg(2000);
		pageLogin.validoSaldoDaviPlata();
		Utilidades.tomaEvidencia("Validacion de saldo DaviPlata");
	}

	
	@Step
	public void validoSaldoeCard() {
		Utilidades.esperaMiliseg(2000);
		pageLogin.validoSaldoeCard();
		Utilidades.tomaEvidencia("Validacion de saldo eCard");
	}

	
	@Step
	public void validoSaldoBolsillo() {
		Utilidades.esperaMiliseg(2000);
		pageLogin.validoSaldoBolsillo();
		Utilidades.tomaEvidencia("Validacion de saldo Bolsillo");
	}
 
	
	@Step
	public void capturoSaldos() {
		Utilidades.esperaMiliseg(2000);
		pageLogin.capturoSaldoTotal();
		pageLogin.capturoSaldos();
	}

	@Step
	public void validoSaldoTotal() {
		pageLogin.validoSaldoTotal();
		Utilidades.tomaEvidencia("Validacion de saldo Total");
	}
	
	@Step
	public void validarmensajedaviplatainvalido() {
		pageLogin.validomensajedaviplatainvalido();
	}
	//Bolsilos
	@Step
	public void ingresoABolsillosHome(){
		pageBolsillos.pulsarBtnCrearBolsillos();
	}

	@Step
	public void ingresoAMenuHamburguesa(){
		pageLogin.darClickEnMenuHamburguesa();
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Ingreso a Menu Hamburguesa");
	}
	
	@Step
	public void ingresoAPerfilPersona(){
		Utilidades.esperaMiliseg(1500);
		utilidadesTCS.clicElement("xpath", LoginPageObjects.PERFIL_PERSONA_BTN);
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Ingreso a Menu Hamburguesa");
	}
	
	@Step
	public void ingesoALaOpcionMeterPlataDaviPlataInvalido() {
		pageLogin.darClickEnMenuHamburguesa();
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Ingreso a Menu");
		pageLogin.darClickEnUsarPlata();
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Seleccion de opcion Pasar Plata");
		pageLogin.darClickEnPasarPlata();
		Utilidades.tomaEvidencia("Seleccion de opcion 'A otro DaviPlata'");
		pagePasarPlata.aOtroDaviPlata();
		//pagePasarPlata.pasarPlataEnLinea();
		Utilidades.tomaEvidencia("Ingreso los valores necesarios");
		pagePasarPlata.txtPasarPlata();
	}

	// Pedir plata
	
	@Step
	public void ingresoALaOpcionPedirPlata(String numero) {
		pageLogin.darClickEnMenuHamburguesa();
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Ingreso a Menu");
		pageLogin.darClickEnUsarPlata();
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Seleccion de opcion Pasar Plata");
		pageLogin.darClickEnPasarPlata();
		Utilidades.tomaEvidencia("Seleccion de opcion 'A otro banco en linea'");
		pagePasarPlata.aOtroBancoEnLinea();
		pedirPlataEnLinea();
		pagePasarPlata.txtPedirPlata(numero);
		pagePasarPlata.btnClose();
	}
	
	// Cambiar Numero
	@Step
		public void ingresoALaOpcionCambiarNumeroPrivado() {
			pageLogin.darClickEnMenuHamburguesa();
			Utilidades.esperaMiliseg(500);
			Utilidades.tomaEvidencia("Ingreso a Menu");
			pageLogin.darClickEnMasServicios();
			Utilidades.esperaMiliseg(2000);
			Utilidades.tomaEvidencia("Seleccion de opcion Mas Servicios");
			pageLogin.pulsarBotonCambiarNumero();
			Utilidades.esperaMiliseg(650);
			Utilidades.tomaEvidencia("Seleccion de opcion 'Cambiar Numero'");
			/*pagePasarPlata.aOtroBancoEnLinea();
			pagePasarPlata.pasarPlataEnLinea();
			Utilidades.tomaEvidencia("Ingreso los valores necesarios");
			pagePasarPlata.txtPasarPlata();*/
		}
		
	@Step
		public void ingresarAOpcionCambiarNumeroZonaPublica() {
			pageLogin.darClickEnOpcionCambiarNumeroZonaPublica();
		}

	// Verificar que llego la peticion del dinero
	
	@Step
	public void validarPeticionDinero() {
		pageLogin.darClickEnMenuHamburguesa();
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Ingreso a Menu");
		pageLogin.darClickEnUsarPlata();
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Seleccion de opcion Pasar Plata");
		pageLogin.darClickEnPasarPlata();
		Utilidades.tomaEvidencia("Seleccion de opcion 'A otro banco en linea'");
		pagePasarPlata.aOtroBancoEnLinea();
		pagePasarPlata.btnVerificarSolicitud();

	}

	@Step
	public void pedirPlataEnLinea() {
		pagePasarPlata.pedirPlataEnLinea();
		Utilidades.tomaEvidencia("Ingreso los valores necesarios");
	}

	@Step
	public void validoDireccionamientoAPse() {
		pageLogin.validarIngresoAPSE();
		Utilidades.esperaMiliseg(3000);
		Utilidades.tomaEvidencia("Ingreso a portal PSE"); 
	}
	
	@Step
	public void validoSaldoGloboEnCeros() {
        String saldoCeros = utilidadesTCS.obtenerTexto("xpath", LoginPageObjects.SALDO_HOME_CEROS);
        utilidadesTCS.validateTextContainsString(saldoCeros, "0,00");
        Utilidades.tomaEvidencia("Validar que en caso de que el cliente no tenga saldo, la pantalla de debe ver según la imagen 3, de la HU 4");
    }
//***********************************************************ValidacionDeActualizacionDeDatos***********************************************************

//*********************************************************Validacion ayuda en linea logueado*******************************************

	@Step
	public void ingresoALaOpcionAtencionEnLinea() {
		Utilidades.esperaMiliseg(10000);
		pageHome.darClickAyudaEnLineaHome();
		Utilidades.tomaEvidencia("Ingreso a Ayuda En Linea");
	}
//****************************************************Validacion notificaciones ********************************************************

	@Step
	public void ingresoAMensajesYNotificaciones() {
		pageHome.darClickCampanaNotificaciones();
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
		Utilidades.esperaMiliseg(5000);
		Utilidades.tomaEvidencia("Ingreso a Mensajes y Notificaciones");
	}

	@Step
	public void validarQueAparezcanLosMensajes() {
		pageLogin.darClickEnMensajes();
		pageLogin.validarQueAparezcanMensajes();
		Utilidades.tomaEvidencia("Mensajes de novedades");
	}
	
	
	@Step
	public void validarQueAparezcanLasNotificaciones() {
		pageLogin.validarQueAparezcanNotificaciones();
		Utilidades.tomaEvidencia("Transacciones");
	}

	@Step
	public void validarQueAparezcanCompras() {
		pageLogin.btnCompras();
		pageLogin.validarQueAparezcanCompras();
		Utilidades.tomaEvidencia("Mensajes de Compras");
	}

	@Step
	public void leerCompras() {
		pageLogin.btnBonoLeer();
	}

	@Step
	public void validarQueSePuedanEliminar() {
		pageLogin.seleccionarMensajeAEliminar();
		Utilidades.tomaEvidencia("Seleccion de mensaje a eliminar");
		Utilidades.esperaMiliseg(500);
		pageLogin.darClickEnEliminar();
		pageLogin.validarQueSeEliminenLosMensajesONotificaciones();
		Utilidades.tomaEvidencia("Mensaje eliminado con exito y Dar en boton aceptar de mensaje eliminado.");
		pageLogin.darBtnAceptarEliminarMensaje();
	}

	@Step
	public void verificoPopUpNanocredito() {
		Utilidades.tomaEvidencia("Mensaje de creditos No activos");
		pageLogin.verificoPopUp();
		Utilidades.esperaMiliseg(5000);
		Utilidades.tomaEvidencia("Redirecciona a menu NanoCredito");

	}

	@Step
	public void registroOTP(String contrasena) {
		Utilidades.tomaEvidencia("Cliente no registrado en el dispositivo.");
		pageLogin.darClickEnContinuarRegistro();
		pageLogin.ingresarCorreoElectronico();
		Utilidades.tomaEvidencia("Ingreso datos de registro.");
		pageLogin.ingresoClaveDaviplata(contrasena);
		pageLogin.darClickEnContinuarOTP();
		Utilidades.tomaEvidencia("OTP generada.");
		//pageLogin.darClickEnNotificacion();
		String numCel = pageLogin.capturoNumTelefono();
		// Latinia Web
		NewpageLatinia.initDriverNLatinia();
		NewpageLatinia.clicBtnContinuar();
		NewpageLatinia.ingresarEmpresa();
		NewpageLatinia.ingresarUsuario();
		NewpageLatinia.ingresarPassword();
		NewpageLatinia.darClickAcceder();
		NewpageLatinia.darClickBtnActualizar();
		String otp = NewpageLatinia.traeOTP(numCel);
		NewpageLatinia.darClickFinalizarSesion();
		pageLogin.ingresoOTP(otp);
		Utilidades.tomaEvidencia("OTP Ingresada.");
		pageLogin.darClickEnContinuarRegistro();
	}
	
	@Step
	public void validacionCritreios(){
	pageLogin.validacionDatos();
	}
	
	public void ingresarUsuarioContraseña(String tipoDocumento, String usuario, String contrasena) {

		System.out.println("Ingresando a la app");
		Utilidades.esperaMiliseg(2000);
		verificarVersion();// Version
		utilidadesTCS.seleccionarTipoDocumentoInputHomeDaviplata("xpath",tipoDocumento);
		utilidadesTCS.writeElement("xpath", LoginRobustoPage.CAMPO_INGRESO_USUARIO, usuario);
		Utilidades.esperaMiliseg(800);
		Utilidades.tomaEvidencia("Se diligencia tipo de documento y usuario");
		utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_INGRESAR);
		Utilidades.tomaEvidencia("Ingreso a Daviplata");

		boolean flag = pageLogin.activarDaviplata(usuario, contrasena);
		if (flag) {
			boolean clienteRegistrado = pageLogin.verificoSiEstaRegistrado();
			if (!clienteRegistrado) {
				System.out.println("Cliente no registrado en el dispositivo!!");
				registroOTP(contrasena);
			} else {
				pageLogin.ingresarContrasena(contrasena);
				Utilidades.tomaEvidencia("Diligencio usuario " + usuario + " contraseña " + contrasena);
			}
		}
	}
	
	public void consultoSaldoInicialStratus(String cuenta) {

		/*StratusDev.mostrarEscritorio();
		StratusDev.verificarBloqMayus();
		StratusDev.iniciarStratus();
		StratusDev.loginStratus();
		StratusDev.flujoConsultas();
		String[] datosConsulta = utilidad.saberTipoCuenta(cuenta, "DAVIVIENDA").split(",");

		StratusDev.consultarCuenta(datosConsulta[1], datosConsulta[0]);
		String saldoInicial = StratusDev.consultarSaldo(datosConsulta[0]);
		datosCuentas = new ModelConsultaCuentas(datosConsulta[0], datosConsulta[1], new BigDecimal(saldoInicial));
		listaSaldosIniciales.add(datosCuentas);

		System.out.println(listaSaldosIniciales.get(0).getSaldoInicial());
		StratusDev.cerrarStratus();*/
	}
	
	public void ingresarALaAppValidarDesplegableTipoDocumental() {
		System.out.println("Ingresando a la app");
		Utilidades.esperaMiliseg(2000);
		pageLogin.popUpReinicio();
		verificarVersion();// Version
		pageLogin.popUpReinicio();
		pageAcercaDe.btn_ContinuarintroduccionApp();
		pageLogin.sliderRegistroAcercaDaviplata();
		pageLogin.clickBtnPopUpHuella();
	}
	
	public void validarDesplegableTipoDocumental() {
		pageLogin.validarTipoDeDocumento();
		System.out.println("Validar tipo documental desplegable");
	}
	
	public void validoCaracterEspecial() {
		pageLogin.validacionCaracterEspecial();
		Utilidades.tomaEvidencia("Validación al ingresar caracteres especiales en la contraseña");
	}
	
	public void validarLongitudDeCaracteresPEP(String usuario) {
		pageLogin.validarLongitudCaracteresPEP(usuario);
		Utilidades.tomaEvidencia("Validación de longitud de caracteres del tipo documental PEP");
	}

	public void ingresarALaAppParaLookAndFeel(String tipoDocumento, String usuario) {
		System.out.println("Ingresando a la app");
		Utilidades.esperaMiliseg(2000);
		verificarVersion();// Version
		pageAcercaDe.btn_ContinuarintroduccionApp();		
		pageLogin.sliderRegistroAcercaDaviplata();
		utilidadesTCS.seleccionarTipoDocumentoInputHomeDaviplata("xpath",tipoDocumento);
		utilidadesTCS.writeElement("xpath", LoginRobustoPage.CAMPO_INGRESO_USUARIO, usuario);
		Utilidades.esperaMiliseg(800);
		Utilidades.tomaEvidencia("Se diligencia tipo de documento y usuario");
	}
	
	public void validarIngresoDaviplata() {
		pageLogin.validacionIngresoDaviPlataLookAndFeel();
		Utilidades.tomaEvidencia("Validar look and feel logeo en tipo y numero de documento");
	}

	public void ingresoContrasenalogeo(String contrasena) {
		utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_INGRESAR);
		pageLogin.ingresarContrasena(contrasena);
		pageLogin.darClicBotonIngresar();
	}
	
	public void validarLookAndFeelContrasena() {
		pageLogin.validacionIngresoContrasenaLookAndFeel();
		Utilidades.tomaEvidencia("Validar look and feel logeo contraseña");
	}
	
	@Step
	public void ingresarLatiniaMensajes() {
		pageLogin.ingresarLatinia();
	}
	

	@Step
	public void validarMensajesDeLatinia() {
		System.out.println("entre a validar mensajes de latinia step");
		WebLatiniaPageObject.vaidarAparezcaMensajes();
		pageLogin.validarMensajes();
		Utilidades.tomaEvidenciaPantalla("Validar mensajes visibles del cliente");
	}
	
	@Step
	public void cerrarSesionLatinia() {
		WebLatiniaPageObject.clicBtnHamburguesaLatiniaFinalizarSesion();
		Utilidades.tomaEvidenciaPantalla("Dar clic en finalizar sesión");
		WebLatiniaPageObject.darClickFinalizarSesion();
	}

	@Step
	public void ingresarAAppOlvidoClave(String tipoDocumento, String usuario, String contrasena) {
        System.out.println("Ingresando a la app");
        Utilidades.esperaMiliseg(2000);
        pageLogin.popUpReinicio();
        verificarVersion();// Version
        pageLogin.popUpReinicio();
        pageAcercaDe.btn_ContinuarintroduccionApp();
        pageLogin.sliderRegistroAcercaDaviplata();
        utilidadesTCS.seleccionarTipoDocumentoInputHomeDaviplata("xpath",tipoDocumento);
		utilidadesTCS.writeElement("xpath", LoginRobustoPage.CAMPO_INGRESO_USUARIO, usuario);
		Utilidades.esperaMiliseg(800);
		Utilidades.tomaEvidencia("Se diligencia tipo de documento y usuario");
		utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_INGRESAR);
        pageLogin.ingresarContrasena(contrasena);
        Utilidades.tomaEvidencia("Diligencio usuario " + usuario + " contraseña " + contrasena);
        pageLogin.darClicBotonIngresar();
        Utilidades.esperaMiliseg(5000);
        pageLogin.darClicBotonIngresar();
    }

	@Step
	public void ingresarALaApp() {
        System.out.println("🚀 Ingresando a la app 🚀");
        utilidadesTCS.esperarElementVisibility("xpath", LoginRobustoPage.BOTON_NOTIFICACIONES);
        verificarVersion();// Version
        utilidadesTCS.esperarElementVisibility("xpath", LoginRobustoPage.BOTON_NOTIFICACIONES);
        Utilidades.tomaEvidencia("Ingreso a Daviplata");
    }
	
	@Step
	public void verificarVersion() {
		try {
			Utilidades.esperaMiliseg(1500);
			utilidadesTCS.esperarElementVisibility("xpath", LoginRobustoPage.MENU_TRES_PUNTOS);
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.MENU_TRES_PUNTOS);
			Utilidades.tomaEvidencia("Menu tres puntos");
		} catch(Exception e) {
			
			System.out.println("No se pudo interactuar con el elemento debido a: " + e.getMessage().toString());
			assert utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.MENU_TRES_PUNTOS) : "No se pudo interactuar con el elemento." + LoginRobustoPage.MENU_TRES_PUNTOS;
		}
		try {
			Utilidades.esperaMiliseg(2000);
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.ACERCA_DE_DAVIPLATA);
			Utilidades.esperaMiliseg(1500);
			Utilidades.tomaEvidencia("Entro a menu hamburguesa perfil negocio");
			String version = utilidadesTCS.obtenerTexto("xpath", AcercaDeDaviplataPage.VERSION);
			Utilidades.tomaEvidencia("Ingreso al módulo 'Acerca de Daviplata' y capturo la versión: " + version );
			System.out.println("La versión es: " + version);
			
		} catch(Exception e) {
			System.out.println("No se pudo interactuar con el elemento debido a: " + e.getMessage().toString());
			assert utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.ACERCA_DE_DAVIPLATA) : "No se pudo interactuar con el elemento." + LoginRobustoPage.ACERCA_DE_DAVIPLATA;
		}
		try {
			
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.REGRESAR);
			utilidadesTCS.validateElementVisibility("name","Ingrese a su Daviplata");
			
		} catch(Exception e) {
			System.out.println("No se pudo interactuar con el elemento debido a: " + e.getMessage().toString());
			assert utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.REGRESAR) : "No se pudo interactuar con el elemento." + LoginRobustoPage.REGRESAR;
		}	
	}
	
	@Step
	public void ingresarTipoDocumentoYUsuario(String tipoDocumento, String usuario) {
		try {
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.seleccionarTipoDocumentoInputHomeDaviplata("xpath", tipoDocumento);
			utilidadesTCS.clicElement("name","Ingrese su número de documento");
			utilidadesTCS.writeElement("xpath", LoginRobustoPage.CAMPO_NUMERO_DOCUMENTO, usuario);
		} catch(Exception e) {
			fail("No se pudo interactuar con el elemento debido a: " + e.getMessage());
		}
		try {
			Utilidades.tomaEvidencia("Ingreso tipo y número de documento");
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.BTN_INGRESAR);
			Utilidades.esperaMiliseg(1000);
			boolean popUpParaIngresar = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.POPUP_PARA_INGRESAR);

			if(popUpParaIngresar) {
				String textPopUp = utilidadesTCS.obtenerTexto("xpath", LoginRobustoPage.POPUP_PARA_INGRESAR);
				Utilidades.tomaEvidencia("Acepto Popup: " + textPopUp);
				utilidadesTCS.clicElement("xpath", LoginRobustoPage.PARA_INGRESAR_BTN);
			}
		} catch(Exception e) {
			fail("No se pudo interactuar con el elemento debido a: " + e.getMessage());
		}
    }
}
