package daviplata.nacional.iOS.pageObjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.math.BigDecimal;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.Scenario;
import daviplata.nacional.iOS.definitions.Hooks;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import daviplata.nacional.iOS.utilidades.Utilidades;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import net.serenitybdd.core.pages.PageObject;

public class RecargaPageObjects extends PageObject {
    
	private AppiumDriver<MobileElement> driver = Hooks.getDriver();
	private WebDriverWait wait = Hooks.getDriverWait();
	Utilidades utilidad;
	BaseUtil base;
	
	
	private String btnRecargasTiendaVirtual = "//*[@text = 'Recargas']";
	private String btnRecarga = "com.davivienda.daviplataapp.lab:id/recargar";
	private String listaTipoRecarga = "com.davivienda.daviplataapp.lab:id/editOperationsType";
	private String selectTipoRecarga = "//*[@text='#']";
	private String btnRecargaMinutos = "com.davivienda.daviplataapp.lab:id/btnRecargar";
	private String btnEmpresaOServi = "com.davivienda.daviplataapp.lab:id/hacer_pagos_manual_btnOp1";
	private String inputServicioEmpresa = "com.davivienda.daviplataapp.lab:id/edit_text_hacer_pagos_empresa";
	private String selectOperadorEmpresa = "//android.widget.TextView[contains(@text,";
	private String selectOperadorTV = "com.davivienda.daviplataapp.lab:id/check_hacer_pagos_fav";
	private String selectOperadorEmpresaCelular = "//*[@text='#']";
	private String btnNumReferencia = "com.davivienda.daviplataapp.lab:id/hacer_pagos_manual_btnOp2";
	private String inputNumReferencia = "com.davivienda.daviplataapp.lab:id/hacer_pagos_referencia_numero";
	private String btnValorAPagar = "com.davivienda.daviplataapp.lab:id/hacer_pagos_manual_btnOp3";
	private String selectMonto = "com.davivienda.daviplataapp.lab:id/check_recarga_prepago_paso00_amount#";
	private String inputMonto = "com.davivienda.daviplataapp.lab:id/recargaprepago_paso00_otromonto";
	private String btnCelARecargar = "com.davivienda.daviplataapp.lab:id/recarga_prepago_btnOp1";
	private String inputNumeroRecarga = "com.davivienda.daviplataapp.lab:id/recarga_prepago_numero_et_numero";
	private String btnCuantoRecargar = "com.davivienda.daviplataapp.lab:id/recarga_prepago_btnOp2";
	private String btnSelectOperador = "com.davivienda.daviplataapp.lab:id/recarga_prepago_btnOp3";
	private String btnListaOperadores = "com.davivienda.daviplataapp.lab:id/editOperations";
	private String listOperadores = "//*[@class='android.widget.TextView'][contains(text(),'#')]";
	private String labelRecargaFallida = "com.davivienda.daviplataapp.lab:id/notif_text_rappi";
	private String btnFinalizar = "//*[@text='Finalizar']";
	
	private String labelCuentaNoExiste = "//*[@id='notif_text_rappi']";
	private String lblFondonInsuficientes = "//android.widget.TextView[contains(@text,'RECHAZADA')]";
	private String btnRecargaMovistar = "//*[@text='Recarga de Minutos y Paquetes de Datos new url 03May']";

	
	private String txtAutorizador = "com.davivienda.daviplataapp.lab:id/tv_pasarplata_complete_autorizacion";
	private String txtAutorizador1 = "com.davivienda.daviplataapp.lab:id/tv_pp_authorization_number";
	
	private String btnMenuHamburguesa = "com.davivienda.daviplataapp.lab:id/ivMenuHowMuch";
	private String btnUsarPlata = "com.davivienda.daviplataapp.lab:id/ivUseCash";
	private String btnRecargasPrepago = "//*[@text='Recargas prepago']";
	private String btnContinuar = "//*[@text='Continuar']";
	private int contador = 0;
	private String btnRecargaMinutos2 = "";
	
