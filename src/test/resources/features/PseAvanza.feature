@PseAvanza
Feature: Modulo PSE Avanza

	@CP021000M @Passed @Versio6.1
  Scenario Outline: CP021000M_SYS_Validar que el campo 1 a qué número quiere meter plata permita pegar la información numérica
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Ingreso a la opción meter plata desde el home daviplata
    And Ingreso a la opción de meter plata 'Desde cualquier banco'
    And Ingreso Numero celular <numCelular>
    Then Validar que permita pegar la información númerica

    Examples: 
      | tipoId | usuario    | contrasena | numCelular   |
      | "CC"   | "10333040" | "1234"     | "3002608449" |

  @CP021001M @Passed @Versio6.1
  Scenario Outline: CP021001M_SYS_Validar meter plata no exitoso desde banco "BANCO UNION COLOMBIANO" con destino a diferentes estados de usuario
    Given Obtuve el numero celular del usuario destino validando el estado <usuarioDestino><estado>
    And Validé estado nor del usuario origen <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban subtipo
    When ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    And Ingreso a la opción meter plata desde el home daviplata
    And Ingreso a la opción de meter plata 'Desde cualquier banco'
    And Ingreso Numero celular destino
    And Ingreso confirmacion de numero celular destino
    And Ingreso monto <monto>
    And Despliego la lista de los bancos
    And Escojo la opción banco <banco>
    And Ingreso caracteres alfanumericos en el campo de correo <correo>
    And Doy clic en el botón continuar
    And Validar mensaje de transacción no exitosa
    Then Validar Saldo Final
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta

    Examples: 
      | tipoId | usuario    | contrasena | usuarioDestino | estado | monto     | correo                      | banco                    |
      | "CC"   | "10050066" | "2589"     | "10050066"     | "NOR"  | "5000000" | "prulabdaviplata@gmail.com" | "BANCO UNION COLOMBIANO" | 
      
  @CP021002M @Passed @Versio6.1 
  Scenario Outline: CP021002M_SYS_Validar pop up salida de la app en el modulo meter plata
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a la opción meter plata desde el home daviplata
    And Ingreso a la opción 'Desde cuentas Davivienda' en el módulo meter plata
    And Valido que el correo en la transacción este precargado
    And Edito correo de transaccion <correo>
    And Validar correo nuevo ingresado
    And Ingreso monto a recargar en el daviplata <monto>
    And Doy clic en el botón continuar
    And Valido Pantalla de verificar informacion ingresada
    And Hacer clic en el botón atras
    And Valido Pantalla anterior del formulario
    And Valido boton necesito ayuda
    Then Validar las funciones del popUp salir de la app

    Examples: 
      | tipoId | usuario    | contrasena | correo             | monto  |
      | "CC"   | "10333040" | "1234"     | "yuli36@gmail.com" | "6000" |
      
  @CP021003M @PassedEnCasoCP021003M @Versio6.1 
  Scenario Outline: CP021003M_SYS_Realizar tres recargas en la App con un usuario a un mismo DaviPlata pero con tres correos diferentes
    Given Obtuve el numero celular del usuario destino validando el estado <usuarioDestino><estado>
    And Validé estado nor del usuario origen <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban subtipo
    When ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    And Ingreso a la opción meter plata desde el home daviplata
    And Ingreso a la opción de meter plata 'Desde cualquier banco'
		And Ingreso Numero celular destino
    And Ingreso confirmacion de numero celular destino
    And Ingreso monto <monto>
    And Despliego la lista de los bancos
    And Escojo la opción banco <banco>
    And Ingreso caracteres alfanumericos en el campo de correo <correo>
    And Doy clic en el boton continuar del formulario desde otros bancos
    And Valido transaccion exitosa
    Then Validar Saldo Final
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario    | contrasena | usuarioDestino | estado | monto   | correo                       | banco                    |
      | "CC"   | "10050066" | "2589"     | "10333040"     | "NOR"  | "50000" | "prulabdaviplata1@gmail.com" | "BANCO UNION COLOMBIANO" | 
      | "CC"   | "10050066" | "2589"     | "10333040"     | "NOR"  | "50000" | "prulabdaviplata2@gmail.com" | "BANCO UNION COLOMBIANO" | 
      | "CC"   | "10050066" | "2589"     | "10333040"     | "NOR"  | "50000" | "prulabdaviplata3@gmail.com" | "BANCO UNION COLOMBIANO" | 
    	    
  @CP021004M @Passed @Versio6.1
  Scenario Outline: CP021004M_SYS_Validar meter plata exitoso desde banco "BANCO UNION COLOMBIANO" con destino a diferentes estados de usuario
    Given Obtuve el numero celular del usuario destino validando el estado <usuarioDestino><estado>
    And Validé estado nor del usuario origen <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban subtipo
    When ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    And Ingreso a la opción meter plata desde el home daviplata
    And Ingreso a la opción de meter plata 'Desde cualquier banco'
    And Ingreso Numero celular destino
    And Ingreso confirmacion de numero celular destino
    And Ingreso monto <monto>
    And Despliego la lista de los bancos
    And Escojo la opción banco <banco>
    And Ingreso caracteres alfanumericos en el campo de correo <correo>
    And Doy clic en el boton continuar del formulario desde otros bancos
    And Validar mensaje de transacción exitosa
    Then Validar Saldo Final
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta

    Examples: 
      | tipoId | usuario    | contrasena | usuarioDestino | estado | monto   | correo                      | banco                    |
      | "CC"   | "10050066" | "2589"     | "10333040"     | "NOR"  | "50000" | "prulabdaviplata@gmail.com" | "BANCO UNION COLOMBIANO" | 
      