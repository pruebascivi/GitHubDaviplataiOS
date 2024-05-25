#Author: Anderson Alexander Gonzalez Ruiz
@notificaciones
Feature: Notificaciones y mensajes de DaviPlata

  @CP0750M
  Scenario Outline: CP0750M_SYS_Validar que se puedan leer las notificaciones del cliente
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a mensajes y notificaciones
    Then validar que aparezcan las notificaciones

    Examples: 
      | tipoId | usuario   | contrasena |
      | "CC"   | "10333038" | "1234"     |

  @CP0760M
  Scenario Outline: CP0760M_SYS_Validar que se puedan eliminar las notificaciones del cliente
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a mensajes y notificaciones
    Then validar que aparezcan las notificaciones
    And validar que se puedan eliminar

    Examples: 
      | tipoId | usuario   | contrasena |
      | "CC"   | "10333038" | "1234"     |
