package daviplata.nacional.iOS.steps;

import daviplata.nacional.iOS.pageObjects.AdsPageObjects;
import daviplata.nacional.iOS.pageObjects.LoginPageObjects;
import daviplata.nacional.iOS.pageObjects.LoginRobustoPage;
import daviplata.nacional.iOS.pageObjects.MeterPlataPageObjects;
import daviplata.nacional.iOS.pageObjects.WebLatiniaPageObject;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import daviplata.nacional.iOS.utilidades.Utilidades;
import daviplata.nacional.iOS.utilidades.UtilidadesTCS;
import net.thucydides.core.annotations.Step;

public class AdsSteps {

	Utilidades utilidad;
	BaseUtil base;
	UtilidadesTCS utilidadesTCS;
    WebLatiniaPageObject pageLatinia;
	AdsPageObjects adsPageObjects;
	LoginPageObjects loginPageObject;
	MeterPlataPageObjects meterPlataPageObjects;
	
	@Step
	public void ingresoAlPopUpDeAdelantoDeSueldo() {
        boolean popUpAds = utilidadesTCS.validateElementVisibilityCatch("xpath",AdsPageObjects.TEXTO_POPUP_ADS);
        utilidadesTCS.validateStatusElement(popUpAds);
        Utilidades.tomaEvidencia("Valido pop Up de adelanto de sueldo");
        utilidadesTCS.clicElement("xpath", AdsPageObjects.BOTON_SABER_MAS);
        boolean elemento = utilidadesTCS.validateElementVisibilityCatch("xpath",AdsPageObjects.BOTON_LO_VERE_LUEGO_POPUP_BENEFICIOS_TARJETA_DIGITAL);
        if(elemento) {
        	utilidadesTCS.clicElement("xpath",AdsPageObjects.BOTON_LO_VERE_LUEGO_POPUP_BENEFICIOS_TARJETA_DIGITAL);
        }
    }
    
	@Step
    public void marcarTyCPantallaBeneficios() {
		utilidadesTCS.esperarElementVisibility("xpath",AdsPageObjects.TXT_BENEFICIOS_CARACTERISTICAS); 
    	utilidadesTCS.clicElement("xpath", AdsPageObjects.BOTON_TYC_BENEFICIOS);
        Utilidades.tomaEvidencia("Marcar terminos y condiciones de beneficios");
    }
    
