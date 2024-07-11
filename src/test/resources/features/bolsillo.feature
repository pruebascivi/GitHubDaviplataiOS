@Bolsillos
Feature: Pruebas modulo Bolsillos

  @CP1163M	@Passed
  Scenario Outline: CP02030M_SYS_Validar la creación de bolsillo en cero pesos desde el home
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When selecciono bolsillos <status>
    And Flujo de crear bolsillo <valordisponible>
    Then valido creacion de bolsillo
    And validar transaccion exitosa bolsillos
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario      | contrasena | valordisponible | status  |
      | "CC"   | "1020770044" | "2589"     | "0"             | "false" |

  @CP02040M @Passed
  Scenario Outline: CP02040M_SYS_Validar la creación de bolsillo semanal con valor desde el home daviplata.
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When selecciono bolsillos <status>
    And flujo de crear bolsillo por periodo <valordisponible> <periodo>
    Then valido creacion de bolsillo
    And validar transaccion exitosa bolsillos
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario      | contrasena | valordisponible | status  | periodo       |
      | "CC"   | "1020770044" | "2589"     | "2000"          | "false" | "Cada Semana" |

  @CP03750M
  Scenario Outline: CP03750M_SYS_Validar la creación de bolsillo quincenal con valor desde el Home daviplata.
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When selecciono bolsillos <status>
    And flujo de crear bolsillo por periodo <valordisponible> <periodo>
    Then valido creacion de bolsillo
    And validar transaccion exitosa bolsillos
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario      | contrasena | valordisponible | status  | periodo            |
      | "CC"   | "1020770044" | "2589"     | "2000"          | "false" | "Cada quince días" |

  @CP03000M
  Scenario Outline: CP03000M_SYS_Validar la creación de bolsillo mensual con valor desde el Home daviplata
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When selecciono bolsillos <status>
    And flujo de crear bolsillo por periodo <valordisponible> <periodo>
    Then valido creacion de bolsillo
    And validar transaccion exitosa bolsillos
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario      | contrasena | valordisponible | status  | periodo    |
      | "CC"   | "1020770044" | "2589"     | "2000"          | "false" | "Cada mes" |

  @CP03760M @PASSED
  Scenario Outline: CP03760M_SYS_Validar proceso de sacar plata desde los bolsillos al daviplata
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a la opcion bolsillo desde home
    And flujo sacar plata bolsillos <monto>
    Then valido el pasar plata bolsillos a daviplata
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario    | contrasena | monto  |
      | "CC"   | "10050099" | "2589"     | "1000" |

  @CP03770M @PASSED
  Scenario Outline: CP03770M_SYS_Validar proceso de meter plata a los bolsillos
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When pasar plata a bolsillos <valor>
    Then valido el pasar plata daviplata a bolsillos
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario     | contrasena | valor  |
      | "CC"   | "10333041"  | "2580"     | "1000" |

  @CP02050M
  Scenario Outline: CP02050M_SYS_Validar proceso de modificar bolsillo en nombre y fechas.
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And flujo de modificar bolsillos <periodo>
    Then valido modificacion de bolsillo
    And validar modificacion bolsillo

    Examples: 
      | tipoId | usuario      | contrasena | periodo            | status  |
      | "CC"   | "1020770044" | "1342"     | "Cada quince días" | "false" |

  @CP03780M
  Scenario Outline: CP03780M_SYS_Validar proceso de eliminación de bolsillo
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a la opcion bolsillo desde home
    And flujo de eliminar bolsillos
    Then valido eliminacion de bolsillo

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10050099" | "2589"     |

  @CP03010M
  Scenario Outline: CP03010M_SYS_Validar proceso de sacar plata mayor a lo que tiene el bolsillo
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    When ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And selecciono bolsillos <status>
    And flujo sacar plata bolsillos mayor a lo que tiene el bolsillo
    Then valido el mensaje excede monto
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario      | contrasena | status |
      | "CC"   | "1020770044" | "2589"     | "true" |

  @CP03020M
  Scenario Outline: CP03020M_SYS_Validar que el sistema muestre mensaje de no poder crear más bolsillos desde el menú hamburguesa
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When selecciono bolsillos <status>
    And flujo de crear maximos bolsillos <valordisponible>
    Then valido mesaje de maximos bolsillos creados

    Examples: 
      | tipoId | usuario      | contrasena | valordisponible | status  |
      | "CC"   | "1020770044" | "2589"     | "0"             | "false" |
