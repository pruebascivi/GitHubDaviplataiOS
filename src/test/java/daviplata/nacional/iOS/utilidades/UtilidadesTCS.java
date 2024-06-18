package daviplata.nacional.iOS.utilidades;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.hamcrest.Matcher;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import daviplata.nacional.iOS.definitions.Hooks;
import daviplata.nacional.iOS.pageObjects.LoginRobustoPage;
import daviplata.nacional.iOS.pageObjects.NotificacionesPushPageObjects;
import daviplata.nacional.iOS.pageObjects.PreguntasFrecuentesPageObjects;
import daviplata.nacional.iOS.pageObjects.negocioPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.core.pages.PageObject;
import java.util.regex.Pattern;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import io.appium.java_client.touch.WaitOptions;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class UtilidadesTCS extends PageObject {

	Utilidades utilidades;
	int contador = 0;
	BaseUtil base;
	CustomChromeDriver confiChromeDriver;
	private WebDriverWait wait = new WebDriverWait(Hooks.getDriver(), 5);
	private AppiumDriver<MobileElement> driver = Hooks.getDriver();
	negocioPageObjects negocioPage;
	Utilidades utilidad;
	
	/**
	 * Este método utiliza la clase WebElement para encontrar y hacer clic en el elemento utilizando el método click().
	 * Es adecuado para interactuar con elementos estándar en una página web o en una aplicación móvil.
	 * Utiliza Selenium WebDriver para realizar la acción de clic.
	 * 
	 * @param locatorType : Tipo de localizador utilizado para identificar el elemento (por ejemplo, "name", "id" o "xpath").
	 * @param locator : Valor del localizador que especifica la ubicación del elemento.
	 */
	public void clicElement(String locatorType, String locator) {
		BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		By by = null;
		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}
		try {
			BaseUtil.driver.findElement(by).click();
			System.out.println("Se realizó clic en: " + locator);
		} catch (Exception e) {
			fail("No pudo interactuar con el elemento: " + locator);
		}
	}
	
	/**
	 * Método útil cuando necesitas realizar acciones más complejas o específicas en un elemento, 
	 * 		como hacer clic en un elemento mientras se mueve el cursor sobre él o realizar clics con el botón derecho del mouse.
	 * Es más flexible y puede manejar casos más avanzados de interacción con elementos.
	 * Este método utiliza la clase MobileElement para encontrar el elemento y crea una instancia 
	 *   	de Actions para realizar la acción de clic utilizando moveToElement(element).click().perform().
	 * 
	 * @param locatorType : Tipo de localizador utilizado para identificar el elemento (por ejemplo, "name", "id" o "xpath").
	 * @param locator : Valor del localizador que especifica la ubicación del elemento.
	 */
	public void clicElementAction(String locatorType, String locator) {
		BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		By by = null;
		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}
		try {
			MobileElement element = BaseUtil.driver.findElement(by);
			Actions actions = new Actions(BaseUtil.driver);
			actions.moveToElement(element).click().perform();
			
			System.out.println("Se realizó clic en: " + locator);
		} catch (Exception e) {
			fail("No pudo interactuar con el elemento: " + locator);
		}
	}

	/**
	 * Método útil para obtener el texto de un elemento en la interfaz de usuario.
	 * 
	 * 
	 * @param locatorType : Tipo de localizador utilizado para identificar el elemento (por ejemplo, "name", "id" o "xpath").
	 * @param locator : Valor del localizador que especifica la ubicación del elemento.
	 * @return
	 */
	public String obtenerTexto(String locatorType, String locator) {
		BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String txt = "Vacio";
		By by = null;
		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}
		try {
			txt = BaseUtil.driver.findElement(by).getText();
			System.out.println("Se obtuvo el texto del elemento: " + locator);
		} catch (Exception e) {
			fail("No se pudo interactuar con el elemento: " + locator);
		}
		return txt;
	}

	/**
	 * 
	 * @param locatorType : Tipo de localizador utilizado para identificar el elemento (por ejemplo, "name", "id" o "xpath").
	 * @param locator : Valor del localizador que especifica la ubicación del elemento.
	 * @return
	 */
	public String obtenerTextoAtributoName(String locatorType, String locator) {
		BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String txt = "Vacio";
		By by = null;
		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}
		try {
			txt = BaseUtil.driver.findElement(by).getAttribute("name");
			System.out.println("Se obtuvo el texto del elemento: " + locator);
		} catch (Exception e) {
			fail("No se pudo interactuar con el elemento: " + locator);
		}
		return txt;
	}

	/*
	 * 
	 */
	public boolean validateElementInvisibility(String locatorType, String locator) {
		BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		boolean check = false;
		By by = null;

		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}

		try {
			// Si findElement lanza una excepción, significa que el elemento no está presente
			BaseUtil.driver.findElement(by);
			// Si no se lanza ninguna excepción, el elemento está presente
			check = false;
			fail("Se verifica que el elemento no esté presente y la validación muestra que el elemento esta presente: "
					+ locator);
		} catch (NoSuchElementException e) {
			// El elemento no fue encontrado, lo que indica que está ausente
			check = true;
			System.out.println("El elemento " + locator + " no esta presente");
		}

		return check;
	}

    /**
     * Método para validar un elemento visible que retorna un boolean
     * 
	 * @param locatorType : Tipo de localizador utilizado para identificar el elemento (por ejemplo, "name", "id" o "xpath").
	 * @param locator : Valor del localizador que especifica la ubicación del elemento.
     * @return check = true or false de a cuerdo si el elemento es visible o no
     */
	public boolean validateElementVisibilityCatch(String locatorType, String locator) {
		BaseUtil.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		boolean check = false;
		By by = null;

		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}

		try {
			check = BaseUtil.driver.findElement(by).isDisplayed();
			System.out.println("Se verifica presencia del elemento: " + locator);
		} catch (Exception e) {
			System.out.println("No se pudo interactuar con el elemento: " + locator);
		}
		return check;
	}
	
	/**
	 * 
	 * @param locatorType : Tipo de localizador utilizado para identificar el elemento (por ejemplo, "name", "id" o "xpath").
	 * @param locator : Valor del localizador que especifica la ubicación del elemento.
	 * @return
	 */
	public boolean validateElementVisibility(String locatorType, String locator) {
		BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		boolean check = false;
		By by = null;

		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}

		try {
			check = BaseUtil.driver.findElement(by).isDisplayed();
			System.out.println("Se verifica presencia del elemento: " + locator);
		} catch (Exception e) {
			fail("No se pudo interactuar con el elemento: " + locator);
		}

		return check;
	}
	
	/**
	 * 
	 * @param locatorType : Tipo de localizador utilizado para identificar el elemento (por ejemplo, "name", "id" o "xpath").
	 * @param locator : Valor del localizador que especifica la ubicación del elemento.
	 * @param texto
	 */
	public void writeElement(String locatorType, String locator, String texto) {
		BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		By by = null;

		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}

		try {
			BaseUtil.driver.findElement(by).sendKeys(texto);
			System.out.println("Se escribe el texto: " + texto + " en el elemento: " + locator);
		} catch (Exception e) {
			fail("No se pudo interactuar con el elemento: " + locator);
		}
	}
	
	/**
	 * 
	 * @param locatorType : Tipo de localizador utilizado para identificar el elemento (por ejemplo, "name", "id" o "xpath").
	 * @param locator : Valor del localizador que especifica la ubicación del elemento.
	 * @param texto
	 */
	public void writeElementAction(String locatorType, String locator, String texto) {
        BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        By by = null;
        switch (locatorType) {
        case "name":
            by = By.name(locator);
            break;
        case "id":
            by = By.id(locator);
            break;
        case "xpath":
            by = By.xpath(locator);
            break;
        default:
            throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
        }
        try {
            MobileElement element = BaseUtil.driver.findElement(by);
            Actions action = new Actions(BaseUtil.driver);
            action.sendKeys(element).perform();
            System.out.println("Se escribe el texto: " + texto + " en el elemento: " + locator);
        } catch (Exception e) {
            fail("No se pudo interactuar con el elemento: " + locator);
        }
    }

	/**
	 * 
	 * @param locatorType : Tipo de localizador utilizado para identificar el elemento (por ejemplo, "name", "id" o "xpath").
	 * @param locator : Valor del localizador que especifica la ubicación del elemento.
	 */
	public void esperarElementVisibility(String locatorType, String locator) {
		By by = null;

		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}

		try {
			contador++;
			MobileElement element = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				esperarElementVisibility(locatorType, locator);
			} else {
				fail("No se encontró el elemento: " + locator + ", debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	/**
	 * 
	 * @param locatorType : Tipo de localizador utilizado para identificar el elemento (por ejemplo, "name", "id" o "xpath").
	 * @param locator : Valor del localizador que especifica la ubicación del elemento.
	 */
	public void esperarElementPresente(String locatorType, String locator) {
		By by = null;

		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}

		try {
			contador++;
			MobileElement element = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(by));
		} catch (Exception e) {
			if (!(contador == 15)) {
				Utilidades.esperaMiliseg(500);
				esperarElementPresente(locatorType, locator);
			} else {
				fail("No se encontró el elemento: " + locator + ", debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

    /**
     * Valida que el texto extraído contiene al menos una de las subcadenas especificadas.
     *
     * @param textoExtraido El texto completo extraído.
     * @param textoIgualado Las posibles subcadenas que se espera encontrar en el texto extraído.
     */
    @SuppressWarnings("unchecked")
	public void validateTextContainsString(String textoExtraido, String... textoIgualado) {
        assertThat(textoExtraido, anyOf(
                Arrays.stream(textoIgualado)
                      .map(substring -> containsString(substring))
                      .toArray(Matcher[]::new)
        ));
    }

	/**
	 * 
	 * @param estado
	 */
	public void validateStatusElement(boolean estado) {
		assertThat(estado, is(true));
	}
	
	/**
	 * 
	 * @param estado
	 */
	public void validateStatusElementFalse(boolean estado) {
        assertThat(estado, is(false));
    }

	/**
	 * 
	 * @param textoExtraido
	 * @param textoIgualado
	 */
	public void validateTextEqualTo(String textoExtraido, String textoIgualado) {
		assertThat(textoExtraido, equalTo(textoIgualado));
	}

	/**
	 * 
	 * @param locatorType : Tipo de localizador utilizado para identificar el elemento (por ejemplo, "name", "id" o "xpath").
	 * @param locator : Valor del localizador que especifica la ubicación del elemento.
	 * @return
	 */
	public boolean validateElementEnabled(String locatorType, String locator) {
		BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		boolean check = false;
		By by = null;

		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}

		try {
			check = BaseUtil.driver.findElement(by).isEnabled();
			System.out.println("Se verifica el estado de habilitación del elemento: " + locator);
		} catch (Exception e) {
			fail("No se pudo interactuar con el elemento: " + locator);
		}

		return check;
	}

	/**
	 * 
	 * @param valorExtraido
	 * @param rango
	 * @return
	 */
	public String validarLongitudNumerica(String valorExtraido, int rango) {
		int longitud = valorExtraido.length();
		assertThat(longitud, equalTo(rango));
		String longString = Integer.toString(longitud);
		return longString;
	}

	/**
	 * Método para validar los carácteres númericos de un string
	 * 
	 * @param texto
	 * @return mensaje de cantidad de carácteres númericos del texto evaluado.
	 */
	public String validarCaracteresNumericos(String texto) {
		String mensaje = "";
		if (texto.matches("\\d+")) {
			mensaje = "Sí, contiene solo caracteres numéricos";
		} else {
			mensaje = "No, se encontraron letras o caracteres especiales";
		}
		return mensaje;
	}

	/**
	 * 
	 * @param locatorType : Tipo de localizador utilizado para identificar el elemento (por ejemplo, "name", "id" o "xpath").
	 * @param locator : Valor del localizador que especifica la ubicación del elemento.
	 */
	public void cleanInputElement(String locatorType, String locator) {
		BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		By by = null;

		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}

		try {
			BaseUtil.driver.findElement(by).clear();
			System.out.println("Se limpió el campo del elemento: " + locator);
		} catch (Exception e) {
			fail("No se pudo interactuar con el elemento: " + locator);
		}
	}

	/**
	 * 
	 * @param numero
	 * @return
	 */
	public boolean validarFormatoDecimalesNumero(String numero) {
		return numero.contains(".");
	}

	/**
	 * 
	 * @param texto
	 * @param longitudMaxima
	 * @return
	 */
	public boolean validarLongitudDeLoIngresadoEnElCampo(String texto, int longitudMaxima) {
		return texto.length() <= longitudMaxima;
	}

	/**
	 * 
	 * @param locatorType : Tipo de localizador utilizado para identificar el elemento (por ejemplo, "name", "id" o "xpath").
	 * @param locator : Valor del localizador que especifica la ubicación del elemento.
	 * @param optionNotAppear
	 */
	public void validateListElementsOptionNotAppear(String locatorType, String locator, String optionNotAppear) {
		BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		By by = null;
		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}
		ArrayList<MobileElement> listaElementos = (ArrayList<MobileElement>) BaseUtil.driver.findElements(by);

		for (int j = 0; j < (listaElementos.size()); j++) {
			System.out.println(" ");
			String textoElemento = listaElementos.get(j).getText();
			assertThat(textoElemento, is(not(equalToIgnoringCase(optionNotAppear))));
			System.out.println(listaElementos.get(j).getText() + " no es igual a " + optionNotAppear);
		}
	}

	/**
	 * 
	 * @param locatorType : Tipo de localizador utilizado para identificar el elemento (por ejemplo, "name", "id" o "xpath").
	 * @param locator : Valor del localizador que especifica la ubicación del elemento.
	 * @param optionAppear
	 */
	public void validateListElementsOptionAppear(String locatorType, String locator, String optionAppear) {
		BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		By by = null;
		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}

		ArrayList<MobileElement> listaElementos = (ArrayList<MobileElement>) BaseUtil.driver.findElements(by);
		boolean seEncontro = false;

		for (int j = 0; j < (listaElementos.size()); j++) {
			System.out.println(" ");
			String textoElemento = listaElementos.get(j).getText();
			if (textoElemento.equalsIgnoreCase(optionAppear)) {
				System.out.println(listaElementos.get(j).getText() + " es igual a " + optionAppear);
				seEncontro = true;
				break;
			} else {
				System.out.println(listaElementos.get(j).getText() + " no es igual a " + optionAppear);
			}
		}

		if (!seEncontro) {
			throw new RuntimeException("No se encontró el texto '" + optionAppear + "' en la lista de elementos.");
		}
	}
	
	/**
	 * 
	 * @param valorExtraido
	 * @return
	 */
	public boolean validateContainsAlphanumericCharacters(String valorExtraido) {
		boolean check = false;
		if (valorExtraido.matches("^(?=.*[a-zA-Z])(?=.*\\d).*$")) {
			check = true;
		} else {
			check = false;
			fail("No contiene caracteres alfanuméricos");
		}
		return check;
	}
	
	/**
	 * 
	 * @param estado
	 */
	public void validateStringTextNotEmpty(String estado) {
		assertThat(estado.trim(), is(not(equalTo(""))));
	}

	/**
	 * 	
	 * @param textoExtraido
	 * @param textoIgualado
	 */
	public void validateTextNotEqualTo(String textoExtraido, String textoIgualado) {
		assertThat(textoExtraido, is(not(equalTo(textoIgualado))));
	}

	/**
	 * 
	 * @param valor
	 */
	public void escribirPorTecladoIos(String valor) {
		BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		try {
			for (int i = 0; i < valor.length(); i++) {
				String numero = String.valueOf(valor.charAt(i));
				String teclas = "//XCUIElementTypeKey[@name='" + numero + "']";
				driver.findElement(By.xpath(teclas)).click();
			}
		} catch (Exception e) {
			fail("No pudo interactuar con el elemento del teclado de iOS, debido a: " + e.getMessage());
		}
	}  

	/**
	 * 
	 * @param locatorType : Tipo de localizador utilizado para identificar el elemento (por ejemplo, "name", "id" o "xpath").
	 * @param tipoDocumento
	 */
	public void seleccionarTipoDocumentoInput(String locatorType, String tipoDocumento) {
		BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String getLocator = "";
		By by = null;
		switch (tipoDocumento) {
		case "TI":
			getLocator = PreguntasFrecuentesPageObjects.OPCION_TARJETA_IDENTIDAD;
			break;
		case "CC":
			getLocator = PreguntasFrecuentesPageObjects.OPCION_CEDULA_CIUDADANIA;
			break;
		case "CE":
			getLocator = PreguntasFrecuentesPageObjects.OPCION_CEDULA_EXTRANJERIA;
			break;
		case "PEP":
			getLocator = PreguntasFrecuentesPageObjects.OPCION_CEDULA_EXTRANJERIA;
			break;
		default:
			throw new IllegalArgumentException("Tipo de documento no válido: " + tipoDocumento);
		}
		switch (locatorType) {
		case "name":
			by = By.name(getLocator);
			break;
		case "id":
			by = By.id(getLocator);
			break;
		case "xpath":
			by = By.xpath(getLocator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}
		try {
			BaseUtil.driver.findElement(by).click();
			System.out.println("Se hizo clic en " + tipoDocumento + " del elemento " + getLocator);

		} catch (Exception e) {
			fail("No se pudo interactuar con el elemento: " + getLocator);
		}
	}
	
	/**
	 * 
	 * @param locatorType : Tipo de localizador utilizado para identificar el elemento (por ejemplo, "name", "id" o "xpath").
	 * @param tipoDocumento
	 */
	public void seleccionarTipoProducto(String locatorType, String tipoProducto) {
		BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String getLocator = "";
		By by = null;
		switch (tipoProducto) {
		case "Cuenta de Ahorros":
			getLocator = negocioPageObjects.TP_CUENTA_AHORRO;
			break;
		case "Cuenta Corriente":
			getLocator = negocioPageObjects.TP_CUENTA_CORRIENTE;
			break;
		case "Monedero":
			getLocator = negocioPageObjects.TP_MONEDERO;
			break;
		default:
			throw new IllegalArgumentException("Tipo de documento no válido: " + tipoProducto);
		}
		switch (locatorType) {
		case "name":
			by = By.name(getLocator);
			break;
		case "id":
			by = By.id(getLocator);
			break;
		case "xpath":
			by = By.xpath(getLocator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}
		try {
			BaseUtil.driver.findElement(by).click();
			System.out.println("Se hizo clic en " + tipoProducto + " del elemento " + getLocator);

		} catch (Exception e) {
			fail("No se pudo interactuar con el elemento: " + getLocator);
		}
	}

	/**
	 * 
	 * @param locatorType : Tipo de localizador utilizado para identificar el elemento (por ejemplo, "name", "id" o "xpath").
	 * @param locator : Valor del localizador que especifica la ubicación del elemento.
	 * @param expectedCount
	 * @return
	 */
	public boolean validateQuantityOfElements(String locatorType, String locator, int expectedCount) {
		BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		By by = null;

		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}

		ArrayList<MobileElement> listaElementos = (ArrayList<MobileElement>) BaseUtil.driver.findElements(by);

		int cantidadElementos = listaElementos.size();
		System.out.println("Cantidad de elementos encontrados: " + cantidadElementos);

		return cantidadElementos == expectedCount;
	}

	/**
	 * 
	 * @param textoExtraido
	 * @param textoIgualado
	 */
	public void validateTextContainsStringIgnoreUppercaseLowercase(String textoExtraido, String textoIgualado) {
		assertThat(textoExtraido.toLowerCase(), containsString(textoIgualado.toLowerCase()));
	}

	/**
	 * 
	 * @param texto
	 * @return
	 */
	public boolean validarTextoConNumerosYCaracteresEspeciales(String texto) {
		// Define el conjunto de caracteres especiales permitidos
		String caracteresEspecialesPermitidos = "!@#$%^&*()-_+=<>?";

		// Itera sobre cada carácter en el texto
		for (char c : texto.toCharArray()) {
			// Verifica si el carácter no es una letra, número, espacio o está en el conjunto de caracteres permitidos
			if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)
					&& caracteresEspecialesPermitidos.indexOf(c) == -1) {
				// Si encuentra un carácter no permitido, retorna false
				return false;
			}
		}
		// Si todos los caracteres son válidos, retorna true
		return true;
	}

	/**
	 * 
	 * @return
	 */
	public String getTituloResultadoBusqueda() {
		return "//XCUIElementTypeOther[contains(translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), translate('"
				+ BaseUtil.tituloBusqueda + "', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'))]";
	}

	/**
	 * 
	 * @param sourceLocatorType
	 * @param sourceLocator
	 * @param destinationLocatorType
	 * @param destinationLocator
	 */
	public void dragAndDrop(String sourceLocatorType, String sourceLocator, String destinationLocatorType,
			String destinationLocator) {
		BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		By sourceBy = getByType(sourceLocatorType, sourceLocator);
		By destinationBy = getByType(destinationLocatorType, destinationLocator);

		MobileElement sourceElement = BaseUtil.driver.findElement(sourceBy);
		MobileElement destinationElement = BaseUtil.driver.findElement(destinationBy);
		TouchAction touchAction = new TouchAction(BaseUtil.driver);

		// Utilizando LongPressOptions
		LongPressOptions longPressOptions = LongPressOptions.longPressOptions()
				.withElement(ElementOption.element(sourceElement))
				.withDuration(Duration.ofMillis(1000)); 
		
		touchAction.longPress(longPressOptions)
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
				.moveTo(ElementOption.element(destinationElement)).release().perform();
	}

	/**
	 * 
	 * @param locatorType : Tipo de localizador utilizado para identificar el elemento (por ejemplo, "name", "id" o "xpath").
	 * @param locator : Valor del localizador que especifica la ubicación del elemento.
	 * @return
	 */
	private By getByType(String locatorType, String locator) {
		switch (locatorType) {
		case "name":
			return By.name(locator);
		case "id":
			return By.id(locator);
		case "xpath":
			return By.xpath(locator);
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}
	}
	
	/**
	 * 
	 * @param locatorType : Tipo de localizador utilizado para identificar el elemento (por ejemplo, "name", "id" o "xpath").
	 * @param tipoDocumento
	 */
	public void seleccionarTipoDocumentoInputHomeDaviplata(String locatorType, String tipoDocumento) {
        BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String getLocator = "";
        String getLocatorTipoDocumento = "";
        By by = null;
        By byDos = null;

        switch (tipoDocumento) {
        case "TI":
            getLocator = LoginRobustoPage.FIELD_TYPE_ID;
            getLocatorTipoDocumento = LoginRobustoPage.ELEMENT_TI_TYPE_ID;
            break;
        case "CC":
            getLocator = LoginRobustoPage.FIELD_TYPE_ID;
            getLocatorTipoDocumento = LoginRobustoPage.ELEMENT_CC_TYPE_ID;
            break;
        case "CE":
            getLocator = LoginRobustoPage.FIELD_TYPE_ID;
            getLocatorTipoDocumento = LoginRobustoPage.ELEMENT_CE_TYPE_ID;
            break;
        case "PEP":
            getLocator = LoginRobustoPage.FIELD_TYPE_ID;
            getLocatorTipoDocumento = LoginRobustoPage.ELEMENT_CE_TYPE_ID;
            break;
        default:
            throw new IllegalArgumentException("Tipo de documento no válido: " + tipoDocumento);
        }
        switch (locatorType) {
        case "name":
            by = By.name(getLocator);
            byDos = By.name(getLocatorTipoDocumento);
            break;
        case "id":
            by = By.id(getLocator);
            byDos = By.id(getLocatorTipoDocumento);
            break;
        case "xpath":
            by = By.xpath(getLocator);
            byDos = By.xpath(getLocatorTipoDocumento);
            break;
        default:
            throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
        }
        try {
            BaseUtil.driver.findElement(by).click();
            BaseUtil.driver.findElement(byDos).click();
            System.out.println("Se hizo clic en " + tipoDocumento + " del elemento " + getLocator);

        } catch (Exception e) {
            fail("No se pudo interactuar con el elemento: " + getLocator);
        }
    }
	
	public void seleccionarTipoDocumentoNegocio(String locatorType, String tipoDocumento) {
        BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String getLocator = "";
        String textoDocumento = "";
        By by = null;
        switch (tipoDocumento) {
            case "TI":
                getLocator = negocioPageObjects.OPCION_TARJETA_IDENTIDAD;
                textoDocumento = "Tarjeta de Identidad";
                break;
            case "CC":
                getLocator = negocioPageObjects.OPCION_CEDULA;
                textoDocumento = "Cédula de Ciudadanía";
                break;
            case "CE":
                getLocator = negocioPageObjects.OPCION_EXTRANJERIA;
                textoDocumento = "Cédula de Extranjería";
                break;
            case "PEP":
                getLocator = negocioPageObjects.OPCION_EXTRANJERIA;
                textoDocumento = "Cédula de Extranjería";
                break;
            case "PASAPORTE":
                getLocator = negocioPageObjects.OPCION_PASAPORTE;
                textoDocumento = "Pasaporte";
                break;
            case "PERMISO DE PERMANENCIA":
                getLocator = negocioPageObjects.OPCION_PERMANENCIA;
                textoDocumento = "Permiso Especial de permanencia";
                break;
            default:
                throw new IllegalArgumentException("Tipo de documento no válido: " + tipoDocumento);
        }
        switch (locatorType) {
            case "name":
                by = By.name(getLocator);
                break;
            case "id":
                by = By.id(getLocator);
                break;
            case "xpath":
                by = By.xpath(getLocator);
                break;
            default:
                throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
        }
        try {
            BaseUtil.driver.findElement(by).click();
            System.out.println("Se hizo clic en " + tipoDocumento + " del elemento " + getLocator);

        } catch (Exception e) {
            fail("No se pudo interactuar con el elemento: " + getLocator);
        }
    }
	
	/**
	 * 
	 * @param locatorType : Tipo de localizador utilizado para identificar el elemento (por ejemplo, "name", "id" o "xpath").
	 * @param locator : Valor del localizador que especifica la ubicación del elemento.
	 */
	public void ingresarUsuario(String locatorType, String locator) {
		String dato = "1994";
		BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		By by = null;

		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}

		try {
			BaseUtil.driver.findElement(by).sendKeys(dato);
			System.out.println("Se ingresa el usuario: " + dato + " en el elemento: " + locator);
		} catch (Exception e) {
			fail("No se pudo interactuar con el elemento: " + locator);
		}
	}
	
	/**
	 * 
	 * @param locatorType : Tipo de localizador utilizado para identificar el elemento (por ejemplo, "name", "id" o "xpath").
	 * @param locator : Valor del localizador que especifica la ubicación del elemento.
	 */
	public void seleccionarTipoDireccion(String locatorType, String locator) {
		BaseUtil.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		By by = null;
		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}
		try {
			BaseUtil.driver.findElement(by).click();
			System.out.println("Se realizó clic en: " + locator);
		} catch (Exception e) {
			fail("No pudo interactuar con el elemento: " + locator);
		}
	}
	
	/**
	 * 
	 * @param xCoord
	 * @param yCoord
	 */
	public void clickCoordinates(int xCoord, int yCoord) {
        TouchAction touchAction = new TouchAction(BaseUtil.driver);
        touchAction.tap(PointOption.point(xCoord, yCoord)).perform();
    }
	
	/**
	 * 
	 * @param locatorType : Tipo de localizador utilizado para identificar el elemento (por ejemplo, "name", "id" o "xpath").
	 * @param locator : Valor del localizador que especifica la ubicación del elemento.
	 * @param periodo
	 */
	public void scrollToElementTypePeriod(String locatorType, String locator, String periodo) {
		BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		By by = null;
		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}
        MobileElement element = (MobileElement) BaseUtil.driver.findElement(by);
        int yOffset = 0; // Ajusta el valor según sea necesario

        switch (periodo.toLowerCase()) {
        case "Cada Semana":
            yOffset = 0;
            break;
        case "Cada quince días":
            yOffset = -50;
            break;
        case "Cada mes":
            yOffset = -100;
            break;
        default:
            throw new IllegalArgumentException("Tipo de periodo no válido: " + periodo);
        }
        Point location = element.getCenter();
        int startX = location.getX();
        int startY = location.getY();

        new TouchAction(BaseUtil.driver).press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(startX, startY + yOffset)).release().perform();

        System.out.println("Moví elemento");
    }
	
	/**
	 * 
	 * @param locator : Valor del localizador que especifica la ubicación del elemento.
	 * @param anio
	 */
	public void scrollToElementYear(String locator, String anio) {
		MobileElement element = (MobileElement) findElement("xpath", locator);

		int baseYear = 2024; // AÑO MÁXIMO, AJUSTA SEGÚN SEA NECESARIO
		int minYear = 1904; // AÑO MÍNIMO, AJUSTA SEGÚN SEA NECESARIO

		int year = Integer.parseInt(anio);

		if (year < minYear || year > baseYear) {
			throw new IllegalArgumentException("Año no válido: " + anio);
		}
	}
	
	/**
	 * 
	 * @param locatorType : Tipo de localizador utilizado para identificar el elemento (por ejemplo, "name", "id" o "xpath").
	 * @param locator : Valor del localizador que especifica la ubicación del elemento.
	 * @param texto
	 */
	public void  writeElementWeb(String locatorType, String locator, String texto) {
        BaseUtil.chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        By by = null;
        switch (locatorType) {
        case "name":
            by = By.name(locator);
            break;
        case "id":
            by = By.id(locator);
            break;
        case "xpath":
            by = By.xpath(locator);
            break;
        default:
            throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
        }
        try {
            BaseUtil.chromeDriver.findElement(by).sendKeys(texto);
            System.out.println("Se ingreso texto en: " + locator);
        } catch (Exception e) {
            fail("No pudo interactuar con el elemento: " + locator);
        }
    }
	
	/**
	 * 
	 * @param locatorType : Tipo de localizador utilizado para identificar el elemento (por ejemplo, "name", "id" o "xpath").
	 * @param locator : Valor del localizador que especifica la ubicación del elemento.
	 * @return
	 */
	public MobileElement findElement(String locatorType, String locator) {
		By by = null;
		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}
		MobileElement element = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return element;
	}
	
	/**
     * Método que espera hasta que un elemento se desaparezca de la pantalla
     * Tiempo que pregunta repetitivo: Cada 2 Seg
     * Tiempo máximo de espera: 1 minuto
     * 
     * @author Jonathan Vargas Ríos
     * 
	 * @param locator : Valor del localizador que especifica la ubicación del elemento.
     * @param maxWait en segundos
     */
    public void esperaCargaElemento(String locator, int maxWait) {
        boolean isElementProgressBarVisible = true;
        boolean elementVisible = true;
        int timeCont = 1;
        
        while(elementVisible) {
            System.out.println("Cargando... " + locator);
            isElementProgressBarVisible = validateElementVisibilityCatch("xpath", locator);
            Utilidades.esperaMiliseg(1000);
            timeCont++;
            
            if(!isElementProgressBarVisible) {
                elementVisible = false;
                Utilidades.esperaMiliseg(5000);
                System.out.println("Terminó espera de elemento.");
                
            } else if(timeCont == maxWait) {
    			fail("Tiempo de espera superado.");
            }
        }
    }
    
    /**
     * 
     * 
     * @param texto
     * @param formato
     * @return : Resultado boolean
     */
    public boolean validarFormatoFecha(String texto, String formato) {
        // Creamos un objeto SimpleDateFormat con el formato especificado
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        // Desactivamos el modo lenient para evitar fechas no válidas
        sdf.setLenient(false);
        
        try {
            // Intentamos parsear el texto según el formato especificado
            sdf.parse(texto);
            // Si no ocurre una excepción, significa que el formato es válido
            return true;
        } catch (ParseException e) {
            // Si ocurre una ParseException, significa que el texto no cumple con el formato de fecha
            return false;
        }
    }
    
    /**
     * Método que hace scroll en Y and X
     * 
     * @author Jonathan Vargas Ríos
     * @mejora David Sebastian Caballero Hernandez
     * 
	 * @param locatorType : Tipo de localizador utilizado para identificar el elemento (por ejemplo, "name", "id" o "xpath").
	 * @param locator : Valor del localizador que especifica la ubicación del elemento.
     * @param xOffset Cantidad entera de scroll en X
     * @param yOffset Cantidad entera de scroll en Y
     */
    public void scrollBackground(String locatorType, String locator, int xOffset, int yOffset) {
         BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
         boolean check = false;
         By by = null;

         switch (locatorType) {
             case "name":
                 by = By.name(locator);
                 break;
             case "id":
                 by = By.id(locator);
                 break;
             case "xpath":
                 by = By.xpath(locator);
                 break;
             default:
                 throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
         }
         
        MobileElement element = BaseUtil.driver.findElement(by);
        Point location = element.getCenter();
        int startX = location.getX();
        int startY = location.getY();

        new TouchAction(BaseUtil.driver).press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                .moveTo(PointOption.point(startX + xOffset, startY + yOffset)).release().perform();

        System.out.println("Moví elemento");
    }
    
    public void scrollHastaElemento(String elemento) {
        MobileElement element = (MobileElement) BaseUtil.driver
                .findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
                        + ".scrollIntoView(new UiSelector().text(\"" + elemento + "\"))"));
    }
    
    
    /**
     * Método que permite seleccionar un elemento de cualquier lista
     * 
     * @author David Sebastian Caballero Hernandez
     * @mejora Jonathan Alejandro Vargas Ríos
     * 
	 * @param locatorType : Tipo de localizador utilizado para identificar el elemento (por ejemplo, "name", "id" o "xpath").
	 * @param locatorInitial  : Valor del localizador que especifica la ubicación del elemento inicio del desplazamiento.
     * @param locatorSearch : Valor del localizador que especifica la ubicación del elemento a encontrar.
     * @param maxScrolls Máximo de scrolls para determinar el final de la lista
     */
    public void scrollToElements(String locatorType, String locatorInitial, String locatorSearch, int maxScrolls, int XoffSet, int YoffSet) {
        boolean elementFound = false;
        int scrollCount = 0;
        int maxScrollCount = maxScrolls; // Establece un límite máximo de desplazamientos
        
        while (!elementFound && scrollCount < maxScrollCount) {
            //Si se encuentra el localizador de locatorSearch, entra
            boolean isElementVisible = validateElementVisibilityException(locatorType, locatorSearch);
            if (isElementVisible) {
                elementFound = true;
                System.out.println("Elemento encontrado: " + locatorSearch);
                clicElement(locatorType, locatorSearch); //Lo selecciona
                break; //Rompe el ciclo para que no dé más scroll
            }
            
            //Scroll
            scrollBackground("xpath", locatorInitial, XoffSet, YoffSet);
            scrollCount++;
        }
        
        // Si no se encontró el elemento después de los desplazamientos, hacer fail() de JUnit
        if (!elementFound) {
            System.out.println("No se encontró el elemento después de " + maxScrollCount + " desplazamientos.");
            fail("El elemento " + locatorSearch + " no se encontró después de realizar el scroll.");
        }
    }
    
    /**
     * Método para validar un elemento visible que retorna un boolean
	 * @param locatorType : Tipo de localizador utilizado para identificar el elemento (por ejemplo, "name", "id" o "xpath").
	 * @param locator : Valor del localizador que especifica la ubicación del elemento.
     * @return check = true or false de a cuerdo si el elemento es visible o no
     */
    public static boolean validateElementVisibilityException(String locatorType, String locator) {
        BaseUtil.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        boolean check = false;
        By by = null;

        switch (locatorType) {
        case "name":
            by = By.name(locator);
            break;
        case "id":
            by = By.id(locator);
            break;
        case "xpath":
            by = By.xpath(locator);
            break;
        default:
            throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
        }

        try {
            check = BaseUtil.driver.findElement(by).isDisplayed();
            System.out.println("Se verifica presencia del elemento: " + locator);
        } catch (Exception e) {
            System.out.println("No se pudo interactuar con el elemento: " + locator);
        }
        return check;
    }
    
    /**
     * Metodo para el manejo de assertions
     * 
     * @param nombreElemento
     * @param tipoLocalizador
     * @param localizador
     * 
     * @author Laura Pérez
     */
    public void assertElementoVisible(String nombreElemento, String tipoLocalizador, String localizador) {
        if (validateElementVisibilityCatch(tipoLocalizador, localizador) == false) {
            String errorMessage = "El elemento [" + nombreElemento + "] no es visible: " + localizador;
            System.out.println(errorMessage);
            throw new RuntimeException(errorMessage);
        }
    }
    
    /**
     * Método para abir web google
     * nombreVariablePagina - nombre variable que esta en el archivo properties
     * @author Laura Pérez
     */
    public void abrirWeb(String nombreVariablePagina) {
        CustomChromeDriver.iniciarChromeDriver();
        BaseUtil.chromeDriver.get(Credenciales.propertiesWebs().getProperty(nombreVariablePagina.trim()));
        BaseUtil.chromeDriver.manage().window().maximize();
        System.out.println("paso");
        wait = new WebDriverWait(BaseUtil.chromeDriver, 60);
    }
    
    public void cerrarWebEnlaceDePago() {
        try {
            CustomChromeDriver.cerrarChromeDriver();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("No cerro ChromeDriver");
        }
    }
    
    /**
     * Método para setear valor (dirección web) a una variable credenciales_web.properties(web.google.url)
     * 
     * @param url
     * 
     * @author Laura Pérez
     */
    public void setearUrlAProperties (String url) {
        String filePath = System.getProperty("user.dir") + "\\credenciales_web.properties";
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(filePath)) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Setear el valor de la URL capturada a la propiedad web.google.url
        properties.setProperty("web.google.url", url);
        
        // Guardar los cambios en el archivo .properties
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            properties.store(fos, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     */
    public void ocultarTeclado() {
        try {
            // Verificar que el driver sea una instancia de IOSDriver
            if (BaseUtil.driveriOS instanceof IOSDriver) {
                ((IOSDriver<?>) BaseUtil.driveriOS).hideKeyboard();
            } else {
                System.out.println("Este método solo es compatible con iOS");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
    
    /**
     * Calcula las dimensiones del celular para realizar scroll hacia arriba, abajo,
     * derecha o izquierda.
     * 
     * @param direccion - Direccion a la que quiere desplazarse
     * 
     * @author Juan Pablo Doncel
     */
    public void scrollMultiDireccional(String direccion) {
        Dimension size = BaseUtil.driver.manage().window().getSize();
        int startX, startY, endX, endY;

        switch (direccion.toLowerCase()) {
        case "izquierda":
            startX = (int) (size.width * 0.9); // Inicio desde el 90% del ancho hacia la izquierda
            startY = size.height / 2; // Altura central de la pantalla
            endX = (int) (size.width * 0.1); // Fin en el 10% del ancho hacia la izquierda
            endY = startY; // Mismo nivel vertical
            break;
        case "derecha":
            startX = (int) (size.width * 0.1); // Inicio desde el 10% del ancho hacia la izquierda
            startY = size.height / 2; // Altura central de la pantalla
            endX = (int) (size.width * 0.9); // Fin en el 90% del ancho hacia la derecha
            endY = startY; // Mismo nivel vertical
            break;
        case "arriba":
            startX = size.width / 2; // Centro horizontal de la pantalla
            startY = (int) (size.height * 0.9); // Inicio desde el 90% de la altura hacia arriba
            endX = startX; // Mismo nivel horizontal
            endY = (int) (size.height * 0.1); // Fin en el 10% de la altura hacia arriba
            break;
        case "abajo":
            startX = size.width / 2; // Centro horizontal de la pantalla
            startY = (int) (size.height * 0.1); // Inicio desde el 10% de la altura hacia arriba
            endX = startX; // Mismo nivel horizontal
            endY = (int) (size.height * 0.9); // Fin en el 90% de la altura hacia arriba
            break;
        default:
            throw new IllegalArgumentException("Dirección no válida: " + direccion);
        }

        new TouchAction<>(BaseUtil.driver).press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(endX, endY))
                .release().perform();
    }
    
    /**
     * Realiza un gesto de Zoom-In (pellizco hacia adentro) en la pantalla del dispositivo móvil.
     * 
     * @param time : Tiempo de duración del Zoom-In ó duración de la interación con la pantalla.
     * @author Jonathan Vargas
     */
    public void zoomIn(int time) {
        try {
            // Espera implícita
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // Obtener las dimensiones de la pantalla
            int screenWidth = driver.manage().window().getSize().getWidth();
            int screenHeight = driver.manage().window().getSize().getHeight();

            // Coordenadas para el zoom-out desde los costados hacia el centro
            int startX1 = 100;
            int startY1 = screenHeight / 2;
            int endX1 = screenWidth / 2 - 100;
            int endY1 = screenHeight / 2;

            int startX2 = screenWidth - 100;
            int startY2 = screenHeight / 2;
            int endX2 = screenWidth / 2 + 100;
            int endY2 = screenHeight / 2;

            // Crear acciones de toque
            TouchAction<?> action1 = new TouchAction<>(driver)
                    .press(PointOption.point(startX1, startY1))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(time))) // Espera de 'x' segundos
                    .moveTo(PointOption.point(endX1, endY1))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(time))) // Espera de 'x' segundos
                    .release();

            TouchAction<?> action2 = new TouchAction<>(driver)
                    .press(PointOption.point(startX2, startY2))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(time))) // Espera de 'x' segundos
                    .moveTo(PointOption.point(endX2, endY2))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(time))) // Espera de 'x' segundos
                    .release();

            // Ejecutar las acciones simultáneamente
            new MultiTouchAction(driver)
                    .add(action1)
                    .add(action2)
                    .perform();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    /**
     * 
     * @param locatorType
     * @param locator
     * @return
     */
    public boolean validateElementInvisibilityWebCatch(String locatorType, String locator) {
        BaseUtil.chromeDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        boolean check = false;
        By by = null;

        switch (locatorType) {
        case "name":
            by = By.name(locator);
            break;
        case "id":
            by = By.id(locator);
            break;
        case "xpath":
            by = By.xpath(locator);
            break;
        default:
            throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
        }

        try {
            // Si findElement lanza una excepción, significa que el elemento no está
            // presente
            BaseUtil.chromeDriver.findElement(by);
            // Si no se lanza ninguna excepción, el elemento está presente
            check = false;
            System.out.println("El elemento esta presente: " + locator);
        } catch (NoSuchElementException e) {
            // El elemento no fue encontrado, lo que indica que está ausente
            check = true;
            System.out.println("El elemento " + locator + " no esta presente");
        }

        return check;
    }
    
    /**
     * Extrae la cantidad de elementos obtenidos desde un localizador padre
     * @param locatorType - Tipo de localizador
     * @param locator - Localizador
     * @return Retorna la cantidad de elementos encontrados
     */
    public int extractQuantityOfElements(String locatorType, String locator) {
        BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        By by = null;
        
        switch (locatorType) {
            case "name":
                by = By.name(locator);
                break;
            case "id":
                by = By.id(locator);
                break;
            case "xpath":
                by = By.xpath(locator);
                break;
            default:
                throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
        }

        ArrayList<MobileElement> listaElementos = (ArrayList<MobileElement>) BaseUtil.driver.findElements(by);
        
        int cantidadElementos = listaElementos.size();
        System.out.println("Cantidad de elementos encontrados: " + cantidadElementos);

        return cantidadElementos;
    }
    
    /**
     * Compara una cantidad con una referencia según el operador proporcionado.
     * @param operador - El operador de comparación ("mayor", "menor" o "igual").
     * @param cantidad - La cantidad que se desea comparar.
     * @param referencia - El valor de referencia para la comparación.
     * @return true si la comparación es verdadera según el operador especificado, false de lo contrario.
     */
    public boolean comparadorCantidades(String operador, int cantidad, int referencia) {
        switch (operador) {
            case "mayor":
                return cantidad > referencia;
            case "menor":
                return cantidad < referencia;
            case "igual":
                return cantidad == referencia;
            case "mayor o igual":
                return cantidad >= referencia;
            default:
                System.out.println("Operador no válido");
                return false;
        }
    }
    
    /**
     * Se loguea en la pagina que se declare
     */
    public void loginWebPagina(String locatorType, String locator, String pagina) {
        try {
            abrirWeb(pagina);
            for(int i=0; i<5; i++) {
                boolean estadoVisible = validateElementInvisibilityWebCatch(locatorType, locator);
                if(estadoVisible == true) {
                    cerrarWebEnlaceDePago();
                    abrirWeb(pagina);
                } else {
                    break;
                }
            }
            System.out.println("Ya me encuentro en el enlace de pago");
        } catch (Exception e) {
            e.printStackTrace();
            cerrarWebEnlaceDePago();
            abrirWeb(pagina);
        }
    }
    
    public void esperarElementVisibilityWeb(String locatorType, String locator) {
        By by = null;
        switch (locatorType) {
            case "name":
                by = By.name(locator);
                break;
            case "id":
                by = By.id(locator);
                break;
            case "xpath":
                by = By.xpath(locator);
                break;
            default:
                throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
        }
        try {
        	contador++;
            WebElement element = wait
					.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Exception e) {
            if (!(contador == 15)) {
                Utilidades.esperaMiliseg(500);
                esperarElementVisibilityWeb(locatorType, locator);
            } else {
                fail("No se encontró elemento: " + locator + ", debido a: " + e.getMessage());
            }
        } finally {
            contador = 0;
        }
    }
    
    public static  void clicElementWeb(String locatorType, String locator) {
        BaseUtil.chromeDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        By by = null;
        switch (locatorType) {
        case "name":
            by = By.name(locator);
            break;
        case "id":
            by = By.id(locator);
            break;
        case "xpath":
            by = By.xpath(locator);
            break;
        default:
            throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
        }
        try {
            BaseUtil.chromeDriver.findElement(by).click();
            System.out.println("Se realizó clic en: " + locator);
        } catch (Exception e) {
            fail("No pudo interactuar con el elemento: " + locator);
        }
    }
    
    /**
     * Cambia de foco al iframe especificado
     */
    public void cambiarFocoIframe(String locatorType, String locator) {
         By by = null;
        switch (locatorType) {
            case "name":
                by = By.name(locator);
                break;
            case "id":
                by = By.id(locator);
                break;
            case "xpath":
                by = By.xpath(locator);
                break;
            default:
                throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
        }
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
        System.out.println("Cambió al iframe: " + locator);
    }

    /**
     * Selecciona un valor en una lista desplegable identificada por el tipo de localizador y el locator especificado,
     * utilizando la abreviación del tipo de documento.
     *
     * @param locatorType   El tipo de localizador del elemento (por ejemplo, "name", "id", "xpath").
     * @param locator       El valor del localizador del elemento.
     * @param abbreviation  La abreviación del tipo de documento para seleccionar el valor correspondiente en la lista desplegable.
     * @throws IllegalArgumentException Si la abreviación del tipo de documento no es válida.
     * @author Juan Doncel
     */
    public void selectDropdownValue(String locatorType, String locator, String abbreviation) {
        BaseUtil.chromeDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Inicializar el mapa de tipos de documento
        Map<String, String> documentTypeMap = new HashMap<>();
        documentTypeMap.put("CC", "Cedula de Ciudadania");
        documentTypeMap.put("TI", "Tarjeta de Identidad");
        documentTypeMap.put("CE", "Cedula de Extranjeria");

        // Verificar si la abreviación es válida
        String valueToSelect = documentTypeMap.get(abbreviation);
        if (valueToSelect == null) {
            throw new IllegalArgumentException("Sigla no válida: " + abbreviation);
        }

        By by = null;
        switch (locatorType) {
            case "name":
                by = By.name(locator);
                break;
            case "id":
                by = By.id(locator);
                break;
            case "xpath":
                by = By.xpath(locator);
                break;
            default:
                throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
        }

        try {
            WebElement dropdown = BaseUtil.chromeDriver.findElement(by);
            Select select = new Select(dropdown);

            // Imprimir las opciones disponibles para verificación
            // select.getOptions().forEach(option -> System.out.println("Opción disponible: " + option.getText()));

            // Seleccionar el valor de la lista desplegable
            select.selectByVisibleText(valueToSelect);
            System.out.println("Se seleccionó el valor: " + valueToSelect + " para la sigla: " + abbreviation);
        } catch (Exception e) {
            System.err.println("No se pudo interactuar con el elemento: " + locator);
            e.printStackTrace();
        }
    }
    
    public void abrirWebEnPestaniaNueva(String nombreVariablePagina) {
        // Obtener la URL de las propiedades
        String url = Credenciales.propertiesWebs().getProperty(nombreVariablePagina.trim());

        // Abrir una nueva pestaña utilizando JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) BaseUtil.chromeDriver;
        js.executeScript("window.open()");

        // Cambiar a la nueva pestaña
        ArrayList<String> tabs = new ArrayList<>(BaseUtil.chromeDriver.getWindowHandles());
        BaseUtil.chromeDriver.switchTo().window(tabs.get(tabs.size() - 1));

        // Navegar a la URL deseada en la nueva pestaña
        BaseUtil.chromeDriver.get(url);
        
        System.out.println("paso");

        // Configurar WebDriverWait para la nueva pestaña
        wait = new WebDriverWait(BaseUtil.chromeDriver, 60);
    }
    
    public void cleanInputElementWeb(String locatorType, String locator) {
        BaseUtil.chromeDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        By by = null;
        switch (locatorType) {
        case "name":
            by = By.name(locator);
            break;
        case "id":
            by = By.id(locator);
            break;
        case "xpath":
            by = By.xpath(locator);
            break;
        default:
            throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
        }
        try {
            BaseUtil.chromeDriver.findElement(by).clear();
            System.out.println("Se limpió campo del elemento: " + locator);
        } catch (Exception e) {
            fail("No se pudo interactuar con el elemento: " + locator);
        }
    }
    
    public String capturarOtpIngresoDaviviendaNotificaciones() {
        BaseUtil.chromeDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String auxiliar = "";
        String mensajeOTP = "";
        String FilasTablaNotificaciones = "//table[2]//tr";
        String otp = "";
        try {
            int cantidadFilas = BaseUtil.chromeDriver.findElements( By.xpath(FilasTablaNotificaciones)).size();
            
            for(int fila=2; fila < cantidadFilas; fila++) {
                Utilidades.esperar(250);
                auxiliar = BaseUtil.chromeDriver.findElement(By.xpath(FilasTablaNotificaciones + "[" + fila + "]" + "/td[3]")).getText();
                if(auxiliar.contains("Davivienda") || auxiliar.contains("Codigo") ) {
                    mensajeOTP = BaseUtil.chromeDriver.findElement(By.xpath(FilasTablaNotificaciones + "[" + fila + "]" + "/td[3]")).getText();
                    break;
                }
            }
            
            Pattern pattern = Pattern.compile("\\d+"); // Expresion regular para buscar digitos numericos
            java.util.regex.Matcher matcher = pattern.matcher(mensajeOTP);

            if (matcher.find()) {
                otp = matcher.group(); // obtiene la primera coincidencia de digitos numericos encontrados
                System.out.println("La otp es: " + otp);
                Utilidades.tomaEvidenciaPantalla("Web - obtener clave virtual");
            }
            
        } catch(Exception e) {
            fail("No se encontró Otp CVV de la ecard, debido a: " + e.getMessage());
        }
        return otp;
    }
    
    public boolean validateElementVisibilityWeb(String locatorType, String locator) {
        BaseUtil.chromeDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        boolean check = false;
        By by = null;
        switch (locatorType) {
            case "name":
                by = By.name(locator);
                break;
            case "id":
                by = By.id(locator);
                break;
            case "xpath":
                by = By.xpath(locator);
                break;
            default:
                throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
        }
        try {
            check = BaseUtil.chromeDriver.findElement(by).isDisplayed();
            System.out.println("Se verifica presencia de el elemento: " + locator);
        } catch (Exception e) {
            fail("No se pudo interactuar con el elemento: " + locator);
        }
        return check;
    }
    
    /**
     * Cambiar al iframe contenido principal.
     */
    public void switchToIframeDefault() {
        BaseUtil.chromeDriver.switchTo().defaultContent();
    }
    
    public void cerrarChromdriver() {
        try {
            CustomChromeDriver.cerrarChromeDriver();
        } catch (Exception e) {
            System.out.println("No cerró ChromeDriver debido a: " + e.getMessage());
        }
    }
    
    public boolean validateElementVisibilityCatchWeb(String locatorType, String locator) {
        BaseUtil.chromeDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        boolean check = false;
        By by = null;
        switch (locatorType) {
            case "name":
                by = By.name(locator);
                break;
            case "id":
                by = By.id(locator);
                break;
            case "xpath":
                by = By.xpath(locator);
                break;
            default:
                throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
        }
        try {
            check = BaseUtil.chromeDriver.findElement(by).isDisplayed();
            System.out.println("Se verifica presencia de el elemento: " + locator);
        } catch (Exception e) {
            System.out.println("No se pudo interactuar con el elemento: " + locator);
        }
        return check;
    }
    
    /**
     * Cambia el foco de la ventana del navegador a la pestaña especificada.
     *
     * @param direccion Una cadena que indica la dirección del cambio de pestaña.
     *                  Puede ser "siguiente" para la siguiente pestaña,
     *                  "anterior" para la pestaña anterior, o "origen" para volver
     *                  a la pestaña de origen.
     * @throws IllegalArgumentException Si el parámetro 'direccion' no es válido.
     */
    public void cambiarFocoVentana(String direccion) {
        // Obtener todas las pestañas abiertas
        ArrayList<String> tabs = new ArrayList<>(BaseUtil.chromeDriver.getWindowHandles());
        
        // Obtener la pestaña actual
        String currentTab = BaseUtil.chromeDriver.getWindowHandle();
        int currentIndex = tabs.indexOf(currentTab);
        
        switch(direccion.toLowerCase()) {
            case "siguiente":
                // Cambiar a la siguiente pestaña
                int nextIndex = (currentIndex + 1) % tabs.size();
                BaseUtil.chromeDriver.switchTo().window(tabs.get(nextIndex));
                break;
            case "anterior":
                // Cambiar a la pestaña anterior
                int prevIndex = (currentIndex - 1 + tabs.size()) % tabs.size();
                BaseUtil.chromeDriver.switchTo().window(tabs.get(prevIndex));
                break;
            case "origen":
                // Cambiar a la pestaña de origen
                BaseUtil.chromeDriver.switchTo().window(tabs.get(0));
                break;
            default:
                throw new IllegalArgumentException("Parámetro 'direccion' no válido. Use 'siguiente', 'anterior' o 'origen'.");
        }
    }

    /**
     * Captura el mensaje de notificación de recarga de una tabla web y extrae el valor del monto recargado.
     * 
     * Este método busca en una tabla web específica el mensaje de notificación que contiene la información 
     * de una recarga realizada desde una cuenta Davivienda. Luego, extrae el valor del monto recargado y 
     * lo devuelve como una cadena sin comas ni símbolo de dólar.
     * 
     * @return El valor del monto recargado como una cadena sin comas ni símbolo de dólar.
     *         Si no se encuentra ningún valor de recarga, se devuelve una cadena vacía.
     * @throws IllegalStateException Si no se encuentra el valor de recarga en las notificaciones.
     */
    public String capturarMensajeLatiniaNotificaciones() {
        BaseUtil.chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String auxiliar = "";
        String mensajeValorRecarga = "";
        String FilasTablaMensajes = "//table[@class='mat-table cdk-table mat-sort card-table']//tr";
        String valorRecarga = "";
        try {
            int cantidadFilas = BaseUtil.chromeDriver.findElements(By.xpath(FilasTablaMensajes)).size();
            
            for(int fila = 1; fila < cantidadFilas; fila++) {
                Utilidades.esperar(250);
                auxiliar = BaseUtil.chromeDriver.findElement(By.xpath(FilasTablaMensajes + "[" + fila + "]" + "/td[4]")).getText();
                if(auxiliar.contains("Davivienda") || auxiliar.contains("cargado")) {
                    mensajeValorRecarga = BaseUtil.chromeDriver.findElement(By.xpath(FilasTablaMensajes + "[" + fila + "]" + "/td[4]")).getText();
                    break;
                }
            }
            
            // Expresión regular para encontrar el monto incluyendo el símbolo de dólar y separadores de miles
            Pattern pattern = Pattern.compile("\\$([\\d,]+)"); 
            java.util.regex.Matcher matcher = pattern.matcher(mensajeValorRecarga);

            if (matcher.find()) {
                valorRecarga = matcher.group(1).replace(",", ""); // obtiene la primera coincidencia y elimina comas
                System.out.println("El valor de la recarga es: " + valorRecarga);
                Utilidades.tomaEvidenciaPantalla("Web - Obtener valor de la recarga " + valorRecarga);
            }
        } catch(Exception e) {
            cerrarChromdriver();
            fail("No se encontró valor de la recarga en latinia realizada desde Davivienda, debido a: " + e.getMessage());
        }
        return valorRecarga;
    }


    /**
     * Captura el mensaje de notificación de pasar plata cuenta de una tabla web y extrae el valor del monto que se transfirio.
     * 
     * Este método busca en una tabla web específica el mensaje de notificación que contiene la información 
     * de un pasar plata cuenta realizada desde daviplata. Luego, extrae el valor del monto transferido y 
     * lo devuelve como una cadena sin comas ni símbolo de dólar.
     * 
     * @return El valor del monto transferido como una cadena sin comas ni símbolo de dólar.
     *         Si no se encuentra ningún valor transferido, se devuelve una cadena vacía.
     * @throws IllegalStateException Si no se encuentra el valor de la transferencia en las notificaciones.
     */
    public String capturarMensajeLatiniaNotificacionesPasarPlataCuenta() {
        BaseUtil.chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String auxiliar = "";
        String mensajeValorTransferencia = "";
        String FilasTablaMensajes = "//table[@class='mat-table cdk-table mat-sort card-table']//tr";
        String valorTransferencia = "";
        try {
            int cantidadFilas = BaseUtil.chromeDriver.findElements(By.xpath(FilasTablaMensajes)).size();
            
            for(int fila = 1; fila < cantidadFilas; fila++) {
                Utilidades.esperar(250);
                auxiliar = BaseUtil.chromeDriver.findElement(By.xpath(FilasTablaMensajes + "[" + fila + "]" + "/td[4]")).getText();
                if(auxiliar.contains("Paso Plata") || auxiliar.contains("Davivienda")) {
                    mensajeValorTransferencia = BaseUtil.chromeDriver.findElement(By.xpath(FilasTablaMensajes + "[" + fila + "]" + "/td[4]")).getText();
                    break;
                }
            }
            
            // Expresión regular para encontrar el monto incluyendo el símbolo de dólar y separadores de miles
            Pattern pattern = Pattern.compile("\\$([\\d,]+)"); 
            java.util.regex.Matcher matcher = pattern.matcher(mensajeValorTransferencia);

            if (matcher.find()) {
                valorTransferencia = matcher.group(1).replace(",", ""); // obtiene la primera coincidencia y elimina comas
                System.out.println("El valor de la recarga es: " + valorTransferencia);
                Utilidades.tomaEvidenciaPantalla("Web - Obtener valor de la recarga " + valorTransferencia);
            }
        } catch(Exception e) {
            cerrarChromdriver();
            fail("No se encontró valor de la transferencia en latinia realizada desde Daviplata, debido a: " + e.getMessage());
        }
        return valorTransferencia;
    }

    /**
     * Captura el mensaje de notificación de pasar plata en linea de una tabla web y extrae el valor del monto que se transfirio.
     * 
     * Este método busca en una tabla web específica el mensaje de notificación que contiene la información 
     * de un pasar plata en linea realizada desde daviplata. Luego, extrae el valor del monto transferido y 
     * lo devuelve como una cadena sin comas ni símbolo de dólar.
     * 
     * @return El valor del monto transferido como una cadena sin comas ni símbolo de dólar.
     *         Si no se encuentra ningún valor transferido, se devuelve una cadena vacía.
     * @throws IllegalStateException Si no se encuentra el valor de la transferencia en las notificaciones.
     */
    public String capturarMensajeLatiniaNotificacionesPasarPlataEnLinea() {
        BaseUtil.chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String auxiliar = "";
        String mensajeValorTransferenciaEnLinea = "";
        String FilasTablaMensajes = "//table[@class='mat-table cdk-table mat-sort card-table']//tr";
        String valorTransferenciaEnLinea = "";
        try {
            int cantidadFilas = BaseUtil.chromeDriver.findElements(By.xpath(FilasTablaMensajes)).size();
            
            for(int fila = 1; fila < cantidadFilas; fila++) {
                Utilidades.esperar(250);
                auxiliar = BaseUtil.chromeDriver.findElement(By.xpath(FilasTablaMensajes + "[" + fila + "]" + "/td[4]")).getText();
                if(auxiliar.contains("Paso Plata") || auxiliar.contains("Transfiya")) {
                    mensajeValorTransferenciaEnLinea = BaseUtil.chromeDriver.findElement(By.xpath(FilasTablaMensajes + "[" + fila + "]" + "/td[4]")).getText();
                    break;
                }
            }
            
            // Expresión regular para encontrar el monto incluyendo el símbolo de dólar y separadores de miles
            Pattern pattern = Pattern.compile("\\$([\\d,]+)"); 
            java.util.regex.Matcher matcher = pattern.matcher(mensajeValorTransferenciaEnLinea);

            if (matcher.find()) {
                valorTransferenciaEnLinea = matcher.group(1).replace(",", ""); // obtiene la primera coincidencia y elimina comas
                System.out.println("El valor de la recarga es: " + valorTransferenciaEnLinea);
                Utilidades.tomaEvidenciaPantalla("Web - Obtener valor de la recarga " + valorTransferenciaEnLinea);
            }
        } catch(Exception e) {
            cerrarChromdriver();
            fail("No se encontró valor de la transferencia en latinia realizada desde Daviplata, debido a: " + e.getMessage());
        }
        return valorTransferenciaEnLinea;
    }

    /**
     * Captura el mensaje de notificación de compra en tienda virtual de una tabla web y extrae el valor del monto de la compra.
     * 
     * Este método busca en una tabla web específica el mensaje de notificación que contiene la información 
     * de una compra en tienda virtual realizada desde daviplata. Luego, extrae el valor del monto en la compra y 
     * lo devuelve como una cadena sin comas ni símbolo de dólar.
     * 
     * @return El valor del monto de la compra como una cadena sin comas ni símbolo de dólar.
     *         Si no se encuentra ningún valor de la compra, se devuelve una cadena vacía.
     * @throws IllegalStateException Si no se encuentra el valor de la compra en las notificaciones.
     */
    public String capturarMensajeLatiniaNotificacionesCompraTiendaVirtual() {
        BaseUtil.chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String auxiliar = "";
        String mensajeValorCompraTiendaVirtual = "";
        String FilasTablaMensajes = "//table[@class='mat-table cdk-table mat-sort card-table']//tr";
        String valorCompraTiendaVirtual = "";
        try {
            int cantidadFilas = BaseUtil.chromeDriver.findElements(By.xpath(FilasTablaMensajes)).size();
            
            for(int fila = 1; fila < cantidadFilas; fila++) {
                Utilidades.esperar(250);
                auxiliar = BaseUtil.chromeDriver.findElement(By.xpath(FilasTablaMensajes + "[" + fila + "]" + "/td[4]")).getText();
                if(auxiliar.contains("Compra") || auxiliar.contains("Tienda Virtual")) {
                    mensajeValorCompraTiendaVirtual = BaseUtil.chromeDriver.findElement(By.xpath(FilasTablaMensajes + "[" + fila + "]" + "/td[4]")).getText();
                    break;
                }
            }
            
            // Expresión regular para encontrar el monto incluyendo el símbolo de dólar y separadores de miles
            Pattern pattern = Pattern.compile("\\$([\\d,]+)"); 
            java.util.regex.Matcher matcher = pattern.matcher(mensajeValorCompraTiendaVirtual);

            if (matcher.find()) {
                valorCompraTiendaVirtual = matcher.group(1).replace(",", ""); // obtiene la primera coincidencia y elimina comas
                System.out.println("El valor de la compra en tienda virtual es: " + valorCompraTiendaVirtual);
                Utilidades.tomaEvidenciaPantalla("Web - Obtener valor de la compra en tienda virtual " + valorCompraTiendaVirtual);
            }
        } catch(Exception e) {
            cerrarChromdriver();
            fail("No se encontró valor de la compra, desde tienda virtual en latinia, realizada desde Daviplata, debido a: " + e.getMessage());
        }
        return valorCompraTiendaVirtual;
    }


    /**
     * Captura el mensaje de notificación de compra en pse de una tabla web y extrae el valor del monto de la compra.
     * 
     * Este método busca en una tabla web específica el mensaje de notificación que contiene la información 
     * de una compra en pse realizada desde daviplata. Luego, extrae el valor del monto en la compra y 
     * lo devuelve como una cadena sin comas ni símbolo de dólar.
     * 
     * @return El valor del monto de la compra como una cadena sin comas ni símbolo de dólar.
     *         Si no se encuentra ningún valor de la compra, se devuelve una cadena vacía.
     * @throws IllegalStateException Si no se encuentra el valor de la compra en las notificaciones.
     */
    public String capturarMensajeLatiniaNotificacionesCompraPse() {
        BaseUtil.chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String auxiliar = "";
        String mensajeValorCompraPse = "";
        String FilasTablaMensajes = "//table[@class='mat-table cdk-table mat-sort card-table']//tr";
        String valorCompraPse = "";
        try {
            int cantidadFilas = BaseUtil.chromeDriver.findElements(By.xpath(FilasTablaMensajes)).size();
            
            for(int fila = 1; fila < cantidadFilas; fila++) {
                Utilidades.esperar(250);
                auxiliar = BaseUtil.chromeDriver.findElement(By.xpath(FilasTablaMensajes + "[" + fila + "]" + "/td[4]")).getText();
                if(auxiliar.contains("Compra") || auxiliar.contains("Tienda Virtual")) {
                    mensajeValorCompraPse = BaseUtil.chromeDriver.findElement(By.xpath(FilasTablaMensajes + "[" + fila + "]" + "/td[4]")).getText();
                    break;
                }
            }
            
            // Expresión regular para encontrar el monto incluyendo el símbolo de dólar y separadores de miles
            Pattern pattern = Pattern.compile("\\$([\\d,]+)"); 
            java.util.regex.Matcher matcher = pattern.matcher(mensajeValorCompraPse);

            if (matcher.find()) {
                valorCompraPse = matcher.group(1).replace(",", ""); // obtiene la primera coincidencia y elimina comas
                System.out.println("El valor de la compra en tienda virtual es: " + valorCompraPse);
                Utilidades.tomaEvidenciaPantalla("Web - Obtener valor de la compra en tienda virtual " + valorCompraPse);
            }
        } catch(Exception e) {
            cerrarChromdriver();
            fail("No se encontró valor de la compra, desde tienda virtual en latinia, realizada desde Daviplata, debido a: " + e.getMessage());
        }
        return valorCompraPse;
    }
}
