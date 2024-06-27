package daviplata.nacional.iOS.definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import daviplata.nacional.iOS.steps.MeterPlataSteps;
import daviplata.nacional.iOS.steps.PasarPlataSteps;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import daviplata.nacional.iOS.utilidades.Cronometro;
import daviplata.nacional.iOS.utilidades.Evidencias;

public class MeterPlataDefinitions {

	@Steps
	MeterPlataSteps meterPlataSteps;
	@Steps
	Cronometro cronometro;
	@Steps
	BaseUtil base;
	@Steps
	Evidencias evidencia;
	@Steps
	PasarPlataSteps stepsPasarPlata;

	@When("^Valido la opcion meter plata desde home daviplata$")
	public void validoOpcionMeterPlata() throws Exception {
		meterPlataSteps.validarOpcionMeterPlata();
	}

	@Then("^Valido que se presente la opcion meter plata en el menu hamburguesa$")
	public void validoOpcionMeterPlataMenuHamburguesa() throws Exception {
		meterPlataSteps.validarOpcionMeterPlataMH();
	}

	@Given("^Ingreso al menu hamburguesa de perfil persona$")
	public void ingresoAlMenuHamburguesaDePerfilPersona() throws Exception {
		meterPlataSteps.ingresarMenuHamburguesaPerfilPersona();
	}

	@Given("^Ingreso a la opción usar plata$")
	public void ingresoALaOpciónUsarPlata() throws Exception {
		meterPlataSteps.clicBotonUsarPlata();
	}

	@When("^Regreso al home daviplata desde el menu hamburguesa$")
	public void regresoAlHomeDaviplataDesdeElMenuHamburguesa() throws Exception {
		meterPlataSteps.regresarAlHome();

	}

	@When("^Ingreso a la opción meter plata desde el home daviplata$")
	public void ingresoALaOpciónMeterPlataDesdeElHomeDaviplata() throws Exception {
		meterPlataSteps.clicBotonMeterPlata();
	}

	@When("^Valido opciones desde donde se quiere meter la plata$")
	public void validoOpcionesDesdeDondeSeRequiereMeterLaPlata() throws Exception {
		meterPlataSteps.validarOpcionesDeDonceMeterPlata();
	}

	@When("^Regreso al home daviplata desde el modulo meter plata$")
	public void regresoAlHomeDaviplataDesdeElModuloMeterPlata() throws Exception {
		meterPlataSteps.regresarAlHomeDesdeModuloMeterPlata();
	}

	@When("^Ingreso a la opción meter plata desde el menu hamburguesa$")
	public void ingresoALaOpcionMeterPlataDesdeElMenuHamburguesa() throws Exception {
		meterPlataSteps.ingresarBtnMeterPlataMH();
	}

	@When("^Ingreso a la opción de meter plata 'Desde cualquier banco'$")
	public void ingresoALaOpciónMeterPlataDesdeCualquierBanco() throws Exception {
		meterPlataSteps.clicBotonMeterPlataDesdeCualquierBanco();
	}

	@When("^Valido formulario de datos para Meter plata$")
	public void validoFormularioDeDatosParaMeterPlata() throws Exception {
		meterPlataSteps.validarFormDatosMeterPlata();
	}

	@When("^Regreso a la opcion de donde quiero meter la plata$")
	public void regresoALaOpcionDeDondeQuieroMeterlaPlata() throws Exception {
		meterPlataSteps.regresarAOpcionDondeQuieroMeterPlata();
	}

	@When("^Ingreso a la opción de meter plata 'En efectivo'$")
	public void ingresoALaOpcionDeMeterPlataEnEfectivo() throws Exception {
		meterPlataSteps.ingresarAOpcionMeterPlataEnEfectivo();
	}

	@When("^Valido popUp informativo 'Cómo meter plata en efectivo' y botón 'Encontrar' activo$")
	public void validoPopUpInformativoComoMeterPlataEnEfectivoYBotonEncontrarActivo() throws Exception {
		meterPlataSteps.validarPopUpComoMeterPlataEnEfectivo();
	}

	@When("^Acepto informacion de popUp$")
	public void aceptoInformacionDePopUp() throws Exception {
		meterPlataSteps.aceptarInfoPopUp();
	}

	@When("^Valido pantalla del georeferenciador$")
	public void validoPantallaDelGeoreferenciador() throws Exception {
		meterPlataSteps.validarPantallaGeoreferenciador();
	}

