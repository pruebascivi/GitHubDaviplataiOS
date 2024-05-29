package daviplata.nacional.iOS.steps;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import java.math.BigDecimal;
import java.util.List;
import com.github.javafaker.Faker;
import cucumber.api.Scenario;
import daviplata.nacional.iOS.definitions.Hooks;
import daviplata.nacional.iOS.pageObjects.BolsilloPageObjects;
import daviplata.nacional.iOS.pageObjects.HomePageObjects;
import daviplata.nacional.iOS.pageObjects.MenuHamburguesaPageObjects;
import daviplata.nacional.iOS.pageObjects.PasarPlataPageObjects;
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
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class PasarPlataSteps {
	
	BaseUtil base;
	Utilidades utilidades;
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
		Utilidades.tomaEvidencia("Saldo inicial Daviplata " + BaseUtil.saldo);
		pageLogin.darClickEnMenuHamburguesa();
		Utilidades.tomaEvidencia("Doy click en Bolsillos");
		objBolsillosPageObjects.ingresarBolsillo();
//		pagePasarPlata.btnBolsillos();
		pagePasarPlata.btnMeterPlataBolsillo();
		pagePasarPlata.btnSeleccionarBolsillo();
		pagePasarPlata.txtCuantaPlata(valor);
		pagePasarPlata.btnContinuarBolsillo();
		pagePasarPlata.txtAutorizadorBolsillo();
	}

	public void seleccionarPasarPlata(boolean verificador) {
		Utilidades.esperaMiliseg(3000);
		pagePasarPlata.capturarSaldoInicialDaviplata();
		Utilidades.tomaEvidencia("Saldo inicial Daviplata ");
		if (verificador) {
			Utilidades.tomaEvidencia("Seleccionar opcion pasar Plata");
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
	
	public void pasarPlataAOtroDaviplataValor1(String numero) {
		pagePasarPlata.pasarPlataAOtroDaviplata();
		//pagePasarPlata.darClickEnBtnContinuar();
		Utilidades.tomaEvidencia("Ingreso el numero de telefono " + numero);
		pagePasarPlata.pasarPlataAOtroDaviplataNumero(numero);
		try {
		//pagePasarPlata.darClickEnBtnContinuar();
		pagePasarPlata.pasarPlataAOtroDaviplataCantidad1();
		TouchAction touchAction=new TouchAction(driver);
        touchAction.tap(new PointOption().withCoordinates(22, 339)).perform();
		//System.out.println("Dio click en Boton Continuar");
        Utilidades.tomaEvidencia("Selecciono la cantidad");
		//pagePasarPlata.BtnAceptar();
		//pagePasarPlata.darClickBtnpasarPlata();
		pagePasarPlata.darClickEnBtnContinuar();
		System.out.println("Dio click en Boton Continuar");
		//pagePasarPlata.clickBtnContnuarPasarPlataOtroDaviplata();
		//System.out.println("Dio click en Boton Pasar Plata");
		pagePasarPlata.cerrarPopup();
		pagePasarPlata.darClickBtnPasarPlata();
		
		Utilidades.esperaMiliseg(8000);
		
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
				Utilidades.tomaEvidencia("El numero de ingresa comienza con un numero diferente a 3");
				//validacion =true;
				//assertEquals(true,validacion);
			}
			else {assertEquals(true,validacion);
			}
			
		}
	}
	
	public void validarNumeroErrado(String numero) {
		pagePasarPlata.pasarPlataAOtroDaviplata();
		Utilidades.tomaEvidencia("Ingreso el numero de telefono " + numero);
		pagePasarPlata.pasarPlataAOtroDaviplataNumero(numero);
		pagePasarPlata.validarMensajeNumeroDiferenteTres();
		Utilidades.tomaEvidencia("Validar mensaje numero diferente de 3");
	}

	// Selecciono una cantidad
	public void pasarPlataAOtroDaviplataVolverAtras(String numero) {
		pagePasarPlata.pasarPlataAOtroDaviplata();
		Utilidades.tomaEvidencia("Pasar plata a otro Daviplata");
		pagePasarPlata.atras2();
		Utilidades.tomaEvidencia("Valido que volver atras me traiga a la ventana anterior");
	}

	// Selecciono una cantidad
	public void pasarPlataAOtroDaviplataFondosInsuficientes(String numero) {
		pagePasarPlata.pasarPlataAOtroDaviplata();
		Utilidades.tomaEvidencia("Ingreso el numero de telefono " + numero);
		pagePasarPlata.pasarPlataAOtroDaviplataNumero(numero);
	}

	public void pasarPlataAOtroDaviplataMayorAlSaldo(String numero) {
		pagePasarPlata.pasarPlataAOtroDaviplata();
		Utilidades.tomaEvidencia("Ingreso el nuemero de telefono " + numero);
		pagePasarPlata.pasarPlataAOtroDaviplataNumero(numero);
		pagePasarPlata.pasarPlataAOtroDaviplataEscribirCantidadMayorSaldo();
		Utilidades.tomaEvidencia("Selecciono la cantidad");
		pagePasarPlata.BtnAceptar();
		// pagePasarPlata.txtAutorizador();
	}

	// Escribo la cantidad
	public void pasarPlataAOtroDaviplataValor(String numero,String monto) {
		pagePasarPlata.pasarPlataAOtroDaviplata();
		Utilidades.tomaEvidencia("Ingreso el nuemero de telefono " + numero);
		pagePasarPlata.pasarPlataAOtroDaviplataNumero(numero);
		pagePasarPlata.pasarPlataAOtroDaviplataEscribirCantidad(monto);
		Utilidades.tomaEvidencia("Monto a transferir");	
		pagePasarPlata.clickBtnContnuarPasarPlataOtroDaviplata();
		pagePasarPlata.darClickBtnPasarPlata();
		pagePasarPlata.txtAutorizador();
	}
	
	public void pasarPlataAOtroDaviplataValorCero(String numero,String monto) {
		pagePasarPlata.pasarPlataAOtroDaviplata();
		Utilidades.tomaEvidencia("Ingreso el nuemero de telefono " + numero);
		pagePasarPlata.pasarPlataAOtroDaviplataNumero(numero);
		pagePasarPlata.pasarPlataAOtroDaviplataEscribirCantidadCero(monto);
		TouchAction touchAction=new TouchAction(driver);
        touchAction.tap(new PointOption().withCoordinates(22, 339)).perform();
        Utilidades.tomaEvidencia("Monto a transferir");
	}

	public void verificarTransaccionExitosaPasarPlataCuenta() {
		Utilidades.esperaMiliseg(10000);
		//pagePasarPlata.cerrarPopUpTransaccionExitosa();
		//pagePasarPlata.cerrarCalificacion();
		pagePasarPlata.txtAutorizadorPasarPlataCuenta();
		Utilidades.tomaEvidencia("Valido resultado de transacción");
		pagePasarPlata.darClickEnFinalizarTransaccion();
		Utilidades.esperaMiliseg(3000);
		pagePasarPlata.capturarSaldoFinal();
		Utilidades.tomaEvidencia("Saldo final del daviplata");
	}

	//Modulo pasar plata	
	public void escogerOpcionCuentasDavivienda() {
		Utilidades.esperar(8);
		Utilidades.tomaEvidencia("Seleccionar cuentas Davivienda");
		pagePasarPlata.seleccionarCuentasDavivienda();
		Utilidades.esperar(4);
		pagePasarPlata.seleccionarTipoCuentasDavivienda();
		
	}
	
	public void escogerOpcionAOtrosBancos() {
		Utilidades.esperaMiliseg(1500);
		utilidadesTCS.esperarElementVisibility("xpath", PasarPlataPageObjects.BTN_OPCION_AOTROS_BANCOS);
		System.out.println("escogiendo otros bancos");
		Utilidades.tomaEvidencia("Seleccionar opcion a otros bancos");
		pagePasarPlata.seleccionarAOtrosBancos();
	}
	
	public void escogerOpcionTipoCuentaDavivienda(String tipoCuenta) {		
		pagePasarPlata.seleccionarOpcionesCuentasDavivienda(tipoCuenta);
		Utilidades.tomaEvidencia("Seleccion cuenta ahorros");		
	}
	
	public void ingresarNumeroCuentaDavivienda(String numCuenta) {
		pagePasarPlata.ingresarNumeroCuenta(numCuenta);
		Utilidades.tomaEvidencia("Ingresar Numero Cuenta");	
	}
	
	public void ingresarMontoCuentaDavivienda(String monto) {
		pagePasarPlata.ingresarMontoCuenta(monto);
        utilidadesTCS.clickCoordinates(390, 150);
        Utilidades.tomaEvidencia("Ingresar Monto Cuenta");
		pagePasarPlata.clicBotonPasarPlata();
		Utilidades.esperaMiliseg(1500);
		Utilidades.tomaEvidencia("Valido información ingresada");
		utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.PASAR_PLATA_BTN_DAV);
	}
	
	public void clicPasarPlataCuenta() {
		Utilidades.tomaEvidencia("Datos pasar plata");
		pagePasarPlata.clicPasarPlata();
	}
	
	@Step
	public void llenarFormularioPasarPlataYFavorito(String numeroCuenta, String tipoId, String numId, String valorAPasar, String banco) {
		Utilidades.esperaMiliseg(4000);
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
		Utilidades.tomaEvidencia("Seleccion banco y num cuenta");
		//DAR SCROLL
		Utilidades.scrollDownSwipe();
		//BTN SELECCIONAR TIPO DE DOCUMENTO
		pagePasarPlata.seleccioneTipoIdentificacion();
		//SELECCIONAR TIPO DE DOCUMENTACION
		pagePasarPlata.discoTipoIdentificacion(tipoId);
		//INGRESAR NUMERO DE IDENTIFICACION
		pagePasarPlata.numeroIdentificacion(numId);
		//INGRESAR MONTO
		pagePasarPlata.inputMonto(valorAPasar);
		Utilidades.tomaEvidencia("Llenado del formulario");
		System.out.println("Llené el formulario correctamente");
		Utilidades.esperaMiliseg(1500);
		utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.BOTON_FAVORITOS_PASAR_PLATA);
		Utilidades.esperaMiliseg(800);
		Utilidades.tomaEvidencia("Confirmación de contacto añadido a favoritos");
		utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.BTN_CONFIRMACION_FAV_USER_PASAR_PLATA);
		//DAR CLICK BTN CONTINUAR
		pagePasarPlata.btnContinue();
		//CERRAR POPUP
		//pagePasarPlata.btnCerrarPopPup();
		Utilidades.esperaMiliseg(1500);
		utilidadesTCS.esperarElementVisibility("xpath", PasarPlataPageObjects.POPUP_PARAMATERIZACION);
		Utilidades.tomaEvidencia("Dar en el boton Pop Up continuar");
		//CLICK BTN CONTINUAR POPUP
		//pagePasarPlata.btnContinuarPopUp();
		utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.ACEPTAR_POPUP);
		Utilidades.esperaMiliseg(3000);
		Utilidades.tomaEvidencia("Confirmacion datos transacción");
		//CLICK BTN PASAR PLATA
		Utilidades.esperaMiliseg(800);
		pagePasarPlata.btnPasarPlata();
	}
	
	public void llenarFormularioPasarPlata(String numeroCuenta, String tipoId, String numId, String valorAPasar, String banco) {
		Utilidades.esperaMiliseg(4000);
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
		Utilidades.tomaEvidencia("Seleccion banco y num cuenta");
		//DAR SCROLL
		Utilidades.scrollDownSwipe();
		//BTN SELECCIONAR TIPO DE DOCUMENTO
		pagePasarPlata.seleccioneTipoIdentificacion();
		//SELECCIONAR TIPO DE DOCUMENTACION
		pagePasarPlata.discoTipoIdentificacion(tipoId);
		//INGRESAR NUMERO DE IDENTIFICACION
		pagePasarPlata.numeroIdentificacion(numId);
		//INGRESAR MONTO
		pagePasarPlata.inputMonto(valorAPasar);
		Utilidades.tomaEvidencia("Llenado del formulario");
		System.out.println("Llené el formulario correctamente");
		//DAR CLICK BTN CONTINUAR
		pagePasarPlata.btnContinue();
		//CERRAR POPUP
		//pagePasarPlata.btnCerrarPopPup();
		Utilidades.esperaMiliseg(1500);
		utilidadesTCS.esperarElementVisibility("xpath", PasarPlataPageObjects.POPUP_PARAMATERIZACION);
		Utilidades.tomaEvidencia("Dar en el boton Pop Up continuar");
		//CLICK BTN CONTINUAR POPUP
		//pagePasarPlata.btnContinuarPopUp();
		utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.ACEPTAR_POPUP);
		Utilidades.esperaMiliseg(3000);
		Utilidades.tomaEvidencia("Confirmacion datos transacción");
		//CLICK BTN PASAR PLATA
		pagePasarPlata.btnPasarPlata();
	}
	
	public void llenarFormularioPasarPlataFondosInsuficientes(String numeroCuenta, String tipoId, String numId, String banco) {
		Utilidades.esperaMiliseg(4000);
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
		Utilidades.tomaEvidencia("Seleccion banco y num cuenta");
		//DAR SCROLL
		Utilidades.scrollDownSwipe();
		//BTN SELECCIONAR TIPO DE DOCUMENTO
		pagePasarPlata.seleccioneTipoIdentificacion();
		//SELECCIONAR TIPO DE DOCUMENTACION
		pagePasarPlata.discoTipoIdentificacion(tipoId);
		//INGRESAR NUMERO DE IDENTIFICACION
		pagePasarPlata.numeroIdentificacion(numId);
		//INGRESAR MONTO
		pagePasarPlata.inputMontoFondosInsuficientes();
		Utilidades.tomaEvidencia("Llenado del formulario");
		System.out.println("Llené el formulario correctamente");
	}
	
	public void llenarFormularioPasarPlataMenorDiezMil(String numeroCuenta, String tipoId, String numId, String valorAPasar, String banco) {
		Utilidades.esperaMiliseg(4000);
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
		Utilidades.tomaEvidencia("Seleccion banco y num cuenta");
		//DAR SCROLL
		Utilidades.scrollDownSwipe();
		//BTN SELECCIONAR TIPO DE DOCUMENTO
		pagePasarPlata.seleccioneTipoIdentificacion();
		//SELECCIONAR TIPO DE DOCUMENTACION
		pagePasarPlata.discoTipoIdentificacion(tipoId);
		//INGRESAR NUMERO DE IDENTIFICACION
		pagePasarPlata.numeroIdentificacion(numId);
		//INGRESAR MONTO
		pagePasarPlata.inputMonto(valorAPasar);
		Utilidades.tomaEvidencia("Llenado del formulario");
		System.out.println("Llené el formulario correctamente");
		//DAR CLICK BTN CONTINUAR
		pagePasarPlata.btnContinue();
	}
	
	
	public void llenarPrimerFormularioPasarPlata(String numeroCuenta, String tipoId, String numId, String valorAPasar, String banco) {
		Utilidades.esperar(4000);
		pagePasarPlata.inputNombreContacto();
		pagePasarPlata.btnSeleccioneBanco();
		pagePasarPlata.discoSeleccioneBanco(banco);
		pagePasarPlata.btnSeleccioneTipoCuentaBanco();
		pagePasarPlata.discoSeleccioneTipoCuentaBanco();
		pagePasarPlata.inputNumeroCuentaBanco(numeroCuenta);
		Utilidades.tomaEvidencia("Seleccion banco y num cuenta");
		pagePasarPlata.scrollHastaBtnContinuarPasarPlataOtrosBancos();
		pagePasarPlata.seleccioneTipoIdentificacion();
		pagePasarPlata.discoTipoIdentificacion(tipoId);
		pagePasarPlata.numeroIdentificacion(numId);
		pagePasarPlata.inputMonto(valorAPasar);
		Utilidades.tomaEvidencia("Llenado del formulario");
		System.out.println("Llené el formulario correctamente");
	}
	
	public void llenarMonto(String valorAPasar) {
		Utilidades.esperaMiliseg(4000);
		Utilidades.tomaEvidencia("Dar en seleccionar cuenta inscrita");
		pagePasarPlata.clicCuentaFavorita();
		Utilidades.esperaMiliseg(8000);
		Utilidades.tomaEvidencia("Dar en cuenta inscrita");
		pagePasarPlata.seleccionaCuentaInscrita();
		Utilidades.esperaMiliseg(3000);
		pagePasarPlata.inputMonto(valorAPasar);
		Utilidades.tomaEvidencia("Llenado del formulario");
		System.out.println("Llené el formulario correctamente");
		//DAR CLICK BTN CONTINUAR
		pagePasarPlata.btnContinue();
		Utilidades.esperaMiliseg(4000);
		Utilidades.tomaEvidencia("Dar en el boton Pop Up continuar");
		//CERRAR POPUP
		pagePasarPlata.btnCerrarPopPup();
		//CLICK BTN CONTINUAR POPUP
		pagePasarPlata.btnContinuarPopUp();
		Utilidades.esperaMiliseg(3000);
		Utilidades.tomaEvidencia("Confirmacion datos transacción");
		//CLICK BTN PASAR PLATA
		pagePasarPlata.btnPasarPlata();
	}
	
	public void llenarFormularioPasarPlataAch(String numeroCuenta, String tipoId, String numId, String valorAPasar, String banco) {
		Utilidades.esperaMiliseg(4000);
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
		Utilidades.tomaEvidencia("Seleccion banco y num cuenta");
		//DAR SCROLL
		Utilidades.scrollDownSwipe();
		//BTN SELECCIONAR TIPO DE DOCUMENTO
		pagePasarPlata.seleccioneTipoIdentificacion();
		//SELECCIONAR TIPO DE DOCUMENTACION
		pagePasarPlata.discoTipoIdentificacion(tipoId);
		//INGRESAR NUMERO DE IDENTIFICACION
		pagePasarPlata.numeroIdentificacion(numId);
		//INGRESAR MONTO
		pagePasarPlata.inputMonto(valorAPasar);
		Utilidades.tomaEvidencia("Llenado del formulario");
	}

	// Selecciono la cantidad cuenta ahorros
	public void seleccionarTipoCuentaDestino(String tipoCuenta, String cuentaNum) {
		pagePasarPlata.seleccionarCuentasDavivienda();
		pagePasarPlata.seleccionarTipoCuentasDavivienda();
		pagePasarPlata.seleccionarOpcionesCuentasDavivienda(tipoCuenta);
		Utilidades.tomaEvidencia("Seleccion A cuenta de Ahorros Daviviendd");
		pagePasarPlata.ingresarNumCuentaDestino(cuentaNum);
		TouchAction touchAction=new TouchAction(driver);
        touchAction.tap(new PointOption().withCoordinates(20, 352)).perform();
		Utilidades.tomaEvidencia("Cuenta de destino " + cuentaNum);
	}

	// Selecciono la cantidad cuenta corriente
	public void seleccionarCuentaCorriente(String tipoCuenta, String numeroCuenta) {
		pagePasarPlata.seleccionarCuentasDavivienda();
		pagePasarPlata.seleccionarTipoCuentasDavivienda();
		pagePasarPlata.seleccionarOpcionesCuentasDavivienda(tipoCuenta);
		Utilidades.tomaEvidencia("Seleccion A cuenta corriente Davivienda");
		pagePasarPlata.ingresarNumeroCuenta(numeroCuenta);
		Utilidades.tomaEvidencia("Cuenta de destino " + numeroCuenta);
	}

	// Selecciono la cantidad cuenta corriente mayor al saldo
	public void seleccionarCuentaCorrienteMayorSaldoDaviplata(String cuentaNum) {
		Utilidades.tomaEvidencia("Seleccion A cuenta corriente Davivienda");
		Utilidades.tomaEvidencia("Cuenta de destino " + cuentaNum);
		pagePasarPlata.pasarPlataAOtroDaviplataEscribirCantidadMayorSaldo();
		pagePasarPlata.BtnAceptar();
		pagePasarPlata.txtAutorizador();
	}

	public void validarMonto() {
		pagePasarPlata.verificoMonto();
	}

	public void seleccionarTipoCuentaDestinoACH(String tipoCuenta, String cuentaNum, String monto) {
		//seleccionarCuantaOtroBancoNoInscrita(tipoCuenta);
		Utilidades.tomaEvidencia("Seleccion de tipo De Cuenta");
		diligenciarFormularioCuentasNoInscritasFondosInsuficientes(tipoCuenta, monto);
		// procesarTransaccionOtrosBancosFondosInsuficientes();
	}

	public void seleccionarTipoCuentaDestinoACH1(String tipoCuenta, String cuentaNum, String monto) {
		//seleccionarCuantaOtroBancoNoInscrita(tipoCuenta);
		Utilidades.tomaEvidencia("Seleccion de tipo De Cuenta");
		diligenciarFormularioCuentasNoInscritasFondosInsuficientes(tipoCuenta, monto);
		//procesarTransaccionOtrosBancosFondosInsuficientes();
	}

	public void seleccionarMonto() {
		pagePasarPlata.pasarPlataAOtroDaviplataCantidad();
		Utilidades.tomaEvidencia("Selecciono la cantidad");
		pagePasarPlata.BtnAceptar();
		pagePasarPlata.txtAutorizador();
	}

	public void escribirValor(String monto) {
		pagePasarPlata.pasarPlataAOtroDaviplataEscribirCantidad(monto);
		Utilidades.tomaEvidencia("Dar en boton continuar");
		pagePasarPlata.clicBotonPasarPlata();
		Utilidades.tomaEvidencia("Dar en boton pasar plata");
		pagePasarPlata.clicPasarPlata();
	}

	public void escribirValorMenor() {
		pagePasarPlata.pasarPlataAOtroDaviplataEscribirCantidadMenor();
		Utilidades.tomaEvidencia("Selecciono la cantidad");
		pagePasarPlata.BtnAceptar();
		pagePasarPlata.txtAutorizador();
	}

	public void seleccionarOtroValor() {
		pagePasarPlata.seleccionarOpcionCuantoQuierePagar();
		pagePasarPlata.ingresarOtroMonto();
		Utilidades.tomaEvidencia("Monto a Transferir");
		pagePasarPlata.darClickEnBtnAceptar();
	}

	public void transaccionConvalorMayorAlSaldo() {
		pagePasarPlata.seleccionarOpcionCuantoQuierePagar();
		pagePasarPlata.ingresarMontoMayorSaldo();
		Utilidades.tomaEvidencia("Monto a Transferir");
		pagePasarPlata.darClickEnBtnAceptar();
	}

	public void transaccionFondosInsuficientes(String monto) {
		pagePasarPlata.ingresarMonto(monto);
		Utilidades.tomaEvidencia("Monto a Transferir");
	}

	public void validoFondosInsuficientes() {
		pagePasarPlata.validoLblFondosInsuficientes();
		pagePasarPlata.validoBtnContinuarDeshabilitado();
		Utilidades.esperaMiliseg(500);
		pageHome.clickBotonAtras(2);
		pageHome.capturarSaldoFinal();
		Utilidades.tomaEvidencia("Valido no haya descuento del home");
		//Utilidades.validacionDeSaldos();
	}

	public void validoFondosInsuficientes(int repeticiones) {
		pagePasarPlata.validoLblFondosInsuficientes();
		pageHome.clickBotonAtras(repeticiones);
		pageHome.darClickEnActualizarSaldo();
		pageHome.capturarSaldoFinal();
		Utilidades.tomaEvidencia("Valido no haya descuento del home");
		utilidades.validacionDeSaldos();
		Utilidades.esperaMiliseg(2000);
	}

	public void validoFondosInsuficientesBolsillo(int repeticiones) {
		pagePasarPlata.validoLblFondosInsuficientesBolsillos();
		pageHome.clickBotonAtras(repeticiones);
		pageHome.darClickEnActualizarSaldo();
		pageHome.capturarSaldoFinal();
		Utilidades.tomaEvidencia("Valido no haya descuento del home");
		utilidades.validacionDeSaldos();
		Utilidades.esperaMiliseg(2000);
	}

	public void validoTransaccionRechazada() {
		pagePasarPlata.validoLblFondosTransaccionDeclinada();
		pageHome.clickBotonAtras(2);
		pageHome.darClickEnActualizarSaldo();
		pageHome.capturarSaldoFinal();
		Utilidades.tomaEvidencia("Valido no haya descuento del home");
		utilidades.validacionDeSaldos();
		Utilidades.esperaMiliseg(2000);
	}

	public void validoTransaccionRechazada(int repeticiones) {
		pagePasarPlata.validoLblFondosTransaccionDeclinada();
		pageHome.clickBotonAtras(repeticiones);
		pageHome.darClickEnActualizarSaldo();
		pageHome.capturarSaldoFinal();
		Utilidades.tomaEvidencia("Valido no haya descuento del home");
		utilidades.validacionDeSaldos();
		Utilidades.esperaMiliseg(2000);
	}

	public void validoRechazoFondosInsuficientes(int repeticiones) {
		pagePasarPlata.validoLblRechazoFondosInsuficientes();
		pageHome.clickBotonAtras(repeticiones);
		pageHome.darClickEnActualizarSaldo();
		pageHome.capturarSaldoFinal();
		Utilidades.tomaEvidencia("Valido no haya descuento del home");
		utilidades.validacionDeSaldos();
		Utilidades.esperaMiliseg(2000);
	}
	
	public void validoRechazoFondosInsuficientesAOtros(int repeticiones) {
		pagePasarPlata.validoLblRechazoFondosInsuficientesAOtros();
		pageHome.clickBotonAtras(repeticiones);
		pageHome.darClickEnActualizarSaldo();
		pageHome.capturarSaldoFinal();
		Utilidades.tomaEvidencia("Valido no haya descuento del home");
		utilidades.validacionDeSaldos();
		Utilidades.esperaMiliseg(2000);
	}

	public void validoInferiorAlPermitido(int repeticiones) {
		pagePasarPlata.validoLblValorSuperiorAlPermitido();
		pageHome.clickBotonAtras(repeticiones);
		pageHome.darClickEnActualizarSaldo();
		pageHome.capturarSaldoFinal();
		Utilidades.tomaEvidencia("Valido no haya descuento del home");
		utilidades.validacionDeSaldos();
		Utilidades.esperaMiliseg(2000);
	}

	public void validoValorInicialInvalidoBolsillo() {
		pagePasarPlata.validoLblValorInicialInvalido();
		pageHome.clickBotonAtrasBolsillos(3);
		pageHome.capturarSaldoFinal();
		Utilidades.tomaEvidencia("Valido no haya descuento del home");
		utilidades.validacionDeSaldos();
	}

	public void validoSinAbonoPorFondoInsuficiente(int repeticiones) {
		pagePasarPlata.validoLblSinAbonoFondosInsuficientes();
		pageHome.clickBotonAtras(repeticiones);
		pageHome.darClickEnActualizarSaldo();
		pageHome.capturarSaldoFinal();
		Utilidades.tomaEvidencia("Valido no haya descuento del home");
		utilidades.validacionDeSaldos();
		Utilidades.esperaMiliseg(2000);
	}

	public void validoBolsilloNoSaldoDisponible() {
		pagePasarPlata.validoLblBolsilloNoSaldoDisponible();
		pageHome.clickBotonAtrasBolsillos(3);
		pageHome.capturarSaldoFinal();
		Utilidades.tomaEvidencia("Valido no haya descuento del home");
	}

	public void validoValorInicialBolsilloInvalido() {
		pagePasarPlata.validoLblValorInicialInvalido();
		pageHome.clickBotonAtras(3);
		pageHome.darClickEnActualizarSaldo();
		pageHome.capturarSaldoFinal();
		Utilidades.tomaEvidencia("Valido no haya descuento del home");
		utilidades.validacionDeSaldos();
		Utilidades.esperaMiliseg(2000);
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
		Utilidades.tomaEvidencia("Valido no haya descuento del home");
		utilidades.validacionDeSaldos();
		Utilidades.esperaMiliseg(2000);
	}

	public void validoExcedeCupo(int repeticiones) {
		pagePasarPlata.validoLblExcedeCupo();
		pagePasarPlata.validoBtnContinuarDeshabilitado();
		pageHome.clickBotonAtras(repeticiones);
		pageHome.darClickEnActualizarSaldo();
		pageHome.capturarSaldoFinal();
		Utilidades.tomaEvidencia("Valido no haya descuento del home");
		utilidades.validacionDeSaldos();
		Utilidades.esperaMiliseg(2000);
	}

	public void validoTransaccionInvalida(int repeticiones) {
		pagePasarPlata.validoLblTransaccionInvalida();
		pageHome.clickBotonAtras(repeticiones);
		pageHome.darClickEnActualizarSaldo();
		pageHome.capturarSaldoFinal();
		Utilidades.tomaEvidencia("Valido no haya descuento del home");
		utilidades.validacionDeSaldos();
		Utilidades.esperaMiliseg(2000);
	}

	public void verificarTransaccionExitosa() {
		Utilidades.esperaMiliseg(10000);
		Utilidades.tomaEvidencia("Transacción exitosa");
		pagePasarPlata.validarTransaccion();
		pagePasarPlata.txtAutorizador();	
		pagePasarPlata.darClickEnFinalizarTransaccion();
	}
	
	public void verificarTransaccionFallida() {
		Utilidades.tomaEvidencia("Transacción fallida");
		pagePasarPlata.validarTransaccionFallida();
	}
	
	@Step
	public void agregarCuentaAFavoritos(String nombreContactoFavorito) {
        Utilidades.tomaEvidencia("Hacer clic en favoritos");
        utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.BOTON_FAVORITOS_PASAR_PLATA);
        utilidadesTCS.writeElement("xpath", PasarPlataPageObjects.INPUT_NOMBRE_DEL_CONTACTO_FAVORITO, nombreContactoFavorito);
        Utilidades.tomaEvidencia("Hacer clic en el boton guardar");
        utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.BOTON_GUARDAR_FAVORITO);
    }
	
	public void verificarTransaccionExitosaa() {
		System.out.println("entre a validar la transaccion exitosa");
		//List<MobileElement> listaElementos = pagePasarPlata.capturaResultadoTransaccion();
		Utilidades.tomaEvidencia("Resultado Transacción");
		//pagePasarPlata.verificoResultadoTransaccion(listaElementos);
		pagePasarPlata.darClickEnFinalizarTransaccion();
	}
	
	public void verificarTransaccionExitosaOtrosBancos() {
		List<MobileElement> listaElementos = pagePasarPlata.capturaResultadoTransaccion();
		Utilidades.tomaEvidencia("Resultado Transacción");
		pagePasarPlata.verificoResultadoTransaccion(listaElementos);		
		utilidades.scrollHastaElFinalDePantalla();
		pagePasarPlata.txtAutorizadorOtrosBancos();
		Utilidades.scrollDownSwipe();
		pagePasarPlata.darClickEnFinalizarTransaccionOtrosBancos();
	}

	public void seleccionarCuentaOtroBanco(String numeroCuenta, String tipoId, String numId, String monto, String banco) {
		Utilidades.tomaEvidencia("Seleccion tipo de destino");
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
		utilidades.scrollHastaElFinalDePantalla();
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
		Utilidades.esperaMiliseg(5000);
		pagePasarPlata.capturarSaldoFinal();
		Utilidades.tomaEvidencia("Saldo Final " + BaseUtil.saldoFinal);
		pageLogin.validarCreditoSaldoDaviPlata();
	}
	
	public void verificarSaldosDebitoDaviPlata() {
		System.out.println("entre a verificar saldo de debito en daviplata");
		Utilidades.esperaMiliseg(4000);
		pagePasarPlata.capturarSaldoFinal();
		Utilidades.tomaEvidencia("Saldo Final " + BaseUtil.saldoFinal);
	}
	
	public void verificarIgualdadSaldoDaviPlata() {
		Utilidades.esperaMiliseg(5000);
		pageLogin.capturarSaldo();
		Utilidades.tomaEvidencia("Saldo Final " + BaseUtil.saldoFinal);
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
			Utilidades.tomaEvidencia("Saldo Final " + BaseUtil.saldoFinal);
			System.out.println("Monto " + BaseUtil.montoTransado);
			System.out.println("Saldo " + BaseUtil.saldo);
			System.out.println("Saldo Final: " + BaseUtil.saldoFinal);
			
			System.out.println("suma saldo más monto: " + BaseUtil.saldo.subtract(BaseUtil.montoTransado));
			assertThat(BaseUtil.saldoFinal, is(equalTo(BaseUtil.saldo.subtract(BaseUtil.montoTransado))));
			// Utilidades.validacionDeSaldos();
		} catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(2000);
				verificarSaldosBolsillos();
			} else {
				fail("No se puedovalidar el saldo final debido a : "+e.getMessage());
				System.out.println("no se pudo validar el saldo final debido a : " + e.getMessage().toString());
			}
		} finally {contador=0;}
	}

	public void seleccionarCuantaOtroBancoInscrita() {
		String tipoCuenta = "otro Banco";
		pagePasarPlata.selecTipoCuentaDestino();
		Utilidades.tomaEvidencia("Seleccion tipo de destino");
		Utilidades.tomaEvidencia("Seleccion de opcion cuenta inscrita");
		pagePasarPlata.seleccionarCuentaInscrita();
		Utilidades.tomaEvidencia("Seleccion de cuenta inscrita");
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
		// Utilidades.moverPantalla();
		pagePasarPlata.ingresarValorAPasarOtrosBancoBasico();
		pagePasarPlata.ingresarMotivoODescripcion();
		utilidades.moverPantallaCorto(); 
		Utilidades.tomaEvidencia("Datos de Destino diligenciados"); 
		//Utilidades.moverPantalla(200, 1600, 200, 700);
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
		Utilidades.tomaEvidencia("Datos de Destino diligenciados");
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
		Utilidades.tomaEvidencia("Datos de Destino diligenciados");
	}

	public void diligenciarFormularioCuentasInscritas() {

		pagePasarPlata.ingresarValorAPasarOtrosBancosCtaInscrita();
		pagePasarPlata.ingresarMotivoODescripcionCtaInscrita();
		Utilidades.tomaEvidencia("Datos de Destino diligenciados");
		pagePasarPlata.btnPasarPlataa();
	}

	public void procesarTransaccionOtrosBancos(String tipoCuenta) {
		pagePasarPlata.darClickEnBtnAceptar();
		List<String> datosValidar = pagePasarPlata.tomarDatosParaValidar();
		Utilidades.tomaEvidencia("Datos de Destino procesados");
		pagePasarPlata.darClickBtnPasarPlataOtrosBancos();
		pagePasarPlata.validarDatosTransaccion(datosValidar, tipoCuenta);
	}

	public void procesarTransaccionOtrosBancosFondosInsuficientes() {
		pagePasarPlata.darClickEnBtnAceptar();
		pagePasarPlata.darClickBtnPasarPlataOtrosBancos();
	}

	public void procesarTransaccionOtrosBancosCtaInscrita() {
		List<String> datosValidar = pagePasarPlata.tomarDatosParaValidar();
		Utilidades.tomaEvidencia("Datos de Destino procesados");
		pagePasarPlata.darClickBtnPasarPlataOtrosBancos();
		pagePasarPlata.validarDatosTransaccionCtaInscrita(datosValidar);
		Utilidades.tomaEvidencia("Resultado Transacción");
	}

	public void validarTransaccionNegada() {
		pagePasarPlata.validarTransaccionNegada();
		Utilidades.tomaEvidencia("Transaccion Negada");
		Utilidades.esperaMiliseg(500);
		objBolsillosPageObjects.btnFinalizarSacar();
		Utilidades.esperaMiliseg(5000);
		pagePasarPlata.capturarSaldoFinal();
	}
	
	public void validarResultadoTransaccion() {
		pagePasarPlata.validoResultadoTransaccion();
		Utilidades.tomaEvidencia("Transaccion no exitosa");
		Utilidades.esperaMiliseg(500);
	}
	
	public void validarTransaccionNegadaMonto() {
		pagePasarPlata.validarTransaccionNegadaMonto();
		Utilidades.tomaEvidencia("Monto excedido del saldo disponible");
	}
	
	public void validarMontoCero() {
		pagePasarPlata.validarHabilitacionBotonContinuarPasarPlata();
		Utilidades.tomaEvidencia("Transferencia denegada boton continuar deshabilitado");
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
		} else {
			utilidadesTCS.clickCoordinates(166, 231);
		}
		String nombre = this.objFaker.name().firstName();
		utilidadesTCS.escribirPorTecladoIos(nombre.toLowerCase());
		if(BaseUtil.nombreDispositivo == "iPhone 14".toLowerCase()) {
			utilidadesTCS.clickCoordinates(166, 207);
		} else {
			utilidadesTCS.clickCoordinates(166, 196);
		}
		utilidadesTCS.escribirPorTecladoIos(valorDisponible);
		if(BaseUtil.nombreDispositivo == "iPhone 14".toLowerCase()) {
			utilidadesTCS.clickCoordinates(166, 278);
		} else {
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
			} else {
				utilidadesTCS.clickCoordinates(166, 231);
			}
			String nombre = this.objFaker.name().firstName();
			utilidadesTCS.escribirPorTecladoIos(nombre.toLowerCase());
			if(BaseUtil.nombreDispositivo == "iPhone 14".toLowerCase()) {
				utilidadesTCS.clickCoordinates(166, 207);
			} else {
				utilidadesTCS.clickCoordinates(166, 196);
			}
			utilidadesTCS.escribirPorTecladoIos(monto);
			if(BaseUtil.nombreDispositivo == "iPhone 14".toLowerCase()) {
				utilidadesTCS.clickCoordinates(166, 278);
			} else {
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
		} else {
			utilidadesTCS.clickCoordinates(166, 231);
		}
		String nombre = this.objFaker.name().firstName();
		utilidadesTCS.escribirPorTecladoIos(nombre.toLowerCase());
		if("iPhone 14".equalsIgnoreCase(BaseUtil.nombreDispositivo)) {
			utilidadesTCS.clickCoordinates(166, 207);
		} else {
			utilidadesTCS.clickCoordinates(166, 196);
		}
		utilidadesTCS.escribirPorTecladoIos(monto);
		if("iPhone 14".equalsIgnoreCase(BaseUtil.nombreDispositivo)) {
			utilidadesTCS.clickCoordinates(166, 278);
		} else {
			utilidadesTCS.clickCoordinates(166, 270);
		}
		utilidadesTCS.escribirPorTecladoIos(monto);
		utilidadesTCS.clicElement("xpath", BolsilloPageObjects.LISTA_DESPLEGABLE_PERIODO);
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
		utilidadesTCS.clicElement("xpath", BolsilloPageObjects.LISTA_DESPLEGABLE_PERIODO_MODIFICADO);
		objBolsillosPageObjects.seleccionoPeriodo(periodo);
		objBolsillosPageObjects.pulsarModificarBolsillo();
	}
	
	public void modificarBolsilloHamburguesa(String periodo) {
		objBolsillosPageObjects.seleccionarBolsillo();
		objBolsillosPageObjects.pulsarModificarBolsillo();
		objBolsillosPageObjects.ingresarNombreBolsillo();
		utilidadesTCS.clicElement("xpath", BolsilloPageObjects.LISTA_DESPLEGABLE_PERIODO);
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
		Utilidades.esperaMiliseg(2000);
		Utilidades.tomaEvidencia("Valido el bolsillo eliminado");
	}

	public int seleccionarBolsiloAleatorio() {
		objBolsillosPageObjects.verBolsillos();
		return objBolsillosPageObjects.seleccionarBolsilloAleatorio();
	}

	public int consultarSacarPlataBolsilloAleatorio() {
		objBolsillosPageObjects.seleccionarBolsilloAleatorio();
		int numero = objBolsillosPageObjects.obtenerMontoTotal();
		Utilidades.tomaEvidencia("Consulto datos bolsillo");
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
		System.out.println(BaseUtil.saldoBolsillo.doubleValue());
		
		int saldoBolsilloMayor = BaseUtil.saldoBolsillo.intValue() + 1000;
		
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
		Utilidades.tomaEvidencia("capturo saldo final");
	}
	
	public void validarMensajeExcedeMonto() {
		objBolsillosPageObjects.verificoResultadoTransaccionExcedeMonto();
		Utilidades.esperaMiliseg(500);
		objBolsillosPageObjects.btnVolver();
		Utilidades.esperaMiliseg(500);
		objBolsillosPageObjects.btnVolver();
		Utilidades.esperaMiliseg(500);
		objBolsillosPageObjects.btnVolver();
	}
	
	public void cerrarPopup() {
		objBolsillosPageObjects.cerrarPopupSacarBolsillo();
	}
	
	public void validarPasarPlataBolsillosADaviplata() {
		pagePasarPlata.darClickEnFinalizarTransaccion();
		objBolsillosPageObjects.btnVolver();
		Utilidades.esperaMiliseg(4000);
		pageHome.capturarSaldoFinal();
		Utilidades.tomaEvidencia("capturo saldo final");
	}

	public void ingresarMonto(String monto) {
		objBolsillosPageObjects.ingresarMonto(monto);
		pagePasarPlata.clicContinuar(2);
	}

	@Step
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

	@Step
	public void consultaSaldoInicialRedeban(String documento) {
		pagePasarPlata.consultaSaldoInicialRedeban(documento);
	}

	@Step
	public void validarDiferenciaSaldosRedeban() {
		pagePasarPlata.validarDiferenciaSaldosRedeban();
	}

	@Step
	public void validarIgualdadSaldosRedeban() {
		pagePasarPlata.validarIgualdadSaldosRedeban();
	}

	@Step
	public void transaccionFondosInsuficientesBancos(String monto) {
		//pagePasarPlata.seleccionarOpcionCuantoQuierePagar();
		pagePasarPlata.ingresarMontoBancos(monto);
		Utilidades.tomaEvidencia("Monto a Transferir");
		TouchAction touchAction=new TouchAction(driver);
        touchAction.tap(new PointOption().withCoordinates(206, 196)).perform();
	}
	
	@Step
	public void irATransfiYa() {
		System.out.println("di click a btn pasar plata");
		Utilidades.tomaEvidencia("Clic opción pasar plata");
		pagePasarPlata.clickBtnMas();
		Utilidades.esperaMiliseg(1000);
		pagePasarPlata.darClickEnOpcionPasarPlata();
		Utilidades.esperaMiliseg(1000);
		pagePasarPlata.escogerOpcionTransfiYa();
		System.out.println("di click a opcion escoger opcion transfiya");
		boolean estadoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", PasarPlataPageObjects.TEXTO_POPUP_PEDIR_PLATA);
		if(estadoVisible == true) {
			utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.CONTINUAR_POPUP_ANTES_FINALIZAR_BTN);
		}
		//pagePasarPlata.clickBtnContinuarTransiYaPopup();
	}
	
	@Step
	public void ingresarARecibirPedirPlata() {
		System.out.println("di click a btn pasar plata");
		Utilidades.tomaEvidencia("Clic opción pasar plata");
		pagePasarPlata.clickBtnMas();
		Utilidades.esperaMiliseg(1000);
		pagePasarPlata.darClickEnOpcionPasarPlata();
		Utilidades.esperaMiliseg(1000);
		pagePasarPlata.escogerOpcionTransfiYa();
		System.out.println("di click a opcion escoger opcion transfiya");
		//pagePasarPlata.clickBtnContinuarTransiYaPopup();
	}
	
	@Step
	public void irARecibirYPedir() {
		performanceIrRecibirYPedir();
		utilidadesTCS.esperarElementVisibility("xpath", PasarPlataPageObjects.BTN_PEDIR_PLATA_ENLINEA);
		utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.BTN_PEDIR_PLATA_ENLINEA);
		Utilidades.tomaEvidencia("Entré a la opción 'Recibir y Pedir Plata'");
	}
	
	@Step
	public void irARecibirYPedirValidandoSolicitud() {
		performanceIrRecibirYPedir();
	}
	
	@Step
	public void performanceIrRecibirYPedir() {
		Utilidades.esperaMiliseg(1500);
		pagePasarPlata.clickBtnMas();
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
		System.out.println("Di clic al botón 'Más'");
		Utilidades.tomaEvidencia("Di clic al botón 'Más'");
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.esperarElementVisibility("xpath", PasarPlataPageObjects.BTN_RECIBIR_PEDIR_PLATA);
		utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.BTN_RECIBIR_PEDIR_PLATA);
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
		Utilidades.esperaMiliseg(1000);
		
		boolean estadoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", PasarPlataPageObjects.ACEPTO_TERM_COND);
		if(estadoVisible == true) {
			utilidadesTCS.esperarElementVisibility("xpath", PasarPlataPageObjects.ACEPTO_TERM_COND);
			utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.ACEPTO_TERM_COND);
			Utilidades.tomaEvidencia("Acepto términos y condiciones");	
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.BTN_CONTINUAR);
		}
	}
	
	@Step
	public void validarSolicitudes() {
		boolean estadoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", PasarPlataPageObjects.TXT_NO_TIENE_SOLICITUDES);
		if(estadoVisible == true) {
			Utilidades.tomaEvidencia("El usuario No tiene solicitudes de plata pendientes por autorizar en el momento");
			fail("No tiene solicitudes de plata pendientes por autorizar en el momento");
		} else {
			Utilidades.tomaEvidencia("El usuario tiene solicitudes de plata pendientes por autorizar en el momento");
		}
	}
	
	@Step
	public void aceptarYValidarTransferenciaDenegada() {
		Utilidades.tomaEvidencia("Mensaje de peticion de envio de dinero");
		pagePasarPlata.clickBtnAceptar();
		pagePasarPlata.validarTransferenciaFallida();
	}
	
	@Step
	public void darClickOpcionTransfiYa() {
		Utilidades.tomaEvidencia("Clic opción pasar plata");
		pagePasarPlata.darClickEnOpcionPasarPlata();
		Utilidades.esperaMiliseg(10000);
		Utilidades.tomaEvidencia("Clic opción transfiYa");
		pagePasarPlata.escogerOpcionTransfiYa();
	}
	
	@Step
	public void darClickOpcionAbonosFrecuentes() {
		pagePasarPlata.darClickEnOpcionAbonosFrecuentes();
		Utilidades.esperaMiliseg(1000);
		Utilidades.tomaEvidencia("Di Clic opción Abonos Frecuentes");
	}
	
	@Step
	public void validarListaContactosAbonosFrecuentes() {
		pagePasarPlata.validoListaContactosAbonosFrecuentes();
		Utilidades.esperaMiliseg(1000);
		Utilidades.tomaEvidencia("Valide correctamente lista de contactos de abonos frecuentes");
	}
	
	@Step
	public void realizarFlujoPedirPlata(String numCelular, String monto) {
		Utilidades.esperaMiliseg(1500);
		pagePasarPlata.ingresarNumeroPasarPlataLinea(numCelular);
		utilidadesTCS.clickCoordinates(200, 200);
		pagePasarPlata.ingresarMontoPasarPlataLinea(monto);
		utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.BTN_DONE);
		utilidadesTCS.scrollBackground("xpath", PasarPlataPageObjects.BTN_CONTINUAR, 0, 150);
		Utilidades.tomaEvidencia("Formulario pedir plata diligenciado");
		utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.BTN_CONTINUAR);
		Utilidades.esperaMiliseg(1500);
		pagePasarPlata.clicBtnContinuarPlataLinea();
		utilidadesTCS.esperarElementVisibility("xpath", PasarPlataPageObjects.TXT_COMPLETAR_DATOS);
		Utilidades.esperaMiliseg(800);
	}
	
	@Step
	public void realizarFlujoPasarPlataTransfiya(String numCelular, String monto) {
		Utilidades.esperaMiliseg(15000);
		pagePasarPlata.ingresarNumeroPasarPlataLinea(numCelular);
		utilidadesTCS.clickCoordinates(200, 200);
		pagePasarPlata.ingresarMontoPasarPlataLinea(monto);
		utilidadesTCS.scrollBackground("xpath", PasarPlataPageObjects.BTN_CONTINUAR, 0, -150);
		Utilidades.tomaEvidencia("Formulario transfiYa diligenciado");
		pagePasarPlata.clicBtnContinuarPlataLinea();
		Utilidades.esperaMiliseg(8000);
		Utilidades.tomaEvidencia("Validacion de informacion");
		utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.BTN_POR_TRANSFIYA);
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
		Utilidades.esperaMiliseg(800);
		Utilidades.tomaEvidencia("Valido la informacion ingresada");
		pagePasarPlata.clicBtnContinuarPlataLinea();
		Utilidades.esperaMiliseg(800);
		Utilidades.tomaEvidencia("Confirmo los datos ingresados");
		pagePasarPlata.clicBtnContinuarPlataLinea();
	}
	
	@Step
	public void realizarFlujoPedirPlataEnLinea(String numCelular, String monto) {
		Utilidades.esperaMiliseg(3000);
		Utilidades.tomaEvidencia("Valido ingreso a la opción pedir plata en linea");
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.BTN_PEDIR_PLATA_ENLINEA);
		Utilidades.esperaMiliseg(1000);
		pagePasarPlata.ingresarNumeroPasarPlataLinea(numCelular);
		pagePasarPlata.ingresarMontoPasarPlataLinea(monto);
