package daviplata.nacional.iOS.steps;

import static org.junit.Assert.fail;
import daviplata.nacional.iOS.pageObjects.GenerarExtractosPageObjects;
import daviplata.nacional.iOS.pageObjects.MenuHamburguesaPageObjects;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import daviplata.nacional.iOS.utilidades.Utilidades;
import daviplata.nacional.iOS.utilidades.UtilidadesTCS;
import net.thucydides.core.annotations.Step;

public class GeneracionExtractosSteps {

	 Utilidades utilidad;
	 BaseUtil base;
	 MenuHamburguesaPageObjects menuHamburPO;
	 UtilidadesTCS utilidadesTCS;
	 GenerarExtractosPageObjects generarExtractosPageObjects = new GenerarExtractosPageObjects();
	 ClaveCorreoSteps claveCorreoSteps;
	 Excepcion4x1000Steps excepcion4x1000Steps;
	
	@Step
    public void ingresarAExtractos() {
        utilidadesTCS.clicElement("xpath", GenerarExtractosPageObjects.BTN_HEADER);
    	Utilidades.esperaMiliseg(800);
    	utilidadesTCS.esperarElementVisibility("xpath", GenerarExtractosPageObjects.BTN_SOLICITUDES);
        Utilidades.tomaEvidencia("Valido que encuentro la opción 'Solicitudes'");
        utilidadesTCS.clicElement("xpath", GenerarExtractosPageObjects.BTN_SOLICITUDES);
    	Utilidades.esperaMiliseg(800);
    	utilidadesTCS.esperarElementVisibility("xpath", GenerarExtractosPageObjects.BTN_EXTRACTOS);
        Utilidades.tomaEvidencia("Valido que encuentro la opción 'Extractos'");
        utilidadesTCS.clicElement("xpath", GenerarExtractosPageObjects.BTN_EXTRACTOS);
    	Utilidades.esperaMiliseg(800);
		boolean estadoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", GenerarExtractosPageObjects.TXT_NO_CUENTA_EXTRACTOS_DISPONIBLES);
		if(estadoVisible == true) {
	        Utilidades.tomaEvidencia("Usted no cuenta con extractos disponibles para su consulta");
			utilidadesTCS.clicElement("xpath", GenerarExtractosPageObjects.TXT_NO_CUENTA_EXTRACTOS_DISPONIBLES);
			System.out.println("Usted no cuenta con extractos disponibles para su consulta");
			fail("Usted no cuenta con extractos disponibles para su consulta");
		} else {
			utilidadesTCS.esperarElementVisibility("xpath", GenerarExtractosPageObjects.BTN_DESPLEGABLE_PERIODO);
	        utilidadesTCS.clicElement("xpath", GenerarExtractosPageObjects.BTN_DESPLEGABLE_PERIODO);
	        Utilidades.tomaEvidencia("Valido lista de periodos de los extractos en lista desplegable");
	    	Utilidades.esperaMiliseg(800);
	        Utilidades.tomaEvidencia("Ingresar a Extractos");
		}
    }
    
	@Step
    public void generarExtractos() {
		utilidadesTCS.scrollBackground("xpath", GenerarExtractosPageObjects.BOTON_DISCO_PERIODO, 0, 10);
    	Utilidades.esperaMiliseg(800);
        utilidadesTCS.clicElement("xpath", GenerarExtractosPageObjects.BOTON_DISCO_PERIODO);
		utilidadesTCS.esperarElementVisibility("xpath", GenerarExtractosPageObjects.BTN_DESCARGAR);
        utilidadesTCS.clicElement("xpath", GenerarExtractosPageObjects.BTN_DESCARGAR);
    	Utilidades.esperaMiliseg(800);
    }
    
