#Author: your.email@your.domain.com
@Acerca_de
Feature: Pruebas modulo Acerca De
#passed
  @CP0050M 
  Scenario: CP0050M_SYS_Validar la opción de Para Que Sirve
    Given ingreso al modulo acerca de
    When ingresar a opcion para que sirve
    Then validar opcion para que sirve
#defecto no muestra pnatalla de GPS
  @CP0060M
  Scenario: CP0060M_SYS_Validar la opción de Donde lo Puedo Usar
    Given ingreso al modulo acerca de
    And Ingresé al boton de notificaciones home daviplata
    When ingresar a opcion donde usar
    Then validar opcion donde usar  
#passed
  @CP0070M 
  Scenario: CP0070M_SYS_Validar el link de Twitter
    Given ingreso al modulo acerca de
    When ingresar a opcion twitter
    Then validar opcion twitter
#passed
  @CP0080M 
  Scenario: CP0080M_SYS_Validar el link de YouTube
    Given ingreso al modulo acerca de
    When ingresar a opcion youtube
    Then validar opcion youtube
 #passed
  @CP0090M 
  Scenario: CP0090M_SYS_Validar el reglamento
    Given ingreso al modulo acerca de
    When ingresar a opcion reglamento
    Then validar opcion reglamento  
#passed
  @CP0100M  
  Scenario: CP0100M_SYS_Validar las condiciones de uso
    Given ingreso al modulo acerca de
    When ingresar a opcion condiciones
    Then validar opcion condiciones   
#passed
  @CP0110M 
  Scenario: CP0110M_SYS_Validar la opción de atención en línea
    Given ingreso a la opcion ayuda en linea
    Then validar opcion ayuda en linea
