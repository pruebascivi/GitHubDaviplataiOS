package daviplata.nacional.iOS.steps;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.regexp.recompile;
import org.junit.Assert;

import cucumber.api.Scenario;
import daviplata.nacional.iOS.definitions.Hooks;
import daviplata.nacional.iOS.pageObjects.HomePageObjects;
import daviplata.nacional.iOS.pageObjects.LoginPageObjects;
import daviplata.nacional.iOS.pageObjects.MenuHamburguesaPageObjects;
import daviplata.nacional.iOS.pageObjects.PasarPlataPageObjects;
import daviplata.nacional.iOS.pageObjects.RecargaPageObjects;
import daviplata.nacional.iOS.pageObjects.WebRedebanPageObjects;
import daviplata.nacional.iOS.utilidades.Evidencias;
import daviplata.nacional.iOS.utilidades.Utilidades;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import net.thucydides.core.annotations.Step;

public class RecargaSteps {
	LoginPageObjects pageLogin;
	PasarPlataPageObjects pagePasarPlata;
	HomePageObjects pageHome;
	RecargaPageObjects pageRecarga;
	MenuHamburguesaPageObjects menuHamburguesaPageObjects;
	BigDecimal valorHome = null;
	BigDecimal valorTransferencia = null;
	private Scenario scenario = Hooks.scenario;
	private AppiumDriver<MobileElement> driver = Hooks.getDriver();
	Utilidades utilidad;
	Utilidades Utilidades;

	public void seleccionarRecargaVirual() {
		//pagePasarPlata.capturarSaldo();
		pageRecarga.darClickEnMenuHamburguesa();
		pageLogin.darClickEnUsarPlata();
		pageRecarga.btnRecargasPrepago();
		pageRecarga.clickRecargas();
		//pageRecarga.clicBtnRecargas();
		//utilidad.esperaMilise(8000);
		/*for(int i=0; i<4; i++) {
			utilidad.moverPantallaCorto();
		}*/

	}
	
	public void selecccionarTipoRecarga() {
		//pageRecarga.selectTipoDeRecarga();
		pageRecarga.clicBtnRecargasMovistar();
		//pageRecarga.clicBtnRecargaMinutos();
		//pageRecarga.btnContinuar();
	}
	
	public void diligenciarDatosDeRecargaTv(String empresaOperador,String numReferencia,String montoSeleccionable) {
		pageRecarga.darClickEmpresaOServicio();
		pageRecarga.darClickDesplegableEmpresaServicio(empresaOperador);
		pageRecarga.selectOperadorEmpresaTv(empresaOperador);
		pagePasarPlata.darClickEnBtnContinuar();
		pageRecarga.darClickNumReferencia();
		pageRecarga.ingresarNumReferencia(numReferencia);
		utilidad.tomaEvidencia("Numero de referencia "+ numReferencia); 
		pagePasarPlata.darClickEnBtnContinuar();
		pageRecarga.darClickValorAPagar();
		pageRecarga.ingresarOSeleccionarValor(montoSeleccionable);
		utilidad.tomaEvidencia("Monto seleccionable" + montoSeleccionable);
		pagePasarPlata.darClickEnBtnAceptar();
		utilidad.tomaEvidencia("Datos de recarga diligenciados");
		pagePasarPlata.darClickEnBtnContinuar();
		utilidad.esperaMiliseg(5000);
	}
	
	public void diligenciarDatosRecargaCelular(String numReferencia,String montoSeleccionable) {
		//pageRecarga.darClickNumCelARecargar();
		pageRecarga.ingresarNumeroARecargar(numReferencia);
		utilidad.tomaEvidencia("Numero de celular "+ numReferencia);
		pagePasarPlata.darClickEnBtnContinuar();
		//pageRecarga.darClickCuantaPlataRecaragr();
		pageRecarga.ingresarOSeleccionarValor(montoSeleccionable);
		pagePasarPlata.darClickEnBtnAceptar();
		//pageRecarga.darClickEnSelectOperador();
		//pageRecarga.desplegarListaOperador();
		//pageRecarga.selectOperadorEmpresaCelular(empresaOperador);
		utilidad.tomaEvidencia("Datos de recarga");
		//pagePasarPlata.darClickEnBtnContinuar(2);
		pagePasarPlata.clicBtnRecargar();

	}
	
