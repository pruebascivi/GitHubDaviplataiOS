package daviplata.nacional.iOS.definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import daviplata.nacional.iOS.steps.PreguntasFrecuentesSteps;
import net.thucydides.core.annotations.Steps;

public class PreguntasFrecuentesDefinitions {
	
	@Steps
	PreguntasFrecuentesSteps preguntasFrecuentesSteps;
	
	@Given("^Ingresé al botón necesito ayuda$")
    public void ingreséAlBotónNecesitoAyuda() throws Exception {
        preguntasFrecuentesSteps.ingresarAlBotonNecesitoAyuda();
    }
	
	@Then("^Valido seccion de necesito ayuda en otra ventana$")
    public void validoSeccionDeNecesitoAyudaEnOtraVentana() throws Exception {
        preguntasFrecuentesSteps.validarPantallaNecesitoAyuda();
    }
	
	@When("^Ingreso credenciales para la solicitud \"([^\"]*)\"\"([^\"]*)\"$")
	public void ingresoCredencialesParaLaSolicitud(String tipoDocumento, String numDocumento) {
		preguntasFrecuentesSteps.ingresarCredenciales(tipoDocumento,numDocumento);
	}
	
	@When("^Acepto terminos y condiciones antes de ingresar al modulo necesito ayuda$")
	public void aceptoTerminosYCondicionesAntesDeIngresarAlModuloNecesitoAyuda() {
		preguntasFrecuentesSteps.aceptarTerminosCondiciones();

	}
	
	@When("^Doy clic en el botón continuar para ingresar al modulo necesito ayuda$")
	public void doyClicEnElBotónContinuarParaIngresarAlModuloNecesitoAyuda() {
		preguntasFrecuentesSteps.clicEnBotonContinuar();
	}
	
	@When("^Hago clic en el campo de busqueda de la consulta$")
	public void hagoClicEnElCampoDeBusquedaDeLaConsulta() {
		preguntasFrecuentesSteps.hacerClicInputConsulta();

	}
	
	@Then("^Valido el teclado desplegado$")
    public void validoElTecladoDesplegado() throws Exception {
        preguntasFrecuentesSteps.validarTecladoDesplegado();
    }
	
	@Then("^Valido busqueda barra de busqueda$")
    public void validoBusquedaPorVoz() throws Exception {
        preguntasFrecuentesSteps.validoConsultaBarraBusqueda();
    }
	
	@When("^Ingreso la pregunta formulada en el campo de consultas \"([^\"]*)\"$")
    public void ingresoYSeleccionoLaPreguntaFormuladaEnElCampoDeConsultas(String pregunta) throws Exception {
        preguntasFrecuentesSteps.ingresarPreguntaYSeleccionarla(pregunta);
    }
	
	@When("^Valido la cantidad de resultados en la busqueda$")
    public void validoLaCantidadDeResultadosEnLaBusqueda() throws Exception {
        preguntasFrecuentesSteps.validarCantidadResultadosEnBusqueda();
    }
	
	@When("^Selecciono el resultado de la busqueda$")
    public void seleccionoElResultadoDeLaBusqueda() throws Exception {
        preguntasFrecuentesSteps.seleccionarElResultadoDeLaBusqueda();
    }
	
	@When("^Valido resultados de la consulta$")
    public void validoResultadosDeLaConsulta() throws Exception {
        preguntasFrecuentesSteps.validarResultadosBusqueda();
        preguntasFrecuentesSteps.validarOcultarTecladoDesplegado();
    }
	
	@When("^Valido resultados de preguntas con video embebidos en la Webview$")
    public void validoResultadosDePreguntasConVideoEmbebidosEnLaWebview() throws Exception {
        preguntasFrecuentesSteps.validarVideoEmbebido();
    }
	
	@When("^Doy clic en el boton devolver$")
    public void doyClicEnElBotonDevolver() throws Exception {
        preguntasFrecuentesSteps.darClicBotonVolver();
    }
	
