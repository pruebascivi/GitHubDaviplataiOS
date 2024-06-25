#Author: laura Pérez
@LauraVoz
Feature: Pruebas modulo Laura Chat

  @CP0020001M @Passed
  Scenario Outline: CP0020001M_SYS_Validar el ingreso al gestor POC Laura Avatar desde zona privada con usuario CC autorizado, redireccione al usuario a la pantalla bienvenida
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a necesito ayuda desde zona privada
    And Valido pantalla de bienvenida <tipoId><usuario>
    And Hago clic en el boton cerrar
    And Valido que despues de dar clic en el boton de cerrar chat direccione al home Daviplata
    And Ingreso a necesito ayuda desde zona privada
    And Valido pantalla de bienvenida <tipoId><usuario>
    And Hago clic en el boton minimizar
    And Valido que despues de dar clic en el boton de minimizar chat direccione al home Daviplata
    And Ingreso a necesito ayuda desde zona privada
    And Valido pantalla de bienvenida <tipoId><usuario>
    And Doy clic en el boton empecemos
    Then Validar pantalla del canal del chat
    
    Examples: 
      | tipoId | usuario       | contrasena |
      | "CC"   | "1004473745"  | "2580"     |