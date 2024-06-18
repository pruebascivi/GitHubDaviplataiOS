@PasarPlataEnLinea
Feature: Set de pasar plata en linea

  @CP03600M @Passed
  Scenario Outline: CP03600M_SYS_Validar proceso por la opción a otro banco en línea a un daviplata
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    When ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And ir a la opcion TransfiYA
    And Realizo flujo pasar plata transfiya <numCelular> <monto>
    And valido resultado transaccion exitosa
    And validar saldo final
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario    | contrasena | numCelular   | monto   |
      | "CC"   | "10050066" | "2589"     | "3227680744" | "11000" |

  @CP03610M @passed
  Scenario Outline: CP03610M_SYS_Validar proceso por la opción a otro banco en línea a un daviplata y realizando aceptacion
    Given obtener numero celular actual en redeban bolsillos <usuario2>
    And Consulté saldo disponible en redeban
    Then logout redeban al finalizar consulta
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And ir a la opcion 'Recibir y Pedir Plata'
    When realizo flujo pedir plata en linea <numCelular> <monto>
    And valido resultado transaccion exitosa
    And Regreso al home desde trasnsaccion
    And Salir de la app
		And ingreso usuario y contrasena sin capturar saldo <tipoId2> <usuario2> <contrasena2>
    And Ir a la opcion 'Recibir y Pedir Plata' validando solicitud
    And Valido solicitudes de plata pendientes 
    And aceptar solicitud pendiente <monto>
    And validar transaccion destino
    And obtener numero celular actual en redeban bolsillos <usuario2>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar afectacion de saldos en redeban y daviplata
		
    Examples: 
      | tipoId | usuario    | contrasena | numCelular   | monto  | tipoId2 | usuario2   | contrasena2 |
      | "CC"   | "10333040" | "1234"     | "3221005049" | "5000" | "CC"    | "10050066" | "2589"      |

  @CP03620M
  Scenario Outline: CP03620M_SYS_Validar proceso por la opción a otro banco en línea a un daviplata con daviplata origen GMF
    Given obtener numero celular actual en redeban <usuario>
    And consultar saldo tarjeta en redeban pasar plata cuenta
    And logout redeban
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And ir a la opcion 'Recibir y Pedir Plata'
    When realizo flujo pedir plata en linea <numCelular> <monto>
    And valido resultado transaccion exitosa
    And Regreso al home desde trasnsaccion
    And obtener numero celular actual en redeban <usuario>
    And consultar saldo tarjeta en redeban pasar plata cuenta
    Then valido afectacion cuenta en redeban GMF <monto>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario    | contrasena | numCelular   | monto  |
      | "CC"   | "10050018" | "2589"     | "3227680754" | "2000" |


  @CP03650M
  Scenario Outline: CP03650M_SYS_Validar proceso por la opción a otro banco en línea de pedir plata
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And ir a la opcion TransfiYA
    When realizo flujo pedir plata en linea <numCelular> <monto>
    And valido resultado transaccion exitosa
    And validar saldo final
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario      | contrasena | numCelular   | monto  |
      | "CC"   | "1020770053" | "1342"     | "3227680754" | "2000" |

  @CP03660M @PASSED
  Scenario Outline: CP03660M_SYS_Validar proceso por la opción a otro banco en línea de pedir plata con cliente origen GMF
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata GMF
    And ir a la opcion 'Recibir y Pedir Plata'
    When Realizo el flujo de 'Pedir Plata en Linea' <numCelular> <monto>
    And valido resultado transaccion exitosa
    And validar saldo final
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    And logout redeban

    Examples: 
      | tipoId | usuario    | contrasena | numCelular   | monto  |
      | "CC"   | "10050099" | "2589"     | "3227680754" | "2000" |

  @CP03670M @Passed
  Scenario Outline: CP03670M_SYS_Validar proceso por la opción a otro banco en línea de pedir plata realizando proceso de aceptacion.
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And ir a la opcion 'Recibir y Pedir Plata'
    When realizo flujo pedir plata en linea <numCelular> <monto>
    And valido resultado transaccion exitosa
    And Regreso al home desde trasnsaccion
    And Salir de la app
    When obtener numero celular actual en redeban bolsillos <usuario2>
    And Consulté saldo disponible en redeban
    Then logout redeban al finalizar consulta
    And ingreso usuario y contrasena sin capturar saldo <tipoId2> <usuario2> <contrasena2>
    And Ir a la opcion 'Recibir y Pedir Plata' validando solicitud
    And Valido solicitudes de plata pendientes 
    And aceptar solicitud pendiente <monto>
    And validar transaccion destino
    And obtener numero celular actual en redeban bolsillos <usuario2>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario       | contrasena | numCelular   | monto  | tipoId2 | usuario2    | contrasena2 |
			| "CC"   | "10333040"    | "1234"     | "3221005049" | "1000" | "CC"    | "10050066"  | "2589"      |

  @CP03680M @Passed
  Scenario Outline: CP03680M_SYS_Validar proceso por la opción a otro banco en línea de pedir plata realizando proceso de rechazo.
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And ir a la opcion 'Recibir y Pedir Plata'
    When realizo flujo pedir plata en linea <numCelular> <monto>
    And valido resultado transaccion exitosa
    And Regreso al home desde trasnsaccion
    And Salir de la app
    When obtener numero celular actual en redeban bolsillos <usuario2>
    And Consulté saldo disponible en redeban
    Then logout redeban al finalizar consulta
    And ingreso usuario y contrasena sin capturar saldo <tipoId2> <usuario2> <contrasena2>
    And Ir a la opcion 'Recibir y Pedir Plata' validando solicitud
    And Valido solicitudes de plata pendientes 
    And rechazar solicitud pendiente <monto>
    And valido resultado solicitud rechazada
    And obtener numero celular actual en redeban bolsillos <usuario2>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta

    Examples: 
      | tipoId | usuario       | contrasena | numCelular     | monto  | tipoId2 | usuario2   | contrasena2 |
			| "CC"   | "10050066"    | "2589"     | "3003633350"   | "1000" | "CC"    | "10333040" | "1234"      |

  @CP03690M @pasarplata12
  Scenario Outline: CP03690M_SYS_Validar proceso por la opción a otro banco en línea de pedir plata con cliente origen GMF y realizar rechazo
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And ir a la opcion 'Recibir y Pedir Plata'
    When realizo flujo pedir plata en linea <numCelular> <monto>
    And valido resultado transaccion exitosa
    And Regreso al home desde trasnsaccion
    And Salir de la app
    When obtener numero celular actual en redeban bolsillos <usuario2>
    And Consulté saldo disponible en redeban
    Then logout redeban al finalizar consulta
    And ingreso usuario y contrasena sin capturar saldo <tipoId2> <usuario2> <contrasena2>
    And Ir a la opcion 'Recibir y Pedir Plata' validando solicitud
    And Valido solicitudes de plata pendientes 
    And rechazar solicitud pendiente <monto>
    And valido resultado solicitud rechazada
    And obtener numero celular actual en redeban bolsillos <usuario2>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta

    Examples: 
      | tipoId | usuario      | contrasena | numCelular   | monto  | tipoId2 | usuario2     | contrasena2 |
      | "CC"   | "1020770054" | "1342"     | "3227680754" | "2000" | "CC"    | "1020770032" | "1342"      |

  @CP03700M @pasarplata12
  Scenario Outline: CP03700M_SYS_Validar proceso donde el destino cuando se le pide dinero, y el origen no tiene suficiente en el disponible.
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And ir a la opcion TransfiYA
    When realizo flujo pedir plata en linea <numCelular> <monto>
    And valido resultado transaccion exitosa
    And Regreso al home desde trasnsaccion
    And Salir de la app
    When obtener numero celular actual en redeban bolsillos <usuario2>
    And Consulté saldo disponible en redeban
    Then logout redeban al finalizar consulta
    And ingreso usuario y contrasena del segundo usuario <tipoId2> <usuario2> <contrasena2>
    And ir a la opcion TransfiYA
    And aceptar solicitud pendiente <monto>
    And valido resultado transaccion rechazada
    And obtener numero celular actual en redeban bolsillos <usuario2>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario      | contrasena | numCelular   | monto     | tipoId2 | usuario2     | contrasena2 |
      | "CC"   | "1020770054" | "1342"     | "3227680732" | "1000000" | "CC"    | "1020770068" | "1342"      |

  @CP03710M @pasarplata12
  Scenario Outline: CP03710M_SYS_Validar que al hacer tap en el icono que está al lado de link tip (A otro banco en línea) el sistema muestra mensaje con una descripción y botón aceptar
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ir a la opcion TransfiYA
    Then valido descripcion pop up TransfiYa

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "1020770054" | "1342"     |

  @CP03720M @pasarplata12
  Scenario Outline: CP03720M_SYS_Validar que el sistema muestra la lista de pagos frecuente en el link A otro banco en línea en Abonos frecuentes
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And ir a la opcion TransfiYA
    When selecciono opcion Abonos Frecuentes
    Then valido lista contactos abonos frecuentes

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "1020770054" | "1342"     |
      
  @CP00M
  Scenario Outline: CP03720M_SYS_Validar que el sistema muestra la lista de pagos frecuente en el link A otro banco en línea en Abonos frecuentes
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And ir a la opcion TransfiYA
    When selecciono opcion Abonos Frecuentes
    Then valido lista contactos abonos frecuentes

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "1020770054" | "1342"     |
           
  @CP03640M @DiseñadoCompletoPeroPresenteDefecto
  Scenario Outline: CP03640M_SYS_Validar proceso por la opción a otro banco en línea a un daviplata y realizando rechazo
    Given obtener numero celular actual en redeban <usuario>
    And consultar saldo tarjeta en redeban pasar plata cuenta
    And logout redeban
    When ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And ir a la opcion TransfiYA
    And realizo flujo pasar plata en linea <numCelular> <monto>
    And valido resultado transaccion exitosa
    And logout app
    And ingreso usuario y contrasena <tipoId2> <usuario2> <contrasena2>
    And ir a la opcion TransfiYA
    And rechazar solicitud pendiente <monto>
    And valido resultado solicitud rechazada
    Given obtener numero celular actual en redeban <usuario>
    And consultar saldo tarjeta en redeban pasar plata cuenta
    Then valido igualdad saldos en redeban
    And logout redeban

    Examples: 
      | tipoId | usuario      | contrasena | numCelular   | monto  | tipoId2 | usuario2  | contrasena2 |
			| "CC"   | "1020770006" | "1234"     | "3213702112" | "2000" | "CC"    | "1007708" | "1234"      |
			
	@CP037302M @DiseñadoCompletoPeroPresenteDefecto
  Scenario Outline: CP037302M_SYS_Validar que al dar tap en el boton (+) Se muestre la pantalla de "que quiere hacer con su plata"
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And ir a la opcion más Home
    Then Valido la opción recibir y pedir plata
    And Ingreso a las solicitudes de TransfiYa

    Examples: 
      | tipoId | usuario      | contrasena |
			| "CC"   | "10050022"   | "2589"		 |
