package daviplata.nacional.iOS.steps;

import daviplata.nacional.iOS.pageObjects.LoginPageObjects;
import daviplata.nacional.iOS.pageObjects.LoginRobustoPage;
import daviplata.nacional.iOS.pageObjects.MeterPlataPageObjects;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import daviplata.nacional.iOS.utilidades.Utilidades;
import daviplata.nacional.iOS.utilidades.UtilidadesTCS;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;


public class MeterPlataSteps{
	
	UtilidadesTCS utilidadesTcs;
	MeterPlataPageObjects meterPlataPageObjects;
	LoginPageObjects pageLogin;
	
	@Step
	public void validarOpcionMeterPlata() throws Exception {
		boolean estado = utilidadesTcs.validateElementVisibility("xpath", MeterPlataPageObjects.BOTON_METER_PLATA);
		utilidadesTcs.validateStatusElement(estado);
		Utilidades.tomaEvidencia("Validar que se encuentre presente la opción meter plata en el Home de la app");
	}
	
	@Step
	public void validarOpcionMeterPlataMH() throws Exception {
		boolean estado = utilidadesTcs.validateElementVisibility("xpath", MeterPlataPageObjects.BOTON_METER_PLATA_MH);
		utilidadesTcs.validateStatusElement(estado);
		Utilidades.tomaEvidencia("Validar que se encuentre presente la opcion meter plata en el menú hamburguesa");
	}
	
