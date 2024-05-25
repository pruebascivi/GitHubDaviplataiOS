@setOperacionRegresion
Feature: Set de operación y regresión

  @CP1350M
  Scenario Outline: CP1350M_SYS_Validar la opción pasar plata A (Daviplata, cta ahorros, cta corriente)
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When paso plata a otro daviplata <numeroDaviPlata> <valor>
    Then valido la transaccion <usuario>
    And crear excel

    Examples: 
      | tipoId | usuario   | contrasena | numeroDaviPlata | valor   |
      | "CC"   | "1007721" | "1234"     | "3213702169"    | "20000" |

  @CP1360M
  Scenario Outline: CP1360M_SYS_Validar la opción pasar plata A (Bolsillo)
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When pasar plata a bolsillo <valor>
    Then valido la transaccion de daviplata hacia bolsillo <usuario>
    And crear excel

    Examples: 
      | tipoId | usuario    | contrasena | valor   |
      | "CC"   | "10007753" | "1234"     | "10000" |

  @CP1370M
  Scenario Outline: CP1370M_SYS_Validar la opción pasar plata A (Cuenta otros bancos)
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When paso plata cta ach no inscrita <valor>
    Then valido la transaccion ach <usuario>
    And crear excel

    Examples: 
      | tipoId | usuario   | contrasena | valor   |
      #|"5524001"|"1234"|"20000"|
      | "CC"   | "1007721" | "1234"     | "20000" |

  #@CP1380M
  #Scenario Outline: CP1380M_SYS_Validar recargas prepago
   # Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
   # When recargar celular <operador> <numCel> <monto>
   # Then valido recarga celular <usuario>
   # And crear excel

#    Examples: 
 #     | tipoId | usuario   | contrasena | operador  | numCel       | monto  |
      #|"5524001"|"1234"|"AVANTEL"|"3013604450"|"5000"|
  #    | "CC"   | "1007721" | "1234"     | "AVANTEL" | "3013604450" | "5000" |

  @CP1390M
  Scenario Outline: CP1390M_SYS_Validar la opción pagar servicios (Convenios) (DNR , 1Referencia)
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When pagar servicio <empresa> <referencia> <monto>
    Then valido pagar servicio <usuario> <monto>
    And crear excel

    Examples: 
      | tipoId | usuario   | contrasena | empresa               | referencia | monto   |
      #|"5524001"|"1234"|"DNR UNA REF ATH dos"|"52411956"|"12000"|
      | "CC"   | "1007721" | "1234"     | "DNR UNA REF ATH dos" | "52411956" | "12000" |

  @CP1400M
  Scenario Outline: CP1400M_SYS_Validar la opción pagar servicios (Convenios) (DNR , 2Referencia)
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When pagar dos servicios <empresa> <referencia1> <referencia2> <monto>
    Then valido pagar servicio <usuario> <monto>
    And crear excel

    Examples: 
      | tipoId | usuario   | contrasena | empresa                   | referencia1 | referencia2 | monto  |
      # |"5524001"|"1234"|"DNR CON ABONO UNIFICADO"|"80145"|"52411946"|"12000"|
      | "CC"   | "1007721" | "1234"     | "DNR CON ABONO UNIFICADO" | "80145"     | "52411946"  | "1200" |

  @CP1410M
  Scenario Outline: CP1410M_SYS_Validar la opción pagar servicios publicos (EEAA)
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a pago de servicios y pago un servicio <empresa> <referencia>
    Then valido pagar servicio <usuario> <monto>
    And crear excel

    Examples: 
      | tipoId | usuario   | contrasena | empresa       | referencia    | monto    |
      #|"5524001" |  "1234"  |"EAAB BOGOTA"| "10126612018"| "136740"|
      | "CC"   | "1007721" | "1234"     | "EAAB BOGOTA" | "10126612018" | "136740" |

  @CP1420M
  Scenario Outline: CP1420M_SYS_Validar creación bolsillo Menu Hamburguesa
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso y creo el bolsillo MH <montoInicial> <montoAhorro> <cadaCuanto> <queDia>
    Then valido creación bolsillo
    And crear excel

    Examples: 
      | tipoId | usuario    | contrasena | montoInicial | montoAhorro | cadaCuanto    | queDia    |
      #| "5524001" |   "1234"   |   "10000"   |  "100000"  | "Cada Semana" | "Viernes" |
      | "CC"   | "10007753" | "1234"     | "10000"      | "100000"    | "Cada Semana" | "Viernes" |

  @CP1430M
  Scenario Outline: CP1430M_SYS_Validar eliminación bolsillo
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso y elimino bolsillo <bolsillo>
    Then valido eliminación bolsillo <valorBolsillo>
    And crear excel

    Examples: 
      | tipoId | usuario    | contrasena | valorBolsillo | bolsillo |
      | "CC"   | "10007753" | "1234"     | "-10000"      | "1"      |

  @CP1440M
  Scenario Outline: CP1440M_SYS_Validar pasar plata del bolsillo a Daviplata
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When pasar plata de bolsillo <valor>
    Then valido la transaccion de bolsillo hacia daviplata <usuario>
    And crear excel

    Examples: 
      | tipoId | usuario   | contrasena | valor    |
      | "CC"   | "1007721" | "1234"     | "-10000" |

  @CP1450M
  Scenario Outline: CP1450M_SYS_Validar Recarga Tarjeta Virtual
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When realizar recarga con monto seleccionado
    Then validar saldo de eCard <usuario> <valor>
    And crear excel

    Examples: 
      | tipoId | usuario   | contrasena | valor   |
      | "CC"   | "1007721" | "1234"     | "50000" |

  @CP1460M
  Scenario Outline: CP1460M_SYS_Validar la compra de seguro
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso y compro seguro bicicileta <año>
    Then valido la compra del seguro bicicleta <usuario>
    And crear excel

    Examples: 
      | tipoId | usuario    | contrasena | año    |
      | "CC"   | "10007753" | "1234"     | "2015" |

  @CP1470M
  Scenario Outline: CP1470M_SYS_Validar la compra de seguro de vida desde tienda virtual
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso y compro seguro de vida <dia> <mes> <año> <sexo> <opcion>
    Then valido la compra del seguro vida <usuario>
    And crear excel

    Examples: 
      | tipoId | usuario    | contrasena | dia  | mes         | año    | sexo        | opcion |
      | "CC"   | "10007753" | "1234"     | "22" | "September" | "1995" | "Masculino" | "2"    |
