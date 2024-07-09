package daviplata.nacional.iOS.steps;

import daviplata.nacional.iOS.pageObjects.LoginRobustoPage;
import daviplata.nacional.iOS.pageObjects.PreguntasFrecuentesPageObjects;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import daviplata.nacional.iOS.utilidades.Utilidades;
import daviplata.nacional.iOS.utilidades.UtilidadesTCS;
import net.thucydides.core.annotations.Step;

public class PreguntasFrecuentesSteps {
	
	UtilidadesTCS utilidadesTcs;
	
	@Step
	public void ingresarAlBotonNecesitoAyuda() {
		Utilidades.esperaMiliseg(4000);
        Utilidades.tomaEvidencia("Hacer clic en el boton necesito ayuda desde zona publica");
        utilidadesTcs.clicElement("xpath", PreguntasFrecuentesPageObjects.BOTON_NECESITO_AYUDA);
		utilidadesTcs.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
    }

	@Step
	public void validarPantallaNecesitoAyuda() {
		Utilidades.esperaMiliseg(4000);
        utilidadesTcs.esperarElementVisibility("xpath", PreguntasFrecuentesPageObjects.TEXTO_NECESITO_AYUDA);
        String texto = utilidadesTcs.obtenerTexto("xpath", PreguntasFrecuentesPageObjects.TEXTO_NECESITO_AYUDA);
        utilidadesTcs.validateTextContainsString(texto, "¿Necesita Ayuda?");
        Utilidades.tomaEvidencia("Validar pantalla Necesita Ayuda, desde Zona Pública en la App; deberá desplegarse una nueva pantalla con el titulo de la seccion 'Necesita ayuda'");
    }
	
	@Step
	public void ingresarCredenciales(String tipoDocumento, String numDocumento) {
		Utilidades.esperaMiliseg(6000);
		utilidadesTcs.esperarElementVisibility("xpath", PreguntasFrecuentesPageObjects.BOTON_DESPLEGAR_TIPO_DOCUMENTO);
		Utilidades.tomaEvidencia("Hago clic en el input seleccionar tipo de documento");
        utilidadesTcs.clicElement("xpath", PreguntasFrecuentesPageObjects.BOTON_DESPLEGAR_TIPO_DOCUMENTO);
        utilidadesTcs.seleccionarTipoDocumentoInput("xpath",tipoDocumento);
        utilidadesTcs.writeElement("xpath", PreguntasFrecuentesPageObjects.INPUT_NUMERO_DOCUMENTO, numDocumento);
        Utilidades.tomaEvidencia("Ingresar las credenciales para la consulta");
    }
	
	@Step
	public void aceptarTerminosCondiciones() {
        utilidadesTcs.clicElement("xpath", PreguntasFrecuentesPageObjects.BOTON_TERMINOS_CONDICIONES);
        Utilidades.tomaEvidencia("Aceptar terminos y condiciones");
    }
	
	@Step
	public void clicEnBotonContinuar() {
		Utilidades.tomaEvidencia("Dar clic en el botón continuar");
        utilidadesTcs.clicElement("xpath", PreguntasFrecuentesPageObjects.BOTON_CONTINUAR);
    }
	
	@Step
	public void hacerClicInputConsulta() {
		Utilidades.esperaMiliseg(4000);
        utilidadesTcs.esperarElementVisibility("xpath", PreguntasFrecuentesPageObjects.INPUT_ESCRIBIR_CONSULTA);    
        Utilidades.tomaEvidencia("Hacer clic en el campo de consulta");
        utilidadesTcs.clicElement("xpath", PreguntasFrecuentesPageObjects.INPUT_ESCRIBIR_CONSULTA);        
    }
	
