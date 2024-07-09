@ecard
Feature: Agrupacion de casos de ecard

  @CP0841M
  Scenario Outline: CP0841M_SYS_Validar proceso de creación de tarjeta virtual desde el Home del daviplata
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tarjeta de credito
    And crear tarjeta de credito
    Then valido creacion sin recarga

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "19758461" | "1234"     |

  @CP0842M @PASSED
  Scenario Outline: CP0842M_SYS_Validar el proceso de recargar la tarjeta Virtual
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tarjeta de credito
    And recargo tarjeta credito <monto>
    Then valido recarga exitosa

    Examples: 
      | tipoId | usuario    | contrasena | monto   |
      | "CC"   | "19758461" | "1234"     | "10000" |

  @CP1062M
  Scenario Outline: CP1062M_SYS_Validar el proceso de bloqueo de la tarjeta Virtual
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tarjeta de credito
    And selecciono Bloquear Tarjeta
    Then valido Bloqueo Tarjeta

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "19758461" | "1234"     |

  @CP11630M @Passed
  Scenario Outline: CP11630M_SYS_Validar el proceso de mostrar movimientos de la tarjeta virtual
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tarjeta de credito
    And selecciono Movimientos Tarjeta
    Then valido visualizacion movimientos

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10050066" | "2589"     |

  @CP1164M
  Scenario Outline: CP1164M_SYS_Validar el proceso de ver datos de tarjeta virtual
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tarjeta de credito
    And click boton Ver datos Tarjeta
    Then valido datos tarjeta

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "19758461" | "1234"     |

  @CP1165M
  Scenario Outline: CP1165M_SYS_Validar mensaje para recarga a tarjeta virtual cuando no hay suficiente disponible
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tarjeta de credito
    And recargar tarjeta sin disponible
    Then validar mensaje de saldo insuficiente

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10050078" | "2589"     |

  @CP1068M
  Scenario Outline: CP1068M_SYS_Validar tope actual en la recarga Tarjeta virtual
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tarjeta de credito
    And recargo tarjeta credito <monto>
    Then Validar mensaje de topes en tarjeta virtual

    Examples: 
      | tipoId | usuario    | contrasena | monto |
      | "CC"   | "19758461" | "1234"     | "10000" |
      
  # No permite la consulta de la web notificaciones por falta de permisos de la rede banco en la macbook
  @CP0870M
  Scenario Outline: CP0870M_SYS_Validar que se genere el CVV de la eCard,  dando clic al logo de la tarjeta
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tarjeta de credito
    And click imagen tarjeta
    Then Valido en web consultas <numCel>

    Examples: 
      | tipoId | usuario    | contrasena | numCel       |
      | "CC"   | "19758461" | "1234"     | "3124851065" |

  @CP0880M
  Scenario Outline: CP0880M_SYS_Validar que se pueda consultar los datos de la eCard, dando clic al botón de ver datos
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tarjeta de credito
    And click boton Ver datos Tarjeta
    Then valido datos tarjeta

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "19758461" | "1234"     |
      
  # No permite la consulta de la web notificaciones por falta de permisos de la rede banco en la macbook
  @CP0890M
  Scenario Outline: CP0890M_SYS_Validar que se genere el CVV de la eCard, dando clic al botón de ver datos
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tarjeta de credito
    And click boton Ver datos Tarjeta
    Then Valido en web consultas <numCel>

    Examples: 
      | tipoId | usuario    | contrasena | numCel       |
      | "CC"   | "19758461" | "1234"     | "3003633335" |

  @CP0920M
  Scenario Outline: CP0920M_SYS_Validar que no permita realizar la recarga cuando la tarjeta esta restringida
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tarjeta de credito
    And recargo tarjeta credito <monto>
    Then valido recarga negada

    Examples: 
      | tipoId | usuario    | contrasena | monto   |
      | "CC"   | "19758461" | "1234"     | "10000" |

  @CP0930M
  Scenario Outline: CP0930M_SYS_Validar que no permita realizar la recarga cuando supero cupo de la eCard
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tarjeta de credito
    And recargo tarjeta credito <monto>
    Then Validar mensaje de topes en tarjeta virtual

    Examples: 
      | tipoId | usuario    | contrasena | monto |
      | "CC"   | "19758461" | "1234"     | "10000" |

  @CP1071M
  Scenario Outline: CP1071M_SYS_Validar que no permita realizar la recarga cuando supero cupo del DaviPlata
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tarjeta de credito
    And recargo tarjeta credito <monto>
    Then Validar mensaje de topes en tarjeta virtual

    Examples: 
      | tipoId | usuario    | contrasena | monto   |
      | "CC"   | "19758461" | "1234"     | "10000" |

  @CP0860M
  Scenario Outline: CP0860M_SYS_Validar que se pueda consultar los datos de la eCard, dando clic al logo de la tarjeta
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tarjeta de credito
    And click imagen tarjeta
    Then valido datos tarjeta

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "19758461" | "1234"     |

  @CP0950M
  Scenario Outline: CP0950M_SYS_Validar que se visualicen los movimientos de la eCard
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tarjeta de credito
    And selecciono Movimientos Tarjeta
    Then valido visualizacion movimientos

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "19758461" | "1234"     |

  @CP0960M
  Scenario Outline: CP0960M_SYS_Validar que se pueda bloquear la eCard
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tarjeta de credito
    And selecciono Bloquear Tarjeta
    Then valido Bloqueo Tarjeta

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "19758461" | "1234"     |