	@When("^Acepto permisos georeferenciador'$")
	public void aceptoPermisosGeoreferenciador() throws Exception {
		meterPlataSteps.aceptarPermisosGeoreferenciador();
	}

	@When("^Regresar a la pantalla de donde quiere meter plata$")
	public void regresoALaPantallaDeDondeQuiereMeterPlata() throws Exception {
		meterPlataSteps.regresarAModuloDesdeDondeMeterPlata();
	}

	@When("^Valido los campos correspondientes del formulario$")
	public void validoLosCamposCorrespondientesDelFormulario() throws Exception {
		meterPlataSteps.validarFormDatosMeterPlata();
	}

	@When("^Ingreso Numero celular \"([^\"]*)\"$")
	public void ingresoNumeroCelular(String numCelular) {
		meterPlataSteps.ingresarNumCel(numCelular);
	}
	
	@When("^c\"([^\"]*)\"$")
	public void ingresoNumeroCelularPorTeclado(String numCelular) {
		meterPlataSteps.ingresarNumeroCelularPorTeclado(numCelular);
	}

	@When("^Valido longitud del numero ingresado$")
	public void validoLongitudDelNumeroIngresado() throws Exception {
		meterPlataSteps.validarLongitudNumeroCelular();
	}

	@When("^Valido que solo permita carácteres numéricos$")
	public void validoQueSoloPermitaCaracteresNumericos() throws Exception {
		meterPlataSteps.validarSoloPermitidoCaracateresNumericos();
	}

	@When("^Limpio campo del número ingresado$")
	public void limpioCampoDelNumeroIngresado() throws Exception {
		meterPlataSteps.limpiarCampoNumIngresado();
	}

	@When("^Ingreso número celular diferente de tres \"([^\"]*)\"$")
	public void ingresoNumeroCelularDiferenteDeTres(String numCelularDiferenteTres) {
		meterPlataSteps.ingresarNumCelDiferenteDeTres(numCelularDiferenteTres);
	}

	@When("^Valido que solo permita ingresar números que solo inician en tres$")
	public void validoQueSoloPermitaIngresarNumerosQueSoloInicianEnTres() throws Exception {
		meterPlataSteps.validarNumIngresadoEmpiezaEnTres();
	}

	@When("^Ingreso Número celular \"([^\"]*)\"$")
	public void ingresoNumCelular(String numCelular) {
		meterPlataSteps.ingresarNumCel(numCelular);
	}

	@When("^Ingreso confirmación de número celular \"([^\"]*)\"$")
	public void ingresoConfirmacionDeNumCelular(String confirmarNumCelularEspecial) {
		meterPlataSteps.confirmarNumCelEspecial(confirmarNumCelularEspecial);
	}
	
	@When("^Ingreso confirmación de número celular por teclado \"([^\"]*)\"$")
	public void ingresoConfirmacionDeNumCelularPorTeclado(String confirmarNumCelularEspecial) {
		meterPlataSteps.confirmarNumeroCelularConfirmacion(confirmarNumCelularEspecial);
	}

	@When("^Valido longitud de la confirmacion del numero celular ingresado$")
	public void validoLongitudDeLaConfirmacionDelNumeroCelularIngresado() throws Exception {
		meterPlataSteps.validarLongitudNumeroCelularConfirmacion();
	}

	@When("^Valido que solo permita caracteres numericos en la confirmacion del numero celular$")
	public void validoQueSoloPermitaCaracteresNumericosEnLaConfirmacionDelNumeroCelular() throws Exception {
		meterPlataSteps.validarSoloPermitidoCaracateresNumericosConfirmacionCel();
	}

	@When("^Ingreso confirmacion de numero celular \"([^\"]*)\"$")
	public void ingresoConfirmacionDeNumeroCelular(String numCelularConfirmacionDiferenteTres) {
		meterPlataSteps.ingresarNumCelConfirmacionDiferenteDeTres(numCelularConfirmacionDiferenteTres);
	}

	@When("^Valido que al confirmar el numero solo permita numeros que inicien en tres$")
	public void validoQueAlConfirmarElNumeroSoloPermitaNumerosQueInicienEnTres() throws Exception {
		meterPlataSteps.validarNumCelConfirmaciónEmpieceEnTres();
	}

	@When("^Validar opciones 'Desde cualquier banco' y 'En efectivo'$")
	public void validarOpcionesDesdeCualquierBancoYEnEfectivo() throws Exception {
		meterPlataSteps.validarOpcionesMeterPlata();
	}

