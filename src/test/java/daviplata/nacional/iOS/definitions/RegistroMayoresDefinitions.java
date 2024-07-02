package daviplata.nacional.iOS.definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import daviplata.nacional.iOS.steps.LoginSteps;
import daviplata.nacional.iOS.steps.RegistroMayoresSteps;
import net.thucydides.core.annotations.Steps;

public class RegistroMayoresDefinitions {
	
	@Steps
	RegistroMayoresSteps registroMayoresSteps;
	@Steps
	LoginSteps loginSteps;

	@Given("^Validar mover el boton que permita desplazarse por toda la pantalla segun la comodidad del usuario$")
	public void validarMoverElBotonQuePermitaDesplasarcePorTodaLaPantallaSegunLaComodidadDelUsuario() throws Exception {
		registroMayoresSteps.validarMoverElBotonNecesitoAyudaAVariasZonasDeLaPantalla();
	}
    
	@When("^Valido que los botones back cerrar o necesito ayuda no esten presentes en la pantalla de bienvenidos$")
	public void validoQueLosBotonesBackCerrarONecesitoAyudaNoEstenPresentesEnLaPantallaDeBienvenidos() throws Exception {
		registroMayoresSteps.validarQueEnLaPantallaBienvenidaNoEsteBotonNecesitoAyuda();
	}
	
	@When("^Hago clic en el boton ya tengo daviplata$")
	public void hagoClicEnElBotonYaTengoDaviplata() throws Exception {
		registroMayoresSteps.clicBotonYaTengoDaviplata();
	}
	
	@When("^Valido pantalla de login de ingreso al daviplata$")
	public void validoPantallaDeLoginDeIngresoAlDaviplata() throws Exception {
		registroMayoresSteps.validarPantallaDeLogin();
	}
	
	@When("^Valido la flecha para seleccionar el tipo de documento$")
	public void validoLaFlechaParaSeleccionarElTipoDeDocumento() throws Exception {
		registroMayoresSteps.validarFlechaTipoDocumento();
	}
	
	@When("^Valido marca de agua en el input de documento$")
	public void validoMarcaDeAguaEnElInputDeDocumento() throws Exception {
		registroMayoresSteps.validarMarcaDeAguaInputNumeroDocumento();
	}
	
	@Given("^Selecciono tipo de documento \"([^\"]*)\"$")
	public void seleccionoTipoDeDocumento(String tipoID) throws Exception {
		registroMayoresSteps.escogerTipoDocumento(tipoID);
	}
	
	@Given("^Ingreso numero de documento \"([^\"]*)\"$")
	public void ingresoNumeroDeDocumento(String numDocumento) throws Exception {
		registroMayoresSteps.ingresarNumeroDocumento(numDocumento);
	}

	
	@Given("^Valido longitud de los cinco digitos$")
	public void ValidoLongitudDeLosCincoDigitos() throws Exception {
		registroMayoresSteps.validarLongitudDeCincoDigitos();
	}
	
	@Given("^Limpio el campo de numero de documento$")
	public void limpioElCampoDeNumeroDeDocumento() throws Exception {
		registroMayoresSteps.limpiarCampoNumeroDocumento();
	}
	
	@When("^Valido longitud de los diez y seis digitos$")
	public void ValidoLongitudDeLosDiezYSeisDigitos() throws Exception {
		registroMayoresSteps.validarLongitudDeDiezYSeisDigitos();
	}
	
	@When("^Doy clic en el boton ingresar$")
	public void doyClicEnElBotonIngresar() throws Exception {
		registroMayoresSteps.hacerClicEnElBotonIngresarDelLogin();
	}

	@When("^Valido popup de registro nuevo en daviplata$")
	public void validoPopupDeRegistroNuevoEnDaviplata() throws Exception {
		registroMayoresSteps.validarPopUpRegistroUsuarioNuevo();
	}
	
	@When("^Valido botones cancelar y registrarme del pop up de registro$")
	public void validoBotonesCancelarYRegistrarmeDelPopUpDeRegistros() throws Exception {
		registroMayoresSteps.validarBotonesEnPopUp();
	}
	
	@When("^Valido funcionalidades de los botones cancelar y registrarme del pop up de registro$")
	public void validoFuncionalidadesDeLosBotonesCancelarYRegistrarme() throws Exception {
		registroMayoresSteps.validarFuncionalidadesDeBotonesEnPopUp();
	}
	
	@When("^Doy clic en el boton atras hasta la pantalla de Bienvenidos$")
	public void doyClicEnElBotonAtrasHastaLaPantallaDeBienvenidos() throws Exception {
		registroMayoresSteps.regresarHastaElHomeBienvenidos();
	}
	
	@When("^Valido que al dar clic en el boton registrarme direccione a la pantalla ingrese sus datos \"([^\"]*)\" \"([^\"]*)\"$")
	public void validoQueAlDarClicEnElBotonRegistrarmeDireccioneALaPantallaIngreseSusDatos(String numDocumento, String tipoID) throws Exception {
		registroMayoresSteps.validarPantallaIngreseSusDatosDesdeElBotonRegistrarme(numDocumento, tipoID);
	}
	
	@When("^Hago clic en el boton Registrarme$")
	public void hagoClicEnElBotonRegistrarme() throws Exception {
		registroMayoresSteps.hacerClicEnElBotonRegistrarme();
	}
	
	@When("^Doy clic en el boton continuar$")
	public void doyClicEnElBotonContinuar() throws Exception {
		registroMayoresSteps.hacerClicEnElBotonContinuar();
	}
	
	@When("^Doy clic en el boton finalizar$")
	public void doyClicEnElBotonFinalizar() throws Exception {
		registroMayoresSteps.hacerClicEnElBotonFinalizar();
	}
	