	public void darClickEnMenuHamburguesa() {
		MobileElement btnMenuHamburguesa = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.btnMenuHamburguesa)));
		btnMenuHamburguesa.click();
	}
	public void btnContinuar() {
		MobileElement btnMenuHamburguesa = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuar)));
		btnMenuHamburguesa.click();
	}
	
	public void btnRecargasPrepago() {
		MobileElement btnRecargasPrepago = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnRecargasPrepago)));
		btnRecargasPrepago.click();
	}
	public void txtAutorizador() {
		try {
			MobileElement txtAutorizador = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.id(this.txtAutorizador)));
			quitarCerosIzquierda(txtAutorizador.getText());
			
		}catch(Exception e) {
			
		}	
		try {
			MobileElement txtAutorizador1 = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.id(this.txtAutorizador1)));
			quitarCerosIzquierda(txtAutorizador1.getText());
		}catch(Exception e) {
			
		}	
		
		
	}
	public void quitarCerosIzquierda(String numero) {
		long p = Long.parseLong(numero);
		base.Autorizador = Long.toString(p);
	}
	
	public void clickRecargas() {
		MobileElement btnRecargasTiendaVirtual = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnRecargasTiendaVirtual)));
		utilidad.esperaMiliseg(2000);
		btnRecargasTiendaVirtual.click();
	}
	
	public void darClickEnOpcionRecargaCapturaNo() {
		MobileElement btnRecarga = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnRecarga)));
		btnRecarga.click();
	}

	public void clickListaTipoRecarga() {
		MobileElement listaTipoRecarga = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.listaTipoRecarga)));
		listaTipoRecarga.click();
	}

	public void selectTipoDeRecarga() {
		MobileElement selectTipoRecarga = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.selectTipoRecarga)));
		selectTipoRecarga.click();

	}

	public void darClickEmpresaOServicio() {
		MobileElement btnEmpresaOServi = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.btnEmpresaOServi)));
		btnEmpresaOServi.click();
	}

	public void darClickDesplegableEmpresaServicio(String empresaOperador) {
		MobileElement inputServicioEmpresa = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.inputServicioEmpresa)));
//	//	inputServicioEmpresa.sendKeys(empresaOperador);
		inputServicioEmpresa.click();
		utilidad.esperaMiliseg(100);
		inputServicioEmpresa.click();
	//	inputServicioEmpresa.sendKeys(empresaOperador);
	//	utilidad.esperaMiliseg(100);

	}

	public void selectOperadorEmpresa(String empresaOperador) {
		String NumCuadroOperador = "";
		switch (empresaOperador) {
		case "VIRGIN":
			NumCuadroOperador = "1";
			break;
		case "MOVISTAR":
			NumCuadroOperador = "2";
			break;
		case "WOM":
			NumCuadroOperador = "3";
			break;
		case "FLASH":
			NumCuadroOperador = "4";
			break;
		case "CLARO":
			NumCuadroOperador = "5";
			break;
		default:
			NumCuadroOperador = "2";
			break;
		}
		String xpathOperador = "(//*[@resource-id='com.davivienda.daviplataapp.lab:id/imvCard'])[#]";
		System.out.println(empresaOperador);
		MobileElement selectOperadorEmpresa = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathOperador.replace("#",NumCuadroOperador)))); 
		utilidad.tomaEvidencia("Operador destino: "+ empresaOperador);
		selectOperadorEmpresa.click();
	//	this.selectOperadorEmpresa = this.selectOperadorEmpresa.replace("#", empresaOperador);
		/*String empresaOp = selectOperadorEmpresa +"\'"+ empresaOperador+"\'" +")]";
		System.out.println(empresaOp);
		MobileElement selectOperadorEmpresa = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(empresaOp))); 
		utilidad.tomaEvidencia("Operador destino"+ empresaOperador);
		selectOperadorEmpresa.click();*/

	}
	
	public void selectOperadorEmpresaTv(String empresaOperador) {

		try {
			MobileElement selectOperadorEmpresa = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.id(selectOperadorTV))); 
			utilidad.tomaEvidencia("Operador destino"+ empresaOperador);
			selectOperadorEmpresa.click();
		} catch (Exception e) {
			// TODO: handle exception
			utilidad.darUnTap(540, 680);
			System.out.println("Dio un tap");
		}


	}
	public void selectOperadorEmpresaCelular(String empresaOperador) {

			this.selectOperadorEmpresaCelular = this.selectOperadorEmpresaCelular.replace("#", empresaOperador);
			MobileElement selectOperadorEmpresaCelular = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.selectOperadorEmpresaCelular)));
			utilidad.tomaEvidencia("Operador destino");
			selectOperadorEmpresaCelular.click();

		}

	public void darClickNumReferencia() {
		MobileElement btnNumReferencia = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.btnNumReferencia)));
		btnNumReferencia.click();
	}

	public void ingresarNumReferencia(String numReferencia) {
		MobileElement inputNumReferencia = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.inputNumReferencia)));
		inputNumReferencia.sendKeys(numReferencia);
	}

	public void darClickValorAPagar() {
		MobileElement btnValorAPagar = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.btnValorAPagar)));
		btnValorAPagar.click();
	}

	public void ingresarOSeleccionarValor(String montoSeleccionable) {
		if (montoSeleccionable.equalsIgnoreCase("si")) {
			seleccionarMonto();
		}else if(montoSeleccionable.equalsIgnoreCase("mayor")) {
			ingresarMonto();
		}
		else {
			
			ingresarMontoMayor();
		}
	}

	public void seleccionarMonto() {
		this.selectMonto = this.selectMonto.replace("#", utilidad.numAleatorio(4, 1));
		MobileElement selectMonto = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.selectMonto)));
		System.out.println(selectMonto.getText());
		base.montoTransado = new BigDecimal(selectMonto.getText().replace("$", "").replace(".", "").trim());
		base.monto = base.montoTransado.toString();
		selectMonto.click();
		utilidad.tomaEvidencia("Monto seleccionado");
		utilidad.esperaMiliseg(200);
	}


	public void ingresarMonto() {
		MobileElement inputMonto = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.inputMonto)));
		base.saldoSinDecimal=base.saldoSinDecimal.add(new BigDecimal(20000));
		inputMonto.sendKeys(base.saldoSinDecimal.toString());
