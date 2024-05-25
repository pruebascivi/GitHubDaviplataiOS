package daviplata.nacional.iOS.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import daviplata.nacional.iOS.utilidades.BaseUtil;
import daviplata.nacional.iOS.utilidades.Credenciales;
import daviplata.nacional.iOS.utilidades.Utilidades;

public class NewLPageObjects {

	Utilidades utilidad;
	Utilidades Utilidades;
	private static BaseUtil base;

	private WebDriverWait wait ;
	private String urlNLatinia = "https://dev.redebansms.com/limsp-ui/#/message-details/mt?id_contract=2125";
	private String empresa = "mat-input-0";
	private String usuario = "mat-input-1";
	private String password = "mat-input-2";
	private String btnAcceder = "//div/div[2]/form/div/button";
	private String btnActualizar = "//mat-card/mat-card-header/div[2]/button[1]";
	private String btnFinalizarSesion = "//span[contains(text(),'Finalizar sesión')]";
	private String btnContinuar = "//input[@value='Continuar']";
	private String btnContinuar2 = "//input[1]";



	public void initDriverNLatinia() {
		base.chromeDriver.get(Credenciales.propertiesWebs().getProperty(this.urlNLatinia));
	}

	public void ingresarEmpresa() {
		WebElement empresa = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(this.empresa)));
		empresa.click();
		empresa.sendKeys("DAVIVIENDA");

	}

	public void clicBtnContinuar() {

		try {
			WebElement element = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnContinuar2)));
			element.click();
		} catch (Exception e) {
			base.chromeDriverLatinia.findElement(By.xpath(btnContinuar)).click();
		}

	}

	public void ingresarUsuario() {
		WebElement usuario = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(this.usuario)));
		usuario.sendKeys(Credenciales.propertiesRegistro().getProperty("usuario.latinia"));
	}

	public void ingresarPassword() {
		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(this.password)));
		password.sendKeys(Credenciales.propertiesRegistro().getProperty("clave.Nlatinia"));
	}

	public void darClickAcceder() {
		WebElement btnAcceder = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnAcceder)));
		btnAcceder.click();
	}

	public void darClickBtnActualizar() {
		utilidad.esperaMiliseg(3500);
		WebElement btnActualizar = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnActualizar)));
		btnActualizar.click();
	}

	public String traeOTP(String numCel) {
		int contador = 0;
		String xpath = "";
		String otp = "No encontrada";
		for (int i = 1; i < 10; i++) {// 30 porque solo los registros que muestra Latinia.
			xpath = "//table[@class='mat-table cdk-table mat-sort card-table']//tr[" + i + "]/td[3]";
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			if (element.getText().contains(numCel)) {
				System.out.println(i);
				String xpathDetalle = "//table[@class='mat-table cdk-table mat-sort card-table']//tr[" + i + "]/td[4]";
				otp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathDetalle))).getText();
				if (otp.contains("DaviPlata es "))
					otp = otp.split("DaviPlata es ")[1].trim();
				else if (otp.contains("DaviPlata es: "))
					otp = otp.split("DaviPlata es: ")[1].trim();
				else if (otp.contains("registro es "))
					otp = otp.split("registro es ")[1].trim();
				else if (otp.contains("codigo "))
					otp = otp.split("codigo ")[1].substring(0, 6).trim();
				contador = 0;
				return otp;
			}
		}
		if (otp.equals("No encontrada") && contador <= 3) {
			System.out.println("Actualizo pagina " + contador);
			contador++;
			darClickBtnActualizar();
			Utilidades.esperar(3);
			traeOTP(numCel);
		}
		return otp;
	}

	public void darClickFinalizarSesion() {
		WebElement btnFinalizarSesion = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnFinalizarSesion)));
		btnFinalizarSesion.click();
		utilidad.esperar(2000);
		base.chromeDriver.quit();
	}

	public void cerrarLatinia() {
		
		base.chromeDriver.quit();
	}

}