	@Step
	public void validarTecladoDesplegado() {
		boolean estadoVisible = utilidadesTcs.validateElementVisibilityCatch("xpath", PreguntasFrecuentesPageObjects.POPUP_JOVENES_ACCION);
		if(estadoVisible == true) {
			Utilidades.tomaEvidencia("Cerrar pop up de amigos");
			Utilidades.esperaMiliseg(800);
			utilidadesTcs.clicElementAction("xpath", PreguntasFrecuentesPageObjects.CERRAR_POPUP_JOVENES_ACCION);
		}
		Utilidades.esperaMiliseg(800);
        utilidadesTcs.clicElement("xpath", PreguntasFrecuentesPageObjects.ESCRIBE_AQUI_CAMPO);        
		Utilidades.esperaMiliseg(1500);
		boolean estado = utilidadesTcs.validateElementVisibility("xpath", PreguntasFrecuentesPageObjects.TECLADO_IOS);
		utilidadesTcs.validateStatusElement(estado);
		Utilidades.tomaEvidencia("Validar que el teclado del usuario deberá siempre aparecer cuando se pulse en el campo de búsqueda");
    }
	
	@Step
	public void validoConsultaBarraBusqueda() {
        boolean estado = utilidadesTcs.validateElementVisibility("xpath", PreguntasFrecuentesPageObjects.INPUT_ESCRIBIR_CONSULTA);
        utilidadesTcs.validateStatusElement(estado);
        Utilidades.tomaEvidencia("Validar el campo Barra de Búsqueda para ejecutar una consulta por búsqueda de voz o texto");
    }
	
	@Step
	public void ingresarPreguntaYSeleccionarla(String pregunta) {
        utilidadesTcs.writeElement("xpath", PreguntasFrecuentesPageObjects.INPUT_ESCRIBIR_CONSULTA, pregunta);
        BaseUtil.tituloBusqueda = pregunta; 
        Utilidades.tomaEvidencia("Ingresar Pregunta en el campo de busqueda");
        
    }
	
	@Step
	public void validarCantidadResultadosEnBusqueda() {
        boolean estado = utilidadesTcs.validateQuantityOfElements("xpath", PreguntasFrecuentesPageObjects.LISTA_OBJETOS_BUSQUEDA,3);
        utilidadesTcs.validateStatusElement(estado);
        Utilidades.tomaEvidencia("Validar durante la digitación por parte del usuario, que al escribir las dos primeras palabras, se deberá ejecutar la primera búsqueda y mostrar los 3 resultados");
        
    }
	
	@Step
	public void seleccionarElResultadoDeLaBusqueda() {
		Utilidades.tomaEvidencia("Selecciono resultado de la bsuqueda");
        utilidadesTcs.clicElement("xpath", PreguntasFrecuentesPageObjects.OPCION_BUSQUEDA_CONSULTA);
    }
	
	@Step
	public void validarResultadosBusqueda() {
		Utilidades.esperaMiliseg(2000);
        String texto = utilidadesTcs.obtenerTextoAtributoName("xpath", utilidadesTcs.getTituloResultadoBusqueda());
        utilidadesTcs.validateTextContainsStringIgnoreUppercaseLowercase(texto, BaseUtil.tituloBusqueda);
        Utilidades.tomaEvidencia("Validar que permita la entrega de resultados de búsqueda de forma inmediata y de mayor coincidencia con su búsqueda");
        Utilidades.tomaEvidencia("Validar que al pulsar sobre una de las respuestas, deberá dirigirse a una nueva pantalla en la que se evidencie la respuesta completa a la consulta de la pregunta frecuente.");
        Utilidades.tomaEvidencia("Validar que en esta nueva pantalla NO se expondrá la barra de búsqueda.");
    }
	
	@Step
	public void validarOcultarTecladoDesplegado() {
		boolean estado = utilidadesTcs.validateElementInvisibility("xpath", PreguntasFrecuentesPageObjects.TECLADO_IOS);
		utilidadesTcs.validateStatusElement(estado);
		Utilidades.tomaEvidencia("Validar desaparezca teclado cuando la búsqueda se complete");
		
    }

