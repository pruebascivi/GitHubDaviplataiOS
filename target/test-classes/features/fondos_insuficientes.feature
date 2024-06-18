#Author: Juan Doncel
@fondos_insuficientes
Feature: Casos de fondos insuficientes

  @CP1530M
  Scenario Outline: CP1530M_SYS_Validar el mensaje de fondos insuficientes para la transacción Pasar plata a otro daviplata (Con GMF)
    Given consultar saldos tarjetas en redeban origen y destino <usuario><usuario2>
    And logout redeban iOS
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When paso plata a otro daviplata fondo insuficiente
    And consultar saldos tarjetas en redeban origen y destino <usuario><usuario2>
    And logout redeban iOS
    Then valido igualdad saldos cuenta origen y destino

    Examples: 
      | tipoId | usuario    | contrasena | usuario2   |
      | "CC"   | "10050038" | "2589"     | "10050034" |

  @CP1540M @fondosinsuficientes1
  Scenario Outline: CP1540M_SYS_Validar el mensaje de fondos insuficientes para la transacción Pasar plata a otro daviplata (Sin GMF)
    Given consultar saldos tarjetas en redeban origen y destino <usuario><usuario2>
    And logout redeban iOS
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When paso plata a otro daviplata fondo insuficiente
    And consultar saldos tarjetas en redeban origen y destino <usuario><usuario2>
    And logout redeban iOS
    Then valido igualdad saldos cuenta origen y destino

    Examples: 
      | tipoId | usuario     | contrasena | usuario2    |
      | "CC"   | "100111512" | "2580"     | "100111513" |

  @CP1550M @fondos12
  Scenario Outline: CP1550M_SYS_Validar el mensaje de fondos insuficientes para la transacción Pasar Plata A cuenta de Ahorros Davivienda (Con GMF)
    Given consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    When ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And pasar plata a cuenta bancaria fondo insuficiente <tipoCuenta> <cuentaNum>
    And consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    Then valido igualdad saldos cuenta origen

    Examples: 
      | tipoId | usuario    | contrasena | tipoCuenta | cuentaNum     |
      | "CC"   | "10050034" | "2589"     | "AHORROS"  | "98170019255" |

  @CP1560M @fondosinsuficientes1
  Scenario Outline: CP1560M_SYS_Validar el mensaje de fondos insuficientes para la transacción Pasar Plata A cuenta de Ahorros Davivienda (Sin GMF)
    Given consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    When ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And pasar plata a cuenta bancaria fondo insuficiente <tipoCuenta> <cuentaNum>
    And consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    Then valido igualdad saldos cuenta origen

    Examples: 
      | tipoId | usuario    | contrasena | tipoCuenta | cuentaNum     |
      | "CC"   | "10050033" | "2589"     | "AHORROS"  | "98170019255" |

  @CP1570M @fondos12
  Scenario Outline: CP1570M_SYS_Validar el mensaje de fondos insuficientes para la transacción Pasar Plata A cuenta Corriente Davivienda (Con GMF)
    Given consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    When ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And pasar plata a cuenta bancaria fondo insuficiente <tipoCuenta> <cuentaNum>
    And consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    Then valido igualdad saldos cuenta origen

    Examples: 
      | tipoId | usuario    | contrasena | tipoCuenta  | cuentaNum     |
      | "CC"   | "10050034" | "2589"     | "Corriente" | "98170019255" |

  @CP1580M @fondos12
  Scenario Outline: CP1580M_SYS_Validar el mensaje de fondos insuficientes para la transacción Pasar Plata A cuenta Corriente Davivienda (Sin GMF)
    Given consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    When ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And pasar plata a cuenta bancaria fondo insuficiente <tipoCuenta> <cuentaNum>
    And consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    Then valido igualdad saldos cuenta origen

    Examples: 
      | tipoId | usuario    | contrasena | tipoCuenta  | cuentaNum     |
      | "CC"   | "10050033" | "2589"     | "Corriente" | "98170019255" |

  @CP1590M @fondos1
  Scenario Outline: CP1590M_SYS_Validar el mensaje de fondos insuficientes para la transacción Pasar Plata Desde y hacia mis Bolsillos (Con GMF) - (Desde Bolsillo)
    Given consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    When ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And ingresar a bolsillo y sacar dinero excede cupo
    And consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    Then valido igualdad saldos cuenta origen

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10050034" | "2589"     |

  @CP1600M @fondos1
  Scenario Outline: CP1600M_SYS_Validar el mensaje de fondos insuficientes para la transacción Pasar Plata Desde y hacia mis Bolsillos (Sin GMF) - (Desde Bolsillo)
    Given consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    When ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And ingresar a bolsillo y sacar dinero excede cupo
    And consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    Then valido igualdad saldos cuenta origen

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10050033" | "2589"     |

  @CP1610M
  Scenario Outline: CP1610M_SYS_Validar el mensaje de fondos insuficientes para la transacción Pasar Plata Desde y hacia mis Bolsillos (Con GMF) - (Hacia Bolsillo)
    Given consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    When ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And ingresar bolsillo y meter dinero fondo insuficiente
    And consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    Then valido igualdad saldos cuenta origen

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10050034" | "2589"     |

  @CP1620M @fondos1
  Scenario Outline: CP1620M_SYS_Validar el mensaje de fondos insuficientes para la transacción Pasar Plata Desde y hacia mis Bolsillos (Sin GMF) - (Hacia Bolsillo)
    Given consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    When ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And ingresar bolsillo y meter dinero fondo insuficiente
    And consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    Then valido igualdad saldos cuenta origen

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10050033" | "2589"     |

  @CP1630M
  Scenario Outline: CP1630M_SYS_Validar el mensaje de fondos insuficientes para la transacción Pasar Plata Desde y hacia mis Bolsillos (Con GMF) - (Creación Bolsillo)
    Given consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    When ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And crear bolsillo y meter dinero fondo insuficiente
    And consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    Then valido igualdad saldos cuenta origen

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10050034" | "2589"     |

  @CP1640M @fondos1
  Scenario Outline: CP1640M_SYS_Validar el mensaje de fondos insuficientes para la transacción Pasar Plata Desde y hacia mis Bolsillos (Sin GMF) - (Creación Bolsillo)
    Given consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    When ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And crear bolsillo y meter dinero fondo insuficiente
    And consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    Then valido igualdad saldos cuenta origen

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10050033" | "2589"     |

  @CP2550M @fondos13
  Scenario Outline: CP2550M_SYS_Validar el mensaje de fondos insuficientes para la transacción Pasar Plata a Pasar Plata Ya (Con GMF) - (Pasar Plata)
    And consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    When ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And ir a la opcion TransfiYA
    And pasar plata a banco en linea y meter dinero fondo insuficiente<numCelular><monto>
    And consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    Then valido igualdad saldos cuenta origen

    Examples: 
      | tipoId | usuario    | contrasena | numCelular   | monto    |
      | "CC"   | "10050034" | "2589"     | "3227680754" | "700000" |

  @CP1565M @fondos1
  Scenario Outline: CP1565M_SYS_Validar el mensaje de fondos insuficientes para la transacción Pasar Plata a Pasar Plata Ya (Sin GMF) - (Pasar Plata)
    And consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    When ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And ir a la opcion TransfiYA
    And pasar plata a banco en linea y meter dinero fondo insuficiente<numCelular><monto>
    And consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    Then valido igualdad saldos cuenta origen

    Examples: 
      | tipoId | usuario    | contrasena | numCelular   | monto     |
      | "CC"   | "10050033" | "2589"     | "3221005016" | "1820000" |

  @CP1566M
  Scenario Outline: CP1566M_SYS_Validar el mensaje de fondos insuficientes para la transacción Pasar Plata a Pasar Plata Ya (Con GMF) - (Pedir Plata)
    And consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And ir a la opcion TransfiYA
    And pedir plata a banco en linea y meter dinero fondo insuficiente<numCelular><monto>
    And cerrar sesion usuario 1
    And ingreso usuario y contrasena del segundo usuario <tipoId2> <usuario2> <contrasena2>
    And ir a la opcion TransfiYA
    And aceptar y validar transferencia denegada
    And consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    Then valido igualdad saldos cuenta origen

    Examples: 
      | tipoId | usuario    | contrasena | numCelular   | monto     | tipoId2 | usuario2     | contrasena2 |
      | "CC"   | "10050034" | "2589"     | "3227680754" | "2000000" | "CC"    | "1020770034" | "1342"      |

  @CP1581M @FONFDOS13
  Scenario Outline: CP1581M_SYS_Validar el mensaje de fondos insuficientes para la transacción Pasar Plata a Pasar Plata Ya (Sin GMF) - (Pedir Plata)
    Given consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And ir a la opcion TransfiYA
    And pedir plata a banco en linea y meter dinero fondo insuficiente<numCelular><monto>
    And cerrar sesion usuario 1
    And ingreso usuario y contrasena del segundo usuario <tipoId2> <usuario2> <contrasena2>
    And ir a la opcion TransfiYA
    And aceptar y validar transferencia denegada
    And consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    Then valido igualdad saldos cuenta origen

    Examples: 
      | tipoId | usuario    | contrasena | numCelular   | monto     | tipoId2 | usuario2     | contrasena2 |
      | "CC"   | "10050033" | "2589"     | "3221005016" | "2000000" | "CC"    | "1020770034" | "1342"      |

  @CP1650M
  Scenario Outline: CP1650M_SYS_Validar el mensaje de fondos insuficientes para la transacción Pasar Plata A otros Bancos (Con GMF)
    And consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And pasar plata a otros bancos fondo insuficiente <numeroCuenta> <tipoIdDestino> <usuarioDestino> <valorAPasar> <banco>
    And consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    Then valido igualdad saldos cuenta origen

    Examples: 
      | tipoId | usuario    | contrasena | numeroCuenta | tipoIdDestino | usuarioDestino | valorAPasar | banco    |
      | "CC"   | "10050034" | "2589"     | "3227680754" | "CC"          | "1003613"      | "4000000"   | "Bogota" |

  @CP1660M @fondos6
  Scenario Outline: CP1660M_SYS_Validar el mensaje de fondos insuficientes para la transacción Pasar Plata A otros Bancos (Sin GMF)
    And consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And pasar plata a otros bancos fondo insuficiente <numeroCuenta> <tipoIdDestino> <usuarioDestino> <valorAPasar> <banco>
    And consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    Then valido igualdad saldos cuenta origen

    Examples: 
      | tipoId | usuario    | contrasena | numeroCuenta | tipoIdDestino | usuarioDestino | valorAPasar | banco    |
      | "CC"   | "10050033" | "2589"     | "3221005016" | "CC"          | "1003613"      | "500000"    | "Bogota" |

  @CP1770M @fondos65
  Scenario Outline: CP1770M_SYS_Validar el mensaje de fondos insuficientes para la transacción Pago Convenio DNR Con 1 Referencia (Con GMF)
    And consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a modulo pagar
    And Diligencio datos de una referencia en empresa <empresaServicio> <referencia> <valorTransaccion>
    Then verifico transaccion negada
    And consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    Then valido igualdad saldos cuenta origen

    Examples: 
      | tipoId | usuario      | contrasena | empresaServicio       | referencia | valorTransaccion |
      | "CC"   | "1020770054" | "1342"     | "DNR UNA REF ATH dos" | "528568"   | "5000000"        |

  @CP1780M @fondos13
  Scenario Outline: CP1780M_SYS_Validar el mensaje de fondos insuficientes para la transacción Pago Convenio DNR Con 1 Referencia (Sin GMF)
    And consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a modulo pagar
    And Diligencio datos de una referencia en empresa <empresaServicio> <referencia> <valorTransaccion>
    Then verifico transaccion negada
    And consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    Then valido igualdad saldos cuenta origen

    Examples: 
      | tipoId | usuario    | contrasena | empresaServicio       | referencia | valorTransaccion |
      | "CC"   | "10050033" | "2589"     | "DNR UNA REF ATH dos" | "528568"   | "5000000"        |

  @CP1790M @fondos13
  Scenario Outline: CP1790M_SYS_Validar el mensaje de fondos insuficientes para la transacción Pago Convenio DNR Con 2 Referencias (Con GMF)
    And consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a modulo pagar
    And diligencio datos de dos referencias <empresaServicio> <referencia> <referencia2> <valorTransaccion>
    Then verifico transaccion negada
    And consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    Then valido igualdad saldos cuenta origen

    Examples: 
      | tipoId | usuario      | contrasena | empresaServicio | referencia | referencia2 | valorTransaccion |
      | "CC"   | "1020770054" | "1342"     | "DNR2"          | "52856856" | "25362536"  | "5000000"        |

  @CP1800M @fondos13
  Scenario Outline: CP1800M_SYS_Validar el mensaje de fondos insuficientes para la transacción Pago Convenio DNR Con 2 Referencias (Sin GMF)
    And consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a modulo pagar
    And diligencio datos de dos referencias <empresaServicio> <referencia> <referencia2> <valorTransaccion>
    Then verifico transaccion negada
    And consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    Then valido igualdad saldos cuenta origen

    Examples: 
      | tipoId | usuario    | contrasena | empresaServicio | referencia | referencia2 | valorTransaccion |
      | "CC"   | "10050033" | "2589"     | "DNR2"          | "52856856" | "25362536"  | "5000000"        |

  @CP1810M @fondos13
  Scenario Outline: CP1810M_SYS_Validar el mensaje de fondos insuficientes para la transacción Pasar Plata A Cuenta Corriente del mismo cliente (Con GMF)
    Given consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    When ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And pasar plata a cuenta bancaria fondo insuficiente <tipoCuenta> <cuentaNum>
    And consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    Then valido igualdad saldos cuenta origen

    Examples: 
      | tipoId | usuario      | contrasena | tipoCuenta  | cuentaNum      |
      | "CC"   | "1020770054" | "1342"     | "Corriente" | "098360033017" |

  @CP1821M
  Scenario Outline: CP1821M_SYS_Validar el mensaje de fondos insuficientes para la transacción Recarga Prepago (Con GMF)
    Given consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    When ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And ingreso a tienda virtual
    And ingresar a operador seleccionado <operador>
    And diligenciar formulario paquetes movistar fondos insuficientes <numero>
    And validar mensaje saldo insuficiente
    And consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    Then valido igualdad saldos cuenta origen

    Examples: 
      | tipoId | usuario      | contrasena | operador   | numero       |
      | "CC"   | "1020770054" | "1342"     | "movistar" | "3176582733" |

  @CP1822M @fondos_insuficientes202
  Scenario Outline: CP1822M_SYS_Validar el mensaje de fondos insuficientes para la transacción Recarga Prepago (Sin GMF)
    Given consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    When ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And ingreso a tienda virtual
    And ingresar a operador seleccionado <operador>
    And diligenciar formulario paquetes movistar fondos insuficientes <numero>
    And validar mensaje saldo insuficiente
    And consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    Then valido igualdad saldos cuenta origen

    Examples: 
      | tipoId | usuario    | contrasena | operador   | numero       |
      | "CC"   | "10050033" | "2589"     | "movistar" | "3176582733" |

  @CP1730M @fondos65
  Scenario Outline: CP1730M_SYS_Validar el mensaje de fondos insuficientes para la transacción Sacar Plata ATM (Con GMF)
    Given consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When realizo sacar plata con GMF
    And consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    Then valido igualdad saldos cuenta origen

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "1020770054" | "1342"     |

  @CP1740M @fondos_insuficientes201
  Scenario Outline: CP1740M_SYS_Validar el mensaje de fondos insuficientes para la transacción Sacar Plata ATM (Sin GMF)
    Given consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When realizo sacar plata sin GMF
    And consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    Then valido igualdad saldos cuenta origen

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10050033" | "2589"     |

  @CP1771M @fondos_insuficientes201
  Scenario Outline: CP1771M_SYS_Validar el mensaje de fondos insuficientes para la transacción Recargar Tarjeta Virtual (Con GMF)
    Given consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a menu hamburguesa
    And ir a tarjeta virtual
    And recargar tarjeta sin disponible
    Then validar mensaje de saldo insuficiente
    And consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    Then valido igualdad saldos cuenta origen

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "1020770054" | "1342"     |

  @CP1781M @fondos_insuficientes202
  Scenario Outline: CP1781M_SYS_Validar el mensaje de fondos insuficientes para la transacción Recargar Tarjeta Virtual (Sin GMF)
    Given consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a menu hamburguesa
    And ir a tarjeta virtual
    And recargar tarjeta sin disponible
    Then validar mensaje de saldo insuficiente
    And consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    Then valido igualdad saldos cuenta origen

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10050033" | "2589"     |

  @CP1791M @fondos_insuficientes202
  Scenario Outline: CP1791M_SYS_Validar el mensaje de fondos insuficientes para la transacción Pasar Plata A Cuenta de Ahorros del mismo cliente (Con GMF)
    Given consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    When ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And pasar plata a cuenta bancaria fondo insuficiente <tipoCuenta> <cuentaNum>
    And consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    Then valido igualdad saldos cuenta origen

    Examples: 
      | tipoId | usuario      | contrasena | tipoCuenta | cuentaNum      |
      | "CC"   | "1020770054" | "1342"     | "ahorros"  | "098300129362" |

  @CP1901M @fondos65
  Scenario Outline: CP1901M_SYS_Validar el mensaje de fondos insuficientes para la transacción Pasar Plata A Cuenta de Ahorros del mismo cliente (Sin GMF)
    Given consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    When ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And pasar plata a cuenta bancaria fondo insuficiente <tipoCuenta> <cuentaNum>
    And consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    Then valido igualdad saldos cuenta origen

    Examples: 
      | tipoId | usuario    | contrasena | tipoCuenta | cuentaNum      |
      | "CC"   | "10050033" | "2589"     | "ahorros"  | "098300129685" |

  @CP1720M @fondos_insuficientes202
  Scenario Outline: CP1720M_SYS_Validar el mensaje de fondos insuficientes para la transacción Pasar Plata A Cuenta Corriente del mismo cliente (Sin GMF)
    Given consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    When ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And pasar plata a cuenta bancaria fondo insuficiente <tipoCuenta> <cuentaNum>
    And consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    Then valido igualdad saldos cuenta origen

    Examples: 
      | tipoId | usuario    | contrasena | tipoCuenta  | cuentaNum      |
      | "CC"   | "10050033" | "2589"     | "Corriente" | "098360033215" |
