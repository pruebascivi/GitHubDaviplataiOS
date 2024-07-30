@Login
Feature: Set De Pruebas de Login

	
  @CP0009M 
  Scenario: CP0009M_SYS_Validar lista desplegable de tipo documental
    Given Ingreso a la app
    Then validacion campo tipo documental desplegable

  @CP0010M 
  Scenario Outline: CP0010M_SYS_Validar el Login con clave correcta
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    Then valido ingreso al app

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "10050039" | "2589"     |

  @CP02090M 
  Scenario Outline: CP02090M_SYS_Validar proceso de logueo por tipo documental CC
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    Then valido ingreso al app

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "10333041" | "2580"     |

  @CP0011M 
  Scenario Outline: CP0011M_SYS_Validar proceso de logueo  con  CC ingresando caracteres y números en número documental
    Given ingreso usuario con caracteres <tipoId> <usuario>
    Then validar Mensaje

    Examples: 
      | tipoId | usuario   |
      | "CC"   | "1975jhp" |

  @CP0012M 
  Scenario Outline: CP0012M_SYS_Validar proceso de logueo con PEP mayor a 15 caracteres
    Given ingreso usuario longitud superior quince <tipoId> <usuario>
    Then validar longitud de caracteres <usuario>

    Examples: 
      | tipoId | usuario               |
      | "CE"   | "1001001001278933654" |

  @CP0013M 
  Scenario Outline: CP0013M_SYS_Validar proceso de logueo con CC  que no deje ingresar caracteres especiales en el campo de clave
    Given Ingreso usuario y contrasena caracter especial <tipoId> <usuario> <contrasena>
    Then Valido ingreso de caracter especial

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "10050039" | "12$4"     |

  @CP02091M 
  Scenario Outline: CP02091M_SYS_Validar proceso de logueo por tipo documental CE
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    Then valido ingreso al app

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CE"   | "90062810017" | "2580"     |

  @CP0014M 
  Scenario Outline: CP0014M_SYS_Validar proceso de logueo  con  CE ingresando de caracteres especiales en la clave
    Given Ingreso usuario y contrasena caracter especial <tipoId> <usuario> <contrasena>
    Then Valido ingreso de caracter especial

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CE"   | "90062810017" | "12$4"     |

  @CP0015M 
  Scenario Outline: CP0015M_SYS_Validar proceso de logueo con CE ingresando caracteres y números en número documental
    Given ingreso usuario con caracteres <tipoId> <usuario>
    Then validar Mensaje

    Examples: 
      | tipoId | usuario   |
      | "CE"   | "1975jhp" |

  #Cantidad de casos adicionales que agrupa el modulo APAGADO_E-CARD_MENORES: 1
  @CP0016M @APAGADO_E-CARD_MENORES
  Scenario Outline: CP0016M_SYS_Validar proceso de logueo por tipo documental TI
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    Then valido ingreso al app

    Examples: 
      | tipoId | usuario       | contrasena |
      | "TI"   | "1022983" | "1234"     |

  @CP0017M 
  Scenario Outline: CP0017M_SYS_Validar proceso de logueo  con  TI ingresando caracteres y números en número documental
    Given ingreso usuario con caracteres <tipoId> <usuario>
    Then validar Mensaje

    Examples: 
      | tipoId | usuario   |
      | "TI"   | "1975jhp" |

  @CP0018M 
  Scenario Outline: CP0018M_SYS_Validar proceso de logueo  con  TI ingresando de caracteres especiales en la clave
    Given Ingreso usuario y contrasena caracter especial <tipoId> <usuario> <contrasena>
    Then Valido ingreso de caracter especial

    Examples: 
      | tipoId | usuario       | contrasena |
      | "TI"   | "1022983" | "12$4"     |

  @CP0019M 			
  Scenario Outline: CP0019M_SYS_Validar proceso de logueo por tipo documental PEP con 14 caracteres
    Given ingreso usuario longitud superior quince <tipoId> <usuario>
    Then validar longitud de caracteres tipo documental PEP <usuario>

    Examples: 
      | tipoId | usuario          |
      | "CE"   | "100200900894568" |

  @CP0021M 
  Scenario Outline: CP0021M_SYS_Validar proceso de logueo con PEP ingresando letras y números en número documental
    Given ingreso usuario con caracteres <tipoId> <usuario>
    Then validar Mensaje

    Examples: 
      | tipoId | usuario   |
      | "CE"   | "1975jhp" |

  @CP0022M 
  Scenario Outline: CP0022M_SYS_Validar proceso de logueo  con  PEP ingresando caracteres especiales en la clave
    Given Ingreso usuario y contrasena caracter especial <tipoId> <usuario> <contrasena>
    Then Valido ingreso de caracter especial

    Examples: 
      | tipoId | usuario          | contrasena |
      | "CC"   | "100111519"      | "12$4"     |

  @CP0023M 
  Scenario Outline: CP0023M_SYS_Validar look and feel de la pantalla de loguin.
    Given Ingreso usuario y contraseña look and feel <tipoId> <usuario>
    When Valido look and feel ingreso a daviplata
    And Ingreso contraseña <contrasena>
    Then Valido look and feel contrasena logeo

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "10050039" | "2589"     |

  @CP0520M 
  Scenario Outline: CP0520M_SYS_Validar la opción de atención en línea con cliente autenticado
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a la opcion atencion en linea
    Then validar opcion ayuda en linea

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "10050039" | "2589"     |
  
  #No se ejecuta debido a restriccion de latinia por red de internet
  @CP0730M 
  Scenario: CP0730M_SYS_Validar que se puedan leer los mensajes del cliente
    Given Ingresar a latinia
    Then Validar que aparezcan mensajes
    And Finalizar sesion latinia

  @CP0751M @PASSED
  Scenario Outline: CP0751M_SYS_Validar que se puedan leer las notificaciones del cliente
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a mensajes y notificaciones
    Then validar que aparezcan las notificaciones

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10333041" | "2580"     |

  @CP0761M 
  Scenario Outline: CP0761M_SYS_Validar que se puedan eliminar las notificaciones del cliente
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a mensajes y notificaciones
    Then validar que aparezcan las notificaciones
    And validar que se puedan eliminar

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "10050039" | "2589"     |
