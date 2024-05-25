#Author: Juan Pablo Doncel
@ComprobanteQR
Feature: Gruopo de casos comprobante QR

  @CP01000M
  Scenario Outline: CP01000M_SYS_Validar que se debe mostrar tanto en el login inicial como de datos recordados el botón “Código QR” en círculo blanco y color rojo
    Given Ingresé a la app Daviplata
    And verifico la version del aplicativo
    When Valido botón QR desde el login inicial
    And Ingreso a la sección datos recordados <tipoId> <usuario> <contrasena>
    Then Validar botón QR desde la sección datos recordados

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10050099" | "2589"     |

  @CP01001M
  Scenario: CP01001M_SYS_Validar que cuando el cliente de click en el botón “Código QR” se debe desplegar a la derecha tres botones: “Comprar” “Vender” y “Confirmar comprobante”
    Given Ingresé a la app Daviplata
    Then Validar opciones del boton QR

	@CP01002M
  Scenario Outline: CP01002M_SYS_Validar en el home el botón Leer código QR
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso al modulo de lectura de QR desde el home
    Then Valido modulo de lectura de QR
    
    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10050099" | "2589"     |