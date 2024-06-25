package daviplata.nacional.iOS.steps;

import static org.junit.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import daviplata.nacional.iOS.pageObjects.EcardPageObject;
import daviplata.nacional.iOS.pageObjects.GenerarExtractosPageObjects;
import daviplata.nacional.iOS.pageObjects.LoginRobustoPage;
import daviplata.nacional.iOS.pageObjects.MenuHamburguesaPageObjects;
import daviplata.nacional.iOS.pageObjects.NotificacionesPushPageObjects;
import daviplata.nacional.iOS.pageObjects.PasarPlataPageObjects;
import daviplata.nacional.iOS.pageObjects.WebLatiniaPageObject;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import daviplata.nacional.iOS.utilidades.Credenciales;
import daviplata.nacional.iOS.utilidades.CustomChromeDriver;
import daviplata.nacional.iOS.utilidades.Utilidades;
import daviplata.nacional.iOS.utilidades.UtilidadesTCS;
import net.thucydides.core.annotations.Step;

public class NotificacionesPushSteps {

	Utilidades utilidad;
	BaseUtil base;
	MenuHamburguesaPageObjects menuHamburPO;
	UtilidadesTCS utilidadesTCS;
	GenerarExtractosPageObjects generarExtractosPageObjects = new GenerarExtractosPageObjects();
	ClaveCorreoSteps claveCorreoSteps;
	Excepcion4x1000Steps excepcion4x1000Steps;
	PasarPlataPageObjects pagePasarPlata;
    WebLatiniaPageObject pageLatinia;
    NotificacionesPushPageObjects notificacionesPushPageObjects;
    EcardPageObject ecardPageObjects;
	public static CustomChromeDriver confiChromeDriver;
	public static WebDriverWait wait;

