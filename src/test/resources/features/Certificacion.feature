@MovimientoFuncional
Feature: Movimientos Funcionales

  @CP001604M
  Scenario Outline: CP001604M_SYS_Validar que se muestren los movimientos del DaviPlata
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And selecciono ver movimientos
    Then validar que se muestren los movimientos

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "1020770002" | "1234"     |
