package daviplata.nacional.iOS.steps;

import static org.junit.Assert.fail;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.WebDriverWait;
import daviplata.nacional.iOS.pageObjects.AumentoDeTopesPageObjects;
import daviplata.nacional.iOS.pageObjects.LoginPageObjects;
import daviplata.nacional.iOS.pageObjects.LoginRobustoPage;
import daviplata.nacional.iOS.pageObjects.WebCheckOutPageObjects;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import daviplata.nacional.iOS.utilidades.CustomChromeDriver;
import daviplata.nacional.iOS.utilidades.Utilidades;
import daviplata.nacional.iOS.utilidades.UtilidadesTCS;
import net.thucydides.core.annotations.Step;

public class WebCheckOutSteps {
	
	UtilidadesTCS utilidadesTcs;
	Utilidades utilidad;
    AumentoDeTopesPageObjects pageAumentoDeTopes;
    BaseUtil base;
    WebCheckOutPageObjects webCheckOutPageObjects;
    LoginPageObjects loginPageObject;
    CustomChromeDriver confiChromeDriver;
    WebDriverWait wait;

    @Step
    public void seleccionoElBotonDePago() {
    	try {
    		utilidadesTcs.esperarElementVisibility("xpath", WebCheckOutPageObjects.TEXTO_CUANTO_TENGO);
            Utilidades.esperaMiliseg(1500);
            Utilidades.tomaEvidencia("Valido que me encuentro en el perfil 'Mi Negocio'");
    	} catch(Exception e) {
    		System.out.println("No se pudo interactuar con el elemnto: " + WebCheckOutPageObjects.TEXTO_CUANTO_TENGO);
			fail("No se pudo interactuar con elemento debido a: " + e.getMessage() + WebCheckOutPageObjects.TEXTO_CUANTO_TENGO);
    	}
        try {
            Utilidades.esperaMiliseg(5000);
        	utilidadesTcs.esperarElementVisibility("xpath", WebCheckOutPageObjects.ELEMENTO_VISIBLE_BOTON_PAGO);
            utilidadesTcs.clicElement("xpath", WebCheckOutPageObjects.ELEMENTO_VISIBLE_BOTON_PAGO);
    	} catch(Exception e) {
    		System.out.println("No se pudo interactuar con el elemnto: " + WebCheckOutPageObjects.ELEMENTO_VISIBLE_BOTON_PAGO);
			fail("No se pudo interactuar con elemento debido a: " + e.getMessage() + WebCheckOutPageObjects.ELEMENTO_VISIBLE_BOTON_PAGO);
    	}
        try {
            Utilidades.esperaMiliseg(5000);
        	utilidadesTcs.esperarElementVisibility("xpath", WebCheckOutPageObjects.TXT_MODULE_BOTON_PAGO);
        	System.out.println("Ingreso al módulo botón de pago");
    	} catch(Exception e) {
    		System.out.println("No se pudo interactuar con el elemnto: " + WebCheckOutPageObjects.TXT_MODULE_BOTON_PAGO);
			fail("No se pudo interactuar con elemento debido a: " + e.getMessage() + WebCheckOutPageObjects.TXT_MODULE_BOTON_PAGO);
    	}
    }
    
