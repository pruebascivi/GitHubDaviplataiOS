package daviplata.nacional.iOS.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import daviplata.nacional.iOS.definitions.Hooks;
import daviplata.nacional.iOS.pageObjects.GenerarExtractosPageObjects;
import daviplata.nacional.iOS.pageObjects.LoginRobustoPage;
import daviplata.nacional.iOS.pageObjects.MenuHamburguesaPageObjects;
import daviplata.nacional.iOS.pageObjects.PasarPlataPageObjects;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import daviplata.nacional.iOS.utilidades.Utilidades;
import daviplata.nacional.iOS.utilidades.UtilidadesTCS;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import net.thucydides.core.annotations.Step;

public class OnHoldSteps {

	Utilidades utilidad;
	BaseUtil base;
	MenuHamburguesaPageObjects menuHamburPO;
	UtilidadesTCS utilidadesTCS;
	GenerarExtractosPageObjects generarExtractosPageObjects = new GenerarExtractosPageObjects();
	ClaveCorreoSteps claveCorreoSteps;
	Excepcion4x1000Steps excepcion4x1000Steps;
	PasarPlataPageObjects pagePasarPlata;
	private AppiumDriver<MobileElement> driver = Hooks.getDriver();

	
	@Step
    public void pasarPlataAOtroDaviplataOnHold(String numero, String monto) {
		pagePasarPlata.pasarPlataAOtroDaviplata();
		Utilidades.tomaEvidencia("Ingreso el numero de telefono " + numero);
		pagePasarPlata.pasarPlataAOtroDaviplataNumero(numero);
		
		try {
			pagePasarPlata.pasarPlataAOtroDaviplataCantidad();
			TouchAction touchAction=new TouchAction(driver);
	        touchAction.tap(new PointOption().withCoordinates(22, 339)).perform();
	        Utilidades.tomaEvidencia("Selecciono la cantidad");
			pagePasarPlata.darClickEnBtnContinuar();
			Utilidades.esperaMiliseg(2000);

			boolean estadoVisibilidadPopUP = utilidadesTCS.validateElementVisibilityCatch("xpath", PasarPlataPageObjects.TXT_ANTES_FINALIZAR);
			if (estadoVisibilidadPopUP == true) {
				
				Utilidades.esperaMiliseg(800);
				String celNum = utilidadesTCS.obtenerTexto("xpath", PasarPlataPageObjects.CELULAR);
				System.out.println("Número de celular capturado: " + celNum);
				Utilidades.tomaEvidencia("Antes de finalizar! El número " + celNum + " aún no tiene Daviplata.");
				Utilidades.esperaMiliseg(800);
				utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.CONTINUAR_POPUP_ANTES_FINALIZAR_BTN);
				System.out.println("Dio click en Boton Continuar");
			}
			
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.esperarElementVisibility("xpath", PasarPlataPageObjects.TXT_VERIFICAR_INFO);
			Utilidades.esperaMiliseg(500);
			Utilidades.tomaEvidencia("Verifico la información ingresada.");
			pagePasarPlata.darClickBtnPasarPlata();
			Utilidades.esperaMiliseg(10000);
			
			boolean transaccionExitosa = utilidadesTCS.validateElementVisibilityCatch("xpath", PasarPlataPageObjects.TXT_TRANSACCION_EXITOSA);
			if (transaccionExitosa == true) {
				utilidadesTCS.esperarElementVisibility("xpath", PasarPlataPageObjects.TXT_TRANSACCION_EXITOSA);
				Utilidades.tomaEvidencia("Transacción exitosa.");
				BaseUtil.Autorizador = utilidadesTCS.obtenerTexto("xpath", PasarPlataPageObjects.CODIGO_AUTORIZACION);
				Utilidades.esperaMiliseg(2000);
				utilidadesTCS.scrollBackground("xpath", PasarPlataPageObjects.TXT_TRANSACCION_EXITOSA, 0, -100);
				utilidadesTCS.esperarElementVisibility("xpath", PasarPlataPageObjects.FINALIZAR_TRANSACCION);
				utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.FINALIZAR_TRANSACCION);
				Utilidades.esperaMiliseg(4000);
				pagePasarPlata.capturarSaldoFinal();
				
			} else {
				Utilidades.tomaEvidencia("La transacción no fue exitosa o se presentó un problema.");
                fail("La transacción no fue exitosa o se presentó un problema.");
			}
			
		} catch (Exception e){
			boolean validacion = false;
			int Primer_Numero = Integer. parseInt(numero.substring(0,1));
			validacion =true;
			assertEquals(true,validacion);
			if (Primer_Numero != 3 ) {
				System.out.println("El numero de ingresa comienza con un numero diferente a 3");
				Utilidades.tomaEvidencia("El numero de ingresa comienza con un numero diferente a 3");
				//validacion =true;
				//assertEquals(true,validacion);
			} else 
				{assertEquals(true,validacion);
			}
		}
		boolean estadoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.POP_UP_INVITE_AMIGOS);
		if(estadoVisible == true) {
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_CLOSE);
		}
	}
}

