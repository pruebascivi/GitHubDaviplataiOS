package daviplata.nacional.iOS.pageObjects;

import static org.junit.Assert.fail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import daviplata.nacional.iOS.utilidades.Credenciales;
import daviplata.nacional.iOS.utilidades.CustomChromeDriver;
import daviplata.nacional.iOS.utilidades.Utilidades;
import net.serenitybdd.core.pages.PageObject;

public class WebLatiniaPageObject extends PageObject {
	
	Utilidades Utilidades;
	static BaseUtil base;
	Utilidades utilidad;
	private static CustomChromeDriver confiChromeDriver;
	private static  WebDriverWait wait;
//	private String urlLatinia = "https://dev.redebansms.com/limsp-ui/#/message-details/mt?id_contract=2125";
	public static String empresaLatinia = "//input[@id='mat-input-0']";
	private static String usuariolatinia = "//input[@id='mat-input-1']";
	private static String passwordLatinia = "//input[@id='mat-input-2']";
	private String btnInicio = "//input[@value=\'Inicio\']";
	private String DetalleTransacciones = "//a[@href=\"../lman-vcontent/index.jsp?id_contract=2033\"]";
	private  String btnAccederLatinia = "//button[@class='mat-focus-indicator mat-flat-button mat-button-base mat-primary']";
	private String btnActualizar = "//button[@id='em-monitor-refresh-button']";
	private static String btnFinalizarSesionLatinia = "//span[contains(text(),'Finalizar sesión')]";
	private String btnContinuar = "//input[@value='Continuar']";
	private String btnContinuar2 = "//input[1]";
	private int contador=0;
	private String btnFiltro = "//button[@id='msg-details-filter']";
	private String btnFiltroAvanzado = "//button[@id='msg-details-search']";
	private String btnMensajes = "//div[@id='mat-tab-label-0-1']";
	private String inputFiltro = "//input[@id='search-bar-input']";
	private String btnCheckDireccion = "//mat-radio-button[@id='search-msg-recipient-radio-button']";
	private String inputDireccionDestino = "//input[@id='search-msg-recipient-input']";
	private String btnBuscar = "//button[@id='search-msg-search-footer']";
	private String btnOpciones = "/html/body/app-root/app-message-details/app-page-layout/app-toolbar/mat-toolbar/button/span[1]/mat-icon";
	private static String btnHamburguesaLatinia = "/html/body/app-root/app-message-details/app-page-layout/app-toolbar/mat-toolbar/button";

	//// table[@class='table-message-list']//tr[2]
	// //table[@class='table-message-list']//tr[2]/td[4 and contains(text(),'7355')]
	// table[@class='table-message-list']//tr[2]/td[5]
	


	public String consultaOTPLtinia(String cel) {
		// WebLatiniaPageObject lt= new WebLatiniaPageObject();
		initDriverLatinia();
		ingresarEmpresa();
		ingresarUsuario();
		ingresarPassword();
		Utilidades.tomaEvidenciaPantalla("Ingreso Credenciales Latinia");
		darClickAcceder();
		String OTP = traeOTP(cel);
		cerrarWebLatinia();
		return OTP;
	}
	
	public String consultaCVVLtinia(String cel) {
		// WebLatiniaPageObject lt= new WebLatiniaPageObject();
		abrirWebLatinia();
		ingresarEmpresa();
		ingresarUsuario();
		ingresarPassword();
		darClickAcceder();
		String CVV = traeCvv(cel);
		Utilidades.tomaEvidenciaPantalla("Web - Encuentro el cvv con el numero de celular "+cel+ " y el CVV es "+ CVV);
		cerrarWebLatinia();
		return CVV;
	}

	public void abrirWebLatinia() {
		confiChromeDriver.iniciarChromeDriver();
		base.chromeDriver.get(Credenciales.propertiesWebs().getProperty("web.latinia.url"));
		base.chromeDriver.manage().window().maximize();
		wait = new WebDriverWait(base.chromeDriver, 60);
	}

	public void cerrarWebLatinia() {
		base.chromeDriver.quit();
	}

	
	public static void initDriverLatinia() {
		confiChromeDriver.iniciarChromeDriver();
		BaseUtil.chromeDriver.get(Credenciales.propertiesWebs().getProperty("web.Nlatinia.url"));
		wait = new WebDriverWait(BaseUtil.chromeDriver, 20);
	}



