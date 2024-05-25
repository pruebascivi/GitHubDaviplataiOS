@Referidos
Feature: Modulo de referidos

  @CP04000M @passed
  Scenario Outline: CP04000M_SYS_Validaciones del pop up referidos abierto por primera vez
    Given Ingresé al pop up de referidos <tipoId> <usuario> <contrasena>
    And Valido dos textos de la primera pantalla
    And Valido barra ilustrativa de avance entre pantallas
    And Valido que este presente un check obligatorio desmarcado
    And Valido que el check al marcarlo se encuentre activo en las dos pantallas
    And Regreso al home 
    When Valido la funcionalidad de la equis en el header
    And Salgo del header de referidos

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "17130497" | "2580"     |

 @CP04001M @passed
  Scenario Outline: CP04001M_SYS_Validaciones del pop up en el header de referidos
    Given Ingresé al pop up de referidos <tipoId> <usuario> <contrasena>
    And Regreso al home 
    When Valido la funcionalidad de la equis en el header
    And Salgo del header de referidos
    And Ingresé al pop up de referidos <tipoId> <usuario> <contrasena>
    And Valido el logo daviplata en referidos
    And Valido que el check al marcarlo se encuentre activo en las dos pantallas
    And Doy a continuar en el modulo invita a sus amigos
    And Valido modulo 'Gane plata invitando a sus amigos'
    And Ingreso al menu hamburguesa de referidos
    And Valido opcion mis ganancias
    And Valido el recuadro que refleja el dinero adquirido
    And Valido contadores de enlaces
    And Valido texto de referidos dentro de mis ganancias
    And Valido campos de busqueda por nombre y fecha de referidos
    And Valido lista de referidos
    And Valido opcion para invitar referidos
    And Valido la opcion registrarse en daviPlata
    And Valido el cuadro de texto con el link e icono de copiar
    And Valido los diferentes canales de compartir
    And Valido opciones para ganar dinero por invitar amigos
    Then Validar las opciones de compartir en cada medio de red social

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "17130494" | "2580"     | 