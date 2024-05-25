#Author: Gabo
@Nanocredito
Feature: Nanocredito

  @tag1
  Scenario Outline: Validar popUp y seleccionar la opcion no me interesa
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    And Verifico que aparece popUp de nanocredito
    And Verifico que el contenido del popUp sea <mensaje>
    And Verifico que aparezcan los botones "No me interesa" y "Autorizo"
    And selecciono el boton "No me interesa"
    And verifico que me encuentro en el inicio de la app

    Examples: 
      | tipoId                           | usuario    | contrasena | mensaje                                                                                                       |
      | "Selección Cédula de Ciudadanía" | "10333041" | "2580"     | "Davivienda tiene para usted un credito ¿Autoriza el tratamiendo de sus datos al banco para poder conocerlo?" |

  Scenario Outline: Validar popUp y seleccionar la opcion Autorizo
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    And Verifico que aparece popUp de nanocredito
    And Verifico que el contenido del popUp sea <mensaje>
    And Verifico que aparezcan los botones "No me interesa" y "Autorizo"
    And selecciono el boton "No me interesa"
    And verifico que me encuentro en la pantalla adquiera su credito
    And verifico las caracteristicas del producto "Nanocredito"
    And Valido que aparecen los botones "Regresar" y "Cerrar Sesion"
    And selecciono la opcion "Nanocredito"
    And selecciono la opcion "Continuar"
    And Vdrifico que aparezca la oferta de credito
    And ingreso un valor superior al permitido
    And verifico mensaje de valor limite superior "El monto solicitado supera la cantidad permitida"
    And ingreso un valor inferiror al permitido
    And verifico mensaje de valor limite inferiror "El monto solicitado es inferior al permitido"
    And verifico tooltip que muestre el rango permitido para la solicitud del nanocredito
    And selecciono la opcion continuar
    And Valido que aparecen los botones "Regresar" y "Cerrar Sesion"
    And Valido que me encuentro en la pantalla simulacion del valor solicitado
    And selecciono el tooltip valor de la cuota y verifico el valor de la cuota
    And selecciono la opcion "Continuar"
    And sellecciono tooltip valor fianza y verifico que se muestre la informacion
    And selecciono la opcion "Continuar"
    And selecciono que dia voy a pagar la cuota <diaCuota>
    And valido la tasa de interes en mes vencido y efectivo anual
    And selecciono tooltip interes y verifico la informacion
    And selecciono la opcion "Continuar"
    And selecciono tooltip valor total unificado y verifico la informacion
    And Selecciono la opcion "Continuar"
    And selecciono la opcion "Nueva Simulacion"
    And selecciono la opcion "Continuar"

    Examples: 
      | tipoId                           | usuario    | contrasena | mensaje                                                                                                       | <diaCuota> |
      | "Selección Cédula de Ciudadanía" | "10333041" | "2580"     | "Davivienda tiene para usted un credito ¿Autoriza el tratamiendo de sus datos al banco para poder conocerlo?" |         12 |
