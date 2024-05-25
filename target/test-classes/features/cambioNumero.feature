#Author: Carlos Sarmiento
Feature: casos de cambio numero

  @CP03040M @cambioNumero1
  Scenario Outline: CP03040M_SYS_validar proceso de cambio de numero para tipo documental CE y no deje realizar el proceso desde Zona Privada
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And ingresar a opcion Cambiar Numero privado
    And validar pop up asesoria en linea

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CE"   | "65753445" | "1234"     |

  @CP03050M @cambioNumero1
  Scenario Outline: CP03050M_SYS_validar proceso de cambio de numero para tipo documental TI y no deje realizar el proceso desde Zona Privada
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And ingresar a opcion Cambiar Numero privado
    And validar pop up asesoria en linea

    Examples: 
      | tipoId | usuario        | contrasena |
      | "TI"   | "112202296874" | "1234"     |

  @CP03060M @cambioNumero1
  Scenario Outline: CP03060M_SYS_validar proceso de cambio de numero para tipo documental PEP y no deje realizar el proceso desde Zona Privada
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And ingresar a opcion Cambiar Numero privado
    And validar pop up asesoria en linea

    Examples: 
      | tipoId | usuario           | contrasena |
      | "CE"   | "106470359955431" | "1234"     |

  @CP03090M @cambio345
  Scenario Outline: CP03090M_SYS_validar proceso de cambio de numero para tipo documental CE y no deje realizar el proceso desde Zona Pública
    Given ingresar a app sin credenciales
    And ingresar a opcion cambiar numero zona publica
    When ingreso documento  <tipoId> <usuario>
    Then validar pop up asesoria en linea

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CE"   | "10011499" | "2580"     |

  @CP03100M  @cambio345
  Scenario Outline: CP03100M_SYS_Validar proceso de cambio de número para tipo documental TI y no deje realizar el proceso desde Zona Pública
    Given ingresar a app sin credenciales
    And ingresar a opcion cambiar numero zona publica
    When ingreso documento  <tipoId> <usuario>
    Then validar pop up asesoria en linea

    Examples: 
      | tipoId | usuario        | contrasena |
      | "TI"   | "112202296874" | "1234"     |

  @CP03110M 
  Scenario Outline: CP03110M_SYS_Validar proceso de cambio de número para tipo documental PEP y no deje realizar el proceso desde Zona Pública
    And ingresar a app sin credenciales
    And ingresar a opcion cambiar numero zona publica
    And ingreso documento  <tipoId> <usuario>
    And validar pop up asesoria en linea

    Examples: 
      | tipoId | usuario           | contrasena |
      | "CE"   | "106470359955431" | "1234"     |

  

  @CP03130M 
  Scenario Outline: CP03130M_SYS_Validar proceso de cambio de número que muestre mensaje de Atención eliminar bolsillos desde menú hamburguesa
    Given obtener numero celular actual en redeban <usuario>
    And logout redeban al finalizar consulta numero celular
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingresar a opcion Cambiar Numero privado
    And validar pop up atencion

    Examples: 
      | tipoId | usuario   | contrasena |
      | "CC"   | "1007713" | "1234"     |

  @CP03140M  
  Scenario Outline: CP03140M_SYS_Validar proceso de cambio de número desde mensaje Atencion haciendo tap en botón Cancelar desde menú hamburguesa
    Given obtener numero celular actual en redeban <usuario>
    And logout redeban al finalizar consulta numero celular
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingresar a opcion Cambiar Numero privado
    And validar y dar tap en boton Cancelar

    Examples: 
      | tipoId | usuario   | contrasena |
      | "CC"   | "1007713" | "1234"     |

  @CP03150M 
  Scenario Outline: CP03150M_SYS_Validar proceso de cambio de número desde mensaje Atencion haciendo tap en botón Aceptar desde menú hamburguesa
    Given obtener numero celular actual en redeban <usuario>
    And logout redeban al finalizar consulta numero celular
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingresar a opcion Cambiar Numero privado
    And validar y dar tap en boton Aceptar

    Examples: 
      | tipoId | usuario   | contrasena |
      | "CC"   | "1007713" | "1234"     |
      
      
      
