@registro
Feature: Casos de registro

  @CP1480M @registro12 @PASSED
  Scenario Outline: CP1480M_SYS_Validar registro completo en la APP DaviPlata
    Given Realizo registro <tipoId> <usuario>
    And Acepte autorizaciones de regitro
    When completo formulario mis datos <nombre> <dia> <mes> <año> <diaExpedicion> <mesExpedicion> <anioExpedicion> <lugar> <cel> <correo>
    And ingreso otp
    And ingreso contrasena <contrasena>
    Then validar registro completo

    Examples: 
      | tipoId | usuario      | contrasena | nombre               | dia | mes     | año    | diaExpedicion | mesExpedicion | anioExpedicion | lugar   | cel           | correo          |
      | "CC"   | "1000800222" | "2589"     | "Cleopathre Jhnuirm" | "8" | "Enero" | "2000" | "1"           | "Enero"       | "2018"         | "BOGOT" | "31554486589" | "xxx@gmail.com" |

  @CP1490M @registro123 @PASSED
  Scenario Outline: CP1490M_SYS_Validar registro con OTP invalida
    Given Realizo registro <tipoId> <usuario>
    And Acepte autorizaciones de regitro
    When completo formulario mis datos <nombre> <dia> <mes> <año> <diaExpedicion> <mesExpedicion> <anioExpedicion> <lugar> <cel> <correo>
    And ingreso otp invalida
    Then valido el mensaje de otp invalida

    Examples: 
			| tipoId  | usuario      | nombre           | dia | mes     | año    | diaExpedicion | mesExpedicion | anioExpedicion | lugar   | cel           | correo          |
    	| "CC"    | "1001115081" | "Ahmad Herzoged" | "8" | "Enero" | "2000" | "1"           | "Enero"       | "2018"         | "BOGOTA" | "3137687712" | "xxx@gmail.com" |

  @CP1500M @registro12
  Scenario Outline: CP1500M_SYS_Validar registro con Clave incorrecta
    Given Realizo registro <tipoId> <usuario>
    And Acepte autorizaciones de regitro
    When completo formulario mis datos <nombre> <dia> <mes> <año> <diaExpedicion> <mesExpedicion> <anioExpedicion> <lugar> <cel> <correo>
    And ingreso otp
    And ingreso contrasena invalidas <contrasena> <contrasenaErronea>
    Then Valido contrasena invalida

    Examples: 
      | tipoId  | usuario      | contrasena | contrasenaErronea | nombre           | dia | mes     | año    | diaExpedicion | mesExpedicion | anioExpedicion | lugar  | cel          | correo          |
      | "CC"    | "1233890123" | "1342"     | "9632"            | "Ahmad Herfrzog" | "8" | "Enero" | "2000" | "1"           | "Enero"       | "2018"         | "BOGO" | "3227680774" | "xxx@gmail.com" |

  @CP1520M @registro12
  Scenario Outline: CP1520M_SYS_Validar ingresar claves distintas y genere mensaje de error
    Given Realizo registro <tipoId> <usuario>
    And Acepte autorizaciones de regitro
    When completo formulario mis datos <nombre> <dia> <mes> <año> <diaExpedicion> <mesExpedicion> <anioExpedicion> <lugar> <cel> <correo>
    And ingreso otp
    And ingreso contrasena invalidas <contrasena> <contrasenaErronea>
    Then Valido contrasena invalida

    Examples: 
      | tipoId  | usuario      | contrasena | contrasenaErronea | nombre          | dia | mes     | año    | diaExpedicion | mesExpedicion | anioExpedicion | lugar   | cel          | correo          |
      | "CC"    | "1233890123" | "1342"     | "9632"            | "Ahmad Herzfog" | "8" | "Enero" | "2000" | "1"           | "Enero"       | "2018"         | "BOGOT" | "3227680774" | "xxx@gmail.com" |
