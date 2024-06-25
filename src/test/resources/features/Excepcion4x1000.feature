@Excepcion4x1000
Feature: casos Excepcion 4x1000

  @CP03300M
  Scenario Outline: CP03300M_SYS_Validar que deje realizar el proceso de Exención de 4x1000
    Given consulto el estado actual excenta 4x1000 en redeban <usuario>
    And logout redeban al finalizar consulta estado excenta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso al header home
    And Ingreso al desplegable solicitudes
    And selecciono opcion exencion 4x1000
    Then valido exencion exitosa
    And pulso boton finalizar

    Examples: 
      | tipoId | usuario   | contrasena |
      | "CC"   | "1020770034" | "1342"     |

  @CP03310M
  Scenario Outline: CP03310M_SYS_Validar que no muestre link si el cliente es No Excento
    #Given consulto el estado actual excenta 4x1000 en redeban <usuario>
    #And logout redeban al finalizar consulta estado excenta
    #And validar estado de exencion <estado>
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso al header home
    And Ingreso al desplegable solicitudes
    And selecciono opcion exencion 4x1000
    Then valido exencion no exitosa
    And pulso boton finalizar

    Examples: 
      | tipoId | usuario    | contrasena | estado    |
      | "CC"   | "10050066" | "2589"     |"No Exenta"|

  @CP03560M
  Scenario Outline: CP03560M_SYS_Validar que no muestre link si el cliente es Excento
    Given consulto el estado actual excenta 4x1000 en redeban <usuario>
    And logout redeban al finalizar consulta estado excenta
    And validar estado de exencion <estado>
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso al header home
    And Ingreso al desplegable solicitudes
    And valido opcion exencion 4x1000

    Examples: 
      | tipoId | usuario      | contrasena |estado|
      | "CC"   | "1020770034" | "1342"     |"Exenta"|

  @CP03320M @PassedSinRedeban
  Scenario Outline: CP03320M_SYS_Validar que si el cliente es no aplica muestre link
    Given consulto el estado actual excenta 4x1000 en redeban <usuario>
    And logout redeban al finalizar consulta estado excenta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso al header home
    And Ingreso al desplegable solicitudes
    And selecciono opcion exencion 4x1000
    Then valido exencion exitosa
    And pulso boton finalizar

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10050066" | "2589"     |
