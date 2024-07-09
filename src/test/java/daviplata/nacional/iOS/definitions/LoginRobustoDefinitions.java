package daviplata.nacional.iOS.definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import daviplata.nacional.iOS.utilidades.Cronometro;
import daviplata.nacional.iOS.utilidades.Evidencias;
import daviplata.nacional.iOS.steps.EcardSteps;
import daviplata.nacional.iOS.steps.HomeRobustoSteps;
import daviplata.nacional.iOS.steps.LoginRobustoSteps;
import daviplata.nacional.iOS.steps.MicroSegurosSteps;
import net.thucydides.core.annotations.Steps;

public class LoginRobustoDefinitions {
	
	@Steps
	LoginRobustoSteps loginRobustoSteps;
	@Steps
	HomeRobustoSteps homeRobustoSteps;
	@Steps
	Cronometro cronometro;
	@Steps
	BaseUtil base;
	@Steps
	Evidencias evidencia;
	@Steps
	EcardSteps stepsEcard;
	@Steps
	MicroSegurosSteps microSegurosSteps;

	@Given("^ingreso al aplicativo$")
	public void ingresoAlAplicativo() {
	    loginRobustoSteps.ingresoAlAplicativo();
	}

	@Given("^verifico la version del aplicativo$")
	public void verificoLaVersionDelAplicativo() {
	    loginRobustoSteps.verificarVersion();
	}
	
	@Given("valido la opcion 'Cambiar mi numero'")
	public void validoLaOpcionCambiarMiNumero() {
	    loginRobustoSteps.validarOpcCambiarNum();
	}
	
	@Given("verifico la opcion 'Donde usar su DaviPlata'")
	public void verificoLaOpcionDondeUsarSuDaviPlata() {
	    loginRobustoSteps.verificarOpcDondeUsarDaviPlata();
	}
	
	@Given("validado presencia de la opcion 'Desactivar huella Face ID'")
	public void validoPresenciaDeLaOpcionDesactivarHuellaFaceID() {
	    loginRobustoSteps.validarOpcionDesactivarHuellaFaceID();
	}
	
	@When("^ingreso las credenciales \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoLasCredenciales(String tipoID, String id, String passwd) {
	    loginRobustoSteps.ingresarCredenciales(tipoID, id, passwd);
	}
	
	@When("^selecciono la opcion ingresar$")
	public void seleccionoLaOpcionIngresar() {
	    //loginRobustoSteps.seleccionarOpcionIngresar();
	}

	@Then("^verifico que me encuentro en el inicio de la app$")
	public void verificoQueMeEncuentroEnElInicioDeLaApp() {
		loginRobustoSteps.verificarHome();
	}
	
	@Then("validar en el home la barra de productos")
	public void validarEnElHomeLaBarraDeProductos() {
		loginRobustoSteps.validateProducts();
	}
	
	@When("^Ingresar a bolsillos$")
    public void ingresarABolsillos() throws Exception {
		loginRobustoSteps.ingresarAModuloBolsillos();
    }
	
	@When("^Regreso al home desde bolsillos$")
    public void regresoAlHomeDesdeBolsillos() {
		loginRobustoSteps.regresarAlHomeDesdeBolsillos();
    }
	
	@When("^Ingreso a tarjeta virtual$")
    public void ingresoATarjetaVirtual() {
        stepsEcard.ingresarAEcard();
    }
	
	@When("^Regreso al home desde tarjeta virtual$")
    public void regresoAlHomeDesdeTarjetaVirtual() {
		loginRobustoSteps.regresarAlHomeDesdeTarjetaVirtual();
    }
	
	@When("^Realizo scroll horizontal en barra de productos$")
    public void realizoScrollHorizontalEnBarraDeProductos() {
		loginRobustoSteps.scrollHorizontalEnBarraProductos();
    }
	
	@When("^Ingreso al cajon de seguros$")
    public void ingresoAlCajonDeSeguros() throws Exception {
        microSegurosSteps.ingresarAModuloSeguros();
    }
	
	@When("^Ingreso a tienda virtual desde el cajon del home$")
    public void ingresoATiendaVirtualDesdeElCajonDelHome() throws Exception {
		stepsEcard.ingresarATiendaVirtual();
    }

	@When("^Realizo scroll horizontal hasta el final de la barra de productos$")
    public void realizoScrollHorizontalHastaFinalDeLaBarraDeProductos() {
		loginRobustoSteps.scrollHorizontalFinalBarraProductos();
    }
	
	@Then("^Validar cajon de mas productos en la barra de productos$")
    public void validarCajonDeMasProductosEnLaBarraDeProductos() {
		loginRobustoSteps.validarCajonDeMasProductos();
    }
	
	@Then("^Ingresar al modulo de mis productos$")
    public void ingresarAlModuloDeMisProductos() {
		loginRobustoSteps.ingresarModuloMasProductos();
    }
	
	@Then("^Validar modulo mis productos$")
    public void validarModuloMisProductos() {
		loginRobustoSteps.validarModuloDeMisProductos();
    }
}