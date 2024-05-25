@cambioDispositivo
Feature: casos cambio de dispositivo

  @CP03800M
  Scenario Outline: CP03800M_SYS_Validar proceso de cambio de dispositivo con contraseña válida
    Given Ingresé usuario <tipoId> <usuario>
    When Realizo cambio de dispositivo <contrasena>
    Then valido ingreso al app

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10050039" | "2589"     |

  @CP03210M
  Scenario Outline: CP03210M_SYS_validar proceso de cambio de dispositivo con contrasena no valida
    Given Ingresé usuario <tipoId> <usuario>
    When Realizo cambio de dispositivo con clave incorrecta <contrasena> <otp>
    Then Validar mensaje de clave incorrecta

    Examples: 
      | tipoId | usuario    | contrasena | otp      |
      | "CC"   | "10050041" | "2586"     | "230116" |

  @CP03220M
  Scenario Outline: CP03220M_SYS_validar proceso de cambio de dispositivo con otp invalida
    Given Ingresé usuario <tipoId> <usuario>
    When Realizo cambio de dispositivo con clave incorrecta <contrasena> <otp>
    Then Validar mensaje de otp incorrecta

    Examples: 
      | tipoId | usuario    | contrasena | otp      |
      | "CC"   | "10050041" | "2589"     | "230167" |

  @CP03221M @cambio198
  Scenario Outline: CP03221M_SYS_Validar proceso de cambio de dispositivo con otp valida
    Given Ingresé usuario <tipoId> <usuario>
    When Realizo cambio de dispositivo <contrasena>
    Then valido ingreso al app

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10050039" | "2589"     |
