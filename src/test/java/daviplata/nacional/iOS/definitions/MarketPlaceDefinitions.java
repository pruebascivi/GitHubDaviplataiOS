package daviplata.nacional.iOS.definitions;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import daviplata.nacional.iOS.modelo.ConsultaCupoTarjeta;
import daviplata.nacional.iOS.steps.MarketPlaceSteps;
import daviplata.nacional.iOS.steps.PasarPlataSteps;
import daviplata.nacional.iOS.steps.WebRedebanSteps;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class MarketPlaceDefinitions {

	@Steps
	MarketPlaceSteps stepsMarket;
	BaseUtil base;
	@Steps
	WebRedebanSteps stepsWebRedeban;
	ArrayList<Float> saldos = new ArrayList<Float>();
	String numCelular = "";


	@When("^ingreso a tienda virtual$")
	public void ingresoATiendaVirtual() throws Exception {
		stepsMarket.btnMarketPlace();
	}
	
	@When("^ingreso al boton movilidad$")
	public void ingresoAlBotonMovilidad() throws Exception {
		stepsMarket.validarBtnMovilidad();
	}
	
	
	@When("^validar saldos por recarga$")
	public void validarSaldosPorRecarga() throws Exception {
		stepsMarket.validarSaldosRecarga();
	}
	
	@When("^validar mensaje saldo insuficiente$")
	public void validarMensajeSaldoInsuficiente() throws Exception {
		stepsMarket.validarMensajeSaldoInsuficiente();
	}
	
	@When("^validar boton inhabilitado$")
	public void validarBtnInhabilitado() throws Exception {
		stepsMarket.validarBtnInhabilitado();
	}
	
	
	@When("^diligenciar formulario claro \"([^\"]*)\" \"([^\"]*)\"$")
	public void completarFlujoDiligenciarClaro(String monto, String numero) throws Exception {
		stepsMarket.diligenciarDatosRecargaMinutos(monto, numero);
	}
	
	@When("^diligenciar formulario minutos \"([^\"]*)\" \"([^\"]*)\"$")
	public void completarFlujoDiligenciarMinutos(String monto, String numero) throws Exception {
		stepsMarket.diligenciarDatosRecargaMinutos(monto, numero);
	}
	
	@When("^diligenciar formulario minutos monto superior \"([^\"]*)\" \"([^\"]*)\"$")
	public void completarFlujoDiligenciarMinutosMontoSuperior(String monto, String numero) throws Exception {
		stepsMarket.diligenciarDatosRecargaMinutosMontoSuperior(monto, numero);
	}
	
	@When("^diligenciar formulario paquetes movistar \"([^\"]*)\"$")
	public void completarFlujoDiligenciarPaquetesMovistar(String numero) throws Exception {
		stepsMarket.diligenciarDatosRecargaPaquetes(numero);
	}
	
	@When("^diligenciar formulario paquetes movistar fondos insuficientes \"([^\"]*)\"$")
	public void completarFlujoDiligenciarPaquetesMovistarFondosInsuficientes(String numero) throws Exception {
		stepsMarket.diligenciarDatosRecargaPaquetesFondosInsuficientes(numero);
	}


	@When("^completar flujo comprar seguro \"([^\"]*)\" \"([^\"]*)\"$")
	public void completarFlujoComprarSeguro(String opcion, String genero) throws Exception {
		stepsMarket.btnSeguros();
		stepsMarket.btnSegurosVida(opcion, genero);
	}
	
	@When("^ingresar a seguros$")
	public void ingresar() throws Exception {
		stepsMarket.btnSeguros();
	}
	
	@When("^completar flujo comprar seguro bicicleta \"([^\"]*)\"$")
	public void completarFlujoComprarSeguroBicicleta(String opcion) throws Exception {
		stepsMarket.btnSeguros();
		stepsMarket.btnSeguroBicicleta(opcion);
	}

	@When("^ingresar a operador seleccionado \"([^\"]*)\"$")
	public void ingresarOperadorSeleccionado(String operador) throws Exception {
		stepsMarket.ingresarOpcionSeleccionada(operador);
	}
	
	@When("^completar flujo de recarga de paquetes \"([^\"]*)\" \"([^\"]*)\"$")
	public void completarFlujoDeRecargaPaquetes(String numeroVeces, String numero) throws Exception {
		for(int i = 0; i < Integer.parseInt(numeroVeces); i++) {
			stepsMarket.completoFlujoDeRecargaPaquetes(numero);	
		}
	}
	
	@Then("^validar compra de seguro$")
	public void validarCompraDeSeguro() throws Exception {
		stepsMarket.btnValidar();
	}

	@Then("^volver a capturar saldo final$")
	public void volverCapturarSaldoFinal() throws Exception {
		stepsMarket.flujoVolvercapturarSaldo();
	}

	
	@Then("^Completo flujo comprar seguro con fecha menor \"([^\"]*)\" \"([^\"]*)\"$")
	public void completoFlujoComprarSeguroConFechaMenor(String opcion, String genero) throws Exception {
		stepsMarket.btnSeguros();
		stepsMarket.btnSegurosVidaFechaMenor(opcion, genero);
	}

	@Then("^Valido mensaje$")
	public void validoMensaje() throws Exception {
		stepsMarket.validarMensaje();
	}

	@Then("^Complejo flujo de servicios \"([^\"]*)\" \"([^\"]*)\"$")
	public void complejoFlujoDeServicios(String opcion, String referencia) throws Exception {
		if (opcion.equalsIgnoreCase("Gas")) {
			stepsMarket.ingresarGas();
			stepsMarket.ingresarGasFlujo(referencia, "gas natural");
		} else {
			stepsMarket.ingresarMinutos();
			stepsMarket.ingresarGasFlujo(referencia, opcion);

		}

	}

	@Then("^Valido transaccion$")
	public void validoTransaccion() throws Exception {
		stepsMarket.btnValidarGas();
	}

	@Then("^Completo flujo comprar seguro mascota \"([^\"]*)\" \"([^\"]*)\"$")
	public void completoFlujoComprarSeguroMascota(String opcion, String raza) throws Exception {
		stepsMarket.btnSeguroMascota(opcion, raza);
	}

	@Then("^Completo flujo comprar seguro mascota volver atras \"([^\"]*)\" \"([^\"]*)\"$")
	public void completoFlujoComprarSeguroMascotaVolverAtras(String opcion, String raza) throws Exception {
		stepsMarket.btnSeguroMascotaVolver(opcion, raza);
	}

	@Then("^Completo flujo comprar seguro bicicleta \"([^\"]*)\"$")
	public void completoFlujoComprarSeguroBicicleta(String opcion) throws Exception {
		stepsMarket.btnSeguroBicicleta(opcion);
	}

	@Then("^Complejo flujo de otros servicios \"([^\"]*)\" \"([^\"]*)\"$")
	public void complejoFlujoDeOtrosServicios(String opcion, String referencia) throws Exception {
		stepsMarket.ingresarOtrosServicios(referencia, opcion);
	}

	@Then("^Complejo flujo de otros servicios referencia errada \"([^\"]*)\" \"([^\"]*)\"$")
	public void complejoFlujoDeOtrosServiciosReferenciaErrada(String opcion, String referencia) throws Exception {
		stepsMarket.ingresarOtrosServiciosReferenciaErrada(referencia, opcion);
		;
	}

	@Then("^Valido transaccion rechazada$")
	public void validoTransaccionRechazada() throws Exception {
		stepsMarket.validarReferenciaErrada();
	}

	@When("^validar salida de tienda virtual$")
	public void validarSalidaDeTiendaVirtual() throws Exception {
		stepsMarket.validarSalidaDaviplata();
	}

	@Then("^Completo el flujo compra Bono con correo$")
	public void completoElFlujoCompraBonoConCorreo() throws Exception {
		stepsMarket.ingresarBono();
	}

	@Then("^completo flujo descuento mcDonals$")
	public void completoFlujoDescuentoMcDonals() throws Exception {
		stepsMarket.ingresarDescuentosMc();
	}

	@Then("^Completo el flujo compra Bono con correo y validar Necesito ayuda$")
	public void completoElFlujoCompraBonoConCorreoYValidarNecesitoAyuda() throws Exception {
		stepsMarket.ingresarBonoYValidarNecesitoAyuda();
	}
	
	@Then("^Completo el flujo pago de servicio y validar necesito ayuda$")
	public void completoElFlujoPagoServiciosConCorreoYValidarNecesitoAyuda() throws Exception {
		stepsMarket.ingresarPagarYValidarNecesitoAyuda();
	}

	@Then("^Completo el flujo compra Bono sin correo$")
	public void completoElFlujoCompraBonoSinCorreo() throws Exception {
		stepsMarket.ingresarBonoSinCorreo();
	}

	@Then("^Valido la compra del bono$")
	public void validoLaCompraDelBono() throws Exception {
		stepsMarket.validarCompraBono();
	}

	@Then("^ingreso a descuentos$")
	public void ingresoADescuentos() throws Exception {
		stepsMarket.ingresarDescuentos();
	}

	@Then("^valido descuentos$")
	public void validoDescuentos() throws Exception {
		stepsMarket.validarDescuentos();
	}

	@Then("^completo flujo descuento donki$")
	public void completoFlujoDescuentoDonki() throws Exception {
		stepsMarket.ingresarDescuentosDunki();
	}

	@Then("^Valido aliados por categorias$")
	public void validoAliadosPorCategorias() throws Exception {
		stepsMarket.validarAliados();
	}

	@Then("^ingreso a donas$")
	public void ingresoADonas() throws Exception {
		stepsMarket.ingresarDonas();
	}

	@Then("^completo flujo donki$")
	public void completoFlujoDonki() throws Exception {
		stepsMarket.CompletarflujoDonas();
	}

	@Then("^flujo de compra validando volver$")
	public void flujoDeCompraValidandoVolver() throws Exception {
		stepsMarket.ValidarFlujoAtras();
	}

	@Then("^Validar crear negocio$")
	public void validarCrearNegocio() throws Exception {
		stepsMarket.validarCrearNegocio();
	}

	@Then("^Complejo flujo de servicios incorrecto \"([^\"]*)\" \"([^\"]*)\"$")
	public void complejoFlujoDeServiciosIncorrecto(String opcion, String referencia) throws Exception {
		stepsMarket.ingresarGasFlujoReferencia(referencia, opcion);
	}

	@Then("^Valido transaccion rechazada pago$")
	public void validarTransaccionRechazadaPago() throws Exception {
		stepsMarket.ingresarFlujoReferenciaRechazada();
	}

	@Then("^Completo flujo comprar seguro soat \"([^\"]*)\"$")
	public void completoFlujoComprarSeguroSoat(String placa) throws Exception {
		stepsMarket.btnSeguroSoat(placa);
	}

	@Then("^formulario soat$")
	public void formularioSoat() throws Exception {

	}

	@Then("^Completo flujo comprar seguro soat plata invalida \"([^\"]*)\" \"([^\"]*)\"$")
	public void completoFlujoComprarSeguroSoatPlataInvalida(String usuario, String placa) throws Exception {
		stepsMarket.btnSeguroSoatPlacaInvalida(usuario, placa);
	}
 
	@Then("^valido que soat invalido$")
	public void validoQueSoatInvalido() throws Exception {
		stepsMarket.validarMensajePlacaValida();
	}

	@And("^Validar en redeban seguros \"([^\"]*)\"$")
	public void validarEnRedebanSeguros(String cuenta) throws Exception {
		// base.idTransaccion = base.Autorizador;
		// base.ValorPoliza
		System.out.println("Base monto: "+  base.ValorPoliza);
		base.montoTrasadoRedeban = stepsWebRedeban.consultaDiaria3(cuenta,  base.ValorPoliza);
	}
	
	@Given("^Validar en redeban subtipo \"([^\"]*)\"\"([^\"]*)\"$")
	public void validarEnRedebanSubtipo(String cuenta,String subtipo) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	
		base.montoTrasadoRedeban = stepsWebRedeban.consultasubtipo(cuenta, subtipo);
	}
	

	//--------- Validar saldo en perfil negocio -----------//
	
	@When("^ingreso al perfil negocio$")
	public void ingresoAlPerfilNegocio() throws Exception {
		stepsMarket.ingresarPerfilNegocio();
	    
	}
	
	@Then("^validar saldo negocio$")
	public void validarSaldoNegocio() throws Exception {
		stepsMarket.validarSaldoPerfilNegocio();
	    
	}
	
	
	
	
	//------------------------------------------------------------------------------------------------------------------------------------------------------
	
	
	@Then("^Valido scroll horizontal categorias$")
	public void validoScrollHorizontalCategorias() throws Exception {
		stepsMarket.validoScrollHorizontalCategorias();	
		}
	
	@Then("^dar click btn \"([^\"]*)\"$")
	public void darClickBtn(String categoria) throws Exception {
		stepsMarket.realizarScroll(categoria);
		stepsMarket.darClickBtn(categoria);
	}
	
	@Then("^completo flujo comprar vestuario$")
	public void completoFlujoComprarVestuario() throws Exception {
		stepsMarket.completoFlujoComprarVestuario();
	}
	
	@Then("^completo flujo comprar cine$")
	public void completoFlujoComprarCine() throws Exception {
		stepsMarket.completoFlujoComprarCine();
	}
	
	@Given("^obtener numero celular actual en redeban marketplace \"([^\"]*)\"$")
	public void obtenerNumeroCelularActualEnRedeban(String usuario) throws Exception {
		numCelular = stepsWebRedeban.consultaNumeroCelular(usuario);
		assertNotNull(numCelular);
	}
	
	@Given("^consultar saldo tarjeta en redeban marketplace$")
	public void consultarSaldoTarjetaEnRedebanMarketplace() throws Exception {
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
	
	@Then("^validar igualdad saldos tarjetas marketplace$")
	public void validarIgualdadSaldosTarjetasMarketplace() throws Exception {
		boolean flag = false;
		int valorBono = Serenity.sessionVariableCalled("valorBono");
		int cantidadSaldos = saldos.size();
		if (cantidadSaldos == 4) {
			double sumaPrimeraTarjeta = saldos.get(0) + saldos.get(1);
			double sumaSegundaTarjeta = saldos.get(2) + saldos.get(3);
			
			if(sumaPrimeraTarjeta == sumaSegundaTarjeta) {
				System.out.println("La transaccion no afectó redeban");
			}else if((sumaSegundaTarjeta) == (sumaPrimeraTarjeta - valorBono)) {
				System.out.println("La transaccion  afectó redeban correctamente");
			}else {
				System.out.println("Hubo un error");
			}
		}else {
			System.out.println("No pude validar saldos");
		}
}
	
	
	@Given("^completo flujo validar btn descarga$")
	public void completarFlujoValidarBtnDescarga() throws Exception {
		stepsMarket.flujoValidarBtnDescarga();
	}
		
	@Given("^completo flujo validar btn compartir$")
	public void completarFlujoValidarBtnCompartir() throws Exception {
		stepsMarket.flujoValidarBtnCompartir();
	}
	
	@When("^validacion de saldo despues de las transacciones$")
	public void validarSaldoDespuesTransacciones() throws Exception {
		stepsMarket.validacionSaldoTransacciones();
	}
	
	@When("^llenar autorizadores test$")
	public void llenarAutorizadoresTest() throws Exception {
		stepsMarket.llenarAutorizadoresTest();
	}
	
	
	@When("^flujo crear negocio \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
	public void flujoCrearNegocio(String nombre, String queVende, String monto, String ciudadNegocio, String casa, String correo) throws Exception {
		stepsMarket.crearNegocio(nombre, queVende, monto, ciudadNegocio, casa, correo);
	}
	
	@Then("^Valido terminos marketplace$")
	public void validoTerminos() throws Exception {
		stepsMarket.validarTerminosCondicionesTiendaVirtual();
	}
	
	@Then("^Ingreso a opcion pagar$")
	public void ingresoAOpcionPagar() throws Exception {
		stepsMarket.clicOpcionPagar();
	}
	
	@Then("^Validar pestaña pagos de servicios$")
	public void validarPestañaPagosServicios() throws Exception {
		stepsMarket.validarPestañaPagos();
	}

	@When("^Ingreso a opcion recargas$")
	public void ingresoOpcionRecargas() throws Exception {
		stepsMarket.ingresarOpcionRecargas();
	}
	
	@Then("^Validar pestaña recargas$")
	public void validarPestañaRecargas() throws Exception {
		stepsMarket.validarPestañaRecargasTiendaVirtual();
	}
	
	@Then("^Validar que no aparezca terminos marketplace$")
	public void validarNoAparezcaTerminosMarketplace() throws Exception {
		stepsMarket.validarNoAparezcaTyCMarketPlace();
	}
	
	@When("^Comprar algo de los aliados$")
	public void ComprarAlgoDeLosAliados() throws Exception {
		stepsMarket.comprarProductoDeLosAliados();
	}
	
	@When("^Acepto terminos y condiciones$")
	public void aceptoTerminosCondiciones() throws Exception {
		stepsMarket.aceptarTerminosCondicionesTiendaVirtual();
	}
	
	@Then("^Valido que el bono quede en la campana y se pueda abrir$")
	public void validoBonoQuedeEnCampanaYPuedaAbrir() throws Exception {
		stepsMarket.validarBonoEnCampanaNotificaciones();
	}
	
	@Given("^Compro bono en tienda virtual$")
	public void comproBonoTiendavirtual() throws Exception {
		stepsMarket.comprarBono();
	}
	
	@Then("^Valido la compra del bono McDonals$")
	public void validoLaCompraDelBonoMcDonals() throws Exception {
		stepsMarket.validarCompraBonoMcDonals();
	}
	
	@Then("^Valido que la franja de Nuestro aliados se ve en la mitad$")
	public void validoFranjaEnLaMitad() throws Exception {
		stepsMarket.validarFranjaAliadosEnLaMitad();
	}
	
	@Then("^Valido que al hacer tap se evidencie la pantalla con sus categorías$")
	public void validoFranjaCategoriasAlHacerTap() throws Exception {
		stepsMarket.validarCategoriasAliadosAlHacerTap();
	}


	@Given("^Validar en redeban subtipo \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
	public void validarEnRedebanSubtipo(String cuenta,String subtipo, String celular) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	
		base.montoTrasadoRedeban = stepsWebRedeban.consultasubtipo(cuenta, subtipo, celular);
	}
	
	@Then("^Realizo compra de bono para compartir y descargar la compra$")
	public void realizoCompraDeBonoParaCompartirDescargarLaCompra() throws Exception {
		stepsMarket.flujoCompraBono();

	}
	
	@Then("^Validar opciones de compartir y descargar bono$")
	public void validarOpcionesDeCompartirDescargarBono() throws Exception {
		stepsMarket.validarOpcionesCompartirDescargarBono();

	}



}