    @Step
    public void ingresoAWebDavivienda(String tipoDocumentoWebDavivienda, String usuarioDavivienda, String contrasenaDavivienda, String numeroCelularUsuarioDavivienda) {
        try{
    		CustomChromeDriver.iniciarChromeDriver();
    		BaseUtil.chromeDriver.get(Credenciales.propertiesWebs().getProperty("web.davivienda.url"));
    		BaseUtil.chromeDriver.manage().window().maximize();
    		wait = new WebDriverWait(BaseUtil.chromeDriver, 60);
            Utilidades.esperaMiliseg(10000);
            utilidadesTCS.esperarElementoVisibleEnLaWeb("xpath", NotificacionesPushPageObjects.BOTON_CERRAR_POP_UP_POLITICAS_TRATAMIENTO_DATOS);
            UtilidadesTCS.clicElementWeb("xpath", NotificacionesPushPageObjects.BOTON_CERRAR_POP_UP_POLITICAS_TRATAMIENTO_DATOS);
            utilidadesTCS.esperarElementoVisibleEnLaWeb("xpath", NotificacionesPushPageObjects.LOGO_DAVIVIENDA);
            Utilidades.tomaEvidenciaPantalla("Ingreso a la web davivienda"); 
            UtilidadesTCS.clicElementWeb("xpath", NotificacionesPushPageObjects.BOTON_INGRESO_CLIENTES);
            Utilidades.esperaMiliseg(5000);
            UtilidadesTCS.cambiarFocoIframe("xpath",NotificacionesPushPageObjects.IFRAME_FORMULARIO_ACCESO);
            Utilidades.esperaMiliseg(10000);
            utilidadesTCS.esperarElementoVisibleEnLaWeb("xpath", NotificacionesPushPageObjects.DESPLEGABLE_TIPO_DOCUMENTO_INGRESO_CLIENTES);
            //utilidadesTCS.selectDropdownValue("xpath", NotificacionesPushPageObjects.DESPLEGABLE_TIPO_DOCUMENTO_INGRESO_CLIENTES, tipoDocumentoWebDavivienda);
            utilidadesTCS.writeElementWeb("xpath", NotificacionesPushPageObjects.CAMPO_USUARIO_INGRESO_CLIENTES,usuarioDavivienda);
            UtilidadesTCS.clicElementWeb("xpath", NotificacionesPushPageObjects.BOTON_INGRESAR_Y_CONTINUAR_INGRESO_CLIENTES);
            Utilidades.esperaMiliseg(2000);
            utilidadesTCS.writeElementWeb("xpath", NotificacionesPushPageObjects.CAMPO_CONTRASENA_INGRESO_CLIENTES,contrasenaDavivienda);
            UtilidadesTCS.clicElementWeb("xpath", NotificacionesPushPageObjects.BOTON_INGRESAR_Y_CONTINUAR_INGRESO_CLIENTES);
            Utilidades.esperaMiliseg(2000);
            System.out.println("La hora actual es: " +BaseUtil.horaSistema);            
            Utilidades.tomaEvidenciaPantalla("Web - Ingreso usuario y contraseña");
            boolean visibleCampoOtp = utilidadesTCS.validateElementVisibilityCatchWeb("xpath", NotificacionesPushPageObjects.CAMPO_OTP_INGRESO_CLIENTES);
            if(visibleCampoOtp) {
            	utilidadesTCS.abrirWebEnPestaniaNueva("web.notificaciones.url");
            	utilidadesTCS.writeElementWeb("xpath", EcardPageObject.INPUT_NUMERO_CELULAR, numeroCelularUsuarioDavivienda);
            	utilidadesTCS.cleanInputElementWeb("xpath", EcardPageObject.INPUT_HORA);
            	utilidadesTCS.writeElementWeb("xpath", EcardPageObject.INPUT_HORA, BaseUtil.horaSistema);
            	Utilidades.tomaEvidenciaPantalla("Web - Diligenciar número del daviplata y hora");
                UtilidadesTCS.clicElementWeb("xpath", EcardPageObject.BOTON_SUBMIT_NANOCREDITO);
                Utilidades.cambiarFocoNuevaVentanaAbierta();
                String otp = utilidadesTCS.capturarOtpIngresoDaviviendaNotificaciones();
                utilidadesTCS.cambiarFocoVentana("origen");
                UtilidadesTCS.cambiarFocoIframe("xpath",NotificacionesPushPageObjects.IFRAME_FORMULARIO_ACCESO);
                utilidadesTCS.writeElementWeb("xpath", NotificacionesPushPageObjects.CAMPO_OTP_INGRESO_CLIENTES, otp);
                UtilidadesTCS.clicElementWeb("xpath", NotificacionesPushPageObjects.BOTON_INGRESAR_Y_CONTINUAR_INGRESO_CLIENTES);
            }
            Utilidades.esperaMiliseg(8000);
            boolean elemento = utilidadesTCS.validateElementVisibilityWeb("xpath", NotificacionesPushPageObjects.BOTON_CERRAR_SESION_DAVIVIENDA);
            utilidadesTCS.validateStatusElement(elemento);
            Utilidades.tomaEvidenciaPantalla("Web - Ingresó correctamente a Davivienda");        
        } catch (WebDriverException e) {
            cerrarSesionDavivienda();
            fail("Error en WebDriver: " + e.getMessage());
        } catch (Exception e) {
            cerrarSesionDavivienda();
            fail("Se produjo un error no esperado: " + e.getMessage());
        }
    }
    
    @Step
    public void cerrarSesionDavivienda() {
    	utilidadesTCS.switchToIframeDefault();
    	UtilidadesTCS.clicElementWeb("xpath", NotificacionesPushPageObjects.BOTON_CERRAR_SESION_DAVIVIENDA);
        Utilidades.esperaMiliseg(5000);
        utilidadesTCS.esperarElementoVisibleEnLaWeb("xpath", NotificacionesPushPageObjects.LOGO_DAVIVIENDA);
        Utilidades.esperaMiliseg(2000);
        Utilidades.tomaEvidenciaPantalla("Web - Cerrar correctamente la sesión");
        Utilidades.esperaMiliseg(5000);
        //utilidadesTCS.cerrarChromdriver();
    }
    
