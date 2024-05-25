/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daviplata.nacional.iOS.steps;

import static org.junit.Assert.fail;

import java.util.Random;
import daviplata.nacional.iOS.pageObjects.AumentoDeTopesPageObjects;
import daviplata.nacional.iOS.pageObjects.LoginRobustoPage;
import daviplata.nacional.iOS.pageObjects.MovimientoFuncionalPageObjects;
import daviplata.nacional.iOS.utilidades.Utilidades;
import daviplata.nacional.iOS.utilidades.UtilidadesTCS;
import net.thucydides.core.annotations.Step;

public class MovimientoFuncionalSteps {
	
	AumentoDeTopesPageObjects pageAumentoDeTopes;
	Utilidades utilidades;
	UtilidadesTCS utilidadesTcs;
	Random rand = new Random();
	MovimientoFuncionalPageObjects movimientoFuncionalPageObjects;

	@Step
	public void ingresarAlDetalleSaldoDaviplata() {
		try {
			Utilidades.tomaEvidencia("Hacer clic al boton 'ver más' del saldo en el home");
	        Utilidades.esperaMiliseg(1000);
	        utilidadesTcs.esperarElementVisibility("xpath", MovimientoFuncionalPageObjects.VER_MAS_SALDO_HEADER);
	        utilidadesTcs.clicElement("xpath", MovimientoFuncionalPageObjects.VER_MAS_SALDO_HEADER);
		} catch(Exception e) {
			System.out.println("No se pudo interactuar con el elemento debido a: " + e.getMessage().toString());
			assert utilidadesTcs.validateElementVisibilityCatch("xpath", MovimientoFuncionalPageObjects.VER_MAS_SALDO_HEADER) : "No se pudo interactuar con el elemento." + MovimientoFuncionalPageObjects.VER_MAS_SALDO_HEADER;
		}
    }
    
	@Step
    public void validarEquisEnElDetalleDelSaldo() {
        Utilidades.esperaMiliseg(1000);
        utilidadesTcs.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
        utilidadesTcs.esperarElementVisibility("xpath", MovimientoFuncionalPageObjects.TEXTO_CUANTO_TENGO_DETALLE_SALDO);
        boolean visibilidad = utilidadesTcs.validateElementVisibility("xpath", MovimientoFuncionalPageObjects.EQUIS_HEADER);
        utilidadesTcs.validateStatusElement(visibilidad);
        Utilidades.tomaEvidencia("Validar que se muestre una X en el Header de la pantalla detalle del disponible");
        utilidadesTcs.clicElement("xpath", MovimientoFuncionalPageObjects.EQUIS_HEADER);
		Utilidades.esperaMiliseg(1000);
		boolean estadoVisible = utilidadesTcs.validateElementVisibilityCatch("xpath", LoginRobustoPage.POP_UP_INVITE_AMIGOS);
		if(estadoVisible == true) {
			utilidadesTcs.clicElement("xpath", LoginRobustoPage.BOTON_CLOSE);
		}
    }
	
	@Step
    public void validarHomeZonaPrivada() {
		Utilidades.esperaMiliseg(2000);
        utilidadesTcs.esperarElementVisibility("xpath", MovimientoFuncionalPageObjects.ULTIMO_MOVIMIENTO_BTN);
        boolean visibilidad = utilidadesTcs.validateElementVisibility("xpath", MovimientoFuncionalPageObjects.ULTIMO_MOVIMIENTO_BTN);
        utilidadesTcs.validateStatusElement(visibilidad);
        Utilidades.tomaEvidencia("Validar que al dar tap sobre la X que aparece en el Header de la pantalla detalle del disponible, el sistema deje al cliente en el Home de la zona Privada");
    }
    
	@Step
    public void entrarAlModuloMovimientos() {
		
		boolean estadoVisible = utilidadesTcs.validateElementVisibilityCatch("xpath", LoginRobustoPage.POP_UP_INVITE_AMIGOS);
		if(estadoVisible == true) {
			utilidadesTcs.clicElement("xpath", LoginRobustoPage.BOTON_CLOSE);
		}
        utilidadesTcs.clicElement("xpath", MovimientoFuncionalPageObjects.VER_TODOS_MOV_BTN);
		Utilidades.esperaMiliseg(1500);
        Utilidades.tomaEvidencia("Ingreso al botón movimientos");
        
		boolean defectoVisible = utilidadesTcs.validateElementVisibilityCatch("xpath", MovimientoFuncionalPageObjects.POPUP_LO_SENTIMOS_DEFECTO);
		if(defectoVisible == true) {
			Utilidades.esperaMiliseg(800);
			Utilidades.tomaEvidencia("Se presenta Pop Up de error, '¡Lo sentimos! En este momento no podemos cargar su información.'");
			System.out.println("Se presenta Pop Up de error, '¡Lo sentimos! En este momento no podemos cargar su información.'");
			fail("Se presenta Pop Up de error, '¡Lo sentimos! En este momento no podemos cargar su información.'");
		}
    }
    
