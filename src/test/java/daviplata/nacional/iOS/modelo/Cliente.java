package daviplata.nacional.iOS.modelo;

import net.thucydides.core.annotations.Steps;

public class Cliente {

	private ConsultaClientes consultaClientes;
	private ConsultaCupoTarjeta consultaCupoTarjeta;
	private ConsultaMovimientoHistorico consultaMovimientoHistorico;

	public ConsultaClientes getConsultaClientes() {
		return consultaClientes;
	}

	public void setConsultaClientes(ConsultaClientes consultaClientes) {
		this.consultaClientes = consultaClientes;
	}

	public ConsultaCupoTarjeta getConsultaCupoTarjeta() {
		return consultaCupoTarjeta;
	}

	public void setConsultaCupoTarjeta(ConsultaCupoTarjeta consultaCupoTarjeta) {
		this.consultaCupoTarjeta = consultaCupoTarjeta;
	}

	public ConsultaMovimientoHistorico getConsultaMovimientoHistorico() {
		return consultaMovimientoHistorico;
	}

	public void setConsultaMovimientoHistorico(ConsultaMovimientoHistorico consultaMovimientoHistorico) {
		this.consultaMovimientoHistorico = consultaMovimientoHistorico;
	}

	@Override
	public String toString() {
		return "Cliente [consultaClientes=" + consultaClientes + ", consultaCupoTarjeta=" + consultaCupoTarjeta
				+ ", consultaMovimientoHistorico=" + consultaMovimientoHistorico + "]";
	}

}