    @Step
    public void ValidoElVideoPresenteBotonPago () {
        boolean visibilidadPantalla = utilidadesTcs.validateElementVisibilityCatch("xpath", WebCheckOutPageObjects.TXT_GENERACION_EXITOSA);
        
        /** Bloque IF: dado sea visible el video guía!**/
        if(visibilidadPantalla == true) {
            Utilidades.esperaMiliseg(500);
            System.out.println("Valido generación exitosa de botón de pago");
            try {
            	utilidadesTcs.esperarElementVisibility("xpath", WebCheckOutPageObjects.TXT_GENERACION_EXITOSA);
                Utilidades.tomaEvidencia("Valido generación exitosa de botón de pago");
            } catch(Exception e) {
    	        System.out.println("No se pudo interactuar con el elemnto: " + WebCheckOutPageObjects.TXT_GENERACION_EXITOSA);
    			fail("No se pudo interactuar con elemento debido a: " + e.getMessage() + WebCheckOutPageObjects.TXT_GENERACION_EXITOSA);
            }
            try {
            	utilidadesTcs.clicElement("xpath", WebCheckOutPageObjects.BOTON_FINALIZAR);
            } catch(Exception e) {
    	        System.out.println("No se pudo interactuar con el elemnto: " + WebCheckOutPageObjects.BOTON_FINALIZAR);
    			fail("No se pudo interactuar con elemento debido a: " + e.getMessage() + WebCheckOutPageObjects.BOTON_FINALIZAR);
            }

        /** Bloque ELSE: dado no sea visible el video guía!**/
        } else {
            System.out.println("Está presente la opción de reproducción del video gúia. Se ejecuta bloque ELSE.");
            Utilidades.tomaEvidencia("Realizo clic en el video guía");
            Utilidades.esperaMiliseg(500);
            try {
                utilidadesTcs.esperarElementVisibility("xpath", WebCheckOutPageObjects.BTN_GENERAR_BTN_PAGO);
            } catch(Exception e) {
    	        System.out.println("No se pudo interactuar con el elemnto: " + WebCheckOutPageObjects.BTN_GENERAR_BTN_PAGO);
    			fail("No se pudo interactuar con elemento debido a: " + e.getMessage() + WebCheckOutPageObjects.BTN_GENERAR_BTN_PAGO);
            }
            try {
            	utilidadesTcs.clicElement("xpath", WebCheckOutPageObjects.INTERACCION_VIDEO);
                Utilidades.esperaMiliseg(1500);
                Utilidades.tomaEvidencia("Reproducir video");
                utilidadesTcs.clickCoordinates(210, 750);
                utilidadesTcs.clicElement("xpath", WebCheckOutPageObjects.INTERACCION_VIDEO);
                utilidadesTcs.scrollBackground("xpath", WebCheckOutPageObjects.INTERACCION_VIDEO, 0, 300);
            } catch(Exception e) {
    	        System.out.println("No se pudo interactuar con el elemnto: " + WebCheckOutPageObjects.INTERACCION_VIDEO);
    			fail("No se pudo interactuar con elemento debido a: " + e.getMessage() + WebCheckOutPageObjects.INTERACCION_VIDEO);
            }
        }
    }
    
    @Step
    public void ValidarTextosDefinidos () {
        boolean visibilidadMensaje = utilidadesTcs.validateElementVisibilityCatch("xpath", WebCheckOutPageObjects.MENSAJE_DEFINIDO);
        	
        /** Bloque IF: dado sea visible el texto!**/
        if(visibilidadMensaje == true) {
        	try {
        		utilidadesTcs.esperarElementVisibility("xpath", WebCheckOutPageObjects.MENSAJE_DEFINIDO);
                String mensaje = utilidadesTcs.obtenerTexto("xpath",WebCheckOutPageObjects.MENSAJE_DEFINIDO);
                utilidadesTcs.validateTextContainsStringIgnoreUppercaseLowercase(mensaje, "De esta forma podrán pagarle por sus ventas usando DaviPlata con un solo clic");
                Utilidades.tomaEvidencia("Valido el texto del módulo botón de pago");
        	} catch(Exception e) {
    	        System.out.println("No se pudo interactuar con el elemnto: " + WebCheckOutPageObjects.MENSAJE_DEFINIDO);
    			fail("No se pudo interactuar con elemento debido a: " + e.getMessage() + WebCheckOutPageObjects.MENSAJE_DEFINIDO);
        	}
        }
    }
    
    @Step
    public void DarClicAtrasBotonDePago () {
        boolean visibilidadMensaje = utilidadesTcs.validateElementVisibilityCatch("xpath", WebCheckOutPageObjects.MENSAJE_DEFINIDO);
    	
        /** Bloque IF: dado sea visible el texto!**/
        if(visibilidadMensaje == true) {
        	try {
                System.out.println("Clic en el botón Atrás");
                utilidadesTcs.clicElement("xpath", WebCheckOutPageObjects.BOTON_ATRAS);
        		Utilidades.tomaEvidencia("Realizo clic en el botón Atrás");
        	} catch (Exception e) {
        		System.out.println("No se pudo interactuar con el elemnto: " + WebCheckOutPageObjects.BOTON_ATRAS);
    			fail("No se pudo interactuar con elemento debido a: " + e.getMessage() + WebCheckOutPageObjects.BOTON_ATRAS);
        	}
        	try {
        		utilidadesTcs.esperarElementVisibility("xpath", WebCheckOutPageObjects.TEXTO_CUANTO_TENGO);
                Utilidades.esperaMiliseg(2500);
                Utilidades.tomaEvidencia("Home perfil 'Mi Negocio'");
        	} catch (Exception e) {
        		System.out.println("No se pudo interactuar con el elemnto: " + WebCheckOutPageObjects.TEXTO_CUANTO_TENGO);
    			fail("No se pudo interactuar con elemento debido a: " + e.getMessage() + WebCheckOutPageObjects.TEXTO_CUANTO_TENGO);
        	}
        }
    }
    
