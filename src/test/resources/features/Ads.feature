@Ads
Feature: Modulo ADS

  # La data que se debe usar es un usuario "no comun"
  @CP09001M @Passed
  Scenario Outline: CP09001M_SYS_Validaciones pantalla de autorizaciones con usuarios no comunes
    Given Login ADS <tipoId> <usuario> <contrasena>
    When Ingreso al pop up de adelanto de sueldo
    And Acepto terminos y condiciones en pantalla de beneficios
    And Doy clic en el boton continuar de beneficios
    And Validamos pantalla de resultado
    And Valido pantalla de autorizaciones
    And Ingreso a pantalla autorizacion tratamiento de datos sensibles
    And Valido que al dar clic al boton atras deje el check desmarcado
    And Ingreso a pantalla autorizacion tratamiento de datos sensibles
    And Acepto terminos y condiciones de tratamiento de datos sensibles
    And Acepto debitar automaticamente mi DaviPlata
    And Acepto terminos de pagare
    And Ingreso a pantalla autorizacion tratamiento de datos sensibles
    And Valido que al dar clic en el boton atras mantenga los check marcados
    And Ingreso a pantalla autorizacion tratamiento de datos sensibles
    And Valido checks marcados al aceptar terminos y condiciones de datos sensibles
    And Valido elementos del pop up salir de la app
    And Valido que al hacer clic en cancelar deje en la misma pantalla de autorizaciones
    Then Validar que al hacer clic en continuar deje en la pantalla de login

    Examples: 
      | tipoId | usuario   | contrasena |
      | "CC"   | "1020571" | "1234"     |

  # La data que se debe usar es un usuario con ADS
  @CP09002M @Passed
  Scenario Outline: CP09002M_SYS_Validar que si el cliente esta realizando su proceso de vinculacion ADS entre la pantalla de informacion personal 1 y pasa a la 2 y cierre el proceso en el momento de retomar el sistema deje al usuario en el punto maximo donde dejo diligenciado es decir debe tener toda la informacion de la pantalla 1 informacion personal
    Given Login ADS <tipoId> <usuario> <contrasena>
    When Ingreso al pop up de adelanto de sueldo
    And Acepto terminos y condiciones en pantalla de beneficios
    And Doy clic en el boton continuar de beneficios
    And Valido presencia Pop Up 'ya ha iniciado una solicitud de adelanto de saldo' y cancelar
    And Lleno formulario de informacion personal primera pantalla <ciudadExpedicionDocumento> <paisNacimiento>
    And Doy clic en el boton continuar de beneficios
    And Salgo de la app
    And Login ADS <tipoId> <usuario> <contrasena>
    And Ingreso al pop up de adelanto de sueldo
    And Acepto terminos y condiciones en pantalla de beneficios
    And Doy clic en el boton continuar de beneficios
    And Acepto retomar la solicitud de ads
    Then Validar que se haya guardado los datos al salir de la app

    Examples: 
      | tipoId | usuario   | contrasena | ciudadExpedicionDocumento | paisNacimiento |
      | "CC"   | "1020624" | "1234"     | "Bogo"                    | "Colo"         |

  # La data que se debe usar es un usuario con ADS
  @CP09003M @Passed
  Scenario Outline: CP09003M_SYS_Validar que si el cliente esta realizando su proceso de vinculacion ADS entre la pantalla de informacion personal 2 y pasa a la pantalla de informacion laboral y cierre el proceso, en el momento de retomar el sistema deje al usuario en el punto maximo donde dejo diligenciado es decir debe tener toda la informacion de la pantalla 2 informacion personal
    Given Login ADS <tipoId> <usuario> <contrasena>
    When Ingreso al pop up de adelanto de sueldo
    And Acepto terminos y condiciones en pantalla de beneficios
    And Doy clic en el boton continuar de beneficios
    And Valido presencia Pop Up 'ya ha iniciado una solicitud de adelanto de saldo' y cancelar
    And Lleno formulario de informacion personal primera pantalla <ciudadExpedicionDocumento> <paisNacimiento>
    And Doy clic en el boton continuar de beneficios
    And Lleno formulario de informacion personal segunda pantalla <correoElectronico><tipoCalle><numUnoDireccion><numDosDireccion><numTresDireccion><tipoInmueble><ciudadResidencia>
    And Doy clic en el boton continuar de beneficios
    And Salgo de la app
    And Login ADS <tipoId> <usuario> <contrasena>
    And Ingreso al pop up de adelanto de sueldo
    And Acepto terminos y condiciones en pantalla de beneficios
    And Doy clic en el boton continuar de beneficios
    And Acepto retomar la solicitud de ads
    Then Validar que se haya guardado los datos de la pantalla dos de informacion personal al salir de la app

    Examples: 
      | tipoId | usuario   | contrasena | ciudadExpedicionDocumento | paisNacimiento | correoElectronico | tipoCalle | numUnoDireccion | numDosDireccion | numTresDireccion | tipoInmueble | ciudadResidencia |
      | "CC"   | "1020624" | "1234"     | "Bogo"                    | "Colo"         | "xxx@gmail.com"   | "Calle"   | "51"            | "57"            | "20"             | "Casa"       | "Bogo"           |

  # La data que se debe usar es un usuario con ADS
  @CP09004M @Passed
  Scenario Outline: CP09004M_SYS_Validar que si el cliente esta realizando su proceso de vinculacion ADS entre la pantalla de informacion laboral y pasa a la pantalla de informacion financiera 1 y cierre el proceso, en el momento de retomar el sistema deje al usuario en el punto maximo donde dejo diligenciado es decir debe tener toda la informacion de la pantalla informacion laboral.
    Given Login ADS <tipoId> <usuario> <contrasena>
    When Ingreso al pop up de adelanto de sueldo
    And Acepto terminos y condiciones en pantalla de beneficios
    And Doy clic en el boton continuar de beneficios
    And Valido presencia Pop Up 'ya ha iniciado una solicitud de adelanto de saldo' y cancelar
    And Lleno formulario de informacion personal primera pantalla <ciudadExpedicionDocumento> <paisNacimiento>
    And Doy clic en el boton continuar de beneficios
    And Lleno formulario de informacion personal segunda pantalla <correoElectronico><tipoCalle><numUnoDireccion><numDosDireccion><numTresDireccion><tipoInmueble><ciudadResidencia>
    And Doy clic en el boton continuar de beneficios
    And Lleno formulario de informacion laboral <tipoCalleDondeTrabaja> <numUnoDireccionDondeTrabaja> <numDosDireccionDondeTrabaja> <numTresDireccionDondeTrabaja> <tipoInmuebleDondeTrabaja> <ciudaDeTrabajo>
    And Doy clic en el boton continuar de beneficios
    And Salgo de la app
    And Login ADS <tipoId> <usuario> <contrasena>
    And Ingreso al pop up de adelanto de sueldo
    And Acepto terminos y condiciones en pantalla de beneficios
    And Doy clic en el boton continuar de beneficios
    And Acepto retomar la solicitud de ads
    Then Validar que se haya guardado los datos de informacion laboral al salir de la app

    Examples: 
      | tipoId | usuario   | contrasena | ciudadExpedicionDocumento | paisNacimiento | correoElectronico | tipoCalle | numUnoDireccion | numDosDireccion | numTresDireccion | tipoInmueble | ciudadResidencia | tipoCalleDondeTrabaja | numUnoDireccionDondeTrabaja | numDosDireccionDondeTrabaja | numTresDireccionDondeTrabaja | tipoInmuebleDondeTrabaja | ciudaDeTrabajo |
      | "CC"   | "1020624" | "1234"     | "Bogo"                    | "Colo"         | "xxx@gmail.com"   | "Calle"   | "51"            | "57"            | "20"             | "Casa"       | "Bogo"           | "Calle"               | "50"                        | "51"                        | "10"                         | "Oficina"                | "Bogo"         |

  # La data que se debe usar es un usuario con ADS
  @CP09005M
  Scenario Outline: CP09005M_SYS_Validar que si el cliente esta realizando su proceso de vinculacion ADS entre la pantalla de informacion financiera 1 y pasa a la pantalla de informacion financiera 2 y cierre el proceso, en el momento de retomar el sistema deje al usuario en el punto maximo donde dejo diligenciado es decir debe tener toda la informacion de la pantalla financiera 1.
    Given Login ADS <tipoId> <usuario> <contrasena>
    When Ingreso al pop up de adelanto de sueldo
    And Acepto terminos y condiciones en pantalla de beneficios
    And Doy clic en el boton continuar de beneficios
    And Valido presencia Pop Up 'ya ha iniciado una solicitud de adelanto de saldo' y cancelar
    And Lleno formulario de informacion personal primera pantalla <ciudadExpedicionDocumento> <paisNacimiento>
    And Doy clic en el boton continuar de beneficios
    And Lleno formulario de informacion personal segunda pantalla <correoElectronico><tipoCalle><numUnoDireccion><numDosDireccion><numTresDireccion><tipoInmueble><ciudadResidencia>
    And Doy clic en el boton continuar de beneficios
    And Lleno formulario de informacion laboral <tipoCalleDondeTrabaja> <numUnoDireccionDondeTrabaja> <numDosDireccionDondeTrabaja> <numTresDireccionDondeTrabaja> <tipoInmuebleDondeTrabaja> <ciudaDeTrabajo>
    And Doy clic en el boton continuar de beneficios
    And Lleno formulario de informacion Financiera uno <montoGastosMes><montoSumaLoQueTiene>
    And Doy clic en el boton continuar de beneficios
    And Salgo de la app
    Given Login ADS <tipoId> <usuario> <contrasena>
    And Ingreso al pop up de adelanto de sueldo
    And Acepto terminos y condiciones en pantalla de beneficios
    And Doy clic en el boton continuar de beneficios
    And Acepto retomar la solicitud de ads
    Then Validar que se haya guardado los datos de informacion financiera uno al salir de la app

    Examples: 
      | tipoId | usuario   | contrasena | ciudadExpedicionDocumento | paisNacimiento | correoElectronico | tipoCalle | numUnoDireccion | numDosDireccion | numTresDireccion | tipoInmueble | ciudadResidencia | tipoCalleDondeTrabaja | numUnoDireccionDondeTrabaja | numDosDireccionDondeTrabaja | numTresDireccionDondeTrabaja | tipoInmuebleDondeTrabaja | ciudaDeTrabajo | montoGastosMes | montoSumaLoQueTiene |
      | "CC"   | "1020624" | "1234"     | "Bogo"                    | "Colo"         | "xxx@gmail.com"   | "Calle"   | "51"            | "57"            | "20"             | "Casa"       | "Bogo"           | "Calle"               | "50"                        | "51"                        | "10"                         | "Oficina"                | "Bogo"         | "50000"        | "2000000"           |

  # La data que se debe usar es un usuario con ADS
  @CP09006M
  Scenario Outline: CP09006M_SYS_Validar que si el cliente esta realizando su proceso de vinculacion ADS entre la pantalla de informacion financiera 2 y pasa a la pantalla de informacion PEP y cierre el proceso, en el momento de retomar el sistema deje al usuario en el punto maximo donde dejo diligenciado es decir debe tener toda la informacion de la pantalla financiera 2.
    Given Login ADS <tipoId> <usuario> <contrasena>
    When Ingreso al pop up de adelanto de sueldo
    And Acepto terminos y condiciones en pantalla de beneficios
    And Doy clic en el boton continuar de beneficios
    And Valido presencia Pop Up 'ya ha iniciado una solicitud de adelanto de saldo' y cancelar
    And Lleno formulario de informacion personal primera pantalla <ciudadExpedicionDocumento> <paisNacimiento>
    And Doy clic en el boton continuar de beneficios
    And Lleno formulario de informacion personal segunda pantalla <correoElectronico><tipoCalle><numUnoDireccion><numDosDireccion><numTresDireccion><tipoInmueble><ciudadResidencia>
    And Doy clic en el boton continuar de beneficios
    And Lleno formulario de informacion laboral <tipoCalleDondeTrabaja> <numUnoDireccionDondeTrabaja> <numDosDireccionDondeTrabaja> <numTresDireccionDondeTrabaja> <tipoInmuebleDondeTrabaja> <ciudaDeTrabajo>
    And Doy clic en el boton continuar de beneficios
    And Lleno formulario de informacion Financiera uno <montoGastosMes><montoSumaLoQueTiene>
    And Doy clic en el boton continuar de beneficios
    And Lleno formulario de informacion financiera dos <montoSumaLoQueDebe>
    And Doy clic en el boton continuar de beneficios
    And Salgo de la app
    Given Login ADS <tipoId> <usuario> <contrasena>
    And Ingreso al pop up de adelanto de sueldo
    And Acepto terminos y condiciones en pantalla de beneficios
    And Doy clic en el boton continuar de beneficios
    And Acepto retomar la solicitud de ads
    Then Validar que se haya guardado los datos de informacion financiera dos al salir de la app

    Examples: 
      | tipoId | usuario   | contrasena | ciudadExpedicionDocumento | paisNacimiento | correoElectronico | tipoCalle | numUnoDireccion | numDosDireccion | numTresDireccion | tipoInmueble | ciudadResidencia | tipoCalleDondeTrabaja | numUnoDireccionDondeTrabaja | numDosDireccionDondeTrabaja | numTresDireccionDondeTrabaja | tipoInmuebleDondeTrabaja | ciudaDeTrabajo | montoGastosMes | montoSumaLoQueTiene | montoSumaLoQueDebe |
      | "CC"   | "1020624" | "1234"     | "Bogo"                    | "Colo"         | "xxx@gmail.com"   | "Calle"   | "51"            | "57"            | "20"             | "Casa"       | "Bogo"           | "Calle"               | "50"                        | "51"                        | "10"                         | "Oficina"                | "Bogo"         | "50000"        | "2000000"           | "1000000"          |

  # La data que se debe usar es un usuario con ADS
  @CP09007M
  Scenario Outline: CP09007M_SYS_Validar que si el cliente esta realizando su proceso de vinculacion ADS entre la pantalla de informacion PEP y pasa a la pantalla de informacion tributaria y cierre el proceso, en el momento de retomar el sistema deje al usuario en el punto maximo donde dejo diligenciado es decir debe tener toda la informacion de la pantalla PEP.
    Given Login ADS <tipoId> <usuario> <contrasena>
    When Ingreso al pop up de adelanto de sueldo
    And Acepto terminos y condiciones en pantalla de beneficios
    And Doy clic en el boton continuar de beneficios
    And Valido presencia Pop Up 'ya ha iniciado una solicitud de adelanto de saldo' y cancelar
    And Lleno formulario de informacion personal primera pantalla <ciudadExpedicionDocumento> <paisNacimiento>
    And Doy clic en el boton continuar de beneficios
    And Lleno formulario de informacion personal segunda pantalla <correoElectronico><tipoCalle><numUnoDireccion><numDosDireccion><numTresDireccion><tipoInmueble><ciudadResidencia>
    And Doy clic en el boton continuar de beneficios
    And Lleno formulario de informacion laboral <tipoCalleDondeTrabaja> <numUnoDireccionDondeTrabaja> <numDosDireccionDondeTrabaja> <numTresDireccionDondeTrabaja> <tipoInmuebleDondeTrabaja> <ciudaDeTrabajo>
    And Doy clic en el boton continuar de beneficios
    And Lleno formulario de informacion Financiera uno <montoGastosMes><montoSumaLoQueTiene>
    And Doy clic en el boton continuar de beneficios
    And Lleno formulario de informacion financiera dos <montoSumaLoQueDebe>
    And Doy clic en el boton continuar de beneficios
    And Lleno formulario de persona politicamente expuesta
    And Doy clic en el boton continuar de beneficios
    And Salgo de la app
    Given Login ADS <tipoId> <usuario> <contrasena>
    And Ingreso al pop up de adelanto de sueldo
    And Acepto terminos y condiciones en pantalla de beneficios
    And Doy clic en el boton continuar de beneficios
    And Acepto retomar la solicitud de ads
    Then Validar que se haya guardado los datos de la persona politicamente expuesta al salir de la app

    Examples: 
      | tipoId | usuario   | contrasena | ciudadExpedicionDocumento | paisNacimiento | correoElectronico | tipoCalle | numUnoDireccion | numDosDireccion | numTresDireccion | tipoInmueble | ciudadResidencia | tipoCalleDondeTrabaja | numUnoDireccionDondeTrabaja | numDosDireccionDondeTrabaja | numTresDireccionDondeTrabaja | tipoInmuebleDondeTrabaja | ciudaDeTrabajo | montoGastosMes | montoSumaLoQueTiene | montoSumaLoQueDebe |
      | "CC"   | "1020624" | "1234"     | "Bogo"                    | "Colo"         | "xxx@gmail.com"   | "Calle"   | "51"            | "57"            | "20"             | "Casa"       | "Bogo"           | "Calle"               | "50"                        | "51"                        | "10"                         | "Oficina"                | "Bogo"         | "50000"        | "2000000"           | "1000000"          |

  # La data que se debe usar es un usuario con ADS
  @CP09008M
  Scenario Outline: CP09008M_SYS_Validar que si el cliente esta realizando su proceso de vinculacion ADS entre la pantalla de informacion tributaria 1 y pasa a la pantalla de declaracion tributaria y cierre el proceso, en el momento de retomar el sistema deje al usuario en el punto maximo donde dejo diligenciado es decir debe tener toda la informacion de la pantalla tributaria.
    Given Login ADS <tipoId> <usuario> <contrasena>
    When Ingreso al pop up de adelanto de sueldo
    And Acepto terminos y condiciones en pantalla de beneficios
    And Doy clic en el boton continuar de beneficios
    And Valido presencia Pop Up 'ya ha iniciado una solicitud de adelanto de saldo' y cancelar
    And Lleno formulario de informacion personal primera pantalla <ciudadExpedicionDocumento> <paisNacimiento>
    And Doy clic en el boton continuar de beneficios
    And Lleno formulario de informacion personal segunda pantalla <correoElectronico><tipoCalle><numUnoDireccion><numDosDireccion><numTresDireccion><tipoInmueble><ciudadResidencia>
    And Doy clic en el boton continuar de beneficios
    And Lleno formulario de informacion laboral <tipoCalleDondeTrabaja> <numUnoDireccionDondeTrabaja> <numDosDireccionDondeTrabaja> <numTresDireccionDondeTrabaja> <tipoInmuebleDondeTrabaja> <ciudaDeTrabajo>
    And Doy clic en el boton continuar de beneficios
    And Lleno formulario de informacion Financiera uno <montoGastosMes><montoSumaLoQueTiene>
    And Doy clic en el boton continuar de beneficios
    And Lleno formulario de informacion financiera dos <montoSumaLoQueDebe>
    And Doy clic en el boton continuar de beneficios
    And Lleno formulario de persona politicamente expuesta
    And Doy clic en el boton continuar de beneficios
    And Lleno formulario informacion tributaria
    And Doy clic en el boton continuar de beneficios
    And Salgo de la app
    Given Login ADS <tipoId> <usuario> <contrasena>
    And Ingreso al pop up de adelanto de sueldo
    And Acepto terminos y condiciones en pantalla de beneficios
    And Doy clic en el boton continuar de beneficios
    And Acepto retomar la solicitud de ads
    Then Validar que se haya guardado los datos de la pantalla informacion tributaria al salir de la app

    Examples: 
      | tipoId | usuario   | contrasena | ciudadExpedicionDocumento | paisNacimiento | correoElectronico | tipoCalle | numUnoDireccion | numDosDireccion | numTresDireccion | tipoInmueble | ciudadResidencia | tipoCalleDondeTrabaja | numUnoDireccionDondeTrabaja | numDosDireccionDondeTrabaja | numTresDireccionDondeTrabaja | tipoInmuebleDondeTrabaja | ciudaDeTrabajo | montoGastosMes | montoSumaLoQueTiene | montoSumaLoQueDebe |
      | "CC"   | "1020624" | "1234"     | "Bogo"                    | "Colo"         | "xxx@gmail.com"   | "Calle"   | "51"            | "57"            | "20"             | "Casa"       | "Bogo"           | "Calle"               | "50"                        | "51"                        | "10"                         | "Oficina"                | "Bogo"         | "50000"        | "2000000"           | "1000000"          |

  @CP09009M
  Scenario Outline: CP09009M_SYS_Validar que si el cliente esta realizando su proceso de vinculacion ADS entre la pantalla de informacion tributaria 1 e indica si en factca y pasa a la pantalla de informacion tributaria 2 y cierre el proceso, en el momento de retomar el sistema deje al usuario en el punto maximo donde dejo diligenciado es decir debe tener toda la informacion de la pantalla tributaria 1.
    Given Login ADS <tipoId> <usuario> <contrasena>
    When Ingreso al pop up de adelanto de sueldo
    And Acepto terminos y condiciones en pantalla de beneficios
    And Doy clic en el boton continuar de beneficios
    And Valido presencia Pop Up 'ya ha iniciado una solicitud de adelanto de saldo' y cancelar
    And Lleno formulario de informacion personal primera pantalla <ciudadExpedicionDocumento> <paisNacimiento>
    And Doy clic en el boton continuar de beneficios
    And Lleno formulario de informacion personal segunda pantalla <correoElectronico><tipoCalle><numUnoDireccion><numDosDireccion><numTresDireccion><tipoInmueble><ciudadResidencia>
    And Doy clic en el boton continuar de beneficios
    And Lleno formulario de informacion laboral <tipoCalleDondeTrabaja> <numUnoDireccionDondeTrabaja> <numDosDireccionDondeTrabaja> <numTresDireccionDondeTrabaja> <tipoInmuebleDondeTrabaja> <ciudaDeTrabajo>
    And Doy clic en el boton continuar de beneficios
    And Lleno formulario de informacion Financiera uno <montoGastosMes><montoSumaLoQueTiene>
    And Doy clic en el boton continuar de beneficios
    And Lleno formulario de informacion financiera dos <montoSumaLoQueDebe>
    And Doy clic en el boton continuar de beneficios
    And Lleno formulario de persona politicamente expuesta
    And Doy clic en el boton continuar de beneficios
    And Lleno formulario informacion tributaria facta
    And Doy clic en el boton continuar de beneficios
    And Salgo de la app
    Given Login ADS <tipoId> <usuario> <contrasena>
    And Ingreso al pop up de adelanto de sueldo
    And Acepto terminos y condiciones en pantalla de beneficios
    And Doy clic en el boton continuar de beneficios
    And Acepto retomar la solicitud de ads
    Then Validar que se haya guardado los datos de la pantalla informacion tributaria facta al salir de la app

    Examples: 
      | tipoId | usuario   | contrasena | ciudadExpedicionDocumento | paisNacimiento | correoElectronico | tipoCalle | numUnoDireccion | numDosDireccion | numTresDireccion | tipoInmueble | ciudadResidencia | tipoCalleDondeTrabaja | numUnoDireccionDondeTrabaja | numDosDireccionDondeTrabaja | numTresDireccionDondeTrabaja | tipoInmuebleDondeTrabaja | ciudaDeTrabajo | montoGastosMes | montoSumaLoQueTiene | montoSumaLoQueDebe |
      | "CC"   | "1020624" | "1234"     | "Bogo"                    | "Colo"         | "xxx@gmail.com"   | "Calle"   | "51"            | "57"            | "20"             | "Casa"       | "Bogo"           | "Calle"               | "50"                        | "51"                        | "10"                         | "Oficina"                | "Bogo"         | "50000"        | "2000000"           | "1000000"          |

  @CP090010M
  Scenario Outline: CP090010M_SYS_Validar que si el cliente esta realizando su proceso de vinculacion ADS entre la pantalla de informacion tributaria 2 y pasa a la pantalla de declaracion tributaria y cierre el proceso, en el momento de retomar el sistema deje al usuario en el punto maximo donde dejo diligenciado es decir debe tener toda la informacion de la pantalla tributaria 2.
    Given Login ADS <tipoId> <usuario> <contrasena>
    When Ingreso al pop up de adelanto de sueldo
    And Acepto terminos y condiciones en pantalla de beneficios
    And Doy clic en el boton continuar de beneficios
    And Valido presencia Pop Up 'ya ha iniciado una solicitud de adelanto de saldo' y cancelar
    And Lleno formulario de informacion personal primera pantalla <ciudadExpedicionDocumento> <paisNacimiento>
    And Doy clic en el boton continuar de beneficios
    And Lleno formulario de informacion personal segunda pantalla <correoElectronico><tipoCalle><numUnoDireccion><numDosDireccion><numTresDireccion><tipoInmueble><ciudadResidencia>
    And Doy clic en el boton continuar de beneficios
    And Lleno formulario de informacion laboral <tipoCalleDondeTrabaja> <numUnoDireccionDondeTrabaja> <numDosDireccionDondeTrabaja> <numTresDireccionDondeTrabaja> <tipoInmuebleDondeTrabaja> <ciudaDeTrabajo>
    And Doy clic en el boton continuar de beneficios
    And Lleno formulario de informacion Financiera uno <montoGastosMes><montoSumaLoQueTiene>
    And Doy clic en el boton continuar de beneficios
    And Lleno formulario de informacion financiera dos <montoSumaLoQueDebe>
    And Doy clic en el boton continuar de beneficios
    And Lleno formulario de persona politicamente expuesta
    And Doy clic en el boton continuar de beneficios
    And Lleno formulario informacion tributaria facta
    And Doy clic en el boton continuar de beneficios
    And Lleno formulario de declaracion tributaria facta <nombreDeclaracionImpuestos><direccionResidenciaFacta><ciudad><numeroPostal><numeroSeguroSocial>
    And Doy clic en el boton continuar de beneficios
    And Salgo de la app
    Given Login ADS <tipoId> <usuario> <contrasena>
    And Ingreso al pop up de adelanto de sueldo
    And Acepto terminos y condiciones en pantalla de beneficios
    And Doy clic en el boton continuar de beneficios
    And Acepto retomar la solicitud de ads
    Then Validar que se haya guardado los datos de la pantalla declaracion tributaria facta al salir de la app

    Examples: 
      | tipoId | usuario   | contrasena | ciudadExpedicionDocumento | paisNacimiento | correoElectronico | tipoCalle | numUnoDireccion | numDosDireccion | numTresDireccion | tipoInmueble | ciudadResidencia | tipoCalleDondeTrabaja | numUnoDireccionDondeTrabaja | numDosDireccionDondeTrabaja | numTresDireccionDondeTrabaja | tipoInmuebleDondeTrabaja | ciudaDeTrabajo | montoGastosMes | montoSumaLoQueTiene | montoSumaLoQueDebe | nombreDeclaracionImpuestos | direccionResidenciaFacta        | ciudad   | numeroPostal | numeroSeguroSocial |
      | "CC"   | "1020624" | "1234"     | "Bogo"                    | "Colo"         | "xxx@gmail.com"   | "Calle"   | "51"            | "57"            | "20"             | "Casa"       | "Bogo"           | "Calle"               | "50"                        | "51"                        | "10"                         | "Oficina"                | "Bogo"         | "50000"        | "2000000"           | "1000000"          | "Jaime Antonio Velez"      | "Carrera 45 # 56 - 77, Apto 4"  | "Bogota" | "114111"     | "263626272"        |

  @CP090011M
  Scenario Outline: CP090011M_SYS_Validar que si el cliente esta realizando su proceso de vinculacion ADS entre la pantalla de informacion declaraciones tributarias y pasa al proceso de Apertura y cierre el proceso, en el momento de retomar el sistema deje al usuario en el punto maximo donde dejo diligenciado es decir debe tener toda la informacion de la pantalla declaracion tributaria.
    Given Login ADS <tipoId> <usuario> <contrasena>
    When Ingreso al pop up de adelanto de sueldo
    And Acepto terminos y condiciones en pantalla de beneficios
    And Doy clic en el boton continuar de beneficios
    And Valido presencia Pop Up 'ya ha iniciado una solicitud de adelanto de saldo' y cancelar
    And Lleno formulario de informacion personal primera pantalla <ciudadExpedicionDocumento> <paisNacimiento>
    And Doy clic en el boton continuar de beneficios
    And Lleno formulario de informacion personal segunda pantalla <correoElectronico><tipoCalle><numUnoDireccion><numDosDireccion><numTresDireccion><tipoInmueble><ciudadResidencia>
    And Doy clic en el boton continuar de beneficios
    And Lleno formulario de informacion laboral <tipoCalleDondeTrabaja> <numUnoDireccionDondeTrabaja> <numDosDireccionDondeTrabaja> <numTresDireccionDondeTrabaja> <tipoInmuebleDondeTrabaja> <ciudaDeTrabajo>
    And Doy clic en el boton continuar de beneficios
    And Lleno formulario de informacion Financiera uno <montoGastosMes><montoSumaLoQueTiene>
    And Doy clic en el boton continuar de beneficios
    And Lleno formulario de informacion financiera dos <montoSumaLoQueDebe>
    And Doy clic en el boton continuar de beneficios
    And Lleno formulario de persona politicamente expuesta flujo si
    And Doy clic en el boton continuar de beneficios
    And Lleno formulario informacion tributaria
    And Doy clic en el boton continuar de beneficios
    And Lleno formulario declaraciones
    And Doy clic en el boton continuar de beneficios
    And Valido cupo resultado del adelanto de sueldo 
    And Doy clic en el boton continuar de beneficios
    And Acepto autorizaciones finales
    And Salgo de la app
    Given Login ADS <tipoId> <usuario> <contrasena>
    And Ingreso al pop up de adelanto de sueldo
    And Acepto terminos y condiciones en pantalla de beneficios
    And Doy clic en el boton continuar de beneficios
    And Acepto retomar la solicitud de ads
    Then Validar que se haya guardado los datos de la pantalla declaraciones al salir de la app

    Examples: 
      | tipoId | usuario   | contrasena | ciudadExpedicionDocumento | paisNacimiento | correoElectronico | tipoCalle | numUnoDireccion | numDosDireccion | numTresDireccion | tipoInmueble | ciudadResidencia | tipoCalleDondeTrabaja | numUnoDireccionDondeTrabaja | numDosDireccionDondeTrabaja | numTresDireccionDondeTrabaja | tipoInmuebleDondeTrabaja | ciudaDeTrabajo | montoGastosMes | montoSumaLoQueTiene | montoSumaLoQueDebe | nombreDeclaracionImpuestos | direccionResidenciaFacta        | ciudad   | numeroPostal | numeroSeguroSocial |
      | "CC"   | "1020624" | "1234"     | "Bogo"                    | "Colo"         | "xxx@gmail.com"   | "Calle"   | "51"            | "57"            | "20"             | "Casa"       | "Bogo"           | "Calle"               | "50"                        | "51"                        | "10"                         | "Oficina"                | "Bogo"         | "50000"        | "2000000"           | "1000000"          | "Jaime Antonio Velez"      | "Carrera 45 # 56 - 77, Apto 4"  | "Bogota" | "114111"     | "263626272"        |