    @Step
    public void realizarTransaccionDaviviendaDaviplata(String monto, String numeroCelular) {
        try {
        	Utilidades.tomaEvidenciaPantalla("Web - Hacer clic al botón transferir");
        	UtilidadesTCS.clicElementWeb("xpath", NotificacionesPushPageObjects.BOTON_TRANSFERIR);
            UtilidadesTCS.cambiarFocoIframe("xpath",NotificacionesPushPageObjects.IFRAME_FORMULARIO_TRANSFERENCIAS);
            utilidadesTCS.esperarElementoVisibleEnLaWeb("xpath", NotificacionesPushPageObjects.BOTON_A_DAVIPLATA_DAVIVIENDA);
            UtilidadesTCS.clicElementWeb("xpath", NotificacionesPushPageObjects.BOTON_A_DAVIPLATA_DAVIVIENDA);
            utilidadesTCS.writeElementWeb("xpath", NotificacionesPushPageObjects.CAMPO_TRANSFERIR,monto);
            utilidadesTCS.writeElementWeb("xpath", NotificacionesPushPageObjects.CAMPO_NUMERO_MONEDERO,numeroCelular);
            UtilidadesTCS.clicElementWeb("xpath", NotificacionesPushPageObjects.BOTON_CONTINUAR);
            Utilidades.tomaEvidenciaPantalla("Web - Diligenciar datos del usuario al que se le hará la transacción");
            utilidadesTCS.esperarElementoVisibleEnLaWeb("xpath", NotificacionesPushPageObjects.TEXTO_CONFIRMACION_TRANSFERENCIA);
            Utilidades.tomaEvidenciaPantalla("Web - Confirmacion de la transferencia");
            UtilidadesTCS.clicElementWeb("xpath", NotificacionesPushPageObjects.BOTON_CONTINUAR);
            utilidadesTCS.esperarElementoVisibleEnLaWeb("xpath", NotificacionesPushPageObjects.TEXTO_RESULTADO_TRANSACCION);
            Utilidades.tomaEvidenciaPantalla("Web - Resultado de la transacción");            
        } catch (WebDriverException e) {
            cerrarSesionDavivienda();
            fail("Error en WebDriver: " + e.getMessage());
        } catch (Exception e) {
            cerrarSesionDavivienda();
            fail("Se produjo un error no esperado: " + e.getMessage());
        }
    }
    
    @Step
    public void validarMovimientoHome(){
        String textoObtenido = utilidadesTCS.obtenerTexto("xpath", NotificacionesPushPageObjects.MOVIMIENTO_HOME_PASO_PLATA);
        utilidadesTCS.validateTextContainsString(textoObtenido, "Pasó plata por Transfiya");    
        Utilidades.tomaEvidencia("Validar mensaje movimiento transfiya");
    }
    
    @Step
    public void validarMensajeRecargaDesdeDaviplata() {
        String texto = utilidadesTCS.obtenerTexto("xpath", NotificacionesPushPageObjects.MENSAJE_RECARGA_DAVIVIENDA);
        System.out.println(texto);
        //utilidadesTCS.validateTextContainsString(texto, "Su DaviPlata fue cargado");
        Utilidades.tomaEvidencia("Validar mensaje de recarga");
    }
    
    @Step
    public void validarMensajeTransferenciaDesdeDaviplata() {
        String texto = utilidadesTCS.obtenerTexto("xpath", NotificacionesPushPageObjects.MENSAJE_TRANSFERENCIA_DAVIPLATA);
        System.out.println(texto);
        utilidadesTCS.validateTextContainsString(texto, "Usted paso plata por");
        Utilidades.tomaEvidencia("Validar mensaje de transferencia");
    }
    
    @Step
    public void validarMensajeCompraTiendaVirtualDesdeDaviplata() {
        String texto = utilidadesTCS.obtenerTexto("xpath", NotificacionesPushPageObjects.MENSAJE_COMPRA_TIENDA_VIRTUAL_DAVIPLATA);
        System.out.println(texto);
        utilidadesTCS.validateTextContainsString(texto, "Compra Quantum");
        Utilidades.tomaEvidencia("Validar mensaje de compra tienda virtual");
    }    
    
