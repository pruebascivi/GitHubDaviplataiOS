package daviplata.nacional.iOS.steps;

import static org.junit.Assert.fail;
import daviplata.nacional.iOS.pageObjects.AcercaDeDaviplataPage;
import daviplata.nacional.iOS.pageObjects.BolsilloPageObjects;
import daviplata.nacional.iOS.pageObjects.EcardPageObject;
import daviplata.nacional.iOS.pageObjects.HomePageObjects;
import daviplata.nacional.iOS.pageObjects.LoginPageObjects;
import daviplata.nacional.iOS.pageObjects.LoginRobustoPage;
import daviplata.nacional.iOS.pageObjects.MarketPlacePageObjects;
import daviplata.nacional.iOS.pageObjects.PasarPlataPageObjects;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import daviplata.nacional.iOS.utilidades.Utilidades;
import daviplata.nacional.iOS.utilidades.UtilidadesTCS;
import net.thucydides.core.annotations.Step;

public class LoginRobustoSteps {
	
	UtilidadesTCS utilidadesTCS;
	LoginRobustoPage loginRobustoPage;
	AcercaDeDaviplataPage acercaDeDaviplataPage;
	Utilidades utilidades;
	LoginPageObjects pageLogin;
	BolsilloPageObjects bolsillosPageObjects;
	PasarPlataPageObjects pasarPlataPageObjects;
	MarketPlacePageObjects marketPlacePageObjects;
	HomePageObjects homePageObjects;
	
	@Step
	public void ingresoAlAplicativo() {
		try {
			
			System.out.println("Ingresando al aplicativo");
			utilidadesTCS.validateElementVisibility("name","Ingrese a su Daviplata");
			Utilidades.tomaEvidencia("Ingreso al aplicativo");
			
		} catch(Exception e) {
			
			System.out.println("No se pudo interactuar con el elemento debido a: " + e.getMessage().toString());
			assert utilidadesTCS.validateElementVisibilityCatch("name","Ingrese a su Daviplata") : "No se pudo interactuar con el elemento.";
		}
	}