	@Step
	public void ingresarMenuHamburguesaPerfilPersona() throws Exception {
		utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BOTON_MENU_HAMBURGUESA);
		Utilidades.tomaEvidencia("Ingresar a menu hamburguesa");
	}
	
	@Step
	public void clicBotonUsarPlata() throws Exception {
		utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BOTON_USAR_PLATA_MH);
		Utilidades.tomaEvidencia("Clic botón usar plata");
	}
	
	@Step
	public void regresarAlHome() throws Exception {
		utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BOTON_MENU_HAMBURGUESA);
		Utilidades.tomaEvidencia("Regreso al home de daviplata");
	}
	
	@Step
	public void clicBotonMeterPlata() throws Exception {
		Utilidades.tomaEvidencia("Clic botón meter plata desde el home DaviPlata");
		utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BOTON_METER_PLATA_HOME);
		
	}
	
	@Step
	public void validarOpcionesDeDonceMeterPlata() throws Exception {
		boolean estado = utilidadesTcs.validateElementVisibility("xpath", MeterPlataPageObjects.TXT_DESDE_DONDE_METER_PLATA);
		utilidadesTcs.validateStatusElement(estado);
		Utilidades.tomaEvidencia("Validar que se encuentre presente las opciones para meter plata");
	}
	
	@Step
	public void regresarAlHomeDesdeModuloMeterPlata() throws Exception {
		Utilidades.tomaEvidencia("Clic botón (<) regreso a home");
		utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BOTON_REGRESO_HOME);
	}
	
	@Step
	public void ingresarBtnMeterPlataMH() throws Exception {
		Utilidades.esperaMiliseg(8000);
		utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BOTON_MENU_HAMBURGUESA);
		Utilidades.tomaEvidencia("Ingreso al menu hamburguesa");
		utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BOTON_USAR_PLATA_MH);
		Utilidades.tomaEvidencia("Ingresar a la opcion usar plata");
		utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BOTON_METER_PLATA_MH);
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Clic botón meter plata desde menú hamburguesa");
	}
	
	@Step
	public void validarOpcionesMeterPlataMH() throws Exception {
		boolean estado = utilidadesTcs.validateElementVisibility("xpath", MeterPlataPageObjects.TXT_DESDE_DONDE_METER_PLATA_HM);
		utilidadesTcs.validateStatusElement(estado);
		Utilidades.tomaEvidencia("Validar que se encuentre presente las opciones para meter plata desde el menu hamburguesa");
	}
	
	
	@Step
	public void clicBotonMeterPlataDesdeCualquierBanco() throws Exception {
		utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BTN_METER_PLATA_DESDE_CUALQUIER_BANCO);
		Utilidades.esperaMiliseg(1000);
		Utilidades.tomaEvidencia("Doy clic al botón meter plata 'Desde cualquier banco'");
	}
	
	@Step
	public void validarFormDatosMeterPlata() throws Exception {
		boolean estado = utilidadesTcs.validateElementVisibility("xpath", MeterPlataPageObjects.FORM_DATOS_METER_PLATA);
		utilidadesTcs.validateStatusElement(estado);
		Utilidades.tomaEvidencia("Valido formulario de datos para meter plata 'Desde cualquier banco'");
	}
	
	@Step
	public void validarOpcionesFormularioOtrosBancosMeterPlata() throws Exception {
	    String txtAQueNumeroQuiereMeterPlata = utilidadesTcs.obtenerTexto("xpath", MeterPlataPageObjects.TEXTO_A_QUE_NUMERO_QUIERE_METER_PLATA);
	    String txtConfirmarNumeroQuiereMeterPlata = utilidadesTcs.obtenerTexto("xpath", MeterPlataPageObjects.TEXTO_CONFIRMAR_NUMERO_QUIERE_METER_PLATA);
	    String txtCuantaPlataQuiereMeter = utilidadesTcs.obtenerTexto("xpath", MeterPlataPageObjects.TEXTO_CUANTA_PLATA_QUIERE_METER);
	    String txtDesdeQueBancoQuiereMeterPlata = utilidadesTcs.obtenerTexto("xpath", MeterPlataPageObjects.TEXTO_DESDE_QUE_BANCO_QUIERE_METER_PLATA);
	    String txtIngreseCorreoMeterPlata = utilidadesTcs.obtenerTexto("xpath", MeterPlataPageObjects.TEXTO_INGRESE_CORREO_METER_PLATA);

	    utilidadesTcs.validateTextContainsString(txtAQueNumeroQuiereMeterPlata, "A qué número quiere");
	    utilidadesTcs.validateTextContainsString(txtConfirmarNumeroQuiereMeterPlata, "Confirme el número");
	    utilidadesTcs.validateTextContainsString(txtCuantaPlataQuiereMeter, "Cuánta plata quiere");
	    utilidadesTcs.validateTextContainsString(txtDesdeQueBancoQuiereMeterPlata, "Desde qué banco");
	    utilidadesTcs.validateTextContainsString(txtIngreseCorreoMeterPlata, "Ingrese su correo");

	    Utilidades.tomaEvidencia("Validar que el formulario 'Complete los datos para Meter Plata a Daviplata' tenga los campos: '¿A qué número quiere meter plata','Confirme el número al que quiere meter plata', '¿Cuánta plata quiere meter?', 'Desde qué banco quiere meter plata?', 'Ingrese el correo registrado en PSE'");
	}

	
	@Step
	public void regresarAOpcionDondeQuieroMeterPlata() throws Exception {
		Utilidades.tomaEvidencia("Doy clic al botón (<) regreso desde donde quiero meter plata");
		utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BTN_REGRESO_DONDE_METER_PLATA);
	}
	
	@Step
	public void ingresarAOpcionMeterPlataEnEfectivo() throws Exception {
		utilidadesTcs.esperarElementVisibility("xpath", MeterPlataPageObjects.BTN_METER_PLATA_EN_EFECTIVO);
		Utilidades.tomaEvidencia("Doy clic al botón meter plata 'En Efectivo'");
		utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BTN_METER_PLATA_EN_EFECTIVO);
		
	}
	
	@Step
	public void validarPopUpComoMeterPlataEnEfectivo() throws Exception {
		String texto = utilidadesTcs.obtenerTexto("xpath", MeterPlataPageObjects.POP_UP_METER_PLATA_EFECTIVO);
		utilidadesTcs.validateTextContainsString(texto, "¿Cómo Meter Plata en Efectivo?");
		boolean estado = utilidadesTcs.validateElementEnabled("xpath", MeterPlataPageObjects.BTN_POP_UP_ENCONTRAR);
		utilidadesTcs.validateStatusElement(estado);
		Utilidades.tomaEvidencia("Valido PopUp informativo 'Cómo meter plata en efectivo' y botón 'Encontrar' activo");
	}
	
	@Step
	public void aceptarInfoPopUp() throws Exception {
		Utilidades.esperaMiliseg(2000);
		Utilidades.tomaEvidencia("Cliqueo botón ENCONTRAR dentro de POP UP Donde meter plata en Efectivo");
		utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BTN_POP_UP_ENCONTRAR);
		
		
	}
	
	@Step
	public void aceptarPermisosGeoreferenciador() throws Exception {
		utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BTN_REGRESO_MODULO_DONDE_METER_PLATA); //Cambiar localizador
		Utilidades.esperaMiliseg(2000);
		Utilidades.tomaEvidencia(" ");
	}
	
	@Step
	public void validarPantallaGeoreferenciador() throws Exception {
		utilidadesTcs.esperarElementVisibility("xpath", MeterPlataPageObjects.TEXTO_METER_PLATA_EFECTIVO);
		boolean estado = utilidadesTcs.validateElementVisibility("xpath", MeterPlataPageObjects.TEXTO_METER_PLATA_EFECTIVO);
		utilidadesTcs.validateStatusElement(estado);
		Utilidades.tomaEvidencia("Valido presencia de pantalla del georeferenciador: " + estado);
	}
	
	@Step
	public void regresarAModuloDesdeDondeMeterPlata() throws Exception {
		utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BTN_REGRESO_MODULO_DONDE_METER_PLATA);
		Utilidades.esperaMiliseg(2000);
		Utilidades.tomaEvidencia("Clic botón (<) regreso a desde donde meter plata");
	}
	
	@Step
	public void ingresarNumCel(String numCelularEspecial) {
		utilidadesTcs.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
		Utilidades.esperaMiliseg(1000);
		utilidadesTcs.writeElement("xpath", MeterPlataPageObjects.CAMPO_INGRESO_NUMERO_CEL, numCelularEspecial);
		Utilidades.tomaEvidencia("Ingreso a campo y digito número de celular especial");
	}
	
	@Step
	public void ingresarNumeroCelularPorTeclado(String numCelular) {
		Utilidades.esperaMiliseg(1000);
		utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.CAMPO_INGRESO_NUMERO_CEL);
		utilidadesTcs.escribirPorTecladoIos(numCelular);
		Utilidades.tomaEvidencia("Ingreso a campo y digito número de celular");
	}
	
	@Step
	public void validarLongitudNumeroCelular() {
		String valorExtraido = utilidadesTcs.obtenerTexto("xpath", MeterPlataPageObjects.CAMPO_INGRESO_NUMERO_CEL);
		String longitudCelular = utilidadesTcs.validarLongitudNumerica(valorExtraido, 10);
		Utilidades.tomaEvidencia("Valido longitud número celular ingresado es: " + longitudCelular + "dígitos");
	}
	
	@Step
	public void validarSoloPermitidoCaracateresNumericos() {
		String valorExtraido = utilidadesTcs.obtenerTexto("xpath", MeterPlataPageObjects.CAMPO_INGRESO_NUMERO_CEL);
		String sonValoresNumericos = utilidadesTcs.validarCaracteresNumericos(valorExtraido);
		Utilidades.tomaEvidencia("Valido que solo se permitan caracteres numéricos: " + sonValoresNumericos);
	}
	
	@Step
	public void limpiarCampoNumIngresado() {
		utilidadesTcs.cleanInputElement("xpath", MeterPlataPageObjects.CAMPO_INGRESO_NUMERO_CEL);
		Utilidades.esperaMiliseg(1000);
		Utilidades.tomaEvidencia("Limpio campo de número ingresado");
	}
	
	@Step
	public void limpiarCampoNumIngresadoConfirmacion() {
		utilidadesTcs.cleanInputElement("xpath", MeterPlataPageObjects.INPUT_NUMERO_CONFIRMACION);
		Utilidades.esperaMiliseg(1000);
		Utilidades.tomaEvidencia("Limpio campo de número confirmación ingresado");
	}
	
	@Step
	public void ingresarNumCelDiferenteDeTres(String numCelularDiferenteTres) {
		Utilidades.esperaMiliseg(1000);
		utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.CAMPO_INGRESO_NUMERO_CEL);
		// utilidadesTcs.ingresarUsuario("xpath", meterPlataPageObjects.CAMPO_INGRESO_NUMERO_CEL, numCelularEspecial);
		utilidadesTcs.writeElement("xpath", MeterPlataPageObjects.CAMPO_INGRESO_NUMERO_CEL, numCelularDiferenteTres);
		Utilidades.tomaEvidencia("Ingreso a campo y digito número de celular especial");
	}
	
	@Step
	public void validarNumIngresadoEmpiezaEnTres() {
		String texto = utilidadesTcs.obtenerTexto("xpath", MeterPlataPageObjects.TXT_NUM_CEL_DEBE_INICIAR_CON_TRES);
		utilidadesTcs.validateTextContainsString(texto, "El número debe iniciar");
		Utilidades.tomaEvidencia("Valido que el número ingresado debe empezar en tres");		
	}
	
	@Step
	public void confirmarNumCelEspecial(String confirmarNumCelularEspecial) {
		Utilidades.esperaMiliseg(1000);
		utilidadesTcs.writeElement("xpath", MeterPlataPageObjects.CAMPO_CONFIRME_NUMERO_CEL, confirmarNumCelularEspecial);
		Utilidades.tomaEvidencia("Confirmo número de celular especial");
	}
	
	@Step
	public void confirmarNumeroCelularConfirmacion(String confirmarNumCelular) {
		Utilidades.esperaMiliseg(1000);
		utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.CAMPO_CONFIRME_NUMERO_CEL);
		utilidadesTcs.escribirPorTecladoIos(confirmarNumCelular);
		Utilidades.tomaEvidencia("Confirmo número de celular especial");
	}
	
	@Step
	public void validarLongitudNumeroCelularConfirmacion() {
		String valorExtraido = utilidadesTcs.obtenerTexto("xpath", MeterPlataPageObjects.CAMPO_CONFIRME_NUMERO_CEL);
		String longitudCelular = utilidadesTcs.validarLongitudNumerica(valorExtraido, 10);
		Utilidades.tomaEvidencia("Valido longitud número celular de confirmación ingresado es: " + longitudCelular + "dígitos");
	}
	
	@Step
	public void validarSoloPermitidoCaracateresNumericosConfirmacionCel() {
		String valorExtraido = utilidadesTcs.obtenerTexto("xpath", MeterPlataPageObjects.CAMPO_CONFIRME_NUMERO_CEL);
		String sonValoresNumericos = utilidadesTcs.validarCaracteresNumericos(valorExtraido);
		Utilidades.tomaEvidencia("Valido que solo se permitan caracteres numéricos en confirmación de número: " + sonValoresNumericos);
	}
	
	@Step
	public void ingresarNumCelConfirmacionDiferenteDeTres(String numCelularDiferenteTres) {
		Utilidades.esperaMiliseg(1000);
		utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.CAMPO_CONFIRME_NUMERO_CEL);
		utilidadesTcs.writeElement("xpath", MeterPlataPageObjects.CAMPO_CONFIRME_NUMERO_CEL, numCelularDiferenteTres);
		Utilidades.tomaEvidencia("Ingreso a campo y digito número de celular de confirmación");
	}
	
	@Step
	public void validarNumCelConfirmaciónEmpieceEnTres() {
		String texto = utilidadesTcs.obtenerTexto("xpath", MeterPlataPageObjects.TXT_NUM_CEL_CONFIRMACION_DEBE_INICIAR_CON_TRES);
		utilidadesTcs.validateTextContainsString(texto, "El número debe iniciar");
		Utilidades.tomaEvidencia("Valido que el número de confirmación ingresado debe empezar en tres");		
	}
	
	@Step
	public void validarOpcionesMeterPlata() {
	    String textoCualquierBanco = utilidadesTcs.obtenerTexto("xpath", MeterPlataPageObjects.BTN_METER_PLATA_DESDE_CUALQUIER_BANCO);
	    String textoEnEfectivo = utilidadesTcs.obtenerTexto("xpath", MeterPlataPageObjects.BTN_METER_PLATA_EN_EFECTIVO);

	    utilidadesTcs.validateTextContainsString(textoCualquierBanco, "Desde cualquier banco");
	    utilidadesTcs.validateTextContainsString(textoEnEfectivo, "En efectivo");

	    Utilidades.tomaEvidencia("Validar que la pantalla para elegir cómo quiere Meter Plata presente las opciones 'Desde cualquier banco' y 'En efectivo'");
	}
	
	@Step
	public void ingresarNumeroConsultadoDesdeRedeban() {
		utilidadesTcs.writeElement("xpath", MeterPlataPageObjects.CAMPO_INGRESO_NUMERO_CEL, BaseUtil.numeroCelularRedeban);
		Utilidades.tomaEvidencia("Ingresar numero propio consultado en redeban");
	}
	
	@Step
	public void ingresarConfirmacionNumeroConsultadoDesdeRedeban() {
		utilidadesTcs.writeElement("xpath", MeterPlataPageObjects.CAMPO_CONFIRME_NUMERO_CEL, BaseUtil.numeroCelularRedeban);
		Utilidades.tomaEvidencia("Ingresar confirmacion de numero consultado en redeban");
	}
	
	@Step
	public void validarMensajeNoCoincidenNumeros() {
        String texto = utilidadesTcs.obtenerTexto("xpath", MeterPlataPageObjects.TEXTO_MENSAJE_NO_COINCIDE);
        utilidadesTcs.validateTextContainsString(texto, "Los números no coinciden");
        Utilidades.tomaEvidencia("Validar que cuando los datos ingresados en los campos no coincidan se muestre texto indicando el error debajo de los dos campos");
    }
	
	@Step
	public void ingresarMontoFormulario(String monto) {
        utilidadesTcs.writeElement("xpath", MeterPlataPageObjects.INPUT_MONTO, monto);
        Utilidades.tomaEvidencia("Ingresar cantidad de monto");
    }
	
	@Step
	public void desplegarListaBancos() {
		Utilidades.esperaMiliseg(1000);
        utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.LISTA_DESPLEGABLE_BANCOS);
        
    }
	
	
	@Step
	public void validarValorMaximoMinimo() {
        String texto = utilidadesTcs.obtenerTexto("xpath", MeterPlataPageObjects.TEXTO_MAXIMO_MINIMO_SALDO);
        utilidadesTcs.validateTextContainsString(texto, "El valor mínimo por transacción");
        Utilidades.tomaEvidencia("Validar que el campo controle el monto minimmo y maximo");
    }
	
	@Step
	public void validarPuntosDecimalesYLongitud() {
        String texto = utilidadesTcs.obtenerTexto("xpath", MeterPlataPageObjects.INPUT_MONTO);
        boolean estadoUno = utilidadesTcs.validarFormatoDecimalesNumero(texto);
        utilidadesTcs.validateStatusElement(estadoUno);
        boolean estadoDos = utilidadesTcs.validarLongitudDeLoIngresadoEnElCampo(texto,9);
        utilidadesTcs.validateStatusElement(estadoDos);
        Utilidades.tomaEvidencia("Validar que el campo Cuánta plata quiere meter solo permita el ingreso de valores numericos y tenga longitud de nueve");
    }
	
	@Step
	public void confirmoNumeroCel() {
		Utilidades.esperaMiliseg(1500);
		utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.CAMPO_CONFIRMACION_INGRESO_NUMERO_CEL);
	}
	
	@Step
	public void hacerClicEnElBotonSeleccionarBancos() {
        Utilidades.tomaEvidencia("Desplegar lista de bancos");
		utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BOTON_SELECCIONE_EL_BANCO);
	}
	
	@Step
	public void validarListaDeBancos() {
       boolean estadoVisible = utilidadesTcs.validateElementVisibility("xpath", MeterPlataPageObjects.LISTA_BANCOS);
       utilidadesTcs.validateStatusElement(estadoVisible);
       Utilidades.tomaEvidencia("Validar que el campo Desde que banco quiere meter plata Despliegue una lista con los bancos");
    }
	
	@Step
	public void validarListaBancosNoEsteDaviplataYDavivienda() {
        utilidadesTcs.validateListElementsOptionNotAppear("xpath", MeterPlataPageObjects.OPCIONES_LISTA_BANCOS, "Daviplata");
        utilidadesTcs.validateListElementsOptionNotAppear("xpath", MeterPlataPageObjects.OPCIONES_LISTA_BANCOS, "BANCO DAVIVIENDA");
        Utilidades.tomaEvidencia("Validar que en el campo Desde que banco quiere meter plata No se presente la opcion Daviplata y Davivienda");
        utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.OPCION_BANCO_ALIANZA_FIDUCIARIA);
    }
	
	@Step
	public void ingresarCorreoPse(String correo) {
		Utilidades.esperaMiliseg(1000);
		utilidadesTcs.cleanInputElement("xpath", MeterPlataPageObjects.INPUT_CORREO);
		Utilidades.esperaMiliseg(1500);
        utilidadesTcs.writeElement("xpath", MeterPlataPageObjects.INPUT_CORREO, correo);
        Utilidades.tomaEvidencia("Ingresar correo con caracteres alfanumericos");
    }
	
	@Step
	public void validarCorreoContengaCaracteresAlfanumericos() {
        String texto = utilidadesTcs.obtenerTexto("xpath", MeterPlataPageObjects.INPUT_CORREO);
        boolean estado = utilidadesTcs.validateContainsAlphanumericCharacters(texto);
        utilidadesTcs.validateStatusElement(estado);
        Utilidades.tomaEvidencia("Validar que el campo Ingrese el correo registrado en PSE permita ingresar valores alfa-númericos");
    }
	
	@Step
	public void ingresoOpcionDesdeCuentasDavivienda() {
		utilidadesTcs.esperarElementVisibility("xpath", MeterPlataPageObjects.OPCION_DESDE_CUENTAS_DAVIVIENDA);
		Utilidades.tomaEvidencia("Ingreso a la opción desde cuentas davivienda");
	    utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.OPCION_DESDE_CUENTAS_DAVIVIENDA);
	}
	
	@Step
	public void extraerCorreoPrecargadoYValidarlo() {
	    utilidadesTcs.esperarElementVisibility("xpath", MeterPlataPageObjects.TEXTO_FORMULARIO_PSE);
	    BaseUtil.correoActual = utilidadesTcs.obtenerTexto("xpath", MeterPlataPageObjects.INPUT_CORREO_PSE);
	    utilidadesTcs.validateStringTextNotEmpty(BaseUtil.correoActual);
	    Utilidades.tomaEvidencia("Validar que el correo registrado en PSE debe estar precargado con el correo ingresado en anteriores transacciones");
	}
	
	@Step
	public void editarCorreoDeTransaccion(String correo) {
	    utilidadesTcs.cleanInputElement("xpath", MeterPlataPageObjects.INPUT_CORREO_PSE);
	    utilidadesTcs.writeElement("xpath", MeterPlataPageObjects.INPUT_CORREO_PSE, correo);
	    Utilidades.tomaEvidencia("Ingreso Correo Nuevo");
	}
	
	@Step
	public void validarCorreoNuevoIngresado() {
	    String correo = utilidadesTcs.obtenerTexto("xpath", MeterPlataPageObjects.INPUT_CORREO_PSE);
	    utilidadesTcs.validateTextNotEqualTo(BaseUtil.correoActual, correo);
	    Utilidades.tomaEvidencia("Validar que el correo precargado tenga la opción de editarse y quede guardado el nuevo.");
	}
	
	@Step
	public void ingresarMontoARecargar(String monto) {
	    utilidadesTcs.writeElement("xpath", MeterPlataPageObjects.INPUT_INGRESE_UN_VALOR, monto);
	    Utilidades.tomaEvidencia("Ingresar monto a recargar en el daviplata");
	}
	
	@Step
	public void clicBotonContinuar() {
	    Utilidades.tomaEvidencia("Dar clic en el botón continuar");
	    utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BOTON_CONTINUAR);
	}
	
	@Step
	public void clicBotonContinuarVerificarInfo() {
	    Utilidades.tomaEvidencia("Dar clic en el botón continuar");
	    utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BOTON_CONTINUAR_VERIFICAR_INFO);
	}
	
	@Step
	public void validarPantallaInformacionIngresada() {
		Utilidades.esperaMiliseg(4000);
	    utilidadesTcs.esperarElementVisibility("xpath", MeterPlataPageObjects.TEXTO_INFORMACION_INGRESADA);
	    String texto = utilidadesTcs.obtenerTexto("xpath", MeterPlataPageObjects.TEXTO_INFORMACION_INGRESADA);
	    utilidadesTcs.validateTextContainsString(texto, "Verifique la información ingresada");
	    Utilidades.tomaEvidencia("Validar que al seleccionar el botón continuar se dirija el flujo de la pantalla 'Verifique informacion ingresada'");
	}
	
	@Step
	public void clicEnElBotonAtras() {
		Utilidades.tomaEvidencia("Dar clic en el botón regresar");
	    utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BOTON_REGRESAR_FORMULARIO);
	}
	
	@Step
	public void validarPantallaPse() {
	    utilidadesTcs.esperarElementVisibility("xpath", MeterPlataPageObjects.TEXTO_FORMULARIO_PSE);
	    String texto = utilidadesTcs.obtenerTexto("xpath", MeterPlataPageObjects.TEXTO_FORMULARIO_PSE);
	    utilidadesTcs.validateTextContainsString(texto, "Complete la información");
	    Utilidades.tomaEvidencia("Validar que al hacer tap sobre el botón atrás redirija a la pantalla inmediatamente anterior");
	}
	
	@Step
	public void validoBotonNecesitoAyuda() {
	    boolean estado = utilidadesTcs.validateElementVisibility("xpath", MeterPlataPageObjects.BOTON_NECESITO_AYUDA);
	    utilidadesTcs.validateStatusElement(estado);
	    Utilidades.tomaEvidencia("Validar botón necesita Ayuda. Siempre debe estar activo y visible en todas las pantallas");
	}
	
	@Step
	public void validoFuncionalidadesCancelarAceptarSalirDeLaApp() {
		Utilidades.tomaEvidencia("Dar clic en el botón cerrar daviplata");
	    utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BOTON_CERRAR_DAVIPLATA);
	    String texto = utilidadesTcs.obtenerTexto("xpath", MeterPlataPageObjects.TEXTO_POP_UP_CERRAR_DAVIPLATA);
	    utilidadesTcs.validateTextContainsString(texto, "Está seguro que desea salir");
	    Utilidades.tomaEvidencia("Validar que muestre pop up de '¿Está seguro que desea salir de la aplicación?' después de hacer clic en la X");
	    Utilidades.tomaEvidencia("Hacer clic en el botón cancelar");
	    utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BOTON_CANCELAR_POP_UP_CERRAR_DAVIPLATA);
	    utilidadesTcs.esperarElementVisibility("xpath", MeterPlataPageObjects.TEXTO_FORMULARIO_PSE);
	    String texto1 = utilidadesTcs.obtenerTexto("xpath", MeterPlataPageObjects.TEXTO_FORMULARIO_PSE);
	    utilidadesTcs.validateTextContainsString(texto1, "Complete la información");
	    Utilidades.tomaEvidencia("Validar que al dar tap en botón cancelar lo deje en la misma pantalla");
	    Utilidades.tomaEvidencia("Dar clic en el botón cerrar daviplata");
	    utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BOTON_CERRAR_DAVIPLATA);
	    utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BOTON_ACEPTAR_POP_UP_ACEPTAR_DAVIPLATA);
	    String texto2 = utilidadesTcs.obtenerTexto("xpath", MeterPlataPageObjects.TEXTO_INGRESE_A_SU_DAVIPLATA);
	    utilidadesTcs.validateTextEqualTo(texto2, "Ingrese a su Daviplata");
	    Utilidades.tomaEvidencia("Validar que al dar tap en botón aceptar lo saque de la aplicación");
	}
	
	@Step
	public void escojoOpcionBancoUnionColombiano(String banco) {
		String localizador = "(//XCUIElementTypeStaticText[@name='"+banco.trim()+"'])[1]";
		utilidadesTcs.clicElement("xpath", localizador);
	    Utilidades.tomaEvidencia("Elegir banco union colombiano");
	}
	
	@Step
	public void clicContinuarFormularioOtrosBancos() {
		Utilidades.esperaMiliseg(1500);
	    Utilidades.tomaEvidencia("Continuo despues de llenar formulario");
		utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BOTON_CONTINUAR);
		Utilidades.esperaMiliseg(3000);
	    Utilidades.tomaEvidencia("Verifico la informacion ingresada");
		utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BOTON_METER_PLATA_VERIFIQUE_INFORMACION);
		Utilidades.esperaMiliseg(500);
		utilidadesTcs.esperarElementVisibility("xpath", MeterPlataPageObjects.TXT_WELCOME_PSE);
		String pass = "123";
		String passConfirm = "1234";
		String validation = "12345";
		utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.INPUT_ACCOUNT_AGENCY);
		utilidadesTcs.writeElement("xpath", MeterPlataPageObjects.INPUT_ACCOUNT_AGENCY, pass);
		Utilidades.esperaMiliseg(1500);
		utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.INPUT_ACCOUNT_NUMBER);
		utilidadesTcs.writeElement("xpath", MeterPlataPageObjects.INPUT_ACCOUNT_NUMBER, passConfirm);
		Utilidades.esperaMiliseg(1500);
		utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.INPUT_PASSWORD);
		utilidadesTcs.writeElement("xpath", MeterPlataPageObjects.INPUT_PASSWORD, validation);
		Utilidades.esperaMiliseg(1500);
	    Utilidades.tomaEvidencia("Completo formulario PSE");
		utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BOTON_PAY);
	}
	
	@Step
	public void validarCostoTransaccionCero() {
        String texto = utilidadesTcs.obtenerTexto("xpath", MeterPlataPageObjects.TEXTO_COSTO_TRANSACCION);
        utilidadesTcs.validateTextEqualTo(texto, "$0");
        Utilidades.tomaEvidencia("Validar costo de la transacción en cero");
        
    }
	
	@Step
	public void clicBotonMeterPlataDesdeVerifiqueInformacion() {
		Utilidades.tomaEvidencia("Hacer clic en el boton meter plata");
		utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BOTON_METER_PLATA_VERIFIQUE_INFORMACION);
    }
	
	@Step
	public void llenarFormularioSamplePse() {
        utilidadesTcs.esperarElementVisibility("xpath", MeterPlataPageObjects.LOGO_PSE);
        Utilidades.esperaMiliseg(1000);
        Utilidades.scrollDownSwipe();
        utilidadesTcs.writeElement("xpath", MeterPlataPageObjects.INPUT_ACCOUNT_AGENCY, "123456");
        utilidadesTcs.writeElement("xpath", MeterPlataPageObjects.INPUT_ACCOUNT_NUMBER, "123456");
        utilidadesTcs.writeElement("xpath", MeterPlataPageObjects.INPUT_PASSWORD, "123456");
        utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BOTON_PAY);
        Utilidades.tomaEvidencia("Llenar formulario sample de Pse");
    }
	
	@Step
	public void aceptarTerminosYCondiciones() {
		Utilidades.esperaMiliseg(4000);
		boolean estado = utilidadesTcs.validateElementVisibilityCatch("xpath", MeterPlataPageObjects.TEXTO_AUTORIZA_PSE);
		if(estado == true) {
			utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.CHECK_SWITCH_TRATAMIENTO_DATOS);
			utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.CHECK_SWITCH_TYC);
			utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BOTON_CONTINUAR);
		}
		
	}
	
	@Step
	public void validarTransaccion() {
		Utilidades.esperaMiliseg(8000);
        utilidadesTcs.esperarElementVisibility("xpath", MeterPlataPageObjects.TEXTO_TRANSACCION_EXITOSA);
        utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.TEXTO_TRANSACCION_EXITOSA);
        String texto = utilidadesTcs.obtenerTexto("xpath", MeterPlataPageObjects.TEXTO_TRANSACCION_EXITOSA);
        utilidadesTcs.validateTextEqualTo(texto, "Transacción exitosa");
        Utilidades.tomaEvidencia("Validar transaccion exitosa");
    }
	
	@Step
	public void validarInformacionDeLaTransaccion() {
        String texto1 = utilidadesTcs.obtenerTexto("xpath", MeterPlataPageObjects.CAMPO_FECHA_Y_HORA);
        String texto2 = utilidadesTcs.obtenerTexto("xpath", MeterPlataPageObjects.CAMPO_NUMERO_PRODUCTO_DESTINO);
        String texto3 = utilidadesTcs.obtenerTexto("xpath", MeterPlataPageObjects.CAMPO_CUANTA_PLATA_METIO);
        String texto4 = utilidadesTcs.obtenerTexto("xpath", MeterPlataPageObjects.CAMPO_NUMERO_AUTORIZACIÓN);
        utilidadesTcs.validateTextEqualTo(texto1, "Fecha y hora de la transacción");
        utilidadesTcs.validateTextEqualTo(texto2, "Número al que metió plata");
        utilidadesTcs.validateTextEqualTo(texto3, "¿Cuánta plata metió?");
        utilidadesTcs.validateTextEqualTo(texto4, "Número de autorización");
    }
	
	@Step
	public void hacerClicBotonFinalizar() {
		Utilidades.esperaMiliseg(1000);
		Utilidades.scrollDownSwipe();
        utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BOTON_FINALIZAR);
    }
	
	@Step
	public void validarMensajeRecargaNoExitosa() {
		Utilidades.esperaMiliseg(8000);
	    utilidadesTcs.esperarElementVisibility("xpath", MeterPlataPageObjects.MENSAJE_TRANSACCION_NO_EXITOSA);
	    String texto = utilidadesTcs.obtenerTexto("xpath", MeterPlataPageObjects.MENSAJE_TRANSACCION_NO_EXITOSA);
	    utilidadesTcs.validateTextContainsString(texto, "Comunicación no disponible");
	    Utilidades.tomaEvidencia("Validar transacción no exitosa");
	    utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BOTON_CONTINUAR);
		Utilidades.esperaMiliseg(1000);
		boolean estadoVisible = utilidadesTcs.validateElementVisibilityCatch("xpath", LoginRobustoPage.POP_UP_INVITE_AMIGOS);
		if(estadoVisible == true) {
			utilidadesTcs.clicElement("xpath", LoginRobustoPage.BOTON_CLOSE);
		}	    
	}
	
	@Step
	public void validarTransaccionExitosa() {
		Utilidades.esperaMiliseg(8000);
	    utilidadesTcs.esperarElementVisibility("xpath", MeterPlataPageObjects.TEXTO_TRANSACCION_EXITOSA);
	    String texto = utilidadesTcs.obtenerTexto("xpath", MeterPlataPageObjects.TEXTO_TRANSACCION_EXITOSA);
		System.out.println("Valido resultado transacción en: " + texto);
	    Utilidades.tomaEvidencia("Validar transacción exitosa");
	    utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BOTON_FINALIZAR);
		boolean estadoVisible = utilidadesTcs.validateElementVisibilityCatch("xpath", LoginRobustoPage.POP_UP_INVITE_AMIGOS);
		if(estadoVisible == true) {
			utilidadesTcs.clicElement("xpath", LoginRobustoPage.BOTON_CLOSE);
		}	
	}
}
