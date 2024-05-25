package daviplata.nacional.iOS.pageObjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import daviplata.nacional.iOS.definitions.Hooks;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import daviplata.nacional.iOS.utilidades.Utilidades;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import net.serenitybdd.core.pages.PageObject;

public class MicroSegurosPageObjects extends PageObject {
	
	private AppiumDriver<MobileElement> driver = Hooks.getDriver();
	public WebDriverWait wait = Hooks.getDriverWait();
	public WebDriverWait wait2 = Hooks.getDriverWait();
	public static Utilidades utilidades;
	public static BaseUtil base;
	private int contador = 0;

	private String btncontinuanmicrosegurobici = "//XCUIElementTypeStaticText[@name='Bicicleta']";
	private String btncontinuanmicroseguromascota = "//android.widget.Button[@content-desc=\"Mascota\"]";
	private String txtfondosinsuficientesmicroseguros = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView";
	public static final String BOTON_MICROSEGURO_HOME = "//XCUIElementTypeOther[@name='container-tab-buttons']/XCUIElementTypeOther[1]";
	public static final String BOTON_SEGUROS = "//XCUIElementTypeOther[@name='Seguros']/XCUIElementTypeOther";
	public static final String DESPRENDIBLE_FECHA_NACIMIENTO = "(//XCUIElementTypeButton[@name='selector arrow down red'])[1]";
	public static final String SELECT_ANIO = "(//XCUIElementTypePickerWheel)[3]";
	public static final String BOTON_SEGUROS_HOME = "//XCUIElementTypeStaticText[contains(@value, 'Seguros y asistencias')] | //XCUIElementTypeStaticText[@name='name-product-3']";
	
	public void btnContinuarmicrosegurobicicleta() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btncontinuanmicrosegurobici)));
			driver.findElement(By.xpath(this.btncontinuanmicrosegurobici)).click();
		}catch(Exception e) {
			if(!(contador==5)) {
				utilidades.esperaMiliseg(500);
				btnContinuarmicrosegurobicicleta();
			}else {
				fail("No se encontró boton 'Bicicleta' en el modulo de seguros, debido a: " + e.getMessage());
			}
		}finally {contador=0;}
		
	}

	public void btnContinuarmicroseguromascota() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btncontinuanmicroseguromascota)));
		driver.findElement(By.xpath(this.btncontinuanmicroseguromascota)).click();
	}

	public void validomensajedaviplatainvalido() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtfondosinsuficientesmicroseguros)));
		String txtinvalido = driver.findElement(By.xpath(this.txtfondosinsuficientesmicroseguros)).getText();
		
		boolean validacion = false;
		if (txtinvalido.contains("Fondos insuficientes")) {
			utilidades.tomaEvidencia("Valido mensaje fondos insuficientes");
			validacion = true;
		}
		assertEquals(true, validacion);

	}

}