	@Step
	public void verificarVersion() {
		
		utilidadesTCS.clicElement("xpath", LoginRobustoPage.MENU_TRES_PUNTOS);
		Utilidades.esperaMiliseg(800);
		utilidadesTCS.clicElement("xpath", LoginRobustoPage.MENU_TRES_PUNTOS);

		try {
			
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.MENU_TRES_PUNTOS);
			Utilidades.tomaEvidencia("Menu tres puntos");
		} catch(Exception e) {
			
			System.out.println("No se pudo interactuar con el elemento debido a: " + e.getMessage().toString());
			assert utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.MENU_TRES_PUNTOS) : "No se pudo interactuar con el elemento." + LoginRobustoPage.MENU_TRES_PUNTOS;
		}
		try {
			
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.ACERCA_DE_DAVIPLATA);
			Utilidades.esperaMiliseg(1500);
			String version = utilidadesTCS.obtenerTexto("xpath", AcercaDeDaviplataPage.VERSION);
			Utilidades.tomaEvidencia("Ingreso al módulo 'Acerca de Daviplata' y capturo la versión: " + version );
			System.out.println("La versión es: " + version);
			
		} catch(Exception e) {
			System.out.println("No se pudo interactuar con el elemento debido a: " + e.getMessage().toString());
			assert utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.ACERCA_DE_DAVIPLATA) : "No se pudo interactuar con el elemento." + LoginRobustoPage.ACERCA_DE_DAVIPLATA;
		}
		try {
			
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.REGRESAR);
			utilidadesTCS.validateElementVisibility("name","Ingrese a su Daviplata");
			
		} catch(Exception e) {
			System.out.println("No se pudo interactuar con el elemento debido a: " + e.getMessage().toString());
			assert utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.REGRESAR) : "No se pudo interactuar con el elemento." + LoginRobustoPage.REGRESAR;
		}	
	}
	
	@Step
	public void validarOpcCambiarNum() {
		try {
			
			utilidadesTCS.esperarElementVisibility("xpath", LoginRobustoPage.MENU_TRES_PUNTOS);
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.MENU_TRES_PUNTOS);
			Utilidades.esperaMiliseg(500);
			
		} catch(Exception e) {
			System.out.println("No se pudo interactuar con el elemento debido a: " + e.getMessage().toString());
			assert utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.MENU_TRES_PUNTOS) : "No se pudo interactuar con el elemento." + LoginRobustoPage.MENU_TRES_PUNTOS;
		}	
		try {
			
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.CAMBIAR_MI_NUMERO_BTN);
			Utilidades.esperaMiliseg(1500);
			
		} catch(Exception e) {
			System.out.println("No se pudo interactuar con el elemento debido a: " + e.getMessage().toString());
			assert utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.CAMBIAR_MI_NUMERO_BTN) : "No se pudo interactuar con el elemento." + LoginRobustoPage.CAMBIAR_MI_NUMERO_BTN;
		}	
		try {
			
			utilidadesTCS.esperarElementVisibility("xpath", LoginRobustoPage.CAMBIO_NUMERO_MODULO);
			Utilidades.tomaEvidencia("Valido el módulo 'Cambio de número'");
			Utilidades.esperaMiliseg(500);
			
		} catch(Exception e) {
			System.out.println("No se pudo interactuar con el elemento debido a: " + e.getMessage().toString());
			assert utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.CAMBIO_NUMERO_MODULO) : "No se pudo interactuar con el elemento." + LoginRobustoPage.CAMBIO_NUMERO_MODULO;
		}		
		try {
			
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.REGRESAR);
			utilidadesTCS.validateElementVisibility("name","Ingrese a su Daviplata");
			
		} catch(Exception e) {
			System.out.println("No se pudo interactuar con el elemento debido a: " + e.getMessage().toString());
			assert utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.REGRESAR) : "No se pudo interactuar con el elemento." + LoginRobustoPage.REGRESAR;
		}
	}
	
	@Step
	public void validarOpcionDesactivarHuellaFaceID() {
		try {
			
			utilidadesTCS.esperarElementVisibility("xpath", LoginRobustoPage.MENU_TRES_PUNTOS);
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.MENU_TRES_PUNTOS);
			Utilidades.esperaMiliseg(500);
			
		} catch(Exception e) {
			System.out.println("No se pudo interactuar con el elemento debido a: " + e.getMessage().toString());
			assert utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.MENU_TRES_PUNTOS) : "No se pudo interactuar con el elemento." + LoginRobustoPage.MENU_TRES_PUNTOS;
		}
		
		boolean btnDesactivarHuellaFaceID = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.DESACTIVAR_HUELLA_FACEID_BTN);
		if(btnDesactivarHuellaFaceID) {
			try {
				Utilidades.esperaMiliseg(1000);
				utilidadesTCS.clicElement("xpath", LoginRobustoPage.DESACTIVAR_HUELLA_FACEID_BTN);
				Utilidades.esperaMiliseg(500);
				
			} catch(Exception e) {
				System.out.println("No se pudo interactuar con el elemento debido a: " + e.getMessage().toString());
				assert utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.DESACTIVAR_HUELLA_FACEID_BTN) : "No se pudo interactuar con el elemento." + LoginRobustoPage.DONDE_USAR_DAVIPLATA_BTN;
			}
			try {
				
				utilidadesTCS.esperarElementVisibility("xpath", LoginRobustoPage.DESACTIVAR_HUELLA_FACEID_POPUP);
				Utilidades.tomaEvidencia("Valido el Popup '¿Está seguro que desea deshabilitar el ingreso a DaviPlata con Huella?'");
				Utilidades.esperaMiliseg(500);
				
			} catch(Exception e) {
				System.out.println("No se pudo interactuar con el elemento debido a: " + e.getMessage().toString());
				assert utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.DESACTIVAR_HUELLA_FACEID_POPUP) : "No se pudo interactuar con el elemento." + LoginRobustoPage.DESACTIVAR_HUELLA_FACEID_POPUP;
			}
			try {
				
				utilidadesTCS.clicElement("xpath", LoginRobustoPage.CANCELAR_POPUP_DESACTIVAR_HUELLA);
				Utilidades.tomaEvidencia("Valido que al cancelar el Popup me regresa al login");
				utilidadesTCS.validateElementVisibility("name","Ingrese a su Daviplata");
				
			} catch(Exception e) {
				System.out.println("No se pudo interactuar con el elemento debido a: " + e.getMessage().toString());
				assert utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.CANCELAR_POPUP_DESACTIVAR_HUELLA) : "No se pudo interactuar con el elemento." + LoginRobustoPage.CANCELAR_POPUP_DESACTIVAR_HUELLA;
			}
			try {
				
				utilidadesTCS.esperarElementVisibility("xpath", LoginRobustoPage.MENU_TRES_PUNTOS);
				utilidadesTCS.clicElement("xpath", LoginRobustoPage.MENU_TRES_PUNTOS);
				Utilidades.esperaMiliseg(500);
				
			} catch(Exception e) {
				System.out.println("No se pudo interactuar con el elemento debido a: " + e.getMessage().toString());
				assert utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.MENU_TRES_PUNTOS) : "No se pudo interactuar con el elemento." + LoginRobustoPage.MENU_TRES_PUNTOS;
			}	
			try {
				
				utilidadesTCS.clicElement("xpath", LoginRobustoPage.DESACTIVAR_HUELLA_FACEID_BTN);
				Utilidades.esperaMiliseg(800);
				
			} catch(Exception e) {
				System.out.println("No se pudo interactuar con el elemento debido a: " + e.getMessage().toString());
				assert utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.DESACTIVAR_HUELLA_FACEID_BTN) : "No se pudo interactuar con el elemento." + LoginRobustoPage.DESACTIVAR_HUELLA_FACEID_BTN;
			}
			try {
				
				utilidadesTCS.clicElement("xpath", LoginRobustoPage.DESACTIVAR_HUELLA_FACEID_POPUP);
				Utilidades.esperaMiliseg(1500);
				
			} catch(Exception e) {
				System.out.println("No se pudo interactuar con el elemento debido a: " + e.getMessage().toString());
				assert utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.DESACTIVAR_HUELLA_FACEID_POPUP) : "No se pudo interactuar con el elemento." + LoginRobustoPage.DESACTIVAR_HUELLA_FACEID_POPUP;
			}
			try {
				
				utilidadesTCS.clicElement("xpath", LoginRobustoPage.DESHABILITAR_POPUP_DESACTIVAR_HUELLA);
				Utilidades.esperaMiliseg(1000);
				utilidadesTCS.esperarElementVisibility("xpath", LoginRobustoPage.POPUP_CONFIRMACIÓN_HUELLA_FACEID_DESHABILITADA);
				Utilidades.esperaMiliseg(1000);
				Utilidades.tomaEvidencia("Valido que al deshabilitar la opcion de ingreso con huella y FaceID sale el mensaje: 'Listo! El ingreso a Daviplata con huella fue deshabilitado'");
				utilidadesTCS.clicElement("xpath", LoginRobustoPage.POPUP_CONFIRMACIÓN_HUELLA_FACEID_DESHABILITADA);
				Utilidades.esperaMiliseg(500);
				
			} catch(Exception e) {
				System.out.println("No se pudo interactuar con el elemento debido a: " + e.getMessage().toString());
				assert utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.DESHABILITAR_POPUP_DESACTIVAR_HUELLA) : "No se pudo interactuar con el elemento." + LoginRobustoPage.DESHABILITAR_POPUP_DESACTIVAR_HUELLA;
			}
		} else {
			System.out.println("No se encuentra presente la opción 'Desactivar Huella/Face ID'");
			try {
				
				Utilidades.esperaMiliseg(500);
	        	utilidadesTCS.clickCoordinates(151,151);
				Utilidades.esperaMiliseg(500);
				
			} catch(Exception e) {
				System.out.println("No se pudo interactuar con el elemento debido a: " + e.getMessage().toString());
				assert utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.MENU_TRES_PUNTOS) : "No se pudo interactuar con el elemento." + LoginRobustoPage.MENU_TRES_PUNTOS;
			}
		}
	}
	
	@Step
	public void verificarOpcDondeUsarDaviPlata() {
		try {
			
			utilidadesTCS.esperarElementVisibility("xpath", LoginRobustoPage.MENU_TRES_PUNTOS);
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.MENU_TRES_PUNTOS);
			Utilidades.esperaMiliseg(500);
			
		} catch(Exception e) {
			System.out.println("No se pudo interactuar con el elemento debido a: " + e.getMessage().toString());
			assert utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.MENU_TRES_PUNTOS) : "No se pudo interactuar con el elemento." + LoginRobustoPage.MENU_TRES_PUNTOS;
		}	
		try {
			
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.DONDE_USAR_DAVIPLATA_BTN);
			utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
			Utilidades.esperaMiliseg(500);
			
		} catch(Exception e) {
			System.out.println("No se pudo interactuar con el elemento debido a: " + e.getMessage().toString());
			assert utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.DONDE_USAR_DAVIPLATA_BTN) : "No se pudo interactuar con el elemento." + LoginRobustoPage.DONDE_USAR_DAVIPLATA_BTN;
		}
		try {
			
			utilidadesTCS.esperarElementVisibility("xpath", LoginRobustoPage.DONDE_USAR_DAVIPLATA_MODULO);
			Utilidades.tomaEvidencia("Valido el módulo '¿Dónde usar su DaviPlata?'");
			Utilidades.esperaMiliseg(500);
			
		} catch(Exception e) {
			System.out.println("No se pudo interactuar con el elemento debido a: " + e.getMessage().toString());
			assert utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.DONDE_USAR_DAVIPLATA_MODULO) : "No se pudo interactuar con el elemento." + LoginRobustoPage.DONDE_USAR_DAVIPLATA_MODULO;
		}
		try {
			
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.REGRESAR);
			utilidadesTCS.validateElementVisibility("name","Ingrese a su Daviplata");
			
		} catch(Exception e) {
			System.out.println("No se pudo interactuar con el elemento"+ LoginRobustoPage.REGRESAR + "debido a: " + e.getMessage().toString());
			assert utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.REGRESAR) : "No se pudo interactuar con el elemento." + LoginRobustoPage.REGRESAR;
		}
	}

	@Step
	public void ingresarCredenciales(String tipoID, String id, String passwd) {
		
		try {
			
			utilidadesTCS.clicElement("name","Lista Desplegable");
			utilidadesTCS.clicElement("name", tipoID);
			utilidadesTCS.clicElement("name","Ingrese su número de documento");
			utilidadesTCS.writeElement("name","Ingrese su número de documento", id);
			
		} catch(Exception e) {
			fail("No se pudo interactuar con el elemento debido a: " + e.getMessage());
		}
		try {
			
			Utilidades.tomaEvidencia("Ingreso tipo y número de documento");
			utilidadesTCS.clicElement("name", "Ingresar");
			Utilidades.esperaMiliseg(500);
			boolean popUpParaIngresar = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.POPUP_PARA_INGRESAR);

			if(popUpParaIngresar) {
				String textPopUp = utilidadesTCS.obtenerTexto("xpath", LoginRobustoPage.POPUP_PARA_INGRESAR);
				Utilidades.tomaEvidencia("Acepto Popup: " + textPopUp);
				utilidadesTCS.clicElement("xpath", LoginRobustoPage.PARA_INGRESAR_BTN);
			}

		} catch(Exception e) {
			fail("No se pudo interactuar con el elemento debido a: " + e.getMessage());
		}
		
		boolean popUpReglamento = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.POP_UP_REGLAMENTO_CAMBIO_DISPOSITIVO);
		if(popUpReglamento) {
			
			Utilidades.esperaMiliseg(800);
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.POP_UP_REGLAMENTO_CAMBIO_DISPOSITIVO);
		} else {
			System.out.println("No está presente el Popup de reglamento por cambio de dispositivo.");
		}
		boolean pantallaEscribeCorreo = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.TXT_ESCRIBE_CORREO_Y_CLAVE);
		if(pantallaEscribeCorreo) {
			
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.writeElement("xpath", LoginRobustoPage.INPUT_CORREO_ELECTRONICO, "XXX@gmail.com");
			utilidadesTCS.writeElement("xpath", LoginRobustoPage.INPUT_CLAVE_DAVIPLATA, passwd);
			Utilidades.esperaMiliseg(1000);
			Utilidades.tomaEvidencia("Ingreso correo y contraseña");
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.CONTINUAR_POP_UP_CAMBIAR_DISPOSITIVO);
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.CONTINUAR_POP_UP_CAMBIAR_DISPOSITIVO);
			performanceValidatePass(passwd);
			Utilidades.esperaMiliseg(500);
			pageLogin.darClicBotonIngresar();
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.esperarElementVisibility("xpath", LoginRobustoPage.POP_UP_OTP);
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.POP_UP_OTP);
			Utilidades.esperaMiliseg(2000);
			
			boolean visibilidadTeclado = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.TXT_CODIGO_6_DIGITOS);
			if(visibilidadTeclado == true) {
				
				utilidadesTCS.clicElement("xpath", LoginRobustoPage.TXT_CODIGO_6_DIGITOS);
				Utilidades.esperaMiliseg(1500);
				performanceClickCoordates();

			} else {
				performanceClickCoordates();
			}
			Utilidades.esperaMiliseg(2000);
			Utilidades.tomaEvidencia("Ingreso el código de autorización");
			utilidadesTCS.validateElementVisibility("xpath", LoginRobustoPage.BOTON_ACEPTAR_TECLADO_IOS);
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_ACEPTAR_TECLADO_IOS);
			
		} else {
			Utilidades.esperaMiliseg(800);
			pageLogin.ingresarContrasena(passwd);
			Utilidades.esperaMiliseg(1000);
			Utilidades.tomaEvidencia("Ingreso contraseña");
			pageLogin.darClicBotonIngresar();
			Utilidades.esperaMiliseg(500);
			pageLogin.darClicBotonIngresar();
			performanceValidatePass(passwd);
			Utilidades.esperaMiliseg(500);
			pageLogin.darClicBotonIngresar();
			
		}
	}
	
	@Step
	public void verificarHome() {
		
		boolean estadoVisiblePopUpAmigos = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.POP_UP_INVITE_AMIGOS);
		boolean estadoVisibleSlideInformativo = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.SLIDE_INFORMATIVO_DAVIPLATA);
		try {
			if(estadoVisiblePopUpAmigos == true || estadoVisibleSlideInformativo ==true) {
				
				Utilidades.esperaMiliseg(1000);
				boolean estadoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.POP_UP_INVITE_AMIGOS);
				if(estadoVisible == true) {
					utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_CLOSE);
				}
