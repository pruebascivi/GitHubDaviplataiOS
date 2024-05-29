@olvidoClave
Feature: Modulo Olvido Clave

  @CP1289M
  Scenario Outline: CP1289M_SYS_Validar proceso de olvido de clave para tipo documental CC
    Given Ingresé al modulo olvido clave
    When Ingreso datos de olvido clave <tipoDocumento> <NumeroDocumento>
    And Consulto numero celular en redeban <NumeroDocumento>
    And Consulto en latinia la otp de olvido clave
    And Ingreso otp en cambio de clave
    And Ingreso clave nueva en olvido clave <claveNueva> <claveNueva>
    Then Validar cambio de clave
    And Ingresar a la app para validar el ingreso con nueva clave <tipoDocumento> <NumeroDocumento> <claveNueva>

    Examples: 
      | tipoDocumento | NumeroDocumento | claveNueva |
      | "cc"          | "10050077"      | "1342"     |

  @CP1321M
  Scenario Outline: CP1321M_SYS_Validar proceso de olvido de clave para tipo documental CC ingresando clave temporal erronea
    Given Ingresé al modulo olvido clave
    When Ingreso datos de olvido clave <tipoDocumento> <NumeroDocumento>
    Then Validar clave temporal erronea

    Examples: 
      | tipoDocumento          | NumeroDocumento | contrasena |
      | "Cédula de ciudadanía" | "10333037"      | "3102"     |

  @CP03380M
  Scenario Outline: CP03380M_SYS_Validar proceso de olvido de clave para tipo documental CC ingresando correo erroneo
    Given obtener correo actual en redeban <usuario>
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When selecciono menu hamburguesa
    And selecciono cambiar clave y correo
    And cambiar correo  <correoNuevo>
    Then validar cambio de correo fallido
    And validar No cambio correo en redeban <usuario> <correoNuevo>

    Examples: 
      | tipoId | usuario    | contrasena | correoNuevo |
      | "CC"   | "10050040" | "0225"     | "xxx@.com"  |

  @CP1322M @CLAVE123
  Scenario Outline: CP1322M_SYS_Validar proceso de olvido de clave para tipo documental CC ingresando confirmación erronea de la clave
    Given consultar correo actual en redeban <NumeroDocumento>
    When completar flujo olvido su clave ingresando confirmación erronea <tipoDocumento> <NumeroDocumento> <claveNueva>
    Then validar cambio de clave erroneo

    Examples: 
      | tipoDocumento          | NumeroDocumento | claveNueva |
      | "Cédula de ciudadanía" | "10333037"      | "0225"     |

  @CP1323M @CLAVE123
  Scenario Outline: CP1323M_SYS_Validar proceso de olvido de clave para tipo documental CE
    Given consultar correo actual en redeban <NumeroDocumento>
    Given completar flujo olvido su clave <tipoDocumento> <NumeroDocumento> <claveNueva>
    Then validar cambio de clave <tipoDocumento> <NumeroDocumento> <claveNueva>

    Examples: 
      | tipoDocumento           | NumeroDocumento | claveNueva |
      | "Cédula de extranjeria" | "90062810017"   | "2589"     |

  @CP1324M @CLAVE123
  Scenario Outline: CP1324M_SYS_Validar proceso de olvido de clave para tipo documental CE ingresando correo erroneo
    Given obtener correo actual en redeban <usuario>
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When selecciono menu hamburguesa
    And selecciono cambiar clave y correo
    And cambiar correo  <correoNuevo>
    Then validar cambio de correo fallido
    And validar No cambio correo en redeban <usuario> <correoNuevo>

    Examples: 
      | tipoId | usuario    | contrasena | correoNuevo |
      | "CE"   | "10272004" | "1234"     | "xxx@.com"  |

  @CP1325M @CLAVE123
  Scenario Outline: CP1325M_SYS_Validar proceso de olvido de clave para tipo documental CE ingresando clave temporal erronea
    Given Habilite proceso de olvido clave temporal redeban <usuario>
    And Cerre redeban desde olvido clave
    When Ingreso usuario y contrasena de olvido clave <tipoId> <usuario> <contrasena>
    Then Validar clave temporal erronea

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CE"   | "10272004" | "1234"     |

  @CP1326M @CLAVE123
  Scenario Outline: CP1326M_SYS_Validar proceso de olvido de clave para tipo documental CE solicitando nuevamente clave temporal
    Given consultar correo actual en redeban <NumeroDocumento>
    When flujo olvido su clave otp <tipoDocumento> <NumeroDocumento> <claveNueva>

    Examples: 
      | tipoDocumento           | NumeroDocumento | claveNueva |
      | "Cédula de extranjeria" | "90062810017"   | "2589"     |

  @CP1327M @CLAVE123
  Scenario Outline: CP1327M_SYS_Validar proceso de olvido de clave para tipo documental CE ingresando confirmación erronea de la clave
    Given consultar correo actual en redeban <NumeroDocumento>
    When completar flujo olvido su clave ingresando confirmación erronea <tipoDocumento> <NumeroDocumento> <claveNueva>
    Then validar cambio de clave erroneo

    Examples: 
      | tipoDocumento           | NumeroDocumento | claveNueva |
      | "Cédula de extranjeria" | "90062810017"   | "2589"     |

  @CP1328M @CLAVE123
  Scenario Outline: CP1328M_SYS_Validar proceso de olvido de clave para tipo documental TI
    Given consultar correo actual en redeban <NumeroDocumento>
    When completar flujo olvido su clave <tipoDocumento> <NumeroDocumento> <claveNueva>
    Then validar cambio de clave <tipoDocumento> <NumeroDocumento> <claveNueva>

    Examples: 
      | tipoDocumento          | NumeroDocumento | claveNueva |
      | "Tarjeta de identidad" | "1022988"       | "1320"     |

  @CP1329M @CLAVE12
  Scenario Outline: CP1329M_SYS_Validar proceso de olvido de clave para tipo documental TI ingresando correo erroneo
    Given obtener correo actual en redeban <usuario>
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When selecciono menu hamburguesa
    And selecciono cambiar clave y correo
    And cambiar correo  <correoNuevo>
    Then validar cambio de correo fallido
    And validar No cambio correo en redeban <usuario> <correoNuevo>

    Examples: 
      | tipoId | usuario   | contrasena | correoNuevo |
      | "TI"   | "1022988" | "1230"     | "xxx@.com"  |

  @CP1231M @olvidoClave20
  Scenario Outline: CP1231M_SYS_Validar proceso de olvido de clave para tipo documental TI ingresando clave temporal erronea
    Given Habilite proceso de olvido clave temporal redeban <usuario>
    And Cerre redeban desde olvido clave
    When Ingreso usuario y contrasena de olvido clave <tipoId> <usuario> <contrasena>
    Then Validar clave temporal erronea

    Examples: 
      | tipoId | usuario   | contrasena |
      | "TI"   | "1022988" | "1342"     |

  @CP1232M
  Scenario Outline: CP1232M_SYS_Validar proceso de olvido de clave para tipo documental TI solicitando nuevamente clave temporal
    When flujo olvido su clave otp <tipoDocumento> <NumeroDocumento> <claveNueva>

    Examples: 
      | tipoDocumento          | NumeroDocumento | claveNueva |
      | "Tarjeta de identidad" | "1022988"       | "1320"     |

  @CP1233M
  Scenario Outline: CP1233M_SYS_Validar proceso de olvido de clave para tipo documental TI ingresando confirmación erronea de la clave
    When completar flujo olvido su clave ingresando confirmación erronea <tipoDocumento> <NumeroDocumento> <claveNueva>
    Then validar cambio de clave erroneo

    Examples: 
      | tipoDocumento          | NumeroDocumento | claveNueva |
      | "Tarjeta de identidad" | "1022988"       | "4321"     |

  @CP1234M
  Scenario Outline: CP1234M_SYS_Validar proceso de olvido de clave para tipo documental PEP
    When completar flujo olvido su clave <tipoDocumento> <NumeroDocumento> <claveNueva>
    Then validar cambio de clave <tipoDocumento> <NumeroDocumento> <claveNueva>

    Examples: 
      | tipoDocumento | NumeroDocumento | claveNueva |
      | "CC"          | "10333040"      | "2580"     |

  @CP1235M @olvidoClave20
  Scenario Outline: CP1235M_SYS_Validar proceso de olvido de clave para tipo documental PEP ingresando correo erroneo
    Given obtener correo actual en redeban <usuario>
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When selecciono menu hamburguesa
    And selecciono cambiar clave y correo
    And cambiar correo  <correoNuevo>
    Then validar cambio de correo fallido
    And validar No cambio correo en redeban <usuario> <correoNuevo>

    Examples: 
      | tipoId | usuario    | contrasena | correoNuevo |
      | "CC"   | "10333040" | "2580"     | "xxx@.com"  |

  @CP1236M @olvidoClave20
  Scenario Outline: CP1236M_SYS_Validar proceso de olvido de clave para tipo documental PEP ingresando clave temporal erronea
    Given Habilite proceso de olvido clave temporal redeban <usuario>
    And Cerre redeban desde olvido clave
    When Ingreso usuario y contrasena de olvido clave <tipoId> <usuario> <contrasena>
    Then Validar clave temporal erronea

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10333040" | "1061"     |

  #@CP1237M
  #Scenario Outline: CP1237M_SYS_Validar proceso de olvido de clave para tipo documental PEP solicitando nuevamente clave temporal
  #  When flujo olvido su clave otp <tipoDocumento> <NumeroDocumento> <claveNueva>
  # Examples:
  #  | tipoDocumento           | NumeroDocumento   | claveNueva |
  ##@externaldata@D:/ArchivosRobotMovil/OlvidoClave/OlvidoClave.xlsx@CP1237M
  # | "Cédula de extranjeria" | "9876511" | "4321"     |
  @CP1238M
  Scenario Outline: CP1238M_SYS_Validar proceso de olvido de clave para tipo documental PEP ingresando confirmación erronea de la clave
    Given consultar correo actual en redeban <NumeroDocumento>
    When completar flujo olvido su clave ingresando confirmación erronea <tipoDocumento> <NumeroDocumento> <claveNueva>
    Then validar cambio de clave erroneo

    Examples: 
      | tipoDocumento           | NumeroDocumento | claveNueva |
      | "Cédula de extranjeria" | "10333040"      | "2580"     |

  @CP1300M
  Scenario Outline: CP1300M_SYS_Validar que permita el cambio si esta es la misma a la anterior
    When completar flujo olvido su clave <tipoDocumento> <NumeroDocumento> <claveNueva>
    Then validar cambio de clave <tipoDocumento> <NumeroDocumento> <claveNueva>

    Examples: 
      | tipoDocumento          | NumeroDocumento | claveNueva |
      | "Cédula de ciudadanía" | "10333040"      | "2580"     |

  @CP1310M
  Scenario Outline: CP1310M_SYS_Validar que no permita el olvido de clave nueva no coincide
    When completar flujo olvido su clave ingresando clave nueva erronea <tipoDocumento> <NumeroDocumento> <claveNueva>
    Then validar cambio de clave erroneo

    Examples: 
      | tipoDocumento          | NumeroDocumento | claveNueva |
      | "Cédula de ciudadanía" | "10333037"      | "2580"     |

  @CP1320M
  Scenario Outline: CP1320M_SYS_Validar que no permita el olvido de clave de la OTP invalida
    Given consultar correo actual en redeban <NumeroDocumento>
    When completar flujo olvido su clave con otp mal <tipoDocumento> <NumeroDocumento> <claveNueva>
    Then validar notificacion otp mal

    Examples: 
      | tipoDocumento          | NumeroDocumento | claveNueva |
      | "Cédula de ciudadanía" | "10333038"      | "2580"     |
      
      
  @CP13002M @Passed
  Scenario Outline: CP13002M_SYS_Validar opciones del pop up olvido clave con tipo de documento TI y CE
    Given Diligencio formulario olvido clave <tipoId> <usuario> <claveNueva>
    And Valido pop up chat con asesor
    Then Validar que al dar tap en la equis direccione a la pantalla anterior
    
     Examples: 
      | tipoId | usuario       | claveNueva |
      | "CE"   | "90062810017" | "1342"     | 
      
      
      
