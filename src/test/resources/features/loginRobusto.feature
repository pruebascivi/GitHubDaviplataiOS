#Author: Gabo
@LoginRobusto
Feature: Login Robusto
  Escenarios que permiten realizar login controlado

  @LoginRobusto
  Scenario Outline: Login
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app

    Examples: 
      | tipoId                           | usuario    | contrasena |
      | "Selección Cédula de Ciudadanía" | "10333041" | "2580"     |

  @CP0731M
  Scenario Outline: CP0731M_SYS_Validar funcionalidades en App Daviplata
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    And valido la opcion 'Cambiar mi numero' 
    And verifico la opcion 'Donde usar su DaviPlata'
    And validado presencia de la opcion 'Desactivar huella Face ID'
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    Then verifico que me encuentro en el inicio de la app

    Examples: 
      | tipoId                           | usuario    | contrasena |
      | "Selección Cédula de Ciudadanía" | "10333041" | "2580"     |
       	
       	
  @CP020842M @David
  Scenario Outline: CP020842M_SYS_Validar Login y version
    Given ingreso al aplicativo prueba
    And verifico la version prueba
    When ingreso las credenciales prueba <tipoId> <usuario> <contrasena>
    Then valido el ingreso prueba

    Examples: 
      | tipoId                           | usuario    | contrasena |
      | "Selección Cédula de Ciudadanía" | "10333041" | "2580"     |
       	
	@CP0732M @PASSED
	Scenario Outline: CP0732M_SYS_Validar productos en home daviplata
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingresar a bolsillos
    And Regreso al home desde bolsillos
    And Ingreso a tarjeta virtual
    And Regreso al home desde tarjeta virtual
    And Realizo scroll horizontal en barra de productos
    And Ingreso al cajon de seguros
    And Regreso al home desde tarjeta virtual
    And Realizo scroll horizontal en barra de productos
    And Ingreso a tienda virtual desde el cajon del home
    And Regreso al home desde tarjeta virtual
    And Realizo scroll horizontal hasta el final de la barra de productos
    Then Validar cajon de mas productos en la barra de productos
    And Ingresar al modulo de mis productos
    And Validar modulo mis productos
    
    Examples: 
      | tipoId | usuario    | contrasena | 
      | "CC"   | "10050099" | "2589"     |
      
