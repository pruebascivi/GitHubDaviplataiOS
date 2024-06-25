package daviplata.nacional.iOS.pageObjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.fail;
import static org.hamcrest.MatcherAssert.assertThat;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.host.media.webkitMediaStream;

import daviplata.nacional.iOS.definitions.Hooks;
import daviplata.nacional.iOS.steps.WebRedebanSteps;
import daviplata.nacional.iOS.utilidades.Credenciales;
import daviplata.nacional.iOS.utilidades.CustomChromeDriver;
import daviplata.nacional.iOS.utilidades.Evidencias;
import daviplata.nacional.iOS.utilidades.Utilidades;
import daviplata.nacional.iOS.utilidades.BaseUtil;

import freemarker.core.ReturnInstruction.Return;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.safari.SafariDriver;


public class WebRedebanPageObjects {

	@Steps
	static
	WebRedebanSteps stepsWebRedeban;
	static Utilidades utilidad;
	static Utilidades Utilidades;
	static BaseUtil base;
	public String fechaHora = "-";

	static String numCelular = "";
	private static CustomChromeDriver confiChromeDriver;

	private static WebDriverWait wait;
	private static int contador = 0;
	private static String btnVolver = "//input[@value='Volver']";
	private static String btnContinuar = "//tr[7]/td/table/tbody/tr/td/div/form/input[1]";
	private static String btnContinuar2 = "//input[@value='Continue']";
	private static String inputUsuario = "//input[@name='login']";
	private static String inputPass = "//input[@name='password']";
	private static String btnEnviar = "//input[@name='enviar']";
	private static String btnradiobtn = "//*[@id=\"checkEditB\"]";
	private static String btnvistageneral = "//*[@id=\"generalForm\"]/table[2]/tbody/tr[2]/td[1]/button/img";
	private static String btnEnvia = "//tr[9]/td[2]/input";
	private static String btnSend = "//*[@name= 'b1']";
	private static String btnLimpiar = "//input[@value='Limpiar']";
	private static String btnAutorizador = "//a[text()='Autorizador']";
	private static String btnDebitoPrepago = "//a[text()='Debito Prepago']";
	private static String btnMonederos = "//a[text()='Monederos']";
	private static String btnOlvidoClave = "//*[@id='ASUL_1050']/li[2]/div/a";
	private static String inputDocumento = "//*[@id='cedula']";
	private static String btnListaExcepciones = "//a[text()='Lista de Excepciones']";
	private static String btnConsultaClientes = "//a[text()='Consulta Clientes']";
	private static String btnMovimientoDiario = "//a[text()='Movimiento Diario']";
	private static String btnConsultaCuposTarjeta = "//a[text()='Consulta de Cupos por Tarjeta']";
	private static String btnConsultas = "(//a[text()='Consultas'])[2]";
	private static String chkNumeroID = "//input[@value='cedula']";
	private static String inputNumeroID = "//input[@id='cedula']";
	private static String chkTarjetaID = "//input[@value='tarjeta']";
	private static String inputTarjetaID = "//input[@id='tarjeta']";
	private static String tdNumeroTarjeta = "//table[@class='table1']/tbody/tr[3]/td[9]";
	private static String txtNumeroTarjeta = "//table[@class='table1']/tbody/tr[";
	private static String inputTarjeta = "//input[@name='AMVTAR']";
	private static String inputFecha = "//input[@name='AMVFSI']";
	private static String btnAceptar = "//input[@value='Aceptar']";
	private static String lblResultados = "//td[@class='tdRowContTotal']";
	private static String btnSalir = "(//img)[6]";
	private static String btnSiguiente = "(//button[@class='formclass'])[3]";
	private static String tdExenta4x1000 = "//table[@class='table1']/tbody/tr[3]/td[12]";
	private static String tdEstadoCliente = "//table[@class='table1']/tbody/tr[3]/td[11]";
	private static String radioBtnConsulta3 = "(//input[@type='radio'])[3]";
	private static String btnDatosGeneralesTarjeta = "//button[@title='Datos Generales de Tarjeta']";
	private static String btnConsultaDatos = "//button[@title='Consultar']";
	private static String btnEnviarOlvidoClave = "//*[@id='generalForm']/table[2]/tbody/tr[4]/td[2]/input";
	private static String btnAceptarOlvidoClave = "//*[@id='generalForm']/table[6]/tbody/tr/td/input";
	private static String btnAppDviplata = "//a[contains(text(),'App Daviplata')]";
	private static String btnActualizarCorreoElectronico = "//a[contains(text(),'Actualizar Correo Electronico')]";
	private static String inputNumeroCelular = "//input[@id='daviplata']";
	private static String txtCorreoElectronico = "(//td[@class='tdRowCellCont2'])[8]";
	private static String mensajeClaveTemporal = "//*[@id='generalForm']/table[2]/tbody/tr[2]/td";
	private static String logoutRedeban = "//img[@src='/ASDebitMonWeb/images/pages/logout.gif']";
	private static String logoutRedebanOlvidoClave = "//img[@src='/ASPrivateCardMonWeb/images/pages/logout.gif']";
	private static String btnEnviarConsultaClientes = "//*[@name='enviar']";
	private static String btnCheckConsultaClientes = "//*[@id='checkEditB']";
	private static String campoCelularConsultaClientes = "//*[@id='generalForm']/table[2]/tbody/tr[3]/td[9]";

	// --------------------ConsultaClientes-----------------------//
	private static String lblTarjeta = "((//td[contains(text(),'Tarjeta')])/following::td[contains(text(),'88')])[1]";
	private static String lblBin = "";
	private static String lblFranquicia = "(//td[contains(text(),'Franquicia')])/following::td[1]";
	private static String lblTipoIdentificacion = "(//td[contains(text(),'Tipo Identificación')])/following::td[1]";
	private static String lblNombreRealce = "(//td[contains(text(),'Tipo Identificación')])/following::td[1]";
	private static String lblEstadoActual = "(//td[contains(text(),'Estado Actual')])/following::td[1]";
	private static String lblEstadoAnterior = "((//td[contains(text(),'Estado Anterior')])/following::td[1])";
	private static String lblTipoTarjeta = "((//td[contains(text(),'Tipo Tarjeta')])/following::td[1])";
	private static String lblSubTipo = "//*[@id=\"generalForm\"]/table[2]/tbody/tr[11]/td[2]";
	private static String lblExcenta4XMil = "((//td[contains(text(),'Exenta 4 x Mil')])/following::td[1])";
	// --------------------ConsultaCuposPorTarjeta------------------//
	private static String btnDetallesLimitesDisponibles = "//td[contains(text(),'DETALLE LIMITES Y DISPONIBLES')]";
	private static String btnMovimientoRealizado = "//td[contains(text(),'MOVIMIENTO REALIZADO')]";
	private static String lblEstadoCuenta = "//td[contains(text(),'Estado de Cuenta')]/following::td[1]";
	private static String lblIndicador4x1000 = "//td[contains(text(),'Indicador de 4 x Mil')]/following::td[1]";
	private static String lblEstado = "(//td[contains(text(),'Estado')]/following::td[1])[1]";
	private static String lblTipo = "//td[contains(text(),'Tipo')]/following::td[1]";
	private static String lblExenta4x1000 = "//td[contains(text(),'Exenta 4 x Mil')]/following::td[1]";
	private static String lblTotalSaldos = "(//td[contains(text(),'Total')]/following::td[1])[1]";
	private static String lblDisponibleSaldos = "(//td[contains(text(),'Disponible')]/following::td[1])[1]";
	private static String lblTotalDisponible = "(//td[contains(text(),'Total')]/following::td[1])[2]";
	private static String lblRealDisponible = "(//td[contains(text(),'Real')]/following::td[1])[1]";
	private static String lblSaldoDisponible4x1000 = "(//td[contains(text(),'Saldo Disponible')]/following::td[1])";
	private static String lblSaldoBolsillo = "(//td[contains(text(),'Saldo Bolsillos')]/following::td[1])";
	private static String lblAcumulado4x1000 = "(//td[contains(text(),'Acumulado')]/following::td[1])";
	private static String lblTotalAcumuladoDiario = "(//td[contains(text(),'Total')]/following::td[1])[1]";
	private static String lblAcumuladoMensualCredito = "(//td[contains(text(),'Acumulado mensual Credito')]/following::td[1])[1]";
	private static String lblAcumuladoMensualDebito = "(//td[contains(text(),'Acumulado mensual Debito')]/following::td[1])[1]";
	private static String lblUtilizacionesAcumuladas = "(//td[contains(text(),'Total')]/following::td[1])[2]";
//	//--------------------ConsultaMovimientosDiarios-------------//
	private static String txtTipoTransaccion = "(//table[@class='table1']//tr)[";
	private static String selectPaginacion = "//table[@class='table1']/tbody//select[@name='PAG_CONTROL']";
	private static String btnPaginacion = "(//button[@class='formclass'])[3]";
	private static String btnImgDetails = "(//button[@class='formclass'])[1]";
	private static String btnCheckBox = "//input[@name='checkEditB']";
	private static String txtFechaHoraRedeban = "(//td[@class='tdRowCellContNew'])[12]";
	private static String numTarjeta = "//*[@id=\"generalForm\"]/table[2]/tbody/tr[1]/td[2]";
	private static String txtTarjeta = "//td[contains(text(), 'Numero de Tarjeta')]"; 
	private static String btnVerDetalle = "//button[@title='Ver Detalle']";
	private static String txtSwitch = "//td[contains(text(), 'Switch')]//following::td[1]";
	public static final String INICIO_HOME_REDEBAN = "//*[contains(@src,'logoASNETLogin')]";

	
	public static void traerNumTarjeta() {

		String numeroTarjeta = element(By.xpath(numTarjeta)).getText();
		Serenity.setSessionVariable("numeroTarjeta").to(numeroTarjeta);
	}

