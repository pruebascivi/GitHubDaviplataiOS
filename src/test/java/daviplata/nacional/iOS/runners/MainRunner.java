package daviplata.nacional.iOS.runners;

import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import daviplata.nacional.iOS.utilidades.BeforeSuite;
import daviplata.nacional.iOS.utilidades.DataToFeature;

@RunWith(RunnerPersonalizado.class) 
@CucumberOptions(
        
features = "src/test/resources/features" 
,glue = "daviplata.nacional.iOS.definitions"
,tags = "@CP03200M",
monochrome = true
,snippets = SnippetType.CAMELCASE    
)
public class MainRunner {
    @BeforeSuite
    public static void test() throws InvalidFormatException, IOException {
        DataToFeature.overrideFeatureFiles("./src/test/resources/features");
    }
}