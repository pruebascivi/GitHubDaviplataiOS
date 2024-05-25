package daviplata.nacional.iOS.utilidades.rest;

import java.util.List;

public class Entities {

	private List<Fields> entities;
	private Long TotalResults;

	public Entities() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getTotalResults() {
		return TotalResults;
	}

	public void setTotalResults(Long totalResults) {
		TotalResults = totalResults;
	}

	public List<Fields> getEntities() {
		return entities;
	}

	public void setEntities(List<Fields> entities) {
		this.entities = entities;
	}

}
