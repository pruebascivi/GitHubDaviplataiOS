@sacar_plata
Feature: Modulo completo de sacar plata

  @CP0440M 
  Scenario Outline: CP0440M_SYS_Validar que se genere la OTP para sacar plata utilizando un monto seleccionable
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a modulo sacar plata
    And diligenciar sacar plata monto seleccionable <monto>
    Then valido generacion de OTP
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario    | contrasena | monto   |
      | "CC"   | "10050099" | "2589"     | "20000" |

  @CP0450M @PASSED
  Scenario Outline: CP0450M_SYS_Validar que se genere la OTP para sacar plata ingresando un monto diferente
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a modulo sacar plata
    And diligenciar sacar plata monto diferente <montoATransar>
    Then valido generacion de OTP
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata
    
    Examples: 
      | tipoId | usuario    | contrasena | montoATransar |
      | "CC"   | "10050099" | "2589"     | "10000"       |

  @CP0460M 
  Scenario Outline: CP0460M_SYS_Validar que no genere la OTP cuando ingreso valores diferentes a los parametrizados en los cajeros
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta  
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a modulo sacar plata
    And Diligencio monto diferente <montoATransar>
    Then Validar valor errado
    And volver a capturar saldo
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario    | contrasena | montoATransar  |
      | "CC"   | "10333052" | "2580"     | "12222"        |

  @CP0470M 
  Scenario Outline: CP0470M_SYS_Validar que no genere la OTP cuando tengo fondos insuficientes
  	Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta  
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a modulo sacar plata
    And Diligencio monto diferente para fondos insuficientes <montoATransar>
    Then valido fondos insuficientes
    And volver a capturar saldo
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario      | contrasena | montoATransar |
      | "CC"   | "10050077"   | "2589"     | "600000"      |
