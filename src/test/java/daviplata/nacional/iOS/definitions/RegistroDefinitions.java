package daviplata.nacional.iOS.definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import daviplata.nacional.iOS.pageObjects.LoginRobustoPage;
import daviplata.nacional.iOS.steps.LoginSteps;
import daviplata.nacional.iOS.steps.RegistroMayoresSteps;
import daviplata.nacional.iOS.steps.RegistroSteps;
import daviplata.nacional.iOS.utilidades.Utilidades;
import daviplata.nacional.iOS.utilidades.UtilidadesTCS;
import net.thucydides.core.annotations.Steps;

public class RegistroDefinitions {

	@Steps
	LoginSteps stepsLogin;
	@Steps
	RegistroSteps stepsRegistro;
	
	@Steps 
	RegistroMayoresSteps registroMayoresSteps;
	
	UtilidadesTCS utilidadesTCS;
	Utilidades utilidades;
	LoginRobustoPage loginRobustoPage; 

	@When("^completo formulario mis datos \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void completoFormularioMisDatos(String nombre, String numDoc, String lugar, String cel, String correo)
			throws Exception {
		stepsRegistro.ingresarMisDatos(nombre, numDoc, lugar, cel, correo);
	}
	
	@When("^ingreso a latinia en busca de la otp$")
	public void ingresoALatiniaEnBuscaDeLaOtp() throws Exception {
		stepsLogin.ingresarLatiniaRegistro();
	}
	
	@When("^ingreso otp$")
	public void ingresoOtp() throws Exception {
		stepsLogin.ingresoOtp();
	}
	@When("^ingreso otp invalida$")
	public void ingresoOtpInvalida() throws Exception {
		stepsLogin.ingresoOtpInvalida();
	}
	
	@When("^acepto terminos$")
	public void aceptoTerminos() throws Exception {
	    stepsRegistro.aceptarTerminos();
	    
	}

	@When("^ingreso contrasena \"([^\"]*)\"$")
	public void ingresoContrasena(String clave) throws Exception {
	   stepsRegistro.ingresarClave(clave);
	}

	@Then("^completo el flujo restante$")
	public void completoElFlujoRestante() throws Exception {
	   stepsRegistro.completarFlujo();
	}

	@Then("^valido ingreso a Daviplata$")
	public void validoIngresoADaviplata() throws Exception {
	    stepsRegistro.validoIngreso();
	}
	
	@When("^ingreso la opt invalida$")
	public void ingresoLaOptInvalida() throws Exception {
	    stepsRegistro.ingresoOtpInvalida();
	}

	
	@When("^ingreso contrasena invalidas \"([^\"]*)\"$")
	public void ingresoContrasenaInvalidas(String clave) throws Exception {
	    stepsRegistro.ingresoClaveInvalida(clave);
	}
	
	@When("^Acepte autorizaciones de regitro$")
	public void aceptoAutorizacionesRegitro() throws Exception {
	    stepsRegistro.aceptoAutorizaciones();
	    
	}
	
	@When("^completo formulario mis datos \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void completoFormularioMisDatos(String nombre, String dia, String mes, String año, String diaExpedicion, String mesExpedicion, String anioExpedicion, String lugar, String cel, String correo)
			throws Exception {
		stepsRegistro.ingresarMisDatos(nombre, dia, mes, año, diaExpedicion, mesExpedicion, anioExpedicion, lugar, cel, correo);
	}
	
    @Then("^Acepto autorizacion de regitro$")
	public void aceptoAutorizacionDeRegistro() throws Exception {
		stepsRegistro.aceptarAutorizacion();
	}
	
	@Then("^validar registro completo$")
	public void validarRegistroCompleto() throws Exception {
		stepsRegistro.validarRegistro();
	}
	
	@Then("^valido el mensaje de otp invalida$")
	public void validoEnMensajeDeOtpInvalida() throws Exception {
	    stepsRegistro.validoOtpInvalida();
	}
	
	@When("^ingreso contrasena invalidas \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoContrasenaInvalidas(String clave, String claveErronea) throws Exception {
	    stepsRegistro.ingresoClaveInvalida(clave, claveErronea);
	}

	@Then("^Valido contrasena invalida$")
	public void validoContrasenaInvalidas() throws Exception {
	    stepsRegistro.validoClaveInvalida();
	}

	@Then("Valido mensaje de bienvenida")
	public void validoMensajeDeBienvenida() throws Exception {
		registroMayoresSteps.validarMensajeBienvenida();
	}
	
	@Then("^Validar pop up de funcionalidad de negocio no disponible$")
    public void validarPopUpDeFuncionalidadDeNegocioNoDisponible() throws Exception {
        registroMayoresSteps.validarPopUpFuncionalidadNegocioNoDisponible();
    }
	
	@Given("^ingreso tipo y numero de documento \"([^\"])\" \"([^\"])\"$")
    public void ingresoTipoYNumeroDeDocumento(String tipoId, String usuario) throws Exception {
		stepsLogin.verificarVersion();
        utilidadesTCS.seleccionarTipoDocumentoInputHomeDaviplata("xpath",tipoId);
        utilidadesTCS.writeElement("xpath", LoginRobustoPage.CAMPO_NUMERO_DOCUMENTO, usuario);
        Utilidades.tomaEvidencia("Diligencio tipo de documento y número a registrar");
        utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_INGRESAR);    
    }
	
	@Given("^Hice clic en el boton de registrarme$")
    public void hiceClicEnElBotonDeRegistrarme() throws Exception {
        registroMayoresSteps.hacerClicBotonRegistrarmePopUpRegistro();
    }
	
	@When("^Ingresar a mis beneficios en negocio$")
    public void ingresarAMisBeneficiosEnNegocio() throws Exception {
        registroMayoresSteps.ingresarABeneficiosMiNegocioDesdeRegistro();
    }
	
	@When("^Valido pantalla de beneficios mi negocio$")
    public void validoPantallaDeBeneficiosMiNegocio() throws Exception {
        registroMayoresSteps.validarPantallaMisBeneficios();
    }
	
	@When("^Hago scroll hasta el final de la pantalla$")
    public void hagoScrollHastaElFinalDeLaPantalla() throws Exception {
        registroMayoresSteps.hacerScrollHastaElFinalDeLaPantalla();
    }
	
	@When("^Me devuelvo al home de daviplata desde el boton usar mi daviplata$")
    public void meDevuelvoAlHomeDeDaviplataDesdeElBotonUsarMiDaviplata() throws Exception {
        registroMayoresSteps.hacerClicAlBotonUsarMiDaviplata();
    }
	
	@When("^Doy clic en el boton de mi negocio para ingresar a perfil negocio$")
    public void ingresoAPerfilNegocioParaValidarFuncionalidadDelBoton() throws Exception {
        registroMayoresSteps.ingresarAPerfilNegocio();
    }
	
	@When("^Marco check de terminos y condiciones$")
    public void marcoCheckDeTerminosYCondiciones() throws Exception {
        registroMayoresSteps.marcarCheckTerminosYCondiciones();
    }
	
	@When("^Valido ingreso a formulario mi negocio$")
    public void validoIngresoAFormularioMiNegocio() throws Exception {
        registroMayoresSteps.validoIngresoAFormularioMiNegocio();
    }
	
	@When("^Lleno formulario creacion de negocio \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void llenoFormularioCreacionDeNegocio(String nombre, String queVende, String monto, String ciudadNegocio, String tipoInmueble, String correo) throws Exception {
        registroMayoresSteps.llenarFormularioRegistroNegocio(nombre, queVende, monto, ciudadNegocio, tipoInmueble, correo);
    }
	
	@When("^Finalizo proceso de creacion de negocio$")
    public void finalizoProcesoDeCreacionDeNegocio() throws Exception {
        registroMayoresSteps.finalizarCreacionNegocio();
    }
	
}