    @Step
    public void ClicEnLaEquisValidoDevolvermeAlHome () {
		utilidadesTcs.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
    	try {
    		Utilidades.esperaMiliseg(2500);
            utilidadesTcs.esperarElementVisibility("xpath", WebCheckOutPageObjects.ELEMENTO_VISIBLE_BOTON_PAGO);
            utilidadesTcs.clicElement("xpath", WebCheckOutPageObjects.ELEMENTO_VISIBLE_BOTON_PAGO);
    	} catch(Exception e) {
    		System.out.println("No se pudo interactuar con el elemnto: " + WebCheckOutPageObjects.ELEMENTO_VISIBLE_BOTON_PAGO);
			fail("No se pudo interactuar con elemento debido a: " + e.getMessage() + WebCheckOutPageObjects.ELEMENTO_VISIBLE_BOTON_PAGO);
    	}
        try {
        	utilidadesTcs.esperarElementVisibility("xpath", WebCheckOutPageObjects.TXT_MODULE_BOTON_PAGO);
        	System.out.println("Ingreso al módulo botón de pago y valido presencia del boton 'equis'");
            Utilidades.tomaEvidencia("Ingreso al módulo botón de pago y valido presencia del boton 'equis'");
            Utilidades.esperaMiliseg(1500);
            utilidadesTcs.esperarElementVisibility("xpath", WebCheckOutPageObjects.BOTON_EQUIS);
            utilidadesTcs.clicElement("xpath", WebCheckOutPageObjects.BOTON_EQUIS);
    	} catch(Exception e) {
    		System.out.println("No se pudo interactuar con el elemnto: " + WebCheckOutPageObjects.BOTON_EQUIS);
			fail("No se pudo interactuar con elemento debido a: " + e.getMessage() + WebCheckOutPageObjects.BOTON_EQUIS);
    	}
        try {
			utilidadesTcs.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 90);
        	utilidadesTcs.esperarElementVisibility("xpath", WebCheckOutPageObjects.TEXTO_CUANTO_TENGO);
            System.out.println("Valido que al dar clic a la 'equis' me lleve al perfil 'Mi Negocio'");
            Utilidades.tomaEvidencia("Regreso al home de perfil mi Negocio");
    	} catch(Exception e) {
    		System.out.println("No se pudo interactuar con el elemnto: " + WebCheckOutPageObjects.TEXTO_CUANTO_TENGO);
			fail("No se pudo interactuar con elemento debido a: " + e.getMessage() + WebCheckOutPageObjects.TEXTO_CUANTO_TENGO);
    	}
    }

    @Step
    public void DarClicEnGenerarBotonDePago () {
		utilidadesTcs.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
    	try {
    		Utilidades.esperaMiliseg(2500);
            utilidadesTcs.esperarElementVisibility("xpath", WebCheckOutPageObjects.ELEMENTO_VISIBLE_BOTON_PAGO);
            utilidadesTcs.clicElement("xpath", WebCheckOutPageObjects.ELEMENTO_VISIBLE_BOTON_PAGO);
    	} catch(Exception e) {
    		System.out.println("No se pudo interactuar con el elemnto: " + WebCheckOutPageObjects.ELEMENTO_VISIBLE_BOTON_PAGO);
			fail("No se pudo interactuar con elemento debido a: " + e.getMessage() + WebCheckOutPageObjects.ELEMENTO_VISIBLE_BOTON_PAGO);
    	}
	     boolean generacionExitosa =  utilidadesTcs.validateElementVisibilityCatch("xpath", WebCheckOutPageObjects.TXT_GENERACION_EXITOSA);
	     /** Bloque IF: dado sea visible el video guía!**/
	     if(generacionExitosa == true) {
	     	 Utilidades.esperaMiliseg(2500);
	     	 utilidadesTcs.esperarElementVisibility("xpath", WebCheckOutPageObjects.TXT_GENERACION_EXITOSA);
	     	 System.out.println("Valido generación de botón de pago ya realizada");
	         Utilidades.tomaEvidencia("Valido generación de botón de pago ya realizada");
	         Utilidades.esperaMiliseg(800);
	     } else {
	    	 Utilidades.esperaMiliseg(800);
	    	 utilidadesTcs.esperarElementVisibility("xpath", WebCheckOutPageObjects.BTN_GENERAR_BTN_PAGO);
	         utilidadesTcs.clicElement("xpath", WebCheckOutPageObjects.BTN_GENERAR_BTN_PAGO);
	     	 Utilidades.esperaMiliseg(2500);
	
	     	 boolean generacionBotonPago =  utilidadesTcs.validateElementVisibilityCatch("xpath", WebCheckOutPageObjects.TXT_GENERACION_EXITOSA);
	         if(generacionBotonPago == true) {
	         	 utilidadesTcs.esperarElementVisibility("xpath", WebCheckOutPageObjects.TXT_GENERACION_EXITOSA);
	         	 System.out.println("Valido generación de botón de pago exitoso");
	             Utilidades.tomaEvidencia("Valido generación de botón de pago exitoso");
	             Utilidades.esperaMiliseg(800);
	          } else {
	          	  Utilidades.esperaMiliseg(1500);
	          	  Utilidades.tomaEvidencia("No pudimos generar su botón de pago");
	          	  System.out.println("No pudimos generar su botón de pago");
	          	  utilidadesTcs.clickCoordinates(215, 545);
	              Utilidades.esperaMiliseg(2500);
	          }
	     }
    }

    @Step
    public void ValidarUrlBotonDePago () {
    	try {
    		utilidadesTcs.esperarElementVisibility("xpath", WebCheckOutPageObjects.URL_BOTON_PAGO);
            Utilidades.tomaEvidencia("Valido la url botón de pago");
    	} catch (Exception e) {
	         System.out.println("No se pudo interactuar con el elemnto: " + WebCheckOutPageObjects.URL_BOTON_PAGO);
			 fail("No se pudo interactuar con elemento debido a: " + e.getMessage() + WebCheckOutPageObjects.URL_BOTON_PAGO);
    	}
    	try {
    		utilidadesTcs.esperarElementVisibility("xpath", WebCheckOutPageObjects.BOTON_COPIAR_URL);
            Utilidades.tomaEvidencia("Valido el botón copiar");
            utilidadesTcs.clicElement("xpath", WebCheckOutPageObjects.BOTON_COPIAR_URL);
            System.out.println("Realice clic en el botón copiar url");
    	} catch(Exception e) {
	         System.out.println("No se pudo interactuar con el elemnto: " + WebCheckOutPageObjects.BOTON_COPIAR_URL);
			 fail("No se pudo interactuar con elemento debido a: " + e.getMessage() + WebCheckOutPageObjects.BOTON_COPIAR_URL);
    	}
        try {
        	utilidadesTcs.esperarElementVisibility("xpath", WebCheckOutPageObjects.TEXTO_URL_COPIADA);
        	BaseUtil.urlCopy = utilidadesTcs.obtenerTexto("xpath", WebCheckOutPageObjects.TEXTO_URL_COPIADA);
            Utilidades.tomaEvidencia("Valido mensaje 'Enlace copiado'");
            Utilidades.esperaMiliseg(1000);
            Utilidades.tomaEvidencia("Valido que el mensaje 'Enlace copiado' desaparece");
        } catch(Exception e) {
        	System.out.println("No se pudo interactuar con el elemnto: " + WebCheckOutPageObjects.TEXTO_URL_COPIADA);
			fail("No se pudo interactuar con elemento debido a: " + e.getMessage() + WebCheckOutPageObjects.TEXTO_URL_COPIADA);
        }
        try {
            utilidadesTcs.clicElement("xpath", WebCheckOutPageObjects.BOTON_EQUIS);
            System.out.println("Clic en la X");
            Utilidades.tomaEvidencia("Realizo clic en la X");
        } catch(Exception e) {
        	System.out.println("No se pudo interactuar con el elemnto: " + WebCheckOutPageObjects.BOTON_EQUIS);
			fail("No se pudo interactuar con elemento debido a: " + e.getMessage() + WebCheckOutPageObjects.BOTON_EQUIS);
        }
    }
    
    
    @Step
    public void ValidarBotonFinalizar () {
        try {
            Utilidades.esperaMiliseg(1000);
            utilidadesTcs.esperarElementVisibility("xpath", WebCheckOutPageObjects.BOTON_FINALIZAR);
        	utilidadesTcs.clicElement("xpath", WebCheckOutPageObjects.BOTON_FINALIZAR);
        } catch(Exception e) {
	         System.out.println("No se pudo interactuar con el elemnto: " + WebCheckOutPageObjects.BOTON_FINALIZAR);
			 fail("No se pudo interactuar con elemento debido a: " + e.getMessage() + WebCheckOutPageObjects.BOTON_FINALIZAR);
        }
    	try {
    		utilidadesTcs.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
    		utilidadesTcs.esperarElementVisibility("xpath", WebCheckOutPageObjects.TEXTO_CUANTO_TENGO);
            Utilidades.esperaMiliseg(2500);
            System.out.println("Regresando a perfil mi Negocio");
            Utilidades.tomaEvidencia("Regresando a home perfil 'Mi Negocio'");
    	} catch (Exception e) {
    		System.out.println("No se pudo interactuar con el elemnto: " + WebCheckOutPageObjects.TEXTO_CUANTO_TENGO);
			fail("No se pudo interactuar con elemento debido a: " + e.getMessage() + WebCheckOutPageObjects.TEXTO_CUANTO_TENGO);
    	}
    	try {
    		Utilidades.esperaMiliseg(2500);
            utilidadesTcs.esperarElementVisibility("xpath", WebCheckOutPageObjects.ELEMENTO_VISIBLE_BOTON_PAGO);
            utilidadesTcs.clicElement("xpath", WebCheckOutPageObjects.ELEMENTO_VISIBLE_BOTON_PAGO);
    	} catch(Exception e) {
    		System.out.println("No se pudo interactuar con el elemnto: " + WebCheckOutPageObjects.ELEMENTO_VISIBLE_BOTON_PAGO);
			fail("No se pudo interactuar con elemento debido a: " + e.getMessage() + WebCheckOutPageObjects.ELEMENTO_VISIBLE_BOTON_PAGO);
    	}
        Utilidades.esperaMiliseg(1500);
        Utilidades.tomaEvidencia("Ingreso nuevamente al módulo botón de pago");
		utilidadesTcs.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
    	try {
    		Utilidades.esperaMiliseg(2500);
            utilidadesTcs.esperarElementVisibility("xpath", WebCheckOutPageObjects.ELEMENTO_VISIBLE_BOTON_PAGO);
            utilidadesTcs.clicElement("xpath", WebCheckOutPageObjects.ELEMENTO_VISIBLE_BOTON_PAGO);
    	} catch(Exception e) {
    		System.out.println("No se pudo interactuar con el elemnto: " + WebCheckOutPageObjects.ELEMENTO_VISIBLE_BOTON_PAGO);
			fail("No se pudo interactuar con elemento debido a: " + e.getMessage() + WebCheckOutPageObjects.ELEMENTO_VISIBLE_BOTON_PAGO);
    	}
    }
    
    @Step
    public void ValidarPantallaNoPresente () {
        boolean visibilidadPantalla = utilidadesTcs.validateElementVisibilityCatch("xpath", WebCheckOutPageObjects.BTN_GENERAR_BTN_PAGO);
        if(visibilidadPantalla == true) {
        	Utilidades.tomaEvidencia("No se presenta la pantalla 'para que sirve el botón de pago'");
        }
        else {
            System.out.println("Se sigue presentando la pantalla para que sirve el botón de pago");
            utilidadesTcs.clicElement("xpath", WebCheckOutPageObjects.BOTON_EQUIS);
            System.out.println("Clic en la X");
        }
    }
    
    @Step
    public void seleccionoElBotonEnlaceDePago () {
    	try {
    		
    		utilidadesTcs.esperarElementVisibility("xpath", WebCheckOutPageObjects.TEXTO_CUANTO_TENGO);
            Utilidades.esperaMiliseg(3000);
            utilidadesTcs.scrollBackground("xpath", WebCheckOutPageObjects.TEXTO_CUANTO_TENGO, 0, -350);
            Utilidades.esperaMiliseg(3000);
            Utilidades.tomaEvidencia("Botón de Pago");
            utilidadesTcs.esperarElementVisibility("xpath", WebCheckOutPageObjects.ELEMENTOS_PAGO_VENTA);
            Utilidades.tomaEvidencia("Valido el botón enlace de pago");
            utilidadesTcs.clicElement("xpath", WebCheckOutPageObjects.BOTON_ENLACE_DE_PAGO);
            utilidadesTcs.esperarElementVisibility("xpath", WebCheckOutPageObjects.TEXTO_OPCIONES_ENLACE);
            Utilidades.tomaEvidencia("Valido el módulo Enlaces de pago");
            utilidadesTcs.clicElement("xpath", WebCheckOutPageObjects.TAP_OPCION_UNO_ENLACE);
            
	    } catch (Exception e) {
	    	
	        String errorMessage = "Se presentó un error debido a: " + e.getMessage();
	        System.out.println(errorMessage);
	        throw new RuntimeException(errorMessage, e);
	    }
    }
    
    @Step
    public void realizoLaCreacionDelProducto (String nombreProducto, String valorProducto) {
    	
        boolean visibilidadPantalla = utilidadesTcs.validateElementVisibilityCatch("xpath", WebCheckOutPageObjects.NUEVO_ENLACE_BTN);
        if(visibilidadPantalla == true) {
        	Utilidades.tomaEvidencia("Seleccionar opción para generar un nuevo enlace de pago");
            utilidadesTcs.esperarElementVisibility("xpath", WebCheckOutPageObjects.NUEVO_ENLACE_BTN);
            utilidadesTcs.clicElement("xpath", WebCheckOutPageObjects.NUEVO_ENLACE_BTN);
        }
    	utilidadesTcs.esperarElementVisibility("xpath", WebCheckOutPageObjects.TXT_DATOS_VENTA);
        utilidadesTcs.writeElement("xpath", WebCheckOutPageObjects.INPUT_NOMBRE_PRODUCTO, nombreProducto);
        System.out.println("Ingrese el nombre del producto");
        utilidadesTcs.esperarElementVisibility("xpath", WebCheckOutPageObjects.INPUT_VALOR_PRODUCTO);
        utilidadesTcs.writeElement("xpath", WebCheckOutPageObjects.INPUT_VALOR_PRODUCTO, valorProducto);
        System.out.println("Ingrese el valor del producto");
        Utilidades.tomaEvidencia("Valido la información del producto");
        utilidadesTcs.esperarElementVisibility("xpath", WebCheckOutPageObjects.BOTON_CONTINUAR);
        utilidadesTcs.clicElement("xpath", WebCheckOutPageObjects.BOTON_CONTINUAR);
        utilidadesTcs.esperarElementVisibility("xpath", WebCheckOutPageObjects.BOTON_GENERAR_NUEVO_ENLACE);
        Utilidades.tomaEvidencia("Valido el botón enlace de pago");
        utilidadesTcs.clicElement("xpath", WebCheckOutPageObjects.BOTON_GENERAR_NUEVO_ENLACE);
        System.out.println("Realizo clic en el botón Generar el enlace");
        utilidadesTcs.esperarElementVisibility("xpath", WebCheckOutPageObjects.TEXTO_GENERACION_EXITOSA);
        Utilidades.tomaEvidencia("Generación exitosa");
        BaseUtil.urlBotonPago = utilidadesTcs.obtenerTexto("xpath", WebCheckOutPageObjects.RUTA_URL);
        System.out.println(BaseUtil.urlBotonPago);
        utilidadesTcs.clicElement("xpath", WebCheckOutPageObjects.BOTON_FINALIZAR);
    }
    
    @Step
    public void ingresoAWebEnlaceDePago (String numeroDocumento) {
        try{
            utilidadesTcs.setearUrlAProperties("web.enlacePago.url", BaseUtil.urlBotonPago);
            utilidadesTcs.abrirWeb("web.enlacePago.url");
            Utilidades.esperaMiliseg(4000);
            Utilidades.tomaEvidenciaPantalla("Ingreso a la web con la url generada de enlace de pago");
            utilidadesTcs.writeElementWeb("xpath",WebCheckOutPageObjects.INPUT_WEB_NUMERO_DOCUMENTO, numeroDocumento);
            Utilidades.tomaEvidenciaPantalla("Web - Ingreso cédula");
            Utilidades.esperaMiliseg(4000);
            Utilidades.tomaEvidenciaPantalla("Web - Hacer clic en el boton continuar");
            UtilidadesTCS.clicElementWeb("xpath", WebCheckOutPageObjects.BOTON_CONTINUAR_WEB);
        } catch (WebDriverException e) {
            utilidadesTcs.cerrarWebEnlaceDePago();
            fail("Error en WebDriver: " + e.getMessage());
        } catch (Exception e) {
            utilidadesTcs.cerrarWebEnlaceDePago();
            fail("Se produjo un error no esperado: " + e.getMessage());
        }
    }
}