	@Step
    public void validarBotonAtrasModuloMovimientos() {
		
		try {
			Utilidades.esperaMiliseg(800);
	        utilidadesTcs.esperarElementVisibility("xpath", MovimientoFuncionalPageObjects.MODULO_MOVIMIENTOS_TXT);
	        Utilidades.tomaEvidencia("Validar que se muestre el boton Atrás en el header de la pantalla de Movimientos");
		} catch(Exception e) {
			
	        System.out.println("No se pudo interactuar con el elemnto: " + MovimientoFuncionalPageObjects.MODULO_MOVIMIENTOS_TXT);
			fail("No se pudo interactuar con elemento debido a: " + e.getMessage() + MovimientoFuncionalPageObjects.MODULO_MOVIMIENTOS_TXT);
		}
    }
    
	@Step
    public void hacerClicEnElBotonAtras() {
		
		try {
			Utilidades.esperaMiliseg(1000);
	        utilidadesTcs.esperarElementVisibility("xpath", MovimientoFuncionalPageObjects.BOTON_ATRAS_MOVIMIENTOS);
	        utilidadesTcs.clicElement("xpath", MovimientoFuncionalPageObjects.BOTON_ATRAS_MOVIMIENTOS); 
	        
		} catch(Exception e) {
	        System.out.println("No se pudo interactuar con el elemnto: " + MovimientoFuncionalPageObjects.BOTON_ATRAS_MOVIMIENTOS);
			fail("No se pudo interactuar con elemento debido a: " + e.getMessage() + MovimientoFuncionalPageObjects.BOTON_ATRAS_MOVIMIENTOS);
		}      
    }
    
	@Step
    public void entrarAlModuloMovimientosDesdeDetalleDeSaldo() {
		boolean estadoVisible = utilidadesTcs.validateElementVisibilityCatch("xpath", LoginRobustoPage.POP_UP_INVITE_AMIGOS);
		if(estadoVisible == true) {
			utilidadesTcs.clicElement("xpath", LoginRobustoPage.BOTON_CLOSE);
		}
        Utilidades.tomaEvidencia("Dar clic en ver mas");
		Utilidades.esperaMiliseg(1000);
        utilidadesTcs.esperarElementVisibility("xpath", MovimientoFuncionalPageObjects.BOTON_VER_MAS_MOVIMIENTOS);
        utilidadesTcs.clicElement("xpath", MovimientoFuncionalPageObjects.BOTON_VER_MAS_MOVIMIENTOS);
    }
    
	@Step
    public void validarHeaderSaldos() {
		
		try {
	        boolean visibilidad = utilidadesTcs.validateElementVisibility("xpath", MovimientoFuncionalPageObjects.TEXTO_CUANTO_TENGO_DETALLE_SALDO);
	        utilidadesTcs.validateStatusElement(visibilidad);
	        Utilidades.tomaEvidencia("Validar cuando se ingrese a la pantalla Movimientos desde la pantalla detalle del disponible y el cliente da tap sobre el boton Atrás el sistema direccione al cliente a la pantalla inmediatamente anterior");
		
		} catch (Exception e) {
			Utilidades.esperaMiliseg(800);
			System.out.println("No se pudo interactuar con el elemnto: " + MovimientoFuncionalPageObjects.TEXTO_CUANTO_TENGO_DETALLE_SALDO);
			Utilidades.tomaEvidencia("No se pudo interactuar con el elemento");
			fail("No se pudo interactuar con elemento debido a: " + e.getMessage() + MovimientoFuncionalPageObjects.TEXTO_CUANTO_TENGO_DETALLE_SALDO);
		}
    }
    
    @Step
    public void validarTituloDelModuloMovimientos() {
    	
    	try {
    		String texto = utilidadesTcs.obtenerTexto("xpath", MovimientoFuncionalPageObjects.TEXTO_MODULO_MOVIMIENTOS);
            utilidadesTcs.validateTextContainsString(texto, "Movimientos");
            Utilidades.tomaEvidencia("Validar que en el Header de la pantalla Movimientos, aparezca un titulo que diga Movimientos");
    	} catch(Exception e) {
    		
	        System.out.println("No se pudo interactuar con el elemnto: " + MovimientoFuncionalPageObjects.TEXTO_MODULO_MOVIMIENTOS);
			fail("No se pudo interactuar con elemento debido a: " + e.getMessage() + MovimientoFuncionalPageObjects.TEXTO_MODULO_MOVIMIENTOS);
		}  
    }
    
    @Step
    public void validarEquisDeMovimientos() {
    	
    	try {
    		boolean visibilidad = utilidadesTcs.validateElementVisibility("xpath", MovimientoFuncionalPageObjects.BOTON_EQUIS_MOVIMIENTOS);
    		utilidadesTcs.validateStatusElement(visibilidad);
   	     	Utilidades.tomaEvidencia("Validar que en el Header de la pantalla Movimientos, aparezca un titulo que diga Movimientos");
   	     	//utilidadesTcs.clicElement("xpath", MovimientoFuncionalPageObjects.BOTON_EQUIS_MOVIMIENTOS);

    	} catch(Exception e) {
	        System.out.println("No se pudo interactuar con el elemnto: " + MovimientoFuncionalPageObjects.BOTON_EQUIS_MOVIMIENTOS);
			fail("No se pudo interactuar con elemento debido a: " + e.getMessage() + MovimientoFuncionalPageObjects.BOTON_EQUIS_MOVIMIENTOS);
		}  
    }
    
