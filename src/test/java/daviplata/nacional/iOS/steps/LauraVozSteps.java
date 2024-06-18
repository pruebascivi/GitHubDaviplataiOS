package daviplata.nacional.iOS.steps;

import static org.junit.Assert.fail;
import daviplata.nacional.iOS.pageObjects.LauraVozPageObjects;
import daviplata.nacional.iOS.pageObjects.LoginRobustoPage;
import daviplata.nacional.iOS.pageObjects.MeterPlataPageObjects;
import daviplata.nacional.iOS.utilidades.Utilidades;
import daviplata.nacional.iOS.utilidades.UtilidadesTCS;
import net.thucydides.core.annotations.Step;

public class LauraVozSteps {
    
	Utilidades utilidad;
    UtilidadesTCS utilidadesTcs;
    LauraVozPageObjects lauraVozPageObjects;
    MeterPlataPageObjects meterPlataPageObjects;

    @Step
    public void validoMeRedireccioneAlGestorDeInteraccionesTradicional() {
		Utilidades.esperaMiliseg(2000);
        boolean popUpIngreso = utilidadesTcs.validateElementVisibilityCatch("xpath", 
        		LauraVozPageObjects.POP_UP_DOS_ENLACES);
        if (popUpIngreso == true) {
            System.out.println("Me redirijo al gestor de interacciones");
            Utilidades.tomaEvidencia("Cerrar el pop Up presente");
            utilidadesTcs.clicElementAction("xpath", LauraVozPageObjects.BOTON_CERRAR_PRUEBAS_DOS_ENLACES);
        } else {
            System.out.println("Me encuentro en Laura voz");
            fail("No me encuentró en el gestor de interacción del chat necesito ayuda");
        }
        utilidadesTcs.esperarElementVisibility("xpath", LauraVozPageObjects.PANTALLA_CHAT_NECESITO_AYUDA);
        Utilidades.tomaEvidencia("Valido la pantalla gestor de interacciones");
    }

    @Step
    public void validoMeRedireccioneAlUsuarioALaPantallaBienvenida() {
        boolean popUpIngreso = utilidadesTcs.validateElementVisibilityCatch("xpath",
                LauraVozPageObjects.PANTALLA_DE_BIENVENIDA_LAURA_VOZ);
        if (popUpIngreso == true) {
            System.out.println("Me redirijo a la pantalla de bienvenida Laura voz");
            Utilidades.tomaEvidencia("Me redirigí a la pantalla de bienvenida Laura voz");
        } else {
            System.out.println("Me encuentro en el gestor de interacciones");
            fail("No me encuentró en la pantalla de bienvenida Laura voz");
        }
    }

    @Step
    public void validarLaPantallaBienvenidoAlChatDeServicioDaviplataContengaIconoCerrar() {
        Utilidades.tomaEvidencia("Valido el icono cerrar de la pantalla Laura Voz");
        utilidadesTcs.clicElement("xpath", LauraVozPageObjects.ICONO_CERRAR_PANTALLA_LAURA_VOZ);
		Utilidades.esperaMiliseg(2000);
        Utilidades.tomaEvidencia("Valido me redirija al home público");
    }

    @Step
    public void validoLapantallaLauraVozContengaElIconoMinimizar() {
        Utilidades.tomaEvidencia("Valido el botón necesito ayuda del home privado");
        utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BOTON_NECESITO_AYUDA);
		utilidadesTcs.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
        
