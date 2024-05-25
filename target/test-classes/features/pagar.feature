@Pagar
Feature: Pruebas modulo pagar

  @CP03701M
  Scenario Outline: CP03701M_SYS_Validar proceso de pago de servicio EAAB desde la pestaña pagos de servicios en tienda virtual y verificar campo switch en web redeban
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    Then ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a modulo pagar
    And Diligencio datos de una referencia en empresa <empresaServicio> <referencia> <valorServicio>
    Then verifico transaccion exitosa una ref <empresaServicio> <referencia>
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban la transaccion de switch <usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario   | contrasena | empresaServicio | referencia | valorServicio |
      | "CC"   | "10050077" | "2589"     | "EAAB" | "30951863015" |"78320"|

  @CP0371M
  Scenario Outline: CP0371M_SYS_Validar proceso de pago de servicio EAAB desde la pestaña pagos de servicios en tienda virtual con cliente GMF y verificar campo switch en web redeban
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    And logout redeban al finalizar consulta
    When ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata GMF
    And ingreso a modulo pagar
    And Diligencio datos de una referencia en empresa <empresaServicio> <referencia> <valorServicio>
    Then verifico transaccion exitosa una ref <empresaServicio> <referencia>
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    And Extraer cobro GMF
    And Validar en redeban la transaccion de switch <usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata


    Examples: 
      | tipoId | usuario      | contrasena | empresaServicio | referencia | valorServicio |
      | "CC"   | "100111511" | "2580"     | "EAAB" | "10126617793" | "64719"           |

  @CP0372M 
  Scenario Outline: CP0372M_SYS_Validar proceso de pago de convenios BDI desde la subcategoría otros servicios estando en pago de servicios en tienda virtual
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a modulo pagar
    And Diligencio datos de una referencia en empresa <empresaServicio> <referencia> <valorServicio>
    Then verifico transaccion exitosa una ref <empresaServicio> <referencia>
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario   | contrasena | empresaServicio                | referencia | valorServicio |
      | "CC"   | "100111518" | "2580"     | "BDI+DNR STRATUS2012 01017052" | "2656635"  | "34508"           |

  @CP0373M
  Scenario Outline: CP0373M_SYS_Validar proceso de pago de convenios DNR con una referencia desde la subcategoría otros servicios estando en pago de servicios en tienda virtual
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a modulo pagar
    And Diligencio datos de una referencia servico <empresaServicio> <referencia> <valorTransaccion>
    Then verifico transaccion exitosa una ref <empresaServicio> <referencia>
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario    | contrasena | empresaServicio       | referencia | valorTransaccion |
      | "CC"   | "10050033" | "2589"     | "DNR UNA REF ATH dos" | "52411946" | "2500"           |

  @CP0374M 
  Scenario Outline: CP0374M_SYS_Validar proceso de pago de convenios DNR con dos referencias desde la subcategoría otros servicios estando en pago de servicios en tienda virtual
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a modulo pagar
    And diligencio datos de dos referencias <empresaServicio> <referencia> <referencia2> <valorTransaccion>
    Then verifico transaccion exitosa dos ref <empresaServicio> <referencia> <referencia2>
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario     | contrasena | empresaServicio                 | referencia | referencia2 | valorTransaccion |
      | "CC"   | "80418029"  | "1234"     | "DNR2" | "52856856" | "25362536"  | "2500"           |

  @CP0375M
  Scenario Outline: CP0375M_SYS_Validar proceso de pago de convenios BDI desde la subcategoría otros servicios estando en pago de servicios en tienda virtual con usuario GMF
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    And logout redeban al finalizar consulta
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata GMF
    When ingreso a modulo pagar
    And Diligencio datos de una referencia en empresa <empresaServicio> <referencia> <valorServicio>
    Then verifico transaccion exitosa una ref <empresaServicio> <referencia>
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    And Extraer cobro GMF
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario   | contrasena | empresaServicio                | referencia | valorServicio |
      | "CC"   | "10050018" | "2589"     | "BDI+DNR STRATUS2012 01017052" | "2656636"  | "35188"           |

  @CP0376M
  Scenario Outline: CP0376M_SYS_Validar proceso de pago de convenios DNR con una referencia desde la subcategoría otros servicios estando en pago de servicios en tienda virtual con usuario GMF
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    And logout redeban al finalizar consulta
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata GMF
    When ingreso a modulo pagar
    And Diligencio datos de una referencia servico <empresaServicio> <referencia> <valorTransaccion>
    Then verifico transaccion exitosa una ref <empresaServicio> <referencia>
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    And Extraer cobro GMF
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario   | contrasena | empresaServicio       | referencia | valorTransaccion |
      | "CC"   | "10050018" | "2589"     | "DNR UNA REF ATH dos" | "52411946" | "4000"           |

  @CP0377M
  Scenario Outline: CP0377M_SYS_Validar proceso de pago de convenios DNR con dos referencias desde la subcategoría otros servicios estando en pago de servicios en tienda virtual con usuario GMF
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata GMF
    When ingreso a modulo pagar
    And diligencio datos de dos referencias <empresaServicio> <referencia> <referencia2> <valorTransaccion>
    Then verifico transaccion exitosa dos ref <empresaServicio> <referencia> <referencia2>
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    And Extraer cobro GMF
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario    | contrasena | empresaServicio                 | referencia | referencia2 | valorTransaccion |
      | "CC"   | "10050018" | "2589"     | "DNR Daviplata 01014240" | "52856856" | "25362536"  | "2500"           |

  @CP0390M
  Scenario Outline: CP0390M_SYS_Validar que no permita el Pago de servicios de 1 referencia errada
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a modulo pagar
    And diligencio datos de una referencia errada <empresaServicio> <referencia>
    Then verifico transaccion negada

    Examples: 
      | tipoId | usuario    | contrasena | empresaServicio | referencia |
      | "CC"   | "10050050" | "2589"     | "Avianca"           | "52411946"      |

  @CP0400M 
  Scenario Outline: CP0400M_SYS_Validar que no permita el Pago de servicios de 2 referencias con la 1ra errada
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a modulo pagar
    And diligencio datos de dos referencias errada <empresaServicio> <referencia> <referencia2>
    Then verifico transaccion negada

    Examples: 
      | tipoId | usuario    | contrasena | empresaServicio  | referencia | referencia2 |
      | "CC"   | "100111519" | "2580"     | "PORTAL EMP BDI" | "123"      | "987654"    |

  @CP0410M 
  Scenario Outline: CP0410M_SYS_Validar que no permita el Pago de servicios de 2 referencias con la 2da errada
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a modulo pagar
    And diligencio datos de dos referencias errada <empresaServicio> <referencia> <referencia2>
    Then verifico transaccion negada

    Examples: 
      | tipoId | usuario    | contrasena | empresaServicio  | referencia | referencia2 |
      | "CC"   | "100111519" | "2580"     | "PORTAL EMP BDI" | "1234567"  | "8351"      |

  @CP0430M 
  Scenario Outline: CP0430M_SYS_Validar que no permita el Pago de servicios ingresando un monto superior al DaviPlata
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a modulo pagar
    And Diligencio datos de una referencia servico <empresaServicio> <referencia> <valorTransaccion>
    Then verifico transaccion negada

    Examples: 
      | tipoId | usuario      | contrasena | empresaServicio       | referencia | valorTransaccion |
      | "CC"   | "100111518" | "2580"     | "DNR UNA REF ATH dos" | "52411946" | "1000000"           |

  @CP1211M
  Scenario Outline: CP1211M_SYS_Validar que no se realizo el pago con referencia errada de servicios (Luz, agua, gas y minutos)
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a tienda virtual
    And Complejo flujo de servicios incorrecto <opcion> <referencia>
   	Then verifico transaccion negada
   	And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario    | contrasena | opcion | referencia |
      | "CC"   | "10050050" | "2589"     | "etb"  | "456"      |

  @CP1221M 
  Scenario Outline: CP1221M_SYS_Validar que no se realizo el pago con referencia errada de otros servicios
     Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a modulo pagar
    And diligencio datos de una referencia errada <empresaServicio> <referencia>
    Then verifico transaccion negada

    Examples: 
      | tipoId | usuario     | contrasena | empresaServicio | referencia |
      | "CC"   | "100111519" | "2580"     | "Avianca"           | "52411946"      |

  @CP1411M @pagar1
  Scenario Outline: CP1411M_SYS_Validar la opción Pagar Servicios  Servicios Publicos ( EAAB l )
   Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    Then ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a modulo pagar
    And Diligencio datos de una referencia servico <empresaServicio> <referencia> <valorTransaccion>
    Then verifico transaccion exitosa una ref <empresaServicio> <referencia>
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario    | contrasena | empresaServicio      | referencia    | valorTransaccion |
      | "CC"   | "100111518" | "2580"     | "EAAB" | "10126619815" | "86490"           |