//		base.montoTransado = new BigDecimal(15000);
		utilidad.tomaEvidencia("Monto a recargar");

		utilidad.esperaMiliseg(100);
	}
	public void ingresarMontoMayor() {
		MobileElement inputMonto = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.inputMonto)));
		inputMonto.sendKeys("15000");
		base.montoTransado = new BigDecimal(15000);
		utilidad.tomaEvidencia("Monto a recargar");

		utilidad.esperaMiliseg(100);
	}
	
	public void ingresarMonto(String monto) {
		MobileElement inputMonto = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.inputMonto)));
		inputMonto.sendKeys(monto);
		utilidad.tomaEvidencia("Monto a recargar");
		utilidad.esperaMiliseg(100);
	}

	public String verificarScenario(Scenario scenario) {
		String valorAConsignar = "";
		System.out.println(base.saldo);
		if (scenario.getName().contains("valor mayor saldo")) {
			BigDecimal valorConsignar = base.saldo.add(new BigDecimal("15000.00"));
			valorAConsignar = String.valueOf(valorConsignar).split("\\.")[0];
		} else if (scenario.getName().contains("un valor menor"))
			valorAConsignar = "1000";
		else
			valorAConsignar = utilidad.generarMontoTransaccional();

		base.montoTransado = new BigDecimal(valorAConsignar);
		return valorAConsignar;
	}

	public void darClickNumCelARecargar() {
		MobileElement btnCelARecargar = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.btnCelARecargar)));
		btnCelARecargar.click();
	}

	public void ingresarNumeroARecargar(String numReferencia) {
		MobileElement inputNumeroRecarga = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.inputNumeroRecarga)));
		inputNumeroRecarga.sendKeys(numReferencia);
		base.cuentaONumero = numReferencia;
		utilidad.tomaEvidencia("ingreso numero a recargar");
	}

	public void darClickCuantaPlataRecaragr() {
		MobileElement btnCuantoRecargar = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.btnCuantoRecargar)));
		btnCuantoRecargar.click();
	}

	public void darClickEnSelectOperador() {
		MobileElement btnSelectOperador = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.btnSelectOperador)));
		btnSelectOperador.click();
	}

	public void desplegarListaOperador() {
		MobileElement btnListaOperadores = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.btnListaOperadores)));
		btnListaOperadores.click();
	}

	public void verificoResultadoRecarga(List<MobileElement> listaElementos) {
		String textoValidacion = "";
		for (MobileElement mobileElement : listaElementos) {
			if (mobileElement.getText().contains("Recarga exitosa")) {
				textoValidacion = "Recarga exitosa";
				break;
			} else
				textoValidacion = "No se encuentra 'Transaccion exitosa'";
		}
		assertEquals("Recarga exitosa", textoValidacion);
	}

	public void validarRecargaNegada() {
		String resultado;
		boolean validacion = false;
		try {
			MobileElement labelRecargaFallida = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.id(this.labelRecargaFallida)));
			resultado = labelRecargaFallida.getText();
		} catch (Exception e) {
			resultado = "Algo Salio Mal";
		}
		resultado = resultado.trim();
		System.out.println(resultado);
		if (resultado.equalsIgnoreCase("CUENTA NO EXISTE"))
			validacion = true;
		else if (resultado.contains("RECHAZADA POR FONDOS INSUFICIENTES"))
			validacion = true;
		else if (resultado.equalsIgnoreCase("EXCEDE CUPO"))
			validacion = true;
		else if (resultado.equalsIgnoreCase("Valor inferior al permitido"))
			validacion = true;

		assertTrue(validacion);

	}

	public void darClickFinalizar() {
		MobileElement btnFinalizar = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnFinalizar)));
		btnFinalizar.click();
	}
	
	public void validoLblFondosTransaccionDeclinada() {
		MobileElement lblExcedeCupo = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.labelCuentaNoExiste)));
		utilidad.esperaMiliseg(3000);
		assertEquals("TRANSACCION DECLINADA                 00", lblExcedeCupo.getText());
		utilidad.tomaEvidencia("Valido mensaje de transaccion declinada");
		utilidad.esperaMiliseg(2000);
		base.montoTransado = new BigDecimal(0);
		lblExcedeCupo.click();
	}
	
	public void validarLblFondosInsuficientes() {
		MobileElement lblExcedeCupo = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.lblFondonInsuficientes)));
		utilidad.esperaMiliseg(3000);
		System.out.println("Text: " +lblExcedeCupo.getText());
		assertEquals("RECHAZADA POR FONDOS INSUFICIENTES    07", lblExcedeCupo.getText());
		utilidad.tomaEvidencia("Valido mensaje de transaccion rechazada");
		utilidad.esperaMiliseg(2000);
		base.montoTransado = new BigDecimal(0);
