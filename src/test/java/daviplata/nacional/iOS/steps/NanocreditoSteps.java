package daviplata.nacional.iOS.steps;

import static org.junit.Assert.fail;
import daviplata.nacional.iOS.definitions.Hooks;
import daviplata.nacional.iOS.pageObjects.AcercaDeDaviplataPage;
import daviplata.nacional.iOS.pageObjects.CuantoDeboPageObjects;
import daviplata.nacional.iOS.pageObjects.HomePageObjects;
import daviplata.nacional.iOS.pageObjects.LoginRobustoPage;
import daviplata.nacional.iOS.pageObjects.MenuHamburguesaPageObjects;
import daviplata.nacional.iOS.pageObjects.NanocreditoPageObjects;
import daviplata.nacional.iOS.pageObjects.RegistroMayoresPageObjects;
import daviplata.nacional.iOS.pageObjects.RegistroPageObject;
import daviplata.nacional.iOS.utilidades.Utilidades;
import daviplata.nacional.iOS.utilidades.UtilidadesTCS;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import net.thucydides.core.annotations.Step;

public class NanocreditoSteps {
	
	MenuHamburguesaPageObjects pageMenuHamburguesa;
	CuantoDeboPageObjects cuantoDeboPageObjects;
	NanocreditoPageObjects pageNanoCredito;
	HomePageObjects pageHome;
	private AppiumDriver<MobileElement> driver = Hooks.getDriver();
	Utilidades utilidad;
	UtilidadesTCS utilidadesTCS;
	LoginSteps loginSteps;
	RegistroPageObject registroObj = new RegistroPageObject();



	public void ingresoAOpcionNanocredito() {
		pageHome.darClickEnNoMeInteresa();
		pageMenuHamburguesa.darClickMenuHamburguesa();
		Utilidades.tomaEvidencia("Ingreso a menu Hamburguesa");
		pageMenuHamburguesa.darClickBtnNanoCredito();
		Utilidades.esperaMiliseg(1000);
		Utilidades.tomaEvidencia("Click a opcion Nanocredito");

	}

	public void autorizoUtilizacionDeDatos() {
		pageNanoCredito.esperoAQueAparezcaAutorizoNanoCredito();
		utilidad.scrollHastaElFinalDePantalla();
		Utilidades.esperaMiliseg(1000);
		Utilidades.tomaEvidencia("Autorizando tratamiento de datos");
		pageNanoCredito.darClickAutorizo();

	}

	public void adquirirCreditoMontoNoPermitido() {
		pageNanoCredito.darClickNoDeseo();
		Utilidades.esperaMiliseg(2500);
		Utilidades.tomaEvidencia("Condiciones para adquirir credito");
		Utilidades.esperaMiliseg(1000);
		pageNanoCredito.darClickContinuar();
		Utilidades.esperaMiliseg(1000);
		Utilidades.tomaEvidencia("Sugerencia de monto para el credito");
		pageNanoCredito.obtenerMontoMaximo();
		String montoSuperior = pageNanoCredito.calcularMontoSuperior();
		pageNanoCredito.ingresarMonto(montoSuperior);
		Utilidades.esperaMiliseg(1000);
		Utilidades.tomaEvidencia("Ingresando monto no permitido");
		pageNanoCredito.darClickContinuar();
	}
	
