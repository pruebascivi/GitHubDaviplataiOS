@PasarPLata
Feature: Agrupación casos de PasarPlata

  @CP02289M @PASSED
  Scenario Outline: CP02289M_SYS_Validar proceso de pasar plata del bolsillo al monedero por valor mayor al que tiene el bolsillo
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And consultar saldo tarjeta en redeban bolsillos
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When selecciono bolsillos <status>
    And flujo sacar plata bolsillos mayor a lo que tiene el bolsillo
    Then valido el mensaje excede monto
    And obtener numero celular actual en redeban bolsillos <usuario>
    And consultar saldo tarjeta en redeban bolsillos
    And validar igualdad saldos tarjetas bolsillos

    Examples: 
      | tipoId | usuario    | contrasena | status  |
      | "CC"   | "10333041" | "2580"     | "false" |

  @CP02341M
  Scenario Outline: CP02341M_SYS_Validar proceso de pasar plata a otro daviplata por valor cero desde el Home de daviplata el sistema no deje
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When seleccionar pasar plata Home
    And pasar plata a otro Daviplata en cero <celular><monto>
    Then Validar Monto Cero

    Examples: 
      | tipoId | usuario    | contrasena | celular      | monto |
      | "CC"   | "10050039" | "2589"     | "3227680733" | "0"   |

  @CP0961M
  Scenario Outline: CP0961M_SYS_Validar los topes débito con una transaccion
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en debitos <topeDebito>
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And Pasar plata a otro Daviplata tope debitos <celular>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario    | contrasena | celular      | topeDebito |
      | "CC"   | "10050095" | "2589"     | "3221005095" | "1600000"  |

  @CP02301M @Passed
  Scenario Outline: CP02301M_SYS_Validar proceso de pasar plata a otro daviplata con cliente CC GMF mostrando descuento
    Given obtener numero celular actual en redeban bolsillos <usuario>
   	And Consulté saldo disponible en redeban GMF
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata GMF
    When seleccionar pasar plata Home
    And pasar plata a otro Daviplata <celular>
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    #And Extraer cobro GMF
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata GMF

    Examples: 
      | tipoId | usuario     | contrasena | celular      |
      | "CC"   | "10088833"  | "2589"     | "3227680744" |

  @CP02302M
  Scenario Outline: CP02302M_SYS_Validar proceso de pasar plata a otro daviplata  con cliente CC GMF generando Fondos insuficientes
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata GMF
    When Paso plata a otro daviplata fondos insuficientes gmf <numCelular>
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    And logout redeban al finalizar consulta
    Then Validar igualdad de saldos en redeban y daviplata GMF

    Examples: 
      | tipoId | usuario    | contrasena | numCelular   |
      | "CC"   | "10050018" | "2589"     | "3227680744" |

  @CP02303M
  Scenario Outline: CP02303M_SYS_Validar proceso de pasar plata a otro daviplata  con cliente CC sin GMF generando Excede cupo
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When Paso plata a otro daviplata fondos insuficientes <numCelular>
    Then obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario    | contrasena | numCelular   |
      | "CC"   | "10050038" | "2589"     | "3227680744" |

  @CP002350M @passed
  Scenario Outline: CP002350M_SYS_Validar proceso de pasar plata a otro daviplata desde el Home de daviplata
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And pasar plata a otro Daviplata <cuentaNum>
    Then valido transaccion exitosa
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario    | contrasena | cuentaNum    |
      | "CC"   | "10050099" | "2589"     | "3227680733" |
      
  @CP02380M @PASSED
  Scenario Outline: CP02380M_SYS_Realizar un pasar plata a otro Daviplata exitoso añadiendo cuenta a favoritos
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And Pasar plata a otro Daviplata añadiendo cuenta a favoritos <cuentaNum> <monto> <nombreContactoFavorito>
    Then validar transaccion exitosa
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario    | contrasena | cuentaNum    | monto  | nombreContactoFavorito |
      | "CC"   | "10050099" | "2589"     | "3227680733" | "5000" | "Carlos"               |

	@CP0291M
  Scenario Outline: CP0291M_SYS_Realizar un pasar plata a cuentas Davivienda exitoso
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And Pasar plata a cuentas davivienda añadiendo cuenta a favoritos <tipoCuenta> <cuentaNum> <nombreContactoFavorito> <monto>
    Then Validar transaccion exitosa pasar plata cuenta
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban <usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario    | contrasena | tipoCuenta | cuentaNum      | nombreContactoFavorito | monto   |
      | "CC"   | "10050099" | "2589"     | "Ahorros"  |  "3227680733"  | "Tatiana"              | "15000" |

  @CP002352M
  Scenario Outline: CP002352M_SYS_Validar proceso de pasar plata a un numero que empicese diferente de 3 desde el Home de daviplata
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When seleccionar pasar plata Home
    Then validacion de numero diferente de tres <celular>

    Examples: 
      | tipoId | usuario    | contrasena | celular      |
      | "CC"   | "10050038" | "2589"     | "3227680744" |
      
  @CP02361M
  Scenario Outline: CP02361M_SYS_Validar proceso de pasar plata a otro daviplata por valor 1 desde el Home de daviplata el sistema deje
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And pasar plata a otro Daviplata valor 1 <celular>
    Then validar transaccion exitosa
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario    | contrasena | celular      |
      | "CC"   | "10050038" | "2589"     | "3227680744" |

  @CP02362M
  Scenario Outline: CP02362M_SYS_Validar proceso de pasar plata a otro daviplata desde el Home de daviplata cuando el destino tiene tope de creditos
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And Obtener numero celular actual en redeban aumento de topes Destino <usuarioDestino>
    And Consulté saldo tarjeta en redeban aumento de topes destino
    And Validé tope actual en creditos <topeCredito>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And pasar plata a otro Daviplata <celular>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario    | contrasena | celular      | usuarioDestino | topeCredito |
      | "CC"   | "10050038" | "2589"     | "3002009173" | "35399173"     | "1160000"   |

  @CP02363M
  Scenario Outline: CP02363M_SYS_Validar proceso de pasar plata a otro daviplata desde el Home de daviplata cuando el origen tiene tope de debitos
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en debitos <topeDebito>
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And Pasar plata a otro Daviplata tope debitos <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban bolsillos <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario      | contrasena | cuentaNum    | topeDebito |
      | "CC"   | "1020770033" | "1342"     | "3003085537" | "3840000"  |

  @CP02360M
  Scenario Outline: CP02360M_SYS_Validar proceso de pasar plata a otro daviplata desde el Home de daviplata cuando el destino tiene tope de debitos
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And Obtener numero celular actual en redeban aumento de topes Destino <usuarioDestino>
    And Consulté saldo tarjeta en redeban aumento de topes destino
    And Validé tope actual en debitos destino <topeDebito>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    When ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And Paso plata a otro Daviplata <celular> <montoATransferir>
    Then validar transaccion exitosa
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario    | contrasena | celular      | usuarioDestino | topeDebito | montoATransferir |
      | "CC"   | "10050038" | "2589"     | "3221005095" | "10050112"     | "1600000"  | "2000"           |

  @CP02365M
  Scenario Outline: CP02365M_SYS_Validar proceso de pasar plata a otro daviplata desde el Home de daviplata cuando el origen tiene tope de creditos
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en creditos <topeCredito>
    And logout redeban al finalizar consulta
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And Paso plata a otro Daviplata <celular> <montoATransferir>
    Then validar transaccion exitosa Pasar Plata
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata topes

    Examples: 
      | tipoId | usuario    | contrasena | celular      | topeCredito | montoATransferir |
      | "CC"   | "10050099" | "2589"     | "3227680733" | "2000000"   | "1200"           |

  @CP02366M
  Scenario Outline: CP02366M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo BMO con origen en tope de debitos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And Validé tope actual en debitos <topeDebito>
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And Pasar plata a otro Daviplata tope debitos <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban bolsillos <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario    | contrasena | cuentaNum    | topeDebito | subtipo |
      | "CC"   | "80418029" | "1234"     | "3132302919" | "8927726"  | "BMO"   |

  @CP02367M
  Scenario Outline: CP02367M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo RA3 con origenten en tope de debitos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And Validé tope actual en debitos <topeDebito>
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And Pasar plata a otro Daviplata tope debitos <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban bolsillos <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario    | contrasena | cuentaNum    | topeDebito | subtipo |
      | "CC"   | "52546864" | "1234"     | "3227680733" | "3480000"  | "RA3"   |

  @CP02368M
  Scenario Outline: CP02368M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo D11 con origenten en tope de debitos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And Validé tope actual en debitos <topeDebito>
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And Pasar plata a otro Daviplata tope debitos <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban bolsillos <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario    | contrasena | cuentaNum    | topeDebito | subtipo |
      | "CC"   | "10007749" | "1234"     | "3227680733" | "14844200" | "D11"   |

  @CP02369M
  Scenario Outline: CP02369M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo M35 con origenten en tope de debitos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And Validé tope actual en debitos <topeDebito>
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And Pasar plata a otro Daviplata tope debitos <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban bolsillos <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario    | contrasena | cuentaNum    | topeDebito | subtipo |
      | "CC"   | "10050112" | "2589"     | "3227680734" | "1600000"  | "M35"   |

  @CP02370M
  Scenario Outline: CP02370M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo MET con origenten en tope de debitos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And Validé tope actual en debitos <topeDebito>
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And Pasar plata a otro Daviplata tope debitos <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban bolsillos <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario    | contrasena | cuentaNum    | topeDebito | subtipo |
      | "CC"   | "35399173" | "1234"     | "3227680733" | "9280000"  | "MET"   |

  @CP02371M
  Scenario Outline: CP02371M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo RA1 con origenten en tope de debitos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And Validé tope actual en debitos <topeDebito>
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And Pasar plata a otro Daviplata tope debitos <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban bolsillos <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario    | contrasena | cuentaNum    | topeDebito | subtipo |
      | "CC"   | "10007760" | "1234"     | "3227680733" | "14844200" | "RA1"   |

  @CP02372M
  Scenario Outline: CP02372M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo RAP con origenten en tope de debitos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And Validé tope actual en debitos <topeDebito>
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And Pasar plata a otro Daviplata tope debitos <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban bolsillos <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario    | contrasena | cuentaNum    | topeDebito | subtipo |
      | "CC"   | "52546863" | "1234"     | "3227680733" | "9280000"  | "RAP"   |

  @CP02373M @PasarPLata376
  Scenario Outline: CP02373M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo BMO con destino en tope de creditos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And Obtener numero celular actual en redeban aumento de topes Destino <usuarioDestino>
    And Consulté saldo tarjeta en redeban aumento de topes destino
    And Validé tope actual en creditos <topeCredito>
    And Consulté saldo disponible en redeban
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And pasar plata a otro Daviplata <celular>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario      | contrasena | celular      | usuarioDestino | subtipo | topeCredito |
      | "CC"   | "1020770043" | "1342"     | "3142149029" | "80418029"     | "BMO"   | "8927726"   |

  @CP02374M @PasarPLata1234567
  Scenario Outline: CP02374M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo RA3 con destino en tope de creditos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And Obtener numero celular actual en redeban aumento de topes Destino <usuarioDestino>
    And Consulté saldo tarjeta en redeban aumento de topes destino
    And Validé tope actual en creditos <topeCredito>
    And Consulté saldo disponible en redeban
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And pasar plata a otro Daviplata <celular>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario      | contrasena | celular      | usuarioDestino | subtipo | topeCredito |
      | "CC"   | "1020770043" | "1342"     | "3003085537" | "52546864"     | "RA3"   | "1160000"   |

  @CP02375M @PasarPLata12
  Scenario Outline: CP02375M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo D11 con destino en tope de creditos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And Obtener numero celular actual en redeban aumento de topes Destino <usuarioDestino>
    And Consulté saldo tarjeta en redeban aumento de topes destino
    And Validé tope actual en creditos <topeCredito>
    And Consulté saldo disponible en redeban
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And pasar plata a otro Daviplata <celular>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario      | contrasena | celular      | usuarioDestino | subtipo | topeCredito |
      | "CC"   | "1020770043" | "1342"     | "3002010756" | "10007756"     | "D11"   | "1160000"   |

  @CP02376M
  Scenario Outline: CP02376M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo M35 con destino en tope de creditos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And Obtener numero celular actual en redeban aumento de topes Destino <usuarioDestino>
    And Consulté saldo tarjeta en redeban aumento de topes destino
    And Validé tope actual en creditos <topeCredito>
    And Consulté saldo disponible en redeban
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And pasar plata a otro Daviplata <celular>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario    | contrasena | celular      | usuarioDestino | subtipo | topeCredito |
      | "CC"   | "10050098" | "2589"     | "3221005082" | "10050099"     | "M35"   | "2000000"   |

  @CP02377M @PasarPLata12
  Scenario Outline: CP02377M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo MET con destino en tope de creditos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And Obtener numero celular actual en redeban aumento de topes Destino <usuarioDestino>
    And Consulté saldo tarjeta en redeban aumento de topes destino
    And Validé tope actual en creditos <topeCredito>
    And Consulté saldo disponible en redeban
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And pasar plata a otro Daviplata <celular>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario      | contrasena | celular      | usuarioDestino | subtipo | topeCredito |
      | "CC"   | "1020770043" | "1342"     | "3002009173" | "35399173"     | "MET"   | "1160000"   |

  @CP02378M @PasarPLata12
  Scenario Outline: CP02378M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo RA1 con destino en tope de creditos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And Obtener numero celular actual en redeban aumento de topes Destino <usuarioDestino>
    And Consulté saldo tarjeta en redeban aumento de topes destino
    And Validé tope actual en creditos <topeCredito>
    And Consulté saldo disponible en redeban
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And pasar plata a otro Daviplata <celular>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario      | contrasena | celular      | usuarioDestino | subtipo | topeCredito |
      | "CC"   | "1020770043" | "1342"     | "3002013115" | "10007760"     | "RA1"   | "1160000"   |

  @CP02379M
  Scenario Outline: CP02379M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo RAP con destino en tope de creditos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And Obtener numero celular actual en redeban aumento de topes Destino <usuarioDestino>
    And Consulté saldo tarjeta en redeban aumento de topes destino
    And Validé tope actual en creditos <topeCredito>
    And Consulté saldo disponible en redeban
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And pasar plata a otro Daviplata <celular>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario      | contrasena | celular      | usuarioDestino | subtipo | topeCredito |
      | "CC"   | "1020770043" | "1342"     | "3003085536" | "52546863"     | "RAP"   | "1160000"   |

  @CP50000M
  Scenario Outline: CP50000M_SYS_Validar el boton volver en el flujo pasar plata a otro Daviplata.
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When seleccionar pasar plata Home
    Then pasar plata a otro Daviplata volver atras <cuentaNum>

    Examples: 
      | tipoId | usuario    | contrasena | cuentaNum    |
      | "CC"   | "10050038" | "2589"     | "3227680744" |

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
      
  @CP031105M @Passed
  Scenario Outline: CP031105M_SYS_Validaciones movimientos en pasar plata del dia actual y anterior
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When seleccionar pasar plata Home
    And pasar plata a otro Daviplata <cuentaNum>
    And Salir de la app 
    Given ingreso usuario y contrasena <tipoId> <usuarioDestino> <contrasenaDestino>
    And Entro al modulo de movimientos
    And Valido enmascaramiento del numero de transaccion
   	Then Valido transaccion fecha actual y anterior 
    Then Valido nombre y numero de la transaccion en los movimientos

    Examples: 
      | tipoId | usuario    | contrasena  | cuentaNum    | tipoId | usuarioDestino    | contrasenaDestino |  
      | "CC"   | "10050099" | "2589"      | "3221005049" |  "CC"  | "10050066"        |  "2589"           |
      
  @CP031106M
  Scenario Outline: CP031106M_SYS_Validaciones movimientos cuando no tiene movimientos
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validar aun no tiene movimientos home
   
    Examples: 
      | tipoId | usuario    | contrasena |    
      | "CC"   | "17130494" | "2580"     |	