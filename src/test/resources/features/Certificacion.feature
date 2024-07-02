@Certificacion
Feature: Pruebas en la funcionalidad de Certificaciones de la app Daviplata.

  @CP001604M @Passed
  Scenario Outline: CP001604M_SYS_Validar que se muestren los movimientos del DaviPlata
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And selecciono ver movimientos
    Then validar que se muestren los movimientos

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "1020770002" | "1234"     |

  @CP70001M @Passed
  Scenario Outline: CP70001M_SYS_Validar que si es cliente que no tiene cetificacion tributaria muestre el mensaje
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Ingreso a certificaciones
    When Ingreso a consultar certificacion tributaria
    Then Validar mensaje de certificacion tributaria

    Examples: 
      | tipoId | usuario   | contrasena |
      | "CC"   | "1069773" | "1234"     |

  @CP70002M @DiseñadoSinDataCostos
  Scenario Outline: CP70002M_SYS_Validar que si es cliente que no tiene cetificacion de costos muestre el mensaje
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Ingreso a certificaciones
    When Ingreso a consultar certificacion costos
    Then Valido mensaje de certificacion de costos

    Examples: 
      | tipoId | usuario   | contrasena |
      | "CC"   | "1069773" | "1234"     |

  @CP70003M @DiseñadoConDefecto
  Scenario Outline: CP70003M_SYS_Validar proceso de generacion de certificación tributaria por año
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Cerre popup nanocredito
    And Ingreso a certificaciones
    When Ingreso a consultar certificacion tributaria
    And Genero certificación por año
    Then Valido generacion de certificacion tributaria

    Examples: 
      | tipoId | usuario   | contrasena |
      | "CC"   | "1069773" | "1234"     |

  @CP70004M @DiseñadoConDefecto
  Scenario Outline: CP70004M_SYS_Validar proceso de generacion de certificación tributaria que se deje descargar en pdf
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Cerre popup nanocredito
    And Ingreso a certificaciones
    When Ingreso a consultar certificacion tributaria
    And Genero certificación por año
    Then Valido generacion de certificacion tributaria

    Examples: 
      | tipoId | usuario   | contrasena |
      | "CC"   | "1069773" | "1234"     |