	private static Alert element(By xpath) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Alert alertPage() {
		return base.chromeDriver.switchTo().alert();
	}

	private static int validoCodAutorizacion(String codigo) {
		int valor = returnTextLblResultados();

		for (int i = 2; i <= valor + 2; i++) {
//				 *[@id="generalForm"]/table[2]/tbody/tr[4]/td[10]
			WebElement element = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@id=\"generalForm\"]/table[2]/tbody/tr[" + i + "]/td[10]")));
			System.out.println(i + ":" + element.getText());
			try {
				if (element.getText().equalsIgnoreCase(codigo)) {
					System.out.println("fila" + i);
					return i;
				} else if (i == 12) {
					clicBtnSiguiente();
					i = 2;
					valor = valor - 10;
					System.out.println("Siguiente");
					utilidad.esperaMiliseg(3000);
					// utilidad.tomaEvidenciaPC("web-Pagina siguiente");

				}
			} catch (StaleElementReferenceException e) {
				validoCodAutorizacion(codigo);
			}


		}
		return 0;
	}

	private static int validarValorTransferencia(String valor) {
		int cantidadTabla = returnTextLblResultados();
		System.out.println("Valor que llega:" + valor);
		for (int i = 3; i <= cantidadTabla + 2; i++) {
//				 *[@id="generalForm"]/table[2]/tbody/tr[4]/td[4]
			WebElement element = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@id=\"generalForm\"]/table[2]/tbody/tr[" + i + "]/td[4]")));
			String valorRedeban = element.getText().replace(".", "").replace(",00", "").trim();
			System.out.println(i + ":-" + valorRedeban);
			try {
				if (valorRedeban.equalsIgnoreCase(valor)) {
					System.out.println("fila: " + i);
					return i;
				} else if (i == 12) {
					clicBtnSiguiente();
					i = 2;
					cantidadTabla = cantidadTabla - 10;
					System.out.println("Siguiente");
					utilidad.esperaMiliseg(3000);
					// utilidad.tomaEvidenciaPC("web-Pagina siguiente");

				}
			} catch (StaleElementReferenceException e) {
				validoCodAutorizacion(valor);
			}

		}
		return 0;
	}
	
	public static String returnValorTrans() {
	    String autorizador;
	    String monto1 = "0";
	    String monto_final = "0";
	    int cont = 0;

	    Utilidades.esperaMiliseg(2000);

	    while (true) {
	        // Variable para controlar si se encontró el elemento en la página actual
	        boolean elementoEncontrado = false;

	        for (int j = 3; j <= 12; j++) {
	        	try {
	            Utilidades.esperaMiliseg(4000);
	            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(
	                    By.xpath("//*[@id='generalForm']/table[2]/tbody/tr[" + j + "]/td[10]")));
	            Utilidades.esperaMiliseg(2000);
	            autorizador = element.getText();

	            System.out.println(autorizador + "   -   " + BaseUtil.Autorizador);
	            if (autorizador.equals(BaseUtil.Autorizador)) {
	                System.out.println("Entre a autorizador encontrado");

	                element = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                        By.xpath("//*[@id='generalForm']/table[2]/tbody/tr[" + j + "]/td[4]")));
	                monto1 = element.getText();
	                monto1 = monto1.replace(".", "").replace(",", "");
	                monto_final = monto1.substring(0, monto1.length() - 2);
	                assertThat(BaseUtil.montoTransado, is(equalTo(new BigDecimal(monto_final))));
	                System.out.println("Rompiendo ciclo: " + monto_final);

	                // Marca que el elemento fue encontrado en la página actual
	                elementoEncontrado = true;
	                return monto_final;
	                }
	        	}catch(Exception e) {
	            	System.out.println("No se encontrarón mas registros en la tabla, debido a: " + e.getMessage());
	            	break;
	            }
	        }

	        // Si no se encontró el elemento en la página actual, retrocede a la página anterior
	        if (!elementoEncontrado) {
	            try {
	                Utilidades.esperaMiliseg(6000);
	                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(
							By.xpath("(//button[@class='formclass'])[2]")));
					element = BaseUtil.chromeDriver.findElement(By.xpath("(//button[@class='formclass'])[2]"));
					Utilidades.esperaMiliseg(2500);
					if (element.isEnabled()) {
						element.click();
					}
	            } catch (Exception e) {
	                // Manejar la excepción si no hay más páginas para retroceder
	                System.out.println("No hay más páginas para retroceder");
	                break;
	            }
	        }
	    }

	    return monto_final;
	}
	

	
	
	
	
	
	public static void irHastaUltimaPaginaRegistros(String cantidadRegistros) {
		BaseUtil.chromeDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement element = null;
		try {
			int totalRegistros = Integer.parseInt(cantidadRegistros);
			int registrosPorPagina = 10;
			int paginas = (totalRegistros + registrosPorPagina - 1) / registrosPorPagina;
			BaseUtil.fila = obtenerUltimoDigito(totalRegistros);
			
			for (int i = 1; i < paginas; i++) {
				Utilidades.esperaMiliseg(6000);
				element = wait.until(ExpectedConditions.elementToBeClickable(
						By.xpath("(//button[@class='formclass'])[3]")));
				element = BaseUtil.chromeDriver.findElement(By.xpath("(//button[@class='formclass'])[3]"));
				Utilidades.esperaMiliseg(2500);
				if (element.isEnabled()) {
					element.click();
				}
			}
		} catch (Exception e) {
			clicBtnSalir("//img[contains(@src, 'logout.gif')]");
			cerrarWebRedeban();
			fail("Se produjo un error no esperado: " + e.getMessage());
		}
	}
	
    public static int obtenerUltimoDigito(int numero) {
        // Asumimos que el número siempre es positivo
        int ultimoDigito = numero % 10;

        if (ultimoDigito == 0) {
            return 12;  // Si el último dígito es 0, retornamos 12 (10 + 2)
        } else {
            return (ultimoDigito + 2);
        }
    }

	public static String returnValorregistrps() {
		// *[@id="generalForm"]/table[2]/tbody/tr[4]/td[4]

		try {
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"generalForm\"]/table[2]/tbody/tr[15]/td/table/tbody/tr[1]/td[2]")));
			return element.getText();
		} catch (Exception objException) {
			try {
				WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//*[@id=\"generalForm\"]/table[2]/tbody/tr[11]/td/table/tbody/tr[1]/td[2]")));
				return element.getText();
			}

			catch (Exception objExceptions) {

				WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//*[@id=\"generalForm\"]/table[2]/tbody/tr[13]/td/table/tbody/tr[1]/td[2]")));
				return element.getText();

			}
		}
	}

	public static String obtenerValorRegistros() {

		try {
			contador++;
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"generalForm\"]/table[2]/tbody/tr[15]/td/table/tbody/tr[1]/td[2]")));
			System.out.println("numero de registros: " + element.getText());
			return element.getText();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				obtenerValorRegistros();
			} else {
				fail("No se encontro valor de registros en redeban debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
			return "0";
		}
	}

	public static void obtenerValorTransado(String valor) {
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"generalForm\"]/table[2]/tbody/tr["
						+ validarValorTransferencia(valor) + "]/td[4]/following-sibling::td[5]")));
		String transaccionExitosa = element.getText();
		assertEquals("TRANSACCION EXITOSA", transaccionExitosa);

	}

	public static void clickCheckButtonTransaccion(String valor) {
		Utilidades.esperaMiliseg(1000);
		WebElement element1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"generalForm\"]/table[2]/tbody/tr["
						+ validarValorTransferencia(valor) + "]/td[4]/preceding-sibling::td[3]")));
		element1.click();
		utilidad.tomaEvidenciaPantalla("web-Valor encontrado");
	}

	public static void obtenerInformacionTransaccion() {
		Utilidades.esperaMiliseg(1000);
		WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnImgDetails)));
		element2.click();
		Utilidades.esperaMiliseg(1000);
		WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(txtFechaHoraRedeban)));
		String hora = element3.getText().substring(0, 5);
		System.out.println("Hora: " + hora);
		assertEquals(hora, base.fechaHora);
		utilidad.tomaEvidenciaPantalla("web-Información de la transacción");
	}

	private static int returnTextLblResultados() {
		Utilidades.esperaMiliseg(5000);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lblResultados)));
		return Integer.parseInt(element.getText());
	}

