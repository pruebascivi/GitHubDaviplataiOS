package daviplata.nacional.iOS.steps;

import java.util.ArrayList;

import daviplata.nacional.iOS.pageObjects.AcercaDePageObjects;
import daviplata.nacional.iOS.pageObjects.ComprasMarketPlacePageObjects;
import daviplata.nacional.iOS.pageObjects.EcardPageObject;
import daviplata.nacional.iOS.pageObjects.HomePageObjects;
import daviplata.nacional.iOS.pageObjects.LoginPageObjects;
import daviplata.nacional.iOS.pageObjects.MarketPlacePageObjects;
import daviplata.nacional.iOS.pageObjects.NanocreditoPageObjects;
import daviplata.nacional.iOS.pageObjects.OlvidoClavePageObjects;
import daviplata.nacional.iOS.pageObjects.WebLatiniaPageObject;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import daviplata.nacional.iOS.utilidades.Utilidades;
import daviplata.nacional.iOS.utilidades.UtilidadesTCS;
import daviplata.nacional.iOS.utilidades.stratus.ModelConsultaCuentas;
import daviplata.nacional.iOS.utilidades.stratus.StratusDev;
import io.appium.java_client.MobileElement;
import net.thucydides.core.annotations.Step;
import daviplata.nacional.iOS.pageObjects.NewLPageObjects;

import daviplata.nacional.iOS.pageObjects.BolsilloPageObjects;
import daviplata.nacional.iOS.pageObjects.PasarPlataPageObjects;
import daviplata.nacional.iOS.pageObjects.WebLatiniaPageObject;
import daviplata.nacional.iOS.pageObjects.MicroSegurosPageObjects;
public class MicroSegurosSteps {
	Utilidades utilidad;
	LoginPageObjects pageLogin;
	WebRedebanSteps WebRedebanSteps;
	HomePageObjects pageHome;
	WebLatiniaPageObject pageLatinia;
	PasarPlataPageObjects pagePasarPlata;
	StratusDev stratusdev;
	ModelConsultaCuentas datosCuentas;
	AcercaDePageObjects pageAcercaDe;
	BolsilloPageObjects pageBolsillos;
	MarketPlacePageObjects marketObj;
	MicroSegurosPageObjects microSegurosPageObjects;
	static ArrayList<ModelConsultaCuentas> listaSaldosIniciales = new ArrayList<ModelConsultaCuentas>();
	UtilidadesTCS utilidadesTCS;
	EcardPageObject ecardPageObject;
	
	@Step
	public void compraseguroMH() {
		pageLogin.darClickEnMenuHamburguesa();
		pageHome.darClickMicroseguros();
	}
	
	@Step
	public void compraseguroHome() {
		Utilidades.esperaMiliseg(800);
		utilidadesTCS.clicElement("xpath", MicroSegurosPageObjects.BOTON_MICROSEGURO_HOME);
	}
	
	public void validomensajedaviplatainvalido() {
		marketObj.validomensajedaviplatainvalido();
	}

	public void ingresocompraseguroMH(String opcion, String genero) {

		pageHome.darClicksegurodevida();
		marketObj.cerrarPopup();
		utilidad.tomaEvidencia("Continuar");
		marketObj.btnContinuarmicroseguro();
		if (opcion.equalsIgnoreCase("1")) {
			utilidad.tomaEvidencia("Primera Cobertura");
			marketObj.btnSeleccionaroberturaPrimera();
		} else {
			utilidad.tomaEvidencia("Segunda Cobertura");
			marketObj.btnSeleccionarCoberturaSegunda();
		}
		marketObj.clicBtnDesplegableFechaNacimiento();
		//marketObj.abrirDiscosFechaNacimiento();
		marketObj.escogerFechaNacimiento();
		marketObj.clicBtnAceptarFechaNacimiento();
		utilidad.tomaEvidencia("Ingreso fecha de nacimiento");
		utilidad.esperaMiliseg(2000);
		marketObj.clicbtnGenero();
		marketObj.escogerGenero(genero);
		utilidad.tomaEvidencia("Ingreso genero");
		marketObj.btnCheckBox();
		marketObj.capturoDatosValorPagar();
		utilidad.tomaEvidencia("Comprar");
		marketObj.btnComprar();
	}
	
	public void ingresoAOpcionSeguros() {
		utilidad.esperaMiliseg(800);
		utilidadesTCS.esperarElementVisibility("xpath", MicroSegurosPageObjects.BOTON_SEGUROS);
		utilidadesTCS.clicElement("xpath", MicroSegurosPageObjects.BOTON_SEGUROS);
		utilidad.esperaMiliseg(800);
	}
	
