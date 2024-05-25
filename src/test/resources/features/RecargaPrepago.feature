@RecargaPrepago
Feature: Agrupación de casos Recarga prepago

  @CP0340M @RecargaPrepago10
  Scenario Outline: CP0340M_SYS_Validar proceso de recarga desde tienda virtual para operador movistar y verificar campo switch en web redeban
  	Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And ingreso a tienda virtual
    And ingresar a operador seleccionado <operador>
    And diligenciar formulario paquetes movistar <numero>
    And validar saldos por recarga
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario      | contrasena | operador   | numero       |
      | "CC"   | "1020770043" | "1342"     | "movistar" | "3176582733" |

  @CP0341M
  Scenario Outline: CP0341M_SYS_Validar proceso de recarga desde tienda virtual para operador movistar por valor no superior a 500000 y verificar campo switch en web redeban
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And ingreso a tienda virtual
    And ingresar a operador seleccionado <operador>
    And diligenciar formulario paquetes movistar <numero>
    And validar boton inhabilitado

    Examples: 
      | tipoId | usuario      | contrasena | operador   | numero       |
      | "CC"   | "1020770043" | "1342"     | "movistar" | "3176582733" |

  @CP0351M  @RecargaPrepago10
  Scenario Outline: CP0351M_SYS_Validar proceso de recarga desde tienda virtual para operador movistar por cantidad de transacciones al dia no superior a 8 y verificar campo switch en web redeban
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And ingreso a tienda virtual
    And completar flujo de recarga de paquetes <numveces> <numero>
    And validacion de saldo despues de las transacciones
    When llenar autorizadores test
		And validar en redeban autorizaciones <usuario>
		And logout redeban
    Examples: 
      | tipoId | usuario   | contrasena | operador   | numveces | numero       |
      | "CC"   | "10050050" | "2589"     | "movistar" | "2"      | "3176582733" |

  @CP0361M @RecargaPrepago10
  Scenario Outline: CP0361M_SYS_Validar proceso de recarga desde tienda virtual para operador movistar y verificar campo switch en web redeban
   Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And ingreso a tienda virtual
    And ingresar a operador seleccionado <operador>
    And diligenciar formulario paquetes movistar <numero>
    And validar saldos por recarga
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario      | contrasena | operador   | numero       |
      | "CC"   | "1020770043" | "1342"     | "movistar" | "3176582733" |

  @CP0371M @RecargaPrepago10
  Scenario Outline: CP0371M_SYS_Realizar recarga a dispositivo celular con cliente GMF.
  	Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata GMF
    And ingreso a tienda virtual
    And ingresar a operador seleccionado <operador>
    And diligenciar formulario paquetes movistar <numero>
    And validar saldos por recarga
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    And Extraer cobro GMF
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata GMF



    Examples: 
      | tipoId | usuario      | contrasena | operador   | numero       |
      | "CC"   | "1020770053" | "1342"     | "movistar" | "3176582733" |

  @CP0381M @RecargaPrepago10
  Scenario Outline: CP0381M_SYS_Realizar recarga a dispositivo celular con Fondos insuficientes.
  	Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta  
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And ingreso a tienda virtual
    And ingresar a operador seleccionado <operador>
    And diligenciar formulario paquetes movistar fondos insuficientes <numero>
    And validar mensaje saldo insuficiente
		And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario   | contrasena | operador   | numero       |
      | "CC"   | "1020770051" | "1342"     | "movistar" | "3176582733" |

  @CP0391M @RecargaPrepago10
  Scenario Outline: CP0391M_SYS_Realizar recarga a dispositivo celular con a operador MOVISTAR
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And ingreso a tienda virtual
    And ingresar a operador seleccionado <operador>
    And diligenciar formulario paquetes movistar <numero>
    And validar saldos por recarga
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario      | contrasena | operador   | numero       |
      | "CC"   | "1020770043" | "1342"     | "movistar" | "3176582733" |

  @CP0401M @RecargaPrepago10
  Scenario Outline: CP0401M_SYS_Realizar recarga a dispositivo celular sin cliente GMF.
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And ingreso a tienda virtual
    And ingresar a operador seleccionado <operador>
    And diligenciar formulario paquetes movistar <numero>
    And validar saldos por recarga
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario      | contrasena | operador   | numero       |
      | "CC"   | "1020770032" | "1234"     | "movistar" | "3227680738" |

  @CP0411M @RecargaPrepago10
  Scenario Outline: CP0411M_SYS_Validar recarga exitosa con usuario BMO
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    Then ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And ingreso a tienda virtual
    And ingresar a operador seleccionado <operador>
    And diligenciar formulario paquetes movistar <numero>
    And validar saldos por recarga
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario      | contrasena | operador   | numero       |
      | "CC"   | " 1020770043" | "1342"     | "movistar" | "3176582733" |

  @CP0412M @RecargaPrepago10
  Scenario Outline: CP0412M_SYS_Validar recarga exitosa con usuario MET
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    Then ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And ingreso a tienda virtual
    And ingresar a operador seleccionado <operador>
    And diligenciar formulario paquetes movistar <numero>
    And validar saldos por recarga
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario   | contrasena | operador   | numero       |
      | "CC"   | "10050100" | "2589"     | "movistar" | "3176582733" |

  @CP0413M @RecargaPrepago10
  Scenario Outline: CP0413M_SYS_Validar recarga exitosa con usuario RA3
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    Then ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And ingreso a tienda virtual
    And ingresar a operador seleccionado <operador>
    And diligenciar formulario paquetes movistar <numero>
    And validar saldos por recarga
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario   | contrasena | operador   | numero       |
      | "CC"   | "10050095" | "2589"     | "movistar" | "3176582733" |

  @CP0421M @RecargaPrepago20
  Scenario Outline: CP0421M_SYS_Validar recarga exitosa con tipo ID C.C
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    Then ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And ingreso a tienda virtual
    And ingresar a operador seleccionado <operador>
    And diligenciar formulario paquetes movistar <numero>
    And validar saldos por recarga
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario   | contrasena | operador   | numero       |
      | "CC"   | "1020770032" | "1342"     | "movistar" | "3176582733" |

  @CP0422M @RecargaPrepago20
  Scenario Outline: CP0422M_SYS_Validar recarga exitosa con tipo ID T.I
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    Then ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And ingreso a tienda virtual
    And ingresar a operador seleccionado <operador>
    And diligenciar formulario paquetes movistar <numero>
    And validar saldos por recarga
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario   | contrasena | operador   | numero       |
      | "TI"   | "1022983" | "1234"     | "movistar" | "3176582733" |

  @CP0423M  @RecargaPrepago20
  Scenario Outline: CP0423M_SYS_Validar recarga exitosa con tipo ID C.E
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    Then ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And ingreso a tienda virtual
    And ingresar a operador seleccionado <operador>
    And diligenciar formulario paquetes movistar <numero>
    And validar saldos por recarga
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario           | contrasena | operador   | numero       |
      | "CE"   | "90062810018" | "2580"     | "movistar" | "3227680732" |

  @CP0431M  @RecargaPrepago20
  Scenario Outline: CP0431M_SYS_Validar el número de autorización en Web RBM
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    Then ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And ingreso a tienda virtual
    And ingresar a operador seleccionado <operador>
    And diligenciar formulario paquetes movistar <numero>
    And validar saldos por recarga
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario           | contrasena | operador   | numero       |
      | "CC"   | "1020770032" | "1342"     | "movistar" | "3176582733" |

  @CP0441M  @RecargaPrepago20
  Scenario Outline: CP0441M_SYS_Validar saldos desde la Web RBM
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    Then ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And ingreso a tienda virtual
    And ingresar a operador seleccionado <operador>
    And diligenciar formulario paquetes movistar <numero>
    And validar saldos por recarga
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario           | contrasena | operador   | numero       |
      | "CC"   | "1020770032" | "1342"     | "movistar" | "3176582733" |
