package daviplata.nacional.iOS.utilidades;

import daviplata.nacional.iOS.steps.WebRedebanSteps;

public class WebRedebanException extends Exception {

	String message = "";

	public WebRedebanException() {
		message = "La prueba fallo, se debe cerrar redeban manualmente";
	}

	public WebRedebanException(WebRedebanSteps wr) {
		super();
		message = "La prueba fallo, se intenta cerrar RBM";
		wr.loginWebRedeban();
	}

	public WebRedebanException(WebRedebanSteps wr, String xpath) {
		super();
		message = "La prueba fallo, se intenta cerrar RBM con el xpath:" + xpath;
		wr.logOut(xpath);
	}

	public String getMessage() {
		return message;
	}

	public void cerrarRedeban(WebRedebanSteps wr) {
		message = "La prueba fallo, se intenta cerrar RBM";
		wr.loginWebRedeban();
	}

	public void cerrarRedeban(WebRedebanSteps wr, String xpath) {
		message = "La prueba fallo, se intenta cerrar RBM con el xpath:" + xpath;
		wr.logOut(xpath);
	}

}
