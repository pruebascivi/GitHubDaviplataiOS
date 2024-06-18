#Author: laura Pérez
@LauraVoz
Feature: Pruebas modulo Laura Voz

  @CP0921001M @Passed
  Scenario Outline: CP0921001M_SYS_Validar el ingreso al gestor POC Laura Avatar desde zona publica con usuario TI no autorizado, redireccione al Gestor de interacciones tradicional (flujo actual).
    Given Ingresé a la app Daviplata home
    And Ingresé al botón necesito ayuda
    And Valido seccion de necesito ayuda en otra ventana
    When Ingreso credenciales para la solicitud <tipoDocumento><numeroDocumento>
    And Acepto terminos y condiciones antes de ingresar al modulo necesito ayuda
    And Doy clic en el botón continuar para ingresar al modulo necesito ayuda
    And Valido que me redireccione al gestor de interacciones tradicional

    Examples: 
      | tipoDocumento | numeroDocumento |
      | "TI"          | "961007"        |

  @CP0921002M @Passed
  Scenario Outline: CP0921002M_SYS_Validar el ingreso al gestor POC Laura Avatar desde zona publica con usuario CC no autorizado, redireccione al Gestor de interacciones tradicional (flujo actual).
    Given Ingresé a la app Daviplata home
    And Ingresé al botón necesito ayuda
    And Valido seccion de necesito ayuda en otra ventana
    When Ingreso credenciales para la solicitud <tipoDocumento><numeroDocumento>
    And Acepto terminos y condiciones antes de ingresar al modulo necesito ayuda
    And Doy clic en el botón continuar para ingresar al modulo necesito ayuda
    And Valido que me redireccione al gestor de interacciones tradicional

    Examples: 
      | tipoDocumento | numeroDocumento |
      | "CC"          | "10050011"      |
 
  @CP0921003M @Passed
  Scenario Outline: CP0921003M_SYS_Validar el ingreso al gestor POC Laura Avatar desde zona publica con usuario CE no autorizado, redireccione al Gestor de interacciones tradicional (flujo actual).
    Given Ingresé a la app Daviplata home
    And Ingresé al botón necesito ayuda
    And Valido seccion de necesito ayuda en otra ventana
    When Ingreso credenciales para la solicitud <tipoDocumento><numeroDocumento>
    And Acepto terminos y condiciones antes de ingresar al modulo necesito ayuda
    And Doy clic en el botón continuar para ingresar al modulo necesito ayuda
    And Valido que me redireccione al gestor de interacciones tradicional

    Examples: 
      | tipoDocumento | numeroDocumento |
      | "CE"          | "65753445"      |

  @CP0921004M @Passed
  Scenario Outline: CP0921004M_SYS_Validar el ingreso al gestor POC Laura Avatar desde zona publica con usuario TI autorizado, redireccione al usuario a la pantalla bienvenida.
    Given Ingresé a la app Daviplata home
    And Ingresé al botón necesito ayuda
    And Valido seccion de necesito ayuda en otra ventana
    When Ingreso credenciales para la solicitud <tipoDocumento><numeroDocumento>
    And Acepto terminos y condiciones antes de ingresar al modulo necesito ayuda
    And Doy clic en el botón continuar para ingresar al modulo necesito ayuda
    And Valido que me redireccione al usuario a la pantalla bienvenida

    Examples: 
      | tipoDocumento | numeroDocumento |
      | "TI"          | "9610070988"    |

  @CP0921005M @Passed
  Scenario Outline: CP0921005M_SYS_Validar el ingreso al gestor POC Laura Avatar desde zona publica con usuario CC autorizado, redireccione al usuario a la pantalla bienvenida.
    Given Ingresé a la app Daviplata home
    And Ingresé al botón necesito ayuda
    And Valido seccion de necesito ayuda en otra ventana
    When Ingreso credenciales para la solicitud <tipoDocumento><numeroDocumento>
    And Acepto terminos y condiciones antes de ingresar al modulo necesito ayuda
    And Doy clic en el botón continuar para ingresar al modulo necesito ayuda
    And Valido que me redireccione al usuario a la pantalla bienvenida

    Examples: 
      | tipoDocumento | numeroDocumento |
      | "CC"          | "300028"        |

  @CP0921006M @Passed
  Scenario Outline: CP0921006M_SYS_Validar el ingreso al gestor POC Laura Avatar desde zona publica con usuario CE autorizado, redireccione al usuario a la pantalla bienvenida.
    Given Ingresé a la app Daviplata home
    And Ingresé al botón necesito ayuda
    And Valido seccion de necesito ayuda en otra ventana
    When Ingreso credenciales para la solicitud <tipoDocumento><numeroDocumento>
    And Acepto terminos y condiciones antes de ingresar al modulo necesito ayuda
    And Doy clic en el botón continuar para ingresar al modulo necesito ayuda
    And Valido que me redireccione al usuario a la pantalla bienvenida

    Examples: 
      | tipoDocumento | numeroDocumento |
      | "CE"          | "100524202"     |

  @CP0921007M @Passed
  Scenario Outline: CP0921007M_SYS_Validar que en la pantalla Bievenido al chat de servicio en daviplata contenga el icono cerrar X, que al dar tap sobre el icono redirrecione al login del gestor
    Given Ingresé a la app Daviplata home
    And Ingresé al botón necesito ayuda
    And Valido seccion de necesito ayuda en otra ventana
    When Ingreso credenciales para la solicitud <tipoDocumento><numeroDocumento>
    And Acepto terminos y condiciones antes de ingresar al modulo necesito ayuda
    And Doy clic en el botón continuar para ingresar al modulo necesito ayuda
    And Valido que me redireccione al usuario a la pantalla bienvenida
    Then Validar la pantalla Bievenido al chat de servicio daviplata contenga el icono cerrar y me redirija al login del gestor

    Examples: 
      | tipoDocumento | numeroDocumento |
      | "CC"          | "300028"        |

  @CP0921008M @Passed
  Scenario Outline: CP0921008M_SYS_Validar que en la pantalla Bienvenido al chat de servicio en Daviplata contenga el icono Minimizar -, que al dar tap sobre el icono redireccione a la App Daviplata
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    Then Valido que en la pantalla contenga el icono Minimizar y al dar tap sobre el icono redireccione a la App Daviplata
    And Validar despues del tap en el icono minimizar y volver a ingresar al boton necesito ayuda se direccione al Gestor Poc Laura en la misma pantalla que se minimizo
    And Realizo tap en el boton Empecemos y se dirija a la pantalla 'necesita Ayuda' donde se podrá visualizar el mensaje predeterminado

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CE"   | "1005242019" | "2580"     |

	@CP0921009M @PassedElementosNoMapeables
  Scenario Outline: CP0921009M_SYS_Validar los textos del chat en Laura Voz
    Given Ingresé a la app Daviplata home
    And Ingresé al botón necesito ayuda
    And Valido seccion de necesito ayuda en otra ventana
    When Ingreso credenciales para la solicitud <tipoDocumento><numeroDocumento>
    And Acepto terminos y condiciones antes de ingresar al modulo necesito ayuda
    And Doy clic en el botón continuar para ingresar al modulo necesito ayuda
    And Valido que la pantalla contenga el texto 'Renovamos nuestro servicio de ayuda'
    And Hago clic en el boton reproducir
    Then Validar textos de la reproduccion de Laura voz

    Examples: 
      | tipoDocumento | numeroDocumento |
      | "CC"          | "1004473747"    |