	public void adquirirCreditoMontoPermitido() {
		pageNanoCredito.darClickNoDeseo();
		Utilidades.esperaMiliseg(2500);
		Utilidades.tomaEvidencia("Condiciones para adquirir credito");
		Utilidades.esperaMiliseg(1000);
		pageNanoCredito.darClickContinuar();
		Utilidades.esperaMiliseg(1000);
		pageNanoCredito.obtenerMontoMaximo();
		pageNanoCredito.ingresarMontoAleatorio();
		Utilidades.esperaMiliseg(1000);
		Utilidades.tomaEvidencia("ingresar monto permitido");
		pageNanoCredito.darClickContinuar();
		pageNanoCredito.escogerFechaInicialPago();
		pageNanoCredito.seleccionarDiaDePago();
		Utilidades.tomaEvidencia("Escoger fecha de cobro");
		pageNanoCredito.darClickContinuar();
		pageNanoCredito.ingresarCiudadResidencia();
		// Vamos en el paso 1
		Utilidades.tomaEvidencia("Ingresar ciudad de residencia");
		pageNanoCredito.darClickAceptarCondiciones();
		Utilidades.tomaEvidencia("Aceptar terminos y condiciones");
		pageNanoCredito.darClickAutorizoDebitoAutomatico();
		Utilidades.tomaEvidencia("Aceptar debito automatico");
		pageNanoCredito.darClickAceptoInformacion();

		// Vamos en el paso 2 o 50%
		pageNanoCredito.esperarIconoEstudioCredito50();
	//	utilidad.moverPantalla();
//		utilidad.moverPantalla();
		pageNanoCredito.darClickContinuar();
		Utilidades.tomaEvidencia("Se evalua la solicitud");
		pageNanoCredito.esperarConfirmacionPreaprobacionNanoCredito();
		Utilidades.tomaEvidencia("Confirmacion de preaprobacion de nanocredito");
	//	utilidad.moverPantalla();
		//utilidad.moverPantalla();
		pageNanoCredito.darClickContinuar();

		pageNanoCredito.darClickAceptarFirmarPagare();
		Utilidades.tomaEvidencia("Aceptar firmar pagare");
		pageNanoCredito.darClickContratoCreditoDaviplata();
		Utilidades.tomaEvidencia("Aceptar credito daviplata");
		pageNanoCredito.darClickSeguroVida();
		Utilidades.tomaEvidencia("Aceptar seguro de vida");
		pageNanoCredito.darClickAutorizacionDaviplata();
		Utilidades.tomaEvidencia("Autorizacion desembolso en Daviplata");
	//	utilidad.moverPantalla();
		pageNanoCredito.darClickFinalizarFirmaAutenticacion();

	}

	public void solicitudDelCreditoPorMontoPermitidoNoCumploPoliticas() {
		pageNanoCredito.darClickNoDeseo();
		Utilidades.esperaMiliseg(2500);
		Utilidades.tomaEvidencia("Condiciones para adquirir credito");
		Utilidades.esperaMiliseg(1000);
		pageNanoCredito.darClickContinuar();
		Utilidades.esperaMiliseg(1000);
		pageNanoCredito.obtenerMontoMaximo();
		pageNanoCredito.ingresarMontoAleatorio();
		Utilidades.esperaMiliseg(1000);
		Utilidades.tomaEvidencia("ingresar monto permitido");
		pageNanoCredito.darClickContinuar();
		pageNanoCredito.escogerFechaInicialPago();
		pageNanoCredito.seleccionarDiaDePago();
		Utilidades.tomaEvidencia("Escoger fecha de cobro");
		pageNanoCredito.darClickContinuar();
		pageNanoCredito.ingresarCiudadResidencia();
		// Vamos en el paso 1
		Utilidades.tomaEvidencia("Ingresar ciudad de residencia");
		pageNanoCredito.darClickAceptarCondiciones();
		Utilidades.tomaEvidencia("Aceptar terminos y condiciones");
		pageNanoCredito.darClickAutorizoDebitoAutomatico();
		Utilidades.tomaEvidencia("Aceptar debito automatico");
		pageNanoCredito.darClickAceptoInformacion();
		// Vamos en el paso 2 o 50%
		pageNanoCredito.esperarIconoEstudioCredito50();
	//	utilidad.moverPantalla();
		//utilidad.moverPantalla();
		pageNanoCredito.darClickContinuar();
		Utilidades.tomaEvidencia("Se evalua la solicitud");
		pageNanoCredito.esperarConfirmacionPreaprobacionNanoCredito();
		Utilidades.tomaEvidencia("Confirmacion de preaprobacion de nanocredito");
	//	utilidad.moverPantalla();
	//	utilidad.moverPantalla();
		pageNanoCredito.darClickContinuar();
	}

	public void validoNegacionDelCredito() {
		pageNanoCredito.validoNegacionDelCredito();
		Utilidades.esperaMiliseg(5000);
		Utilidades.tomaEvidencia("Credito negado.");
	}
	
	public void validoNegacionDelCreditoOTPNoValida() {
		for (int contador = 0; contador < 3; contador++) {
			pageNanoCredito.ingresarOTPNoValida();
			Utilidades.tomaEvidencia("Se ingresa OTP invalida");
			pageNanoCredito.darClickAceptarOTP();
			if (contador < 2) {
				Utilidades.esperaMiliseg(5000);
				Utilidades.tomaEvidencia("Se informa que la OTP es invalida");
				pageNanoCredito.darClickNotificacionOTPInvalida();
			}
		}
		pageNanoCredito.validoNegacionDelCreditoOTPInvalida();

	}

	public void validoNegacionDelCreditoNoCumploPoliticas() {
		pageNanoCredito.validoNegacionDelCreditoNoCumploPoliticas();
	}