	@When("^Ingreso numeros y caracteres especiales \"([^\"]*)\"$")
    public void ingresoNumerosYCaracteresEspeciales(String textoNumerosCaracteresEspeciales) throws Exception {
        preguntasFrecuentesSteps.ingresarNumerosCaracteresEspeciales(textoNumerosCaracteresEspeciales);
    }
	
	@Then("^Valido que se permita el ingreso de numeros y caracteres especiales$")
    public void ValidoQueSePermitaElIngresoDeNumerosYCaracteresEspeciales() throws Exception {
        preguntasFrecuentesSteps.validarNumerosCaracteresEspecialesBarraBusqueda();
    }
	
	@When("^Limpiar campo de busqueda$")
    public void limpiarCampoDeBusqueda() throws Exception {
        preguntasFrecuentesSteps.limpiarCampoDeBusquedaConsultas();
    }
	
	@Then("^Valido que al no haber coincidencias el texto se mantenga$")
    public void validoQueAlNoHaberCoincidenciasElTextoSeMantenga() throws Exception {
        preguntasFrecuentesSteps.validarTextoSeMantengaAlNoEncontrarCoincidencias();
    }
	
	@When("^Espero carga de la respuesta$")
    public void esperoCargaDeLaRespuesta() throws Exception {
        preguntasFrecuentesSteps.esperarCargaRespuestaConsulta();
    }
	
	@Then("^Valido scroll en respuestas largas$")
    public void validoScrollEnRespuestasLargas() throws Exception {
        preguntasFrecuentesSteps.validoHacerScrollRespuestasLargas();
    }
	
	@Then("^Valido el boton chat con asesor en encuestas de resolucion$")
    public void validoElBotonChatConAsesorEnEncuestasDeResolucion() throws Exception {
        preguntasFrecuentesSteps.validoChatConAsesor();
    }
	
	@When("^Doy clic en el boton devolver sin pop up de encuesta$")
    public void doyClicEnElBotonDevolverSinPopUpDeEncuesta() throws Exception {
        preguntasFrecuentesSteps.darClicBotonVolverSinEncuesta();
    }
	
	@Then("^Valido casos de procesos de autogestion$")
    public void validoCasosDeProcesosDeAutogestion() throws Exception {
        preguntasFrecuentesSteps.validoRespuestasDeAutogestion();
    }
	
	@When("^Selecciono opcion dos de los resultados de la encuesta$")
	public void seleccionoOpcionDosDeLosResultadosDeLaEncuesta() throws Exception {
		preguntasFrecuentesSteps.seleccionarSegundaOpcionResultados();
	}
	
	@Then("^Valido desplazamiento vertical para respuestas con video embebido$")
	public void validoDesplazamientoVerticalParaRespuestasConVideoEmbebido() throws Exception {
		preguntasFrecuentesSteps.validoHacerScrollRespuestasLargasVideosEmbebidos();
	}
	
	@When("^Me desplazo hasta la encuesta$")
	public void MeDesplazoHastaLaEncuesta() throws Exception {
		preguntasFrecuentesSteps.desplazarseHastaLaEncuesta();
	}
	
	@When("^Califico respuesta de la consulta$")
	public void calificRespuestaDeLaConsulta() throws Exception {
		preguntasFrecuentesSteps.calificarEncuesta();
	}
	
	@Then("^Valido resultado de la encuesta$")
	public void validoResultadoDeLaEncuesta() throws Exception {
		preguntasFrecuentesSteps.validarResultadoDeEncuestaCalificada();
	}
	
	@Then("^Validar encuesta sin resolver despues de ingresar nuevamente$")
	public void validarEncuestaSinResolverDespuesDeIngresarNuevamente() throws Exception {
		preguntasFrecuentesSteps.validarEncuestaSinResolver();
	}
	
	@When("^Hago scroll hacia arriba$")
	public void hacerScrollHaciaArriba() throws Exception {
		preguntasFrecuentesSteps.hacerUnScrollHaciaArribaEnBarraDeBusqueda();
	}

}
