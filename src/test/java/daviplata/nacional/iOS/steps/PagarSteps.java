package daviplata.nacional.iOS.steps;

import java.math.BigDecimal;


import daviplata.nacional.iOS.pageObjects.HomePageObjects;
import daviplata.nacional.iOS.pageObjects.MenuHamburguesaPageObjects;
import daviplata.nacional.iOS.pageObjects.PagarPageObjects;
import daviplata.nacional.iOS.pageObjects.RecargaPageObjects;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import daviplata.nacional.iOS.utilidades.Utilidades;
import daviplata.nacional.iOS.utilidades.UtilidadesTCS;

public class PagarSteps {

	HomePageObjects pageHome;
	RecargaPageObjects recargarPageObjects;
	PagarPageObjects pagePagar;
	MenuHamburguesaPageObjects menuHamburguesaPageObjects;
	BigDecimal valorHome = null;
	BigDecimal valorTransferencia = null;
	String monto;
	Utilidades utilidades;
	BaseUtil base;
	UtilidadesTCS utilidadesTCS;

	public void ingresoAModuloPagar() {
		pageHome.capturarSaldoInicial();
		pageHome.darClickEnBotonMas();
		Utilidades.tomaEvidencia("Seleccionar opción Pagar");
		utilidadesTCS.clicElement("xpath", PagarPageObjects.BOTON_PAGAR);
		Utilidades.esperaMiliseg(4000);
		utilidadesTCS.esperarElementVisibility("xpath", PagarPageObjects.BOTON_TODOS_MARKETPLACE);
		Utilidades.tomaEvidencia("Dar clic en mas servicios");
		pageHome.darClickMasServicios();
	}

	public void ingresoAModuloPagarMarketPlaceServicioAgua() {
		pageHome.capturarSaldoInicial();
		Utilidades.tomaEvidencia("Seleccionar opción Pagar");
		pageHome.darClickBtnMas();
		pageHome.darClickBotonMarketPlace();
		pageHome.cerrarPopup();
		Utilidades.tomaEvidencia("Ingresar a Tienda Virtual");
		pageHome.darClickBtnAgua();
		Utilidades.tomaEvidencia("Ingresar a Servicio de agua");
		pageHome.seleccionarEPM();
		pageHome.clickBtnAceptar();
	}

	public void ingresoAModuloPagarMarketPlace() {
		pageHome.capturarSaldoInicial();
		Utilidades.tomaEvidencia("Seleccionar opción Pagar");
		Utilidades.tomaEvidencia("Seleccion de opción Escribir datos del recibo");
		pagePagar.darClickEnEscribirDatosDelRecibo();
	}

	public void diligencioDatosDeUnaReferencia(String empresaServicio, String referencia) {
		pagePagar.ingresoDatosDeEmpresa(empresaServicio);
		Utilidades.tomaEvidencia("Empresa buscada " + empresaServicio);
		pagePagar.darClickEnEmpresaEncontrada(empresaServicio);
		pagePagar.ingresarReferenciaUno(referencia);
		Utilidades.tomaEvidencia("Referencia de pago ingresada " + referencia);
		pagePagar.darClickEnContinuar();
	}

	public void diligencioDatosDeUnaReferenciaErrada(String empresaServicio, String referencia) {
		pagePagar.ingresoDatosDeEmpresa(empresaServicio);
		Utilidades.tomaEvidencia("Empresa buscada " + empresaServicio);
		pagePagar.darClickEnEmpresaEncontrada(empresaServicio);
		pagePagar.ingresarReferenciaUno("3243454");
		Utilidades.tomaEvidencia("Referencia de pago ingresada " + referencia);
		pagePagar.darClickEnContinuar();
	}

	public void ingresarReferencia(String referencia) {
		pagePagar.ingresarReferenciaUno(referencia);
		Utilidades.tomaEvidencia("Referencia de pago ingresada " + referencia);
		pagePagar.darClickEnContinuar();
	}

	public void ingresarValorYPagar(String valorTransaccion) {
		pagePagar.ingresarValorAPagar(valorTransaccion);
		Utilidades.tomaEvidencia("Valor a pagar " + valorTransaccion);
		pagePagar.darClickEnContinuar();
		pagePagar.darClickEnPagar();
	}

