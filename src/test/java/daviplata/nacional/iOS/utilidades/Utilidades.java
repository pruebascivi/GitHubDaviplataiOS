package daviplata.nacional.iOS.utilidades;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import daviplata.nacional.iOS.definitions.Hooks;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import daviplata.nacional.iOS.utilidades.Evidencias;

import daviplata.nacional.iOS.modelo.ConsultaCupoTarjeta;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.ios.IOSTouchAction;

import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofSeconds;

public class Utilidades {

	BaseUtil base;
	private static AppiumDriver<MobileElement> driver = Hooks.getDriver();

	private static String dato = "Vacio";
	private static int contador = 0;
	private static WebDriverWait wait = Hooks.getDriverWait();



	/**
	 * Dar un tap en iOS-- puede servir para otras herramientas como uiautomator2
	 * 
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void darTapiOS(AppiumDriver<MobileElement> driver, int x, int y) {
		Map<String, Object> args = new HashMap<>();
		args.put("x", x);
		args.put("y", y);
		driver.executeScript("mobile: tap", args);
	}

	/**
	 * Da un tap en un xy dado.
	 * 
	 * @param driver
	 * @param punto
	 */
	public static void darTapiOS(AppiumDriver<MobileElement> driver, int punto[]) {
		Map<String, Object> args = new HashMap<>();
		args.put("x", punto[0]);
		args.put("y", punto[1]);
		driver.executeScript("mobile: tap", args);
	}

	public void goToBack() {
//		Map<String, Object> args = new HashMap<>();
//		args.put("name", "back");
		Hooks.getDriver().navigate().back();
		;

//		driver.executeScript("mobile: pressButton", args);
	}

	/**
	 * Vuelve hacia atras la pantalla del celular
	 * 
	 * @param driver
	 */
	public void goToBack(AppiumDriver<MobileElement> driver) {
//		Map<String, Object> args = new HashMap<>();
//		args.put("name", "back");
		driver = Hooks.getDriver();
		driver.navigate().back();
//		driver.executeScript("mobile: pressButton", args);
	}

	public static void goToBack2(AppiumDriver<MobileElement> driver) {
		Map<String, Object> args = new HashMap<>();
		args.put("name", "back");
//		driver.navigate().back();
		driver.executeScript("mobile: pressButton", args);
	}

	/**
	 * vuelve hacia atras las veces necesarias.s
	 * 
	 * @param driver
	 * @param repeticiones
	 */
	public static void goToBack(AppiumDriver<MobileElement> driver, int repeticiones) {
		for (int i = 0; i < repeticiones; i++) {
			driver.navigate().back();
		}

	}

	/**
	 * Genera un numero aleatorio de tipo BigDecimal.
	 * 
	 * @return
	 */
	public static BigDecimal generarNumero() {

		Random numAleatorio = new Random();
		Random numAleatorio1 = new Random(234);
		int n = (numAleatorio.nextInt(15000 - 5000 + 1) + 5000);
		String valor = String.valueOf(n);
		BigDecimal monto = new BigDecimal(valor);
		System.out.println(monto);
		return monto;
	}

	/**
	 * Genera un numero con la cantidad ingresada de digitos.
	 * 
	 * @param numeroDigitos
	 * @return
	 */
	public static String generarNumeroDigitos(int numeroDigitos) {
		Random numAleatorio1 = new Random();
		String salida = "";
		for (int i = 0; i < numeroDigitos; i++) {
			int valor = numAleatorio1.nextInt(9);
			salida = salida + valor;
		}
		return salida;

	}

	/**
	 * Genera un numero con la cantidad ingresada de digitos, pero sin usar el
	 * numero 3.
	 * 
	 * @param numeroDigitos
	 * @return
	 */
	public static String generarNumeroDifTres(int numeroDigitos) {
		Random numAleatorio1 = new Random();
		String salida = "";
		for (int i = 0; i < numeroDigitos; i++) {
			int valor = numAleatorio1.nextInt(9);
			if (valor == 3) {
				i--;
			} else {
				salida = salida + valor;
			}
		}
		return salida;

	}