	@Step
	public void validarVideoEmbebido() {
        Utilidades.esperaMiliseg(4000);
        boolean estado = utilidadesTcs.validateElementVisibility("xpath", PreguntasFrecuentesPageObjects.RECUADRO_VIDEO);
        utilidadesTcs.validateStatusElement(estado);
        Utilidades.tomaEvidencia("Validar los videos embebidos en la Webview");
    }
	
	@Step
	public void darClicBotonVolver() {
		Utilidades.tomaEvidencia("Dar clic en el botón regresar");
        utilidadesTcs.clicElement("xpath", PreguntasFrecuentesPageObjects.BOTON_REGRESAR);
        Utilidades.esperaMiliseg(2000);
        utilidadesTcs.esperarElementVisibility("xpath", PreguntasFrecuentesPageObjects.BOTON_CERRAR_POP_UP_CALIFICACION);
        utilidadesTcs.clicElement("xpath", PreguntasFrecuentesPageObjects.BOTON_CERRAR_POP_UP_CALIFICACION);
    }
	
	@Step
	public void ingresarNumerosCaracteresEspeciales(String textoNumerosCaracteresEspeciales) {
        utilidadesTcs.cleanInputElement("xpath", PreguntasFrecuentesPageObjects.INPUT_ESCRIBIR_CONSULTA);
        utilidadesTcs.writeElement("xpath", PreguntasFrecuentesPageObjects.INPUT_ESCRIBIR_CONSULTA,textoNumerosCaracteresEspeciales);
        Utilidades.tomaEvidencia("Ingreso numeros y caracteres especiales en la barra de busqueda");
    }
	
	@Step
	public void validarNumerosCaracteresEspecialesBarraBusqueda() {
        String texto = utilidadesTcs.obtenerTexto("xpath", PreguntasFrecuentesPageObjects.INPUT_ESCRIBIR_CONSULTA);
        boolean estado = utilidadesTcs.validarTextoConNumerosYCaracteresEspeciales(texto);
        utilidadesTcs.validateStatusElement(estado);
        Utilidades.tomaEvidencia("Validar que además de “texto” deberá permitirse la escritura de números y caracteres especiales");
    }
	
	@Step
	public void limpiarCampoDeBusquedaConsultas() {
        utilidadesTcs.cleanInputElement("xpath", PreguntasFrecuentesPageObjects.INPUT_ESCRIBIR_CONSULTA);
        
    }
	
	@Step
	public void validarTextoSeMantengaAlNoEncontrarCoincidencias() {
        String texto = utilidadesTcs.obtenerTexto("xpath", PreguntasFrecuentesPageObjects.INPUT_ESCRIBIR_CONSULTA);
        utilidadesTcs.validateTextContainsStringIgnoreUppercaseLowercase(texto,BaseUtil.tituloBusqueda);
        Utilidades.tomaEvidencia("Validar que al no encontrar coincidencias, deberá mantenerse el texto ingresado por el usuario en el campo de búsqueda");
    }
	
	@Step
	public void esperarCargaRespuestaConsulta() {
		Utilidades.esperaMiliseg(4000);
        utilidadesTcs.esperarElementVisibility("xpath", utilidadesTcs.getTituloResultadoBusqueda());
    }
	
	@Step
	public void validoHacerScrollRespuestasLargas() {
		Utilidades.esperaMiliseg(3000);
		Utilidades.scrollHastaElementoPorNombre("Nueva búsqueda");
        boolean estado = utilidadesTcs.validateElementVisibility("xpath", PreguntasFrecuentesPageObjects.BOTON_NUEVA_BUSQUEDA);
        utilidadesTcs.validateStatusElement(estado);
        Utilidades.tomaEvidencia("Validar que permita, para respuestas a preguntas que sean más extensas, desplazamiento vertical");
        Utilidades.tomaEvidencia("Validar que las respuestas a preguntas frecuentes que incorporen información infográfica: Deberá permitir, de ser necesario, desplazamiento vertical");
    }
	
