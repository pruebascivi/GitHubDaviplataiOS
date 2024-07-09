@LookAndFeel
Feature: Pruebas del modulo look and feel

  @CP1281M @LookAndFeel10 @Passed
  Scenario Outline: CP1281M_SYS_Creación de negocio desde zona privada cliente antiguo sin negocio.
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Doy clic en el boton de mi negocio para ingresar a perfil negocio
    And Marco check de terminos y condiciones
    And Valido ingreso a formulario mi negocio
    And Lleno formulario creacion de negocio <nombre><queVende><monto><ciudadNegocio><tipoInmueble><correo>
    And Finalizo proceso de creacion de negocio
    Then Validar crear negocio

    Examples: 
      | tipoId | usuario    | contrasena | nombre       | cel          | correo            | queVende | monto   | ciudadNegocio | tipoInmueble |
      | "CC"   | "17130497" | "2580"     | "Bicicletas" | "3002608449" | "xxz79@gmail.com" | "Bici"   | "50000" | "Bogo"        | "Casa"       |

  @CP02570M @LookAndFeel10
  Scenario Outline: CP02570M_SYS_Validar look and feel del home de perfil negocio (Globo saldo "cuanto tengo").
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    Then Valido cuanto tengo

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10050033" | "2589"     |

  @CP02580M @LookAndFeel10
  Scenario Outline: CP02580M_SYS_Validar look and feel del home de perfil negocio (botón pasar plata).
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And ingreso a pasar plata
    Then Valido pasar plata

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10050033" | "2589"     |

  @CP02590M @LookAndFeel10
  Scenario Outline: CP02590M_SYS_Validar look and feel del home de perfil negocio (botón sacar plata).
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And ingreso a sacar plata
    Then Valido boton sacar plata

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10050033" | "2589"     |

  @CP02600M @LookAndFeel10
  Scenario Outline: CP02600M_SYS_Validar look and feel del home de perfil negocio (nombre del negocio).
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    Then nombre del negocio

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10050033" | "2589"     |

  @CP02610M @LookAndFeel10
  Scenario Outline: CP02610M_SYS_Validar look and feel del home de perfil negocio (visualización campana de notificaciones).
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    Then validar campana de notificaciones

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10050033" | "2589"     |

  @CP02620M @LookAndFeel10
  Scenario Outline: CP02620M_SYS_Validar look and feel del home de perfil negocio (visualización opción cerrar).
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    Then validar visibilidad boton cerrar

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10050033" | "2589"     |

  @CP02630M @LookAndFeel21
  Scenario Outline: CP02630M_SYS_Validar look and feel del home de perfil negocio (visualización menú hamburguesa).
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingresar a menu hamburguesa perfil negocio
    Then validar menu hamburguesa

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10050033" | "2589"     |

  @CP02640M @LookAndFeel21 @PASSED
  Scenario Outline: CP02640M_SYS_Validar opción cambio foto del Perfil en perfil persona.
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Ingreso a perfil persona
    When ingreso a perfil persona
    And Flujo cambiar foto
    Then validar cambio de foto

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10050033" | "2589"     |

  @CP02650M @LookAndFeel21
  Scenario Outline: CP02650M_SYS_Validar opción cambio foto del Perfil en perfil negocio.
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingresar a menu hamburguesa perfil negocio
    And Flujo cambiar foto perfil negocio
    Then validar cambio de foto perfil negocio

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10050033" | "2589"     |

  @CP02660M @LookAndFeel21
  Scenario Outline: CP02660M_SYS_Validar visualización botón menú hamburguesa desde perfil negocio.
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    Then validar boton menu hamburguesa

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10050033" | "2589"     |

  @CP02670M @LookAndFeel21
  Scenario Outline: CP02670M_SYS_Validar botón menú hamburguesa desde perfil negocio (usar plata)
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    Then validar boton menu hamburguesa y opcion usar plata

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10050033" | "2589"     |
