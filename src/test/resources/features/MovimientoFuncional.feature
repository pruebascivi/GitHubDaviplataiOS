@MovimientoFuncional
Feature: Movimientos Funcionales

	@CP031100M @Passed
  Scenario Outline: CP031100M_SYS_Validaciones del header
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso al detalle del saldo en el home
    And Valido la equis en el detalle de los saldos
    And Valido que despues de dar clic en la equis direccione a la pantalla del home
    And Entro al modulo de movimientos
    And Valido el boton atras en movimientos
    And Dar clic en el boton atras
    And Ingreso al detalle del saldo en el home
    And Entro al modulo de movimientos desde el detalle del saldo
    And Dar clic en el boton atras
    And Valido la equis en el detalle de los saldos
    And Entro al modulo de movimientos
    And Valido titulo de movimientos
    And Valido equis del header de movimientos
    And Dar clic en el boton atras
    And ingreso a modulo sacar plata
    And diligenciar sacar plata monto diferente <montoATransar>
    And valido generacion de OTP
    And Entro al modulo de movimientos
    And Valido movimientos del dia de hoy
    Then Validar movimientos que contengan fecha con el nombre del mes

    Examples: 
      | tipoId | usuario    | contrasena | montoATransar |
      | "CC"   | "10050064" | "2589"     | "20000"       |
      
      
  @CP031101M
  Scenario Outline: CP031101M_SYS_Validaciones movimientos en pasar plata
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When seleccionar pasar plata Home
    And pasar plata a otro Daviplata <cuentaNum>
    #And validar transaccion exitosa
    And Entro al modulo de movimientos
    And Ingreso al detalle del movimiento en el pasar plata
    And Valido nombre y numero de la transaccion en los movimientos

    Examples: 
      | tipoId | usuario    | contrasena  | cuentaNum    |
      | "CC"   | "10088833" | "2589"      | "3227680742" |
      
  @CP031102M
  Scenario Outline: CP031102M_SYS_Validaciones cantidad movimientos
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Entro al modulo de movimientos
    Then Validar filtros de movimientos

    Examples: 
      | tipoId | usuario    | contrasena | montoATransar | cuentaNum    |
      | "CC"   | "10050078" | "2580"     | "5000"        | "3227680742" |
      
   
    