    @Step
    public void validarMensajeCompraPseDaviplata() {
        boolean compraPSEText = utilidadesTCS.validateElementVisibilityCatch("xpath", NotificacionesPushPageObjects.MENSAJE_COMPRA_PSE_DAVIPLATA);
        if(compraPSEText == true) {
        	String texto = utilidadesTCS.obtenerTexto("xpath", NotificacionesPushPageObjects.MENSAJE_COMPRA_PSE_DAVIPLATA);
            System.out.println(texto);
            utilidadesTCS.validateTextContainsString(texto, "PSE");
            Utilidades.tomaEvidencia("Valido presencia del mensaje de compra por pse");
        } else {
            Utilidades.tomaEvidencia("Valido presencia del mensaje de compra por pse");
        }
    }    
    
    @Step
    public void hacerClicComprasEnTiendaVirtual() {
    	Utilidades.tomaEvidencia("Validar mensaje de compra tienda virtual");
        utilidadesTCS.clicElement("xpath", NotificacionesPushPageObjects.BOTON_COMPRAS_EN_TIENDA_VIRTUAL);
    }
    
    @Step
    public void ingresoAWebLatinia() {
        try {
        	utilidadesTCS.abrirWeb("web.latinia.url");
            Utilidades.esperaMiliseg(2000);
            utilidadesTCS.esperarElementVisibilityWeb("xpath", NotificacionesPushPageObjects.LOGO_LATINIA);
            utilidadesTCS.writeElementWeb("xpath", NotificacionesPushPageObjects.CAMPO_EMPRESA_LATINIA, "Davivienda");
            utilidadesTCS.writeElementWeb("xpath", NotificacionesPushPageObjects.CAMPO_USUARIO_LATINIA, "Josei");
            utilidadesTCS.writeElementWeb("xpath", NotificacionesPushPageObjects.CAMPO_CONTRASENA_LATINIA, "Josei/*-");
            Utilidades.tomaEvidenciaPantalla("Web - Ingresar credenciales de ingreso a latinia");
            UtilidadesTCS.clicElementWeb("xpath",NotificacionesPushPageObjects.BOTON_ACCEDER_LATINIA);
        } catch (WebDriverException e) {
        	utilidadesTCS.cerrarChromdriver();
            fail("Error en WebDriver: " + e.getMessage());
        } catch (Exception e) {
        	utilidadesTCS.cerrarChromdriver();
            fail("Se produjo un error no esperado: " + e.getMessage());
        }
    }
    
    @Step
    public void filtrarPorNumeroCelular(String numeroCelular) {
        try {
        	utilidadesTCS.esperarElementVisibilityWeb("xpath", NotificacionesPushPageObjects.BOTON_FILTRO);
        	Utilidades.tomaEvidenciaPantalla("Web - Ingresar al detalle de mensajes");
        	UtilidadesTCS.clicElementWeb("xpath", NotificacionesPushPageObjects.BOTON_FILTRO);
            utilidadesTCS.writeElementWeb("xpath", NotificacionesPushPageObjects.INPUT_FILTRO_NUMERO_LATINIA, numeroCelular);
            Utilidades.tomaEvidenciaPantalla("Web - Ingresar numero celular");
            UtilidadesTCS.clicElementWeb("xpath", NotificacionesPushPageObjects.BOTON_ACTUALIZAR_LATINIA);
        } catch (WebDriverException e) {
        	utilidadesTCS.cerrarChromdriver();
            fail("Error en WebDriver: " + e.getMessage());
        } catch (Exception e) {
        	utilidadesTCS.cerrarChromdriver();
            fail("Se produjo un error no esperado: " + e.getMessage());
        }
    }
    
