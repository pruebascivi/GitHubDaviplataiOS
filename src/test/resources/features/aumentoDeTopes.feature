#Author: Miguel Ortiz
@AumentoDeTopes
Feature: casos de aumento de topes

  @CP03200M @AumentoDeTopes
  Scenario Outline: CP03200M_SYS_validar proceso de aumento de topes desde el home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en debitos <topeDebito>
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingresar a opcion topes
    And obtener topes de credito
    When seleccionar pasar plata Home
    And pasar plata a otro Daviplata escribir <cuentaNum><monto>
    And Salir de la app
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And ingresar a opcion topes
    And obtener topes de credito

    Examples: 
      | tipoId | usuario    | contrasena | cuentaNum    | monto   | topeDebito |
      | "CC"   | "10050112" | "2589"     | "3221005095" | "10000" | "1600000"  |
