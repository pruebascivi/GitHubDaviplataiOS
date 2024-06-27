package daviplata.nacional.iOS.definitions;

import cucumber.api.java.en.When;
import daviplata.nacional.iOS.steps.MovimientoFuncionalSteps;
import net.thucydides.core.annotations.Steps;

public class MovimientoFuncionalDefinitions {

	@Steps
	MovimientoFuncionalSteps movimientoFuncionalSteps;

	@When("^Ingreso al detalle del saldo en el home$")
    public void ingresoAlDetalleDelSaldoEnElHome() throws Exception {
        movimientoFuncionalSteps.ingresarAlDetalleSaldoDaviplata();
    }
    
    @When("^Valido la equis en el detalle de los saldos$")
    public void validoLaEquisEnElDetalleDeLosSaldos() throws Exception {
        movimientoFuncionalSteps.validarEquisEnElDetalleDelSaldo();
    }
    
    @When("^Valido que despues de dar clic en la equis direccione a la pantalla del home$")
    public void validoQueDespuesDeDarClicEnLaEquisDireccioneALaPantallaDelHome() throws Exception {
        movimientoFuncionalSteps.validarHomeZonaPrivada();
    }
    
    @When("^Entro al modulo de movimientos$")
    public void entroAlModuloDeMovimientos() throws Exception {
        movimientoFuncionalSteps.entrarAlModuloMovimientos();
    }
    
    @When("^Ingreso al detalle del movimiento en el pasar plata$")
    public void ingresoAlDetalleDelMovimientoEnElPasarPlata() throws Exception {
        movimientoFuncionalSteps.ingresarAlDetalleDelMovimientoPasarPlataDaviplata();
    }
    
    @When("^Valido nombre y numero de la transaccion en los movimientos$")
    public void validoNombreYNumeroDeLaTransaccionEnLosMovimientos() throws Exception {
        movimientoFuncionalSteps.validarNombreYNumeroTransaccion();
    }
    
    @When("^Entro al modulo de movimientos desde el detalle del saldo$")
    public void entroAlModuloDeMovimientosDesdeElDetalleDelSaldo() throws Exception {
        movimientoFuncionalSteps.entrarAlModuloMovimientosDesdeDetalleDeSaldo();
    }
    
    @When("^Valido el boton atras en movimientos$")
    public void validoElBotonAtrasEnMovimientos() throws Exception {
        movimientoFuncionalSteps.validarBotonAtrasModuloMovimientos();
    }
    
    @When("^Dar clic en el boton atras$")
    public void darClicEnElBotonAtras() throws Exception {
        movimientoFuncionalSteps.hacerClicEnElBotonAtras();
    }
    
    @When("^Valido header de saldos$")
    public void validoHeaderDeSaldos() throws Exception {
        movimientoFuncionalSteps.validarHeaderSaldos();
    }
    
    @When("^Dar clic en la equis de los saldos$")
    public void darClicEnLaEquisDeLosSaldos() throws Exception {
        movimientoFuncionalSteps.hacerClicEnLaEquisDeSaldos();
    }
    
    @When("^Valido titulo de movimientos$")
    public void validoTituloDeMovimientos() throws Exception {
        movimientoFuncionalSteps.validarTituloDelModuloMovimientos();
    }
    
    @When("^Valido equis del header de movimientos$")
    public void validoEquisDelHeaderDeMovimientos() throws Exception {
        movimientoFuncionalSteps.validarEquisDeMovimientos();
    }
    
    @When("^Valido movimientos del dia de hoy$")
    public void validoMovimientosDelDiaDeHoy() throws Exception {
        movimientoFuncionalSteps.validarMovimientosDelDiaActual();
    }
    
    @When("^Validar movimientos que contengan fecha con el nombre del mes$")
    public void validarMovimientosQueContenganFechaConElNombreDelMes() throws Exception {
        movimientoFuncionalSteps.validarFormatoFechaMovimientos();
    }

}
