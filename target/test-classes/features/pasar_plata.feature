@PasarPLata
Feature: Agrupación casos de PasarPlata

  @CP02289M
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
      | "CC"   | "10050066" | "2589"     | "3126258200" | "0"   |

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
      | "CC"   | "10050102" | "2589"     | "3227680744" | "14844200" |

  #Cantidad de casos adicionales que agrupa el modulo Barra_saldo_disponible_(iOS-Android): 2
  @CP02301M @Barra_saldo_disponible_(iOS-Android)
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
    And Extraer cobro GMF
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata GMF

    Examples: 
      | tipoId | usuario    | contrasena | celular      |
      | "CC"   | "10050040" | "2580"     | "3227680744" |

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
      | "CC"   | "10050040" | "2580"     | "3227680744" |

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
      | "CC"   | "10050040" | "2580"     | "3227680744" |

  @CP002350M 
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

  @CP02380M
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
      | tipoId | usuario    | contrasena | tipoCuenta | cuentaNum    | nombreContactoFavorito | monto   |
      | "CC"   | "10050099" | "2589"     | "Ahorros"  | "3227680733" | "Tatiana"              | "15000" |

  @CP002352M
  Scenario Outline: CP002352M_SYS_Validar proceso de pasar plata a un numero que empicese diferente de 3 desde el Home de daviplata
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When seleccionar pasar plata Home
    Then validacion de numero diferente de tres <celular>

    Examples: 
      | tipoId | usuario    | contrasena | celular      |
      | "CC"   | "10050038" | "2589"     | "4227680744" |

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
      | "CC"   | "10050038" | "2589"     | "3227680744" | "10050095"     | "3480000"   |

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
      | tipoId | usuario    | contrasena | cuentaNum    | topeDebito |
      | "CC"   | "10050095" | "2589"     | "3227680744" | "3480000"  |

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
    And Paso plata a otro Daviplata <celularDestino> <montoATransferir>
    Then validar transaccion exitosa
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario    | contrasena | celularDestino | usuarioDestino | topeDebito | montoATransferir |
      | "CC"   | "10050038" | "2589"     | "3221005085"   | "10050102"     | "14844200" | "2000"           |

  @CP02365M
  Scenario Outline: CP02365M_SYS_Validar proceso de pasar plata a otro daviplata desde el Home de daviplata cuando el origen tiene tope de creditos
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en creditos <topeCredito>
    And logout redeban al finalizar consulta
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And Paso plata a otro Daviplata <celularDestino> <montoATransferir>
    Then validar transaccion exitosa Pasar Plata
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata topes

    Examples: 
      | tipoId | usuario    | contrasena | celularDestino | topeCredito | montoATransferir |
      | "CC"   | "10050098" | "2589"     | "3227680744"   | "1160000"   | "1200"           |

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
    And Pasar plata a otro Daviplata tope debitos <celularDestino>
    Then validar transaccion negada
    And obtener numero celular actual en redeban bolsillos <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario      | contrasena | celularDestino | topeDebito | subtipo |
      | "CC"   | "1020770010" | "1234"     | "3227680044"   | "8927726"  | "BMO"   |

  @CP02367M
  Scenario Outline: CP02367M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo RA3 con origen en tope de debitos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And Validé tope actual en debitos <topeDebito>
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And Pasar plata a otro Daviplata tope debitos <celularDestino>
    Then validar transaccion negada
    And obtener numero celular actual en redeban bolsillos <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario    | contrasena | celularDestino | topeDebito | subtipo |
      | "CC"   | "10050095" | "2589"     | "3227680044"   | "3480000"  | "RA3"   |

  @CP02368M
  Scenario Outline: CP02368M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo D11 con origen en tope de debitos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And Validé tope actual en debitos <topeDebito>
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And Pasar plata a otro Daviplata tope debitos <celularDestino>
    Then validar transaccion negada
    And obtener numero celular actual en redeban bolsillos <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario    | contrasena | celularDestino | topeDebito | subtipo |
      | "CC"   | "10050096" | "2589"     | "3227680044"   | "14844200" | "D11"   |

  @CP02369M
  Scenario Outline: CP02369M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo M35 con origen en tope de debitos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And Validé tope actual en debitos <topeDebito>
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And Pasar plata a otro Daviplata tope debitos <celularDestino>
    Then validar transaccion negada
    And obtener numero celular actual en redeban bolsillos <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario    | contrasena | celularDestino | topeDebito | subtipo |
      | "CC"   | "10050099" | "2589"     | "3227680044"   | "1160000"  | "M35"   |

  @CP02370M
  Scenario Outline: CP02370M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo MET con origen en tope de debitos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And Validé tope actual en debitos <topeDebito>
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And Pasar plata a otro Daviplata tope debitos <celularDestino>
    Then validar transaccion negada
    And obtener numero celular actual en redeban bolsillos <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario    | contrasena | celularDestino | topeDebito | subtipo |
      | "CC"   | "10050100" | "2589"     | "3227680044"   | "9280000"  | "MET"   |

  @CP02371M
  Scenario Outline: CP02371M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo RA1 con origen en tope de debitos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And Validé tope actual en debitos <topeDebito>
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And Pasar plata a otro Daviplata tope debitos <celularDestino>
    Then validar transaccion negada
    And obtener numero celular actual en redeban bolsillos <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario    | contrasena | celularDestino | topeDebito | subtipo |
      | "CC"   | "10050102" | "2589"     | "3227680044"   | "14844200" | "RA1"   |

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
    And Pasar plata a otro Daviplata tope debitos <celularDestino>
    Then validar transaccion negada
    And obtener numero celular actual en redeban bolsillos <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario    | contrasena | celularDestino | topeDebito | subtipo |
      | "CC"   | "10050104" | "2589"     | "3227680044"   | "9280000"  | "RAP"   |

  @CP02373M
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
    And pasar plata a otro Daviplata <celularDestino>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario      | contrasena | celularDestino | usuarioDestino | subtipo | topeCredito |
      | "CC"   | "1020770010" | "1234"     | "3221005082"   | "10050099"     | "BMO"   | "1160000"   |

  @CP02374M
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
    And pasar plata a otro Daviplata <celularDestino>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario    | contrasena | celularDestino | usuarioDestino | subtipo | topeCredito |
      | "CC"   | "10050094" | "2589"     | "3221005078"   | "10050095"     | "RA3"   | "3480000"   |

  @CP02375M
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
    And pasar plata a otro Daviplata <celularDestino>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario    | contrasena | celularDestino | usuarioDestino | subtipo | topeCredito |
      | "CC"   | "10050097" | "2589"     | "3221005078"   | "10050095"     | "D11"   | "3480000"   |

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
    And pasar plata a otro Daviplata <celularDestino>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario    | contrasena | celularDestino | usuarioDestino | subtipo | topeCredito |
      | "CC"   | "10050098" | "2589"     | "3221005078"   | "10050095"     | "M35"   | "3480000"   |

  @CP02377M
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
    And pasar plata a otro Daviplata <celularDestino>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario    | contrasena | celularDestino | usuarioDestino | subtipo | topeCredito |
      | "CC"   | "10050101" | "2589"     | "3221005078"   | "10050095"     | "MET"   | "3480000"   |

  @CP02378M
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
    And pasar plata a otro Daviplata <celularDestino>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario    | contrasena | celularDestino | usuarioDestino | subtipo | topeCredito |
      | "CC"   | "10050103" | "2589"     | "3221005078"   | "10050095"     | "RA1"   | "3480000"   |

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
    And pasar plata a otro Daviplata <celularDestino>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario    | contrasena | celularDestino | usuarioDestino | subtipo | topeCredito |
      | "CC"   | "10050105" | "2589"     | "3221005078"   | "10050095"     | "RAP"   | "3480000"   |

  @CP50000M
  Scenario Outline: CP50000M_SYS_Validar el boton volver en el flujo pasar plata a otro Daviplata.
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When seleccionar pasar plata Home
    Then pasar plata a otro Daviplata volver atras <cuentaNum>

    Examples: 
      | tipoId | usuario    | contrasena | cuentaNum    |
      | "CC"   | "10050038" | "2589"     | "3227680744" |