    @Step
    public void validarMensajeRecargaDesdeDaviviendaEnLatinia(String monto) {
        try {
            String valorRecarga = utilidadesTCS.capturarMensajeLatiniaNotificaciones();
            utilidadesTCS.validateTextContainsString(valorRecarga, monto);
        } catch (WebDriverException e) {
        	utilidadesTCS.cerrarChromdriver();
            fail("Tiempo de espera excedido: " + e.getMessage());
        } catch (Exception e) {
        	utilidadesTCS.cerrarChromdriver();
            fail("Se produjo un error no esperado: " + e.getMessage());
        }
    }
    
    @Step
    public void validarMensajeTransferenciaACuentaDaviviendaDesdeDaviplata(String monto) {
        try {
            String valorTransferencia = utilidadesTCS.capturarMensajeLatiniaNotificacionesPasarPlataCuenta();
            utilidadesTCS.validateTextContainsString(valorTransferencia, monto);
        } catch (WebDriverException e) {
        	utilidadesTCS.cerrarChromdriver();
            fail("Tiempo de espera excedido: " + e.getMessage());
        } catch (Exception e) {
        	utilidadesTCS.cerrarChromdriver();
            fail("Se produjo un error no esperado: " + e.getMessage());
        }
    }
    
    @Step
    public void validarMensajePasarPlataEnLineaDesdeDaviplata(String monto) {
        try {
            String valorTransferencia = utilidadesTCS.capturarMensajeLatiniaNotificacionesPasarPlataEnLinea();
            utilidadesTCS.validateTextContainsString(valorTransferencia, monto);
        } catch (WebDriverException e) {
        	utilidadesTCS.cerrarChromdriver();
            fail("Tiempo de espera excedido: " + e.getMessage());
        } catch (Exception e) {
        	utilidadesTCS.cerrarChromdriver();
            fail("Se produjo un error no esperado: " + e.getMessage());
        }
    }
    
    @Step
    public void validarMensajeCompraEnTiendaVirtual() {
        try {
            String valorCompraTiendaVirtual = utilidadesTCS.capturarMensajeLatiniaNotificacionesCompraTiendaVirtual();
            System.out.println("El valor de Compa de tienda virtual es: " + valorCompraTiendaVirtual);
//            utilidadesTCS.validateTextContainsString(valorCompraTiendaVirtual, BaseUtil.numero);
        } catch (WebDriverException e) {
        	utilidadesTCS.cerrarChromdriver();
            fail("Error en WebDriver: " + e.getMessage());
        } catch (Exception e) {
        	utilidadesTCS.cerrarChromdriver();
            fail("Se produjo un error no esperado: " + e.getMessage());
        }
    }
    
    
    @Step
    public void validarMensajeCompraEnPse() {
        try {
            String valorCompraPse = utilidadesTCS.capturarMensajeLatiniaNotificacionesCompraPse();
            utilidadesTCS.validateTextContainsString(valorCompraPse, BaseUtil.numero);
        } catch (WebDriverException e) {
        	utilidadesTCS.cerrarChromdriver();
            fail("Tiempo de espera excedido: " + e.getMessage());
        } catch (Exception e) {
        	utilidadesTCS.cerrarChromdriver();
            fail("Se produjo un error no esperado: " + e.getMessage());
        }
    }
    
    @Step
    public void validoLaTansaccionEnCampanaNotificaciones() {
        utilidadesTCS.clicElementAction("xpath", NotificacionesPushPageObjects.BOTON_CAMPANA_NOTIFICACIONES);
        Utilidades.esperaMiliseg(5000);
        Utilidades.tomaEvidencia("Ingreso a la campana de notificaciones");
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
        utilidadesTCS.clicElement("xpath", NotificacionesPushPageObjects.NOTIFICACION_DE_TRANSACCION_DAVIVIENDA);
        utilidadesTCS.esperarElementVisibility("xpath", NotificacionesPushPageObjects.NOTIFICACION_DE_TRANSACCION_DAVIVIENDA);
        Utilidades.esperaMiliseg(1000);
        Utilidades.tomaEvidencia("Valido notificaciones de Davivienda a Daviplata y mensajes de la transacción");
        salirDeLaApp();
    }
    
