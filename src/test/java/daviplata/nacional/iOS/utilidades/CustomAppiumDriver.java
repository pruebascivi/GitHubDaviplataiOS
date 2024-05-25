package daviplata.nacional.iOS.utilidades;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CustomAppiumDriver {

	
	public AppiumDriver<MobileElement> driver;
	private DesiredCapabilities dc;

	public CustomAppiumDriver() {
		iniciarAppiumDriver();
	}

	public void iniciarAppiumDriver() {
		dc = new DesiredCapabilities();
		dc.setCapability("bundleId", Credenciales.parametrosGenerales().getProperty("appium.bundleId"));
		dc.setCapability("noReset", Credenciales.parametrosGenerales().getProperty("appium.noReset"));
		dc.setCapability("skipUnlock", Credenciales.parametrosGenerales().getProperty("appium.skipUnlock"));
		dc.setCapability("showXcodelog", Credenciales.parametrosGenerales().getProperty("appium.showXcodelog"));
		dc.setCapability("autoAcceptAlerts", Credenciales.parametrosGenerales().getProperty("appium.autoAcceptAlerts"));
		dc.setCapability("newCommandTimeout",
				Credenciales.parametrosGenerales().getProperty("appium.newCommandTimeout"));
		dc.setCapability("automationName", Credenciales.parametrosGenerales().getProperty("appium.automationName"));

//		Devices
		dc.setCapability("deviceName", Credenciales.parametrosGenerales().getProperty("appium.device.deviceName"));
		BaseUtil.nombreDispositivo = Credenciales.parametrosGenerales().getProperty("appium.device.deviceName");
		dc.setCapability("platformName", Credenciales.parametrosGenerales().getProperty("appium.device.platformName"));
		dc.setCapability("platformVersion",
				Credenciales.parametrosGenerales().getProperty("appium.device.platformVersion"));
		dc.setCapability("udid", Credenciales.parametrosGenerales().getProperty("appium.device.udid"));
		try {
			BaseUtil.driver = new AppiumDriver<MobileElement>(
					new URL(Credenciales.parametrosGenerales().getProperty("appium.server.url")), dc);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public AppiumDriver<MobileElement> getCustomDriver() {
		return BaseUtil.driver;
	}
}