	/**
	 * Genera un numero aleatorio, la cuenta comienza en 0
	 * 
	 * @param valor
	 * @return
	 */
	public static int generarNumero(int valor) {
		Random numAleatorio = new Random();
		valor = numAleatorio.nextInt(valor);
		return valor;
	}

	/**
	 * La direccion puede ser "next" o "previous", el offset es el tiempo de paso
	 * 
	 * @param driver
	 * @param element
	 * @param direction
	 * @param offset
	 */
	public static void pickerWheelSelect(AppiumDriver<MobileElement> driver, MobileElement element, String direction,
			double offset) {
		Map<String, Object> params = new HashMap<>();
		params.put("order", direction);
		params.put("offset", offset);
		params.put("element", element.getId());
		driver.executeScript("mobile: selectPickerWheelValue", params);
		// element.setValue("BANCOLOMBIA");
	}

	/**
	 * Ejecuta un comando para mover la pantalla hacia arriba.
	 * 
	 * @param driver
	 */
	public void moverPantallaUpiOS(AppiumDriver<MobileElement> driver) {
		Map<String, Object> params = new HashMap<>();
		params.put("direction", "up");
		driver.executeScript("mobile: swipe", params);
		// element.setValue("BANCOLOMBIA");
	}

	/**
	 * Ejecuta un comando para bajar la pantalla.
	 * 
	 * @param driver
	 */
	public static void moverPantallaDowniOS(AppiumDriver<MobileElement> driver) {
		Map<String, Object> params = new HashMap<>();
		params.put("direction", "down");
		driver.executeScript("mobile: swipe", params);
		// element.setValue("BANCOLOMBIA");
	}

	/**
	 * Metodo para mover la pantalla en X y Y.
	 * 
	 * @param driver
	 */
	public void moverPantallaXY(AppiumDriver<MobileElement> driver) {
		Map<String, Object> params = new HashMap<>();
		params.put("duration", 1.0);
		params.put("fromX", 100);
		params.put("fromY", 500);
		params.put("toX", 100);
		params.put("toY", 300);
		driver.executeScript("mobile: dragFromToForDuration", params);
		// element.setValue("BANCOLOMBIA");
	}