	@Step
    public void clicBotonContinuarDeBeneficios() {
        Utilidades.tomaEvidencia("Clic boton continuar");
        utilidadesTCS.clicElement("xpath", LoginRobustoPage.CONTINUAR_POP_UP_CAMBIAR_DISPOSITIVO);
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 120);
    }
	
	@Step
	public void validarPopUpSolicitudIniciadaYCancelar() {
        boolean elemento = utilidadesTCS.validateElementVisibilityCatch("xpath", AdsPageObjects.POPUP_YA_HA_INICIADO_SOLICITUD);
        if(elemento == true) {
            Utilidades.tomaEvidencia("Valido presencia de un proceso de solicitud iniciada");
        	utilidadesTCS.clicElement("xpath", AdsPageObjects.BTN_CANCELAR);
        }
	}
    
	@Step
    public void validarPantallaDeAutorizaciones() {
        Utilidades.esperaMiliseg(1000);
		utilidadesTCS.esperarElementVisibility("xpath", AdsPageObjects.TXT_AUTORIZACIONES);
        Utilidades.tomaEvidencia("Validar que para un cliente No común le muestre el sistema la pantalla de Autorizaciones");
    }
	
	@Step
	public void validaraPantallResultado() {
		utilidadesTCS.esperarElementVisibility("xpath", AdsPageObjects.TXT_RESULTADO);
        Utilidades.tomaEvidencia("Validamos pantalla de resultados");
        utilidadesTCS.clicElement("xpath", LoginRobustoPage.CONTINUAR_POP_UP_CAMBIAR_DISPOSITIVO);
        Utilidades.esperaMiliseg(2000);
	}
    
	@Step
    public void ingresarAPantallaTratamientoDatosSensibles() {
        Utilidades.esperaMiliseg(1000);
        utilidadesTCS.clicElement("xpath", AdsPageObjects.TXT_AUTORIZADOR_CONTRATO);
        Utilidades.esperaMiliseg(2000);
        Utilidades.tomaEvidencia("Validar que para un cliente No común le muestre el sistema la pantalla de Autorizaciones hacer tap en T y C y el sistema muestre documento tratamiento de datos sensibles");
    }
    
	@Step
    public void validarCheckAutorizacionesDesmarcadoAlDarClicBotonAtras() {
        utilidadesTCS.clicElement("xpath", AdsPageObjects.BTN_ATRAS);
        Utilidades.esperaMiliseg(1000);
		utilidadesTCS.esperarElementVisibility("xpath", AdsPageObjects.TXT_AUTORIZACIONES);
        Utilidades.tomaEvidencia("Validar que para un cliente No común le muestre el sistema la pantalla de Autorizaciones hacer tap en T y C y el sistema muestre documento hacer tap en botón atras y dejando al usuario en pantalla autorizaciones con el check desmarcado.");
    }
    
	@Step
    public void aceptarTerminosYCondicionesTratamientoDeDatos() {
        Utilidades.esperaMiliseg(1500);
        for(int i = 0; i<12; i++) {
            Utilidades.scrollDownSwipe(1);
        }
        Utilidades.tomaEvidencia("Hacer clic en el boton Aceptar");
        utilidadesTCS.clicElement("xpath", AdsPageObjects.BTN_ACEPTAR);
        Utilidades.esperaMiliseg(1500);
        Utilidades.tomaEvidencia("Validar que para un cliente No común le muestre el sistema la pantalla de Autorizaciones hacer tap en T y C y el sistema muestre documento hacer tap en botón Aceptar y dejando al usuario en pantalla autorizaciones con el check marcado.");
    }
    
	@Step
	public void aceptarTerminosYCondicionesDebitar() {
        utilidadesTCS.clicElement("xpath", AdsPageObjects.TXT_AUTORIZADOR_DEBITAR);
        Utilidades.esperaMiliseg(2000);
		utilidadesTCS.esperarElementVisibility("xpath", AdsPageObjects.TXT_AUTORIZADOR_DEBITAR_AUTOMATICO);
        Utilidades.esperaMiliseg(1000);
        Utilidades.tomaEvidencia("Validar Autorización débito Automático");
        utilidadesTCS.clicElement("xpath", AdsPageObjects.BTN_ACEPTAR);
		utilidadesTCS.esperarElementVisibility("xpath", AdsPageObjects.TXT_AUTORIZACIONES);
        Utilidades.tomaEvidencia("Valido check marcado de autorización de débito automático");
	}
	
	@Step
    public void aceptarTerminosPagare() {
        utilidadesTCS.clicElement("xpath", AdsPageObjects.TXT_AUTORIZADOR_PAGARE);
        Utilidades.esperaMiliseg(800);
		utilidadesTCS.esperarElementVisibility("xpath", AdsPageObjects.TXT_AUTORIZADOR_PAGARE_DOCUMENTO);
        Utilidades.esperaMiliseg(800);
        for(int i = 0; i<5; i++) {
            Utilidades.scrollDownSwipe(1);
        }
        Utilidades.tomaEvidencia("Valido documento automatización del pagaré");
        utilidadesTCS.clicElement("xpath", AdsPageObjects.BTN_ACEPTAR);
        Utilidades.tomaEvidencia("Valido check marcado de autorización del pagaré");
    }
    
	@Step
    public void hacerClicBotonAtrasParaValidarChecksMarcadosPantallaAutorizaciones() {
        Utilidades.esperaMiliseg(1500);
        Utilidades.tomaEvidencia("Hacer clic en el boton atras");
        utilidadesTCS.clicElement("xpath", AdsPageObjects.BTN_ATRAS);
        Utilidades.esperaMiliseg(1500);
        Utilidades.tomaEvidencia("Validar que el si los check de la pantalla estan todos marcados y se hace tap en TyC y vuleve a la pantalla al hacer tap en atras la pantalla este con los check marcados");
    }
    
	@Step
    public void aceptarTerminosYCondicionesTratamientoDeDatosYValidarChecksMarcados() {
        Utilidades.esperaMiliseg(1500);
        for(int i = 0; i<12; i++) {
            Utilidades.scrollDownSwipe(1);
        }
        Utilidades.tomaEvidencia("Hacer clic en el boton Aceptar");
        utilidadesTCS.clicElement("xpath", AdsPageObjects.BTN_ACEPTAR);
        Utilidades.esperaMiliseg(1500);
        Utilidades.tomaEvidencia("Validar que el si los check de la pantalla estan todos marcados y se hace tap en TyC y vuleve a la pantalla al hacer tap en aceptar la pantalla este con los check marcados");
    }
    
	@Step
    public void validarElementosPopUpSalirDeLaApp() {
        Utilidades.esperaMiliseg(1500);    
        utilidadesTCS.clicElement("xpath", AdsPageObjects.BNT_SALIR_APP);
        boolean texto = utilidadesTCS.validateElementVisibility("xpath", MeterPlataPageObjects.TEXTO_POP_UP_CERRAR_DAVIPLATA);
        boolean btnCancelar = utilidadesTCS.validateElementVisibility("xpath", MeterPlataPageObjects.BOTON_CANCELAR_POP_UP_CERRAR_DAVIPLATA);
        boolean btnAceptar = utilidadesTCS.validateElementVisibility("xpath", MeterPlataPageObjects.BOTON_ACEPTAR_POP_UP_ACEPTAR_DAVIPLATA);
        utilidadesTCS.validateStatusElement(texto);
        utilidadesTCS.validateStatusElement(btnCancelar);
        utilidadesTCS.validateStatusElement(btnAceptar);
        Utilidades.tomaEvidencia("Validar que en la pantalla de Autorizaciones el usuario hace tap en cerrar el sistema muestra el pop up con el mensaje ¿Está seguro que desea salir de la aplicación? con los botón de Cancelar y Aceptar");
    }
    
	@Step
    public void validarQueAlDarClicEnCancelarDejeEnPantallaAutorizaciones() {
    	utilidadesTCS.clicElement("xpath", MeterPlataPageObjects.BOTON_CANCELAR_POP_UP_CERRAR_DAVIPLATA);
        Utilidades.tomaEvidencia("Validar que en la pantalla de Autorizaciones el usuario hace tap en cerrar el sistema muestra el pop up ¿Está seguro que desea salir de la aplicación? y hacer tap en el botón de Cancelar y deje al usuario en la misma pantalla");
    }
    
	@Step
    public void validarQueAlDarClicEnAceptarDejeEnPantallaLogin() {
        Utilidades.esperaMiliseg(1500);    
        utilidadesTCS.clicElement("xpath", AdsPageObjects.BNT_SALIR_APP);
        Utilidades.esperaMiliseg(1500);    
        utilidadesTCS.clicElement("xpath", MeterPlataPageObjects.BOTON_ACEPTAR_POP_UP_ACEPTAR_DAVIPLATA);
        utilidadesTCS.esperarElementVisibility("xpath",MeterPlataPageObjects.TEXTO_INGRESE_A_SU_DAVIPLATA);
        Utilidades.tomaEvidencia("Validar que en la pantalla de Autorizaciones el usuario hace tap en cerrar el sistema muestra el pop up ¿Está seguro que desea salir de la aplicación? y hacer tap en el botón Aceptar y deje al usurio en el login.");
    }
    
	@Step
    public void llenarFormularioInformacionPersonalPrimeraPantalla(String ciudadExpedicionDocumento, String paisNacimiento) {
        Utilidades.esperaMiliseg(1500);    
        boolean elemento = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.CONTINUAR_POP_UP_CAMBIAR_DISPOSITIVO);
        if(elemento == true) {
            Utilidades.tomaEvidencia("Valido mis datos en 'Adelanto de saldo'");
            utilidadesTCS.clicElement("xpath", LoginRobustoPage.CONTINUAR_POP_UP_CAMBIAR_DISPOSITIVO);
        }
        Utilidades.esperaMiliseg(800);    
    	utilidadesTCS.clicElement("xpath", AdsPageObjects.CAMPO_CIUDAD_EXPEDICION_DOCUMENTO);
    	utilidadesTCS.escribirPorTecladoIos(ciudadExpedicionDocumento);
        utilidadesTCS.clicElement("xpath", AdsPageObjects.OPCION_CIUDAD_EXPEDICION);
        Utilidades.esperaMiliseg(800);    
        Utilidades.tomaEvidencia("Ingreso ciudad de expedición del documento");
        utilidadesTCS.clicElement("xpath", AdsPageObjects.CAMPO_PAIS_NACIMIENTO);
    	utilidadesTCS.escribirPorTecladoIos(paisNacimiento);
        utilidadesTCS.clicElement("xpath", AdsPageObjects.OPCION_COLOMBIA_CIUDAD_NACIMIENTO);
        Utilidades.esperaMiliseg(800);    
        Utilidades.tomaEvidencia("Ingreso país de nacimiento");
        utilidadesTCS.clicElement("xpath", AdsPageObjects.CAMPO_CIUDAD_NACIMIENTO);
    	utilidadesTCS.escribirPorTecladoIos(ciudadExpedicionDocumento);
        utilidadesTCS.clicElement("xpath", AdsPageObjects.OPCION_CIUDAD_NACIMIENTO);
        Utilidades.esperaMiliseg(800);    
        Utilidades.tomaEvidencia("Ingreso país de nacimiento");
    }
    
	@Step
    public void llenarFormularioInformacionPersonalSegundaPantalla(String correoElectronico, String tipoCalle, String numUnoDireccion, String numDosDireccion, String numTresDireccion, String tipoInmueble, String ciudadResidencia) {
    	utilidadesTCS.clicElement("xpath",AdsPageObjects.CAMPO_CORREO_ELECTRONICO);
    	//utilidadesTCS.cleanInputElement("xpath",AdsPageObjects.CAMPO_CORREO_ELECTRONICO);
    	//utilidadesTCS.escribirPorTecladoIos(correoElectronico);
        Utilidades.tomaEvidencia("Ingreso el correo electrónico");
        utilidadesTCS.clicElement("xpath",AdsPageObjects.DESPLEGABLE_DONDE_VIVE);
        utilidadesTCS.clicElement("xpath", "//XCUIElementTypeButton[@name='"+tipoCalle.trim()+"']");
        utilidadesTCS.writeElement("xpath",AdsPageObjects.CAMPO_NUMERO_UNO_DIRECCION, numUnoDireccion);
        utilidadesTCS.writeElement("xpath",AdsPageObjects.CAMPO_NUMERO_DOS_DIRECCION, numDosDireccion);
        utilidadesTCS.writeElement("xpath",AdsPageObjects.CAMPO_NUMERO_TRES_DIRECCION, numTresDireccion);
        utilidadesTCS.clicElement("xpath",AdsPageObjects.BTN_DONE);
        Utilidades.tomaEvidencia("Ingreso tipo de calle y la dirección");
        utilidadesTCS.clicElementAction("xpath",AdsPageObjects.CHECKOUT_DIRECCION_PRINCIPAL_SI);
        utilidadesTCS.clicElement("xpath",AdsPageObjects.TIPO_INMUEBLE);  
        utilidadesTCS.escribirPorTecladoIos(tipoInmueble);
        utilidadesTCS.clicElement("xpath",AdsPageObjects.CIUDAD_DONDE_VIVE);
        utilidadesTCS.escribirPorTecladoIos(ciudadResidencia);
        utilidadesTCS.clicElement("xpath",AdsPageObjects.OPCION_CIUDAD_RESIDENCIA);
        Utilidades.tomaEvidencia("Diligencio formulario informacion personal pantalla dos");
    }
    
	@Step
    public void llenarFormularioInformacionLaboral(String tipoCalleDondeTrabaja, String numUnoDireccionDondeTrabaja, String numDosDireccionDondeTrabaja, String numTresDireccionDondeTrabaja, String tipoInmuebleDondeTrabaja, String ciudaDeTrabajo) {
        Utilidades.esperaMiliseg(1000); 
		utilidadesTCS.clicElement("xpath",AdsPageObjects.DESPLEGABLE_DONDE_TRABAJA);
        utilidadesTCS.clicElement("xpath", "//XCUIElementTypeButton[@name='"+tipoCalleDondeTrabaja.trim()+"']");
        Utilidades.tomaEvidencia("Ingresar tipo de calle de la dirección donde trabaja");
        utilidadesTCS.writeElement("xpath",AdsPageObjects.CAMPO_NUMERO_UNO_DIRECCION_TRABAJO, numUnoDireccionDondeTrabaja);
        utilidadesTCS.writeElement("xpath",AdsPageObjects.CAMPO_NUMERO_DOS_DIRECCION, numDosDireccionDondeTrabaja);
        utilidadesTCS.writeElement("xpath",AdsPageObjects.CAMPO_NUMERO_TRES_DIRECCION, numTresDireccionDondeTrabaja);
        utilidadesTCS.clicElement("xpath",AdsPageObjects.BTN_DONE);
        utilidadesTCS.clicElementAction("xpath",AdsPageObjects.CHECKOUT_SI_DIRECCION_PROPIA_DONDE_TRABAJA);
        utilidadesTCS.clicElement("xpath",AdsPageObjects.TIPO_INMUEBLE_DONDE_TRABAJA);
        utilidadesTCS.escribirPorTecladoIos(tipoInmuebleDondeTrabaja);
        utilidadesTCS.clicElement("xpath",AdsPageObjects.CIUDAD_DONDE_TRABAJA);
        utilidadesTCS.escribirPorTecladoIos(ciudaDeTrabajo);
        utilidadesTCS.clicElement("xpath",AdsPageObjects.OPCION_CIUDAD_RESIDENCIA);
        Utilidades.tomaEvidencia("Diligencio formulario informacion laboral");
    }
    
	@Step
    public void llenarFormularioInformacionFinanciera(String montoGastosMes, String montoSumaLoQueTiene) {
        Utilidades.esperaMiliseg(10000);    
        utilidadesTCS.clicElementAction("xpath",AdsPageObjects.CHECKOUT_NO_INGRESOS_MENSUALES);
        Utilidades.esperaMiliseg(800);    
		for(int i = 0 ; i<2; i++) {
	        utilidadesTCS.clicElement("xpath",AdsPageObjects.CAMPO_GASTOS_AL_MES);
		}
        utilidadesTCS.writeElement("xpath",AdsPageObjects.CAMPO_GASTOS_AL_MES, montoGastosMes);
		for(int i = 0 ; i<2; i++) {
	        utilidadesTCS.clicElement("xpath",AdsPageObjects.CAMPO_SUMA_LO_QUE_TIENE);
		}
        utilidadesTCS.writeElement("xpath",AdsPageObjects.CAMPO_SUMA_LO_QUE_TIENE, montoSumaLoQueTiene);
        utilidadesTCS.clicElement("xpath",AdsPageObjects.BTN_DONE);
        Utilidades.tomaEvidencia("Diligenciar formulario informacion financiera uno");
    }
    
    @Step
    public void llenarFormularioInformacionFinancieraDos(String montoSumaLoQueDebe) {
        Utilidades.esperaMiliseg(1000);   
		for(int i = 0 ; i<2; i++) {
	        utilidadesTCS.clicElement("xpath", AdsPageObjects.SUMA_LO_QUE_DEBE);  
		}
        utilidadesTCS.writeElement("xpath", AdsPageObjects.SUMA_LO_QUE_DEBE, montoSumaLoQueDebe);
        utilidadesTCS.clicElement("xpath", AdsPageObjects.BTN_DONE);
        utilidadesTCS.clicElementAction("xpath",AdsPageObjects.CHECKOUT_NO_PRODUCTOS_MONEDA_EXTRANJERA);
        Utilidades.tomaEvidencia("Diligenciar formulario informacion financiera dos");
    }
    
    @Step
    public void salirDeLaApp() {
        Utilidades.esperaMiliseg(5000);    
        utilidadesTCS.clicElement("xpath", AdsPageObjects.TXT_ADELANTO_SALDO);  	
        Utilidades.tomaEvidencia("Dar clic equis salir app daviplata");
        //utilidadesTCS.clicElement("xpath", AdsPageObjects.EQUIS_SALIR_APP_ADELANTO_SALDO); // No deja extraer localizador
        utilidadesTCS.clickCoordinates(370, 70);
        Utilidades.tomaEvidencia("Dar clic boton aceptar salir app daviplata");
        utilidadesTCS.clicElement("xpath", MeterPlataPageObjects.BOTON_ACEPTAR_POP_UP_ACEPTAR_DAVIPLATA);
    }
    
    @Step
    public void retomarSolicitudAds() {
        boolean elemento = utilidadesTCS.validateElementVisibilityCatch("xpath", AdsPageObjects.POP_UP_RETOMAR_SOLICITUD_ADELANTO_SUELDO);
        if(elemento == true) {
            Utilidades.tomaEvidencia("Valido presencia de un proceso de solicitud iniciada y acepto continuar con solicitud ADS");
        	utilidadesTCS.clicElement("xpath", AdsPageObjects.BTN_ACEPTAR);
        }
    }
    
    @Step
    public void validarQueSeHayanGuardadoLosDatosDelFormulario() {
        Utilidades.esperaMiliseg(5000);    
//        utilidadesTCS.esperarElementVisibility("xpath", AdsPageObjects.FORMULARIO_PANTALLA_INFORMACION_PERSONAL);
        Utilidades.tomaEvidencia("Valido pantalla dos de informacion personal");
        utilidadesTCS.clicElement("xpath", AdsPageObjects.BOTON_ATRAS_ADS);
        utilidadesTCS.esperarElementVisibility("xpath",AdsPageObjects.TEXTO_FECHA_EXPEDICION_DOCUMENTO);
        Utilidades.tomaEvidencia("Validar que el sistema deje al usuario en el punto maximo donde dejo diligenciado es decir debe tener toda la informacion de la pantalla 1 informacion personal");
    }
    
    @Step
    public void validarQueSeHayanGuardadoLosDatosDelFormularioEnLaPantallaDosInformacionPersonal() {
        Utilidades.esperaMiliseg(8000);    
        Utilidades.tomaEvidencia("Valido pantalla tres de informacion laboral");
        utilidadesTCS.clicElement("xpath", AdsPageObjects.BOTON_ATRAS_ADS);
        utilidadesTCS.esperarElementVisibility("xpath",AdsPageObjects.FORMULARIO_PANTALLA_INFORMACION_PERSONAL);
        Utilidades.tomaEvidencia("Validar que el sistema deje al usuario en el punto maximo donde dejo diligenciado es decir debe tener toda la informacion de la pantalla 2 informacion personal");
    }
    
    @Step
    public void validarQueSeHayanGuardadoLosDatosDelFormularioEnLaPantallaInformacionLaboral() {
        Utilidades.esperaMiliseg(5000);    
        utilidadesTCS.esperarElementVisibility("xpath", AdsPageObjects.FORMULARIO_PANTALLA_INFORMACION_LABORAL);
        Utilidades.tomaEvidencia("Valido pantalla de informacion laboral");
        utilidadesTCS.clicElement("xpath", AdsPageObjects.BOTON_ATRAS_ADS);
        utilidadesTCS.esperarElementVisibility("xpath",AdsPageObjects.DESPLEGABLE_DONDE_TRABAJA);
        Utilidades.tomaEvidencia("Validar que el sistema deje al usuario en el punto maximo donde dejo diligenciado es decir debe tener toda la informacion de la pantalla informacion laboral");
    }
    
    @Step
    public void validarQueSeHayanGuardadoLosDatosDelFormularioEnLaPantallaInformacionFinancieraUno() {
    	utilidadesTCS.esperarElementVisibility("xpath", AdsPageObjects.FORMULARIO_PANTALLA_INFORMACION_FINANCIERA);
        Utilidades.tomaEvidencia("Valido pantalla de informacion financiera");
        utilidadesTCS.clicElement("xpath", AdsPageObjects.BOTON_ATRAS_ADS);
        utilidadesTCS.esperarElementVisibility("xpath",AdsPageObjects.CAMPO_GASTOS_AL_MES);
        Utilidades.tomaEvidencia("Validar que el sistema deje al usuario en el punto maximo donde dejo diligenciado es decir debe tener toda la informacion de la pantalla informacion financiera uno");
    }
    
    @Step
    public void validarQueSeHayanGuardadoLosDatosDelFormularioEnLaPantallaInformacionFinancieraDos() {
        utilidadesTCS.esperarElementVisibility("xpath", AdsPageObjects.FORMULARIO_PANTALLA_INFORMACION_FINANCIERA);
        Utilidades.tomaEvidencia("Valido pantalla de informacion financiera");
        utilidadesTCS.clicElement("xpath", AdsPageObjects.BOTON_ATRAS_ADS);
        utilidadesTCS.esperarElementVisibility("xpath",AdsPageObjects.SUMA_LO_QUE_DEBE);
        Utilidades.tomaEvidencia("Validar que el sistema deje al usuario en el punto maximo donde dejo diligenciado es decir debe tener toda la informacion de la pantalla informacion financiera dos");
    }
    
    @Step
    public void llenoFormularioPersonaPoliticamenteExpuesta() {
        Utilidades.esperaMiliseg(8000);    
        utilidadesTCS.clicElementAction("xpath", AdsPageObjects.CHECKOUT_PERSONA_EXPUESTA);
        Utilidades.esperaMiliseg(1000);    
        utilidadesTCS.clicElementAction("xpath", AdsPageObjects.CHECKOUT_CARGO_POLITICO);
        utilidadesTCS.clicElementAction("xpath", AdsPageObjects.CHECKOUT_JUNTA_DIRECTIVA);
        Utilidades.scrollDownSwipe(1);
        utilidadesTCS.clicElementAction("xpath", AdsPageObjects.CHECKOUT_PERSONA_POLITICAMENTE_EXPUESTA);
        utilidadesTCS.clicElementAction("xpath", AdsPageObjects.CHECKOUT_FAMILIAR);
        Utilidades.scrollDownSwipe(1);
        Utilidades.tomaEvidencia("Llenar formulario de persona politicamente expuesta");
    }
    
    @Step
    public void llenoFormularioPersonaPoliticamenteExpuestaFlujoSi() {
        Utilidades.esperaMiliseg(8000);    
        utilidadesTCS.clicElementAction("xpath", AdsPageObjects.CHECKOUT_PERSONA_EXPUESTA);
        Utilidades.esperaMiliseg(1000);    
        utilidadesTCS.clicElementAction("xpath", AdsPageObjects.CHECKOUT_CARGO_POLITICO);
        utilidadesTCS.clicElementAction("xpath", AdsPageObjects.CHECKOUT_JUNTA_DIRECTIVA);
        Utilidades.scrollDownSwipe(1);
        utilidadesTCS.clicElementAction("xpath", AdsPageObjects.CHECKOUT_PERSONA_POLITICAMENTE_EXPUESTA);
        utilidadesTCS.clicElementAction("xpath", AdsPageObjects.CHECKOUT_FAMILIAR);
        Utilidades.scrollDownSwipe(1);
        utilidadesTCS.clicElement("xpath", AdsPageObjects.CAMPO_QUE_CARGO_TIENE);
        utilidadesTCS.escribirPorTecladoIos("Alcalde");
        Utilidades.esperaMiliseg(500);    
        utilidadesTCS.clicElement("xpath", AdsPageObjects.OPCION_CAMPO_QUE_CARGO_TIENE);
        utilidadesTCS.clicElement("xpath",AdsPageObjects.BTN_DONE);
        Utilidades.tomaEvidencia("Llenar formulario de persona politicamente expuesta");
    }
    
    @Step
    public void validarQueSeHayanGuardadoLosDatosDelFormularioEnLaPantallaPersonaPoliticamenteExpuesta() {
        utilidadesTCS.esperarElementVisibility("xpath", AdsPageObjects.FORMULARIO_PANTALLA_INFORMACION_TRIBUTARIA);
        Utilidades.tomaEvidencia("Valido pantalla de informacion tributaria");
        utilidadesTCS.clicElement("xpath", AdsPageObjects.BOTON_ATRAS_ADS);
        utilidadesTCS.esperarElementVisibility("xpath", AdsPageObjects.CHECKOUT_PERSONA_EXPUESTA);
        Utilidades.tomaEvidencia("Validar que el sistema deje al usuario en el punto maximo donde dejo diligenciado es decir debe tener toda la informacion de la pantalla persona politicamente expuesta");
    }

    @Step
    public void llenoFormularioInformacionTributariaNoFacta() {
        Utilidades.esperaMiliseg(8000);    
        utilidadesTCS.clicElement("xpath", AdsPageObjects.CHECKOUT_PAIS_RECIDENCIA);
        utilidadesTCS.clicElement("xpath", AdsPageObjects.CHECKOUT_NO_LEY_FACTA);
        Utilidades.tomaEvidencia("Llenar formulario informacion tributaria");
    }
    
    @Step
    public void llenoFormularioInformacionTributariaFacta() {
        utilidadesTCS.clicElement("xpath", AdsPageObjects.CHECKOUT_PAIS_RECIDENCIA);
        utilidadesTCS.clicElement("xpath", AdsPageObjects.CHECKOUT_SI_LEY_FACTA);
        Utilidades.tomaEvidencia("Llenar formulario informacion tributaria");
    }
    
    @Step
    public void validarQueSeHayanGuardadoLosDatosDelFormularioEnLaPantallaInformacionTributaria() {
        utilidadesTCS.esperarElementVisibility("xpath", AdsPageObjects.FORMULARIO_DECLARACIONES);
        Utilidades.tomaEvidencia("Valido pantalla de declaraciones");
        utilidadesTCS.clicElement("xpath", AdsPageObjects.BOTON_ATRAS_ADS);
        utilidadesTCS.esperarElementVisibility("xpath",AdsPageObjects.CHECKOUT_PAIS_RECIDENCIA);
        Utilidades.tomaEvidencia("Validar que el sistema deje al usuario en el punto maximo donde dejo diligenciado es decir debe tener toda la informacion de la pantalla informacion tributaria");
    }
    
    @Step
    public void validarQueSeHayanGuardadoLosDatosDelFormularioEnLaPantallaInformacionTributariaUnoFacta() {
        utilidadesTCS.esperarElementVisibility("xpath", AdsPageObjects.FORMULARIO_DECLARACIONES);
        Utilidades.tomaEvidencia("Valido pantalla de declaraciones");
        utilidadesTCS.clicElement("xpath", AdsPageObjects.BOTON_ATRAS_ADS);
        utilidadesTCS.esperarElementVisibility("xpath",AdsPageObjects.CHECKOUT_PAIS_RECIDENCIA);
        Utilidades.tomaEvidencia("Validar que el sistema deje al usuario en el punto maximo donde dejo diligenciado es decir debe tener toda la informacion de la pantalla informacion tributaria facta");
    }
    
    @Step
    public void llenoFormularioDeclaracionTributariaFacta(String nombreDeclaracionImpuestos, String direccionResidenciaFacta, String ciudad, String numeroPostal, String numeroSeguroSocial) {
        Utilidades.esperaMiliseg(8000);    
        utilidadesTCS.clicElement("xpath", AdsPageObjects.NOMBRE_DECLARACION_IMPUESTOS);
        utilidadesTCS.cleanInputElement("xpath", AdsPageObjects.NOMBRE_DECLARACION_IMPUESTOS);
    	utilidadesTCS.writeElement("xpath", AdsPageObjects.NOMBRE_DECLARACION_IMPUESTOS, nombreDeclaracionImpuestos);
        utilidadesTCS.clicElementAction("xpath",AdsPageObjects.DESPLEGABLE_CLASIFICACION_TRIBUTARIA);
        //utilidadesTCS.clicElement("xpath",AdsPageObjects.OPCION_CLASIFICACION_TRIBUTARIA);
        utilidadesTCS.clicElement("xpath", AdsPageObjects.CAMPO_DIRECCION_FACTA);
        utilidadesTCS.cleanInputElement("xpath", AdsPageObjects.CAMPO_DIRECCION_FACTA);
        utilidadesTCS.writeElement("xpath", AdsPageObjects.CAMPO_DIRECCION_FACTA, direccionResidenciaFacta);
        utilidadesTCS.clicElement("xpath", AdsPageObjects.CAMPO_CIUDAD);
        utilidadesTCS.escribirPorTecladoIos(ciudad);
//        Utilidades.scrollDownSwipe(1);
        utilidadesTCS.clicElement("xpath", AdsPageObjects.CAMPO_CIUDAD);
        utilidadesTCS.escribirPorTecladoIos(numeroPostal);
        utilidadesTCS.clicElement("xpath", AdsPageObjects.CAMPO_NUMERO_SEGURO_SOCIAL);
        utilidadesTCS.escribirPorTecladoIos(numeroSeguroSocial);
        Utilidades.scrollDownSwipe(1);
        Utilidades.tomaEvidencia("Llenar formulario declaración tributaria");
    }
    
    @Step
    public void validarQueSeHayanGuardadoLosDatosDelFormularioEnLaPantallaDeclaracionTributariaFacta() {
        utilidadesTCS.esperarElementVisibility("xpath", AdsPageObjects.FORMULARIO_DECLARACIONES);
        Utilidades.tomaEvidencia("Valido pantalla de declaraciones");
        utilidadesTCS.clicElement("xpath", AdsPageObjects.BOTON_ATRAS_ADS);
        utilidadesTCS.esperarElementVisibility("xpath",AdsPageObjects.NOMBRE_DECLARACION_IMPUESTOS);
        Utilidades.tomaEvidencia("Validar que el sistema deje al usuario en el punto maximo donde dejo diligenciado es decir debe tener toda la informacion de la pantalla declaracion tributaria facta");
    }
    
    @Step
    public void llenoFormularioDeclaracionFacta() {
        Utilidades.esperaMiliseg(8000);    
        utilidadesTCS.clicElement("xpath", AdsPageObjects.CHECKOUT_OBJETIVO_ADELANTO);
        utilidadesTCS.clicElement("xpath", AdsPageObjects.CHECKOUT_ORIGEN_RECURSOS);
        utilidadesTCS.clicElementAction("xpath", AdsPageObjects.CHECKOUT_NO_OBJETIVO_INVESTIGACIONES);
        utilidadesTCS.clicElement("xpath", AdsPageObjects.CHECKOUT_OBJETIVO_AUTORIZACIONES);
        Utilidades.tomaEvidencia("Llenar formulario declaraciones");
    }
    
    @Step
    public void validarCupoResultadoAdelantoSueldo() {
    	utilidadesTCS.esperarElementVisibility("xpath", AdsPageObjects.TXT_RESULTADO);
    	String cupo = utilidadesTCS.obtenerTexto("xpath", AdsPageObjects.TXT_VALOR_CUPO);
        Utilidades.tomaEvidencia("Valido el resultado: " + cupo);
    }
    
    @Step
    public void validarQueSeHayanGuardadoLosDatosDelFormularioEnLaPantallaDeclaraciones() {
        utilidadesTCS.esperarElementVisibility("xpath", AdsPageObjects.FORMULARIO_DECLARACIONES);
        Utilidades.tomaEvidencia("Valido pantalla de declaraciones");
        Utilidades.tomaEvidencia("Validar que el sistema deje al usuario en el punto maximo donde dejo diligenciado es decir debe tener toda la informacion de la pantalla declaraciones");
    }
    
    @Step
    public void aceptarAutorizacionesFinales() {
        utilidadesTCS.esperarElementVisibility("xpath", AdsPageObjects.TXT_AUTORIZACIONES);
        Utilidades.tomaEvidencia("Valido pantalla de autorizaciones");
        Utilidades.tomaEvidencia("Validar que el sistema deje al usuario en el punto maximo donde dejo diligenciado");
    }
}

