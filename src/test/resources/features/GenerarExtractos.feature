@GenerarExtractos
Feature: Pruebas en la funcionalidad de generación de extractos de la app Daviplata.

  @CP80001M
  Scenario Outline: CP80001M_SYS_Validar proceso de generación de extractos
    Given Ingreso usuario y contrasena en nanocredito <tipoId> <usuario> <contrasena>
    And Cerre popup nanocredito
    When Ingreso a extractos
    And Genero extractos
    Then Validar generación de extracto

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "1020770004" | "1234"     |

  @CP80002M
  Scenario Outline: CP80002M_SYS_Validar que deje seleccionar la fecha de extracto
    Given Ingreso usuario y contrasena en nanocredito <tipoId> <usuario> <contrasena>
    And Cerre popup nanocredito
    When Ingreso a extractos
    And Genero extractos
    Then Validar generación de extracto

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "1020770004" | "1234"     |

  @CP80003M
  Scenario Outline: CP80003M_SYS_Validar que se pueda descargar el extracto en pdf
    Given Ingreso usuario y contrasena en nanocredito <tipoId> <usuario> <contrasena>
    When Ingreso a extractos
    And Genero extractos
    Then Validar generación de extracto

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "1020770004" | "1234"     |

  @CP80004M
  Scenario Outline: CP80004M_SYS_Validar la opción ¿Cuánto Debo? Generación Extractos para créditos Bajo Monto
    Given Ingreso usuario y contrasena en nanocredito <tipoId> <usuario> <contrasena>
    And Cerre popup nanocredito
    And Ingreso a certificaciones
    When Ingreso tipo de Certificación
    Then Validar opcion cuánto debo

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "1020770004" | "1234"     |