	public void diligenciarDatosRecargaCelularFondosInsuficientes(String numReferencia,String montoSeleccionable,String empresaOperador) {
		/*pageRecarga.darClickNumCelARecargar();
		pageRecarga.ingresarNumeroARecargar(numReferencia);
		pagePasarPlata.darClickEnBtnContinuar();
		pageRecarga.darClickCuantaPlataRecaragr();
		pageRecarga.ingresarMonto(montoSeleccionable);
		pagePasarPlata.darClickEnBtnAceptar();
		pageRecarga.darClickEnSelectOperador();
		pageRecarga.desplegarListaOperador();
		pageRecarga.selectOperadorEmpresa(empresaOperador);
		pagePasarPlata.darClickEnBtnContinuar();
		pagePasarPlata.darClickEnBtnContinuar();*/
		utilidad.esperaMiliseg(6000);
		utilidad.darUnTap(200, 840); 
		utilidad.esperaMiliseg(2000);
		utilidad.darUnTap(369, 1783);
		utilidad.esperaMiliseg(2000);
		utilidad.darUnTap(651, 1388);//3
		utilidad.esperaMiliseg(1000);
		utilidad.darUnTap(404, 1388);//2
		utilidad.esperaMiliseg(1000);
		utilidad.darUnTap(404, 1388);//2
		utilidad.esperaMiliseg(1000);
		utilidad.darUnTap(141, 1741);//7
		utilidad.esperaMiliseg(1000);
		utilidad.darUnTap(656, 1575);//6
		utilidad.esperaMiliseg(1000);
		utilidad.darUnTap(414, 1746);//8
		utilidad.esperaMiliseg(1000);
		utilidad.darUnTap(409, 1923);//0
		utilidad.esperaMiliseg(1000);
		utilidad.darUnTap(141, 1741);//7
		utilidad.esperaMiliseg(1000);
		utilidad.darUnTap(409, 1923);//0
		utilidad.esperaMiliseg(1000);
		utilidad.darUnTap(409, 1923);//0
		utilidad.esperaMiliseg(1000);
		utilidad.esperaMiliseg(2000);
		utilidad.darUnTap(525, 1993);//boton Continuar
		utilidad.esperaMiliseg(4000);
		utilidad.darUnTap(530, 1731);//boton recargar
		
	}

	public void validarRecargaExitosa(String numReferencia) {
		List<MobileElement> datosCapturados = pagePasarPlata.capturaResultadoTransaccion();
		pageRecarga.verificoResultadoRecarga(datosCapturados);
		utilidad.tomaEvidencia("Recarga Exitosa");
		pagePasarPlata.txtAutorizador();
		pageRecarga.darClickFinalizar();
	}
	
	public void validarRecargaFallida() {
		pageRecarga.validarRecargaNegada();
		utilidad.tomaEvidencia("Recarga Negada");
		utilidad.esperaMiliseg(500);
	}
	
	public void verificoSaldoFinal() {
		pageHome.darClickEnActualizarSaldo();
		pageHome.capturarSaldoFinal();
		utilidad.validacionDeSaldos();
		utilidad.tomaEvidencia("Saldo Final");
	}
	
	public void validoTransaccionRechazada() {
//		pageRecarga.validoLblFondosTransaccionDeclinada();
		pageRecarga.validarLblFondosInsuficientes();
		pageHome.clickBotonAtras(2);
		pageHome.darClickEnActualizarSaldo();
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("Valido no haya descuento del home");
		utilidad.validacionDeSaldos();
		utilidad.esperaMiliseg(2000);

	}
}