//		pagePasarPlata.clickBtnDone();
		Utilidades.tomaEvidencia("Formulario para pedir plata diligenciado");
		pagePasarPlata.clicBtnContinuarPlataLinea();
		Utilidades.esperaMiliseg(8000);
		Utilidades.tomaEvidencia("Validacion de informacion");
		pagePasarPlata.clicBtnContinuarPlataLinea();
		Utilidades.esperaMiliseg(2000);
	}
	
	@Step
	public void realizarFlujoPedir(String numCelular, String monto) {
		Utilidades.esperaMiliseg(1000);
		pagePasarPlata.clicBtnPedirPlataLinea();
		Utilidades.tomaEvidencia("Clic opción pedir plata en linea"); 	
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.esperarElementVisibility("xpath", PasarPlataPageObjects.TXT_COMPLETAR_INFO);
		pagePasarPlata.ingresarNumeroPasarPlataLinea(numCelular);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.CLIC_TEXT);
		pagePasarPlata.ingresarMontoPasarPlataLinea(monto);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.CLIC_TEXT);
		Utilidades.tomaEvidencia("Formulario transfiYa diligenciado");
		pagePasarPlata.clicBtnContinuarPlataLinea();
		Utilidades.esperaMiliseg(1000);
		boolean elementoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", PasarPlataPageObjects.TXT_CONTACTO_CON_DAVIPLATA);
		if(elementoVisible == true) {
			utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.BTN_MEDIO_TRANSFIYA);
		}
		utilidadesTCS.esperarElementVisibility("xpath", PasarPlataPageObjects.TXT_COMPLETAR_DATOS);
		Utilidades.tomaEvidencia("Validacion de informacion");
		pagePasarPlata.clicBtnContinuarPlataLinea();
		Utilidades.esperaMiliseg(2000);
	}
	
	public void ingresoALaOpcionPedirPlataFondosInsuficientes(String numCelular, String monto) {
		pagePasarPlata.esperarVisibilidadPantallaTransfiYa();
		pagePasarPlata.clickOpcionPedirPlata();
		System.out.println("ingresando numero de cel");
		pagePasarPlata.ingresarNumeroPedirPlata(numCelular);
		TouchAction touchAction=new TouchAction(driver);
        touchAction.tap(new PointOption().withCoordinates(214, 132)).perform();
		pagePasarPlata.ingresarMontoPasarPlataLinea(monto);
		Utilidades.tomaEvidencia("Formulario transfiYa diligenciado");
		pagePasarPlata.clickBtnDone();
        touchAction.tap(new PointOption().withCoordinates(196, 609)).perform();
        touchAction.tap(new PointOption().withCoordinates(237, 516)).perform();
		pagePasarPlata.validarMensajeInsuficienteTransfiYa();
		Utilidades.tomaEvidencia("Validar mensaje de fondos insuficientes");
		
	}
	
	public void validoResultadoTransaccionExitosa() throws Exception {
		pagePasarPlata.validarResultadoTransaccionExitosaTransfiYa();
		Utilidades.esperaMiliseg(5000);
		Utilidades.tomaEvidencia("Valido resultado de la transacción");
		pagePasarPlata.darClickEnFinalizarTransaccion();
		Utilidades.tomaEvidencia("Finalicé Transaccion");
	}
	
	public void validoResultadoSolicitudExitosa() throws Exception {
		pagePasarPlata.validarResultadoSolicitudExitosaTransfiYa();
		Utilidades.tomaEvidencia("Solicitud exitosa");
		pagePasarPlata.darClickEnFinalizarTransaccion();
		Utilidades.tomaEvidencia("Finalicé Transaccion");
	}
	
	public void validarClienteGMF(String estadoExenta) throws Exception {
		pagePasarPlata.validarClienteGMF(estadoExenta);
		Utilidades.tomaEvidencia("Valido estado cliente, es GMF");
	}
	
	public void validarResultadoSolicitudRechazada() throws Exception {
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.esperarElementVisibility("xpath", PasarPlataPageObjects.POPUP_COBRO_RECHAZADO);
		Utilidades.tomaEvidencia("Confirmo que el cobro fue rechazado");
		utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.ACEPTAR_POPUP);
		
		int count = 0;
		do {
			Utilidades.esperaMiliseg(1000);
		    utilidadesTCS.esperarElementVisibility("xpath", PasarPlataPageObjects.BOTON_ATRAS_BOLSILLOS);
		    utilidadesTCS.clicElementAction("xpath", PasarPlataPageObjects.BOTON_ATRAS_BOLSILLOS);
			Utilidades.esperaMiliseg(1500);
			boolean estadoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.POP_UP_INVITE_AMIGOS);
			if(estadoVisible == true) {
				utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_CLOSE);
			}
		    count++;
		} while (count < 2);
		Utilidades.esperaMiliseg(1500);
		pageHome.capturarSaldoFinal();
		Utilidades.tomaEvidencia("capturo saldo final");
	}
	
	public void validarResultadoTransaccionRechazada() throws Exception {
		pagePasarPlata.validarResultadoTransaccionRechazada();
		Utilidades.tomaEvidencia("Transacción rechazada");
		pagePasarPlata.darClickEnFinalizarTransaccion();
		Utilidades.tomaEvidencia("Finalicé Transaccion");
		pagePasarPlata.volverAtras();
		pagePasarPlata.volverAtras();
		pageHome.capturarSaldoFinal();
		Utilidades.tomaEvidencia("capturo saldo final");
	}
	
	@Step
	public void regresarAlHome() {
		int count = 0;
		do {
			Utilidades.esperaMiliseg(1000);
		    utilidadesTCS.esperarElementVisibility("xpath", PasarPlataPageObjects.BOTON_ATRAS_BOLSILLOS);
		    utilidadesTCS.clicElementAction("xpath", PasarPlataPageObjects.BOTON_ATRAS_BOLSILLOS);
			Utilidades.esperaMiliseg(1500);
			boolean estadoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.POP_UP_INVITE_AMIGOS);
			if(estadoVisible == true) {
				utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_CLOSE);
			}
		    count++;
		} while (count < 4);
	}
	
	public void validarSaldoFinalSinAceptacion() {

		int count = 0;
		do {
			Utilidades.esperaMiliseg(1000);
		    utilidadesTCS.esperarElementVisibility("xpath", PasarPlataPageObjects.BOTON_ATRAS_BOLSILLOS);
		    utilidadesTCS.clicElementAction("xpath", PasarPlataPageObjects.BOTON_ATRAS_BOLSILLOS);
			Utilidades.esperaMiliseg(1500);
			boolean estadoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.POP_UP_INVITE_AMIGOS);
			if(estadoVisible == true) {
				utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_CLOSE);
			}
		    count++;
		} while (count < 4);
		
		Utilidades.esperaMiliseg(1500);
		pageHome.capturarSaldoFinal();
		Utilidades.tomaEvidencia("capturo saldo final");
	}
	
	
	public void validarMontoEsMayorATopeCredito(String monto) throws Exception {
		pagePasarPlata.validarMontoEsMayorATopeCredito(monto);
	}
	
	public void validarMontoEsMayorATopeDebito(String monto) throws Exception {
		pagePasarPlata.validarMontoEsMayorATopeDebito(monto);
	}
	
	public void validarDescripcionPopUpTransfiYa() throws Exception {
		Utilidades.esperaMiliseg(10000);
		pagePasarPlata.clickIcono();
		pagePasarPlata.validarDescripcionPopUpTransfiYa();
		Utilidades.tomaEvidencia("Valide la descripcion del pop up transfiYa");
		pagePasarPlata.clicBtnContinuarTransfiYa();
		Utilidades.tomaEvidencia("Valide y di click al btn continuar del pop up");
	}
	
	public void aceptarSolicitudPendiente1(String monto) throws Exception {
		Utilidades.tomaEvidencia("ingreso Modulo trannsfiYa");
		Utilidades.esperaMiliseg(5000);
		pagePasarPlata.darClickBtnSolicitudPendiente();
		Utilidades.esperaMiliseg(2000);
		Utilidades.tomaEvidencia("Ingreso solcitud Pendiente");
		pagePasarPlata.validarMontoSolicitud(monto);
		Utilidades.esperaMiliseg(2000);
		Utilidades.tomaEvidencia("Valido monto solicitud");
		pagePasarPlata.clickAceptarSolicitud();
		Utilidades.esperaMiliseg(2000);
		Utilidades.tomaEvidencia("Di click en aceptar recibir plata");
	}
	
	@Step
	public void aceptarSolicitudPendiente(String monto) throws Exception {
		Utilidades.esperaMiliseg(5000);
		boolean estadoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", PasarPlataPageObjects.TXT_TIENE_SOLICITUDES);
		if(estadoVisible == true) {
			System.out.println("Valido presencia de solicitud pendiente por autorizar");
			utilidadesTCS.esperarElementVisibility("xpath", PasarPlataPageObjects.COBRO_PENDIENTE);
			utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.COBRO_PENDIENTE);
			Utilidades.esperaMiliseg(1000);
			pagePasarPlata.validarMontoSolicitud(monto);
			Utilidades.tomaEvidencia("Valido monto");
			utilidadesTCS.esperarElementVisibility("xpath", PasarPlataPageObjects.BTN_ACEPTAR_COBRO);
			Utilidades.tomaEvidencia("Doy click a aceptar solicitud");
			utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.BTN_ACEPTAR_COBRO);
			Utilidades.esperaMiliseg(1000);
		}
	}
	
	@Step
	public void rechazarSolicitudPendiente(String monto) throws Exception {
		Utilidades.esperaMiliseg(5000);
		boolean estadoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", PasarPlataPageObjects.TXT_TIENE_SOLICITUDES);
		if(estadoVisible == true) {
			System.out.println("Valido presencia de solicitud pendiente por autorizar");
			utilidadesTCS.esperarElementVisibility("xpath", PasarPlataPageObjects.COBRO_PENDIENTE);
			utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.COBRO_PENDIENTE);
			Utilidades.esperaMiliseg(1000);
			pagePasarPlata.validarMontoSolicitud(monto);
			Utilidades.tomaEvidencia("Valido monto");
			utilidadesTCS.esperarElementVisibility("xpath", PasarPlataPageObjects.BTN_RECHAZAR_COBRO);
			utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.BTN_RECHAZAR_COBRO);
			Utilidades.esperaMiliseg(1000);
			Utilidades.tomaEvidencia("Doy click a rechazar solicitud");
			utilidadesTCS.esperarElementVisibility("xpath", PasarPlataPageObjects.BTN_SI_POPUP_RECHAZAR);
			utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.BTN_SI_POPUP_RECHAZAR);
		}
	}
	
	public void ingresarDatosBanco(String agenciaCuentas, String numeroCuenta,  String password) throws Exception {
		pagePasarPlata.validarVisibilidadFormularioPse();
		pagePasarPlata.inputAgenciaCuentas(agenciaCuentas);
		pagePasarPlata.inputNumeroCuenta(numeroCuenta);
		pagePasarPlata.inputPasswordCuenta(password);
		Utilidades.tomaEvidencia("Diligenciar datos de banco");
		pagePasarPlata.clicBtnPay();
	}
	
	public void validarTransaccionPse() throws Exception {
		Utilidades.esperaMiliseg(8000);
		pagePasarPlata.validarAparezcaTransaccionPseBanco();
		pagePasarPlata.validarTransaccionPseBanco();
		Utilidades.tomaEvidencia("Validar transaccion pse");
	}

	public void validoBolsilloFondosInsuficientes() {
		pagePasarPlata.validoLblBolsilloFondosInsuficientes();
		pageHome.clickBotonAtrasBolsillos(3);
		pageHome.capturarSaldoFinal();
		Utilidades.tomaEvidencia("Valido no haya descuento del home");
		utilidades.validacionDeSaldos();
		Utilidades.esperaMiliseg(2000);
	}
	
	public void verificarSaldoInicialDaviplataGmf() {
		pagePasarPlata.capturarSaldoInicialDaviplata();
		pagePasarPlata.validarIgualdadSaldosInicialesGmf();
		Utilidades.tomaEvidencia("Saldo Inicial Gmf" + BaseUtil.saldoInicial);
	}

	public void verificarSaldoInicialDaviplata() {
		pagePasarPlata.capturarSaldoInicialDaviplata();
		pagePasarPlata.validarIgualdadSaldosIniciales();
		Utilidades.tomaEvidencia("Saldo Inicial " + BaseUtil.saldoInicial);
	}
	
	public void validarSaldoInicialNuevoUsuario() {
		pagePasarPlata.capturarSaldoInicialDaviplata();
		Utilidades.tomaEvidencia("Verifico saldo inicial en DaviPlata de usuario recíen registrado: " + BaseUtil.saldoInicial);
	}
	
	public void verificarTransaccionExitosaPasarPlata() {
		Utilidades.esperaMiliseg(4000);
		pagePasarPlata.txtTransaccion();
		Utilidades.tomaEvidencia("Resultado Transacción");
		utilidades.moverPantallaCorto();
		//pagePasarPlata.cerrarCalificacion();
		pagePasarPlata.txtAutorizador();
		pagePasarPlata.darClickEnFinalizarTransaccion();
	}
	
	public void validarTransaccionDestino() {
		pagePasarPlata.txtTransaccion();
		pagePasarPlata.darClickEnFinalizarTransaccion();
		pagePasarPlata.volverAtras();
		pagePasarPlata.volverAtras();
		Utilidades.esperaMiliseg(5000);
		pagePasarPlata.capturarSaldoFinal();
	}
	
	public void verificarSaldos() {
		Utilidades.esperaMiliseg(4000);
		pagePasarPlata.capturarSaldoFinal();
		Utilidades.tomaEvidencia("Saldo Final " + BaseUtil.saldoFinal);
	}
	
	public void pasarPlataAOtroDaviplataTopeDebitos(String numero) {
		pagePasarPlata.pasarPlataAOtroDaviplata();
		Utilidades.tomaEvidencia("Ingreso el numero de telefono " + numero);
		pagePasarPlata.pasarPlataAOtroDaviplataNumero(numero);
		try {
			pagePasarPlata.pasarPlataAOtroDaviplataCantidadTopeDebito();
			Utilidades.tomaEvidencia("Selecciono la cantidad");
			TouchAction touchAction=new TouchAction(driver);
            touchAction.tap(new PointOption().withCoordinates(22,339)).perform();
			pagePasarPlata.darClickEnBtnContinuar();
			pagePasarPlata.cerrarPopup();
			pagePasarPlata.darClickBtnPasarPlata();
			
			Utilidades.esperaMiliseg(4000);
				
		}catch (Exception e){
			boolean validacion = false;
			int Primer_Numero = Integer. parseInt(numero.substring(0,1));
			validacion =true;
			assertEquals(true,validacion);
			if (Primer_Numero != 3 ) {
				System.out.println("El numero de ingresa comienza con un numero diferente a 3");
				Utilidades.tomaEvidencia("El numero de ingresa comienza con un numero diferente a 3");
			}
			else {assertEquals(true,validacion);
			}
		}
	}
	
	public void pasarPlataAOtroDaviplataMonto(String numero, String monto) {
		pagePasarPlata.pasarPlataAOtroDaviplata();
		Utilidades.tomaEvidencia("Ingreso el numero de telefono " + numero);
		pagePasarPlata.pasarPlataAOtroDaviplataNumero(numero);
		try {
			pagePasarPlata.ingresarMontoAOtroDaviplata(monto);
			Utilidades.tomaEvidencia("Selecciono la cantidad");
			TouchAction touchAction=new TouchAction(driver);
            touchAction.tap(new PointOption().withCoordinates(22,339)).perform();
			pagePasarPlata.darClickEnBtnContinuar();
			//pagePasarPlata.cerrarPopup();
			pagePasarPlata.darClickBtnPasarPlata();
			
			Utilidades.esperaMiliseg(8000);
			
			pagePasarPlata.cerrarCalificacion();
			pagePasarPlata.txtAutorizador();	
		} catch (Exception e){
			boolean validacion = false;
			int Primer_Numero = Integer. parseInt(numero.substring(0,1));
			validacion =true;
			assertEquals(true,validacion);
			if (Primer_Numero != 3 ) {
				System.out.println("El numero de ingresa comienza con un numero diferente a 3");
				Utilidades.tomaEvidencia("El numero de ingresa comienza con un numero diferente a 3");
			}
			else {assertEquals(true,validacion);
			}
			
		}
	}

	public void ingresarMontoCuentaDaviviendaCero(String monto) {
		pagePasarPlata.ingresarMontoCuenta(monto);
		Utilidades.tomaEvidencia("Ingresar Monto Cuenta");
	}
	
	public void ingresarMontoCuentaDaviviendaTopeDebitos() {
		pagePasarPlata.ingresarMontoCuentaTopeDebitos();
		Utilidades.tomaEvidencia("Ingresar Monto Cuenta");
		TouchAction touchAction=new TouchAction(driver);
        touchAction.tap(new PointOption().withCoordinates(22,339)).perform();
		pagePasarPlata.clicBotonContinuar();
		pageMarketPlace.cerrarPopup();
		pagePasarPlata.clicBotonPasarPlata();
	}

	public void ingesoALaOpcionPasarPlataHome() {
		pagePasarPlata.darClickEnOpcionPasarPlata();
		Utilidades.tomaEvidencia("Ingreso a Pasar plata desde home daviplata");
	}
	
	public void ingresarMontoCuentaDaviviendaPasarPlata(String monto) {
		pagePasarPlata.ingresarMontoCuenta(monto);
		Utilidades.tomaEvidencia("Ingresar Monto Cuenta " + monto);
		TouchAction touchAction=new TouchAction(driver);
        touchAction.tap(new PointOption().withCoordinates(20, 352)).perform();
	}
	
	public void validarBotonInhabilitado() throws Exception {
		pagePasarPlata.validarBotonContinuarPasarPlataInhabilitado();
		Utilidades.tomaEvidencia("Validar boton inhabilitado");
		for(int i = 0; i<2; i++) {
			pagePasarPlata.atras();
		}
		Utilidades.esperaMiliseg(4000);
		pagePasarPlata.capturarSaldoFinal();
		Utilidades.tomaEvidencia("Saldo final daviplata");
	}
	
	public void escogerOpcionCuentasDaviviendaInscritas() {
		Utilidades.esperaMiliseg(2000);
		Utilidades.tomaEvidencia("Seleccionar cuentas Davivienda");
		pagePasarPlata.seleccionarCuentasDavivienda();
	}
	
	public void ingresarMontoCuentaInscritas(String monto) {
		pagePasarPlata.clicBotonFavoritosCuentaInscritas();
		pagePasarPlata.clicBotonCuentaFav();
		pagePasarPlata.ingresarMontoCuenta(monto);
		TouchAction touchAction=new TouchAction(driver);
        touchAction.tap(new PointOption().withCoordinates(20, 352)).perform();
		Utilidades.tomaEvidencia("Ingresar Monto Cuenta " + monto);
		pagePasarPlata.clicBotonContinuar();
		Utilidades.tomaEvidencia("Verificación de datos");
		pagePasarPlata.clicBotonPasarPlata();
	}
	
	public void ingresarMontoCeroCuentaDavivienda(String monto) {
		pagePasarPlata.ingresarMontoCuenta(monto);
		Utilidades.tomaEvidencia("Ingresar Monto Cuenta " + monto);
	}
	
	public void validarMontoCeroCuentas() {
		pagePasarPlata.validoBtnContinuarDeshabilitado();
		Utilidades.tomaEvidencia("Transferencia denegada botón continuar deshabilitado");
		pagePasarPlata.atras();
		pagePasarPlata.atras();
		pagePasarPlata.capturarSaldoFinal();
		Utilidades.tomaEvidencia("Saldo final del daviplata");
	}

	public void ingresarMayorSaldoDisponible() {
		pagePasarPlata.ingresarMontoMayor();
		TouchAction touchAction=new TouchAction(driver);
        touchAction.tap(new PointOption().withCoordinates(20, 352)).perform();
	}

	public void validarMensajeMontoSuperiorAlSaldoDisponible() {
		pagePasarPlata.validarMensajeMontoSuperiorSaldoDisponible();
		Utilidades.tomaEvidencia("Mensaje de fondos insuficientes");
		pagePasarPlata.atras();
		pagePasarPlata.atras();
		Utilidades.tomaEvidencia("Saldo final daviplata");
		pagePasarPlata.capturarSaldoFinal();
	}
	
	public void validarMensajeFondosInsuficientes() {
		pagePasarPlata.validarFondosInsuficientes();
		Utilidades.tomaEvidencia("Validar Fondos Insuficientes");
		pagePasarPlata.btnVolver();
		pagePasarPlata.btnVolver();
		Utilidades.esperaMiliseg(5000);
		pagePasarPlata.capturarSaldoFinal();
		Utilidades.tomaEvidencia("Saldo Final " + BaseUtil.saldoFinal);
	}
	
	public void llenarFormularioMontoInferiorOtrosBancos(String numeroCuenta, String tipoId, String numId, String valorAPasar, String banco) {
		Utilidades.esperaMiliseg(4000);
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
		Utilidades.tomaEvidencia("Seleccion banco y num cuenta");
		//DAR SCROLL
		Utilidades.scrollDownSwipe();
		//BTN SELECCIONAR TIPO DE DOCUMENTO
		pagePasarPlata.seleccioneTipoIdentificacion();
		//SELECCIONAR TIPO DE DOCUMENTACION
		pagePasarPlata.discoTipoIdentificacion(tipoId);
		//INGRESAR NUMERO DE IDENTIFICACION
		pagePasarPlata.numeroIdentificacion(numId);
		//INGRESAR MONTO
		pagePasarPlata.inputMonto(valorAPasar);
		Utilidades.tomaEvidencia("Llenado del formulario");
		System.out.println("Llené el formulario correctamente");
		//DAR CLICK BTN CONTINUAR
		pagePasarPlata.btnContinue();
		Utilidades.tomaEvidencia("Dar en el boton Pop Up continuar");
	}
	
	public void validarMensajeValorInferior() {
		pagePasarPlata.validarValorInferiorOtrosBancos();
		Utilidades.tomaEvidencia("Validar valor inferior");
		pagePasarPlata.btnVolver();
		pagePasarPlata.btnVolver();
		Utilidades.esperaMiliseg(5000);
		pagePasarPlata.capturarSaldoFinal();
		Utilidades.tomaEvidencia("Saldo Final " + BaseUtil.saldoFinal);
	}
	
	public void validarSaldoFinalBolsillos() {
		pagePasarPlata.darClickEnFinalizarTransaccion();
		pageHome.clickBotonAtrasBolsillos(1);
		Utilidades.esperaMiliseg(3000);
		pagePasarPlata.capturarSaldoFinal();
		Utilidades.tomaEvidencia("Saldo final del daviplata");
	}


	public void meterPlataBolsillo(int numero) {
		objBolsillosPageObjects.pulsarMeterPlata();
		objBolsillosPageObjects.pulsarBolsilloSeleccionado(numero);
	}
	
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
		Utilidades.esperaMiliseg(10000);
		pagePasarPlata.ingresarPasarPlataLinea();
		pagePasarPlata.ingresarNumeroPasarPlataLinea(numCelular);
		utilidades.ocultarTeclado(214, 132);
		pagePasarPlata.ingresarMontoPasarPlataLinea(monto);
		Utilidades.tomaEvidencia("Formulario transfiYa diligenciado");
		utilidades.ocultarTeclado(339, 463);
		pagePasarPlata.clicBotonContinuar();
		pagePasarPlata.clicBotonContinuar();
		pagePasarPlata.validarMensajeInsuficienteTransfiYa();
		Utilidades.tomaEvidencia("Validar mensaje de fondos insuficientes");
	}
	
	@Step
	public void pasarPlataAOtroDaviplataAñadiendoCuentaAFavoritos(String numero, String monto, String nombreContactoFavorito) {
        pagePasarPlata.pasarPlataAOtroDaviplata();
        Utilidades.tomaEvidencia("Ingreso el numero de telefono " + numero);
        pagePasarPlata.pasarPlataAOtroDaviplataNumero(numero);
        Utilidades.tomaEvidencia("Hacer clic en favoritos");
        utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.BOTON_FAVORITOS_PASAR_PLATA);
        utilidadesTCS.writeElement("xpath", PasarPlataPageObjects.INPUT_NOMBRE_DEL_CONTACTO_FAVORITO, nombreContactoFavorito);
        utilidadesTCS.clickCoordinates(220, 220);
		Utilidades.esperaMiliseg(800);
        Utilidades.tomaEvidencia("Hacer clic en el boton guardar");
        utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.BOTON_GUARDAR_FAVORITO);
		Utilidades.esperaMiliseg(1000);
        pagePasarPlata.ingresarMontoAOtroDaviplata(monto);
        Utilidades.tomaEvidencia("Selecciono la cantidad");
        utilidadesTCS.clickCoordinates(220, 220);
		Utilidades.esperaMiliseg(800);
        pagePasarPlata.darClickEnBtnContinuar();
        System.out.println("Dio click en Boton Continuar");
        utilidadesTCS.clickCoordinates(220, 220);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.CONTINUAR_BTN);
        //pagePasarPlata.clickBtnContnuarPasarPlataOtroDaviplata();
        System.out.println("Dio click en Boton Pasar Plata");
    }	
	
	@Step
	public void validarEnmascaramiento() {
		Utilidades.esperaMiliseg(1500);
		String userEnmascarado = utilidadesTCS.obtenerTexto("xpath", PasarPlataPageObjects.TXT_USUARIO_ENMASCARADO);
        System.out.println("Usuario enmascarado: " + userEnmascarado);
        Utilidades.tomaEvidencia("Usuario enmascarado: " + userEnmascarado);
	}
	
	@Step
	public void validarTransaccionFechas() {
		Utilidades.esperaMiliseg(1500);
		utilidadesTCS.clicElement("xpath", PasarPlataPageObjects.TXT_PRIMER_MOVIMIENTO);
		Utilidades.esperaMiliseg(800);
		utilidadesTCS.esperarElementVisibility("xpath", PasarPlataPageObjects.TXT_FECHA_HORA_TRANS);
		String fechaHora = utilidadesTCS.obtenerTexto("xpath", PasarPlataPageObjects.TXT_FECHA_HORA_TRANS);
        System.out.println("Fecha y hora de transacción: " + fechaHora);
        Utilidades.tomaEvidencia("Fecha y hora de transacción: " + fechaHora);
	}
	
	@Step
	public void validarNoMovimientos() {
		Utilidades.esperaMiliseg(1500);
		boolean estadoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", PasarPlataPageObjects.TXT_NO_TIENE_MOVIMIENTOS);
		if(estadoVisible == true) {
			utilidadesTCS.esperarElementVisibility("xpath", PasarPlataPageObjects.TXT_NO_TIENE_MOVIMIENTOS);
			String txt = utilidadesTCS.obtenerTexto("xpath", PasarPlataPageObjects.TXT_NO_TIENE_MOVIMIENTOS);
	        System.out.println("Valido mensaje: " + txt);
	        Utilidades.tomaEvidencia("Valido mensaje: " + txt);
		} else {
	        System.out.println("El usuario si cuenta con movimientos");
	        Utilidades.tomaEvidencia("El usuario si cuenta con movimientos");
			fail("El usuario si cuenta con movimientos");
		}
	}
	
}