	public void validoQueElDaviPlataNoConcuerde() {
		pageNanoCredito.validoDaviplataNoConcuerde();
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Numero DaviPlata no concuerda");
		Utilidades.esperaMiliseg(1000);
		pageNanoCredito.darClickEnAceptar();
	}
	
	@Step
	public void ingresarALaAppEnNanocredito(String tipoDocumento, String usuario, String contrasena) {
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
    			/** CLIC POR COORDENADAS A CAMPO 'CÓDIGO DE 6 DÍGITOS' **/
    			utilidadesTCS.clickCoordinates(221,435);
    			boolean visibilidadTeclado = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.BOTON_ACEPTAR_TECLADO_IOS);
    			if(visibilidadTeclado == true) {
    				utilidadesTCS.escribirPorTecladoIos("230116");
    				utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_ACEPTAR_TECLADO_IOS);
    			}else {
        			/** CLIC POR COORDENADAS A CAMPO 'CÓDIGO DE 6 DÍGITOS' **/
    				utilidadesTCS.clickCoordinates(194,385);
    				utilidadesTCS.escribirPorTecladoIos("230116");
    				utilidadesTCS.validateElementVisibility("xpath", LoginRobustoPage.BOTON_ACEPTAR_TECLADO_IOS);
    				utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_ACEPTAR_TECLADO_IOS);
    			}
    			Utilidades.esperaMiliseg(2000);
    			/** CLIC POR COORDENADAS A BOTÓN 'CONTINUAR' DESPUES DE INGRESO DEL 'CÓDIGO DE 6 DÍGITOS' **/
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
        			/** CLIC POR COORDENADAS A BOTÓN 'CONTINUAR' DESPUES DE INGRESO DEL 'CÓDIGO DE 6 DÍGITOS' **/
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
			pageNanoCredito.ingresarContrasena(contrasena);
			Utilidades.tomaEvidencia("Diligencio contraseña " + contrasena);
			pageNanoCredito.darClicBotonIngresar();
			Utilidades.esperaMiliseg(500);
			pageNanoCredito.darClicBotonIngresar();
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
	}
	
	public void verificarVersion() {

		try {
			
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
	public void validarPopUpNanocredito() {
		boolean estadoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", NanocreditoPageObjects.POP_UP_NANOCREDITO);
		if(estadoVisible == true) {
			Utilidades.esperaMiliseg(1500);
			utilidadesTCS.esperarElementVisibility("xpath", NanocreditoPageObjects.POP_UP_NANOCREDITO);
	        Utilidades.tomaEvidencia("Valio Pop Up campaña Nanocrédito");
		}
	}
	
	@Step
	public void validarOpcionNoMeInteresa() {
		boolean estadoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", NanocreditoPageObjects.POP_UP_NANOCREDITO);
		if(estadoVisible == true) {
			Utilidades.esperaMiliseg(1500);
			utilidadesTCS.clicElement("xpath", NanocreditoPageObjects.BNT_NO_ME_INTERESA);
			System.out.println("Di clic al botón no me interesa");
		}
	}
	
	@Step
	public void validaCajonNanocreditoBarraProductos() {
		Utilidades.esperaMiliseg(1500);
		utilidadesTCS.esperarElementVisibility("xpath", NanocreditoPageObjects.BTN_CAJA_NANOCREDITO);
		utilidadesTCS.scrollBackground("xpath", NanocreditoPageObjects.BTN_CAJA_NANOCREDITO, -150, 0);
        Utilidades.tomaEvidencia("Valida caja de productos y cajón Nanocrédito");
		Utilidades.esperaMiliseg(800);
	}
	
	@Step
    public void validarHomeGloboSaldoDaviplata() {
		Utilidades.esperaMiliseg(1500);
        Utilidades.tomaEvidencia("Validar home daviplata");
    }
	
	@Step
    public void ingresarANanocreditoHome() {
		Utilidades.esperaMiliseg(1500);
		utilidadesTCS.clicElement("xpath", NanocreditoPageObjects.BTN_CAJA_NANOCREDITO);
		Utilidades.esperaMiliseg(2000);
		Utilidades.tomaEvidencia("Pantalla solicitar nanocredito");		
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
		boolean visibilidad4 = utilidadesTCS.validateElementVisibilityCatch("xpath", RegistroPageObject.BTN_ACEPTAR);
		if(visibilidad4 == true) {
			Utilidades.esperaMiliseg(800);
			registroObj.clicBtnContinuar();		
		}			
		Utilidades.esperaMiliseg(1500);
        Utilidades.tomaEvidencia("Validar ingreso a Nanocredito home");
    }
}
