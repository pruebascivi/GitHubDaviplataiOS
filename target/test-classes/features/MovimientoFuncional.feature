@MovimientoFuncional
Feature: Movimientos Funcionales

@CP031100M
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
      
  @CP031102M @Passed
  Scenario Outline: CP031102M_SYS_Validaciones cantidad movimientos
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Entro al modulo de movimientos
    Then Validar filtros de movimientos

    Examples: 
      | tipoId | usuario    | contrasena | montoATransar | cuentaNum    |
      | "CC"   | "10333040" | "1234"     | "5000"        | "3221005049" |
      
  @CP031103M @Passed
  Scenario Outline: CP031103M_SYS_Validaciones movimientos por busqueda
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When seleccionar pasar plata Home
   	And pasar plata a otro Daviplata en cero <cuentaNum><montoATransar>
   	And Verifico la informacion y paso plata
    And validar transaccion exitosa
    And Entro al modulo de movimientos
    And Ingreso a la opcion de busqueda
    And Filtro la busqueda por numero celular <cuentaNum>
    And Hago clic en el boton atras
    And Entro al modulo de movimientos
    And Ingreso a la opcion de busqueda
    And Filtro la busqueda por nombre <nombreBusqueda>
    And Hago clic en el boton atras
    And Entro al modulo de movimientos
    And Ingreso a la opcion de busqueda
    And Filtro la busqueda sin coincidencia <nombreBusquedaSinCoincidencia>
    
    Examples: 
      | tipoId | usuario    | contrasena | montoATransar | cuentaNum    | nombreBusqueda | nombreBusquedaSinCoincidencia |
      | "CC"   | "10333040" | "1234"     | "5000"        | "3221005049" | "Plata"        | "prueba"                      |
      
  @CP031104M @Passed
  Scenario Outline: CP031104M_SYS_Validaciones de extractos en modulo movimientos
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Entro al modulo de movimientos
    And Ingresar a extractos 
    And Valido lista de extractos disponibles
    And Oculto lista desplegable de extractos disponibles
    And Valido texto en pestaña de extractos
    And Valido boton descargas deshabilitado
    And Valido boton descargar habilitado al escoger extracto
    Then Valido que al dar clic en la equis de extractos lo deje en la pantalla de movimientos

    Examples: 
      | tipoId | usuario    | contrasena | 
      | "CC"   | "10007760" | "1234"     |
      
  @CP0311005M @Passed
  Scenario Outline: CP0311005M_SYS_Validaciones movimientos en pasar plata del dia actual y anterior
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When seleccionar pasar plata Home
    And pasar plata a otro Daviplata <cuentaNum>
    And Entro al modulo de movimientos
    And Valido enmascaramiento del numero de transaccion
    Then Valido nombre y numero de la transaccion en los movimientos
    And Ingreso al detalle del movimiento en el pasar plata
    Then Valido transaccion fecha actual y anterior 

    Examples: 
      | tipoId | usuario    | contrasena | montoATransar | cuentaNum    | usuario2   | contrasena2 |  
      | "CC"   | "10007760" | "1234"     | "5000"        | "3221005015" | "10050066" |  "2589"     |
      
  @CP0311006M @Passed
  Scenario Outline: CP0311006M_SYS_Validaciones movimientos cuando no tiene movimientos
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    Then Validar aun no tiene movimientos home
   
    Examples: 
      | tipoId | usuario     | contrasena |    
      | "CE"   | "65753445"  | "1234"     |   
      
  @CP031107M @Passed 
  Scenario Outline: CP031107M_SYS_Validaciones movimientos cuando opcion buscar nombre, celular o cuenta
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When seleccionar pasar plata Home
   	And pasar plata a otro Daviplata en cero <cuentaNum><montoATransar>
   	And Verifico la informacion y paso plata
    And validar transaccion exitosa
    And Entro al modulo de movimientos
    And Ingreso a la opcion de busqueda
    And Filtro la busqueda por numero celular <cuentaNum>
    And Hago clic en el boton atras
    And Entro al modulo de movimientos
    And Ingreso a la opcion de busqueda
    And Filtro la busqueda por nombre <nombreBusqueda>
    And Hago clic en el boton atras
    And Entro al modulo de movimientos
    And Ingreso a la opcion de busqueda
   
    Examples: 
      | tipoId | usuario    | contrasena | montoATransar | cuentaNum    | nombreBusqueda | nombreBusquedaSinCoincidencia |
      | "CC"   | "10333040" | "1234"     | "5000"        | "3221005049" | "Plata"        | "prueba"                      |
      