	@When("^Limpio campo del número de confirmacion ingresado$")
	public void limpioCampoDelNumeroDeConfirmacionIngresado() throws Exception {
		meterPlataSteps.limpiarCampoNumIngresadoConfirmacion();
	}

	@When("^Ingreso numero celular propio del usuario$")
	public void ingresoNumeroCelularPropioDelUsuario() throws Exception {
		meterPlataSteps.limpiarCampoNumIngresadoConfirmacion();
	}

	@When("^Ingreso confirmacion de numero celular consultado en redeban$")
	public void ingresoConfirmacionDeNumeroCelularConsultadoEnRedeban() throws Exception {
		meterPlataSteps.ingresarConfirmacionNumeroConsultadoDesdeRedeban();
	}

	@Then("^Valido mensaje cuando los numeros ingresados no coinciden$")
	public void validoMensajeCuandoLosNumerosIngresadosNoCoinciden() throws Exception {
		meterPlataSteps.validarMensajeNoCoincidenNumeros();
	}

	@Given("^Ingreso monto \"([^\"]*)\"$")
	public void ingresarMonto(String monto) throws Exception {
		meterPlataSteps.ingresarMontoFormulario(monto);
	}

	@Given("^Despliego la lista de los bancos$")
	public void diegoLaListaDeLosBancos() throws Exception {
		meterPlataSteps.desplegarListaBancos();
	}
	
	
	@Given("Ingreso confirmacion de numero celular destino \"([^\"]*)\"$")
	public void ingresoConfirmacionDeNumeroCelularDestino() throws Exception {
		meterPlataSteps.confirmoNumeroCel();
	}

	@When("^Valido que el campo controle el monto maximo y minimo al meter plata$")
	public void validoQueElCampoControleElMontoMaximoMinimoAlMeterPlata() throws Exception {
		meterPlataSteps.validarValorMaximoMinimo();
	}

	@When("^Validar puntos decimales en el campo y longitud de nueve$")
	public void validarPuntosDecimalesEnElCampo() throws Exception {
		meterPlataSteps.validarPuntosDecimalesYLongitud();
	}

	@When("^Desplegar la lista de los bancos$")
	public void desplegarLaListaDeLosBancos() throws Exception {
		meterPlataSteps.hacerClicEnElBotonSeleccionarBancos();
	}

	@Then("^Validar lista de bancos habilitados para la transacción$")
	public void validarListaDeBancosHabilitadosParaLaTransaccion() throws Exception {
		meterPlataSteps.validarListaDeBancos();
	}

	@Then("^Valido que no este presente el banco davivienda y la opcion daviplata$")
	public void validoQueNoEstePresenteElBancoDaviviendaYLaOpcionDaviplata() throws Exception {
		meterPlataSteps.validarListaBancosNoEsteDaviplataYDavivienda();
	}

	@When("^Ingreso caracteres alfanumericos en el campo de correo \"([^\"]*)\"$")
	public void ingresoCaracteresAlfanumericosEnElCampoDeCorreo(String correo) throws Exception {
		meterPlataSteps.ingresarCorreoPse(correo);
	}

	@Then("^Validar que el campo de correo contenga caracteres alfanumericos$")
	public void validarQueElCampoDeCorreoContengaCaracteresAlfanumericos() throws Exception {
		meterPlataSteps.validarCorreoContengaCaracteresAlfanumericos();
	}

	@Given("^Ingreso a la opción 'Desde cuentas Davivienda' en el módulo meter plata$")
	public void ingresoALaOpciónDesdeCuentasDaviviendaEnElMóduloMeterPlata() {
		meterPlataSteps.ingresoOpcionDesdeCuentasDavivienda();
	}

	@Given("^Valido que el correo en la transacción este precargado$")
	public void validoQueElCorreoEnLaTransacciónEstePrecargado() {
		meterPlataSteps.extraerCorreoPrecargadoYValidarlo();
	}

	@Given("^Edito correo de transaccion \"([^\"]*)\"$")
	public void editoCorreoDeTransaccion(String correo) {
		meterPlataSteps.editarCorreoDeTransaccion(correo);
	}
	
	@Given("^Edito número celular$")
	public void editoCorreoDeTransaccion() {
		meterPlataSteps.borrarEIngresarNumCel();
	}

	@Given("^Validar correo nuevo ingresado$")
	public void validarCorreoNuevoIngresado() {
		meterPlataSteps.validarCorreoNuevoIngresado();
	}

