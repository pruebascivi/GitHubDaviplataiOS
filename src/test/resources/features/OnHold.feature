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
      | "CC"   | "10088877" | "2589"     | "3112747423" | "4000" | "CC"    | "1019827924" | "2589"      | "uren alckmun" | "1" | "Enero" | "2000" | "2"           | "Febrero"     | "2018"         | "BOGOTÁ, D.C." | "3129719403" | "xxx@gmail.com" | "apt"         |
      
  @CP00228M
  Scenario Outline: CP00228M_SYS_Validar proceso de pasar plata a otro daviplata no existente y registrarlo
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And pasar plata a otro Daviplata <cuentaNum>
    And Valido presencia de PopUp invita Amigos
    And Salir de la app
    And Realizo registro <tipoId> <nuevoUsuario>
    And Acepto autorizacion de regitro
    When completo formulario mis datos <nombre> <dia> <mes> <año> <diaExpedicion> <mesExpedicion> <anioExpedicion> <lugar> <cuentaNum> <correo>
    And ingreso otp
    And ingreso contrasena <contrasena>
    Then validar registro completo
    And Valido saldo inicial usuario recien registrado
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban la transansaccion<nuevoUsuario>
    And logout redeban al finalizar consulta

    Examples: 
      | tipoId | usuario    | contrasena | cuentaNum    | nuevoUsuario | nombre			  	   | dia | mes      | año    | diaExpedicion | mesExpedicion | anioExpedicion | lugar        | correo          | 
      | "CC"   | "10050112" | "2589"     | "3126258210" | "1035431836" | "Alejandro Ríos"  | "9" | "Agosto" | "1994" | "1"           | "Agosto"      | "2012"         | "Copacabana" | "xxx@gmail.com" |
