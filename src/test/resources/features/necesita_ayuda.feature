	@necesita_ayuda
Feature: necesito ayuda

  @CP1260M 
  Scenario Outline: CP1260M_SYS_Validar boton flotante en las pantallas del banco (Necesito ayuda)
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a modulo pagar
    Then Completo el flujo pago de servicio y validar necesito ayuda

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "1020770043" | "1342"     |
