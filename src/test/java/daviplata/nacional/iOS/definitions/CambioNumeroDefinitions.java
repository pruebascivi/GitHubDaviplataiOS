package daviplata.nacional.iOS.definitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.hamcrest.core.IsNull;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import daviplata.nacional.iOS.modelo.ConsultaCupoTarjeta;
import daviplata.nacional.iOS.steps.CambioNumeroSteps;
import daviplata.nacional.iOS.steps.LoginSteps;
import daviplata.nacional.iOS.steps.WebRedebanSteps;
import daviplata.nacional.iOS.utilidades.Utilidades;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class CambioNumeroDefinitions {

	@Steps
	private CambioNumeroSteps stepsCambioNumero;
	@Steps
	private WebRedebanSteps stepsWebRedeban;
	@Steps
	private LoginSteps stepsLogin;
	ArrayList<Float> saldos = new ArrayList<Float>();
	String numCelular = "";

	
	
	
	
	@Then("^logout redeban al finalizar consulta numero celular$")
	public void logoutRedeban() throws Exception {
		stepsWebRedeban.logOut("//*[@id=\"AS_RespSpander\"]/table/tbody/tr/td/table/tbody/tr[2]/td/img");
	}
	

	@Given("^ingresar a opcion cambiar numero zona publica$")
	public void ingresarAOpcionCambiarNumeroZonaPublica() throws Exception {
		stepsLogin.ingresarAOpcionCambiarNumeroZonaPublica();
	}
	
	
	@Given("^ingresar a opcion Cambiar Numero privado$")
	public void ingresarAOpcionCambiarNumeroPrivado() throws Exception {
		stepsLogin.ingresoALaOpcionCambiarNumeroPrivado();
	}

	@Given("^validar pop up asesoria en linea$")
	public void validarPopUpAsesoriaEnLinea() throws Exception {
		stepsCambioNumero.validarPopUpAsesoriaEnLinea();
	}
	
	@Given("^validar y dar tap en boton Cancelar$")
	public void validarYDarTapEnBotonCancelar() throws Exception {
		stepsCambioNumero.validarYDarTapEnBotonCancelar();
	}
	
	@Given("^validar y dar tap en boton Aceptar$")
	public void validarYDarTapEnBotonAceptar() throws Exception {
		stepsCambioNumero.validarYDarTapEnBotonAceptar();
	}
	
	
	
	@Given("^ingresar a opcion Olvido Su Clave$")
	public void ingresarAOpcionOlvidoSuClave() throws Exception {
		stepsCambioNumero.pulsarOlvidoSuClave();
	}

	@Given("^obtener numero celular actual en redeban \"([^\"]*)\"$")
	public void obtenerNumeroCelularActualEnRedeban(String usuario) throws Exception {
		numCelular = stepsWebRedeban.consultaNumeroCelular(usuario);
		assertNotNull(numCelular);
	}
	
	

	@Given("^consultar saldo tarjeta en redeban cambio numero$")
	public void consultarSaldoTarjetaEnRedeban() throws Exception {
		String numTarjeta = stepsWebRedeban.returnNumeroTarjeta();
		ConsultaCupoTarjeta cupoTarjeta = stepsWebRedeban.consultaCuposTarjeta(numTarjeta);
		float realDisponible = Float.parseFloat(cupoTarjeta.getRealDisponible().replace(".", "").replace(",", "."));
		float bolsillos = Float.parseFloat(cupoTarjeta.getSaldoBolsillos().replace(".", "").replace(",", "."));
		saldos.add(realDisponible);
		saldos.add(bolsillos);
		System.out.println("Real Disponible tarjeta " + numTarjeta + ": " + cupoTarjeta.getRealDisponible());
		System.out.println("Bolsillos tarjeta " + numTarjeta + ": " + cupoTarjeta.getSaldoBolsillos());
		String saldoTarjeta = cupoTarjeta.getRealDisponible();
		Serenity.setSessionVariable("saldoTarjeta").to(saldoTarjeta);
	}

	@Given("^ingreso documento  \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoDocumento(String tipoId, String usuario) throws Exception {
		stepsCambioNumero.ingresarDocumento(tipoId, usuario);
		stepsCambioNumero.pulsarBotonContinuar();
	}
	
	@Given("^ingresar a opcion Cambiar Numero privado \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
	public void ingresarAOpcionCambiarNumeroPrivado(String tipoDocumento, String numeroDocumento, String contrasena) throws Exception {
		stepsWebRedeban.logOut("//img[@src='/AutorizadorMonWeb/images/pages/logout.gif']");
		stepsLogin.ingresarAApp( tipoDocumento, numeroDocumento, contrasena);
		stepsCambioNumero.IngresarCambioNumeroPrivado();
	}

	@When("^ingresar numero celular \"([^\"]*)\"$")
	public void ingresarNumeroCelular(String numeroCelular) throws Exception {
		stepsCambioNumero.ingresarNumeroCelular(numeroCelular);
	}
	
	@When("^validar pop up atencion$")
	public void validarPopUpAtencion() throws Exception {
		stepsCambioNumero.validarPopUpAtencion();
	}

	@When("^ingresar OTP \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresarOTP(String numeroCelular, String contrasena) throws Exception {
		stepsCambioNumero.ingresarOTP(numeroCelular, contrasena);
	}
	
	@When("^ingresar OTP invalido$")
	public void ingresarOTPInvalido() throws Exception {
		stepsCambioNumero.ingresarOTPInvalido();
	}
	
	@When("^ingresar segunda OTP \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresarSegundaOTP(String numeroCelular, String contrasena) throws Exception {
		stepsCambioNumero.ingresarSegundaOTP(numeroCelular, contrasena);
	}

	@When("^OTP con opcion Volver a Enviar OTP$")
	public void OTPConOpcionVolverAEnviarOTP() throws Exception {
		stepsCambioNumero.pulsarVolverAEnviarOTP();
	}

	@When("^ingresar OTP errada tres veces$")
	public void ingresarOTPErradaTresVeces() throws Exception {
		stepsCambioNumero.ingresarOTPErradaTresVeces();
	}

	@When("^ingresar numero celular con confirmacion diferente \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresarNumeroCelularConConfirmacionDiferente(String numeroCelular, String numeroCelular2)
			throws Exception {
		stepsCambioNumero.ingresarNumeroCelularDiferenteConfirmacion(numeroCelular, numeroCelular2);
	}

	@When("^ingresar usuario \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresarUsuario(String tipoDocumento, String numeroDocumento) throws Exception {
		stepsCambioNumero.ingresarUsuarioOlvidoClave(tipoDocumento, numeroDocumento);
	}

	@When("^ingresar email \"([^\"]*)\"$")
	public void ingresarEmail(String email) throws Exception {
		stepsCambioNumero.ingresarEmailOlvidoClave(email);
	}

	@When("^ingresar clave temporal \"([^\"]*)\"$")
	public void ingresarClaveTemporal(String documento) throws Exception {
		String numCelular = stepsWebRedeban.consultaNumeroCelular(documento);
		stepsCambioNumero.ingresarClaveTemporal(numCelular);
	}

	@When("^ingresar nueva clave \"([^\"]*)\"$")
	public void ingresarNuevaClave(String clave) throws Exception {
		stepsCambioNumero.ingresarNuevaClave(clave);
	}

	@Then("^validar cambio numero celular$")
	public void validarCambioNumeroCelular() throws Exception {
		stepsCambioNumero.validarPopUpCambioNumero();
	}
	
	@Then("^validar mensaje otp invalido$")
	public void validarMensajeOtpInvalido() throws Exception {
		stepsCambioNumero.validarMensajeOtpInvalido();
	}

	@Then("^validar pop up advertencia$")
	public void validarPopUpAdvertencia() throws Exception {
		stepsCambioNumero.validarPopUpConfirmacionDiferente();
	}

	@Then("^validar pop up advertencia numero no inicia en tres$")
	public void validarPopUpAdvertenciaNumeroNoIniciaEnTres() throws Exception {
		stepsCambioNumero.validarPopUpNumeroNoIniciaEnTres();
	}

	@Then("^validar pop up advertencia numero debe ser diferente$")
	public void validarPopUpAdvertenciaNumeroDebeSerDiferente() throws Exception {
		stepsCambioNumero.validarPopUpAdvertenciaNumeroDebeSerDiferente();
	}

	@Then("^validar advertencia al superar intentos$")
	public void validarAdvertenciaAlSuperarIntentos() throws Exception {
		stepsCambioNumero.validarAdvertenciaAlSuperarIntentos();
	}

	@Then("^obtener numero celular nuevo en redeban \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void obtenerNumeroCelularNuevoEnRedeban(String documento, String celular, String validar) throws Exception {
		String numCelular = stepsWebRedeban.consultaNuevoNumeroCelular(documento);
		String numCelularConsulta1 = Serenity.sessionVariableCalled("numeroCelularRedeban");
		assertNotNull(numCelular);
		if (validar.equalsIgnoreCase("si")) {
			System.out.println("validación exitosa");
			assertEquals("Validando cambio numero celular", numCelularConsulta1, numCelular);
		} else {
			System.out.println("validación NO exitosa");
			System.out.println(celular);
			System.out.println(numCelular);
			assertNotEquals("Validando no cambio numero celular", celular, numCelular);
			stepsWebRedeban.logOut("//img[@src='/AutorizadorMonWeb/images/pages/logout.gif']");
		}
	}

	@Then("^validar igualdad saldos tarjetas$")
	public void validarIgualdadSaldosTarjetas() throws Exception {
		boolean flag = false;
		int cantidadSaldos = saldos.size();
		if (cantidadSaldos == 4) {
			double sumaPrimeraTarjeta = saldos.get(0) + saldos.get(1);
			double sumaSegundaTarjeta = saldos.get(2) + saldos.get(3);
			System.out.println("Suma Primera Tarjeta: " + sumaPrimeraTarjeta);
			System.out.println("Suma Segunda Tarjeta: " + sumaSegundaTarjeta);
			if (Double.compare(sumaPrimeraTarjeta, sumaSegundaTarjeta) == 0)
				flag = true;
			stepsWebRedeban.logOut("//img[@src='/AutorizadorMonWeb/images/pages/logout.gif']");
			assertTrue(flag);
		}else {
			System.out.println("No coinciden saldos");
			stepsWebRedeban.logOut("//img[@src='/AutorizadorMonWeb/images/pages/logout.gif']");
			assertTrue(flag);
		}
	}

	/*
	 * -------------------------------------Método
	 * Main-------------------------------------------------
	 */
//	public static void main(String[] args) {
//		WebRedebanSteps stepsWebRedeban = new WebRedebanSteps(null, null, null);
//		String numCelular = stepsWebRedeban.consultaNuevoNumeroCelular("Cédula de ciudadanía");
//		assertNotNull(numCelular);
//		if ("si".equalsIgnoreCase("si"))
//			assertEquals("Validando cambio numero celular", "3142972022", numCelular);
//		else
//			assertNotEquals("Validando no cambio numero celular", "3142972022", numCelular);
//		stepsWebRedeban.logOut("//img[@src='/AutorizadorMonWeb/images/pages/logout.gif']");
//	}
}
