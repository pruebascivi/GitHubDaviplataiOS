package daviplata.nacional.iOS.pageObjects;

import org.openqa.selenium.support.ui.WebDriverWait;

import daviplata.nacional.iOS.definitions.Hooks;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TecladoDaviPageObjects {
    
	private AppiumDriver<MobileElement> driver= Hooks.getDriver();
	private WebDriverWait wait =Hooks.getDriverWait();
	
}
