@MicroSeguro
Feature: Set De Casos Microseguros

  @CP02130M @ya @passed
  Scenario Outline: CP02130M_SYS_Validar proceso de compra microseguro de vida opción 1 desde el Home
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual desde el home
    And completar flujo comprar seguro home <opcion> <genero>
    Then validar compra de seguro
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario    | contrasena | opcion | genero |
      | "CC"   | "10050083" | "2589"     | "1"    | "M"    |

  @CP02131M @ya @passed 
  Scenario Outline: CP02131M_SYS_Validar proceso de compra microseguro de vida opción 2 desde el Home
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual desde el home
    And completar flujo comprar seguro home <opcion> <genero>
    Then validar compra de seguro
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario    | contrasena | opcion | genero |
      | "CC"   | "10050074" | "2589"     | "2"    | "M"    |

  @CP02140M @ya @passed
  Scenario Outline: CP02140M_SYS_Validar proceso de compra microseguro de vida opción 1 con usuario GMF desde el Home
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata GMF
    When ingreso a tienda virtual desde el home
    And completar flujo comprar seguro home <opcion> <genero>
    Then validar compra de seguro
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    And Extraer cobro GMF
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata GMF

    Examples: 
      | tipoId | usuario    | contrasena | opcion | genero |
      | "CC"   | "1000807506" | "2589"     | "1"    | "M"    |

  @CP02141M @ya @passed
  Scenario Outline: CP02141M_SYS_Validar proceso de compra microseguro de vida opción 2 con usuario GMF desde el Home
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata GMF
    When ingreso a tienda virtual desde el home
    And completar flujo comprar seguro home <opcion> <genero>
    Then validar compra de seguro
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    And Extraer cobro GMF
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata GMF

    Examples: 
      | tipoId | usuario    | contrasena | opcion | genero |
      | "CC"   | "10050042" | "2589"     | "2"    | "M"    |

  @CP10719M @ya @passed
  Scenario Outline: CP10719M_SYS_Validar proceso de compra microseguro de vida para un unico daviplata y muestre mensaje desde el Home
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual desde el home
    And completar flujo comprar seguro home <opcion> <genero>
    Then validar compra de seguro
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario    | contrasena | opcion | genero |
      | "CC"   | "10050098" | "2589"     | "1"    | "M"    |

  @CP02160M @ya @passed
  Scenario Outline: CP02160M_SYS_Validar proceso de compra microseguro de vida ingresando una fecha de nacimiento que sea menor a 18 años desde el Home
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual desde el home
    And ingreso a opcion seguros
    And completar flujo comprar seguro MH con fecha menor <opcion> <genero>
    Then Valido mensaje

    Examples: 
      | tipoId | usuario      | contrasena | opcion | genero |
      | "CC"   | "1004473738" | "2580"     | "1"    | "M"    |

  @CP02170M @ya @passed
  Scenario Outline: CP02170M_SYS_Validar proceso de compra microseguro de vida opción 1 generando mensaje de fondos insuficientes desde el Home
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual desde el home
    And ingreso a opcion seguros
    And completar flujo comprar seguro home <opcion> <genero>
    And Valido mensaje fondos insuficientes

    Examples: 
      | tipoId | usuario      | contrasena | opcion | genero |
      | "CC"   | "10050022"   | "2589"     | "1"    | "M"    |

  @CP02171M @ya @TimeOut
  Scenario Outline: CP02171M_SYS_Validar proceso de compra microseguro de vida opción 2 generando mensaje de fondos insuficientes desde menú hamburguesa
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual desde el home
    And ingreso a opcion seguros
    And completar flujo comprar seguro home <opcion> <genero>
    And Valido mensaje fondos insuficientes

    Examples: 
      | tipoId | usuario      | contrasena | opcion | genero |
      | "CC"   | "1004473743" | "2580"     | "2"    | "M"    |

  @CP02180M @ya @passed
  Scenario Outline: CP02180M_SYS_Validar proceso de compra microseguro de vida opción 1 generando mensaje de que ya tiene un seguro desde menú hamburguesa
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual desde el home
    And ingreso a opcion seguros
    And completar flujo comprar seguro home <opcion> <genero>
    Then Validar mensaje de que ya tiene seguro de vida

    Examples: 
      | tipoId | usuario      | contrasena | opcion | genero |
      | "CC"   | "1004473738" | "2580"     | "1"    | "M"    |

  @CP02181M @YA @passed
  Scenario Outline: CP02181M_SYS_Validar proceso de compra microseguro de vida opción 2 generando mensaje de que ya tiene un seguro desde menú hamburguesa
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual desde el home
    And ingreso a opcion seguros
    And completar flujo comprar seguro home <opcion> <genero>
    Then Validar mensaje de que ya tiene seguro de vida

    Examples: 
      | tipoId | usuario      | contrasena | opcion | genero |
      | "CC"   | "1004473738" | "2580"     | "2"    | "M"    |

  @CP02182M @YA @passed
  Scenario Outline: CP02182M_SYS_Validar que el sistema debe aceptar TyC por opción 1 y por opción 2 se seguros de vida desde el home
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual desde el home
    And ingreso a opcion seguros
    And Ingresar a cobertura primera
    Then Validar TyC
    And Ingresar a cobertura segunda
    And Validar TyC

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "1004473738" | "2580"     |

  @CP1111M @ya @passed
  Scenario Outline: CP1111M_SYS_Validar proceso de compra microseguro de Bicicleta opción 1 desde el Home
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And ingreso a tienda virtual desde el home
    And ingreso a opcion seguros
    When Completo flujo comprar seguro bicicleta <opcion>
    Then validar compra de seguro
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario      | contrasena | opcion |
      | "CC"   | "1020770032" | "1234"     | "1"    |

  @CP1112M @ya @passed
  Scenario Outline: CP1112M_SYS_Validar proceso de compra microseguro de Bicicleta opción 2 desde el Home
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And ingreso a tienda virtual desde el home
    And ingreso a opcion seguros
    When Completo flujo comprar seguro bicicleta <opcion>
    Then validar compra de seguro
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario      | contrasena | opcion |
      | "CC"   | "1020770032" | "1234"     | "2"    |

  @CP02190M @ya @passed
  Scenario Outline: CP02190M_SYS_Validar proceso de compra microseguro de Bicicleta opción 1 con cliente GMF desde el Home
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata GMF
    When ingreso a tienda virtual desde el home
    And ingreso a opcion seguros
    And Completo flujo comprar seguro bicicleta <opcion>
    Then validar compra de seguro
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    And Extraer cobro GMF
    And logout redeban al finalizar consulta
    And Validar afectacion de saldos en redeban y daviplata GMF

    Examples: 
      | tipoId | usuario    | contrasena | opcion |
      | "CC"   | "10050035" | "2589"     | "1"    |

  @CP02191M @ya @passed
  Scenario Outline: CP02191M_SYS_Validar proceso de compra microseguro de Bicicleta opción 2 con cliente GMF desde el Home
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata GMF
    When ingreso a tienda virtual desde el home
    And ingreso a opcion seguros
    And Completo flujo comprar seguro bicicleta <opcion>
    Then validar compra de seguro
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    And Extraer cobro GMF
    And logout redeban al finalizar consulta
    And Validar afectacion de saldos en redeban y daviplata GMF

    Examples: 
      | tipoId | usuario    | contrasena | opcion |
      | "CC"   | "10050034" | "2580"     | "2"    |

  @CP02200M @ya @passed
  Scenario Outline: CP02200M_SYS_Validar proceso de compra microseguro de Bicicleta opción 1 generando mensaje de fondos insuficientes desde el Home
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual desde el home
    And ingreso a opcion seguros
    Then Completo flujo comprar seguro bicicleta <opcion>
    And Valido mensaje fondos insuficientes

    Examples: 
      | tipoId | usuario      | contrasena | opcion |
      | "CC"   | "1004473738" | "2580"     | "1"    |

  @CP02201M @ya @passed
  Scenario Outline: CP02201M_SYS_Validar proceso de compra microseguro de Bicicleta opción 2 generando mensaje de fondos insuficientes desde el Home
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual desde el home
    And ingreso a opcion seguros
    Then Completo flujo comprar seguro bicicleta <opcion>
    And Valido mensaje fondos insuficientes

    Examples: 
      | tipoId | usuario      | contrasena | opcion |
      | "CC"   | "1004473738" | "2580"     | "2"    |

  @CP02202M @ya @passed
  Scenario Outline: CP02202M_SYS_Validar que el sistema debe aceptar TyC por opción 1 y por opción 2 se seguros de Bicicleta desde el Home
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual desde el home
    And ingreso a opcion seguros
    And Ingreso a cobertura primera bicicleta
    Then Validar TyC
    And Ingresar a cobertura segunda
    And Validar TyC

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "1004473738" | "2580"     |

  @CP100064M @ya @passed
  Scenario Outline: CP100064M_SYS_Validar proceso de compra microseguro de Mascotas opción 1 desde el Home
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual desde el home
    And ingreso a opcion seguros
    Then Completo flujo comprar seguro mascota MH <opcion> <raza>
    And validar compra de seguro

    Examples: 
      | tipoId | usuario   | contrasena | opcion | raza   |
      | "CC"   | "1100166" | "2580"     | "1"    | "gato" |

  @CP100063M @ya @passed
  Scenario Outline: CP100063M_SYS_Validar proceso de compra microseguro de Mascotas opción 2 desde el Home
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual desde el home
    And ingreso a opcion seguros
    And Completo flujo comprar seguro mascota MH <opcion> <raza>
    Then validar compra de seguro

    Examples: 
      | tipoId | usuario      | contrasena | opcion | raza   |
      | "CC"   | "1004473738" | "2580"     | "2"    | "gato" |

  @CP100065M @ya
  Scenario Outline: CP100065M_SYS_Validar proceso de compra microseguro de Mascotas opción 1 con cliente GMF desde el Home
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual desde el home
    And ingreso a opcion seguros
    And Completo flujo comprar seguro mascota MH <opcion> <raza>
    Then validar compra de seguro
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Validar en redeban seguros <usuario>
    And logout redeban

    Examples: 
      | tipoId | usuario      | contrasena | opcion | raza   |
      | "CC"   | "1004473743" | "2580"     | "1"    | "gato" |

  @CP100066M @ya
  Scenario Outline: CP100066M_SYS_Validar proceso de compra microseguro de Mascotas opción 2 con cliente GMF desde el Home
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual desde el home
    And ingreso a opcion seguros
    Then Completo flujo comprar seguro mascota MH <opcion> <raza>
    And validar compra de seguro
    And Validar en redeban seguros <usuario>
    And logout redeban

    Examples: 
      | tipoId | usuario    | contrasena | opcion | raza   |
      | "CC"   | "10050040" | "2589"     | "2"    | "gato" |

  @CP100067M @ya
  Scenario Outline: CP100067M_SYS_Validar proceso de compra microseguro de Mascotas opción 1 generando mensaje de fondos insuficientes desde el Home
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual desde el home
    And ingreso a opcion seguros
    Then Completo flujo comprar seguro mascota MH <opcion> <raza>
    And Valido mensaje fondos insuficientes

    Examples: 
      | tipoId | usuario    | contrasena | opcion | raza   |
      | "CC"   | "10050040" | "2589"     | "1"    | "gato" |

  @CP100068M @ya
  Scenario Outline: CP100068M_SYS_Validar proceso de compra microseguro de Mascotas opción 2 generando mensaje de fondos insuficientes desde el Home
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual desde el home
    And ingreso a opcion seguros
    Then Completo flujo comprar seguro mascota MH <opcion> <raza>
    And Valido mensaje fondos insuficientes

    Examples: 
      | tipoId | usuario    | contrasena | opcion | raza   |
      | "CC"   | "10050040" | "2589"     | "2"    | "gato" |

  @CP100069M @ya
  Scenario Outline: CP100069M_SYS_Validar que el sistema debe aceptar TyC por opción 1 y por opción 2 se seguros de Mascotas desde menú hamburguesa
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual desde el home
    And ingreso a opcion seguros
    And Ingreso a primera cobertura mascotas
    Then Validar TyC
    And Ingresar a cobertura segunda
    And Validar TyC

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10050040" | "2589"     |

  #???
  @CP100070M @ya
  Scenario Outline: CP100070M_SYS_Validar proceso de compra de microseguro de vida opción 1 desde tienda virtual
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    Then ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual
    And completar flujo comprar seguro <opcion> <genero>
    Then validar compra de seguro
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario    | contrasena | opcion | genero |
      | "CC"   | "52546839" | "1234"     | "1"    | "M"    |

  @CP100071M @ya
  Scenario Outline: CP100071M_SYS_Validar proceso de compra de microseguro de vida opción 2 desde tienda virtual
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    Then ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual
    And completar flujo comprar seguro <opcion> <genero>
    Then validar compra de seguro
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario    | contrasena | opcion | genero |
      | "CC"   | "52546839" | "1234"     | "2"    | "M"    |

  @CP100072M @passed
  Scenario Outline: CP100072M_SYS_Validar proceso de compra de microseguro de vida opción 1 con cliente GMF desde tienda virtual
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    And logout redeban al finalizar consulta
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata GMF
    When ingreso a tienda virtual desde el home
    And ingreso a opcion seguros
    And completar flujo comprar seguro <opcion> <genero>
    Then validar compra de seguro
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    And Extraer cobro GMF
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata GMF

    Examples: 
      | tipoId | usuario    | contrasena | opcion | genero |
      | "CC"   | "1100166" | "2580"     | "1"    | "M"    |

  @CP100073M @vida
  Scenario Outline: CP100073M_SYS_Validar proceso de compra de microseguro de vida opción 2 con cliente GMF desde tienda virtual
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    And logout redeban al finalizar consulta
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata GMF
    When ingreso a tienda virtual desde el home
    And ingreso a opcion seguros
    And completar flujo comprar seguro <opcion> <genero>
    Then validar compra de seguro
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    #And Extraer cobro GMF
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata GMF

    Examples: 
      | tipoId | usuario    | contrasena | opcion | genero |
      | "CC"   | "10050072" | "2589"     | "1"    | "M"    |

  @CP100074M @ya
  Scenario Outline: CP100074M_SYS_Validar proceso de compra de microseguro de vida opción 1 desde tienda virtual, que generen mensaje de fondos insuficientes
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual
    And completar flujo comprar seguro <opcion> <genero>
    Then Valido mensaje fondos insuficientes

    Examples: 
      | tipoId | usuario    | contrasena | opcion | genero |
      | "CC"   | "10050040" | "2589"     | "1"    | "M"    |

  @CP100075M @ya
  Scenario Outline: CP100075M_SYS_Validar proceso de compra de microseguro de vida opción 2 desde tienda virtual, que generen mensaje de fondos insuficientes
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual
    And completar flujo comprar seguro <opcion> <genero>
    Then Valido mensaje fondos insuficientes

    Examples: 
      | tipoId | usuario    | contrasena | opcion | genero |
      | "CC"   | "10050040" | "2589"     | "2"    | "M"    |

  @CP100076M @ya
  Scenario Outline: CP100076M_SYS_Validar proceso de compra de microseguro de vida desde tienda virtual ingresando una fecha que sea menor a 18 años y el sistema muestra mensaje
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual
    Then Completo flujo comprar seguro con fecha menor <opcion> <genero>
    And Valido mensaje

    Examples: 
      | tipoId | usuario    | contrasena | opcion | genero |
      | "CC"   | "10050040" | "2589"     | "2"    | "M"    |

  @CP100077M @ya
  Scenario Outline: CP100077M_SYS_Validar proceso de compra de microseguro de vida desde tienda virtual que muestra mensaje cuando ya se tiene un seguro adquirido
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual
    And completar flujo comprar seguro <opcion> <genero>
    Then Validar mensaje de que ya tiene seguro de vida

    Examples: 
      | tipoId | usuario      | contrasena | opcion | genero |
      | "CC"   | "1004473743" | "2580"     | "2"    | "M"    |

  @CP100078M @passed
  Scenario Outline: CP100078M_SYS_Validar proceso de compra de microseguro de bicicleta opción 1 desde tienda virtual
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual
    And completar flujo comprar seguro bicicleta <opcion>
    Then validar compra de seguro
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario    | contrasena | opcion |
      | "CC"   | "10050033" | "2589"     | "1"    |

  @CP100079M @SEGURO12
  Scenario Outline: CP100079M_SYS_Validar proceso de compra de microseguro de bicicleta opción 2 desde tienda virtual
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual
    And completar flujo comprar seguro bicicleta <opcion>
    Then validar compra de seguro
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario    | contrasena | opcion |
      | "CC"   | "10050039" | "2589"     | "2"    |

  @CP100080M @passed
  Scenario Outline: CP100080M_SYS_Validar proceso de compra de microseguro de bicicleta opción 1 desde tienda virtual muestra mensaje de fondos insuficiente
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual desde el home
    And completar flujo comprar seguro bicicleta <opcion>
    Then Valido mensaje fondos insuficientes
    And volver a capturar saldo final
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos
    
    Examples: 
      | tipoId | usuario     | contrasena | opcion | 
      | "CC"   | "100111515" | "2580"     | "1"    | 

  @CP100081M @passed
  Scenario Outline: CP100081M_SYS_Validar proceso de compra de microseguro de bicicleta opción 2 desde tienda virtual muestra mensaje de fondos insuficiente
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual desde el home
    And completar flujo comprar seguro bicicleta <opcion>
    Then Valido mensaje fondos insuficientes
    And volver a capturar saldo final
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario     | contrasena | opcion |
      | "CC"   | "100111515" | "2580"     | "2"    |

  @CP100082M @passed
  Scenario Outline: CP100082M_SYS_Validar proceso de compra de microseguro de mascota opción 1 desde tienda virtual
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual desde el home
    And Completo flujo comprar seguro mascota <opcion> <raza>
    Then validar compra de seguro
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata
    
    Examples: 
      | tipoId | usuario     | contrasena | opcion | raza   |
      | "CC"   | "1020770032" | "1234"     | "1"    | "gato" |


  @CP100083M @passed
  Scenario Outline: CP100083M_SYS_Validar proceso de compra de microseguro de mascota opción 2 desde tienda virtual
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual desde el home
    And Completo flujo comprar seguro mascota <opcion> <raza>
    Then validar compra de seguro
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario    | contrasena | opcion | raza   |
      | "CC"   | "1020770032" | "1234"     | "2"    | "gato" |

  @CP100084M @passed
  Scenario Outline: CP100084M_SYS_Validar proceso de compra de microseguro de mascota opción 1 desde tienda virtual muestra mensaje de fondos insuficiente
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual desde el home
    And Completo flujo comprar seguro mascota <opcion> <raza>
    Then Valido mensaje fondos insuficientes
    And volver a capturar saldo final
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario     | contrasena | opcion | raza   |
      | "CC"   | "100111515" | "2580"     | "1"    | "gato" |

  @CP100085M @passed
  Scenario Outline: CP100085M_SYS_Validar proceso de compra de microseguro de mascota opción 2 desde tienda virtual muestra mensaje de fondos insuficiente
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual desde el home
    And Completo flujo comprar seguro mascota <opcion> <raza>
    Then Valido mensaje fondos insuficientes
    And volver a capturar saldo final
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario     | contrasena | opcion | raza   |
      | "CC"   | "100111515" | "2580"     | "2"    | "gato" |