	@When("^Valido pop up del usuario previamente registrado$")
	public void validoPopUpDelUsuarioPreviamenteRegistrado() throws Exception {
		registroMayoresSteps.validarPopUpUsuarioExistente();
	}
	
	@When("^Valido que en el pop-up esten presentes los botones Cancelar e Ingresar$")
	public void validoQueEnElPopUpEstenPresentesLosBotonesCancelarEIngresar() throws Exception {
		registroMayoresSteps.validarBotonesCancelarIngresar();
	}
	
	@When("^Valido que al dar tap en el botón Cancelar debe dejar en la pantalla Cree su DaviPlata$")
	public void validoQueAlDarTapEnElBotonCancelarDebeDejarEnLaPantallaCreeSuDaviPlata() throws Exception {
		registroMayoresSteps.validarFuncionalidadBtnCancelar();
	}
	
	@When("^Valido que al dar tap en el botón Ingresar debe dejar en la pantalla Ingrese a su DaviPlata$")
	public void validoQueAlDarTapEnElBotonIngresarDebeDejarEnLaPantallaIngreseASuDaviPlata() throws Exception {
		registroMayoresSteps.validarFuncionalidadBtnIngresar();
	}
	
	@When("^Valido presencia del boton 3 puntos$")
	public void validoPresenciaDelBoton3Puntos() throws Exception {
		registroMayoresSteps.validarPresenciaBtn3Puntos();
	}
	
	@When("^Valido opciones del boton 3 puntos$")
	public void validoOpcionesDelBtn3Puntos() throws Exception {
		registroMayoresSteps.validarOpcionesDelBtn3Puntos();
	}
	
	@Given("^Ingrese tipo de documento y usuario \"([^\"]*)\"\"([^\"]*)\"$")
    public void ingreseTipoDeDocumentoYUsuario(String tipoDocumento, String usuario) {
        loginSteps.ingresarTipoDocumentoYUsuario(tipoDocumento, usuario);
    }
	
	@When("^Realizo proceso de registro \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void realizoProcesoDeRegistro(String usuario, String nombreUsuario, String numCelular, String correo, String claveNueva) throws Exception {
        registroMayoresSteps.realizarRegistroCedulaExtranjeria(usuario, nombreUsuario,numCelular,correo);
        registroMayoresSteps.ingresoOtp();
        registroMayoresSteps.aceptarTerminosCondicionesRegistroCedulaExtranjeria();
        registroMayoresSteps.crearClaveRegistroRegistroCedulaExtranjeria(claveNueva);
    }
	
	@Then("^Validar si el registro es exitoso o no$")
    public void validarSiElRegistroEsExitosoONo() throws Exception {
        registroMayoresSteps.validarRegistroExitosoNoExitoso();
    }
	
	@When("^Acepto autorizacion de registro$")
    public void aceptoAutorizacionDeRegistro() throws Exception {
        registroMayoresSteps.aceptarAutorizaciones();
    }
	
	@When("^Realizo validaciones de campos dentro del formulario \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void realizoValidacionesDeCamposDentroDelFormulario(String nombreUsuario,String numCelular, String correo) throws Exception {
        registroMayoresSteps.procesoValidacionFormulario(nombreUsuario,numCelular,correo);
    }
	
	@Then("^Doy clic en el boton atras$")
    public void doyClicEnElBotonAtras() throws Exception {
        registroMayoresSteps.hacerClicEnElBotonAtras();
    }
	
	@When("^Realizo diligenciamento completo del formulario \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void realizoDiligenciamentoCompletoDelFormulario(String nombreUsuario,String diaFechaNacimiento,String mesFechaNacimiento,String anioFechaNacimiento, String diaFechaExpedicion,String mesFechaExpedicion,String anioFechaExpedicion,String numCelular,String correo) throws Exception {
        registroMayoresSteps.diligenciarFormularioCompleto(nombreUsuario,diaFechaNacimiento,mesFechaNacimiento,anioFechaNacimiento,diaFechaExpedicion,mesFechaExpedicion,anioFechaExpedicion,numCelular,correo);
    }
	
	@When("^Valido mensaje de error al llenar confirmacion de correo mal \"([^\"]*)\"\"([^\"]*)\"$")
    public void validoMensajeDeErrorAlLlenarConfirmacionDeCorreoMal(String confirmacionCorreoErroneo, String correo) throws Exception {
        registroMayoresSteps.validarConfirmacionCorreoErroneo(confirmacionCorreoErroneo,correo);
    }
	
	@When("^Hago clic en el boton continuar$")
    public void hagoClicEnElBotonContinuar() throws Exception {
        registroMayoresSteps.hacerClicBotonContinuarFormularioRegistro();
    }
	
	@Then("^Validar pantalla de otp$")
    public void validarPantallaDeOtp() throws Exception {
        registroMayoresSteps.validarPantallaOtpRegistro();
    }
	
	@Then("^Validar que al devolverse a la pantalla del formulario se puedan modificar los datos$")
    public void validarQueAlDevolverseALaPantallaDelFormularioSePuedanModificarLosDatos() throws Exception {
        registroMayoresSteps.validarSePuedanLlenarDatosDelFomularioAlDarClicEnBotonAtras();
    }
	
	@Then("Ingreso otp para terminar registro")
    public void ingresoOtpParaTerminarRegistro() throws Exception {
        registroMayoresSteps.ingresarOtpFinalRegistro();
    }
	
	@Then("^Creo la clave \"([^\"]*)\"$")
	public void creoClave(String clave) throws Exception {
        registroMayoresSteps.crearClave(clave);
	}
	
	@Then("^Dar clic en el boton editar$")
    public void darClicEnElBotonEditar() throws Exception {
        registroMayoresSteps.hacerClicEnElBotonLapiz();
    }
}
