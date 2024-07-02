@OnHold
Feature: Pruebas en la funcionalidad de generación de extractos de la app Daviplata.

  @CP07010M @Passed
  Scenario Outline: CP07010M_SYS_Validar proceso de pasar plata a un daviplata que no existe con CC (on hold) y se cree daviplata destino
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And Pasar plata a otro Daviplata on Hold <cel> <monto>
    And Salir de la app
    And Realizo registro <tipoId2> <usuario2>
    And Acepto autorizacion para el registro
    And Realizo diligenciamento completo del formulario <nombre><dia><mes><anio><diaExpedicion><mesExpedicion><anioExpedicion><cel><correo>
    And Hago clic en el boton continuar
    And Ingreso otp para terminar registro
    And ingreso contrasena <contrasena2>
    And Valido mensaje de bienvenida
    And obtener numero celular actual en redeban bolsillos <usuario2>
    And Consulté saldo disponible en redeban
    And Validar en redeban la transansaccion<usuario2>
    And logout redeban al finalizar consulta

    Examples: 
      | tipoId | usuario    | contrasena | numero       | monto  | tipoId2 | usuario2     | contrasena2 | nombre         | dia | mes     | anio   | diaExpedicion | mesExpedicion | anioExpedicion | lugar          | cel          | correo          | estadoRedeban |
      | "CC"   | "10088877" | "2589"     | "3112747423" | "4000" | "CC"    | "1019727928" | "2589"      | "uren alckmun" | "1" | "Enero" | "2000" | "2"           | "Febrero"     | "2018"         | "BOGOTÁ, D.C." | "3129719493" | "xxx@gmail.com" | "apt"         |
