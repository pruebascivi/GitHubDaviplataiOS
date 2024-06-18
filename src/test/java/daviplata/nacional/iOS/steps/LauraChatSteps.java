package daviplata.nacional.iOS.steps;

import daviplata.nacional.iOS.pageObjects.LauraChatPageObjects;
import daviplata.nacional.iOS.pageObjects.LauraVozPageObjects;
import daviplata.nacional.iOS.pageObjects.LoginRobustoPage;
import daviplata.nacional.iOS.pageObjects.MeterPlataPageObjects;
import daviplata.nacional.iOS.pageObjects.PreguntasFrecuentesPageObjects;
import daviplata.nacional.iOS.utilidades.Utilidades;
import daviplata.nacional.iOS.utilidades.UtilidadesTCS;

public class LauraChatSteps {
    
	Utilidades utilidad;
    UtilidadesTCS utilidadesTcs;
    LauraChatPageObjects lauraVozPageObjects;
    MeterPlataPageObjects meterPlataPageObjects;

    public void ingresarANecesitoAyudaDesdeElHomeDaviplata() {
    	Utilidades.tomaEvidencia("Hacer clic en necesito ayuda");
        utilidadesTcs.clicElement("xpath", LauraChatPageObjects.BOTON_NECESITO_AYUDA_HOME);
    }
    
    public void validarPantallaBienvenida(String tipoDocumento, String numDocumento) {
    	
        boolean elemento = utilidadesTcs.validateElementVisibilityCatch("xpath", LauraChatPageObjects.TXT_INGRESE_SUS_DATOS);
        if(elemento == true) {
    		utilidadesTcs.esperarElementVisibility("xpath", PreguntasFrecuentesPageObjects.BOTON_DESPLEGAR_TIPO_DOCUMENTO);
    		Utilidades.tomaEvidencia("Hago clic en el input seleccionar tipo de documento");
            utilidadesTcs.clicElement("xpath", PreguntasFrecuentesPageObjects.BOTON_DESPLEGAR_TIPO_DOCUMENTO);
            utilidadesTcs.seleccionarTipoDocumentoInput("xpath", tipoDocumento);
            utilidadesTcs.writeElement("xpath", PreguntasFrecuentesPageObjects.INPUT_NUMERO_DOCUMENTO, numDocumento);
        	Utilidades.esperaMiliseg(1000);
            utilidadesTcs.clicElement("xpath", PreguntasFrecuentesPageObjects.BOTON_TERMINOS_CONDICIONES);
        	Utilidades.esperaMiliseg(1000);
            utilidadesTcs.clicElement("xpath", PreguntasFrecuentesPageObjects.BOTON_CONTINUAR);
        }
        utilidadesTcs.esperarElementVisibility("xpath", LauraChatPageObjects.TEXTO_BIENVENIDA_CHAT);
        utilidadesTcs.validateElementVisibility("xpath", LauraChatPageObjects.TEXTO_BIENVENIDA_CHAT);
        Utilidades.tomaEvidencia("Validar pantalla de bienvenida");
    }
    
    public void hacerClicEnLaEquis() {
    	Utilidades.tomaEvidencia("Hacer clic en la equis");
        utilidadesTcs.clicElement("xpath", LauraChatPageObjects.BOTON_EQUIS);
    }
    
    public void validarHomeDaviplataAlDarEnLaEquis() {
        utilidadesTcs.esperarElementVisibility("xpath", LoginRobustoPage.TEXTO_SALDO);
        boolean elemento = utilidadesTcs.validateElementVisibility("xpath", LoginRobustoPage.TEXTO_SALDO);
        utilidadesTcs.validateStatusElement(elemento);
        Utilidades.tomaEvidencia("Validar home despues de dar clic en la equis del chat");
    }
    
    public void hacerClicEnMinimizar() {
        boolean elemento = utilidadesTcs.validateElementVisibilityCatch("xpath", LauraVozPageObjects.ICONO_MINIMIZAR_PANTALLA_LAURA_VOZ);
        if(elemento == true) {
            Utilidades.tomaEvidencia("Valido presencia del botón minimizar");
            utilidadesTcs.clicElement("xpath", LauraVozPageObjects.ICONO_MINIMIZAR_PANTALLA_LAURA_VOZ);
        	Utilidades.esperaMiliseg(1000);

        } else {
            System.out.println("No se encuentra presente el botón minimizar");
            utilidadesTcs.clicElement("xpath", LauraChatPageObjects.BOTON_EQUIS);
        }
    }
    
    public void validarHomeDaviplataAlDarEnMinimizar() {
        utilidadesTcs.esperarElementVisibility("xpath", LoginRobustoPage.TEXTO_SALDO);
        boolean elemento = utilidadesTcs.validateElementVisibility("xpath", LoginRobustoPage.TEXTO_SALDO);
        utilidadesTcs.validateStatusElement(elemento);
        Utilidades.tomaEvidencia("Validar home despues de dar clic en minimizar del chat");
    }
    
    public void hacerClicEnElBotonEmpecemos() {
        utilidadesTcs.esperarElementVisibility("xpath", LauraChatPageObjects.TEXTO_BIENVENIDA_CHAT);
        Utilidades.tomaEvidencia("Hacer clic en empecemos");
        utilidadesTcs.clicElement("xpath", LauraChatPageObjects.BOTON_EMPECEMOS);
    }
    
    public void validarCanalDelChat() {
    	Utilidades.esperaMiliseg(6000);
        boolean elemento = utilidadesTcs.validateElementVisibilityCatch("xpath", LauraChatPageObjects.BOTON_PERMITIR_SOLO_USO_CON_APP);
        if(elemento) {
            utilidadesTcs.clicElement("xpath", LauraChatPageObjects.BOTON_PERMITIR_SOLO_USO_CON_APP);
        }
        boolean chatElemento = utilidadesTcs.validateElementVisibility("xpath", LauraChatPageObjects.TEXTO_AL_CANAL_CHAT);
        utilidadesTcs.validateStatusElement(chatElemento);
        Utilidades.tomaEvidencia("Validar canal del chat despues de dar clic en el boton 'Empecemos'");
    }
}