	public static  void ingresarEmpresa() {
		WebElement empresa = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(empresaLatinia)));
		empresa.click();
		empresa.sendKeys("DAVIVIENDA");
	}
	
	public void clicBtnContinuar() {
		try {
			
	
		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuar2)));
			element.click(); 
		} catch (Exception e) {
			base.chromeDriverLatinia.findElement(By.xpath(btnContinuar)).click();
		}
		} catch (Exception e) {
				
		}

	}
	


	public static void ingresarUsuario() {
		WebElement usuario = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(usuariolatinia)));
		usuario.sendKeys(Credenciales.propertiesWebs().getProperty("web.user.latinia"));
	}

	public static void ingresarPassword() {
		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(passwordLatinia)));
		password.sendKeys(Credenciales.propertiesWebs().getProperty("web.pass.latinia"));
	}
	
	public void darClickInicio() {
		WebElement btnInicio = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnInicio)));
		btnInicio.click();
	}
	
	public void darClickDetalleTransacciones() {
		WebElement btnAcceder = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.DetalleTransacciones)));
		btnAcceder.click();
	}
	
	public void darClickAcceder() {
		
		Utilidades.esperaMiliseg(10000);
		try {
			contador++;
			WebElement btnActualizar = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnAccederLatinia)));
			btnActualizar.click();
		}catch (Exception e) {
			if(!(contador==20)) {Utilidades.esperaMiliseg(2000);darClickAcceder();
			}else {fail("No se puedo dar clic en boton actualizar de Latinia debido a: "+e.getMessage());}
		}finally {contador=0;}
	}
		
		
		
	
	

	
	public void darClickBtnActualizar() {
		Utilidades.esperaMiliseg(10000);
		try {
			contador++;
			WebElement btnActualizar = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnActualizar)));
			btnActualizar.click();
		}catch (Exception e) {
			if(!(contador==20)) {Utilidades.esperaMiliseg(2000);darClickBtnActualizar();
			}else {fail("No se puedo dar clic en boton actualizar de Latinia debido a: "+e.getMessage());}
		}finally {contador=0;}
	}
	
	public void darClickBtnFiltroAvanzado() {
		Utilidades.esperaMiliseg(10000);
		try {
			contador++;
			WebElement btnFiltro = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnFiltroAvanzado)));
			btnFiltro.click();
		}catch (Exception e) {
			if(!(contador==20)) {Utilidades.esperaMiliseg(2000);darClickBtnFiltroAvanzado();
			}else {fail("No se puedo dar clic en boton filtro avanzado de Latinia debido a: "+e.getMessage());}
		}finally {contador=0;}
	}
	
	public void darClickTabMensajes() {
		utilidad.esperaMiliseg(3000);
		try {
			contador++;
			WebElement btnMensajes = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnMensajes)));
			btnMensajes.click();
		}catch (Exception e) {
			if(!(contador==20)) {Utilidades.esperaMiliseg(2000);darClickTabMensajes();
			}else {fail("No se puedo dar clic en tab de mensajes de Latinia debido a: "+e.getMessage());}
		}finally {contador=0;}
	}
	
	public void darClickCheckBoxDireccion() {
		utilidad.esperaMiliseg(1000);
		try {
			contador++;
			WebElement btnCheckDireccion = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnCheckDireccion)));
			btnCheckDireccion.click();
		}catch (Exception e) {
			if(!(contador==20)) {Utilidades.esperaMiliseg(2000);darClickCheckBoxDireccion();
			}else {fail("No se puedo dar clic en checbox direccion de Latinia debido a: "+e.getMessage());}
		}finally {contador=0;}
	}
	
	public void escribirNumeroCelular(String numeroCelular) {
		utilidad.esperaMiliseg(1000);
		try {
			contador++;
			System.out.println("El numero de celular es: " + numeroCelular);
			String numeroConExtensionColombia = "+57" + numeroCelular;
			
			WebElement inputDireccionDestino = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.inputDireccionDestino)));
			inputDireccionDestino.click();
			inputDireccionDestino.sendKeys(numeroConExtensionColombia);
		}catch (Exception e) {
			if(!(contador==20)) {Utilidades.esperaMiliseg(2000);escribirNumeroCelular(numeroCelular);
			}else {fail("No se puedo dar clic y escribir en input destino de Latinia debido a: "+e.getMessage());}
		}finally {contador=0;}
	}
	
	public void darClickBtnBuscar() {
		try {
			contador++;
			
			WebElement btnBuscar = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnBuscar)));
			btnBuscar.click();
		}catch (Exception e) {
			if(!(contador==20)) {Utilidades.esperaMiliseg(2000);darClickBtnBuscar();
			}else {fail("No se puedo dar clic btn buscar destino de Latinia debido a: "+e.getMessage());}
		}finally {contador=0;}
	}
	
	public void darClickBtnOpciones() {
		try {
			contador++;
			
			WebElement btnOpciones = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnOpciones)));
			btnOpciones.click();
		}catch (Exception e) {
			if(!(contador==20)) {Utilidades.esperaMiliseg(2000);darClickBtnOpciones();
			}else {fail("No se puedo dar clic btn opciones de Latinia debido a: "+e.getMessage());}
		}finally {contador=0;}
	}

	public String traeOTP(String numCel) {
		int contador=0;
		String otp = "No encontrada";
		otp = buscarOTP(numCel);
		utilidad.tomaEvidenciaPantalla("Consulta Numero OTP");
		System.out.println("LA OTP ES: " + otp);
		return otp;
	}
	
	public String traeOtpOlvidoClave(String numCel) {
		int contador=0;
		String otp = "No encontrada";
		otp = buscarOtpOlvidoClave(numCel);
		utilidad.tomaEvidenciaPantalla("Consulta Numero OTP");
		System.out.println("LA OTP ES: " + otp);
		return otp;
	}
	
	public String traeMsj(String numCel) {
		int contador=0;
		String msj = "No encontré msj";
		msj = buscarMsj(numCel);
		while(msj.equals("No encontré msj") && contador <= 15) {
			System.out.println("Actualizo pagina " + contador);
			contador = contador + 1;
			darClickBtnActualizar();
			utilidad.esperar(2000);
			//traeOTP(numCel);
			msj = buscarMsj(numCel);
		}
		return msj;
	}
	
	public String buscarOTP(String numCel) {
		String xpath = "";
		String xpathDetalle = "";
		String otp = "No encontrada";
		int indice = 1;
		while(otp.equals("No encontrada")) {
			xpath = "//table[@class='mat-table cdk-table mat-sort card-table']//tr[" + indice + "]/td[3]";
			xpathDetalle = "//table[@class='mat-table cdk-table mat-sort card-table']//tr[" + indice + "]/td[4]";

			WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathDetalle)));
			
			if (element1.getText().contains(numCel) && element2.getText().contains("Si usted esta intentando ingresar a su DaviPlata desde otro celular")) {
				otp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathDetalle))).getText();
				System.out.println("la otp es: " + otp);
				otp = otp.replaceAll("[^0-9]", "");
				System.out.println("la nueva otp es: " + otp);
				break;
			}
			indice++;
			if(indice >= 10) break;
			
		}
		return otp;
	}
	
	public String buscarMsj(String numCel) {
		String xpath = "";
		String msj = "No encontré msj";
		for (int i = 1; i < 10; i++) {// 10 porque solo los registros que muestra Latinia.
			xpath = "//table[@class='mat-table cdk-table mat-sort card-table']//tr[" + i + "]/td[3]";
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			if (element.getText().contains(numCel)) {
				System.out.println(i);
				String xpathDetalle = "//table[@class='mat-table cdk-table mat-sort card-table']//tr[" + i + "]/td[4]";
				msj = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathDetalle))).getText();
				if (msj.contains("Usted recibio un cobro por")) {
					System.out.println("Encontre el registro con el mensaje de cobro");
					System.out.println(msj);
				}else if(msj.contains("Recibio un giro por")) {
					System.out.println("Encontre el registro con el mensaje de cobro");
					System.out.println(msj);
				}
				else {
					System.out.println("No fue posible encontrar el mensaje");
				}
				
				
			}
		}
		return msj;
	}
	
	
	
	public String traeCvv(String numCel) {
		int contador = 0;
		String xpath = "";
		String otp = "No encontrada";
		for (int i = 2; i < 32; i++) {// 30 porque solo los registros que muestra Latinia.
			xpath = "//table[@class='table-message-list']//tr[" + i + "]/td[4]";
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			if (element.getText().contains(numCel)) {
				System.out.println(i);
				String xpathDetalle = "//table[@class='table-message-list']//tr[" + i + "]/td[5]";
				otp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathDetalle))).getText();
				if (otp.contains("Tarjeta es "))
					otp = otp.split("Tarjeta es ")[1].trim();
				
				
				contador = 0;
				return otp;
			}
		}
		if (otp.equals("No encontrada") && contador <= 3) {
			System.out.println("Actualizo pagina " + contador);
			contador++;
			darClickBtnActualizar();
			utilidad.esperar(3);
			traeOTP(numCel);
		}
		return otp;
	}
	

	public static void darClickFinalizarSesion() {
		WebElement btnFinalizarSesion = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnFinalizarSesionLatinia)));
		btnFinalizarSesion.click();
        
		confiChromeDriver.cerrarChromeDriver();
	}

	public void cerrarLatinia() {
		confiChromeDriver.cerrarChromeDriverLatinia();
	}

	public String traeOPTFiltro(String numCelular) {
		String strOTP="";
		darClicBtnfiltro();
		colocarFiltro(numCelular);
		strOTP = extraerOPTFiltro(numCelular);
		while(strOTP.equals("No encontrada") && contador <= 15) {
			System.out.println("Actualizo pagina " + contador);
			contador = contador + 1;
			darClickBtnActualizar();
			utilidad.esperar(2000);
			//traeOTP(numCel);
			strOTP = extraerOPTFiltro(numCelular);
		}
		return strOTP;
	}

	public String extraerOPTFiltro(String numCel) {
		String otp = "No Encontrada";
		String xpath = "//table[@class='mat-table cdk-table mat-sort card-table']//tr[1]/td[3]";
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		if (element.getText().contains(numCel)) {
			String xpathDetalle = "//table[@class='mat-table cdk-table mat-sort card-table']//tr[1]/td[4]";
			otp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathDetalle))).getText();
			if (otp.contains("DaviPlata es "))
				otp = otp.split("DaviPlata es ")[1].trim();
			else if(otp.contains("DaviPlata es: "))
				otp = otp.split("DaviPlata es: ")[1].trim();
			else if(otp.contains("registro es "))
				otp = otp.split("registro es ")[1].trim();
			else if(otp.contains("codigo "))
				otp = otp.split("codigo ")[1].substring(0,6).trim();
			return otp;
		}else {return otp;}
	}

	public void colocarFiltro(String numCelular) {
		try {
			contador++;
			WebElement inputFiltro = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.inputFiltro )));
			inputFiltro.sendKeys(numCelular);
		}catch (Exception e) {
			if(!(contador==20)) {Utilidades.esperaMiliseg(2000);colocarFiltro(numCelular);
			}else {fail("No se puedo colocar el filtro de Latinia debido a: "+e.getMessage());}
		}finally {contador=0;}
	}

	public void darClicBtnfiltro() {
		try {
			contador++;
			WebElement btnFiltro = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnFiltro )));
			btnFiltro.click();
		}catch (Exception e) {
			if(!(contador==20)) {Utilidades.esperaMiliseg(2000);darClicBtnfiltro();
			}else {fail("No se puedo dar clic en boton filtro de Latinia debido a: "+e.getMessage());}
		}finally {contador=0;}
	}
	
	public static void vaidarAparezcaMensajes() {
			System.out.println("validando que aparezcan los mensajes");
		    String xpath = "";
		    xpath = "//table[@class='mat-table cdk-table mat-sort card-table']//tr[1 ]/td[4]";
		    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	
	public static void vaidarMensajes() {
		System.out.println("validar mensajes entro");
		String xpath = "";
		for (int i = 1; i < 10; i++) {// 10 porque solo los registros que muestra Latinia.
			xpath = "//table[@class='mat-table cdk-table mat-sort card-table']//tr[" + i + "]/td[4]";
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			String contenidoMensaje = element.getText();
			if (contenidoMensaje != null) {
				System.out.println("......Mensaje: " + contenidoMensaje + "......");
			}else{
				System.out.println("No se encontro mensaje en la posición: " + i);
			}
		}
	}
	
	 public static void clicBtnHamburguesaLatiniaFinalizarSesion() {
	    	try {
	    		WebElement element = wait
	    				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnHamburguesaLatinia)));
	        	element.click();
	    	}catch(Exception e) {
	    			fail("No se encontró menu hamburguesa de latinia, debido a: " + e.getMessage());
	    	}
	    	
	    }
	 
	 public String buscarOtpOlvidoClave(String numCel) {
			String xpath = "";
			String xpathDetalle = "";
			String otp = "No encontrada";
			int indice = 1;
			while(otp.equals("No encontrada")) {
				xpath = "//table[@class='mat-table cdk-table mat-sort card-table']//tr[" + indice + "]/td[3]";
				xpathDetalle = "//table[@class='mat-table cdk-table mat-sort card-table']//tr[" + indice + "]/td[4]";

				WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
				WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathDetalle)));
				
				if (element1.getText().contains(numCel) && element2.getText().contains("Continue con el cambio de clave para su DaviPlata")) {
					otp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathDetalle))).getText();
					System.out.println("la otp es: " + otp);
					otp = otp.replaceAll("[^0-9]", "");
					System.out.println("la nueva otp es: " + otp);
					break;
				}
				indice++;
				if(indice >= 10) break;
				
			}
			return otp;
		}

	
	


}
