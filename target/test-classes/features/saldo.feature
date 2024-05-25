@Saldos
Feature: Modulo saldos

  @CP0130M @Saldos10
  Scenario Outline: CP0130M_SYS_Validar el Saldo del DaviPlata
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    Then valido saldo DaviPlata

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10333037" | "2580"     |

  @CP0140M 
  Scenario Outline: CP0140M_SYS_Validar el Saldo de la eCard
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    Then valido saldo eCard

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10333037" | "2580"     |

  @CP0150M @Saldos10
  Scenario Outline: CP0150M_SYS_Validar el Saldo del Bolsillo
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    Then valido saldo Bolsillo

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10333037" | "2580"     |

  @CP0160M 
  Scenario Outline: CP0160M_SYS_Validar el Saldo Total
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When capturo saldos
    Then valido saldo total

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10333037" | "2580"     |

  @CP0161M @passed
  Scenario Outline: CP0161M_SYS_Validar que en caso de que el cliente no tenga saldo, la pantalla de debe ver según la imagen 3, de la HU 4
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    Then Valido saldo DaviPlata en cero

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10088833" | "2589"     |

    