package daviplata.nacional.iOS.definitions;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.InvalidArgumentException;

import com.headius.invokebinder.transform.Convert;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import daviplata.nacional.iOS.pageObjects.HomePageObjects;
import daviplata.nacional.iOS.pageObjects.WebRedebanPageObjects;
import daviplata.nacional.iOS.steps.EcardSteps;
import daviplata.nacional.iOS.steps.LoginSteps;
import daviplata.nacional.iOS.steps.MarketPlaceSteps;
import daviplata.nacional.iOS.steps.RecargaSteps;
import daviplata.nacional.iOS.modelo.Cliente;
import daviplata.nacional.iOS.modelo.ConsultaClientes;
import daviplata.nacional.iOS.modelo.ConsultaCupoTarjeta;
import daviplata.nacional.iOS.modelo.FondosInsuficientes;
import daviplata.nacional.iOS.pageObjects.BolsilloPageObjects;
import daviplata.nacional.iOS.steps.MarketPlaceSteps;
import daviplata.nacional.iOS.steps.PagarSteps;
import daviplata.nacional.iOS.steps.PasarPlataSteps;
import daviplata.nacional.iOS.steps.RecargaSteps;
import daviplata.nacional.iOS.steps.SacarPlataSteps;
import daviplata.nacional.iOS.steps.WebRedebanSteps;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import daviplata.nacional.iOS.utilidades.Utilidades;
import daviplata.nacional.iOS.utilidades.WebRedebanException;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import jnr.ffi.Struct.int16_t;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class FondosInsuficientesDefinitions {
	
	
	    @Steps
	    WebRedebanPageObjects pageRedeban = new WebRedebanPageObjects();
	    @Steps
		private WebRedebanSteps stepsWebRedeban;
	    @Steps
		private static Cliente origenCliente = new Cliente();
	    @Steps
		private static Cliente destinoCliente = new Cliente();
	    
	    @Steps
		private Utilidades utilidad;
	    @Steps
		private HomePageObjects pageHome;
	    @Steps
		private PasarPlataSteps stepsPasarPlata;
	    @Steps
		private RecargaSteps stepsRecarga;
	    @Steps
		private SacarPlataSteps stepsSacarPlata;
	    @Steps
		private PagarSteps stepsPagar;
	    @Steps
		private MarketPlaceSteps objQRSteps;
	    @Steps
		private EcardSteps stepsEcard;
	    @Steps
		private LoginSteps stepsLogin;
	    BaseUtil base;
		public String Cel ="";
		ArrayList<Float> saldos = new ArrayList<Float>();
		String numCelular = "";


		@Given("^valido saldos redeban solo origen \"([^\"]*)\"$")
		public void validoSaldosRedebanSoloOrigen(String usuario) {
			stepsWebRedeban.loginWebRedeban();
			ConsultaClientes cco = stepsWebRedeban.consultaClientesWebRedeban(usuario);
			ConsultaCupoTarjeta ccto = stepsWebRedeban.consultaCuposTarjeta(cco.getNumeroTarjeta());
			origenCliente.setConsultaClientes(cco);
			origenCliente.setConsultaCupoTarjeta(ccto);
		}
		
		/*@Given("^consultar saldo tarjeta en redeban \"([^\"]*)\"$")
	    public void consultarSaldoTarjetaEnRedeban(String usuario) throws Exception {
			stepsWebRedeban.loginWebRedeban();
			ConsultaClientes cco = stepsWebRedeban.consultaClientesWebRedeban(usuario);
			pageRedeban.traerNumTarjeta();
			String numTarjeta = Serenity.sessionVariableCalled("numeroTarjeta");
	 //     String numTarjeta = stepsWebRedeban.returnNumeroTarjeta();
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
		*/
		
		/*@Given("^obtener numero celular actual en redeban \"([^\"]*)\"$")
		public void obtenerNumeroCelularActualEnRedeban(String documento) throws Exception {
			numCelular = stepsWebRedeban.consultaNumeroCelular(documento);
			assertThat(numCelular, is(not(null)));
			//assertNotNull(numCelular);
		}*/
		
		/*@Given("^consultar saldo tarjeta en redeban casita$")
	    public void consultarSaldoTarjetaEnRedebanCasita() throws Exception {
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
	    }*/
		
		
		
		@Then("^validar igualdad saldos$")
	    public void validarIgualdadSaldos() throws Exception {
	        boolean flag = false;
	        int cantidadSaldos = saldos.size();
	        if (cantidadSaldos == 4) {
	            double sumaPrimeraTarjeta = saldos.get(0) + saldos.get(1);
	            double sumaSegundaTarjeta = saldos.get(2) + saldos.get(3);
	            assertThat(sumaPrimeraTarjeta, is(equalTo(sumaSegundaTarjeta)));
	        }else {
	            System.out.println("No pude validar saldos");
	        }
	}
		
		@When("^pasar plata a banco en linea y pedir dinero fondo insuficiente \"([^\"]*)\"$")
		public void pasarPlataABancoEnLineaYPedirDineroFondoInsuficiente(String numero) throws Exception {
			stepsLogin.ingresoALaOpcionPedirPlata(numero);
		}
		
		@When("^pasar plata a banco en linea y verificar el dinero pedido$")
		public void pasarPlataABancoEnLineaYVerificarElDineroPedido()  {
			stepsLogin.validarPeticionDinero();
		}


		@Then("^valido saldos redeban salida \"([^\"]*)\" \"([^\"]*)\"$")
		public void validoSaldosRedebanSalida(String usuario, String idDaviplata) {
			stepsWebRedeban.loginWebRedeban();
			ConsultaClientes cco = stepsWebRedeban.consultaClientesWebRedeban(usuario);
			ConsultaCupoTarjeta ccto = stepsWebRedeban.consultaCuposTarjeta(cco.getNumeroTarjeta());
//			origenCliente.setConsultaClientes(cco);
//			origenCliente.setConsultaCupoTarjeta(ccto);
			ConsultaClientes ccd = stepsWebRedeban.consultaClientesWebRedeban(idDaviplata);
			ConsultaCupoTarjeta cctd = stepsWebRedeban.consultaCuposTarjeta(ccd.getNumeroTarjeta());
//			destinoCliente.setConsultaClientes(ccd);
//			destinoCliente.setConsultaCupoTarjeta(cctd);
			Assert.assertEquals(origenCliente.getConsultaCupoTarjeta().getTotalDisponible(), ccto.getTotalDisponible());
			Assert.assertEquals(origenCliente.getConsultaCupoTarjeta().getSaldoBolsillos(), ccto.getSaldoBolsillos());
			Assert.assertEquals(origenCliente.getConsultaCupoTarjeta().getDisponibleSaldos(), ccto.getDisponibleSaldos());
			Assert.assertEquals(origenCliente.getConsultaCupoTarjeta().getRealDisponible(), ccto.getRealDisponible());
			Assert.assertEquals(origenCliente.getConsultaCupoTarjeta().getSaldoDisponible4x1000(),
					ccto.getSaldoDisponible4x1000());

			Assert.assertEquals(destinoCliente.getConsultaCupoTarjeta().getTotalDisponible(), cctd.getTotalDisponible());
			Assert.assertEquals(destinoCliente.getConsultaCupoTarjeta().getSaldoBolsillos(), cctd.getSaldoBolsillos());
			Assert.assertEquals(destinoCliente.getConsultaCupoTarjeta().getDisponibleSaldos(), cctd.getDisponibleSaldos());
			Assert.assertEquals(destinoCliente.getConsultaCupoTarjeta().getRealDisponible(), cctd.getRealDisponible());
			Assert.assertEquals(destinoCliente.getConsultaCupoTarjeta().getSaldoDisponible4x1000(),
					cctd.getSaldoDisponible4x1000());
			utilidad.tomaEvidenciaPantalla("web - Valido que los saldos de RBM se han igual a los del principio de la prueba");
		}
		
		
		//
		@Then("^valido saldo redeban salida \"([^\"]*)\"$")
		public void validoSaldoRedebanSalida(String usuario, String idDaviplata) {
			stepsWebRedeban.loginWebRedeban();
			ConsultaClientes cco = stepsWebRedeban.consultaClientesWebRedeban(usuario);
			ConsultaCupoTarjeta ccto = stepsWebRedeban.consultaCuposTarjeta(cco.getNumeroTarjeta());
//			origenCliente.setConsultaClientes(cco);
//			origenCliente.setConsultaCupoTarjeta(ccto);
			ConsultaClientes ccd = stepsWebRedeban.consultaClientesWebRedeban(idDaviplata);
			ConsultaCupoTarjeta cctd = stepsWebRedeban.consultaCuposTarjeta(ccd.getNumeroTarjeta());
//			destinoCliente.setConsultaClientes(ccd);
//			destinoCliente.setConsultaCupoTarjeta(cctd);
			Assert.assertEquals(origenCliente.getConsultaCupoTarjeta().getTotalDisponible(), ccto.getTotalDisponible());
			Assert.assertEquals(origenCliente.getConsultaCupoTarjeta().getSaldoBolsillos(), ccto.getSaldoBolsillos());
			Assert.assertEquals(origenCliente.getConsultaCupoTarjeta().getDisponibleSaldos(), ccto.getDisponibleSaldos());
			Assert.assertEquals(origenCliente.getConsultaCupoTarjeta().getRealDisponible(), ccto.getRealDisponible());
			Assert.assertEquals(origenCliente.getConsultaCupoTarjeta().getSaldoDisponible4x1000(),
					ccto.getSaldoDisponible4x1000());

			Assert.assertEquals(destinoCliente.getConsultaCupoTarjeta().getTotalDisponible(), cctd.getTotalDisponible());
			Assert.assertEquals(destinoCliente.getConsultaCupoTarjeta().getSaldoBolsillos(), cctd.getSaldoBolsillos());
			Assert.assertEquals(destinoCliente.getConsultaCupoTarjeta().getDisponibleSaldos(), cctd.getDisponibleSaldos());
			Assert.assertEquals(destinoCliente.getConsultaCupoTarjeta().getRealDisponible(), cctd.getRealDisponible());
			Assert.assertEquals(destinoCliente.getConsultaCupoTarjeta().getSaldoDisponible4x1000(),
					cctd.getSaldoDisponible4x1000());
			utilidad.tomaEvidenciaPantalla("web - Valido que los saldos de RBM se han igual a los del principio de la prueba");
		}

		@Then("^valido saldos origen redeban salida \"([^\"]*)\"$")
		public void validoSaldosOrigenRedebanSalida(String usuario) {
			stepsWebRedeban.loginWebRedeban();
			ConsultaClientes cco = stepsWebRedeban.consultaClientesWebRedeban(usuario);
			ConsultaCupoTarjeta ccto = stepsWebRedeban.consultaCuposTarjeta(cco.getNumeroTarjeta());
			Assert.assertEquals(origenCliente.getConsultaCupoTarjeta().getTotalDisponible(), ccto.getTotalDisponible());
			Assert.assertEquals(origenCliente.getConsultaCupoTarjeta().getSaldoBolsillos(), ccto.getSaldoBolsillos());
			Assert.assertEquals(origenCliente.getConsultaCupoTarjeta().getDisponibleSaldos(), ccto.getDisponibleSaldos());
			Assert.assertEquals(origenCliente.getConsultaCupoTarjeta().getRealDisponible(), ccto.getRealDisponible());
			Assert.assertEquals(origenCliente.getConsultaCupoTarjeta().getSaldoDisponible4x1000(),
					ccto.getSaldoDisponible4x1000());
			utilidad.tomaEvidenciaPantalla("web - Valido que los saldos de RBM se han igual a los del principio de la prueba");
		}
		
		
		
		@Given("^pasar plata a banco en linea y meter dinero fondo insuficiente\"([^\"]*)\"\"([^\"]*)\"$")
		public void pasarPlataABancoEnLineaYMeterDineroFondoInsuficiente(String numCelular, String monto) throws Exception {
			stepsPasarPlata.ingresoALaOpcionMeterPlataFondosInsuficientes(numCelular,monto);
		}
		
		@Given("^pedir plata a banco en linea y meter dinero fondo insuficiente\"([^\"]*)\"\"([^\"]*)\"$")
		public void pedirPlataABancoEnLineaYMeterDineroFondoInsuficiente(String numCelular, String monto) throws Exception {
			stepsPasarPlata.ingresoALaOpcionPedirPlataFondosInsuficientes(numCelular,monto);
		}
		
		@Given("^cerrar sesion usuario 1$")
		public void cerrarSesion() throws Exception {
			stepsPasarPlata.cerrarSesion();
		}

		/*@When("^paso plata a otro daviplata fondo insuficiente$")
		public void pasoPlataAOtroDaviplataFondoInsuficiente() {
			stepsPasarPlata.seleccionarPasarPlata(false);
			stepsPasarPlata.pasarPlataAOtroDaviplataFondosInsuficientes("3227680732");
			stepsPasarPlata.transaccionFondosInsuficientes("8000000");
			stepsPasarPlata.validoExcedeCupo();
			TouchAction touchAction=new TouchAction(base.driver);
            touchAction.tap(new PointOption().withCoordinates(51,319)).perform();
			stepsPasarPlata.volver();
			stepsPasarPlata.volver();
			pageHome.capturarSaldoFinal();
		}*/
		
		@When("^Paso plata a otro daviplata fondos insuficientes gmf \"([^\"]*)\"$")
		public void pasoPlataAOtroDaviplataFondosInsuficientesGmf(String numCelular) {
			BigDecimal saldoTotal = Serenity.sessionVariableCalled("saldoRealGmf");
			String valorSuperior = saldoTotal.add(new BigDecimal(2)).toBigInteger().toString();
			
			stepsPasarPlata.seleccionarPasarPlata(true);
			stepsPasarPlata.pasarPlataAOtroDaviplataFondosInsuficientes(numCelular);
			stepsPasarPlata.transaccionFondosInsuficientesBancos(valorSuperior);
			stepsPasarPlata.validoFondosInsuficientes();
		}
		
		@When("^Paso plata a otro daviplata fondos insuficientes \"([^\"]*)\"$")
		public void pasoPlataAOtroDaviplataFondosInsuficientes(String numCelular) {
			BigDecimal saldoTotal = Serenity.sessionVariableCalled("saldoReal");
			String valorSuperior = saldoTotal.add(new BigDecimal(2)).toBigInteger().toString();
			
			stepsPasarPlata.seleccionarPasarPlata(true);
			stepsPasarPlata.pasarPlataAOtroDaviplataFondosInsuficientes(numCelular);
			stepsPasarPlata.transaccionFondosInsuficientesBancos(valorSuperior);
			stepsPasarPlata.validoFondosInsuficientes();
		}

		@When("^paso plata a otro daviplata excede cupo$")
		public void pasoPlataAOtroDaviplataExcedeCupo() {
			stepsPasarPlata.seleccionarPasarPlata(false);
			stepsPasarPlata.pasarPlataAOtroDaviplataFondosInsuficientes("3227680732");
			stepsPasarPlata.transaccionFondosInsuficientes("8000000");
			stepsPasarPlata.validoExcedeCupo();
		}

		@When("^pasar plata a cuenta bancaria excede cupo \"([^\"]*)\" \"([^\"]*)\"$")
		public void pasarPlataCuentaBancariaExcedeCupo(String tipoCuenta, String cuentaNum) {
			String valorDisponibleRBM = origenCliente.getConsultaCupoTarjeta().getSaldoDisponible4x1000();
			valorDisponibleRBM = utilidad.quitarCaracter(valorDisponibleRBM, ".");
			valorDisponibleRBM = utilidad.quitarCaracter(valorDisponibleRBM, ",");
			BigDecimal valorDisponibleApp = pageHome.capturarSaldoInicial();
			Assert.assertEquals(valorDisponibleRBM, utilidad.quitarCaracter(valorDisponibleApp + "", "."));
			valorDisponibleRBM = utilidad.quitarDigitos(valorDisponibleRBM, 2);
			BigDecimal valorDisponible = new BigDecimal(valorDisponibleRBM);
			// ----Valor Total Redeban -------------//
			String valorTotalRBM = origenCliente.getConsultaCupoTarjeta().getTotalDisponible();
			valorTotalRBM = utilidad.quitarCaracter(valorTotalRBM, ".");
			valorTotalRBM = utilidad.quitarCaracter(valorTotalRBM, ",");
			valorTotalRBM = utilidad.quitarDigitos(valorTotalRBM, 2);
			BigDecimal valorTotalApp = pageHome.capturarSaldoInicialTotal();
			BigDecimal valorTotal = new BigDecimal(valorTotalRBM);
			System.out.println("VALOR TOTAL REDEBAN: " + valorTotal);
			System.out.println("VALOR DISPONIBLE REDEBAN : " + valorDisponible);
			System.out.println("Total Daviplata: " + valorTotalApp + " Total RBM: " + valorTotal);
			BigDecimal BigvalorDispTotal = (valorDisponible.add(valorTotal)).divide(new BigDecimal(2));
			BigvalorDispTotal = BigvalorDispTotal.setScale(2, RoundingMode.HALF_UP);

			String valorLigeramenteInferior = valorTotal.toBigInteger().toString();
			String valorInferior = BigvalorDispTotal.toBigInteger().toString();
			String valorSuperior = valorTotal.add(new BigDecimal(2)).toBigInteger().toString();
			String valorMuySuperior = valorTotal.add(new BigDecimal(123456)).toBigInteger().toString();

			// --------------------------------------------------------------------------------------//
			System.out.println("valorInferior: " + valorInferior);
			System.out.println("valorLigeramenteInferior: " + valorLigeramenteInferior);
			System.out.println("valorSuperior: " + valorSuperior);
			System.out.println("valorMuySuperior: " + valorMuySuperior);
			// --------------------------------------------------------------------------------------//

			stepsPasarPlata.seleccionarPasarPlata(true);
			stepsPasarPlata.seleccionarTipoCuentaDestino(tipoCuenta, cuentaNum);
			stepsPasarPlata.transaccionFondosInsuficientesBancos(valorSuperior);
			stepsPasarPlata.validoExcedeCupo(2);

			stepsPasarPlata.seleccionarPasarPlata(false);
			stepsPasarPlata.seleccionarTipoCuentaDestino(tipoCuenta, cuentaNum);
			stepsPasarPlata.transaccionFondosInsuficientesBancos(valorMuySuperior);
			stepsPasarPlata.validoExcedeCupo(2);
		}

		@When("^pasar plata a cuenta bancaria fondo insuficiente \"([^\"]*)\" \"([^\"]*)\"$")
		public void pasarPlataCuentaBancariaFondoInsuficiente(String tipoCuenta, String cuentaNum) {
			String saldoTotal = Serenity.sessionVariableCalled("saldoTarjeta");
			saldoTotal = saldoTotal.replace(",", "").replace(".", "").replace("'", "");
			saldoTotal = saldoTotal.substring(0, (saldoTotal.length()-2));
			BigDecimal valorTotal = new BigDecimal(saldoTotal);
			String valorSuperior = valorTotal.add(new BigDecimal(2)).toBigInteger().toString();
			
			
			stepsPasarPlata.seleccionarPasarPlata(true);
			stepsPasarPlata.seleccionarTipoCuentaDestino(tipoCuenta, cuentaNum);
			stepsPasarPlata.transaccionFondosInsuficientesBancos(valorSuperior);
			stepsPasarPlata.validoFondosInsuficientes();
		}
		
		@When("^pasar plata a cuenta de ahorros fondo insuficiente \"([^\"]*)\" \"([^\"]*)\"$")
		public void pasarPlataCuentaAhorrosFondoInsuficiente(String tipoCuenta, String cuentaNum) {
			String saldoTotal = Serenity.sessionVariableCalled("saldoTarjeta");
			saldoTotal = saldoTotal.replace(",", "").replace(".", "").replace("'", "");
			saldoTotal = saldoTotal.substring(0, (saldoTotal.length()-2));
			BigDecimal valorTotal = new BigDecimal(saldoTotal);
			String valorSuperior = valorTotal.add(new BigDecimal(2)).toBigInteger().toString();
			
			
			stepsPasarPlata.seleccionarPasarPlata(true);
			stepsPasarPlata.seleccionarTipoCuentaDestino(tipoCuenta, cuentaNum);
			stepsPasarPlata.transaccionFondosInsuficientesBancos(valorSuperior);
			stepsPasarPlata.validoFondosInsuficientes();
		}
		
		@When("^pasar plata a otros bancos fondo insuficiente (.*) \"([^\"]*)\" (.*) (.*) \"([^\"]*)\"$")
		public void pasarPlataOtrosBancosFondoInsuficiente(String numeroCuenta, String tipoId, String numId, String valorAPasar, String banco) {
			String saldoTotal = Serenity.sessionVariableCalled("saldoTarjeta");
			saldoTotal = saldoTotal.replace(",", "").replace(".", "").replace("'", "");
			saldoTotal = saldoTotal.substring(0, (saldoTotal.length()-2));
			BigDecimal valorTotal = new BigDecimal(saldoTotal);
			String valorSuperior = valorTotal.add(new BigDecimal(2)).toBigInteger().toString();
			
			
			stepsPasarPlata.seleccionarPasarPlata(true);
			stepsPasarPlata.seleccionarOtrosBancos();
			stepsPasarPlata.llenarFormularioPasarPlataAch(numeroCuenta, tipoId, numId, valorAPasar, banco );
			stepsPasarPlata.validarTransaccionNegadaMonto();
		}

		/*@When("^ingresar a bolsillo y sacar dinero fondo insuficiente$")
		public void ingresarBolsilloSacarDineroFondoInsuficiente() {
			String valorDisponibleRBM = origenCliente.getConsultaCupoTarjeta().getSaldoDisponible4x1000();
			valorDisponibleRBM = utilidad.quitarCaracter(valorDisponibleRBM, ".");
			valorDisponibleRBM = utilidad.quitarCaracter(valorDisponibleRBM, ",");
			BigDecimal valorDisponibleApp = pageHome.capturarSaldoInicial();
			Assert.assertEquals(valorDisponibleRBM, utilidad.quitarCaracter(valorDisponibleApp + "", "."));
			valorDisponibleRBM = utilidad.quitarDigitos(valorDisponibleRBM, 2);
			BigDecimal valorDisponible = new BigDecimal(valorDisponibleRBM);
			// ----Valor Total Redeban -------------//
			String valorTotalRBM = origenCliente.getConsultaCupoTarjeta().getTotalDisponible();
			valorTotalRBM = utilidad.quitarCaracter(valorTotalRBM, ".");
			valorTotalRBM = utilidad.quitarCaracter(valorTotalRBM, ",");
			valorTotalRBM = utilidad.quitarDigitos(valorTotalRBM, 2);
			BigDecimal valorTotalApp = pageHome.capturarSaldoInicialTotal();
			BigDecimal valorTotal = new BigDecimal(valorTotalRBM);
			System.out.println("VALOR TOTAL REDEBAN: " + valorTotal);
			System.out.println("VALOR DISPONIBLE REDEBAN : " + valorDisponible);
			System.out.println("Total Daviplata: " + valorTotalApp + " Total RBM: " + valorTotal);
			BigDecimal BigvalorDispTotal = (valorDisponible.add(valorTotal)).divide(new BigDecimal(2));
			BigvalorDispTotal = BigvalorDispTotal.setScale(2, RoundingMode.HALF_UP);

			String valorLigeramenteInferior = valorTotal.toBigInteger().toString();
			String valorInferior = BigvalorDispTotal.toBigInteger().toString();
			String valorSuperior = valorTotal.add(new BigDecimal(2)).toBigInteger().toString();
			String valorMuySuperior = valorTotal.add(new BigDecimal(123456)).toBigInteger().toString();

			// -------------Calculos para crear saldo en bolsillos------------------------//
			BigDecimal montoInicial = valorDisponible.divide(new BigDecimal("5"));
			// --------------------------------------------------------------------------------------//
			System.out.println("valorInferior: " + valorInferior);
			System.out.println("valorLigeramenteInferior: " + valorLigeramenteInferior);
			System.out.println("valorSuperior: " + valorSuperior);
			System.out.println("valorMuySuperior: " + valorMuySuperior);
			// --------------------------------------------------------------------------------------//

			/*stepsPasarPlata.ingresarABolsillos(true);
			int numero = stepsPasarPlata.consultarMeterPlataBolsilloAleatorio();
			stepsPasarPlata.ingresarMonto(valorSuperior);
			stepsPasarPlata.validoBolsilloNoSaldoDisponible();// otro mensaje*/
			/*
			stepsPasarPlata.ingresarABolsillos(true);
			int saldo = stepsPasarPlata.consultarSacarPlataBolsilloAleatorio();
			saldo = saldo + 2;
			String saldoBolsillo= String.valueOf(saldo);
			stepsPasarPlata.ingresarMonto(saldoBolsillo);
			stepsPasarPlata.validoBolsilloNoSaldoDisponible();// otro mensaje

			stepsPasarPlata.ingresarABolsillos(false);
			int saldo2 = stepsPasarPlata.consultarSacarPlataBolsilloAleatorio();
			saldo2 = saldo2 + 100000;
			String saldoBolsillo2= String.valueOf(saldo2);
			stepsPasarPlata.ingresarMonto(saldoBolsillo2);
			stepsPasarPlata.validoBolsilloNoSaldoDisponible();
		}*/

		@When("^ingresar a bolsillo y sacar dinero excede cupo$")
		public void ingresarBolsilloSacarDineroExcedeCupo() {
			stepsPasarPlata.ingresarABolsillos(false);
			int saldo = stepsPasarPlata.consultarSacarPlataBolsilloAleatorio();
			saldo = saldo + 1000;
			String valorSuperior = Integer.toString(saldo);
			stepsPasarPlata.ingresarMonto(valorSuperior);
			stepsPasarPlata.validoBolsilloNoSaldoDisponible();
		}

		@When("^ingresar bolsillo y meter dinero fondo insuficiente$")
		public void ingresarBolsilloMeterrDineroFondoInsuficiente() {
			String saldoTotal = Serenity.sessionVariableCalled("saldoTarjeta");
			saldoTotal = saldoTotal.replace(",", "").replace(".", "").replace("'", "");
			saldoTotal = saldoTotal.substring(0, (saldoTotal.length()-2));
			BigDecimal valorTotal = new BigDecimal(saldoTotal);
			String valorSuperior = valorTotal.add(new BigDecimal(2)).toBigInteger().toString();
			
			
			stepsPasarPlata.ingresarABolsillos(true);
			int numero = stepsPasarPlata.consultarMeterPlataBolsilloAleatorio();
			stepsPasarPlata.ingresarMonto(valorSuperior);
			stepsPasarPlata.validoBolsilloFondosInsuficientes();
		}

		@When("^ingresar bolsillo y meter dinero excede cupo$")
		public void ingresarBolsilloMeterrDineroExcedeCupo() {
			String valorDisponibleRBM = origenCliente.getConsultaCupoTarjeta().getSaldoDisponible4x1000();
			valorDisponibleRBM = utilidad.quitarCaracter(valorDisponibleRBM, ".");
			valorDisponibleRBM = utilidad.quitarCaracter(valorDisponibleRBM, ",");
			BigDecimal valorDisponibleApp = pageHome.capturarSaldoInicial();
			Assert.assertEquals(valorDisponibleRBM, utilidad.quitarCaracter(valorDisponibleApp + "", "."));
			valorDisponibleRBM = utilidad.quitarDigitos(valorDisponibleRBM, 2);
			BigDecimal valorDisponible = new BigDecimal(valorDisponibleRBM);
			// ----Valor Total Redeban -------------//
			String valorTotalRBM = origenCliente.getConsultaCupoTarjeta().getTotalDisponible();
			valorTotalRBM = utilidad.quitarCaracter(valorTotalRBM, ".");
			valorTotalRBM = utilidad.quitarCaracter(valorTotalRBM, ",");
			valorTotalRBM = utilidad.quitarDigitos(valorTotalRBM, 2);
			BigDecimal valorTotalApp = pageHome.capturarSaldoInicialTotal();
			BigDecimal valorTotal = new BigDecimal(valorTotalRBM);
			System.out.println("VALOR TOTAL REDEBAN: " + valorTotal);
			System.out.println("VALOR DISPONIBLE REDEBAN : " + valorDisponible);
			System.out.println("Total Daviplata: " + valorTotalApp + " Total RBM: " + valorTotal);
			BigDecimal BigvalorDispTotal = (valorDisponible.add(valorTotal)).divide(new BigDecimal(2));
			BigvalorDispTotal = BigvalorDispTotal.setScale(2, RoundingMode.HALF_UP);

			String valorLigeramenteInferior = valorTotal.toBigInteger().toString();
			String valorInferior = BigvalorDispTotal.toBigInteger().toString();
			String valorSuperior = valorTotal.add(new BigDecimal(2)).toBigInteger().toString();
			String valorMuySuperior = valorTotal.add(new BigDecimal(123456)).toBigInteger().toString();

			// -------------Calculos para crear saldo en bolsillos------------------------//
			BigDecimal montoInicial = valorDisponible.divide(new BigDecimal("5"));
			// --------------------------------------------------------------------------------------//
			System.out.println("valorInferior: " + valorInferior);
			System.out.println("valorLigeramenteInferior: " + valorLigeramenteInferior);
			System.out.println("valorSuperior: " + valorSuperior);
			System.out.println("valorMuySuperior: " + valorMuySuperior);
			// --------------------------------------------------------------------------------------//

			stepsPasarPlata.ingresarOCrearBolsillos(montoInicial.toBigInteger().toString(), true);
			int numero = stepsPasarPlata.consultarMeterPlataBolsilloAleatorio();
			stepsPasarPlata.ingresarMonto(valorSuperior);
			stepsPasarPlata.validoFondosInsuficientesBolsillo(3);

			stepsPasarPlata.ingresarOCrearBolsillos(montoInicial.toBigInteger().toString(), false);
			stepsPasarPlata.meterPlataBolsillo(numero);
			stepsPasarPlata.ingresarMonto(valorMuySuperior);
			stepsPasarPlata.validoFondosInsuficientesBolsillo(3);
		}

		@When("^crear bolsillo y meter dinero fondo insuficiente$")
		public void crearBolsilloMeterDineroFondoInsuficiente() {
			String saldoTotal = Serenity.sessionVariableCalled("saldoTarjeta");
			saldoTotal = saldoTotal.replace(",", "").replace(".", "").replace("'", "");
			saldoTotal = saldoTotal.substring(0, (saldoTotal.length()-2));
			BigDecimal valorTotal = new BigDecimal(saldoTotal);
			String valorSuperior = valorTotal.add(new BigDecimal(2)).toBigInteger().toString();
			
			stepsPasarPlata.ingresarEliminarCrearBolsillos(valorSuperior, true);
			stepsPasarPlata.validoValorInicialInvalidoBolsillo();
		}

		@When("^crear bolsillo y meter dinero excede cupo$")
		public void crearBolsilloMeterDineroExcedeCupo() {
			String valorDisponibleRBM = origenCliente.getConsultaCupoTarjeta().getSaldoDisponible4x1000();
			valorDisponibleRBM = utilidad.quitarCaracter(valorDisponibleRBM, ".");
			valorDisponibleRBM = utilidad.quitarCaracter(valorDisponibleRBM, ",");
			BigDecimal valorDisponibleApp = pageHome.capturarSaldoInicial();
			Assert.assertEquals(valorDisponibleRBM, utilidad.quitarCaracter(valorDisponibleApp + "", "."));
			valorDisponibleRBM = utilidad.quitarDigitos(valorDisponibleRBM, 2);
			BigDecimal valorDisponible = new BigDecimal(valorDisponibleRBM);
			// ----Valor Total Redeban -------------//
			String valorTotalRBM = origenCliente.getConsultaCupoTarjeta().getTotalDisponible();
			valorTotalRBM = utilidad.quitarCaracter(valorTotalRBM, ".");
			valorTotalRBM = utilidad.quitarCaracter(valorTotalRBM, ",");
			valorTotalRBM = utilidad.quitarDigitos(valorTotalRBM, 2);
			BigDecimal valorTotalApp = pageHome.capturarSaldoInicialTotal();
			BigDecimal valorTotal = new BigDecimal(valorTotalRBM);
			System.out.println("VALOR TOTAL REDEBAN: " + valorTotal);
			System.out.println("VALOR DISPONIBLE REDEBAN : " + valorDisponible);
			System.out.println("Total Daviplata: " + valorTotalApp + " Total RBM: " + valorTotal);
			BigDecimal BigvalorDispTotal = (valorDisponible.add(valorTotal)).divide(new BigDecimal(2));
			BigvalorDispTotal = BigvalorDispTotal.setScale(2, RoundingMode.HALF_UP);

			String valorLigeramenteInferior = valorTotal.toBigInteger().toString();
			String valorInferior = BigvalorDispTotal.toBigInteger().toString();
			String valorSuperior = valorTotal.add(new BigDecimal(2)).toBigInteger().toString();
			String valorMuySuperior = valorTotal.add(new BigDecimal(123456)).toBigInteger().toString();

			// -------------Calculos para crear saldo en bolsillos------------------------//
			BigDecimal montoInicial = valorDisponible.divide(new BigDecimal("5"));
			// --------------------------------------------------------------------------------------//
			System.out.println("valorInferior: " + valorInferior);
			System.out.println("valorLigeramenteInferior: " + valorLigeramenteInferior);
			System.out.println("valorSuperior: " + valorSuperior);
			System.out.println("valorMuySuperior: " + valorMuySuperior);
			// --------------------------------------------------------------------------------------//

			stepsPasarPlata.ingresarEliminarCrearBolsillos(valorSuperior, true);
			stepsPasarPlata.validoSinAbonoPorFondoInsuficiente(3);

			stepsPasarPlata.ingresarEliminarCrearBolsillos(valorMuySuperior, false);
			stepsPasarPlata.validoSinAbonoPorFondoInsuficiente(3);
		}

		@When("^pasar plata a cuenta bancaria otro banco fondo insuficiente \"([^\"]*)\" \"([^\"]*)\"$")
		public void pasarPlataCuentaBancariaOtroBancoFondoInsuficiente(String tipoCuenta, String cuentaNum) {
			String valorDisponibleRBM = origenCliente.getConsultaCupoTarjeta().getSaldoDisponible4x1000();
			valorDisponibleRBM = utilidad.quitarCaracter(valorDisponibleRBM, ".");
			valorDisponibleRBM = utilidad.quitarCaracter(valorDisponibleRBM, ",");
			BigDecimal valorDisponibleApp = pageHome.capturarSaldoInicial();
			Assert.assertEquals(valorDisponibleRBM, utilidad.quitarCaracter(valorDisponibleApp + "", "."));
			valorDisponibleRBM = utilidad.quitarDigitos(valorDisponibleRBM, 2);
			BigDecimal valorDisponible = new BigDecimal(valorDisponibleRBM);
			// ----Valor Total Redeban -------------//
			String valorTotalRBM = origenCliente.getConsultaCupoTarjeta().getTotalDisponible();
			valorTotalRBM = utilidad.quitarCaracter(valorTotalRBM, ".");
			valorTotalRBM = utilidad.quitarCaracter(valorTotalRBM, ",");
			valorTotalRBM = utilidad.quitarDigitos(valorTotalRBM, 2);
			BigDecimal valorTotalApp = pageHome.capturarSaldoInicialTotal();
			BigDecimal valorTotal = new BigDecimal(valorTotalRBM);
			System.out.println("VALOR TOTAL REDEBAN: " + valorTotal);
			System.out.println("VALOR DISPONIBLE REDEBAN : " + valorDisponible);
			System.out.println("Total Daviplata: " + valorTotalApp + " Total RBM: " + valorTotal);
			BigDecimal BigvalorDispTotal = (valorDisponible.add(valorTotal)).divide(new BigDecimal(2));
			BigvalorDispTotal = BigvalorDispTotal.setScale(2, RoundingMode.HALF_UP);

			String valorLigeramenteInferior = valorTotal.toBigInteger().toString();
			String valorInferior = BigvalorDispTotal.toBigInteger().toString();
			String valorSuperior = valorTotal.add(new BigDecimal(2)).toBigInteger().toString();
			String valorMuySuperior = valorTotal.add(new BigDecimal(123456)).toBigInteger().toString();

			// --------------------------------------------------------------------------------------//
			System.out.println("valorInferior: " + valorInferior);
			System.out.println("valorLigeramenteInferior: " + valorLigeramenteInferior);
			System.out.println("valorSuperior: " + valorSuperior);
			System.out.println("valorMuySuperior: " + valorMuySuperior);
			// --------------------------------------------------------------------------------------//

			/*stepsPasarPlata.seleccionarPasarPlata(true);
			stepsPasarPlata.seleccionarTipoCuentaDestinoACH(tipoCuenta, cuentaNum, valorInferior);
			stepsPasarPlata.validoInferiorAlPermitido(3);
			stepsPasarPlata.validoFondosInsuficientes();

			stepsPasarPlata.seleccionarPasarPlata(false);
			stepsPasarPlata.seleccionarTipoCuentaDestinoACH(tipoCuenta, cuentaNum, valorLigeramenteInferior);
			stepsPasarPlata.validoInferiorAlPermitido(3);
			stepsPasarPlata.validoFondosInsuficientes();*/

			stepsPasarPlata.seleccionarPasarPlata(true);
			stepsPasarPlata.btnAOtroBanco();
			stepsPasarPlata.seleccionarTipoCuentaDestinoACH(tipoCuenta, cuentaNum, valorSuperior);
			stepsPasarPlata.validoExcedeCupoAOtros();
//			stepsPasarPlata.validoInferiorAlPermitido(3);
//			stepsPasarPlata.validoExcedeCupo();
			

			stepsPasarPlata.seleccionarPasarPlata(false);
			stepsPasarPlata.btnAOtroBanco();
			stepsPasarPlata.seleccionarTipoCuentaDestinoACH(tipoCuenta, cuentaNum, valorMuySuperior);
			stepsPasarPlata.validoExcedeCupoAOtros();
//			stepsPasarPlata.validoInferiorAlPermitido(3);
//			stepsPasarPlata.validoExcedeCupo();
		}

		@When("^pasar plata a cuenta bancaria otro banco excede cupo \"([^\"]*)\" \"([^\"]*)\"$")
		public void pasarPlataCuentaBancariaOtroBancoExcedeCupo(String tipoCuenta, String cuentaNum) {
			String valorDisponibleRBM = origenCliente.getConsultaCupoTarjeta().getSaldoDisponible4x1000();
			valorDisponibleRBM = utilidad.quitarCaracter(valorDisponibleRBM, ".");
			valorDisponibleRBM = utilidad.quitarCaracter(valorDisponibleRBM, ",");
			BigDecimal valorDisponibleApp = pageHome.capturarSaldoInicial();
			Assert.assertEquals(valorDisponibleRBM, utilidad.quitarCaracter(valorDisponibleApp + "", "."));
			valorDisponibleRBM = utilidad.quitarDigitos(valorDisponibleRBM, 2);
			BigDecimal valorDisponible = new BigDecimal(valorDisponibleRBM);
			// ----Valor Total Redeban -------------//
			String valorTotalRBM = origenCliente.getConsultaCupoTarjeta().getTotalDisponible();
			valorTotalRBM = utilidad.quitarCaracter(valorTotalRBM, ".");
			valorTotalRBM = utilidad.quitarCaracter(valorTotalRBM, ",");
			valorTotalRBM = utilidad.quitarDigitos(valorTotalRBM, 2);
			BigDecimal valorTotalApp = pageHome.capturarSaldoInicialTotal();
			BigDecimal valorTotal = new BigDecimal(valorTotalRBM);
			System.out.println("VALOR TOTAL REDEBAN: " + valorTotal);
			System.out.println("VALOR DISPONIBLE REDEBAN : " + valorDisponible);
			System.out.println("Total Daviplata: " + valorTotalApp + " Total RBM: " + valorTotal);
			BigDecimal BigvalorDispTotal = (valorDisponible.add(valorTotal)).divide(new BigDecimal(2));
			BigvalorDispTotal = BigvalorDispTotal.setScale(2, RoundingMode.HALF_UP);

			String valorLigeramenteInferior = valorTotal.toBigInteger().toString();
			String valorInferior = BigvalorDispTotal.toBigInteger().toString();
			String valorSuperior = valorTotal.add(new BigDecimal(2)).toBigInteger().toString();
			String valorMuySuperior = valorTotal.add(new BigDecimal(123456)).toBigInteger().toString();

			// --------------------------------------------------------------------------------------//
			System.out.println("valorInferior: " + valorInferior);
			System.out.println("valorLigeramenteInferior: " + valorLigeramenteInferior);
			System.out.println("valorSuperior: " + valorSuperior);
			System.out.println("valorMuySuperior: " + valorMuySuperior);
			// --------------------------------------------------------------------------------------//

			stepsPasarPlata.seleccionarPasarPlata(true);
			stepsPasarPlata.btnAOtroBanco();
			stepsPasarPlata.seleccionarTipoCuentaDestinoACH1(tipoCuenta, cuentaNum, valorSuperior);
			stepsPasarPlata.validoRechazoFondosInsuficientesAOtros(2);

			stepsPasarPlata.seleccionarPasarPlata(false);
			stepsPasarPlata.btnAOtroBanco();
			stepsPasarPlata.seleccionarTipoCuentaDestinoACH1(tipoCuenta, cuentaNum, valorMuySuperior);
			stepsPasarPlata.validoRechazoFondosInsuficientesAOtros(2);
		}

		@When("^pagar una referencia fondo insuficiente \"([^\"]*)\" \"([^\"]*)\"$")
		public void pagarUnaReferenciaFondoInsuficiente(String empresaServicio, String referencia) {
			// -----Valor Disponible redeban ---------//
			String valorDisponibleRBM = origenCliente.getConsultaCupoTarjeta().getSaldoDisponible4x1000();
			valorDisponibleRBM = utilidad.quitarCaracter(valorDisponibleRBM, ".");
			valorDisponibleRBM = utilidad.quitarCaracter(valorDisponibleRBM, ",");
			BigDecimal valorDisponibleApp = pageHome.capturarSaldoInicial();
			Assert.assertEquals(valorDisponibleRBM, utilidad.quitarCaracter(valorDisponibleApp + "", "."));
			valorDisponibleRBM = utilidad.quitarDigitos(valorDisponibleRBM, 2);
			BigDecimal valorDisponible = new BigDecimal(valorDisponibleRBM);
			// ----Valor Total Redeban -------------//
			String valorTotalRBM = origenCliente.getConsultaCupoTarjeta().getTotalDisponible();
			valorTotalRBM = utilidad.quitarCaracter(valorTotalRBM, ".");
			valorTotalRBM = utilidad.quitarCaracter(valorTotalRBM, ",");
			valorTotalRBM = utilidad.quitarDigitos(valorTotalRBM, 2);
			BigDecimal valorTotalApp = pageHome.capturarSaldoInicialTotal();
			BigDecimal valorTotal = new BigDecimal(valorTotalRBM);
			System.out.println("VALOR TOTAL REDEBAN: " + valorTotal);
			System.out.println("VALOR DISPONIBLE REDEBAN : " + valorDisponible);
			System.out.println("Total Daviplata: " + valorTotalApp + " Total RBM: " + valorTotal);
			BigDecimal BigvalorDispTotal = (valorDisponible.add(valorTotal)).divide(new BigDecimal(2));
			BigvalorDispTotal = BigvalorDispTotal.setScale(2, RoundingMode.HALF_UP);

			String valorLigeramenteInferior = valorTotal.toBigInteger().toString();
			String valorInferior = BigvalorDispTotal.toBigInteger().toString();
			String valorSuperior = valorTotal.add(new BigDecimal(2)).toBigInteger().toString();
			String valorMuySuperior = valorTotal.add(new BigDecimal(123456)).toBigInteger().toString();

			// --------------------------------------------------------------------------------------//
			System.out.println("valorInferior: " + valorInferior);
			System.out.println("valorLigeramenteInferior: " + valorLigeramenteInferior);
			System.out.println("valorSuperior: " + valorSuperior);
			System.out.println("valorMuySuperior: " + valorMuySuperior);
			// --------------------------------------------------------------------------------------//

			/*stepsPagar.ingresoAModuloPagar();
			stepsPagar.diligencioDatosDeUnaReferencia(empresaServicio, referencia);
			stepsPagar.ingresarValorYPagar(valorInferior);
			stepsPagar.validoFondosInsuficientes07();

			stepsPagar.ingresoAModuloPagar();
			stepsPagar.diligencioDatosDeUnaReferencia(empresaServicio, referencia);
			stepsPagar.ingresarValorYPagar(valorLigeramenteInferior);
			stepsPagar.validoFondosInsuficientes07();*/

			stepsPagar.ingresoAModuloPagar();
			stepsPagar.diligencioDatosDeUnaReferencia(empresaServicio, referencia);
			stepsPagar.ingresarValorYPagar(valorSuperior);
			stepsPagar.validoFondosInsuficientes07();

			stepsPagar.ingresoAModuloPagar();
			stepsPagar.diligencioDatosDeUnaReferencia(empresaServicio, referencia);
			stepsPagar.ingresarValorYPagar(valorMuySuperior);
			stepsPagar.validoFondosInsuficientes07();

		}

		@When("^pagar una referencia excede cupo \"([^\"]*)\" \"([^\"]*)\"$")
		public void pagarUnaReferenciaExcedeCupo(String empresaServicio, String referencia) {
			// -----Valor Disponible redeban ---------//
			String valorDisponibleRBM = origenCliente.getConsultaCupoTarjeta().getSaldoDisponible4x1000();
			valorDisponibleRBM = utilidad.quitarCaracter(valorDisponibleRBM, ".");
			valorDisponibleRBM = utilidad.quitarCaracter(valorDisponibleRBM, ",");
			BigDecimal valorDisponibleApp = pageHome.capturarSaldoInicial();
			Assert.assertEquals(valorDisponibleRBM, utilidad.quitarCaracter(valorDisponibleApp + "", "."));
			valorDisponibleRBM = utilidad.quitarDigitos(valorDisponibleRBM, 2);
			BigDecimal valorDisponible = new BigDecimal(valorDisponibleRBM);
			// ----Valor Total Redeban -------------//
			String valorTotalRBM = origenCliente.getConsultaCupoTarjeta().getTotalDisponible();
			valorTotalRBM = utilidad.quitarCaracter(valorTotalRBM, ".");
			valorTotalRBM = utilidad.quitarCaracter(valorTotalRBM, ",");
			valorTotalRBM = utilidad.quitarDigitos(valorTotalRBM, 2);
			BigDecimal valorTotalApp = pageHome.capturarSaldoInicialTotal();
			BigDecimal valorTotal = new BigDecimal(valorTotalRBM);
			System.out.println("VALOR TOTAL REDEBAN: " + valorTotal);
			System.out.println("VALOR DISPONIBLE REDEBAN : " + valorDisponible);
			System.out.println("Total Daviplata: " + valorTotalApp + " Total RBM: " + valorTotal);
			BigDecimal BigvalorDispTotal = (valorDisponible.add(valorTotal)).divide(new BigDecimal(2));
			BigvalorDispTotal = BigvalorDispTotal.setScale(2, RoundingMode.HALF_UP);

			String valorLigeramenteInferior = valorTotal.toBigInteger().toString();
			String valorInferior = BigvalorDispTotal.toBigInteger().toString();
			String valorSuperior = valorTotal.add(new BigDecimal(2)).toBigInteger().toString();
			String valorMuySuperior = valorTotal.add(new BigDecimal(123456)).toBigInteger().toString();

			// --------------------------------------------------------------------------------------//
			System.out.println("valorInferior: " + valorInferior);
			System.out.println("valorLigeramenteInferior: " + valorLigeramenteInferior);
			System.out.println("valorSuperior: " + valorSuperior);
			System.out.println("valorMuySuperior: " + valorMuySuperior);
			// --------------------------------------------------------------------------------------//

			stepsPagar.ingresoAModuloPagar();
			stepsPagar.diligencioDatosDeUnaReferencia(empresaServicio, referencia);
			stepsPagar.ingresarValorYPagar(valorSuperior);
			stepsPagar.validoFondosInsuficientes07();

			stepsPagar.ingresoAModuloPagar();
			stepsPagar.diligencioDatosDeUnaReferencia(empresaServicio, referencia);
			stepsPagar.ingresarValorYPagar(valorMuySuperior);
			stepsPagar.validoFondosInsuficientes07();
		}

		@When("^pagar dos referencias fondo insuficiente \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
		public void pagarDosReferenciasFondoInsuficiente(String empresaServicio, String referencia, String referencia2) {
			String valorDisponibleRBM = origenCliente.getConsultaCupoTarjeta().getSaldoDisponible4x1000();
			valorDisponibleRBM = utilidad.quitarCaracter(valorDisponibleRBM, ".");
			valorDisponibleRBM = utilidad.quitarCaracter(valorDisponibleRBM, ",");
			BigDecimal valorDisponibleApp = pageHome.capturarSaldoInicial();
			Assert.assertEquals(valorDisponibleRBM, utilidad.quitarCaracter(valorDisponibleApp + "", "."));
			valorDisponibleRBM = utilidad.quitarDigitos(valorDisponibleRBM, 2);
			BigDecimal valorDisponible = new BigDecimal(valorDisponibleRBM);
			// ----Valor Total Redeban -------------//
			String valorTotalRBM = origenCliente.getConsultaCupoTarjeta().getTotalDisponible();
			valorTotalRBM = utilidad.quitarCaracter(valorTotalRBM, ".");
			valorTotalRBM = utilidad.quitarCaracter(valorTotalRBM, ",");
			valorTotalRBM = utilidad.quitarDigitos(valorTotalRBM, 2);
			BigDecimal valorTotalApp = pageHome.capturarSaldoInicialTotal();
			BigDecimal valorTotal = new BigDecimal(valorTotalRBM);
			System.out.println("VALOR TOTAL REDEBAN: " + valorTotal);
			System.out.println("VALOR DISPONIBLE REDEBAN : " + valorDisponible);
			System.out.println("Total Daviplata: " + valorTotalApp + " Total RBM: " + valorTotal);
			BigDecimal BigvalorDispTotal = (valorDisponible.add(valorTotal)).divide(new BigDecimal(2));
			BigvalorDispTotal = BigvalorDispTotal.setScale(2, RoundingMode.HALF_UP);

			String valorLigeramenteInferior = valorTotal.toBigInteger().toString();
			String valorInferior = BigvalorDispTotal.toBigInteger().toString();
			String valorSuperior = valorTotal.add(new BigDecimal(2)).toBigInteger().toString();
			String valorMuySuperior = valorTotal.add(new BigDecimal(123456)).toBigInteger().toString();

			// --------------------------------------------------------------------------------------//
			System.out.println("valorInferior: " + valorInferior);
			System.out.println("valorLigeramenteInferior: " + valorLigeramenteInferior);
			System.out.println("valorSuperior: " + valorSuperior);
			System.out.println("valorMuySuperior: " + valorMuySuperior);
			// --------------------------------------------------------------------------------------//

			/*stepsPagar.ingresoAModuloPagar();
			stepsPagar.diligencioDatosDeDosReferencias(empresaServicio, referencia, referencia2);
			stepsPagar.ingresarValorYPagar(valorInferior);
			stepsPagar.validoFondosInsuficientes07();

			stepsPagar.ingresoAModuloPagar();
			stepsPagar.diligencioDatosDeDosReferencias(empresaServicio, referencia, referencia2);
			stepsPagar.ingresarValorYPagar(valorLigeramenteInferior);
			stepsPagar.validoFondosInsuficientes07();*/

			stepsPagar.ingresoAModuloPagar();
			stepsPagar.diligencioDatosDeDosReferencias(empresaServicio, referencia, referencia2);
			stepsPagar.ingresarValorYPagar(valorSuperior);
			stepsPagar.validoFondosInsuficientes07();

			stepsPagar.ingresoAModuloPagar();
			stepsPagar.diligencioDatosDeDosReferencias(empresaServicio, referencia, referencia2);
			stepsPagar.ingresarValorYPagar(valorMuySuperior);
			stepsPagar.validoFondosInsuficientes07();

		}

		@When("^pagar dos referencias excede cupo \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
		public void pagarDosReferenciasExcedeCupo(String empresaServicio, String referencia, String referencia2) {
			String valorDisponibleRBM = origenCliente.getConsultaCupoTarjeta().getSaldoDisponible4x1000();
			valorDisponibleRBM = utilidad.quitarCaracter(valorDisponibleRBM, ".");
			valorDisponibleRBM = utilidad.quitarCaracter(valorDisponibleRBM, ",");
			BigDecimal valorDisponibleApp = pageHome.capturarSaldoInicial();
			Assert.assertEquals(valorDisponibleRBM, utilidad.quitarCaracter(valorDisponibleApp + "", "."));
			valorDisponibleRBM = utilidad.quitarDigitos(valorDisponibleRBM, 2);
			BigDecimal valorDisponible = new BigDecimal(valorDisponibleRBM);
			// ----Valor Total Redeban -------------//
			String valorTotalRBM = origenCliente.getConsultaCupoTarjeta().getTotalDisponible();
			valorTotalRBM = utilidad.quitarCaracter(valorTotalRBM, ".");
			valorTotalRBM = utilidad.quitarCaracter(valorTotalRBM, ",");
			valorTotalRBM = utilidad.quitarDigitos(valorTotalRBM, 2);
			BigDecimal valorTotalApp = pageHome.capturarSaldoInicialTotal();
			BigDecimal valorTotal = new BigDecimal(valorTotalRBM);
			System.out.println("VALOR TOTAL REDEBAN: " + valorTotal);
			System.out.println("VALOR DISPONIBLE REDEBAN : " + valorDisponible);
			System.out.println("Total Daviplata: " + valorTotalApp + " Total RBM: " + valorTotal);
			BigDecimal BigvalorDispTotal = (valorDisponible.add(valorTotal)).divide(new BigDecimal(2));
			BigvalorDispTotal = BigvalorDispTotal.setScale(2, RoundingMode.HALF_UP);

			String valorLigeramenteInferior = valorTotal.toBigInteger().toString();
			String valorInferior = BigvalorDispTotal.toBigInteger().toString();
			String valorSuperior = valorTotal.add(new BigDecimal(2)).toBigInteger().toString();
			String valorMuySuperior = valorTotal.add(new BigDecimal(123456)).toBigInteger().toString();

			// --------------------------------------------------------------------------------------//
			System.out.println("valorInferior: " + valorInferior);
			System.out.println("valorLigeramenteInferior: " + valorLigeramenteInferior);
			System.out.println("valorSuperior: " + valorSuperior);
			System.out.println("valorMuySuperior: " + valorMuySuperior);
			// --------------------------------------------------------------------------------------//

			stepsPagar.ingresoAModuloPagar();
			stepsPagar.diligencioDatosDeDosReferencias(empresaServicio, referencia, referencia2);
			stepsPagar.ingresarValorYPagar(valorSuperior);
			stepsPagar.validoFondosInsuficientes07();

			stepsPagar.ingresoAModuloPagar();
			stepsPagar.diligencioDatosDeDosReferencias(empresaServicio, referencia, referencia2);
			stepsPagar.ingresarValorYPagar(valorMuySuperior);
			stepsPagar.validoFondosInsuficientes07();
		}

		@When("^transar recarga prepago fondo insuficiente \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
		public void transarRecargaPrepagoFondoInsuficiente(String tipoRecarga, String empresaOperador,
				String numReferencia) {
			String valorDisponibleRBM = origenCliente.getConsultaCupoTarjeta().getSaldoDisponible4x1000();
			valorDisponibleRBM = utilidad.quitarCaracter(valorDisponibleRBM, ".");
			valorDisponibleRBM = utilidad.quitarCaracter(valorDisponibleRBM, ",");
			BigDecimal valorDisponibleApp = pageHome.capturarSaldoInicial();
			Assert.assertEquals(valorDisponibleRBM, utilidad.quitarCaracter(valorDisponibleApp + "", "."));
			valorDisponibleRBM = utilidad.quitarDigitos(valorDisponibleRBM, 2);
			BigDecimal valorDisponible = new BigDecimal(valorDisponibleRBM);
			// ----Valor Total Redeban -------------//
			String valorTotalRBM = origenCliente.getConsultaCupoTarjeta().getTotalDisponible();
			valorTotalRBM = utilidad.quitarCaracter(valorTotalRBM, ".");
			valorTotalRBM = utilidad.quitarCaracter(valorTotalRBM, ",");
			valorTotalRBM = utilidad.quitarDigitos(valorTotalRBM, 2);
			BigDecimal valorTotalApp = pageHome.capturarSaldoInicialTotal();
			BigDecimal valorTotal = new BigDecimal(valorTotalRBM);
			System.out.println("VALOR TOTAL REDEBAN: " + valorTotal);
			System.out.println("VALOR DISPONIBLE REDEBAN : " + valorDisponible);
			System.out.println("Total Daviplata: " + valorTotalApp + " Total RBM: " + valorTotal);
			BigDecimal BigvalorDispTotal = (valorDisponible.add(valorTotal)).divide(new BigDecimal(2));
			BigvalorDispTotal = BigvalorDispTotal.setScale(2, RoundingMode.HALF_UP);

			String valorLigeramenteInferior = valorTotal.toBigInteger().toString();
			String valorInferior = BigvalorDispTotal.toBigInteger().toString();
			String valorSuperior = valorTotal.add(new BigDecimal(2)).toBigInteger().toString();
			String valorMuySuperior = valorTotal.add(new BigDecimal(123456)).toBigInteger().toString();

			// --------------------------------------------------------------------------------------//
			System.out.println("valorInferior: " + valorInferior);
			System.out.println("valorLigeramenteInferior: " + valorLigeramenteInferior);
			System.out.println("valorSuperior: " + valorSuperior);
			System.out.println("valorMuySuperior: " + valorMuySuperior);
			// --------------------------------------------------------------------------------------//

			stepsRecarga.seleccionarRecargaVirual();
			stepsRecarga.selecccionarTipoRecarga();
			stepsRecarga.diligenciarDatosRecargaCelularFondosInsuficientes(numReferencia, valorInferior, empresaOperador);
			stepsRecarga.validoTransaccionRechazada();

			stepsRecarga.seleccionarRecargaVirual();
			stepsRecarga.selecccionarTipoRecarga();
			stepsRecarga.diligenciarDatosRecargaCelularFondosInsuficientes(numReferencia, valorLigeramenteInferior,
					empresaOperador);
			stepsRecarga.validoTransaccionRechazada();

			stepsRecarga.seleccionarRecargaVirual();
			stepsRecarga.selecccionarTipoRecarga();
			stepsRecarga.diligenciarDatosRecargaCelularFondosInsuficientes(numReferencia, valorSuperior, empresaOperador);
			stepsRecarga.validoTransaccionRechazada();

			stepsRecarga.seleccionarRecargaVirual();
			stepsRecarga.selecccionarTipoRecarga();
			stepsRecarga.diligenciarDatosRecargaCelularFondosInsuficientes(numReferencia, valorMuySuperior,
					empresaOperador);
			stepsRecarga.validoTransaccionRechazada();
		}

		@When("^transar recarga prepago fondo excede cupo \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
		public void transarRecargaPrepagoFondoExcedeCupo(String tipoRecarga, String empresaOperador, String numReferencia) {
			String valorDisponibleRBM = origenCliente.getConsultaCupoTarjeta().getSaldoDisponible4x1000();
			valorDisponibleRBM = utilidad.quitarCaracter(valorDisponibleRBM, ".");
			valorDisponibleRBM = utilidad.quitarCaracter(valorDisponibleRBM, ",");
			BigDecimal valorDisponibleApp = pageHome.capturarSaldoInicial();
			Assert.assertEquals(valorDisponibleRBM, utilidad.quitarCaracter(valorDisponibleApp + "", "."));
			valorDisponibleRBM = utilidad.quitarDigitos(valorDisponibleRBM, 2);
			BigDecimal valorDisponible = new BigDecimal(valorDisponibleRBM);
			// ----Valor Total Redeban -------------//
			String valorTotalRBM = origenCliente.getConsultaCupoTarjeta().getTotalDisponible();
			valorTotalRBM = utilidad.quitarCaracter(valorTotalRBM, ".");
			valorTotalRBM = utilidad.quitarCaracter(valorTotalRBM, ",");
			valorTotalRBM = utilidad.quitarDigitos(valorTotalRBM, 2);
			BigDecimal valorTotalApp = pageHome.capturarSaldoInicialTotal();
			BigDecimal valorTotal = new BigDecimal(valorTotalRBM);
			System.out.println("VALOR TOTAL REDEBAN: " + valorTotal);
			System.out.println("VALOR DISPONIBLE REDEBAN : " + valorDisponible);
			System.out.println("Total Daviplata: " + valorTotalApp + " Total RBM: " + valorTotal);
			BigDecimal BigvalorDispTotal = (valorDisponible.add(valorTotal)).divide(new BigDecimal(2));
			BigvalorDispTotal = BigvalorDispTotal.setScale(2, RoundingMode.HALF_UP);

			String valorLigeramenteInferior = valorTotal.toBigInteger().toString();
			String valorInferior = BigvalorDispTotal.toBigInteger().toString();
			String valorSuperior = valorTotal.add(new BigDecimal(2)).toBigInteger().toString();
			String valorMuySuperior = valorTotal.add(new BigDecimal(123456)).toBigInteger().toString();

			// --------------------------------------------------------------------------------------//
			System.out.println("valorInferior: " + valorInferior);
			System.out.println("valorLigeramenteInferior: " + valorLigeramenteInferior);
			System.out.println("valorSuperior: " + valorSuperior);
			System.out.println("valorMuySuperior: " + valorMuySuperior);
			// --------------------------------------------------------------------------------------//

			stepsRecarga.seleccionarRecargaVirual();
			//stepsRecarga.selecccionarTipoRecarga();
			stepsRecarga.diligenciarDatosRecargaCelularFondosInsuficientes(numReferencia, valorSuperior, empresaOperador);
			stepsRecarga.validoTransaccionRechazada();

			stepsRecarga.seleccionarRecargaVirual();
			stepsRecarga.selecccionarTipoRecarga();
			stepsRecarga.diligenciarDatosRecargaCelularFondosInsuficientes(numReferencia, valorMuySuperior, empresaOperador);
			stepsRecarga.validoTransaccionRechazada();
		}

		@When("^sacar plata fondo insuficiente$")
		public void sacarPlataFondoInsuficiente() {
			String valorDisponibleRBM = origenCliente.getConsultaCupoTarjeta().getSaldoDisponible4x1000();
			valorDisponibleRBM = utilidad.quitarCaracter(valorDisponibleRBM, ".");
			valorDisponibleRBM = utilidad.quitarCaracter(valorDisponibleRBM, ",");
			BigDecimal valorDisponibleApp = pageHome.capturarSaldoInicial();
			Assert.assertEquals(valorDisponibleRBM, utilidad.quitarCaracter(valorDisponibleApp + "", "."));
			valorDisponibleRBM = utilidad.quitarDigitos(valorDisponibleRBM, 2);
			BigDecimal valorDisponible = new BigDecimal(valorDisponibleRBM);
			// ----Valor Total Redeban -------------//
			String valorTotalRBM = origenCliente.getConsultaCupoTarjeta().getTotalDisponible();
			valorTotalRBM = utilidad.quitarCaracter(valorTotalRBM, ".");
			valorTotalRBM = utilidad.quitarCaracter(valorTotalRBM, ",");
			valorTotalRBM = utilidad.quitarDigitos(valorTotalRBM, 2);
			BigDecimal valorTotalApp = pageHome.capturarSaldoInicialTotal();
			BigDecimal valorTotal = new BigDecimal(valorTotalRBM);
			System.out.println("VALOR TOTAL REDEBAN: " + valorTotal);
			System.out.println("VALOR DISPONIBLE REDEBAN : " + valorDisponible);
			System.out.println("Total Daviplata: " + valorTotalApp + " Total RBM: " + valorTotal);

			//String valorLigeramenteInferior = Utilidades.prepararNumeroEnteroMultiplo10000(valorTotal);
			//String valorSuperior = Utilidades.prepararNumeroEnteroMultiplo10000(valorTotal.add(new BigDecimal(10000)));
			//String valorMuySuperior = Utilidades.prepararNumeroEnteroMultiplo10000(valorTotal.add(new BigDecimal(20000)));
			// --------------------------------------------------------------------------------------//
			//System.out.println("valorLigeramenteInferior: " + valorLigeramenteInferior);
			//System.out.println("valorSuperior: " + valorSuperior);
			//System.out.println("valorMuySuperior: " + valorMuySuperior);
			// --------------------------------------------------------------------------------------//

			//assertEquals("La cuenta de origen no puede tener un saldo superior a los 720000",
			//		Utilidades.esMenorIgual(valorMuySuperior, "720000"), true);

			/*stepsSacarPlata.seleccionarModuloSacarPlata();
			stepsSacarPlata.diligenciarSacarPlataMontoDiferente(valorLigeramenteInferior);
			stepsSacarPlata.pulsarContinuar();
			stepsSacarPlata.validoFondosInsuficientes();*/

			stepsSacarPlata.seleccionarModuloSacarPlata();
			//stepsSacarPlata.diligenciarSacarPlataMontoDiferente(valorSuperior);
			stepsSacarPlata.pulsarContinuar();
			stepsSacarPlata.validoExcedeCupo();

			stepsSacarPlata.seleccionarModuloSacarPlata();
			//stepsSacarPlata.diligenciarSacarPlataMontoDiferente(valorMuySuperior);
			stepsSacarPlata.pulsarContinuar();
			stepsSacarPlata.validoExcedeCupo();
		}

		@When("^sacar plata excede cupo$")
		public void sacarPlataExcedeCupo() {
			String valorDisponibleRBM = origenCliente.getConsultaCupoTarjeta().getSaldoDisponible4x1000();
			valorDisponibleRBM = utilidad.quitarCaracter(valorDisponibleRBM, ".");
			valorDisponibleRBM = utilidad.quitarCaracter(valorDisponibleRBM, ",");
			BigDecimal valorDisponibleApp = pageHome.capturarSaldoInicial();
			Assert.assertEquals(valorDisponibleRBM, utilidad.quitarCaracter(valorDisponibleApp + "", "."));
			valorDisponibleRBM = utilidad.quitarDigitos(valorDisponibleRBM, 2);
			BigDecimal valorDisponible = new BigDecimal(valorDisponibleRBM);
			// ----Valor Total Redeban -------------//
			String valorTotalRBM = origenCliente.getConsultaCupoTarjeta().getTotalDisponible();
			valorTotalRBM = utilidad.quitarCaracter(valorTotalRBM, ".");
			valorTotalRBM = utilidad.quitarCaracter(valorTotalRBM, ",");
			valorTotalRBM = utilidad.quitarDigitos(valorTotalRBM, 2);
			BigDecimal valorTotalApp = pageHome.capturarSaldoInicialTotal();
			BigDecimal valorTotal = new BigDecimal(valorTotalRBM);
			System.out.println("VALOR TOTAL REDEBAN: " + valorTotal);
			System.out.println("VALOR DISPONIBLE REDEBAN : " + valorDisponible);
			System.out.println("Total Daviplata: " + valorTotalApp + " Total RBM: " + valorTotal);

			//String valorSuperior = Utilidades.prepararNumeroEnteroMultiplo10000(valorTotal.add(new BigDecimal(10000)));
			//String valorMuySuperior = Utilidades.prepararNumeroEnteroMultiplo10000(valorTotal.add(new BigDecimal(20000)));
			// --------------------------------------------------------------------------------------//
			//System.out.println("valorSuperior: " + valorSuperior);
			//System.out.println("valorMuySuperior: " + valorMuySuperior);
			// --------------------------------------------------------------------------------------//

			//assertEquals("La cuenta de origen no puede tener un saldo superior a los 720000",
			//		Utilidades.esMenorIgual(valorMuySuperior, "720000"), true);

			stepsSacarPlata.seleccionarModuloSacarPlata();
			//stepsSacarPlata.diligenciarSacarPlataMontoDiferente(valorSuperior);
			stepsSacarPlata.pulsarContinuar();
			stepsSacarPlata.validoExcedeCupo();

			stepsSacarPlata.seleccionarModuloSacarPlata();
			//stepsSacarPlata.diligenciarSacarPlataMontoDiferente(valorMuySuperior);
			stepsSacarPlata.pulsarContinuar();
			stepsSacarPlata.validoExcedeCupo();
		}

		@When("^transar con QR fondo insuficiente$")
		public void transarConQRFondoInsuficiente() {
			String valorDisponibleRBM = origenCliente.getConsultaCupoTarjeta().getSaldoDisponible4x1000();
			valorDisponibleRBM = utilidad.quitarCaracter(valorDisponibleRBM, ".");
			valorDisponibleRBM = utilidad.quitarCaracter(valorDisponibleRBM, ",");
			BigDecimal valorDisponibleApp = pageHome.capturarSaldoInicial();
			Assert.assertEquals(valorDisponibleRBM, utilidad.quitarCaracter(valorDisponibleApp + "", "."));
			valorDisponibleRBM = utilidad.quitarDigitos(valorDisponibleRBM, 2);
			BigDecimal valorDisponible = new BigDecimal(valorDisponibleRBM);
			// ----Valor Total Redeban -------------//
			String valorTotalRBM = origenCliente.getConsultaCupoTarjeta().getTotalDisponible();
			valorTotalRBM = utilidad.quitarCaracter(valorTotalRBM, ".");
			valorTotalRBM = utilidad.quitarCaracter(valorTotalRBM, ",");
			valorTotalRBM = utilidad.quitarDigitos(valorTotalRBM, 2);
			BigDecimal valorTotalApp = pageHome.capturarSaldoInicialTotal();
			BigDecimal valorTotal = new BigDecimal(valorTotalRBM);
			System.out.println("VALOR TOTAL REDEBAN: " + valorTotal);
			System.out.println("VALOR DISPONIBLE REDEBAN : " + valorDisponible);
			System.out.println("Total Daviplata: " + valorTotalApp + " Total RBM: " + valorTotal);
			BigDecimal BigvalorDispTotal = (valorDisponible.add(valorTotal)).divide(new BigDecimal(2));
			BigvalorDispTotal = BigvalorDispTotal.setScale(2, RoundingMode.HALF_UP);

			String valorLigeramenteInferior = valorTotal.toBigInteger().toString();
			String valorInferior = BigvalorDispTotal.toBigInteger().toString();
			String valorSuperior = valorTotal.add(new BigDecimal(2)).toBigInteger().toString();
			String valorMuySuperior = valorTotal.add(new BigDecimal(123456)).toBigInteger().toString();

			// --------------------------------------------------------------------------------------//
			System.out.println("valorInferior: " + valorInferior);
			System.out.println("valorLigeramenteInferior: " + valorLigeramenteInferior);
			System.out.println("valorSuperior: " + valorSuperior);
			System.out.println("valorMuySuperior: " + valorMuySuperior);
			// --------------------------------------------------------------------------------------//

		
		}

		@When("^transar con QR excede cupo$")
		public void transarConQRExcedeCupo() {
			String valorDisponibleRBM = origenCliente.getConsultaCupoTarjeta().getSaldoDisponible4x1000();
			valorDisponibleRBM = utilidad.quitarCaracter(valorDisponibleRBM, ".");
			valorDisponibleRBM = utilidad.quitarCaracter(valorDisponibleRBM, ",");
			BigDecimal valorDisponibleApp = pageHome.capturarSaldoInicial();
			Assert.assertEquals(valorDisponibleRBM, utilidad.quitarCaracter(valorDisponibleApp + "", "."));
			valorDisponibleRBM = utilidad.quitarDigitos(valorDisponibleRBM, 2);
			BigDecimal valorDisponible = new BigDecimal(valorDisponibleRBM);
			// ----Valor Total Redeban -------------//
			String valorTotalRBM = origenCliente.getConsultaCupoTarjeta().getTotalDisponible();
			valorTotalRBM = utilidad.quitarCaracter(valorTotalRBM, ".");
			valorTotalRBM = utilidad.quitarCaracter(valorTotalRBM, ",");
			valorTotalRBM = utilidad.quitarDigitos(valorTotalRBM, 2);
			BigDecimal valorTotalApp = pageHome.capturarSaldoInicialTotal();
			BigDecimal valorTotal = new BigDecimal(valorTotalRBM);
			System.out.println("VALOR TOTAL REDEBAN: " + valorTotal);
			System.out.println("VALOR DISPONIBLE REDEBAN : " + valorDisponible);
			System.out.println("Total Daviplata: " + valorTotalApp + " Total RBM: " + valorTotal);
			BigDecimal BigvalorDispTotal = (valorDisponible.add(valorTotal)).divide(new BigDecimal(2));
			BigvalorDispTotal = BigvalorDispTotal.setScale(2, RoundingMode.HALF_UP);

			String valorLigeramenteInferior = valorTotal.toBigInteger().toString();
			String valorInferior = BigvalorDispTotal.toBigInteger().toString();
			String valorSuperior = valorTotal.add(new BigDecimal(2)).toBigInteger().toString();
			String valorMuySuperior = valorTotal.add(new BigDecimal(123456)).toBigInteger().toString();

			// --------------------------------------------------------------------------------------//
			System.out.println("valorInferior: " + valorInferior);
			System.out.println("valorLigeramenteInferior: " + valorLigeramenteInferior);
			System.out.println("valorSuperior: " + valorSuperior);
			System.out.println("valorMuySuperior: " + valorMuySuperior);
			// --------------------------------------------------------------------------------------//

			
		}
		@When("^realizo sacar plata con GMF$")
		public void realizoSacarPlataConGMF() {
			String saldoTotal = Serenity.sessionVariableCalled("saldoTarjeta");
			saldoTotal = saldoTotal.replace(",", "").replace(".", "").replace("'", "");
			saldoTotal = saldoTotal.substring(0, (saldoTotal.length()-2));
			BigDecimal valorTotal = new BigDecimal(saldoTotal);
			String valorSuperior = valorTotal.add(new BigDecimal(10000)).toBigInteger().toString();
			
			stepsSacarPlata.seleccionarModuloSacarPlata();
			stepsSacarPlata.diligenciarSacarPlataMontoDiferente("720000");
			stepsSacarPlata.pulsarContinuar();
			
			stepsSacarPlata.mensajeExcedeCupo();
		}
		
		@When("^realizo sacar plata sin GMF$")
		public void realizoSacarPlataSinGMF() {
			stepsSacarPlata.seleccionarModuloSacarPlata();
			stepsSacarPlata.diligenciarSacarPlataMontoDiferente("720000");
			stepsSacarPlata.pulsarContinuar();
			
			stepsSacarPlata.mensajeExcedeCupo();
		}
		

		@When("^transar recarga tarjeta fondo insuficiente$")
		public void transarRecargaTarjetaFondoInsuficiente() {
			String valorDisponibleRBM = origenCliente.getConsultaCupoTarjeta().getSaldoDisponible4x1000();
			valorDisponibleRBM = utilidad.quitarCaracter(valorDisponibleRBM, ".");
			valorDisponibleRBM = utilidad.quitarCaracter(valorDisponibleRBM, ",");
			BigDecimal valorDisponibleApp = pageHome.capturarSaldoInicial();
			Assert.assertEquals(valorDisponibleRBM, utilidad.quitarCaracter(valorDisponibleApp + "", "."));
			valorDisponibleRBM = utilidad.quitarDigitos(valorDisponibleRBM, 2);
			BigDecimal valorDisponible = new BigDecimal(valorDisponibleRBM);
			// ----Valor Total Redeban -------------//
			String valorTotalRBM = origenCliente.getConsultaCupoTarjeta().getTotalDisponible();
			valorTotalRBM = utilidad.quitarCaracter(valorTotalRBM, ".");
			valorTotalRBM = utilidad.quitarCaracter(valorTotalRBM, ",");
			valorTotalRBM = utilidad.quitarDigitos(valorTotalRBM, 2);
			BigDecimal valorTotalApp = pageHome.capturarSaldoInicialTotal();
			BigDecimal valorTotal = new BigDecimal(valorTotalRBM);
			System.out.println("VALOR TOTAL REDEBAN: " + valorTotal);
			System.out.println("VALOR DISPONIBLE REDEBAN : " + valorDisponible);
			System.out.println("Total Daviplata: " + valorTotalApp + " Total RBM: " + valorTotal);
			BigDecimal BigvalorDispTotal = (valorDisponible.add(valorTotal)).divide(new BigDecimal(2));
			BigvalorDispTotal = BigvalorDispTotal.setScale(2, RoundingMode.HALF_UP);

			String valorLigeramenteInferior = valorTotal.toBigInteger().toString();
			String valorInferior = BigvalorDispTotal.toBigInteger().toString();
			String valorSuperior = valorTotal.add(new BigDecimal(2)).toBigInteger().toString();
			String valorMuySuperior = valorTotal.add(new BigDecimal(123456)).toBigInteger().toString();

			// --------------------------------------------------------------------------------------//
			System.out.println("valorInferior: " + valorInferior);
			System.out.println("valorLigeramenteInferior: " + valorLigeramenteInferior);
			System.out.println("valorSuperior: " + valorSuperior);
			System.out.println("valorMuySuperior: " + valorMuySuperior);
			// --------------------------------------------------------------------------------------//

			/*stepsEcard.ingresoATarjetaDeCredito(true);
			stepsEcard.seleccionoRecargar();
			stepsEcard.recargoTarjetaFondoInsuficiente(valorInferior);
			stepsEcard.validoNoAlcanzaPlata(2);

			stepsEcard.ingresoATarjetaDeCredito(false);
			stepsEcard.seleccionoRecargar();
			stepsEcard.recargoTarjetaFondoInsuficiente(valorLigeramenteInferior);
			stepsEcard.validoNoAlcanzaPlata(2);*/

			stepsEcard.ingresoATarjetaDeCredito(true);
			stepsEcard.seleccionoRecargar();
			stepsEcard.recargoTarjetaFondoInsuficiente(valorSuperior);
			stepsEcard.validoNoAlcanzaPlata(2);

			stepsEcard.ingresoATarjetaDeCredito(false);
			stepsEcard.seleccionoRecargar();
			stepsEcard.recargoTarjetaFondoInsuficiente(valorMuySuperior);
			stepsEcard.validoNoAlcanzaPlata(2);

		}

		@When("^transar recarga tarjeta excede cupo$")
		public void transarRecargaTarjetaExcedeCupo() {
			// -----Valor Disponible redeban ---------//
			String valorDisponibleRBM = origenCliente.getConsultaCupoTarjeta().getSaldoDisponible4x1000();
			valorDisponibleRBM = utilidad.quitarCaracter(valorDisponibleRBM, ".");
			valorDisponibleRBM = utilidad.quitarCaracter(valorDisponibleRBM, ",");
			BigDecimal valorDisponibleApp = pageHome.capturarSaldoInicial();
			Assert.assertEquals(valorDisponibleRBM, utilidad.quitarCaracter(valorDisponibleApp + "", "."));
			valorDisponibleRBM = utilidad.quitarDigitos(valorDisponibleRBM, 2);
			BigDecimal valorDisponible = new BigDecimal(valorDisponibleRBM);
			// ----Valor Total Redeban -------------//
			String valorTotalRBM = origenCliente.getConsultaCupoTarjeta().getTotalDisponible();
			valorTotalRBM = utilidad.quitarCaracter(valorTotalRBM, ".");
			valorTotalRBM = utilidad.quitarCaracter(valorTotalRBM, ",");
			valorTotalRBM = utilidad.quitarDigitos(valorTotalRBM, 2);
			BigDecimal valorTotalApp = pageHome.capturarSaldoInicialTotal();
			BigDecimal valorTotal = new BigDecimal(valorTotalRBM);
			System.out.println("VALOR TOTAL REDEBAN: " + valorTotal);
			System.out.println("VALOR DISPONIBLE REDEBAN : " + valorDisponible);
			System.out.println("Total Daviplata: " + valorTotalApp + " Total RBM: " + valorTotal);
			BigDecimal BigvalorDispTotal = (valorDisponible.add(valorTotal)).divide(new BigDecimal(2));
			BigvalorDispTotal = BigvalorDispTotal.setScale(2, RoundingMode.HALF_UP);

			String valorLigeramenteInferior = valorTotal.toBigInteger().toString();
			String valorInferior = BigvalorDispTotal.toBigInteger().toString();
			String valorSuperior = valorTotal.add(new BigDecimal(2)).toBigInteger().toString();
			String valorMuySuperior = valorTotal.add(new BigDecimal(123456)).toBigInteger().toString();

			// --------------------------------------------------------------------------------------//
			System.out.println("valorInferior: " + valorInferior);
			System.out.println("valorLigeramenteInferior: " + valorLigeramenteInferior);
			System.out.println("valorSuperior: " + valorSuperior);
			System.out.println("valorMuySuperior: " + valorMuySuperior);
			// --------------------------------------------------------------------------------------//

			stepsEcard.ingresoATarjetaDeCredito(true);
			stepsEcard.seleccionoRecargarHome();
			stepsEcard.recargoTarjetaFondoInsuficiente(valorSuperior);
			stepsEcard.validoNoAlcanzaPlata(2);

			stepsEcard.ingresoATarjetaDeCredito(false);
			stepsEcard.seleccionoRecargarHome();
			stepsEcard.recargoTarjetaFondoInsuficiente(valorMuySuperior);
			stepsEcard.validoNoAlcanzaPlata(2);

		}
		
		@Given("^valido saldos redeban  \"([^\"]*)\"\"([^\"]*)\"$")
		public void validoSaldosRedeban(String usuario, String usuario2) throws Exception {
			stepsWebRedeban.loginWebRedeban();
			ConsultaClientes cco = stepsWebRedeban.consultaClientesWebRedeban(usuario);
			ConsultaCupoTarjeta ccto = stepsWebRedeban.consultaCuposTarjeta(cco.getNumeroTarjeta());
			origenCliente.setConsultaClientes(cco);
			origenCliente.setConsultaCupoTarjeta(ccto);
			ConsultaClientes ccd = stepsWebRedeban.consultaClientesWebRedeban(usuario2);
			ConsultaCupoTarjeta cctd = stepsWebRedeban.consultaCuposTarjeta(ccd.getNumeroTarjeta());
			destinoCliente.setConsultaClientes(ccd);
			destinoCliente.setConsultaCupoTarjeta(cctd); 
		}

}
