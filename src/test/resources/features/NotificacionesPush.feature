@NotificacionesPush
Feature: Notificaciones Push

 @CP011010M
  Scenario Outline: CP011010M_SYS_Validar transacción desde cuenta davivienda a daviplata
    Given Abrir web de davivienda <tipoDocumentoWebDavivienda><usuarioDavivienda><contrasenaDavivienda><numeroCelularUsuarioDavivienda>
    When Realizo transaccion de davivienda a daviplata <monto><numeroCelular>
    Then Cerrar sesion de davivienda
    When ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Valido la transacción en la campana de notificaciones

    Examples: 
      | tipoDocumentoWebDavivienda | usuarioDavivienda | contrasenaDavivienda | numeroCelularUsuarioDavivienda | monto  | numeroCelular | tipoId | usuario    | contrasena |
      | "CC"                       | "808004"          | "252589"             | "3016984768"                   | "5000" | "3221005055"  | "CC"   | "10050072" | "2589"     |

  