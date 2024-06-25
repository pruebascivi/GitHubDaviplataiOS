package daviplata.nacional.iOS.definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import daviplata.nacional.iOS.steps.WebRedebanSteps;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import daviplata.nacional.iOS.utilidades.Cronometro;
import daviplata.nacional.iOS.utilidades.Evidencias;
import daviplata.nacional.iOS.steps.LoginSteps;
import net.thucydides.core.annotations.Steps;

public class LoginDefinitions {

	@Steps
	LoginSteps loginSteps;
	@Steps
	private WebRedebanSteps stepsWebRedeban;
	
	@Steps
	Cronometro cronometro;
	@Steps
	BaseUtil base;
	@Steps
	Evidencias evidencia;
	String numCelular = "";
	
	@Given("^ingresar a app sin credenciales$")
	public void ingresarAAppSinCredenciales() {
		loginSteps.ingresarAAppSinCredenciales();
	}
	
	@Given("^ingresar a app cambio dispositivo \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresarAAppCambioDispositivo(String tipoDocumento, String usuario, String contrasena) {
		loginSteps.ingresarAAppCambioDispositivo(tipoDocumento, usuario, contrasena);
	}
	
	@Given("^ingreso usuario y contrasena \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoUsuarioYContrasena(String tipoDocumento, String usuario, String contrasena) {
		loginSteps.ingresarAApp(tipoDocumento, usuario, contrasena);
	}
	
	@Given("^Login ADS \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void loginADS(String tipoDocumento, String usuario, String contrasena) {
		loginSteps.loginAds(tipoDocumento, usuario, contrasena);
	}
	
	@Given("^ingreso usuario y contrasena sin capturar saldo \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoUsuarioYContrasenaSinCapturaSaldo(String tipoDocumento, String usuario, String contrasena) {
		loginSteps.ingresarAAppSinCapturaSaldo(tipoDocumento, usuario, contrasena);
	}
	
