package daviplata.nacional.iOS.pageObjects;

import net.serenitybdd.core.pages.PageObject;

public class LoginRobustoPage extends PageObject {
	
	public static final String MENU_TRES_PUNTOS = "//XCUIElementTypeButton[@name='Menu de conocimiento']";
	public static final String ACERCA_DE_DAVIPLATA = "//XCUIElementTypeStaticText[@name='Acerca de DaviPlata'] | //XCUIElementTypeStaticText[@name='Acerca de Daviplata']";
	public static final String CAMBIAR_MI_NUMERO_BTN = "//XCUIElementTypeStaticText[contains(@name, 'Cambiar mi número')] | //XCUIElementTypeStaticText[contains(@name, 'Cambiar mi numero')]";
	public static final String CAMBIO_NUMERO_MODULO = "//XCUIElementTypeStaticText[@name='Cambio de número']";
	public static final String DONDE_USAR_DAVIPLATA_BTN = "//XCUIElementTypeStaticText[@name='¿Dónde usar su DaviPlata?']";
	public static final String DONDE_USAR_DAVIPLATA_MODULO = "//XCUIElementTypeStaticText[@name='Dónde usar DaviPlata']";
	public static final String DESACTIVAR_HUELLA_FACEID_BTN = "//XCUIElementTypeStaticText[@name='Desactivar huella/Face ID']";
	public static final String DESACTIVAR_HUELLA_FACEID_POPUP = "//XCUIElementTypeTextView[contains(@value, 'desea deshabilitar')]";
	public static final String CANCELAR_POPUP_DESACTIVAR_HUELLA = "//XCUIElementTypeButton[@name='Cancelar Botón']";
	public static final String DESHABILITAR_POPUP_DESACTIVAR_HUELLA = "//XCUIElementTypeButton[@name='Deshabilitar Botón']";
	public static final String POPUP_CONFIRMACIÓN_HUELLA_FACEID_DESHABILITADA = "//XCUIElementTypeStaticText[contains(@value, 'El ingreso a DaviPlata con Face ID  fue deshabilitado')]";
	public static final String REGRESAR = "//XCUIElementTypeButton[contains(@name, 'Botón atrás')] | //XCUIElementTypeButton[contains(@name, 'Regresar')]";
	public static final String BTN_INGRESAR = "//XCUIElementTypeButton[@name='Ingresar']";
	public static final String POPUP_PARA_INGRESAR = "//XCUIElementTypeTextView[contains(@value, 'Para ingresar a su DaviPlata desde este celular')] | //XCUIElementTypeTextView[contains(@value, '¡Hola!')]";
	public static final String TXT_ESCRIBE_CORREO_Y_CLAVE = "//XCUIElementTypeStaticText[contains(@name,'Escriba su correo electrónico')]";
	public static final String PARA_INGRESAR_BTN = "//XCUIElementTypeButton[@name='Continuar - Botón']";
	public static final String PROGRESS_BAR = "//XCUIElementTypeActivityIndicator[@name='In progress'] | //*[contains(@name,'In progress')] | //XCUIElementTypeImage[@name='loader'] | //XCUIElementTypeActivityIndicator[contains(@name, 'In progress')]";
	public static final String POP_UP_CAMBIAR_DISPOSITIVO = "//XCUIElementTypeTextView[contains(@value,'Para ingresar a su DaviPlata')]";
	public static final String CONTINUAR_POP_UP_CAMBIAR_DISPOSITIVO = "//XCUIElementTypeButton[contains(@name,'Continuar')] | (//XCUIElementTypeButton[@name='Continuar'])[2]";
	public static final String POP_UP_REGLAMENTO_CAMBIO_DISPOSITIVO = "//XCUIElementTypeStaticText[contains(@name,'Al oprimir Continuar, usted acepta')]";
	public static final String INPUT_CORREO_ELECTRONICO = "//XCUIElementTypeTextField[@name='Editar casilla correo electrónico']";
	public static final String INPUT_CLAVE_DAVIPLATA = "//XCUIElementTypeSecureTextField[@name='Editar casilla clave DaviPlata']";
	public static final String INPUT_PASS= "//XCUIElementTypeButton[@name='¿Olvidó su clave? ']/preceding-sibling::XCUIElementTypeOther[1]";
	public static final String POP_UP_OTP = "//XCUIElementTypeStaticText[contains(@name,'Le hemos enviado un código')]";
	public static final String INPUT_OTP = "//XCUIElementTypeSecureTextField[contains(@name,'Editar casilla número')]";
	public static final String SLIDE_INFORMATIVO_DAVIPLATA = "//XCUIElementTypeStaticText[contains(@name,'Conozca todo lo que')]";
	public static final String BOTON_BOLSILLOS = "//XCUIElementTypeStaticText[@value='Mis bolsillos']";
	public static final String BOTON_NOTIFICACIONES = "//*[@name='Menu de conocimiento']";
	public static final String TEXTO_TYT_BIOMETRIA = "//XCUIElementTypeStaticText[contains(@name,'Autorizaciones')]";
	public static final String CAMPO_NUMERO_DOCUMENTO = "//XCUIElementTypeTextField[contains(@name,'Ingrese su número de documento') or contains(@name,'Numero de documento')]";
	public static final String TIPO_DOCUMENTO = "//XCUIElementTypeButton[@name='Lista Desplegable']";
	public static final String POPUP_UBICACION = "//XCUIElementTypeButton[@name='Permitir al usar la app']";
	public static final String FIELD_TYPE_ID =  "//XCUIElementTypeButton[@name='Lista Desplegable'] | //XCUIElementTypeButton[@name='Lista desplegable - Tipo de documento'] | //XCUIElementTypeImage[@name='Icono_row_down']";
	public static final String ELEMENT_CC_TYPE_ID = "//*[@name = 'Selección Cédula de Ciudadanía'] | //XCUIElementTypeStaticText[@name='Cédula de Ciudadanía']";
	public static final String ELEMENT_TI_TYPE_ID = "//*[@name = 'Selección Tarjeta de Identidad'] | (//XCUIElementTypeStaticText[@name='Tarjeta de Identidad'])[last()]";
	public static final String ELEMENT_CE_TYPE_ID = "//*[@name = 'Selección Cédula de Extranjería'] | //XCUIElementTypeStaticText[@name='Cédula de Extranjería']";
	public static final String BOTON_BIENVENIDA_REGISTRARME= "//XCUIElementTypeButton[@name='Registrarme botón']";
	public static final String TEXTO_REGISTRARME_EN_DAVIPLATA = "//XCUIElementTypeStaticText[@name='Registrarme en DaviPlata']";
	public static final String CAMPO_NUMERO_DOCUMENTO_REGISTRO = "//XCUIElementTypeTextField[@name='Editar Numero de documento - campo habilitado']";
	public static final String CAMPO_INGRESO_USUARIO = "//XCUIElementTypeTextField[contains(@name, 'Ingrese su número de documento')] | //XCUIElementTypeTextField[contains(@name, 'Editar Numero de documento')]";
	public static final String BOTON_INGRESAR = "//XCUIElementTypeButton[@name='Ingresar']";
	public static final String BOTON_CONTINUAR = "//XCUIElementTypeStaticText[@name='Continuar']";
	public static final String TXT_CODIGO_6_DIGITOS = "//XCUIElementTypeStaticText[contains(@name, 'Le hemos enviado un código de 6 dígitos')]";
	public static final String POPUP_CLAVE_INCORRECTA = "//XCUIElementTypeTextView[contains(@value, 'es incorrecta')]";
	public static final String BOTON_ACEPTAR_TECLADO_IOS = "//XCUIElementTypeButton[contains(@name,'Aceptar')]";
	public static final String POP_UP_INVITE_AMIGOS = "//XCUIElementTypeStaticText[contains(@name,'Invite a sus amigos')]";
	public static final String BOTON_CLOSE = "//XCUIElementTypeButton[@name='Close'] | //XCUIElementTypeButton[@name='Aceptar'] | //XCUIElementTypeButton[@name='Imagen cerrar']";
	public static final String IN_PROGRESS_INDICATOR = "//XCUIElementTypeActivityIndicator[@name='In progress']";
	public static final String POPUP_APROVECHA_BENEFICIOS = "//XCUIElementTypeStaticText[contains(@name, 'Aproveche los beneficios')] | //XCUIElementTypeStaticText[contains(@name, 'Compre por internet y en datáfonos')]";
	public static final String BTN_LO_VERÉ_LUEGO_POPUP = "//XCUIElementTypeButton[@name='Lo veré luego']";
}
