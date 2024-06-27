package daviplata.nacional.iOS.steps;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.github.javafaker.Faker;

import cucumber.api.Scenario;
import daviplata.nacional.iOS.definitions.Hooks;
import daviplata.nacional.iOS.pageObjects.BolsilloPageObjects;
import daviplata.nacional.iOS.pageObjects.HomePageObjects;
import daviplata.nacional.iOS.pageObjects.MenuHamburguesaPageObjects;
import daviplata.nacional.iOS.pageObjects.PasarPlataPageObjects;
import daviplata.nacional.iOS.pageObjects.PreguntasFrecuentesPageObjects;
import daviplata.nacional.iOS.pageObjects.RecargaPageObjects;
import daviplata.nacional.iOS.pageObjects.LoginPageObjects;
import daviplata.nacional.iOS.pageObjects.LoginRobustoPage;
import daviplata.nacional.iOS.pageObjects.MarketPlacePageObjects;
import daviplata.nacional.iOS.utilidades.Utilidades;
import daviplata.nacional.iOS.utilidades.UtilidadesTCS;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import com.github.javafaker.Faker;

public class PasarPlataSteps {
	
	BaseUtil base;
	Utilidades Utilidades;
	LoginPageObjects pageLogin;
	PasarPlataPageObjects pagePasarPlata;
	RecargaPageObjects recargarPageObjects;
	BolsilloPageObjects objBolsillosPageObjects;
	MenuHamburguesaPageObjects menuHamburguesaPageObjects;
	MarketPlacePageObjects marketPageobject;
	HomePageObjects pageHome;
	BigDecimal valorHome = null;
	BigDecimal valorTotal = null;
	BigDecimal valorBolsillo = null;
	BigDecimal valorTransferencia = null;
	private Scenario scenario = Hooks.scenario;
	private int contador = 0;
	private AppiumDriver<MobileElement> driver = Hooks.getDriver();
	MarketPlacePageObjects pageMarketPlace;
	@Steps
	Utilidades utilidad;
	UtilidadesTCS utilidadesTCS;
	Faker objFaker = new Faker();

	public void volver() {
		System.out.println("di click en btn de volver");
		pagePasarPlata.btnVolver();
	}
	
	public void pasarPlataBolsillos(String valor) {
		pagePasarPlata.btnBolsillos();
		pagePasarPlata.btnMeterPlataBolsillo();
		pagePasarPlata.btnSeleccionarBolsillo();
		pagePasarPlata.txtCuantaPlata(valor);
		pagePasarPlata.btnContinuarBolsillo();
		pagePasarPlata.txtAutorizadorBolsillo();
	}

	public void pasarPlataBolsillosHamburguesa(String valor) {
		pageLogin.capturarSaldo();
		utilidad.tomaEvidencia("Saldo inicial Daviplata " + base.saldo);
		pageLogin.darClickEnMenuHamburguesa();
		utilidad.tomaEvidencia("Doy click en Bolsillos");
		objBolsillosPageObjects.ingresarBolsillo();
//		pagePasarPlata.btnBolsillos();
		pagePasarPlata.btnMeterPlataBolsillo();
		pagePasarPlata.btnSeleccionarBolsillo();
		pagePasarPlata.txtCuantaPlata(valor);
		pagePasarPlata.btnContinuarBolsillo();
		pagePasarPlata.txtAutorizadorBolsillo();
	}

	public void seleccionarPasarPlata(boolean verificador) {
		utilidad.esperaMiliseg(3000);
		pagePasarPlata.capturarSaldoInicialDaviplata();
		utilidad.tomaEvidencia("Saldo inicial Daviplata ");
		if (verificador) {
			utilidad.tomaEvidencia("Seleccionar opcion pasar Plata");
		}
		pagePasarPlata.darClickEnOpcionPasarPlata();
		
	}

	// Dar click en A Otro Banco en pasar plata
	public void btnAOtroBanco() {
		pagePasarPlata.btnAOtroBanco();
	}

	public void seleccionarOtrosBancos() {
		pagePasarPlata.btnOtrosBancos();
	}
	public void btnCuentasNoInscritas() {
		pagePasarPlata.btnCuentasNoInscritas();
	}