	@Given("^Ingreso usuario y contrasena caracter especial \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
		public void ingresoUsuarioYContrasenaCaracterEspecial(String tipoDocumento, String usuario, String contrasena) {
		loginSteps.ingresarUsuarioContraseña(tipoDocumento, usuario, contrasena);
	}

	@Given("^ingreso usuario con caracteres \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoUsuarioYContrasena(String tipoDocumento, String usuario) {
		loginSteps.ingresarCaracteresEspeciales(tipoDocumento, usuario);
	}
	
	@Given("^ingreso usuario longitud superior quince \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoUsuarioLongitudSuperiorQuince (String tipoDocumento, String usuario) {
		loginSteps.ingresarLongitudSuperiorQuince(tipoDocumento, usuario);
	}
	
	@Then("^validar Mensaje$")
	public void validarMensaje() {
		loginSteps.validarMensajeDeCaracteres();
	}
	
	@Then("^Valido presencia de PopUp invita Amigos$")
	public void validoPresenciaDePopUpInvitaAmigos() {
		loginSteps.cerrarPopUpInvitaAmigos();
	}
	
	@Then("^validar longitud de caracteres \"([^\"]*)\"$")
	public void validarLongitudDeCaracteres(String usuario) {
		loginSteps.validarLongitudDeCaracteres(usuario);
	}
	
	@Given("^ingreso usuario y contrasena incorrecta \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoUsuarioYContrasenaIncorrecta(String usuario, String contrasena) throws Exception {
	   loginSteps.ingresarAAppContraInco(usuario, contrasena);
	}
	
	@Given("^ingreso usuario \"([^\"]*)\"$")
	public void ingresoUsuario(String usuario) throws Exception {
		loginSteps.ingresarAAppSinClave(usuario);
	}

	@When("^ingreso usuario y contrasena del segundo usuario \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoUsuarioYContrasenaDelSegundoUsuario(String tipoDocumento, String usuario, String contrasena){
		loginSteps.ingresarAAppNuevaContraseniaDespuesCambio(tipoDocumento, usuario, contrasena);
	}

	@Then("^valido ingreso al app$")
	public void validoIngresoAlApp() {
		loginSteps.validoMensajeIngreso();
	}
	
	@Given("^ingreso usuario y nueva contrasena \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoUsuarioYNuevaContrasena(String tipoDocumento, String usuario, String claveNueva) {
		loginSteps.ingresarAAppNuevaContrasenia(tipoDocumento, usuario, claveNueva);
	}

	@Then("^valido ingreso fallido a la app$")
	public void validoIngresoFallidoALaApp() {
		loginSteps.validoMensajeDeIngresoFalido();
	}
	
	@Then("^valido perfil persona$")
	public void validoPerfilPersona() {
		loginSteps.validoPerfilPersona();
	}
	
	@Given("^Salir de la app$")
	public void logoutApp() throws Exception {
		loginSteps.logoutApp();
	}
	
	@Given("^Realizo registro \"([^\"]*)\" \"([^\"]*)\"$")
	public void realizoRegistro(String tipoId, String usuario) throws Exception {
		loginSteps.registrarUsuario(tipoId, usuario);
	}

//***********************************************************Validacion de Saldos***********************************************************

	@Then("^valido saldo DaviPlata$")
	public void validoSaldoDaviPlata() {
		loginSteps.validoSaldoDaviPlata();
	}

	@Then("^valido saldo eCard$")
	public void validoSaldoECard() {
		loginSteps.validoSaldoeCard();
	}

	@Then("^valido saldo Bolsillo$")
	public void validoSaldoBolsillo() {
		loginSteps.validoSaldoBolsillo();
	}

	@When("^capturo saldos$")
	public void capturoSaldos() {
		loginSteps.capturoSaldos();
	}
	
	@Then("^valido saldo total$")
	public void validoSaldoTotoal() {
		loginSteps.validoSaldoTotal(); 
	}
    
	@Then("^valido direccionamiento a pse$")
	public void validoDireccionamientoAPse() {
		loginSteps.validoDireccionamientoAPse();
	}
	
	@Then("^Valido saldo DaviPlata en cero$")
    public void validoSaldoDaviPlataEnCero() {
        loginSteps.validoSaldoGloboEnCeros();
    }

//***********************************************************ValidacionDeActualizacionDeDatos***********************************************************
//*********************************************************Validacion ayuda en linea logueado*******************************************
	@When("^ingreso a la opcion atencion en linea$")
	public void ingresoALaOpcionAtencionEnLinea() {
		loginSteps.ingresoALaOpcionAtencionEnLinea();
	}
	
	@When("^Valido los criterios de consulta$")
	public void validacionDatos() {
		loginSteps.validacionCritreios();
	}

//****************************************************Validacion notificaciones ********************************************************

	@When("^ingreso a mensajes y notificaciones$")
	public void ingresoAMensajesYNotificaciones() {
		loginSteps.ingresoAMensajesYNotificaciones();
	}

	@Then("^validar que aparezcan los mensajes$")
	public void validarQueAparezcanLosMensajes() {
		loginSteps.validarQueAparezcanLosMensajes();
	}

	@Then("^validar que aparezcan las notificaciones$")
	public void validarQueAparezcanLasNotificaciones() {
		loginSteps.validarQueAparezcanLasNotificaciones();
	}
	
	@Then("^validar que aparezcan las compras$")
	public void validarQueAparezcanLasCompras() throws Exception {
	    loginSteps.validarQueAparezcanCompras();
	}
	
	@Then("^valido que se pueda leer$")
	public void validoQueSePuedaLeer() throws Exception {
	    loginSteps.leerCompras();
	}


	@Then("^validar que se puedan eliminar$")
	public void validarQueSePuedanEliminar() {
		loginSteps.validarQueSePuedanEliminar();
	}

	@Then("^verifico pop up nanocredito$")
	public void verificoPopUpNanocredito() {
		loginSteps.verificoPopUpNanocredito();
	}	
	
	// Stratus!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	
	@Given("^consulto saldo inicial stratus \"([^\"]*)\"$")
	public void consultoSaldoInicialStratus(String cuenta) {	
		loginSteps.consultoSaldoInicialStratus(cuenta);
	}
	
	//***********************************************************Validacion Redeban***********************************************************
	@Given("^obtener correo actual en redeban \"([^\"]*)\" \"([^\"]*)\"$")
	public void obtenerCorreoActualEnRedeban(String usuario, String contrasena) {
		numCelular = stepsWebRedeban.consultaNumeroCelular(usuario);
	}
	
	@Given("^Ingreso a la app$")
	public void ingresoApp() {
		loginSteps.ingresarALaAppValidarDesplegableTipoDocumental();
	}
	
	@Then("^validacion campo tipo documental desplegable$")
	public void ingresoTipoDocumentalDesplegable() {
		loginSteps.validarDesplegableTipoDocumental();
	}
	
	@Then("^Valido ingreso de caracter especial$")
	public void validoIngresoCaracterEspecial() {
		loginSteps.validoCaracterEspecial();
	}
	
	@Then("^validar longitud de caracteres tipo documental PEP \"([^\"]*)\"$")
	public void validarLongitudDeCaracteresPEP(String usuario) {
		loginSteps.validarLongitudDeCaracteresPEP(usuario);
	}
	
	@Given("^Ingreso usuario y contraseña look and feel \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoUsuarioContrasenaLookAndFeel(String tipoDocumento, String usuario) {
		loginSteps.ingresarALaAppParaLookAndFeel(tipoDocumento, usuario);
	}
	
	@When("^Valido look and feel ingreso a daviplata$")
	public void ingresoUsuarioContrasenaLookAndFeel() {
		loginSteps.validarIngresoDaviplata();
	}
	

	@When("^Ingreso contraseña \"([^\"]*)\"$")
	public void ingresoContrasenaLookAndFeel(String contrasena) {
		loginSteps.ingresoContrasenalogeo(contrasena);
	}
	
	@When("^Valido look and feel contrasena logeo$")
	public void ValidoLookAndFeelContrasenaLogeo() {
		loginSteps.validarLookAndFeelContrasena();
	}
	
	@Given("^Ingresar a latinia$")
	public void ingresarALatinia() {
		loginSteps.ingresarLatiniaMensajes();
	}
	

	@Given("^Validar que aparezcan mensajes$")
	public void validarMensajesLatinia() {
		loginSteps.validarMensajesDeLatinia();
	}
	
	@Then("^Finalizar sesion latinia$")
	public void cerrarSesionLatinia() {
		loginSteps.cerrarSesionLatinia();
	}
	
	//***********************************************************Olvido de clave***********************************************************
	
	@When("^Ingreso usuario y contrasena de olvido clave \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoUsuarioYContrasenaOlvidoClave(String tipoDocumento, String usuario, String contrasena) {
		loginSteps.ingresarAAppOlvidoClave(tipoDocumento, usuario, contrasena);
	}
	
	@Given("^Ingresé a la app Daviplata home$")
    public void ingreseAlaAppDaviplataHome() {
        loginSteps.ingresarALaApp();
    }
}
