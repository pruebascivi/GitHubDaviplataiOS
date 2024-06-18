package daviplata.nacional.iOS.definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import daviplata.nacional.iOS.steps.AdsSteps;
import net.thucydides.core.annotations.Steps;

public class AdsDefinitions {
	
	@Steps
	AdsSteps adsSteps;
    
	@When("^Ingreso al pop up de adelanto de sueldo$")
    public void ingresoAlPopUpDeAdelantoDeSueldo() throws Exception {         
        adsSteps.ingresoAlPopUpDeAdelantoDeSueldo();
    }
    
    @When("^Acepto terminos y condiciones en pantalla de beneficios$")
    public void aceptoTerminosYCondicionesEnPantallaDeBeneficios() throws Exception {         
        adsSteps.marcarTyCPantallaBeneficios();
    }
    
    @When("^Doy clic en el boton continuar de beneficios$")
    public void doyClicEnElBotonContinuarDeBeneficios() throws Exception  {         
        adsSteps.clicBotonContinuarDeBeneficios();
    }
    
    @When("^Valido pantalla de autorizaciones$")
    public void validoPantallaDeAutorizaciones() throws Exception  {         
        adsSteps.validarPantallaDeAutorizaciones();
    }
    
    @When("^Validamos pantalla de resultado$")
    public void validamosPantallaDeResultados() throws Exception  {         
        adsSteps.validaraPantallResultado();
    }
    
    @When("^Ingreso a pantalla autorizacion tratamiento de datos sensibles$")
    public void ingresoAPantallaAutorizacionTratamientoDeDatosSensibles() throws Exception  {         
        adsSteps.ingresarAPantallaTratamientoDatosSensibles();
    }
    
    @When("^Valido que al dar clic al boton atras deje el check desmarcado$")
    public void validoQueAlDarClicAlBotonAtrasDejeElCheckDesmarcado() throws Exception  {         
        adsSteps.validarCheckAutorizacionesDesmarcadoAlDarClicBotonAtras();
    }
    
    @When("^Acepto terminos y condiciones de tratamiento de datos sensibles$")
    public void aceptoTerminosYCondicionesDeTratamientoDeDatosSensibles() throws Exception {         
        adsSteps.aceptarTerminosYCondicionesTratamientoDeDatos();
    }
    
    @When("^Acepto debitar automaticamente mi DaviPlata$")
    public void aceptoDebitarAutomaticamenteMiDaviPlata() throws Exception {         
        adsSteps.aceptarTerminosYCondicionesDebitar();
    }
    
    @When("^Acepto terminos de pagare$")
    public void aceptoTerminosDePagare() throws Exception {         
        adsSteps.aceptarTerminosPagare();
    }
    
    @When("^Valido que al dar clic en el boton atras mantenga los check marcados$")
    public void validoQueAlDarClicEnElBotonAtrasMantengaLosCheckMarcados() throws Exception {         
        adsSteps.hacerClicBotonAtrasParaValidarChecksMarcadosPantallaAutorizaciones();
    }
    
    @When("^Valido checks marcados al aceptar terminos y condiciones de datos sensibles$")
    public void validoChecksMarcadosAlAceptarTerminosYCondicionesDeDatosSensibles() throws Exception {         
        adsSteps.aceptarTerminosYCondicionesTratamientoDeDatosYValidarChecksMarcados();
    }
    
    @When("^Valido elementos del pop up salir de la app$")
    public void validoElementosDelPopUpSalirDeLaApp() throws Exception {         
        adsSteps.validarElementosPopUpSalirDeLaApp();
    }
    
    @When("^Valido que al hacer clic en cancelar deje en la misma pantalla de autorizaciones$")
    public void validoQueAlHacerClicEnCancelarDejeEnLaMismaPantallaDeAutorizaciones() throws Exception {         
        adsSteps.validarQueAlDarClicEnCancelarDejeEnPantallaAutorizaciones();
    }