//		lblExcedeCupo.click();
	}
	public void clicBtnRecargaMinutos() {
		utilidad.esperaMiliseg(6000);
		utilidad.darUnTap(364, 1170);
	}
	
	public void clicBtnRecargasMovistar() {
        try {
            contador++;
          MobileElement recargaMovistar = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
                  "new UiScrollable(new UiSelector().scrollable(true))" +
                   ".scrollIntoView(new UiSelector().text(\"Recarga de Minutos y Paquetes de Datos new url 03May\"))"));
          recargaMovistar.click();
        }catch(Exception e) {
            if(!(contador== 5)) {
                utilidad.esperaMiliseg(2000);
                clicBtnRecargasMovistar();
            }else {
                fail("No se encontro boton recarga movistar debido a: "+e.getMessage());
            }
        }finally {contador  = 0;}
        }
     
	
	public void clicBtnRecargas(){
		try {
			contador++;
			/*
			MobileElement recargaTelefonica = (MobileElement) base.driver.findElement(MobileBy.AndroidUIAutomator(
			        "new UiScrollable(new UiSelector().scrollable(true))" +
			         ".scrollIntoView(new UiSelector().text(\"Recargas Telefónica\"))"));
			recargaTelefonica.click();
			MobileElement recargas = (MobileElement) base.driver.findElement(MobileBy.AndroidUIAutomator(
			        "new UiScrollable(new UiSelector().scrollable(true))" +
			         ".scrollIntoView(new UiSelector().text(\"Recargas\"))"));
			recargas.click();*/
			
            MobileElement recargaTelefonica = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                     ".scrollIntoView(new UiSelector().text(\"Recarga Telefonica\"))"));
            recargaTelefonica.click();
            MobileElement btnRecargaMinutos = (MobileElement) wait
                    .until(ExpectedConditions.visibilityOfElementLocated(By.id(this.btnRecargaMinutos)));
            btnRecargaMinutos.click();
		}catch(Exception e) {
			if(!(contador== 10)) {
				utilidad.esperaMiliseg(2000);
				clicBtnRecargas();
			}else {
				fail("No se encontro boton recargar debido a: "+e.getMessage());
			}
		}finally {contador  = 0;}
		
		
	}
	public void seleccionarRecargarMinutos() {
		MobileElement btnRecargaMinutos = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.btnRecargaMinutos2 )));
		btnRecargaMinutos.click();
	}
}
