# DaviPlata Nacional iOS

Proyecto de automatización DaviPlata realizado por TCS

## Instalación 

Proyecto realizado por medio de maven, se debe clonar el proyecto y por medio XCUITest Driver se debe ejecutar. Mas información [Appium XCUITest](http://appium.io/docs/en/drivers/ios-xcuitest-real-devices/).

Tener en cuenta la instalación de [Appium](http://appium.io/docs/en/about-appium/getting-started/).

## Usage

Para ejecuciones directas se debe entrar a la carpeta de runners, escoger el runner adecuado a la prueba (si no se conoce el origen de la prueba se puede escoger LoginRunner.java).

En el siguiente ejemplo se está corriendo la prueba CP0010M el cual tiene este tag en los feature de cucumber. También tener en cuenta la ruta de los features tanto en la variable features y en DataToFeature. En este ejemplo está tomando de manera global todos los datos.


```java

@RunWith(RunnerPersonalizado.class)
@CucumberOptions(
features = "src/test/resources/features"
,glue = "daviplata.nacional.iOS.definitions"
,tags ="@CP0010M"
,monochrome = true
,snippets = SnippetType.CAMELCASE
)

public class LoginRunner {
	@BeforeSuite
	public static void test() throws InvalidFormatException, IOException {
		DataToFeature.overrideFeatureFiles("./src/test/resources/features");
	}
}

```

