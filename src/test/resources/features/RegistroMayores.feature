#Author: Juan Pablo Doncel
@RegistroMayores
Feature: Modulo Registro De Mayores

  @CP031000M
  Scenario: CP031000M_SYS_Validar que el botón '¿Necesita ayuda?' al abrir la app se encuentre en la esquina inferior derecha y permita desplazarse por todo la pantalla según la comodidad del usuario
    Given Ingresé a la app Daviplata home
    Then Validar mover el boton que permita desplazarse por toda la pantalla segun la comodidad del usuario

  @CP031001M
  Scenario Outline: CP031001M_SYS_Validar que el botón '¿Necesita ayuda?' al abrir la app se encuentre en la esquina inferior derecha y permita desplazarse por todo la pantalla segun la comodidad del usuario
    Given Ingresé a la app Daviplata home
    And Valido que los botones back cerrar o necesito ayuda no esten presentes en la pantalla de bienvenidos
    And Hago clic en el boton ya tengo daviplata
    And Valido pantalla de login de ingreso al daviplata
    And Valido la flecha para seleccionar el tipo de documento
    And Valido marca de agua en el input de documento
    And Selecciono tipo de documento <tipoID>
    And Ingreso numero de documento <numDocumentoCincoDigitos>
    And Valido longitud de los cinco digitos
    And Limpio el campo de numero de documento
    And Ingreso numero de documento <numDocumentoDiezYSeisDigitos>
    And Valido longitud de los diez y seis digitos
    And Doy clic en el boton ingresar
    And Valido popup de registro nuevo en daviplata
    And Valido botones cancelar y registrarme del pop up de registro
    And Valido funcionalidades de los botones cancelar y registrarme del pop up de registro
    And Doy clic en el boton atras hasta la pantalla de Bienvenidos
    And Valido que al dar clic en el boton registrarme direccione a la pantalla ingrese sus datos <numDocumentoCincoDigitos> <tipoID>
    And Doy clic en el boton atras hasta la pantalla de Bienvenidos
    And Hago clic en el boton Registrarme
    And Selecciono tipo de documento <tipoID>
    And Ingreso numero de documento <numeroCedulaExistente>
    And Doy clic en el boton continuar
    And Valido pop up del usuario previamente registrado
    And Valido que en el pop-up esten presentes los botones Cancelar e Ingresar
    And Valido que al dar tap en el botón Cancelar debe dejar en la pantalla Cree su DaviPlata
    And Doy clic en el boton continuar
    And Valido que al dar tap en el botón Ingresar debe dejar en la pantalla Ingrese a su DaviPlata
    And Valido presencia del boton 3 puntos
    And Valido opciones del boton 3 puntos
    And valido la opcion 'Cambiar mi numero'
    And verifico la opcion 'Donde usar su DaviPlata'

    Examples: 
      | tipoID | numDocumentoCincoDigitos | numDocumentoDiezYSeisDigitos | numeroCedulaExistente |
      | "CC"   | "12395"                  | "9876584562145987"           | "10050099"            |

  @CP031002M
  Scenario Outline: CP031002M_SYS_Validacion de registro en cedula de extranjeria exitoso y no exitoso
    Given Ingresé a la app Daviplata home
    And Ingrese tipo de documento y usuario <tipoId><usuario>
    And Hice clic en el boton de registrarme
    When Realizo proceso de registro <usuario> <nombreUsuario> <numCelular> <correo> <claveNueva>
    Then Validar si el registro es exitoso o no

    Examples: 
      | tipoId | usuario     | nombreUsuario | numCelular   | correo               | claveNueva |
      | "CE"   | "999666336" | "Andrea"      | "3008964780" | "andri655@gmail.com" | "3574"     |

  @CP031003M
  Scenario Outline: CP031003M_SYS_Validacion de campos del registro en cedula de ciudadania
    Given Ingresé a la app Daviplata home
    And Ingrese tipo de documento y usuario <tipoId><usuario>
    And Hice clic en el boton de registrarme
    When Acepto autorizacion de registro
    And Realizo validaciones de campos dentro del formulario <nombreUsuario> <numCelular> <correo>
    And Doy clic en el boton atras
    And Realizo diligenciamento completo del formulario <nombreUsuario><diaFechaNacimiento><mesFechaNacimiento><anioFechaNacimiento><diaFechaExpedicion><mesFechaExpedicion><anioFechaExpedicion><numCelular><correo>
    And Valido mensaje de error al llenar confirmacion de correo mal <confirmacionCorreoErroneo><correo>
    And Hago clic en el boton continuar
    Then Validar pantalla de otp
    And Doy clic en el boton atras
    And Validar que al devolverse a la pantalla del formulario se puedan modificar los datos
    And Doy clic en el boton atras
    And Realizo diligenciamento completo del formulario <nombreUsuarioModificado><diaFechaNacimientoModificado><mesFechaNacimientoModificado><anioFechaNacimientoModificado><diaFechaExpedicionModificado><mesFechaExpedicionModificado><anioFechaExpedicionModificado><numCelularModificado><correoModificado>
    And Hago clic en el boton continuar
    And Dar clic en el boton editar
    And Validar que al devolverse a la pantalla del formulario se puedan modificar los datos
    And Hago clic en el boton continuar
    And Ingreso otp para terminar registro
    And ingreso contrasena <clave>
    And Valido mensaje de bienvenida

    Examples: 
      | tipoId | usuario      | clave  | nombreUsuario     | numCelular   | correo             | confirmacionCorreoErroneo | diaFechaNacimiento | mesFechaNacimiento | anioFechaNacimiento | diaFechaExpedicion | mesFechaExpedicion | anioFechaExpedicion | nombreUsuarioModificado | diaFechaNacimientoModificado | mesFechaNacimientoModificado | anioFechaNacimientoModificado | diaFechaExpedicionModificado | mesFechaExpedicionModificado | anioFechaExpedicionModificado | numCelularModificado | correoModificado    |
      | "CC"   | "1012367869" | "4296" | "Andrea Hincapie" | "3227694967" | "ani567@gmail.com" | "ani987@gmail.com"        | "1"                | "Enero"            | "2001"              | "10"               | "Enero"            | "2010"              | "Tatiana"               | "5"                          | "Marzo"                      | "1999"                        | "6"                          | "Marzo"                      | "2017"                        | "3202787659"         | "tatis45@gmail.com" |

  @CP031004M
  Scenario Outline: CP031004M_SYS_Validar que Si es un tipo documental diferente a CC se debe mostrar el pop up “Esta funcionalidad aún no está disponible
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    Then Validar pop up de funcionalidad de negocio no disponible

    Examples: 
      | tipoId | usuario    | contrasena |
      | "TI"   | "10010435" | "1234"     |

  @CP031005M @biometria @passed
  Scenario Outline: CP031005M_SYS_Validar registro ingresando a beneficios mi negocio
    And Ingrese tipo de documento y usuario <tipoId><usuario>
    And Hice clic en el boton de registrarme
    And Acepto autorizacion de registro
    When completo formulario mis datos <nombre> <dia> <mes> <año> <diaExpedicion> <mesExpedicion> <anioExpedicion> <lugar> <cel> <correo>
    And ingreso otp
    And ingreso contrasena <contrasena>
    And Ingresar a mis beneficios en negocio
    And Valido pantalla de beneficios mi negocio
    And Me devuelvo al home de daviplata desde el boton usar mi daviplata
    And Doy clic en el boton de mi negocio para ingresar a perfil negocio
    And Marco check de terminos y condiciones
    And Valido ingreso a formulario mi negocio
    And Lleno formulario creacion de negocio <nombre><queVende><monto><ciudadNegocio><tipoInmueble><correo>

    Examples: 
      | tipoId | usuario    | contrasena | nombre            | dia | mes     | año    | diaExpedicion | mesExpedicion | anioExpedicion | lugar          | cel          | correo            | queVende | monto   | ciudadNegocio | tipoInmueble |
      | "CC"   | "17130497" | "2580"     | "Sherril Lockman" | "1" | "Enero" | "2000" | "1"           | "Enero"       | "2018"         | "BOGOTÁ, D.C." | "3002608449" | "xxx78@gmail.com" | "Bici"   | "50000" | "Bogo"        | "Casa"       |
