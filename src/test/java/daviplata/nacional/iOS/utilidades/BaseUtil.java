package daviplata.nacional.iOS.utilidades;

import cucumber.api.Scenario;
//import daviplata.nacional.iOS.definitions.MarketPlaceDefinitions;
import daviplata.nacional.iOS.pageObjects.AcercaDePageObjects;
//import daviplata.nacional.iOS.pageObjects.BolsillosPageObjects;
//import daviplata.nacional.iOS.pageObjects.ClaveCorreoPageObject;
//import daviplata.nacional.iOS.pageObjects.CodigoQRPageObjects;
import daviplata.nacional.iOS.pageObjects.HomePageObjects;
//import daviplata.nacional.iOS.pageObjects.LatiniaPageObjects;
import daviplata.nacional.iOS.pageObjects.LoginPageObjects;
//import daviplata.nacional.iOS.pageObjects.MenuHamburPageObjects;
//import daviplata.nacional.iOS.pageObjects.NanoCreditoPageObjects;
import daviplata.nacional.iOS.pageObjects.PagarPageObjects;
import daviplata.nacional.iOS.pageObjects.PasarPlataPageObjects;
import daviplata.nacional.iOS.pageObjects.SacarPlataPageObjects;
import daviplata.nacional.iOS.pageObjects.WebRedebanPageObjects;
import daviplata.nacional.iOS.steps.AcercaDeSteps;
//import daviplata.nacional.iOS.steps.ClaveCorreoSteps;
import daviplata.nacional.iOS.steps.EcardSteps;
import daviplata.nacional.iOS.steps.LoginSteps;
//import daviplata.nacional.iOS.steps.NanoCreditoSteps;
import daviplata.nacional.iOS.steps.PagarSteps;
//import daviplata.nacional.iOS.steps.RecargaSteps;
import daviplata.nacional.iOS.steps.SacarPlataSteps;
import daviplata.nacional.iOS.steps.WebRedebanSteps;
//import daviplata.nacional.iOS.utilidades.stratus.StratusDev;
import daviplata.nacional.iOS.steps.PasarPlataSteps;
//import daviplata.nacional.iOS.steps.MarketPlaceSteps;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import java.math.BigDecimal;
import java.util.Properties;

import daviplata.nacional.iOS.definitions.Hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Pattern;

import com.github.javafaker.Faker;

public class BaseUtil {
	
	public static String baseInfo;
	public  static WebDriverWait wait;
	public WebDriverWait waitAll;
	public String numCelular;
	public static String numero;
	public static String numCelularUsuarioDestino = "";
	public static String numCelularRedeban = "";
	public static AppiumDriver<MobileElement> driver;
    public static IOSDriver<MobileElement> driveriOS;
	//public LoginSteps stepsLogin;
	//public LoginPageObjects pageLogin;
	public  static Utilidades utilidad;
	public  static Evidencias evidencia;
	//public PasarPlataSteps stepsPasarPlata;
	//public PasarPlataPageObjects pagePasarPlata;
	//public AcercaDeSteps stepsAcercaDe;
	//public AcercaDePageObjects pageAcercaDe;
	public static Scenario scenario;
	//public RecargaSteps stepsRecarga;
	public static String Autorizador;
	public static String fechaAutorizador;
	public static BigDecimal saldo;
	public static BigDecimal saldoInicial;
	public static BigDecimal saldoSinDecimal;
	public static BigDecimal saldoInicialTarjeta;
	public static BigDecimal montoTransado;
	//Valores Seguro
	public static String numeroPoliza;
	public static String ValorPoliza;
	public static BigDecimal ValorPago;
	//Fin De Valores Seguro
	public static String montoTrasadoRedeban;
	public static BigDecimal comision = new BigDecimal("0.00");
	public static BigDecimal saldoFinal;
	//public ClaveCorreoSteps stepsClaveCorreo;
	//public ClaveCorreoPageObject pageClaveCorreo;
	//public MenuHamburPageObjects pageMenuHamburguesa;
	public static HomePageObjects pageHome;
	public static SacarPlataPageObjects pageSacarPlata;
	public static SacarPlataSteps stepsSacarPlata;
	public static PagarPageObjects pagePagar;
	public static PagarSteps stepsPagar;
	public static Cronometro cronometro;
	public static BigDecimal saldoBolsillo;
	//public NanoCreditoSteps stepsNanoCreditoSteps;
	//public NanoCreditoPageObjects pageNanoCredito;
	public static EcardSteps stepsEcard;
	public static WebDriver chromeDriver;
	public static WebDriver chromeDriverLatinia;
	public static WebDriver chromeDriverNLatinia;
	//public CustomChromeDriver configChromeDriver;
	//public LatiniaPageObjects pageLatinia;
	public static WebRedebanPageObjects webRedebanPageObjects;
	public static WebRedebanSteps stepsWebRedeban;
	public static BigDecimal saldoTotalInicial;
	public static BigDecimal saldoTotalFinal;
	//public BolsillosPageObjects objBolsillosPageObjects;
	//public MarketPlaceDefinitions objQRDefinitions;
	//public MarketPlaceSteps objQRSteps;
	//public CodigoQRPageObjects objCodigoQRPageObjects;
	//public Pattern pattern;
	//public StratusDev stratusdev;
	//Excel
	public static String NombreImagen;
	public static String [] NombreImage = new String[100];
	public static String nombreBolsillo = "";
	//Datos Set Operacion - Regresion
	public static String usuario = "-";
	public static String numeroCelular = "No Aplica";
	public static String saldoIni = "-";
	public static String cuentaONumero = "-";
	public static String cuentaONumero2 = "-";
	public static String monto = "-";
	public static String saldoFin = "-";
	public static String idTransaccion = "-";
	public static String fechaHora = "-";
	public static String NombreSce = "";
	public static String topeCreditos = "";
	public static String topeDebitos = "";
	public static String topeCreditosActual = "";
	public static String topeDebitosActual = "";
	public static int sumaCredito = 0;
	public static int sumaDebito = 0;
	public static String numeroCelularOtp = "";
	public static String numeroOTP = "";
	public static String numeroCelularRedeban = "";
	public static String correoActual = "";
	public static String tituloBusqueda = new String();
	public static String nombreDispositivo = "No Hay Dispositivo Conectado";
	public static String versionApp = "";
	public static int fila;
	public static String urlCopy = "";
	


}
