package daviplata.nacional.iOS.modelo;

import java.math.BigDecimal;

import daviplata.nacional.iOS.utilidades.Utilidades;

/**
 * Esta clase genera los calculos necesarios para realizar las pruebas de fondos
 * insuficientes.
 * 
 * @author Alexander Gonzalez
 *
 */
public class FondosInsuficientes {

	private String valorInicial;
	private String valorFinal;
	private String vDisponible;
	private String vDispoMasUno;
	private String vEntreDispoYTotal;
	private String vTotal;
	private String vTotalMasUno;
	private String vTotalMasDiezMil;

	public FondosInsuficientes() {

	}

	public FondosInsuficientes(String valorInicial, String valorFinal) {
		calcularValores(valorInicial, valorFinal);
	}

	public String getValorInicial() {
		return valorInicial;
	}

	public void setValorInicial(String valorInicial) {
		this.valorInicial = valorInicial;
	}

	public String getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(String valorFinal) {
		this.valorFinal = valorFinal;
	}

	public String getvDisponible() {
		return vDisponible;
	}

	public void setvDisponible(String vDisponible) {
		this.vDisponible = vDisponible;
	}

	public String getvDispoMasUno() {
		return vDispoMasUno;
	}

	public void setvDispoMasUno(String vDispoMasUno) {
		this.vDispoMasUno = vDispoMasUno;
	}

	public String getvEntreDispoYTotal() {
		return vEntreDispoYTotal;
	}

	public void setvEntreDispoYTotal(String vEntreDispoYTotal) {
		this.vEntreDispoYTotal = vEntreDispoYTotal;
	}

	public String getvTotal() {
		return vTotal;
	}

	public void setvTotal(String vTotal) {
		this.vTotal = vTotal;
	}

	public String getvTotalMasUno() {
		return vTotalMasUno;
	}

	public void setvTotalMasUno(String vTotalMasUno) {
		this.vTotalMasUno = vTotalMasUno;
	}

	public String getvTotalMasDiezMil() {
		return vTotalMasDiezMil;
	}

	public void setvTotalMasDiezMil(String vTotalMasDiezMil) {
		this.vTotalMasDiezMil = vTotalMasDiezMil;
	}

	public FondosInsuficientes calcularValores(String valorInicial, String valorFinal) {
		FondosInsuficientes fi = new FondosInsuficientes();
		valorInicial = Utilidades.quitarCaracter(valorInicial, ".");// quito datos innecesarios.
		valorInicial = Utilidades.quitarCaracter(valorInicial, ",");
		valorInicial = Utilidades.quitarDigitos(valorInicial, 2);
		valorFinal = Utilidades.quitarCaracter(valorFinal, ".");// quito datos innecesarios.
		valorFinal = Utilidades.quitarCaracter(valorFinal, ",");
		valorFinal = Utilidades.quitarDigitos(valorFinal, 2);
		BigDecimal vInicial = new BigDecimal(valorInicial);
		BigDecimal vFinal = new BigDecimal(valorFinal);
		setvDisponible(valorInicial);
		setvDispoMasUno(vInicial.add(new BigDecimal("1")) + "");// Tomo el valor disponible y le sumo 1
		setvEntreDispoYTotal((((vInicial.add(vFinal)).divide(new BigDecimal("2"))).add(new BigDecimal("1"))) + ""); // ((Disponible+total)/2)+1
		setvTotal(valorFinal);
		setvTotalMasUno((vFinal.add(new BigDecimal("1"))) + "");
		setvTotalMasDiezMil((vFinal.add(new BigDecimal("10000"))) + "");
		return fi;
	}

}
