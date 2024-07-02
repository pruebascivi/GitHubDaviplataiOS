package daviplata.nacional.iOS.steps;

import daviplata.nacional.iOS.pageObjects.LoginPageObjects;
import daviplata.nacional.iOS.pageObjects.LoginRobustoPage;
import daviplata.nacional.iOS.pageObjects.MarketPlacePageObjects;
import daviplata.nacional.iOS.pageObjects.PreguntasFrecuentesPageObjects;
import daviplata.nacional.iOS.pageObjects.RegistroMayoresPageObjects;
import daviplata.nacional.iOS.pageObjects.negocioPageObjects;
import daviplata.nacional.iOS.utilidades.Utilidades;
import daviplata.nacional.iOS.utilidades.UtilidadesTCS;
import net.thucydides.core.annotations.Step;

public class RegistroMayoresSteps{
	
	UtilidadesTCS utilidadesTcs;
	LoginPageObjects loginpageobjects;
	MarketPlacePageObjects marketPlacePageObjects;

	@Step
	public void validarMoverElBotonNecesitoAyudaAVariasZonasDeLaPantalla() {
		Utilidades.tomaEvidencia("El botón necesito ayuda se encuentra en la parte inferior derecha");
		utilidadesTcs.dragAndDrop("xpath", PreguntasFrecuentesPageObjects.BOTON_NECESITO_AYUDA, "xpath", RegistroMayoresPageObjects.LABEL_INGRESO_DAVIPLATA);
		Utilidades.tomaEvidencia("Validar que el botón 'Necesita ayuda' al abrir la app se encuentre en la esquina inferior derecha y permita desplazarse por toda la pantalla según la comodidad del usuario");
	}
	