	@Step
	public void validoChatConAsesor() {
		Utilidades.esperaMiliseg(2000);
		Utilidades.scrollHastaElementoPorNombre("Chat con asesor");
        boolean estado = utilidadesTcs.validateElementVisibility("xpath", PreguntasFrecuentesPageObjects.BOTON_CHAT_ASESOR);
        utilidadesTcs.validateStatusElement(estado);
        Utilidades.tomaEvidencia("Validar bajo los selectores de la encuesta de resolución deberá deberá exponerse el botón 'Chat con asesor'");
    }
	
	@Step
	public void darClicBotonVolverSinEncuesta() {
		Utilidades.tomaEvidencia("Dar clic en el botón regresar");
        utilidadesTcs.clicElement("xpath", PreguntasFrecuentesPageObjects.BOTON_REGRESAR);
    }
	
	@Step
	public void validoRespuestasDeAutogestion() {
        String tituloRespuesta = utilidadesTcs.obtenerTextoAtributoName("xpath", utilidadesTcs.getTituloResultadoBusqueda());
        Utilidades.scrollHastaElementoPorNombre("Olvidé mi clave");
        String nombreBotonRespuestaAutogestion = utilidadesTcs.obtenerTextoAtributoName("xpath", PreguntasFrecuentesPageObjects.BOTON_OLVIDE_CLAVE);
        utilidadesTcs.validateTextEqualTo(tituloRespuesta, nombreBotonRespuestaAutogestion);
    }
	
	@Step
	public void seleccionarSegundaOpcionResultados() {
		Utilidades.esperaMiliseg(2000);
		Utilidades.tomaEvidencia("Seleccionar segunda opcion");
		utilidadesTcs.clicElement("xpath", PreguntasFrecuentesPageObjects.OPCION_SEGUNDA_RESPUESTA);
	}
	
	@Step
	public void validoHacerScrollRespuestasLargasVideosEmbebidos() {
		Utilidades.esperaMiliseg(2500);
		Utilidades.scrollHastaElementoPorNombre("Nueva búsqueda");
		boolean estado = utilidadesTcs.validateElementVisibility("xpath", PreguntasFrecuentesPageObjects.BOTON_NUEVA_BUSQUEDA);
		utilidadesTcs.validateStatusElement(estado);
		Utilidades.tomaEvidencia("Validar que para aquellas respuestas a preguntas frecuentes que tengan video asociado en su respuesta deberá permitir desplazamiento vertical");
		
	}
	
	@Step
	public void desplazarseHastaLaEncuesta() {
		Utilidades.esperaMiliseg(2000);
		Utilidades.scrollHastaElementoPorNombre("Chat con asesor");
		Utilidades.tomaEvidencia("Ir a la encuesta de la consulta");
	}
	
	@Step
	public void calificarEncuesta() {
		utilidadesTcs.clicElement("xpath", PreguntasFrecuentesPageObjects.BOTON_PULGAR_ARRIBA);
		Utilidades.tomaEvidencia("Calificar la encuesta");
	}
	
	@Step
	public void validarResultadoDeEncuestaCalificada() {
		String texto = utilidadesTcs.obtenerTexto("xpath", PreguntasFrecuentesPageObjects.TEXTO_RESULTADO_ENCUESTA);
		utilidadesTcs.validateTextContainsString(texto, "¡Gracias! Su respuesta");
		Utilidades.tomaEvidencia("Validar que al ser resuelta la encuesta, el botón 'Chat con asesor', deberá estar expuesto bajo el texto 'Gracias Su respuesta nos ayuda a mejorar cada día'.");
	}
	
	@Step
	public void validarEncuestaSinResolver() {
		Utilidades.tomaEvidencia("Validar en caso tal que el cliente salga y vuelva a ingresar a una pregunta ya calificada, deberá nuevamente exponerse la encuesta inicializada");
		
	}
	
	@Step
	public void hacerUnScrollHaciaArribaEnBarraDeBusqueda() {
		Utilidades.esperaMiliseg(4000);
		Utilidades.scrollHaciaArribaEnIos();
	}









}
