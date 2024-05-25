package daviplata.nacional.iOS.pageObjects;

import static org.junit.Assert.assertEquals;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import daviplata.nacional.iOS.definitions.Hooks;
import daviplata.nacional.iOS.utilidades.Utilidades;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import net.serenitybdd.core.pages.PageObject;

public class CuantoDeboPageObjects extends PageObject {

	
	private AppiumDriver<MobileElement> driver= Hooks.getDriver();
	private WebDriverWait wait =Hooks.getDriverWait();
	
	Utilidades utilidad;
	Utilidades Utilidades;

	// ------ Nanocredito Mora Cuanto debe-------------
	private String numeroCreditoId = "tv_credit_number";
	private String valorProximaCuotaId = "tv_min_pay";
	private String fechaProximoPagoId = "tv_pay_date";
	private String valorTotalId = "tv_max_pay";
	private String fechaConsultaId = "tv_query_date";
	private String valorPagadoChequeId = "tv_pay_with_check";
	private String elementos = "//*[@id='fullPaymentAmount']";
	private String labelCredito = "//*[@text='Crédito']";
	private String btnAtras = "//*[@id='nav_bar_btn_left']";
	private String textoDeuda = "//*[@id='tv_max_pay']";

	public void seleccionarNanocredito(String ultimosDigitosCredito) {
		MobileElement btnNanoCredito = (MobileElement) wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='****" + ultimosDigitosCredito + "']")));
//		btnNanoCredito.click();
		Utilidades.tomaEvidencia("Creditos en mora");
		List<MobileElement> creditosEnMora = Hooks.getDriver().findElements(By.xpath(elementos));
		for (MobileElement mobileElement : creditosEnMora) {

			mobileElement = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(mobileElement));
			mobileElement.click();
			validarCredito(mobileElement);
			Utilidades.tomaEvidencia("Validacion de credito");
			darClickAtras();
			waitFor(2).seconds();
			System.out.println(mobileElement.getText());
		}
		waitFor(10).milliseconds();
	}

	public void validarCredito(MobileElement credito) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.labelCredito)));
		String textoCredito = driver.findElement(By.xpath(this.labelCredito)).getText();
		
		assertEquals("Crédito", textoCredito);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.textoDeuda)));
		String textoDeuda = driver.findElement(By.xpath(this.textoDeuda)).getText();
		
		int deuda = 0;
		System.out.println(textoDeuda);
		deuda = Integer.parseInt(textoDeuda.replace("$", "").replace(".", ""));
		assertEquals(true, deuda>0);

	}
	
	public void darClickAtras() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAtras)));
		driver.findElement(By.xpath(this.btnAtras)).click();
	}

	public String obtenerNumeroCredito() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id(this.numeroCreditoId)));
		String labelNumeroCredito = driver.findElement(By.id(this.numeroCreditoId)).getText();
		return labelNumeroCredito;
	}

	public String obtenerValorProximaCuota() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id(this.valorProximaCuotaId)));
		String labelProximaCouta = driver.findElement(By.id(this.valorProximaCuotaId)).getText();
		return labelProximaCouta;
	}

	public String obtenerFechaProximoPago() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id(this.fechaProximoPagoId)));
		String labelFechaProximoPago = driver.findElement(By.id(this.fechaProximoPagoId)).getText();
		return labelFechaProximoPago;
	}

	public String obtenerFechaConsulta() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id(this.fechaConsultaId)));
		String labelFechaConsulta = driver.findElement(By.id(this.fechaConsultaId)).getText();
		return labelFechaConsulta;
	}

	public String obtenerValorTotal() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id(this.valorTotalId)));
		String labelValorTotal = driver.findElement(By.id(this.valorTotalId)).getText();
		return labelValorTotal;
	}

	public String obtenerValorPagadoCheque() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id(this.valorPagadoChequeId)));
		String labelValorPagadoCheque = driver.findElement(By.id(this.valorPagadoChequeId)).getText();
		return labelValorPagadoCheque;
	}

}
