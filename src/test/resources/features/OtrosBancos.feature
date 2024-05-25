@OtrosBancos
Feature: Casos de prueba para Otros Bancos

  @CP0301M @PASSED
  Scenario Outline: CP0301M_SYS_Validar proceso de transacción a otros banco como a banco bogotá ACH
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And Escoger opcion a otros bancos
    And Llenar formulario de datos <numeroCuenta> <tipoIden> <numId> <valorAPasar> <banco>
    Then validar transaccion exitosa
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban <usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario    | contrasena | numeroCuenta  | tipoIden | numId     | valorAPasar | banco    |
      | "CC"   | "10050099" | "2589"     | "3227680733"  | "CC"     | "1003613" | "10000"     | "Bogota" |
      
	@CP00255M @PASSED
  Scenario Outline: CP00255M_SYS_Realizar un pasar plata a Otros Bancos exitoso añadiendo cuenta a favoritos
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And Escoger opcion a otros bancos
    And Llenar formulario de datos y favorito <numeroCuenta> <tipoIden> <numId> <valorAPasar> <banco>
    Then validar transaccion exitosa
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban <usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario    | contrasena | numeroCuenta  | tipoIden | numId     | valorAPasar | banco    |
      | "CC"   | "10050099" | "2589"     | "3227680733"  | "CC"     | "1003613" | "10000"     | "Bogota" |

  @CP0302M 
  Scenario Outline: CP0302M_SYS_Validar proceso de transacción a otros banco como a banco bogotá por valor inferior a 10000 es canal ACH
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And Escoger opcion a otros bancos
    And Pasar plata otro banco monto inferior otros bancos <numeroCuenta> <tipoIden> <numId> <valorAPasar> <banco>
    Then Validar mensaje valor inferior
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos


    Examples: 
      | tipoId | usuario      | contrasena | numeroCuenta   | tipoIden | numId     | valorAPasar | banco    |
      | "CC"   | "1020770054" | "1342"     | "98169994476"  | "CC"     | "1003613" | "8000"     | "Bogota" |

  @CP03401M 
  Scenario Outline: CP03401M_SYS_Validar proceso de transacción a otros banco como a banco bogotá que genere mensaje de fondos insuficientes por canal ACH
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And Escoger opcion a otros bancos
    And Llenar el formulario de datos fondos insuficientes <numeroCuenta> <tipoId> <numId> <banco>
    Then Validar mensaje fondos insuficientes
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos
    
    Examples: 
      | tipoId | usuario      | contrasena | numeroCuenta   | tipoId | numId | banco    |
      | "CC"   | "1020770053" | "1342"     | "98169994476"  | "CC"          | "1003613"      | "Bogota" |

  @CP03411M 
  Scenario Outline: CP03411M_SYS_Validar proceso de transacción a otros banco como a banco bogotá ACH con cliente GMF
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    And logout redeban al finalizar consulta
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata GMF
    When seleccionar pasar plata Home
    And Escoger opcion a otros bancos
    And Llenar formulario de datos <numeroCuenta> <tipoIden> <numId> <valorAPasar> <banco>
    Then validar transaccion exitosa
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    And Extraer cobro GMF
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata GMF

    Examples: 
      | tipoId | usuario      | contrasena | numeroCuenta   | tipoIden | numId     | valorAPasar | banco    |
      | "CC"   | "10050033"   | "2589"     | "98169994476" | "CC"     | "1003613" | "10000"     | "Bogota" |

  @CP0241M 
  Scenario Outline: CP0241M_SYS_Validar proceso de pasar plata a otro banco seleccionando cuentas mas usadas para canal ACH con Cliente CC
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And Escoger opcion a otros bancos
    And Llenar monto de cuenta inscrita<valorAPasar>
    Then validar transaccion exitosa
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban <usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario      | contrasena | valorAPasar |
      | "CC"   | "10333042"   | "2580"     | "10000"     |

  @CP0242M 
  Scenario Outline: CP0242M_SYS_Validar proceso de pasar plata a otro banco seleccionando cuentas mas usadas para canal ACH con Cliente CE
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When seleccionar pasar plata Home
    And Escoger opcion a otros bancos
    And Llenar monto de cuenta inscrita<valorAPasar>
    Then validar transaccion exitosa
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban <usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario           | contrasena | valorAPasar |
      | "CE"   | "614567893"       | "1234"     | "10000"     |

  @CP0243M 
  Scenario Outline: CP0243M_SYS_Validar proceso de pasar plata a otro banco seleccionando cuentas mas usadas para canal ACH con Cliente TI
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And Escoger opcion a otros bancos
    And Llenar monto de cuenta inscrita<valorAPasar>
    Then validar transaccion exitosa
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban <usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario    | contrasena | valorAPasar |
      | "TI"   | "10010436" | "1234"     | "10000"     |

  @CP0244M 
  Scenario Outline: CP0244M_SYS_Validar proceso de pasar plata a otro banco seleccionando cuentas mas usadas para canal ACH con Cliente PEP
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When seleccionar pasar plata Home
    And Escoger opcion a otros bancos
    And Llenar monto de cuenta inscrita<valorAPasar>
    Then validar transaccion exitosa
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban <usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario           | contrasena | valorAPasar |
      | "CE"   | "614567893"       | "1234"     | "10000"     |

  @CP0245M 
  Scenario Outline: CP0245M_SYS_Validar proceso de transacción a otros banco como a banco Agrario es canal CENIT
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When seleccionar pasar plata Home
    And Escoger opcion a otros bancos
    And Llenar formulario de datos <numeroCuenta> <tipoIden> <numId> <valorAPasar> <banco>
    Then validar transaccion exitosa
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban <usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario      | contrasena | numeroCuenta   | tipoIden | numId     | valorAPasar | banco     |
      | "CC"   | "10333042"   | "2580"     | "98169994476"  | "CC"     | "1003613" | "10000"     | "Agrario" |

  @CP0246M 
  Scenario Outline: CP0246M_SYS_Validar proceso de transacción a otros banco como a banco Agrario por valor inferior a 10000 es canal CENIT
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When seleccionar pasar plata Home
    And Escoger opcion a otros bancos
    And Llenar formulario menor diez mil <numeroCuenta> <tipoIden> <numId> <valorAPasar> <banco>
    Then validar transaccion fallida

    Examples: 
      | tipoId | usuario      | contrasena | numeroCuenta   | tipoIden | numId     | valorAPasar | banco     |
      | "CC"   | "10333042"   | "2580"     | "98169994476" | "CC"     | "1003613" | "9000"      | "Agrario" |

  @CP0247M 
  Scenario Outline: CP0247M_SYS_Validar proceso de transacción a otros banco como a banco Agrario que genere mensaje de fondos insuficientes por canal CENIT
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When seleccionar pasar plata Home
    And Escoger opcion a otros bancos
    And Llenar formulario ACH <numeroCuenta> <tipoIdDestino> <usuarioDestino> <valorAPasar> <banco>
    Then validar transaccion negada monto

    Examples: 
      | tipoId | usuario      | contrasena | numeroCuenta   | tipoIdDestino | usuarioDestino | valorAPasar  | banco     |
      | "CC"   | "1020770053" | "1342"     | "98169994476"  | "CC"          | "1003613"      | "10000000"   | "Agrario" |

  @CP0248M 
  Scenario Outline: CP0248M_SYS_Validar proceso de transacción a otros banco como a banco Agrario CENIT con cliente GMF
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    And logout redeban al finalizar consulta
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata GMF
    When seleccionar pasar plata Home
    And Escoger opcion a otros bancos
    And Llenar formulario de datos <numeroCuenta> <tipoIden> <numId> <valorAPasar> <banco>
    Then validar transaccion exitosa
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    And Extraer cobro GMF
    And Validar en redeban la transansaccion<usuario>
    And logout redeban iOS
    And Validar afectacion de saldos en redeban y daviplata GMF
    

    Examples: 
      | tipoId | usuario      | contrasena | numeroCuenta   | tipoIden | numId     | valorAPasar | banco     |
      | "CC"   | "10050033"   | "1342"     | "98169994476"  | "CC"     | "1003613" | "10000"     | "Agrario" |

  @CP0249M 
  Scenario Outline: CP0249M_SYS_Validar proceso de pasar plata a otro banco seleccionando cuentas mas usadas para canal CENIT con Cliente CC
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And Escoger opcion a otros bancos
    And Llenar monto de cuenta inscrita<valorAPasar>
    Then validar transaccion exitosa
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban <usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario      | contrasena | valorAPasar |
      | "CC"   | "10333042"   | "2580"     | "10000"     |

  @CP00250M 
  Scenario Outline: CP00250M_SYS_Validar proceso de pasar plata a otro banco seleccionando cuentas mas usadas para canal CENIT con Cliente CE
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And Escoger opcion a otros bancos
    And Llenar monto de cuenta inscrita<valorAPasar>
    Then validar transaccion exitosa
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban <usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario      | contrasena | valorAPasar |
      | "CE"   | "614567893"  | "1234"     | "10000"     |

  @CP00251M 
  Scenario Outline: CP00251M_SYS_Validar proceso de pasar plata a otro banco seleccionando cuentas mas usadas para canal CENIT con Cliente TI
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And Escoger opcion a otros bancos
    And Llenar monto de cuenta inscrita<valorAPasar>
    Then validar transaccion exitosa
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban <usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario      | contrasena | valorAPasar |
      | "TI"   | "10010436" | "1234"     | "10000"     |

  @CP00252M 
  Scenario Outline: CP00252M_SYS_Validar proceso de pasar plata a otro banco seleccionando cuentas mas usadas para canal CENIT con Cliente PEP
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And Escoger opcion a otros bancos
    And Llenar monto de cuenta inscrita<valorAPasar>
    Then validar transaccion exitosa
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban <usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario      | contrasena | valorAPasar |
      | "CE"   | "614567893"  | "1234"     | "10000"     |

  @CP00254M @OtrosBancos2
  Scenario Outline: CP00254M_SYS_Validar la opción de pasar plata a otro Banco sin cuenta inscrita ingresando otro valor
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And Escoger opcion a otros bancos
    And Llenar formulario de datos <numeroCuenta> <tipoIden> <numId> <valorAPasar> <banco>
    Then validar transaccion exitosa
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban <usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario      | contrasena | numeroCuenta   | tipoIden | numId     | valorAPasar | banco    |
      | "CC"   | "10333042"   | "2580"     | "98169994476" | "CC"     | "1003613" | "10000"      | "Bogota" |

  @CP03390M @OtrosBancos2
  Scenario Outline: CP03390M_SYS_Validar proceso de transacción a otros banco como a banco bogotá por valor superior a 800000 es canal ACH
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And Escoger opcion a otros bancos
    And Llenar formulario de datos <numeroCuenta> <tipoIdDestino> <usuarioDestino> <valorAPasar> <banco>
    Then validar transaccion negada
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario      | contrasena | numeroCuenta   | tipoIdDestino | usuarioDestino | valorAPasar   | banco    |
      | "CC"   | "10333042"   | "2580"     | "98170019255"  | "CC"          | "1003613"      | "800700"      | "Bogota" |

  @CP03430M @OtrosBancos2
  Scenario Outline: CP03430M_SYS_Validar proceso de transacción a otros banco como a banco Agrario por valor superior a 800000 es canal CENIT
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And Escoger opcion a otros bancos
    And Llenar formulario de datos <numeroCuenta> <tipoIdDestino> <usuarioDestino> <valorAPasar> <banco>
    Then validar transaccion negada
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario   | contrasena | numeroCuenta   | tipoIdDestino | usuarioDestino | valorAPasar | banco     |
      | "CC"   | "10333042" | "2580"     | "98170019255" | "CC"          | "1003613"      | "800700"    | "Agrario" |
