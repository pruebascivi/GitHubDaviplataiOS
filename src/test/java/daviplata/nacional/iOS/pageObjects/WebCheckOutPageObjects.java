package daviplata.nacional.iOS.pageObjects;


public class WebCheckOutPageObjects {
	
    public static final String TEXTO_CUANTO_TENGO = "//XCUIElementTypeStaticText[contains(@name, 'Cuánto tengo')] | //XCUIElementTypeStaticText[contains(@label, 'Cuánto tengo')]";
    public static final String BOTON_DE_PAGO = "";
    public static final String ELEMENTO_VISIBLE_BOTON_PAGO = "//XCUIElementTypeStaticText[@name='Botón de pago']";
    public static final String TXT_GENERACION_EXITOSA = "//XCUIElementTypeStaticText[contains(@name, 'Generación exitosa')]";
    public static final String INTERACCION_VIDEO = "//XCUIElementTypeOther[@name='main']/XCUIElementTypeOther[1] | //XCUIElementTypeOther[@name='45 seconds'] | //XCUIElementTypeOther[contains(@label, 'seconds')]";
    public static final String TXT_MODULE_BOTON_PAGO = "//XCUIElementTypeStaticText[@name='Botón de pago']";
    public static final String BTN_GENERAR_BTN_PAGO = "//XCUIElementTypeButton[@name='Botón generar botón de pago']";
    public static final String BOTON_ATRAS = "//XCUIElementTypeOther[@name='Botón atrás'] | //XCUIElementTypeOther[@label='Botón atrás'] | //XCUIElementTypeOther[contains(@name, 'atrás')] | //XCUIElementTypeOther[contains(@label, 'atrás')]";
    public static final String BOTON_EQUIS = "//XCUIElementTypeButton[@name='Botón cerrar'] | //XCUIElementTypeButton[@label='Botón cerrar']";
    public static final String MENSAJE_DEFINIDO = "//XCUIElementTypeStaticText[@name='De esta forma podrán pagarle por sus ventas usando DaviPlata con un solo clic']";
    public static final String TXT_MENSAJE_DEFINIDO = "//XCUIElementTypeOther[@name='main']/XCUIElementTypeOther[3]";
    public static final String URL_BOTON_PAGO = "//XCUIElementTypeStaticText[contains(@value, 'https')]";
    public static final String BOTON_COPIAR_URL = "//XCUIElementTypeStaticText[@name='Copiar']";
    public static final String TEXTO_URL_COPIADA = "//XCUIElementTypeStaticText[@name='Enlace copiado']";
    public static final String BOTON_FINALIZAR = "//XCUIElementTypeButton[@name='Botón finalizar']";
    public static final String ELEMENTOS_PAGO_VENTA = "//XCUIElementTypeStaticText[contains(@name,'Elija una opción para recibir el pago de su venta')]";
    public static final String BOTON_ENLACE_DE_PAGO = "//XCUIElementTypeOther[@name='Botón enlace de pago']";
    public static final String TEXTO_OPCIONES_ENLACE = "//XCUIElementTypeStaticText[contains(@name,'Seleccione una de las siguientes opciones')]";
    public static final String TAP_OPCION_UNO_ENLACE = "//XCUIElementTypeOther[@name='Botón Enlace de pago DaviPlata']";
    public static final String TXT_DATOS_VENTA = "//XCUIElementTypeStaticText[@name='Ingrese los datos de la venta']";
    public static final String INPUT_NOMBRE_PRODUCTO = "//XCUIElementTypeTextField[@value= 'Nombre del producto']";
    public static final String INPUT_VALOR_PRODUCTO = "//XCUIElementTypeTextField[@value= 'Ingrese el valor del producto']";
    public static final String BOTON_CONTINUAR = "//XCUIElementTypeButton[@name='Botón continuar']";
    public static final String BOTON_GENERAR_NUEVO_ENLACE = "//XCUIElementTypeButton[@name='Botón generar enlace']";
    public static final String TEXTO_GENERACION_EXITOSA = "//XCUIElementTypeStaticText[@name='Generación exitosa']";
    public static final String RUTA_URL = "//XCUIElementTypeStaticText[contains(@value, 'https')]";
    public static final String NUEVO_ENLACE_BTN = "//XCUIElementTypeButton[@name='Botón nuevo enlace']";
    
  //WEB ENLACE
    public static final String TEXTO_WEB_ENLACE = "//div[@class='contDate']";
    public static final String INPUT_WEB_NUMERO_DOCUMENTO = "//input[@name='numeroDocumento']";
    public static final String BOTON_CONTINUAR_WEB = "//*[@mbaasdynatraceclick='continuar'] | (//*[@class='button button--primary'])";
    public static final String TEXTO_WEB_CONFIRMACION ="//div[@class='contSubtitle']";
    public static final String ELEMENTO_L_OTP = "(//*[@class='logger-container ng-star-inserted']//child::p[contains(text(),'otp')])[last()]";

}