        boolean popUpIngreso = utilidadesTcs.validateElementVisibilityCatch("xpath",LauraVozPageObjects.POP_UP_DOS_ENLACES);
        if (popUpIngreso == true) {
            System.out.println("Me redirijo al gestor de interacciones");
            Utilidades.tomaEvidencia("Cerrar el pop Up presente");
            utilidadesTcs.clicElement("xpath", LauraVozPageObjects.BOTON_CERRAR_PRUEBAS_DOS_ENLACES);
        }
        utilidadesTcs.esperarElementVisibility("xpath", LauraVozPageObjects.TITULO_NECESITA_AYUDA);
        Utilidades.tomaEvidencia("Valido el icono minimizar");
        utilidadesTcs.clicElement("xpath", LauraVozPageObjects.ICONO_MINIMIZAR_PANTALLA_LAURA_VOZ);
        System.out.println("Regreso al home del Daviplata");
        Utilidades.esperaMiliseg(5000);
        Utilidades.tomaEvidencia("Regreso al home del Daviplata");
    }

    @Step
    public void validarElTapMinimizarPresentaLaMismaPantallaQueSeMinimizo() {
        Utilidades.tomaEvidencia("Ingreso nuevamente al botón necesito ayuda");
        utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BOTON_NECESITO_AYUDA);
		utilidadesTcs.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);

        boolean pantallaUno = utilidadesTcs.validateElementVisibilityCatch("xpath", LauraVozPageObjects.PANTALLA_DE_BIENVENIDA_LAURA_VOZ);
        if (pantallaUno == true) {
            Utilidades.tomaEvidencia("Valido que me encuentre en la pantalla de Laura chat después del tap minimizar");
            System.out.println("Me encuentro en la pantalla de bienvenida Laura Chat");
            String mensajePantallaDeBienvenida = utilidadesTcs.obtenerTexto("xpath" , LauraVozPageObjects.TEXTO_TODAS_SUS_CONSULTAS_PANTALLA_BIENVENIDA);
            utilidadesTcs.validateTextContainsString(mensajePantallaDeBienvenida, "Aquí podrá realizar todas sus consultas sobre el producto DaviPlata");
            Utilidades.tomaEvidencia("Validar que la pantalla Bienvenido contenga el siguiente texto 'Aquí podra realizar todas sus consultas sobre el producto Daviplata.'");

        } else {
            Utilidades.tomaEvidencia("Valido que me encuentre en la pantalla del chat de necesito ayuda después del tap minimizar");
            System.out.println("Me encuentro en la pantalla del chat necesita ayuda");
        }
    }
    
    @Step
    public void realizoTapEnElBotonEmpecemosSeVisualiceElMensajePredeterminado() {
        boolean pantallaUno = utilidadesTcs.validateElementVisibilityCatch("xpath", LauraVozPageObjects.PANTALLA_DE_BIENVENIDA_LAURA_VOZ);
        boolean pantallaDos = utilidadesTcs.validateElementVisibilityCatch("xpath", LauraVozPageObjects.TEXTO_CHAT_LAURA);
        if (pantallaUno == true) {
            utilidadesTcs.esperarElementVisibility("xpath", LauraVozPageObjects.PANTALLA_DE_BIENVENIDA_LAURA_VOZ);
            Utilidades.tomaEvidencia("Clic en el botón Empecemos");
            utilidadesTcs.clicElement("xpath", LauraVozPageObjects.BOTON_EMPECEMOS);
            Utilidades.esperaMiliseg(5000);
            String mensajeChatLaura = utilidadesTcs.obtenerTexto("xpath" , LauraVozPageObjects.TEXTO_CHAT_LAURA);
            utilidadesTcs.validateTextContainsString(mensajeChatLaura, "Bienvenido a nuestro canal de Chat DaviPlata. Soy Laura y estaré encargada de atender su consulta. ¿Cómo puedo ayudarle?");
            String horaChat = utilidadesTcs.obtenerTexto("xpath" , LauraVozPageObjects.HORA_CHAT_LAURA);
            utilidadesTcs.validateTextContainsString(horaChat, "-");
        } else if (pantallaDos == true) {
            Utilidades.esperaMiliseg(5000);
            String mensajeChatLaura = utilidadesTcs.obtenerTexto("xpath" , LauraVozPageObjects.TEXTO_CHAT_LAURA);
            utilidadesTcs.validateTextContainsString(mensajeChatLaura, "Bienvenido a nuestro canal de Chat DaviPlata. Soy Laura y estaré encargada de atender su consulta. ¿Cómo puedo ayudarle?");
            String horaChat = utilidadesTcs.obtenerTexto("xpath" , LauraVozPageObjects.HORA_CHAT_LAURA);
            utilidadesTcs.validateTextContainsString(horaChat, ":");
        } else {
            System.out.println("No me encuentro en la pantalla de bienvenida Laura chat");
            fail ("No me encuentro en la pantalla de Laura chat ingrese con una identificación autorizada");
        }
    }
    
    @Step
    public void ingresarCredenciales(String tipoDocumento, String numDocumento) {
        Utilidades.esperaMiliseg(5000);
        Utilidades.tomaEvidencia("Hago clic para seleccionar el tipo de documento");
        utilidadesTcs.seleccionarTipoDocumentoInputHomeDaviplata("xpath",tipoDocumento);
        utilidadesTcs.writeElement("xpath", LoginRobustoPage.CAMPO_INGRESO_USUARIO, numDocumento);
        Utilidades.tomaEvidencia("Ingresar las credenciales para la consulta");
    }
    
    @Step
    public void validarQueLaPantallaContegaElTextoPredeterminado() {
        utilidadesTcs.esperarElementVisibility("xpath", LauraVozPageObjects.TEXTO_BIENVENIDA_LAURA_VOZ);
        boolean elemento = utilidadesTcs.validateElementVisibility("xpath", LauraVozPageObjects.TEXTO_BIENVENIDA_LAURA_VOZ);
        utilidadesTcs.validateStatusElement(elemento);
        Utilidades.tomaEvidencia("Validar que la pantalla contenga el texto 'Renovamos nuestro servicio de ayuda' para que su experiencia al realizar consultas sea la mejor");
    }
    
    public void hacerClicBotonReproducir() {
        Utilidades.tomaEvidencia("Hago clic en el boton reproducir");
        utilidadesTcs.clicElement("xpath", LauraVozPageObjects.BOTON_REPRODUCIR);
    }
    
    public void validarTextosDeLaReproduccionLaura() {
    	
    	//no deja extraer localizador
//        boolean textoHola = utilidadesTcs.validateElementVisibility("xpath", LauraVozPageObjects.TEXTO_HOLA); //no deja extraer localizador
//        utilidadesTcs.validateStatusElement(textoHola);
//        boolean botonOmitirPantallaUno = utilidadesTcs.validateElementVisibility("xpath", LauraVozPageObjects.BOTON_OMITIR); //no deja extraer localizador
//        utilidadesTcs.validateStatusElement(botonOmitirPantallaUno);
        Utilidades.esperaMiliseg(2000);
    	Utilidades.tomaEvidencia("Validar texto Hola, Soy Laura  y botón omitir");

    	//no deja extraer localizador
//        boolean textoSoyLaura = utilidadesTcs.validateElementVisibility("xpath", LauraVozPageObjects.TEXTO_SOY_LAURA); //no deja extraer localizador
//        utilidadesTcs.validateStatusElement(textoSoyLaura);
//        boolean botonOmitirPantallaDos = utilidadesTcs.validateElementVisibility("xpath", LauraVozPageObjects.BOTON_OMITIR); //no deja extraer localizador
//        utilidadesTcs.validateStatusElement(botonOmitirPantallaDos);
//        Utilidades.tomaEvidencia("Validar texto soy Laura y botón omitir");
        
    	//no deja extraer localizador
//        boolean textoConsulteFacilmente = utilidadesTcs.validateElementVisibility("xpath", LauraVozPageObjects.TEXTO_CONSULTE_FACILMENTE); //no deja extraer localizador
//        utilidadesTcs.validateStatusElement(textoConsulteFacilmente);
//        boolean botonOmitirPantallaTres = utilidadesTcs.validateElementVisibility("xpath", LauraVozPageObjects.BOTON_OMITIR); //no deja extraer localizador
//        utilidadesTcs.validateStatusElement(botonOmitirPantallaTres);
//        Utilidades.tomaEvidencia("Validar texto consultar facilmente y botón omitir");
        
    	//no deja extraer localizador
//        boolean textoRevisarVolumen = utilidadesTcs.validateElementVisibility("xpath", LauraVozPageObjects.TEXTO_REVISAR_VOLUMEN); //no deja extraer localizador
//        utilidadesTcs.validateStatusElement(textoRevisarVolumen);
//        boolean botonOmitirPantallaCuatro = utilidadesTcs.validateElementVisibility("xpath", LauraVozPageObjects.BOTON_OMITIR); //no deja extraer localizador
//        utilidadesTcs.validateStatusElement(botonOmitirPantallaCuatro);
        Utilidades.esperaMiliseg(2000);
        Utilidades.tomaEvidencia("Validar texto revisar volumen y botón omitir");
        Utilidades.esperaMiliseg(2000);
        Utilidades.tomaEvidencia("Validar texto 'Conversemos'");
    	utilidadesTcs.clickCoordinates(196, 812);
    }
}