    @Then("^Validar que al hacer clic en continuar deje en la pantalla de login$")
    public void validarQueAlHacerClicEnContinuarDejeEnLaPantallaDeLogin() throws Exception {         
        adsSteps.validarQueAlDarClicEnAceptarDejeEnPantallaLogin();
    }
    
    @When("^Lleno formulario de informacion personal primera pantalla \"([^\"]*)\" \"([^\"]*)\"$")
    public void llenoFormularioDeInformacionPersonalPrimeraPantalla(String ciudadExpedicionDocumento, String paisNacimiento) throws Exception {         
        adsSteps.llenarFormularioInformacionPersonalPrimeraPantalla(ciudadExpedicionDocumento,paisNacimiento);
    }
    
    @When("^Lleno formulario de informacion personal segunda pantalla \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void llenoFormularioDeInformacionPersonalSegundaPantalla(String correoElectronico, String tipoCalle, String numUnoDireccion, String numDosDireccion, String numTresDireccion, String tipoInmueble, String ciudadResidencia) throws Exception {
        adsSteps.llenarFormularioInformacionPersonalSegundaPantalla(correoElectronico,tipoCalle,numUnoDireccion,numDosDireccion,numTresDireccion,tipoInmueble,ciudadResidencia);
    }
    
    @When("^Lleno formulario de informacion laboral \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void llenoFormularioDeInformacionLaboral(String tipoCalleDondeTrabaja, String numUnoDireccionDondeTrabaja, String numDosDireccionDondeTrabaja, String numTresDireccionDondeTrabaja, String tipoInmuebleDondeTrabaja, String ciudaDeTrabajo) throws Exception {
        adsSteps.llenarFormularioInformacionLaboral(tipoCalleDondeTrabaja,numUnoDireccionDondeTrabaja,numDosDireccionDondeTrabaja,numTresDireccionDondeTrabaja,tipoInmuebleDondeTrabaja,ciudaDeTrabajo);
    }
    
    @When("^Lleno formulario de informacion Financiera uno \"([^\"]*)\"\"([^\"]*)\"$")
    public void llenoFormularioDeInformacionFinanciera(String montoGastosMes, String montoSumaLoQueTiene) throws Exception {
        adsSteps.llenarFormularioInformacionFinanciera(montoGastosMes, montoSumaLoQueTiene);
    }
    
    @When("^Lleno formulario de informacion financiera dos \"([^\"]*)\"$")
    public void llenoFormularioDeInformacionFinancieraDos(String montoSumaLoQueDebe) throws Exception {
        adsSteps.llenarFormularioInformacionFinancieraDos(montoSumaLoQueDebe);
    }
    
    @When("^Salgo de la app$")
    public void salgoDeLaApp() throws Exception {         
        adsSteps.salirDeLaApp();
    }
    
    @When("^Acepto retomar la solicitud de ads$")
    public void aceptoRetomarLaSolicitudDeAds() throws Exception {         
        adsSteps.retomarSolicitudAds();
    }
    
    @Then("^Validar que se haya guardado los datos al salir de la app$")
    public void validarQueSeHayaGuardadoLosDatosAlSalirDeLaApp() throws Exception {         
        adsSteps.validarQueSeHayanGuardadoLosDatosDelFormulario();
    }
    
    @Then("^Validar que se haya guardado los datos de la pantalla dos de informacion personal al salir de la app$")
    public void validarQueSeHayaGuardadoLosDatosDeLaPantallaDosDeInformacionPersonalAlSalirDeLaApp() throws Exception {         
        adsSteps.validarQueSeHayanGuardadoLosDatosDelFormularioEnLaPantallaDosInformacionPersonal();
    }
    
    @When("^Validar que se haya guardado los datos de informacion laboral al salir de la app$")
    public void validarQueSeHayaGuardadoLosDatosDeInformacionLaboralAlSalirDeLaApp() throws Exception {         
        adsSteps.validarQueSeHayanGuardadoLosDatosDelFormularioEnLaPantallaInformacionLaboral();
    }
    
