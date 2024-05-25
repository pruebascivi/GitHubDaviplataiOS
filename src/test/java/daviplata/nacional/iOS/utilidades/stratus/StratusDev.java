package daviplata.nacional.iOS.utilidades.stratus;
/*
import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.sikuli.basics.Settings;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

import daviplata.nacional.iOS.utilidades.BaseUtil;
import daviplata.nacional.iOS.utilidades.Credenciales;
import daviplata.nacional.iOS.utilidades.Evidencias;
import daviplata.nacional.iOS.utilidades.Utilidades;



public class StratusDev {

	public static WiniumDriver driver;
	static String horaMaxima ="";
	Utilidades utilidad;
	BaseUtil baseutil;
	
	
	
	public StratusDev(Utilidades utilidad,BaseUtil baseutil) {
		super();
		this.utilidad = utilidad;
		this.baseutil = baseutil;
	}
	
	public static ArrayList<ModelDebitoRealizadoStratus> datosDebitoStratus = new ArrayList<ModelDebitoRealizadoStratus>();
	private static ModelDebitoRealizadoStratus mov = null;
	

	public ArrayList<ModelDebitoRealizadoStratus> getDatosMovimientoDebito() {
		return datosDebitoStratus;
	}

	public static void mostrarEscritorio() {
		Robot r;
		try {
			r = new Robot();
			Thread.sleep(1000);
			r.keyPress(KeyEvent.VK_WINDOWS);
			r.keyPress(KeyEvent.VK_D);
			Thread.sleep(100);
			r.keyRelease(KeyEvent.VK_WINDOWS);
			r.keyRelease(KeyEvent.VK_D);
		} catch (AWTException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void verificarBloqMayus() {
		Robot r;
		try {
			r = new Robot();
			if (Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK)) {
				r.keyPress(KeyEvent.VK_CAPS_LOCK);
				r.keyRelease(KeyEvent.VK_CAPS_LOCK);
			}
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void iniciarStratus() {

		try {
			iniciarPutty();
			siku_escribir("Host.PNG", "90.4.28.1");
			funcionALT("t");
			funcionALT("o");
//			esperarElementoclk("Telnet.PNG");
//			esperarElementoclk("Open.PNG");
			siku_escribir("Please_login.PNG", "login");
			darEnter(1);
		} catch (Exception e) {

		}

	}

	public static WiniumDriver iniciarPutty() throws MalformedURLException {
		DesktopOptions options = new DesktopOptions();
		options.setApplicationPath("D:\\putty.exe");
		driver = new WiniumDriver(new URL("http://localhost:9999"), options);
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return driver;
	}
	
	public static boolean siku_escribir(String rutaElemento, String txt_muestra) {
		Settings.OcrTextRead = true;
		Settings.OcrTextSearch = true;
		boolean encontrado = false;
		int conteo = 0;
		Screen screen = new Screen();
		String CompletePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "java" + File.separator + "davi" + File.separator + "daviplata" + File.separator
				+ "nacional" + File.separator + "android" + File.separator +"utilidades"+ File.separator + "stratus" + File.separator +  "imagenes_validaciones" + File.separator
				+ rutaElemento;
		System.out.println(CompletePath);
		Pattern validar = new Pattern(CompletePath);
		while (encontrado == false && conteo < 350) {
			try {
				screen.find(validar).below(10).type(txt_muestra);
				encontrado = true;
				// System.out.println("Elemento Encontrado");

			} catch (FindFailed e) {
				encontrado = false;
				// System.out.println("Buscando Elemento");
			}
			conteo++;
		}
		return encontrado;
	}

	public static void funcionALT(String letra) {
		Robot r;
		try {
			r = new Robot();
			Thread.sleep(1000);
			r.keyPress(KeyEvent.VK_ALT);

			if (letra.equalsIgnoreCase("t")) {
				r.keyPress(KeyEvent.VK_T);
				Thread.sleep(100);
				r.keyRelease(KeyEvent.VK_T);
			} else if (letra.equalsIgnoreCase("o")) {
				r.keyPress(KeyEvent.VK_O);
				Thread.sleep(100);
				r.keyRelease(KeyEvent.VK_O);
			}

			r.keyRelease(KeyEvent.VK_ALT);

		} catch (AWTException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void darEnter(int repeticiones) {
		Robot r;
		try {
			r = new Robot();
			for (int i = 0; i < repeticiones; i++) {
				Thread.sleep(100);
				r.keyPress(KeyEvent.VK_ENTER);
				Thread.sleep(100);
				r.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(500);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void loginStratus() {
		try {
			escribirTexto(Credenciales.propertiesStratus().getProperty("stratus.user"));
			darEnter(1);
			escribirTexto(Credenciales.propertiesStratus().getProperty("stratus.user.password"));
			darEnter(1);
			esperarElementoclk("Validacion_ingreso");
			Thread.sleep(1000);
			escribirTexto("2");
			darEnter(1);
			Thread.sleep(1000);
		} catch (Exception e) {

		}
	}


	public static void escribirTexto(String texto) {
		Robot r;
		char q;
		int asciiValue;
		try {
			r = new Robot();
			for (int i = 0; i < (texto.length()); i++) {
				q = texto.charAt(i);
				asciiValue = q;
//				System.out.println(asciiValue);
//				System.out.println(q);
				if (asciiValue >= 97 && asciiValue <= 122) {

					r.keyPress(Character.toUpperCase(q));
					r.keyRelease(Character.toUpperCase(q));

				} else if (asciiValue >= 65 && asciiValue <= 90) {

					r.keyPress(KeyEvent.VK_SHIFT);
					Thread.sleep(500);
					r.keyPress(Character.toUpperCase(q));
					r.keyRelease(Character.toUpperCase(q));
					Thread.sleep(500);
					r.keyRelease(KeyEvent.VK_SHIFT);

				} else {
					r.keyPress(Character.toUpperCase(q));
					r.keyRelease(Character.toUpperCase(q));
					Thread.sleep(100);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean esperarElementoclk(String rutaElemento) {
		Settings.OcrTextRead = true;
		Settings.OcrTextSearch = true;
		boolean encontrado = false;
		int conteo = 0;
		Screen screen = new Screen();
		String CompletePath =  System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "java" + File.separator + "davi" + File.separator + "daviplata" + File.separator
				+ "nacional" + File.separator + "android" + File.separator +"utilidades"+ File.separator + "stratus" + File.separator +  "imagenes_validaciones" + File.separator
				+ rutaElemento;
		Pattern validar = new Pattern(CompletePath);
		while (encontrado == false && conteo < 350) {
			try {
				screen.find(validar).click();
				encontrado = true;
				Thread.sleep(500);
			} catch (FindFailed | InterruptedException e) {

				encontrado = false;
				System.out.println("buscando foto: " + rutaElemento);
			}
			conteo++;

		}
		return encontrado;
	}

	public static void flujoConsultas() {
		try {
			Thread.sleep(1000);
			escribirTexto("1");
			darEnter(2);
			Thread.sleep(1000);
			escribirTexto("4");
			darEnter(2);

//			Utilidades.capturaPantalla("Datos de Cuenta");

		} catch (Exception e) {

		}
	}

	public static void consultarCuenta(String cuenta, String tipoCuenta) {
		esperar(1000);
		seleccionarFuncion("2");
		esperarElemento("Consulta_Maestras.PNG");
		if (tipoCuenta.equals("Cuenta Corriente") || tipoCuenta.equals("Crediplus")
				|| tipoCuenta.equalsIgnoreCase("CC")) {
			escribirTexto("c");
		}
		tabular(1);
		escribirTexto(cuenta);
	}

	public static void seleccionarFuncion(String funcion) {
		Robot r;

		try {
			r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_X);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_X);
			Thread.sleep(500);
			switch (funcion) {
			case "0":
				r.keyPress(KeyEvent.VK_0);
				r.keyRelease(KeyEvent.VK_0);
				break;
			case "1":
				r.keyPress(KeyEvent.VK_1);
				r.keyRelease(KeyEvent.VK_1);
				break;
			case "2":
				r.keyPress(KeyEvent.VK_2);
				r.keyRelease(KeyEvent.VK_2);
				break;

			case "3":
				r.keyPress(KeyEvent.VK_3);
				r.keyRelease(KeyEvent.VK_3);
				break;
			case "4":
				r.keyPress(KeyEvent.VK_4);
				r.keyRelease(KeyEvent.VK_4);
				break;
			case "5":
				r.keyPress(KeyEvent.VK_5);
				r.keyRelease(KeyEvent.VK_5);
				break;
			case "6":
				r.keyPress(KeyEvent.VK_6);
				r.keyRelease(KeyEvent.VK_6);
				break;
			case "7":
				r.keyPress(KeyEvent.VK_7);
				r.keyRelease(KeyEvent.VK_7);
				break;
			case "e":
				r.keyPress(KeyEvent.VK_E);
				r.keyRelease(KeyEvent.VK_E);
				break;

			default:
				break;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static Point esperarElemento(String rutaElemento) {
		Settings.OcrTextRead = true;
		Settings.OcrTextSearch = true;
		boolean encontrado = false;
		int conteo = 0;
		Screen screen = new Screen();
		String CompletePath =  System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "java" + File.separator + "davi" + File.separator + "daviplata" + File.separator
				+ "nacional" + File.separator + "android" + File.separator +"utilidades"+ File.separator + "stratus" + File.separator +  "imagenes_validaciones" + File.separator
				+ rutaElemento;
		Pattern validar = new Pattern(CompletePath);
		Point punto = null;
		while (encontrado == false && conteo < 350) {
			try {
				Thread.sleep(500);
				punto = screen.find(validar).getCenter().getPoint();
				encontrado = true;
				System.out.println("encontre la imagen: " + rutaElemento);
			} catch (FindFailed | InterruptedException e) {
				System.out.println("buscanado imagen: " + rutaElemento);
				encontrado = false;

			}
			conteo++;
		}
		return punto;
	}

	public static void tabular(int repeticiones) {
		Robot r;
		try {
			r = new Robot();
			for (int i = 1; i <= repeticiones; i++) {
				r.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(100);
				r.keyRelease(KeyEvent.VK_TAB);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String obtenerTexto(int corX, int corY, int with, int height) {
		Settings.OcrTextRead = true;
		Settings.OcrTextSearch = true;
		Region region = new Region(corX, corY, with, height);
//		region.highlight(0.5)
		esperar(300);
		String texto = region.text();
		// System.out.println("Texto encontrado: " + texto);
		return texto;
	}

	public static void esperar(long milisegundos) {
		try {
			Thread.sleep(milisegundos);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void salirFlujo(int repeticiones, String flujo) {
		Robot r;
		try {
			r = new Robot();
			for (int i = 1; i <= repeticiones; i++) {
				r.keyPress(KeyEvent.VK_ESCAPE);
				r.keyPress(KeyEvent.VK_Q);
				Thread.sleep(100);
				r.keyRelease(KeyEvent.VK_ESCAPE);
				r.keyRelease(KeyEvent.VK_Q);
				Thread.sleep(500);
			}
			if (flujo.equalsIgnoreCase("Consultas")) {
				escribirTexto("0");
				darEnter(2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void flujoAuxTRDB() {
		esperar(500);
		escribirTexto("4");
		esperar(500);
		darEnter(2);
		esperar(500);
		seleccionarFuncion("2");
		esperar(500);
	}
	public static void salirFlujoDos(int repeticiones, String flujo) {
		Robot r;
		try {
			r = new Robot();
			for (int i = 1; i <= repeticiones; i++) {
				r.keyPress(KeyEvent.VK_ESCAPE);
				r.keyPress(KeyEvent.VK_Q);
				Thread.sleep(100);
				r.keyRelease(KeyEvent.VK_ESCAPE);
				r.keyRelease(KeyEvent.VK_Q);
			}
			if (flujo.equalsIgnoreCase("Consultas")) {
				escribirTexto("0");
				darEnter(2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static String consultarSaldo(String tipoCuenta) {
		String texto = "";
		seleccionarFuncion("1");
//		Utilidades.capturaPantalla("Saldo");
		if (tipoCuenta.contentEquals("Cuenta de Ahorros") || tipoCuenta.contentEquals("AH")) {

			Point puntoTarifas = esperarElemento("saldoTotal.PNG");
//			System.out.println(puntoTarifas);
			texto = obtenerTexto((int) puntoTarifas.getX() + 80, (int) puntoTarifas.getY() - 8, 200, 15);
			Utilidades.tomaEvidenciaStratus("Saldo inicial cuenta de ahorros web");
//			texto = obtenerTextoFollowing("Saldo Total", 160, 100).replace(",", "").replace(" ", "").replace("$", "");

			salirFlujo(1, "Saldo");

		} else {
			escribirTexto("1");
			seleccionarFuncion("1");
//			texto = obtenerTextoFollowing("SALDO TOTAL", 160, 80).replace(",", "").replace(" ", "").replace("$", "")
//					.replace("|", "");
			Point puntoTarifas = esperarElemento("saldoTotalCC.PNG");
//			System.out.println(puntoTarifas);
			Utilidades.tomaEvidenciaStratus("Saldo inicial cuenta corriente.");
			texto = obtenerTexto((int) puntoTarifas.getX() + 78, (int) puntoTarifas.getY() - 6, 200, 15);
			salirFlujo(2, "Saldo");
			System.out.println(texto);
		}
		texto = texto.replace(",", "").replace(" ", "").replace("$", "");
		esperar(250);
		return texto;
	}

	public static void cerrarStratus() {
		driver.quit();
		// esperarElementoclk("AceptarSalirPutty.PNG");
		darEnter(1);
	}

	public static void consultarMovimientos(String tipoCuenta, String numCuenta, String entidad, String horaDebito,
			String saldoFinal) {
		String hora = Utilidades.procesarHora(horaDebito);
		String horaMaxima = StratusDev.calcularHoraMaxima(hora);
		String horaMinima = StratusDev.calcularHoraMinima(hora);
		String auxiliar = "";
		Point puntoTituloPagos = esperarElemento("localizaPagos.PNG");
		int puntoY = (int) puntoTituloPagos.getY() + 24;
		int suma = 0;
		String numTransaccion = "";
		boolean busqueda = true;
		boolean consulta = false;
		tabular(3);
		System.out.println("HORA: " + hora);
		do {
			Utilidades.esperar(500);
			String pantalla = obtenerTexto((int) puntoTituloPagos.getX() - 280, puntoY + suma, 50, 192);
//			System.out.println("Datos Obtenidos: " + pantalla);
			pantalla = pantalla.replaceAll("o", "0").replaceAll("g", "9").replaceAll("O", "0");
			Utilidades.esperar(500);
			if (pantalla.contains(hora) || pantalla.contains(horaMaxima) || pantalla.contains(horaMinima)) {
				Utilidades.tomaEvidenciaStratus("Consultando pago web");
				consulta = true;
				for (int i = 1; i < 11; i++) {
					String[] dato;
//					String textAux = obtenerTexto((int) puntoTituloPagos.getX() - 314, puntoY + suma, 630, 16);
//					System.out.println("Transaccion consultada: " + textAux);
					dato = obtenerTexto((int) puntoTituloPagos.getX() - 314, puntoY + suma, 630, 16).split(" ");
					if (dato.length == 1) {
						busqueda = false;
						break;
					} else if (dato.length < 11) {
						dato[1] = "0000";
					} else if ((dato[1].equals(hora) || dato[1].equals(horaMaxima) || dato[1].equals(horaMinima))) {
						if (!numTransaccion.equals(dato[3])) {
							System.out.println("Hora consultada: " + dato[1]);
							mov = new ModelDebitoRealizadoStratus();
							mov.setSaldoFinal(new BigDecimal(saldoFinal));
							mov.setCuenta(numCuenta);
							mov.setTipoCuenta(tipoCuenta);
							mov.setTipo(dato[4]);
							mov.setValorTotal(new BigDecimal(Utilidades.procesarValor(dato[6])));
							mov.setMotivo(dato[8]);
							consultarValores(tipoCuenta, puntoTituloPagos, puntoY, suma);
							datosDebitoStratus.add(mov);
						}
						numTransaccion = dato[3];
					} else if (horaMaxima.compareTo(dato[1]) < 0) {
						busqueda = false;
						break;
					}
					suma = i * 16;
				}
				if (busqueda) {
					seleccionarFuncion("2");
					suma = 0;
				}
			} else {
				Utilidades.esperar(100);
				seleccionarFuncion("2");
				suma = 0;

				if (auxiliar.equalsIgnoreCase(pantalla) && consulta) 
					busqueda = false;
				 else 
					auxiliar = pantalla;
			}
		} while (busqueda);
	}

	public static void consultarValores(String tipoCuenta, Point puntoTituloPagos, int puntoY, int suma) {
		if (tipoCuenta.equalsIgnoreCase("AH")) {
			mov.setUnidades(new BigDecimal(obtenerCobrosAhorros(puntoTituloPagos, puntoY, suma)));
			mov.setEmergencia(new BigDecimal("0.00"));
		} else {
			mov.setEmergencia(obtenerCobrosCorriente(puntoTituloPagos, puntoY, suma));
			mov.setUnidades(new BigDecimal("0.00"));
		}
		mov.setIva(new BigDecimal(obtenerSoloIva(puntoTituloPagos, puntoY, suma, tipoCuenta)));

	}
	
	public static Double obtenerCobrosAhorros(Point puntoTituloPagos, int puntoY, int suma) {
		String dato[];
		double cobroTotalComision = 0.0;
		try {
			escribirTexto("u");
			seleccionarFuncion("1");
			Thread.sleep(500);
			dato = obtenerTexto((int) puntoTituloPagos.getX() - 314, puntoY + suma, 630, 16).split(" ");
			if (dato.length == 8) {
				cobroTotalComision = Double.parseDouble(dato[7].replace(",", "").replace("S", ""));
//				Utilidades.capturaPantalla("consultar Unidades");
			}
			escribirTexto("i");
			escribirTexto("i");
			seleccionarFuncion("1");
			Thread.sleep(500);
		} catch (Exception e) {
			System.out.println("ERROR CAPTURANDO EL COBRO DE UNIDADES");
			e.printStackTrace();
		}
		System.out.println("EL COBRO UNIDADES ES: " + cobroTotalComision);
		return cobroTotalComision;
	}

	
	public static String obtenerSoloIva(Point puntoTituloPagos, int puntoY, int suma, String tipoCuenta) {
		String dato[];
		double iva = 0.0;
		try {
			escribirTexto("i");
			seleccionarFuncion("1");
			Thread.sleep(500);
			dato = obtenerTexto((int) puntoTituloPagos.getX() - 314, puntoY + suma, 630, 16).split(" ");
			if (dato.length == 8) {
				iva = Double.parseDouble(dato[7].replace(",", "").replace("S", ""));
//				if (tipoCuenta.equalsIgnoreCase("CUENTA DE AHORROS"))
////					Utilidades.capturaPantalla("consultar IVA");
			}
			escribirTexto("i");
			seleccionarFuncion("1");
			Thread.sleep(500);
		} catch (Exception e) {
			System.out.println("ERROR CAPTURANDO EL COBRO DE UNIDADES");
			e.printStackTrace();
		}
		System.out.println("EL COBRO DE SOLO IVA ES: " + iva);
		String valorIva = String.valueOf(iva);
		return valorIva;
	}

	public static BigDecimal obtenerCobrosCorriente(Point puntoTituloPagos, int puntoY, int suma) {
		String dato[];
		double emergencia = 0.0;
		try {

			escribirTexto("e");
			seleccionarFuncion("1");
			Thread.sleep(500);
			dato = obtenerTexto((int) puntoTituloPagos.getX() - 314, puntoY + suma, 630, 16).split(" ");
			if (dato.length == 9) {
				System.out.println("esta es la emergencia que esta obteniendo sikulix: "+ dato[8]);
				emergencia = Double.parseDouble(dato[8].replace(",", "").replace("-", "."));
				System.out.println("Esta es la emergencia en Double: "+emergencia);
//				Utilidades.capturaPantalla("consultar 'emergencia'");
			}
			escribirTexto("i");
			escribirTexto("i");
			seleccionarFuncion("1");
			Thread.sleep(250);
		} catch (Exception e) {
			System.out.println("ERROR CAPTURANDO EL VALOR DE IVA Y EMERGENCIA");
		}
		System.out.println("EMERGENCIA ES: " + String.valueOf(emergencia));
		return (new BigDecimal(emergencia));
	}
	
	public static String calcularHoraMaxima(String hora) {
		String horaLetras = hora.substring(0, 2);
		String minutosLetras = hora.substring(2, 4);
		int auxMinutos = 1 + Integer.parseInt(minutosLetras);
		int auxHoras = Integer.parseInt(horaLetras);
		if (auxMinutos == 60) {
			auxMinutos = 0;
			auxHoras = auxHoras + 1;
			minutosLetras = "0".concat(String.valueOf(auxMinutos));
		} else if (auxMinutos > 9)
			minutosLetras = String.valueOf(auxMinutos);
		else if (auxMinutos <= 9)
			minutosLetras = "0".concat(String.valueOf(auxMinutos));
		if (auxHoras == 24) {
			auxHoras = 0;
			horaLetras = "0".concat(String.valueOf(auxHoras));
		} else if (auxHoras > 9)
			horaLetras = String.valueOf(auxHoras);
		else if (auxHoras <= 9)
			horaLetras = "0".concat(String.valueOf(auxHoras));
		horaMaxima = String.valueOf(horaLetras).concat(minutosLetras);
		return horaMaxima;
	}

	public static String calcularHoraMinima(String hora) {
		String horaLetras = hora.substring(0, 2);
		String minutosLetras = hora.substring(2, 4);
		int auxMinutos = Integer.parseInt(minutosLetras) - 1;
		int auxHoras = Integer.parseInt(horaLetras);
		if (auxMinutos == -1) {
			auxMinutos = 59;
			auxHoras = auxHoras - 1;
			minutosLetras = String.valueOf(auxMinutos);
		} else if (auxMinutos > 9)
			minutosLetras = String.valueOf(auxMinutos);
		else if (auxMinutos <= 9)
			minutosLetras = "0".concat(String.valueOf(auxMinutos));
		if (auxHoras == -1) {
			auxHoras = 23;
			horaLetras = String.valueOf(auxHoras);
		} else if (auxHoras > 9)
			horaLetras = String.valueOf(auxHoras);
		else if (auxHoras <= 9)
			horaLetras = "0".concat(String.valueOf(auxHoras));
		return String.valueOf(horaLetras).concat(minutosLetras);
	}

}*/

public class StratusDev {}


