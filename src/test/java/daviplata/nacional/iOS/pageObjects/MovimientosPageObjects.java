package daviplata.nacional.iOS.pageObjects;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import daviplata.nacional.iOS.definitions.Hooks;
import daviplata.nacional.iOS.utilidades.Utilidades;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import net.serenitybdd.core.pages.PageObject;

public class MovimientosPageObjects extends PageObject {
	
	private AppiumDriver<MobileElement> driver= Hooks.getDriver();
	private WebDriverWait wait =Hooks.getDriverWait();
	Utilidades utilidad;
	Utilidades Utilidades;
	private String lblUltimosMovimientos = "//*[contains(@name,'Últimos movimientos')]";
	private String btnSelectMesAno = "//XCUIElementTypeApplication[@name=\"DaviPlata\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTextField";
	private String selectMesAno = "//XCUIElementTypePickerWheel[1]";
	private String btnEnviarCorreo = "//XCUIElementTypeButton[@name=\"Enviar a correo electrónico\"]";
	private String lblMovimientosAlCorreo = "//XCUIElementTypeStaticText[@name=\"Sus movimientos han sido enviados a su correo electrónico registrado.\"]";
	private String btnAceptarXpath = "//XCUIElementTypeButton[@name=\"Aceptar\"]";
	private String lblFechaPrimerTrans="//XCUIElementTypeApplication[@name=\"DaviPlata\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeTable/XCUIElementTypeCell[1]//XCUIElementTypeStaticText[2]";
	private String lblTipoTrans="//XCUIElementTypeApplication[@name=\\\"DaviPlata\\\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeTable/XCUIElementTypeCell[1]//XCUIElementTypeStaticText[1]";
	private String lblValorTrans="//XCUIElementTypeApplication[@name=\\\"DaviPlata\\\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeTable/XCUIElementTypeCell[1]//XCUIElementTypeStaticText[3]";
	
	
	public void validoLblUltimosMovimientos() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.lblUltimosMovimientos)));
		boolean lblUltimosMovimientos = driver.findElement(By.xpath(this.lblUltimosMovimientos)).isEnabled();
		assertTrue(lblUltimosMovimientos);
	}
	
	public void clicBtnSelectMesAno() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSelectMesAno)));
			driver.findElement(By.xpath(this.btnSelectMesAno)).click();
		} catch (Exception e) {
			System.out.println("Falla Xpath. Se implementa coordenadar");
			Utilidades.darTapiOS(driver, 300, 768);
		}	
	}
	
	public void selectMesAno(String mes) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.selectMesAno)));
		MobileElement selectMesAno = driver.findElement(By.xpath(this.selectMesAno));
		Utilidades.pickerWheelSelect(selectMesAno, mes);
	}
	
	public void clicBtnEnviarCorreo() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnEnviarCorreo)));
		driver.findElement(By.xpath(this.btnEnviarCorreo)).click();
	}
	
	public void validoLblMovimientosAlCorreo() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.lblMovimientosAlCorreo)));
		boolean lblMovimientosAlCorreo = driver.findElement(By.xpath(this.lblMovimientosAlCorreo)).isEnabled();
		assertTrue(lblMovimientosAlCorreo);
	}
	
	public void clicBtnAceptar() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptarXpath)));
		driver.findElement(By.xpath(this.btnAceptarXpath)).click();
	}
	
	public String returnLblFechaPrimerTrans() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.lblFechaPrimerTrans)));
		MobileElement lblFechaPrimerTrans = driver.findElement(By.xpath(this.lblFechaPrimerTrans));
		return lblFechaPrimerTrans.getAttribute("value");
	}
	
	public String returnLblTipoTrans() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.lblTipoTrans)));
		MobileElement lblTipoTrans = driver.findElement(By.xpath(this.lblTipoTrans));
		return lblTipoTrans.getAttribute("value");
	}
	
	public String returnLblValorTrans() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.lblValorTrans)));
		String lblValorTrans = driver.findElement(By.xpath(this.lblValorTrans)).getText();
		return lblValorTrans;
	}
}