	@Step
    public void validarGeneracionExtracto() {
		utilidadesTCS.esperarElementVisibility("xpath", GenerarExtractosPageObjects.TXT_EXTRACTO);
        Utilidades.tomaEvidencia("Valido generación de extracto");
    	Utilidades.esperaMiliseg(1500);
        utilidadesTCS.clicElement("xpath", GenerarExtractosPageObjects.BTN_COMPARTIR);
		utilidadesTCS.esperarElementVisibility("xpath", GenerarExtractosPageObjects.BTN_SAVE_TO_FILES);
        utilidadesTCS.clicElement("xpath", GenerarExtractosPageObjects.BTN_SAVE_TO_FILES);
    	Utilidades.esperaMiliseg(800);
		utilidadesTCS.esperarElementVisibility("xpath", GenerarExtractosPageObjects.BTN_GUARDAR);
        Utilidades.tomaEvidencia("Cliqueo botón compartir y luego procedo a descargar");
        utilidadesTCS.clicElement("xpath", GenerarExtractosPageObjects.BTN_GUARDAR);
    }

	@Step
    public void cerrePopupNanocredito() {
        boolean estado = utilidadesTCS.validateElementVisibilityCatch("xpath", GenerarExtractosPageObjects.POPUP_NANOCREDITO);
        if (estado == true) {
            utilidadesTCS.clicElement("xpath", GenerarExtractosPageObjects.BTN_NO_ME_INTERESA);
        } else {
        	Utilidades.esperaMiliseg(3000);
            Utilidades.tomaEvidencia("Ingreso a home daviplata");
        }
    }
    
	@Step
    public void validarOpcionCertificaciones() {
        utilidadesTCS.clicElement("xpath", GenerarExtractosPageObjects.BTN_HEADER);
    	Utilidades.esperaMiliseg(800);
    	utilidadesTCS.esperarElementVisibility("xpath", GenerarExtractosPageObjects.BTN_SOLICITUDES);
        Utilidades.tomaEvidencia("Valido la opción 'Solicitudes'");
        utilidadesTCS.clicElement("xpath", GenerarExtractosPageObjects.BTN_SOLICITUDES);
    	Utilidades.esperaMiliseg(800);
    	utilidadesTCS.esperarElementVisibility("xpath", GenerarExtractosPageObjects.OPCION_CERTIFICACIONES);
        Utilidades.tomaEvidencia("Valido la opción 'Certificaciones'");
        utilidadesTCS.clicElement("xpath", GenerarExtractosPageObjects.OPCION_CERTIFICACIONES);
    	Utilidades.esperaMiliseg(800);
    }
	
	@Step
    public void seleccionarTipoCertificacion() {
		utilidadesTCS.esperarElementVisibility("xpath", GenerarExtractosPageObjects.TXT_TIPO_CERTIFICACION);
    	Utilidades.esperaMiliseg(800);
        Utilidades.tomaEvidencia("Valido las opciones 'Tipo de Certificación'");
	}
	
	@Step
    public void seleccionarCertificacionNano() {
    	Utilidades.esperaMiliseg(800);
        utilidadesTCS.clicElement("xpath", GenerarExtractosPageObjects.OPCION_CERTIFICACIONES_NANOCREDITO);
    	Utilidades.esperaMiliseg(800);
	}
	
	@Step
    public void validarModuloCuantoDebo() {
        boolean estado = utilidadesTCS.validateElementVisibilityCatch("xpath", GenerarExtractosPageObjects.CUANTO_DEBO);
        if (estado == true) {
        	Utilidades.esperaMiliseg(800);
        	utilidadesTCS.esperarElementVisibility("xpath", GenerarExtractosPageObjects.CUANTO_DEBO);
        	Utilidades.esperaMiliseg(800);
            Utilidades.tomaEvidencia("Valido módulo '¿Cuánto debo?' dentro de 'Certificaciones Nanocrédito'");
        } else {
            Utilidades.tomaEvidencia("Usuario no cuenta con crédito activo");
        }
	}
	
