package daviplata.nacional.iOS.modelo;

import net.thucydides.core.annotations.Steps;

public class ConsultaClientes {
    
	private String tipoIdentificacion;
	private String numeroIdentificacion;
	private String bin;
	private String numeroTarjeta;
	private String nombreRealce;
	private String estado;
	private String excenta4xmil;
	private String franquicia;
	private String tipoTarjeta;
	private String subTipo;
	private String acumulado4x1000;

	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public String getBin() {
		return bin;
	}

	public void setBin(String bin) {
		this.bin = bin;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public String getNombreRealce() {
		return nombreRealce;
	}

	public void setNombreRealce(String nombreRealce) {
		this.nombreRealce = nombreRealce;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getExcenta4xmil() {
		return excenta4xmil;
	}

	public void setExcenta4xmil(String excenta4xmil) {
		this.excenta4xmil = excenta4xmil;
	}
	
	public void setAcumulado4xmil(String excenta4xmil) {
		this.acumulado4x1000 = excenta4xmil;
	}
	public String getAcumulado4xmil() {
		return acumulado4x1000;
	}
	public String getFranquicia() {
		return franquicia;
	}

	public void setFranquicia(String franquicia) {
		this.franquicia = franquicia;
	}

	public String getTipoTarjeta() {
		return tipoTarjeta;
	}

	public void setTipoTarjeta(String tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
	}

	public String getSubTipo() {
		return subTipo;
	}

	public void setSubTipo(String subTipo) {
		this.subTipo = subTipo;
	}

	@Override
	public String toString() {
		return "ConsultaClientes [tipoIdentificacion=" + tipoIdentificacion + ", numeroIdentificacion="
				+ numeroIdentificacion + ", bin=" + bin + ", numeroTarjeta=" + numeroTarjeta + ", nombreRealce="
				+ nombreRealce + ", estado=" + estado + ", excenta4xmil=" + excenta4xmil + ", franquicia=" + franquicia
				+ ", tipoTarjeta=" + tipoTarjeta + ", subTipo=" + subTipo + "]";
	}
	
	

}
