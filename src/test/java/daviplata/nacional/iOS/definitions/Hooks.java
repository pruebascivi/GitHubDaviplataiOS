package daviplata.nacional.iOS.definitions;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import daviplata.nacional.iOS.pageObjects.WebRedebanPageObjects;
import daviplata.nacional.iOS.steps.WebRedebanSteps;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import daviplata.nacional.iOS.utilidades.Credenciales;
import daviplata.nacional.iOS.utilidades.Cronometro;
import daviplata.nacional.iOS.utilidades.CustomAppiumDriver;
import daviplata.nacional.iOS.utilidades.Evidencias;
import daviplata.nacional.iOS.utilidades.MobileActions;
import daviplata.nacional.iOS.utilidades.Utilidades;
import daviplata.nacional.iOS.utilidades.rest.ALMRest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Hooks {
	 BaseUtil base;
	 CustomAppiumDriver cd;
	 
	 WebDriverWait wait;
	 public static Scenario scenario;
	 public static Scenario scenario1;
	 Cronometro crono = new Cronometro();
	 static AppiumDriver<MobileElement> driverAll;
	 static WebDriverWait waitAll;
	 public MobileActions mobileActions;


	@Before
	public void iniciarTests(Scenario scenario) throws InterruptedException {
		Runtime.getRuntime().gc();
		System.gc();
		Evidencias.numeroScreen = 1;
		int valueWait = Integer.parseInt(Credenciales.parametrosGenerales().getProperty("wait"));
		Hooks.scenario = scenario;
		cd = new CustomAppiumDriver();
		BaseUtil.driver = cd.getCustomDriver();
		driverAll = BaseUtil.driver;
		BaseUtil.wait = new WebDriverWait(BaseUtil.driver, 10);
		waitAll = BaseUtil.wait;
		System.setProperty("RutaEvidencias", System.getProperty("user.dir") + File.separator + "Evidencias"
				+ File.separator + scenario.getName().split("_")[0]);
		new File(System.getProperty("user.dir") + File.separator + "Evidencias" + File.separator
				+ scenario.getName().split("_")[0]).mkdirs();
		System.out.println(System.getProperty("RutaEvidencias"));
		Evidencias.eleminarImagenes(System.getProperty("RutaEvidencias"));
		crono.iniciarCronometro();
		String scenario1=scenario.getName();
		System.setProperty("idScenario", scenario1);
	}

	@After
	public void FinalizarTests(Scenario scenario) throws InterruptedException {
		System.out.println(scenario.getStatus());
		if (scenario.isFailed()) {
			try {
				Evidencias.capturaDispositivo("Se presento un error");
			} catch (IOException e) {
				e.printStackTrace();
			}
//			try {
//				Evidencias.capturaPantalla("Web - Se presento un error");
//			} catch(Exception e) {
//				System.out.println("No se encontró Chrome driver abierto");
//			}
		}
		try {
			Evidencias.generarReporte(System.getProperty("RutaEvidencias"), scenario.getName(),
					scenario.getStatus().toString(), crono.pararCronometro());
			System.out.println("Nombre Caso: "+scenario.getName().toString());
			System.out.println("Status: "+ scenario.getStatus().toString());
			System.out.println("Nombre Archivo:"+System.getProperty("RutaEvidencias")+File.separator+"Evidencias_"+scenario.getName().split("_")[0]+"_"+scenario.getStatus().toString()+"_" + Utilidades.formatDateInforme("yyyy-MM-dd_HH-mm-ss", Evidencias.fechaPrueba) + ".docx");
			//ALMRest.changeStatusCase(scenario.getName().toString(), scenario.getStatus().toString(), System.getProperty("RutaEvidencias")+File.separator+"Evidencias_"+scenario.getName().split("_")[0]+"_"+scenario.getStatus().toString()+"_" + Utilidades.formatDateInforme("yyyy-MM-dd_HH-mm-ss", Evidencias.fechaPrueba) + ".docx");
			//base.driver.closeApp();
			//base.driver.quit();
			Evidencias.numeroScreen = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseUtil.saldo = null;
		BaseUtil.saldoInicial = null;
		BaseUtil.saldoSinDecimal = null;
		BaseUtil.saldoFinal = null;
		BaseUtil.saldoFin = null;
		BaseUtil.saldoTotalInicial = null;
		BaseUtil.saldoTotalFinal = null;
		//BaseUtil.driver.quit();
		BaseUtil.driver.closeApp();
		//base.driver.quit();
		Evidencias.numeroScreen = 1;
		Runtime.getRuntime().gc();
		System.gc();
	}

	public static AppiumDriver<MobileElement> getDriver() {
		return BaseUtil.driver;
	}

	public static WebDriverWait getDriverWait() {
		return waitAll;
	}

	public static Scenario getScenario() {
		scenario1 = scenario;
		return scenario1;
	}
	
}