	@Step
    public void seleccionarCertificacionTributaria() {
    	Utilidades.esperaMiliseg(800);
        utilidadesTCS.clicElement("xpath", GenerarExtractosPageObjects.OPCION_CERTIFICACIONES_TRIBUTARIAS);
    	Utilidades.esperaMiliseg(800);
	}
	
	@Step
    public void validarInformeGeneral() {
    	Utilidades.esperaMiliseg(800);
    	utilidadesTCS.esperarElementVisibility("xpath", GenerarExtractosPageObjects.TXT_AÑO_INFORME_GENERAL);
        utilidadesTCS.clicElement("xpath", GenerarExtractosPageObjects.BTN_DESPRENDIBLE_ANIO_INFORME);
    	Utilidades.esperaMiliseg(800);
        Utilidades.tomaEvidencia("Valido opcion para generar informe general");
	}
	
	@Step
    public void validarInformeGeneralPorAnio() {
    	Utilidades.esperaMiliseg(800);
    	utilidadesTCS.esperarElementVisibility("xpath", GenerarExtractosPageObjects.TXT_AÑO_INFORME_GENERAL);
        utilidadesTCS.clicElement("xpath", GenerarExtractosPageObjects.BTN_DESPRENDIBLE_ANIO_INFORME);
    	Utilidades.esperaMiliseg(800);
        Utilidades.tomaEvidencia("Valido lista seleccionable de años para generar informe general");
    	Utilidades.esperaMiliseg(800);
	}
	
	@Step
    public void validarGeneracionDeInforme() {
        utilidadesTCS.clicElement("xpath", GenerarExtractosPageObjects.BTN_DESCARGAR);
    	Utilidades.esperaMiliseg(800);
        boolean estado = utilidadesTCS.validateElementVisibilityCatch("xpath", GenerarExtractosPageObjects.TXT_ERROR_EN_SISTEMA);
        if (estado == true) {
            Utilidades.tomaEvidencia("Se presenta un error a la hora de generar informe");
            System.out.println("Se presenta un error a la hora de generar informe");
			fail("Se presenta un error a la hora de generar informe");
        }
    	Utilidades.esperaMiliseg(800);
        Utilidades.tomaEvidencia("Valido generación de informe general");
	}
	
	@Step
    public void validarOpcionCertificarCostos() {
    	Utilidades.esperaMiliseg(800);
        boolean estado = utilidadesTCS.validateElementVisibilityCatch("xpath", GenerarExtractosPageObjects.OPCION_COSTOS);
        if (estado == true) {
        	Utilidades.esperaMiliseg(800);
            utilidadesTCS.clicElement("xpath", GenerarExtractosPageObjects.OPCION_COSTOS);
        	Utilidades.esperaMiliseg(800);
            Utilidades.tomaEvidencia("Ingreso a la opcion 'Certificacion de Costos'");
        } else {
            Utilidades.tomaEvidencia("Se presenta un error, la opción 'Certificacion de Costos' no se encuentra disponible");
            System.out.println("Se presenta un error, la opción 'Certificacion de Costos' no se encuentra disponible");
			fail("Se presenta un error, la opción 'Certificacion de Costos' no se encuentra disponible");
        }
	}
	
	@Step
    public void validarMensajeCertificacionCostos() {
        utilidadesTCS.clicElement("xpath", GenerarExtractosPageObjects.BTN_DESCARGAR);
    	Utilidades.esperaMiliseg(800);
        boolean estado = utilidadesTCS.validateElementVisibilityCatch("xpath", GenerarExtractosPageObjects.TXT_ERROR_EN_SISTEMA);
        if (estado == true) {
            Utilidades.tomaEvidencia("Se presenta un error a la hora de generar informe");
            System.out.println("Se presenta un error a la hora de generar informe");
			fail("Se presenta un error a la hora de generar informe");
        }
    	Utilidades.esperaMiliseg(800);
        Utilidades.tomaEvidencia("Valido generación de informe general");
	}
}

