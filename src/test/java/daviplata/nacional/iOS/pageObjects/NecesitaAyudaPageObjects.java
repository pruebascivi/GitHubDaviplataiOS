package daviplata.nacional.iOS.pageObjects;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import daviplata.nacional.iOS.definitions.Hooks;
import daviplata.nacional.iOS.utilidades.Utilidades;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import net.serenitybdd.core.pages.PageObject;

public class NecesitaAyudaPageObjects extends PageObject {
	
	private AppiumDriver<MobileElement> driver= Hooks.getDriver();
	private WebDriverWait wait =Hooks.getDriverWait();
	Utilidades utilidad;
	Utilidades Utilidades;
	
    private String btnDaviHelpXpath="//XCUIElementTypeOther[@name=\"viewChat\"]";
    private String txtDaviHelpId="Seleccione el tipo de consulta que desea realizar.";

    public void clicBtnDaviHelp() {
        MobileElement btnDaviHelp = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnDaviHelpXpath)));
        btnDaviHelp.click();
    }
    
    public void validoDaviHelp() {
        Utilidades.esperaMiliseg(14000);
        MobileElement txtDaviHelp = driver.findElement(By.id(this.txtDaviHelpId));
        assertEquals("Seleccione el tipo de consulta que desea realizar.", txtDaviHelp.getText());
    }
}
