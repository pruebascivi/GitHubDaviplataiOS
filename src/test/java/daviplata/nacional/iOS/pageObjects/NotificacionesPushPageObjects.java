package daviplata.nacional.iOS.pageObjects;

public class NotificacionesPushPageObjects {

	//Davivienda Web transaccion Davivienda a Daviplata
    public static final String BOTON_TRANSFERIR = "//a[@title='Transferir']";
    public static final String BOTON_DAVIPLATA_DAVIVIENDA = "(//td[@width='7.5%'])[last()]/following-sibling::td";
    public static final String INPUT_VALOR_TRANSFERIR = "//input[@name='valorTransferir']";
    public static final String LISTA_DESPLEGABLE = "(//span[@class='bordeSelect'])[2] | //select[@name='monederoDestino']";
    public static final String OPCION_OTRO_DAVIPLATA = "//option[@value=\"-1\"] |  //option[contains(text(),'Otro DaviPlata')]";
    public static final String BOTON_CAMPANA_NOTIFICACIONES = "//XCUIElementTypeOther[@name='btn-rigth-0'] | //XCUIElementTypeOther[@label= 'Notificaciones botón']";
    public static final String NOTIFICACION_DE_TRANSACCION_DAVIVIENDA = "//XCUIElementTypeStaticText[@name='Transacciones']";
    public static final String MENSAJE_DE_NOTIFICACION = "Su DaviPlata fue cargado desde una cuenta Davivienda con $";
    public static final String BOTON_FILTRO = "//button[@id='msg-details-filter']";
    
    public static final String TXT_COMPRE_FACIL = "//h1[contains(text(), 'Compre fácil con DaviPlata')] | //h4[contains(text(), 'Confirmación de pago')]";
    public static final String DESPLEGABLE_L_OTP = "//div[@class='rectangulo rotar']";
    public static final String BOTON_PAGAR_LINK_PAGO_OTP = "//mbaas-button-continue[@mbaasdynatraceclick='btnPagar']";
    public static final String LOGO_DAVIVIENDA = "//a[@id='personas-volver-head']";
    public static final String BOTON_INGRESO_CLIENTES = "//a[@id='personas-ingresar']";
    public static final String DESPLEGABLE_TIPO_DOCUMENTO_INGRESO_CLIENTES = "//select[@id='formAutenticar:selectedTipoDocCod'] | //*[@id='formAutenticar:selectedTipoDocCod']";
    public static final String OPCION_TIPO_DOCUMENTO_CEDULA_CIUDADANIA = "//option[@text='Cedula de Ciudadania']";
    public static final String OPCION_TIPO_DOCUMENTO_TARJETA_IDENTIDAD = "//option[@text='Tarjeta de Identidad']";
    public static final String OPCION_TIPO_DOCUMENTO_CEDULA_EXTRANJERIA = "//option[@text='Cedula de Extranjeria']";
    public static final String CAMPO_USUARIO_INGRESO_CLIENTES = "//input[@id='formAutenticar:numeroDocumento']";
    public static final String CAMPO_CONTRASENA_INGRESO_CLIENTES = "//input[@id='formAutenticar:claveVirtualMask']";
    public static final String CAMPO_OTP_INGRESO_CLIENTES = "//input[@id='formAutenticar:otpMask']";
    public static final String TXT_NO_PUDIMOS_REALIZAR_PAGO = "//h4[contains(text(), 'No pudimos realizar su pago')]";
    public static final String BOTON_INGRESAR_Y_CONTINUAR_INGRESO_CLIENTES = "//input[@id='formAutenticar:btnSubmitContHidden']";
    public static final String IFRAME_FORMULARIO_ACCESO = "//iframe[contains(@src, 'https://transacciones.davivienda.com/transaccional/personas/nuevo/login.jsf')]";
    public static final String BOTON_CERRAR_POP_UP_POLITICAS_TRATAMIENTO_DATOS = "//button[@class='swal2-close']";
    public static final String BOTON_CERRAR_SESION_DAVIVIENDA = "//a[@id='dashboardform:cerrarSesion']";
    public static final String BOTON_A_DAVIPLATA_DAVIVIENDA = "//a[contains(text(),'A DaviPlata Davivienda')]";
    public static final String CAMPO_TRANSFERIR = "//input[@name='valorTransferir']";
    public static final String CAMPO_NUMERO_MONEDERO = "//input[@name='numeroMonedero']";
    public static final String BOTON_CONTINUAR = "//input[contains(@class, 'boton') and contains(@value, 'Continuar')]";
    public static final String TEXTO_CONFIRMACION_TRANSFERENCIA = "//p[contains(text(),'Confirmación de transferencia')]";
    public static final String TEXTO_RESULTADO_TRANSACCION = "//p[contains(text(),'Resultado de la Transacción')]";
    public static final String IFRAME_FORMULARIO_TRANSFERENCIAS = "//iframe[contains(@src, 'DashboardGlassfishServlet?page=dashboard.pages.resumen&button=Transferir')]";
    public static final String MOVIMIENTO_HOME_PASO_PLATA = "//XCUIElementTypeStaticText[contains(@value, 'por Transfiya')] | //XCUIElementTypeStaticText[contains(@name, 'por Transfiya')]";
    public static final String MENSAJE_RECARGA_DAVIVIENDA = "//XCUIElementTypeStaticText[contains(@value, 'Su DaviPlata fue cargado')] | //XCUIElementTypeStaticText[contains(@name, 'Usted paso plata por')]"; 
    public static final String LOGO_LATINIA = "//img[@src='assets/img/new-logo-text.png']";
    public static final String CAMPO_EMPRESA_LATINIA = "//input[@id='mat-input-0']";
    public static final String CAMPO_USUARIO_LATINIA = "//input[@id='mat-input-1']";
    public static final String CAMPO_CONTRASENA_LATINIA = "//input[@id='mat-input-2']";
    public static final String BOTON_ACCEDER_LATINIA = "//button[span[text()='ACCEDER']]";
    public static final String INPUT_FILTRO_NUMERO_LATINIA = "//input[@id='search-bar-input']";
    public static final String BOTON_ACTUALIZAR_LATINIA = "//button[@id='em-monitor-refresh-button']";
    public static final String MENSAJE_TRANSFERENCIA_DAVIPLATA = "//XCUIElementTypeStaticText[contains(@name, 'Usted paso plata por')]"; 
    public static final String MENSAJE_COMPRA_TIENDA_VIRTUAL_DAVIPLATA = "//XCUIElementTypeStaticText[contains(@name, 'Compra Quantum')]"; 
    public static final String BOTON_COMPRAS_EN_TIENDA_VIRTUAL = "//XCUIElementTypeStaticText[@name='Compras en Tienda Virtual']";
    public static final String MENSAJE_COMPRA_PSE_DAVIPLATA = "//XCUIElementTypeStaticText[contains(@name, 'PSE')] | //XCUIElementTypeStaticText[contains(@name, 'Pse')]"; 
    
    
}