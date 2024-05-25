  @Marketplace
Feature: Set PruebasMarketplace

  @CP1040M @MarketplaceSet11
  Scenario Outline: CP1040M_SYS_Validar primer ingresó a tienda virtual que muestra pop up de TyC
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual
    Then Valido terminos marketplace

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10333041" | "2580"     |

  @CP0370M @MarketplaceSet11
  Scenario Outline: CP0370M_SYS_Validar que al ingresar por Pagos desde el Home Daviplata el sistema lleve al usuario a la Tienda Virtual y lo deje en la pestaña de pagos de servicios
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a opcion pagar
    Then Validar pestaña pagos de servicios

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "1020770032" | "1342"     |

  @CP0330M @MarketplaceSet11
  Scenario Outline: CP0330M_SYS_Validar que al ingresar por Recargas desde el Home Daviplata el sistema lleve al usuario a la Tienda Virtual y lo deje en la pestaña de Recargas
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a opcion recargas
    Then Validar pestaña recargas

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "1020770032" | "1342"     |

  @CP0331M @passed
  Scenario Outline: CP0331M_SYS_Validar que la franja de Nuestro aliados se ve en la mitad de la pantalla
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual
    Then Valido que la franja de Nuestro aliados se ve en la mitad

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10050033" | "2589"     |

  @CP0332M @MarketplaceSet11
  Scenario Outline: CP0332M_SYS_Validar que al hacer tap en la franja nuestros aliados, se evidencie la pantalla con sus categorías
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual
    Then Valido que al hacer tap se evidencie la pantalla con sus categorías

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "1020770032" | "1234"     |

  @CP03330M @MarketplaceSet11
  Scenario Outline: CP03330M_SYS_Validar que la franja de categorías tenga scroll de forma horizontal tanto a la derecha como a la izquierda.
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual
    Then Valido scroll horizontal categorias

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10050099" | "2589"     |

  @CP1380M @MarketplaceSet11
  Scenario Outline: CP1380M_SYS_Validar ingresó a través de pagos y recargas del Home Daviplata por primera vez el sistema no muestra pop up de TyC
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a opcion pagar
    Then Validar que no aparezca terminos marketplace

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "20001" | "1234"     |

  @CP1381M @MarketplaceSet11
  Scenario Outline: CP1381M_SYS_Validar que si ingresó por primera vez a tienda por pagos y recargas del de Home de Daviplata y va a comprar algo de nuestros aliados muestra pop up TyC
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a opcion pagar
    And Comprar algo de los aliados
    Then Valido terminos marketplace

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "10050073" | "2589"     |

  @CP1382M @MarketplaceSet11
  Scenario Outline: CP1382M_SYS_Validar ingresó a tienda virtual luego de aceptar TyC no volver a mostrar pop up
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual
    And Acepto terminos y condiciones
    Then Validar que no aparezca terminos marketplace

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "10050073" | "2589"     |

  @CP1383M 
  Scenario Outline: CP1383M_SYS_Validar proceso de compra de tienda virtual de restaurantes
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a tienda virtual
    And Completo el flujo compra Bono con correo
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "19758462" | "1234"     |

  @CP03340M @MarketplaceSet12
  Scenario Outline: CP03340M_SYS_Validar proceso de compra de tienda virtual de vestuario
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual
    Then completo flujo comprar vestuario
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario      | contrasena | categoria   |
      | "CC"   | "1020770032" | "1234"     | "Vestuario" |

  @CP03350M @MarketplaceSet12
  Scenario Outline: CP03350M_SYS_Validar proceso de compra de tienda virtual de cines
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual
    Then completo flujo comprar cine
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario   | contrasena | categoria |
      | "CC"   | "1020770032" | "1234"     | "Cines"   |

  @CP1384M @MarketplaceSet12
  Scenario Outline: CP1384M_SYS_Validar proceso de compra de tienda virtual de restaurantes con usuarios GMF
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata GMF
    When ingreso a tienda virtual
    And Completo el flujo compra Bono con correo
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    And Extraer cobro GMF
    And logout redeban
    Then Validar afectacion de saldos en redeban y daviplata GMF

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10050034" | "2589"     |

  @CP1385M @MarketplaceSet12
  Scenario Outline: CP1385M_SYS_Validar proceso de compra de tienda virtual de vestuario con usuarios GMF
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    And logout redeban al finalizar consulta
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata GMF
    When ingreso a tienda virtual
    And dar click btn <categoria>
    Then completo flujo comprar vestuario
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    And Extraer cobro GMF
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata GMF

    Examples: 
      | tipoId | usuario    | contrasena | categoria   |
      | "CC"   | "100111511" | "2580"     | "Vestuario" |

  @CP1386M @MarketplaceSet12
  Scenario Outline: CP1386M_SYS_Validar proceso de compra de tienda virtual de cines con usuarios GMF
    Given obtener numero celular actual en redeban marketplace <usuario>
    And consultar saldo tarjeta en redeban marketplace
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual
    And dar click btn <categoria>
    Then completo flujo comprar cine
    And obtener numero celular actual en redeban marketplace <usuario>
    And consultar saldo tarjeta en redeban marketplace
    And validar igualdad saldos tarjetas marketplace
    And logout redeban al finalizar consulta

    Examples: 
      | tipoId | usuario    | contrasena | categoria |
      | "CC"   | "100111512" | "2580"     | "Cines"   |
      
  @CP03360M @MarketplaceSet12
  Scenario Outline: CP03360M_SYS_Validar que bono de compra de tienda virtual quede en la campana y se pueda abrir como descargar
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual
    And Completo el flujo compra Bono con correo
    Then Valido que el bono quede en la campana y se pueda abrir

    Examples: 
      | tipoId | usuario   | contrasena | 
      | "CC"   | "19758462" | "1234"     |

  @CP03370M @MarketplaceSet12
  Scenario Outline: CP03370M_SYS_Validar que proceso de compra de tienda virtual deje compartir el bono y descargarlo entes de la pantalla transacción exitosa
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual
    And Realizo compra de bono para compartir y descargar la compra
    Then Validar opciones de compartir y descargar bono

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "19758462" | "1234"     |

  @CP1150M @MarketplaceSet12
  Scenario Outline: CP1150M_SYS_Validar que no permita comprar bono sin escribir un correo
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual
    Then Completo el flujo compra Bono sin correo

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "20001" | "1234"     |

  @CP1261M @PASSED
  Scenario Outline: CP1261M_SYS_Validar boton flotante en las pantallas del banco (Necesito ayuda)
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a modulo pagar
    Then Completo el flujo pago de servicio y validar necesito ayuda

    Examples: 
      | tipoId | usuario    | contrasena |
			| "CC"   | "10333041" | "2580"     |

  @CP1270M @Marketplace13
  Scenario Outline: CP1270M_SYS_Validar boton volver en todas las pantallas del proceso tienda virtual
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual
    Then flujo de compra validando volver

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "19758462" | "1234"     |

  @CP1230M @Marketplace13
  Scenario Outline: CP1230M_SYS_Validar navegacion de aliados por categorias
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual
    Then Valido aliados por categorias

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "19758462" | "1234"     |

  @CP1510M @Marketplace13
  Scenario Outline: CP1510M_SYS_Validar el boton volver en el flujo compra de seguro Mascota.
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual
    Then Completo flujo comprar seguro mascota volver atras <opcion> <raza>

    Examples: 
      | tipoId | usuario    | contrasena | opcion | raza    |
      | "CC"   | "10050091" | "2589"     | "1"    | "perro" |

  @CP1131M @Marketplace13
  Scenario Outline: CP1131M_SYS_Validar que no permita la compra de SOAT de una placa invalida
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tienda virtual
    Then Completo flujo comprar seguro soat plata invalida <usuario> <placa>
    And valido que soat invalido

    Examples: 
      | tipoId | usuario    | contrasena | placa    |
      | "CC"   | "20001" | "1234"     | "TFR543" |
      
   @CP1511M
   Scenario Outline: CP1511M_SYS_Validar funcionalidad botón Movilidad
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso al boton movilidad

    Examples: 
      | tipoId | usuario     | contrasena | 
      | "CC"   | "10050099"  | "2589"     | 
      
      