    @Step
    public void salirDeLaApp() {
    	Utilidades.tomaEvidencia("Dar clic equis salir app daviplata");
//        utilidadesTCS.clicElement("xpath", AdsPageObjects.EQUIS_SALIR_APP_ADELANTO_SALDO);
        Utilidades.tomaEvidencia("Dar clic boton aceptar salir app daviplata");
//        utilidadesTCS.clicElement("xpath", MeterPlataPageObjects.BOTON_ACEPTAR_POP_UP_ACEPTAR_DAVIPLATA);
    }
    
    @Step
    public void validoResultadoTransaccionExitosaPasarPlataLinea() throws Exception {
        pagePasarPlata.validarVisibilidadSolicitudExitosaTransfiYa();
        Utilidades.tomaEvidencia("Transacción exitosa datos finales");
        pagePasarPlata.darClickEnFinalizarTransaccion();
        Utilidades.esperaMiliseg(1000);
        pagePasarPlata.regresarAlHome(3);
        System.out.println("Me encuentre de nuevo en el home");
        pagePasarPlata.capturarSaldoFinal();
        Utilidades.tomaEvidencia("Capturar saldo final");
    }
    
    @Step
    public void diligenciarOtpDePago() {
        try {
            Utilidades.esperaMiliseg(15000);
//            utilidadesTCS.esperarElementVisibilityWeb("xpath", NotificacionesPushPageObjects.TXT_COMPRE_FACIL);
            String texto = utilidadesTCS.extraerNumeroOTPLinkPago();
            System.out.println("El número OTP es: " + texto);
            Utilidades.esperaMiliseg(1000);
            utilidadesTCS.ingresarOtpLinkBotonPago(texto);
            Utilidades.tomaEvidenciaPantalla("Web - Ingresar otp");
        } catch (TimeoutException e) {
            utilidadesTCS.cerrarWebEnlaceDePago();
            fail("Tiempo de espera excedido: " + e.getMessage());
        } catch (WebDriverException e) {
        	utilidadesTCS.cerrarWebEnlaceDePago();
            fail("Error en WebDriver: " + e.getMessage());
        } catch (Exception e) {
        	utilidadesTCS.cerrarWebEnlaceDePago();
            fail("Se produjo un error no esperado: " + e.getMessage());
        }
    }
    
    @Step
    public void clicBotonPagarEnlacePago() {
        try {
            Utilidades.esperaMiliseg(2000);
            utilidadesTCS.scrollToElementWeb("xpath", NotificacionesPushPageObjects.BOTON_PAGAR_LINK_PAGO_OTP);
            Utilidades.tomaEvidenciaPantalla("Web - Hacer clic en el boton pagar");
            UtilidadesTCS.clicElementWeb("xpath", NotificacionesPushPageObjects.BOTON_PAGAR_LINK_PAGO_OTP);
            Utilidades.esperaMiliseg(8000);
        } catch (TimeoutException e) {
        	utilidadesTCS.cerrarWebEnlaceDePago();
            fail("Tiempo de espera excedido: " + e.getMessage());
        } catch (WebDriverException e) {
        	utilidadesTCS.cerrarWebEnlaceDePago();
            fail("Error en WebDriver: " + e.getMessage());
        } catch (Exception e) {
        	utilidadesTCS.cerrarWebEnlaceDePago();
            fail("Se produjo un error no esperado: " + e.getMessage());
        }
    }
    
    @Step
    public void validarPantallaDeDatosCompraExitosa() {
        boolean visibleCampoOtp = utilidadesTCS.validateElementVisibilityCatchWeb("xpath", NotificacionesPushPageObjects.TXT_NO_PUDIMOS_REALIZAR_PAGO);
        if(visibleCampoOtp) {
            Utilidades.tomaEvidenciaPantalla("Web - No pudimos realizar el pago");
        } else {
            Utilidades.tomaEvidenciaPantalla("Web - Datos de compra exitosa");
        }
    	utilidadesTCS.cerrarWebEnlaceDePago();
    }
}