	@Step
	public void validarQueEnLaPantallaBienvenidaNoEsteBotonNecesitoAyuda() {
		Utilidades.tomaEvidencia("Hacer clic en el botón regresar");
		utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BOTON_REGRESAR);
		boolean estadoVisibilidad = utilidadesTcs.validateElementInvisibility("xpath", PreguntasFrecuentesPageObjects.BOTON_NECESITO_AYUDA);
		utilidadesTcs.validateStatusElement(estadoVisibilidad);
		Utilidades.tomaEvidencia("Validar que en la pantalla de “Bienvenida” NO se visualicen los botones de back, cerrar o la opción de necesitas ayuda.");
	}
	
	@Step
	public void clicBotonYaTengoDaviplata() {
		Utilidades.tomaEvidencia("Hacer clic en el botón 'Ya tengo Daviplata'");
		utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BOTON_YA_TENGO_DAVIPLATA);
	}
	
	@Step
	public void validarPantallaDeLogin() {
		Utilidades.esperaMiliseg(4000);
		utilidadesTcs.esperarElementVisibility("xpath", RegistroMayoresPageObjects.LABEL_INGRESO_DAVIPLATA);
		boolean estadoVisibilidad = utilidadesTcs.validateElementVisibility("xpath", RegistroMayoresPageObjects.LABEL_INGRESO_DAVIPLATA);
		utilidadesTcs.validateStatusElement(estadoVisibilidad);
		Utilidades.tomaEvidencia("Validar que al da tap en el botón 'Ya tengo DaviPlata' el sistema lo debe enviar a la pantalla de login 'Ingrese a su DaviPlata'");
	}
	
	@Step
	public void validarFlechaTipoDocumento() {
		Utilidades.esperaMiliseg(2000);
		utilidadesTcs.esperarElementVisibility("xpath", RegistroMayoresPageObjects.LISTA_DESPLEGABLE_TIPO_DOCUMENTO);
		boolean estadoVisibilidad = utilidadesTcs.validateElementVisibility("xpath", RegistroMayoresPageObjects.LISTA_DESPLEGABLE_TIPO_DOCUMENTO);	
		utilidadesTcs.validateStatusElement(estadoVisibilidad);
		Utilidades.tomaEvidencia("Validar que en el campo se presente la flecha para selecccionar entre 'TI' 'CE' 'CC' ");
	}
	
	@Step
	public void validarMarcaDeAguaInputNumeroDocumento() {
		String texto = utilidadesTcs.obtenerTexto("xpath", LoginRobustoPage.CAMPO_NUMERO_DOCUMENTO);
		utilidadesTcs.validateTextContainsString(texto, "Número de documento");
		Utilidades.tomaEvidencia("Validar que en el campo 'Número de Documento' debe estar en marca de agua");
	}
	
	@Step
	public void escogerTipoDocumento(String tipoDocumento) {
		utilidadesTcs.seleccionarTipoDocumentoInputHomeDaviplata("xpath", tipoDocumento);
	}
	
	@Step
	public void ingresarNumeroDocumento(String numDocumento) {
		utilidadesTcs.writeElement("xpath", LoginRobustoPage.CAMPO_NUMERO_DOCUMENTO, numDocumento);
		Utilidades.esperaMiliseg(800);
		Utilidades.tomaEvidencia("Se diligencia tipo de documento y usuario");
	}
	
	@Step
	public void validarLongitudDeCincoDigitos () {
		String texto = utilidadesTcs.obtenerTexto("xpath", LoginRobustoPage.CAMPO_NUMERO_DOCUMENTO);
		utilidadesTcs.validarLongitudNumerica(texto, 5);
		Utilidades.tomaEvidencia("Validar que el campo sea solo numérico y con un minimo de 5 digitos");		
	}
	
	@Step
	public void limpiarCampoNumeroDocumento() {
		utilidadesTcs.cleanInputElement("xpath", LoginRobustoPage.CAMPO_NUMERO_DOCUMENTO);
	}
	
	@Step
	public void validarLongitudDeDiezYSeisDigitos() {
		String texto = utilidadesTcs.obtenerTexto("xpath", LoginRobustoPage.CAMPO_NUMERO_DOCUMENTO);
		utilidadesTcs.validarLongitudNumerica(texto, 16);
		Utilidades.tomaEvidencia("Validar que el campo sea solo numérico y con un minimo de 16 digitos");
	}

	@Step
	public void validarPopUpRegistroUsuarioNuevo() {
		String texto = utilidadesTcs.obtenerTexto("xpath", RegistroMayoresPageObjects.POP_UP_REGISTRO_USUARIO_NUEVO);
		utilidadesTcs.validateTextContainsString(texto,"Verifique que el número del documento");
		Utilidades.tomaEvidencia("Validar que al dar tap en el botón 'Ingresar' si el cliente no tiene cuenta daviplata le debe presentar pop-up");
	}
	
	@Step
	public void hacerClicEnElBotonIngresarDelLogin() {
		utilidadesTcs.clicElement("xpath", LoginRobustoPage.BTN_INGRESAR);
		Utilidades.esperaMiliseg(1000);
		Utilidades.tomaEvidencia("Hacer clic en el botón 'ingresar'");		
	}
	
	@Step
	public void validarBotonesEnPopUp() {
		String btnCancelar = utilidadesTcs.obtenerTexto("xpath", RegistroMayoresPageObjects.BOTON_CANCELAR_POP_UP_REGISTRO_USUARIO_NUEVO);
		utilidadesTcs.validateTextContainsString(btnCancelar,"Cancelar");
		String btnRegistrarme = utilidadesTcs.obtenerTexto("xpath", RegistroMayoresPageObjects.BOTON_REGISTRARME_POP_UP_REGISTRO_USUARIO_NUEVO);
		utilidadesTcs.validateTextContainsString(btnRegistrarme,"Registrarme");
		Utilidades.tomaEvidencia("Validar que en el pop-up esten presentes los botones 'Cancelar' y 'Registrarme'");
	}

	
	@Step
	public void validarFuncionalidadesDeBotonesEnPopUp() {
		utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BOTON_CANCELAR_POP_UP_REGISTRO_USUARIO_NUEVO);
		utilidadesTcs.esperarElementVisibility("xpath", RegistroMayoresPageObjects.LABEL_INGRESO_DAVIPLATA);
		Utilidades.tomaEvidencia("Valido que luego de dar clic sobre 'Cancelar' me envía a la pantalla de ingreso de datos.");
		utilidadesTcs.clicElement("xpath", LoginRobustoPage.BTN_INGRESAR);
		utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BOTON_REGISTRARME_POP_UP_REGISTRO_USUARIO_NUEVO);
		utilidadesTcs.esperarElementVisibility("xpath", RegistroMayoresPageObjects.TXT_AUTORIZACIONES_REGISTRO);
		Utilidades.tomaEvidencia("Valido que me encuentro en la sección de autorizaciones.");
		utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.CHECKBOX_AUTORIZACIONES);
		Utilidades.tomaEvidencia("Acepto el checkbox de las autorizaciones.");
		utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BOTON_CONTINUAR);
		utilidadesTcs.esperarElementVisibility("xpath", RegistroMayoresPageObjects.TXT_VALIDACION_IDENTIDAD);
		Utilidades.tomaEvidencia("Valido que me encuentro en la sección validación de identidad.");
		utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BX_CEDULA_TRADICIONAL);
		Utilidades.esperaMiliseg(1000);
		boolean estadoVisible = utilidadesTcs.validateElementVisibilityCatch("xpath", RegistroMayoresPageObjects.TXT_VALIDACION_IDENTIDAD_BIO);
		if(estadoVisible == true) {
			Utilidades.tomaEvidencia("Valido que me encuentro en el módulo de ingreso de datos para registro");
		} else {
			Utilidades.tomaEvidencia("Valido que me encuentro en la sección validación de identidad con biometría.");
		}
	}
	
	@Step
	public void regresarHastaElHomeBienvenidos() {
		utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BTN_REGRESAR_DESDE_VI_BIO);
		utilidadesTcs.esperarElementVisibility("xpath", RegistroMayoresPageObjects.TXT_VALIDACION_IDENTIDAD);
		utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BTN_REGRESAR_DESDE_VI);
		utilidadesTcs.esperarElementVisibility("xpath", RegistroMayoresPageObjects.TXT_AUTORIZACIONES_REGISTRO);
		utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BTN_REGRESAR_DESDE_AUTORIZACIONES);
		utilidadesTcs.esperarElementVisibility("xpath", RegistroMayoresPageObjects.LABEL_DAVIPLATA);
		utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BOTON_REGRESAR);
		utilidadesTcs.esperarElementVisibility("xpath", RegistroMayoresPageObjects.TEXTO_BIENVENIDA);
		Utilidades.tomaEvidencia("Validar que me encuentro en el Home de Bienvenida.");
	}
	
	@Step
	public void validarPantallaIngreseSusDatosDesdeElBotonRegistrarme (String numDocumento, String tipoID) {
		Utilidades.esperaMiliseg(800);
		utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BTN_REGISTRARME_HOME_BIENV);
		utilidadesTcs.esperarElementVisibility("xpath", LoginRobustoPage.TEXTO_REGISTRARME_EN_DAVIPLATA);
		Utilidades.esperaMiliseg(800);
		utilidadesTcs.seleccionarTipoDocumentoInputHomeDaviplata("xpath",tipoID);
		utilidadesTcs.writeElement("xpath", LoginRobustoPage.CAMPO_NUMERO_DOCUMENTO_REGISTRO, numDocumento);
		Utilidades.esperaMiliseg(800);
		Utilidades.tomaEvidencia("Se diligencia tipo de documento y usuario");	
		utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BTN_CONTINUAR_REGISTRARME);
		utilidadesTcs.esperarElementVisibility("xpath", RegistroMayoresPageObjects.TXT_AUTORIZACIONES_REGISTRO);
		Utilidades.tomaEvidencia("Valido que me encuentro en la sección de autorizaciones.");
		Utilidades.esperaMiliseg(800);
		utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.CHECKBOX_AUTORIZACIONES);
		Utilidades.tomaEvidencia("Declarar Permisos de registro");
		Utilidades.esperaMiliseg(800);
		utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BOTON_CONTINUAR);
		utilidadesTcs.esperarElementVisibility("xpath", RegistroMayoresPageObjects.TXT_VALIDACION_IDENTIDAD);
		String texto = utilidadesTcs.obtenerTexto("xpath", RegistroMayoresPageObjects.TXT_VALIDACION_IDENTIDAD);
		utilidadesTcs.validateTextContainsString(texto, "Validación de identidad");
		Utilidades.tomaEvidencia("Valido que me encuentro en la sección validación de identidad por biometría.");
		utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BX_CEDULA_TRADICIONAL);
	}
	
	@Step
	public void hacerClicEnElBotonRegistrarme() {
		Utilidades.tomaEvidencia("Hacer clic en el boton Registrarme");
		utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BTN_REGISTRARME_HOME_BIENV);
	}
	
	@Step
	public void hacerClicEnElBotonContinuar() {
		Utilidades.esperaMiliseg(1000);
		utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BOTON_CONTINUAR);
	}
	
	@Step
	public void hacerClicEnElBotonFinalizar() {
		Utilidades.esperaMiliseg(1000);
		utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BOTON_FINALIZAR);
	}
	
	@Step
	public void validarPopUpUsuarioExistente() {
		utilidadesTcs.esperarElementVisibility("xpath", RegistroMayoresPageObjects.TEXTO_POP_UP_USUARIO_CON_CUENTA);
		String texto = utilidadesTcs.obtenerTexto("xpath", RegistroMayoresPageObjects.TEXTO_POP_UP_USUARIO_CON_CUENTA);
		utilidadesTcs.validateTextContainsString(texto, "ya cuenta con un");
		Utilidades.tomaEvidencia("Validar que en el pop-up se presente la 'CC' digitada anteriormente con el mensaje 'La cédula de ciudadanía -XXXXX- ya cuenta con un DaviPlata'");
	}
	
	@Step
	public void validarBotonesCancelarIngresar() {
		boolean estadoVisibleBotonCancelar =  utilidadesTcs.validateElementVisibility("xpath", RegistroMayoresPageObjects.BOTON_CANCELAR_POP_UP_REGISTRO_USUARIO_NUEVO);
		utilidadesTcs.validateStatusElement(estadoVisibleBotonCancelar);
		boolean estadoVisibleBotonIngresar = utilidadesTcs.validateElementVisibility("xpath", RegistroMayoresPageObjects.BOTON_INGRESAR_POP_UP_REGISTRO_USUARIO_NUEVO);
		utilidadesTcs.validateStatusElement(estadoVisibleBotonIngresar);
		Utilidades.tomaEvidencia("Validar que en el pop-up esten presentes los botones 'Cancelar' e 'Ingresar'");
	}
	
	@Step
	public void validarFuncionalidadBtnCancelar() {
		utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BOTON_CANCELAR_POP_UP_REGISTRO_USUARIO_NUEVO);
		Utilidades.esperaMiliseg(1000);
		Utilidades.tomaEvidencia("Validar que al dar tap en el botón 'Cancelar' debe dejar en la pantalla 'Cree su DaviPlata'");
	}
	
	@Step
	public void validarFuncionalidadBtnIngresar() {
		utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BOTON_INGRESAR_POP_UP_REGISTRO_USUARIO_NUEVO);
		utilidadesTcs.esperarElementVisibility("xpath", RegistroMayoresPageObjects.LABEL_INGRESO_DAVIPLATA);
		Utilidades.tomaEvidencia("Validar que al dar tap en el botón 'Ingresar' debe enviar a la pantalla 'Ingrese a su DaviPlata'");
		utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BOTON_REGRESAR);
	}
	
	@Step
	public void validarPresenciaBtn3Puntos() {
		boolean estadoVisibleBoton3Puntos = utilidadesTcs.validateElementVisibility("xpath", RegistroMayoresPageObjects.BTN_TRES_PUNTOS);
		utilidadesTcs.validateStatusElement(estadoVisibleBoton3Puntos);
		Utilidades.tomaEvidencia("Validar que en la pantalla de 'Bienvenida' esten presenten los 3 puntos en la esquina superior derecha");
	}
	
	@Step
	public void validarOpcionesDelBtn3Puntos() {
		Utilidades.esperaMiliseg(1000);
		utilidadesTcs.esperarElementVisibility("xpath", RegistroMayoresPageObjects.MENU_TRES_PUNTOS);
		utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.MENU_TRES_PUNTOS);
		Utilidades.tomaEvidencia("Menu tres puntos");
		Utilidades.esperaMiliseg(1000);
		boolean estadoVisibleOp1Btn3Puntos = utilidadesTcs.validateElementVisibility("xpath", RegistroMayoresPageObjects.OPCION_1_BTN_3_PUNTOS);
		utilidadesTcs.validateStatusElement(estadoVisibleOp1Btn3Puntos);
		Utilidades.esperaMiliseg(1000);
		boolean estadoVisibleOp2Btn3Puntos = utilidadesTcs.validateElementVisibility("xpath", RegistroMayoresPageObjects.OPCION_2_BTN_3_PUNTOS);
		utilidadesTcs.validateStatusElement(estadoVisibleOp2Btn3Puntos);
		Utilidades.tomaEvidencia("Validar que al dar en los 3 puntos se presenten las opciones '¿Dónde usar su daviplata?' y 'Acerca de DaviPlata'");
	}
	
	@Step
	public void hacerClicBotonRegistrarmePopUpRegistro() {
		Utilidades.tomaEvidencia("Hacer Clic Boton Registrarme");
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BOTON_REGISTRARME_POP_UP_REGISTRO_USUARIO_NUEVO);
    }
	
	@Step
	public void realizarRegistroCedulaExtranjeria(String usuario, String nombreUsuario, String numCelular, String correo) {
        utilidadesTcs.esperarElementVisibility("xpath", RegistroMayoresPageObjects.BOTON_TOMAR_FOTO_CEDULA);
        Utilidades.tomaEvidencia("Hacer clic tomar foto de cedula");
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BOTON_TOMAR_FOTO_CEDULA);
		Utilidades.esperaMiliseg(5000);
		//boolean visibilidad = utilidadesTcs.validateElementVisibilityCatch("xpath", AcercaDePageObjects.BOTON_PERMITIR_SOLO_USO_CON_APP);
		//if(visibilidad) {
		//  utilidadesTcs.clicElement("xpath", AcercaDePageObjects.BOTON_PERMITIR_SOLO_USO_CON_APP);    
		//}
        utilidadesTcs.esperarElementVisibility("xpath", RegistroMayoresPageObjects.TEXTO_FORMULARIO_MIS_DATOS);
        utilidadesTcs.writeElement("xpath", RegistroMayoresPageObjects.CAMPO_NOMBRE_USUARIO_REGISTRO_CE, nombreUsuario);
        Utilidades.esperaMiliseg(1000);
        utilidadesTcs.writeElement("xpath", RegistroMayoresPageObjects.CAMPO_DOCUMENTO_USUARIO_REGISTRO_CE, usuario);
        Utilidades.esperaMiliseg(1000);
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.DESPLEGABLE_FECHA_NACIMIENTO_USUARIO_REGISTRO_CE);
        for(int i = 0; i<3; i++) {
            String anio = "1920";
            utilidadesTcs.writeElement("xpath", RegistroMayoresPageObjects.OPCION_ANIO_FECHA_NACIMIENTO_USUARIO_REGISTRO_CE, anio);
        }
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BOTON_HECHO_FECHA_NACIMIENTO_USUARIO_REGISTRO_CE);
        
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.DESPLEGABLE_FECHA_EXPEDICION_USUARIO_REGISTRO_CE);
        for(int i = 0; i<3; i++) {
            String anio = "1930";
            utilidadesTcs.writeElement("xpath", RegistroMayoresPageObjects.OPCION_ANIO_FECHA_NACIMIENTO_USUARIO_REGISTRO_CE, anio);
        }
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BOTON_HECHO_FECHA_NACIMIENTO_USUARIO_REGISTRO_CE);
        utilidadesTcs.writeElement("xpath", RegistroMayoresPageObjects.CAMPO_CIUDAD_EXPEDICION_USUARIO_REGISTRO_CE, "BOGOTÁ, D.C.");
        Utilidades.esperaMiliseg(1000);
        utilidadesTcs.writeElement("xpath", RegistroMayoresPageObjects.CAMPO_NUMERO_CELULAR_USUARIO_REGISTRO_CE, numCelular);
        Utilidades.esperaMiliseg(500);
        utilidadesTcs.writeElement("xpath", RegistroMayoresPageObjects.CAMPO_CONFIRMAR_NUMERO_CELULAR_USUARIO_REGISTRO_CE, numCelular);
        Utilidades.esperaMiliseg(500);
        utilidadesTcs.writeElement("xpath", RegistroMayoresPageObjects.CAMPO_CORREO_USUARIO_REGISTRO_CE, correo);
        Utilidades.esperaMiliseg(500);
        utilidadesTcs.writeElement("xpath", RegistroMayoresPageObjects.CAMPO_CONFIRMAR_CORREO_USUARIO_REGISTRO_CE, correo);
        Utilidades.esperaMiliseg(1000);
        Utilidades.tomaEvidencia("Llenar formulario de registro en cedula de extranjeria");
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BOTON_CONTINUAR_POPUP_CAMBIO_DISPOSITIVO);
        Utilidades.esperaMiliseg(500);
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BOTON_CONTINUAR_POPUP_CAMBIO_DISPOSITIVO);
    }
	
	@Step
	public void ingresoOtp() {
        Utilidades.esperaMiliseg(2000);
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.POPUP_REGLAMENTO_CAMBIO_DISPOSITIVO);
        Utilidades.esperaMiliseg(500);
        utilidadesTcs.writeElement("xpath", RegistroMayoresPageObjects.INPUT_OTP_REGISTRO, "230116");
        Utilidades.tomaEvidencia("Ingresar numero de otp");
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BOTON_CONTINUAR_POPUP_CAMBIO_DISPOSITIVO);
        Utilidades.esperaMiliseg(500);
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BOTON_CONTINUAR_POPUP_CAMBIO_DISPOSITIVO);
    }
	
	@Step
	public void aceptarTerminosCondicionesRegistroCedulaExtranjeria() {
        Utilidades.esperaMiliseg(2000);
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.POPUP_REGLAMENTO_CAMBIO_DISPOSITIVO2);
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BOTON_TERMINO);
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BOTON_REGLAS);
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BOTON_AUTO);
        Utilidades.tomaEvidencia("Aceptar terminos y condiciones de registro");
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BOTON_CONTINUAR_POPUP_CAMBIO_DISPOSITIVO);
    }
	
	@Step
	public void crearClaveRegistroRegistroCedulaExtranjeria(String claveNueva) {
        Utilidades.esperaMiliseg(2000);
        utilidadesTcs.writeElement("xpath", RegistroMayoresPageObjects.CAMPO_CLAVE_REGISTRO, claveNueva);
        utilidadesTcs.writeElement("xpath", RegistroMayoresPageObjects.CAMPO_CONFIRMACION_CLAVE_REGISTRO, claveNueva);
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.ACEPTAR_BTN);
        Utilidades.tomaEvidencia("Ingresar claves creadas");
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BOTON_CONTINUAR_CREACION_CLAVE);
		utilidadesTcs.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
    }
	
	@Step
	public void validarRegistroExitosoNoExitoso() {
        boolean estadoRegistro = utilidadesTcs.validateElementVisibilityCatch("xpath", RegistroMayoresPageObjects.TEXTO_VIDEO_INFORMATIVO);
        if(estadoRegistro) {
            Utilidades.tomaEvidencia("Validar video informativo");
            utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BOTON_CONTINUAR_POPUP_CAMBIO_DISPOSITIVO);
        }
        
        boolean condicionesUso = utilidadesTcs.validateElementVisibilityCatch("xpath", RegistroMayoresPageObjects.TEXTO_ACTUALIZAMOS_CONDICIONES);
        if(condicionesUso) {
            Utilidades.esperaMiliseg(500);
            utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.CHECK_BOX_ACTUALIZACION_1);
            utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.CHECK_BOX_ACTUALIZACION_2);
            Utilidades.esperaMiliseg(500);
            Utilidades.tomaEvidencia("Validar actualizacion de las condiciones de uso de los datos");
            utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.ACEPTAR_ACTUALZIACION_CONDICIONES);
        }
        Utilidades.esperaMiliseg(2000);
        utilidadesTcs.esperarElementVisibility("xpath", RegistroMayoresPageObjects.TEXTO_CUANTO_TENGO_DETALLE_SALDO);
        boolean visibilidad = utilidadesTcs.validateElementVisibility("xpath", RegistroMayoresPageObjects.TEXTO_CUANTO_TENGO_DETALLE_SALDO);
        utilidadesTcs.validateStatusElement(visibilidad);
        Utilidades.tomaEvidencia("Validacion de registro exitoso");
    }
	
	@Step
	public void aceptarAutorizaciones() {
		utilidadesTcs.esperarElementVisibility("xpath", RegistroMayoresPageObjects.TXT_AUTORIZACIONES_REGISTRO);
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BOTON_DECLARO_PERMISOS_REGISTRO_USUARIO_NUEVO);
        Utilidades.tomaEvidencia("Declarar Permisos de registro");
        Utilidades.esperaMiliseg(1000);
		utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BOTON_CONTINUAR);
        Utilidades.tomaEvidencia("Hacer clic en el formato de cedula");
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BOTON_CEDULA_VALIDACION);
		//boolean estadoVisible = utilidadesTcs.validateElementVisibilityCatch("xpath", RegistroMayoresPageObjects.BOTON_PERMITIR_NATIVO_CELULAR);
		//if(estadoVisible) {
		//  utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BOTON_PERMITIR_NATIVO_CELULAR);
		//}
        utilidadesTcs.esperarElementVisibility("xpath", RegistroMayoresPageObjects.TEXTO_INGRESE_SUS_DATOS);    
    }
	
	@Step
	public void procesoValidacionFormulario(String nombreUsuario, String numCelular, String correo) {
        utilidadesTcs.writeElement("xpath", RegistroMayoresPageObjects.NOMBRES_APELLIDOS_FIELD, nombreUsuario);
        Utilidades.esperaMiliseg(1000);
        
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.DESPLEGABLE_FECHA_DIA);
        Utilidades.tomaEvidencia("Valido que el campo 'Día' sea de tipo desplegable y se valida el valor inicial");
        String diaFecha = "31";
        utilidadesTcs.scrollToElements("xpath", RegistroMayoresPageObjects.DISPLAY, "//XCUIElementTypeStaticText[@value='"+diaFecha.trim()+"']", 10, 0, -200);
        String diaFechaCaptura = utilidadesTcs.obtenerTexto("xpath", RegistroMayoresPageObjects.DESPLEGABLE_FECHA_DIA_VALUE);
        utilidadesTcs.validateTextContainsString(diaFechaCaptura, "31");
        Utilidades.tomaEvidencia("Valido que la lista muestre hasta la opción '31'");
        Utilidades.esperaMiliseg(1000);
        
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.DESPLEGABLE_FECHA_MES);
        Utilidades.tomaEvidencia("Validar que el campo 'Mes' sea de tipo desplegable y se valida el valor inicial");
        String mesFecha = "Diciembre";
        utilidadesTcs.scrollToElements("xpath", RegistroMayoresPageObjects.DISPLAY, "//XCUIElementTypeStaticText[@name='"+mesFecha.trim()+"']",  10, 0, -200 );
        String mesFechaCaptura = utilidadesTcs.obtenerTexto("xpath", RegistroMayoresPageObjects.DESPLEGABLE_FECHA_MES_VALUE);
        utilidadesTcs.validateTextContainsString(mesFechaCaptura, "Dic");
        Utilidades.tomaEvidencia("Valido que la lista muestre hasta la opción 'Diciembre'");
        Utilidades.esperaMiliseg(1000);
        
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.DESPLEGABLE_FECHA_ANIO);
        Utilidades.tomaEvidencia("Validar que el campo 'Año' sea tipo desplegable y se valida el valor inicial");
        String anioFecha = "1920";
        utilidadesTcs.scrollToElements("xpath", RegistroMayoresPageObjects.DISPLAY, "//XCUIElementTypeStaticText[@name='"+anioFecha.trim()+"']",  15, 0, -550 );
        String anioFechaCaptura = utilidadesTcs.obtenerTexto("xpath", RegistroMayoresPageObjects.DESPLEGABLE_FECHA_ANIO_VALUE);
        utilidadesTcs.validateTextContainsString(anioFechaCaptura, "1920");
        Utilidades.tomaEvidencia("Valido que la lista muestre hasta la opción '1920'");
        
        utilidadesTcs.scrollBackground("xpath", RegistroMayoresPageObjects.TEXTO_FECHA_EXPEDICION, 0, -200);
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.DESPLEGABLE_DIA_FECHA_EXPEDICION);
        //utilidadesTcs.esperarElementVisibility("xpath", RegistroMayoresPageObjects.POP_UP_FECHA_EXPEDICION);
		boolean estadoVisible = utilidadesTcs.validateElementVisibilityCatch("xpath", RegistroMayoresPageObjects.POP_UP_FECHA_EXPEDICION);
		if(estadoVisible == true) {
	        utilidadesTcs.validateStatusElement(estadoVisible);
	        Utilidades.tomaEvidencia("Validar que al dar por primera vez tap en el campo Día, Mes o Año de la fecha de expedicion se presente Pop-up");
			utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BOTON_ACEPTAR);
		}
        String diaFechaExp = "20";
        String mesFechaExp = "Agosto";
        String anioFechaExp = "1930";
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.DESPLEGABLE_DIA_FECHA_EXPEDICION);
        Utilidades.esperaMiliseg(1000);
        utilidadesTcs.scrollToElements("xpath", RegistroMayoresPageObjects.DISPLAY, "//XCUIElementTypeStaticText[@value='"+diaFechaExp.trim()+"']", 10, 0, -200);
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.DESPLEGABLE_MES_FECHA_EXPEDICION);
        utilidadesTcs.scrollToElements("xpath", RegistroMayoresPageObjects.DISPLAY, "//XCUIElementTypeStaticText[@name='"+mesFechaExp.trim()+"']",  10, 0, -200 );
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.DESPLEGABLE_ANIO_FECHA_EXPEDICION);
        utilidadesTcs.scrollToElements("xpath", RegistroMayoresPageObjects.DISPLAY, "//XCUIElementTypeStaticText[@name='"+anioFechaExp.trim()+"']",  35, 0, -350 );
        Utilidades.esperaMiliseg(1000);
        utilidadesTcs.writeElement("xpath", RegistroMayoresPageObjects.CAMPO_LUGAR_EXPEDICION, "BOGOTÁ");
		Utilidades.esperaMiliseg(800);
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.SELECCION_LUGAR_EXPEDICION);
        Utilidades.tomaEvidencia("Validar el campo Ciudad de expedición pemita solo ingreso de caracteres Alfabeticos");
        utilidadesTcs.writeElement("xpath", RegistroMayoresPageObjects.CAMPO_NUMERO_CELULAR, numCelular);
		Utilidades.esperaMiliseg(800);
        String numeroCelular = utilidadesTcs.obtenerTexto("xpath", RegistroMayoresPageObjects.VALOR_CAMPO_NUMERO_CEL);
        utilidadesTcs.validarLongitudNumerica(numeroCelular, 10);
        utilidadesTcs.validarCaracteresNumericos(numeroCelular);
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BTN_CONTINUAR_TECLADO);
        Utilidades.tomaEvidencia("Validar que el campo Número de celular solo permita el ingreso de caracteres numericos, debe iniciar simepre en 3 y tener una longitud de 10 digitos.");
        utilidadesTcs.writeElement("xpath", RegistroMayoresPageObjects.CAMPO_CORREO, correo);
        String correoElectronico = utilidadesTcs.obtenerTexto("xpath", RegistroMayoresPageObjects.VALOR_CAMPO_CORREO);
        utilidadesTcs.validateContainsAlphanumericCharacters(correoElectronico);
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.TEXTO_FECHA_EXPEDICION);
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.TEXTO_FECHA_EXPEDICION);
        Utilidades.tomaEvidencia("Validar que el campo Correo electronico debe permitir ingreso de caracteres alfanuméricos");
        Utilidades.tomaEvidencia("Validar que el campor Correo electronico permita una longitud menor a 50 caracteres, debe tener una extensión de dominio valida donde contenga '@' y luego '.'");
        utilidadesTcs.writeElement("xpath", RegistroMayoresPageObjects.CAMPO_CONFIRMACION_CORREO, correo);
        String confirmacionCorreoElectronico = utilidadesTcs.obtenerTexto("xpath", RegistroMayoresPageObjects.VALOR_CAMPO_CONFIRMACION_CORREO);
        utilidadesTcs.validateContainsAlphanumericCharacters(confirmacionCorreoElectronico);
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.TEXTO_FECHA_EXPEDICION);
        Utilidades.tomaEvidencia("Validar que el campo Confirme su Correo electronico debe permitir ingreso de caracteres alfanuméricos");
        Utilidades.tomaEvidencia("Validar que el campor Confirme Correo electronico permita una longitud menor a 50 caracteres, debe tener una extensión de dominio valida donde contenga '@' y luego '.'");
	}
	
	@Step
	public void hacerClicEnElBotonAtras() {
        utilidadesTcs.esperarElementVisibility("xpath", RegistroMayoresPageObjects.BOTON_REGRESAR);
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BOTON_REGRESAR);   
        Utilidades.tomaEvidencia("Hacer clic en el boton atras");
    }
	
	@Step
	public void diligenciarFormularioCompleto(String nombreUsuario,String diaFechaNacimiento,String mesFechaNacimiento,String anioFechaNacimiento, String diaFechaExpedicion,String mesFechaExpedicion,String anioFechaExpedicion,String numCelular,String correo) {
        Utilidades.tomaEvidencia("Hacer clic en el formato de cedula");
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BOTON_CEDULA_VALIDACION);
        utilidadesTcs.esperarElementVisibility("xpath", RegistroMayoresPageObjects.TEXTO_INGRESE_SUS_DATOS);
        utilidadesTcs.writeElement("xpath", RegistroMayoresPageObjects.NOMBRES_APELLIDOS_FIELD, nombreUsuario);
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.DESPLEGABLE_FECHA_DIA);
        Utilidades.tomaEvidencia("Valido que el campo 'Día' sea de tipo desplegable y se valida el valor inicial");
        utilidadesTcs.scrollToElements("xpath", RegistroMayoresPageObjects.DISPLAY, "//XCUIElementTypeStaticText[@value='"+diaFechaNacimiento.trim()+"']", 15, 0, -200);
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.DESPLEGABLE_FECHA_MES);
        utilidadesTcs.scrollToElements("xpath", RegistroMayoresPageObjects.DISPLAY, "//XCUIElementTypeStaticText[@name='"+mesFechaNacimiento.trim()+"']",  15, 0, -200);
        Utilidades.esperaMiliseg(3000);
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.DESPLEGABLE_FECHA_ANIO);
        utilidadesTcs.scrollToElements("xpath", RegistroMayoresPageObjects.DISPLAY, "//XCUIElementTypeStaticText[@name='"+anioFechaNacimiento.trim()+"']",  15, 0, -250);
        
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.DESPLEGABLE_DIA_FECHA_EXPEDICION);
		boolean estadoVisible = utilidadesTcs.validateElementVisibilityCatch("xpath", RegistroMayoresPageObjects.POP_UP_FECHA_EXPEDICION);
		if(estadoVisible == true) {
	        utilidadesTcs.validateStatusElement(estadoVisible);
	        Utilidades.tomaEvidencia("Validar que al dar por primera vez tap en el campo Día, Mes o Año de la fecha de expedicion se presente Pop-up");
			utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BOTON_ACEPTAR);
		}
	    utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.DESPLEGABLE_DIA_FECHA_EXPEDICION);
	    Utilidades.esperaMiliseg(1000);
        utilidadesTcs.scrollToElements("xpath", RegistroMayoresPageObjects.DISPLAY, "//XCUIElementTypeStaticText[@value='"+diaFechaExpedicion.trim()+"']", 10, 0, -200);
	    utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.DESPLEGABLE_MES_FECHA_EXPEDICION);
	    utilidadesTcs.scrollToElements("xpath", RegistroMayoresPageObjects.DISPLAY, "//XCUIElementTypeStaticText[@name='"+mesFechaExpedicion.trim()+"']",  10, 0, -200 );
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.DESPLEGABLE_ANIO_FECHA_EXPEDICION);
        utilidadesTcs.scrollToElements("xpath", RegistroMayoresPageObjects.DISPLAY, "//XCUIElementTypeStaticText[@name='"+anioFechaExpedicion.trim()+"']",  35, 0, -250 );
        Utilidades.esperaMiliseg(1000);
	    utilidadesTcs.writeElement("xpath", RegistroMayoresPageObjects.CAMPO_LUGAR_EXPEDICION, "BOGOTÁ");
	    Utilidades.esperaMiliseg(800);
	    utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.SELECCION_LUGAR_EXPEDICION);
	    Utilidades.tomaEvidencia("Validar el campo Ciudad de expedición pemita solo ingreso de caracteres Alfabeticos");
	    utilidadesTcs.writeElement("xpath", RegistroMayoresPageObjects.CAMPO_NUMERO_CELULAR, numCelular);
	    Utilidades.esperaMiliseg(800);
        utilidadesTcs.scrollBackground("xpath", RegistroMayoresPageObjects.TEXTO_FECHA_EXPEDICION, 0, -200);
        utilidadesTcs.writeElement("xpath", RegistroMayoresPageObjects.CAMPO_NUMERO_CELULAR, numCelular);
        utilidadesTcs.writeElement("xpath", RegistroMayoresPageObjects.CAMPO_CORREO, correo);
        utilidadesTcs.writeElement("xpath", RegistroMayoresPageObjects.CAMPO_CONFIRMACION_CORREO, correo);
		/** CLIC AL ELEMENTO PARA OCULTAR EL TECLADO **/
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.TEXTO_FECHA_EXPEDICION);
        Utilidades.tomaEvidencia("Diligenciar formulario de registro");
    }
	
	@Step
	public void validarConfirmacionCorreoErroneo(String confirmacionCorreoErroneo, String correo) {
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.VALOR_CAMPO_CONFIRMACION_CORREO);
        utilidadesTcs.cleanInputElement("xpath", RegistroMayoresPageObjects.VALOR_CAMPO_CONFIRMACION_CORREO);
	    Utilidades.esperaMiliseg(800);
        utilidadesTcs.writeElement("xpath", RegistroMayoresPageObjects.VALOR_CAMPO_CONFIRMACION_CORREO, confirmacionCorreoErroneo);
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.TEXTO_FECHA_EXPEDICION);
	    Utilidades.esperaMiliseg(800);
        String mensajeError = utilidadesTcs.obtenerTexto("xpath", RegistroMayoresPageObjects.MENSAJE_CORREO_ERRONEO);
        utilidadesTcs.validateTextContainsString(mensajeError, "El correo no coincide con el ingresado arriba");
	    Utilidades.esperaMiliseg(800);
        Utilidades.tomaEvidencia("Validar en caso de que el correo y la confirmación de correo no coincidan debe arrojar el error");
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.VALOR_CAMPO_CONFIRMACION_CORREO);
        utilidadesTcs.cleanInputElement("xpath", RegistroMayoresPageObjects.VALOR_CAMPO_CONFIRMACION_CORREO);
        utilidadesTcs.writeElement("xpath", RegistroMayoresPageObjects.VALOR_CAMPO_CONFIRMACION_CORREO, correo);
    }
	
	@Step
	public void hacerClicBotonContinuarFormularioRegistro() {
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BOTON_CONTINUAR_POPUP_CAMBIO_DISPOSITIVO);
    }
	
	@Step
	public void validarPantallaOtpRegistro() {
		
        utilidadesTcs.esperarElementVisibility("xpath", RegistroMayoresPageObjects.TEXTO_CODIGO_VERIFICACION);
        boolean elementoVisible = utilidadesTcs.validateElementVisibility("xpath", RegistroMayoresPageObjects.TEXTO_CODIGO_VERIFICACION);
        utilidadesTcs.validateStatusElement(elementoVisible);
        Utilidades.tomaEvidencia("Validar que al completar el formuario y dar tap en el botón 'Continuar' envie a la pantalla 'OTP'");
    }
	
	@Step
	public void validarSePuedanLlenarDatosDelFomularioAlDarClicEnBotonAtras() {
		Utilidades.esperaMiliseg(1500);
        //utilidadesTcs.scrollBackground("xpath", RegistroMayoresPageObjects.TEXTO_FECHA_EXPEDICION, 0, 300);
		Utilidades.tomaEvidencia("Validar que cuando el usuario de tap en el boton atrás sea dirigido nuevamente a la pantalla de datos iniciales");           
    }
	
	@Step
	public void ingresarOtpFinalRegistro() {
		String otp = "230116";
		utilidadesTcs.escribirPorTecladoIos(otp);
		Utilidades.tomaEvidencia("Ingresar Otp de cambio de dispositivo");
		/** CLIC AL ELEMENTO PARA OCULTAR EL TECLADO **/
		utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.TEXTO_CODIGO_VERIFICACION); 
		Utilidades.esperaMiliseg(500);
		utilidadesTcs.clickCoordinates(410, 410);
		Utilidades.esperaMiliseg(500);
		utilidadesTcs.clicElement("xpath", LoginRobustoPage.CONTINUAR_POP_UP_CAMBIAR_DISPOSITIVO);
	}
	
	@Step
	public void crearClave(String passwd) {
		loginpageobjects.ingresarContrasena(passwd);
	}
	
	@Step
	public void validarMensajeBienvenida() {
        utilidadesTcs.esperarElementVisibility("xpath", RegistroMayoresPageObjects.TEXTO_CREACION);
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Valido mensaje de bienvenida");
		utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.USAR_MI_DAVIPLATA);
		boolean estadoVisible = utilidadesTcs.validateElementVisibilityCatch("xpath", LoginRobustoPage.POP_UP_INVITE_AMIGOS);
		if(estadoVisible == true) {
			Utilidades.tomaEvidencia("Cerrar pop up de amigos");
			utilidadesTcs.clicElement("xpath", LoginRobustoPage.BOTON_CLOSE);
		}
        boolean estadoRegistro = utilidadesTcs.validateElementVisibilityCatch("xpath", RegistroMayoresPageObjects.TEXTO_VIDEO_INFORMATIVO);
        if(estadoRegistro) {
            Utilidades.tomaEvidencia("Validar video informativo");
            utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BOTON_CONTINUAR_POPUP_CAMBIO_DISPOSITIVO);
        }
		boolean estadoVisible2 = utilidadesTcs.validateElementVisibilityCatch("xpath", LoginRobustoPage.POP_UP_INVITE_AMIGOS);
		if(estadoVisible2 == true) {
			Utilidades.tomaEvidencia("Cerrar pop up de amigos");
			utilidadesTcs.clicElement("xpath", LoginRobustoPage.BOTON_CLOSE);
		}
	}
	
	@Step
	public void hacerClicEnElBotonLapiz() {
        utilidadesTcs.esperarElementVisibility("xpath", RegistroMayoresPageObjects.BOTON_LAPIZ);
        Utilidades.tomaEvidencia("Hacer clic en el boton lapiz");
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BOTON_LAPIZ);    
	}
	
	@Step
	public void validarPopUpFuncionalidadNegocioNoDisponible() {
		Utilidades.esperaMiliseg(10000);
		utilidadesTcs.clicElement("xpath", negocioPageObjects.BOTON_IR_NEGOCIO);
		Utilidades.esperaMiliseg(1500);
        utilidadesTcs.esperarElementVisibility("xpath",RegistroMayoresPageObjects.LO_SENTIMOS_FUNCIONALIDAD_NEGOCIO);
        boolean popUpFuncionalidad = utilidadesTcs.validateElementVisibility("xpath",RegistroMayoresPageObjects.LO_SENTIMOS_FUNCIONALIDAD_NEGOCIO);
        utilidadesTcs.validateStatusElement(popUpFuncionalidad);
        Utilidades.tomaEvidencia("Validar que Si es un tipo documental diferente a CC se debe mostrar el pop up Esta funcionalidad aún no está disponible");
    }
	
	@Step
	public void ingresarABeneficiosMiNegocioDesdeRegistro() {
		Utilidades.esperaMiliseg(10000);
		utilidadesTcs.clicElement("xpath", negocioPageObjects.BOTON_IR_NEGOCIO);
		Utilidades.esperaMiliseg(1500);
    }
	
	@Step
	public void validarPantallaMisBeneficios() {
        utilidadesTcs.esperarElementVisibility("xpath", RegistroMayoresPageObjects.TEXTO_BENEFICIOS_MI_NEGOCIO);
        boolean elemento = utilidadesTcs.validateElementVisibility("xpath", RegistroMayoresPageObjects.TEXTO_BENEFICIOS_MI_NEGOCIO);
        utilidadesTcs.validateStatusElement(elemento);
        Utilidades.tomaEvidencia("Validar que Cuando el cliente de Tap en el botón 'Conocer beneficios' deberá ser llevado a pantalla 'Beneficios Mi Negocio' con el look and feel y beneficios asociados a Mi Negocio");
    }
	
	@Step
	public void hacerScrollHastaElFinalDeLaPantalla() {
		Utilidades.scrollHastaElemento("Usar Mi DaviPlata");
    }

	@Step
	public void hacerClicAlBotonUsarMiDaviplata() {
		utilidadesTcs.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
        Utilidades.tomaEvidencia("Hacer clic en el boton usar mi daviplata");
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BOTON_USAR_MI_DAVIPLATA);
		
		boolean estadoVisiblePopUpAmigos = utilidadesTcs.validateElementVisibilityCatch("xpath", LoginRobustoPage.POP_UP_INVITE_AMIGOS);
		if(estadoVisiblePopUpAmigos == true) {
			
			Utilidades.esperaMiliseg(1500);
			utilidadesTcs.clicElement("xpath", LoginRobustoPage.BOTON_CLOSE);
		}	
        utilidadesTcs.esperarElementVisibility("xpath", RegistroMayoresPageObjects.TEXTO_CUANTO_TENGO_DETALLE_SALDO);
        boolean elemento = utilidadesTcs.validateElementVisibility("xpath", RegistroMayoresPageObjects.TEXTO_CUANTO_TENGO_DETALLE_SALDO);
        utilidadesTcs.validateStatusElement(elemento);
        Utilidades.tomaEvidencia("Validar que si el cliente tiene desmarcado el check y selecciona el botón 'Usar mi DaviPlata' debe ser direccionado al home");
    }

	@Step
	public void ingresarAPerfilNegocio() {
		Utilidades.esperaMiliseg(10000);
        utilidadesTcs.esperarElementVisibility("xpath", negocioPageObjects.BOTON_IR_NEGOCIO);
        Utilidades.tomaEvidencia("Hacer clic en el boton mi negocio");
        utilidadesTcs.clicElement("xpath", negocioPageObjects.BOTON_IR_NEGOCIO);
    }
	
	@Step
	public void marcarCheckTerminosYCondiciones() {
		Utilidades.esperaMiliseg(1500);
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.CHECK_TYC);
        Utilidades.tomaEvidencia("Marcar terminos y condiciones");
    }

	@Step
	public void validoIngresoAFormularioMiNegocio() {
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BOTON_CREAR_MI_NEGOCIO);
        Utilidades.esperaMiliseg(2000);
        utilidadesTcs.esperarElementVisibility("xpath", RegistroMayoresPageObjects.TEXTO_FORMULARIO_NEGOCIO);
        boolean elemento = utilidadesTcs.validateElementVisibility("xpath", RegistroMayoresPageObjects.TEXTO_FORMULARIO_NEGOCIO);
        utilidadesTcs.validateStatusElement(elemento);
    }

	@Step
	public void llenarFormularioRegistroNegocio(String nombre, String queVende, String monto, String ciudadNegocio, String tipoInmueble, String correo) {
		utilidadesTcs.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
		Utilidades.esperaMiliseg(2000);
		utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.CAMPO_NOMBRE_NEGOCIO);
        utilidadesTcs.writeElement("xpath", RegistroMayoresPageObjects.CAMPO_NOMBRE_NEGOCIO, nombre);
        Utilidades.tomaEvidencia("Validar que Nombre de su negocio (Alfabético - cantidad de caracteres como se encuentra hoy en producción)");
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.CAMPO_QUE_VENDE);
        utilidadesTcs.writeElement("xpath", RegistroMayoresPageObjects.CAMPO_QUE_VENDE, queVende);
        Utilidades.tomaEvidencia("Validar que Qué vende o a qué se dedica Lista predictiva");
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.SELECCION_OPCION_QUE_VENDE);
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.CAMPO_MONTO);
        utilidadesTcs.writeElement("xpath", RegistroMayoresPageObjects.CAMPO_MONTO, monto);
        Utilidades.tomaEvidencia("Validar que Cuál es el monto de sus ventas o ingresos Manual (numérico cantidad de caracteres como se encuentra hoy en producción)");
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.CAMPO_CIUDAD_NEGOCIO);
        utilidadesTcs.writeElement("xpath", RegistroMayoresPageObjects.CAMPO_CIUDAD_NEGOCIO, ciudadNegocio);
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.SELECCION_OPCION_CIUDAD);
        Utilidades.esperaMiliseg(800);
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.LISTA_TIPO_CALLE);
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.OPCION_CALLE);
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.CAMPO_NUMERO_DIRECCION_UNO);
        utilidadesTcs.writeElement("xpath", RegistroMayoresPageObjects.CAMPO_NUMERO_DIRECCION_UNO, "9");
        Utilidades.esperaMiliseg(1000);
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.CAMPO_NUMERO_DIRECCION_DOS);
        utilidadesTcs.writeElement("xpath", RegistroMayoresPageObjects.CAMPO_NUMERO_DIRECCION_DOS, "5");
        Utilidades.esperaMiliseg(1000);
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.CAMPO_NUMERO_DIRECCION_TRES);
        utilidadesTcs.writeElement("xpath", RegistroMayoresPageObjects.CAMPO_NUMERO_DIRECCION_TRES, "8");
        Utilidades.esperaMiliseg(1000);
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.CAMPO_TIPO_CASA);
        utilidadesTcs.writeElement("xpath", RegistroMayoresPageObjects.CAMPO_TIPO_CASA, tipoInmueble);
        Utilidades.tomaEvidencia("'Torre' 'Local' 'Casa' 'otro' (opcional) Manual - (Alfanumérico - cantidad de caracteres como se encuentra hoy en producción)");
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.CAMPO_CORREO);
        utilidadesTcs.cleanInputElement("xpath", RegistroMayoresPageObjects.CAMPO_CORREO);
        utilidadesTcs.writeElement("xpath", RegistroMayoresPageObjects.CAMPO_CORREO, correo);
        String textoCorreo = utilidadesTcs.obtenerTexto("xpath", RegistroMayoresPageObjects.CAMPO_CORREO);
        boolean validacionCorreo = utilidadesTcs.validateContainsAlphanumericCharacters(textoCorreo);
        utilidadesTcs.validateStatusElement(validacionCorreo);
        Utilidades.tomaEvidencia("Validar que (el correo debe tener una extensión de dominio válida donde contenga un @ y luego de este un punto (.) como está hoy en producción)");
    }
	
	@Step
	public void finalizarCreacionNegocio() {
		Utilidades.esperaMiliseg(1500);
        Utilidades.tomaEvidencia("Valido datos ingresados");
        utilidadesTcs.clicElement("xpath", RegistroMayoresPageObjects.BTN_ACTIVAR_MI_NEGOCIO);
		utilidadesTcs.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
    }
}


