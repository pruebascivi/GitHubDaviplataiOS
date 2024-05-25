package daviplata.nacional.iOS.modelo;

import java.util.Date;

public class ConsultaMovimientoHistorico {

	private Date fechaSistema;
	private String valorTransaccion;
	private String mensaje;
	private String dispositivo;
	private String transaccion;
	private String indicadorReverso;
	private String codigoRespuesta;
	private String codigoAutorizacion;
	private String origentransaccion;
	private String switchTrans;
	private String hora;
	private String impEmergenciaEconomica;
	private String valorAjustes;
	private String valorComision;
	private String valorIVA;

	public Date getFechaSistema() {
		return fechaSistema;
	}

	public void setFechaSistema(Date fechaSistema) {
		this.fechaSistema = fechaSistema;
	}

	public String getValorTransaccion() {
		return valorTransaccion;
	}

	public void setValorTransaccion(String valorTransaccion) {
		this.valorTransaccion = valorTransaccion;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(String dispositivo) {
		this.dispositivo = dispositivo;
	}

	public String getTransaccion() {
		return transaccion;
	}

	public void setTransaccion(String transaccion) {
		this.transaccion = transaccion;
	}

	public String getIndicadorReverso() {
		return indicadorReverso;
	}

	public void setIndicadorReverso(String indicadorReverso) {
		this.indicadorReverso = indicadorReverso;
	}

	public String getCodigoRespuesta() {
		return codigoRespuesta;
	}

	public void setCodigoRespuesta(String codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}

	public String getCodigoAutorizacion() {
		return codigoAutorizacion;
	}

	public void setCodigoAutorizacion(String codigoAutorizacion) {
		this.codigoAutorizacion = codigoAutorizacion;
	}

	public String getOrigentransaccion() {
		return origentransaccion;
	}

	public void setOrigentransaccion(String origentransaccion) {
		this.origentransaccion = origentransaccion;
	}

	public String getSwitchTrans() {
		return switchTrans;
	}

	public void setSwitchTrans(String switchTrans) {
		this.switchTrans = switchTrans;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getImpEmergenciaEconomica() {
		return impEmergenciaEconomica;
	}

	public void setImpEmergenciaEconomica(String impEmergenciaEconomica) {
		this.impEmergenciaEconomica = impEmergenciaEconomica;
	}

	public String getValorAjustes() {
		return valorAjustes;
	}

	public void setValorAjustes(String valorAjustes) {
		this.valorAjustes = valorAjustes;
	}

	public String getValorComision() {
		return valorComision;
	}

	public void setValorComision(String valorComision) {
		this.valorComision = valorComision;
	}

	public String getValorIVA() {
		return valorIVA;
	}

	public void setValorIVA(String valorIVA) {
		this.valorIVA = valorIVA;
	}

	@Override
	public String toString() {
		return "ConsultaMovimientoHistorico [fechaSistema=" + fechaSistema + ", valorTransaccion=" + valorTransaccion
				+ ", mensaje=" + mensaje + ", dispositivo=" + dispositivo + ", transaccion=" + transaccion
				+ ", indicadorReverso=" + indicadorReverso + ", codigoRespuesta=" + codigoRespuesta
				+ ", codigoAutorizacion=" + codigoAutorizacion + ", origentransaccion=" + origentransaccion
				+ ", switchTrans=" + switchTrans + ", hora=" + hora + ", impEmergenciaEconomica="
				+ impEmergenciaEconomica + ", valorAjustes=" + valorAjustes + ", valorComision=" + valorComision
				+ ", valorIVA=" + valorIVA + "]";
	}

}
