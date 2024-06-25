@NotificacionesPush
Feature: Notificaciones Push

  @CP011010M @Passed
  Scenario Outline: CP011010M_SYS_Validar transacción desde cuenta davivienda a daviplata
    Given Abrir web de davivienda <tipoDocumentoWebDavivienda><usuarioDavivienda><contrasenaDavivienda><numeroCelularUsuarioDavivienda>
    When Realizo transaccion de davivienda a daviplata <monto><numeroCelular>
    Then Cerrar sesion de davivienda
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Valido la transacción en la campana de notificaciones

    Examples: 
      | tipoDocumentoWebDavivienda | usuarioDavivienda | contrasenaDavivienda | numeroCelularUsuarioDavivienda | monto  | numeroCelular | tipoId | usuario    | contrasena |
      | "CC"                       | "808003"          | "159753"             | "3016984768"                   | "5000" | "3221005055"  | "CC"   | "10050072" | "2589"     |

  @CP04550M @Passed
  Scenario Outline: CP04550M_SYS_Validar que las Transferencia cuenta Davivienda a Daviplata llegue sms (latinia) push (campana app)
    Given Abrir web de davivienda <tipoDocumentoWebDavivienda><usuarioDavivienda><contrasenaDavivienda><numeroCelularUsuarioDavivienda>
    When Realizo transaccion de davivienda a daviplata <monto><numeroCelularRecargar>
    And Cerrar sesion de davivienda
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And ingreso a mensajes y notificaciones
    And Valido mensaje de recarga daviplata desde davivienda
    And Abro web de latinia
    And Filtro numero celular <numeroCelularRecargar>
    Then Validar notificacion recarga daviplata en latinia <monto>

    Examples: 
      | tipoId | usuario    | contrasena | tipoDocumentoWebDavivienda | usuarioDavivienda | contrasenaDavivienda | numeroCelularUsuarioDavivienda | monto  | numeroCelularRecargar |
      | "CC"   | "10050011" | "2589"     | "CC"                       | "808003"          | "159753"             | "3016984768"                   | "5000" | "3221005061"          |

  @CP04551M @DiseñadoPresentaDefectoTransfiya
  Scenario Outline: CP04551M_SYS_validar que al hacer un Enviar plata ACH llegue sms (latinia) , push (campana app)
    Given ingreso usuario y contrasena <tipoDocumento> <usuario> <contrasena>
    When ir a la opcion TransfiYA
    And realizo flujo pasar plata en linea <numCelularDestino> <monto>
    And Valido resultado transaccion exitosa pasar plata linea
    And Entro al modulo de movimientos
    And Valido movimiento realizado
    And Abro web de latinia
    And Filtro numero celular <numeroCelularUsuario>
    Then Validar notificacion pasar plata en linea desde latinia <monto>

    Examples: 
      | tipoDocumento | usuario    | contrasena | numeroCelularUsuario | monto | numCelularDestino |
      | "CC"          | "10050011" | "2589"     | "3299568774"         | "100" | "3227680744"      |

  @CP04552M @Passed
  Scenario Outline: CP04552M_SYS_validar que las Transferencia Daviplata a cuenta Davivienda lleguen el sms (latinia) , push (campana app)
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When seleccionar pasar plata Home
    And pasar plata monto seleccionable <tipoCuenta> <cuentaNum> <monto>
    And Validar transaccion exitosa pasar plata cuenta
    And ingreso a mensajes y notificaciones
    And Valido mensaje de transferencia desde daviplata a davivienda
    And Abro web de latinia
    And Filtro numero celular <numeroCelularUsuario>
    Then Validar notificacion transferencia desde daviplata a davivienda en latinia <monto>

    Examples: 
      | tipoId | usuario    | contrasena | numeroCelularUsuario | tipoCuenta | cuentaNum     | monto  |
      | "CC"   | "10050011" | "2589"     | "3299568774"         | "Ahorros"  | "98170019255" | "3000" |

  @CP04553M @Passed
  Scenario Outline: CP04553M_SYS_validar que al hacer una Compra Tienda Virtual lleguen el sms (Latinia) ,push (campana app)
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And ingreso a tienda virtual
    And Completo el flujo compra Bono con correo
    And ingreso a mensajes y notificaciones
    And Ingreso a notificaciones de tienda virtual
    And Valido mensaje de compra en tienda virtual desde daviplata
    And Abro web de latinia
    And Filtro numero celular <numeroCelularUsuario>
    Then Validar mensaje de compra en tienda virtual desde latinia

    Examples: 
      | tipoId | usuario    | contrasena | numeroCelularUsuario |
      | "CC"   | "10050011" | "2589"     | "3299568774"         |

  @CP04554M @PassedDefectoEnLaWeb
  Scenario Outline: CP04554M_SYS_validar que al hacer Compras/Pagos PSE lleguen sms (latinia) , push (campana app)
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Selecciono el botón enlace de pago
    And Realizo la creación del producto <nombreProducto> <valorProducto>
    And Ingreso a la web con la url de enlace de pago <usuario>
    And Diligencio otp en el enlace de pago
    And Hago clic en el boton de pagar en la otp de enlace de pago
    Then Validar datos de transaccion exitosa
    And ingreso a mensajes y notificaciones
    And Valido mensaje de compra por pse
    And Abro web de latinia
    And Filtro numero celular <numeroCelularUsuario>
    And Validar mensaje de compra en pse desde latinia

    Examples: 
      | tipoId | usuario    | contrasena | nombreProducto | valorProducto | numeroCelularUsuario |
      | "CC"   | "10050011" | "2589"     | "Maletuas"     | "10000"       | "3221005062"         |