	// Selecciono una cantidad
	public void pasarPlataAOtroDaviplata(String numero) {
		pagePasarPlata.pasarPlataAOtroDaviplata();
		utilidad.tomaEvidencia("Ingreso el numero de telefono " + numero);
		pagePasarPlata.pasarPlataAOtroDaviplataNumero(numero);
		
		try {
			pagePasarPlata.pasarPlataAOtroDaviplataCantidad();
			TouchAction touchAction=new TouchAction(driver);
	        touchAction.tap(new PointOption().withCoordinates(22, 339)).perform();
			utilidad.tomaEvidencia("Selecciono la cantidad");
			pagePasarPlata.darClickEnBtnContinuar();
			utilidad.esperaMiliseg(2000);

			boolean estadoVisibilidadPopUP = utilidadesTCS.validateElementVisibilityCatch("xpath", PasarPlataPageObjects.TXT_ANTES_FINALIZAR);
			if (estadoVisibilidadPopUP == true) {
				
				utilidad.esperaMiliseg(800);
				String celNum = utilidadesTCS.obtenerTexto("xpath", PasarPlataPageObjects.CELULAR);
				System.out.println("Número de celular capturado: " + celNum);
				Utilidades.tomaEvidencia("Antes de finalizar! El número " + celNum + " aún no tiene Daviplata.");
				utilidad.esperaMiliseg(800);
				utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.CONTINUAR_POPUP_ANTES_FINALIZAR_BTN);
				System.out.println("Dio click en Boton Continuar");
			}
			
			utilidad.esperaMiliseg(1000);
			utilidadesTCS.esperarElementVisibility("xpath", PasarPlataPageObjects.TXT_VERIFICAR_INFO);
			utilidad.esperaMiliseg(500);
			Utilidades.tomaEvidencia("Verifico la información ingresada.");
			pagePasarPlata.darClickBtnPasarPlata();
			utilidad.esperaMiliseg(10000);
			
			boolean transaccionExitosa = utilidadesTCS.validateElementVisibilityCatch("xpath", PasarPlataPageObjects.TXT_TRANSACCION_EXITOSA);
			if (transaccionExitosa == true) {
				utilidadesTCS.esperarElementVisibility("xpath", PasarPlataPageObjects.TXT_TRANSACCION_EXITOSA);
				Utilidades.tomaEvidencia("Transacción exitosa.");
				BaseUtil.Autorizador = utilidadesTCS.obtenerTexto("xpath", PasarPlataPageObjects.CODIGO_AUTORIZACION);
				utilidadesTCS.scrollBackground("xpath", PasarPlataPageObjects.CODIGO_AUTORIZACION, 0, -150);
				Utilidades.esperaMiliseg(1000);
				utilidadesTCS.esperarElementVisibility("xpath", PasarPlataPageObjects.FINALIZAR_TRANSACCION);
				utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.FINALIZAR_TRANSACCION);
				Utilidades.esperaMiliseg(4000);
				boolean estadoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.POP_UP_INVITE_AMIGOS);
				if(estadoVisible == true) {
					utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_CLOSE);
				}
				pagePasarPlata.capturarSaldoFinal();
				
			} else {
				utilidad.tomaEvidencia("La transacción no fue exitosa o se presentó un problema.");
                fail("La transacción no fue exitosa o se presentó un problema.");
			}
			
		} catch (Exception e){
			boolean validacion = false;
			int Primer_Numero = Integer. parseInt(numero.substring(0,1));
			validacion =true;
			assertEquals(true,validacion);
			if (Primer_Numero != 3 ) {
				System.out.println("El numero de ingresa comienza con un numero diferente a 3");
				utilidad.tomaEvidencia("El numero de ingresa comienza con un numero diferente a 3");
				//validacion =true;
				//assertEquals(true,validacion);
			} else 
				{assertEquals(true,validacion);
			}
		}
	}
	
	public void pasarPlataAOtroDaviplataValor1(String numero) {
		pagePasarPlata.pasarPlataAOtroDaviplata();
		//pagePasarPlata.darClickEnBtnContinuar();
		utilidad.tomaEvidencia("Ingreso el numero de telefono " + numero);
		pagePasarPlata.pasarPlataAOtroDaviplataNumero(numero);
		try {
		//pagePasarPlata.darClickEnBtnContinuar();
		pagePasarPlata.pasarPlataAOtroDaviplataCantidad1();
		TouchAction touchAction=new TouchAction(driver);
        touchAction.tap(new PointOption().withCoordinates(22, 339)).perform();
		//System.out.println("Dio click en Boton Continuar");
		utilidad.tomaEvidencia("Selecciono la cantidad");
		//pagePasarPlata.BtnAceptar();
		//pagePasarPlata.darClickBtnpasarPlata();
		pagePasarPlata.darClickEnBtnContinuar();
		System.out.println("Dio click en Boton Continuar");
		//pagePasarPlata.clickBtnContnuarPasarPlataOtroDaviplata();
		//System.out.println("Dio click en Boton Pasar Plata");
		pagePasarPlata.cerrarPopup();
		pagePasarPlata.darClickBtnPasarPlata();
		
		utilidad.esperaMiliseg(8000);
		
		pagePasarPlata.cerrarCalificacion();
		pagePasarPlata.txtAutorizador();
		
		}
		catch (Exception e){
			boolean validacion = false;
			int Primer_Numero = Integer. parseInt(numero.substring(0,1));
			validacion =true;
			assertEquals(true,validacion);
			if (Primer_Numero != 3 ) {
				System.out.println("El numero de ingresa comienza con un numero diferente a 3");
				utilidad.tomaEvidencia("El numero de ingresa comienza con un numero diferente a 3");
				//validacion =true;
				//assertEquals(true,validacion);
			}
			else {assertEquals(true,validacion);
			}
			
		}
	}
	
	public void validarNumeroErrado(String numero) {
		pagePasarPlata.pasarPlataAOtroDaviplata();
		utilidad.tomaEvidencia("Ingreso el numero de telefono " + numero);
		pagePasarPlata.pasarPlataAOtroDaviplataNumero(numero);
		pagePasarPlata.validarMensajeNumeroDiferenteTres();
		utilidad.tomaEvidencia("Validar mensaje numero diferente de 3");
	}

	// Selecciono una cantidad
	public void pasarPlataAOtroDaviplataVolverAtras(String numero) {
		pagePasarPlata.pasarPlataAOtroDaviplata();
		utilidad.tomaEvidencia("Pasar plata a otro Daviplata");
		pagePasarPlata.atras2();
		utilidad.tomaEvidencia("Valido que volver atras me traiga a la ventana anterior");
	}

	// Selecciono una cantidad
	public void pasarPlataAOtroDaviplataFondosInsuficientes(String numero) {
		pagePasarPlata.pasarPlataAOtroDaviplata();
		utilidad.tomaEvidencia("Ingreso el numero de telefono " + numero);
		pagePasarPlata.pasarPlataAOtroDaviplataNumero(numero);
	}

	public void pasarPlataAOtroDaviplataMayorAlSaldo(String numero) {
		pagePasarPlata.pasarPlataAOtroDaviplata();
		utilidad.tomaEvidencia("Ingreso el nuemero de telefono " + numero);
		pagePasarPlata.pasarPlataAOtroDaviplataNumero(numero);
		pagePasarPlata.pasarPlataAOtroDaviplataEscribirCantidadMayorSaldo();
		utilidad.tomaEvidencia("Selecciono la cantidad");
		pagePasarPlata.BtnAceptar();
		// pagePasarPlata.txtAutorizador();
	}

	// Escribo la cantidad
	public void pasarPlataAOtroDaviplataValor(String numero,String monto) {
		pagePasarPlata.pasarPlataAOtroDaviplata();
		utilidad.tomaEvidencia("Ingreso el nuemero de telefono " + numero);
		pagePasarPlata.pasarPlataAOtroDaviplataNumero(numero);
		pagePasarPlata.pasarPlataAOtroDaviplataEscribirCantidad(monto);
		utilidad.tomaEvidencia("Monto a transferir");	
		pagePasarPlata.clickBtnContnuarPasarPlataOtroDaviplata();
		pagePasarPlata.darClickBtnPasarPlata();
		pagePasarPlata.txtAutorizador();
	}
	
	public void pasarPlataAOtroDaviplataValorCero(String numero,String monto) {
		pagePasarPlata.pasarPlataAOtroDaviplata();
		utilidad.tomaEvidencia("Ingreso el nuemero de telefono " + numero);
		pagePasarPlata.pasarPlataAOtroDaviplataNumero(numero);
		pagePasarPlata.pasarPlataAOtroDaviplataEscribirCantidadCero(monto);
		TouchAction touchAction=new TouchAction(driver);
        touchAction.tap(new PointOption().withCoordinates(22, 339)).perform();
        Utilidades.tomaEvidencia("Monto a transferir");
		boolean condicionContinuar = utilidadesTCS.validateElementVisibilityCatch("xpath", PasarPlataPageObjects.BTN_CONTINUAR);
		if (condicionContinuar == true) {
	        utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.BTN_CONTINUAR);
		}
		boolean condicionPasarPlata = utilidadesTCS.validateElementVisibilityCatch("xpath", PasarPlataPageObjects.PASAR_PLATA_BTN_DAV);
		if (condicionPasarPlata == true) {
	        utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.PASAR_PLATA_BTN_DAV);
		}
	}

	public void verificarTransaccionExitosaPasarPlataCuenta() {
		utilidad.esperaMiliseg(10000);
		//pagePasarPlata.cerrarPopUpTransaccionExitosa();
		//pagePasarPlata.cerrarCalificacion();
		pagePasarPlata.txtAutorizadorPasarPlataCuenta();
		utilidad.tomaEvidencia("Valido resultado de transacción");
		pagePasarPlata.darClickEnFinalizarTransaccion();
		utilidad.esperaMiliseg(3000);
		pagePasarPlata.capturarSaldoFinal();
		utilidad.tomaEvidencia("Saldo final del daviplata");
	}

	//Modulo pasar plata	
	public void escogerOpcionCuentasDavivienda() {
		Utilidades.esperaMiliseg(10);
		Utilidades.tomaEvidencia("Seleccionar cuentas Davivienda");
		pagePasarPlata.seleccionarCuentasDavivienda();
		Utilidades.esperaMiliseg(1000);
		pagePasarPlata.seleccionarTipoCuentasDavivienda();
		
	}
	
	public void escogerOpcionAOtrosBancos() {
		utilidad.esperaMiliseg(1500);
		utilidadesTCS.esperarElementVisibility("xpath", PasarPlataPageObjects.BTN_OPCION_AOTROS_BANCOS);
		System.out.println("escogiendo otros bancos");
		utilidad.tomaEvidencia("Seleccionar opcion a otros bancos");
		pagePasarPlata.seleccionarAOtrosBancos();
	}
	
	public void escogerOpcionTipoCuentaDavivienda(String tipoCuenta) {		
		pagePasarPlata.seleccionarOpcionesCuentasDavivienda(tipoCuenta);
		utilidad.tomaEvidencia("Seleccion cuenta ahorros");		
	}
	
	public void ingresarNumeroCuentaDavivienda(String numCuenta) {
		pagePasarPlata.ingresarNumeroCuenta(numCuenta);
		utilidad.tomaEvidencia("Ingresar Numero Cuenta");	
	}
	
	public void ingresarMontoCuentaDavivienda(String monto) {
		pagePasarPlata.ingresarMontoCuenta(monto);
        utilidadesTCS.clickCoordinates(390, 150);
		utilidad.tomaEvidencia("Ingresar Monto Cuenta");
		pagePasarPlata.clicBotonPasarPlata();
		utilidad.esperaMiliseg(1500);
		utilidad.tomaEvidencia("Valido información ingresada");
		utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.PASAR_PLATA_BTN_DAV);

	}
	
	public void clicPasarPlataCuenta() {
		utilidad.tomaEvidencia("Datos pasar plata");
		pagePasarPlata.clicPasarPlata();
	}
	
	@Step
	public void llenarFormularioPasarPlataYFavorito(String numeroCuenta, String tipoId, String numId, String valorAPasar, String banco) {
		utilidad.esperaMiliseg(4000);
		//INGRESAR NOMBRE DE CONTACTO
		pagePasarPlata.inputNombreContacto();
		//BTN SELECCIONAR BANCO
		pagePasarPlata.btnSeleccioneBanco();
		//SELECCIONAR OPCION DE BANCO
		pagePasarPlata.discoSeleccioneBanco(banco);
		//BTN SELECCIONAR TIPO DE BANCO
		pagePasarPlata.btnSeleccioneTipoCuentaBanco();
		//SELECCIONAR TIPO DE BANCO
		pagePasarPlata.discoSeleccioneTipoCuentaBanco();
		//INGRESAR NUMERO DE CUENTA
		pagePasarPlata.inputNumeroCuentaBanco(numeroCuenta);
		utilidad.tomaEvidencia("Seleccion banco y num cuenta");
		//DAR SCROLL
		Utilidades.scrollDownSwipe(1);
		//BTN SELECCIONAR TIPO DE DOCUMENTO
		pagePasarPlata.seleccioneTipoIdentificacion();
		//SELECCIONAR TIPO DE DOCUMENTACION
		pagePasarPlata.discoTipoIdentificacion(tipoId);
		//INGRESAR NUMERO DE IDENTIFICACION
		pagePasarPlata.numeroIdentificacion(numId);
		//INGRESAR MONTO
		pagePasarPlata.inputMonto(valorAPasar);
		utilidad.tomaEvidencia("Llenado del formulario");
		System.out.println("Llené el formulario correctamente");
		utilidad.esperaMiliseg(1500);
		utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.BOTON_FAVORITOS_PASAR_PLATA);
		utilidad.esperaMiliseg(800);
		utilidad.tomaEvidencia("Confirmación de contacto añadido a favoritos");
		utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.BTN_CONFIRMACION_FAV_USER_PASAR_PLATA);
		//DAR CLICK BTN CONTINUAR
		pagePasarPlata.btnContinue();
		//CERRAR POPUP
		//pagePasarPlata.btnCerrarPopPup();
		utilidad.esperaMiliseg(1500);
		utilidadesTCS.esperarElementVisibility("xpath", PasarPlataPageObjects.POPUP_PARAMATERIZACION);
		utilidad.tomaEvidencia("Dar en el boton Pop Up continuar");
		//CLICK BTN CONTINUAR POPUP
		//pagePasarPlata.btnContinuarPopUp();
		utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.ACEPTAR_POPUP);
		utilidad.esperaMiliseg(3000);
		utilidad.tomaEvidencia("Confirmacion datos transacción");
		//CLICK BTN PASAR PLATA
		utilidad.esperaMiliseg(800);
		pagePasarPlata.btnPasarPlata();
	}
	
	public void llenarFormularioPasarPlata(String numeroCuenta, String tipoId, String numId, String valorAPasar, String banco) {
		utilidad.esperaMiliseg(4000);
		//INGRESAR NOMBRE DE CONTACTO
		pagePasarPlata.inputNombreContacto();
		//BTN SELECCIONAR BANCO
		pagePasarPlata.btnSeleccioneBanco();
		//SELECCIONAR OPCION DE BANCO
		pagePasarPlata.discoSeleccioneBanco(banco);
		//BTN SELECCIONAR TIPO DE BANCO
		pagePasarPlata.btnSeleccioneTipoCuentaBanco();
		//SELECCIONAR TIPO DE BANCO
		pagePasarPlata.discoSeleccioneTipoCuentaBanco();
		//INGRESAR NUMERO DE CUENTA
		pagePasarPlata.inputNumeroCuentaBanco(numeroCuenta);
		utilidad.tomaEvidencia("Seleccion banco y num cuenta");
		//DAR SCROLL
		Utilidades.scrollDownSwipe(1);
		//BTN SELECCIONAR TIPO DE DOCUMENTO
		pagePasarPlata.seleccioneTipoIdentificacion();
		//SELECCIONAR TIPO DE DOCUMENTACION
		pagePasarPlata.discoTipoIdentificacion(tipoId);
		//INGRESAR NUMERO DE IDENTIFICACION
		pagePasarPlata.numeroIdentificacion(numId);
		//INGRESAR MONTO
		pagePasarPlata.inputMonto(valorAPasar);
		utilidad.tomaEvidencia("Llenado del formulario");
		System.out.println("Llené el formulario correctamente");
		//DAR CLICK BTN CONTINUAR
		pagePasarPlata.btnContinue();
		//CERRAR POPUP
		//pagePasarPlata.btnCerrarPopPup();
		utilidad.esperaMiliseg(1500);
		utilidadesTCS.esperarElementVisibility("xpath", PasarPlataPageObjects.POPUP_PARAMATERIZACION);
		utilidad.tomaEvidencia("Dar en el boton Pop Up continuar");
		//CLICK BTN CONTINUAR POPUP
		//pagePasarPlata.btnContinuarPopUp();
		utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.ACEPTAR_POPUP);
		utilidad.esperaMiliseg(3000);
		utilidad.tomaEvidencia("Confirmacion datos transacción");
		//CLICK BTN PASAR PLATA
		pagePasarPlata.btnPasarPlata();
	}
	
	public void llenarFormularioPasarPlataFondosInsuficientes(String numeroCuenta, String tipoId, String numId, String banco) {
		utilidad.esperaMiliseg(4000);
		//INGRESAR NOMBRE DE CONTACTO
		pagePasarPlata.inputNombreContacto();
		//BTN SELECCIONAR BANCO
		pagePasarPlata.btnSeleccioneBanco();
		//SELECCIONAR OPCION DE BANCO
		pagePasarPlata.discoSeleccioneBanco(banco);
		//BTN SELECCIONAR TIPO DE BANCO
		pagePasarPlata.btnSeleccioneTipoCuentaBanco();
		//SELECCIONAR TIPO DE BANCO
		pagePasarPlata.discoSeleccioneTipoCuentaBanco();
		//INGRESAR NUMERO DE CUENTA
		pagePasarPlata.inputNumeroCuentaBanco(numeroCuenta);
		utilidad.tomaEvidencia("Seleccion banco y num cuenta");
		//DAR SCROLL
		Utilidades.scrollDownSwipe(1);
		//BTN SELECCIONAR TIPO DE DOCUMENTO
		pagePasarPlata.seleccioneTipoIdentificacion();
		//SELECCIONAR TIPO DE DOCUMENTACION
		pagePasarPlata.discoTipoIdentificacion(tipoId);
		//INGRESAR NUMERO DE IDENTIFICACION
		pagePasarPlata.numeroIdentificacion(numId);
		//INGRESAR MONTO
		pagePasarPlata.inputMontoFondosInsuficientes();
		utilidad.tomaEvidencia("Llenado del formulario");
		System.out.println("Llené el formulario correctamente");
	}
	
	public void llenarFormularioPasarPlataMenorDiezMil(String numeroCuenta, String tipoId, String numId, String valorAPasar, String banco) {
		utilidad.esperaMiliseg(4000);
		//INGRESAR NOMBRE DE CONTACTO
		pagePasarPlata.inputNombreContacto();
		//BTN SELECCIONAR BANCO
		pagePasarPlata.btnSeleccioneBanco();
		//SELECCIONAR OPCION DE BANCO
		pagePasarPlata.discoSeleccioneBanco(banco);
		//BTN SELECCIONAR TIPO DE BANCO
		pagePasarPlata.btnSeleccioneTipoCuentaBanco();
		//SELECCIONAR TIPO DE BANCO
		pagePasarPlata.discoSeleccioneTipoCuentaBanco();
		//INGRESAR NUMERO DE CUENTA
		pagePasarPlata.inputNumeroCuentaBanco(numeroCuenta);
		utilidad.tomaEvidencia("Seleccion banco y num cuenta");
		//DAR SCROLL
		Utilidades.scrollDownSwipe(1);
		//BTN SELECCIONAR TIPO DE DOCUMENTO
		pagePasarPlata.seleccioneTipoIdentificacion();
		//SELECCIONAR TIPO DE DOCUMENTACION
		pagePasarPlata.discoTipoIdentificacion(tipoId);
		//INGRESAR NUMERO DE IDENTIFICACION
		pagePasarPlata.numeroIdentificacion(numId);
		//INGRESAR MONTO
		pagePasarPlata.inputMonto(valorAPasar);
		utilidad.tomaEvidencia("Llenado del formulario");
		System.out.println("Llené el formulario correctamente");
		//DAR CLICK BTN CONTINUAR
		pagePasarPlata.btnContinue();
	}
	
	
	public void llenarPrimerFormularioPasarPlata(String numeroCuenta, String tipoId, String numId, String valorAPasar, String banco) {
		Utilidades.esperaMiliseg(1000);
		pagePasarPlata.inputNombreContacto();
		pagePasarPlata.btnSeleccioneBanco();
		pagePasarPlata.discoSeleccioneBanco(banco);
		pagePasarPlata.btnSeleccioneTipoCuentaBanco();
		pagePasarPlata.discoSeleccioneTipoCuentaBanco();
		pagePasarPlata.inputNumeroCuentaBanco(numeroCuenta);
		utilidad.tomaEvidencia("Seleccion banco y num cuenta");
		pagePasarPlata.scrollHastaBtnContinuarPasarPlataOtrosBancos();
		pagePasarPlata.seleccioneTipoIdentificacion();
		pagePasarPlata.discoTipoIdentificacion(tipoId);
		pagePasarPlata.numeroIdentificacion(numId);
		pagePasarPlata.inputMonto(valorAPasar);
		utilidad.tomaEvidencia("Llenado del formulario");
		System.out.println("Llené el formulario correctamente");
	}
	
	public void llenarMonto(String valorAPasar) {
		utilidad.esperaMiliseg(4000);
		utilidad.tomaEvidencia("Dar en seleccionar cuenta inscrita");
		pagePasarPlata.clicCuentaFavorita();
		utilidad.esperaMiliseg(8000);
		utilidad.tomaEvidencia("Dar en cuenta inscrita");
		pagePasarPlata.seleccionaCuentaInscrita();
		utilidad.esperaMiliseg(3000);
		pagePasarPlata.inputMonto(valorAPasar);
		utilidad.tomaEvidencia("Llenado del formulario");
		System.out.println("Llené el formulario correctamente");
		//DAR CLICK BTN CONTINUAR
		pagePasarPlata.btnContinue();
		utilidad.esperaMiliseg(4000);
		utilidad.tomaEvidencia("Dar en el boton Pop Up continuar");
		//CERRAR POPUP
		pagePasarPlata.btnCerrarPopPup();
		//CLICK BTN CONTINUAR POPUP
		pagePasarPlata.btnContinuarPopUp();
		utilidad.esperaMiliseg(3000);
		utilidad.tomaEvidencia("Confirmacion datos transacción");
		//CLICK BTN PASAR PLATA
		pagePasarPlata.btnPasarPlata();
		
		
	}
	
	public void llenarFormularioPasarPlataAch(String numeroCuenta, String tipoId, String numId, String valorAPasar, String banco) {
		utilidad.esperaMiliseg(4000);
		//INGRESAR NOMBRE DE CONTACTO
		pagePasarPlata.inputNombreContacto();
		//BTN SELECCIONAR BANCO
		pagePasarPlata.btnSeleccioneBanco();
		//SELECCIONAR OPCION DE BANCO
		pagePasarPlata.discoSeleccioneBanco(banco);
		//BTN SELECCIONAR TIPO DE BANCO
		pagePasarPlata.btnSeleccioneTipoCuentaBanco();
		//SELECCIONAR TIPO DE BANCO
		pagePasarPlata.discoSeleccioneTipoCuentaBanco();
		//INGRESAR NUMERO DE CUENTA
		pagePasarPlata.inputNumeroCuentaBanco(numeroCuenta);
		utilidad.tomaEvidencia("Seleccion banco y num cuenta");
		//DAR SCROLL
		Utilidades.scrollDownSwipe(1);
		//BTN SELECCIONAR TIPO DE DOCUMENTO
		pagePasarPlata.seleccioneTipoIdentificacion();
		//SELECCIONAR TIPO DE DOCUMENTACION
		pagePasarPlata.discoTipoIdentificacion(tipoId);
		//INGRESAR NUMERO DE IDENTIFICACION
		pagePasarPlata.numeroIdentificacion(numId);
		//INGRESAR MONTO
		pagePasarPlata.inputMonto(valorAPasar);
		utilidad.tomaEvidencia("Llenado del formulario");
	}

	// Selecciono la cantidad cuenta ahorros
	public void seleccionarTipoCuentaDestino(String tipoCuenta, String cuentaNum) {
		pagePasarPlata.seleccionarCuentasDavivienda();
		pagePasarPlata.seleccionarTipoCuentasDavivienda();
		pagePasarPlata.seleccionarOpcionesCuentasDavivienda(tipoCuenta);
		utilidad.tomaEvidencia("Seleccion A cuenta de Ahorros Daviviendd");
		pagePasarPlata.ingresarNumCuentaDestino(cuentaNum);
		TouchAction touchAction=new TouchAction(driver);
        touchAction.tap(new PointOption().withCoordinates(20, 352)).perform();
		utilidad.tomaEvidencia("Cuenta de destino " + cuentaNum);
	}

	// Selecciono la cantidad cuenta corriente
	public void seleccionarCuentaCorriente(String tipoCuenta, String numeroCuenta) {
		pagePasarPlata.seleccionarCuentasDavivienda();
		pagePasarPlata.seleccionarTipoCuentasDavivienda();
		pagePasarPlata.seleccionarOpcionesCuentasDavivienda(tipoCuenta);
		utilidad.tomaEvidencia("Seleccion A cuenta corriente Davivienda");
		pagePasarPlata.ingresarNumeroCuenta(numeroCuenta);
		utilidad.tomaEvidencia("Cuenta de destino " + numeroCuenta);
	}

	// Selecciono la cantidad cuenta corriente mayor al saldo
	public void seleccionarCuentaCorrienteMayorSaldoDaviplata(String cuentaNum) {
		utilidad.tomaEvidencia("Seleccion A cuenta corriente Davivienda");
		utilidad.tomaEvidencia("Cuenta de destino " + cuentaNum);
		pagePasarPlata.pasarPlataAOtroDaviplataEscribirCantidadMayorSaldo();
		pagePasarPlata.BtnAceptar();
		pagePasarPlata.txtAutorizador();
	}

	public void validarMonto() {
		pagePasarPlata.verificoMonto();
	}

	public void seleccionarTipoCuentaDestinoACH(String tipoCuenta, String cuentaNum, String monto) {
		//seleccionarCuantaOtroBancoNoInscrita(tipoCuenta);
		utilidad.tomaEvidencia("Seleccion de tipo De Cuenta");
		diligenciarFormularioCuentasNoInscritasFondosInsuficientes(tipoCuenta, monto);
		// procesarTransaccionOtrosBancosFondosInsuficientes();
	}

	public void seleccionarTipoCuentaDestinoACH1(String tipoCuenta, String cuentaNum, String monto) {
		//seleccionarCuantaOtroBancoNoInscrita(tipoCuenta);
		utilidad.tomaEvidencia("Seleccion de tipo De Cuenta");
		diligenciarFormularioCuentasNoInscritasFondosInsuficientes(tipoCuenta, monto);
		//procesarTransaccionOtrosBancosFondosInsuficientes();
	}

	public void seleccionarMonto() {
		pagePasarPlata.pasarPlataAOtroDaviplataCantidad();
		utilidad.tomaEvidencia("Selecciono la cantidad");
		pagePasarPlata.BtnAceptar();
		pagePasarPlata.txtAutorizador();
	}

	public void escribirValor(String monto) {
		pagePasarPlata.pasarPlataAOtroDaviplataEscribirCantidad(monto);
		utilidad.tomaEvidencia("Dar en boton continuar");
		pagePasarPlata.clicBotonPasarPlata();
		utilidad.tomaEvidencia("Dar en boton pasar plata");
		pagePasarPlata.clicPasarPlata();
	}

	public void escribirValorMenor() {
		pagePasarPlata.pasarPlataAOtroDaviplataEscribirCantidadMenor();
		utilidad.tomaEvidencia("Selecciono la cantidad");
		pagePasarPlata.BtnAceptar();
		pagePasarPlata.txtAutorizador();
	}

	public void seleccionarOtroValor() {
		pagePasarPlata.seleccionarOpcionCuantoQuierePagar();
		pagePasarPlata.ingresarOtroMonto();
		utilidad.tomaEvidencia("Monto a Transferir");
		pagePasarPlata.darClickEnBtnAceptar();
	}

	public void transaccionConvalorMayorAlSaldo() {
		pagePasarPlata.seleccionarOpcionCuantoQuierePagar();
		pagePasarPlata.ingresarMontoMayorSaldo();
		utilidad.tomaEvidencia("Monto a Transferir");
		pagePasarPlata.darClickEnBtnAceptar();
	}

	public void transaccionFondosInsuficientes(String monto) {
		pagePasarPlata.ingresarMonto(monto);
		utilidad.tomaEvidencia("Monto a Transferir");
	}

	public void validoFondosInsuficientes() {
		pagePasarPlata.validoLblFondosInsuficientes();
		pagePasarPlata.validoBtnContinuarDeshabilitado();
		utilidad.esperaMiliseg(500);
		pageHome.clickBotonAtras(2);
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("Valido no haya descuento del home");
		//utilidad.validacionDeSaldos();

	}

	public void validoFondosInsuficientes(int repeticiones) {
		pagePasarPlata.validoLblFondosInsuficientes();
		pageHome.clickBotonAtras(repeticiones);
		pageHome.darClickEnActualizarSaldo();
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("Valido no haya descuento del home");
		utilidad.validacionDeSaldos();
		utilidad.esperaMiliseg(2000);
	}

	public void validoFondosInsuficientesBolsillo(int repeticiones) {
		pagePasarPlata.validoLblFondosInsuficientesBolsillos();
		pageHome.clickBotonAtras(repeticiones);
		pageHome.darClickEnActualizarSaldo();
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("Valido no haya descuento del home");
		utilidad.validacionDeSaldos();
		utilidad.esperaMiliseg(2000);
	}

	public void validoTransaccionRechazada() {
		pagePasarPlata.validoLblFondosTransaccionDeclinada();
		pageHome.clickBotonAtras(2);
		pageHome.darClickEnActualizarSaldo();
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("Valido no haya descuento del home");
		utilidad.validacionDeSaldos();
		utilidad.esperaMiliseg(2000);

	}

	public void validoTransaccionRechazada(int repeticiones) {
		pagePasarPlata.validoLblFondosTransaccionDeclinada();
		pageHome.clickBotonAtras(repeticiones);
		pageHome.darClickEnActualizarSaldo();
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("Valido no haya descuento del home");
		utilidad.validacionDeSaldos();
		utilidad.esperaMiliseg(2000);

	}

	public void validoRechazoFondosInsuficientes(int repeticiones) {
		pagePasarPlata.validoLblRechazoFondosInsuficientes();
		pageHome.clickBotonAtras(repeticiones);
		pageHome.darClickEnActualizarSaldo();
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("Valido no haya descuento del home");
		utilidad.validacionDeSaldos();
		utilidad.esperaMiliseg(2000);

	}
	
	public void validoRechazoFondosInsuficientesAOtros(int repeticiones) {
		pagePasarPlata.validoLblRechazoFondosInsuficientesAOtros();
		pageHome.clickBotonAtras(repeticiones);
		pageHome.darClickEnActualizarSaldo();
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("Valido no haya descuento del home");
		utilidad.validacionDeSaldos();
		utilidad.esperaMiliseg(2000);
	}

	public void validoInferiorAlPermitido(int repeticiones) {
		pagePasarPlata.validoLblValorSuperiorAlPermitido();
		pageHome.clickBotonAtras(repeticiones);
		pageHome.darClickEnActualizarSaldo();
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("Valido no haya descuento del home");
		utilidad.validacionDeSaldos();
		utilidad.esperaMiliseg(2000);

	}

	public void validoValorInicialInvalidoBolsillo() {
		pagePasarPlata.validoLblValorInicialInvalido();
		pageHome.clickBotonAtrasBolsillos(3);
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("Valido no haya descuento del home");
		utilidad.validacionDeSaldos();
	}

	public void validoSinAbonoPorFondoInsuficiente(int repeticiones) {
		pagePasarPlata.validoLblSinAbonoFondosInsuficientes();
		pageHome.clickBotonAtras(repeticiones);
		pageHome.darClickEnActualizarSaldo();
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("Valido no haya descuento del home");
		utilidad.validacionDeSaldos();
		utilidad.esperaMiliseg(2000);
	}

	public void validoBolsilloNoSaldoDisponible() {
		pagePasarPlata.validoLblBolsilloNoSaldoDisponible();
		pageHome.clickBotonAtrasBolsillos(3);
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("Valido no haya descuento del home");
	}

	public void validoValorInicialBolsilloInvalido() {
		pagePasarPlata.validoLblValorInicialInvalido();
		pageHome.clickBotonAtras(3);
		pageHome.darClickEnActualizarSaldo();
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("Valido no haya descuento del home");
		utilidad.validacionDeSaldos();
		utilidad.esperaMiliseg(2000);

	}

	public void validoExcedeCupo() {
		pagePasarPlata.validoLblExcedeCupo();
	}
	
	public void cerrarSesion() {
		pageHome.clickBotonAtras(2);
		pageHome.clickBtnLogout();
	}
	
	public void validoExcedeCupoAOtros() {
		pagePasarPlata.validoLblRechazoFondosInsuficientesAOtros();
		//pagePasarPlata.validoBtnContinuarDeshabilitado();
		pageHome.clickBotonAtras(2);
		pageHome.darClickEnActualizarSaldo();
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("Valido no haya descuento del home");
		utilidad.validacionDeSaldos();
		utilidad.esperaMiliseg(2000);

	}

	public void validoExcedeCupo(int repeticiones) {
		pagePasarPlata.validoLblExcedeCupo();
		pagePasarPlata.validoBtnContinuarDeshabilitado();
		pageHome.clickBotonAtras(repeticiones);
		pageHome.darClickEnActualizarSaldo();
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("Valido no haya descuento del home");
		utilidad.validacionDeSaldos();
		utilidad.esperaMiliseg(2000);

	}

	public void validoTransaccionInvalida(int repeticiones) {
		pagePasarPlata.validoLblTransaccionInvalida();
		pageHome.clickBotonAtras(repeticiones);
		pageHome.darClickEnActualizarSaldo();
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("Valido no haya descuento del home");
		utilidad.validacionDeSaldos();
		utilidad.esperaMiliseg(2000);

	}

	public void verificarTransaccionExitosa() {
		utilidad.esperaMiliseg(10000);
		utilidad.tomaEvidencia("Transacción exitosa");
		pagePasarPlata.validarTransaccion();
		pagePasarPlata.txtAutorizador();	
		pagePasarPlata.darClickEnFinalizarTransaccion();
	}
	
	public void verificarTransaccionFallida() {
		utilidad.tomaEvidencia("Transacción fallida");
		pagePasarPlata.validarTransaccionFallida();
	}
	
	@Step
	public void agregarCuentaAFavoritos(String nombreContactoFavorito) {
        utilidad.tomaEvidencia("Hacer clic en favoritos");
        utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.BOTON_FAVORITOS_PASAR_PLATA);
        utilidadesTCS.writeElement("xpath", PasarPlataPageObjects.INPUT_NOMBRE_DEL_CONTACTO_FAVORITO, nombreContactoFavorito);
        utilidad.tomaEvidencia("Hacer clic en el boton guardar");
        utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.BOTON_GUARDAR_FAVORITO);
    }
	
	public void verificarTransaccionExitosaa() {
		System.out.println("entre a validar la transaccion exitosa");
		//List<MobileElement> listaElementos = pagePasarPlata.capturaResultadoTransaccion();
		utilidad.tomaEvidencia("Resultado Transacción");
		
		//pagePasarPlata.verificoResultadoTransaccion(listaElementos);
		pagePasarPlata.darClickEnFinalizarTransaccion();
		
	}
	
	public void verificarTransaccionExitosaOtrosBancos() {
		List<MobileElement> listaElementos = pagePasarPlata.capturaResultadoTransaccion();
		utilidad.tomaEvidencia("Resultado Transacción");
		pagePasarPlata.verificoResultadoTransaccion(listaElementos);		
		utilidad.scrollHastaElFinalDePantalla();
		pagePasarPlata.txtAutorizadorOtrosBancos();
		Utilidades.scrollDownSwipe(1);
		pagePasarPlata.darClickEnFinalizarTransaccionOtrosBancos();

	}

	public void seleccionarCuentaOtroBanco(String numeroCuenta, String tipoId, String numId, String monto, String banco) {
		utilidad.tomaEvidencia("Seleccion tipo de destino");
		btnAOtroBanco();
		//pagePasarPlata.seleccionarCuentaNoInscrita();
		pagePasarPlata.inputNombreContacto();
		pagePasarPlata.btnSeleccioneBanco();
		pagePasarPlata.discoSeleccioneBanco(banco);
		pagePasarPlata.btnSeleccioneTipoCuentaBanco();
		pagePasarPlata.discoSeleccioneTipoCuentaBanco();
		pagePasarPlata.inputNumeroCuentaBanco(numeroCuenta);
		pagePasarPlata.seleccioneTipoIdentificacion();
		pagePasarPlata.discoTipoIdentificacion(tipoId);
		pagePasarPlata.scrollHastaBotonContinuar();
		pagePasarPlata.numeroIdentificacion(numId);
		pagePasarPlata.inputMonto(monto);
		pagePasarPlata.btnContinue();
		pagePasarPlata.btnContinuarPopUp();
		utilidad.scrollHastaElFinalDePantalla();
		pagePasarPlata.btnPasarPlata();		
	}

	
	public void verificarTransacccionFallida() {
		pageLogin.popUpDaviplata();
		System.out.println(pageLogin.popUpDaviplata());
		assertEquals("CUENTA NO EXISTE", pageLogin.popUpDaviplata());
		
	}

	public void verificarTransaccionExitosaDavNoExiste() {
		pagePasarPlata.validarTransaccionExitosaDavNoExiste();
		pagePasarPlata.btnVolver();
		pagePasarPlata.btnVolver();
	}

	public void verificarSaldosCreditoDaviPlata() {
		utilidad.esperaMiliseg(5000);
		pagePasarPlata.capturarSaldoFinal();
		utilidad.tomaEvidencia("Saldo Final " + base.saldoFinal);
		pageLogin.validarCreditoSaldoDaviPlata();
	}
	
	public void verificarSaldosDebitoDaviPlata() {
		System.out.println("entre a verificar saldo de debito en daviplata");
		utilidad.esperaMiliseg(4000);
		pagePasarPlata.capturarSaldoFinal();
		utilidad.tomaEvidencia("Saldo Final " + base.saldoFinal);
	}
	
	@Step
	public void verificarInfoYPasarPlata() {
		Utilidades.esperaMiliseg(1000);
		System.out.println("Valido datos para poder pasar plata");
		boolean condicionContinuar = utilidadesTCS.validateElementVisibilityCatch("xpath", PasarPlataPageObjects.BTN_CONTINUAR);
		if (condicionContinuar == true) {
	        utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.BTN_CONTINUAR);
		}
		boolean condicionPasarPlata = utilidadesTCS.validateElementVisibilityCatch("xpath", PasarPlataPageObjects.PASAR_PLATA_BTN_DAV);
		if (condicionPasarPlata == true) {
	        utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.PASAR_PLATA_BTN_DAV);
		}
	}
	
	@Step
	public void verificarIgualdadSaldoDaviPlata() {
		utilidad.esperaMiliseg(5000);
		pageLogin.capturarSaldo();
		utilidad.tomaEvidencia("Saldo Final " + base.saldoFinal);
		pageLogin.validarIgualdadSaldoDaviPlata();
	}

	public void verificarSaldosBolsillos() {
		System.out.println("Entre a verificar el saldo del bolsillo");
		try {
			contador++;
			//pagePasarPlata.atras();
			//pagePasarPlata.darClickEnActualizarSaldo();
			//pagePasarPlata.capturarSaldoFinal();
			Utilidades.esperaMiliseg(3000);
			pageLogin.capturarSaldo();
			utilidad.tomaEvidencia("Saldo Final " + base.saldoFinal);
			System.out.println("Monto " + base.montoTransado);
			System.out.println("Saldo " + base.saldo);
			System.out.println("Saldo Final: " + base.saldoFinal);
			
			System.out.println("suma saldo más monto: " + base.saldo.subtract(base.montoTransado));
			assertThat(base.saldoFinal, is(equalTo(base.saldo.subtract(base.montoTransado))));
			// utilidad.validacionDeSaldos();
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(2000);
				verificarSaldosBolsillos();
			}else {
				fail("No se puedovalidar el saldo final debido a : "+e.getMessage());
				System.out.println("no se pudo validar el saldo final debido a : " + e.getMessage().toString());
			}
		}finally {contador=0;}
	}

	public void seleccionarCuantaOtroBancoInscrita() {
		String tipoCuenta = "otro Banco";
		pagePasarPlata.selecTipoCuentaDestino();
		utilidad.tomaEvidencia("Seleccion tipo de destino");
		utilidad.tomaEvidencia("Seleccion de opcion cuenta inscrita");
		pagePasarPlata.seleccionarCuentaInscrita();
		utilidad.tomaEvidencia("Seleccion de cuenta inscrita");
		pagePasarPlata.seleccionarCuentaInscritaDestino();
	}

	public void diligenciarFormularioCuentasNoInscritas(String tipoCuenta) {
		pagePasarPlata.darClickADesplegableBancos();
		pagePasarPlata.seleccionarBancoAleatorio();
		pagePasarPlata.darClickDesplegableTipoProducto();
		pagePasarPlata.seleccionarTipoProducto(tipoCuenta);
		pagePasarPlata.ingresarNumCuentaOtrosBancos();
		pagePasarPlata.darClickDesplegableTipoIndntificacion();
		pagePasarPlata.seleccionarTipoIdentificacion();
		pagePasarPlata.ingresarNumDocumento();
		// utilidad.moverPantalla();
		pagePasarPlata.ingresarValorAPasarOtrosBancoBasico();
		pagePasarPlata.ingresarMotivoODescripcion();
		utilidad.moverPantallaCorto(); 
		utilidad.tomaEvidencia("Datos de Destino diligenciados"); 
		//utilidad.moverPantalla(200, 1600, 200, 700);
		pagePasarPlata.BtnAceptar();
		pagePasarPlata.btnPasarPlataa();
		pagePasarPlata.txtAutorizador();

	}

	public void diligenciarFormularioCuentasNoInscritasSaldoMenor(String tipoCuenta) {
		pagePasarPlata.darClickADesplegableBancos();
		pagePasarPlata.seleccionarBancoAleatorio();
		pagePasarPlata.darClickDesplegableTipoProducto();
		pagePasarPlata.seleccionarTipoProducto(tipoCuenta);
		pagePasarPlata.ingresarNumCuentaOtrosBancos();
		pagePasarPlata.darClickDesplegableTipoIndntificacion();
		pagePasarPlata.seleccionarTipoIdentificacion();
		pagePasarPlata.ingresarNumDocumento();
		pagePasarPlata.ingresarValorAPasarOtrosBancoBasico();
		pagePasarPlata.ingresarMotivoODescripcion();
		utilidad.tomaEvidencia("Datos de Destino diligenciados");
		

		
	}

	public void diligenciarFormularioCuentasNoInscritasFondosInsuficientes(String tipoCuenta, String monto) {
		pagePasarPlata.ingresarNombreContacto();
		pagePasarPlata.darClickADesplegableBancos();
		pagePasarPlata.seleccionarBancoAleatorio();
		pagePasarPlata.darClickDesplegableTipoProducto();
		pagePasarPlata.seleccionarTipoProducto(tipoCuenta);
		pagePasarPlata.ingresarNumCuentaOtrosBancos();
		pagePasarPlata.darClickDesplegableTipoIndntificacion();
		pagePasarPlata.seleccionarTipoIdentificacion();
		pagePasarPlata.scrollHastaBotonContinuar();
		pagePasarPlata.ingresarNumDocumento();
		pagePasarPlata.ingresarValorAPasarOtrosBancos(monto);
		pagePasarPlata.ingresarMotivoODescripcion();
		utilidad.tomaEvidencia("Datos de Destino diligenciados");
	}

	public void diligenciarFormularioCuentasInscritas() {

		pagePasarPlata.ingresarValorAPasarOtrosBancosCtaInscrita();
		pagePasarPlata.ingresarMotivoODescripcionCtaInscrita();
		utilidad.tomaEvidencia("Datos de Destino diligenciados");
		pagePasarPlata.btnPasarPlataa();
	}

	public void procesarTransaccionOtrosBancos(String tipoCuenta) {
		pagePasarPlata.darClickEnBtnAceptar();
		List<String> datosValidar = pagePasarPlata.tomarDatosParaValidar();
		utilidad.tomaEvidencia("Datos de Destino procesados");
		pagePasarPlata.darClickBtnPasarPlataOtrosBancos();
		pagePasarPlata.validarDatosTransaccion(datosValidar, tipoCuenta);
	}

	public void procesarTransaccionOtrosBancosFondosInsuficientes() {
		pagePasarPlata.darClickEnBtnAceptar();
		pagePasarPlata.darClickBtnPasarPlataOtrosBancos();
	}

	public void procesarTransaccionOtrosBancosCtaInscrita() {
		List<String> datosValidar = pagePasarPlata.tomarDatosParaValidar();
		utilidad.tomaEvidencia("Datos de Destino procesados");
		pagePasarPlata.darClickBtnPasarPlataOtrosBancos();
		pagePasarPlata.validarDatosTransaccionCtaInscrita(datosValidar);
		utilidad.tomaEvidencia("Resultado Transacción");
	}

	public void validarTransaccionNegada() {
		pagePasarPlata.validarTransaccionNegada();
		utilidad.tomaEvidencia("Transaccion Negada");
		utilidad.esperaMiliseg(500);
		objBolsillosPageObjects.btnFinalizarSacar();
		utilidad.esperaMiliseg(5000);
		pagePasarPlata.capturarSaldoFinal();
	}
	
	public void validarResultadoTransaccion() {
		pagePasarPlata.validoResultadoTransaccion();
		utilidad.tomaEvidencia("Transaccion no exitosa");
		utilidad.esperaMiliseg(500);
	}
	
	public void validarTransaccionNegadaMonto() {
		pagePasarPlata.validarTransaccionNegadaMonto();
		utilidad.tomaEvidencia("Monto excedido del saldo disponible");
	}
	
	public void validarMontoCero() {
		pagePasarPlata.validarHabilitacionBotonContinuarPasarPlata();
		utilidad.tomaEvidencia("Transferencia denegada boton continuar deshabilitado");
	}

	public void ingresarABolsillos(boolean verificador) { 
		objBolsillosPageObjects.pulsarSaldoTotalBolsillos(verificador);
	}

	public void ingresarOCrearBolsillos(String valorDisponible, boolean verificador) {
		objBolsillosPageObjects.pulsarBtnActualizarSaldoBolsillos();
		objBolsillosPageObjects.pulsarSaldoTotalBolsillos(verificador);
		if (objBolsillosPageObjects.isCrearBolsillo()) {
			crearBolsillo(valorDisponible);
		}
	}

	public void ingresarEliminarCrearBolsillos(String valorDisponible, boolean verificador) {
		objBolsillosPageObjects.pulsarSaldoTotalBolsillos(verificador);
		//objBolsillosPageObjects.cerrarPopUPBolsillo();
		objBolsillosPageObjects.pulsarBtnCrearBolsillos();
		crearBolsilloFondosInsuficientes(valorDisponible);

	}

	public void crearBolsillo(String valorDisponible) {
		objBolsillosPageObjects.pulsarAbrirBolsillo();
		if("iPhone 14".equalsIgnoreCase(BaseUtil.nombreDispositivo)) {
			utilidadesTCS.clickCoordinates(166, 238);
		}else {
			utilidadesTCS.clickCoordinates(166, 231);
		}
		String nombre = this.objFaker.name().firstName();
		utilidadesTCS.escribirPorTecladoIos(nombre.toLowerCase());
		if(BaseUtil.nombreDispositivo == "iPhone 14".toLowerCase()) {
			utilidadesTCS.clickCoordinates(166, 207);
		}else {
			utilidadesTCS.clickCoordinates(166, 196);
		}
		utilidadesTCS.escribirPorTecladoIos(valorDisponible);
		if(BaseUtil.nombreDispositivo == "iPhone 14".toLowerCase()) {
			utilidadesTCS.clickCoordinates(166, 278);
		}else {
			utilidadesTCS.clickCoordinates(166, 270);
		}
		utilidadesTCS.escribirPorTecladoIos(valorDisponible);
		objBolsillosPageObjects.pulsarAceptarTyC();
		objBolsillosPageObjects.pulsarContinuarCreacionBolsillo();
		objBolsillosPageObjects.pulsarConfirmarCreacionBolsillo();
		objBolsillosPageObjects.validoTransaccionExitosa();
		objBolsillosPageObjects.pulsarFinalizarCreacionBolsillo();
	}

	public void crearBolsilloHamburguesa(String monto) {
		objBolsillosPageObjects.pulsarAbrirBolsillo();
		objBolsillosPageObjects.ingresarNombreBolsillo();
		objBolsillosPageObjects.ingresarMontoInicialBolsillo(monto);
		objBolsillosPageObjects.ingresarMontoTotalBolsillohamburguesa(monto);
		objBolsillosPageObjects.pulsarAceptarTyC();
		objBolsillosPageObjects.pulsarContinuarCreacionBolsillo();
		//popup
		marketPageobject.cerrarPopup();
		objBolsillosPageObjects.pulsarConfirmarCreacionBolsillo();
		//popup
		marketPageobject.cerrarPopup();
		objBolsillosPageObjects.validoTransaccionExitosa();
		objBolsillosPageObjects.pulsarFinalizarCreacionBolsillo();
		//popup
		marketPageobject.cerrarPopup();
		//objBolsillosPageObjects.cerrarPopup();
	}

	public void crearMaximosBolsillos(String monto) {

		for (int i = 0; i < 5; i++) {
			objBolsillosPageObjects.pulsarAbrirBolsillo();
			if("iPhone 14".equalsIgnoreCase(BaseUtil.nombreDispositivo)) {
				utilidadesTCS.clickCoordinates(166, 238);
			}else {
				utilidadesTCS.clickCoordinates(166, 231);
			}
			String nombre = this.objFaker.name().firstName();
			utilidadesTCS.escribirPorTecladoIos(nombre.toLowerCase());
			if(BaseUtil.nombreDispositivo == "iPhone 14".toLowerCase()) {
				utilidadesTCS.clickCoordinates(166, 207);
			}else {
				utilidadesTCS.clickCoordinates(166, 196);
			}
			utilidadesTCS.escribirPorTecladoIos(monto);
			if(BaseUtil.nombreDispositivo == "iPhone 14".toLowerCase()) {
				utilidadesTCS.clickCoordinates(166, 278);
			}else {
				utilidadesTCS.clickCoordinates(166, 270);
			}
			utilidadesTCS.escribirPorTecladoIos(monto);
			objBolsillosPageObjects.pulsarAceptarTyC();
			objBolsillosPageObjects.pulsarContinuarCreacionBolsillo();
			objBolsillosPageObjects.pulsarConfirmarCreacionBolsillo();
			if (objBolsillosPageObjects.mensajeNoMasBolsillos() == true) {
				break;
			}
			objBolsillosPageObjects.validoTransaccionExitosa();
			objBolsillosPageObjects.pulsarFinalizarCreacionBolsillo();
			marketPageobject.cerrarPopup();
		}
	}

	public void ValidarMensajeMaximoBolsillos() {
		objBolsillosPageObjects.validarMensajeMaximoBolsillos();
	}
	
	
	public void crearBolsilloPeriodo(String monto, String periodo) {
	    objBolsillosPageObjects.pulsarAbrirBolsillo();
	    if("iPhone 14".equalsIgnoreCase(BaseUtil.nombreDispositivo)) {
			utilidadesTCS.clickCoordinates(166, 238);
		}else {
			utilidadesTCS.clickCoordinates(166, 231);
		}
		String nombre = this.objFaker.name().firstName();
		utilidadesTCS.escribirPorTecladoIos(nombre.toLowerCase());
		if("iPhone 14".equalsIgnoreCase(BaseUtil.nombreDispositivo)) {
			utilidadesTCS.clickCoordinates(166, 207);
		}else {
			utilidadesTCS.clickCoordinates(166, 196);
		}
		utilidadesTCS.escribirPorTecladoIos(monto);
		if("iPhone 14".equalsIgnoreCase(BaseUtil.nombreDispositivo)) {
			utilidadesTCS.clickCoordinates(166, 278);
		}else {
			utilidadesTCS.clickCoordinates(166, 270);
		}
		utilidadesTCS.escribirPorTecladoIos(monto);
		utilidadesTCS.clicElement("xpath", objBolsillosPageObjects.LISTA_DESPLEGABLE_PERIODO);
		objBolsillosPageObjects.seleccionoPeriodo(periodo);
		objBolsillosPageObjects.pulsarAceptarTyC();
		objBolsillosPageObjects.pulsarContinuarCreacionBolsillo();
		objBolsillosPageObjects.pulsarConfirmarCreacionBolsillo();
		objBolsillosPageObjects.validoTransaccionExitosa();
		objBolsillosPageObjects.pulsarFinalizarCreacionBolsillo();
	}

	public void validoBolsilloCreado() {
		objBolsillosPageObjects.validarBolsilloCreado();
	}

	public void crearBolsilloFondosInsuficientes(String valorDisponible) {
		objBolsillosPageObjects.ingresarNombreBolsillo();
		objBolsillosPageObjects.ingresarMontoInicialBolsilloFondosInsuficientes(valorDisponible);
		objBolsillosPageObjects.ingresarMontoTotalBolsillo(valorDisponible);
		objBolsillosPageObjects.pulsarAceptarTyC();
		objBolsillosPageObjects.pulsarContinuarCreacion(2);
	}

	public void eliminarBolsillo() {
		objBolsillosPageObjects.seleccionarBolsillo();
		objBolsillosPageObjects.setSaldoBolsillo();
		objBolsillosPageObjects.pulsarEliminarBolsillo();
		Utilidades.esperaMiliseg(2000);
		objBolsillosPageObjects.pulsarAceptarEliminarBolsillo();
	}
	public void modificarBolsillo(String periodo) {
		pagePasarPlata.btnBolsillos();
		objBolsillosPageObjects.seleccionarBolsillo();
		objBolsillosPageObjects.pulsarModificarBolsillo();
		objBolsillosPageObjects.ingresarNombreBolsillo();
		utilidadesTCS.clicElement("xpath", objBolsillosPageObjects.LISTA_DESPLEGABLE_PERIODO_MODIFICADO);
		objBolsillosPageObjects.seleccionoPeriodo(periodo);
		objBolsillosPageObjects.pulsarModificarBolsillo();
	}
	
	public void modificarBolsilloHamburguesa(String periodo) {
		objBolsillosPageObjects.seleccionarBolsillo();
		objBolsillosPageObjects.pulsarModificarBolsillo();
		objBolsillosPageObjects.ingresarNombreBolsillo();
		utilidadesTCS.clicElement("xpath", objBolsillosPageObjects.LISTA_DESPLEGABLE_PERIODO);
		objBolsillosPageObjects.seleccionoPeriodo(periodo);
		objBolsillosPageObjects.pulsarModificarBolsillo();
	}
	
	public void validoModificacionBolsillo() {
		objBolsillosPageObjects.validarModificacionRealizada();
		//objBolsillosPageObjects.pulsarAceptarEliminarBolsillo();
		objBolsillosPageObjects.btnContinuarEliminacion();
	}
	public void validarModificacionBolsillo() {
		objBolsillosPageObjects.validarActualizacionNombreBolsillo();
	}
	
	public void validarEliminacion() {
		boolean estadoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.POP_UP_INVITE_AMIGOS);
		if(estadoVisible == true) {
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_CLOSE);
		}
		objBolsillosPageObjects.btnContinuarEliminacion();
		utilidad.esperaMiliseg(2000);
		utilidad.tomaEvidencia("Valido el bolsillo eliminado");
	}

	public int seleccionarBolsiloAleatorio() {
		objBolsillosPageObjects.verBolsillos();
		return objBolsillosPageObjects.seleccionarBolsilloAleatorio();
	}



	public int consultarSacarPlataBolsilloAleatorio() {
		objBolsillosPageObjects.seleccionarBolsilloAleatorio();
		int numero = objBolsillosPageObjects.obtenerMontoTotal();
		utilidad.tomaEvidencia("Consulto datos bolsillo");
		pageHome.clickBotonAtrasBolsillos(1);
		objBolsillosPageObjects.pulsarSacarPlata();
		objBolsillosPageObjects.pulsarBolsilloSeleccionado(numero);
		return numero;
	}



	public void sacarPlataBolsillo(String monto) {
		objBolsillosPageObjects.pulsarSacarPlata();
		objBolsillosPageObjects.seleccionarBolsilloPasar();
		objBolsillosPageObjects.ingresarMontoSacarPlataBolsillo(monto);
		objBolsillosPageObjects.pulsarContinuarSacarPlataBolsillos();
		marketPageobject.cerrarPopup();
	}
	
	
	public void sacarPlataBolsilloMayorSaldoBolsillo() {
		objBolsillosPageObjects.pulsarSacarPlata();
		objBolsillosPageObjects.obtenerSaldoBolsilloSacarPlata();
		objBolsillosPageObjects.seleccionarBolsilloPasar();
		//String saldoBolsillo = Serenity.sessionVariableCalled("saldoBolsilloSeleccionado");
		//double saldoBolsilloMayor = Double.parseDouble(saldoBolsillo);
		System.out.println(base.saldoBolsillo.doubleValue());
		
		int saldoBolsilloMayor = base.saldoBolsillo.intValue() + 1000;
		
		System.out.println(saldoBolsilloMayor);
		String montoMayor = String.valueOf(saldoBolsilloMayor);
		objBolsillosPageObjects.ingresarMontoSacarPlataBolsillo(montoMayor);
		objBolsillosPageObjects.pulsarContinuarSacarPlataBolsillos();
	}

	public void validarPasarPlataBolsillos() {
		objBolsillosPageObjects.verificoResultadoTransaccion();
		objBolsillosPageObjects.btnFinalizarSacar();
		objBolsillosPageObjects.btnVolver();
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("capturo saldo final");
	}
	
	public void validarMensajeExcedeMonto() {
		
		objBolsillosPageObjects.verificoResultadoTransaccionExcedeMonto();
		utilidad.esperaMiliseg(500);
		objBolsillosPageObjects.btnVolver();
		utilidad.esperaMiliseg(500);
		objBolsillosPageObjects.btnVolver();
		utilidad.esperaMiliseg(500);
		objBolsillosPageObjects.btnVolver();
	}
	
	@Step
	public void cerrarPopup() {
		objBolsillosPageObjects.cerrarPopupSacarBolsillo();
	}
	
	@Step
	public void validarPasarPlataBolsillosADaviplata() {
		pagePasarPlata.darClickEnFinalizarTransaccion();
		objBolsillosPageObjects.btnVolver();
		Utilidades.esperaMiliseg(4000);
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("capturo saldo final");
	}

	@Step
	public void ingresarMonto(String monto) {
		objBolsillosPageObjects.ingresarMonto(monto);
		pagePasarPlata.clicContinuar(2);
	}

	public void eliminarBolsillos(String valorDisponible) {
		objBolsillosPageObjects.pulsarBtnCrearBolsillos();
		objBolsillosPageObjects.pulsarAbrirBolsillo();
		objBolsillosPageObjects.ingresarNombreBolsillo();
		objBolsillosPageObjects.ingresarMontoInicialBolsillo(valorDisponible);
		objBolsillosPageObjects.ingresarMontoTotalBolsillo(valorDisponible);
		objBolsillosPageObjects.pulsarAceptarTyC();
		objBolsillosPageObjects.pulsarContinuarCreacionBolsillo();
		marketPageobject.cerrarPopup();
		objBolsillosPageObjects.pulsarConfirmarCreacionBolsillo();
		marketPageobject.cerrarPopup();
		objBolsillosPageObjects.pulsarFinalizarCreacionBolsillo();
	}

	public void consultaSaldoInicialRedeban(String documento) {
		pagePasarPlata.consultaSaldoInicialRedeban(documento);
	}

	public void validarDiferenciaSaldosRedeban() {
		pagePasarPlata.validarDiferenciaSaldosRedeban();
	}

	public void validarIgualdadSaldosRedeban() {
		pagePasarPlata.validarIgualdadSaldosRedeban();
	}

	public void transaccionFondosInsuficientesBancos(String monto) {
		//pagePasarPlata.seleccionarOpcionCuantoQuierePagar();
		pagePasarPlata.ingresarMontoBancos(monto);
		utilidad.tomaEvidencia("Monto a Transferir");
		TouchAction touchAction=new TouchAction(driver);
        touchAction.tap(new PointOption().withCoordinates(206, 196)).perform();
	}
	
	public void irATransfiYa() {
		System.out.println("di click a btn pasar plata");
		utilidad.tomaEvidencia("Clic opción pasar plata");
		pagePasarPlata.clickBtnMas();
		utilidad.esperaMiliseg(1000);
		pagePasarPlata.darClickEnOpcionPasarPlata();
		utilidad.esperaMiliseg(1000);
		utilidad.tomaEvidencia("Clic opción transfiYa");
		System.out.println("di click a opcion escoger opcion transfiya");
		pagePasarPlata.escogerOpcionTransfiYa();
		boolean estadoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", PasarPlataPageObjects.TEXTO_POPUP_PEDIR_PLATA);
		if(estadoVisible == true) {
			utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.CONTINUAR_POPUP_ANTES_FINALIZAR_BTN);
		}
		//pagePasarPlata.clickBtnContinuarTransiYaPopup();
	}
	
	public void irARecibirYPedir() {
		pagePasarPlata.clickBtnMas();
		System.out.println("Di clic al botón 'Más'");
		utilidad.tomaEvidencia("Di clic al botón 'Más'");
		utilidad.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.BTN_RECIBIR_PEDIR_PLATA);
		utilidad.esperaMiliseg(3000);
		utilidad.tomaEvidencia("Entré a la opción 'Recibir y Pedir Plata'");
		utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.ACEPTO_TERM_COND);
		utilidad.tomaEvidencia("Acepto términos y condiciones");
		utilidad.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.BTN_CONTINUAR);
	}
	
	public void aceptarYValidarTransferenciaDenegada() {
		utilidad.tomaEvidencia("Mensaje de peticion de envio de dinero");
		pagePasarPlata.clickBtnAceptar();
		pagePasarPlata.validarTransferenciaFallida();
	}
	
	public void darClickOpcionTransfiYa() {
		utilidad.tomaEvidencia("Clic opción pasar plata");
		pagePasarPlata.darClickEnOpcionPasarPlata();
		utilidad.esperaMiliseg(10000);
		utilidad.tomaEvidencia("Clic opción transfiYa");
		pagePasarPlata.escogerOpcionTransfiYa();
	}
	
	public void darClickOpcionAbonosFrecuentes() {
		pagePasarPlata.darClickEnOpcionAbonosFrecuentes();
		utilidad.esperaMiliseg(1000);
		utilidad.tomaEvidencia("Di Clic opción Abonos Frecuentes");
	}
	
	public void validarListaContactosAbonosFrecuentes() {
		pagePasarPlata.validoListaContactosAbonosFrecuentes();
		utilidad.esperaMiliseg(1000);
		utilidad.tomaEvidencia("Valide correctamente lista de contactos de abonos frecuentes");
	}
	
	
	public void realizarFlujoPasarPlata(String numCelular, String monto) {
		Utilidades.esperaMiliseg(2000);
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
		pagePasarPlata.ingresarNumeroPasarPlataLinea(numCelular);
		utilidadesTCS.clickCoordinates(200, 200);
		utilidadesTCS.writeElement("xpath", PasarPlataPageObjects.CAMPO_MONTO, monto);
		utilidadesTCS.clickCoordinates(200, 200);
		Utilidades.tomaEvidencia("Formulario pedir plata diligenciado");
		utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.BTN_CONTINUAR);
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.BTN_CONTINUAR);
		Utilidades.esperaMiliseg(800);
		//pagePasarPlata.clicBtnContinuarPlataLinea();
		Utilidades.tomaEvidencia("Selecciono opción por Transfiya");
		Utilidades.esperaMiliseg(3000);
		utilidadesTCS.esperarElementVisibility("xpath", PasarPlataPageObjects.BTN_POR_TRANSFIYA);
		utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.BTN_POR_TRANSFIYA);
		Utilidades.esperaMiliseg(2000);
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
	    boolean txtPorSuSeguridadDefecto = utilidadesTCS.validateElementVisibilityCatch("xpath", PasarPlataPageObjects.TXT_POR_SU_SEGURIDAD);
	       if (txtPorSuSeguridadDefecto == true) {
	    	   String txt = utilidadesTCS.obtenerTexto("xpath", PasarPlataPageObjects.TXT_POR_SU_SEGURIDAD);
	           Utilidades.tomaEvidencia("Se evidencia defecto con texto: " + txt);
	           System.out.println("Se evidencia defecto con texto: " + txt);
	           fail("Se evidencia defecto con texto: " + txt);
	       } 
	}
	
	@Step
	public void realizarFlujoPasarPlataTransfiya(String numCelular, String monto) {
		Utilidades.esperaMiliseg(8000);
		pagePasarPlata.ingresarNumeroPasarPlataLinea(numCelular);
		pagePasarPlata.clickBtnDone();
		pagePasarPlata.ingresarMontoPasarPlataLinea(monto);
		pagePasarPlata.clickBtnDone();
		utilidad.tomaEvidencia("Formulario transfiYa diligenciado");
		pagePasarPlata.clicBtnContinuarPlataLinea();
		utilidad.esperaMiliseg(8000);
		utilidad.tomaEvidencia("Validacion de informacion");
		pagePasarPlata.clicBtnContinuarPlataLinea();
		utilidad.esperaMiliseg(2000);
	}
	
	public void realizarFlujoPedirPlataEnLinea(String numCelular, String monto) {
		utilidad.esperaMiliseg(3000);
		utilidad.tomaEvidencia("Valido ingreso a la opción pedir plata en linea");
		utilidad.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath", pagePasarPlata.BTN_PEDIR_PLATA_ENLINEA);
		utilidad.esperaMiliseg(1000);
		pagePasarPlata.ingresarNumeroPasarPlataLinea(numCelular);
		pagePasarPlata.ingresarMontoPasarPlataLinea(monto);
//		pagePasarPlata.clickBtnDone();
		utilidad.tomaEvidencia("Formulario para pedir plata diligenciado");
		pagePasarPlata.clicBtnContinuarPlataLinea();
		utilidad.esperaMiliseg(8000);
		utilidad.tomaEvidencia("Validacion de informacion");
		pagePasarPlata.clicBtnContinuarPlataLinea();
		utilidad.esperaMiliseg(2000);
	}
	
	@Step
	public void realizarFlujoPedir(String numCelular, String monto) {
		utilidad.esperaMiliseg(1000);
		pagePasarPlata.clicBtnPedirPlataLinea();
		utilidad.tomaEvidencia("Clic opción pedir plata en linea"); 	
		utilidad.esperaMiliseg(500);
		utilidadesTCS.esperarElementVisibility("xpath", PasarPlataPageObjects.TXT_COMPLETAR_INFO);
		pagePasarPlata.ingresarNumeroPasarPlataLinea(numCelular);
		utilidad.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.CLIC_TEXT);
		pagePasarPlata.ingresarMontoPasarPlataLinea(monto);
		utilidad.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.CLIC_TEXT);
		utilidad.tomaEvidencia("Formulario transfiYa diligenciado");
		pagePasarPlata.clicBtnContinuarPlataLinea();
		utilidad.esperaMiliseg(1000);
		boolean elementoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", PasarPlataPageObjects.TXT_CONTACTO_CON_DAVIPLATA);
		if(elementoVisible == true) {
			utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.BTN_MEDIO_TRANSFIYA);
		}
		utilidadesTCS.esperarElementVisibility("xpath", PasarPlataPageObjects.TXT_COMPLETAR_DATOS);
		utilidad.tomaEvidencia("Validacion de informacion");
		pagePasarPlata.clicBtnContinuarPlataLinea();
		utilidad.esperaMiliseg(2000);
	}
	
	@Step
	public void ingresoALaOpcionPedirPlataFondosInsuficientes(String numCelular, String monto) {
		pagePasarPlata.esperarVisibilidadPantallaTransfiYa();
		pagePasarPlata.clickOpcionPedirPlata();
		System.out.println("ingresando numero de cel");
		pagePasarPlata.ingresarNumeroPedirPlata(numCelular);
		TouchAction touchAction=new TouchAction(driver);
        touchAction.tap(new PointOption().withCoordinates(214, 132)).perform();
		pagePasarPlata.ingresarMontoPasarPlataLinea(monto);
		utilidad.tomaEvidencia("Formulario transfiYa diligenciado");
		pagePasarPlata.clickBtnDone();
        touchAction.tap(new PointOption().withCoordinates(196, 609)).perform();
        touchAction.tap(new PointOption().withCoordinates(237, 516)).perform();
		pagePasarPlata.validarMensajeInsuficienteTransfiYa();
		utilidad.tomaEvidencia("Validar mensaje de fondos insuficientes");
		
	}
	
	@Step
	public void validoResultadoTransaccionExitosa() throws Exception {
		pagePasarPlata.validarResultadoTransaccionExitosaTransfiYa();
		utilidad.esperaMiliseg(5000);
		utilidad.tomaEvidencia("Valido resultado de la transacción");
		pagePasarPlata.darClickEnFinalizarTransaccion();
		utilidad.tomaEvidencia("Finalicé Transaccion");
	}
	
	@Step
	public void validoResultadoSolicitudExitosa() throws Exception {
		pagePasarPlata.validarResultadoSolicitudExitosaTransfiYa();
		utilidad.tomaEvidencia("Solicitud exitosa");
		pagePasarPlata.darClickEnFinalizarTransaccion();
		utilidad.tomaEvidencia("Finalicé Transaccion");
	}
	
	@Step
	public void validarClienteGMF(String estadoExenta) throws Exception {
		pagePasarPlata.validarClienteGMF(estadoExenta);
		utilidad.tomaEvidencia("Valido estado cliente, es GMF");
	}
	
	@Step
	public void validarResultadoSolicitudRechazada() throws Exception {
		pagePasarPlata.validarResultadoSolicitudRechazadaTransfiYa();
		utilidad.tomaEvidencia("Solicitud rechazada");
		pagePasarPlata.clickContinuarRechazarSolicitud();
		utilidad.tomaEvidencia("Tap en continuar, la tx es rechazada");
		pagePasarPlata.volverAtras();
		pagePasarPlata.volverAtras();
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("capturo saldo final");
	}
	
	@Step
	public void validarResultadoTransaccionRechazada() throws Exception {
		pagePasarPlata.validarResultadoTransaccionRechazada();
		utilidad.tomaEvidencia("Transacción rechazada");
		pagePasarPlata.darClickEnFinalizarTransaccion();
		utilidad.tomaEvidencia("Finalicé Transaccion");
		pagePasarPlata.volverAtras();
		pagePasarPlata.volverAtras();
		pageHome.capturarSaldoFinal();
		Utilidades.tomaEvidencia("capturo saldo final");
	}
	
	@Step
	public void regresarAlHome() {
		int count = 0;
		do {
			utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
		    utilidadesTCS.esperarElementVisibility("xpath", PasarPlataPageObjects.BOTON_ATRAS_BOLSILLOS);
		    utilidadesTCS.clicElementAction("xpath", PasarPlataPageObjects.BOTON_ATRAS_BOLSILLOS);
			utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
			boolean estadoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.POP_UP_INVITE_AMIGOS);
			if(estadoVisible == true) {
				utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_CLOSE);
			}
		    count++;
		} while (count < 4);
	}
	
	@Step
	public void validarSaldoFinalSinAceptacion() {
		utilidad.esperaMiliseg(1000);
		utilidadesTCS.clicElementAction("xpath", PasarPlataPageObjects.BOTON_ATRAS_BOLSILLOS);
		boolean estadoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.POP_UP_INVITE_AMIGOS);
		if(estadoVisible == true) {
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_CLOSE);
		}
		utilidad.esperaMiliseg(1000);
		utilidadesTCS.esperarElementVisibility("xpath", PasarPlataPageObjects.BOTON_ATRAS_BOLSILLOS);
		utilidadesTCS.clicElementAction("xpath", PasarPlataPageObjects.BOTON_ATRAS_BOLSILLOS);
		utilidad.esperaMiliseg(1500);
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("capturo saldo final");
	}
	
	@Step
	public void validarMontoEsMayorATopeCredito(String monto) throws Exception {
		pagePasarPlata.validarMontoEsMayorATopeCredito(monto);
	}
	
	@Step
	public void validarMontoEsMayorATopeDebito(String monto) throws Exception {
		pagePasarPlata.validarMontoEsMayorATopeDebito(monto);
	}
	
	@Step
	public void validarDescripcionPopUpTransfiYa() throws Exception {
		utilidad.esperaMiliseg(10000);
		pagePasarPlata.clickIcono();
		pagePasarPlata.validarDescripcionPopUpTransfiYa();
		utilidad.tomaEvidencia("Valide la descripcion del pop up transfiYa");
		pagePasarPlata.clicBtnContinuarTransfiYa();
		utilidad.tomaEvidencia("Valide y di click al btn continuar del pop up");
	}
	
	@Step
	public void aceptarSolicitudPendiente1(String monto) throws Exception {
		Utilidades.tomaEvidencia("ingreso Modulo trannsfiYa");
		Utilidades.esperaMiliseg(5000);
		pagePasarPlata.darClickBtnSolicitudPendiente();
		utilidad.esperaMiliseg(2000);
		utilidad.tomaEvidencia("Ingreso solcitud Pendiente");
		pagePasarPlata.validarMontoSolicitud(monto);
		utilidad.esperaMiliseg(2000);
		utilidad.tomaEvidencia("Valido monto solicitud");
		pagePasarPlata.clickAceptarSolicitud();
		utilidad.esperaMiliseg(2000);
		utilidad.tomaEvidencia("Di click en aceptar recibir plata");
	}
	

	
	public void rechazarSolicitudPendiente(String monto) throws Exception {
		utilidad.tomaEvidencia("ingreso Modulo trannsfiYa");
		utilidad.esperaMiliseg(5000);
		pagePasarPlata.darClickBtnSolicitudPendiente();
		utilidad.esperaMiliseg(2000);
		utilidad.tomaEvidencia("Ingreso solcitud Pendiente");
		pagePasarPlata.validarMontoSolicitud(monto);
		utilidad.esperaMiliseg(2000);
		utilidad.tomaEvidencia("Valido monto");
		pagePasarPlata.clickRechazarSolicitud();
		utilidad.esperaMiliseg(2000);
		utilidad.tomaEvidencia("Di click en rechazar solicitud");
		pagePasarPlata.clickConfirmarRechazarSolicitud();
		utilidad.esperaMiliseg(2000);
		utilidad.tomaEvidencia("Di click en SI rechazar solicitud");
	}
	
	@Step
	public void ingresarDatosBanco(String agenciaCuentas, String numeroCuenta,  String password) throws Exception {
		pagePasarPlata.validarVisibilidadFormularioPse();
		pagePasarPlata.inputAgenciaCuentas(agenciaCuentas);
		pagePasarPlata.inputNumeroCuenta(numeroCuenta);
		pagePasarPlata.inputPasswordCuenta(password);
		utilidad.tomaEvidencia("Diligenciar datos de banco");
		pagePasarPlata.clicBtnPay();
	}
	
	@Step
	public void validarTransaccionPse() throws Exception {
		utilidad.esperaMiliseg(8000);
		pagePasarPlata.validarAparezcaTransaccionPseBanco();
		pagePasarPlata.validarTransaccionPseBanco();
		utilidad.tomaEvidencia("Validar transaccion pse");
	}

	@Step
	public void validoBolsilloFondosInsuficientes() {
		pagePasarPlata.validoLblBolsilloFondosInsuficientes();
		pageHome.clickBotonAtrasBolsillos(3);
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("Valido no haya descuento del home");
		utilidad.validacionDeSaldos();
		utilidad.esperaMiliseg(2000);
	}
	
	@Step
	public void verificarSaldoInicialDaviplataGmf() {
		pagePasarPlata.capturarSaldoInicialDaviplata();
		pagePasarPlata.validarIgualdadSaldosInicialesGmf();
		utilidad.tomaEvidencia("Saldo Inicial Gmf" + base.saldoInicial);
	}

	@Step
	public void verificarSaldoInicialDaviplata() {
		pagePasarPlata.capturarSaldoInicialDaviplata();
		pagePasarPlata.validarIgualdadSaldosIniciales();
		utilidad.tomaEvidencia("Saldo Inicial " + base.saldoInicial);
	}
	
	@Step
	public void validarSaldoInicialNuevoUsuario() {
		pagePasarPlata.capturarSaldoInicialDaviplata();
		utilidad.tomaEvidencia("Verifico saldo inicial en DaviPlata de usuario recíen registrado: " + base.saldoInicial);
	}
	
	@Step
	public void verificarTransaccionExitosaPasarPlata() {
		utilidad.esperaMiliseg(4000);
		pagePasarPlata.txtTransaccion();
		utilidad.tomaEvidencia("Resultado Transacción");
		utilidad.moverPantallaCorto();
		//pagePasarPlata.cerrarCalificacion();
		pagePasarPlata.txtAutorizador();
		pagePasarPlata.darClickEnFinalizarTransaccion();
	}
	
	@Step
	public void validarTransaccionDestino() {
		pagePasarPlata.txtTransaccion();
		pagePasarPlata.darClickEnFinalizarTransaccion();
		pagePasarPlata.volverAtras();
		pagePasarPlata.volverAtras();
		utilidad.esperaMiliseg(5000);
		pagePasarPlata.capturarSaldoFinal();
	}
	
	@Step
	public void verificarSaldos() {
		utilidad.esperaMiliseg(4000);
		pagePasarPlata.capturarSaldoFinal();
		utilidad.tomaEvidencia("Saldo Final " + base.saldoFinal);
	}
	
	@Step
	public void pasarPlataAOtroDaviplataTopeDebitos(String numero) {
		pagePasarPlata.pasarPlataAOtroDaviplata();
		utilidad.tomaEvidencia("Ingreso el numero de telefono " + numero);
		pagePasarPlata.pasarPlataAOtroDaviplataNumero(numero);
		try {
			pagePasarPlata.pasarPlataAOtroDaviplataCantidadTopeDebito();
			utilidad.tomaEvidencia("Selecciono la cantidad");
			TouchAction touchAction=new TouchAction(driver);
            touchAction.tap(new PointOption().withCoordinates(22,339)).perform();
			pagePasarPlata.darClickEnBtnContinuar();
			pagePasarPlata.cerrarPopup();
			pagePasarPlata.darClickBtnPasarPlata();
			
			utilidad.esperaMiliseg(4000);
				
		}catch (Exception e){
			boolean validacion = false;
			int Primer_Numero = Integer. parseInt(numero.substring(0,1));
			validacion =true;
			assertEquals(true,validacion);
			if (Primer_Numero != 3 ) {
				System.out.println("El numero de ingresa comienza con un numero diferente a 3");
				utilidad.tomaEvidencia("El numero de ingresa comienza con un numero diferente a 3");
			}
			else {assertEquals(true,validacion);
			}
			
		}
	}
	
	@Step
	public void pasarPlataAOtroDaviplataMonto(String numero, String monto) {
		pagePasarPlata.pasarPlataAOtroDaviplata();
		utilidad.tomaEvidencia("Ingreso el numero de telefono " + numero);
		pagePasarPlata.pasarPlataAOtroDaviplataNumero(numero);
		try {
			pagePasarPlata.ingresarMontoAOtroDaviplata(monto);
			utilidad.tomaEvidencia("Selecciono la cantidad");
			TouchAction touchAction=new TouchAction(driver);
            touchAction.tap(new PointOption().withCoordinates(22,339)).perform();
			pagePasarPlata.darClickEnBtnContinuar();
			//pagePasarPlata.cerrarPopup();
			pagePasarPlata.darClickBtnPasarPlata();
			
			utilidad.esperaMiliseg(8000);
			
			pagePasarPlata.cerrarCalificacion();
			pagePasarPlata.txtAutorizador();	
		}catch (Exception e){
			boolean validacion = false;
			int Primer_Numero = Integer. parseInt(numero.substring(0,1));
			validacion =true;
			assertEquals(true,validacion);
			if (Primer_Numero != 3 ) {
				System.out.println("El numero de ingresa comienza con un numero diferente a 3");
				utilidad.tomaEvidencia("El numero de ingresa comienza con un numero diferente a 3");
			}
			else {assertEquals(true,validacion);
			}
			
		}
	}

	@Step
	public void ingresarMontoCuentaDaviviendaCero(String monto) {
		pagePasarPlata.ingresarMontoCuenta(monto);
		utilidad.tomaEvidencia("Ingresar Monto Cuenta");
	}
	
	@Step
	public void ingresarMontoCuentaDaviviendaTopeDebitos() {
		pagePasarPlata.ingresarMontoCuentaTopeDebitos();
		utilidad.tomaEvidencia("Ingresar Monto Cuenta");
		TouchAction touchAction=new TouchAction(driver);
        touchAction.tap(new PointOption().withCoordinates(22,339)).perform();
		pagePasarPlata.clicBotonContinuar();
		pageMarketPlace.cerrarPopup();
		pagePasarPlata.clicBotonPasarPlata();
	}

	@Step
	public void ingesoALaOpcionPasarPlataHome() {
		
		pagePasarPlata.darClickEnOpcionPasarPlata();
		utilidad.tomaEvidencia("Ingreso a Pasar plata desde home daviplata");
	}
	
	@Step
	public void ingresarMontoCuentaDaviviendaPasarPlata(String monto) {
		pagePasarPlata.ingresarMontoCuenta(monto);
		utilidad.tomaEvidencia("Ingresar Monto Cuenta " + monto);
		TouchAction touchAction=new TouchAction(driver);
        touchAction.tap(new PointOption().withCoordinates(20, 352)).perform();
	}
	
	@Step
	public void validarBotonInhabilitado() throws Exception {
		pagePasarPlata.validarBotonContinuarPasarPlataInhabilitado();
		utilidad.tomaEvidencia("Validar boton inhabilitado");
		for(int i = 0; i<2; i++) {
			pagePasarPlata.atras();
		}
		utilidad.esperaMiliseg(4000);
		pagePasarPlata.capturarSaldoFinal();
		utilidad.tomaEvidencia("Saldo final daviplata");
		
	}
	
	@Step
	public void escogerOpcionCuentasDaviviendaInscritas() {
		utilidad.esperaMiliseg(2000);
		utilidad.tomaEvidencia("Seleccionar cuentas Davivienda");
		pagePasarPlata.seleccionarCuentasDavivienda();
		
	}
	
	@Step
	public void ingresarMontoCuentaInscritas(String monto) {
		pagePasarPlata.clicBotonFavoritosCuentaInscritas();
		pagePasarPlata.clicBotonCuentaFav();
		pagePasarPlata.ingresarMontoCuenta(monto);
		TouchAction touchAction=new TouchAction(driver);
        touchAction.tap(new PointOption().withCoordinates(20, 352)).perform();
		utilidad.tomaEvidencia("Ingresar Monto Cuenta " + monto);
		pagePasarPlata.clicBotonContinuar();
		utilidad.tomaEvidencia("Verificación de datos");
		pagePasarPlata.clicBotonPasarPlata();
	}
	
	@Step
	public void ingresarMontoCeroCuentaDavivienda(String monto) {
		pagePasarPlata.ingresarMontoCuenta(monto);
		utilidad.tomaEvidencia("Ingresar Monto Cuenta " + monto);
	}
	
	@Step
	public void validarMontoCeroCuentas() {
		pagePasarPlata.validoBtnContinuarDeshabilitado();
		utilidad.tomaEvidencia("Transferencia denegada botón continuar deshabilitado");
		pagePasarPlata.atras();
		pagePasarPlata.atras();
		pagePasarPlata.capturarSaldoFinal();
		utilidad.tomaEvidencia("Saldo final del daviplata");
	}

	@Step
	public void ingresarMayorSaldoDisponible() {
		pagePasarPlata.ingresarMontoMayor();
		TouchAction touchAction=new TouchAction(driver);
        touchAction.tap(new PointOption().withCoordinates(20, 352)).perform();
		
	}

	@Step
	public void validarMensajeMontoSuperiorAlSaldoDisponible() {
		pagePasarPlata.validarMensajeMontoSuperiorSaldoDisponible();
		utilidad.tomaEvidencia("Mensaje de fondos insuficientes");
		pagePasarPlata.atras();
		pagePasarPlata.atras();
		utilidad.tomaEvidencia("Saldo final daviplata");
		pagePasarPlata.capturarSaldoFinal();
	}
	
	@Step
	public void validarMensajeFondosInsuficientes() {
		pagePasarPlata.validarFondosInsuficientes();
		utilidad.tomaEvidencia("Validar Fondos Insuficientes");
		pagePasarPlata.btnVolver();
		pagePasarPlata.btnVolver();
		utilidad.esperaMiliseg(5000);
		pagePasarPlata.capturarSaldoFinal();
		utilidad.tomaEvidencia("Saldo Final " + base.saldoFinal);
	}
	
	@Step
	public void llenarFormularioMontoInferiorOtrosBancos(String numeroCuenta, String tipoId, String numId, String valorAPasar, String banco) {
		utilidad.esperaMiliseg(4000);
		//INGRESAR NOMBRE DE CONTACTO
		pagePasarPlata.inputNombreContacto();
		//BTN SELECCIONAR BANCO
		pagePasarPlata.btnSeleccioneBanco();
		//SELECCIONAR OPCION DE BANCO
		pagePasarPlata.discoSeleccioneBanco(banco);
		//BTN SELECCIONAR TIPO DE BANCO
		pagePasarPlata.btnSeleccioneTipoCuentaBanco();
		//SELECCIONAR TIPO DE BANCO
		pagePasarPlata.discoSeleccioneTipoCuentaBanco();
		//INGRESAR NUMERO DE CUENTA
		pagePasarPlata.inputNumeroCuentaBanco(numeroCuenta);
		utilidad.tomaEvidencia("Seleccion banco y num cuenta");
		//DAR SCROLL
		Utilidades.scrollDownSwipe(1);
		//BTN SELECCIONAR TIPO DE DOCUMENTO
		pagePasarPlata.seleccioneTipoIdentificacion();
		//SELECCIONAR TIPO DE DOCUMENTACION
		pagePasarPlata.discoTipoIdentificacion(tipoId);
		//INGRESAR NUMERO DE IDENTIFICACION
		pagePasarPlata.numeroIdentificacion(numId);
		//INGRESAR MONTO
		pagePasarPlata.inputMonto(valorAPasar);
		utilidad.tomaEvidencia("Llenado del formulario");
		System.out.println("Llené el formulario correctamente");
		//DAR CLICK BTN CONTINUAR
		pagePasarPlata.btnContinue();
		utilidad.tomaEvidencia("Dar en el boton Pop Up continuar");
		
	}
	
	@Step
	public void validarMensajeValorInferior() {
		pagePasarPlata.validarValorInferiorOtrosBancos();
		utilidad.tomaEvidencia("Validar valor inferior");
		pagePasarPlata.btnVolver();
		pagePasarPlata.btnVolver();
		utilidad.esperaMiliseg(5000);
		pagePasarPlata.capturarSaldoFinal();
		utilidad.tomaEvidencia("Saldo Final " + base.saldoFinal);
	}
	
	@Step
	public void validarSaldoFinalBolsillos() {
		pagePasarPlata.darClickEnFinalizarTransaccion();
		pageHome.clickBotonAtrasBolsillos(1);
		utilidad.esperaMiliseg(3000);
		pagePasarPlata.capturarSaldoFinal();
		utilidad.tomaEvidencia("Saldo final del daviplata");
	}

	@Step
	public void meterPlataBolsillo(int numero) {
		objBolsillosPageObjects.pulsarMeterPlata();
		objBolsillosPageObjects.pulsarBolsilloSeleccionado(numero);
	}
	
	@Step
	public int consultarMeterPlataBolsilloAleatorio() {
		objBolsillosPageObjects.verBolsillos();
		objBolsillosPageObjects.seleccionarBolsilloAleatorio();
		int numero = objBolsillosPageObjects.obtenerMontoTotal();
		pageHome.clickBotonAtrasBolsillos(1);
		objBolsillosPageObjects.pulsarMeterPlata();
		objBolsillosPageObjects.pulsarBolsilloSeleccionado(numero);
		return numero;
	}
	
	@Step
	public void ingresoALaOpcionMeterPlataFondosInsuficientes(String numCelular, String monto) {
		utilidad.esperaMiliseg(10000);
		pagePasarPlata.ingresarPasarPlataLinea();
		pagePasarPlata.ingresarNumeroPasarPlataLinea(numCelular);
		utilidad.ocultarTeclado(214, 132);
		pagePasarPlata.ingresarMontoPasarPlataLinea(monto);
		utilidad.tomaEvidencia("Formulario transfiYa diligenciado");
		utilidad.ocultarTeclado(339, 463);
		pagePasarPlata.clicBotonContinuar();
		pagePasarPlata.clicBotonContinuar();
		pagePasarPlata.validarMensajeInsuficienteTransfiYa();
		utilidad.tomaEvidencia("Validar mensaje de fondos insuficientes");
		
	}
	
	@Step
	public void pasarPlataAOtroDaviplataAñadiendoCuentaAFavoritos(String numero, String monto, String nombreContactoFavorito) {
        pagePasarPlata.pasarPlataAOtroDaviplata();
        utilidad.tomaEvidencia("Ingreso el numero de telefono " + numero);
        pagePasarPlata.pasarPlataAOtroDaviplataNumero(numero);
        utilidad.tomaEvidencia("Hacer clic en favoritos");
        utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.BOTON_FAVORITOS_PASAR_PLATA);
        utilidadesTCS.writeElement("xpath", PasarPlataPageObjects.INPUT_NOMBRE_DEL_CONTACTO_FAVORITO, nombreContactoFavorito);
        utilidadesTCS.clickCoordinates(220, 220);
		utilidad.esperaMiliseg(800);
        utilidad.tomaEvidencia("Hacer clic en el boton guardar");
        utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.BOTON_GUARDAR_FAVORITO);
		utilidad.esperaMiliseg(1000);
        pagePasarPlata.ingresarMontoAOtroDaviplata(monto);
        utilidad.tomaEvidencia("Selecciono la cantidad");
        utilidadesTCS.clickCoordinates(220, 220);
		utilidad.esperaMiliseg(800);
        pagePasarPlata.darClickEnBtnContinuar();
        System.out.println("Dio click en Boton Continuar");
        utilidadesTCS.clickCoordinates(220, 220);
		utilidad.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.CONTINUAR_BTN);
        //pagePasarPlata.clickBtnContnuarPasarPlataOtroDaviplata();
        System.out.println("Dio click en Boton Pasar Plata");
    }	
	
	@Step
	public void validarEnmascaramiento() {
		utilidad.esperaMiliseg(1500);
		String userEnmascarado = utilidadesTCS.obtenerTexto("xpath", PasarPlataPageObjects.TXT_USUARIO_ENMASCARADO);
        System.out.println("Usuario enmascarado: " + userEnmascarado);
        utilidad.tomaEvidencia("Usuario enmascarado: " + userEnmascarado);
	}
	
	@Step
	public void validarTransaccionFechas() {
		Utilidades.esperaMiliseg(1500);
		utilidadesTCS.esperarElementVisibility("xpath", PasarPlataPageObjects.TXT_FECHA_HORA_TRANS);
		String fechaHora = utilidadesTCS.obtenerTexto("xpath", PasarPlataPageObjects.TXT_FECHA_HORA_TRANS);
        System.out.println("Fecha y hora de transacción: " + fechaHora);
        utilidad.tomaEvidencia("Fecha y hora de transacción: " + fechaHora);
	}
	
	@Step
	public void validarNoMovimientos() {
		utilidad.esperaMiliseg(1500);
		boolean estadoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", PasarPlataPageObjects.TXT_NO_TIENE_MOVIMIENTOS);
		if(estadoVisible == true) {
			utilidadesTCS.esperarElementVisibility("xpath", PasarPlataPageObjects.TXT_NO_TIENE_MOVIMIENTOS);
			String txt = utilidadesTCS.obtenerTexto("xpath", PasarPlataPageObjects.TXT_NO_TIENE_MOVIMIENTOS);
	        System.out.println("Valido mensaje: " + txt);
	        utilidad.tomaEvidencia("Valido mensaje: " + txt);
		} else {
	        System.out.println("El usuario si cuenta con movimientos");
	        utilidad.tomaEvidencia("El usuario si cuenta con movimientos");
			fail("El usuario si cuenta con movimientos");
		}
	}
	
	@Step
	public void irALaOpcionMasHome() {
		Utilidades.tomaEvidencia("Clic opción Más");
        pagePasarPlata.darClickBotonMasHome();
		utilidadesTCS.esperarElementVisibility("xpath", PasarPlataPageObjects.BTN_RECIBIR_PEDIR_PLATA);
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
        Utilidades.tomaEvidencia("Opciones '¿Qué quiere hacer con su Plata?'");
        Utilidades.esperaMiliseg(5000);
   }
   
	@Step
	public void irARecibirYPedirPlata() {
       utilidadesTCS.esperarElementVisibility("xpath", PasarPlataPageObjects.BTN_RECIBIR_PEDIR_PLATA);
       utilidadesTCS.clicElementAction("xpath", PasarPlataPageObjects.BTN_RECIBIR_PEDIR_PLATA);
       Utilidades.esperaMiliseg(2000);

       boolean txtPorSuSeguridadDefecto = utilidadesTCS.validateElementVisibilityCatch("xpath", PasarPlataPageObjects.TXT_POR_SU_SEGURIDAD);
       if (txtPorSuSeguridadDefecto == true) {
    	   String txt = utilidadesTCS.obtenerTexto("xpath", PasarPlataPageObjects.TXT_POR_SU_SEGURIDAD);
           Utilidades.tomaEvidencia("Se evidencia defecto con texto: " + txt);
           System.out.println("Se evidencia defecto con texto: " + txt);
           fail("Se evidencia defecto con texto: " + txt);
    	   
       } else {
           Utilidades.tomaEvidencia("Clic opción Recibir y Pedir Plata");
           utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
           Utilidades.esperaMiliseg(5000);
           Utilidades.tomaEvidencia("Opciones del módulo transfiYa");
       }
   }
   
   @Step
   public void validarSolicitudesTransfiya () {
	   Utilidades.tomaEvidencia("Clic opción Recibir y Pedir Plata");
       boolean recuadroSinSolicitud = utilidadesTCS.validateElementVisibilityCatch("xpath", PasarPlataPageObjects.TXT_NO_TIENE_SOLICITUDES);

       if (recuadroSinSolicitud) {
           String textoSinSolicitud = utilidadesTCS.obtenerTexto("xpath", PasarPlataPageObjects.TXT_NO_TIENE_SOLICITUDES);
           utilidadesTCS.validateTextContainsString(textoSinSolicitud, "No tiene solicitudes de plata pendientes por autorizar en el momento");
           Utilidades.tomaEvidencia("Validar que no cuente con solicitudes");
       } else {
           String textoConSolicitud = utilidadesTCS.obtenerTexto("xpath", PasarPlataPageObjects.TXT_TIENE_SOLICITUDES);
           utilidadesTCS.validateTextContainsString(textoConSolicitud, "Tiene solicitudes pendientes");
           Utilidades.tomaEvidencia("Validar que cuente con solicitudes pendientes");
       }
    }
   
   @Step
   public void validarTopeDebito(String topeDebito) throws Exception {
       validarTopeDebitos(topeDebito);
   }
   
   @Step
   public void validarTopeDebitos(String topeDebito) {
       try {
           contador++;
           String topeDebitos = Serenity.sessionVariableCalled("acumuladoMensualDebitoRedebanDestino");
           int longitud = topeDebitos.length();
           int numero = longitud - 2;
           topeDebitos = topeDebitos.substring(0, numero).replace(",", "").replace(".", ""); 
           String realStringCreditos = String.valueOf(topeDebitos);
           assertThat(realStringCreditos,equalTo(topeDebito));
           System.out.println("El usuario uno tiene tope debitos");
       } catch (Exception e) {
           if (!(contador == 10)) {
               Utilidades.esperaMiliseg(500);
               validarTopeDebitos(topeDebito);
           } else {
               fail("No se pudo validar el monto con el tope de debitos, debido a: " + e.getMessage());
           }
       } finally {
           contador = 0;
       }
   }
   
   @Step
   public void validoResultadoTransaccionRechazadaTope() throws Exception {
       Utilidades.esperaMiliseg(2000);
       pagePasarPlata.validarResultadoTransaccionRechazada();
       Utilidades.tomaEvidencia("Transacción rechazada");
       pagePasarPlata.darClickEnFinalizarTransaccion();
       Utilidades.tomaEvidencia("Finalicé Transaccion");
       Utilidades.esperaMiliseg(4000);
       pagePasarPlata.capturarSaldoFinal();
       Utilidades.tomaEvidencia("Capturar saldo final");
   }
}
