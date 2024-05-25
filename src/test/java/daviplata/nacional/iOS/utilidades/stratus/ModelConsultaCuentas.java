package daviplata.nacional.iOS.utilidades.stratus;

import java.math.BigDecimal;

public class ModelConsultaCuentas {

	private String tipoCuenta = "";
	private String numCuenta = "";
	private BigDecimal saldoInicial = new BigDecimal("0.0");

	public ModelConsultaCuentas() {
		super();
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public String getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}

	public BigDecimal getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(BigDecimal saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

}