    @Step
    public void validarMovimientosDelDiaActual() {
    	
    	try {
    		String texto = utilidadesTcs.obtenerTexto("xpath", MovimientoFuncionalPageObjects.TEXTO_MOVIMIENTO_DEL_DIA_HOY);
            utilidadesTcs.validateTextContainsString(texto, "Hoy");
            Utilidades.tomaEvidencia("Validar que si se efectua algun movimiento en el dia en que se consulta los movimientos, lo que vera el cliente de primeras sera un titulo que diga Hoy");
    	
    	} catch(Exception e) {
	        System.out.println("No se pudo interactuar con el elemnto: " + MovimientoFuncionalPageObjects.TEXTO_MOVIMIENTO_DEL_DIA_HOY);
			assert utilidadesTcs.validateElementVisibilityCatch("xpath", MovimientoFuncionalPageObjects.TEXTO_MOVIMIENTO_DEL_DIA_HOY) : "No se pudo interactuar con el elemento." + MovimientoFuncionalPageObjects.TEXTO_MOVIMIENTO_DEL_DIA_HOY;
	        fail("No se pudo interactuar con elemento debido a: " + e.getMessage() + MovimientoFuncionalPageObjects.TEXTO_MOVIMIENTO_DEL_DIA_HOY);
    	}
    }
    
    @Step
    public void ingresarAlDetalleDelMovimientoPasarPlataDaviplata() {
    	
    	try {
    		Utilidades.tomaEvidencia("Ingresar al detalle del movimiento");
            utilidadesTcs.clicElement("xpath", MovimientoFuncionalPageObjects.TEXTO_MOVIMIENTO_PASAR_PLATA_DAVIPLATA);
    	
    	} catch(Exception e) {
	        System.out.println("No se pudo interactuar con el elemnto: " + MovimientoFuncionalPageObjects.TEXTO_MOVIMIENTO_PASAR_PLATA_DAVIPLATA);
			assert utilidadesTcs.validateElementVisibilityCatch("xpath", MovimientoFuncionalPageObjects.TEXTO_MOVIMIENTO_PASAR_PLATA_DAVIPLATA) : "No se pudo interactuar con el elemento." + MovimientoFuncionalPageObjects.TEXTO_MOVIMIENTO_PASAR_PLATA_DAVIPLATA;
	        fail("No se pudo interactuar con elemento debido a: " + e.getMessage() + MovimientoFuncionalPageObjects.TEXTO_MOVIMIENTO_PASAR_PLATA_DAVIPLATA);
    	}
    }
    
    @Step
    public void validarNombreYNumeroTransaccion() {
        Utilidades.esperaMiliseg(4000);
        utilidadesTcs.esperarElementVisibility("xpath", MovimientoFuncionalPageObjects.TEXTO_MOVIMIENTO_PASAR_PLATA_DAVIPLATA);
        String texto = utilidadesTcs.obtenerTexto("xpath", MovimientoFuncionalPageObjects.TEXTO_MOVIMIENTO_PASAR_PLATA_DAVIPLATA);
        utilidadesTcs.validateTextContainsString(texto, "Pasó plata a otro DaviPlata", "Recibió plata de otro DaviPlata");
        Utilidades.tomaEvidencia("Valido nombre de la transacción");
        boolean estado = utilidadesTcs.validateElementVisibility("xpath", MovimientoFuncionalPageObjects.TEXTO_NUMERO_MOVIMIENTO_PASAR_PLATA_DAVIPLATA);
        utilidadesTcs.validateStatusElement(estado);
    }
    
    @Step
    public void validarFormatoFechaMovimientos() {
    	try {
    		String textoFecha = utilidadesTcs.obtenerTexto("Xpath", MovimientoFuncionalPageObjects.TEXTO_FECHA_MOVIMIENTO);
            boolean validarFecha = utilidadesTcs.validarFormatoFecha(textoFecha,"MMMM dd - yyyy");
            utilidadesTcs.validateStatusElement(validarFecha);
    	} catch(Exception e) {
    		assert utilidadesTcs.validateElementVisibilityCatch("xpath", MovimientoFuncionalPageObjects.TEXTO_MOVIMIENTO_DEL_DIA_HOY) : "No se pudo interactuar con el elemento." + MovimientoFuncionalPageObjects.TEXTO_MOVIMIENTO_DEL_DIA_HOY;
    	}
    }
    
    @Step
    public void hacerClicEnLaEquisDeSaldos() {
		Utilidades.esperaMiliseg(1000);
        utilidadesTcs.clicElement("xpath", MovimientoFuncionalPageObjects.EQUIS_HEADER);
    }
    
}
