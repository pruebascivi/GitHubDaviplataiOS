@Negocio
Feature: Pruebas en la funcionalidad de perfil negocio de la app Daviplata.

  @CP02673M @PASSED
  Scenario Outline: CP02673M_SYS_Validar funcionalidad de pasar plata desde botón "usar plata" de menú hamburguesa desde perfil negocio.
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingresar a menu hamburguesa perfil negocio
    And ingresar a opcion pasar plata
    And ingresar a otro daviplata perfil negocio
    Then flujo pasar plata y validacion de la transaccion <numCuenta>

    Examples: 
      | tipoId | usuario    | contrasena | numCuenta    |
      | "CC"   | "10050099" | "2589"     | "3227680733" |

  @CP02674M @defectoMovimientos
  Scenario Outline: CP02674M_SYS_Validar funcionalidad de sacar plata desde botón "usar plata" de menú hamburguesa desde perfil negocio.
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When Ingreso a perfil negocio
    And Ingresar a menu hamburguesa perfil negocio
    And ingresar a opcion sacar plata
    And Flujo de sacar plata
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    Then Validar en redeban la transansaccion<usuario>
    And logout redeban

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10333040" | "1234"     |

  @CP02675M @passed
  Scenario Outline: CP02675M_SYS_Validar botón menú hamburguesa desde perfil negocio (mas servicio).
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingresar a menu hamburguesa perfil negocio
    Then validar boton mas servicios

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10050018" | "2589"     |

  @CP02677M @passed
  Scenario Outline: CP02677M_SYS_Validar opción actualización de datos desde botón "mas servicios" de menú hamburguesa desde perfil negocio.
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingresar a menu hamburguesa perfil negocio
    Then Ingresar a actualizar datos y validar la opcion

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10333040" | "1234"     |

  @CP02679M @passed
  Scenario Outline: CP02679M_SYS_Validar actualización de Datos desde perfil negocio (Actualizar nombre negocio).
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingresar a menu hamburguesa perfil negocio
    And Ingresar a actualizar datos
    And Actualizar nombre negocio <nombreNegocioNuevo>
    Then Validar actualizacion de datos

    Examples: 
      | tipoId | usuario    | contrasena | nombreNegocioNuevo |
      | "CC"   | "10333040" | "1234"     | "Maleteros"        |

  @CP02680M @passed
  Scenario Outline: CP02680M_SYS_Validar actualización de Datos desde perfil negocio (Actualizar dirección del negocio).
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingresar a menu hamburguesa perfil negocio
    And Ingresar a actualizar datos
    And Actualizar direccion negocio <tipoVia><numeroUno><numeroDos><numeroTres>
    Then Validar actualizacion de direccion

    Examples: 
      | tipoId | usuario    | contrasena | tipoVia   | numeroUno | numeroDos | numeroTres |
      | "CC"   | "10333040" | "1234"     | "Avenida" | "8"       | "6"       | "8"        |

  @CP02681M @defecto
  Scenario Outline: CP02681M_SYS_Validar actualización de Datos desde perfil negocio (Actualizar ciudad del negocio).
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingresar a menu hamburguesa perfil negocio
    And Ingresar a actualizar datos
    And Actualizar ciudad <ciudadNueva>
    Then Validar actualizacion de datos

    Examples: 
      | tipoId | usuario      | contrasena | ciudadNueva |
      | "CC"   | "1020770032" | "1234"     | "C"         |

  @CP02682M @defecto
  Scenario Outline: CP02682M_SYS_Validar actualización de Datos desde perfil negocio (Actualizar que vende).
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingresar a menu hamburguesa perfil negocio
    And Ingresar a actualizar datos
    And Actualizar que vende <ventaNueva>
    Then Validar actualizacion de datos

    Examples: 
      | tipoId | usuario      | contrasena | ventaNueva |
      | "CC"   | "1020770032" | "1234"     | "D"        |

  @CP02686M @passed
  Scenario Outline: CP02686M_SYS_Validar visualización de catalogo.
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    Then Validar catalogo

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "1020770002" | "1234"     |

  @CP02687M @passed
  Scenario Outline: CP02687M_SYS_Validar opciones (compartir, editar, eliminar).
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingreso a catalogo creado
    Then Validar opciones compartir editar eliminar

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "1020770002" | "1234"     |

  @CP02688M @passed
  Scenario Outline: CP02688M_SYS_Validar opción editar producto de catalogo.
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingreso a catalogo creado
    Then Validar opcion editar producto catalogo

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "1020770002" | "1234"     |

  @CP02689M @passed
  Scenario Outline: CP02689M_SYS_Validar opción compartir por medio de mensaje (texto para catalogo, categoría y producto).
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingreso a catalogo creado
    Then Validar opcion compartir

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "1020770002" | "1234"     |

  @CP02690M @passed
  Scenario Outline: CP02690M_SYS_Validar la opción de eliminar catálogo.
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingreso a catalogo creado
    Then Validar opcion eliminar

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "1020770002" | "1234"     |

  @CP02691M @Passed @defectoQr
  Scenario Outline: CP02691M_SYS_Validar la creación de código QR sin valor
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingresar a codigo QR
    And Creación QR sin valor
    Then Validar QR Creado

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "1020770002" | "1234"     |

  @CP02692M @Passed
  Scenario Outline: CP02692M_SYS_Validar la creación de código QR con valor aleatorio.
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingresar a codigo QR
    And Creación QR con valor <valor>
    Then Validar QR Creado con valor aleatorio

    Examples: 
      | tipoId | usuario    | contrasena | valor   |
      | "CC"   | "10050033" | "2589"     | "50000" |

  @CP02693M @Passed
  Scenario Outline: CP02693M_SYS_Validar la creación de código QR con valor, con el tope minimo y maximo actual permitido en el mes.
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingresar a codigo QR
    And Creación QR con valor tope minimo <valorMinimo>
    And Validar QR Creado con valor minimo
    And Creación QR con valor tope maximo <valorMaximo>
    Then Validar QR Creado con valor maximo

    Examples: 
      | tipoId | usuario    | contrasena | valorMinimo | valorMaximo |
      | "CC"   | "10050033" | "2589"     | "1"         | "1250000"   |

  @CP02694M @defectoQr
  Scenario Outline: CP02694M_SYS_Validar que permita la descarga del QR en pdf (QR sin valor).
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingresar a codigo QR
    And Creación QR sin valor
    Then Validar descarga pdf sin valor

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "1020770002" | "1234"     |

  @CP02695M @defectoQr
  Scenario Outline: CP02695M_SYS_Validar que permita la descarga del QR en pdf (QR con valor).
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingresar a codigo QR
    And Creación QR con valor <valor>
    Then Validar descarga pdf con valor

    Examples: 
      | tipoId | usuario      | contrasena | valor   |
      | "CC"   | "1020770002" | "1234"     | "50000" |

  @CP02696M @defectoQr
  Scenario Outline: CP02696M_SYS_Validar opción compartir QR (QR sin valor).
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingresar a codigo QR
    And Creación QR sin valor
    Then Validar compartir QR sin valor

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "1020770002" | "1234"     |

  @CP02697M @defectoQr
  Scenario Outline: CP02697M_SYS_Validar opción compartir QR (QR con valor).
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingresar a codigo QR
    And Creación QR con valor <valor>
    Then Validar compartir QR con valor

    Examples: 
      | tipoId | usuario      | contrasena | valor   |
      | "CC"   | "1020770002" | "1234"     | "50000" |

  @CP02698M @passed
  Scenario Outline: CP02698M_SYS_Validar funcionalidad de sacar plata desde botón de home desde perfil negocio.
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingresar a menu hamburguesa perfil negocio
    And ingresar a opcion sacar plata
    And Flujo de sacar plata
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    Then Validar en redeban la transansaccion<usuario>
    And logout redeban

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "1020770002" | "1234"     |

  @CP02699M @passed
  Scenario Outline: CP02699M_SYS_Validar funcionalidad de pasar plata (a otro DaviPlata), desde botón de home desde perfil negocio.
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingresar a opcion pasar plata home
    And ingresar a otro daviplata perfil negocio
    Then flujo pasar plata y validacion de la transaccion <numCuenta>
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    Then Validar en redeban la transansaccion<usuario>
    And logout redeban

    Examples: 
      | tipoId | usuario      | contrasena | numCuenta    |
      | "CC"   | "1020770002" | "1234"     | "3054250150" |

  @CP02700M @passed
  Scenario Outline: CP02700M_SYS_Validar funcionalidad de pasar plata (a cuenta de ahorros), desde botón de home desde perfil negocio.
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingresar a opcion pasar plata home
    And Ingresar a cuenta de ahorros perfil negocio
    And flujo pasar plata y validar la transaccion <numCuenta>
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    Then Validar en redeban la transansaccion<usuario>
    And logout redeban

    Examples: 
      | tipoId | usuario      | contrasena | numCuenta     |
      | "CC"   | "1020770002" | "1234"     | "98170019255" |

  @CP02701M @passed
  Scenario Outline: CP02701M_SYS_Validar funcionalidad de pasar plata (a cuenta corriente), desde botón de home desde perfil negocio.
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingresar a opcion pasar plata home
    And Ingresar a cuenta corriente perfil negocio
    And flujo pasar plata y validar la transaccion a cuenta corriente <numCuenta>
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    Then Validar en redeban la transansaccion<usuario>
    And logout redeban

    Examples: 
      | tipoId | usuario      | contrasena | numCuenta     |
      | "CC"   | "1020770002" | "1234"     | "98169994476" |

  @CP027028M @readyPorProbar
  Scenario Outline: CP02702M_SYS_Validar funcionalidad de pasar plata (a cuenta corriente), desde botón de home desde perfil negocio.
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingresar a menu hamburguesa perfil negocio
    Then validar boton mas servicios
    And verifico opcion abrir punto de venta
    And abro nuevo punto de venta
    And completo datos para crear el punto de venta <puntoVentaName> <ciudad> <tipoDireccion>
    And Ingresar a opcion pasar plata home
    And Ingresar a cuenta corriente perfil negocio
    And flujo pasar plata y validar la transaccion a cuenta corriente <numCuenta>
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    Then Validar en redeban la transansaccion<usuario>
    And logout redeban

    Examples: 
      | tipoId | usuario    | contrasena | numCuenta     | puntoVentaName | ciudad     | tipoDireccion |
      | "CC"   | "10050033" | "2589"     | "98169994476" | "Avenida"      | "Medellín" | "Avenida"     |

  @CP02705M
  Scenario Outline: CP02705M_SYS_Validar funcionalidad cambio de perfiles
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio para validar funcionalidad del boton
    And Valido ingreso al perfil negocio
    And Ingreso a perfil persona para validar funcionalidad del boton
    Then Valido ingreso al perfil persona

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10050099" | "2589"     |

  @CP02678M @passed
  Scenario Outline: CP02678M_SYS_Validar actualización de Datos desde perfil negocio (correo).
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingresar a menu hamburguesa perfil negocio
    And Ingresar a actualizar datos
    And Actualizar correo perfil negocio <correoNuevo>
    Then Validar actualizacion de datos

    Examples: 
      | tipoId | usuario    | contrasena | correoNuevo                 |
      | "CC"   | "10050066" | "2589"     | "pruebasdavilab4@gmail.com" |

  @CP02676M @passed
  Scenario Outline: CP02676M_SYS_Validar movimientos de venta desde botón "mas servicios" de menú hamburguesa desde perfil negocio.
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingresar a menu hamburguesa perfil negocio
    And Ingresar a ver movimientos

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10050066" | "2589"     |

  @CP02684M @Passed
  Scenario Outline: CP02684M_SYS_Validar la creación de catalogo nuevo con referencia.
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And ir opcion crear catalogo
    And flujo crear catalogo <nombreCatalogo> <nombreCategoria> <nombreProducto> <nombreContacto> <numeroContacto> <colorReferencias> <unidadesDisponibles> <valorProducto>
    Then validar creacion catalogo

    Examples: 
      | tipoId | usuario    | contrasena | nombreCatalogo | nombreCategoria | nombreProducto | nombreContacto | numeroContacto | colorReferencias | unidadesDisponibles | valorProducto |
      | "CC"   | "10050066" | "2589"     | "Computadores" | "Portatiles"    | "Core Ryzen 5" | "Monica"       | "3213702171"   | "Negro"          | "2"                 | "5000000"     |

  @CP02685M @Passed
  Scenario Outline: CP02685M_SYS_Validar la creación de catalogo nuevo sin referencia
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And ir opcion crear catalogo
    And flujo crear catalogo sin referencia <nombreCatalogo> <nombreCategoria> <nombreProducto> <nombreContacto> <numeroContacto> <unidadesDisponibles> <valorProducto>
    Then validar creacion catalogo

    Examples: 
      | tipoId | usuario      | contrasena | nombreCatalogo | nombreCategoria | nombreProducto | nombreContacto | numeroContacto | unidadesDisponibles | valorProducto |
      | "CC"   | "1020770002" | "1234"     | "Mouse"        | "Grandes"       | "Mouse Gamer"  | "Camila"       | "3213702171"   | "2"                 | "40000"       |

  @CP02702M @Defecto
  Scenario Outline: CP02702M_SYS_Validar funcionalidad de pasar plata (a otro banco), desde botón de home desde perfil negocio.
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Validé saldos iniciales del daviplata en perfil negocio
    And Ingresar a opcion pasar plata home
    And Ingresar a otros bancos perfil negocio
    Then flujo pasar plata y validar la transaccion a otros bancos <numeroProducto><numId><montoAPasar><motivoPasarPlata>
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario      | contrasena | numeroProducto | numId     | montoAPasar | motivoPasarPlata |
      | "CC"   | "1020770004" | "1234"     | "123456789"    | "1007716" | "10000"     | "Test"           |

  @CP02703M @Defecto
  Scenario Outline: CP02703M_SYS_Validar funcionalidad de pasar plata (a otro banco en línea), desde botón de home desde perfil negocio.
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Validé saldos iniciales del daviplata en perfil negocio
    And Ingresar a opcion pasar plata home
    And Ingresar a otros bancos en linea perfil negocio
    Then flujo pasar plata y validar la transaccion a otro banco en linea <numCelular><monto>
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario      | contrasena | numCelular   | monto |
      | "CC"   | "1020770004" | "1234"     | "3227680700" | "100" |

  #Diseños de nuevos casos
  @CP02704M @Defecto
  Scenario Outline: CP02704M_SYS_Validaciones puntos de ventas y vendedores
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingresar a menu hamburguesa perfil negocio
    And Ingreso a la opcion mas servicios
    And Ingreso a la opcion de administrar mi negocio
    And Creo punto de venta <nombrePuntoVenta><ciudad><primerNumeroDireccion><segundoNumeroDireccion><tercerNumeroDireccion>
    Then Validar creacion punto de venta
    And Creo vendedor <tipoId><nombreVendedor><numeroDocumento><numeroDeCelular>
    Then Validar que permita actualizar los datos en punto venta y en vendedor <nombrePuntoVentaDos><numeroDeCelularDos>
    Then Validar que permita eliminar punto venta y vendedores
    
    Examples: 
      | tipoId | usuario    | contrasena | nombrePuntoVenta | ciudad                       | primerNumeroDireccion | segundoNumeroDireccion | tercerNumeroDireccion | nombreVendedor   | numeroDocumento | numeroDeCelular | nombrePuntoVentaDos | numeroDeCelularDos |
      | "CC"   | "10050066" | "2589"     | "Motores"        | "Bogota D.C. - Bogotá, D.C." | "9"                   | "13"                   | "89"                  | "Paola Buitrago" | "10050064"      | "3221005047"    | "monty"             | "3202927338"       |

  @CP02706M @passed
  Scenario Outline: CP02706M_SYS_Validar que permita generar enlace PSE mis productos y otros
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Selecciono el botón enlace de pago opcion dos
    Then Realizo la creación del enlace de pago mis productos
    And Selecciono la creación del enlace de pago Otros <descripcion> <valor>

    Examples: 
      | tipoId | usuario      | contrasena | descripcion | valor   |
      | "CC"   | "10333040"   | "1234"     | "nuecesdos" | "10000" |

  @CP02707M
  Scenario Outline: CP02707M_SYS_Validar que permita compra en la tienda virtual mi negocio
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Selecciono más ingresos para su negocio desde el home
    Then Ingreso a tienda virtual y realizo una compra

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "10050066"   | "2589"     |

  @CP02708M
  Scenario Outline: CP02708M_SYS_Validar que permita descargar el extracto de más ingresos para su negocio
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Selecciono más ingresos para su negocio desde el home
    And Ingreso a los movimientos desde la opcion más ingresos
    And Ingreso y descargo el extracto de los movimientos

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "10050066"   | "2589"     |

  @CP02709M
  Scenario Outline: CP02709M_SYS_Validar que en la pantalla de consulta se vean los datos correctos del movimiento teniendo en cuenta que el usuario realiza el pago
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Validé saldos iniciales del daviplata
    And Selecciono más ingresos para su negocio desde el home
    Then Ingreso a tienda virtual y realizo una compra
    And validar saldo final
    And Selecciono más ingresos para su negocio desde el home
    And Ingreso a los movimientos desde la opcion más ingresos

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "10050066"   | "2589"     |
