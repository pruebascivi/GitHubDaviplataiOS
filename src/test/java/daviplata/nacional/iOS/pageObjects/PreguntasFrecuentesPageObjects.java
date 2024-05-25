package daviplata.nacional.iOS.pageObjects;

import net.serenitybdd.core.pages.PageObject;

public class PreguntasFrecuentesPageObjects extends PageObject {
	
	public static final String BOTON_NECESITO_AYUDA = "//XCUIElementTypeOther[contains(@name,'Ir a asesor virtual')]";
	public static final String TEXTO_NECESITO_AYUDA = "//XCUIElementTypeStaticText[contains(@name,'¿Necesita Ayuda?')]";
	public static final String BOTON_DESPLEGAR_TIPO_DOCUMENTO = "//XCUIElementTypeStaticText[@name='Seleccione una opción']";
	public static final String OPCION_TARJETA_IDENTIDAD = "//XCUIElementTypeStaticText[@name='Tarjeta de identidad']";
	public static final String OPCION_CEDULA_CIUDADANIA = "//XCUIElementTypeStaticText[@name='Cédula de ciudadanía']";
	public static final String OPCION_CEDULA_EXTRANJERIA = "//XCUIElementTypeStaticText[@name='Cédula de extranjería']";
	public static final String INPUT_NUMERO_DOCUMENTO = "//*[@value='Ingrese un número de documento']";
	public static final String BOTON_TERMINOS_CONDICIONES = "//XCUIElementTypeOther[@name='FAQ Daviplata']/XCUIElementTypeSwitch";
	public static final String BOTON_CONTINUAR = "//XCUIElementTypeButton[contains(@name,'Continuar')]";
	public static final String INPUT_ESCRIBIR_CONSULTA = "//*[contains(@value,'Escriba aquí su consulta')] | //XCUIElementTypeOther[@name='FAQ Daviplata']/XCUIElementTypeTextField";
	public static final String TECLADO_IOS = "//XCUIElementTypeButton[@name='Done']";
	public static final String LISTA_OBJETOS_BUSQUEDA = "//XCUIElementTypeOther[@name='FAQ Daviplata']/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeOther";
	public static final String OPCION_BUSQUEDA_CONSULTA = "//XCUIElementTypeOther[@name='FAQ Daviplata']/XCUIElementTypeOther[4]/XCUIElementTypeOther[1]";
	public static final String RECUADRO_VIDEO = "//XCUIElementTypeOther[contains(@name,'seconds')]";
	public static final String BOTON_REGRESAR = "(//XCUIElementTypeImage[@name='back'])[2]";
	public static final String BOTON_CERRAR_POP_UP_CALIFICACION = "(//XCUIElementTypeImage[@name='Cerrar'])[1]";
	public static final String BOTON_NUEVA_BUSQUEDA = "//XCUIElementTypeButton[@name='Nueva búsqueda']";
	public static final String BOTON_CHAT_ASESOR = "//XCUIElementTypeButton[@name='Chat con asesor']";
	public static final String BOTON_OLVIDE_CLAVE = "//XCUIElementTypeButton[@name='Olvidé mi clave']";
	public static final String OPCION_SEGUNDA_RESPUESTA = "//XCUIElementTypeOther[@name='FAQ Daviplata']/XCUIElementTypeOther[4]/XCUIElementTypeOther[2]";
	public static final String BOTON_PULGAR_ARRIBA = "//XCUIElementTypeImage[@name='up thumb']";
	public static final String TEXTO_RESULTADO_ENCUESTA = "//XCUIElementTypeStaticText[@name='¡Gracias! Su respuesta nos']";
	public static final String POPUP_JOVENES_ACCION = "//XCUIElementTypeStaticText[contains(@name, 'Para consultar por su pago')]";
	public static final String CERRAR_POPUP_JOVENES_ACCION = "//XCUIElementTypeImage[@name='close']";
	public static final String ESCRIBE_AQUI_CAMPO = "//XCUIElementTypeTextField[contains(@value, 'Escriba aquí su consulta')] | //XCUIElementTypeOther[@name='FAQ Daviplata']/XCUIElementTypeTextField";

}