//				utilidadesTCS.esperarElementVisibility("xpath", LoginRobustoPage.SLIDE_INFORMATIVO_DAVIPLATA);
//				utilidadesTCS.clicElement("xpath", LoginRobustoPage.CONTINUAR_POP_UP_CAMBIAR_DISPOSITIVO);
			}
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.esperarElementVisibility("xpath", LoginRobustoPage.BOTON_BOLSILLOS);
			Utilidades.tomaEvidencia("Verifico que me encuentro en el inicio de la App.");

		} catch (Exception e) {
			fail("No se pudo realizar acción de digitar código de autorización debido a: " + e.getMessage());
		}
	}
	
	
	@Step
	public void regresarAlHomeDesdeBolsillos() {
        utilidadesTCS.clicElement("xpath", BolsilloPageObjects.BOTON_SACAR_PLATA);
		Utilidades.esperaMiliseg(2000);
        utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.BOTON_ATRAS_BOLSILLOS);
		Utilidades.esperaMiliseg(2000);
        utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.BOTON_ATRAS_BOLSILLOS);
		boolean estadoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.POP_UP_INVITE_AMIGOS);
		if(estadoVisible == true) {
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_CLOSE);
		}
    }
	
	@Step
	public void regresarAlHomeDesdeTarjetaVirtual() {
    	Utilidades.esperaMiliseg(2000);
		utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.BOTON_ATRAS_BOLSILLOS);
		boolean estadoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.POP_UP_INVITE_AMIGOS);
		if(estadoVisible == true) {
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_CLOSE);
		}
    }
	
	@Step
	public void scrollHorizontalFinalBarraProductos() {
		utilidadesTCS.scrollBackground("xpath", HomePageObjects.BOTON_TARJETA_VIRTUAL, -450, 0);
		utilidadesTCS.scrollBackground("xpath", EcardPageObject.BOTON_TIENDA_VIRTUAL, -200, 0);
    }
	
	@Step
	public void validarCajonDeMasProductos() {
        boolean estado = utilidadesTCS.validateElementVisibility("xpath", HomePageObjects.BOTON_MAS_PRODUCTOS);
        utilidadesTCS.validateStatusElement(estado);
        Utilidades.tomaEvidencia("Validar boton de 'Mas productos");
    }
	
	@Step
	public void ingresarModuloMasProductos() {
		Utilidades.esperaMiliseg(2000);
		utilidadesTCS.clicElement("xpath", HomePageObjects.BOTON_MAS_PRODUCTOS);
    }
	
	@Step
	public void validarModuloDeMisProductos() {
        boolean estado = utilidadesTCS.validateElementVisibility("xpath", HomePageObjects.TEXTO_MIS_PRODUCTOS);
        utilidadesTCS.validateStatusElement(estado);
        Utilidades.tomaEvidencia("Validar modulo de mis productos");        
    }
	
	@Step
	public void scrollHorizontalEnBarraProductos() {
		Utilidades.esperaMiliseg(1500);
		utilidadesTCS.scrollBackground("xpath", HomePageObjects.BOTON_TARJETA_VIRTUAL, -450, 0);
    }
	
	@Step
	public void ingresarAModuloBolsillos() {
		Utilidades.tomaEvidencia("Hacer clic en cajon bolsillo");
		utilidadesTCS.clicElement("xpath", BolsilloPageObjects.BOTON_BOLSILLOS_HOME);
		utilidadesTCS.esperarElementVisibility("xpath", HomePageObjects.TEXTO_BOLSILLO_MODULO);
        Utilidades.tomaEvidencia("Ingreso al modulo de bolsillos");
    }
	
	/**
	* Método: PERFORMANCE PARA DAR CLIC POR COORDENADAS SEGÚN VERSIÓN DEL DISPOSITIVO
	*/
	public void performanceClickCoordates() {
		System.out.println(BaseUtil.nombreDispositivo);
		try {
			switch (BaseUtil.nombreDispositivo) {
	        case "iPhone 14":
    			/** CLIC POR COORDENADAS A CAMPO 'CÓDIGO DE 6 DÍGITOS' **/
	        	utilidadesTCS.clickCoordinates(221,435);
				utilidadesTCS.escribirPorTecladoIos("230116");
	            break;
	        case "iPhone 12":
    			/** CLIC POR COORDENADAS A CAMPO 'CÓDIGO DE 6 DÍGITOS' **/
	        	utilidadesTCS.clickCoordinates(221,455);
				utilidadesTCS.escribirPorTecladoIos("230116");
	            break;
	        default:
	            throw new IllegalArgumentException("Tipo de dispositivo no apto.");
			}
		} catch(Exception e) {
			fail("No se pudo realizar acción de digitar código de autorización debido a: " + e.getMessage());
		}
	}
	
	/**
	* Método: PERFORMANCE PARA VALIDAR CONTRASEÑAS ERRÓNEAS
	* 
	* @param contrasenia Variable cuyo valor es la contraseña o clave para el ingreso.  
	*/
	public void performanceValidatePass(String contrasenia) {
		System.out.println("La contraseña ingresada es: " + contrasenia);
		try {
			
			boolean validationPass = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.POPUP_CLAVE_INCORRECTA);
			if(validationPass == true) {
				
				Utilidades.tomaEvidencia("Se ingresa una contraseña incorrecta.");
				assert utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.POPUP_CLAVE_INCORRECTA) : "Se ingresa una contraseña incorrecta.";
			}
			
			System.out.println("La contraseña ingresada es correcta.");
		} catch (Exception e) {
			fail("No se pudo realizar acciones debido a: " + e.getMessage());
		}
	}
	
	/**
	* Método: PERFORMANCE PARA DAR CLIC POR COORDENADAS SEGÚN VERSIÓN DEL DISPOSITIVO
	*/
	public void validateProducts() {
		System.out.println(BaseUtil.nombreDispositivo);
		try {
			

		} catch(Exception e) {
			fail("No se pudo realizar acción de digitar código de autorización debido a: " + e.getMessage());
		}
	}
}