	public void pagar(String valorTransaccion) {
		Utilidades.esperaMiliseg(3000);
		pagePagar.valorAPagar(valorTransaccion);
		Utilidades.tomaEvidencia("Valor a pagar ");
		pagePagar.darClickEnContinuar();
		pagePagar.darClickEnPagar();
	}

	public void verificoTransaccionExitosaUnaRef(String empresaServicio, String referencia) {
		Utilidades.tomaEvidencia("popup");
		pagePagar.cerrarPopup();
		// pagePagar.validarEmpresa(empresaServicio);
		// pagePagar.validarReferenciaUno(referencia);
		// pagePagar.validarValorAPagar();
		Utilidades.tomaEvidencia("Transaccion Exitosa");
		pagePagar.txtAutorizador();
		pagePagar.darClickEnFinalizar();
	}

	public void verificoTransaccionExitosa(String referencia) {
		Utilidades.tomaEvidencia("popup");
		pagePagar.cerrarPopup();
		pagePagar.validarReferenciaUno(referencia);
		pagePagar.validarValorAPagar();
		Utilidades.tomaEvidencia("Transaccion Exitosa");
		pagePagar.txtAutorizador();
		pagePagar.darClickEnFinalizar();
	}

	public void verificoSaldoFinal() {
		// pageHome.darClickEnActualizarSaldo();
		pageHome.capturarSaldoFinal();
		// Utilidades.validacionDeSaldos();
		Utilidades.tomaEvidencia("Saldo Final" + BaseUtil.saldoFinal);
	}

	public void verificoTransaccionNegada() {
		pagePagar.validarNumDeReferenciaNoExiste();
		Utilidades.tomaEvidencia("Transacción Negada");
		pageHome.clickBotonAtras(4);
		Utilidades.esperaMiliseg(4000);
		pageHome.capturarSaldoFinal();
		Utilidades.tomaEvidencia("Validacion de saldo final");
	}

	public void diligencioDatosDeDosReferencias(String empresaServicio, String referencia, String referencia2) {
		pagePagar.ingresoDatosDeEmpresa(empresaServicio);
		Utilidades.tomaEvidencia("Empresa buscada " + empresaServicio);
		pagePagar.darClickEnEmpresaEncontrada(empresaServicio);
		pagePagar.ingresarReferenciaUno(referencia);
		pagePagar.ingresarReferenciaDos(referencia2);
		Utilidades.tomaEvidencia("Referencias de pago ingresada " + referencia + "-" + referencia2);
		pagePagar.darClickEnContinuar();

	}

	public void verificoTransaccionExitosaDosRef(String empresaServicio, String referencia, String referencia2) {
		Utilidades.tomaEvidencia("Transaccion Exitosa");
		pagePagar.txtAutorizador();
		pagePagar.darClickEnFinalizar();
	}

	public void validoFondosInsuficientes07() {
		pagePagar.validoLblFondosInsuficientes07();
		pageHome.clickBotonAtras(5);
		pageHome.darClickEnActualizarSaldo();
		pageHome.capturarSaldoFinal();
		Utilidades.tomaEvidencia("Valido no haya descuento del home");
		utilidades.validacionDeSaldos();
		Utilidades.esperaMiliseg(2000);
	}

	public void validoTxExcedeTopeSaldo() {
		pagePagar.validoLblExcedeTopeSaldo();
		pageHome.clickBotonAtras(4);
		pageHome.darClickEnActualizarSaldo();
		pageHome.capturarSaldoFinal();
		Utilidades.tomaEvidencia("Valido no haya descuento del home");
		utilidades.validacionDeSaldos();
		Utilidades.esperaMiliseg(2000);
	}

	public void ingresarValorPagarServicio(String valorServicio) {
		pagePagar.esperarAparezcaInfoHacerPagosServicios();
		pagePagar.valorAPagarServicio(valorServicio);
		Utilidades.tomaEvidencia("Valor a pagar ");
		pagePagar.darClickEnContinuar();
		pagePagar.darClickEnPagar();
		
	}
}
