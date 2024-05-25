#Author: Juan Pablo Doncel
@PreguntasFrecuentes
Feature: Modulo de preguntas frecuentes

  @CP030000M
  Scenario Outline: CP030000M_SYS_Validar que permita la entrega de resultados de búsqueda de forma inmediata.
    Given Ingresé a la app Daviplata home
    And Ingresé al botón necesito ayuda
    And Valido seccion de necesito ayuda en otra ventana
    When Ingreso credenciales para la solicitud <tipoDocumento><numeroDocumento>
    And Acepto terminos y condiciones antes de ingresar al modulo necesito ayuda
    And Doy clic en el botón continuar para ingresar al modulo necesito ayuda
    And Hago clic en el campo de busqueda de la consulta
    And Valido el teclado desplegado
    And Valido busqueda barra de busqueda
    And Ingreso la pregunta formulada en el campo de consultas <preguntaUno>
    And Valido la cantidad de resultados en la busqueda
    And Selecciono el resultado de la busqueda
    And Valido resultados de la consulta
    And Valido resultados de preguntas con video embebidos en la Webview
    And Doy clic en el boton devolver
    And Ingreso numeros y caracteres especiales <textoNumerosCaracteresEspeciales>
    And Valido que se permita el ingreso de numeros y caracteres especiales
    And Limpiar campo de busqueda
    And Ingreso la pregunta formulada en el campo de consultas <preguntaSinCoincidencia>
    And Valido que al no haber coincidencias el texto se mantenga
    And Limpiar campo de busqueda
    And Ingreso la pregunta formulada en el campo de consultas <pregunta2>
    And Selecciono el resultado de la busqueda
    And Espero carga de la respuesta
    And Valido scroll en respuestas largas
    And Doy clic en el boton devolver
    And Hago scroll hacia arriba
    And Hago clic en el campo de busqueda de la consulta
    And Limpiar campo de busqueda
    And Ingreso la pregunta formulada en el campo de consultas <preguntaTres>
    And Selecciono el resultado de la busqueda
    And Espero carga de la respuesta
    And Valido el boton chat con asesor en encuestas de resolucion
    And Doy clic en el boton devolver sin pop up de encuesta
    And Hago scroll hacia arriba
    And Hago clic en el campo de busqueda de la consulta
    And Limpiar campo de busqueda
    And Ingreso la pregunta formulada en el campo de consultas <preguntaCuatro>
    And Selecciono el resultado de la busqueda
    And Espero carga de la respuesta
    And Valido casos de procesos de autogestion
    And Doy clic en el boton devolver sin pop up de encuesta
    And Hago scroll hacia arriba
    And Hago clic en el campo de busqueda de la consulta
    And Limpiar campo de busqueda
    And Ingreso la pregunta formulada en el campo de consultas <preguntaCinco>
    And Selecciono opcion dos de los resultados de la encuesta
    And Valido desplazamiento vertical para respuestas con video embebido
    And Doy clic en el boton devolver
    And Hago scroll hacia arriba
    And Hago clic en el campo de busqueda de la consulta
    And Limpiar campo de busqueda
    And Ingreso la pregunta formulada en el campo de consultas <preguntaTres>
    And Selecciono el resultado de la busqueda
    And Espero carga de la respuesta
    And Me desplazo hasta la encuesta
    And Califico respuesta de la consulta
    And Valido resultado de la encuesta
    And Doy clic en el boton devolver sin pop up de encuesta
    And Hago scroll hacia arriba
    And Hago clic en el campo de busqueda de la consulta
    And Ingreso la pregunta formulada en el campo de consultas <preguntaTres>
    And Selecciono el resultado de la busqueda
    And Espero carga de la respuesta
    And Me desplazo hasta la encuesta
    Then Validar encuesta sin resolver despues de ingresar nuevamente

    Examples: 
      | tipoDocumento | numeroDocumento | preguntaUno       | textoNumerosCaracteresEspeciales | preguntaSinCoincidencia | pregunta2                  | preguntaTres        | preguntaCuatro    | preguntaCinco 	 |
      | "CC"          | "10050038"      | "crear productos" | "tr@nsacciones 1234"             | "Automatizacion"        | "Registrarme desde la app" | "Cargar mi tarjeta" | "Olvidé mi clave" | "Transfiya" |

  @CP030001M
  Scenario Outline: CP030001M_SYS_Validar que cuando se dé click en el botón “Necesita ayuda”, debe direccionar a la experiencia del gestor de interacciones.
    Given Ingresé a la app Daviplata home
    And Ingresé al botón necesito ayuda
    And Valido seccion de necesito ayuda en otra ventana
    When Ingreso credenciales para la solicitud <tipoDocumento><numeroDocumento>
    And Acepto terminos y condiciones antes de ingresar al modulo necesito ayuda
    And Doy clic en el botón continuar para ingresar al modulo necesito ayuda
    And Hago clic en el campo de busqueda de la consulta

    Examples: 
      | tipoDocumento | numeroDocumento |
      | "CC"          | "10050050"      |