	public void ingresocompraseguroHome(String opcion, String genero) {
		utilidad.esperaMiliseg(800);
		utilidadesTCS.esperarElementVisibility("xpath", MicroSegurosPageObjects.BOTON_SEGUROS);
		utilidadesTCS.clicElement("xpath", MicroSegurosPageObjects.BOTON_SEGUROS);
		utilidad.esperaMiliseg(800);
		pageHome.darClicksegurodevida();
		marketObj.cerrarPopup();
		utilidad.tomaEvidencia("Continuar");
		marketObj.btnContinuarmicroseguro();
		if (opcion.equalsIgnoreCase("1")) {
			utilidad.tomaEvidencia("Primera Cobertura");
			marketObj.btnSeleccionaroberturaPrimera();
		} else {
			utilidad.tomaEvidencia("Segunda Cobertura");
			marketObj.btnSeleccionarCoberturaSegunda();
		}
		marketObj.clicBtnDesplegableFechaNacimiento();
		marketObj.abrirDiscosFechaNacimiento();
		marketObj.escogerFechaNacimiento();
//		utilidadesTCS.clicElement("xpath", MicroSegurosPageObjects.DESPRENDIBLE_FECHA_NACIMIENTO);
//		String anio = "1994";
//		utilidadesTCS.scrollToElementYear(MicroSegurosPageObjects.SELECT_ANIO, anio);
		marketObj.clicBtnAceptarFechaNacimiento();
		utilidad.tomaEvidencia("Ingreso fecha de nacimiento");
		utilidad.esperaMiliseg(2000);
		marketObj.clicbtnGenero();
		marketObj.escogerGenero(genero);
		utilidad.tomaEvidencia("Ingreso genero");
		marketObj.btnCheckBox();
		marketObj.capturoDatosValorPagar();
		utilidad.tomaEvidencia("Comprar");
		marketObj.btnComprar();
	}
	
	
	public void ingresarPrimeraCobertura() {
		pageHome.darClicksegurodevida();
		marketObj.cerrarPopup();
		utilidad.tomaEvidencia("Continuar");
		marketObj.btnContinuarmicroseguro();
		utilidad.tomaEvidencia("Primera Cobertura");
		marketObj.btnSeleccionaroberturaPrimera();
	}
	
	public void ingresarSegundaCobertura() {
		marketObj.btnVolver();
		utilidad.tomaEvidencia("Segunda Cobertura");
		marketObj.btnSeleccionarCoberturaSegunda();
		
	}

	public void ingresocompraseguroMHconfechamenor(String opcion, String genero) {

		pageHome.darClicksegurodevida();
		marketObj.cerrarPopup();
		utilidad.tomaEvidencia("Continuar");
		marketObj.btnContinuarmicroseguro();
		if (opcion.equalsIgnoreCase("1")) {
			utilidad.tomaEvidencia("Primera Cobertura");
			marketObj.btnSeleccionaroberturaPrimera();
		} else {
			utilidad.tomaEvidencia("Segunda Cobertura");
			marketObj.btnSeleccionarCoberturaSegunda();
		}
		utilidad.tomaEvidencia("carga de informacion");
		marketObj.clicBtnDesplegableFechaNacimiento();
		marketObj.btnFechaNacimientoIncorrecto();
		marketObj.clicBtnAceptarFechaNacimiento();
		utilidad.tomaEvidencia("mensaje de cliente menor");
	}

	public void CompletoflujocomprarSegurobicicletaMH(String opcion) {
		microSegurosPageObjects.btnContinuarmicrosegurobicicleta();
		utilidad.tomaEvidencia("Continuar");
		marketObj.btnContinuarMascota();
		if (opcion.equalsIgnoreCase("1")) {
			utilidad.tomaEvidencia("Primera Cobertura");
			marketObj.btnSeleccionarOpcion1();
		} else {
			utilidad.tomaEvidencia("Segunda Cobertura");
			marketObj.btnSeleccionarOpcion2();
		}
		marketObj.btnFechaBicicleta();
		marketObj.btnFecha();
		utilidad.tomaEvidencia("Fecha de compra bicicleta");
		marketObj.btnCheckBox();
		marketObj.capturoDatosValorPagarBicicleta();
		utilidad.tomaEvidencia("Comprar");
		marketObj.btnComprar();
	}
	
	public void ingresarCoberturaPrimera() {
		marketObj.btnBicicleta();
		marketObj.cerrarPopup();
		utilidad.tomaEvidencia("Continuar");
		marketObj.btnContinuarMascota();
		utilidad.tomaEvidencia("Primera Cobertura");
		marketObj.btnSeleccionarOpcion1();
	}

	public void completoFlujoComprarSeguroMascotaMH(String opcion, String raza) {
		marketObj.btnMascota();
		marketObj.cerrarPopup();
		utilidad.tomaEvidencia("click continuar mascota");
		marketObj.btnContinuarMascota();
		if (opcion.equalsIgnoreCase("1")) {
			utilidad.tomaEvidencia("Primera Cobertura");
			marketObj.btnSeleccionarOpcion1();
		} else {
			utilidad.tomaEvidencia("Segunda Cobertura");
			marketObj.btnSeleccionarOpcion2();
		}
		marketObj.btnSeleccionarMascota();
		marketObj.seleccionarMascota(raza);
		
		marketObj.btnCheckBox();
		marketObj.capturoDatosValorPagarBicicleta();
		utilidad.tomaEvidencia("Comprar");
		marketObj.btnComprar();

	}
	
	public void ingresarPrimeraCoberturaMascotas() {
		marketObj.btnMascota();
		marketObj.cerrarPopup();
		marketObj.btnContinuarMascota();
		utilidad.tomaEvidencia("Primera Cobertura");
		marketObj.btnSeleccionarOpcion1();
	}


	public void validoMensajeCuentaConSeguroVida() {
		marketObj.validarMensajeCuentaConSeguroVida();
		Utilidades.tomaEvidencia("Validar mensaje de que ya cuenta con microseguro de vida");
		
	}
	
	public void validarTyCMicroseguro() {
		marketObj.validarTyCMicroseguros();
		utilidad.tomaEvidencia("Validar términos y condiciones");
	}
	
	@Step
	public void ingresarAModuloSeguros() {
        Utilidades.tomaEvidencia("Hacer clic en cajon de seguros");
        utilidadesTCS.clicElement("xpath", MicroSegurosPageObjects.BOTON_SEGUROS_HOME);
		Utilidades.esperaMiliseg(2500);
        //utilidadesTCS.esperarElementVisibility("xpath", EcardPageObject.TEXTO_TIENDA_VIRTUAL_MODULO);
		Utilidades.esperaMiliseg(2000);
        Utilidades.tomaEvidencia("Ingreso al modulo de seguros");
    }
}