//	public static void main(String[] args) {
//		WebRedebanPageObjects wr=new WebRedebanPageObjects();
//		wr.abrirWebRedeban();
//		wr.sendKeysInputUsuario();
//	}

//	public void tomarEvidenciaRedeban(String descripcion) {
//		try {
//			Evidencias.capturaDispositivoPC(base.chromeDriver, descripcion);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	public static void sendKeysInputUsuario() {
//		base.driver.navigate().refresh();
		System.out.println(BaseUtil.chromeDriver.getWindowHandles());
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(inputUsuario)));
		element.sendKeys(Credenciales.propertiesWebs().getProperty("web.redeban.user"));
	}

	public static void sendKeysInputPass() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(inputPass)));
		element.sendKeys(Credenciales.propertiesWebs().getProperty("web.redeban.pass"));
	}

	public static void clicBtnContinuar() {
		// repo
		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnContinuar)));
			element.click();
		} catch (Exception e) {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnContinuar2)));
			element.click();
		}
	}

	public static void clicBtnEnvia() {
		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnEnvia)));
			element.click();
		} catch (Exception e) {
			WebElement element = BaseUtil.chromeDriver.findElement(By.xpath(btnSend));
			element.click();
		}
	}

	public static void clicBtnEnviar() {
		try {
			contador++;
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnEnviar)));
			element.click();
		} catch (Exception e) {
			if (!(contador == 20)) {
				utilidad.esperaMiliseg(2000);
				WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnEnviar)));
				JavascriptExecutor js = (JavascriptExecutor) base.chromeDriver;
				js.executeScript("arguments[0].removeAttribute('disabled','disabled')", element);
				clicBtnEnviar();
			} else {
				fail("No se pudo dar clic en boton Enviar en Redeban " + btnEnviar + " debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public static void clicRadioBtn() {
		Utilidades.esperaMiliseg(1000);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnradiobtn)));
		element.click();
	}

	public static void clicBtnVistaGeneral() {
		Utilidades.esperaMiliseg(1000);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnvistageneral)));
		element.click();
	}

	public static void clicBtnSiguiente() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnSiguiente)));
		element.click();
	}

	public static void clicBtnLimpiar() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnLimpiar)));
		element.click();
	}

	public static void clicBtnAutorizador() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnAutorizador)));
		element.click();
	}

	public static void clicBtnDebitoPrepago() {
//		base.base.chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(BaseUtil.chromeDriver.getWindowHandles());
		System.out.println(BaseUtil.chromeDriver.getTitle());
		for (String handles : base.chromeDriver.getWindowHandles()) {
			if (!base.chromeDriver.getWindowHandle().equals(handles)) {
				base.chromeDriver.switchTo().window(handles);
			}
		}
		System.out.println(base.chromeDriver.getTitle());
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnDebitoPrepago)));
		element.click();
	}

	public static void clicBtnMonederos() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnMonederos)));
		element.click();
	}

	public void clicBtnListaExcepciones() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnListaExcepciones)));
		element.click();
	}

	public static void clicBtnMovimientoDiario() {
		utilidad.esperaMiliseg(5000);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnMovimientoDiario)));
		element.click();
	}

	public void clicBtnConsultaCuposTarjeta() {
        WebElement element = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnConsultaCuposTarjeta)));
        element.click();
    }

	public void clicBtnConsultas() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(WebRedebanPageObjects.btnConsultas)));
        element.click();
    }

	public static void clicChkNumeroID() {
		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(chkNumeroID)));
			if (!(element.isSelected())) {
				element.click();
			} else {
				System.out.println("El check de Numero ID ya esta checkeado");
			}
		} catch (Exception e) {
			if (!(contador == 20)) {
				Utilidades.esperaMiliseg(2000);
				clicChkNumeroID();
			} else {
				fail("No se pudo dar clic en el Check Número ID de redeban " + chkNumeroID + " debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}
	
	public void clicChkNumeroID(int contar) {
        try {
            contador++;
            for (int i = 0; i < contar; i++) {
                WebElement element = wait
                        .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.chkNumeroID)));
                if (!(element.isSelected())) {
                    element.click();
                } else {
                    System.out.println("El check de Numero ID ya esta checkeado");
                }
            }

        } catch (Exception e) {
            if (!(contador == 20)) {
                Utilidades.esperaMiliseg(2000);
                clicChkNumeroID(contar);
            } else {
                fail("No se pudo dar clic en el Check Número ID de redeban " + this.chkNumeroID + " debido a: "
                        + e.getMessage());
            }
        } finally {
            contador = 0;
        }
    }
	
	public int returnEstadoDiferente(String estadoRedeban) {
        boolean flag = false;
        WebElement element = null;
        int conta = 3; // el xpath revisa desde el tr3 de la tabla en redeban
        WebElement table = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table1']")));
        List<WebElement> TotalRowsList = table.findElements(By.tagName("tr"));
        for (int i = 1; i <= TotalRowsList.size() - 8; i++) {
            element = BaseUtil.chromeDriver
                    .findElement(By.xpath("//*[@id='generalForm']/table[2]/tbody/tr[" + conta + "]/td[11]"));
            String estadoDaviplata = element.getText();
            if (estadoDaviplata.equalsIgnoreCase(estadoRedeban.trim())) {
                i = TotalRowsList.size();
                flag = true;
            } else {
                conta++;
                clicBtnSalir("//img[contains(@src, 'logout.gif')]");
                cerrarWebRedeban();
                System.out.println("Cerré Redeban Correctamente");
                fail("El estado de la cuenta del Daviplata debe estar en estado 'NOR' y no en: " + estadoDaviplata);
            }
        }
        if (flag)
            return conta;
        else
            return 0;
    }

	public static void clicChkTarjetaID() {
		try {
			contador++;
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(chkTarjetaID)));
			element.click();
		} catch (Exception e) {
			if (!(contador == 20)) {
				Utilidades.esperaMiliseg(2000);
				clicChkTarjetaID();
			} else {
				fail("No se pudo dar clic en el Check Tarjeta ID de redeban " + chkTarjetaID + " debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}
	
	public static boolean buscarAutorizadores(String numeroRegistros, List<String> autorizadores) {
		try {
			contador++;
			Integer registros = Integer.parseInt(numeroRegistros);
			System.out.println("numero de registros actual: "+ registros);
			WebElement botonSiguiente = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id=\"generalForm\"]/table[2]/tbody/tr[14]/td/table/tbody/tr/td[3]/button")));
			//*[@id="generalForm"]/table[2]/tbody/tr[3]/td[10]
			
			List<String> autorizadoresRestantes = buscarEnTablaAutorizador(autorizadores);
			
			System.out.println("autorizaodores restantes primer filtro: " + autorizadoresRestantes);
			while(registros > 0) {
				autorizadoresRestantes = buscarEnTablaAutorizador(autorizadoresRestantes);
				System.out.println("autorizadores restantes dentro de ciclo : " + autorizadoresRestantes);
				if(autorizadoresRestantes.size() > 0) {
					registros -= 10;
					System.out.println("reste registros actual pendiente : " + registros);
					botonSiguiente.click();
				}
			}
			
			boolean validoTodo = autorizadoresRestantes.size() == 0 ? true : false;
			System.out.println("valide todo y fue: " + validoTodo);
			assertTrue(validoTodo);
			
			return validoTodo;
		} catch (Exception e) {
			if (!(contador == 20)) {
				Utilidades.esperaMiliseg(2000);
				buscarAutorizadores(numeroRegistros, autorizadores);
			} else {
				fail("No se encontro el autorizador debido a redeban " + chkTarjetaID + " debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
			return false;
		}
	}
	public static List<String> buscarEnTablaAutorizador(List<String> autorizadores) {
		try {
			for(int i = 3; i <= 12; i++) {
				System.out.println("los autorizadores que buscare seran en esta iteracion: " + autorizadores);
				WebElement element = wait.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//*[@id=\"generalForm\"]/table[2]/tbody/tr["+i+"]/td[10]")));
				if(autorizadores.contains(element.getText())) {
					System.out.println("encontre el autorizador: " + element.getText());
					autorizadores.remove(element.getText());
				}
				if(autorizadores.size() == 0) return autorizadores;
			}
			System.out.println("retornare esta lista de autorizadores: " + autorizadores);
			return autorizadores;
		}catch(Exception e) {
			System.out.println("no encontre mas filas debido a: " + e.getMessage());
		}
		return autorizadores;
	}

	public static void clicBtnAceptar() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnAceptar)));
		element.click();
	}

	public static void clicBtnConsultaClientes() {

//		base.base.chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			WebElement element = base.chromeDriver.findElement(By.xpath(btnConsultaClientes));
			element.click();
		} catch (Exception e) {
			clicBtnDebitoPrepago();
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnConsultaClientes)));
			element.click();
		}
		Utilidades.esperaMiliseg(3000);
	}

	public static void sendKeysInputNumeroID(String text) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(inputNumeroID)));
		element.sendKeys(text);
	}
	
	public static void sendKeysWeb(String locatorType, String locator, String text) {
		
		By by = null;
		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
		element.sendKeys(text);
	}

	public static void sendKeysInputTarjetaID(String text) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(inputTarjetaID)));
		element.sendKeys(text);
	}

	public static String returnTdNumeroTarjeta() {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(tdNumeroTarjeta)));
		return element.getText();
	}

	public static String returnNumeroTarjetaNor() {
		String result = "";
		for (int i = 3; i < 10; i++) {
			String lblEstado = txtNumeroTarjeta + i + "]" + "/td[9]" + "/following-sibling::td[2]";
			String numeroTarjeta = txtNumeroTarjeta + i + "]" + "/td[9]";
			String estadoElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lblEstado))).getText();
			System.out.println("Estado:" + estadoElement);
			if (estadoElement.equalsIgnoreCase("NOR")) {
				String element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(numeroTarjeta))).getText();
				result = element;
				i = 11;
			}

		}
		return result;
	}

	public static String returnNumeroTarjeta(int row) {
		txtNumeroTarjeta = "//table[@class='table1']/tbody/tr[" + row + "]/td[9]";
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(txtNumeroTarjeta)));
		return element.getText();
	}

	public static void sendKeysInputFecha(String text) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(inputFecha)));
		element.sendKeys(text);
	}

	public static void sendKeysInputTarjeta(String text) {
		
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(inputTarjeta)));
		element.sendKeys(text);
	}

	public static void clicBtnSalir() {
		try {
			utilidad.esperaMiliseg(3000);
			WebElement element = base.chromeDriver.findElement(By.xpath(btnSalir));
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void clicBtnSalir(String xpath) {
		try {
			contador++;
			System.out.println("Estoy en Redeban Page Object");
			WebElement element = base.chromeDriver.findElement(By.xpath(xpath));
			element.click();
		} catch (Exception e) {
			if (!(contador == 20)) {
				Utilidades.esperaMiliseg(2000);
				clicBtnSalir(xpath);
			} else {
				fail("No se pudo dar clic en el boton salir de redeban " + xpath + " debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
		/*
		 * try { utilidad.esperaMiliseg(2000); WebElement element =
		 * base.chromeDriver.findElement(By.xpath(btnSalir)); element.click(); } catch
		 * (Exception e) { utilidad.esperaMiliseg(2000); WebElement element =
		 * base.chromeDriver.findElement(By.xpath(xpath)); element.click(); }
		 */
	}

	public static String returnTdExenta4x1000() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(tdExenta4x1000)));
		return element.getText();
	}

	public static String returnTdEstadoCliente() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(tdEstadoCliente)));
		return element.getText();
	}

	public static void clicRadioBtnDetallesConsultaCliente() {
		int radioButton = returnTdEstado();
		if (radioButton == 4) {
			radioButton = radioButton + 3;
		} else if (radioButton == 5) {
			radioButton = radioButton + 6;
		} else if (radioButton == 6) {
			radioButton = radioButton + 9;
		}
		utilidad.esperaMiliseg(1000);
		WebElement element = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='radio'])[" + radioButton + "]")));
		element.click();
	}

	public static void clicBtnDatosGeneralesTarjeta() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnDatosGeneralesTarjeta)));
		element.click();
	}

	public static void clicBtnConsultaDatos() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnConsultaDatos)));
		element.click();
	}

	public static String returnLblTarjeta() {
		int contador1 = 0;
		String auxiliar = "";
		WebElement element = null;
		do {
			try {
				element = base.chromeDriver.findElement(By.xpath(lblTarjeta));
				auxiliar = element.getText();
				contador = 5;
			} catch (Exception objException) {
				contador1++;
				System.out.println("Fallé en returnLblEstado: " + contador1);
				objException.printStackTrace();
			}
		} while (contador < 3);
		return auxiliar;
	}

	public static String returnLblFranquicia() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(lblFranquicia)));
		return element.getText();
	}

	public static String returnLblTipoIdentificacion() {

		int contador1 = 0;
		String auxiliar = "";
		WebElement element = null;
		do {
			try {
				base.chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				element = base.chromeDriver.findElement(By.xpath(lblTipoIdentificacion));
				auxiliar = element.getText();
				contador1 = 5;
			} catch (Exception objException) {
				contador1++;
				System.out.println("Fallé en returnLblTipoIdentificacion: " + contador1);
				objException.printStackTrace();
			}
		} while (contador1 < 3);
		return auxiliar;
	}

	public static String returnLblNombreRealce() {
		int contador3 = 0;
		String auxiliar = "";
		WebElement element = null;
		do {
			try {
				element = base.chromeDriver.findElement(By.xpath(lblNombreRealce));
				auxiliar = element.getText();
				contador3 = 5;
			} catch (Exception objException) {
				contador3++;
				System.out.println("Fallé en returnLblNombreRealce: " + contador3);
				objException.printStackTrace();
			}
		} while (contador3 < 3);
		return auxiliar;
	}

	public static String returnLblEstadoActual() {
		int contador = 0;
		String auxiliar = "";
		WebElement element = null;
		do {
			try {
				element = base.chromeDriver.findElement(By.xpath(lblEstadoActual));
				auxiliar = element.getText();
				contador = 5;
			} catch (Exception objException) {
				contador++;
				System.out.println("Fallé en returnLblEstadoActual: " + contador);
				objException.printStackTrace();
			}
		} while (contador < 3);
		return auxiliar;
	}

	public static String returnLblEstadoAnterior() {
		int contador = 0;
		String auxiliar = "";
		WebElement element = null;
		do {
			try {
				element = base.chromeDriver.findElement(By.xpath(lblEstadoAnterior));
				auxiliar = element.getText();
				contador = 5;
			} catch (Exception objException) {
				contador++;
				System.out.println("Fallé en returnLblEstadoAnterior: " + contador);
				objException.printStackTrace();
			}
		} while (contador < 3);
		return auxiliar;
	}

	public static String returnLblTipoTarjeta() {
		int contador = 0;
		String auxiliar = "";
		WebElement element = null;
		do {
			try {
				element = base.chromeDriver.findElement(By.xpath(lblTipoTarjeta));
				auxiliar = element.getText();
				contador = 5;
			} catch (Exception objException) {
				contador++;
				System.out.println("Fallé en returnLblTipoTarjeta: " + contador);
				objException.printStackTrace();
			}
		} while (contador < 3);
		return auxiliar;
	}

	public static String returnLblSubTipo() {
		/*
		 * int contador = 0; String auxiliar = ""; WebElement element = null; do { try {
		 * element = base.chromeDriver.findElement(By.xpath(lblSubTipo)); auxiliar =
		 * element.getText(); System.out.println(auxiliar); contador = 5; } catch
		 * (Exception objException) { contador++;
		 * System.out.println("Fallé en returnLblSubTipo: " + contador);
		 * objException.printStackTrace(); } } while (contador < 3);
		 * 
		 * return auxiliar;
		 */

		String result;
		String element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(lblSubTipo))).getText();
		result = element;

		return result;

	}

	public static String returnLblExcenta4XMil() {
		int contador = 0;
		String auxiliar = "";
		WebElement element = null;
		do {
			try {
				element = base.chromeDriver.findElement(By.xpath(lblExcenta4XMil));
				auxiliar = element.getText();
				contador = 5;
			} catch (Exception objException) {
				contador++;
				System.out.println("Fallé en returnLblExcenta4XMil: " + contador);
				objException.printStackTrace();
			}
		} while (contador < 3);
		return auxiliar;
	}

	public static int returnTdEstado() {
		boolean flag = false;
		WebElement element = null;
		int conta = 3; // el xpath revisa desde el tr3 de la tabla en redeban
		WebElement table = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='table1']")));
		List<WebElement> TotalRowsList = table.findElements(By.tagName("tr"));
		for (int i = 1; i <= TotalRowsList.size() - 8; i++) {
			element = base.chromeDriver
					.findElement(By.xpath("//*[@id='generalForm']/table[2]/tbody/tr[" + conta + "]/td[11]"));
			System.out.println("Element:" + element.getText());
			flag = true;
			/*if (element.getText().equalsIgnoreCase("NOR") || element.getText().equalsIgnoreCase("APT") || element.getText().equalsIgnoreCase("BLI")) {
				i = TotalRowsList.size();
				flag = true;
			} else {
				conta++;
			}*/
		}
		if (flag)
			return conta;
		else
			return 0;
	}
	
	public int validarEstadoUsuarios(String estado) {
        boolean flag = false;
        WebElement element = null;
        int conta = 3; // el xpath revisa desde el tr3 de la tabla en redeban
        WebElement table = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='table1']")));
        List<WebElement> TotalRowsList = table.findElements(By.tagName("tr"));
        for (int i = 1; i <= TotalRowsList.size() - 8; i++) {
            element = BaseUtil.chromeDriver
                    .findElement(By.xpath("//*[@id='generalForm']/table[2]/tbody/tr[" + conta + "]/td[11]"));
            System.out.println("Element:" + element.getText());
            if (element.getText().equalsIgnoreCase(estado)) {
                i = TotalRowsList.size();
                flag = true;
            } else {
                conta++;
            }
        }
        if (flag)
            return conta;
        else
            return 0;
    }

	public static int returnContEstado() {
		boolean flag = false;
		WebElement element = null;
		int conta = 3;
		WebElement table = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='table1']")));
		List<WebElement> TotalRowsList = table.findElements(By.tagName("tr"));
		System.out.println("Numero de filas de la tabla: " + TotalRowsList.size());
		for (int i = 1; i <= TotalRowsList.size() - 8; i++) {
			element = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//*[@id=\"generalForm\"]/table[2]/tbody/tr[" + conta + "]/td[11]")));
			System.out.println(element.getText());
			if (!element.getText().equalsIgnoreCase("RET")) {
				i = TotalRowsList.size();
				flag = true;
			} else {
				conta++;
			}
		}
		if (flag)
			return conta;
		else
			return 0;
	}

	public static void clicBtnMovimientoRealizado(int contar) {
		for(int i=0; i<contar; i++) {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnMovimientoRealizado)));
			element.click();			
		}		
	}

	public static void clicBtnDetallesLimitesDisponibles(int contar) {	
		for(int i=0; i<contar; i++) {
			WebElement element = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(btnDetallesLimitesDisponibles)));
			element.click();
			Utilidades.esperaMiliseg(1500);
		}	
	}



	public static String returnLblEstadoCuenta() {
		String texto = "";
		try {
			WebElement element = base.chromeDriver.findElement(By.xpath(lblEstadoCuenta));
			texto = element.getText();
		} catch (Exception objException) {
			System.out.println("----------------------------------------");
			System.out.println("No cargó página después de pulsar consultar límites");
			System.out.println("----------------------------------------");
		}
		return texto;
	}

	public static String returnLblIndicador4x1000() {
		String texto = "";
		try {
			base.chromeDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			utilidad.esperaMiliseg(5000);
			WebElement element = base.chromeDriver.findElement(By.xpath(lblIndicador4x1000));
			texto = element.getText();
		} catch (Exception objException) {
			System.out.println("----------------------------------------");
			System.out.println("No cargó página después de pulsar consultar límites");
			System.out.println("----------------------------------------");
		}
		return texto;
	}

	public static String returnLblEstado() {
		int contador = 0;
		String auxiliar = "";
		WebElement element = null;
		do {
			try {
				utilidad.esperaMiliseg(1000);
				element = base.chromeDriver.findElement(By.xpath(lblEstado));
				auxiliar = element.getText();
				contador = 5;
			} catch (Exception objException) {
				contador++;
				System.out.println("Fallé en returnLblEstado: " + contador);
				objException.printStackTrace();
			}
		} while (contador < 3);
		return auxiliar;
	}

	public static String returnLblTipo() {
		int contador = 0;
		String auxiliar = "";
		WebElement element = null;
		do {
			try {
				utilidad.esperaMiliseg(1000);
				element = base.chromeDriver.findElement(By.xpath(lblTipo));
				auxiliar = element.getText();
				contador = 5;
			} catch (Exception objException) {
				contador++;
				System.out.println("Fallé en returnLblTipo: " + contador);
				objException.printStackTrace();
			}
		} while (contador < 3);
		return auxiliar;
	}

	public static String returnLblExenta4x1000() {
		int contador = 0;
		String auxiliar = "";
		WebElement element = null;
		do {
			try {
				utilidad.esperaMiliseg(1000);
				element = base.chromeDriver.findElement(By.xpath(lblExenta4x1000));
				auxiliar = element.getText();
				contador = 5;
			} catch (Exception objException) {
				contador++;
				System.out.println("Fallé en returnLblExenta4x1000: " + contador);
				objException.printStackTrace();
			}
		} while (contador < 3);
		return auxiliar;
	}

	public static String returnLblTotalSaldos() {
		int contador = 0;
		String auxiliar = "";
		WebElement element = null;
		do {
			try {
				utilidad.esperaMiliseg(1000);
				element = base.chromeDriver.findElement(By.xpath(lblTotalSaldos));
				auxiliar = element.getText();
				contador = 5;
			} catch (Exception objException) {
				contador++;
				System.out.println("Fallé en returnLblTotalSaldos: " + contador);
				objException.printStackTrace();
			}
		} while (contador < 3);
		return auxiliar;
	}

	public static String returnLblDisponibleSaldos() {
		int contador = 0;
		String auxiliar = "";
		WebElement element = null;
		do {
			try {
				utilidad.esperaMiliseg(1000);
				element = base.chromeDriver.findElement(By.xpath(lblDisponibleSaldos));
				auxiliar = element.getText();
				contador = 5;
			} catch (Exception objException) {
				contador++;
				System.out.println("Fallé en returnLblDisponibleSaldos: " + contador);
				objException.printStackTrace();
			}
		} while (contador < 3);
		return auxiliar;
	}

	public static String returnLblTotalDisponible() {
		int contador = 0;
		String auxiliar = "";
		WebElement element = null;
		do {
			try {
				utilidad.esperaMiliseg(1000);
				element = base.chromeDriver.findElement(By.xpath(lblTotalDisponible));
				auxiliar = element.getText();
				contador = 5;
			} catch (Exception objException) {
				contador++;
				System.out.println("Fallé en returnLblTotalDisponible: " + contador);
				objException.printStackTrace();
			}
		} while (contador < 3);
		return auxiliar;
	}

	public static String returnLblRealDisponible() {
		System.out.println("entre a return lbl real disponible");
		int contador = 0;
		String auxiliar = "";
		WebElement element = null;
		do {
			try {
				utilidad.esperaMiliseg(1000);
				element = base.chromeDriver.findElement(By.xpath(lblRealDisponible));
				auxiliar = element.getText();
				contador = 5;
			} catch (Exception objException) {
				contador++;
				System.out.println("Fallé en returnLblTotalDisponible: " + contador);
				objException.printStackTrace();
			}
		} while (contador < 3);
		return auxiliar;
	}

	public static String returnLblSaldoDisponible4x1000() {
		int contador = 0;
		String auxiliar = "";
		WebElement element = null;
		do {
			try {
				utilidad.esperaMiliseg(1000);
				element = base.chromeDriver.findElement(By.xpath(lblSaldoDisponible4x1000));
				auxiliar = element.getText();
				contador = 5;
			} catch (Exception objException) {
				contador++;
				System.out.println("Fallé en returnLblTotalDisponible: " + contador);
				objException.printStackTrace();
			}
		} while (contador < 3);
		return auxiliar;
	}

	public static String returnLblSaldoBolsillo() {
		int contador = 0;
		String auxiliar = "";
		WebElement element = null;
		do {
			try {
				utilidad.esperaMiliseg(1000);
				element = base.chromeDriver.findElement(By.xpath(lblSaldoBolsillo));
				auxiliar = element.getText();
				contador = 5;
			} catch (Exception objException) {
				contador++;
				System.out.println("Fallé en returnLblTotalDisponible: " + contador);
				objException.printStackTrace();
			}
		} while (contador < 3);
		return auxiliar;
	}

	public static String returnLblAcumulado4x1000() {
		int contador = 0;
		String auxiliar = "";
		WebElement element = null;
		do {
			try {
				utilidad.esperaMiliseg(1000);
				element = base.chromeDriver.findElement(By.xpath(lblAcumulado4x1000));
				auxiliar = element.getText();
				contador = 5;
			} catch (Exception objException) {
				contador++;
				System.out.println("Fallé en returnLblTotalDisponible: " + contador);
				objException.printStackTrace();
			}
		} while (contador < 3);
		return auxiliar;
	}

	public static String returnLblTotalAcumuladoDiario() {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lblTotalAcumuladoDiario)));
		return element.getText();
	}

	public static String returnLblAcumuladoMensualCredito() {
		utilidad.esperaMiliseg(2000);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lblAcumuladoMensualCredito)));
		base.topeCreditos = element.getText();
		System.out.println(base.topeCreditos);
		return element.getText();
	}

	public static String returnLblAcumuladoMensualDebito() {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lblAcumuladoMensualDebito)));
		base.topeDebitos = element.getText();
		return element.getText();
	}

	public static String returnLblUtilizacionesAcumuladas() {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lblUtilizacionesAcumuladas)));
		return element.getText();
	}

	public static String clicRadioBtnConsulta3() {
		String texto = "";
		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(radioBtnConsulta3)));
			/*
			 * base.chromeDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			 * WebElement element =
			 * base.chromeDriver.findElement(By.xpath(radioBtnConsulta3));
			 */
			element.click();
			texto = "ok";
		} catch (Exception e) {
			if (!(contador == 20)) {
				Utilidades.esperaMiliseg(2000);
				clicRadioBtnConsulta3();
			} else {
				fail("No se pudo dar clic en RadioButton Consulta Redeban " + radioBtnConsulta3 + " debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}
		/*
		 * String texto = ""; try {
		 * base.chromeDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 * WebElement element =
		 * base.chromeDriver.findElement(By.xpath(radioBtnConsulta3)); element.click();
		 * texto = "ok"; } catch (Exception objException) {
		 * System.out.println("----------------------------------------");
		 * System.out.println("Falló en clicRadioBtnConsulta3");
		 * System.out.println("----------------------------------------"); }
		 */
		return texto;
	}

	public static String returnLblBin() {
		String texto = "";
		try {
			base.chromeDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			int row = returnTdEstado();
			if (row != 0) {
				WebElement element = base.chromeDriver
						.findElement(By.xpath("//*[@id='generalForm']/table[2]/tbody/tr[" + row + "]/td[8]"));
				texto = element.getText();
			}
		} catch (Exception objException) {
			System.out.println("----------------------------------------");
			System.out.println("Fallé en returnLblBin");
			System.out.println("----------------------------------------");
		}
		return texto;

		// Verificar si lo comentado funciona igual a lo de arriba. -> Diego.

//		base.chromeDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		int row = returnTdEstado();
//		String texto = "";
//		if (row != 0) {
//			try {
//				WebElement element = base.chromeDriver.findElement(By.xpath("//*[@id='generalForm']/table[2]/tbody/tr[" + row + "]/td[8]"));
//				texto = element.getText();
//			} catch (Exception objException) {
//				System.out.println("----------------------------------------");
//				System.out.println("No cargó página después de pulsar enviar");
//				System.out.println("----------------------------------------");
//			}
//			return texto;
//		} else {
//			return "";
//		}
	}

	public static String returnNumeroBin(int row) {
		String texto = "";
		if (row != 0) {
			try {
				WebElement element = wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//*[@id='generalForm']/table[2]/tbody/tr[" + row + "]/td[8]")));
				texto = element.getText();
				System.out.println("Text" + texto);
			} catch (Exception objException) {
				System.out.println("----------------------------------------");
				System.out.println("No cargó página después de pulsar enviar");
				System.out.println("----------------------------------------");
			}
			return texto;
		} else {
			return "";
		}
	}

	public static void clicBtnAppDaviplata() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnAppDviplata)));
		element.click();
	}

	public static void clicBtnActualizarCorreoElectronico() {
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(btnActualizarCorreoElectronico)));
		element.click();
	}

	public static void ingresarNumeroCelular(String NumCelular) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(inputNumeroCelular)));
		element.sendKeys(NumCelular);
	}

	public static String obtenerCorreoElectronico() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(txtCorreoElectronico)));
		String correo = element.getText();
		utilidad.tomaEvidenciaPantalla("Obteniendo Correo Actual Web Redeban");
		return correo;
	}

	public static ArrayList<String> obtenerDatosCompra() {
		ArrayList<String> datosCompra = new ArrayList<String>();
		String tipoTransaccion = "";
		String valorPago = "";
		String numAprobacion = "";
		seleccionarUltimaPaginaTabla();
		Utilidades.esperaMiliseg(1500);
		WebElement table = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='table1']")));
		List<WebElement> TotalRowsList = table.findElements(By.tagName("tr"));
		for (int i = TotalRowsList.size() - 6; i >= 1; i--) {
			String xpathTipoTransaccion = txtTipoTransaccion + i + "]//td[7]";
			String xpathValorPago = txtTipoTransaccion + i + "]//td[4]";
			String xpathNumeroAprob = txtTipoTransaccion + i + "]//td[10]";
			WebElement txtTipoTransaccion = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathTipoTransaccion)));
			tipoTransaccion = txtTipoTransaccion.getText();
			if (tipoTransaccion.equalsIgnoreCase("COMPRA")) {
				WebElement txtValorPago = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathValorPago)));
				valorPago = txtValorPago.getText();
				WebElement txtNumAprob = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathNumeroAprob)));
				numAprobacion = txtNumAprob.getText();
				datosCompra.add(valorPago);
				datosCompra.add(numAprobacion);
				utilidad.tomaEvidenciaPantalla(numAprobacion);
				i = 0;
			}
		}
		return datosCompra;
	}

	public static void seleccionarUltimaPaginaTabla() {
		Select dropDown = new Select(base.chromeDriver.findElement(By.xpath(selectPaginacion)));
		List<WebElement> TotalRowsList = dropDown.getOptions();
		if (TotalRowsList.size() > 1) {
			for (int i = 1; i < TotalRowsList.size(); i++) {
				WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnPaginacion)));
				element.click();
			}
		}
	}

	// ---------------------------------------------------------------------------------------------------------------------------------------
	
	public static void clicRadioBtnPorNumeroCelular(String celular)
	{
		String xpathBtnRadiobtn = "//*[contains(text(), '"+ celular +"')]//preceding::td[8]";
		Utilidades.esperaMiliseg(1000);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathBtnRadiobtn)));
		element.click();
	}

	
	
	//---------------------------------------------------------------------------------------------------------------------------------------
	public static String returnEstadoExcenta4x1000(int row) {
		String texto = "";
		if (row != 0) {
			try {
				WebElement element = wait.until(ExpectedConditions.elementToBeClickable(
						By.xpath("//*[@id='generalForm']/table[2]/tbody/tr[" + row + "]/td[12]")));
				texto = element.getText();
				System.out.println("Text" + texto);
			} catch (Exception objException) {
				System.out.println("----------------------------------------");
				System.out.println("No cargó página después de pulsar enviar");
				System.out.println("----------------------------------------");
			}
			return texto;
		} else {
			return "";
		}
	}

	public static void clicMonederos() {
		try {
		    contador++;
		    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnMonederos)));
			element.click();					
		}catch(Exception e) {
		    if(!(contador==5)) {
		    	utilidad.esperaMiliseg(2000);
			    clicMonederos();
		    }else {
		    	fail("No se encontró botón monederos en redeban, debido a: " + e.getMessage());
		    }
		}finally {contador=0;}	
	}
	
	public static void clicOlvidoClave() {
		try {
		    contador++;
		    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnOlvidoClave)));
			element.click();					
		}catch(Exception e) {
		    if(!(contador==5)) {
		    	utilidad.esperaMiliseg(2000);
		    	clicOlvidoClave();
		    }else {
		    	fail("No se encontró botón 'olvido clave' en redeban, debido a: " + e.getMessage());
		    }
		}finally {contador=0;}
		
		
	}
	
	public static void ingresarDocumento(String usuario) {
		try {
		    contador++;
		    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(inputDocumento)));
			element.sendKeys(usuario);					
		}catch(Exception e) {
		    if(!(contador==5)) {
		    	utilidad.esperaMiliseg(2000);
		    	ingresarDocumento(usuario);
		    }else {
		    	fail("No se encontró input 'Numero Documento' en redeban, debido a: " + e.getMessage());
		    }
		}finally {contador=0;}
		
		
	}
	
	public static void clicEnviarOlvidoClave() {
		try {
		    contador++;
		    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnEnviarOlvidoClave)));
			element.click();			
		}catch(Exception e) {
		    if(!(contador==5)) {
		    	utilidad.esperaMiliseg(2000);
		    	clicEnviarOlvidoClave();
		    }else {
		    	fail("No se encontró botón 'Enviar' de olvido clave en redeban, debido a: " + e.getMessage());
		    }
		}finally {contador=0;}
		
		
	}
	
	public static void clicAceptarOlvidoClave() {
		try {
		    contador++;
		    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnAceptarOlvidoClave)));
			element.click();			
		}catch(Exception e) {
		    if(!(contador==5)) {
		    	utilidad.esperaMiliseg(2000);
		    	clicAceptarOlvidoClave();
		    }else {
		    	fail("No se encontró botón 'Aceptar' de olvido clave en redeban, debido a: " + e.getMessage());
		    }
		}finally {contador=0;}
		
		
	}
	
	public static void clicAceptarAlerta() {
		try {
		    contador++;
		    utilidad.esperaMiliseg(2000);
		    Alert alert = base.chromeDriver.switchTo().alert();
		    alert.accept();
		}catch(Exception e) {
		    if(!(contador==5)) {
		    	utilidad.esperaMiliseg(2000);
		    	clicAceptarAlerta();
		    }else {
		    	fail("No se encontró botón 'Aceptar' en la alerta de olvido clave en redeban, debido a: " + e.getMessage());
		    }
		}finally {contador=0;}
		
		
	}
	
	public static void validarActivacionClaveTemporal() {
		try {
		    contador++;
		    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(mensajeClaveTemporal)));
			assertThat(element.getText(), containsString("LA CLAVE SE HA REASIGNADO EXITOSAMENTE"));
		}catch(Exception e) {
		    if(!(contador==5)) {
		    	utilidad.esperaMiliseg(2000);
		    	validarActivacionClaveTemporal();
		    }else {
		    	fail("No se encontró mensaje de activacion de la clave temporal en olvido clave redeban, debido a: " + e.getMessage());
		    }
		}finally {contador=0;}
		
		
	}
	
	public static void logoutRedebanDebitoPrepago() {
		try {
		    contador++;
		    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(logoutRedeban)));
			element.click();
		}catch(Exception e) {
		    if(!(contador==5)) {
		    	utilidad.esperaMiliseg(2000);
		    	logoutRedebanDebitoPrepago();
		    }else {
		    	fail("No se encontró botón de 'Logout' en debito prepago redeban, debido a: " + e.getMessage());
		    }
		}finally {contador=0;}

	}
	
	public static void logoutRedebanOlvidoClave() {
		try {
		    contador++;
		    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(logoutRedebanOlvidoClave)));
			element.click();
		}catch(Exception e) {
		    if(!(contador==5)) {
		    	utilidad.esperaMiliseg(2000);
		    	logoutRedebanOlvidoClave();
		    }else {
		    	fail("No se encontró botón de 'Logout' en olvido clave redeban, debido a: " + e.getMessage());
		    }
		}finally {contador=0;}

	}
	
	public static void clicEnviarConsultaClientes() {
		try {
		    contador++;
		    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnEnviarConsultaClientes)));
			element.click();
		}catch(Exception e) {
		    if(!(contador==5)) {
		    	utilidad.esperaMiliseg(2000);
		    	clicEnviarConsultaClientes();
		    }else {
		    	fail("No se encontró botón 'Enviar' consulta de clientes redeban, debido a: " + e.getMessage());
		    }
		}finally {contador=0;}

	}
	
	public static void clicCheckConsultaClientes() {
		try {
		    contador++;
		    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnCheckConsultaClientes)));
			element.click();
		}catch(Exception e) {
		    if(!(contador==5)) {
		    	utilidad.esperaMiliseg(2000);
		    	clicCheckConsultaClientes();
		    }else {
		    	fail("No se encontró checkbox consulta de clientes redeban, debido a: " + e.getMessage());
		    }
		}finally {contador=0;}

	}
	
	public static void obtenerNumeroCelularConsultaClientes() {
		try {
		    contador++;
		    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(campoCelularConsultaClientes)));
			String numeroTarjeta = element.getText();
			numCelular = numeroTarjeta.substring(9);		
		}catch(Exception e) {
		    if(!(contador==5)) {
		    	utilidad.esperaMiliseg(2000);
		    	obtenerNumeroCelularConsultaClientes();
		    }else {
		    	fail("No se encontró campo de celular en consulta de clientes redeban, debido a: " + e.getMessage());
		    }
		}finally {contador=0;}

	}



	public static String validarValorRegistros() {
		String registros = "";
		try {
			contador++;
			utilidad.esperaMiliseg(2000);
			WebElement element = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[@class='tdRowContTotal']")));
			registros = element.getText();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				validarValorRegistros();
			} else {
				fail("No se encontró texto de registros de las transacciones de redeban, debido a: " + e.getMessage());
			}

		} finally {
			contador = 0;
		}
		return registros;
	}

	public static void abrirWebRedeban() {
        confiChromeDriver.iniciarChromeDriver();
        BaseUtil.chromeDriver.get(Credenciales.propertiesWebs().getProperty("web.redeban.url"));
        BaseUtil.chromeDriver.manage().window().maximize();
        wait = new WebDriverWait(BaseUtil.chromeDriver, 60);
		
//		WebDriver driver = new SafariDriver();
//		driver.get("http://www.rbmtest.com.co/AdminMenuMonWeb/pages/welcome/Login.jsp");
    }

	public static void cerrarWebRedeban() {
		BaseUtil.chromeDriver.quit();
	}
	
	public static void validarTopesCreditos(String topecredito) {
		String creditoMensual = base.topeCreditos.replace(".","").replace(",00","");
		base.topeCreditosActual = topecredito;
		int num1 = Integer.parseInt(base.topeCreditosActual);
		int num2 = Integer.parseInt(creditoMensual);
		if (num1 < num2) {
			int extractoCredito = num2 - num1;
			base.sumaCredito = extractoCredito + 5000;
		} else if (num1 > num2) {
			int extractoCredito = num1 - num2;
			base.sumaCredito = extractoCredito + 5000;

		} else if (num1 == num2) {
			int extractoCredito = num1 - num2;
			base.sumaCredito = extractoCredito + 5000;
		}
	}
	
	public static void validarTopesDebito(String topeDebitos) {
		String debitoMensual = base.topeDebitos.replace(".","").replace(",00","");
		System.out.println("debito: " + debitoMensual);
		base.topeDebitosActual = topeDebitos;
		int num1 = Integer.parseInt(base.topeDebitosActual);
		int num2 = Integer.parseInt(debitoMensual);
		if (num1 < num2) {
			int extractoDebito = num2 - num1;
			base.sumaDebito = extractoDebito + 5000;
		} else if (num1 > num2) {
			int extractoDebito = num1 - num2;
			base.sumaDebito = extractoDebito + 5000;

		} else if (num1 == num2) {
			int extractoDebito = num1 - num2;
			base.sumaDebito = extractoDebito + 5000;
		}
	}

	public static void validarTopesDebitoDestino(String topeDebitos) {
		String debitoMensual = base.topeDebitos;
		base.topeDebitosActual = topeDebitos;
		int num1 = Integer.parseInt(base.topeDebitosActual);
		int num2 = Integer.parseInt(debitoMensual);
		if (num2 >= num1) {
			System.out.println("***El tope debito del daviplata se encuentra en el rango actual de topes***");
		} else {
			System.out.println("***El tope debito del daviplata no se encuentra en el rango actual de topes***");
		}
	}

	public static void esperarVisibilidadNumeroTarjeta() {
		try {
			contador++;
			Utilidades.esperaMiliseg(2000);
			WebElement element = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath(txtTarjeta)));
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				esperarVisibilidadNumeroTarjeta();
			} else {
				clicBtnSalir("//img[@src='/AutorizadorMonWeb/images/pages/logout.gif']");
				cerrarWebRedeban();
				fail("No se pudo obtener visibilidad de saldos en redeban, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}
	public static void clicCheckboxRedeban() {
		String checkBoxTransaccion = "//*[contains(text(), '"+ base.Autorizador +"')]//preceding-sibling::td[9]";
			try {
				contador++;
				WebElement element = wait
						.until(ExpectedConditions.presenceOfElementLocated(By.xpath(checkBoxTransaccion)));
				element.click();
			} catch (Exception e) {
				if (!(contador == 5)) {
					utilidad.esperaMiliseg(2000);
					clicCheckboxRedeban();
				} else {
					fail("No se encontró botón checkbox en redeban de la validación de la transacción, debido a: " + e.getMessage());
				}

			} finally {
				contador = 0;
			}

		}
	public static void clicBotonVerDetalle() {
		try {
			contador++;
			WebElement element = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(btnVerDetalle)));
			element.click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				clicBotonVerDetalle();
			} else {
				fail("No se encontró botón 'Ver Detalle' en redeban de la validación de la transacción, debido a: " + e.getMessage());
			}

		} finally {
			contador = 0;
		}

	}
	
	public static String validarSwitch() {
		String switchText = "";
		
		try {
			contador++;
			WebElement element = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath(txtSwitch)));
			switchText = element.getText();
			return switchText;
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				clicBotonVerDetalle();
			} else {
				fail("No se encontró botón 'Ver Detalle' en redeban de la validación de la transacción, debido a: " + e.getMessage());
			}

		} finally {
			contador = 0;
		}
		return switchText;

	}

	



}
