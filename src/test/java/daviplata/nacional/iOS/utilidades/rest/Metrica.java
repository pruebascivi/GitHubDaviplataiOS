package daviplata.nacional.iOS.utilidades.rest;

import java.util.List;

public class Metrica {

	private String name;
	private boolean colorByPoint;
	private List<Data> data;
	private double total;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isColorByPoint() {
		return colorByPoint;
	}

	public void setColorByPoint(boolean colorByPoint) {
		this.colorByPoint = colorByPoint;
	}

	public List<Data> getData() {
		return data;
	}

	public void setData(List<Data> data) {
		this.data = data;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
