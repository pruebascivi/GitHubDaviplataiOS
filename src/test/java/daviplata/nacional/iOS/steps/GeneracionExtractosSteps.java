package daviplata.nacional.iOS.steps;

import static org.junit.Assert.fail;
import java.math.BigDecimal;
import org.openqa.selenium.By;
import daviplata.nacional.iOS.pageObjects.GenerarExtractosPageObjects;
import daviplata.nacional.iOS.pageObjects.LoginPageObjects;
import daviplata.nacional.iOS.pageObjects.LoginRobustoPage;
import daviplata.nacional.iOS.pageObjects.MarketPlacePageObjects;
import daviplata.nacional.iOS.pageObjects.MenuHamburguesaPageObjects;
import daviplata.nacional.iOS.pageObjects.PasarPlataPageObjects;
import daviplata.nacional.iOS.pageObjects.negocioPageObjects;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import daviplata.nacional.iOS.utilidades.Utilidades;
import daviplata.nacional.iOS.utilidades.UtilidadesTCS;
import net.serenitybdd.core.Serenity;
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
    public void IngresoTipoDeCertificación() {
        generarExtractosPageObjects.IngresoTipoDeCertificación();
        Utilidades.tomaEvidencia("Validación de ¿Cuanto?");
    }
    
	@Step
    public void validarOpcionCuantoDebo() {
		generarExtractosPageObjects.validarOpcionCuantoDebo();    
		Utilidades.tomaEvidencia("Valido opción cuánto debo");
    }
    
	@Step
    public void cerrePopupNanocredito() {
        boolean estado = utilidadesTCS.validateElementVisibilityCatch("xpath", GenerarExtractosPageObjects.POPUP_NANOCREDITO);
        if (estado == true) {
            utilidadesTCS.clicElement("xpath", GenerarExtractosPageObjects.BOTON_NO_ME_INTERESA);
        } else {
        	Utilidades.esperaMiliseg(3000);
            Utilidades.tomaEvidencia("Ingreso a home daviplata");
        }
    }
    
	@Step
    public void ingresoACertificaciones() {
        claveCorreoSteps.seleccionoHeaderHome();
        excepcion4x1000Steps.pulsarDespegableSolicitudes();
        certificacionSteps.ingresarACertificaciones();
        Utilidades.tomaEvidencia("Ingresar a Certificaciones Nanocrédito");
    }
}