	public void moverPantallaXY1(AppiumDriver<MobileElement> driver, double startX, double startY, double endX,
			double endY) {
		Dimension size = Hooks.getDriver().manage().window().getSize();
		System.out.println("ancho " + size.width);
		System.out.println("largo " + size.height);

		int start_x = (int) (size.width * startX);
		int start_y = (int) (size.height * startY);
		int end_x = (int) (size.width * endX);
		int end_y = (int) (size.height * endY);
		System.out.println("inicio ancho " + start_x);
		System.out.println("inicio largo " + start_y);
		System.out.println("fin ancho " + end_x);
		System.out.println("fin largo " + end_y);
		TouchAction touch = new TouchAction(driver);
		touch.press(PointOption.point(start_x, start_y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.moveTo(PointOption.point(end_x, end_y)).release().perform();

		// Utilidades.moverPantalla(150, 570);
		// Utilidades.moverPantalla(150, 370);

		// element.setValue("BANCOLOMBIA");
	}

	/**
	 * Metodo para mover un X y Y la Pantalla de celular.
	 * 
	 * @param driver
	 * @param xi
	 * @param yi
	 * @param xf
	 * @param yf
	 */
	public void moverPantallaXY(AppiumDriver<MobileElement> driver, int xi, int yi, int xf, int yf) {
		Map<String, Object> params = new HashMap<>();
		params.put("duration", 1.0);
		params.put("fromX", xi);
		params.put("fromY", yi);
		params.put("toX", xf);
		params.put("toY", yf);
		driver.executeScript("mobile: dragFromToForDuration", params);
		// element.setValue("BANCOLOMBIA");
	}

	/**
	 * Tap en iOS.
	 * 
	 * @param driver
	 * @param x
	 * @param y
	 */
	public static void tapiOS(AppiumDriver<MobileElement> driver, int x, int y) {
		Map<String, Object> params = new HashMap<>();
		params.put("x", x);
		params.put("y", y);
		driver.executeScript("mobile: tap", params);
		// element.setValue("BANCOLOMBIA");
	}

	/**
	 * Debo poner el value que desea setear exactamente al que tenga el Wheel
	 * 
	 * @param driver
	 * @param element
	 * @param value
	 */
	public void pickerWheelSelect(MobileElement element, String value) {
		element.setValue(value);
	}

	/**
	 * Mueve la pantalla en X y Y, mas usado para dispositivos Android.
	 * 
	 * @param startY
	 * @param endY
	 */
	public void moverPantalla(double startY, double endY) {
		Dimension size = Hooks.getDriver().manage().window().getSize();
		System.out.println(size.height);
		System.out.println(size.width);
		int anchor = (int) (size.width * 0.5);
		int startPoint = (int) (size.height * startY);
		int endPoint = (int) (size.height * endY);

		new TouchAction(Hooks.getDriver()).press(PointOption.point(anchor, startPoint))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(100))).moveTo(PointOption.point(anchor, endPoint))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(200))).release().perform();

	}

	/**
	 * Da un tap en la pantalla. Màs usado en los dispositivos Android.
	 * 
	 * @param puntoX
	 * @param puntoY
	 */
	public void darUnTap(int puntoX, int puntoY) {
		new TouchAction(Hooks.getDriver()).tap(PointOption.point(puntoX, puntoY)).perform();
	}

	public static void esperar(int tiempo) {
		try {
			Thread.sleep(tiempo * 1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * Toma evidencia del dispositivo.
	 * 
	 * @param detalle
	 */
	public static void tomaEvidenciaResaltado(String detalle, String locator) {
		try {
			Evidencias.capturaDispositivo(detalle, locator);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Toma evidencia del dispositivo.
	 * 
	 * @param detalle
	 */
	public static void tomaEvidencia(String detalle) {
		try {
			Evidencias.capturaDispositivo(detalle);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void tomaEvidenciaPantalla(String detalle) {
		try {
			Evidencias.capturaPantalla(detalle);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ocultarTeclado(int x, int y) {
		try {
			TouchAction touchAction=new TouchAction(driver);
            touchAction.tap(new PointOption().withCoordinates(x,y)).perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void moverElementoTouch(MobileElement startElement, int YFin) {
		int startX = startElement.getLocation().getX() + (startElement.getSize().getWidth() / 2);
		int startY = startElement.getLocation().getY() + (startElement.getSize().getHeight() / 2);

		new TouchAction(Hooks.getDriver()).press(PointOption.point(startX, startY))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(startX, YFin))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(200))).release().perform();

		System.out.println("Moví elemento");
	}

	/**
	 * Toma evidencia del driver que se le inserte.
	 * 
	 * @param driver
	 * @param detalle
	 */
	public void tomaEvidencia(WebDriver driver, String detalle) {
		try {
			Evidencias.capturaDispositivo(driver, detalle);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Toma evidencia del dispotivo con un retardo en milisegundos.
	 * 
	 * @param miliSeg
	 * @param detalle
	 */
	public void tomaEvidencia(int miliSeg, String detalle) {
		esperaMiliseg(miliSeg);
		try {
			Evidencias.capturaDispositivo(detalle);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void tomaEvidenciaPCLatinia(String detalle) {
		try {
			esperaMiliseg(500);
			Evidencias.capturaDispositivoPCLatinia(detalle);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Realiza un espera sin necesidad de usar el try-catch en el metodo.
	 * 
	 * @param miliSeg
	 */
	public static void esperaMiliseg(int miliSeg) {
		try {
			Thread.sleep(miliSeg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void moverPantalla(int xInt, int YInt, int XFin, int YFin) {
		System.out.println("Entro al método moverPantalla");
		// Dimension size = base.driver.manage().window().getSize();
		// int anchor = (int) (size.width * 0.5);
		// int startPoint = (int) (size.height - 4.0);
		// int endPoint = (int) (size.height - 4.0);
		AppiumDriver<MobileElement> driver2 = Hooks.getDriver();

		new TouchAction(driver2).press(PointOption.point(xInt, YInt))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(XFin, YFin))
				.release().perform();
		System.out.println("Moví pantalla");
	}

	/**
	 * Verifica los saldos realizando una resta tomando en cuenta el saldo inicial y
	 * final.
	 * 
	 * @param saldoInicial
	 * @param saldoFinal
	 * @param valorAConsignar
	 * @param movConsultado
	 */
	public static void verificoSaldos(BigDecimal saldoInicial, BigDecimal saldoFinal, BigDecimal valorAConsignar,
			BigDecimal movConsultado) {
		BigDecimal subSaldo = saldoInicial.subtract(saldoFinal);
		String montoConsignado = String.valueOf(valorAConsignar).concat(".00");
		BigDecimal consignado = new BigDecimal(montoConsignado);
		assertEquals(consignado, movConsultado);
		assertEquals(consignado, subSaldo);
	}

	/**
	 * Realiza una verificacion de saldos con respecto a la tx realizada.
	 * 
	 * @param saldoInicial
	 * @param saldoFinal
	 * @param valorAConsignar
	 */
	public void verificoSaldos(BigDecimal saldoInicial, BigDecimal saldoFinal, BigDecimal valorAConsignar) {
		BigDecimal subSaldo = saldoInicial.subtract(saldoFinal);
		String montoConsignado = String.valueOf(valorAConsignar).concat(".00");
		BigDecimal consignado = new BigDecimal(montoConsignado);
		try {
			assertEquals(consignado, subSaldo);
		} catch (AssertionError e) {
			System.out.println("Se esperaba " + consignado + " pero fue " + subSaldo);
			tomaEvidencia("Se esperaba " + consignado + " pero fue " + subSaldo);
			assertTrue("Se esperaba " + consignado + " pero fue " + subSaldo, false);
		}

	}

	/**
	 * Quita el caracter de una cadena de texto.
	 * 
	 * @param texto
	 * @param caracter
	 * @return
	 */
	public static String quitarCaracter(String texto, String caracter) {
		if (texto.contains(caracter)) {
			texto = texto.replace(caracter, "");
		}
		return texto;
	}

	/**
	 * Quita los digitos a final de una cadena de texto.
	 * 
	 * @param texto
	 * @param valor
	 * @return
	 */
	public static String quitarDigitos(String texto, int valor) {
		return texto.substring(0, texto.length() - valor);
	}

	/**
	 * Devuelve la resta entre el valor inicial y el final.
	 * 
	 * @param saldoInicial
	 * @param saldoFinal
	 * @param valorAConsignar
	 * @return
	 */
	public static BigDecimal devuelveResta(BigDecimal saldoInicial, BigDecimal saldoFinal, BigDecimal valorAConsignar) {
		BigDecimal subSaldo = saldoInicial.subtract(saldoFinal);
		String montoConsignado = String.valueOf(valorAConsignar).concat(".00");
		BigDecimal consignado = new BigDecimal(montoConsignado);
		return subSaldo;
	}

	/**
	 * Ingresa un string con caracteres de numero, este devolverà un valor Big
	 * decimal.
	 * 
	 * @param valorStr
	 * @return
	 */
	public static BigDecimal convertirStrABigDecimal(String valorStr) {
		BigDecimal valor = new BigDecimal(valorStr);
		return valor;
	}

	/**
	 * Genera un el formato necesario para una fecha
	 * 
	 * @param formato
	 * @param fecha
	 * @return
	 */
	public static String formatDateInforme(String formato, Date fecha) {
		String dateString = null;
		try {
			SimpleDateFormat format = new SimpleDateFormat(formato);
			dateString = format.format(fecha);
			// date = format.parse("2009-12-31");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateString;
	}

	/**
	 * Inserta un caracter dentro de un espacio correspondiente en un cadena de
	 * texto.
	 * 
	 * @param valor
	 * @param posicion
	 * @param caracter
	 * @return
	 */
	public static String insertarCaracter(String valor, int posicion, String caracter) {
		valor = valor.substring(0, valor.length() - posicion) + caracter + valor.substring(valor.length() - posicion);
		return valor;
	}

	/**
	 * guarda el driver de Google Chrome para su uso en general.
	 * 
	 * @return
	 */
	public static void driverChrome() {
		System.setProperty("webdriver.chrome.driver",
				Credenciales.parametrosGenerales().getProperty("ubicacion.driverchrome"));
		BaseUtil.chromeDriver = new ChromeDriver();
		BaseUtil.chromeDriver.manage().window().maximize();
	}

	/**
	 * Devuelve la url de Redeban.
	 * 
	 * @return
	 */
	public static String urlRedeban() {
		return Credenciales.propertiesWebs().getProperty("web.redeban");
	}

	/**
	 * Guarda un dato de tipo string para ser usando
	 * 
	 * @param datoGuardado
	 */
	public static void guardaDato(String datoGuardado) {
		dato = datoGuardado;
	}

	/**
	 * Devuelve el dato guardado
	 * 
	 * @return
	 */
	public static String retornaDato() {
		return dato;
	}

	/**
	 * Pasa un String a Double
	 * 
	 * @param valor
	 * @return
	 */
	public static double pasarStrDou(String valor) {
		if (valor.contains(".")) {
			valor = valor.replace(".", "");
		}
		if (valor.contains(",")) {
			valor = valor.replace(",", ".");
		}
		double valorF = Double.parseDouble(valor);
		return valorF;
	}

	/**
	 * valida si los valores en RBM al principio y final de prueba.
	 * 
	 * @param inicioValores
	 * @param finalValores
	 */
	public static void validarValoresCambioNumero(ConsultaCupoTarjeta inicioValores, ConsultaCupoTarjeta finalValores) {
		double disponibleIni = pasarStrDou(inicioValores.getSaldoBolsillos())
				+ pasarStrDou(inicioValores.getSaldoDisponible4x1000());
		double disponibleFin = pasarStrDou(finalValores.getSaldoBolsillos())
				+ pasarStrDou(finalValores.getSaldoDisponible4x1000());
		Assert.assertEquals(disponibleIni + "", disponibleFin + "");
	}

	public static void scrollDownSwipe() {

		Dimension dimension = Hooks.getDriver().manage().window().getSize();

		int initX = (int) (dimension.width * 0.5);
		int initY = (int) (dimension.height * 0.8);
		int endX = (int) (dimension.width * 0.5);
		int endY = (int) (dimension.height * 0.6);

		TouchAction touchAction = new TouchAction(Hooks.getDriver());
		touchAction.press(PointOption.point(initX, initY)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.moveTo(PointOption.point(endX, endY)).release().perform();
	}

	public static String numAleatorio(int limSuperior, int limInferior) {

		Random numAleatorio = new Random();
		int n = (numAleatorio.nextInt(limSuperior - limInferior + 1) + limInferior);
		return String.valueOf(n);
	}

	public String generarCuentaAleatoria() {
		Random numAleatorio = new Random();
		int n = (numAleatorio.nextInt(999999999 - 9999999 + 1) + 9999999);
		return String.valueOf(n);
	}

	public String generarMontoTransaccional() {
		Random numAleatorio = new Random();
		int n = (numAleatorio.nextInt(30000 - 20000 + 1) + 20000);
		System.out.println(n);
		return String.valueOf(n);
	}
	
	public static void scrollHastaElementoPorNombre(String nombreElemento) {
	    MobileElement element = (MobileElement) Hooks.getDriver()
	            .findElement(MobileBy.iOSNsPredicateString("name CONTAINS '" + nombreElemento + "'"));

	    // Si el elemento se encontró, hacemos scroll manualmente
	    if (element != null) {
	        Dimension size = Hooks.getDriver().manage().window().getSize();
	        int starty = (int) (size.height * 0.80);
	        int endy = (int) (size.height * 0.20);
	        int startx = size.width / 2;
	        new TouchAction<>(Hooks.getDriver())
	            .press(PointOption.point(startx, starty))
	            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
	            .moveTo(PointOption.point(startx, endy))
	            .release()
	            .perform();
	    }
	}
	
	public void moverPantallaCorto() {
		esperaMiliseg(1000);
		Dimension size = Hooks.getDriver().manage().window().getSize();
		int anchor = (int) (size.width * 0.5);
		int startPoint = (int) (size.height * 0.3);
		int endPoint = (int) (size.height * 0.1);

		new TouchAction(Hooks.getDriver()).press(PointOption.point(anchor, startPoint))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
				.moveTo(PointOption.point(anchor, endPoint)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
				.release().perform();

	}

	public void validacionDeSaldos() {

		BigDecimal subSaldo = base.saldo.subtract(base.montoTransado);
		subSaldo = subSaldo.subtract(base.comision);
		String saldoFinal = String.valueOf(base.saldoFinal).split("\\.")[0];
		String subSaldoString = String.valueOf(subSaldo).split("\\.")[0];
		assertEquals(saldoFinal, subSaldoString);

	}

	public void scrollHastaElFinalDePantalla() {
		esperaMiliseg(8000);
		Dimension size = Hooks.getDriver().manage().window().getSize();
		int anchor = (int) (size.width * 0.5);
		int startPoint = (int) (size.height * 0.5);
		int endPoint = (int) (size.height * -0.1);

		new TouchAction(Hooks.getDriver()).press(PointOption.point(anchor, startPoint))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
				.moveTo(PointOption.point(anchor, endPoint)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
				.release().perform();
		System.out.println("Movi Pantalla");

	}

	//Press by coordinates
	public void pressByCoordinates(int x, int y, long seconds) {
		new TouchAction(driver).press(point(x, y)).waitAction(waitOptions(ofSeconds(seconds))).release().perform();
	}

	public static void cambiarFocoNuevaVentanaAbierta() {
		for (String winHandle : BaseUtil.chromeDriver.getWindowHandles()) {
			BaseUtil.chromeDriver.switchTo().window(winHandle);
		}
	}

	public static void scrollHaciaArriba() {
		JavascriptExecutor js = (JavascriptExecutor) BaseUtil.chromeDriver;
		js.executeScript("window.scrollBy(0,-350)", "");
	}
	
	public static void swipeByElements (IOSElement startElement, IOSElement endElement) {
	    int startX = startElement.getLocation().getX() + (startElement.getSize().getWidth() / 2);
	    int startY = startElement.getLocation().getY() + (startElement.getSize().getHeight() / 2);
	    int endX = endElement.getLocation().getX() + (endElement.getSize().getWidth() / 2);
	    int endY = endElement.getLocation().getY() + (endElement.getSize().getHeight() / 2);
	    new IOSTouchAction(driver)
	        .press(ElementOption.element(startElement, startX, startY))
	        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
	        .moveTo(ElementOption.element(endElement, endX, endY))
	        .release().perform();
	    System.out.println("Moví pantalla");
	}
	
	public static void hacerScrollHorizontal(String xpath) {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			MobileElement elemento = driver.findElement(By.xpath(xpath));

			Point localizacion = elemento.getLocation();

			TouchAction touchAction = new TouchAction(Hooks.getDriver());
			touchAction.press(PointOption.point(localizacion.getX() + 200, localizacion.getY()))
					.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
					.moveTo(PointOption.point(localizacion.getX() - 20, localizacion.getY())).release().perform();

		} catch (Exception e) {
			if (!(contador == 5)) {
				esperaMiliseg(500);
				hacerScrollHorizontal(xpath);
			} else {
				fail("No pude hacer scroll, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}
	
	public static void scrollHaciaArribaEnIos() {
	    Dimension size = Hooks.getDriver().manage().window().getSize();
	    int starty = (int) (size.height * 0.80);
	    int endy = (int) (size.height * 0.20);
	    int startx = size.width / 2;
	    new TouchAction<>(Hooks.getDriver())
	        .press(PointOption.point(startx, endy))
	        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
	        .moveTo(PointOption.point(startx, starty))
	        .release()
	        .perform();
	}
	
	public static void scrollHastaElemento(String elemento) {
        MobileElement element = (MobileElement) Hooks.getDriver()
                .findElement(MobileBy.IosUIAutomation("new UiScrollable(new UiSelector().scrollable(true))"
                        + ".scrollIntoView(new UiSelector().text(\"" + elemento + "\"))"));
    }


}
