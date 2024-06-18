@Webcheckout
Feature: casos de aumento de topes

  @CP09010M @Passed
  Scenario Outline: CP09010M_SYS_Validar que al dar tap en la opcion "Botón de pago" envie la pantalla "Botón de pago"
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Selecciono botón de pago en perfil mi negocio
    And Validar que se presente un video y permita reproducirse varias veces
    And Validar que se presente el texto definido
    And Dar clic Atrás en el módulo botón de pago
    And Hago clic en la equis y valido devolverme al home
    And Ingreso y genero el botón de pago
    And Valido la url del botón de pago
    And Valido el botón finalizar
    And Validar que despues de generar el primer botón de pago se omita la pantalla de Enlaces de pago

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10088844" | "2589"     |

  @CP09020M
  Scenario Outline: CP09020M_SYS_Validar que al dar tap en la opcion "Botón de pago" envie la pantalla "Botón de pago"
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Selecciono el botón enlace de pago
    And Realizo la creación del producto <nombreProducto> <valorProducto>
    And Ingreso a la web con la url de enlace de pago <usuario>

    Examples: 
      | tipoId | usuario    | contrasena | nombreProducto | valorProducto |
      | "CC"   | "10050033" | "2589"     | "juguete"      | "26000"       |
