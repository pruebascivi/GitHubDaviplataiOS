#Author: David Cardenas Guzman
@nanocredito
Feature: Agrupoación de casos de Nanocredito

  @CP0610M
  Scenario Outline: CP0610M_SYS_Validar que al dar clic en No me interesa, no se genere la solicitud del crédito
    Given ingreso usuario y contrasena no me interesa <usuario> <contrasena>
    Then valido no me interesa

    Examples: 
      | usuario   | contrasena |
      | "2569109" | "1234"     |

  @CP0620M
  Scenario Outline: CP0620M_SYS_Validar que se genere la solicitud del crédito con un cliente en campaña de crédito
    Given ingreso usuario y contrasena no me interesa <usuario> <contrasena>
    When proceso nanocredito completo <valor> <diaAPagar> <ciudad>
    Then valido nanocredito

    Examples: 
      | usuario   | contrasena | valor | diaAPagar                      | ciudad   |
      | "2569020" | "1234"     | "0"   | "El día martes de cada semana" | "BOGOTA" |

  @CP0630M
  Scenario Outline: CP0630M_SYS_Validar que no permita solicitar el crédito ingresando un monto diferente al aprobado
    Given ingreso usuario y contrasena no me interesa <usuario> <contrasena>
    When cambio valor de nanocredito superior
    Then valido pop up de monto superior al permitido

    Examples: 
      | usuario   | contrasena |
      | "2569109" | "1234"     |

  @CP0640M
  Scenario Outline: CP0640M_SYS_Validar que no permita solicitar el crédito cuando el DaviPlata no concuerde
    Given ingreso usuario y contrasena no me interesa <usuario> <contrasena>
    When entro a credito por el menu
    Then valido pop up no coincide campana

    Examples: 
      | usuario   | contrasena |
      | "2569031" | "1234"     |

  @CP0650M
  Scenario Outline: CP0650M_SYS_Validar que no permita solicitar el crédito cuando el DaviPlata esta en listas restrictivas
    Given ingreso usuario y contrasena no me interesa <usuario> <contrasena>
    When entro a credito por el menu
    Then valido pop up de listas restrictivas

    Examples: 
      | usuario   | contrasena |
      | "2569013" | "1234"     |

  @CP0660M
  Scenario Outline: CP0660M_SYS_Validar que no permita solicitar el crédito cuando el DaviPlata esta en listas de asegurabilidad
    Given ingreso usuario y contrasena no me interesa <usuario> <contrasena>
    When entro a credito por el menu
    Then valido pop up de listas de asegurabilidad

    Examples: 
      | usuario   | contrasena |
      | "2569013" | "1234"     |

  @CP0670M
  Scenario Outline: CP0670M_SYS_Validar que no se genere el crédito a un cliente que no cumpla con las políticas de evaluación (Definir mínimo una)
    Given ingreso usuario y contrasena no me interesa <usuario> <contrasena>
    When entro a credito por el menu
    Then valido pop up de listas restrictivas

    Examples: 
      | usuario   | contrasena |
      | "2569109" | "1234"     |

  @CP0680M
  Scenario Outline: CP0680M_SYS_Validar que no se genere el crédito con una OTP invalida
    Given ingreso usuario y contrasena no me interesa <usuario> <contrasena>
    When realizo proceso de credito <valor> <diaAPagar> <ciudad>
    Then valido otp invalida

    Examples: 
      | usuario   | contrasena | valor | diaAPagar                      | ciudad   |
      | "2569109" | "1234"     | "0"   | "El día martes de cada semana" | "BOGOTA" |

  @CP0700M
  Scenario Outline: CP0700M_SYS_Validar la consulta del nano crédito cuando este esta en mora
    Given ingreso usuario y contrasena <usuario> <contrasena>
    Then valido cuanto debo

    Examples: 
      | usuario   | contrasena |
      | "2569109" | "1234"     |

  @CP0710M
  Scenario Outline: CP0710M_SYS_Validar la consulta del nano crédito cuando este esta al día
    Given ingreso usuario y contrasena <usuario> <contrasena>
    Then valido cuanto debo

    Examples: 
      | usuario   | contrasena |
      | "2569109" | "1234"     |

  @CP0720M
  Scenario Outline: CP0720M_SYS_Validar que se muestre el mensaje cuando el cliente no tiene nano créditos activos
    Given ingreso usuario y contrasena <usuario> <contrasena>
    Then valido cuanto debo

    Examples: 
      | usuario   | contrasena |
      | "2569109" | "1234"     |

  @CP0684M @Passed
  Scenario Outline: CP0684M_SYS_Validar cajón de nanocredito barra productos
    Given Ingreso usuario y contrasena en nanocredito <tipoId> <usuario> <contrasena>
    Then Validar PopUp nanocredito al ingresar al home daviplata
    When Seleccionar opcion no me interesa
    And Validar cajon nanocredito de la barra productos
   	And Ingresar a nanocredito desde home opcion mas productos

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "80145621" | "1234"     |
      
  @CP0681M @Passed
  Scenario Outline: CP0681M_SYS_Validar popup de Nanocredito
    Given Ingreso usuario y contrasena en nanocredito <tipoId> <usuario> <contrasena>
    Then Validar PopUp nanocredito al ingresar al home daviplata
    When Seleccionar opcion no me interesa
    Then Validar home daviplata
    And Validar cajon nanocredito de la barra productos
    And Ingresar a nanocredito desde home opcion mas productos
    
    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "80145621" | "1234"     |
      
      