	@Given("^Ingreso monto a recargar en el daviplata \"([^\"]*)\"$")
	public void ingresoMontoARecargarEnElDaviplata(String monto) {
		meterPlataSteps.ingresarMontoARecargar(monto);
	}

	@Given("^Doy clic en el botón continuar$")
	public void doyClicEnElBotónContinuar() {
		meterPlataSteps.clicBotonContinuar();
	}

	@Given("^Valido Pantalla de verificar informacion ingresada$")
	public void validoPantallaDeVerificarInformacionIngresada() {
		meterPlataSteps.validarPantallaInformacionIngresada();
	}
	
	@Given("^Doy clic en el botón continuar información ingresada$")
	public void doyClicEnElBotónContinuarInformacionIngresada() {
		meterPlataSteps.clicBotonContinuarVerificarInfo();
	}
	
	@Given("^Hacer clic en el botón atras$")
	public void hacerClicEnElBotónAtras() {
		meterPlataSteps.clicEnElBotonAtras();
	}

	@Given("^Valido Pantalla anterior del formulario$")
	public void validoPantallaAnteriorDelFormulario() {
		meterPlataSteps.validarPantallaPse();
	}

	@Given("^Valido boton necesito ayuda$")
	public void validoBotonNecesitoAyuda() {
		meterPlataSteps.validoBotonNecesitoAyuda();
	}

	@Then("^Validar las funciones del popUp salir de la app$")
	public void validarLasFuncionesDelPopUpSalirDeLaApp() {
		meterPlataSteps.validoFuncionalidadesCancelarAceptarSalirDeLaApp();
	}

	@When("^Escojo la opción banco \"([^\"]*)\"$")
	public void escojoLaOpcionBancoUniónColombiano(String banco) throws Exception {
		meterPlataSteps.escojoOpcionBancoUnionColombiano(banco);
	}

	@When("^Doy clic en el boton continuar del formulario desde otros bancos$")
	public void doyClicEnElBotonContinuarDelFormularioDesdeOtrosBancos() throws Exception {
		meterPlataSteps.clicContinuarFormularioOtrosBancos();
	}
	
	@When("^Valido transaccion exitosa$")
	public void validoTransaccionExitosa() throws Exception {
		meterPlataSteps.validarTransaccionExitosa();
	}

	@Given("^Verifico que el costo de la transaccion sea cero$")
	public void verificoQueElCostoDeLaTransaccionSeaCero() {
		meterPlataSteps.validarCostoTransaccionCero();
		meterPlataSteps.clicBotonMeterPlataDesdeVerifiqueInformacion();
	}

	@Given("^Lleno información del sample en pse$")
	public void llenoInformaciónDelSampleEnPse() {
		meterPlataSteps.aceptarTerminosYCondiciones();
		meterPlataSteps.llenarFormularioSamplePse();
	}

	@When("^Valido información de la transaccion del meter plata$")
	public void validoInformaciónDeLaTransaccionDelMeterPlata() {
		meterPlataSteps.validarTransaccion();
		meterPlataSteps.validarInformacionDeLaTransaccion();
	}

	@Given("^Doy clic en boton finalizar$")
	public void doyClicEnBotonFinalizar() {
		meterPlataSteps.hacerClicBotonFinalizar();
	}

	@Then("^Validar Saldo Final$")
	public void validarSaldoFinal() {
		stepsPasarPlata.verificarSaldos();
	}
	
	@Then("^Validar mensaje de transacción no exitosa$")
    public void validarMensajeDeTransaccionNoExitosa() throws Exception {
        meterPlataSteps.validarMensajeRecargaNoExitosa();
    }
	
	@Then("^Validar que permita pegar la información númerica$")
    public void validarQuePermitaPegarLaInformaciónNumerica() throws Exception {
		
    }
	
	@When("^Doy clic en el boton continuar de informacion en recarga$")
    public void doyClicEnElBotonContinuarDeInformacionEnRecarga() throws Exception {
        meterPlataSteps.clicBotonContinuarInformacionTransaccion();
    }
    
	@Then("^Validar mensaje de recarga del daviplata$")
    public void validarMensajeDeRecargaDelDaviplata() throws Exception {
        meterPlataSteps.validarMensajeDeRecargaDaviplata();
    }
	
	@Then("^Validar mensaje de numero de usuario invalido$")
    public void validarMensajeDeNumeroDeUsuarioInvalido() throws Exception {
        meterPlataSteps.validarMensajeUsuarioNumeroInvalido();
    }
}