    @Then("^Validar que se haya guardado los datos de informacion financiera uno al salir de la app$")
    public void validarQueSeHayaGuardadoLosDatosDeInformacionFinancieraUnoAlSalirDeLaApp() throws Exception {         
        adsSteps.validarQueSeHayanGuardadoLosDatosDelFormularioEnLaPantallaInformacionFinancieraUno();
    }
    
    @Then("^Validar que se haya guardado los datos de informacion financiera dos al salir de la app$")
    public void validarQueSeHayaGuardadoLosDatosDeInformacionFinancieraDosAlSalirDeLaApp() throws Exception {         
        adsSteps.validarQueSeHayanGuardadoLosDatosDelFormularioEnLaPantallaInformacionFinancieraDos();
    }
    
    @When("^Lleno formulario de persona politicamente expuesta$")
    public void llenoFormularioDePersonaPoliticamenteExpuesta() throws Exception {         
        adsSteps.llenoFormularioPersonaPoliticamenteExpuesta();
    }
    
    @Then("^Validar que se haya guardado los datos de la persona politicamente expuesta al salir de la app$")
    public void validarQueSeHayaGuardadoLosDatosDeLaPersonaPoliticamenteExpuestaAlSalirDeLaApp() throws Exception {         
        adsSteps.validarQueSeHayanGuardadoLosDatosDelFormularioEnLaPantallaPersonaPoliticamenteExpuesta();
    }
    
    @When("^Lleno formulario informacion tributaria$")
    public void llenoFormularioInformacionTributaria() throws Exception {         
        adsSteps.llenoFormularioInformacionTributariaNoFacta();
    }
    
    @When("^Lleno formulario informacion tributaria facta$")
    public void llenoFormularioInformacionTributariaFacta() throws Exception {         
        adsSteps.llenoFormularioInformacionTributariaFacta();
    }
    
    @Then("^Validar que se haya guardado los datos de la pantalla informacion tributaria al salir de la app$")
    public void validarQueSeHayaGuardadoLosDatosDeLaPantallaInformacionTributariaAlSalirDeLaApp() throws Exception {        
        adsSteps.validarQueSeHayanGuardadoLosDatosDelFormularioEnLaPantallaInformacionTributaria();
    }
    
    @Then("^Validar que se haya guardado los datos de la pantalla informacion tributaria facta al salir de la app$")
    public void validarQueSeHayaGuardadoLosDatosDeLaPantallaInformacionTributariaFactaAlSalirDeLaApp() throws Exception {        
        adsSteps.validarQueSeHayanGuardadoLosDatosDelFormularioEnLaPantallaInformacionTributariaUnoFacta();
    }
    
    @Then("^Validar que se haya guardado los datos de la pantalla declaracion tributaria facta al salir de la app$")
    public void validarQueSeHayaGuardadoLosDatosDeLaPantallaDeclaracionTributariaFactaAlSalirDeLaApp() throws Exception {        
        adsSteps.validarQueSeHayanGuardadoLosDatosDelFormularioEnLaPantallaDeclaracionTributariaFacta();
    }
    
    @When("^Lleno formulario de declaracion tributaria facta \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void llenoFormularioDeDeclaracionTributariaFacta(String nombreDeclaracionImpuestos, String direccionResidenciaFacta, String ciudad, String numeroPostal, String numeroSeguroSocial) throws Exception {         
        adsSteps.llenoFormularioDeclaracionTributariaFacta(nombreDeclaracionImpuestos,direccionResidenciaFacta,ciudad,numeroPostal,numeroSeguroSocial);
    }
    
    @When("^Lleno formulario declaraciones$")
    public void llenoFormularioDeclaraciones() throws Exception {         
        adsSteps.llenoFormularioDeclaracionFacta();
    }
    
    @Then("^Validar que se haya guardado los datos de la pantalla declaraciones al salir de la app$")
    public void validarQueSeHayaGuardadoLosDatosDeLaPantallaDeclaracionesAlSalirDeLaApp() throws Exception {        
        adsSteps.validarQueSeHayanGuardadoLosDatosDelFormularioEnLaPantallaDeclaraciones();
    }
}

